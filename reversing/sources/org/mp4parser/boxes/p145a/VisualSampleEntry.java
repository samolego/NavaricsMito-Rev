package org.mp4parser.boxes.p145a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import org.mp4parser.Container;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.p144a.Utf8;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: org.mp4parser.boxes.a.c */
/* loaded from: classes2.dex */
public final class VisualSampleEntry extends AbstractSampleEntry implements Container {

    /* renamed from: b */
    static final /* synthetic */ boolean f11731b = !VisualSampleEntry.class.desiredAssertionStatus();

    /* renamed from: e */
    private int f11732e;

    /* renamed from: f */
    private int f11733f;

    /* renamed from: g */
    private double f11734g;

    /* renamed from: h */
    private double f11735h;

    /* renamed from: i */
    private int f11736i;

    /* renamed from: j */
    private String f11737j;

    /* renamed from: k */
    private int f11738k;

    /* renamed from: l */
    private long[] f11739l;

    public VisualSampleEntry() {
        super("avc1");
        this.f11734g = 72.0d;
        this.f11735h = 72.0d;
        this.f11736i = 1;
        this.f11737j = "";
        this.f11738k = 24;
        this.f11739l = new long[3];
    }

    public VisualSampleEntry(String str) {
        super(str);
        this.f11734g = 72.0d;
        this.f11735h = 72.0d;
        this.f11736i = 1;
        this.f11737j = "";
        this.f11738k = 24;
        this.f11739l = new long[3];
    }

    /* renamed from: c */
    public int m701c() {
        return this.f11732e;
    }

    /* renamed from: b */
    public void m702b(int i) {
        this.f11732e = i;
    }

    /* renamed from: d */
    public int m699d() {
        return this.f11733f;
    }

    /* renamed from: c */
    public void m700c(int i) {
        this.f11733f = i;
    }

    /* renamed from: e */
    public double m697e() {
        return this.f11734g;
    }

    /* renamed from: a */
    public void m705a(double d) {
        this.f11734g = d;
    }

    /* renamed from: f */
    public double m695f() {
        return this.f11735h;
    }

    /* renamed from: b */
    public void m703b(double d) {
        this.f11735h = d;
    }

    /* renamed from: g */
    public int m694g() {
        return this.f11736i;
    }

    /* renamed from: d */
    public void m698d(int i) {
        this.f11736i = i;
    }

    /* renamed from: h */
    public String m693h() {
        return this.f11737j;
    }

    /* renamed from: a */
    public void m704a(String str) {
        this.f11737j = str;
    }

    /* renamed from: i */
    public int m692i() {
        return this.f11738k;
    }

    /* renamed from: e */
    public void m696e(int i) {
        this.f11738k = i;
    }

    @Override // org.mp4parser.support.AbstractContainerBox, org.mp4parser.InterfaceC3117b
    /* renamed from: a */
    public void mo402a(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(m401j());
        ByteBuffer allocate = ByteBuffer.allocate(78);
        allocate.position(6);
        IsoTypeWriter.m721b(allocate, this.f11730a);
        IsoTypeWriter.m721b(allocate, 0);
        IsoTypeWriter.m721b(allocate, 0);
        IsoTypeWriter.m720b(allocate, this.f11739l[0]);
        IsoTypeWriter.m720b(allocate, this.f11739l[1]);
        IsoTypeWriter.m720b(allocate, this.f11739l[2]);
        IsoTypeWriter.m721b(allocate, m701c());
        IsoTypeWriter.m721b(allocate, m699d());
        IsoTypeWriter.m726a(allocate, m697e());
        IsoTypeWriter.m726a(allocate, m695f());
        IsoTypeWriter.m720b(allocate, 0L);
        IsoTypeWriter.m721b(allocate, m694g());
        IsoTypeWriter.m718c(allocate, Utf8.m707b(m693h()));
        allocate.put(Utf8.m709a(m693h()));
        int m707b = Utf8.m707b(m693h());
        while (m707b < 31) {
            m707b++;
            allocate.put((byte) 0);
        }
        IsoTypeWriter.m721b(allocate, m692i());
        IsoTypeWriter.m721b(allocate, 65535);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        m745a_(writableByteChannel);
    }

    @Override // org.mp4parser.support.AbstractContainerBox, org.mp4parser.InterfaceC3117b
    /* renamed from: m_ */
    public long mo400m_() {
        long b = m744b() + 78;
        return b + ((this.f12380d || 8 + b >= IjkMediaMeta.AV_CH_WIDE_RIGHT) ? 16 : 8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VisualSampleEntry visualSampleEntry = (VisualSampleEntry) obj;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            mo402a(Channels.newChannel(byteArrayOutputStream));
            try {
                visualSampleEntry.mo402a(Channels.newChannel(byteArrayOutputStream2));
                return Arrays.equals(byteArrayOutputStream.toByteArray(), byteArrayOutputStream2.toByteArray());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public int hashCode() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            mo402a(Channels.newChannel(byteArrayOutputStream));
            return Arrays.hashCode(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
