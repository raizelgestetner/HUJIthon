package com.example.myapplication;

public class Helper {
    int target;
    String when;

    public Helper(int target, String when) {
        this.target = target;
        this.when = when;
    }

    public Helper() {
    }

    public int getTarget() {
        return target;
    }

    public String getWhen() {
        return when;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void setWhen(String when) {
        this.when = when;
    }
}
