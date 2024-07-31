package org.mp4parser.streaming.p149b.p150a;

import com.github.mikephil.charting.utils.Utils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import org.mp4parser.InterfaceC3117b;
import org.mp4parser.boxes.iso14496.p146a.ChunkOffsetBox;
import org.mp4parser.boxes.iso14496.p146a.CompositionTimeToSample;
import org.mp4parser.boxes.iso14496.p146a.MediaHeaderBox;
import org.mp4parser.boxes.iso14496.p146a.MovieBox;
import org.mp4parser.boxes.iso14496.p146a.MovieHeaderBox;
import org.mp4parser.boxes.iso14496.p146a.SampleSizeBox;
import org.mp4parser.boxes.iso14496.p146a.SampleTableBox;
import org.mp4parser.boxes.iso14496.p146a.SampleToChunkBox;
import org.mp4parser.boxes.iso14496.p146a.SyncSampleBox;
import org.mp4parser.boxes.iso14496.p146a.TimeToSampleBox;
import org.mp4parser.boxes.iso14496.p146a.TrackBox;
import org.mp4parser.p144a.CastUtils;
import org.mp4parser.p144a.Mp4Arrays;
import org.mp4parser.p144a.Mp4Math;
import org.mp4parser.p144a.Path;
import org.mp4parser.streaming.StreamingSample;
import org.mp4parser.streaming.StreamingTrack;
import org.mp4parser.streaming.p148a.CompositionTimeSampleExtension;
import org.mp4parser.streaming.p148a.CompositionTimeTrackExtension;
import org.mp4parser.streaming.p148a.SampleFlagsSampleExtension;
import org.mp4parser.streaming.p148a.TrackIdTrackExtension;
import org.mp4parser.streaming.p149b.SampleSink;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.mp4parser.streaming.b.a.c */
/* loaded from: classes2.dex */
public class StandardMp4Writer extends DefaultBoxes implements SampleSink {

    /* renamed from: b */
    protected final WritableByteChannel f12155b;

    /* renamed from: c */
    protected List<StreamingTrack> f12156c;

    /* renamed from: d */
    protected Date f12157d = new Date();

    /* renamed from: e */
    protected Map<StreamingTrack, CountDownLatch> f12158e = new ConcurrentHashMap();

    /* renamed from: f */
    protected Map<StreamingTrack, Long> f12159f = new ConcurrentHashMap();

    /* renamed from: g */
    protected Map<StreamingTrack, Long> f12160g = new ConcurrentHashMap();

    /* renamed from: h */
    protected Map<StreamingTrack, Long> f12161h = new HashMap();

    /* renamed from: i */
    protected Map<StreamingTrack, List<StreamingSample>> f12162i = new HashMap();

    /* renamed from: j */
    protected Map<StreamingTrack, TrackBox> f12163j = new HashMap();

    /* renamed from: k */
    protected Map<StreamingTrack, Queue<C3130a>> f12164k = new ConcurrentHashMap();

    /* renamed from: l */
    protected Map<StreamingTrack, Long> f12165l = new HashMap();

    /* renamed from: m */
    protected Map<StreamingTrack, Long> f12166m = new HashMap();

    /* renamed from: n */
    long f12167n = 0;

    /* renamed from: o */
    volatile boolean f12168o = false;

    /* renamed from: p */
    static final /* synthetic */ boolean f12153p = !StandardMp4Writer.class.desiredAssertionStatus();

    /* renamed from: a */
    public static final Object f12152a = new Object();

    /* renamed from: q */
    private static InterfaceC3153b f12154q = C3154c.m260a(FragmentedMp4Writer.class.getName());

