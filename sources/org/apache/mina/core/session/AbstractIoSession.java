package org.apache.mina.core.session;

import com.github.mikephil.charting.utils.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.mina.core.p129a.AbstractC3054b;
import org.apache.mina.core.p130b.DefaultFileRegion;
import org.apache.mina.core.p130b.FilenameFileRegion;
import org.apache.mina.core.p131c.CloseFuture;
import org.apache.mina.core.p131c.DefaultCloseFuture;
import org.apache.mina.core.p131c.DefaultReadFuture;
import org.apache.mina.core.p131c.DefaultWriteFuture;
import org.apache.mina.core.p131c.IoFutureListener;
import org.apache.mina.core.p131c.ReadFuture;
import org.apache.mina.core.p131c.WriteFuture;
import org.apache.mina.core.p133e.AbstractIoService;
import org.apache.mina.core.p133e.InterfaceC3064f;
import org.apache.mina.core.p133e.IoAcceptor;
import org.apache.mina.core.p133e.IoProcessor;
import org.apache.mina.core.p133e.IoService;
import org.apache.mina.core.p133e.TransportMetadata;
import org.apache.mina.core.write.DefaultWriteRequest;
import org.apache.mina.core.write.InterfaceC3088b;
import org.apache.mina.core.write.WriteRequestQueue;
import org.apache.mina.core.write.WriteTimeoutException;
import org.apache.mina.core.write.WriteToClosedSessionException;
import org.apache.mina.util.ExceptionMonitor;

/* renamed from: org.apache.mina.core.session.a */
/* loaded from: classes2.dex */
public abstract class AbstractIoSession implements IoSession {

    /* renamed from: A */
    private long f11476A;

    /* renamed from: B */
    private long f11477B;

    /* renamed from: C */
    private long f11478C;

    /* renamed from: D */
    private double f11479D;

    /* renamed from: E */
    private double f11480E;

    /* renamed from: F */
    private double f11481F;

    /* renamed from: G */
    private double f11482G;

    /* renamed from: K */
    private long f11486K;

    /* renamed from: L */
    private long f11487L;

    /* renamed from: M */
    private long f11488M;

    /* renamed from: a */
    protected IoSessionConfig f11490a;

    /* renamed from: d */
    private final InterfaceC3064f f11491d;

    /* renamed from: e */
    private final IoService f11492e;

    /* renamed from: j */
    private IoSessionAttributeMap f11494j;

    /* renamed from: k */
    private WriteRequestQueue f11495k;

    /* renamed from: l */
    private InterfaceC3088b f11496l;

    /* renamed from: m */
    private final long f11497m;

    /* renamed from: o */
    private long f11498o;

    /* renamed from: q */
    private volatile boolean f11500q;

    /* renamed from: w */
    private long f11506w;

    /* renamed from: x */
    private long f11507x;

    /* renamed from: y */
    private long f11508y;

    /* renamed from: z */
    private long f11509z;

    /* renamed from: f */
    private static final AttributeKey f11472f = new AttributeKey(AbstractIoSession.class, "readyReadFutures");

    /* renamed from: g */
    private static final AttributeKey f11473g = new AttributeKey(AbstractIoSession.class, "waitingReadFutures");

    /* renamed from: h */
    private static final IoFutureListener<CloseFuture> f11474h = new IoFutureListener<CloseFuture>() { // from class: org.apache.mina.core.session.a.1
        @Override // org.apache.mina.core.p131c.IoFutureListener
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo894a(CloseFuture closeFuture) {
            AbstractIoSession abstractIoSession = (AbstractIoSession) closeFuture.mo960e();
            abstractIoSession.f11504u.set(0);
            abstractIoSession.f11505v.set(0);
            abstractIoSession.f11479D = Utils.DOUBLE_EPSILON;
            abstractIoSession.f11481F = Utils.DOUBLE_EPSILON;
            abstractIoSession.f11480E = Utils.DOUBLE_EPSILON;
            abstractIoSession.f11482G = Utils.DOUBLE_EPSILON;
        }
    };

    /* renamed from: b */
    public static final InterfaceC3088b f11470b = new DefaultWriteRequest(new Object());

    /* renamed from: c */
    public static final InterfaceC3088b f11471c = new DefaultWriteRequest(DefaultWriteRequest.f11543a);

    /* renamed from: n */
    private static AtomicLong f11475n = new AtomicLong(0);

    /* renamed from: i */
    private final Object f11493i = new Object();

