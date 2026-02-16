package com.example.addfragment;

import android.widget.Spinner;

public class Task {
    private String title;
    private String des;
    private String start;
    private String end;
    private String dur;
    private String color;


    public Task() {
    }

    public Task(String title, String des, String start, String end, String dur, String color) {
        this.title = title;
        this.des = des;
        this.start = start;
        this.end = end;
        this.dur = dur;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDur() {
        return dur;
    }

    public void setDur(String dur) {
        this.dur = dur;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", dur='" + dur + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}





