package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.au */
/* loaded from: classes.dex */
public class TestMessage extends OutputMessage {

    /* renamed from: d */
    private static C3044k f6329d = C3044k.m1564a(TestMessage.class);

    /* renamed from: e */
    private static final Object f6330e = new Object();

    /* renamed from: f */
    private static int f6331f;

    /* renamed from: g */
    private static TestMessage f6332g;

    /* renamed from: h */
    private TestMessage f6333h;

    /* renamed from: i */
    private byte[] f6334i;

    private TestMessage(int i) {
        super(i);
        this.f6334i = new byte[2];
    }

    /* renamed from: a */
    public static TestMessage m6476a(int i) {
        synchronized (f6330e) {
            TestMessage testMessage = f6332g;
            if (testMessage == null) {
                return new TestMessage(i);
            }
            f6332g = testMessage.f6333h;
            f6331f--;
            testMessage.f6333h = null;
            testMessage.m6504j();
            testMessage.f6290c = i;
            return testMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6330e) {
            if (f6331f < 20) {
                f6331f++;
                this.f6333h = f6332g;
                f6332g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        this.f6334i[0] = (byte) m6503k();
        byte[] bArr = this.f6334i;
        bArr[1] = 1;
        return bArr;
    }

    public String toString() {
        return "MSG_TEST_MSG(0xF0, " + String.format("0x%02x", Integer.valueOf(m6503k())) + ")";
    }
}
