package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.bb */
/* loaded from: classes.dex */
public class UpdateReplyMessage extends InputMessage {

    /* renamed from: d */
    private static final C3044k f6376d = C3044k.m1564a(UpdateReplyMessage.class);

    /* renamed from: e */
    private static final Object f6377e = new Object();

    /* renamed from: f */
    private static int f6378f;

    /* renamed from: g */
    private static UpdateReplyMessage f6379g;

    /* renamed from: h */
    private UpdateReplyMessage f6380h;

    /* renamed from: i */
    private int f6381i;

    /* renamed from: j */
    private int f6382j;

    private UpdateReplyMessage() {
        super(37);
    }

    /* renamed from: a */
    public static UpdateReplyMessage m6456a(DataInputStream dataInputStream) {
        UpdateReplyMessage updateReplyMessage;
        try {
            updateReplyMessage = m6452d();
            try {
                updateReplyMessage.m6454b(dataInputStream);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                f6376d.mo1503b("obtain StatusMessage error !", e);
                if (updateReplyMessage != null) {
                    updateReplyMessage.mo6369a();
                }
                return updateReplyMessage;
            }
        } catch (Exception e2) {
            e = e2;
            updateReplyMessage = null;
        }
        return updateReplyMessage;
    }

    /* renamed from: d */
    private static UpdateReplyMessage m6452d() {
        synchronized (f6377e) {
            UpdateReplyMessage updateReplyMessage = f6379g;
            if (updateReplyMessage == null) {
                return new UpdateReplyMessage();
            }
            f6379g = updateReplyMessage.f6380h;
            f6378f--;
            updateReplyMessage.f6380h = null;
            updateReplyMessage.m6504j();
            return updateReplyMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public void mo6369a() {
        super.mo6369a();
        this.f6381i = 0;
        this.f6382j = -1;
        synchronized (f6377e) {
            if (f6378f < 100) {
                f6378f++;
                this.f6380h = f6379g;
                f6379g = this;
            }
        }
    }

    /* renamed from: b */
    private void m6454b(DataInputStream dataInputStream) throws IOException {
        this.f6382j = dataInputStream.readUnsignedByte();
        this.f6381i = dataInputStream.readUnsignedByte();
    }

    /* renamed from: b */
    public boolean m6455b() {
        return this.f6381i == 0;
    }

    /* renamed from: c */
    public int m6453c() {
        return this.f6382j;
    }

    @Override // com.navatics.robot.protocol.InputMessage
    /* renamed from: e */
    public int mo6451e() {
        return this.f6381i;
    }

    public String toString() {
        return String.format("MSG_UPDATE_REPLY_DATA(0x%02x, 0x%02x, 0x%02x)", Integer.valueOf(m6534g()), Integer.valueOf(m6503k()), Integer.valueOf(this.f6381i));
    }
}
