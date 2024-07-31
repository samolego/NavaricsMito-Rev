package com.navatics.app.framework.p054f;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.navatics.app.framework.INvVideoPlayer;
import com.navatics.robot.transport.NvError;
import com.navatics.robot.transport.NvException;
import com.navatics.robot.transport.NvVideoChannel;
import com.navatics.robot.utils.C2160n;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.apache.log4j.C3044k;
import org.mp4parser.streaming.input.h264.H264NalUnitHeader;
import org.mp4parser.streaming.input.h264.spspps.PictureParameterSet;
import org.mp4parser.streaming.input.h264.spspps.SeqParameterSet;

/* renamed from: com.navatics.app.framework.f.k */
/* loaded from: classes.dex */
public class NvMediaCodecPlayer implements INvVideoPlayer {

    /* renamed from: a */
    private static final C3044k f4517a = C3044k.m1564a(NvMediaCodecPlayer.class);

    /* renamed from: b */
    private Surface f4518b;

    /* renamed from: c */
    private NvVideoChannel f4519c;

    /* renamed from: d */
    private C1802b f4520d;

    /* renamed from: e */
    private OnH264DataAvailableCallback f4521e;

    /* renamed from: f */
    private boolean f4522f;

    public NvMediaCodecPlayer(NvVideoChannel nvVideoChannel) {
        this.f4519c = nvVideoChannel;
        f4517a.mo1500c((Object) "using navatics video player");
        this.f4522f = m8344e();
    }

    @Override // com.navatics.app.framework.INvVideoPlayer
    /* renamed from: a */
    public void mo8015a(OnH264DataAvailableCallback onH264DataAvailableCallback) {
        this.f4521e = onH264DataAvailableCallback;
    }

    @Override // com.navatics.app.framework.INvVideoPlayer
    /* renamed from: a */
    public void mo8017a() {
        this.f4520d = new C1802b();
        this.f4520d.start();
    }

    @Override // com.navatics.app.framework.INvVideoPlayer
    /* renamed from: b */
    public void mo8014b() {
        if (this.f4520d.f4533a) {
            return;
        }
        this.f4520d.m8329a();
    }

