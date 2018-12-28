package com.keguang.daily.json.analysis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * @version v1.0.0
 * @Author:keguang
 * @Date:2018/8/20 11:11
 */
public class Demo {
    public static void main(String[] args) throws IOException {

        String MSGTYPE = "install";

        String path = "data/json/hm2.file";
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        String tmpString = "";
        while ((tmpString = reader.readLine()) != null){
            JSONObject json = JSON.parseObject(tmpString);
            JSONObject message = JSON.parseObject(json.getString("message"));
            JSONObject decrypted_data = JSON.parseObject(message.getString("decrypted_data"));

            String msgtype = decrypted_data.getString("msgtype");
            if(MSGTYPE.equals(msgtype)) {
                JSONArray offer = JSON.parseArray(decrypted_data.getString("offer"));
                if (offer.size() > 0) {
                    System.out.println(offer);
                    JSONObject one = offer.getJSONObject(0);
                    System.out.println(one.getJSONArray("id"));
                    System.out.println("=======================");
                }
            }
        }
    }

}
