package demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xk
 * @Date: 2018/8/16
 * @Version 1.0
 */
public class dateUtil {

    /**
     * 得到两个时间段字符串显示方式，如果是同一年，年份部分省略
     */
    public static String getFormatStrWithTwoDateIgnoreSameYear(Date date1, Date date2, String pattern, String seperator) {
        int date1Year = DateUtilt.getYear(date1);
        int date2Year = DateUtilt.getYear(date2);

        // 相同年份移除年
        if (date1Year == date2Year) {
            pattern = pattern.replace("yyyy/", "").replace("yyyy-", "").replace("yyyy", "");
        }

        return getFormatStrWithTwoDate(date1, date2, pattern, seperator);
    }

    /**
     * 得到两个时间段字符串显示方式
     */
    public static String getFormatStrWithTwoDate(Date date1, Date date2, String pattern, String seperator) {
        String date1Str = DateUtilt.toDateStrByCustomerFormatter(date1, pattern);
        String date2Str = DateUtilt.toDateStrByCustomerFormatter(date2, pattern);

        StringBuilder sb = new StringBuilder(100);
        sb.append(date1Str);
        sb.append(seperator);
        sb.append(date2Str);

        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate1 = dateFormat1.parse("2017-11-01");
        Date date1 = new Date();
        Date date2 = new Date();
        String str = getFormatStrWithTwoDateIgnoreSameYear(myDate1, date2, "yyyy/MM/dd", "--");
        System.out.println(str);

    }
}
