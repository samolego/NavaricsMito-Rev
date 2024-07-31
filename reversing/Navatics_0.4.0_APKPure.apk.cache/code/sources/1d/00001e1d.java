package com.senseplay.sdk.model.ota;

import java.util.List;

/* loaded from: classes2.dex */
public class VersionInfo {
    private String alt_style;
    private String auto_download;
    private int code;
    private String endVer;
    private String entirety;
    private List<FileInfo> files;
    private String message;
    private String necessary;
    private String release_note;
    private String startVer;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getAuto_download() {
        return this.auto_download;
    }

    public void setAuto_download(String str) {
        this.auto_download = str;
    }

    public String getAlt_style() {
        return this.alt_style;
    }

    public void setAlt_style(String str) {
        this.alt_style = str;
    }

    public String getStartVer() {
        return this.startVer;
    }

    public void setStartVer(String str) {
        this.startVer = str;
    }

    public String getEndVer() {
        return this.endVer;
    }

    public void setEndVer(String str) {
        this.endVer = str;
    }

    public String getEntirety() {
        return this.entirety;
    }

    public void setEntirety(String str) {
        this.entirety = str;
    }

    public String getNecessary() {
        return this.necessary;
    }

    public void setNecessary(String str) {
        this.necessary = str;
    }

    public String getRelease_note() {
        return this.release_note;
    }

    public void setRelease_note(String str) {
        this.release_note = str;
    }

    public List<FileInfo> getFiles() {
        return this.files;
    }

    public void setFiles(List<FileInfo> list) {
        this.files = list;
    }
}