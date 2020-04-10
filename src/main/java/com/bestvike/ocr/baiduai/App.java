package com.bestvike.ocr.baiduai;

import java.net.URLEncoder;

public class App
{
    public static void main(String[] args) throws Exception
    {
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
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            // 请求模板参数
            String recogniseParams = "templateSign=78f68d1de422bb4525f208691d84de79&image=" + URLEncoder.encode(imgStr, "UTF-8");
            // 请求分类器参数
            String classifierParams = "classifierId=1&image=" + URLEncoder.encode(imgStr, "UTF-8");


            String accessToken = AuthService.getAuth();
            // 请求模板识别
            String result = HttpUtil.post(recogniseUrl, accessToken, recogniseParams);
            // 请求分类器识别
            // String result = HttpUtil.post(recogniseUrl, accessToken, classifierParams);

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}