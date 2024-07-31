package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.as */
/* loaded from: classes.dex */
public class SwitchModeMessage extends OutputMessage {

    /* renamed from: d */
    private static C3044k f6317d = C3044k.m1564a(SwitchModeMessage.class);

    /* renamed from: e */
    private static final Object f6318e = new Object();

    /* renamed from: f */
    private static int f6319f;

    /* renamed from: g */
    private static SwitchModeMessage f6320g;

    /* renamed from: h */
    private SwitchModeMessage f6321h;

    /* renamed from: i */
    private int f6322i;

    /* renamed from: j */
    private byte[] f6323j;

    private SwitchModeMessage() {
        super(68);
        this.f6323j = new byte[2];
    }

    /* renamed from: a */
    public static SwitchModeMessage m6480a(int i) {
        SwitchModeMessage m6479c = m6479c();
        m6479c.f6322i = i;
        return m6479c;
    }

    /* renamed from: c */
    private static SwitchModeMessage m6479c() {
        synchronized (f6318e) {
            SwitchModeMessage switchModeMessage = f6320g;
            if (switchModeMessage == null) {
                return new SwitchModeMessage();
            }
            f6320g = switchModeMessage.f6321h;
            f6319f--;
            switchModeMessage.f6321h = null;
            switchModeMessage.m6504j();
            return switchModeMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6318e) {
            if (f6319f < 20) {
                f6319f++;
                this.f6321h = f6320g;
                f6320g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        this.f6323j[0] = (byte) m6503k();
        byte[] bArr = this.f6323j;
        bArr[1] = (byte) this.f6322i;
        return bArr;
    }

    public String toString() {
        return "MSG_SWITCH_MODE(0xF0, " + String.format("0x%02x, 0x%08x", Integer.valueOf(m6503k()), Integer.valueOf(this.f6322i)) + ")";
    }
}
