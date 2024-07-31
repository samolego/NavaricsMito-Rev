package org.mp4parser.streaming.p149b;

import java.io.Closeable;
import java.io.IOException;
import org.mp4parser.streaming.StreamingSample;
import org.mp4parser.streaming.StreamingTrack;

/* renamed from: org.mp4parser.streaming.b.a */
/* loaded from: classes2.dex */
public interface SampleSink extends Closeable {
    /* renamed from: a */
    void mo464a(StreamingSample streamingSample, StreamingTrack streamingTrack) throws IOException;
}
