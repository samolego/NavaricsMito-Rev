package org.mp4parser.streaming.input.h264;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.Callable;
import org.mp4parser.streaming.p148a.TrackIdTrackExtension;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.mp4parser.streaming.input.h264.b */
/* loaded from: classes2.dex */
public class H264AnnexBTrack extends H264NalConsumingTrack implements Callable<Void> {

    /* renamed from: d */
    static final /* synthetic */ boolean f12183d = !H264AnnexBTrack.class.desiredAssertionStatus();

    /* renamed from: v */
    private InputStream f12184v;

    public H264AnnexBTrack(InputStream inputStream) throws IOException {
        if (!f12183d && inputStream == null) {
            throw new AssertionError();
        }
        this.f12184v = new BufferedInputStream(inputStream);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: e */
    public Void call() throws IOException, InterruptedException {
        C3133b c3133b = new C3133b(this.f12184v);
        while (true) {
            byte[] m446a = c3133b.m446a();
            if (m446a != null) {
                m438b(ByteBuffer.wrap(m446a));
            } else {
                m442a(m443a(this.f12204s, this.f12205t.f12207a, this.f12206u), true, true);
                return null;
            }
        }
    }

    public String toString() {
        TrackIdTrackExtension trackIdTrackExtension = (TrackIdTrackExtension) mo456a(TrackIdTrackExtension.class);
        if (trackIdTrackExtension != null) {
            return "H264AnnexBTrack{trackId=" + trackIdTrackExtension.m497a() + "}";
        }
        return "H264AnnexBTrack{}";
    }

    /* compiled from: H264AnnexBTrack.java */
    /* renamed from: org.mp4parser.streaming.input.h264.b$b */
    /* loaded from: classes2.dex */
    public static class C3133b {

        /* renamed from: c */
        private static InterfaceC3153b f12185c = C3154c.m260a(C3133b.class.getName());

        /* renamed from: a */
        C3132a f12186a = new C3132a();

        /* renamed from: b */
        int f12187b = 0;

        /* renamed from: d */
        private InputStream f12188d;

        public C3133b(InputStream inputStream) {
            this.f12188d = inputStream;
        }

        /* renamed from: a */
        public byte[] m446a() throws IOException {
            f12185c.isDebugEnabled();
            while (true) {
                int read = this.f12188d.read();
                if (read != -1) {
                    if (this.f12187b != 2 || read != 3) {
                        this.f12186a.write(read);
                        if (this.f12187b == 0 && read == 0) {
                            this.f12187b = 1;
                        } else if (this.f12187b == 1 && read == 0) {
                            this.f12187b = 2;
                        } else if (this.f12187b == 2 && read == 0) {
                            byte[] m447a = this.f12186a.m447a();
                            this.f12186a.reset();
                            if (m447a != null) {
                                return m447a;
                            }
                        } else if (this.f12187b == 2 && read == 1) {
                            byte[] m447a2 = this.f12186a.m447a();
                            this.f12186a.reset();
                            this.f12187b = 0;
                            if (m447a2 != null) {
                                return m447a2;
                            }
                        } else if (this.f12187b != 0) {
                            this.f12187b = 0;
                        }
                    } else {
                        this.f12187b = 0;
                    }
                } else {
                    byte[] byteArray = this.f12186a.toByteArray();
                    this.f12186a.reset();
                    if (byteArray.length > 0) {
                        return byteArray;
                    }
                    return null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: H264AnnexBTrack.java */
    /* renamed from: org.mp4parser.streaming.input.h264.b$a */
    /* loaded from: classes2.dex */
    public static class C3132a extends ByteArrayOutputStream {
        C3132a() {
        }

        /* renamed from: a */
        public byte[] m447a() {
            if (this.count > 3) {
                return Arrays.copyOf(this.buf, this.count - 3 > 0 ? this.count - 3 : 0);
            }
            return null;
        }
    }
}
