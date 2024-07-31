package com.common;

/* loaded from: classes.dex */
public class VIDEO_PARAM {
    public byte VideoDpiFps;
    public short VideoDpiHeight;
    public short VideoDpiLength;
    public byte VideoMode;

    public void fill(byte b, short s, short s2, byte b2) {
        this.VideoMode = b;
        this.VideoDpiLength = s;
        this.VideoDpiHeight = s2;
        this.VideoDpiFps = b2;
    }

    public String toString() {
        return "VIDEO_PARAM{VideoMode=" + ((int) this.VideoMode) + ", VideoDpiLength=" + ((int) this.VideoDpiLength) + ", VideoDpiHeight=" + ((int) this.VideoDpiHeight) + ", VideoDpiFps=" + ((int) this.VideoDpiFps) + '}';
    }
}
