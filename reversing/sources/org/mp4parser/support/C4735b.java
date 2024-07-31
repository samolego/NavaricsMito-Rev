package org.mp4parser.support;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import org.mp4parser.BasicContainer;
import org.mp4parser.ParsableBox;
import org.mp4parser.p144a.IsoTypeWriter;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: org.mp4parser.support.b */
/* loaded from: classes2.dex */
public class AbstractContainerBox extends BasicContainer implements ParsableBox {

    /* renamed from: c */
    protected String f12379c;

    /* renamed from: d */
    protected boolean f12380d;

    public AbstractContainerBox(String str) {
        this.f12379c = str;
    }

    /* renamed from: m_ */
    public long mo400m_() {
        long b = m744b();
        return b + ((this.f12380d || 8 + b >= IjkMediaMeta.AV_CH_WIDE_RIGHT) ? 16 : 8);
    }

    @Override // org.mp4parser.InterfaceC3117b
    /* renamed from: n_ */
    public String mo399n_() {
        return this.f12379c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public ByteBuffer m401j() {
        ByteBuffer wrap;
        if (this.f12380d || mo400m_() >= IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            wrap = ByteBuffer.wrap(new byte[]{0, 0, 0, 1, this.f12379c.getBytes()[0], this.f12379c.getBytes()[1], this.f12379c.getBytes()[2], this.f12379c.getBytes()[3], 0, 0, 0, 0, 0, 0, 0, 0});
            wrap.position(8);
            IsoTypeWriter.m724a(wrap, mo400m_());
        } else {
            wrap = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, this.f12379c.getBytes()[0], this.f12379c.getBytes()[1], this.f12379c.getBytes()[2], this.f12379c.getBytes()[3]});
            IsoTypeWriter.m720b(wrap, mo400m_());
        }
        wrap.rewind();
        return wrap;
    }

    /* renamed from: a */
    public void mo402a(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(m401j());
        m745a_(writableByteChannel);
    }
}
