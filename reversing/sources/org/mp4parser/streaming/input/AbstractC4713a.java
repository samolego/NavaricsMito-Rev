package org.mp4parser.streaming.input;

import java.util.HashMap;
import org.mp4parser.boxes.iso14496.p146a.TrackHeaderBox;
import org.mp4parser.streaming.StreamingTrack;
import org.mp4parser.streaming.TrackExtension;
import org.mp4parser.streaming.p149b.SampleSink;

/* renamed from: org.mp4parser.streaming.input.a */
/* loaded from: classes2.dex */
public abstract class AbstractStreamingTrack implements StreamingTrack {

    /* renamed from: c */
    protected SampleSink f12179c;

    /* renamed from: b */
    protected HashMap<Class<? extends TrackExtension>, TrackExtension> f12178b = new HashMap<>();

    /* renamed from: a */
    protected TrackHeaderBox f12177a = new TrackHeaderBox();

    public AbstractStreamingTrack() {
        this.f12177a.m647a(1L);
    }

    @Override // org.mp4parser.streaming.StreamingTrack
    /* renamed from: a */
    public void mo455a(SampleSink sampleSink) {
        this.f12179c = sampleSink;
    }

    @Override // org.mp4parser.streaming.StreamingTrack
    /* renamed from: a */
    public <T extends TrackExtension> T mo456a(Class<T> cls) {
        return (T) this.f12178b.get(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.mp4parser.streaming.StreamingTrack
    /* renamed from: a */
    public void mo454a(TrackExtension trackExtension) {
        this.f12178b.put(trackExtension.getClass(), trackExtension);
    }
}
