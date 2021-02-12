package com.arthur.dataformat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @title: SimpleDataFormat
 * @Author ArthurJi
 * @Date: 2020/12/25 10:04
 * @Version 1.0
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDataFormat = new SimpleDateFormat("w");
        String format = simpleDataFormat.format(date);
        System.out.println(format);

    }
}
