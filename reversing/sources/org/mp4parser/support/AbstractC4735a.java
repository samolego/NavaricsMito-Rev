package org.mp4parser.support;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import org.mp4parser.IsoFile;
import org.mp4parser.ParsableBox;
import org.mp4parser.p144a.CastUtils;
import org.mp4parser.p144a.Hex;
import org.mp4parser.p144a.IsoTypeWriter;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: org.mp4parser.support.a */
/* loaded from: classes2.dex */
public abstract class AbstractBox implements ParsableBox {

    /* renamed from: b */
    private byte[] f12374b;

    /* renamed from: d */
    protected String f12376d;

    /* renamed from: e */
    protected ByteBuffer f12377e;

    /* renamed from: g */
    static final /* synthetic */ boolean f12373g = !AbstractBox.class.desiredAssertionStatus();

    /* renamed from: a */
    private static InterfaceC3153b f12372a = C3154c.m262a(AbstractBox.class);

    /* renamed from: c */
    private ByteBuffer f12375c = null;

    /* renamed from: f */
    boolean f12378f = true;

    /* renamed from: a */
    protected abstract void mo411a(ByteBuffer byteBuffer);

    /* renamed from: b */
    protected abstract void mo410b(ByteBuffer byteBuffer);

    /* renamed from: l_ */
    protected abstract long mo406l_();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractBox(String str) {
        this.f12376d = str;
    }

    @Override // org.mp4parser.InterfaceC3117b
    /* renamed from: a */
    public void mo402a(WritableByteChannel writableByteChannel) throws IOException {
        if (this.f12378f) {
            ByteBuffer allocate = ByteBuffer.allocate(CastUtils.m743a(mo400m_()));
            m407d(allocate);
            mo410b(allocate);
            ByteBuffer byteBuffer = this.f12375c;
            if (byteBuffer != null) {
                byteBuffer.rewind();
                while (this.f12375c.remaining() > 0) {
                    allocate.put(this.f12375c);
                }
            }
            writableByteChannel.write((ByteBuffer) allocate.rewind());
            return;
        }
        ByteBuffer allocate2 = ByteBuffer.allocate((m408d() ? 8 : 16) + ("uuid".equals(mo399n_()) ? 16 : 0));
        m407d(allocate2);
        writableByteChannel.write((ByteBuffer) allocate2.rewind());
        writableByteChannel.write((ByteBuffer) this.f12377e.position(0));
    }

    /* renamed from: m */
    public final synchronized void m405m() {
        f12372a.debug("parsing details of {}", mo399n_());
        if (this.f12377e != null) {
            ByteBuffer byteBuffer = this.f12377e;
            this.f12378f = true;
            byteBuffer.rewind();
            mo411a(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.f12375c = byteBuffer.slice();
            }
            this.f12377e = null;
            if (!f12373g && !m409c(byteBuffer)) {
                throw new AssertionError();
            }
        }
    }

    @Override // org.mp4parser.InterfaceC3117b
    /* renamed from: m_ */
    public long mo400m_() {
        long mo406l_ = this.f12378f ? mo406l_() : this.f12377e.limit();
        long j = mo406l_ + (mo406l_ >= 4294967288L ? 8 : 0) + 8 + ("uuid".equals(mo399n_()) ? 16 : 0);
        ByteBuffer byteBuffer = this.f12375c;
        return j + (byteBuffer != null ? byteBuffer.limit() : 0);
    }

    @Override // org.mp4parser.InterfaceC3117b
    @DoNotParseDetail
    /* renamed from: n_ */
    public String mo399n_() {
        return this.f12376d;
    }

    @DoNotParseDetail
    /* renamed from: n */
    public byte[] m404n() {
        return this.f12374b;
    }

    /* renamed from: o */
    public boolean m403o() {
        return this.f12378f;
    }

    /* renamed from: c */
    private boolean m409c(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        ByteBuffer allocate = ByteBuffer.allocate(CastUtils.m743a(mo406l_() + (this.f12375c != null ? byteBuffer2.limit() : 0)));
        mo410b(allocate);
        ByteBuffer byteBuffer3 = this.f12375c;
        if (byteBuffer3 != null) {
            byteBuffer3.rewind();
            while (this.f12375c.remaining() > 0) {
                allocate.put(this.f12375c);
            }
        }
        byteBuffer.rewind();
        allocate.rewind();
        if (byteBuffer.remaining() != allocate.remaining()) {
            f12372a.error("{}: remaining differs {}  vs. {}", mo399n_(), Integer.valueOf(byteBuffer.remaining()), Integer.valueOf(allocate.remaining()));
            return false;
        }
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 1;
        int limit2 = allocate.limit() - 1;
        while (limit >= position) {
            byte b = byteBuffer.get(limit);
            byte b2 = allocate.get(limit2);
            if (b != b2) {
                f12372a.error("{}: buffers differ at {}: {}/{}", mo399n_(), Integer.valueOf(limit), Byte.valueOf(b), Byte.valueOf(b2));
                byte[] bArr = new byte[byteBuffer.remaining()];
                byte[] bArr2 = new byte[allocate.remaining()];
                byteBuffer.get(bArr);
                allocate.get(bArr2);
                f12372a.error("original      : {}", Hex.m740a(bArr, 4));
                f12372a.error("reconstructed : {}", Hex.m740a(bArr2, 4));
                return false;
            }
            limit--;
            limit2--;
        }
        return true;
    }

    /* renamed from: d */
    private boolean m408d() {
        int i = "uuid".equals(mo399n_()) ? 24 : 8;
        if (!this.f12378f) {
            return ((long) (this.f12377e.limit() + i)) < IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        long mo406l_ = mo406l_();
        ByteBuffer byteBuffer = this.f12375c;
        return (mo406l_ + ((long) (byteBuffer != null ? byteBuffer.limit() : 0))) + ((long) i) < IjkMediaMeta.AV_CH_WIDE_RIGHT;
    }

    /* renamed from: d */
    private void m407d(ByteBuffer byteBuffer) {
        if (m408d()) {
            IsoTypeWriter.m720b(byteBuffer, mo400m_());
            byteBuffer.put(IsoFile.m524a(mo399n_()));
        } else {
            IsoTypeWriter.m720b(byteBuffer, 1L);
            byteBuffer.put(IsoFile.m524a(mo399n_()));
            IsoTypeWriter.m724a(byteBuffer, mo400m_());
        }
        if ("uuid".equals(mo399n_())) {
            byteBuffer.put(m404n());
        }
    }
}
