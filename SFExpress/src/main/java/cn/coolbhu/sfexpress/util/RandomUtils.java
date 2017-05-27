package cn.coolbhu.sfexpress.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by brainy on 17-5-27.
 */
public class RandomUtils {

    /**
     *
     */
    public static final SimpleDateFormat sdf = new SimpleDateFormat("HHmmssSSS");

    public static final Random random = new Random();

    public static String randomId10() {

        String preStr = sdf.format(new Date());

        int subStr = Math.abs(random.nextInt()) % 10;
        return preStr + subStr;
    }
}
