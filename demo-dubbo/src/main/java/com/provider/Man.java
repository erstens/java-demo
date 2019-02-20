package com.provider;

import com.consumer.Body;

public class Man implements Body {
    public String sex() {
        return "man";
    }

    public void voidFunc() {

    }

    public Women women(Women m) {
        return m;
    }
}