    public StandardMp4Writer(List<StreamingTrack> list, WritableByteChannel writableByteChannel) {
        this.f12156c = new ArrayList(list);
        this.f12155b = writableByteChannel;
        HashSet hashSet = new HashSet();
        for (StreamingTrack streamingTrack : list) {
            streamingTrack.mo455a(this);
            this.f12165l.put(streamingTrack, 1L);
            this.f12166m.put(streamingTrack, 1L);
            this.f12161h.put(streamingTrack, 0L);
            this.f12159f.put(streamingTrack, 0L);
            this.f12160g.put(streamingTrack, 0L);
            this.f12158e.put(streamingTrack, new CountDownLatch(0));
            this.f12162i.put(streamingTrack, new ArrayList());
            this.f12164k.put(streamingTrack, new LinkedList());
            if (streamingTrack.mo456a(TrackIdTrackExtension.class) != null) {
                TrackIdTrackExtension trackIdTrackExtension = (TrackIdTrackExtension) streamingTrack.mo456a(TrackIdTrackExtension.class);
                if (!f12153p && trackIdTrackExtension == null) {
                    throw new AssertionError();
                }
                if (hashSet.contains(Long.valueOf(trackIdTrackExtension.m497a()))) {
                    throw new RuntimeException("There may not be two tracks with the same trackID within one file");
                }
            }
        }
        for (StreamingTrack streamingTrack2 : list) {
            if (streamingTrack2.mo456a(TrackIdTrackExtension.class) == null) {
                Iterator it = hashSet.iterator();
                long j = 0;
                while (it.hasNext()) {
                    j = Math.max(((Long) it.next()).longValue(), j);
                }
                TrackIdTrackExtension trackIdTrackExtension2 = new TrackIdTrackExtension(j + 1);
                hashSet.add(Long.valueOf(trackIdTrackExtension2.m497a()));
                streamingTrack2.mo454a(trackIdTrackExtension2);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        for (StreamingTrack streamingTrack : this.f12156c) {
            m465a(m458h(streamingTrack));
            streamingTrack.close();
        }
        m466a(this.f12155b, m460d());
    }

    /* renamed from: d */
    protected InterfaceC3117b m460d() {
        MovieBox movieBox = new MovieBox();
        movieBox.m746a(mo462b());
        for (StreamingTrack streamingTrack : this.f12156c) {
            movieBox.m746a(this.f12163j.get(streamingTrack));
        }
        return movieBox;
    }

    /* renamed from: e */
    private void m459e() {
        Collections.sort(this.f12156c, new Comparator<StreamingTrack>() { // from class: org.mp4parser.streaming.b.a.c.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(StreamingTrack streamingTrack, StreamingTrack streamingTrack2) {
                return (int) Math.signum((float) ((StandardMp4Writer.this.f12160g.get(streamingTrack).longValue() * streamingTrack2.mo445a()) - (StandardMp4Writer.this.f12160g.get(streamingTrack2).longValue() * streamingTrack.mo445a())));
            }
        });
    }

    @Override // org.mp4parser.streaming.p149b.p150a.DefaultBoxes
    /* renamed from: b */
    protected InterfaceC3117b mo462b() {
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.m398b(1);
        movieHeaderBox.m572a(this.f12157d);
        movieHeaderBox.m570b(this.f12157d);
        long[] jArr = new long[0];
        long j = 0;
        double d = Utils.DOUBLE_EPSILON;
        for (StreamingTrack streamingTrack : this.f12156c) {
            d = Math.max(this.f12161h.get(streamingTrack).longValue() / streamingTrack.mo445a(), d);
            jArr = Mp4Arrays.m716a(jArr, streamingTrack.mo445a());
            j = Math.max(((TrackIdTrackExtension) streamingTrack.mo456a(TrackIdTrackExtension.class)).m497a(), j);
        }
        movieHeaderBox.m573a(Mp4Math.m714a(jArr));
        movieHeaderBox.m571b((long) (Mp4Math.m714a(jArr) * d));
        movieHeaderBox.m569c(j + 1);
        return movieHeaderBox;
    }

    /* renamed from: a */
    protected void m466a(WritableByteChannel writableByteChannel, InterfaceC3117b... interfaceC3117bArr) throws IOException {
        for (InterfaceC3117b interfaceC3117b : interfaceC3117bArr) {
            interfaceC3117b.mo402a(writableByteChannel);
            this.f12167n += interfaceC3117b.mo400m_();
        }
    }

    /* renamed from: a */
    protected boolean m463a(StreamingTrack streamingTrack, StreamingSample streamingSample) {
        return this.f12161h.get(streamingTrack).longValue() >= this.f12159f.get(streamingTrack).longValue() + (streamingTrack.mo445a() * 2);
    }

    /* renamed from: a */
    protected void m465a(C3130a c3130a) throws IOException {
        ChunkOffsetBox chunkOffsetBox = (ChunkOffsetBox) Path.m711a(this.f12163j.get(c3130a.f12171b), "mdia[0]/minf[0]/stbl[0]/stco[0]");
        if (!f12153p && chunkOffsetBox == null) {
            throw new AssertionError();
        }
        chunkOffsetBox.mo608a(Mp4Arrays.m716a(chunkOffsetBox.mo607c(), this.f12167n + 8));
        m466a(this.f12155b, c3130a.f12170a);
    }

    @Override // org.mp4parser.streaming.p149b.SampleSink
    /* renamed from: a */
    public void mo464a(StreamingSample streamingSample, StreamingTrack streamingTrack) throws IOException {
        boolean z;
        if (this.f12163j.get(streamingTrack) == null) {
            TrackBox trackBox = new TrackBox();
            trackBox.m746a(m489g(streamingTrack));
            trackBox.m746a(m494b(streamingTrack));
            this.f12163j.put(streamingTrack, trackBox);
        }
        synchronized (f12152a) {
            if (!this.f12168o) {
                boolean z2 = true;
                for (StreamingTrack streamingTrack2 : this.f12156c) {
                    if (this.f12161h.get(streamingTrack2).longValue() <= 0 && streamingTrack2 != streamingTrack) {
                        z = false;
                        z2 &= z;
                    }
                    z = true;
                    z2 &= z;
                }
                if (z2) {
                    m466a(this.f12155b, m496a());
                    this.f12168o = true;
                }
            }
        }
        try {
            CountDownLatch countDownLatch = this.f12158e.get(streamingTrack);
            if (countDownLatch.getCount() > 0) {
                countDownLatch.await();
            }
        } catch (InterruptedException unused) {
        }
        if (m463a(streamingTrack, streamingSample)) {
            C3130a m458h = m458h(streamingTrack);
            this.f12162i.get(streamingTrack).clear();
            Map<StreamingTrack, Long> map = this.f12159f;
            map.put(streamingTrack, Long.valueOf(map.get(streamingTrack).longValue() + m458h.f12172c));
            Queue<C3130a> queue = this.f12164k.get(streamingTrack);
            queue.add(m458h);
            synchronized (f12152a) {
                if (this.f12168o && this.f12156c.get(0) == streamingTrack) {
                    while (true) {
                        Map<StreamingTrack, Queue<C3130a>> map2 = this.f12164k;
                        StreamingTrack streamingTrack3 = this.f12156c.get(0);
                        Queue<C3130a> queue2 = map2.get(streamingTrack3);
                        if (queue2.isEmpty()) {
                            break;
                        }
                        C3130a remove = queue2.remove();
                        m465a(remove);
                        this.f12158e.get(streamingTrack3).countDown();
                        long longValue = this.f12160g.get(streamingTrack3).longValue() + remove.f12172c;
                        this.f12160g.put(streamingTrack3, Long.valueOf(longValue));
                        if (f12154q.isTraceEnabled()) {
                            InterfaceC3153b interfaceC3153b = f12154q;
                            interfaceC3153b.trace(streamingTrack3 + " advanced to " + (longValue / streamingTrack3.mo445a()));
                        }
                        m459e();
                    }
                } else if (queue.size() > 10) {
                    this.f12158e.put(streamingTrack, new CountDownLatch(queue.size()));
                }
            }
        }
        this.f12162i.get(streamingTrack).add(streamingSample);
        Map<StreamingTrack, Long> map3 = this.f12161h;
        map3.put(streamingTrack, Long.valueOf(map3.get(streamingTrack).longValue() + streamingSample.mo450b()));
    }

    /* renamed from: h */
    private C3130a m458h(StreamingTrack streamingTrack) {
        List<StreamingSample> list;
        C3130a c3130a;
        Iterator<StreamingSample> it;
        List<StreamingSample> list2 = this.f12162i.get(streamingTrack);
        long longValue = this.f12165l.get(streamingTrack).longValue();
        this.f12165l.put(streamingTrack, Long.valueOf(longValue + 1));
        C3130a c3130a2 = new C3130a();
        c3130a2.f12171b = streamingTrack;
        c3130a2.f12170a = new C3131b(list2);
        c3130a2.f12172c = this.f12161h.get(streamingTrack).longValue() - this.f12159f.get(streamingTrack).longValue();
        SampleTableBox sampleTableBox = (SampleTableBox) Path.m711a(this.f12163j.get(streamingTrack), "mdia[0]/minf[0]/stbl[0]");
        if (f12153p || sampleTableBox != null) {
            SampleToChunkBox sampleToChunkBox = (SampleToChunkBox) Path.m711a(sampleTableBox, "stsc[0]");
            if (f12153p || sampleToChunkBox != null) {
                if (sampleToChunkBox.m546d().isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    sampleToChunkBox.m547a(arrayList);
                    arrayList.add(new SampleToChunkBox.C3123a(longValue, list2.size(), 1L));
                } else if (sampleToChunkBox.m546d().get(sampleToChunkBox.m546d().size() - 1).m543b() != list2.size()) {
                    sampleToChunkBox.m546d().add(new SampleToChunkBox.C3123a(longValue, list2.size(), 1L));
                }
                long longValue2 = this.f12166m.get(streamingTrack).longValue();
                SampleSizeBox sampleSizeBox = (SampleSizeBox) Path.m711a(sampleTableBox, "stsz[0]");
                TimeToSampleBox timeToSampleBox = (TimeToSampleBox) Path.m711a(sampleTableBox, "stts[0]");
                SyncSampleBox syncSampleBox = (SyncSampleBox) Path.m711a(sampleTableBox, "stss[0]");
                CompositionTimeToSample compositionTimeToSample = (CompositionTimeToSample) Path.m711a(sampleTableBox, "ctts[0]");
                if (streamingTrack.mo456a(CompositionTimeTrackExtension.class) != null && compositionTimeToSample == null) {
                    compositionTimeToSample = new CompositionTimeToSample();
                    compositionTimeToSample.m605a(new ArrayList());
                    ArrayList arrayList2 = new ArrayList(sampleTableBox.mo526a());
                    arrayList2.add(arrayList2.indexOf(timeToSampleBox), compositionTimeToSample);
                }
                long[] jArr = new long[list2.size()];
                Iterator<StreamingSample> it2 = list2.iterator();
                long j = longValue2;
                int i = 0;
                while (it2.hasNext()) {
                    StreamingSample next = it2.next();
                    int i2 = i + 1;
                    long j2 = j;
                    jArr[i] = next.mo453a().limit();
                    if (compositionTimeToSample != null) {
                        compositionTimeToSample.m604d().add(new CompositionTimeToSample.C3122a(1, CastUtils.m743a(((CompositionTimeSampleExtension) next.mo452a(CompositionTimeSampleExtension.class)).m519a())));
                    }
                    if (!f12153p && timeToSampleBox == null) {
                        throw new AssertionError();
                    }
                    if (timeToSampleBox.m683d().isEmpty()) {
                        ArrayList arrayList3 = new ArrayList(timeToSampleBox.m683d());
                        list = list2;
                        c3130a = c3130a2;
                        arrayList3.add(new TimeToSampleBox.C3119a(1L, next.mo450b()));
                        timeToSampleBox.m684a(arrayList3);
                        it = it2;
                    } else {
                        list = list2;
                        c3130a = c3130a2;
                        TimeToSampleBox.C3119a c3119a = timeToSampleBox.m683d().get(timeToSampleBox.m683d().size() - 1);
                        if (c3119a.m679b() == next.mo450b()) {
                            c3119a.m680a(c3119a.m681a() + 1);
                            it = it2;
                        } else {
                            it = it2;
                            timeToSampleBox.m683d().add(new TimeToSampleBox.C3119a(1L, next.mo450b()));
                        }
                    }
                    SampleFlagsSampleExtension sampleFlagsSampleExtension = (SampleFlagsSampleExtension) next.mo452a(SampleFlagsSampleExtension.class);
                    if (sampleFlagsSampleExtension != null && sampleFlagsSampleExtension.m499g()) {
                        if (syncSampleBox == null) {
                            syncSampleBox = new SyncSampleBox();
                            sampleTableBox.m746a(syncSampleBox);
                        }
                        syncSampleBox.m687a(Mp4Arrays.m716a(syncSampleBox.m686d(), j2));
                    }
                    it2 = it;
                    list2 = list;
                    i = i2;
                    j = j2 + 1;
                    c3130a2 = c3130a;
                }
                C3130a c3130a3 = c3130a2;
                long j3 = j;
                List<StreamingSample> list3 = list2;
                if (f12153p || sampleSizeBox != null) {
                    sampleSizeBox.m552a(Mp4Arrays.m716a(sampleSizeBox.m549f(), jArr));
                    this.f12166m.put(streamingTrack, Long.valueOf(j3));
                    list3.clear();
                    InterfaceC3153b interfaceC3153b = f12154q;
                    interfaceC3153b.debug("CC created. mdat size: " + c3130a3.f12170a.f12175b);
                    return c3130a3;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    @Override // org.mp4parser.streaming.p149b.p150a.DefaultBoxes
    /* renamed from: c */
    protected InterfaceC3117b mo461c(StreamingTrack streamingTrack) {
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.m589a(this.f12157d);
        mediaHeaderBox.m587b(this.f12157d);
        mediaHeaderBox.m588b(this.f12161h.get(streamingTrack).longValue());
        mediaHeaderBox.m591a(streamingTrack.mo445a());
        mediaHeaderBox.m590a(streamingTrack.mo437c());
        return mediaHeaderBox;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StandardMp4Writer.java */
    /* renamed from: org.mp4parser.streaming.b.a.c$b */
    /* loaded from: classes2.dex */
    public class C3131b implements InterfaceC3117b {

        /* renamed from: a */
        ArrayList<StreamingSample> f12174a;

        /* renamed from: b */
        long f12175b = 8;

        @Override // org.mp4parser.InterfaceC3117b
        /* renamed from: n_ */
        public String mo399n_() {
            return "mdat";
        }

        public C3131b(List<StreamingSample> list) {
            this.f12174a = new ArrayList<>(list);
            for (StreamingSample streamingSample : list) {
                this.f12175b += streamingSample.mo453a().limit();
            }
        }

        @Override // org.mp4parser.InterfaceC3117b
        /* renamed from: m_ */
        public long mo400m_() {
            return this.f12175b;
        }

        @Override // org.mp4parser.InterfaceC3117b
        /* renamed from: a */
        public void mo402a(WritableByteChannel writableByteChannel) throws IOException {
            long j = this.f12175b;
            writableByteChannel.write(ByteBuffer.wrap(new byte[]{(byte) (((-16777216) & j) >> 24), (byte) ((16711680 & j) >> 16), (byte) ((65280 & j) >> 8), (byte) (j & 255), 109, 100, 97, 116}));
            Iterator<StreamingSample> it = this.f12174a.iterator();
            while (it.hasNext()) {
                writableByteChannel.write((ByteBuffer) it.next().mo453a().rewind());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StandardMp4Writer.java */
    /* renamed from: org.mp4parser.streaming.b.a.c$a */
    /* loaded from: classes2.dex */
    public class C3130a {

        /* renamed from: a */
        C3131b f12170a;

        /* renamed from: b */
        StreamingTrack f12171b;

        /* renamed from: c */
        long f12172c;

        private C3130a() {
        }
    }
}
