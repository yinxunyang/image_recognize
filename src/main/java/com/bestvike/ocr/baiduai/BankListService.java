package com.bestvike.ocr.baiduai;

import com.alibaba.fastjson.JSON;
import com.bestvike.ocr.service.BaiduAiService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liu qingxiang on 2020/4/10.
 */
@Service
@Slf4j
public class BankListService {

    @Autowired
    private BaiduAiService baiduAiService;

    public Map bankOcr(String url) {
        String jsonRs = baiduAiService.ocrForBank(url);
        if (jsonRs == null ) {
            throw new RuntimeException("ocr识别失败");
        }
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
            String line = key.substring(5, key.lastIndexOf("#"));
            Map child = mapResult.get(line);
            if (child == null) {
                child = new HashMap();
                mapResult.put(line, child);
            }
            child.put(key.substring(key.lastIndexOf("#") + 1), mapR.get(key));
        });
        List<Object> waitForRemovekey = new ArrayList<>();
        mapResult.keySet().forEach(key -> {
            System.out.println(key);
            Map<String, Object> child = mapResult.get(key);
            if (StringUtils.isEmpty(child.get("jyrq"))) {
                waitForRemovekey.add(key);
            }
        });
        // 处理最后一行为非流水数据问题
        if (delete[0]) {
            mapResult.remove(String.valueOf(mapResult.size()));
        }
        // 处理换行问题
        baiduAiService.joinField(mapResult, waitForRemovekey, delete[0]);

        waitForRemovekey.forEach(key -> {
            mapResult.remove(key);
        });
        log.debug("mapResult = " + mapResult);
        return mapResult;
    }

}
