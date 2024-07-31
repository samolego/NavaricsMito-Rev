package com.navatics.robot.protocol;

import android.support.graphics.drawable.PathInterpolatorCompat;
import com.common.AUTOMATIVE_LIGHT;
import com.navatics.robot.protocol.p061a.MCMInputMessage;
import com.navatics.robot.transport.NvError;
import com.navatics.robot.transport.NvEvent;
import com.navatics.robot.transport.NvEventHandler;
import com.navatics.robot.transport.NvEventLoop;
import com.navatics.robot.transport.NvException;
import com.navatics.robot.transport.NvSocket;
import com.navatics.robot.transport.p063b.NvAbstractObservable;
import com.navatics.robot.utils.HexUtil;
import com.navatics.robot.utils.p065a.LoggerUtil;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.log4j.C3044k;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.navatics.robot.protocol.h */
/* loaded from: classes.dex */
public abstract class Dawn implements INvProtocol, NvEventHandler {

    /* renamed from: a */
    private static final C3044k f6420a = C3044k.m1564a(Dawn.class);

    /* renamed from: b */
    private static AtomicLong f6421b = new AtomicLong(0);

    /* renamed from: o */
    private static Dawn f6422o;

    /* renamed from: c */
    private NvSocket f6423c;

    /* renamed from: d */
    private NvEventHandler f6424d;

    /* renamed from: e */
    private InterfaceC2105a f6425e;

    /* renamed from: f */
    private InterfaceC2105a f6426f;

    /* renamed from: g */
    private InterfaceC2105a f6427g;

    /* renamed from: l */
    private C2106b f6432l;

    /* renamed from: p */
    private InterfaceC2107c f6435p;

    /* renamed from: h */
    private final int f6428h = PathInterpolatorCompat.MAX_NUM_POINTS;

    /* renamed from: i */
    private final Object f6429i = new Object();

    /* renamed from: j */
    private ConcurrentLinkedQueue<C2106b> f6430j = new ConcurrentLinkedQueue<>();

    /* renamed from: k */
    private ConcurrentLinkedQueue<C2106b> f6431k = new ConcurrentLinkedQueue<>();

    /* renamed from: m */
    private boolean f6433m = true;

    /* renamed from: n */
    private boolean f6434n = false;

