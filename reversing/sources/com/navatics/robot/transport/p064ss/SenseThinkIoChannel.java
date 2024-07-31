package com.navatics.robot.transport.p064ss;

import com.adapt.SPM_Manager;
import com.common.SP_ACK;
import com.navatics.robot.transport.IBuffer;
import com.navatics.robot.transport.IoBuffer;
import com.navatics.robot.transport.IoChannel;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.transport.ss.c */
/* loaded from: classes2.dex */
public class SenseThinkIoChannel extends IoChannel {

    /* renamed from: a */
    private static final C3044k f6591a = C3044k.m1564a(SenseThinkIoChannel.class);

    /* renamed from: b */
    private int f6592b;

    /* renamed from: c */
    private int f6593c;

    /* renamed from: d */
    private ConcurrentLinkedQueue<C2133a> f6594d = new ConcurrentLinkedQueue<>();

    /* renamed from: e */
    private ConcurrentLinkedQueue<C2133a> f6595e = new ConcurrentLinkedQueue<>();

    /* renamed from: e */
    public void m6206e() throws IOException {
    }

    /* renamed from: c */
    static /* synthetic */ int m6209c(SenseThinkIoChannel senseThinkIoChannel) {
        int i = senseThinkIoChannel.f6592b;
        senseThinkIoChannel.f6592b = i - 1;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ int m6207d(SenseThinkIoChannel senseThinkIoChannel) {
        int i = senseThinkIoChannel.f6593c;
        senseThinkIoChannel.f6593c = i + 1;
        return i;
    }

    /* renamed from: d */
    public static SenseThinkIoChannel m6208d() {
        return new SenseThinkIoChannel();
    }

    private SenseThinkIoChannel() {
        for (int i = 0; i < 2; i++) {
            if (this.f6594d.add(new C2133a())) {
                this.f6593c++;
            }
        }
    }

    /* renamed from: a */
    public int m6213a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return 0;
        }
        SPM_Manager.GetInstance().GetUserCmd().SendCmd((byte) -16, bArr);
        return bArr.length;
    }

    /* renamed from: a */
    public int m6212a(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return 0;
        }
        C2133a peek = this.f6595e.peek();
        if (peek == null) {
            f6591a.mo1511a((Object) "(peek)request data but we don't have more of it");
            return 0;
        }
        int i3 = peek.f6597b;
        if (i3 > i2) {
            C3044k c3044k = f6591a;
            c3044k.mo1504b((Object) ("provided buf length is " + i2 + ", but we need at least " + i3));
            return -53;
        }
        C2133a poll = this.f6595e.poll();
        if (poll == null) {
            f6591a.mo1511a((Object) "(poll)request data but we don't have more of it");
            return 0;
        }
        System.arraycopy(poll.f6596a, 0, bArr, i, i3);
        this.f6595e.add(poll);
        return i3;
    }

    @Override // com.navatics.robot.transport.IoChannel
    /* renamed from: a */
    public int mo6215a(IoBuffer ioBuffer) throws IOException {
        if (ioBuffer == null) {
            f6591a.mo1504b((Object) "readBuffer invalid param, buf is null.");
            return 0;
        } else if (ioBuffer.mo6202a() == null) {
            C2133a poll = this.f6595e.poll();
            if (poll == null) {
                if (m6349b() == IoChannel.IoMode.NONBLOCKING) {
                    f6591a.mo1511a((Object) "(poll,rb)request data but we don't have more of it");
                    return 0;
                }
                throw new IOException("Blocking read is not implemented yet.");
            }
            ioBuffer.m6283a(poll);
            return poll.f6597b;
        } else {
            return m6212a(ioBuffer.mo6202a(), 0, ioBuffer.mo6201b());
        }
    }

    /* renamed from: f */
    private int m6204f() {
        return !this.f6595e.isEmpty() ? 2 : 0;
    }

    @Override // com.navatics.robot.transport.IoChannel
    /* renamed from: c */
    public int mo6210c() {
        SP_ACK GetAckInfo = SPM_Manager.GetInstance().GetUserCmd().GetAckInfo();
        if (GetAckInfo == null || GetAckInfo.parameters == null || GetAckInfo.parameters.length == 0) {
            long a = m6352a();
            m6351a(15 + a);
            if (a > 250) {
                m6351a(250L);
            }
            return m6204f() | 1;
        }
        C2133a poll = this.f6594d.poll();
        if (poll == null) {
            f6591a.mo1499d("[" + this + "] data available but we don't have free buffer now, discard it.");
            return m6204f() | 1;
        }
        byte[] bArr = GetAckInfo.parameters;
        int length = bArr.length;
        if (length > poll.f6596a.length) {
            f6591a.mo1499d("the available data packet size is larger than per buffer size, will discard this data, pls offer a bigger buffer");
            this.f6594d.add(poll);
            return m6204f() | 1;
        }
        this.f6593c--;
        System.arraycopy(bArr, 0, poll.f6596a, 0, length);
        poll.f6597b = length;
        this.f6595e.add(poll);
        this.f6592b++;
        m6203g();
        m6351a(15L);
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m6203g() {
        if (this.f6592b + this.f6593c == 2) {
            return;
        }
        throw new RuntimeException("wtf ?! bufInUsed + bufFreed = " + (this.f6592b + this.f6593c) + ", but MAX_BUFFER_CNT is2");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SenseThinkIoChannel.java */
    /* renamed from: com.navatics.robot.transport.ss.c$a */
    /* loaded from: classes2.dex */
    public class C2133a implements IBuffer {

        /* renamed from: a */
        byte[] f6596a = new byte[1024];

        /* renamed from: b */
        int f6597b;

        C2133a() {
        }

        @Override // com.navatics.robot.transport.IBuffer
        /* renamed from: a */
        public byte[] mo6202a() {
            return this.f6596a;
        }

        @Override // com.navatics.robot.transport.IBuffer
        /* renamed from: b */
        public int mo6201b() {
            return this.f6596a.length;
        }

        @Override // com.navatics.robot.transport.IBuffer
        /* renamed from: c */
        public int mo6200c() {
            return this.f6597b;
        }

        @Override // com.navatics.robot.transport.IBuffer
        /* renamed from: d */
        public void mo6199d() {
            SenseThinkIoChannel.this.f6595e.remove(this);
            SenseThinkIoChannel.this.f6594d.add(this);
            SenseThinkIoChannel.m6209c(SenseThinkIoChannel.this);
            SenseThinkIoChannel.m6207d(SenseThinkIoChannel.this);
            SenseThinkIoChannel.this.m6203g();
        }
    }
}
