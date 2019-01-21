package com.supply.springboot.Utils;/**
 * 作者: Digest-ljh
 * 创建时间: 2018/12/26 10:11
 * 声明:
 */

import org.json.JSONException;
import org.json.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *@ClassName Digest
 *@Author Junlunet-ljh
 *@Date 2018/12/26 10:11
 *@Version 1.0
 **/

@Slf4j
public class Digest {
    /**加密信息
     * 一次编码      将在传入的map中添加AccessKeyId、Timestamp、Method、
     * @param urlObject      包含请求路径和post参数的对象         //注意不含?以及后的参数，例如"/v1/api/info"
     */
    public static String baseDigest(JSONObject urlObject){

        long nonce = System.currentTimeMillis();
        try {
            urlObject.put("nonce", Long.toString(nonce));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // payload = parameters-object -> JSON encode -> base64
        String payload = urlObject.toString();
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
            digest = hash.toString();
        } catch (UnsupportedEncodingException e) {
            log.debug("Bitfinex：创建签名异常", e.getMessage());
        } catch (InvalidKeyException e) {
            log.debug("Bitfinex：创建签名异常", e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            log.debug("Bitfinex：创建签名异常", e.getMessage());
        }
        return digest;
    }
}
