package com.young.demo.util;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class SnowFlake {
    /**
     * 起始的时间戳，基于秒（原版基于毫秒）.
     */
    private final static long START_SECONDS = 1597979276L;

    /**
     * 每一部分占用的位数.
     */
    //序列号占用的位数
    private final static long SEQUENCE_BIT = 16;
    //机器标识占用的位数
    private final static long MACHINE_BIT = 5;

    /**
     * 每一部分的最大值.
     */
    private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移.
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long TIME_LEFT = MACHINE_LEFT + MACHINE_BIT;
    //机器标识
    private long machineId;
    //序列号
    private long sequence;
    //上一次时间戳
    private long lastSeconds = -1L;

    public SnowFlake() {
        this(1);
    }

    public SnowFlake(long machineId) {
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.machineId = machineId;
    }

    /**
     * 产生下一个ID.
     */
    public synchronized long nextId() {
        long currSeconds = getNewSeconds();
        if (currSeconds < lastSeconds) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currSeconds == lastSeconds) {
            //相同秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一秒的序列数已经达到最大
            if (sequence == 0L) {
                currSeconds = getNextSeconds();
            }
        } else {
            //不同秒内，序列号置为0
            sequence = 0L;
        }

        lastSeconds = currSeconds;

        return (currSeconds - START_SECONDS) << TIME_LEFT
                | machineId << MACHINE_LEFT
                | sequence;
    }

    private long getNextSeconds() {
        long seconds = getNewSeconds();
        while (seconds <= lastSeconds) {
            seconds = getNewSeconds();
        }
        return seconds;
    }

    private long getNewSeconds() {
        return Instant.now().getEpochSecond();
    }
}
