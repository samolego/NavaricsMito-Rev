package org.mp4parser.streaming;

import java.io.Closeable;
import org.mp4parser.boxes.iso14496.p146a.SampleDescriptionBox;
import org.mp4parser.streaming.p149b.SampleSink;

/* renamed from: org.mp4parser.streaming.c */
/* loaded from: classes2.dex */
public interface StreamingTrack extends Closeable {
    /* renamed from: a */
    long mo445a();

    /* renamed from: a */
    <T extends TrackExtension> T mo456a(Class<T> cls);

    /* renamed from: a */
    void mo455a(SampleSink sampleSink);

    /* renamed from: a */
    void mo454a(TrackExtension trackExtension);

    /* renamed from: b */
    String mo439b();

    /* renamed from: c */
    String mo437c();

    /* renamed from: d */
    SampleDescriptionBox mo435d();
}
