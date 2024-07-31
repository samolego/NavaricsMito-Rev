package com.navatics.app.framework.p054f;

import android.view.Surface;
import com.adapt.SPM_Rc;
import com.common.AUTOMATIVE_LIGHT;
import com.common.LOGIN_ACK_REL;
import com.navatics.app.framework.INvVideoPlayer;
import com.navatics.robot.transport.NvVideoChannel;
import com.navatics.xlog.WLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.C3044k;
import org.mp4parser.streaming.input.h264.H264NalUnitHeader;

/* renamed from: com.navatics.app.framework.f.j */
/* loaded from: classes.dex */
public class NvLocalServerPlayer implements INvVideoPlayer {

    /* renamed from: a */
    private static final C3044k f4496a = C3044k.m1564a(NvLocalServerPlayer.class);

    /* renamed from: b */
    private static final String f4497b = NvLocalServerPlayer.class.getSimpleName();

    /* renamed from: c */
    private static IServerSocketProvider f4498c;

    /* renamed from: d */
    private static NvLocalServerPlayer f4499d;

    /* renamed from: e */
    private ServerSocket f4500e;

    /* renamed from: f */
    private ArrayList<ClientSocket> f4501f = new ArrayList<>();

    /* renamed from: g */
    private ArrayList<ClientSocket> f4502g = new ArrayList<>();

    /* renamed from: h */
    private C1799a f4503h;

    /* renamed from: i */
    private C1800b f4504i;

    /* renamed from: j */
    private NvVideoChannel f4505j;

    /* renamed from: k */
    private OnH264DataAvailableCallback f4506k;

    @Override // com.navatics.app.framework.INvVideoPlayer
    /* renamed from: c */
    public String mo8013c() {
        return "nvix:nvssstreamserver";
    }

    /* renamed from: f */
    private static void m8372f() {
        if (f4499d != null) {
            throw new IllegalStateException("There's another video player instance running now.");
        }
    }

    /* renamed from: a */
    public static void m8382a(IServerSocketProvider iServerSocketProvider) {
        if (iServerSocketProvider != null) {
            f4498c = iServerSocketProvider;
        }
    }

    /* renamed from: a */
    public static NvLocalServerPlayer m8379a(NvVideoChannel nvVideoChannel) {
        NvLocalServerPlayer nvLocalServerPlayer;
        m8372f();
        synchronized (NvLocalServerPlayer.class) {
            m8372f();
            f4499d = new NvLocalServerPlayer(nvVideoChannel);
            nvLocalServerPlayer = f4499d;
        }
        return nvLocalServerPlayer;
    }

    private NvLocalServerPlayer(NvVideoChannel nvVideoChannel) {
        this.f4505j = nvVideoChannel;
    }

    @Override // com.navatics.app.framework.INvVideoPlayer
    /* renamed from: a */
    public void mo8015a(OnH264DataAvailableCallback onH264DataAvailableCallback) {
        this.f4506k = onH264DataAvailableCallback;
    }

