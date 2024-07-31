package org.mp4parser.streaming.input.h264;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.mp4parser.boxes.iso14496.p146a.SampleDescriptionBox;
import org.mp4parser.boxes.iso14496.p147b.AvcConfigurationBox;
import org.mp4parser.boxes.p145a.VisualSampleEntry;
import org.mp4parser.streaming.StreamingSample;
import org.mp4parser.streaming.input.StreamingSampleImpl;
import org.mp4parser.streaming.input.h264.spspps.PictureParameterSet;
import org.mp4parser.streaming.input.h264.spspps.SeqParameterSet;
import org.mp4parser.streaming.input.h264.spspps.SliceHeader;
import org.mp4parser.streaming.p148a.CompositionTimeSampleExtension;
import org.mp4parser.streaming.p148a.CompositionTimeTrackExtension;
import org.mp4parser.streaming.p148a.DimensionTrackExtension;
import org.mp4parser.streaming.p148a.SampleFlagsSampleExtension;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.mp4parser.streaming.input.h264.c */
/* loaded from: classes2.dex */
public abstract class H264NalConsumingTrack extends AbstractH264Track {

    /* renamed from: d */
    private static InterfaceC3153b f12189d = C3154c.m260a(H264NalConsumingTrack.class.getName());

    /* renamed from: o */
    boolean f12200o;

    /* renamed from: p */
    SampleDescriptionBox f12201p;

    /* renamed from: u */
    H264NalUnitHeader f12206u;

    /* renamed from: e */
    int f12190e = 16;

    /* renamed from: f */
    List<StreamingSample> f12191f = new ArrayList();

    /* renamed from: g */
    List<StreamingSample> f12192g = new ArrayList();

    /* renamed from: h */
    LinkedHashMap<Integer, ByteBuffer> f12193h = new LinkedHashMap<>();

    /* renamed from: i */
    LinkedHashMap<Integer, SeqParameterSet> f12194i = new LinkedHashMap<>();

    /* renamed from: j */
    LinkedHashMap<Integer, ByteBuffer> f12195j = new LinkedHashMap<>();

    /* renamed from: k */
    LinkedHashMap<Integer, PictureParameterSet> f12196k = new LinkedHashMap<>();

    /* renamed from: l */
    BlockingQueue<SeqParameterSet> f12197l = new LinkedBlockingDeque();

    /* renamed from: m */
    int f12198m = 0;

    /* renamed from: n */
    int f12199n = 0;

    /* renamed from: q */
    SeqParameterSet f12202q = null;

    /* renamed from: r */
    PictureParameterSet f12203r = null;

    /* renamed from: s */
    List<ByteBuffer> f12204s = new ArrayList();

    /* renamed from: t */
    C3134a f12205t = null;

    @Override // org.mp4parser.streaming.StreamingTrack
    /* renamed from: b */
    public String mo439b() {
        return "vide";
    }