    /* renamed from: q */
    private Runnable f6436q = new Runnable() { // from class: com.navatics.robot.protocol.h.1
        {
            Dawn.this = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Dawn.this.f6432l != null) {
                OutputMessage m6387b = Dawn.this.f6432l.m6387b();
                C3044k c3044k = Dawn.f6420a;
                c3044k.mo1504b((Object) ("Transaction_DEBUG msg " + m6387b.toString() + " timeout after 3s"));
                if (Dawn.this.f6435p != null) {
                    Dawn.this.f6435p.mo6380b(m6387b);
                }
                synchronized (Dawn.this) {
                    if (Dawn.this.f6432l != null) {
                        Dawn.this.f6432l.m6389a(ErrorResponse.m6376a(129));
                        Dawn.this.f6432l = null;
                    }
                    Dawn.this.notify();
                }
                Dawn.this.m6398e();
            }
        }
    };

    /* compiled from: Dawn.java */
    /* renamed from: com.navatics.robot.protocol.h$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2105a {
        /* renamed from: a */
        void mo6393a(InputMessage inputMessage);
    }

    /* compiled from: Dawn.java */
    /* renamed from: com.navatics.robot.protocol.h$c */
    /* loaded from: classes.dex */
    public interface InterfaceC2107c {
        /* renamed from: a */
        void mo6383a(OutputMessage outputMessage);

        /* renamed from: a */
        void mo6382a(OutputMessage outputMessage, InputMessage inputMessage);

        /* renamed from: a */
        void mo6381a(OutputMessage outputMessage, byte[] bArr, int i, int i2);

        /* renamed from: b */
        void mo6380b(OutputMessage outputMessage);
    }

    public static /* synthetic */ void lambda$Dk6NtFSnln0rTOU_OI9EodsKCEg(Dawn dawn) {
        dawn.m6396f();
    }

    public Dawn() {
        f6422o = this;
    }

    /* renamed from: a */
    public static Dawn m6419a() {
        return f6422o;
    }

    /* renamed from: a */
    public void m6414a(InterfaceC2107c interfaceC2107c) {
        this.f6435p = interfaceC2107c;
    }

    @Override // com.navatics.robot.protocol.INvProtocol
    /* renamed from: a */
    public void mo6411a(NvSocket nvSocket) {
        this.f6423c = nvSocket;
        C3044k c3044k = f6420a;
        c3044k.mo1500c((Object) ("attachSocket id " + nvSocket.m6035a()));
        this.f6423c.m6027c().m6346a(this);
    }

    @Override // com.navatics.robot.protocol.INvProtocol
    /* renamed from: b */
    public NvSocket mo6410b() {
        return this.f6423c;
    }

    /* renamed from: a */
    public void m6416a(InterfaceC2105a interfaceC2105a) {
        this.f6425e = interfaceC2105a;
    }

    /* renamed from: b */
    public void m6407b(InterfaceC2105a interfaceC2105a) {
        this.f6426f = interfaceC2105a;
    }

    /* renamed from: c */
    public void m6402c(InterfaceC2105a interfaceC2105a) {
        this.f6427g = interfaceC2105a;
    }

    /* renamed from: d */
    private C2106b m6399d(OutputMessage outputMessage) {
        C2106b c2106b = new C2106b(outputMessage);
        synchronized (this.f6429i) {
            boolean isEmpty = this.f6430j.isEmpty();
            if (!this.f6430j.offer(c2106b)) {
                C3044k c3044k = f6420a;
                c3044k.mo1504b((Object) ("add transaction #" + c2106b.m6392a() + " to pending list failed."));
                return null;
            }
            C3044k c3044k2 = f6420a;
            c3044k2.mo1511a((Object) ("Transaction_DEBUG schedule request : " + RobotMessage.m6505c(outputMessage.m6503k())));
            c2106b.m6385d();
            if (isEmpty) {
                m6398e();
            }
            return c2106b;
        }
    }

    /* renamed from: e */
    private void m6397e(OutputMessage outputMessage) throws IOException {
        InterfaceC2107c interfaceC2107c = this.f6435p;
        if (interfaceC2107c != null) {
            interfaceC2107c.mo6383a(outputMessage);
        }
        this.f6423c.m6027c().mo6073a(outputMessage.mo6368b());
    }

    /* renamed from: e */
    public void m6398e() {
        NvEventLoop.m6232a().mo6286a(new Runnable() { // from class: com.navatics.robot.protocol.-$$Lambda$h$Dk6NtFSnln0rTOU_OI9EodsKCEg
            @Override // java.lang.Runnable
            public final void run() {
                Dawn.lambda$Dk6NtFSnln0rTOU_OI9EodsKCEg(Dawn.this);
            }
        });
    }

    /* renamed from: f */
    public void m6396f() {
        C2106b poll;
        synchronized (this) {
            if (this.f6432l != null) {
                return;
            }
            synchronized (this.f6429i) {
                poll = this.f6430j.poll();
            }
            if (poll == null) {
                f6420a.mo1499d("performNextRequest but we already have a active transaction.");
                return;
            }
            this.f6432l = poll;
            poll.m6391a(2);
            NvEventLoop.m6232a().mo6285a(this.f6436q, 3000L);
            C3044k c3044k = f6420a;
            c3044k.mo1511a((Object) ("Transaction_DEBUG perform request : " + this.f6432l.f6442d.toString()));
            try {
                m6397e(this.f6432l.f6442d);
                if (this.f6433m) {
                    m6394h();
                }
            } catch (IOException e) {
                e.printStackTrace();
                this.f6432l.m6388a((Throwable) e);
                this.f6432l = null;
                m6398e();
            }
        }
    }

    /* renamed from: g */
    private void m6395g() {
        NvEventLoop.m6232a().mo6286a(new Runnable() { // from class: com.navatics.robot.protocol.h.2
            {
                Dawn.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                byte[] bArr = {-15, AUTOMATIVE_LIGHT.TRUN_ON, 0};
                NvEvent m6246a = NvEvent.m6246a(this, 131076, bArr, 1, 0, bArr.length);
                Dawn.this.mo6007a(m6246a);
                m6246a.m6245b();
            }
        });
    }

    /* renamed from: h */
    private void m6394h() {
        int k = this.f6432l.m6387b().m6503k();
        if ((17 == k || 16 == k || 18 == k || 32 == k || 48 == k || 33 == k || 49 == k) ? false : true) {
            return;
        }
        C3044k c3044k = f6420a;
        c3044k.mo1511a((Object) ("simulate result for request : " + this.f6432l.m6387b().toString()));
        m6395g();
    }

    /* renamed from: a */
    public C2106b m6417a(OutputMessage outputMessage) {
        if (!m6403c(outputMessage)) {
            throw new InvalidParameterException("OutputMessage is not transactional message");
        }
        return m6399d(outputMessage);
    }

    /* renamed from: b */
    public void m6408b(OutputMessage outputMessage) throws IOException {
        if (m6403c(outputMessage)) {
            return;
        }
        this.f6423c.m6027c().mo6073a(outputMessage.mo6368b());
        outputMessage.mo6369a();
    }

    /* renamed from: a */
    public static boolean m6418a(InputMessage inputMessage) {
        return inputMessage != null && inputMessage.m6503k() == 35;
    }

    /* renamed from: b */
    public static boolean m6409b(InputMessage inputMessage) {
        return inputMessage != null && inputMessage.m6503k() == 36;
    }

    /* renamed from: c */
    public static boolean m6403c(OutputMessage outputMessage) {
        return outputMessage.m6503k() == 80 || outputMessage.m6503k() == 16 || outputMessage.m6503k() == 17 || outputMessage.m6503k() == 18 || outputMessage.m6503k() == 32 || outputMessage.m6503k() == 68 || outputMessage.m6503k() == 67 || outputMessage.m6503k() == 65 || outputMessage.m6503k() == 66 || outputMessage.m6503k() == 49 || outputMessage.m6503k() == 33 || outputMessage.m6503k() == 69 || outputMessage.m6503k() == 48 || outputMessage.m6503k() == 70 || outputMessage.m6503k() == 146;
    }

    /* renamed from: a */
    public void m6415a(C2106b c2106b) {
        this.f6431k.remove(c2106b);
    }

    @Override // com.navatics.robot.transport.NvEventHandler
    /* renamed from: a */
    public void mo6007a(NvEvent nvEvent) {
        if (nvEvent.f6562b == 131073 || nvEvent.f6562b == 131076) {
            switch (nvEvent.f6563c) {
                case 1:
                    byte[] bArr = (byte[]) nvEvent.f6566f;
                    int i = nvEvent.f6564d;
                    int i2 = nvEvent.f6565e;
                    try {
                        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr, i, i2));
                        if (dataInputStream.readUnsignedByte() != 241) {
                            f6420a.mo1500c((Object) "invalid data, 0xF1 expected");
                            dataInputStream.close();
                            return;
                        }
                        int readUnsignedByte = dataInputStream.readUnsignedByte();
                        InputMessage inputMessage = null;
                        if (readUnsignedByte == 64) {
                            LoggerUtil.m5930a("MSG_REPLY");
                            synchronized (this) {
                                if (this.f6432l == null) {
                                    f6420a.mo1504b((Object) "we got reply message not in a transaction, something terrible must happened.");
                                    C3044k c3044k = f6420a;
                                    c3044k.mo1504b((Object) ("data : " + new String(HexUtil.m5884a(bArr, i, i2))));
                                    dataInputStream.close();
                                    return;
                                }
                                if (this.f6435p != null) {
                                    this.f6435p.mo6381a(this.f6432l.m6387b(), bArr, i, i2);
                                }
                                C3044k c3044k2 = f6420a;
                                c3044k2.mo1511a((Object) ("Transaction_DEBUG got resp for request : " + this.f6432l.m6387b().toString()));
                                NvEventLoop.m6232a().mo6284b(this.f6436q);
                                if (bArr.length == 3 && bArr[2] == -127) {
                                    C3044k c3044k3 = f6420a;
                                    c3044k3.mo1504b((Object) ("Transaction_DEBUG receive fail resp for msg " + this.f6432l.m6387b().toString()));
                                    ErrorResponse m6376a = ErrorResponse.m6376a(129);
                                    if (this.f6435p != null) {
                                        this.f6435p.mo6382a(this.f6432l.m6387b(), m6376a);
                                    }
                                    this.f6432l.m6389a(m6376a);
                                } else {
                                    ReplyMessage m6519a = ReplyMessage.m6519a(dataInputStream, this.f6432l.m6387b());
                                    if (m6519a == null) {
                                        C3044k c3044k4 = f6420a;
                                        c3044k4.mo1504b((Object) ("Transaction_DEBUG constor ReplayMessage failed for messageID : " + readUnsignedByte));
                                        if (this.f6435p != null) {
                                            this.f6435p.mo6382a(this.f6432l.m6387b(), null);
                                        }
                                        this.f6432l.m6389a((ErrorResponse) null);
                                    } else {
                                        if (this.f6435p != null) {
                                            this.f6435p.mo6382a(this.f6432l.m6387b(), m6519a);
                                        }
                                        this.f6432l.m6390a((InputMessage) m6519a);
                                        this.f6431k.offer(this.f6432l);
                                    }
                                }
                                this.f6432l = null;
                                notify();
                                dataInputStream.close();
                                m6396f();
                                return;
                            }
                        }
                        if (readUnsignedByte == 130) {
                            inputMessage = MCMInputMessage.m6560a(dataInputStream);
                        } else if (readUnsignedByte != 254) {
                            switch (readUnsignedByte) {
                                case 35:
                                    inputMessage = StatusMessage.m6502a(dataInputStream);
                                    break;
                                case 36:
                                    inputMessage = BuoyStatusMessage.m6566a(dataInputStream);
                                    break;
                                default:
                                    C3044k c3044k5 = f6420a;
                                    c3044k5.mo1504b((Object) ("unknown message id : " + readUnsignedByte));
                                    break;
                            }
                        } else {
                            inputMessage = RobotForceUpdateMessage.m6508a(dataInputStream);
                        }
                        dataInputStream.close();
                        if (this.f6425e != null && m6418a(inputMessage)) {
                            this.f6425e.mo6393a(inputMessage);
                            return;
                        } else if (this.f6426f != null && m6409b(inputMessage)) {
                            this.f6426f.mo6393a(inputMessage);
                            return;
                        } else if (this.f6425e != null && (inputMessage instanceof RobotForceUpdateMessage)) {
                            this.f6425e.mo6393a(inputMessage);
                            return;
                        } else if (this.f6424d != null && inputMessage != null) {
                            NvEvent.m6238c(this.f6424d, this, IjkMediaPlayer.OnNativeInvokeListener.CTRL_DID_TCP_OPEN, inputMessage).m6261a();
                            return;
                        } else if (inputMessage != null) {
                            NvEvent.m6249a(this, IjkMediaPlayer.OnNativeInvokeListener.CTRL_DID_TCP_OPEN, inputMessage).m6261a();
                            return;
                        } else {
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                case 2:
                default:
                    return;
            }
        }
    }

    /* compiled from: Dawn.java */
    /* renamed from: com.navatics.robot.protocol.h$b */
    /* loaded from: classes.dex */
    public class C2106b extends NvAbstractObservable<C2106b> {

        /* renamed from: d */
        OutputMessage f6442d;

        /* renamed from: e */
        InputMessage f6443e;

        /* renamed from: a */
        long f6439a = Dawn.f6421b.addAndGet(1);

        /* renamed from: c */
        AtomicInteger f6441c = new AtomicInteger(1);

        /* renamed from: b */
        volatile int f6440b = 1;

        C2106b(OutputMessage outputMessage) {
            Dawn.this = r3;
            this.f6442d = outputMessage;
        }

        /* renamed from: a */
        public long m6392a() {
            return this.f6439a;
        }

        /* renamed from: a */
        public void m6391a(int i) {
            synchronized (this) {
                this.f6440b = i;
            }
        }

        /* renamed from: b */
        public OutputMessage m6387b() {
            return this.f6442d;
        }

        /* renamed from: c */
        public InputMessage m6386c() {
            return this.f6443e;
        }

        /* renamed from: d */
        public void m6385d() {
            this.f6441c.addAndGet(1);
        }

        /* renamed from: e */
        public void m6384e() {
            C3044k c3044k = Dawn.f6420a;
            c3044k.mo1511a((Object) ("Transaction_DEBUG release ref : " + this.f6441c.get()));
            if (this.f6441c.get() != 0 && this.f6441c.decrementAndGet() == 0) {
                synchronized (this) {
                    if (this.f6440b != 3) {
                        C3044k c3044k2 = Dawn.f6420a;
                        c3044k2.mo1504b((Object) ("Transaction_DEBUG release transaction but state is :" + this.f6440b));
                        return;
                    }
                    Dawn.this.m6415a(this);
                    OutputMessage outputMessage = this.f6442d;
                    if (outputMessage != null) {
                        outputMessage.mo6369a();
                    }
                    InputMessage inputMessage = this.f6443e;
                    if (inputMessage != null) {
                        inputMessage.mo6369a();
                    }
                    this.f6442d = null;
                    this.f6443e = null;
                    m6315i();
                    Dawn.f6420a.mo1511a((Object) "Transaction_DEBUG release");
                }
            }
        }

        /* renamed from: a */
        public void m6390a(InputMessage inputMessage) {
            synchronized (this) {
                if (this.f6440b == 3) {
                    return;
                }
                this.f6440b = 3;
                this.f6443e = inputMessage;
                notifyAll();
                m6318b(this);
                m6384e();
            }
        }

        /* renamed from: a */
        public void m6389a(ErrorResponse errorResponse) {
            synchronized (this) {
                this.f6440b = 3;
                notifyAll();
            }
            if (errorResponse == null) {
                m6317b((Throwable) new NvException(new NvError(55, null)));
            } else {
                this.f6443e = errorResponse;
                m6317b((Throwable) new NvException(new NvError(55, null, errorResponse)));
            }
            m6384e();
        }

        /* renamed from: a */
        public void m6388a(Throwable th) {
            synchronized (this) {
                this.f6440b = 3;
                notifyAll();
            }
            m6317b((Throwable) new NvException(new NvError(55, th.getMessage(), th)));
            m6384e();
        }

        @Override // com.navatics.robot.transport.p063b.NvAbstractObservable, com.navatics.robot.transport.p063b.NvObservable
        /* renamed from: f */
        public boolean mo6310f() {
            return this.f6440b == 3;
        }

        public String toString() {
            if (this.f6442d == null) {
                return "Transaction:(invalid transaction)";
            }
            return "Transaction : (" + this.f6442d.toString() + ")";
        }
    }
}
