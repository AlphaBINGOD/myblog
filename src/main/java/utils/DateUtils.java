package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author zsb@myblog
 * @Description: 日期工具类
 * @Modified By:
 * @Date 2018/6/14
 */
public class DateUtils {
    public static String now(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
