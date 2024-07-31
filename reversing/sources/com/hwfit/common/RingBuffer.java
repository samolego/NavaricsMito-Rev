package com.hwfit.common;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RingBuffer<T> {
    private static final byte INVALID = -1;
    private static final byte READED = 1;
    private static final byte WRITED = 0;
    private int mCapacity;
    private List<RingBuffer<T>.Node> mDataBuf;
    private int mReader = 0;
    private int mWriter = 0;

    /* loaded from: classes.dex */
    private class Node {
        public byte flag;
        public T object;

        public Node(T t, byte b) {
            this.object = null;
            this.flag = RingBuffer.INVALID;
            this.object = t;
            this.flag = b;
        }
    }

    public RingBuffer(int i) {
        this.mCapacity = 0;
        this.mDataBuf = null;
        this.mCapacity = i;
        this.mDataBuf = new ArrayList(i);
    }

    public synchronized boolean push(T t) {
        int size = this.mDataBuf.size();
        if (this.mWriter >= this.mCapacity && this.mWriter >= this.mCapacity) {
            this.mWriter = 0;
        }
        if (this.mCapacity > size) {
            RingBuffer<T>.Node node = new Node(t, (byte) 0);
            List<RingBuffer<T>.Node> list = this.mDataBuf;
            int i = this.mWriter;
            this.mWriter = i + 1;
            list.add(i, node);
        } else {
            try {
                RingBuffer<T>.Node node2 = this.mDataBuf.get(this.mWriter);
                if (node2 != null && node2.flag == 0) {
                    return false;
                }
                RingBuffer<T>.Node node3 = new Node(t, (byte) 0);
                List<RingBuffer<T>.Node> list2 = this.mDataBuf;
                int i2 = this.mWriter;
                this.mWriter = i2 + 1;
                list2.set(i2, node3);
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public synchronized void pushNoCaseFull(T t) {
        int size = this.mDataBuf.size();
        if (this.mWriter >= this.mCapacity && this.mWriter >= this.mCapacity) {
            this.mWriter = 0;
        }
        RingBuffer<T>.Node node = new Node(t, (byte) 0);
        if (this.mCapacity > size) {
            List<RingBuffer<T>.Node> list = this.mDataBuf;
            int i = this.mWriter;
            this.mWriter = i + 1;
            list.add(i, node);
        } else {
            List<RingBuffer<T>.Node> list2 = this.mDataBuf;
            int i2 = this.mWriter;
            this.mWriter = i2 + 1;
            list2.set(i2, node);
        }
    }

    public synchronized T pull() {
        if (this.mReader < this.mCapacity) {
            if (this.mReader < 0) {
                this.mReader = 0;
            }
        } else if (this.mReader >= this.mCapacity) {
            this.mReader = 0;
        }
        try {
            RingBuffer<T>.Node node = this.mDataBuf.get(this.mReader);
            if (node != null && node.flag == 0) {
                node.flag = (byte) 1;
                this.mDataBuf.set(this.mReader, node);
                this.mReader++;
                return node.object;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(7:6|7|8|(3:12|13|14)|17|18|19)|21|7|8|(4:10|12|13|14)|17|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
        if (r3 >= r2.mCapacity) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized T pull(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.mCapacity     // Catch: java.lang.Throwable -> L24
            r1 = 0
            if (r3 >= r0) goto L9
            if (r3 >= 0) goto Le
            goto Lf
        L9:
            int r0 = r2.mCapacity     // Catch: java.lang.Throwable -> L24
            if (r3 < r0) goto Le
            goto Lf
        Le:
            r1 = r3
        Lf:
            java.util.List<com.hwfit.common.RingBuffer<T>$Node> r3 = r2.mDataBuf     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L24
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L24
            com.hwfit.common.RingBuffer$Node r3 = (com.hwfit.common.RingBuffer.Node) r3     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L24
            if (r3 == 0) goto L21
            byte r0 = r3.flag     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L24
            if (r0 != 0) goto L21
            T r3 = r3.object     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L24
            monitor-exit(r2)
            return r3
        L21:
            r3 = 0
            monitor-exit(r2)
            return r3
        L24:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hwfit.common.RingBuffer.pull(int):java.lang.Object");
    }

    public synchronized T pullNoCaseEmpty() {
        if (this.mReader < this.mCapacity) {
            if (this.mReader < 0) {
                this.mReader = 0;
            }
        } else if (this.mReader >= this.mCapacity) {
            this.mReader = 0;
        }
        try {
            RingBuffer<T>.Node node = this.mDataBuf.get(this.mReader);
            if (node != null && -1 != node.flag) {
                this.mReader++;
                return node.object;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(7:6|7|8|(3:12|13|14)|17|18|19)|21|7|8|(4:10|12|13|14)|17|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
        if (r3 >= r2.mCapacity) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized T pullNoCaseEmpty(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.mCapacity     // Catch: java.lang.Throwable -> L25
            r1 = 0
            if (r3 >= r0) goto L9
            if (r3 >= 0) goto Le
            goto Lf
        L9:
            int r0 = r2.mCapacity     // Catch: java.lang.Throwable -> L25
            if (r3 < r0) goto Le
            goto Lf
        Le:
            r1 = r3
        Lf:
            java.util.List<com.hwfit.common.RingBuffer<T>$Node> r3 = r2.mDataBuf     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L25
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L25
            com.hwfit.common.RingBuffer$Node r3 = (com.hwfit.common.RingBuffer.Node) r3     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L25
            if (r3 == 0) goto L22
            r0 = -1
            byte r1 = r3.flag     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L25
            if (r0 == r1) goto L22
            T r3 = r3.object     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L25
            monitor-exit(r2)
            return r3
        L22:
            r3 = 0
            monitor-exit(r2)
            return r3
        L25:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hwfit.common.RingBuffer.pullNoCaseEmpty(int):java.lang.Object");
    }

    public synchronized T pullBack() {
        if (this.mReader < this.mCapacity) {
            if (this.mReader < 0) {
                this.mReader = this.mCapacity - 1;
            }
        } else if (this.mReader >= this.mCapacity) {
            this.mReader = 0;
        }
        try {
            RingBuffer<T>.Node node = this.mDataBuf.get(this.mReader);
            if (node != null && node.flag == 0) {
                node.flag = (byte) 1;
                this.mDataBuf.set(this.mReader, node);
                this.mReader--;
                return node.object;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public synchronized T pullBackNoCaseEmpty() {
        if (this.mReader < this.mCapacity) {
            if (this.mReader < 0) {
                this.mReader = this.mCapacity - 1;
            }
        } else if (this.mReader >= this.mCapacity) {
            this.mReader = 0;
        }
        try {
            RingBuffer<T>.Node node = this.mDataBuf.get(this.mReader);
            if (node != null && -1 != node.flag) {
                this.mReader--;
                return node.object;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public synchronized boolean isFull() {
        try {
            RingBuffer<T>.Node node = this.mDataBuf.get(this.mWriter);
            if (node != null) {
                if (node.flag == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public synchronized boolean isEmpty() {
        if (this.mReader >= this.mCapacity && this.mReader >= this.mCapacity) {
            this.mReader = 0;
        }
        try {
            RingBuffer<T>.Node node = this.mDataBuf.get(this.mReader);
            if (node != null) {
                if (node.flag == 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public synchronized int capacity() {
        return this.mCapacity;
    }

    public synchronized int size() {
        return this.mDataBuf.size();
    }
}
