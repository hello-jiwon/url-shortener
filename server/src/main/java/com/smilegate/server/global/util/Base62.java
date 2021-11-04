package com.smilegate.server.global.util;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Component
public class Base62 implements EncoderUtil, DecoderUtil {

    private static final int BASE = 62;
    private static final char[] CODEC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final Map<Character, Integer> CODES = new HashMap<>();

    static {
        for(int i=0; i<BASE; i++){
            CODES.put(CODEC[i], i);
        }
    }


    @Override
    public String encode(String value){
        int target = Integer.parseInt(value);

        StringBuilder res = new StringBuilder("");
        while(target > 0){
            int remainder = target % BASE;
            res.append(CODEC[remainder]);
            target /= BASE;
        }

        return res.reverse().toString();
    }

    @Override
    public String decode(String value){
        ArrayList<Character> chars = new ArrayList<Character>();
        for (char c : value.toCharArray()) {
            chars.add(c);
        }

        Collections.reverse(chars);

        int res = 0;
        for(char c: chars){
            int num = CODES.get(c);
            res += num * BASE;
        }

        return String.valueOf(res);
    }
}
