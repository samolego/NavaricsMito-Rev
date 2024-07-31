package org.mp4parser.streaming;

import java.nio.ByteBuffer;

/* renamed from: org.mp4parser.streaming.b */
/* loaded from: classes2.dex */
public interface StreamingSample {
    /* renamed from: a */
    ByteBuffer mo453a();

    /* renamed from: a */
    <T extends SampleExtension> T mo452a(Class<T> cls);

    /* renamed from: a */
    void mo451a(SampleExtension sampleExtension);

    /* renamed from: b */
    long mo450b();

    /* renamed from: b */
    <T extends SampleExtension> T mo449b(Class<T> cls);
}
