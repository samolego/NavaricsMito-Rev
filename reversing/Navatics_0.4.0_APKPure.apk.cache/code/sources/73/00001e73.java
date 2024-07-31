package com.senseplay.sdk.video;

import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
public class CircularBuffer<T> {
    private Object[] buffer;
    private int capacity;
    private int indexForPut = 0;
    private int indexForGet = 0;
    private ThreadState putThreadState = ThreadState.RUNNING;
    private ThreadState getThreadState = ThreadState.RUNNING;
    LinkedHashMap<Integer, String> msgs = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum ThreadState {
        BLOCK,
        RUNNING,
        OVER,
        INTERRUPT
    }

    public CircularBuffer(int i) {
        this.buffer = null;
        this.capacity = 0;
        this.capacity = i;
        this.buffer = new String[this.capacity];
    }

    public void putElement(T t) {
        while (this.buffer[this.indexForPut] != null) {
            try {
                setPutThreadState(ThreadState.BLOCK);
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("线程意外停止,正在检查");
            }
        }
        setPutThreadState(ThreadState.RUNNING);
        Object[] objArr = this.buffer;
        int i = this.indexForPut;
        objArr[i] = t;
        this.indexForPut = i + 1;
        this.indexForPut %= this.capacity;
    }

    public T getElement() {
        while (this.buffer[this.indexForGet] == null) {
            try {
                setGetThreadState(ThreadState.BLOCK);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("线程意外停止");
            }
            if (isPutedOver() && isEmputy()) {
                setGetThreadState(ThreadState.OVER);
                return null;
            }
            Thread.sleep(100L);
        }
        setGetThreadState(ThreadState.RUNNING);
        Object[] objArr = this.buffer;
        int i = this.indexForGet;
        T t = (T) objArr[i];
        objArr[i] = null;
        this.indexForGet = i + 1;
        this.indexForGet %= this.capacity;
        return t;
    }

    public boolean isEmputy() {
        for (int length = this.buffer.length - 1; length > 0; length--) {
            if (this.buffer[length] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean isAllBlock() {
        return this.getThreadState == ThreadState.BLOCK && this.putThreadState == ThreadState.BLOCK;
    }

    public boolean isPutedOver() {
        return this.putThreadState == ThreadState.OVER;
    }

    public void setPutThreadState(ThreadState threadState) {
        this.putThreadState = threadState;
    }

    private void setGetThreadState(ThreadState threadState) {
        this.getThreadState = threadState;
    }
}