package utils;

/**
 * @Author zsb@myblog
 * @Description:
 * @Modified By:
 * @Date 2018/6/13
 */
public class StringUtils {
    public static boolean strNotEmptyNotNull(String str){
        boolean result = true;
        if(str == null || str.equals("")){
            result = false;
        }
        return result;
    }
}
