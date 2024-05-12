## 1 EishayParseBinary
| aliyun ecs spec | jdk version 	|	jsonb	|	fastjson2UTF8Bytes	|	hessian	|	javaSerialize |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	4753.973	|	2432.072 (51.16%)	|	668.913 (14.07%)	|	115.792 (2.44%) |
|  | jdk-11.0.19	|	5583.074	|	2762.601 (49.48%)	|	622.662 (11.15%)	|	115.085 (2.06%) |
|  | jdk-17.0.7	|	6453.872	|	2937.135 (45.51%)	|	644.252 (9.98%)	|	129.833 (2.01%) |
|  | graalvm_17.0.7+8.1	|	7781.006	|	2991.523 (38.45%)	|	781.532 (10.04%)	|	140.615 (1.81%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	6810.673	|	3540.907 (51.99%)	|	321.882 (4.73%)	|	162.283 (2.38%) |
|  | jdk-11.0.19	|	7540.507	|	4199.776 (55.7%)	|	479.798 (6.36%)	|	153.712 (2.04%) |
|  | jdk-17.0.7	|	7763.116	|	4178.207 (53.82%)	|	381.863 (4.92%)	|	155.263 (2%) |
|  | graalvm_17.0.7+8.1	|	9896.019	|	4434.275 (44.81%)	|	564.698 (5.71%)	|	172.693 (1.75%) |
| orangepi5p | jdk1.8.0_371	|	5486.477	|	3010.189 (54.87%)	|	179.788 (3.28%)	|	136.303 (2.48%) |
|  | jdk-11.0.19	|	6024.247	|	3246.167 (53.89%)	|	197.913 (3.29%)	|	130.888 (2.17%) |
|  | jdk-17.0.7	|	6304.789	|	3297.556 (52.3%)	|	197.369 (3.13%)	|	147.672 (2.34%) |
|  | graalvm_17.0.7+8.1	|	8366.843	|	3739.818 (44.7%)	|	246.062 (2.94%)	|	143.155 (1.71%) |


### 1.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  jsonb | 6453.872 | 7781.006 | 20.56% |
|  aliyun_ecs.g8y.large |  jsonb | 7763.116 | 9896.019 | 27.47% |
|  orangepi5p |  jsonb | 6304.789 | 8366.843 | 32.71% |
|  aliyun_ecs.g8i.large |  fastjson2UTF8Bytes | 2937.135 | 2991.523 | 1.85% |
|  aliyun_ecs.g8y.large |  fastjson2UTF8Bytes | 4178.207 | 4434.275 | 6.13% |
|  orangepi5p |  fastjson2UTF8Bytes | 3297.556 | 3739.818 | 13.41% |
|  aliyun_ecs.g8i.large |  hessian | 644.252 | 781.532 | 21.31% |
|  aliyun_ecs.g8y.large |  hessian | 381.863 | 564.698 | 47.88% |
|  orangepi5p |  hessian | 197.369 | 246.062 | 24.67% |
|  aliyun_ecs.g8i.large |  javaSerialize | 129.833 | 140.615 | 8.3% |
|  aliyun_ecs.g8y.large |  javaSerialize | 155.263 | 172.693 | 11.23% |
|  orangepi5p |  javaSerialize | 147.672 | 143.155 | -3.06% |
## 2 EishayParseBinaryArrayMapping
| aliyun ecs spec | jdk version 	|	jsonb	|	kryo	|	protobuf	|	fastjson2UTF8Bytes |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	7284.738	|	3151.669 (43.26%)	|	2687.514 (36.89%)	|	4346.624 (59.67%) |
|  | jdk-11.0.19	|	8649.75	|	3428.645 (39.64%)	|	2825.288 (32.66%)	|	4322.014 (49.97%) |
|  | jdk-17.0.7	|	10785.621	|	3048.963 (28.27%)	|	3597.885 (33.36%)	|	4998.405 (46.34%) |
|  | graalvm_17.0.7+8.1	|	16592.974	|	4030.711 (24.29%)	|	5914.667 (35.65%)	|	6002.447 (36.17%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	10318.69	|	4936.282 (47.84%)	|	3274.022 (31.73%)	|	5498.893 (53.29%) |
|  | jdk-11.0.19	|	10738.618	|	5290.104 (49.26%)	|	3322.156 (30.94%)	|	6136.399 (57.14%) |
|  | jdk-17.0.7	|	11240.26	|	5292.191 (47.08%)	|	4515.116 (40.17%)	|	6229.835 (55.42%) |
|  | graalvm_17.0.7+8.1	|	18924.063	|	5106.891 (26.99%)	|	7479.734 (39.52%)	|	7888.807 (41.69%) |
| orangepi5p | jdk1.8.0_371	|	6772.856	|	4136.281 (61.07%)	|	2775.585 (40.98%)	|	4119.015 (60.82%) |
|  | jdk-11.0.19	|	7180.508	|	4090.723 (56.97%)	|	3589.846 (49.99%)	|	4708.18 (65.57%) |
|  | jdk-17.0.7	|	7448.39	|	4300.529 (57.74%)	|	3949.69 (53.03%)	|	4859.558 (65.24%) |
|  | graalvm_17.0.7+8.1	|	9016.341	|	4000.566 (44.37%)	|	5353.059 (59.37%)	|	5872.003 (65.13%) |


### 2.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  jsonb | 10785.621 | 16592.974 | 53.84% |
|  aliyun_ecs.g8y.large |  jsonb | 11240.26 | 18924.063 | 68.36% |
|  orangepi5p |  jsonb | 7448.39 | 9016.341 | 21.05% |
|  aliyun_ecs.g8i.large |  kryo | 3048.963 | 4030.711 | 32.2% |
|  aliyun_ecs.g8y.large |  kryo | 5292.191 | 5106.891 | -3.5% |
|  orangepi5p |  kryo | 4300.529 | 4000.566 | -6.98% |
|  aliyun_ecs.g8i.large |  protobuf | 3597.885 | 5914.667 | 64.39% |
|  aliyun_ecs.g8y.large |  protobuf | 4515.116 | 7479.734 | 65.66% |
|  orangepi5p |  protobuf | 3949.69 | 5353.059 | 35.53% |
|  aliyun_ecs.g8i.large |  fastjson2UTF8Bytes | 4998.405 | 6002.447 | 20.09% |
|  aliyun_ecs.g8y.large |  fastjson2UTF8Bytes | 6229.835 | 7888.807 | 26.63% |
|  orangepi5p |  fastjson2UTF8Bytes | 4859.558 | 5872.003 | 20.83% |
## 3 EishayParseBinaryAutoType
| aliyun ecs spec | jdk version 	|	fastjson2JSONB	|	hessian	|	javaSerialize |
|-----|-----|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	3794.594	|	676.044 (17.82%)	|	117.058 (3.08%) |
|  | jdk-11.0.19	|	4339.484	|	618.233 (14.25%)	|	116.458 (2.68%) |
|  | jdk-17.0.7	|	4779.001	|	647.288 (13.54%)	|	130.006 (2.72%) |
|  | graalvm_17.0.7+8.1	|	5181.598	|	794.567 (15.33%)	|	141.942 (2.74%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	5430.68	|	331.514 (6.1%)	|	162.923 (3%) |
|  | jdk-11.0.19	|	5729.123	|	441.793 (7.71%)	|	156.723 (2.74%) |
|  | jdk-17.0.7	|	5907.579	|	393.633 (6.66%)	|	161.934 (2.74%) |
|  | graalvm_17.0.7+8.1	|	6358.521	|	541.31 (8.51%)	|	170.87 (2.69%) |
| orangepi5p | jdk1.8.0_371	|	3795.223	|	182.861 (4.82%)	|	136.707 (3.6%) |
|  | jdk-11.0.19	|	4189.609	|	184.741 (4.41%)	|	128.911 (3.08%) |
|  | jdk-17.0.7	|	4261.107	|	192.88 (4.53%)	|	144.517 (3.39%) |
|  | graalvm_17.0.7+8.1	|	4998.054	|	239.668 (4.8%)	|	145.492 (2.91%) |


### 3.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2JSONB | 4779.001 | 5181.598 | 8.42% |
|  aliyun_ecs.g8y.large |  fastjson2JSONB | 5907.579 | 6358.521 | 7.63% |
|  orangepi5p |  fastjson2JSONB | 4261.107 | 4998.054 | 17.29% |
|  aliyun_ecs.g8i.large |  hessian | 647.288 | 794.567 | 22.75% |
|  aliyun_ecs.g8y.large |  hessian | 393.633 | 541.31 | 37.52% |
|  orangepi5p |  hessian | 192.88 | 239.668 | 24.26% |
|  aliyun_ecs.g8i.large |  javaSerialize | 130.006 | 141.942 | 9.18% |
|  aliyun_ecs.g8y.large |  javaSerialize | 161.934 | 170.87 | 5.52% |
|  orangepi5p |  javaSerialize | 144.517 | 145.492 | 0.67% |
## 4 EishayParseString
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	2582.255	|	2194.912 (85%)	|	1076.041 (41.67%)	|	957.543 (37.08%) |
|  | jdk-11.0.19	|	2753.434	|	1970.107 (71.55%)	|	969.615 (35.21%)	|	982.558 (35.68%) |
|  | jdk-17.0.7	|	2879.11	|	2646.103 (91.91%)	|	1033.83 (35.91%)	|	1044.744 (36.29%) |
|  | graalvm_17.0.7+8.1	|	2877.882	|	3490.823 (121.3%)	|	1074.694 (37.34%)	|	1045.023 (36.31%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	4013.19	|	3080.664 (76.76%)	|	1387.022 (34.56%)	|	1414.971 (35.26%) |
|  | jdk-11.0.19	|	4150.442	|	3027.893 (72.95%)	|	1352.156 (32.58%)	|	1423.13 (34.29%) |
|  | jdk-17.0.7	|	4247.923	|	4114.055 (96.85%)	|	1420.088 (33.43%)	|	1425.616 (33.56%) |
|  | graalvm_17.0.7+8.1	|	4564.054	|	4711.368 (103.23%)	|	1456.355 (31.91%)	|	1570.283 (34.41%) |
| orangepi5p | jdk1.8.0_371	|	3163.978	|	2663.744 (84.19%)	|	1190.413 (37.62%)	|	1067.005 (33.72%) |
|  | jdk-11.0.19	|	3245.9	|	2561.117 (78.9%)	|	1105.771 (34.07%)	|	1072.671 (33.05%) |
|  | jdk-17.0.7	|	3270.943	|	3567.236 (109.06%)	|	1204.83 (36.83%)	|	1087.251 (33.24%) |
|  | graalvm_17.0.7+8.1	|	3596.944	|	4217.008 (117.24%)	|	1162.206 (32.31%)	|	1148.028 (31.92%) |


### 4.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2 | 2879.11 | 2877.882 | -0.04% |
|  aliyun_ecs.g8y.large |  fastjson2 | 4247.923 | 4564.054 | 7.44% |
|  orangepi5p |  fastjson2 | 3270.943 | 3596.944 | 9.97% |
|  aliyun_ecs.g8i.large |  fastjson1 | 2646.103 | 3490.823 | 31.92% |
|  aliyun_ecs.g8y.large |  fastjson1 | 4114.055 | 4711.368 | 14.52% |
|  orangepi5p |  fastjson1 | 3567.236 | 4217.008 | 18.21% |
|  aliyun_ecs.g8i.large |  jackson | 1033.83 | 1074.694 | 3.95% |
|  aliyun_ecs.g8y.large |  jackson | 1420.088 | 1456.355 | 2.55% |
|  orangepi5p |  jackson | 1204.83 | 1162.206 | -3.54% |
|  aliyun_ecs.g8i.large |  gson | 1044.744 | 1045.023 | 0.03% |
|  aliyun_ecs.g8y.large |  gson | 1425.616 | 1570.283 | 10.15% |
|  orangepi5p |  gson | 1087.251 | 1148.028 | 5.59% |
## 5 EishayParseStringPretty
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	1951.123	|	586.008 (30.03%)	|	981.529 (50.31%)	|	935.943 (47.97%) |
|  | jdk-11.0.19	|	1980.14	|	576.837 (29.13%)	|	895.231 (45.21%)	|	842.114 (42.53%) |
|  | jdk-17.0.7	|	1936.139	|	617.388 (31.89%)	|	905.749 (46.78%)	|	874.874 (45.19%) |
|  | graalvm_17.0.7+8.1	|	2074.951	|	860.298 (41.46%)	|	962.607 (46.39%)	|	983.036 (47.38%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	1816.268	|	863.233 (47.53%)	|	1266.37 (69.72%)	|	1303.309 (71.76%) |
|  | jdk-11.0.19	|	3198.409	|	904.486 (28.28%)	|	1249.957 (39.08%)	|	1338.467 (41.85%) |
|  | jdk-17.0.7	|	2997.572	|	959.907 (32.02%)	|	1299.603 (43.36%)	|	1322.768 (44.13%) |
|  | graalvm_17.0.7+8.1	|	3277.775	|	1298.414 (39.61%)	|	1325.719 (40.45%)	|	1430.954 (43.66%) |
| orangepi5p | jdk1.8.0_371	|	2579.831	|	713.589 (27.66%)	|	1111.452 (43.08%)	|	964.844 (37.4%) |
|  | jdk-11.0.19	|	2593.822	|	718.589 (27.7%)	|	1053.424 (40.61%)	|	990.794 (38.2%) |
|  | jdk-17.0.7	|	2577.714	|	829.781 (32.19%)	|	1106.165 (42.91%)	|	1001.714 (38.86%) |
|  | graalvm_17.0.7+8.1	|	2712.799	|	980.767 (36.15%)	|	1050.036 (38.71%)	|	1039.594 (38.32%) |


### 5.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2 | 1936.139 | 2074.951 | 7.17% |
|  aliyun_ecs.g8y.large |  fastjson2 | 2997.572 | 3277.775 | 9.35% |
|  orangepi5p |  fastjson2 | 2577.714 | 2712.799 | 5.24% |
|  aliyun_ecs.g8i.large |  fastjson1 | 617.388 | 860.298 | 39.34% |
|  aliyun_ecs.g8y.large |  fastjson1 | 959.907 | 1298.414 | 35.26% |
|  orangepi5p |  fastjson1 | 829.781 | 980.767 | 18.2% |
|  aliyun_ecs.g8i.large |  jackson | 905.749 | 962.607 | 6.28% |
|  aliyun_ecs.g8y.large |  jackson | 1299.603 | 1325.719 | 2.01% |
|  orangepi5p |  jackson | 1106.165 | 1050.036 | -5.07% |
|  aliyun_ecs.g8i.large |  gson | 874.874 | 983.036 | 12.36% |
|  aliyun_ecs.g8y.large |  gson | 1322.768 | 1430.954 | 8.18% |
|  orangepi5p |  gson | 1001.714 | 1039.594 | 3.78% |
## 6 EishayParseTreeString
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	2157.731	|	1171.904 (54.31%)	|	1160.387 (53.78%)	|	834.626 (38.68%) |
|  | jdk-11.0.19	|	1967.972	|	1016.21 (51.64%)	|	1014.106 (51.53%)	|	794.442 (40.37%) |
|  | jdk-17.0.7	|	2460.387	|	1252.679 (50.91%)	|	1156.897 (47.02%)	|	811.927 (33%) |
|  | graalvm_17.0.7+8.1	|	2494.678	|	1493.373 (59.86%)	|	1213.447 (48.64%)	|	1074.36 (43.07%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	2544.851	|	1335.47 (52.48%)	|	1169.094 (45.94%)	|	1075.553 (42.26%) |
|  | jdk-11.0.19	|	2831.14	|	1352.26 (47.76%)	|	1259.093 (44.47%)	|	1127.018 (39.81%) |
|  | jdk-17.0.7	|	2821.527	|	1434.44 (50.84%)	|	1369.809 (48.55%)	|	1129.4 (40.03%) |
|  | graalvm_17.0.7+8.1	|	3211.594	|	2145.957 (66.82%)	|	1553.492 (48.37%)	|	1381.737 (43.02%) |
| orangepi5p | jdk1.8.0_371	|	2081.1	|	1066.732 (51.26%)	|	1150.45 (55.28%)	|	892.438 (42.88%) |
|  | jdk-11.0.19	|	2174.288	|	1061.327 (48.81%)	|	1103.669 (50.76%)	|	883.381 (40.63%) |
|  | jdk-17.0.7	|	2228.951	|	1304.163 (58.51%)	|	1198.572 (53.77%)	|	874.087 (39.22%) |
|  | graalvm_17.0.7+8.1	|	2394.753	|	1683.816 (70.31%)	|	1270.827 (53.07%)	|	999.579 (41.74%) |


### 6.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2 | 2460.387 | 2494.678 | 1.39% |
|  aliyun_ecs.g8y.large |  fastjson2 | 2821.527 | 3211.594 | 13.82% |
|  orangepi5p |  fastjson2 | 2228.951 | 2394.753 | 7.44% |
|  aliyun_ecs.g8i.large |  fastjson1 | 1252.679 | 1493.373 | 19.21% |
|  aliyun_ecs.g8y.large |  fastjson1 | 1434.44 | 2145.957 | 49.6% |
|  orangepi5p |  fastjson1 | 1304.163 | 1683.816 | 29.11% |
|  aliyun_ecs.g8i.large |  jackson | 1156.897 | 1213.447 | 4.89% |
|  aliyun_ecs.g8y.large |  jackson | 1369.809 | 1553.492 | 13.41% |
|  orangepi5p |  jackson | 1198.572 | 1270.827 | 6.03% |
|  aliyun_ecs.g8i.large |  gson | 811.927 | 1074.36 | 32.32% |
|  aliyun_ecs.g8y.large |  gson | 1129.4 | 1381.737 | 22.34% |
|  orangepi5p |  gson | 874.087 | 999.579 | 14.36% |
## 7 EishayParseTreeStringPretty
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	1631.978	|	980.824 (60.1%)	|	1051.036 (64.4%)	|	812.683 (49.8%) |
|  | jdk-11.0.19	|	1612.8	|	891.566 (55.28%)	|	890.339 (55.2%)	|	726.192 (45.03%) |
|  | jdk-17.0.7	|	1828.062	|	1042.057 (57%)	|	963.503 (52.71%)	|	738.807 (40.41%) |
|  | graalvm_17.0.7+8.1	|	1893.932	|	1275.176 (67.33%)	|	1120.999 (59.19%)	|	916.984 (48.42%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	2252.79	|	1202.004 (53.36%)	|	1191.446 (52.89%)	|	1063.712 (47.22%) |
|  | jdk-11.0.19	|	2428.803	|	1205.649 (49.64%)	|	1177.345 (48.47%)	|	1078.557 (44.41%) |
|  | jdk-17.0.7	|	2330.073	|	1297.186 (55.67%)	|	1260.2 (54.08%)	|	1070.705 (45.95%) |
|  | graalvm_17.0.7+8.1	|	2700.881	|	1894.45 (70.14%)	|	1441.868 (53.39%)	|	1201.174 (44.47%) |
| orangepi5p | jdk1.8.0_371	|	1830.182	|	986.51 (53.9%)	|	1079.931 (59.01%)	|	810.592 (44.29%) |
|  | jdk-11.0.19	|	1860.078	|	869.449 (46.74%)	|	1008.301 (54.21%)	|	820.3 (44.1%) |
|  | jdk-17.0.7	|	1865.316	|	1146.312 (61.45%)	|	1073.816 (57.57%)	|	828.732 (44.43%) |
|  | graalvm_17.0.7+8.1	|	2062.055	|	1421.686 (68.95%)	|	1144.626 (55.51%)	|	959.165 (46.52%) |


### 7.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2 | 1828.062 | 1893.932 | 3.6% |
|  aliyun_ecs.g8y.large |  fastjson2 | 2330.073 | 2700.881 | 15.91% |
|  orangepi5p |  fastjson2 | 1865.316 | 2062.055 | 10.55% |
|  aliyun_ecs.g8i.large |  fastjson1 | 1042.057 | 1275.176 | 22.37% |
|  aliyun_ecs.g8y.large |  fastjson1 | 1297.186 | 1894.45 | 46.04% |
|  orangepi5p |  fastjson1 | 1146.312 | 1421.686 | 24.02% |
|  aliyun_ecs.g8i.large |  jackson | 963.503 | 1120.999 | 16.35% |
|  aliyun_ecs.g8y.large |  jackson | 1260.2 | 1441.868 | 14.42% |
|  orangepi5p |  jackson | 1073.816 | 1144.626 | 6.59% |
|  aliyun_ecs.g8i.large |  gson | 738.807 | 916.984 | 24.12% |
|  aliyun_ecs.g8y.large |  gson | 1070.705 | 1201.174 | 12.19% |
|  orangepi5p |  gson | 828.732 | 959.165 | 15.74% |
## 8 EishayParseTreeUTF8Bytes
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	2253.021	|	1042.218 (46.26%)	|	1246.496 (55.33%)	|	793.686 (35.23%) |
|  | jdk-11.0.19	|	1930.174	|	925.251 (47.94%)	|	1066.554 (55.26%)	|	775.277 (40.17%) |
|  | jdk-17.0.7	|	2443.981	|	1103.432 (45.15%)	|	1121.258 (45.88%)	|	776.592 (31.78%) |
|  | graalvm_17.0.7+8.1	|	2487.747	|	1318.479 (53%)	|	1271.877 (51.13%)	|	997.497 (40.1%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	2517.839	|	1074.028 (42.66%)	|	1246.687 (49.51%)	|	969.746 (38.52%) |
|  | jdk-11.0.19	|	2837.901	|	1202.739 (42.38%)	|	1584.51 (55.83%)	|	1052.49 (37.09%) |
|  | jdk-17.0.7	|	2772.75	|	1303.895 (47.03%)	|	1376.052 (49.63%)	|	1065.82 (38.44%) |
|  | graalvm_17.0.7+8.1	|	3136.18	|	1739.245 (55.46%)	|	1691.511 (53.94%)	|	1286.053 (41.01%) |
| orangepi5p | jdk1.8.0_371	|	1988.904	|	896.813 (45.09%)	|	1195.52 (60.11%)	|	791.236 (39.78%) |
|  | jdk-11.0.19	|	2169.525	|	957.193 (44.12%)	|	1256.544 (57.92%)	|	835.895 (38.53%) |
|  | jdk-17.0.7	|	2230.993	|	1139.529 (51.08%)	|	1345.365 (60.3%)	|	836.037 (37.47%) |
|  | graalvm_17.0.7+8.1	|	2435.244	|	1302.339 (53.48%)	|	1399.878 (57.48%)	|	923.184 (37.91%) |


### 8.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2 | 2443.981 | 2487.747 | 1.79% |
|  aliyun_ecs.g8y.large |  fastjson2 | 2772.75 | 3136.18 | 13.11% |
|  orangepi5p |  fastjson2 | 2230.993 | 2435.244 | 9.16% |
|  aliyun_ecs.g8i.large |  fastjson1 | 1103.432 | 1318.479 | 19.49% |
|  aliyun_ecs.g8y.large |  fastjson1 | 1303.895 | 1739.245 | 33.39% |
|  orangepi5p |  fastjson1 | 1139.529 | 1302.339 | 14.29% |
|  aliyun_ecs.g8i.large |  jackson | 1121.258 | 1271.877 | 13.43% |
|  aliyun_ecs.g8y.large |  jackson | 1376.052 | 1691.511 | 22.92% |
|  orangepi5p |  jackson | 1345.365 | 1399.878 | 4.05% |
|  aliyun_ecs.g8i.large |  gson | 776.592 | 997.497 | 28.45% |
|  aliyun_ecs.g8y.large |  gson | 1065.82 | 1286.053 | 20.66% |
|  orangepi5p |  gson | 836.037 | 923.184 | 10.42% |
## 9 EishayParseTreeUTF8BytesPretty
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	1782.987	|	892.087 (50.03%)	|	1135.61 (63.69%)	|	746.285 (41.86%) |
|  | jdk-11.0.19	|	1556.411	|	798.095 (51.28%)	|	990.063 (63.61%)	|	714.04 (45.88%) |
|  | jdk-17.0.7	|	1832.521	|	900.709 (49.15%)	|	1067.396 (58.25%)	|	748.217 (40.83%) |
|  | graalvm_17.0.7+8.1	|	1832.723	|	1098.387 (59.93%)	|	1130.491 (61.68%)	|	922.851 (50.35%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	2194.492	|	998.24 (45.49%)	|	1152.602 (52.52%)	|	909.755 (41.46%) |
|  | jdk-11.0.19	|	2400.397	|	1073.307 (44.71%)	|	1329.301 (55.38%)	|	1032.351 (43.01%) |
|  | jdk-17.0.7	|	2416.355	|	1151.586 (47.66%)	|	1185.183 (49.05%)	|	1033.241 (42.76%) |
|  | graalvm_17.0.7+8.1	|	2671.55	|	1461.795 (54.72%)	|	1489.334 (55.75%)	|	1280.103 (47.92%) |
| orangepi5p | jdk1.8.0_371	|	1763.313	|	768.764 (43.6%)	|	1129.328 (64.05%)	|	702.67 (39.85%) |
|  | jdk-11.0.19	|	1867.64	|	770.172 (41.24%)	|	1243.819 (66.6%)	|	804.079 (43.05%) |
|  | jdk-17.0.7	|	1873.573	|	977.8 (52.19%)	|	1136.18 (60.64%)	|	773.038 (41.26%) |
|  | graalvm_17.0.7+8.1	|	2098.289	|	1077.131 (51.33%)	|	1218.783 (58.08%)	|	868.44 (41.39%) |


### 9.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2 | 1832.521 | 1832.723 | 0.01% |
|  aliyun_ecs.g8y.large |  fastjson2 | 2416.355 | 2671.55 | 10.56% |
|  orangepi5p |  fastjson2 | 1873.573 | 2098.289 | 11.99% |
|  aliyun_ecs.g8i.large |  fastjson1 | 900.709 | 1098.387 | 21.95% |
|  aliyun_ecs.g8y.large |  fastjson1 | 1151.586 | 1461.795 | 26.94% |
|  orangepi5p |  fastjson1 | 977.8 | 1077.131 | 10.16% |
|  aliyun_ecs.g8i.large |  jackson | 1067.396 | 1130.491 | 5.91% |
|  aliyun_ecs.g8y.large |  jackson | 1185.183 | 1489.334 | 25.66% |
|  orangepi5p |  jackson | 1136.18 | 1218.783 | 7.27% |
|  aliyun_ecs.g8i.large |  gson | 748.217 | 922.851 | 23.34% |
|  aliyun_ecs.g8y.large |  gson | 1033.241 | 1280.103 | 23.89% |
|  orangepi5p |  gson | 773.038 | 868.44 | 12.34% |
## 10 EishayParseUTF8Bytes
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	2416.504	|	1849.718 (76.55%)	|	1198.099 (49.58%)	|	898.149 (37.17%) |
|  | jdk-11.0.19	|	2295.677	|	1661.76 (72.39%)	|	1055.356 (45.97%)	|	954.814 (41.59%) |
|  | jdk-17.0.7	|	2927.294	|	2074.57 (70.87%)	|	1055.151 (36.05%)	|	985.241 (33.66%) |
|  | graalvm_17.0.7+8.1	|	2982.08	|	2482.913 (83.26%)	|	1184.176 (39.71%)	|	1018.019 (34.14%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	3566.348	|	2660.834 (74.61%)	|	1544.212 (43.3%)	|	1298.701 (36.42%) |
|  | jdk-11.0.19	|	4219.927	|	2479.671 (58.76%)	|	1507.776 (35.73%)	|	1342.897 (31.82%) |
|  | jdk-17.0.7	|	4249.983	|	3111.088 (73.2%)	|	1475.474 (34.72%)	|	1338.74 (31.5%) |
|  | graalvm_17.0.7+8.1	|	4686.092	|	3145.142 (67.12%)	|	1366.381 (29.16%)	|	1484.494 (31.68%) |
| orangepi5p | jdk1.8.0_371	|	2798.083	|	2052.691 (73.36%)	|	1386.798 (49.56%)	|	932.633 (33.33%) |
|  | jdk-11.0.19	|	3164.784	|	2041.79 (64.52%)	|	1294.929 (40.92%)	|	1010.805 (31.94%) |
|  | jdk-17.0.7	|	3278.378	|	2659.782 (81.13%)	|	1323.835 (40.38%)	|	1043.902 (31.84%) |
|  | graalvm_17.0.7+8.1	|	3652.372	|	2285.648 (62.58%)	|	1218.417 (33.36%)	|	1096.793 (30.03%) |


### 10.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2 | 2927.294 | 2982.08 | 1.87% |
|  aliyun_ecs.g8y.large |  fastjson2 | 4249.983 | 4686.092 | 10.26% |
|  orangepi5p |  fastjson2 | 3278.378 | 3652.372 | 11.41% |
|  aliyun_ecs.g8i.large |  fastjson1 | 2074.57 | 2482.913 | 19.68% |
|  aliyun_ecs.g8y.large |  fastjson1 | 3111.088 | 3145.142 | 1.09% |
|  orangepi5p |  fastjson1 | 2659.782 | 2285.648 | -14.07% |
|  aliyun_ecs.g8i.large |  jackson | 1055.151 | 1184.176 | 12.23% |
|  aliyun_ecs.g8y.large |  jackson | 1475.474 | 1366.381 | -7.39% |
|  orangepi5p |  jackson | 1323.835 | 1218.417 | -7.96% |
|  aliyun_ecs.g8i.large |  gson | 985.241 | 1018.019 | 3.33% |
|  aliyun_ecs.g8y.large |  gson | 1338.74 | 1484.494 | 10.89% |
|  orangepi5p |  gson | 1043.902 | 1096.793 | 5.07% |
## 11 EishayParseUTF8BytesPretty
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	1765.587	|	548.961 (31.09%)	|	1037.987 (58.79%)	|	713.592 (40.42%) |
|  | jdk-11.0.19	|	1591.899	|	539.805 (33.91%)	|	1004.984 (63.13%)	|	706.299 (44.37%) |
|  | jdk-17.0.7	|	2066.62	|	576.715 (27.91%)	|	947.916 (45.87%)	|	745.389 (36.07%) |
|  | graalvm_17.0.7+8.1	|	2074.906	|	790.539 (38.1%)	|	1074.671 (51.79%)	|	908.508 (43.79%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	1813.87	|	833.009 (45.92%)	|	1434.672 (79.09%)	|	914.953 (50.44%) |
|  | jdk-11.0.19	|	3140.695	|	830.401 (26.44%)	|	1351.382 (43.03%)	|	1082.025 (34.45%) |
|  | jdk-17.0.7	|	3214.929	|	888.816 (27.65%)	|	1392.019 (43.3%)	|	1060.657 (32.99%) |
|  | graalvm_17.0.7+8.1	|	3482.32	|	1086.35 (31.2%)	|	1337.733 (38.41%)	|	1247.382 (35.82%) |
| orangepi5p | jdk1.8.0_371	|	2343.465	|	652.82 (27.86%)	|	1250.401 (53.36%)	|	727.628 (31.05%) |
|  | jdk-11.0.19	|	2227.612	|	652.677 (29.3%)	|	1227.034 (55.08%)	|	781.262 (35.07%) |
|  | jdk-17.0.7	|	2570.856	|	732.027 (28.47%)	|	1205.866 (46.91%)	|	777.779 (30.25%) |
|  | graalvm_17.0.7+8.1	|	2627.663	|	804.617 (30.62%)	|	1088.258 (41.42%)	|	904.101 (34.41%) |


### 11.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2 | 2066.62 | 2074.906 | 0.4% |
|  aliyun_ecs.g8y.large |  fastjson2 | 3214.929 | 3482.32 | 8.32% |
|  orangepi5p |  fastjson2 | 2570.856 | 2627.663 | 2.21% |
|  aliyun_ecs.g8i.large |  fastjson1 | 576.715 | 790.539 | 37.08% |
|  aliyun_ecs.g8y.large |  fastjson1 | 888.816 | 1086.35 | 22.22% |
|  orangepi5p |  fastjson1 | 732.027 | 804.617 | 9.92% |
|  aliyun_ecs.g8i.large |  jackson | 947.916 | 1074.671 | 13.37% |
|  aliyun_ecs.g8y.large |  jackson | 1392.019 | 1337.733 | -3.9% |
|  orangepi5p |  jackson | 1205.866 | 1088.258 | -9.75% |
|  aliyun_ecs.g8i.large |  gson | 745.389 | 908.508 | 21.88% |
|  aliyun_ecs.g8y.large |  gson | 1060.657 | 1247.382 | 17.6% |
|  orangepi5p |  gson | 777.779 | 904.101 | 16.24% |
## 12 EishayWriteBinary
| aliyun ecs spec | jdk version 	|	jsonb	|	msgpack	|	protobuf |
|-----|-----|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	5051.288	|	992.999 (19.66%)	|	3398.774 (67.29%) |
|  | jdk-11.0.19	|	4615.287	|	1199.145 (25.98%)	|	2824.749 (61.2%) |
|  | jdk-17.0.7	|	6940.079	|	1378.602 (19.86%)	|	3786.507 (54.56%) |
|  | graalvm_17.0.7+8.1	|	8210.052	|	1472.791 (17.94%)	|	8140.054 (99.15%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	7618.399	|	1135.986 (14.91%)	|	3760.837 (49.37%) |
|  | jdk-11.0.19	|	8908.699	|	1732.73 (19.45%)	|	3794.968 (42.6%) |
|  | jdk-17.0.7	|	9054.88	|	1733.335 (19.14%)	|	4862.786 (53.7%) |
|  | graalvm_17.0.7+8.1	|	12948.129	|	1900.142 (14.68%)	|	9624.371 (74.33%) |
| orangepi5p | jdk1.8.0_371	|	6059.417	|	873.94 (14.42%)	|	2896.699 (47.8%) |
|  | jdk-11.0.19	|	7210.483	|	1274.039 (17.67%)	|	2840.929 (39.4%) |
|  | jdk-17.0.7	|	7302.027	|	1287.56 (17.63%)	|	4060.509 (55.61%) |
|  | graalvm_17.0.7+8.1	|	9342.27	|	1380.508 (14.78%)	|	7495.596 (80.23%) |


### 12.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  jsonb | 6940.079 | 8210.052 | 18.3% |
|  aliyun_ecs.g8y.large |  jsonb | 9054.88 | 12948.129 | 43% |
|  orangepi5p |  jsonb | 7302.027 | 9342.27 | 27.94% |
|  aliyun_ecs.g8i.large |  msgpack | 1378.602 | 1472.791 | 6.83% |
|  aliyun_ecs.g8y.large |  msgpack | 1733.335 | 1900.142 | 9.62% |
|  orangepi5p |  msgpack | 1287.56 | 1380.508 | 7.22% |
|  aliyun_ecs.g8i.large |  protobuf | 3786.507 | 8140.054 | 114.98% |
|  aliyun_ecs.g8y.large |  protobuf | 4862.786 | 9624.371 | 97.92% |
|  orangepi5p |  protobuf | 4060.509 | 7495.596 | 84.6% |
## 13 EishayWriteBinaryArrayMapping
| aliyun ecs spec | jdk version 	|	jsonb	|	kryo	|	protobuf	|	fastjson2UTF8Bytes |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	10996.957	|	3393.553 (30.86%)	|	3430.592 (31.2%)	|	4125.085 (37.51%) |
|  | jdk-11.0.19	|	12437.811	|	3440.911 (27.66%)	|	3445.559 (27.7%)	|	4506.16 (36.23%) |
|  | jdk-17.0.7	|	14892.516	|	3518.588 (23.63%)	|	3361.473 (22.57%)	|	5147.146 (34.56%) |
|  | graalvm_17.0.7+8.1	|	24409.683	|	5709.009 (23.39%)	|	8003.641 (32.79%)	|	8084.861 (33.12%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	9938.055	|	4631.044 (46.6%)	|	3500.61 (35.22%)	|	5979.507 (60.17%) |
|  | jdk-11.0.19	|	16654.78	|	5591.341 (33.57%)	|	4851.553 (29.13%)	|	6965.531 (41.82%) |
|  | jdk-17.0.7	|	17486.849	|	5397.279 (30.86%)	|	4778.935 (27.33%)	|	7352.518 (42.05%) |
|  | graalvm_17.0.7+8.1	|	30124.247	|	7146.43 (23.72%)	|	9801.817 (32.54%)	|	10984.52 (36.46%) |
| orangepi5p | jdk1.8.0_371	|	8175.652	|	3629.731 (44.4%)	|	2919.606 (35.71%)	|	5201.933 (63.63%) |
|  | jdk-11.0.19	|	11100.237	|	4576.406 (41.23%)	|	3923.79 (35.35%)	|	5776.681 (52.04%) |
|  | jdk-17.0.7	|	11658.293	|	4501.019 (38.61%)	|	4108.105 (35.24%)	|	5869.731 (50.35%) |
|  | graalvm_17.0.7+8.1	|	16452.916	|	4991.594 (30.34%)	|	7480.583 (45.47%)	|	7802.685 (47.42%) |


### 13.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  jsonb | 14892.516 | 24409.683 | 63.91% |
|  aliyun_ecs.g8y.large |  jsonb | 17486.849 | 30124.247 | 72.27% |
|  orangepi5p |  jsonb | 11658.293 | 16452.916 | 41.13% |
|  aliyun_ecs.g8i.large |  kryo | 3518.588 | 5709.009 | 62.25% |
|  aliyun_ecs.g8y.large |  kryo | 5397.279 | 7146.43 | 32.41% |
|  orangepi5p |  kryo | 4501.019 | 4991.594 | 10.9% |
|  aliyun_ecs.g8i.large |  protobuf | 3361.473 | 8003.641 | 138.1% |
|  aliyun_ecs.g8y.large |  protobuf | 4778.935 | 9801.817 | 105.1% |
|  orangepi5p |  protobuf | 4108.105 | 7480.583 | 82.09% |
|  aliyun_ecs.g8i.large |  fastjson2UTF8Bytes | 5147.146 | 8084.861 | 57.07% |
|  aliyun_ecs.g8y.large |  fastjson2UTF8Bytes | 7352.518 | 10984.52 | 49.4% |
|  orangepi5p |  fastjson2UTF8Bytes | 5869.731 | 7802.685 | 32.93% |
## 14 EishayWriteBinaryAutoType
| aliyun ecs spec | jdk version 	|	fastjson2JSONB	|	hessian	|	javaSerialize |
|-----|-----|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	3361.737	|	869.574 (25.87%)	|	523.171 (15.56%) |
|  | jdk-11.0.19	|	2939.23	|	825.242 (28.08%)	|	517.6 (17.61%) |
|  | jdk-17.0.7	|	3369.112	|	818.714 (24.3%)	|	535.34 (15.89%) |
|  | graalvm_17.0.7+8.1	|	4690.64	|	1256.73 (26.79%)	|	572.517 (12.21%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	4575.932	|	1189.073 (25.99%)	|	825.689 (18.04%) |
|  | jdk-11.0.19	|	4540.034	|	1029.985 (22.69%)	|	820.761 (18.08%) |
|  | jdk-17.0.7	|	4404.005	|	1243.94 (28.25%)	|	817.773 (18.57%) |
|  | graalvm_17.0.7+8.1	|	6289.787	|	1302.702 (20.71%)	|	817.432 (13%) |
| orangepi5p | jdk1.8.0_371	|	3584.42	|	682.634 (19.04%)	|	626.146 (17.47%) |
|  | jdk-11.0.19	|	3645.459	|	683.877 (18.76%)	|	651.808 (17.88%) |
|  | jdk-17.0.7	|	3490.94	|	692.969 (19.85%)	|	650.79 (18.64%) |
|  | graalvm_17.0.7+8.1	|	4493.808	|	704.132 (15.67%)	|	601.961 (13.4%) |


### 14.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2JSONB | 3369.112 | 4690.64 | 39.22% |
|  aliyun_ecs.g8y.large |  fastjson2JSONB | 4404.005 | 6289.787 | 42.82% |
|  orangepi5p |  fastjson2JSONB | 3490.94 | 4493.808 | 28.73% |
|  aliyun_ecs.g8i.large |  hessian | 818.714 | 1256.73 | 53.5% |
|  aliyun_ecs.g8y.large |  hessian | 1243.94 | 1302.702 | 4.72% |
|  orangepi5p |  hessian | 692.969 | 704.132 | 1.61% |
|  aliyun_ecs.g8i.large |  javaSerialize | 535.34 | 572.517 | 6.94% |
|  aliyun_ecs.g8y.large |  javaSerialize | 817.773 | 817.432 | -0.04% |
|  orangepi5p |  javaSerialize | 650.79 | 601.961 | -7.5% |
## 15 EishayWriteString
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	3351.555	|	1572.199 (46.91%)	|	2241.006 (66.86%)	|	982.929 (29.33%) |
|  | jdk-11.0.19	|	3050.54	|	1422.379 (46.63%)	|	1960.731 (64.27%)	|	789.742 (25.89%) |
|  | jdk-17.0.7	|	3663.698	|	1508.58 (41.18%)	|	2133.552 (58.23%)	|	718.56 (19.61%) |
|  | graalvm_17.0.7+8.1	|	5020.114	|	1745.964 (34.78%)	|	2506.563 (49.93%)	|	687.009 (13.69%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	4600.757	|	2073.222 (45.06%)	|	2471.014 (53.71%)	|	1338.269 (29.09%) |
|  | jdk-11.0.19	|	5150.534	|	1932.703 (37.52%)	|	2547.575 (49.46%)	|	1105.371 (21.46%) |
|  | jdk-17.0.7	|	5344.878	|	2149.421 (40.21%)	|	2765.983 (51.75%)	|	844.873 (15.81%) |
|  | graalvm_17.0.7+8.1	|	6792.175	|	3506.425 (51.62%)	|	3331.736 (49.05%)	|	875.97 (12.9%) |
| orangepi5p | jdk1.8.0_371	|	3914.563	|	3192.798 (81.56%)	|	1996.57 (51%)	|	955.556 (24.41%) |
|  | jdk-11.0.19	|	4420.479	|	1460.266 (33.03%)	|	2093.505 (47.36%)	|	920.034 (20.81%) |
|  | jdk-17.0.7	|	4504.858	|	1640.45 (36.42%)	|	2146.788 (47.65%)	|	832.334 (18.48%) |
|  | graalvm_17.0.7+8.1	|	4853.059	|	1952.938 (40.24%)	|	2304.794 (47.49%)	|	798.729 (16.46%) |


### 15.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2 | 3663.698 | 5020.114 | 37.02% |
|  aliyun_ecs.g8y.large |  fastjson2 | 5344.878 | 6792.175 | 27.08% |
|  orangepi5p |  fastjson2 | 4504.858 | 4853.059 | 7.73% |
|  aliyun_ecs.g8i.large |  fastjson1 | 1508.58 | 1745.964 | 15.74% |
|  aliyun_ecs.g8y.large |  fastjson1 | 2149.421 | 3506.425 | 63.13% |
|  orangepi5p |  fastjson1 | 1640.45 | 1952.938 | 19.05% |
|  aliyun_ecs.g8i.large |  jackson | 2133.552 | 2506.563 | 17.48% |
|  aliyun_ecs.g8y.large |  jackson | 2765.983 | 3331.736 | 20.45% |
|  orangepi5p |  jackson | 2146.788 | 2304.794 | 7.36% |
|  aliyun_ecs.g8i.large |  gson | 718.56 | 687.009 | -4.39% |
|  aliyun_ecs.g8y.large |  gson | 844.873 | 875.97 | 3.68% |
|  orangepi5p |  gson | 832.334 | 798.729 | -4.04% |
## 16 EishayWriteStringTree
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	3261.752	|	1957.175 (60%)	|	2120.432 (65.01%)	|	1087.704 (33.35%) |
|  | jdk-11.0.19	|	2578.451	|	1816.697 (70.46%)	|	1850.786 (71.78%)	|	847.599 (32.87%) |
|  | jdk-17.0.7	|	3121.17	|	1849.111 (59.24%)	|	1611.837 (51.64%)	|	730.516 (23.41%) |
|  | graalvm_17.0.7+8.1	|	3445.437	|	2106.462 (61.14%)	|	2172.493 (63.05%)	|	731.296 (21.23%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	3734.306	|	2265.691 (60.67%)	|	2534.349 (67.87%)	|	1614.077 (43.22%) |
|  | jdk-11.0.19	|	3813.869	|	2424.057 (63.56%)	|	2559.903 (67.12%)	|	1365.337 (35.8%) |
|  | jdk-17.0.7	|	4778.902	|	2268.404 (47.47%)	|	2507.172 (52.46%)	|	877.351 (18.36%) |
|  | graalvm_17.0.7+8.1	|	4529.66	|	3241.686 (71.57%)	|	3095.552 (68.34%)	|	902.854 (19.93%) |
| orangepi5p | jdk1.8.0_371	|	2686.429	|	1767.555 (65.8%)	|	2019.632 (75.18%)	|	1020.227 (37.98%) |
|  | jdk-11.0.19	|	2689.171	|	1783.27 (66.31%)	|	2091.617 (77.78%)	|	1033.408 (38.43%) |
|  | jdk-17.0.7	|	3132.018	|	1797.459 (57.39%)	|	2089.26 (66.71%)	|	861.928 (27.52%) |
|  | graalvm_17.0.7+8.1	|	3264.53	|	2195.442 (67.25%)	|	2329.688 (71.36%)	|	849.392 (26.02%) |


### 16.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2 | 3121.17 | 3445.437 | 10.39% |
|  aliyun_ecs.g8y.large |  fastjson2 | 4778.902 | 4529.66 | -5.22% |
|  orangepi5p |  fastjson2 | 3132.018 | 3264.53 | 4.23% |
|  aliyun_ecs.g8i.large |  fastjson1 | 1849.111 | 2106.462 | 13.92% |
|  aliyun_ecs.g8y.large |  fastjson1 | 2268.404 | 3241.686 | 42.91% |
|  orangepi5p |  fastjson1 | 1797.459 | 2195.442 | 22.14% |
|  aliyun_ecs.g8i.large |  jackson | 1611.837 | 2172.493 | 34.78% |
|  aliyun_ecs.g8y.large |  jackson | 2507.172 | 3095.552 | 23.47% |
|  orangepi5p |  jackson | 2089.26 | 2329.688 | 11.51% |
|  aliyun_ecs.g8i.large |  gson | 730.516 | 731.296 | 0.11% |
|  aliyun_ecs.g8y.large |  gson | 877.351 | 902.854 | 2.91% |
|  orangepi5p |  gson | 861.928 | 849.392 | -1.45% |
## 17 EishayWriteUTF8Bytes
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	3117.898	|	1397.729 (44.83%)	|	1931.227 (61.94%)	|	872.899 (28%) |
|  | jdk-11.0.19	|	3290.208	|	1559.448 (47.4%)	|	1829.172 (55.59%)	|	753.726 (22.91%) |
|  | jdk-17.0.7	|	4094.515	|	1311.418 (32.03%)	|	1964.922 (47.99%)	|	704.437 (17.2%) |
|  | graalvm_17.0.7+8.1	|	5293.463	|	1574.744 (29.75%)	|	2496.69 (47.17%)	|	692.987 (13.09%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	5066.945	|	1877.169 (37.05%)	|	2531.139 (49.95%)	|	1165.513 (23%) |
|  | jdk-11.0.19	|	5395.098	|	2641.487 (48.96%)	|	2402.697 (44.53%)	|	1128.482 (20.92%) |
|  | jdk-17.0.7	|	5484.846	|	1934.638 (35.27%)	|	2702.184 (49.27%)	|	816.215 (14.88%) |
|  | graalvm_17.0.7+8.1	|	7678.186	|	2230.843 (29.05%)	|	3437.981 (44.78%)	|	832.257 (10.84%) |
| orangepi5p | jdk1.8.0_371	|	4335.683	|	1421.801 (32.79%)	|	2099.996 (48.44%)	|	805.302 (18.57%) |
|  | jdk-11.0.19	|	4675.018	|	1355.289 (28.99%)	|	1887.46 (40.37%)	|	900.066 (19.25%) |
|  | jdk-17.0.7	|	4850.415	|	1419.481 (29.27%)	|	2137.183 (44.06%)	|	754.629 (15.56%) |
|  | graalvm_17.0.7+8.1	|	5873.62	|	1975.705 (33.64%)	|	2479.081 (42.21%)	|	798.512 (13.59%) |


### 17.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2 | 4094.515 | 5293.463 | 29.28% |
|  aliyun_ecs.g8y.large |  fastjson2 | 5484.846 | 7678.186 | 39.99% |
|  orangepi5p |  fastjson2 | 4850.415 | 5873.62 | 21.1% |
|  aliyun_ecs.g8i.large |  fastjson1 | 1311.418 | 1574.744 | 20.08% |
|  aliyun_ecs.g8y.large |  fastjson1 | 1934.638 | 2230.843 | 15.31% |
|  orangepi5p |  fastjson1 | 1419.481 | 1975.705 | 39.19% |
|  aliyun_ecs.g8i.large |  jackson | 1964.922 | 2496.69 | 27.06% |
|  aliyun_ecs.g8y.large |  jackson | 2702.184 | 3437.981 | 27.23% |
|  orangepi5p |  jackson | 2137.183 | 2479.081 | 16% |
|  aliyun_ecs.g8i.large |  gson | 704.437 | 692.987 | -1.63% |
|  aliyun_ecs.g8y.large |  gson | 816.215 | 832.257 | 1.97% |
|  orangepi5p |  gson | 754.629 | 798.512 | 5.82% |
## 18 EishayWriteUTF8BytesTree
| aliyun ecs spec | jdk version 	|	fastjson2	|	jackson |
|-----|-----|----------|-----|
| aliyun_ecs.g8i.large | jdk1.8.0_371	|	3684.394	|	1835.743 (49.82%) |
|  | jdk-11.0.19	|	3010.893	|	1732.278 (57.53%) |
|  | jdk-17.0.7	|	3619.574	|	1817.525 (50.21%) |
|  | graalvm_17.0.7+8.1	|	4191.035	|	2601.348 (62.07%) |
| aliyun_ecs.g8y.large | jdk1.8.0_371	|	4320.19	|	2845.023 (65.85%) |
|  | jdk-11.0.19	|	4553.992	|	2252.327 (49.46%) |
|  | jdk-17.0.7	|	4732.779	|	2696.215 (56.97%) |
|  | graalvm_17.0.7+8.1	|	6128.801	|	3409.555 (55.63%) |
| orangepi5p | jdk1.8.0_371	|	3324.041	|	2109.605 (63.47%) |
|  | jdk-11.0.19	|	3442.787	|	1888.567 (54.86%) |
|  | jdk-17.0.7	|	3375.879	|	2127.0 (63.01%) |
|  | graalvm_17.0.7+8.1	|	4440.494	|	2458.985 (55.38%) |


### 18.1 jdk17 vs graalvm17
|  ecs | library | jdk-17.0.7 | graalvm-jdk-17.0.7+8.1 | delta |
|-----|-----|-----|-----|-----|
|  aliyun_ecs.g8i.large |  fastjson2 | 3619.574 | 4191.035 | 15.79% |
|  aliyun_ecs.g8y.large |  fastjson2 | 4732.779 | 6128.801 | 29.5% |
|  orangepi5p |  fastjson2 | 3375.879 | 4440.494 | 31.54% |
|  aliyun_ecs.g8i.large |  jackson | 1817.525 | 2601.348 | 43.13% |
|  aliyun_ecs.g8y.large |  jackson | 2696.215 | 3409.555 | 26.46% |
|  orangepi5p |  jackson | 2127.0 | 2458.985 | 15.61% |