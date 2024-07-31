package com.navatics.robot.protocol.p061a;

import com.navatics.miya.Miya;
import com.navatics.miya.p059a.Input;
import com.navatics.miya.p059a.Output;
import com.navatics.robot.protocol.Dawn;
import com.navatics.robot.protocol.RobotMessage;
import com.navatics.robot.protocol.p061a.MCMOperation;
import com.navatics.robot.protocol.p061a.MCMPacket;
import com.navatics.robot.transport.NvEvent;
import com.navatics.robot.transport.NvEventHandler;
import com.navatics.robot.utils.CargoMsg;
import com.navatics.robot.utils.CargoThread;
import com.navatics.robot.utils.PipelineOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.protocol.a.f */
/* loaded from: classes.dex */
public class MCMSocket {

    /* renamed from: a */
    public static final C3044k f6224a = C3044k.m1564a(MCMSocket.class);

    /* renamed from: b */
    private Dawn f6225b;

    /* renamed from: c */
    private MCMOperation f6226c;

    /* renamed from: e */
    private InterfaceC2100d f6228e;

    /* renamed from: i */
    private C2099c f6232i;

    /* renamed from: d */
    private List<AbstractC2098b> f6227d = new ArrayList();

    /* renamed from: f */
    private PipelineOutputStream f6229f = new PipelineOutputStream();

    /* renamed from: g */
    private DataInputStream f6230g = new DataInputStream(this.f6229f.m5873a());

    /* renamed from: h */
    private Input f6231h = new Input(this.f6230g);

    /* compiled from: MCMSocket.java */
    /* renamed from: com.navatics.robot.protocol.a.f$d */
    /* loaded from: classes.dex */
    public interface InterfaceC2100d {
        /* renamed from: a */
        void mo6538a(MCMOperation.C2095a c2095a);
    }

    public MCMSocket(Dawn dawn) {
        this.f6225b = dawn;
        C2097a c2097a = new C2097a();
        C2101e c2101e = new C2101e();
        this.f6227d.add(c2097a);
        this.f6227d.add(c2101e);
        this.f6232i = new C2099c();
        this.f6232i.start();
    }

    /* renamed from: a */
    public void m6545a(MCMOperation mCMOperation) {
        try {
            if (this.f6232i != null) {
                this.f6232i.m5899a(1, mCMOperation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public MCMOperation.C2095a m6541b(MCMOperation mCMOperation) {
        m6539c(mCMOperation);
        f6224a.mo1511a((Object) ("op " + mCMOperation.m6556a() + " already sent."));
        int m6556a = mCMOperation.m6556a();
        if (m6556a != 5) {
            switch (m6556a) {
                case 1:
                    int m6769d = this.f6231h.m6769d();
                    MCMOperation.C2095a c2095a = null;
                    ArrayList arrayList = null;
                    for (int i = 0; i < m6769d; i++) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(new MediaEntity(this.f6231h.m6779a(), this.f6231h.m6767e()));
                        c2095a = new MCMOperation.C2095a(mCMOperation, arrayList);
                    }
                    return c2095a;
                case 2:
                    this.f6231h.m6774b();
                    this.f6225b.mo6410b().m6025d().mo6072c();
                    return null;
                case 3:
                default:
                    return null;
            }
        }
        this.f6225b.mo6410b().m6025d().mo6071d();
        return null;
    }

    /* renamed from: c */
    private void m6539c(MCMOperation mCMOperation) {
        Miya m6744a = Miya.m6744a();
        Output output = new Output();
        m6744a.m6742a(output, mCMOperation);
        byte[] m6764a = output.m6764a();
        int m6749b = output.m6749b();
        int i = (m6749b / 255) + 1;
        int i2 = 0;
        int i3 = 0;
        do {
            int i4 = m6749b <= 255 ? m6749b : 255;
            m6544a(MCMPacket.m6549a(new MCMPacket.C2096a(i, i2, i4), m6764a, i3, i4));
            i2++;
            m6749b -= i4;
            i3 += i4;
        } while (m6749b > 0);
        this.f6226c = mCMOperation;
    }

    /* renamed from: a */
    private void m6544a(MCMPacket mCMPacket) {
        byte[] m6550a = mCMPacket.m6550a();
        int length = m6550a.length;
        int i = 0;
        do {
            int i2 = length <= 36 ? length : 36;
            MCMOutputMessage.m6552a(m6550a, i, i2);
            length -= i2;
            i += i2;
        } while (length > 0);
    }

    /* compiled from: MCMSocket.java */
    /* renamed from: com.navatics.robot.protocol.a.f$c */
    /* loaded from: classes.dex */
    class C2099c extends CargoThread {
        @Override // com.navatics.robot.utils.CargoThread
        /* renamed from: a */
        protected void mo5901a() {
        }

        @Override // com.navatics.robot.utils.CargoThread
        /* renamed from: b */
        protected void mo5896b() {
        }

        C2099c() {
        }

        @Override // com.navatics.robot.utils.CargoThread
        /* renamed from: a */
        protected void mo5898a(CargoMsg cargoMsg) throws Exception {
            if (cargoMsg.m5909a() == 1) {
                MCMOperation.C2095a m6541b = MCMSocket.this.m6541b((MCMOperation) cargoMsg.m5903c());
                if (MCMSocket.this.f6228e != null) {
                    MCMSocket.this.f6228e.mo6538a(m6541b);
                }
            }
        }
    }

    /* compiled from: MCMSocket.java */
    /* renamed from: com.navatics.robot.protocol.a.f$b */
    /* loaded from: classes.dex */
    abstract class AbstractC2098b {
        /* renamed from: a */
        abstract void mo6537a(Object obj);

        AbstractC2098b() {
        }
    }

    /* compiled from: MCMSocket.java */
    /* renamed from: com.navatics.robot.protocol.a.f$a */
    /* loaded from: classes.dex */
    class C2097a extends AbstractC2098b implements NvEventHandler {
        C2097a() {
            super();
        }

        @Override // com.navatics.robot.protocol.p061a.MCMSocket.AbstractC2098b
        /* renamed from: a */
        void mo6537a(Object obj) {
            RobotMessage robotMessage = (RobotMessage) obj;
            if (robotMessage.m6503k() != 130) {
                return;
            }
            MCMInputMessage mCMInputMessage = (MCMInputMessage) robotMessage;
            try {
                MCMSocket.f6224a.mo1499d(mCMInputMessage);
                MCMSocket.this.f6229f.write(mCMInputMessage.m6559b());
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        @Override // com.navatics.robot.transport.NvEventHandler
        /* renamed from: a */
        public void mo6007a(NvEvent nvEvent) {
            mo6537a(nvEvent.f6566f);
        }
    }

    /* compiled from: MCMSocket.java */
    /* renamed from: com.navatics.robot.protocol.a.f$e */
    /* loaded from: classes.dex */
    class C2101e extends AbstractC2098b {
        @Override // com.navatics.robot.protocol.p061a.MCMSocket.AbstractC2098b
        /* renamed from: a */
        void mo6537a(Object obj) {
        }

        C2101e() {
            super();
        }
    }
}
