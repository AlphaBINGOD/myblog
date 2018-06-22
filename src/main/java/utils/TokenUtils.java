package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

/**
 * @Author zsb@myblog
 * @Description: 生成session令牌,主要用于防止表单提交
 * @Modified By:
 * @Date 2018/6/13
 */
public class TokenUtils {

    /**
     *@Author: zsb
     *@Description: 获取一个令牌
     *@params:
     *@Date: 2018/6/13
    */
    public static String getToken(){
        //初始化一个
        String tokenStr = System.currentTimeMillis() + new Random().nextInt(999999) + "";
        String result = null;
        try {
            //使用md5加密
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            //更新摘要
            messageDigest.update(tokenStr.getBytes());
            //计算摘要
            byte token[] = messageDigest.digest();
            //将字节数据转换为字符串,base64就是一个字节转字符串的工具
            result = Base64.getEncoder().encodeToString(token);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }


}
