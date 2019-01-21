package com.supply.springboot.Utils;/**
 * 作者: UUIDUtils-ljh
 * 创建时间: 2018/12/12 9:22
 * 声明:
 */

import org.json.JSONException;
import org.json.JSONObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *@ClassName UUIDUtils
 *@Author Junlunet-ljh
 *@Date 2018/12/12 9:22
 *@Version 1.0
 **/
public class UUIDUtils {
    /**加密信息
     * 一次编码      将在传入的map中添加AccessKeyId、Timestamp、Method、
     * @param apiKey       AppKeyId.
     * @param apiSecretKey AppKeySecret.
     * @param urlPath      请求路径，注意不含?以及后的参数，例如"/v1/api/info"
     */
    public String baseDigest(String apiKey, String apiSecretKey,String urlPath) throws IOException, JSONException {

        long nonce = System.currentTimeMillis();
        //必传的2个加密参数
        JSONObject jo = new JSONObject();
        jo.put("request", urlPath);
        jo.put("nonce", Long.toString(nonce));

        // payload = parameters-object -> JSON encode -> base64
        String payload = jo.toString();
        String payload_base64 = Base64.getEncoder().encodeToString(payload.getBytes()); //Base64加密

        return payload_base64;
    }

    /**创建签名
     * 二次编码使payload_base64实现algo的哈希（HMAC SHA384）sha384加密
     * @param msg           初步编码后的URL路径payload_base64
     * @param keyString     AppKeySecret.
     * @param algo          编码格式
     * @return
     */
    public static String hmacDigest(String msg, String keyString, String algo) {
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
            Mac mac = Mac.getInstance(algo);
            mac.init(key);

            byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));

            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString().substring(0,32);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return digest;
    }
}
