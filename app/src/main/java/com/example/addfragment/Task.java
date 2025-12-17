package com.example.addfragment;

public class Task {
    private String title;
    private String des;
    private String start;
    private String end;
    private String dur;

    @Override
    public String toString() {
        return "Task{" +
                "des='" + des + '\'' +
                ", title='" + title + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", dur='" + dur + '\'' +
                '}';
    }

    public String getDur() {
        return dur;
    }

    public void setDur(String dur) {
        this.dur = dur;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Task(String title, String des,String start,String end, String dur) {
        this.title = title;
        this.des = des;
        this.start = start;
        this.end = end;
        this.dur = dur;
    }
}
