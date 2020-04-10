package com.bestvike.ocr.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by Liu qingxiang on 2020/4/10.
 */
@Service
public class BaiduAiService {

    /**
     * 拼接ocr识别图片换行情况.
     * @param mapResult             要返回的map结果
     * @param waitForRemovekey      判断出来的因换行新增的数据，jyrq字段位null或""
     * @param isDelete              判断最后一行是否为总金额,是则删除，否则为正常数据
     */
    public void joinField(Map<String, Map> mapResult, List<Object> waitForRemovekey, boolean isDelete) {
        waitForRemovekey.forEach(key -> {
            if (isDelete == false || (isDelete == true && Integer.parseInt(key.toString()) != mapResult.size() + 1)) {
                int pre = Integer.parseInt(key.toString()) - 1;
                Map<String, Object> preChild = mapResult.get(String.valueOf(pre));
                Map<String, Object> curChild = mapResult.get(key);
                StringBuffer buffer = new StringBuffer();;
                StringBuffer dfhmBuffer = new StringBuffer();
                StringBuffer zyBuffer = new StringBuffer();
                if (!StringUtils.isEmpty(preChild.get("zy"))) {
                    zyBuffer.append(preChild.get("zy"));
                }
                if (!StringUtils.isEmpty(curChild.get("zy"))) {
                    zyBuffer.append(curChild.get("zy"));
                }
                if (!StringUtils.isEmpty(preChild.get("dfhm"))) {
                    dfhmBuffer.append(preChild.get("dfhm"));
                }
                if (!StringUtils.isEmpty(curChild.get("dfhm"))) {
                    dfhmBuffer.append(curChild.get("dfhm"));
                }
                if (!StringUtils.isEmpty(preChild.get("dfhgm"))) {
                    buffer.append(preChild.get("dfhgm"));
                }
                if (!StringUtils.isEmpty(curChild.get("dfhgm"))) {
                    buffer.append(curChild.get("dfhgm"));
                }
                preChild.put("dfhgm", buffer.toString());
                preChild.put("dfhm", dfhmBuffer.toString());
                preChild.put("zy", zyBuffer.toString());
            }
        });
    }
}
