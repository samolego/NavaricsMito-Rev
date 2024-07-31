package com.navatics.robot.protocol;

import java.io.DataInputStream;
import java.io.IOException;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.ao */
/* loaded from: classes.dex */
public class RobotForceUpdateMessage extends InputMessage {

    /* renamed from: d */
    private static final C3044k f6282d = C3044k.m1564a(RobotForceUpdateMessage.class);

    /* renamed from: e */
    private static final Object f6283e = new Object();

    /* renamed from: f */
    private static int f6284f;

    /* renamed from: g */
    private static RobotForceUpdateMessage f6285g;

    /* renamed from: h */
    private RobotForceUpdateMessage f6286h;

    /* renamed from: b */
    private void m6506b(DataInputStream dataInputStream) throws IOException {
    }

    @Override // com.navatics.robot.protocol.InputMessage
    /* renamed from: e */
    public int mo6451e() {
        return 0;
    }

    public String toString() {
        return "MSG_ROBOT_FORCE_UPDATE";
    }

    private RobotForceUpdateMessage() {
        super(254);
    }

    /* renamed from: a */
    public static RobotForceUpdateMessage m6508a(DataInputStream dataInputStream) {
        RobotForceUpdateMessage robotForceUpdateMessage;
        try {
            robotForceUpdateMessage = m6507b();
            try {
                robotForceUpdateMessage.m6506b(dataInputStream);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                f6282d.mo1503b("obtain BuoyStatusMessage error !", e);
                if (robotForceUpdateMessage != null) {
                    robotForceUpdateMessage.mo6369a();
                }
                return robotForceUpdateMessage;
            }
        } catch (Exception e2) {
            e = e2;
            robotForceUpdateMessage = null;
        }
        return robotForceUpdateMessage;
    }

    /* renamed from: b */
    private static RobotForceUpdateMessage m6507b() {
        synchronized (f6283e) {
            RobotForceUpdateMessage robotForceUpdateMessage = f6285g;
            if (robotForceUpdateMessage == null) {
                return new RobotForceUpdateMessage();
            }
            f6285g = robotForceUpdateMessage.f6286h;
            f6284f--;
            robotForceUpdateMessage.f6286h = null;
            robotForceUpdateMessage.m6504j();
            return robotForceUpdateMessage;
        }
    }

    @Override // com.navatics.robot.protocol.RobotMessage
    /* renamed from: a */
    public void mo6369a() {
        super.mo6369a();
        synchronized (f6283e) {
            if (f6284f < 100) {
                f6284f++;
                this.f6286h = f6285g;
                f6285g = this;
            }
        }
    }
}
