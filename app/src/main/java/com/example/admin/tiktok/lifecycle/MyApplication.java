package com.example.admin.tiktok.lifecycle;

import android.app.Application;

/**
 * Created by admin on 2019/1/19.
 */

public class MyApplication extends Application {

    String message;

    public MyApplication() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