    @Override // org.mp4parser.streaming.StreamingTrack
    /* renamed from: c */
    public String mo437c() {
        return "eng";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    /* renamed from: a */
    public static H264NalUnitHeader m444a(ByteBuffer byteBuffer) {
        H264NalUnitHeader h264NalUnitHeader = new H264NalUnitHeader();
        byte b = byteBuffer.get(0);
        h264NalUnitHeader.f12221a = (b >> 5) & 3;
        h264NalUnitHeader.f12222b = b & 31;
        return h264NalUnitHeader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m438b(ByteBuffer byteBuffer) throws IOException {
        H264NalUnitHeader m444a = m444a(byteBuffer);
        switch (m444a.f12222b) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                C3134a c3134a = new C3134a(byteBuffer, m444a.f12221a, m444a.f12222b);
                this.f12206u = m444a;
                C3134a c3134a2 = this.f12205t;
                if (c3134a2 != null && c3134a2.m432a(c3134a)) {
                    f12189d.debug("Wrapping up cause of first vcl nal is found");
                    m442a(m443a(this.f12204s, this.f12205t.f12207a, this.f12206u), false, false);
                    this.f12204s.clear();
                }
                this.f12205t = c3134a;
                this.f12204s.add(byteBuffer);
                return;
            case 6:
                if (this.f12205t != null) {
                    f12189d.debug("Wrapping up cause of SEI after vcl marks new sample");
                    m442a(m443a(this.f12204s, this.f12205t.f12207a, this.f12206u), false, false);
                    this.f12204s.clear();
                    this.f12205t = null;
                }
                this.f12204s.add(byteBuffer);
                return;
            case 7:
                if (this.f12205t != null) {
                    f12189d.debug("Wrapping up cause of SPS after vcl marks new sample");
                    m442a(m443a(this.f12204s, this.f12205t.f12207a, this.f12206u), false, false);
                    this.f12204s.clear();
                    this.f12205t = null;
                }
                m434d(byteBuffer);
                this.f12204s.add(byteBuffer);
                return;
            case 8:
                if (this.f12205t != null) {
                    f12189d.debug("Wrapping up cause of PPS after vcl marks new sample");
                    m442a(m443a(this.f12204s, this.f12205t.f12207a, this.f12206u), false, false);
                    this.f12204s.clear();
                    this.f12205t = null;
                }
                m436c(byteBuffer);
                this.f12204s.add(byteBuffer);
                return;
            case 9:
                C3134a c3134a3 = this.f12205t;
                if (c3134a3 != null) {
                    m442a(m443a(this.f12204s, c3134a3.f12207a, this.f12206u), false, false);
                    f12189d.debug("Wrapping up cause of AU after vcl marks new sample");
                    this.f12204s.clear();
                    this.f12205t = null;
                }
                this.f12204s.add(byteBuffer);
                return;
            case 10:
            case 11:
                return;
            case 12:
            default:
                InterfaceC3153b interfaceC3153b = f12189d;
                interfaceC3153b.warn("Unknown NAL unit type: " + m444a.f12222b);
                return;
            case 13:
                throw new IOException("Sequence parameter set extension is not yet handled. Needs TLC.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m442a(StreamingSample streamingSample, boolean z, boolean z2) throws IOException {
        if (streamingSample != null) {
            this.f12191f.add(streamingSample);
        }
        if (z) {
            while (this.f12191f.size() > 0) {
                m442a((StreamingSample) null, false, true);
            }
        } else if (this.f12191f.size() - 1 > this.f12190e || z2) {
            StreamingSample remove = this.f12191f.remove(0);
            PictureOrderCountType0SampleExtension pictureOrderCountType0SampleExtension = (PictureOrderCountType0SampleExtension) remove.mo452a(PictureOrderCountType0SampleExtension.class);
            if (pictureOrderCountType0SampleExtension == null) {
                this.f12179c.mo464a(remove, this);
                return;
            }
            int i = 0;
            for (StreamingSample streamingSample2 : this.f12191f) {
                if (pictureOrderCountType0SampleExtension.m431a() > ((PictureOrderCountType0SampleExtension) streamingSample2.mo452a(PictureOrderCountType0SampleExtension.class)).m431a()) {
                    i++;
                }
            }
            for (StreamingSample streamingSample3 : this.f12192g) {
                if (pictureOrderCountType0SampleExtension.m431a() < ((PictureOrderCountType0SampleExtension) streamingSample3.mo452a(PictureOrderCountType0SampleExtension.class)).m431a()) {
                    i--;
                }
            }
            this.f12192g.add(remove);
            if (this.f12192g.size() > this.f12190e) {
                this.f12192g.remove(0).mo449b(PictureOrderCountType0SampleExtension.class);
            }
            remove.mo451a(CompositionTimeSampleExtension.m518a(i * this.f12199n));
            this.f12179c.mo464a(remove, this);
        }
    }

    /* renamed from: a */
    protected SampleFlagsSampleExtension m441a(H264NalUnitHeader h264NalUnitHeader, SliceHeader sliceHeader) {
        SampleFlagsSampleExtension sampleFlagsSampleExtension = new SampleFlagsSampleExtension();
        if (h264NalUnitHeader.f12221a == 0) {
            sampleFlagsSampleExtension.m504b(2);
        } else {
            sampleFlagsSampleExtension.m504b(1);
        }
        if (sliceHeader.f12226b == SliceHeader.SliceType.I || sliceHeader.f12226b == SliceHeader.SliceType.SI) {
            sampleFlagsSampleExtension.m507a(2);
        } else {
            sampleFlagsSampleExtension.m507a(1);
        }
        sampleFlagsSampleExtension.m506a(5 != h264NalUnitHeader.f12222b);
        return sampleFlagsSampleExtension;
    }

    /* renamed from: a */
    protected PictureOrderCountType0SampleExtension m440a(SliceHeader sliceHeader) {
        PictureOrderCountType0SampleExtension pictureOrderCountType0SampleExtension = null;
        if (sliceHeader.f12238n.f12314a == 0) {
            if (this.f12191f.size() > 0) {
                List<StreamingSample> list = this.f12191f;
                pictureOrderCountType0SampleExtension = (PictureOrderCountType0SampleExtension) list.get(list.size() - 1).mo452a(PictureOrderCountType0SampleExtension.class);
            }
            return new PictureOrderCountType0SampleExtension(sliceHeader, pictureOrderCountType0SampleExtension);
        } else if (sliceHeader.f12238n.f12314a == 1) {
            throw new RuntimeException("pic_order_cnt_type == 1 needs to be implemented");
        } else {
            if (sliceHeader.f12238n.f12314a == 2) {
                return null;
            }
            throw new RuntimeException("I don't know sliceHeader.sps.pic_order_cnt_type of " + sliceHeader.f12238n.f12314a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public StreamingSample m443a(List<ByteBuffer> list, SliceHeader sliceHeader, H264NalUnitHeader h264NalUnitHeader) throws IOException {
        int i;
        f12189d.debug("Create Sample");
        m433f();
        if (this.f12198m == 0 || (i = this.f12199n) == 0) {
            throw new IOException("Frame Rate needs to be configured either by hand or by SPS before samples can be created");
        }
        StreamingSampleImpl streamingSampleImpl = new StreamingSampleImpl(list, i);
        streamingSampleImpl.mo451a(m441a(h264NalUnitHeader, sliceHeader));
        streamingSampleImpl.mo451a(m440a(sliceHeader));
        return streamingSampleImpl;
    }

    /* renamed from: f */
    public synchronized void m433f() {
        int i;
        int i2;
        if (!this.f12200o) {
            try {
                SeqParameterSet poll = this.f12197l.poll(5L, TimeUnit.SECONDS);
                if (poll == null) {
                    f12189d.warn("Can't determine frame rate as no SPS became available in time");
                    return;
                }
                if (poll.f12314a == 0 || poll.f12314a == 1) {
                    mo454a(new CompositionTimeTrackExtension());
                }
                int i3 = 16;
                int i4 = (poll.f12326m + 1) * 16;
                int i5 = poll.f12304F ? 1 : 2;
                int i6 = (poll.f12325l + 1) * 16 * i5;
                int i7 = 0;
                if (poll.f12305G) {
                    if ((!poll.f12299A ? poll.f12322i.m421a() : 0) != 0) {
                        i2 = poll.f12322i.m419b();
                        i5 *= poll.f12322i.m418c();
                    } else {
                        i2 = 1;
                    }
                    i4 -= i2 * (poll.f12306H + poll.f12307I);
                    i6 -= i5 * (poll.f12308J + poll.f12309K);
                }
                VisualSampleEntry visualSampleEntry = new VisualSampleEntry("avc1");
                visualSampleEntry.m706a(1);
                visualSampleEntry.m696e(24);
                visualSampleEntry.m698d(1);
                visualSampleEntry.m705a(72.0d);
                visualSampleEntry.m703b(72.0d);
                if (((DimensionTrackExtension) mo456a(DimensionTrackExtension.class)) == null) {
                    mo454a(new DimensionTrackExtension(i4, i6));
                }
                visualSampleEntry.m702b(i4);
                visualSampleEntry.m700c(i6);
                visualSampleEntry.m704a("AVC Coding");
                AvcConfigurationBox avcConfigurationBox = new AvcConfigurationBox();
                avcConfigurationBox.m540a(new ArrayList(this.f12193h.values()));
                avcConfigurationBox.m538b(new ArrayList(this.f12195j.values()));
                avcConfigurationBox.m535d(poll.f12338y);
                avcConfigurationBox.m539b(poll.f12330q);
                avcConfigurationBox.m532g(poll.f12327n);
                avcConfigurationBox.m531h(poll.f12328o);
                avcConfigurationBox.m533f(poll.f12322i.m421a());
                avcConfigurationBox.m541a(1);
                avcConfigurationBox.m534e(3);
                int i8 = (poll.f12332s ? 128 : 0) + (poll.f12333t ? 64 : 0) + (poll.f12334u ? 32 : 0);
                if (!poll.f12335v) {
                    i3 = 0;
                }
                avcConfigurationBox.m537c(i8 + i3 + (poll.f12336w ? 8 : 0) + ((int) (poll.f12331r & 3)));
                visualSampleEntry.m746a(avcConfigurationBox);
                this.f12201p = new SampleDescriptionBox();
                this.f12201p.m746a(visualSampleEntry);
                if (poll.f12311M != null) {
                    if (poll.f12311M.f12355p) {
                        i = poll.f12311M.f12357r >> 1;
                        int i9 = poll.f12311M.f12356q;
                        if (i != 0 && i9 != 0) {
                            i7 = i9;
                        }
                        InterfaceC3153b interfaceC3153b = f12189d;
                        interfaceC3153b.warn("vuiParams contain invalid values: time_scale: " + i + " and frame_tick: " + i9 + ". Setting frame rate to 25fps");
                        i = 0;
                    } else {
                        i = 25000;
                        f12189d.warn("vuiParams doesn't contain any timing info, Set timescale to 250000 and frametick to 1001");
                        i7 = 1000;
                    }
                    if (i7 > 0) {
                        if (i / i7 > 100) {
                            InterfaceC3153b interfaceC3153b2 = f12189d;
                            interfaceC3153b2.warn("Framerate is " + (i / i7) + ". That is suspicious.");
                        }
                    } else {
                        InterfaceC3153b interfaceC3153b3 = f12189d;
                        interfaceC3153b3.warn("Frametick is " + i7 + ". That is suspicious.");
                    }
                    if (poll.f12311M.f12363x != null) {
                        this.f12190e = poll.f12311M.f12363x.f12371g;
                    }
                } else {
                    f12189d.warn("Can't determine frame rate as SPS does not contain vuiParama");
                    i = 0;
                }
                if (this.f12198m == 0) {
                    this.f12198m = i;
                }
                if (this.f12199n == 0) {
                    this.f12199n = i7;
                }
                if (poll.f12314a == 0) {
                    mo454a(new CompositionTimeTrackExtension());
                } else if (poll.f12314a == 1) {
                    throw new RuntimeException("Have not yet imlemented pic_order_cnt_type 1");
                }
                this.f12200o = true;
            } catch (InterruptedException e) {
                f12189d.warn(e.getMessage());
                f12189d.warn("Can't determine frame rate as no SPS became available in time");
            }
        }
    }

    @Override // org.mp4parser.streaming.StreamingTrack
    /* renamed from: a */
    public long mo445a() {
        m433f();
        return this.f12198m;
    }

    @Override // org.mp4parser.streaming.StreamingTrack
    /* renamed from: d */
    public SampleDescriptionBox mo435d() {
        m433f();
        return this.f12201p;
    }

    /* renamed from: c */
    protected void m436c(ByteBuffer byteBuffer) {
        byteBuffer.position(1);
        try {
            PictureParameterSet m417a = PictureParameterSet.m417a(byteBuffer);
            this.f12203r = m417a;
            ByteBuffer byteBuffer2 = this.f12195j.get(Integer.valueOf(m417a.f12272e));
            if (byteBuffer2 != null && !byteBuffer2.equals(byteBuffer)) {
                throw new RuntimeException("OMG - I got two SPS with same ID but different settings! (AVC3 is the solution)");
            }
            this.f12195j.put(Integer.valueOf(m417a.f12272e), byteBuffer);
            this.f12196k.put(Integer.valueOf(m417a.f12272e), m417a);
        } catch (IOException e) {
            throw new RuntimeException("That's surprising to get IOException when working on ByteArrayInputStream", e);
        }
    }

    /* renamed from: d */
    protected void m434d(ByteBuffer byteBuffer) {
        byteBuffer.position(1);
        try {
            SeqParameterSet m415a = SeqParameterSet.m415a(byteBuffer);
            this.f12202q = m415a;
            ByteBuffer byteBuffer2 = this.f12193h.get(Integer.valueOf(m415a.f12339z));
            if (byteBuffer2 != null && !byteBuffer2.equals(byteBuffer)) {
                throw new RuntimeException("OMG - I got two SPS with same ID but different settings!");
            }
            this.f12193h.put(Integer.valueOf(m415a.f12339z), byteBuffer);
            this.f12194i.put(Integer.valueOf(m415a.f12339z), m415a);
            this.f12197l.add(m415a);
        } catch (IOException e) {
            throw new RuntimeException("That's surprising to get IOException when working on ByteArrayInputStream", e);
        }
    }

    /* compiled from: H264NalConsumingTrack.java */
    /* renamed from: org.mp4parser.streaming.input.h264.c$a */
    /* loaded from: classes2.dex */
    class C3134a {

        /* renamed from: a */
        public final SliceHeader f12207a;

        /* renamed from: b */
        int f12208b;

        /* renamed from: c */
        int f12209c;

        /* renamed from: d */
        boolean f12210d;

        /* renamed from: e */
        boolean f12211e;

        /* renamed from: f */
        int f12212f;

        /* renamed from: g */
        int f12213g;

        /* renamed from: h */
        int f12214h;

        /* renamed from: i */
        int f12215i;

        /* renamed from: j */
        int f12216j;

        /* renamed from: k */
        int f12217k;

        /* renamed from: l */
        boolean f12218l;

        /* renamed from: m */
        int f12219m;

        public C3134a(ByteBuffer byteBuffer, int i, int i2) {
            SliceHeader sliceHeader = new SliceHeader(byteBuffer, H264NalConsumingTrack.this.f12194i, H264NalConsumingTrack.this.f12196k, i2 == 5);
            this.f12207a = sliceHeader;
            this.f12208b = sliceHeader.f12229e;
            this.f12209c = sliceHeader.f12227c;
            this.f12210d = sliceHeader.f12230f;
            this.f12211e = sliceHeader.f12231g;
            this.f12212f = i;
            this.f12213g = H264NalConsumingTrack.this.f12194i.get(Integer.valueOf(H264NalConsumingTrack.this.f12196k.get(Integer.valueOf(sliceHeader.f12227c)).f12273f)).f12314a;
            this.f12214h = sliceHeader.f12234j;
            this.f12215i = sliceHeader.f12233i;
            this.f12216j = sliceHeader.f12235k;
            this.f12217k = sliceHeader.f12236l;
            this.f12219m = sliceHeader.f12232h;
        }

        /* renamed from: a */
        boolean m432a(C3134a c3134a) {
            boolean z;
            boolean z2;
            boolean z3;
            if (c3134a.f12208b == this.f12208b && c3134a.f12209c == this.f12209c && (z = c3134a.f12210d) == this.f12210d) {
                if ((!z || c3134a.f12211e == this.f12211e) && c3134a.f12212f == this.f12212f) {
                    if (c3134a.f12213g == 0 && this.f12213g == 0 && (c3134a.f12215i != this.f12215i || c3134a.f12214h != this.f12214h)) {
                        return true;
                    }
                    if (!(c3134a.f12213g == 1 && this.f12213g == 1 && (c3134a.f12216j != this.f12216j || c3134a.f12217k != this.f12217k)) && (z2 = c3134a.f12218l) == (z3 = this.f12218l)) {
                        return z2 && z3 && c3134a.f12219m != this.f12219m;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
    }
}
