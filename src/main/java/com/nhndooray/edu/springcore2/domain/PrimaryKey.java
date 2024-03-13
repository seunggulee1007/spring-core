package com.nhndooray.edu.springcore2.domain;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PrimaryKey {

    private static final long EPOCH_MILLIS= 12623040000000L;
    private static final int TIMESTAMP_SHIFT = 23;
    private static SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final int MAX_RANDOM = 0x800000;

    public static Long generate() {
        long currTime = System.currentTimeMillis() - EPOCH_MILLIS;
        return (currTime << TIMESTAMP_SHIFT) + randomPadding();
    }

    private static int randomPadding() {
        return SECURE_RANDOM.nextInt(MAX_RANDOM);
    }
}
