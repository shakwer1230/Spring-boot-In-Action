package com.sun.jsp.utils;

import lombok.val;
import org.apache.tomcat.util.codec.binary.Base64;




import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.Charset;

/**
 * @author: 陈海涛
 * @date: 2017/11/22 16:59
 * @version: 1.0
 */
public class DesUtil {
    public static String bytes2hex(byte[] bytes)
    {
        final String HEX = "0123456789abcdef";
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes)
        {
            // 取出这个字节的高4位，然后与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
            sb.append(HEX.charAt((b >> 4) & 0x0f));
            // 取出这个字节的低位，与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
            sb.append(HEX.charAt(b & 0x0f));
        }

        return sb.toString();
    }
    public static byte[] encoder(byte[] sourceData, String password) {
        try {

            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            IvParameterSpec iv = new IvParameterSpec(password.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);

            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, securekey,iv);
            return cipher.doFinal(sourceData);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String encoderStringToHexString(String sourceData, String password,Charset charsetset) {
        val data=encoder(sourceData.getBytes(charsetset),password);
        if(data==null)
        {
            return null;
        }
        return bytes2hex(data);
    }

    public static String encoderStringToHexString(String sourceData, String password) {

       return encoderStringToHexString(sourceData,password,Charset.forName("utf-8"));
    }

    /**
     * 解密数据
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static String decrypt(String message, String key) throws Exception {

        byte[] bytesrc = convertHexString(message);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

        byte[] retByte = cipher.doFinal(bytesrc);
        return new String(retByte);
    }

    /**
     * 加密数据
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(String message, String key) throws Exception {

        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        return cipher.doFinal(message.getBytes("UTF-8"));
    }
    public static byte[] convertHexString(String ss) {
        byte digest[] = new byte[ss.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte) byteValue;
        }

        return digest;
    }

    public static String toHexString(byte b[]) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String plainText = Integer.toHexString(0xff & b[i]);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }

        return hexString.toString().toUpperCase();
    }

    /**
     * 进行base64编码
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBase64(String data, String key) throws Exception{
        byte[] bt = encrypt(data,key);

        String strs = Base64.encodeBase64String(bt);
        return strs;
    }
    public static String encryptBase64ToHexString(String data, String key) throws Exception{
        byte[] bt = encrypt(data,key);
        String strs = Base64.encodeBase64String(bt);
        if(strs==null)
        {
            return null;
        }
        return toHexString(strs.getBytes(Charset.forName("utf-8")));
    }


}
