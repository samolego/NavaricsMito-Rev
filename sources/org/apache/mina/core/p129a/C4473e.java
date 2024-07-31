package org.apache.mina.core.p129a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: org.apache.mina.core.a.e */
/* loaded from: classes2.dex */
public class SimpleBufferAllocator implements IoBufferAllocator {
    @Override // org.apache.mina.core.p129a.IoBufferAllocator
    /* renamed from: a */
    public void mo1350a() {
    }

    @Override // org.apache.mina.core.p129a.IoBufferAllocator
    /* renamed from: a */
    public AbstractC3054b mo1349a(int i, boolean z) {
        return mo1348a(mo1347b(i, z));
    }

    @Override // org.apache.mina.core.p129a.IoBufferAllocator
    /* renamed from: b */
    public ByteBuffer mo1347b(int i, boolean z) {
        if (z) {
            return ByteBuffer.allocateDirect(i);
        }
        return ByteBuffer.allocate(i);
    }

    @Override // org.apache.mina.core.p129a.IoBufferAllocator
    /* renamed from: a */
    public AbstractC3054b mo1348a(ByteBuffer byteBuffer) {
        return new C3055a(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SimpleBufferAllocator.java */
    /* renamed from: org.apache.mina.core.a.e$a */
    /* loaded from: classes2.dex */
    public class C3055a extends AbstractIoBuffer {

        /* renamed from: b */
        private ByteBuffer f11325b;

        @Override // org.apache.mina.core.p129a.AbstractC3054b
        /* renamed from: s */
        public void mo1345s() {
        }

        protected C3055a(ByteBuffer byteBuffer) {
            super(SimpleBufferAllocator.this, byteBuffer.capacity());
            this.f11325b = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // org.apache.mina.core.p129a.AbstractC3054b
        /* renamed from: t */
        public ByteBuffer mo1344t() {
            return this.f11325b;
        }

        @Override // org.apache.mina.core.p129a.AbstractIoBuffer
        /* renamed from: a */
        protected void mo1346a(ByteBuffer byteBuffer) {
            this.f11325b = byteBuffer;
        }

        @Override // org.apache.mina.core.p129a.AbstractC3054b
        /* renamed from: v */
        public byte[] mo1342v() {
            return this.f11325b.array();
        }

        @Override // org.apache.mina.core.p129a.AbstractC3054b
        /* renamed from: w */
        public int mo1341w() {
            return this.f11325b.arrayOffset();
        }

        @Override // org.apache.mina.core.p129a.AbstractC3054b
        /* renamed from: u */
        public boolean mo1343u() {
            return this.f11325b.hasArray();
        }
    }
}
