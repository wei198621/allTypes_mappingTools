package com.tz.leo.CglibBeanCopier02withConvert.converters;

import net.sf.cglib.core.Converter;
//import org.springframework.cglib.core.Converter;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: tz_wl
 * Date: 2020/8/12 18:47
 * Content:
 */
public class AccountConverter implements Converter {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    @SuppressWarnings("rawtypes")
    public Object convert(Object source, Class target, Object context) {
        if (source instanceof Integer) {
            return (Integer) source;
        } else if (source instanceof Date) {
            Date date = (Date) source;
            return sdf.format(date);
        } else if (source instanceof BigDecimal) {
            BigDecimal bd = (BigDecimal) source;
            return bd.toPlainString();
        }
        return null;
    }
}
