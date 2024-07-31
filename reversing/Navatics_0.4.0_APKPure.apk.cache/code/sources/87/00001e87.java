package com.senseplay.sdk.video.host;

import com.common.AUTOMATIVE_LIGHT;
import com.senseplay.sdk.video.VideoDataFiFo;
import java.nio.ByteBuffer;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class FrameFIFO extends Thread {
    int flag_1 = 0;
    int flag_2 = 0;
    int count_flag = 0;
    int frame_d_size = 0;
    byte isDiscardFrame = 0;
    private boolean isIframe = false;
    private boolean getFirstIframe = false;
    private String TAG = "VideoFrameFIFO";
    byte[] sps1 = {0, 0, 0, 1, 103, 77, 0, 40, -12, 3, AUTOMATIVE_LIGHT.FLICKER, 17, 63, 46, 2, 32, 0, 0, 3, 0, 32, 0, 0, 7, -127, -29, 6, 84};
    byte[] sps2 = {0, 0, 0, 1, 103, 77, 0, 40, -12, 2, AUTOMATIVE_LIGHT.OVERTURN, 45, -40, 8, AUTOMATIVE_LIGHT.OVERTURN, 0, 0, 3, 0, AUTOMATIVE_LIGHT.OVERTURN, 0, 0, 30, 7, -116, 25, 80};
    byte[] sps3 = {0, 0, 0, 1, 103, 77, 0, 40, -12, 5, -95, -19, AUTOMATIVE_LIGHT.OVERTURN, -120, 0, 0, 3, 0, 8, 0, 0, 3, 1, -32, 120, -63, -107};
    private final int sleep_time = 1;
    private LinkedList<ByteBuffer> mFrameFIFO = new LinkedList<>();
    private VideoDataFiFo streamFiFo = new VideoDataFiFo();

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
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
        return this.streamFiFo.FiFoWrite(bArr, i);
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
        ByteBuffer wrap;
        int actualSize = this.streamFiFo.getActualSize();
        int i = 0;
        while (true) {
            if (i >= actualSize) {
                break;
            }
            if (this.streamFiFo.buffer[(this.streamFiFo.front + i) % this.streamFiFo.FIFO_SIZE] == 0 && i + 30 < this.streamFiFo.getActualSize() && this.streamFiFo.buffer[((this.streamFiFo.front + i) + 1) % this.streamFiFo.FIFO_SIZE] == 0 && this.streamFiFo.buffer[((this.streamFiFo.front + i) + 2) % this.streamFiFo.FIFO_SIZE] == 0 && this.streamFiFo.buffer[((this.streamFiFo.front + i) + 3) % this.streamFiFo.FIFO_SIZE] == 1 && (this.streamFiFo.buffer[((this.streamFiFo.front + i) + 4) % this.streamFiFo.FIFO_SIZE] == 103 || this.streamFiFo.buffer[((this.streamFiFo.front + i) + 4) % this.streamFiFo.FIFO_SIZE] == 65 || this.streamFiFo.buffer[((this.streamFiFo.front + i) + 4) % this.streamFiFo.FIFO_SIZE] == 97 || this.streamFiFo.buffer[((this.streamFiFo.front + i) + 4) % this.streamFiFo.FIFO_SIZE] == 101)) {
                this.count_flag++;
                int i2 = this.count_flag;
                if (i2 == 1) {
                    if (this.streamFiFo.buffer[((this.streamFiFo.front + i) + 4) % this.streamFiFo.FIFO_SIZE] == 103) {
                        this.isIframe = true;
                        this.flag_1 = i;
                        i += 64;
                        this.frame_d_size += 64;
                    } else {
                        this.flag_1 = i;
                        i += 16;
                        this.frame_d_size += 16;
                    }
                } else if (i2 == 2) {
                    if (this.isIframe) {
                        this.getFirstIframe = true;
                        int i3 = this.frame_d_size;
                        int i4 = this.flag_1;
                        byte[] bArr = new byte[i3 + i4];
                        this.streamFiFo.FiFoRead(bArr, i3 + i4);
                        int i5 = this.flag_1;
                        if (bArr[i5 + 9] == 3 && bArr[i5 + 10] == -64 && bArr[i5 + 11] == 17) {
                            ByteBuffer.wrap(bArr, i5, this.frame_d_size);
                            byte[] bArr2 = new byte[this.frame_d_size + 14];
                            byte[] bArr3 = this.sps1;
                            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
                            System.arraycopy(bArr, this.flag_1 + 14, bArr2, this.sps1.length, (bArr.length - r2) - 14);
                            wrap = ByteBuffer.wrap(bArr2, 0, this.frame_d_size + 14);
                        } else {
                            int i6 = this.flag_1;
                            if (bArr[i6 + 9] == 2 && bArr[i6 + 10] == Byte.MIN_VALUE && bArr[i6 + 11] == 45) {
                                byte[] bArr4 = new byte[this.frame_d_size + 14];
                                byte[] bArr5 = this.sps2;
                                System.arraycopy(bArr5, 0, bArr4, 0, bArr5.length);
                                System.arraycopy(bArr, this.flag_1 + 13, bArr4, this.sps2.length, (bArr.length - r2) - 13);
                                wrap = ByteBuffer.wrap(bArr4, 0, this.frame_d_size + 14);
                            } else {
                                int i7 = this.flag_1;
                                if (bArr[i7 + 9] == 5 && bArr[i7 + 10] == -95 && bArr[i7 + 11] == -20) {
                                    byte[] bArr6 = new byte[this.frame_d_size + 15];
                                    byte[] bArr7 = this.sps3;
                                    System.arraycopy(bArr7, 0, bArr6, 0, bArr7.length);
                                    System.arraycopy(bArr, this.flag_1 + 13, bArr6, this.sps3.length, (bArr.length - r2) - 13);
                                    wrap = ByteBuffer.wrap(bArr6, 0, this.frame_d_size + 15);
                                } else {
                                    wrap = ByteBuffer.wrap(bArr, this.flag_1, this.frame_d_size);
                                }
                            }
                        }
                    } else {
                        int i8 = this.flag_1;
                        if (i8 > 0) {
                            this.streamFiFo.FiFoRead(new byte[i8], i8);
                        }
                        int i9 = this.frame_d_size;
                        byte[] bArr8 = new byte[i9];
                        this.streamFiFo.FiFoRead(bArr8, i9);
                        byte[] bArr9 = new byte[8];
                        System.arraycopy(bArr8, bArr8.length - 8, bArr9, 0, 8);
                        if (checkFrameDiscard(bArr9, 8) > 0) {
                            this.isDiscardFrame = (byte) 1;
                        }
                        wrap = ByteBuffer.wrap(bArr8, 0, this.frame_d_size);
                    }
                    if (this.getFirstIframe) {
                        PushFrameBuffer(wrap);
                    }
                    this.flag_1 = 0;
                    this.flag_2 = 0;
                    this.count_flag = 0;
                    this.frame_d_size = 0;
                    this.isDiscardFrame = (byte) 0;
                    this.isIframe = false;
                }
            }
            if (this.count_flag == 1) {
                this.frame_d_size++;
            }
            i++;
        }
        this.flag_1 = 0;
        this.flag_2 = 0;
        this.count_flag = 0;
        this.isDiscardFrame = (byte) 0;
        this.frame_d_size = 0;
        this.isIframe = false;
    }

    private int checkFrameDiscard(byte[] bArr, int i) {
        return (i >= 8 && bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 1 && bArr[3] == 122 && bArr[4] == -91 && bArr[5] == -75 && bArr[6] == -59 && bArr[7] == -43) ? 1 : 0;
    }
}