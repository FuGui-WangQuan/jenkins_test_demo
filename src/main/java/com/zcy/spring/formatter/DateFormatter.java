package com.zcy.spring.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        return simpleDateFormat.parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        return simpleDateFormat.format(date);
    }
}
