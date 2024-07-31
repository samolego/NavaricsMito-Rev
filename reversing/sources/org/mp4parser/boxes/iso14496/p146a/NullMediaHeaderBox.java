package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;

/* renamed from: org.mp4parser.boxes.iso14496.a.u */
/* loaded from: classes2.dex */
public class NullMediaHeaderBox extends AbstractMediaHeaderBox {
    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return 4L;
    }

    public NullMediaHeaderBox() {
        super("nmhd");
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
    }
}
