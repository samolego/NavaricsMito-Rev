package com.senseplay.sdk.video;

import android.util.Log;
import com.common.AUTOMATIVE_LIGHT;
import java.nio.ByteBuffer;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class VideoFrameFIFO extends Thread {
    private int playType;
    private String TAG = "VideoFrameFIFO";
    byte[] sps1 = {0, 0, 0, 1, 103, 77, 0, 40, -12, 3, AUTOMATIVE_LIGHT.FLICKER, 17, 63, 46, 2, 32, 0, 0, 3, 0, 32, 0, 0, 7, -127, -29, 6, 84};
    byte[] sps2 = {0, 0, 0, 1, 103, 77, 0, 40, -12, 2, AUTOMATIVE_LIGHT.OVERTURN, 45, -40, 8, AUTOMATIVE_LIGHT.OVERTURN, 0, 0, 3, 0, AUTOMATIVE_LIGHT.OVERTURN, 0, 0, 30, 7, -116, 25, 80};
    byte[] sps3 = {0, 0, 0, 1, 103, 77, 0, 40, -12, 5, -95, -19, AUTOMATIVE_LIGHT.OVERTURN, -120, 0, 0, 3, 0, 8, 0, 0, 3, 1, -32, 120, -63, -107};
    ByteBuffer byteBuffer = null;
    byte[] dataa = new byte[200000];
    private LinkedList<ByteBuffer> mFrameFIFO = new LinkedList<>();
    private VideoDataFiFo mVideo0FiFo = new VideoDataFiFo();

    public VideoFrameFIFO(int i) {
        this.playType = i;
        setName("VideoFrameFIFO");
    }

    public void PushFrameBuffer(ByteBuffer byteBuffer) {
        try {
            synchronized (this.mFrameFIFO) {
                this.mFrameFIFO.add(byteBuffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int AddVideoData(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        return this.mVideo0FiFo.FiFoWrite(bArr, i);
    }

    public boolean HasFrame() {
        boolean z;
        try {
            synchronized (this.mFrameFIFO) {
                z = !this.mFrameFIFO.isEmpty();
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int FrameSzie() {
        int size;
        synchronized (this.mFrameFIFO) {
            size = this.mFrameFIFO.size();
        }
        return size;
    }

    public ByteBuffer PopFrame() {
        ByteBuffer removeFirst;
        synchronized (this.mFrameFIFO) {
            removeFirst = this.mFrameFIFO.removeFirst();
        }
        return removeFirst;
    }

    public ByteBuffer RemoveHrdFrame() {
        ByteBuffer removeFirst;
        synchronized (this.mFrameFIFO) {
            removeFirst = this.mFrameFIFO.removeFirst();
        }
        return removeFirst;
    }

    private void searchFrame() {
        int actualSize = this.mVideo0FiFo.getActualSize();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        while (i < actualSize) {
            if (this.mVideo0FiFo.buffer[(this.mVideo0FiFo.front + i) % this.mVideo0FiFo.FIFO_SIZE] == 0 && i + 4 < this.mVideo0FiFo.getActualSize() && this.mVideo0FiFo.buffer[((this.mVideo0FiFo.front + i) + 1) % this.mVideo0FiFo.FIFO_SIZE] == 0 && this.mVideo0FiFo.buffer[((this.mVideo0FiFo.front + i) + 2) % this.mVideo0FiFo.FIFO_SIZE] == 0 && this.mVideo0FiFo.buffer[((this.mVideo0FiFo.front + i) + 3) % this.mVideo0FiFo.FIFO_SIZE] == 1 && (this.mVideo0FiFo.buffer[((this.mVideo0FiFo.front + i) + 4) % this.mVideo0FiFo.FIFO_SIZE] == 103 || this.mVideo0FiFo.buffer[((this.mVideo0FiFo.front + i) + 4) % this.mVideo0FiFo.FIFO_SIZE] == 65 || (this.playType == 2 && this.mVideo0FiFo.buffer[((this.mVideo0FiFo.front + i) + 4) % this.mVideo0FiFo.FIFO_SIZE] == 97))) {
                i2++;
                if (i2 == 1) {
                    if (this.mVideo0FiFo.buffer[((this.mVideo0FiFo.front + i) + 4) % this.mVideo0FiFo.FIFO_SIZE] == 103) {
                        z = true;
                    }
                    int i5 = actualSize / 4;
                    int i6 = i + i5;
                    i3 += i5;
                    i4 = i;
                    i = i6;
                } else if (i2 == 2) {
                    if (z) {
                        int i7 = i3 + i4;
                        Log.w("dataLen0", "" + i7);
                        this.mVideo0FiFo.FiFoRead(this.dataa, i7);
                        byte[] bArr = this.dataa;
                        int i8 = i4 + 9;
                        if (bArr[i8] == 3 && bArr[i4 + 10] == -64 && bArr[i4 + 11] == 17) {
                            int i9 = i3 + 14;
                            byte[] bArr2 = new byte[i9];
                            byte[] bArr3 = this.sps1;
                            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
                            System.arraycopy(this.dataa, i4 + 14, bArr2, this.sps1.length, (i7 - i4) - 14);
                            this.byteBuffer = ByteBuffer.wrap(bArr2, 0, i9);
                        } else {
                            byte[] bArr4 = this.dataa;
                            if (bArr4[i8] == 2 && bArr4[i4 + 10] == Byte.MIN_VALUE && bArr4[i4 + 11] == 45) {
                                int i10 = i3 + 14;
                                byte[] bArr5 = new byte[i10];
                                byte[] bArr6 = this.sps2;
                                System.arraycopy(bArr6, 0, bArr5, 0, bArr6.length);
                                System.arraycopy(this.dataa, i4 + 13, bArr5, this.sps2.length, (i7 - i4) - 13);
                                this.byteBuffer = ByteBuffer.wrap(bArr5, 0, i10);
                            } else {
                                byte[] bArr7 = this.dataa;
                                if (bArr7[i8] == 5 && bArr7[i4 + 10] == -95 && bArr7[i4 + 11] == -20) {
                                    int i11 = i3 + 15;
                                    byte[] bArr8 = new byte[i11];
                                    byte[] bArr9 = this.sps3;
                                    System.arraycopy(bArr9, 0, bArr8, 0, bArr9.length);
                                    System.arraycopy(this.dataa, i4 + 13, bArr8, this.sps3.length, (i7 - i4) - 13);
                                    this.byteBuffer = ByteBuffer.wrap(bArr8, 0, i11);
                                } else {
                                    this.byteBuffer = ByteBuffer.wrap(this.dataa, i4, i3);
                                }
                            }
                        }
                    } else {
                        int i12 = i3 + i4;
                        byte[] bArr10 = new byte[i12];
                        Log.w("dataLen1", "" + i12);
                        this.mVideo0FiFo.FiFoRead(bArr10, i12);
                        this.byteBuffer = ByteBuffer.wrap(bArr10, i4, i3);
                    }
                    PushFrameBuffer(this.byteBuffer);
                    return;
                }
            }
            if (i2 == 1) {
                i3++;
            }
            i++;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (VideoPlay.flag) {
            if (this.mVideo0FiFo.getActualSize() > 512) {
                searchFrame();
            }
            try {
                Thread.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        VideoDataFiFo videoDataFiFo = this.mVideo0FiFo;
        if (videoDataFiFo != null) {
            videoDataFiFo.buffer = null;
        }
    }

    public void realse() {
        LinkedList<ByteBuffer> linkedList = this.mFrameFIFO;
        if (linkedList != null) {
            linkedList.clear();
            this.mFrameFIFO = null;
        }
    }
}