    /* renamed from: p */
    private final CloseFuture f11499p = new DefaultCloseFuture(this);

    /* renamed from: r */
    private boolean f11501r = false;

    /* renamed from: s */
    private boolean f11502s = false;

    /* renamed from: t */
    private final AtomicBoolean f11503t = new AtomicBoolean();

    /* renamed from: u */
    private final AtomicInteger f11504u = new AtomicInteger();

    /* renamed from: v */
    private final AtomicInteger f11505v = new AtomicInteger();

    /* renamed from: H */
    private AtomicInteger f11483H = new AtomicInteger();

    /* renamed from: I */
    private AtomicInteger f11484I = new AtomicInteger();

    /* renamed from: J */
    private AtomicInteger f11485J = new AtomicInteger();

    /* renamed from: N */
    private boolean f11489N = true;

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: q */
    public boolean mo989q() {
        return true;
    }

    /* renamed from: r */
    public abstract IoProcessor mo1035r();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractIoSession(IoService ioService) {
        this.f11492e = ioService;
        this.f11491d = ioService.mo1192u();
        long currentTimeMillis = System.currentTimeMillis();
        this.f11497m = currentTimeMillis;
        this.f11478C = currentTimeMillis;
        this.f11476A = currentTimeMillis;
        this.f11477B = currentTimeMillis;
        this.f11486K = currentTimeMillis;
        this.f11487L = currentTimeMillis;
        this.f11488M = currentTimeMillis;
        this.f11499p.mo1333a(f11474h);
        this.f11498o = f11475n.incrementAndGet();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: g */
    public final long mo999g() {
        return this.f11498o;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: p */
    public final boolean mo990p() {
        return !this.f11499p.mo1334a();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: o */
    public final boolean mo991o() {
        return this.f11500q || this.f11499p.mo1334a();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: b */
    public final CloseFuture mo1010b() {
        return this.f11499p;
    }

    /* renamed from: s */
    public final boolean m1051s() {
        return this.f11503t.get();
    }

    /* renamed from: t */
    public final void m1050t() {
        this.f11503t.set(false);
    }

    /* renamed from: b */
    public final boolean m1055b(boolean z) {
        if (z) {
            return this.f11503t.compareAndSet(false, z);
        }
        this.f11503t.set(z);
        return true;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: a */
    public final CloseFuture mo1011a(boolean z) {
        if (z) {
            return mo1016a();
        }
        return m1049u();
    }

    /* renamed from: u */
    public final CloseFuture m1049u() {
        if (!mo991o()) {
            mo1018P().mo958a(this, f11470b);
            mo1035r().mo1025b(this);
        }
        return this.f11499p;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: a */
    public final CloseFuture mo1016a() {
        synchronized (this.f11493i) {
            if (mo991o()) {
                return this.f11499p;
            }
            this.f11500q = true;
            try {
                m1048v();
            } catch (Exception e) {
                mo1002e().mo1101a((Throwable) e);
            }
            mo1002e().mo1088g();
            return this.f11499p;
        }
    }

    /* renamed from: v */
    protected void m1048v() {
        WriteFuture mo955a;
        if (this.f11495k != null) {
            while (!this.f11495k.mo957b(this)) {
                InterfaceC3088b mo956c = this.f11495k.mo956c(this);
                if (mo956c != null && (mo955a = mo956c.mo955a()) != null) {
                    mo955a.mo964a();
                }
            }
        }
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: f */
    public InterfaceC3064f mo1000f() {
        return this.f11491d;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: c */
    public IoSessionConfig mo1007c() {
        return this.f11490a;
    }

    /* renamed from: f */
    public final void m1052f(Object obj) {
        m1080C().mo1315b(obj);
    }

    /* renamed from: a */
    public final void m1069a(Throwable th) {
        m1080C().mo1316a(th);
    }

    /* renamed from: w */
    public final void m1047w() {
        synchronized (m1079D()) {
            m1080C().mo1317a();
        }
    }

    /* renamed from: C */
    private ReadFuture m1080C() {
        ReadFuture poll;
        Queue<ReadFuture> m1079D = m1079D();
        Queue<ReadFuture> m1078E = m1078E();
        synchronized (m1079D) {
            poll = m1078E.poll();
            if (poll == null) {
                poll = new DefaultReadFuture(this);
                m1079D.offer(poll);
            }
        }
        return poll;
    }

    /* renamed from: D */
    private Queue<ReadFuture> m1079D() {
        Queue<ReadFuture> queue = (Queue) mo1009b(f11472f);
        if (queue == null) {
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            Queue<ReadFuture> queue2 = (Queue) mo1005c(f11472f, concurrentLinkedQueue);
            return queue2 != null ? queue2 : concurrentLinkedQueue;
        }
        return queue;
    }

    /* renamed from: E */
    private Queue<ReadFuture> m1078E() {
        Queue<ReadFuture> queue = (Queue) mo1009b(f11473g);
        if (queue == null) {
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            Queue<ReadFuture> queue2 = (Queue) mo1005c(f11473g, concurrentLinkedQueue);
            return queue2 != null ? queue2 : concurrentLinkedQueue;
        }
        return queue;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: e */
    public WriteFuture mo1001e(Object obj) {
        return m1070a(obj, (SocketAddress) null);
    }

    /* renamed from: a */
    public WriteFuture m1070a(Object obj, SocketAddress socketAddress) {
        if (obj == null) {
            throw new IllegalArgumentException("Trying to write a null message : not allowed");
        }
        if (!mo992n().mo1153e() && socketAddress != null) {
            throw new UnsupportedOperationException();
        }
        if (mo991o() || !mo990p()) {
            DefaultWriteFuture defaultWriteFuture = new DefaultWriteFuture(this);
            defaultWriteFuture.mo962a((Throwable) new WriteToClosedSessionException(new DefaultWriteRequest(obj, defaultWriteFuture, socketAddress)));
            return defaultWriteFuture;
        }
        final FileChannel fileChannel = null;
        try {
            if ((obj instanceof AbstractC3054b) && !((AbstractC3054b) obj).mo1356m()) {
                throw new IllegalArgumentException("message is empty. Forgot to call flip()?");
            }
            if (obj instanceof FileChannel) {
                FileChannel fileChannel2 = (FileChannel) obj;
                obj = new DefaultFileRegion(fileChannel2, 0L, fileChannel2.size());
            } else if (obj instanceof File) {
                File file = (File) obj;
                FileChannel channel = new FileInputStream(file).getChannel();
                fileChannel = channel;
                obj = new FilenameFileRegion(file, channel, 0L, channel.size());
            }
            DefaultWriteFuture defaultWriteFuture2 = new DefaultWriteFuture(this);
            mo1002e().mo1094b(new DefaultWriteRequest(obj, defaultWriteFuture2, socketAddress));
            if (fileChannel != null) {
                defaultWriteFuture2.mo961a((IoFutureListener<?>) new IoFutureListener<WriteFuture>() { // from class: org.apache.mina.core.session.a.2
                    @Override // org.apache.mina.core.p131c.IoFutureListener
                    /* renamed from: a  reason: avoid collision after fix types in other method */
                    public void mo894a(WriteFuture writeFuture) {
                        try {
                            fileChannel.close();
                        } catch (IOException e) {
                            ExceptionMonitor.m808a().mo807a(e);
                        }
                    }
                });
            }
            return defaultWriteFuture2;
        } catch (IOException e) {
            ExceptionMonitor.m808a().mo807a(e);
            return DefaultWriteFuture.m1321a(this, e);
        }
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: b */
    public final Object mo1009b(Object obj) {
        return mo1014a(obj, (Object) null);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: a */
    public final Object mo1014a(Object obj, Object obj2) {
        return this.f11494j.mo986a(this, obj, obj2);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: b */
    public final Object mo1008b(Object obj, Object obj2) {
        return this.f11494j.mo984b(this, obj, obj2);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: d */
    public final Object mo1003d(Object obj) {
        return mo1008b(obj, Boolean.TRUE);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: c */
    public final Object mo1005c(Object obj, Object obj2) {
        return this.f11494j.mo983c(this, obj, obj2);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: c */
    public final Object mo1006c(Object obj) {
        return this.f11494j.mo987a(this, obj);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: a */
    public final boolean mo1015a(Object obj) {
        return this.f11494j.mo985b(this, obj);
    }

    /* renamed from: x */
    public final IoSessionAttributeMap m1046x() {
        return this.f11494j;
    }

    /* renamed from: a */
    public final void m1062a(IoSessionAttributeMap ioSessionAttributeMap) {
        this.f11494j = ioSessionAttributeMap;
    }

    /* renamed from: a */
    public final void m1060a(WriteRequestQueue writeRequestQueue) {
        this.f11495k = writeRequestQueue;
    }

    /* renamed from: y */
    public boolean m1045y() {
        return this.f11501r;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: Q */
    public boolean mo1017Q() {
        return this.f11502s;
    }

    /* renamed from: a */
    public final void m1071a(long j, long j2) {
        if (j <= 0) {
            return;
        }
        this.f11506w += j;
        this.f11476A = j2;
        this.f11483H.set(0);
        this.f11484I.set(0);
        if (mo993m() instanceof AbstractIoService) {
            ((AbstractIoService) mo993m()).m1215w().m1172a(j, j2);
        }
    }

    /* renamed from: a */
    public final void m1072a(long j) {
        this.f11508y++;
        this.f11476A = j;
        this.f11483H.set(0);
        this.f11484I.set(0);
        if (mo993m() instanceof AbstractIoService) {
            ((AbstractIoService) mo993m()).m1215w().m1166d(j);
        }
    }

    /* renamed from: a */
    public final void m1073a(int i, long j) {
        if (i <= 0) {
            return;
        }
        this.f11507x += i;
        this.f11477B = j;
        this.f11483H.set(0);
        this.f11485J.set(0);
        if (mo993m() instanceof AbstractIoService) {
            ((AbstractIoService) mo993m()).m1215w().m1174a(i, j);
        }
        m1074a(-i);
    }

    /* renamed from: a */
    public final void m1061a(InterfaceC3088b interfaceC3088b, long j) {
        Object mo836b = interfaceC3088b.mo836b();
        if ((mo836b instanceof AbstractC3054b) && ((AbstractC3054b) mo836b).mo1356m()) {
            return;
        }
        this.f11509z++;
        this.f11477B = j;
        if (mo993m() instanceof AbstractIoService) {
            ((AbstractIoService) mo993m()).m1215w().m1164e(j);
        }
        m1077F();
    }

    /* renamed from: a */
    public final void m1074a(int i) {
        this.f11504u.addAndGet(i);
        if (mo993m() instanceof AbstractIoService) {
            ((AbstractIoService) mo993m()).m1215w().m1175a(i);
        }
    }

    /* renamed from: z */
    public final void m1044z() {
        this.f11505v.incrementAndGet();
        if (mo993m() instanceof AbstractIoService) {
            ((AbstractIoService) mo993m()).m1215w().m1167d();
        }
    }

    /* renamed from: F */
    private void m1077F() {
        this.f11505v.decrementAndGet();
        if (mo993m() instanceof AbstractIoService) {
            ((AbstractIoService) mo993m()).m1215w().m1165e();
        }
    }

    /* renamed from: b */
    public final void m1056b(InterfaceC3088b interfaceC3088b) {
        Object mo836b = interfaceC3088b.mo836b();
        if (mo836b instanceof AbstractC3054b) {
            AbstractC3054b abstractC3054b = (AbstractC3054b) mo836b;
            if (abstractC3054b.mo1356m()) {
                m1074a(-abstractC3054b.mo1357l());
                return;
            } else {
                m1077F();
                return;
            }
        }
        m1077F();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: P */
    public final WriteRequestQueue mo1018P() {
        WriteRequestQueue writeRequestQueue = this.f11495k;
        if (writeRequestQueue != null) {
            return writeRequestQueue;
        }
        throw new IllegalStateException();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: N */
    public final InterfaceC3088b mo1019N() {
        return this.f11496l;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: a */
    public final void mo1012a(InterfaceC3088b interfaceC3088b) {
        this.f11496l = interfaceC3088b;
    }

    /* renamed from: A */
    public final void m1082A() {
        int mo982a = mo1007c().mo982a() << 1;
        if (mo982a <= mo1007c().mo975c()) {
            mo1007c().mo981a(mo982a);
        } else {
            mo1007c().mo981a(mo1007c().mo975c());
        }
        this.f11489N = true;
    }

    /* renamed from: B */
    public final void m1081B() {
        if (this.f11489N) {
            this.f11489N = false;
            return;
        }
        if (mo1007c().mo982a() > mo1007c().mo977b()) {
            mo1007c().mo981a(mo1007c().mo982a() >>> 1);
        }
        this.f11489N = true;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: d */
    public final long mo1004d() {
        return this.f11497m;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: h */
    public final long mo998h() {
        return Math.max(this.f11476A, this.f11477B);
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: i */
    public final long mo997i() {
        return this.f11476A;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: j */
    public final long mo996j() {
        return this.f11477B;
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: a */
    public final long mo1013a(IdleStatus idleStatus) {
        if (idleStatus == IdleStatus.f11537c) {
            return this.f11486K;
        }
        if (idleStatus == IdleStatus.f11535a) {
            return this.f11487L;
        }
        if (idleStatus == IdleStatus.f11536b) {
            return this.f11488M;
        }
        throw new IllegalArgumentException("Unknown idle status: " + idleStatus);
    }

    /* renamed from: a */
    public final void m1065a(IdleStatus idleStatus, long j) {
        if (idleStatus == IdleStatus.f11537c) {
            this.f11483H.incrementAndGet();
            this.f11486K = j;
        } else if (idleStatus == IdleStatus.f11535a) {
            this.f11484I.incrementAndGet();
            this.f11487L = j;
        } else if (idleStatus == IdleStatus.f11536b) {
            this.f11485J.incrementAndGet();
            this.f11488M = j;
        } else {
            throw new IllegalArgumentException("Unknown idle status: " + idleStatus);
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String toString() {
        String str;
        if (mo990p() || mo991o()) {
            String str2 = null;
            try {
                str = String.valueOf(mo994l());
            } catch (Exception e) {
                str = "Cannot get the remote address informations: " + e.getMessage();
            }
            try {
                str2 = String.valueOf(mo995k());
            } catch (Exception unused) {
            }
            if (mo993m() instanceof IoAcceptor) {
                return "(" + m1076G() + ": " + m1075H() + ", server, " + str + " => " + str2 + ')';
            }
            return "(" + m1076G() + ": " + m1075H() + ", client, " + str2 + " => " + str + ')';
        }
        return "(" + m1076G() + ") Session disconnected ...";
    }

    /* renamed from: G */
    private String m1076G() {
        String upperCase = Long.toHexString(mo999g()).toUpperCase();
        if (upperCase.length() <= 8) {
            return "0x00000000".substring(0, 10 - upperCase.length()) + upperCase;
        }
        return "0x" + upperCase;
    }

    /* renamed from: H */
    private String m1075H() {
        TransportMetadata n = mo992n();
        if (n == null) {
            return "null";
        }
        return n.mo1155c() + ' ' + n.mo1154d();
    }

    @Override // org.apache.mina.core.session.IoSession
    /* renamed from: m */
    public IoService mo993m() {
        return this.f11492e;
    }

    /* renamed from: a */
    public static void m1068a(Iterator<? extends IoSession> it, long j) {
        while (it.hasNext()) {
            IoSession next = it.next();
            if (!next.mo1010b().mo1334a()) {
                m1064a(next, j);
            }
        }
    }

    /* renamed from: a */
    public static void m1064a(IoSession ioSession, long j) {
        m1063a(ioSession, j, ioSession.mo1007c().mo976b(IdleStatus.f11537c), IdleStatus.f11537c, Math.max(ioSession.mo998h(), ioSession.mo1013a(IdleStatus.f11537c)));
        m1063a(ioSession, j, ioSession.mo1007c().mo976b(IdleStatus.f11535a), IdleStatus.f11535a, Math.max(ioSession.mo997i(), ioSession.mo1013a(IdleStatus.f11535a)));
        m1063a(ioSession, j, ioSession.mo1007c().mo976b(IdleStatus.f11536b), IdleStatus.f11536b, Math.max(ioSession.mo996j(), ioSession.mo1013a(IdleStatus.f11536b)));
        m1057b(ioSession, j);
    }

    /* renamed from: a */
    private static void m1063a(IoSession ioSession, long j, long j2, IdleStatus idleStatus, long j3) {
        if (j2 <= 0 || j3 == 0 || j - j3 < j2) {
            return;
        }
        ioSession.mo1002e().mo1100a(idleStatus);
    }

    /* renamed from: b */
    private static void m1057b(IoSession ioSession, long j) {
        InterfaceC3088b mo1019N;
        long mo972e = ioSession.mo1007c().mo972e();
        if (mo972e <= 0 || j - ioSession.mo996j() < mo972e || ioSession.mo1018P().mo957b(ioSession) || (mo1019N = ioSession.mo1019N()) == null) {
            return;
        }
        ioSession.mo1012a((InterfaceC3088b) null);
        WriteTimeoutException writeTimeoutException = new WriteTimeoutException(mo1019N);
        mo1019N.mo955a().mo962a(writeTimeoutException);
        ioSession.mo1002e().mo1101a((Throwable) writeTimeoutException);
        ioSession.mo1016a();
    }
}
