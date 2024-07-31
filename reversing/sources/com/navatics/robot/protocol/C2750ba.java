package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.ba */
/* loaded from: classes.dex */
public class UpdateReplyForCrcMessage extends InputMessage {

    /* renamed from: d */
    private static final C3044k f6369d = C3044k.m1564a(UpdateReplyForCrcMessage.class);

    /* renamed from: e */
    private static final Object f6370e = new Object();

    /* renamed from: f */
    private static int f6371f;

    /* renamed from: g */
    private static UpdateReplyForCrcMessage f6372g;

    /* renamed from: h */
    private UpdateReplyForCrcMessage f6373h;

    /* renamed from: i */
    private int f6374i;

    /* renamed from: j */
    private int f6375j;

    private UpdateReplyForCrcMessage() {
        super(38);
    }

    /* renamed from: a */
    public static UpdateReplyForCrcMessage m6461a(DataInputStream dataInputStream) {
        UpdateReplyForCrcMessage updateReplyForCrcMessage;
        try {
            updateReplyForCrcMessage = m6457d();
            try {
                updateReplyForCrcMessage.m6459b(dataInputStream);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                f6369d.mo1503b("obtain StatusMessage error !", e);
                if (updateReplyForCrcMessage != null) {
                    updateReplyForCrcMessage.mo6369a();
                }
                return updateReplyForCrcMessage;
            }
        } catch (Exception e2) {
            e = e2;
            updateReplyForCrcMessage = null;
        }
        return updateReplyForCrcMessage;
    }

    /* renamed from: d */
    private static UpdateReplyForCrcMessage m6457d() {
        synchronized (f6370e) {
            UpdateReplyForCrcMessage updateReplyForCrcMessage = f6372g;
            if (updateReplyForCrcMessage == null) {
                return new UpdateReplyForCrcMessage();
            }
            f6372g = updateReplyForCrcMessage.f6373h;
            f6371f--;
            updateReplyForCrcMessage.f6373h = null;
            updateReplyForCrcMessage.m6504j();
            return updateReplyForCrcMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public void mo6369a() {
        super.mo6369a();
        this.f6374i = 0;
        this.f6375j = -1;
        synchronized (f6370e) {
            if (f6371f < 10) {
                f6371f++;
                this.f6373h = f6372g;
                f6372g = this;
            }
        }
    }

    /* renamed from: b */
    private void m6459b(DataInputStream dataInputStream) throws IOException {
        this.f6375j = dataInputStream.readUnsignedByte();
        this.f6374i = dataInputStream.readUnsignedByte();
    }

    /* renamed from: b */
    public boolean m6460b() {
        return this.f6374i == 0;
    }

    /* renamed from: c */
    public int m6458c() {
        return this.f6375j;
    }

    @Override // com.navatics.robot.protocol.InputMessage
    /* renamed from: e */
    public int mo6451e() {
        return this.f6374i;
    }

    public String toString() {
        return String.format("MSG_UPDATE_REPLY_CRC(0x%02x, 0x%02x, 0x%02x, 0x%02x)", Integer.valueOf(m6534g()), Integer.valueOf(m6503k()), Integer.valueOf(this.f6375j), Integer.valueOf(this.f6374i));
    }
}
