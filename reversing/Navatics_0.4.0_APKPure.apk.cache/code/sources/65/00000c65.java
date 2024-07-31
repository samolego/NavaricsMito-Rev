package com.example.divelog.dao.entity;

import com.navatics.robot.utils.StringUtils;
import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class BaseDiveLogInfo implements Serializable {
    int averageDepth;
    String comment;
    Date diveDate;
    String divePlace;
    String email;
    long endTime;

    /* renamed from: id */
    long f1417id;
    String latitude;
    String longitude;
    int maxDepth;
    int maxTemp;
    int minDepth;
    int minTemp;
    int source;
    long startTime;
    int status;
    int temperature;
    long timeZoneOffset;
    boolean uploaded;
    String weather;

    public long getId() {
        return this.f1417id;
    }

    public void setId(long j) {
        this.f1417id = j;
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

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public int getAverageDepth() {
        return this.averageDepth;
    }

    public void setAverageDepth(int i) {
        this.averageDepth = i;
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

    public boolean isUploaded() {
        return this.uploaded;
    }

    public void setUploaded(boolean z) {
        this.uploaded = z;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public void setMaxDepth(int i) {
        this.maxDepth = i;
    }

    public int getMinDepth() {
        return this.minDepth;
    }

    public void setMinDepth(int i) {
        this.minDepth = i;
    }

    public int getMaxTemp() {
        return this.maxTemp;
    }

    public void setMaxTemp(int i) {
        this.maxTemp = i;
    }

    public int getMinTemp() {
        return this.minTemp;
    }

    public void setMinTemp(int i) {
        this.minTemp = i;
    }

    public void update(BaseDiveLogInfo baseDiveLogInfo) {
        if (baseDiveLogInfo != null) {
            if (!StringUtils.isEmpty((CharSequence) baseDiveLogInfo.getWeather())) {
                this.weather = baseDiveLogInfo.getWeather();
            }
            if (baseDiveLogInfo.getMaxDepth() != 0) {
                this.maxDepth = baseDiveLogInfo.getMaxDepth();
            }
        }
    }
}