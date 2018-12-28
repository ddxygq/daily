package com.keguang.daily.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author haisong
 * @create 2018/10/11 10:36
 */
@Slf4j
public class DayUtil {


    /**
     * 获取当前时间多少天之后的数据 并格式化
     * @param date
     * @param step
     * @param toFormat
     * @return
     */
    public static String getDayDelayFormat(Date date,int step,String toFormat){
        String result = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR,step);
        Date resultdate = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(toFormat);
        try {
            result = sdf.format(resultdate);
        }catch (Exception e){
            log.error("formatTime error date ->{} toFormat ->{}",new Object[]{resultdate,toFormat});
        }
        return result;
    }


    public static Date getDayDelay(Date date,int step){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR,step);
        Date resultdate = calendar.getTime();
        return resultdate;
    }

    public static Date getMonthDelay(Date date,int step){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,step);
        Date resultdate = calendar.getTime();
        return resultdate;
    }

    public static String getDayFormat(Date date,String toFormat){
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat(toFormat);
        try {
            result = sdf.format(date);
        }catch (Exception e){
            log.error("formatTime error date ->{} toFormat ->{}",new Object[]{date,toFormat});
        }
        return result;
    }


    /**
     * 获取当前月 step 下的 月的第一天数据
     * @param date 当前天
     * @param step 间隔数
     * @param step 天间隔数
     * @param toFormat 格式化格式
     * @return
     */
    public static String getMonthFormat(Date date,int step ,String toFormat){
        return getMonthFormatWithDay(date,step,0,toFormat);
    }

    /**
     * 获取当前月 step 下的 月的第一天数据
     * @param date 当前天
     * @param step 间隔数
     * @param step 天间隔数
     * @param toFormat 格式化格式
     * @return
     */
    public static String getMonthFormatWithDay(Date date,int step ,int daystep,String toFormat){
        String result = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,step);
        calendar.add(Calendar.DAY_OF_YEAR,daystep);
        Date resultdate = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(toFormat);
        try {
            result = sdf.format(resultdate);
        }catch (Exception e){
            log.error("formatTime error date ->{} toFormat ->{}",new Object[]{resultdate,toFormat});
        }
        return result;
    }


    public static Date getDateFormat(String dateStr,String pattern) throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
         return simpleDateFormat.parse(dateStr);

    }

}
