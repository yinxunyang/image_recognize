package com.bestvike.ocr.service;

import com.bestvike.ocr.baiduai.AuthService;
import com.bestvike.ocr.baiduai.Base64Util;
import com.bestvike.ocr.baiduai.FileUtil;
import com.bestvike.ocr.baiduai.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created by Liu qingxiang on 2020/4/10.
 */
@Service
@Slf4j
public class BaiduAiService {

    /**
     * 拼接ocr识别图片中单字段文字换行情况.
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

    public String ocrForBank(byte[] imageBytes) {
        /**
         * 重要提示代码中所需工具类
         * FileUtil,Base64Util,HttpUtil,GsonUtils请从
         * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
         * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
         * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
         * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
         * 下载
         */
        // iocr识别apiUrl
        String recogniseUrl = "https://aip.baidubce.com/rest/2.0/solution/v1/iocr/recognise";


        String filePath = "C:\\Users\\Administrator\\Desktop\\高拍仪拍照\\ces.jpg";
        try {
            // byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imageBytes);
            // 请求模板参数
            String recogniseParams = "templateSign=78f68d1de422bb4525f208691d84de79&image=" + URLEncoder
                    .encode(imgStr, "UTF-8");
            // 请求分类器参数
            String classifierParams = "classifierId=1&image=" + URLEncoder.encode(imgStr, "UTF-8");


            String accessToken = AuthService.getAuth();
            // 请求模板识别
            String result = HttpUtil.post(recogniseUrl, accessToken, recogniseParams);
            // 请求分类器识别
            // String result = HttpUtil.post(recogniseUrl, accessToken, classifierParams);
            log.debug(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
