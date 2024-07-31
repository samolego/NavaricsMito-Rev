package com.navatics.robot.protocol;

/* renamed from: com.navatics.robot.protocol.ah */
/* loaded from: classes.dex */
public class PitchCtrlMessage extends OutputMessage {

    /* renamed from: d */
    private static final Object f6254d = new Object();

    /* renamed from: e */
    private static int f6255e;

    /* renamed from: f */
    private static PitchCtrlMessage f6256f;

    /* renamed from: g */
    private PitchCtrlMessage f6257g;

    /* renamed from: h */
    private int f6258h;

    /* renamed from: i */
    private byte[] f6259i;

    private PitchCtrlMessage() {
        super(81);
        this.f6259i = new byte[2];
    }

    /* renamed from: a */
    public static PitchCtrlMessage m6525a(int i) {
        PitchCtrlMessage m6524c = m6524c();
        m6524c.f6258h = i;
        m6524c.f6259i[0] = (byte) m6524c.m6503k();
        m6524c.f6259i[1] = (byte) i;
        return m6524c;
    }

    /* renamed from: c */
    private static PitchCtrlMessage m6524c() {
        synchronized (f6254d) {
            PitchCtrlMessage pitchCtrlMessage = f6256f;
            if (pitchCtrlMessage == null) {
                return new PitchCtrlMessage();
            }
            f6256f = pitchCtrlMessage.f6257g;
            f6255e--;
            pitchCtrlMessage.f6257g = null;
            pitchCtrlMessage.m6504j();
            return pitchCtrlMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        this.f6258h = -1;
        synchronized (f6254d) {
            if (f6255e < 20) {
                f6255e++;
                this.f6257g = f6256f;
                f6256f = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        this.f6259i[0] = (byte) m6503k();
        byte[] bArr = this.f6259i;
        bArr[1] = (byte) this.f6258h;
        return bArr;
    }

    public String toString() {
        return "MSG_PITCH_CTRL(0xF0, " + String.format("0x%02x, 0x%02x", Integer.valueOf(m6503k()), Byte.valueOf(this.f6259i[1])) + ")";
    }
}
