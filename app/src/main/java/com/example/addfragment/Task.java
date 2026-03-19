package com.example.addfragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Spinner;

import androidx.annotation.NonNull;


/*
* Parcel
* Onclick for task in all fragment
* */


public class Task implements Parcelable {
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

    protected Task(Parcel in) {
        title = in.readString();
        des = in.readString();
        start = in.readString();
        end = in.readString();
        dur = in.readString();
        color = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(des);
        dest.writeString(start);
        dest.writeString(end);
        dest.writeString(dur);
        dest.writeString(color);
    }


}





