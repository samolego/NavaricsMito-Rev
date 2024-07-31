package org.mp4parser.streaming.p149b.p150a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import org.mp4parser.InterfaceC3117b;
import org.mp4parser.IsoFile;
import org.mp4parser.boxes.iso14496.p146a.MediaHeaderBox;
import org.mp4parser.boxes.iso14496.p146a.MovieBox;
import org.mp4parser.boxes.iso14496.p146a.MovieExtendsBox;
import org.mp4parser.boxes.iso14496.p146a.MovieExtendsHeaderBox;
import org.mp4parser.boxes.iso14496.p146a.MovieFragmentBox;
import org.mp4parser.boxes.iso14496.p146a.MovieFragmentHeaderBox;
import org.mp4parser.boxes.iso14496.p146a.MovieFragmentRandomAccessBox;
import org.mp4parser.boxes.iso14496.p146a.MovieFragmentRandomAccessOffsetBox;
import org.mp4parser.boxes.iso14496.p146a.MovieHeaderBox;
import org.mp4parser.boxes.iso14496.p146a.SampleFlags;
import org.mp4parser.boxes.iso14496.p146a.TrackExtendsBox;
import org.mp4parser.boxes.iso14496.p146a.TrackFragmentBaseMediaDecodeTimeBox;
import org.mp4parser.boxes.iso14496.p146a.TrackFragmentBox;
import org.mp4parser.boxes.iso14496.p146a.TrackFragmentHeaderBox;
import org.mp4parser.boxes.iso14496.p146a.TrackFragmentRandomAccessBox;
import org.mp4parser.boxes.iso14496.p146a.TrackRunBox;
import org.mp4parser.p144a.CastUtils;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.p144a.Mp4Arrays;
import org.mp4parser.p144a.Mp4Math;
import org.mp4parser.streaming.StreamingSample;
import org.mp4parser.streaming.StreamingTrack;
import org.mp4parser.streaming.p148a.CencEncryptTrackExtension;
import org.mp4parser.streaming.p148a.CompositionTimeSampleExtension;
import org.mp4parser.streaming.p148a.CompositionTimeTrackExtension;
import org.mp4parser.streaming.p148a.DefaultSampleFlagsTrackExtension;
import org.mp4parser.streaming.p148a.SampleFlagsSampleExtension;
import org.mp4parser.streaming.p148a.TrackIdTrackExtension;
import org.mp4parser.streaming.p149b.SampleSink;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.mp4parser.streaming.b.a.b */
/* loaded from: classes2.dex */
public class FragmentedMp4Writer extends DefaultBoxes implements SampleSink {

    /* renamed from: b */
    protected final WritableByteChannel f12132b;

    /* renamed from: c */
    protected List<StreamingTrack> f12133c;

    /* renamed from: d */
    protected Date f12134d;

    /* renamed from: e */
    protected long f12135e;

    /* renamed from: f */
    protected Map<StreamingTrack, CountDownLatch> f12136f;

    /* renamed from: g */
    protected Map<StreamingTrack, Long> f12137g;

    /* renamed from: h */
    protected Map<StreamingTrack, Long> f12138h;

    /* renamed from: i */
    protected Map<StreamingTrack, Long> f12139i;

    /* renamed from: j */
    protected Map<StreamingTrack, List<StreamingSample>> f12140j;

    /* renamed from: k */
    protected Map<StreamingTrack, Queue<C3128a>> f12141k;

    /* renamed from: l */
    protected Map<StreamingTrack, long[]> f12142l;

    /* renamed from: m */
    protected Map<StreamingTrack, long[]> f12143m;

    /* renamed from: n */
    long f12144n;

    /* renamed from: o */
    volatile boolean f12145o;

    /* renamed from: p */
    static final /* synthetic */ boolean f12130p = !FragmentedMp4Writer.class.desiredAssertionStatus();

    /* renamed from: a */
    public static final Object f12129a = new Object();

