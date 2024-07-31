package com.senseplay.sdk.video.host;

import java.nio.ByteBuffer;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class SyncFrame {
    private static Object lockObjectQueue = new Object();
    ByteBuffer byteBuffer;
    byte discard;
    private LinkedList<SyncFrame> frameBufferSyncQueue = new LinkedList<>();
    long timeStamp;

    public SyncFrame() {
        this.discard = (byte) 0;
        this.discard = (byte) 0;
    }

    public void pushSyncFrameBuffer(SyncFrame syncFrame) {
        try {
            synchronized (lockObjectQueue) {
                this.frameBufferSyncQueue.add(syncFrame);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasSyncFrameBuffer() {
        boolean z;
        synchronized (lockObjectQueue) {
            z = !this.frameBufferSyncQueue.isEmpty();
        }
        return z;
    }

    public int syncFrameBufferSzie() {
        return this.frameBufferSyncQueue.size();
    }

    public SyncFrame dequeueSyncFrameBuffer() {
        SyncFrame removeFirst;
        synchronized (lockObjectQueue) {
            removeFirst = this.frameBufferSyncQueue.removeFirst();
        }
        return removeFirst;
    }
}