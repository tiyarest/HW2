package com.example.admin.tiktok.chat;

/**
 * Created by admin on 2019/1/19.
 */

public class chatMessage {
    //1:time
    //2:my
    //3:your
    private int tpye;
    private String content;
    private String icon;
    private String time;

    public chatMessage(int tpye) {
        this.tpye = tpye;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTpye() {
        return tpye;
    }

    public void setTpye(int tpye) {
        this.tpye = tpye;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
