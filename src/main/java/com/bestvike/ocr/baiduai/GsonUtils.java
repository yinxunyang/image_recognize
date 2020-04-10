/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.bestvike.ocr.baiduai;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.sun.org.apache.xpath.internal.operations.String;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Json工具类.
 */
public class GsonUtils {
    private static Gson gson = new GsonBuilder().create();

    public static String toJson(Object value) {
        return gson.toJson(value);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonParseException {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) throws JsonParseException {
        return (T) gson.fromJson(json, typeOfT);
    }


    public static void main(String[] args) {
        String jsonRs = "{\"data\":{\"ret\":[{\"probability\":{\"average\":0.964689,\"min\":0.56189,\"variance\":0.011409},\"location\":{\"height\":37,\"left\":2061,\"top\":1716,\"width\":130},\"word_name\":\"hffsze\",\"word\":\"10850.00\"},{\"probability\":{\"average\":0.996964,\"min\":0.983727,\"variance\":0.000021},\"location\":{\"height\":37,\"left\":113,\"top\":515,\"width\":134},\"word_name\":\"mvyh#1#jyrq\",\"word\":\"20171024\"},{\"probability\":{\"average\":0.996964,\"min\":0.983727,\"variance\":0.000021},\"location\":{\"height\":37,\"left\":256,\"top\":515,\"width\":56},\"word_name\":\"mvyh#1#zy\",\"word\":\"货款\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#1#pzlx\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#1#pzhm\",\"word\":\"\"},{\"probability\":{\"average\":0.997355,\"min\":0.993562,\"variance\":0.000006},\"location\":{\"height\":34,\"left\":908,\"top\":518,\"width\":59},\"word_name\":\"mvyh#1#jdfse\",\"word\":\"0.00\"},{\"probability\":{\"average\":0.985681,\"min\":0.924646,\"variance\":0.000558},\"location\":{\"height\":32,\"left\":1123,\"top\":518,\"width\":116},\"word_name\":\"mvyh#1#dffse\",\"word\":\"1,000.00\"},{\"probability\":{\"average\":0.911274,\"min\":0.498975,\"variance\":0.022762},\"location\":{\"height\":63,\"left\":1341,\"top\":497,\"width\":184},\"word_name\":\"mvyh#1#zhye\",\"word\":\"106073.32\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#1#lsh\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#1#dfzh\",\"word\":\"\"},{\"probability\":{\"average\":0.992938,\"min\":0.982094,\"variance\":0.00006},\"location\":{\"height\":39,\"left\":1923,\"top\":510,\"width\":71},\"word_name\":\"mvyh#1#dfhm\",\"word\":\"俞秀明\"},{\"probability\":{\"average\":0.996421,\"min\":0.983072,\"variance\":0.000022},\"location\":{\"height\":44,\"left\":2226,\"top\":486,\"width\":252},\"word_name\":\"mvyh#1#dfhgm\",\"word\":\"中国农业银行西宁市黄河\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#2#jyrq\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#2#zy\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#2#pzlx\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#2#pzhm\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#2#jdfse\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#2#dffse\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#2#zhye\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#2#lsh\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#2#dfzh\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#2#dfhm\",\"word\":\"\"},{\"probability\":{\"average\":0.994774,\"min\":0.991974,\"variance\":0.000011},\"location\":{\"height\":29,\"left\":2223,\"top\":526,\"width\":71},\"word_name\":\"mvyh#2#dfhgm\",\"word\":\"路支行\"},{\"probability\":{\"average\":0.975736,\"min\":0.728123,\"variance\":0.005123},\"location\":{\"height\":49,\"left\":112,\"top\":592,\"width\":152},\"word_name\":\"mvyh#3#jyrq\",\"word\":\"20171024\"},{\"probability\":{\"average\":0.975736,\"min\":0.728123,\"variance\":0.005123},\"location\":{\"height\":49,\"left\":264,\"top\":592,\"width\":125},\"word_name\":\"mvyh#3#zy\",\"word\":\"购买动态密\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#3#pzlx\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#3#pzhm\",\"word\":\"\"},{\"probability\":{\"average\":0.999582,\"min\":0.999198,\"variance\":0.0},\"location\":{\"height\":36,\"left\":908,\"top\":606,\"width\":61},\"word_name\":\"mvyh#3#jdfse\",\"word\":\"0.00\"},{\"probability\":{\"average\":0.958029,\"min\":0.836871,\"variance\":0.002877},\"location\":{\"height\":40,\"left\":1109,\"top\":603,\"width\":147},\"word_name\":\"mvyh#3#dffse\",\"word\":\"1,000.00\"},{\"probability\":{\"average\":0.955208,\"min\":0.428335,\"variance\":0.012209},\"location\":{\"height\":50,\"left\":1359,\"top\":598,\"width\":160},\"word_name\":\"mvyh#3#zhye\",\"word\":\"107073.32\"},{\"probability\":{\"average\":0.955208,\"min\":0.428335,\"variance\":0.012209},\"location\":{\"height\":53,\"left\":1514,\"top\":587,\"width\":179},\"word_name\":\"mvyh#3#lsh\",\"word\":\"65002017102\"},{\"probability\":{\"average\":0.955208,\"min\":0.428335,\"variance\":0.012209},\"location\":{\"height\":55,\"left\":1679,\"top\":596,\"width\":207},\"word_name\":\"mvyh#3#dfzh\",\"word\":\"002671733\"},{\"probability\":{\"average\":0.955208,\"min\":0.428335,\"variance\":0.012209},\"location\":{\"height\":50,\"left\":1925,\"top\":582,\"width\":259},\"word_name\":\"mvyh#3#dfhm\",\"word\":\"青海惠民业管理有限公\"},{\"probability\":{\"average\":0.955208,\"min\":0.428335,\"variance\":0.012209},\"location\":{\"height\":49,\"left\":2222,\"top\":580,\"width\":262},\"word_name\":\"mvyh#3#dfhgm\",\"word\":\"中国银行股份有限公司西\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#4#jyrq\",\"word\":\"\"},{\"probability\":{\"average\":0.997973,\"min\":0.996192,\"variance\":0.000002},\"location\":{\"height\":35,\"left\":263,\"top\":623,\"width\":74},\"word_name\":\"mvyh#4#zy\",\"word\":\"码令牌\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#4#pzlx\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#4#pzhm\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#4#jdfse\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#4#dffse\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#4#zhye\",\"word\":\"\"},{\"probability\":{\"average\":0.997492,\"min\":0.992828,\"variance\":0.000004},\"location\":{\"height\":35,\"left\":1513,\"top\":617,\"width\":152},\"word_name\":\"mvyh#4#lsh\",\"word\":\"40007092822\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#4#dfzh\",\"word\":\"\"},{\"probability\":{\"average\":0.999736,\"min\":0.999736,\"variance\":0.0},\"location\":{\"height\":34,\"left\":1921,\"top\":618,\"width\":21},\"word_name\":\"mvyh#4#dfhm\",\"word\":\"司\"},{\"probability\":{\"average\":0.975703,\"min\":0.874947,\"variance\":0.002044},\"location\":{\"height\":30,\"left\":2232,\"top\":618,\"width\":128},\"word_name\":\"mvyh#4#dfhgm\",\"word\":\"宁市城北支行\"},{\"probability\":{\"average\":0.993836,\"min\":0.956114,\"variance\":0.000137},\"location\":{\"height\":50,\"left\":112,\"top\":685,\"width\":155},\"word_name\":\"mvyh#5#jyrq\",\"word\":\"20171024\"},{\"probability\":{\"average\":0.993836,\"min\":0.956114,\"variance\":0.000137},\"location\":{\"height\":50,\"left\":268,\"top\":685,\"width\":120},\"word_name\":\"mvyh#5#zy\",\"word\":\"购买动态密\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#5#pzlx\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#5#pzhm\",\"word\":\"\"},{\"probability\":{\"average\":0.995911,\"min\":0.985909,\"variance\":0.000033},\"location\":{\"height\":36,\"left\":907,\"top\":699,\"width\":68},\"word_name\":\"mvyh#5#jdfse\",\"word\":\"0.00\"},{\"probability\":{\"average\":0.946923,\"min\":0.782362,\"variance\":0.004202},\"location\":{\"height\":49,\"left\":1123,\"top\":687,\"width\":169},\"word_name\":\"mvyh#5#dffse\",\"word\":\"1,0000\"},{\"probability\":{\"average\":0.946923,\"min\":0.782362,\"variance\":0.004202},\"location\":{\"height\":49,\"left\":1342,\"top\":687,\"width\":171},\"word_name\":\"mvyh#5#zhye\",\"word\":\"108.073.3\"},{\"probability\":{\"average\":0.998842,\"min\":0.991545,\"variance\":0.000002},\"location\":{\"height\":26,\"left\":1516,\"top\":691,\"width\":160},\"word_name\":\"mvyh#5#lsh\",\"word\":\"565002017102\"},{\"probability\":{\"average\":0.998842,\"min\":0.991545,\"variance\":0.000002},\"location\":{\"height\":60,\"left\":1694,\"top\":673,\"width\":223},\"word_name\":\"mvyh#5#dfzh\",\"word\":\"28133001040006036\"},{\"probability\":{\"average\":0.913775,\"min\":0.432618,\"variance\":0.02821},\"location\":{\"height\":57,\"left\":1938,\"top\":687,\"width\":221},\"word_name\":\"mvyh#5#dfhm\",\"word\":\"青海富恒实业有限公司\"},{\"probability\":{\"average\":0.997894,\"min\":0.989767,\"variance\":0.00001},\"location\":{\"height\":36,\"left\":2228,\"top\":679,\"width\":248},\"word_name\":\"mvyh#5#dfhgm\",\"word\":\"中国农业银行股份有限公\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#6#jyrq\",\"word\":\"\"},{\"probability\":{\"average\":0.993617,\"min\":0.991864,\"variance\":0.000005},\"location\":{\"height\":34,\"left\":263,\"top\":717,\"width\":70},\"word_name\":\"mvyh#6#zy\",\"word\":\"码令牌\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#6#pzlx\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#6#pzhm\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#6#jdfse\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#6#dffse\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#6#zhye\",\"word\":\"\"},{\"probability\":{\"average\":0.991747,\"min\":0.909135,\"variance\":0.000571},\"location\":{\"height\":32,\"left\":1521,\"top\":715,\"width\":152},\"word_name\":\"mvyh#6#lsh\",\"word\":\"10007632188\"},{\"probability\":{\"average\":0.991747,\"min\":0.909135,\"variance\":0.000571},\"location\":{\"height\":32,\"left\":1697,\"top\":715,\"width\":26},\"word_name\":\"mvyh#6#dfzh\",\"word\":\"87\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#6#dfhm\",\"word\":\"\"},{\"probability\":{\"average\":0.998254,\"min\":0.994381,\"variance\":0.000003},\"location\":{\"height\":30,\"left\":2231,\"top\":713,\"width\":222},\"word_name\":\"mvyh#6#dfhgm\",\"word\":\"司西宁市城南新区支行\"},{\"probability\":{\"average\":0.915168,\"min\":0.50813,\"variance\":0.028958},\"location\":{\"height\":45,\"left\":111,\"top\":787,\"width\":147},\"word_name\":\"mvyh#7#jyrq\",\"word\":\"20171026\"},{\"probability\":{\"average\":0.915168,\"min\":0.50813,\"variance\":0.028958},\"location\":{\"height\":45,\"left\":267,\"top\":787,\"width\":53},\"word_name\":\"mvyh#7#zy\",\"word\":\"取款\"},{\"probability\":{\"average\":0.915168,\"min\":0.50813,\"variance\":0.028958},\"location\":{\"height\":45,\"left\":403,\"top\":787,\"width\":55},\"word_name\":\"mvyh#7#pzlx\",\"word\":\"其他\"},{\"probability\":{\"average\":0.915168,\"min\":0.50813,\"variance\":0.028958},\"location\":{\"height\":45,\"left\":637,\"top\":787,\"width\":40},\"word_name\":\"mvyh#7#pzhm\",\"word\":\"0\"},{\"probability\":{\"average\":0.935858,\"min\":0.49493,\"variance\":0.027774},\"location\":{\"height\":39,\"left\":853,\"top\":793,\"width\":121},\"word_name\":\"mvyh#7#jdfse\",\"word\":\"1948.08\"},{\"probability\":{\"average\":0.965491,\"min\":0.7683,\"variance\":0.002453},\"location\":{\"height\":48,\"left\":1158,\"top\":782,\"width\":103},\"word_name\":\"mvyh#7#dffse\",\"word\":\"0.00\"},{\"probability\":{\"average\":0.965491,\"min\":0.7683,\"variance\":0.002453},\"location\":{\"height\":48,\"left\":1336,\"top\":782,\"width\":161},\"word_name\":\"mvyh#7#zhye\",\"word\":\"106,125.2\"},{\"probability\":{\"average\":0.965491,\"min\":0.7683,\"variance\":0.002453},\"location\":{\"height\":48,\"left\":1497,\"top\":782,\"width\":184},\"word_name\":\"mvyh#7#lsh\",\"word\":\"301412017102\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#7#dfzh\",\"word\":\"\"},{\"probability\":{\"average\":0.996403,\"min\":0.975437,\"variance\":0.000034},\"location\":{\"height\":40,\"left\":1926,\"top\":772,\"width\":254},\"word_name\":\"mvyh#7#dfhm\",\"word\":\"济南百思为科软件技术有\"},{\"probability\":{\"average\":0.996403,\"min\":0.975437,\"variance\":0.000034},\"location\":{\"height\":40,\"left\":2228,\"top\":772,\"width\":242},\"word_name\":\"mvyh#7#dfhgm\",\"word\":\"中国工商银行济南经路\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#8#jyrq\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#8#zy\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#8#pzlx\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#8#pzhm\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#8#jdfse\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#8#dffse\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#8#zhye\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#8#lsh\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#8#dfzh\",\"word\":\"\"},{\"probability\":{\"average\":0.999886,\"min\":0.999767,\"variance\":0.0},\"location\":{\"height\":31,\"left\":1928,\"top\":807,\"width\":67},\"word_name\":\"mvyh#8#dfhm\",\"word\":\"限公司\"},{\"probability\":{\"average\":0.992597,\"min\":0.987477,\"variance\":0.000026},\"location\":{\"height\":31,\"left\":2226,\"top\":807,\"width\":37},\"word_name\":\"mvyh#8#dfhgm\",\"word\":\"支行\"},{\"probability\":{\"average\":0.997682,\"min\":0.988845,\"variance\":0.000011},\"location\":{\"height\":45,\"left\":112,\"top\":878,\"width\":144},\"word_name\":\"mvyh#9#jyrq\",\"word\":\"20171027\"},{\"probability\":{\"average\":0.997682,\"min\":0.988845,\"variance\":0.000011},\"location\":{\"height\":45,\"left\":265,\"top\":878,\"width\":25},\"word_name\":\"mvyh#9#zy\",\"word\":\"转\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#9#pzlx\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#9#pzhm\",\"word\":\"\"},{\"probability\":{\"average\":0.998409,\"min\":0.995016,\"variance\":0.000004},\"location\":{\"height\":35,\"left\":907,\"top\":885,\"width\":69},\"word_name\":\"mvyh#9#jdfse\",\"word\":\"0.00\"},{\"probability\":{\"average\":0.998807,\"min\":0.997667,\"variance\":0.000001},\"location\":{\"height\":35,\"left\":1139,\"top\":885,\"width\":104},\"word_name\":\"mvyh#9#dffse\",\"word\":\"200.00\"},{\"probability\":{\"average\":0.89994,\"min\":0.454592,\"variance\":0.021096},\"location\":{\"height\":48,\"left\":1350,\"top\":875,\"width\":171},\"word_name\":\"mvyh#9#zhye\",\"word\":\"106.325.245\"},{\"probability\":{\"average\":0.89994,\"min\":0.454592,\"variance\":0.021096},\"location\":{\"height\":47,\"left\":1512,\"top\":873,\"width\":177},\"word_name\":\"mvyh#9#lsh\",\"word\":\"65002017102\"},{\"probability\":{\"average\":0.89994,\"min\":0.454592,\"variance\":0.021096},\"location\":{\"height\":46,\"left\":1679,\"top\":872,\"width\":80},\"word_name\":\"mvyh#9#dfzh\",\"word\":\"61701\"},{\"probability\":{\"average\":0.89994,\"min\":0.454592,\"variance\":0.021096},\"location\":{\"height\":50,\"left\":1916,\"top\":865,\"width\":258},\"word_name\":\"mvyh#9#dfhm\",\"word\":\"0岛市秦房房地产开发\"},{\"probability\":{\"average\":0.89994,\"min\":0.454592,\"variance\":0.021096},\"location\":{\"height\":49,\"left\":2214,\"top\":861,\"width\":263},\"word_name\":\"mvyh#9#dfhgm\",\"word\":\"秦皇岛银行股份有限公司\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#10#jyrq\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#10#zy\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#10#pzlx\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#10#pzhm\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#10#jdfse\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#10#dffse\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#10#zhye\",\"word\":\"\"},{\"probability\":{\"average\":0.998176,\"min\":0.994067,\"variance\":0.000002},\"location\":{\"height\":31,\"left\":1514,\"top\":903,\"width\":155},\"word_name\":\"mvyh#10#lsh\",\"word\":\"70000981143\"},{\"probability\":{\"average\":0.998176,\"min\":0.994067,\"variance\":0.000002},\"location\":{\"height\":31,\"left\":1690,\"top\":903,\"width\":35},\"word_name\":\"mvyh#10#dfzh\",\"word\":\"93\"},{\"probability\":{\"average\":0.999951,\"min\":0.99987,\"variance\":0.0},\"location\":{\"height\":30,\"left\":1930,\"top\":902,\"width\":83},\"word_name\":\"mvyh#10#dfhm\",\"word\":\"有限公司\"},{\"probability\":{\"average\":0.998492,\"min\":0.996256,\"variance\":0.000002},\"location\":{\"height\":29,\"left\":2224,\"top\":902,\"width\":105},\"word_name\":\"mvyh#10#dfhgm\",\"word\":\"太阳城支行\"},{\"probability\":{\"average\":0.997476,\"min\":0.988911,\"variance\":0.00001},\"location\":{\"height\":39,\"left\":124,\"top\":978,\"width\":136},\"word_name\":\"mvyh#11#jyrq\",\"word\":\"20171031\"},{\"probability\":{\"average\":0.997476,\"min\":0.988911,\"variance\":0.00001},\"location\":{\"height\":39,\"left\":268,\"top\":978,\"width\":71},\"word_name\":\"mvyh#11#zy\",\"word\":\"密钥款\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#11#pzlx\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#11#pzhm\",\"word\":\"\"},{\"probability\":{\"average\":0.99918,\"min\":0.998446,\"variance\":0.0},\"location\":{\"height\":35,\"left\":907,\"top\":980,\"width\":67},\"word_name\":\"mvyh#11#jdfse\",\"word\":\"0.00\"},{\"probability\":{\"average\":0.884845,\"min\":0.448386,\"variance\":0.039603},\"location\":{\"height\":43,\"left\":1104,\"top\":974,\"width\":134},\"word_name\":\"mvyh#11#dffse\",\"word\":\"100.0\"},{\"probability\":{\"average\":0.962981,\"min\":0.622981,\"variance\":0.00668},\"location\":{\"height\":45,\"left\":1350,\"top\":969,\"width\":161},\"word_name\":\"mvyh#11#zhye\",\"word\":\"107.325.245\"},{\"probability\":{\"average\":0.962981,\"min\":0.622981,\"variance\":0.00668},\"location\":{\"height\":47,\"left\":1508,\"top\":966,\"width\":189},\"word_name\":\"mvyh#11#lsh\",\"word\":\"650020171036\"},{\"probability\":{\"average\":0.962981,\"min\":0.622981,\"variance\":0.00668},\"location\":{\"height\":46,\"left\":1693,\"top\":964,\"width\":228},\"word_name\":\"mvyh#11#dfzh\",\"word\":\"30501373603000\"},{\"probability\":{\"average\":0.962981,\"min\":0.622981,\"variance\":0.00668},\"location\":{\"height\":47,\"left\":1930,\"top\":960,\"width\":253},\"word_name\":\"mvyh#11#dfhm\",\"word\":\"西宁金润物业管理有限\"},{\"probability\":{\"average\":0.962981,\"min\":0.622981,\"variance\":0.00668},\"location\":{\"height\":47,\"left\":2222,\"top\":956,\"width\":260},\"word_name\":\"mvyh#11#dfhgm\",\"word\":\"中国建设银行股份有限公\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#12#jyrq\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#12#zy\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#12#pzlx\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#12#pzhm\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#12#jdfse\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#12#dffse\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#12#zhye\",\"word\":\"\"},{\"probability\":{\"average\":0.997081,\"min\":0.98495,\"variance\":0.000013},\"location\":{\"height\":29,\"left\":1514,\"top\":997,\"width\":181},\"word_name\":\"mvyh#12#lsh\",\"word\":\"100058040130\"},{\"probability\":{\"average\":0.997081,\"min\":0.98495,\"variance\":0.000013},\"location\":{\"height\":29,\"left\":1707,\"top\":997,\"width\":41},\"word_name\":\"mvyh#12#dfzh\",\"word\":\"007\"},{\"probability\":{\"average\":0.99997,\"min\":0.999941,\"variance\":0.0},\"location\":{\"height\":30,\"left\":1927,\"top\":994,\"width\":36},\"word_name\":\"mvyh#12#dfhm\",\"word\":\"公司\"},{\"probability\":{\"average\":0.893168,\"min\":0.357667,\"variance\":0.048562},\"location\":{\"height\":30,\"left\":2228,\"top\":994,\"width\":158},\"word_name\":\"mvyh#12#dfhgm\",\"word\":\"司西宁庄支行\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#13#jyrq\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#13#zy\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#13#pzlx\",\"word\":\"\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#13#pzhm\",\"word\":\"\"},{\"probability\":{\"average\":0.998859,\"min\":0.997368,\"variance\":0.000001},\"location\":{\"height\":35,\"left\":822,\"top\":1709,\"width\":170},\"word_name\":\"mvyh#13#jdfse\",\"word\":\"合计笔数:20\"},{\"probability\":{\"average\":0.976022,\"min\":0.807475,\"variance\":0.00298},\"location\":{\"height\":37,\"left\":1258,\"top\":1704,\"width\":22},\"word_name\":\"mvyh#13#dffse\",\"word\":\"借\"},{\"probability\":{\"average\":0.976022,\"min\":0.807475,\"variance\":0.00298},\"location\":{\"height\":37,\"left\":1290,\"top\":1704,\"width\":227},\"word_name\":\"mvyh#13#zhye\",\"word\":\"方发生总额:15,34\"},{\"probability\":{\"average\":0.976022,\"min\":0.807475,\"variance\":0.00298},\"location\":{\"height\":37,\"left\":1523,\"top\":1704,\"width\":49},\"word_name\":\"mvyh#13#lsh\",\"word\":\"7.27\"},{\"probability\":{\"average\":0.964689,\"min\":0.56189,\"variance\":0.011409},\"location\":{\"height\":36,\"left\":1863,\"top\":1712,\"width\":52},\"word_name\":\"mvyh#13#dfzh\",\"word\":\"贷方\"},{\"probability\":{\"average\":0.964689,\"min\":0.56189,\"variance\":0.011409},\"location\":{\"height\":40,\"left\":1925,\"top\":1713,\"width\":266},\"word_name\":\"mvyh#13#dfhm\",\"word\":\"发生总额:10850.00\"},{\"probability\":{\"average\":0.0,\"min\":0.0,\"variance\":0.0},\"location\":{\"height\":0,\"left\":0,\"top\":0,\"width\":0},\"word_name\":\"mvyh#13#dfhgm\",\"word\":\"\"}],\"templateSign\":\"78f68d1de422bb4525f208691d84de79\",\"templateName\":\"msyh\",\"scores\":1.0,\"isStructured\":true,\"logId\":\"158649024352826\",\"templateMatchDegree\":1.0,\"clockwiseAngle\":0.0},\"error_code\":0,\"error_msg\":\"\",\"log_id\":\"158649024352826\"}\n";
        JSONObject jsonObject = new JSONObject(jsonRs);
        JSONObject data = (JSONObject) jsonObject.get("data");
        JSONArray ret = (JSONArray) data.get("ret");

        Map result = JSON.parseObject(data.toString(), Map.class);
        System.out.println("args = " + result);
        List<Map> retMap = JSON.parseArray(ret.toString(), Map.class);
        Map<String, Object> mapR = new HashMap<>();
        final boolean[] delete = { false };
        retMap.stream().forEach(m -> {
            if (m.get("word_name").equals("hffsze")) {
                delete[0] = true;
            } else {
                mapR.put(m.get("word_name").toString(), m.get("word"));
                System.out.println(m.get("word_name"));
                System.out.println(m.get("word"));
            }
        });

        Map<String, Map> mapResult = new HashMap<>();
        mapR.keySet().forEach(key -> {
            String line= key.substring(5, key.lastIndexOf("#"));
            Map child = mapResult.get(line);
            if (child == null){
                child = new HashMap();
                mapResult.put(line, child);
            }
            child.put(key.substring(key.lastIndexOf("#") + 1), mapR.get(key));
        });
        System.out.println("args = " + mapResult);
        List<Object> waitForRemovekey = new ArrayList<>();
        mapResult.keySet().forEach(key -> {
            System.out.println(key);
            Map<String ,Object> child = mapResult.get(key);
            if(StringUtils.isEmpty(child.get("jyrq"))) {
                waitForRemovekey.add(key);
            }
        });
        // 处理换行问题
        waitForRemovekey.forEach(key -> {
            if (delete[0] == false || (delete[0] == true && Integer.parseInt(key.toString()) != mapResult.size() -1)){
                int pre = Integer.parseInt(key.toString()) -1;
                Map<String, Object> preChild = mapResult.get(String.valueOf(pre));
                Map<String, Object> curChild = mapResult.get(key);
                StringBuffer buffer = new StringBuffer();
                if (!StringUtils.isEmpty(preChild.get("dfhgm"))) {
                    buffer.append(preChild.get("dfhgm"));
                }
                if (!StringUtils.isEmpty(curChild.get("dfhgm"))) {
                    buffer.append(curChild.get("dfhgm"));
                }
                preChild.put("dfhgm", buffer.toString());

            }
            mapResult.remove(key);
        });
        System.out.println("mapResult = " + mapResult);
        System.out.println("shanchujey:" + waitForRemovekey);



    }
}
