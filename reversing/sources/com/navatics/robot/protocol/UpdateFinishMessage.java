package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Locale;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.ay */
/* loaded from: classes.dex */
public class UpdateFinishMessage extends InputMessage {

    /* renamed from: d */
    private static final C3044k f6357d = C3044k.m1564a(UpdateFinishMessage.class);

    /* renamed from: e */
    private static final Object f6358e = new Object();

    /* renamed from: f */
    private static int f6359f;

    /* renamed from: g */
    private static UpdateFinishMessage f6360g;

    /* renamed from: h */
    private UpdateFinishMessage f6361h;

    /* renamed from: i */
    private int f6362i;

    private UpdateFinishMessage() {
        super(23);
    }

    /* renamed from: a */
    public static UpdateFinishMessage m6467a(DataInputStream dataInputStream) {
        UpdateFinishMessage updateFinishMessage;
        try {
            updateFinishMessage = m6464c();
            try {
                updateFinishMessage.m6465b(dataInputStream);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                f6357d.mo1503b("obtain StatusMessage error !", e);
                if (updateFinishMessage != null) {
                    updateFinishMessage.mo6369a();
                }
                return updateFinishMessage;
            }
        } catch (Exception e2) {
            e = e2;
            updateFinishMessage = null;
        }
        return updateFinishMessage;
    }

    /* renamed from: c */
    private static UpdateFinishMessage m6464c() {
        synchronized (f6358e) {
            UpdateFinishMessage updateFinishMessage = f6360g;
            if (updateFinishMessage == null) {
                return new UpdateFinishMessage();
            }
            f6360g = updateFinishMessage.f6361h;
            f6359f--;
            updateFinishMessage.f6361h = null;
            updateFinishMessage.m6504j();
            return updateFinishMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public void mo6369a() {
        super.mo6369a();
        this.f6362i = 0;
        synchronized (f6358e) {
            if (f6359f < 100) {
                f6359f++;
                this.f6361h = f6360g;
                f6360g = this;
            }
        }
    }

    /* renamed from: b */
    private void m6465b(DataInputStream dataInputStream) throws IOException {
        this.f6362i = dataInputStream.readUnsignedByte();
    }

    /* renamed from: b */
    public boolean m6466b() {
        return this.f6362i == 0;
    }

    @Override // com.navatics.robot.protocol.InputMessage
    /* renamed from: e */
    public int mo6451e() {
        return this.f6362i;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "MSG_UPDATE_REPLY_DATA(0x%02x, 0x%02x, 0x%02x)", Integer.valueOf(m6534g()), Integer.valueOf(m6503k()), Integer.valueOf(this.f6362i));
    }
}
