package com.hotella.backend.hotella.util;

import java.util.Random;

public class CodeGenerator {

    private static final Random random = new Random();
    private static final String CHARS = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ1234567890!@#$";

    private CodeGenerator() {

    }

    public String getToken() {
        StringBuilder token = new StringBuilder(7);
        for (int i = 0; i < 7; i++) {
            token.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return token.toString();
    }
}
