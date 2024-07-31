package com.senseplay.sdk.model.robot;

import android.util.Log;

/* loaded from: classes2.dex */
public class RobotFiFoOld {
    private static final int MAX_SIZE = 1048576;
    private static final String TAG = "RoundQueue";
    private int PUT = 512;
    private int GET = 320;
    private int readIndex = 0;
    private int writeIndex = 0;
    public byte[] buffer = new byte[1048576];
    private int size = 0;

    private boolean isFull() {
        return 1048576 - this.size < this.PUT;
    }

    private boolean isEmpty() {
        return this.size < this.GET;
    }

    public synchronized boolean putData(byte[] bArr) {
        if (!isFull()) {
            this.PUT = bArr.length;
            System.arraycopy(bArr, 0, this.buffer, this.writeIndex, bArr.length);
            this.writeIndex = (this.writeIndex + this.PUT) % 1048576;
            this.size += this.PUT;
            return true;
        }
        Log.e(TAG, "Buffer is not enough readIndex = " + this.readIndex + ",writeIndex = " + this.writeIndex);
        return false;
    }

    public synchronized boolean getData(byte[] bArr) {
        if (!isEmpty()) {
            this.GET = bArr.length;
            System.arraycopy(this.buffer, this.readIndex, bArr, 0, bArr.length);
            this.readIndex = (this.readIndex + this.GET) % 1048576;
            this.size -= this.GET;
            return true;
        }
        Log.e(TAG, "Buffer is empty readIndex = " + this.readIndex + ",writeIndex = " + this.writeIndex);
        return false;
    }

    public int getSize() {
        return this.size;
    }

    public synchronized void clear() {
        this.writeIndex = 0;
        this.readIndex = 0;
        this.size = 0;
    }
}