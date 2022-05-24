package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InfoFromApp extends AppCompatActivity {
    private String current_time;
    private String start_time;
    private String target;
    private String when;

    public InfoFromApp(String current_time, String start_time, String target, String when) {
        this.current_time = current_time;
        this.start_time = start_time;
        this.target = target;
        this.when = when;
    }

    public InfoFromApp() {

    }

    public String getCurrent_time() {
        return current_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getTarget() {
        return target;
    }

    public String getWhen() {
        return when;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setWhen(String when) {
        this.when = when;
    }
}