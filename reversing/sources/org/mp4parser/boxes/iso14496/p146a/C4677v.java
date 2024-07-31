package org.mp4parser.boxes.iso14496.p146a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import org.mp4parser.InterfaceC3124d;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractContainerBox;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: org.mp4parser.boxes.iso14496.a.v */
/* loaded from: classes2.dex */
public class SampleDescriptionBox extends AbstractContainerBox implements InterfaceC3124d {

    /* renamed from: a */
    private int f12021a;

    /* renamed from: b */
    private int f12022b;

    public SampleDescriptionBox() {
        super("stsd");
    }

    @Override // org.mp4parser.support.AbstractContainerBox, org.mp4parser.InterfaceC3117b
    /* renamed from: a */
    public void mo402a(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(m401j());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        IsoTypeWriter.m718c(allocate, this.f12021a);
        IsoTypeWriter.m725a(allocate, this.f12022b);
        IsoTypeWriter.m720b(allocate, mo526a().size());
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        m745a_(writableByteChannel);
    }

    @Override // org.mp4parser.support.AbstractContainerBox, org.mp4parser.InterfaceC3117b
    /* renamed from: m_ */
    public long mo400m_() {
        long b = m744b() + 8;
        return b + ((this.f12380d || 8 + b >= IjkMediaMeta.AV_CH_WIDE_RIGHT) ? 16 : 8);
    }
}
