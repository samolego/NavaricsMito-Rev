package com.navatics.cv;

import org.opencv.core.Mat;

/* loaded from: classes.dex */
public class NavaticsFilter {
    private String name;

    public static native long _native_process(String str, long j);

    public NavaticsFilter(String str) {
        this.name = str;
    }

    public Mat process(Mat mat) {
        long _native_process = _native_process(this.name, mat.m12531j());
        if (_native_process == -1) {
            return null;
        }
        return new Mat(_native_process);
    }

    public String getName() {
        return this.name;
    }
}