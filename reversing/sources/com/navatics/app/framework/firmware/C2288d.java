package com.navatics.app.framework.firmware;

import android.util.Log;
import com.adapt.SPM_Manager;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.Settings;
import com.navatics.app.framework.p053e.MessageLogger;
import com.navatics.app.framework.p053e.MessageLoggerFactory;
import com.navatics.robot.protocol.CrcCalculator2;
import com.navatics.robot.protocol.InputMessage;
import com.navatics.robot.protocol.UpdateEndMessage;
import com.navatics.robot.protocol.UpdateFinishMessage;
import com.navatics.robot.protocol.UpdateOutputMessage;
import com.navatics.robot.protocol.UpdateReplyForCrcMessage;
import com.navatics.robot.protocol.UpdateReplyMessage;
import com.navatics.robot.protocol.UpdateStartMessage;
import com.navatics.robot.transport.NvSocket;
import com.navatics.robot.utils.C2160n;
import com.navatics.xlog.WLog;
import io.reactivex.AbstractC2901p;
import io.reactivex.Observable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p099e.Schedulers;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.firmware.d */
/* loaded from: classes.dex */
public class Firmware {

    /* renamed from: a */
    private static final C3044k f4548a = C3044k.m1564a(Firmware.class);

    /* renamed from: b */
    private static HashMap<String, Firmware> f4549b = new HashMap<>();

    /* renamed from: e */
    private NvConnection f4552e;

    /* renamed from: f */
    private RobotSocket f4553f;

    /* renamed from: g */
    private String f4554g;

    /* renamed from: i */
    private boolean f4556i;

    /* renamed from: c */
    private int f4550c = 0;

    /* renamed from: d */
    private int f4551d = 0;

    /* renamed from: h */
    private CrcCalculator2 f4555h = new CrcCalculator2();

    /* renamed from: l */
    private long f4559l = 0;

    /* renamed from: m */
    private long f4560m = 0;

    /* renamed from: n */
    private int f4561n = 0;

    /* renamed from: o */
    private byte[] f4562o = {121};

    /* renamed from: j */
    private UpdateLogger f4557j = new C1806a();

    /* renamed from: k */
    private MessageLogger f4558k = MessageLoggerFactory.m8419b();

    /* compiled from: Firmware.java */
    /* renamed from: com.navatics.app.framework.firmware.d$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1807b {
        /* renamed from: a */
        void mo8184a();

        /* renamed from: a */
        void mo8183a(long j);

        /* renamed from: a */
        void mo8182a(Throwable th);

