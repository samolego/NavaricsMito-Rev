package com.navatics.robot.protocol;

import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.at */
/* loaded from: classes.dex */
public class TakePhotoMessage extends OutputMessage {

    /* renamed from: d */
    private static final C3044k f6324d = C3044k.m1564a(TakePhotoMessage.class);

    /* renamed from: e */
    private static final Object f6325e = new Object();

    /* renamed from: f */
    private static int f6326f;

    /* renamed from: g */
    private static TakePhotoMessage f6327g;

    /* renamed from: h */
    private TakePhotoMessage f6328h;

    private TakePhotoMessage() {
        super(67);
    }

    /* renamed from: c */
    public static TakePhotoMessage m6478c() {
        try {
            return m6477d();
        } catch (Exception e) {
            e.printStackTrace();
            f6324d.mo1503b("obtain StatusMessage error !", e);
            return null;
        }
    }

    /* renamed from: d */
    private static TakePhotoMessage m6477d() {
        synchronized (f6325e) {
            TakePhotoMessage takePhotoMessage = f6327g;
            if (takePhotoMessage == null) {
                return new TakePhotoMessage();
            }
            f6327g = takePhotoMessage.f6328h;
            f6326f--;
            takePhotoMessage.f6328h = null;
            takePhotoMessage.m6504j();
            return takePhotoMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public final void mo6369a() {
        super.mo6369a();
        synchronized (f6325e) {
            if (f6326f < 10) {
                f6326f++;
                this.f6328h = f6327g;
                f6327g = this;
            }
        }
    }

    @Override // com.navatics.robot.protocol.OutputMessage
    /* renamed from: b */
    public byte[] mo6368b() {
        return new byte[]{(byte) m6503k()};
    }

    public String toString() {
        return String.format("MSG_TAKE_PHOTO(0x%02x, 0x%02x)", Integer.valueOf(m6528e()), Integer.valueOf(m6503k()));
    }
}
