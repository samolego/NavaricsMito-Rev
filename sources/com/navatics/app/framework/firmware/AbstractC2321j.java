package com.navatics.app.framework.firmware;

import com.navatics.robot.protocol.InputMessage;
import com.navatics.robot.protocol.OutputMessage;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/* renamed from: com.navatics.app.framework.firmware.j */
/* loaded from: classes.dex */
public abstract class RobotSocket {

    /* renamed from: a */
    private C1833a f4642a = new C1833a();

    /* renamed from: a */
    public abstract InputMessage mo8163a(long j) throws IOException, InterruptedException, TimeoutException;

    /* renamed from: a */
    public abstract boolean mo8162a(OutputMessage outputMessage) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RobotSocket() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RobotSocket(UpdateLogger updateLogger) {
        this.f4642a.m8164a(updateLogger);
    }

    /* renamed from: a */
    public static RobotSocket m8165a(int i, UpdateLogger updateLogger) {
        if (i != 1) {
            return null;
        }
        return new SenseThinkSocket(updateLogger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public UpdateLogger m8166a() {
        return this.f4642a;
    }

    /* compiled from: RobotSocket.java */
    /* renamed from: com.navatics.app.framework.firmware.j$a */
    /* loaded from: classes.dex */
    class C1833a implements UpdateLogger {

        /* renamed from: a */
        UpdateLogger f4643a;

        C1833a() {
        }

        /* renamed from: a */
        public void m8164a(UpdateLogger updateLogger) {
            this.f4643a = updateLogger;
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: a */
        public void mo8157a(String str) {
            UpdateLogger updateLogger = this.f4643a;
            if (updateLogger != null) {
                updateLogger.mo8157a(str);
            }
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: b */
        public void mo8155b(String str) {
            UpdateLogger updateLogger = this.f4643a;
            if (updateLogger != null) {
                updateLogger.mo8155b(str);
            }
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: c */
        public void mo8154c(String str) {
            UpdateLogger updateLogger = this.f4643a;
            if (updateLogger != null) {
                updateLogger.mo8154c(str);
            }
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: d */
        public void mo8153d(String str) {
            UpdateLogger updateLogger = this.f4643a;
            if (updateLogger != null) {
                updateLogger.mo8153d(str);
            }
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: a */
        public void mo8156a(String str, Throwable th) {
            UpdateLogger updateLogger = this.f4643a;
            if (updateLogger != null) {
                updateLogger.mo8156a(str, th);
            }
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: a */
        public void mo8158a(long j, long j2) {
            UpdateLogger updateLogger = this.f4643a;
            if (updateLogger != null) {
                updateLogger.mo8158a(j, j2);
            }
        }
    }
}
