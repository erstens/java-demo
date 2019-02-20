package com.demo.entity;

import java.util.HashMap;
import java.util.Map;

public class ObjectBig {
    private static Map m = new HashMap<String, String>();
    static {
        for (int i = 0; i < 100000 ; i++) {
            m.put(i + "", i);
        }
    }
}
