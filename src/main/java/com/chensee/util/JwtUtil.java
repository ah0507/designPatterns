package com.chensee.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import net.minidev.json.JSONObject;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 *  token的认证和生成
 */
public class JwtUtil {

    /**
     * 生成一个token
     * @param  payloadMap
     * @param secret 32位字母
     * @return
     */
    public static String creatToken(String secret,Map<String,Object> payloadMap) {
        byte[] secretBytes = secret.getBytes();
        /**
         * JWSHeader参数：1.加密算法法则,2.类型，3.。。。。。。。
         * 一般只需要传入加密算法法则就可以。
         * 这里则采用HS256
         *
         * JWSAlgorithm类里面有所有的加密算法法则，直接调用。
         */
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);

        //建立一个载荷Payload
        Payload payload = new Payload(new JSONObject(payloadMap));

        //将头部和载荷结合在一起
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        try {
            //建立一个密匙
            JWSSigner jwsSigner = new MACSigner(secretBytes);
            //签名
            jwsObject.sign(jwsSigner);
        } catch (JOSEException e) {
            e.printStackTrace();
        }

        //生成token
        return jwsObject.serialize();
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    public static Map<String,Object> valid(String secret,String token) {

        byte[] secretBytes = secret.getBytes();

        Map<String, Object> resultMap = new HashMap<>();

        try {
            //解析token
            JWSObject jwsObject = JWSObject.parse(token);

            //获取到载荷
            Payload payload=jwsObject.getPayload();

            //建立一个解锁密匙
            JWSVerifier jwsVerifier = new MACVerifier(secretBytes);

            //判断token
            if (jwsObject.verify(jwsVerifier)) {
                resultMap.put("Result", 0);
                //载荷的数据解析成json对象。
                JSONObject jsonObject = payload.toJSONObject();
                resultMap.put("data", jsonObject);

                //判断token是否过期
                if (jsonObject.containsKey("exp")) {
                    Long expTime = Long.valueOf(jsonObject.get("exp").toString());
                    Long nowTime = System.currentTimeMillis();
                    //判断是否过期
                    if (nowTime > expTime) {
                        //已经过期
                        resultMap.clear();
                        resultMap.put("Result", 2);
                    }
                }
            }else {
                resultMap.put("Result", 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return resultMap;

    }
}
