package com.senseplay.sdk.model.ota;

/* loaded from: classes2.dex */
public class FileInfo {
    private String filePath;
    private long file_size;
    private String md5sum;

    public long getFile_size() {
        return this.file_size;
    }

    public void setFile_size(long j) {
        this.file_size = j;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public String getMd5sum() {
        return this.md5sum;
    }

    public void setMd5sum(String str) {
        this.md5sum = str;
    }
}