        /* renamed from: b */
        void mo8181b();
    }

    /* renamed from: lambda$PdDUd-IQIrP1M0Jr5dYqkWpEM9o */
    public static /* synthetic */ void m13061lambda$PdDUdIQIrP1M0Jr5dYqkWpEM9o(Firmware firmware, InterfaceC1807b interfaceC1807b, String str) {
        firmware.m8303b(interfaceC1807b, str);
    }

    public static /* synthetic */ void lambda$QL5wLZPzNWV0eb3KX6e0f2JayTQ(Firmware firmware, InterfaceC1807b interfaceC1807b, String str) {
        firmware.m8316a(interfaceC1807b, str);
    }

    public static /* synthetic */ void lambda$XxUuYi9KHZ4af0wxxqGbJuJRhyc(Firmware firmware, InterfaceC1807b interfaceC1807b, Throwable th) {
        firmware.m8302b(interfaceC1807b, th);
    }

    /* renamed from: lambda$gm4P78CyFm-e9ngvKgdRifVaoEU */
    public static /* synthetic */ boolean m13062lambda$gm4P78CyFme9ngvKgdRifVaoEU(String str, File file, String str2) {
        return m8307a(str, file, str2);
    }

    /* renamed from: a */
    public static Firmware m8311a(NvConnection nvConnection, String str) {
        String m8309a = m8309a(str);
        if (C2160n.m5855a((CharSequence) m8309a)) {
            return null;
        }
        Firmware firmware = f4549b.get(m8309a);
        if (firmware != null) {
            return firmware;
        }
        Firmware firmware2 = new Firmware(nvConnection, m8309a);
        f4549b.put(m8309a, firmware2);
        return firmware2;
    }

    public Firmware(NvConnection nvConnection, String str) {
        this.f4552e = nvConnection;
        this.f4554g = str;
    }

    /* renamed from: a */
    private static String m8309a(final String str) {
        File[] listFiles;
        String m8604h = Settings.m8618a().m8604h();
        if (C2160n.m5855a((CharSequence) m8604h)) {
            return null;
        }
        File file = new File(m8604h);
        if (!file.exists() || !file.canRead() || (listFiles = file.listFiles(new FilenameFilter() { // from class: com.navatics.app.framework.firmware.-$$Lambda$d$gm4P78CyFm-e9ngvKgdRifVaoEU
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str2) {
                return Firmware.m13062lambda$gm4P78CyFme9ngvKgdRifVaoEU(str, file2, str2);
            }
        })) == null || listFiles.length == 0) {
            return null;
        }
        return listFiles[0].getAbsolutePath();
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m8307a(String str, File file, String str2) {
        return str2.contains(str) && str2.endsWith(".bin");
    }

    /* renamed from: a */
    public int m8318a() {
        return this.f4551d;
    }

    /* renamed from: a */
    private InputMessage m8310a(UpdateOutputMessage updateOutputMessage) throws IOException, InterruptedException, TimeoutException {
        if (updateOutputMessage.m6503k() == 20) {
            int i = this.f4550c;
            this.f4550c = i + 1;
            updateOutputMessage.mo6463b(i);
        } else if (updateOutputMessage.m6503k() != 21) {
            if (updateOutputMessage.m6503k() == 19) {
                updateOutputMessage.mo6463b(255);
            } else if (updateOutputMessage.m6503k() != 22) {
                WLog.m5844i("Firmware", "unknown UpdateOutputMessage type " + updateOutputMessage.getClass().getName());
                throw new RuntimeException("unknown UpdateOutputMessage type " + updateOutputMessage.getClass().getName());
            }
        }
        InputMessage inputMessage = null;
        TimeoutTracker timeoutTracker = new TimeoutTracker(10000L);
        timeoutTracker.m8161a();
        long j = 0;
        while (!timeoutTracker.m8160b()) {
            this.f4553f.mo8162a(updateOutputMessage);
            try {
                inputMessage = this.f4553f.mo8163a(500L);
            } catch (TimeoutException unused) {
                j += 500;
                if (j > 2000) {
                    SPM_Manager.GetInstance().GetUserCmd().SendCmd((byte) -16, this.f4562o);
                    j = 0;
                }
            }
            if (inputMessage == null) {
                break;
            } else if (inputMessage.m6503k() == 37) {
                UpdateReplyMessage updateReplyMessage = (UpdateReplyMessage) inputMessage;
                int m6453c = updateReplyMessage.m6453c();
                if (m6453c == updateOutputMessage.m6462c()) {
                    break;
                } else if (!updateReplyMessage.m6455b()) {
                    timeoutTracker.m8159c();
                    timeoutTracker.m8161a();
                } else {
                    WLog.m5844i("Firmware", "data response expect serial " + updateOutputMessage.m6462c() + " but got " + m6453c);
                    throw new RuntimeException("data response expect serial " + updateOutputMessage.m6462c() + " but got " + m6453c);
                }
            } else if (inputMessage.m6503k() == 23) {
                if (((UpdateFinishMessage) inputMessage).m6466b()) {
                    break;
                }
                timeoutTracker.m8159c();
                timeoutTracker.m8161a();
            } else if (inputMessage.m6503k() == 38) {
                UpdateReplyForCrcMessage updateReplyForCrcMessage = (UpdateReplyForCrcMessage) inputMessage;
                int m6458c = updateReplyForCrcMessage.m6458c();
                if (m6458c == updateOutputMessage.m6462c()) {
                    break;
                } else if (!updateReplyForCrcMessage.m6460b()) {
                    timeoutTracker.m8159c();
                    timeoutTracker.m8161a();
                } else {
                    WLog.m5844i("Firmware", "crc response expect serial " + updateOutputMessage.m6462c() + " but got " + m6458c);
                    throw new RuntimeException("crc response expect serial " + updateOutputMessage.m6462c() + " but got " + m6458c);
                }
            } else {
                WLog.m5844i("Firmware", "dfdfdfddf");
                throw new RuntimeException("dfdfdfddf");
            }
        }
        if (timeoutTracker.m8160b()) {
            WLog.m5844i("Firmware", "sendAndGetReply timeout after 10000ms");
            throw new TimeoutException("sendAndGetReply timeout after 10000ms");
        }
        updateOutputMessage.mo6369a();
        return inputMessage;
    }

    /* renamed from: b */
    public String m8305b() {
        return this.f4554g;
    }

    /* renamed from: a */
    public void m8306a(boolean z) {
        if (this.f4556i != z) {
            this.f4556i = z;
        }
    }

    /* renamed from: a */
    public void m8312a(UpdateLogger updateLogger) {
        ((C1806a) this.f4557j).m8299a(updateLogger);
    }

    /* renamed from: c */
    private AbstractC2901p m8300c() {
        return AndroidSchedulers.m3250a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00ec, code lost:
        throw new java.lang.Exception("sector not changed, impossible!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00ed, code lost:
        r17.f4557j.mo8157a(java.lang.String.format(java.util.Locale.getDefault(), "send CRC value : 0x%08x for sector %d", java.lang.Integer.valueOf(r17.f4555h.m6424a(r7)), java.lang.Integer.valueOf(r7)));
        r1 = m8310a((com.navatics.robot.protocol.UpdateCRCMessage) com.navatics.robot.protocol.UpdateCRCMessage.m6475a(r17.f4555h.m6424a(r7)).mo6463b(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0126, code lost:
        if (r1 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x012e, code lost:
        if (r1.m6503k() == 38) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0135, code lost:
        if (r1.mo6451e() == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0137, code lost:
        r1.mo6369a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x013c, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x013d, code lost:
        r17.f4557j.mo8157a(java.lang.String.format(" ----- Send sector " + r7 + " complete, bytes:%d. -----", java.lang.Long.valueOf(r10)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0167, code lost:
        if (r1 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0169, code lost:
        r3 = r1.m6503k();
        r1.mo6369a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0171, code lost:
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0172, code lost:
        r18.mo8167b();
        com.navatics.xlog.WLog.m5844i("Firmware", "crc reply packet receive failed, expect MSG_REPLAY but got : " + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01a1, code lost:
        throw new java.lang.Exception("crc reply packet receive failed, expect MSG_REPLAY but got : " + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01a2, code lost:
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00ad, code lost:
        r17.f4557j.mo8157a("sector " + r7 + " has been sent finish.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00cc, code lost:
        if (r10 <= 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00ce, code lost:
        r1 = r17.f4555h.m6425a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00d6, code lost:
        if (r10 != r21) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00d8, code lost:
        if (r1 == r7) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00db, code lost:
        r18.mo8167b();
        com.navatics.xlog.WLog.m5844i("Firmware", "sector not changed, impossible!");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long m8313a(com.navatics.app.framework.firmware.NavaticsUpdateFile r18, long r19, long r21, com.navatics.app.framework.firmware.Firmware.InterfaceC1807b r23) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.navatics.app.framework.firmware.Firmware.m8313a(com.navatics.app.framework.firmware.i, long, long, com.navatics.app.framework.firmware.d$b):long");
    }

    /* renamed from: a */
    public void m8303b(String str, InterfaceC1807b interfaceC1807b) throws Exception {
        this.f4557j.mo8155b("Firmware update start!");
        File file = new File(str);
        this.f4559l = file.length();
        UpdateLogger updateLogger = this.f4557j;
        updateLogger.mo8157a("fileSize : " + this.f4559l);
        NavaticsUpdateFile m8171a = NavaticsUpdateFile.m8171a(file);
        interfaceC1807b.mo8184a();
        this.f4557j.mo8157a("update starting...");
        this.f4553f = RobotSocket.m8165a(1, this.f4557j);
        InputMessage m8310a = m8310a(UpdateStartMessage.m6450d());
        if (m8310a == null || m8310a.m6503k() != 37) {
            m8171a.mo8167b();
            StringBuilder sb = new StringBuilder();
            sb.append("UpdateStartMessage recv failed, got msg but NOT MSG_REPLAY : ");
            sb.append(m8310a == null ? "null" : Integer.valueOf(m8310a.m6503k()));
            WLog.m5844i("Firmware", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("UpdateStartMessage recv failed, got msg but NOT MSG_REPLAY : ");
            sb2.append(m8310a == null ? "null" : Integer.valueOf(m8310a.m6503k()));
            throw new Exception(sb2.toString());
        }
        UpdateReplyMessage updateReplyMessage = (UpdateReplyMessage) m8310a;
        if (!updateReplyMessage.m6455b()) {
            m8171a.mo8167b();
            WLog.m5844i("Firmware", "UpdateStartMessage recv failed, err = " + updateReplyMessage.mo6451e());
            throw new Exception("UpdateStartMessage recv failed, err = " + updateReplyMessage.mo6451e());
        }
        updateReplyMessage.mo6369a();
        this.f4557j.mo8157a("Got MSG_REPLAY for MSG_START");
        this.f4557j.mo8157a("Sending firmware...");
        while (true) {
            long j = this.f4560m;
            int i = this.f4561n;
            int m6425a = this.f4555h.m6425a();
            if (m8313a(m8171a, this.f4555h.m6420d(m6425a), this.f4555h.m6422b(m6425a), interfaceC1807b) > 0) {
                if (this.f4560m >= this.f4559l) {
                    break;
                }
            } else {
                this.f4555h.m6421c(m6425a);
                this.f4560m = j;
                this.f4561n = i;
                this.f4557j.mo8158a(this.f4560m, this.f4559l);
                Log.i("info1", "performUpdate: " + this.f4560m + " total " + this.f4559l);
                interfaceC1807b.mo8183a((long) ((int) ((((double) this.f4560m) * 100.0d) / ((double) this.f4559l))));
            }
        }
        m8171a.mo8167b();
        this.f4557j.mo8157a("Sending MSG_END...");
        InputMessage m8310a2 = m8310a(UpdateEndMessage.m6470a(this.f4561n));
        if (m8310a2 == null || m8310a2.m6503k() != 23) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Expect UpdateFinishMessage but got ");
            sb3.append(m8310a2 == null ? "null" : Integer.valueOf(m8310a2.m6503k()));
            WLog.m5844i("Firmware", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Expect UpdateFinishMessage but got ");
            sb4.append(m8310a2 == null ? "null" : Integer.valueOf(m8310a2.m6503k()));
            throw new Exception(sb4.toString());
        }
        UpdateFinishMessage updateFinishMessage = (UpdateFinishMessage) m8310a2;
        if (!updateFinishMessage.m6466b()) {
            WLog.m5844i("Firmware", "UpdateFinishMessage recv err code : " + updateFinishMessage.mo6451e());
            throw new Exception("UpdateFinishMessage recv err code : " + updateFinishMessage.mo6451e());
        }
        this.f4557j.mo8157a("Receive MSG_FINISH OK.");
    }

    /* renamed from: b */
    private void m8304b(InterfaceC1807b interfaceC1807b) {
        m8315a(interfaceC1807b, (Throwable) null);
    }

    /* renamed from: a */
    private void m8315a(InterfaceC1807b interfaceC1807b, Throwable th) {
        this.f4552e.m7879f().m6027c().mo6071d();
        if (th != null) {
            interfaceC1807b.mo8182a(th);
        } else {
            interfaceC1807b.mo8181b();
        }
    }

    /* renamed from: a */
    public synchronized void m8317a(final InterfaceC1807b interfaceC1807b) {
        NvSocket m7879f = this.f4552e.m7879f();
        if (m7879f.m6020i()) {
            this.f4557j.mo8153d("Device is not connected.");
            return;
        }
        this.f4551d = 1;
        f4549b.put(this.f4554g, this);
        m7879f.m6027c().mo6072c();
        Observable.m3088a(this.f4554g).m3075b(Schedulers.m3217b()).m3079b(new Consumer() { // from class: com.navatics.app.framework.firmware.-$$Lambda$d$PdDUd-IQIrP1M0Jr5dYqkWpEM9o
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                Firmware.m13061lambda$PdDUdIQIrP1M0Jr5dYqkWpEM9o(Firmware.this, interfaceC1807b, (String) obj);
            }
        }).m3091a(m8300c()).m3107a(new Consumer() { // from class: com.navatics.app.framework.firmware.-$$Lambda$d$QL5wLZPzNWV0eb3KX6e0f2JayTQ
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                Firmware.lambda$QL5wLZPzNWV0eb3KX6e0f2JayTQ(Firmware.this, interfaceC1807b, (String) obj);
            }
        }, new Consumer() { // from class: com.navatics.app.framework.firmware.-$$Lambda$d$XxUuYi9KHZ4af0wxxqGbJuJRhyc
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                Firmware.lambda$XxUuYi9KHZ4af0wxxqGbJuJRhyc(Firmware.this, interfaceC1807b, (Throwable) obj);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m8316a(InterfaceC1807b interfaceC1807b, String str) throws Exception {
        this.f4551d = 2;
        f4549b.remove(this.f4554g);
        this.f4557j.mo8155b("Update success.");
        m8304b(interfaceC1807b);
    }

    /* renamed from: b */
    public /* synthetic */ void m8302b(InterfaceC1807b interfaceC1807b, Throwable th) throws Exception {
        this.f4551d = -1;
        f4549b.remove(this.f4554g);
        this.f4557j.mo8156a("Update error.", th);
        m8315a(interfaceC1807b, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Firmware.java */
    /* renamed from: com.navatics.app.framework.firmware.d$a */
    /* loaded from: classes.dex */
    public class C1806a implements UpdateLogger {

        /* renamed from: a */
        UpdateLogger f4563a;

        C1806a() {
            Firmware.this = r1;
        }

        /* renamed from: a */
        public void m8299a(UpdateLogger updateLogger) {
            this.f4563a = updateLogger;
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: a */
        public void mo8157a(String str) {
            UpdateLogger updateLogger;
            WLog.m5844i("Firmware", str);
            Firmware.this.f4558k.mo8421a(str);
            if (!Firmware.this.f4556i || (updateLogger = this.f4563a) == null) {
                return;
            }
            updateLogger.mo8157a(str);
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: b */
        public void mo8155b(String str) {
            UpdateLogger updateLogger;
            WLog.m5844i("Firmware", str);
            Firmware.this.f4558k.mo8421a(str);
            if (!Firmware.this.f4556i || (updateLogger = this.f4563a) == null) {
                return;
            }
            updateLogger.mo8155b(str);
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: c */
        public void mo8154c(String str) {
            UpdateLogger updateLogger;
            WLog.m5844i("Firmware", str);
            Firmware.this.f4558k.mo8421a(str);
            if (!Firmware.this.f4556i || (updateLogger = this.f4563a) == null) {
                return;
            }
            updateLogger.mo8154c(str);
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: d */
        public void mo8153d(String str) {
            UpdateLogger updateLogger;
            WLog.m5844i("Firmware", str);
            Firmware.this.f4558k.mo8421a(str);
            if (!Firmware.this.f4556i || (updateLogger = this.f4563a) == null) {
                return;
            }
            updateLogger.mo8153d(str);
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: a */
        public void mo8156a(String str, Throwable th) {
            UpdateLogger updateLogger;
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            WLog.m5844i("Firmware", str + ", throwable msg : " + th.getMessage() + ", backtrace : " + stringWriter.toString());
            MessageLogger messageLogger = Firmware.this.f4558k;
            messageLogger.mo8421a(str + ", throwable msg : " + th.getMessage() + ", backtrace : " + stringWriter.toString());
            if (!Firmware.this.f4556i || (updateLogger = this.f4563a) == null) {
                return;
            }
            updateLogger.mo8156a(str, th);
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: a */
        public void mo8158a(long j, long j2) {
            UpdateLogger updateLogger;
            if (!Firmware.this.f4556i || (updateLogger = this.f4563a) == null) {
                return;
            }
            updateLogger.mo8158a(j, j2);
        }
    }
}
