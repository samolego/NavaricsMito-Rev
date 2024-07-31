package com.navatics.common.base;

import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class DiveLog {
    int averageDepth;
    String comment;
    Date diveDate;
    String divePlace;
    String email;
    long endTime;
    List<DiveLogEntry> entries;
    String latitude;
    String longitude;
    int maxDepth;
    int source;
    long startTime;
    int temperature;
    long timeZoneOffset;
    String weather;

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public int getAverageDepth() {
        return this.averageDepth;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setMaxDepth(int i) {
        this.maxDepth = i;
    }

    public void setAverageDepth(int i) {
        this.averageDepth = i;
    }

    public List<DiveLogEntry> getEntries() {
        return this.entries;
    }

    public void setEntries(List<DiveLogEntry> list) {
        this.entries = list;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public void setTemperature(int i) {
        this.temperature = i;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getDivePlace() {
        return this.divePlace;
    }

    public void setDivePlace(String str) {
        this.divePlace = str;
    }

    public Date getDiveDate() {
        return this.diveDate;
    }

    public void setDiveDate(Date date) {
        this.diveDate = date;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public String getWeather() {
        return this.weather;
    }

    public void setWeather(String str) {
        this.weather = str;
    }

    public long getTimeZoneOffset() {
        return this.timeZoneOffset;
    }

    public void setTimeZoneOffset(long j) {
        this.timeZoneOffset = j;
    }

    public int getSource() {
        return this.source;
    }

    public void setSource(int i) {
        this.source = i;
    }
}