    @Override // com.navatics.app.framework.INvVideoPlayer
    /* renamed from: a */
    public void mo8017a() {
        if (this.f4500e != null) {
            return;
        }
        try {
            this.f4500e = f4498c.mo8407a("nvssstreamserver");
            this.f4503h = new C1799a();
            this.f4503h.start();
            System.out.println("before waitForReady");
            this.f4503h.m8365a();
            System.out.println("after waitForReady");
        } catch (IOException e) {
            C3044k c3044k = f4496a;
            c3044k.mo1504b((Object) ("Server to establish connection exception:" + e.toString()));
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private void m8370g() {
        C1800b c1800b = this.f4504i;
        if (c1800b != null) {
            c1800b.m8359b();
            this.f4504i = null;
        }
        C1799a c1799a = this.f4503h;
        if (c1799a != null) {
            c1799a.m8364b();
            this.f4503h = null;
        }
    }

    @Override // com.navatics.app.framework.INvVideoPlayer
    /* renamed from: b */
    public void mo8014b() {
        m8370g();
        synchronized (NvLocalServerPlayer.class) {
            f4499d = null;
        }
    }

    @Override // com.navatics.app.framework.INvVideoPlayer
    /* renamed from: a */
    public void mo8016a(Surface surface) {
        throw new UnsupportedOperationException("don't support setPreviewSurface");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m8368h() {
        Iterator<ClientSocket> it = this.f4502g.iterator();
        while (it.hasNext()) {
            try {
                it.next().mo8409a();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.f4502g.clear();
        Iterator<ClientSocket> it2 = this.f4501f.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().mo8409a();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        this.f4501f.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m8366i() {
        m8368h();
        try {
            this.f4500e.mo8327a();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NvLocalServerPlayer.java */
    /* renamed from: com.navatics.app.framework.f.j$a */
    /* loaded from: classes.dex */
    public class C1799a extends Thread {

        /* renamed from: a */
        final Object f4507a = new Object();

        /* renamed from: b */
        boolean f4508b;

        /* renamed from: c */
        volatile boolean f4509c;

        C1799a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
            r0.mo8409a();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r4 = this;
                org.apache.log4j.k r0 = com.navatics.app.framework.p054f.NvLocalServerPlayer.m8376d()
                java.lang.String r1 = "StreamServer running."
                r0.mo1511a(r1)
                java.lang.Object r0 = r4.f4507a
                monitor-enter(r0)
                r1 = 1
                r4.f4508b = r1     // Catch: java.lang.Throwable -> Lc4
                java.lang.Object r1 = r4.f4507a     // Catch: java.lang.Throwable -> Lc4
                r1.notifyAll()     // Catch: java.lang.Throwable -> Lc4
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc4
            L15:
                boolean r0 = r4.f4509c
                if (r0 != 0) goto Lb5
                org.apache.log4j.k r0 = com.navatics.app.framework.p054f.NvLocalServerPlayer.m8376d()     // Catch: java.io.IOException -> L95
                java.lang.String r1 = "StreamServer accept begin..."
                r0.mo1511a(r1)     // Catch: java.io.IOException -> L95
                com.navatics.app.framework.f.j r0 = com.navatics.app.framework.p054f.NvLocalServerPlayer.this     // Catch: java.io.IOException -> L95
                com.navatics.app.framework.f.m r0 = com.navatics.app.framework.p054f.NvLocalServerPlayer.m8381a(r0)     // Catch: java.io.IOException -> L95
                com.navatics.app.framework.f.d r0 = r0.mo8326b()     // Catch: java.io.IOException -> L95
                org.apache.log4j.k r1 = com.navatics.app.framework.p054f.NvLocalServerPlayer.m8376d()     // Catch: java.io.IOException -> L95
                java.lang.String r2 = "StreamServer new client connected."
                r1.mo1500c(r2)     // Catch: java.io.IOException -> L95
                boolean r1 = r4.f4509c     // Catch: java.io.IOException -> L95
                if (r1 == 0) goto L3e
                r0.mo8409a()     // Catch: java.io.IOException -> L95
                goto Lb5
            L3e:
                com.navatics.app.framework.f.j r1 = com.navatics.app.framework.p054f.NvLocalServerPlayer.this     // Catch: java.io.IOException -> L95
                java.util.ArrayList r1 = com.navatics.app.framework.p054f.NvLocalServerPlayer.m8378b(r1)     // Catch: java.io.IOException -> L95
                boolean r1 = r1.isEmpty()     // Catch: java.io.IOException -> L95
                if (r1 == 0) goto L88
                com.navatics.app.framework.f.j r1 = com.navatics.app.framework.p054f.NvLocalServerPlayer.this     // Catch: java.io.IOException -> L95
                java.util.ArrayList r1 = com.navatics.app.framework.p054f.NvLocalServerPlayer.m8377c(r1)     // Catch: java.io.IOException -> L95
                boolean r1 = r1.isEmpty()     // Catch: java.io.IOException -> L95
                if (r1 != 0) goto L57
                goto L88
            L57:
                com.navatics.app.framework.f.j r1 = com.navatics.app.framework.p054f.NvLocalServerPlayer.this     // Catch: java.io.IOException -> L95
                java.util.ArrayList r1 = com.navatics.app.framework.p054f.NvLocalServerPlayer.m8378b(r1)     // Catch: java.io.IOException -> L95
                r1.add(r0)     // Catch: java.io.IOException -> L95
                com.navatics.app.framework.f.j r0 = com.navatics.app.framework.p054f.NvLocalServerPlayer.this     // Catch: java.io.IOException -> L95
                com.navatics.app.framework.f.j$b r0 = com.navatics.app.framework.p054f.NvLocalServerPlayer.m8375d(r0)     // Catch: java.io.IOException -> L95
                if (r0 != 0) goto L7e
                com.navatics.app.framework.f.j r0 = com.navatics.app.framework.p054f.NvLocalServerPlayer.this     // Catch: java.io.IOException -> L95
                com.navatics.app.framework.f.j$b r1 = new com.navatics.app.framework.f.j$b     // Catch: java.io.IOException -> L95
                com.navatics.app.framework.f.j r2 = com.navatics.app.framework.p054f.NvLocalServerPlayer.this     // Catch: java.io.IOException -> L95
                r1.<init>()     // Catch: java.io.IOException -> L95
                com.navatics.app.framework.p054f.NvLocalServerPlayer.m8380a(r0, r1)     // Catch: java.io.IOException -> L95
                com.navatics.app.framework.f.j r0 = com.navatics.app.framework.p054f.NvLocalServerPlayer.this     // Catch: java.io.IOException -> L95
                com.navatics.app.framework.f.j$b r0 = com.navatics.app.framework.p054f.NvLocalServerPlayer.m8375d(r0)     // Catch: java.io.IOException -> L95
                r0.start()     // Catch: java.io.IOException -> L95
                goto L15
            L7e:
                com.navatics.app.framework.f.j r0 = com.navatics.app.framework.p054f.NvLocalServerPlayer.this     // Catch: java.io.IOException -> L95
                com.navatics.app.framework.f.j$b r0 = com.navatics.app.framework.p054f.NvLocalServerPlayer.m8375d(r0)     // Catch: java.io.IOException -> L95
                r0.m8363a()     // Catch: java.io.IOException -> L95
                goto L15
            L88:
                java.lang.String r1 = com.navatics.app.framework.p054f.NvLocalServerPlayer.m8374e()     // Catch: java.io.IOException -> L95
                java.lang.String r2 = "refuse client because we already have one."
                com.navatics.xlog.WLog.m5840w(r1, r2)     // Catch: java.io.IOException -> L95
                r0.mo8409a()     // Catch: java.io.IOException -> L95
                goto L15
            L95:
                r0 = move-exception
                r0.printStackTrace()
                org.apache.log4j.k r1 = com.navatics.app.framework.p054f.NvLocalServerPlayer.m8376d()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "server socket accept raise an exception : "
                r2.append(r3)
                java.lang.String r0 = r0.toString()
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r1.mo1504b(r0)
            Lb5:
                com.navatics.app.framework.f.j r0 = com.navatics.app.framework.p054f.NvLocalServerPlayer.this
                com.navatics.app.framework.p054f.NvLocalServerPlayer.m8373e(r0)
                org.apache.log4j.k r0 = com.navatics.app.framework.p054f.NvLocalServerPlayer.m8376d()
                java.lang.String r1 = "StreamServer dead."
                r0.mo1504b(r1)
                return
            Lc4:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc4
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.navatics.app.framework.p054f.NvLocalServerPlayer.C1799a.run():void");
        }

        /* renamed from: a */
        public void m8365a() {
            synchronized (this.f4507a) {
                while (!this.f4508b) {
                    try {
                        this.f4507a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /* renamed from: b */
        void m8364b() {
            this.f4509c = true;
            try {
                NvLocalServerPlayer.this.f4500e.mo8327a();
            } catch (IOException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                try {
                    join();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            WLog.m5850d(NvLocalServerPlayer.f4497b, "Player AcceptThread quit");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NvLocalServerPlayer.java */
    /* renamed from: com.navatics.app.framework.f.j$b */
    /* loaded from: classes.dex */
    public class C1800b extends Thread {

        /* renamed from: a */
        volatile boolean f4511a;

        /* renamed from: b */
        volatile boolean f4512b;

        /* renamed from: c */
        final Object f4513c = new Object();

        /* renamed from: d */
        byte[] f4514d = {0, 0, 0, 1, 103, 77, 0, 42, -106, 53, AUTOMATIVE_LIGHT.TRUN_ON, -16, 4, 79, -53, 55, 1, 1, 1, AUTOMATIVE_LIGHT.TRUN_ON, 0, 0, 3, 0, AUTOMATIVE_LIGHT.TRUN_ON, 0, 0, SPM_Rc.VIBRATION_MODE.MAX_VOLUME, 33};

        /* renamed from: e */
        byte[] f4515e = {0, 0, 0, 1, 103, 77, 0, 42, -106, 53, AUTOMATIVE_LIGHT.TRUN_ON, -16, 4, 79, -53, 55, 1, 1, 1, AUTOMATIVE_LIGHT.TRUN_ON, 0, 0, 3, 0, AUTOMATIVE_LIGHT.TRUN_ON, 0, 0, LOGIN_ACK_REL.LOGIN_ACK_REL_REPEAT_LOGIN, -95};

        C1800b() {
        }

        /* renamed from: a */
        void m8363a() {
            if (this.f4512b) {
                synchronized (this.f4513c) {
                    if (this.f4512b) {
                        notify();
                    }
                }
            }
        }

        /* renamed from: a */
        private void m8362a(NalUnit nalUnit) {
            if (NvLocalServerPlayer.this.f4506k != null) {
                byte[] m8390b = nalUnit.m8390b();
                NvLocalServerPlayer.this.f4506k.mo8328a(m8390b, 0, m8390b.length);
            }
            if (NvLocalServerPlayer.this.f4502g.isEmpty()) {
                return;
            }
            Iterator it = NvLocalServerPlayer.this.f4502g.iterator();
            while (it.hasNext()) {
                ClientSocket clientSocket = (ClientSocket) it.next();
                try {
                    m8361a(clientSocket.mo8408b(), nalUnit);
                    NvLocalServerPlayer.this.f4501f.add(clientSocket);
                    it.remove();
                } catch (IOException e) {
                    NvLocalServerPlayer.f4496a.mo1504b((Object) "sendSpsToFreshClient error");
                    e.printStackTrace();
                    try {
                        clientSocket.mo8409a();
                    } catch (IOException unused) {
                    }
                    it.remove();
                }
            }
        }

        /* renamed from: b */
        private void m8358b(NalUnit nalUnit) {
            if (NvLocalServerPlayer.this.f4506k != null) {
                byte[] m8390b = nalUnit.m8390b();
                NvLocalServerPlayer.this.f4506k.mo8328a(m8390b, 0, m8390b.length);
            }
            Iterator it = NvLocalServerPlayer.this.f4501f.iterator();
            while (it.hasNext()) {
                ClientSocket clientSocket = (ClientSocket) it.next();
                try {
                    m8361a(clientSocket.mo8408b(), nalUnit);
                } catch (IOException e) {
                    NvLocalServerPlayer.f4496a.mo1504b((Object) "sendToClient error");
                    e.printStackTrace();
                    try {
                        clientSocket.mo8409a();
                    } catch (IOException unused) {
                    }
                    it.remove();
                }
            }
            Iterator it2 = NvLocalServerPlayer.this.f4502g.iterator();
            while (it2.hasNext()) {
                ClientSocket clientSocket2 = (ClientSocket) it2.next();
                try {
                    m8361a(clientSocket2.mo8408b(), nalUnit);
                } catch (IOException e2) {
                    NvLocalServerPlayer.f4496a.mo1504b((Object) "sendSpsToFreshClient error");
                    e2.printStackTrace();
                    try {
                        clientSocket2.mo8409a();
                    } catch (IOException unused2) {
                    }
                    it2.remove();
                }
            }
        }

        /* renamed from: c */
        private void m8356c(NalUnit nalUnit) {
            if (NvLocalServerPlayer.this.f4506k != null) {
                byte[] m8390b = nalUnit.m8390b();
                NvLocalServerPlayer.this.f4506k.mo8328a(m8390b, 0, m8390b.length);
            }
            Iterator it = NvLocalServerPlayer.this.f4501f.iterator();
            while (it.hasNext()) {
                ClientSocket clientSocket = (ClientSocket) it.next();
                try {
                    m8361a(clientSocket.mo8408b(), nalUnit);
                } catch (IOException e) {
                    NvLocalServerPlayer.f4496a.mo1504b((Object) "sendToClient error");
                    e.printStackTrace();
                    try {
                        clientSocket.mo8409a();
                    } catch (IOException unused) {
                    }
                    it.remove();
                }
            }
        }

        /* renamed from: a */
        private void m8360a(byte[] bArr, int i, int i2) {
            if (NvLocalServerPlayer.this.f4506k != null) {
                NvLocalServerPlayer.this.f4506k.mo8328a(bArr, i, i2);
            }
            if (i2 <= 0) {
                return;
            }
            Iterator it = NvLocalServerPlayer.this.f4501f.iterator();
            while (it.hasNext()) {
                ClientSocket clientSocket = (ClientSocket) it.next();
                try {
                    clientSocket.mo8408b().write(bArr, i, i2);
                } catch (IOException e) {
                    NvLocalServerPlayer.f4496a.mo1504b((Object) "sendToClient error");
                    e.printStackTrace();
                    try {
                        clientSocket.mo8409a();
                    } catch (IOException unused) {
                    }
                    it.remove();
                }
            }
        }

        /* renamed from: c */
        private boolean m8357c() {
            return NvLocalServerPlayer.this.f4501f.isEmpty() && NvLocalServerPlayer.this.f4502g.isEmpty();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr = new byte[65536];
            NvLocalServerPlayer.f4496a.mo1511a((Object) "dispatch thread running");
            NalStreamExtractor nalStreamExtractor = null;
            InputStream inputStream = null;
            while (!this.f4511a) {
                if (m8357c()) {
                    synchronized (this.f4513c) {
                        if (!this.f4512b && !this.f4511a) {
                            if (nalStreamExtractor != null) {
                                nalStreamExtractor.m8396b();
                                nalStreamExtractor = null;
                            }
                            this.f4512b = true;
                            try {
                                NvLocalServerPlayer.f4496a.mo1504b((Object) "DispatchThread going to sleep");
                                this.f4513c.wait();
                                NvLocalServerPlayer.f4496a.mo1504b((Object) "DispatchThread wake up to work.");
                                this.f4512b = false;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                NvLocalServerPlayer.f4496a.mo1504b((Object) "DispatchThread wake up to work.");
                                this.f4512b = false;
                            }
                        }
                    }
                    if (this.f4511a) {
                        break;
                    }
                }
                if (inputStream == null) {
                    try {
                        inputStream = NvLocalServerPlayer.this.f4505j.mo5954i();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        NvLocalServerPlayer.this.m8368h();
                    }
                }
                if (!NvLocalServerPlayer.this.f4502g.isEmpty()) {
                    if (nalStreamExtractor == null) {
                        nalStreamExtractor = new NalStreamExtractor(inputStream, false);
                    }
                    try {
                        NalUnit m8399a = nalStreamExtractor.m8399a();
                        H264NalUnitHeader m8394a = m8399a.m8394a();
                        if (m8394a.f12222b == 6) {
                            NvLocalServerPlayer.f4496a.mo1511a((Object) "send sei");
                            m8358b(m8399a);
                        } else if (m8394a.f12222b == 7) {
                            NvLocalServerPlayer.f4496a.mo1511a((Object) "send sps");
                            m8362a(m8399a);
                            byte[] m8398a = nalStreamExtractor.m8398a(false);
                            m8360a(m8398a, 0, m8398a.length);
                            nalStreamExtractor = null;
                        } else {
                            NvLocalServerPlayer.f4496a.mo1511a((Object) "send other nal");
                            m8356c(m8399a);
                        }
                        m8399a.m8387d();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        NvLocalServerPlayer.this.m8368h();
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        inputStream = null;
                    }
                } else {
                    if (nalStreamExtractor != null) {
                        WLog.m5840w(NvLocalServerPlayer.f4497b, "close extractor in data processing stage!");
                        byte[] m8398a2 = nalStreamExtractor.m8398a(false);
                        m8360a(m8398a2, 0, m8398a2.length);
                        nalStreamExtractor = null;
                    }
                    try {
                        int read = inputStream.read(bArr);
                        if (read < 0) {
                            throw new IOException("EOF");
                            break;
                        }
                        m8360a(bArr, 0, read);
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        NvLocalServerPlayer.this.m8368h();
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                        }
                        inputStream = null;
                    }
                }
            }
            NvLocalServerPlayer.f4496a.mo1499d("dispatch thread has exited.");
        }

        /* renamed from: a */
        void m8361a(OutputStream outputStream, NalUnit nalUnit) throws IOException {
            outputStream.write(nalUnit.m8390b());
        }

        /* renamed from: b */
        void m8359b() {
            this.f4511a = true;
            interrupt();
            try {
                join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
