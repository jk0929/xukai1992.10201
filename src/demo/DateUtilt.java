package demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xk
 * @Date: 2018/8/16
 * @Version 1.0
 */
public class DateUtilt {

    private static final Map<String, SimpleDateFormat> CUSTOM_DATE_FORMATTER_MAP = new ConcurrentHashMap<String, SimpleDateFormat>();
    /**
     * 获取当前时间对应的年份
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.YEAR);
    }

//     * 使用自定义的格式将Date转换为字符串
//	 */
    public static String toDateStrByCustomerFormatter(Date date, String formatter) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat sdf = CUSTOM_DATE_FORMATTER_MAP.get(formatter);
        if (sdf == null) {
            sdf = new SimpleDateFormat(formatter);
            CUSTOM_DATE_FORMATTER_MAP.put(formatter, sdf);
        }

        return sdf.format(date);
    }

}