    @Override // com.navatics.app.framework.INvVideoPlayer
    /* renamed from: c */
    public String mo8013c() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("don't support getLiveStreamUrl");
    }

    @Override // com.navatics.app.framework.INvVideoPlayer
    /* renamed from: a */
    public void mo8016a(Surface surface) throws UnsupportedOperationException {
        this.f4518b = surface;
    }

    /* renamed from: a */
    private void m8355a(NalUnit nalUnit, C1801a c1801a) {
        ByteBuffer m8392a = nalUnit.m8392a(false);
        m8392a.rewind();
        m8392a.position(1);
        try {
            c1801a.m8335a(SeqParameterSet.m415a(m8392a), nalUnit);
        } catch (IOException e) {
            throw new RuntimeException("That's surprising to get IOException when working on ByteArrayInputStream", e);
        }
    }

    /* renamed from: b */
    private void m8350b(NalUnit nalUnit, C1801a c1801a) {
        ByteBuffer m8392a = nalUnit.m8392a(false);
        m8392a.rewind();
        m8392a.position(1);
        try {
            c1801a.m8336a(PictureParameterSet.m417a(m8392a), nalUnit);
            if (this.f4522f) {
                return;
            }
            m8354a(c1801a);
        } catch (IOException e) {
            throw new RuntimeException("That's surprising to get IOException when working on ByteArrayInputStream", e);
        }
    }

    /* renamed from: e */
    private static boolean m8344e() {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                String lowerCase = codecInfoAt.getName().toLowerCase();
                if (!C2160n.m5855a((CharSequence) lowerCase) && lowerCase.startsWith("omx.exynos.avc.dec")) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m8354a(C1801a c1801a) {
        if (c1801a.f4524b == null) {
            return;
        }
        NalUnit nalUnit = c1801a.f4524b;
        NalUnit nalUnit2 = c1801a.f4526d;
        ByteBuffer m8392a = nalUnit.m8392a(true);
        ByteBuffer m8392a2 = nalUnit2.m8392a(true);
        m8392a.rewind();
        m8392a2.rewind();
        ByteBuffer allocate = ByteBuffer.allocate(m8392a.limit() + m8392a2.limit());
        allocate.put(m8392a);
        allocate.put(m8392a2);
        allocate.rewind();
        c1801a.m8337a(allocate, nalUnit.m8390b(), nalUnit2.m8390b());
    }

    /* renamed from: a */
    private void m8353a(C1801a c1801a, NalUnit nalUnit) throws IOException {
        if (!c1801a.m8334b()) {
            c1801a.m8343a();
        }
        if (c1801a.m8334b()) {
            c1801a.m8341a(nalUnit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m8348c(NalUnit nalUnit, C1801a c1801a) throws IOException {
        H264NalUnitHeader m8394a = nalUnit.m8394a();
        switch (m8394a.f12222b) {
            case 1:
                m8353a(c1801a, nalUnit);
                return true;
            case 2:
            case 3:
            case 4:
            case 6:
            case 9:
            case 10:
            case 11:
            case 13:
                return true;
            case 5:
                m8353a(c1801a, nalUnit);
                return true;
            case 7:
                m8355a(nalUnit, c1801a);
                return false;
            case 8:
                m8350b(nalUnit, c1801a);
                return false;
            case 12:
            default:
                C3044k c3044k = f4517a;
                c3044k.mo1499d("Unknown NAL unit type: " + m8394a.f12222b);
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NvMediaCodecPlayer.java */
    /* renamed from: com.navatics.app.framework.f.k$a */
    /* loaded from: classes.dex */
    public class C1801a {

        /* renamed from: a */
        SeqParameterSet f4523a;

        /* renamed from: b */
        NalUnit f4524b;

        /* renamed from: c */
        PictureParameterSet f4525c;

        /* renamed from: d */
        NalUnit f4526d;

        /* renamed from: e */
        MediaCodec f4527e;

        /* renamed from: f */
        long f4528f = 0;

        /* renamed from: g */
        transient long f4529g;

        /* renamed from: h */
        long f4530h;

        /* renamed from: i */
        boolean f4531i;

        C1801a() {
        }

        /* renamed from: a */
        void m8335a(SeqParameterSet seqParameterSet, NalUnit nalUnit) {
            NalUnit nalUnit2 = this.f4524b;
            if (nalUnit2 != null) {
                nalUnit2.m8387d();
                this.f4524b = null;
            }
            this.f4523a = seqParameterSet;
            this.f4524b = nalUnit;
        }

        /* renamed from: a */
        void m8336a(PictureParameterSet pictureParameterSet, NalUnit nalUnit) {
            NalUnit nalUnit2 = this.f4526d;
            if (nalUnit2 != null) {
                nalUnit2.m8387d();
                this.f4526d = null;
            }
            this.f4525c = pictureParameterSet;
            this.f4526d = nalUnit;
        }

        /* renamed from: a */
        void m8343a() throws IOException {
            if (this.f4527e == null) {
                m8342a(NvMediaCodecPlayer.this.f4518b);
            }
        }

        /* renamed from: b */
        boolean m8334b() {
            return this.f4527e != null;
        }

        /* renamed from: a */
        void m8342a(Surface surface) throws IOException {
            m8333b(surface);
        }

        /* renamed from: b */
        void m8333b(Surface surface) throws IOException {
            SeqParameterSet seqParameterSet = this.f4523a;
            if (seqParameterSet == null || this.f4524b == null) {
                NvMediaCodecPlayer.f4517a.mo1504b((Object) "initDecoder but no sps.");
            } else if (this.f4525c == null || this.f4526d == null) {
                NvMediaCodecPlayer.f4517a.mo1504b((Object) "initDecoder but no pps.");
            } else {
                int i = (((seqParameterSet.f12326m + 1) * 16) - (seqParameterSet.f12306H * 2)) - (seqParameterSet.f12307I * 2);
                int i2 = ((((2 - (seqParameterSet.f12304F ? 1 : 0)) * (seqParameterSet.f12325l + 1)) * 16) - (seqParameterSet.f12308J * 2)) - (seqParameterSet.f12309K * 2);
                C3044k c3044k = NvMediaCodecPlayer.f4517a;
                c3044k.mo1511a((Object) (getClass().getSimpleName() + " : width=" + i + ", height=" + i2));
                this.f4527e = MediaCodec.createDecoderByType("video/avc");
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
                createVideoFormat.setInteger("width", i);
                createVideoFormat.setInteger("height", i2);
                createVideoFormat.setInteger("max-input-size", i * i2);
                ByteBuffer m8392a = this.f4524b.m8392a(true);
                ByteBuffer m8392a2 = this.f4526d.m8392a(true);
                m8392a.rewind();
                m8392a2.rewind();
                if (NvMediaCodecPlayer.this.f4522f) {
                    createVideoFormat.setByteBuffer("csd-0", m8392a);
                    createVideoFormat.setByteBuffer("csd-1", m8392a2);
                }
                this.f4527e.configure(createVideoFormat, surface, (MediaCrypto) null, 0);
                this.f4527e.start();
                NvMediaCodecPlayer.f4517a.mo1511a((Object) "initDecoder done.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m8337a(ByteBuffer byteBuffer, byte[]... bArr) {
            ByteBuffer inputBuffer;
            if (this.f4527e == null) {
                return;
            }
            try {
                int m8330e = m8330e();
                if (m8330e >= 0 && (inputBuffer = this.f4527e.getInputBuffer(m8330e)) != null) {
                    inputBuffer.clear();
                    inputBuffer.put(byteBuffer);
                    this.f4527e.queueInputBuffer(m8330e, 0, byteBuffer.capacity(), 0L, 2);
                }
                m8331d();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m8341a(NalUnit nalUnit) {
            ByteBuffer inputBuffer;
            if (this.f4527e == null) {
                return;
            }
            ByteBuffer m8392a = nalUnit.m8392a(true);
            try {
                int m8330e = m8330e();
                if (m8330e >= 0 && (inputBuffer = this.f4527e.getInputBuffer(m8330e)) != null) {
                    inputBuffer.clear();
                    inputBuffer.put(m8392a);
                    long j = this.f4528f;
                    this.f4528f = 1 + j;
                    this.f4527e.queueInputBuffer(m8330e, 0, m8392a.capacity(), 40000 * j, 0);
                }
                m8331d();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* renamed from: d */
        private void m8331d() {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.f4527e.dequeueOutputBuffer(bufferInfo, 0L);
            while (dequeueOutputBuffer >= 0) {
                long j = bufferInfo.presentationTimeUs;
                this.f4529g++;
                this.f4530h = System.currentTimeMillis();
                this.f4527e.releaseOutputBuffer(dequeueOutputBuffer, true);
                dequeueOutputBuffer = this.f4527e.dequeueOutputBuffer(bufferInfo, 0L);
            }
        }

        /* renamed from: e */
        private int m8330e() {
            long currentTimeMillis = System.currentTimeMillis();
            int i = -1;
            while (!this.f4531i && (i = this.f4527e.dequeueInputBuffer(10000L)) < 0) {
                try {
                    m8331d();
                } catch (Exception e) {
                    m8338a(e, null, 0, true);
                    return -1;
                }
            }
            int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
            if (currentTimeMillis2 >= 100) {
                C3044k c3044k = NvMediaCodecPlayer.f4517a;
                c3044k.mo1499d("Dequeue input buffer ran long: " + currentTimeMillis2 + " ms");
            }
            return i;
        }

        /* renamed from: a */
        private void m8338a(Exception exc, ByteBuffer byteBuffer, int i, boolean z) {
            exc.printStackTrace();
            if (Build.VERSION.SDK_INT >= 21 && (exc instanceof MediaCodec.CodecException)) {
                MediaCodec.CodecException codecException = (MediaCodec.CodecException) exc;
                if (!codecException.isTransient() || z) {
                    NvMediaCodecPlayer.f4517a.mo1504b((Object) codecException.getDiagnosticInfo());
                } else {
                    NvMediaCodecPlayer.f4517a.mo1499d(codecException.getDiagnosticInfo());
                    return;
                }
            }
            if (!this.f4531i) {
                throw new NvException(exc, new NvError(48, "codec error"));
            }
        }

        /* renamed from: c */
        void m8332c() {
            if (this.f4527e != null) {
                this.f4531i = true;
                NvMediaCodecPlayer.f4517a.mo1504b((Object) "release codec context");
                try {
                    try {
                        this.f4527e.stop();
                        this.f4527e.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.f4527e = null;
                    this.f4523a = null;
                    NalUnit nalUnit = this.f4524b;
                    if (nalUnit != null) {
                        nalUnit.m8387d();
                        this.f4524b = null;
                    }
                    this.f4525c = null;
                    NalUnit nalUnit2 = this.f4526d;
                    if (nalUnit2 != null) {
                        nalUnit2.m8387d();
                        this.f4526d = null;
                    }
                    NvMediaCodecPlayer.f4517a.mo1504b((Object) "release done.");
                } catch (Throwable th) {
                    this.f4527e = null;
                    throw th;
                }
            }
        }
    }

    /* compiled from: NvMediaCodecPlayer.java */
    /* renamed from: com.navatics.app.framework.f.k$b */
    /* loaded from: classes.dex */
    class C1802b extends Thread {

        /* renamed from: a */
        boolean f4533a;

        /* renamed from: b */
        C1801a f4534b;

        C1802b() {
            this.f4534b = new C1801a();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            InputStream inputStream;
            NalUnit m8399a;
            NvMediaCodecPlayer.f4517a.mo1499d("worker thread is running");
            try {
                inputStream = NvMediaCodecPlayer.this.f4519c.mo5954i();
            } catch (IOException e) {
                e.printStackTrace();
                inputStream = null;
            }
            try {
                try {
                    try {
                        NalStreamExtractor nalStreamExtractor = new NalStreamExtractor(inputStream, false);
                        while (!this.f4533a && (m8399a = nalStreamExtractor.m8399a()) != null) {
                            if (NvMediaCodecPlayer.this.f4521e != null) {
                                byte[] m8390b = m8399a.m8390b();
                                NvMediaCodecPlayer.this.f4521e.mo8328a(m8390b, 0, m8390b.length);
                            }
                            if (NvMediaCodecPlayer.this.m8348c(m8399a, this.f4534b)) {
                                m8399a.m8387d();
                            }
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                NvMediaCodecPlayer.f4517a.mo1499d("worker thread has exited.");
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }

        /* renamed from: a */
        void m8329a() {
            this.f4533a = true;
            interrupt();
            synchronized (this) {
                try {
                    join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.f4534b.m8332c();
            this.f4534b = null;
        }
    }
}
