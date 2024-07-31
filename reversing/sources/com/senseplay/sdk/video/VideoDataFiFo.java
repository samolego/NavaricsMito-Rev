package com.senseplay.sdk.video;

/* loaded from: classes2.dex */
public class VideoDataFiFo {
    private static Object lockObject = new Object();
    public int FIFO_SIZE = 4194304;
    public boolean isEmpty = true;
    public boolean isFull = false;
    public byte[] buffer = new byte[this.FIFO_SIZE];
    public int front = 0;
    public int rear = 0;

    public int FiFoRead(byte[] bArr, int i) {
        int actualSize = getActualSize();
        if (i < 1 || this.isEmpty) {
            return 0;
        }
        if (actualSize > i) {
            this.isEmpty = false;
        } else {
            this.isEmpty = true;
            i = actualSize;
        }
        if (this.isFull) {
            this.isFull = false;
        }
        int i2 = this.rear;
        int i3 = this.front;
        if (i2 > i3) {
            System.arraycopy(this.buffer, i3, bArr, 0, i);
            this.front += i;
        } else {
            int i4 = this.FIFO_SIZE;
            if (i > i4 - i3) {
                System.arraycopy(this.buffer, i3, bArr, 0, i4 - i3);
                byte[] bArr2 = this.buffer;
                int i5 = this.FIFO_SIZE;
                int i6 = this.front;
                System.arraycopy(bArr2, 0, bArr, i5 - i6, i - (i5 - i6));
            } else {
                System.arraycopy(this.buffer, i3, bArr, 0, i);
            }
            int i7 = this.front;
            int i8 = i7 + i;
            int i9 = this.FIFO_SIZE;
            this.front = i8 >= i9 ? (i7 + i) - i9 : i7 + i;
        }
        return i;
    }

    public int FiFoWrite(byte[] bArr, int i) {
        int actualSize = getActualSize();
        int i2 = this.FIFO_SIZE;
        if (actualSize > i2) {
            return 0;
        }
        if (i < 1 || this.isFull) {
            this.isFull = true;
            return 0;
        }
        if (i2 - actualSize > i) {
            this.isFull = false;
        } else {
            i = i2 - actualSize;
            this.isFull = true;
        }
        if (this.isEmpty) {
            this.isEmpty = false;
        }
        int i3 = this.rear;
        if (i3 >= this.front) {
            int i4 = this.FIFO_SIZE;
            if (i4 - i3 >= i) {
                System.arraycopy(bArr, 0, this.buffer, i3, i);
                int i5 = this.rear;
                this.rear = i5 + i < this.FIFO_SIZE ? i5 + i : 0;
            } else {
                System.arraycopy(bArr, 0, this.buffer, i3, i4 - i3);
                int i6 = this.FIFO_SIZE;
                int i7 = this.rear;
                System.arraycopy(bArr, i6 - i7, this.buffer, 0, i - (i6 - i7));
                this.rear = (this.rear + i) - this.FIFO_SIZE;
            }
        } else {
            System.arraycopy(bArr, 0, this.buffer, i3, i);
            int i8 = this.rear;
            int i9 = i8 + i;
            int i10 = this.FIFO_SIZE;
            this.rear = i9 >= i10 ? (i8 + i) - i10 : i8 + i;
        }
        return i;
    }

    public int FiFoCopy(byte[] bArr, int i) {
        synchronized (lockObject) {
            int actualSize = getActualSize();
            if (i >= 1 && !this.isEmpty) {
                if (actualSize > i) {
                    this.isEmpty = false;
                } else {
                    i = actualSize;
                }
                if (this.rear > this.front) {
                    System.arraycopy(this.buffer, this.front, bArr, 0, i);
                } else if (i > this.FIFO_SIZE - this.front) {
                    System.arraycopy(this.buffer, this.front, bArr, 0, this.FIFO_SIZE - this.front);
                    System.arraycopy(this.buffer, 0, bArr, this.FIFO_SIZE - this.front, i - (this.FIFO_SIZE - this.front));
                } else {
                    System.arraycopy(this.buffer, this.front, bArr, 0, i - this.front);
                }
                return i;
            }
            this.isEmpty = true;
            return 0;
        }
    }

    public int getActualSize() {
        if (this.isEmpty) {
            return 0;
        }
        int i = this.rear;
        int i2 = this.front;
        return i >= i2 ? i - i2 : this.FIFO_SIZE - (i2 - i);
    }
}
