package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int numberInt = 789;
        long numberLong = 78;
        double numberDouble = 231.6;
        float numberFloat = 77.7f;
        boolean flag = true;
        byte numberByte = 16;
        short numberShort = 4589;
        char character = 'a';

        LOG.info("Output of variable : {}", numberByte);
        LOG.info("Output of variable : {}", numberShort);
        LOG.info("Output of variable : {}", numberInt);
        LOG.info("Output of variable : {}", numberLong);
        LOG.info("Output of variable : {}", numberFloat);
        LOG.info("Output of variable : {}", numberDouble);
        LOG.info("Output of variable : {}", flag);
        LOG.info("Output of variable : {}", character);
    }
}
