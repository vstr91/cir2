package br.com.vostre.circular.utils;

import android.arch.persistence.room.TypeConverter;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Almir on 02/01/2018.
 */

public class Converters {
    @TypeConverter
    public static Calendar fromTimestamp(Long value) {

        if(value != null){
            Date date = new Date(value);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            return calendar;
        } else{
            return null;
        }

    }

    @TypeConverter
    public static Long dateToTimestamp(Calendar calendar) {
        return calendar == null ? null : calendar.getTime().getTime();
    }
}