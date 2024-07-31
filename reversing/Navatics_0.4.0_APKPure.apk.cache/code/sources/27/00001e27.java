package com.senseplay.sdk.model.robot;

import android.util.Log;

/* loaded from: classes2.dex */
public class RobotFiFO {
    private static final int bufferSize = 2097152;
    private final String tag = "RobotFiFO";
    private byte[] buffer = new byte[2097152];
    private int size = 0;
    private int start = 0;

    public int getSize() {
        return this.size;
    }

    public void put(byte[] bArr) {
        int length = bArr.length;
        if (2097152 - this.size < length) {
            Log.w("RobotFiFO", "buffer is full");
            return;
        }
        System.arraycopy(bArr, 0, this.buffer, this.start, length);
        this.start += length;
        this.size = this.start;
    }

    public byte[] get() {
        return this.buffer;
    }

    public void clear() {
        this.start = 0;
        this.size = 0;
    }
}