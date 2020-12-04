package until;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateUtil
 * @Description: TODO
 * @Author: lk
 * @date: 2020/12/3 16:18
 * @Version: V1.0
 */
public class DateUtil {
    public static Date stringToDate(String pattern,String str){
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        try {
            return  sf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String dateToString(String pattern,Date date){
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.format(date);
    }
}