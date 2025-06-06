package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.*;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.BeanUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import com.alibaba.fastjson2.writer.ObjectWriter;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

import static com.alibaba.fastjson2.util.JDKUtils.UNSAFE;

public class FieldReaderObject<T>
        extends FieldReader<T> {
    protected ObjectReader initReader;
    protected final BiConsumer function;

    public FieldReaderObject(
            String fieldName,
            Type fieldType,
            Class fieldClass,
            int ordinal,
            long features,
            String format,
            Locale locale,
            Object defaultValue,
            JSONSchema schema,
            Method method,
            Field field,
            BiConsumer function
    ) {
        super(fieldName, fieldType, fieldClass, ordinal, features, format, locale, defaultValue, schema, method, field);
        this.function = function;
    }

    @Override
    public ObjectReader getInitReader() {
        return initReader;
    }

    @Override
    public ObjectReader getObjectReader(JSONReader jsonReader) {
        if (initReader != null) {
            return initReader;
        }

        if (reader != null) {
            return reader;
        }

        ObjectReader formattedObjectReader = createFormattedObjectReader(fieldType, fieldClass, format, locale);
        if (formattedObjectReader != null) {
            return reader = formattedObjectReader;
        }

        if (fieldClass != null && Map.class.isAssignableFrom(fieldClass)) {
            return reader = ObjectReaderImplMap.of(fieldType, fieldClass, features);
        } else if (fieldClass != null && Collection.class.isAssignableFrom(fieldClass)) {
            return reader = ObjectReaderImplList.of(fieldType, fieldClass, features);
        }

        return reader = jsonReader.getObjectReader(fieldType);
    }

    public ObjectReader getObjectReader(JSONReader.Context context) {
        if (reader != null) {
            return reader;
        }

        ObjectReader formattedObjectReader = createFormattedObjectReader(fieldType, fieldClass, format, locale);
        if (formattedObjectReader != null) {
            return reader = formattedObjectReader;
        }

        if (Map.class.isAssignableFrom(fieldClass)) {
            return reader = ObjectReaderImplMap.of(fieldType, fieldClass, features);
        } else if (Collection.class.isAssignableFrom(fieldClass)) {
            return reader = ObjectReaderImplList.of(fieldType, fieldClass, features);
        }

        return reader = context.getObjectReader(fieldType);
    }

    @Override
    public void readFieldValue(JSONReader jsonReader, T object) {
        if (!fieldClassSerializable) {
            long contextFeatures = jsonReader.getContext().getFeatures();
            if ((contextFeatures & JSONReader.Feature.IgnoreNoneSerializable.mask) != 0) {
                jsonReader.skipValue();
                return;
            } else if ((contextFeatures & JSONReader.Feature.ErrorOnNoneSerializable.mask) != 0) {
                throw new JSONException("not support none-Serializable");
            }
        }

        ObjectReader objectReader;
        if (this.initReader != null) {
            objectReader = this.initReader;
        } else {
            ObjectReader formattedObjectReader = createFormattedObjectReader(fieldType, fieldClass, format, locale);
            if (formattedObjectReader != null) {
                objectReader = this.initReader = formattedObjectReader;
            } else {
                objectReader = this.initReader = jsonReader.getContext().getObjectReader(fieldType);
            }
        }

        if (jsonReader.isReference()) {
            String reference = jsonReader.readReference();
            if ("..".equals(reference)) {
                accept(object, object);
            } else {
                addResolveTask(jsonReader, object, reference);
            }
            return;
        }

        Object value;
        try {
            if (jsonReader.nextIfNullOrEmptyString()) {
                if (defaultValue != null) {
                    value = defaultValue;
                } else if (fieldClass == OptionalInt.class) {
                    value = OptionalInt.empty();
                } else if (fieldClass == OptionalLong.class) {
                    value = OptionalLong.empty();
                } else if (fieldClass == OptionalDouble.class) {
                    value = OptionalDouble.empty();
                } else if (fieldClass == Optional.class) {
                    value = Optional.empty();
                } else {
                    value = null;
                }
            } else if (jsonReader.jsonb) {
                if (fieldClass == Object.class) {
                    ObjectReader autoTypeObjectReader = jsonReader.checkAutoType(Object.class, 0, features);
                    if (autoTypeObjectReader != null) {
                        value = autoTypeObjectReader.readJSONBObject(jsonReader, fieldType, fieldName, features);
                    } else {
                        value = jsonReader.readAny();
                    }
                } else {
                    value = objectReader.readJSONBObject(jsonReader, fieldType, fieldName, features);
                }
            } else {
                value = objectReader.readObject(jsonReader, fieldType, fieldName, features);
            }
        } catch (JSONSchemaValidException ex) {
            throw ex;
        } catch (Exception | IllegalAccessError ex) {
            if ((features & JSONReader.Feature.NullOnError.mask) == 0) {
                Member member = this.field != null ? this.field : this.method;
                String message;
                if (member != null) {
                    message = "read field '" + member.getDeclaringClass().getName() + "." + member.getName();
                } else {
                    message = "read field " + fieldName + " error";
                }
                throw new JSONException(jsonReader.info(message), ex);
            }
            value = null;
        }

        accept(object, value);

        if (noneStaticMemberClass && value != null) {
            BeanUtils.setNoneStaticMemberClassParent(value, object);
        }
    }

    @Override
    public void readFieldValueJSONB(JSONReader jsonReader, T object) {
        if (!fieldClassSerializable && jsonReader.getType() != JSONB.Constants.BC_TYPED_ANY) {
            long contextFeatures = jsonReader.getContext().getFeatures();
            if ((contextFeatures & JSONReader.Feature.IgnoreNoneSerializable.mask) != 0) {
                jsonReader.skipValue();
                return;
            } else if ((contextFeatures & JSONReader.Feature.ErrorOnNoneSerializable.mask) != 0) {
                if (fieldClass != Object.class || (jsonReader.isObject() || jsonReader.getType() == JSONB.Constants.BC_TYPED_ANY)) {
                    throw new JSONException("not support none-Serializable");
                }
            }
        }

        if (initReader == null) {
            initReader = jsonReader.getContext().getObjectReader(fieldType);
        }

        if (jsonReader.isReference()) {
            String reference = jsonReader.readReference();
            if ("..".equals(reference)) {
                accept(object, object);
            } else {
                addResolveTask(jsonReader, object, reference);
            }
            return;
        }

        Object value = initReader.readJSONBObject(jsonReader, fieldType, fieldName, features);
        if (value == null
                && (jsonReader.features(this.features) & JSONReader.Feature.ErrorOnNullForPrimitives.mask) != 0
                && fieldClass.isPrimitive()
        ) {
            throw new JSONException(jsonReader.info("primitive value not support input null"));
        }
        accept(object, value);
    }

    @Override
    public void accept(T object, boolean value) {
        accept(object, Boolean.valueOf(value));
    }

    @Override
    public void accept(T object, byte value) {
        accept(object, Byte.valueOf(value));
    }

    @Override
    public void accept(T object, short value) {
        accept(object, Short.valueOf(value));
    }

    @Override
    public void accept(T object, int value) {
        accept(object, Integer.valueOf(value));
    }

    @Override
    public void accept(T object, long value) {
        accept(object, Long.valueOf(value));
    }

    @Override
    public void accept(T object, float value) {
        accept(object, Float.valueOf(value));
    }

    @Override
    public void accept(T object, double value) {
        accept(object, Double.valueOf(value));
    }

    @Override
    public void accept(T object, char value) {
        accept(object, Character.valueOf(value));
    }

    @Override
    public void accept(T object, Object value) {
        if (schema != null) {
            schema.assertValidate(value);
        }

        if (value == null && (features & JSONReader.Feature.IgnoreSetNullValue.mask) != 0) {
            return;
        }

        if (fieldClass == char.class) {
            if (value instanceof String) {
                String str = (String) value;
                if (str.length() > 0) {
                    value = str.charAt(0);
                } else {
                    value = '\0';
                }
            }
        }

        if (value != null && !fieldClass.isInstance(value)) {
            value = TypeUtils.cast(value, fieldType);
        }

        try {
            if (function != null) {
                function.accept(object, value);
            } else if (method != null) {
                method.invoke(object, value);
            } else {
                UNSAFE.putObject(object, fieldOffset, value);
            }
        } catch (Exception e) {
            throw new JSONException("set " + (function != null ? super.toString() : fieldName) + " error", e);
        }
    }

    @Override
    public Object readFieldValue(JSONReader jsonReader) {
        if (initReader == null) {
            initReader = getObjectReader(jsonReader);
        }

        Object object = jsonReader.jsonb
                ? initReader.readJSONBObject(jsonReader, fieldType, fieldName, features)
                : initReader.readObject(jsonReader, fieldType, fieldName, features);

        Function builder = initReader.getBuildFunction();
        if (builder != null) {
            object = builder.apply(object);
        }

        return object;
    }

    public void processExtra(JSONReader jsonReader, Object object) {
        if (initReader == null) {
            initReader = getObjectReader(jsonReader);
        }

        if (initReader instanceof ObjectReaderBean && field != null) {
            String name = jsonReader.getFieldName();
            FieldReader extraField = initReader.getFieldReader(name);
            if (extraField != null) {
                try {
                    Object unwrappedFieldValue = field.get(object);
                    if (unwrappedFieldValue == null) {
                        unwrappedFieldValue = initReader.createInstance(features);
                        accept((T) object, unwrappedFieldValue);
                    }
                    extraField.readFieldValue(jsonReader, unwrappedFieldValue);
                    return;
                } catch (Exception e) {
                    throw new JSONException("read unwrapped field error", e);
                }
            }
        }

        jsonReader.skipValue();
    }

    @Override
    public BiConsumer getFunction() {
        return function;
    }

    static void arrayToMap(
            Map object,
            Collection values,
            String keyName,
            PropertyNamingStrategy namingStrategy,
            ObjectReader valueReader,
            BiConsumer duplicateHandler
    ) {
        values.forEach(item -> {
            Object key;
            if (item instanceof Map) {
                key = ((Map<?, ?>) item).get(keyName);
            } else if (item != null) {
                ObjectWriter itemWriter = JSONFactory.getObjectWriter(item.getClass(), 0);
                key = itemWriter.getFieldValue(item, keyName);
            } else {
                throw new JSONException("key not found " + keyName);
            }
            if (namingStrategy != null && key instanceof String) {
                key = namingStrategy.fieldName((String) key);
            }
            Object mapValue;
            if (valueReader.getObjectClass().isInstance(item)) {
                mapValue = item;
            } else if (item instanceof Map) {
                mapValue = valueReader.createInstance((Map) item);
            } else {
                throw new JSONException("can not accept " + JSON.toJSONString(item, JSONWriter.Feature.ReferenceDetection));
            }
            Object origin = object.putIfAbsent(key, mapValue);
            if (origin != null & duplicateHandler != null) {
                duplicateHandler.accept(origin, mapValue);
            }
        });
    }
}
