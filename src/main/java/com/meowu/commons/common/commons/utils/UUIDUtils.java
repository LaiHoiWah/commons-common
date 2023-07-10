package com.meowu.commons.common.commons.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class UUIDUtils{

    private UUIDUtils(){
        throw new IllegalStateException("Instantiation is not allowed");
    }

    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String random(){
        SecureRandom secureRandom = new SecureRandom();
        byte[] seed = new byte[8];
        secureRandom.nextBytes(seed);

        Random random = new Random((new BigInteger(seed)).longValue());
        byte[] randomBytes = new byte[16];
        long   mostSigBits = 0L;
        random.nextBytes(randomBytes);

        for(int i = 0; i < 8; ++i){
            mostSigBits = mostSigBits << 8 | (long) (randomBytes[i] & 255);
        }

        long leastSigBits = 0L;
        for(int i = 8; i < 16; ++i){
            leastSigBits = leastSigBits << 8 | (long) (randomBytes[i] & 255);
        }

        return new UUID(mostSigBits, leastSigBits).toString().replaceAll("-", "");
    }
}
