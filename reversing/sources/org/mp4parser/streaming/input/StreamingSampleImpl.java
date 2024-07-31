package org.mp4parser.streaming.input;

import android.support.p008v4.view.MotionEventCompat;
import android.support.p008v4.view.ViewCompat;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import org.mp4parser.streaming.SampleExtension;
import org.mp4parser.streaming.StreamingSample;

/* renamed from: org.mp4parser.streaming.input.b */
/* loaded from: classes2.dex */
public class StreamingSampleImpl implements StreamingSample {

    /* renamed from: a */
    private ByteBuffer f12180a;

    /* renamed from: b */
    private long f12181b;

    /* renamed from: c */
    private HashMap<Class<? extends SampleExtension>, SampleExtension> f12182c = new HashMap<>();

    public StreamingSampleImpl(List<ByteBuffer> list, long j) {
        this.f12181b = j;
        int i = 0;
        for (ByteBuffer byteBuffer : list) {
            i = i + 4 + byteBuffer.limit();
        }
        this.f12180a = ByteBuffer.allocate(i);
        for (ByteBuffer byteBuffer2 : list) {
            this.f12180a.put((byte) ((byteBuffer2.limit() & ViewCompat.MEASURED_STATE_MASK) >> 24));
            this.f12180a.put((byte) ((byteBuffer2.limit() & 16711680) >> 16));
            this.f12180a.put((byte) ((byteBuffer2.limit() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8));
            this.f12180a.put((byte) (byteBuffer2.limit() & 255));
            this.f12180a.put((ByteBuffer) byteBuffer2.rewind());
        }
    }

    @Override // org.mp4parser.streaming.StreamingSample
    /* renamed from: a */
    public ByteBuffer mo453a() {
        return this.f12180a;
    }

    @Override // org.mp4parser.streaming.StreamingSample
    /* renamed from: b */
    public long mo450b() {
        return this.f12181b;
    }

    @Override // org.mp4parser.streaming.StreamingSample
    /* renamed from: a */
    public <T extends SampleExtension> T mo452a(Class<T> cls) {
        return (T) this.f12182c.get(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.mp4parser.streaming.StreamingSample
    /* renamed from: a */
    public void mo451a(SampleExtension sampleExtension) {
        this.f12182c.put(sampleExtension.getClass(), sampleExtension);
    }

    @Override // org.mp4parser.streaming.StreamingSample
    /* renamed from: b */
    public <T extends SampleExtension> T mo449b(Class<T> cls) {
        return (T) this.f12182c.remove(cls);
    }
}