    /* renamed from: q */
    private static InterfaceC3153b f12131q = C3154c.m260a(FragmentedMp4Writer.class.getName());

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        for (StreamingTrack streamingTrack : this.f12133c) {
            m477b(m485a(streamingTrack, this.f12140j.get(streamingTrack)));
            streamingTrack.close();
        }
        m476c(m472g());
    }

    /* renamed from: a */
    protected void m487a(WritableByteChannel writableByteChannel, InterfaceC3117b... interfaceC3117bArr) throws IOException {
        for (InterfaceC3117b interfaceC3117b : interfaceC3117bArr) {
            interfaceC3117b.mo402a(writableByteChannel);
            this.f12144n += interfaceC3117b.mo400m_();
        }
    }

    @Override // org.mp4parser.streaming.p149b.p150a.DefaultBoxes
    /* renamed from: c */
    protected InterfaceC3117b mo461c(StreamingTrack streamingTrack) {
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.m589a(this.f12134d);
        mediaHeaderBox.m587b(this.f12134d);
        mediaHeaderBox.m588b(0L);
        mediaHeaderBox.m591a(streamingTrack.mo445a());
        mediaHeaderBox.m590a(streamingTrack.mo437c());
        return mediaHeaderBox;
    }

    /* renamed from: d */
    protected InterfaceC3117b m475d() {
        MovieExtendsBox movieExtendsBox = new MovieExtendsBox();
        MovieExtendsHeaderBox movieExtendsHeaderBox = new MovieExtendsHeaderBox();
        movieExtendsHeaderBox.m398b(1);
        movieExtendsHeaderBox.m580a(0L);
        movieExtendsBox.m746a(movieExtendsHeaderBox);
        for (StreamingTrack streamingTrack : this.f12133c) {
            movieExtendsBox.m746a(m470h(streamingTrack));
        }
        return movieExtendsBox;
    }

    /* renamed from: h */
    protected InterfaceC3117b m470h(StreamingTrack streamingTrack) {
        TrackExtendsBox trackExtendsBox = new TrackExtendsBox();
        trackExtendsBox.m678a(((TrackIdTrackExtension) streamingTrack.mo456a(TrackIdTrackExtension.class)).m497a());
        trackExtendsBox.m676b(1L);
        trackExtendsBox.m675c(0L);
        trackExtendsBox.m673d(0L);
        trackExtendsBox.m677a(new SampleFlags());
        return trackExtendsBox;
    }

    @Override // org.mp4parser.streaming.p149b.p150a.DefaultBoxes
    /* renamed from: b */
    protected InterfaceC3117b mo462b() {
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.m398b(1);
        movieHeaderBox.m572a(this.f12134d);
        movieHeaderBox.m570b(this.f12134d);
        long j = 0;
        movieHeaderBox.m571b(0L);
        long[] jArr = new long[0];
        for (StreamingTrack streamingTrack : this.f12133c) {
            jArr = Mp4Arrays.m716a(jArr, streamingTrack.mo445a());
            j = Math.max(((TrackIdTrackExtension) streamingTrack.mo456a(TrackIdTrackExtension.class)).m497a(), j);
        }
        movieHeaderBox.m573a(Mp4Math.m714a(jArr));
        movieHeaderBox.m569c(j + 1);
        return movieHeaderBox;
    }

    /* renamed from: e */
    protected InterfaceC3117b m474e() {
        MovieBox movieBox = new MovieBox();
        movieBox.m746a(mo462b());
        for (StreamingTrack streamingTrack : this.f12133c) {
            movieBox.m746a(m490f(streamingTrack));
        }
        movieBox.m746a(m475d());
        return movieBox;
    }

    /* renamed from: f */
    protected InterfaceC3117b[] m473f() {
        return new InterfaceC3117b[]{m496a(), m474e()};
    }

    /* renamed from: h */
    private void m471h() {
        Collections.sort(this.f12133c, new Comparator<StreamingTrack>() { // from class: org.mp4parser.streaming.b.a.b.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(StreamingTrack streamingTrack, StreamingTrack streamingTrack2) {
                return (int) Math.signum((float) ((FragmentedMp4Writer.this.f12138h.get(streamingTrack).longValue() * streamingTrack2.mo445a()) - (FragmentedMp4Writer.this.f12138h.get(streamingTrack2).longValue() * streamingTrack.mo445a())));
            }
        });
    }

    @Override // org.mp4parser.streaming.p149b.SampleSink
    /* renamed from: a */
    public void mo464a(StreamingSample streamingSample, StreamingTrack streamingTrack) throws IOException {
        boolean z;
        synchronized (f12129a) {
            if (!this.f12145o) {
                boolean z2 = true;
                for (StreamingTrack streamingTrack2 : this.f12133c) {
                    if (this.f12139i.get(streamingTrack2).longValue() <= 0 && streamingTrack2 != streamingTrack) {
                        z = false;
                        z2 &= z;
                    }
                    z = true;
                    z2 &= z;
                }
                if (z2) {
                    m480a(m473f());
                    this.f12145o = true;
                }
            }
        }
        try {
            CountDownLatch countDownLatch = this.f12136f.get(streamingTrack);
            if (countDownLatch.getCount() > 0) {
                countDownLatch.await();
            }
        } catch (InterruptedException unused) {
        }
        if (m481a(streamingTrack, streamingSample)) {
            C3128a m468j = m468j(streamingTrack);
            this.f12140j.get(streamingTrack).clear();
            Map<StreamingTrack, Long> map = this.f12137g;
            map.put(streamingTrack, Long.valueOf(map.get(streamingTrack).longValue() + m468j.f12150b));
            Queue<C3128a> queue = this.f12141k.get(streamingTrack);
            queue.add(m468j);
            synchronized (f12129a) {
                if (this.f12145o && this.f12133c.get(0) == streamingTrack) {
                    while (true) {
                        Map<StreamingTrack, Queue<C3128a>> map2 = this.f12141k;
                        StreamingTrack streamingTrack3 = this.f12133c.get(0);
                        Queue<C3128a> queue2 = map2.get(streamingTrack3);
                        if (queue2.isEmpty()) {
                            break;
                        }
                        C3128a remove = queue2.remove();
                        m477b(remove.f12149a);
                        this.f12136f.get(streamingTrack3).countDown();
                        long longValue = this.f12138h.get(streamingTrack3).longValue() + remove.f12150b;
                        this.f12138h.put(streamingTrack3, Long.valueOf(longValue));
                        if (f12131q.isDebugEnabled()) {
                            InterfaceC3153b interfaceC3153b = f12131q;
                            interfaceC3153b.debug(streamingTrack3 + " advanced to " + (longValue / streamingTrack3.mo445a()));
                        }
                        m471h();
                    }
                } else if (queue.size() > 10) {
                    this.f12136f.put(streamingTrack, new CountDownLatch(queue.size()));
                }
            }
        }
        this.f12140j.get(streamingTrack).add(streamingSample);
        Map<StreamingTrack, Long> map3 = this.f12139i;
        map3.put(streamingTrack, Long.valueOf(map3.get(streamingTrack).longValue() + streamingSample.mo450b()));
    }

    /* renamed from: a */
    protected boolean m481a(StreamingTrack streamingTrack, StreamingSample streamingSample) {
        if (this.f12139i.get(streamingTrack).longValue() > this.f12137g.get(streamingTrack).longValue() + (streamingTrack.mo445a() * 3)) {
            SampleFlagsSampleExtension sampleFlagsSampleExtension = (SampleFlagsSampleExtension) streamingSample.mo452a(SampleFlagsSampleExtension.class);
            return sampleFlagsSampleExtension == null || sampleFlagsSampleExtension.m499g();
        }
        return false;
    }

    /* renamed from: a */
    protected InterfaceC3117b[] m485a(StreamingTrack streamingTrack, List<StreamingSample> list) {
        this.f12137g.get(streamingTrack);
        Map<StreamingTrack, long[]> map = this.f12142l;
        map.put(streamingTrack, Mp4Arrays.m716a(map.get(streamingTrack), this.f12144n));
        Map<StreamingTrack, long[]> map2 = this.f12143m;
        map2.put(streamingTrack, Mp4Arrays.m716a(map2.get(streamingTrack), this.f12137g.get(streamingTrack).longValue()));
        f12131q.trace("Container created");
        InterfaceC3117b m479b = m479b(streamingTrack, list);
        f12131q.trace("moof created");
        InterfaceC3117b m486a = m486a(list);
        f12131q.trace("mdat created");
        if (f12131q.isDebugEnabled()) {
            InterfaceC3153b interfaceC3153b = f12131q;
            interfaceC3153b.debug("created fragment for " + streamingTrack + " of " + ((this.f12139i.get(streamingTrack).longValue() - this.f12137g.get(streamingTrack).longValue()) / streamingTrack.mo445a()) + " seconds");
        }
        return new InterfaceC3117b[]{m479b, m486a};
    }

    /* renamed from: j */
    private C3128a m468j(StreamingTrack streamingTrack) {
        C3128a c3128a = new C3128a();
        c3128a.f12149a = m485a(streamingTrack, new ArrayList(this.f12140j.get(streamingTrack)));
        c3128a.f12150b = this.f12139i.get(streamingTrack).longValue() - this.f12137g.get(streamingTrack).longValue();
        return c3128a;
    }

    /* renamed from: a */
    protected void m480a(InterfaceC3117b... interfaceC3117bArr) throws IOException {
        m487a(this.f12132b, interfaceC3117bArr);
    }

    /* renamed from: b */
    protected void m477b(InterfaceC3117b... interfaceC3117bArr) throws IOException {
        m487a(this.f12132b, interfaceC3117bArr);
    }

    /* renamed from: c */
    protected void m476c(InterfaceC3117b... interfaceC3117bArr) throws IOException {
        m487a(this.f12132b, interfaceC3117bArr);
    }

    /* renamed from: b */
    private InterfaceC3117b m479b(StreamingTrack streamingTrack, List<StreamingSample> list) {
        MovieFragmentBox movieFragmentBox = new MovieFragmentBox();
        m488a(this.f12135e, movieFragmentBox);
        m482a(streamingTrack, movieFragmentBox, list);
        TrackRunBox trackRunBox = movieFragmentBox.m578c().get(0);
        trackRunBox.m635a(1);
        trackRunBox.m635a((int) (movieFragmentBox.mo400m_() + 8));
        return movieFragmentBox;
    }

    /* renamed from: a */
    protected void m484a(StreamingTrack streamingTrack, TrackFragmentBox trackFragmentBox) {
        TrackFragmentHeaderBox trackFragmentHeaderBox = new TrackFragmentHeaderBox();
        SampleFlags sampleFlags = new SampleFlags();
        DefaultSampleFlagsTrackExtension defaultSampleFlagsTrackExtension = (DefaultSampleFlagsTrackExtension) streamingTrack.mo456a(DefaultSampleFlagsTrackExtension.class);
        if (defaultSampleFlagsTrackExtension != null) {
            sampleFlags.m560a(defaultSampleFlagsTrackExtension.m517a());
            sampleFlags.m556b(defaultSampleFlagsTrackExtension.m515c());
            sampleFlags.m559a((int) defaultSampleFlagsTrackExtension.m516b());
            sampleFlags.m555c(defaultSampleFlagsTrackExtension.m514d());
            sampleFlags.m557a(defaultSampleFlagsTrackExtension.m512f());
            sampleFlags.m554d(defaultSampleFlagsTrackExtension.m513e());
            sampleFlags.m553e(defaultSampleFlagsTrackExtension.m511g());
        }
        trackFragmentHeaderBox.m669a(sampleFlags);
        trackFragmentHeaderBox.m667b(-1L);
        trackFragmentHeaderBox.m670a(((TrackIdTrackExtension) streamingTrack.mo456a(TrackIdTrackExtension.class)).m497a());
        trackFragmentHeaderBox.m668a(true);
        trackFragmentBox.m746a(trackFragmentHeaderBox);
    }

    /* renamed from: b */
    protected void m478b(StreamingTrack streamingTrack, TrackFragmentBox trackFragmentBox) {
        TrackFragmentBaseMediaDecodeTimeBox trackFragmentBaseMediaDecodeTimeBox = new TrackFragmentBaseMediaDecodeTimeBox();
        trackFragmentBaseMediaDecodeTimeBox.m398b(1);
        trackFragmentBaseMediaDecodeTimeBox.m672a(this.f12137g.get(streamingTrack).longValue());
        trackFragmentBox.m746a(trackFragmentBaseMediaDecodeTimeBox);
    }

    /* renamed from: a */
    protected void m483a(StreamingTrack streamingTrack, TrackFragmentBox trackFragmentBox, List<StreamingSample> list) {
        TrackRunBox trackRunBox = new TrackRunBox();
        trackRunBox.m398b(1);
        trackRunBox.m632b(true);
        trackRunBox.m633a(true);
        ArrayList arrayList = new ArrayList(list.size());
        trackRunBox.m629d(streamingTrack.mo456a(CompositionTimeTrackExtension.class) != null);
        DefaultSampleFlagsTrackExtension defaultSampleFlagsTrackExtension = (DefaultSampleFlagsTrackExtension) streamingTrack.mo456a(DefaultSampleFlagsTrackExtension.class);
        trackRunBox.m631c(defaultSampleFlagsTrackExtension == null);
        for (StreamingSample streamingSample : list) {
            TrackRunBox.C3121a c3121a = new TrackRunBox.C3121a();
            c3121a.m617b(streamingSample.mo453a().remaining());
            if (defaultSampleFlagsTrackExtension == null) {
                SampleFlagsSampleExtension sampleFlagsSampleExtension = (SampleFlagsSampleExtension) streamingSample.mo452a(SampleFlagsSampleExtension.class);
                if (!f12130p && sampleFlagsSampleExtension == null) {
                    throw new AssertionError("SampleDependencySampleExtension missing even though SampleDependencyTrackExtension was present");
                }
                SampleFlags sampleFlags = new SampleFlags();
                sampleFlags.m560a(sampleFlagsSampleExtension.m508a());
                sampleFlags.m556b(sampleFlagsSampleExtension.m503c());
                sampleFlags.m559a((int) sampleFlagsSampleExtension.m505b());
                sampleFlags.m555c(sampleFlagsSampleExtension.m502d());
                sampleFlags.m557a(sampleFlagsSampleExtension.m500f());
                sampleFlags.m554d(sampleFlagsSampleExtension.m501e());
                sampleFlags.m553e(sampleFlagsSampleExtension.m498h());
                c3121a.m618a(sampleFlags);
            }
            c3121a.m622a(streamingSample.mo450b());
            if (trackRunBox.m625h()) {
                CompositionTimeSampleExtension compositionTimeSampleExtension = (CompositionTimeSampleExtension) streamingSample.mo452a(CompositionTimeSampleExtension.class);
                if (!f12130p && compositionTimeSampleExtension == null) {
                    throw new AssertionError("CompositionTimeSampleExtension missing even though CompositionTimeTrackExtension was present");
                }
                c3121a.m623a(CastUtils.m743a(compositionTimeSampleExtension.m519a()));
            }
            arrayList.add(c3121a);
        }
        trackRunBox.m634a(arrayList);
        trackFragmentBox.m746a(trackRunBox);
    }

    /* renamed from: a */
    private void m482a(StreamingTrack streamingTrack, MovieFragmentBox movieFragmentBox, List<StreamingSample> list) {
        TrackFragmentBox trackFragmentBox = new TrackFragmentBox();
        movieFragmentBox.m746a(trackFragmentBox);
        m484a(streamingTrack, trackFragmentBox);
        m478b(streamingTrack, trackFragmentBox);
        m483a(streamingTrack, trackFragmentBox, list);
        streamingTrack.mo456a(CencEncryptTrackExtension.class);
    }

    /* renamed from: g */
    protected InterfaceC3117b[] m472g() {
        MovieFragmentRandomAccessBox movieFragmentRandomAccessBox = new MovieFragmentRandomAccessBox();
        for (StreamingTrack streamingTrack : this.f12133c) {
            movieFragmentRandomAccessBox.m746a(m469i(streamingTrack));
        }
        MovieFragmentRandomAccessOffsetBox movieFragmentRandomAccessOffsetBox = new MovieFragmentRandomAccessOffsetBox();
        movieFragmentRandomAccessBox.m746a(movieFragmentRandomAccessOffsetBox);
        movieFragmentRandomAccessOffsetBox.m575a(movieFragmentRandomAccessBox.mo400m_());
        return new InterfaceC3117b[]{movieFragmentRandomAccessBox};
    }

    /* renamed from: i */
    protected InterfaceC3117b m469i(StreamingTrack streamingTrack) {
        TrackFragmentRandomAccessBox trackFragmentRandomAccessBox = new TrackFragmentRandomAccessBox();
        trackFragmentRandomAccessBox.m398b(1);
        long[] jArr = this.f12142l.get(streamingTrack);
        long[] jArr2 = this.f12143m.get(streamingTrack);
        ArrayList arrayList = new ArrayList(jArr2.length);
        for (int i = 0; i < jArr2.length; i++) {
            arrayList.add(new TrackFragmentRandomAccessBox.C3120a(jArr2[i], jArr[i], 1L, 1L, 1L));
        }
        trackFragmentRandomAccessBox.m660a(arrayList);
        trackFragmentRandomAccessBox.m661a(((TrackIdTrackExtension) streamingTrack.mo456a(TrackIdTrackExtension.class)).m497a());
        return trackFragmentRandomAccessBox;
    }

    /* renamed from: a */
    private void m488a(long j, MovieFragmentBox movieFragmentBox) {
        MovieFragmentHeaderBox movieFragmentHeaderBox = new MovieFragmentHeaderBox();
        movieFragmentHeaderBox.m577a(j);
        movieFragmentBox.m746a(movieFragmentHeaderBox);
    }

    /* renamed from: a */
    private InterfaceC3117b m486a(final List<StreamingSample> list) {
        return new InterfaceC3117b() { // from class: org.mp4parser.streaming.b.a.b.2
            @Override // org.mp4parser.InterfaceC3117b
            /* renamed from: n_ */
            public String mo399n_() {
                return "mdat";
            }

            @Override // org.mp4parser.InterfaceC3117b
            /* renamed from: m_ */
            public long mo400m_() {
                long j = 8;
                for (StreamingSample streamingSample : list) {
                    j += streamingSample.mo453a().limit();
                }
                return j;
            }

            @Override // org.mp4parser.InterfaceC3117b
            /* renamed from: a */
            public void mo402a(WritableByteChannel writableByteChannel) throws IOException {
                long j = 8;
                for (StreamingSample streamingSample : list) {
                    j += streamingSample.mo453a().limit();
                }
                ByteBuffer allocate = ByteBuffer.allocate(8);
                IsoTypeWriter.m720b(allocate, j);
                allocate.put(IsoFile.m524a(mo399n_()));
                writableByteChannel.write((ByteBuffer) allocate.rewind());
                for (StreamingSample streamingSample2 : list) {
                    writableByteChannel.write((ByteBuffer) streamingSample2.mo453a().rewind());
                }
            }
        };
    }

    /* compiled from: FragmentedMp4Writer.java */
    /* renamed from: org.mp4parser.streaming.b.a.b$a */
    /* loaded from: classes2.dex */
    public class C3128a {

        /* renamed from: a */
        InterfaceC3117b[] f12149a;

        /* renamed from: b */
        long f12150b;

        public C3128a() {
        }
    }
}
