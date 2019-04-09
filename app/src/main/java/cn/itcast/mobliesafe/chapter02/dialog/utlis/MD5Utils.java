package cn.itcast.mobliesafe.chapter02.dialog.utlis;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2019/3/19.
 */

public class MD5Utils {
    public static String encode(String text){
        try {
            MessageDigest digest=MessageDigest.getInstance("md5");
            byte[] result=digest.digest(text.getBytes());//对text进行加密全放在result
            StringBuffer sb =new StringBuffer();
            for (byte b:result){ //二目运算
                int number=b & 0xff;//余的运算 byte 8位 int32位
                String hex=Integer.toHexString(number); //强制转换
                if (hex.length()==1){
                    sb.append("0"+hex);
                }else {
                    sb.append(hex);
                }
            }
            return sb.toString(); //加密结果
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return " ";//返回空值
        }
    }
}
