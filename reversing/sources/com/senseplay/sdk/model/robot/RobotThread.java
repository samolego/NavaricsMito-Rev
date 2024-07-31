package com.senseplay.sdk.model.robot;

import android.util.Log;
import com.senseplay.sdk.tool.UTool;

/* loaded from: classes2.dex */
public class RobotThread extends Thread {
    private boolean flag;
    private RobotListener robotListener;
    private final String tag = "RobotThread";
    private final int dataSize = 4096;
    private QueueBuffer queueBuffer = new QueueBuffer();
    private RobotFiFO robotFiFO = new RobotFiFO();

    /* loaded from: classes2.dex */
    public interface RobotListener {
        void arData(byte[] bArr);
    }

    public RobotThread() {
        this.flag = false;
        this.flag = true;
    }

    public void setRobotListener(RobotListener robotListener) {
        this.robotListener = robotListener;
    }

    public void addData(byte[] bArr) {
        this.queueBuffer.addQueue(bArr);
    }

    private void search() {
        int size = this.robotFiFO.getSize();
        byte[] bArr = this.robotFiFO.get();
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            if (i2 >= size) {
                return;
            }
            if (bArr[i] == -11 && bArr[i2] == -86) {
                byte[] bArr2 = new byte[4];
                int i3 = i + 2;
                System.arraycopy(bArr, i3, bArr2, 0, bArr2.length);
                byte[] bArr3 = new byte[2];
                System.arraycopy(bArr, i + 6, bArr3, 0, bArr3.length);
                int byteToInt = UTool.byteToInt(bArr2);
                byte[] bArr4 = new byte[byteToInt - 6];
                System.arraycopy(bArr, i + 12, bArr4, 0, bArr4.length);
                putData(bArr4);
                int i4 = i3 + byteToInt;
                int i5 = i4 + 2;
                int i6 = (size - i4) - 4;
                if (i5 <= size) {
                    byte[] bArr5 = new byte[i6];
                    System.arraycopy(bArr, i5, bArr5, 0, bArr5.length);
                    this.robotFiFO.clear();
                    this.robotFiFO.put(bArr5);
                } else {
                    this.robotFiFO.clear();
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.w("datatime", "data time " + (currentTimeMillis2 - currentTimeMillis));
                return;
            }
            i = i2;
        }
    }

    public void putData(byte[] bArr) {
        RobotListener robotListener = this.robotListener;
        if (robotListener != null) {
            robotListener.arData(bArr);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        byte[] deQueue;
        while (this.flag) {
            try {
                if (!this.queueBuffer.isEmpty() && (deQueue = this.queueBuffer.deQueue()) != null && deQueue.length > 0) {
                    this.robotFiFO.put(deQueue);
                    Log.w("time", "robotFiFO.getSize() " + this.robotFiFO.getSize());
                    if (this.robotFiFO.getSize() >= 4096) {
                        search();
                    }
                }
                sleep(10L);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void release() {
        this.flag = false;
    }
}
