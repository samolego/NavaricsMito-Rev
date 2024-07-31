package com.senseplay.sdk.model.robot;

import java.util.LinkedList;

/* loaded from: classes2.dex */
public class QueueBuffer extends Thread {
    private LinkedList<byte[]> list = new LinkedList<>();

    public void clear() {
        this.list.clear();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void addQueue(byte[] bArr) {
        this.list.addLast(bArr);
    }

    public byte[] deQueue() {
        if (this.list.isEmpty()) {
            return null;
        }
        return this.list.removeFirst();
    }

    public int size() {
        return this.list.size();
    }

    public Object queuePeek() {
        return this.list.getFirst();
    }
}