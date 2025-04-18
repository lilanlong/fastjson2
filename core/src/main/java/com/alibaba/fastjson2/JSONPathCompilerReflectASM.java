package com.alibaba.fastjson2;

import com.alibaba.fastjson2.internal.asm.ASMUtils;
import com.alibaba.fastjson2.internal.asm.ClassWriter;
import com.alibaba.fastjson2.internal.asm.MethodWriter;
import com.alibaba.fastjson2.internal.asm.Opcodes;
import com.alibaba.fastjson2.reader.FieldReader;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.alibaba.fastjson2.util.DynamicClassLoader;
import com.alibaba.fastjson2.writer.FieldWriter;
import com.alibaba.fastjson2.writer.ObjectWriter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicLong;

import static com.alibaba.fastjson2.internal.asm.ASMUtils.*;

final class JSONPathCompilerReflectASM
        extends JSONPathCompilerReflect {
    // GraalVM not support
    // Android not support
    private static final AtomicLong seed = new AtomicLong();
    static final JSONPathCompilerReflectASM INSTANCE = new JSONPathCompilerReflectASM(
            DynamicClassLoader.getInstance()
    );

    private static final String TYPE_SINGLE_NAME_PATH_TYPED = ASMUtils.type(SingleNamePathTyped.class);
    private static final String METHOD_SINGLE_NAME_PATH_TYPED_INIT = "(Ljava/lang/String;Ljava/lang/Class;" + DESC_OBJECT_READER + DESC_FIELD_READER + DESC_OBJECT_WRITER + DESC_FIELD_WRITER + ")V";
    private final DynamicClassLoader classLoader;

    public JSONPathCompilerReflectASM(DynamicClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    private boolean support(Class objectClass) {
        boolean externalClass = classLoader.isExternalClass(objectClass);
        int objectClassModifiers = objectClass.getModifiers();
        return Modifier.isAbstract(objectClassModifiers)
                || Modifier.isInterface(objectClassModifiers)
                || !Modifier.isPublic(objectClassModifiers)
                || externalClass;
    }

    @Override
    protected JSONPath compileSingleNamePath(Class objectClass, JSONPathSingleName path) {
        if (support(objectClass)) {
            return super.compileSingleNamePath(objectClass, path);
        }

        String fieldName = path.name;

        String TYPE_OBJECT = ASMUtils.type(objectClass);

        ObjectReader objectReader = path.getReaderContext().getObjectReader(objectClass);
        FieldReader fieldReader = objectReader.getFieldReader(fieldName);

        ObjectWriter objectWriter = path.getWriterContext().getObjectWriter(objectClass);
        FieldWriter fieldWriter = objectWriter.getFieldWriter(fieldName);

        ClassWriter cw = new ClassWriter(null);

        String className = "JSONPath_" + seed.incrementAndGet();
        String classNameType;
        String classNameFull;

        Package pkg = JSONPathCompilerReflectASM.class.getPackage();
        if (pkg != null) {
            String packageName = pkg.getName();
            int packageNameLength = packageName.length();
            int charsLength = packageNameLength + 1 + className.length();
            char[] chars = new char[charsLength];
            packageName.getChars(0, packageName.length(), chars, 0);
            chars[packageNameLength] = '.';
            className.getChars(0, className.length(), chars, packageNameLength + 1);
            classNameFull = new String(chars);

            chars[packageNameLength] = '/';
            for (int i = 0; i < packageNameLength; ++i) {
                if (chars[i] == '.') {
                    chars[i] = '/';
                }
            }
            classNameType = new String(chars);
        } else {
            classNameType = className;
            classNameFull = className;
        }

        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_SUPER, classNameType, TYPE_SINGLE_NAME_PATH_TYPED, new String[]{});

        {
            final int THIS = 0, PATH = 1, CLASS = 2, OBJECT_READER = 3, FIELD_READER = 4, OBJECT_WRITER = 5, FIELD_WRITER = 6;

            MethodWriter mw = cw.visitMethod(
                    Opcodes.ACC_PUBLIC,
                    "<init>",
                    METHOD_SINGLE_NAME_PATH_TYPED_INIT,
                    64
            );
            mw.aload(THIS);
            mw.aload(PATH);
            mw.aload(CLASS);
            mw.aload(OBJECT_READER);
            mw.aload(FIELD_READER);
            mw.aload(OBJECT_WRITER);
            mw.aload(FIELD_WRITER);

            mw.invokespecial(TYPE_SINGLE_NAME_PATH_TYPED, "<init>", METHOD_SINGLE_NAME_PATH_TYPED_INIT);

            mw.return_();
            mw.visitMaxs(3, 3);
        }

        if (fieldReader != null) {
            Class fieldClass = fieldReader.fieldClass;
            int OBJECT = 1, VALUE = 2;

            if (fieldClass == int.class) {
                MethodWriter mw = cw.visitMethod(
                        Opcodes.ACC_PUBLIC,
                        "setInt",
                        "(Ljava/lang/Object;I)V",
                        64
                );
                mw.aload(OBJECT);
                mw.checkcast(TYPE_OBJECT);
                mw.visitVarInsn(Opcodes.ILOAD, VALUE);

                gwSetValue(mw, TYPE_OBJECT, fieldReader);

                mw.return_();
                mw.visitMaxs(2, 2);
            }
            if (fieldClass == long.class) {
                MethodWriter mw = cw.visitMethod(
                        Opcodes.ACC_PUBLIC,
                        "setLong",
                        "(Ljava/lang/Object;J)V",
                        64
                );
                mw.aload(OBJECT);
                mw.checkcast(TYPE_OBJECT);
                mw.lload(VALUE);

                gwSetValue(mw, TYPE_OBJECT, fieldReader);

                mw.return_();
                mw.visitMaxs(2, 2);
            }

            {
                MethodWriter mw = cw.visitMethod(
                        Opcodes.ACC_PUBLIC,
                        "set",
                        "(Ljava/lang/Object;Ljava/lang/Object;)V",
                        64
                );
                mw.aload(OBJECT);
                mw.checkcast(TYPE_OBJECT);
                mw.aload(VALUE);
                if (fieldClass == int.class) {
                    mw.checkcast("java/lang/Number");
                    mw.invokevirtual("java/lang/Number", "intValue", "()I");
                } else if (fieldClass == long.class) {
                    mw.checkcast("java/lang/Number");
                    mw.invokevirtual("java/lang/Number", "longValue", "()J");
                } else if (fieldClass == float.class) {
                    mw.checkcast("java/lang/Number");
                    mw.invokevirtual("java/lang/Number", "floatValue", "()F");
                } else if (fieldClass == double.class) {
                    mw.checkcast("java/lang/Number");
                    mw.invokevirtual("java/lang/Number", "doubleValue", "()D");
                } else if (fieldClass == short.class) {
                    mw.checkcast("java/lang/Number");
                    mw.invokevirtual("java/lang/Number", "shortValue", "()S");
                } else if (fieldClass == byte.class) {
                    mw.checkcast("java/lang/Number");
                    mw.invokevirtual("java/lang/Number", "byteValue", "()B");
                } else if (fieldClass == boolean.class) {
                    mw.checkcast("java/lang/Boolean");
                    mw.invokevirtual("java/lang/Boolean", "booleanValue", "()Z");
                } else if (fieldClass == char.class) {
                    mw.checkcast("java/lang/Character");
                    mw.invokevirtual("java/lang/Character", "charValue", "()C");
                }
                gwSetValue(mw, TYPE_OBJECT, fieldReader);

                mw.return_();
                mw.visitMaxs(2, 2);
            }
        }

        if (fieldWriter != null) {
            Class fieldClass = fieldReader.fieldClass;

            int OBJECT = 1;

            MethodWriter mw = cw.visitMethod(
                    Opcodes.ACC_PUBLIC,
                    "eval",
                    "(Ljava/lang/Object;)Ljava/lang/Object;",
                    64
            );
            mw.aload(OBJECT);
            mw.checkcast(TYPE_OBJECT);
            gwGetValue(mw, TYPE_OBJECT, fieldWriter);
            if (fieldClass == int.class) {
                mw.invokestatic("java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } else if (fieldClass == long.class) {
                mw.invokestatic("java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            } else if (fieldClass == float.class) {
                mw.invokestatic("java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            } else if (fieldClass == double.class) {
                mw.invokestatic("java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            } else if (fieldClass == short.class) {
                mw.invokestatic("java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            } else if (fieldClass == byte.class) {
                mw.invokestatic("java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            } else if (fieldClass == boolean.class) {
                mw.invokestatic("java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            } else if (fieldClass == char.class) {
                mw.invokestatic("java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            }

            mw.areturn();
            mw.visitMaxs(2, 2);
        }

        byte[] code = cw.toByteArray();

        Class<?> readerClass = classLoader.defineClassPublic(classNameFull, code, 0, code.length);

        try {
            Constructor<?> constructor = readerClass.getConstructors()[0];
            return (JSONPath) constructor
                    .newInstance(path.path, objectClass, objectReader, fieldReader, objectWriter, fieldWriter);
        } catch (Throwable e) {
            throw new JSONException("compile jsonpath error, path " + path.path + ", objectType " + objectClass.getTypeName(), e);
        }

//        return new SingleNamePathTyped(path.path, objectClass, objectReader, fieldReader, objectWriter, fieldWriter);
    }

    private void gwSetValue(MethodWriter mw, String TYPE_OBJECT, FieldReader fieldReader) {
        Method method = fieldReader.method;
        Field field = fieldReader.field;
        Class fieldClass = fieldReader.fieldClass;
        String fieldClassDesc = ASMUtils.desc(fieldClass);

        if (method != null) {
            Class<?> returnType = method.getReturnType();
            String methodDesc = '(' + fieldClassDesc + ')' + ASMUtils.desc(returnType);
            mw.invokevirtual(TYPE_OBJECT, method.getName(), methodDesc);
            if (returnType != Void.TYPE) { // builder
                mw.pop();
            }
        } else {
            mw.putfield(TYPE_OBJECT, field.getName(), fieldClassDesc);
        }
    }

    private void gwGetValue(MethodWriter mw, String TYPE_OBJECT, FieldWriter fieldWriter) {
        Method method = fieldWriter.method;
        Field field = fieldWriter.field;
        Class fieldClass = fieldWriter.fieldClass;
        String fieldClassDesc = ASMUtils.desc(fieldClass);

        if (method != null) {
            String methodDesc = "()" + fieldClassDesc;
            mw.invokevirtual(TYPE_OBJECT, method.getName(), methodDesc);
        } else {
            mw.getfield(TYPE_OBJECT, field.getName(), fieldClassDesc);
        }
    }
}
