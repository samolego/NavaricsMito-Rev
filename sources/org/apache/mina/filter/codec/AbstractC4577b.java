package org.apache.mina.filter.codec;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.mina.core.p129a.AbstractC3054b;

/* renamed from: org.apache.mina.filter.codec.b */
/* loaded from: classes2.dex */
public abstract class AbstractProtocolEncoderOutput implements ProtocolEncoderOutput {

    /* renamed from: a */
    private final Queue<Object> f11634a = new ConcurrentLinkedQueue();

    /* renamed from: b */
    private boolean f11635b = true;

    /* renamed from: a */
    public Queue<Object> m849a() {
        return this.f11634a;
    }

    @Override // org.apache.mina.filter.codec.ProtocolEncoderOutput
    /* renamed from: a */
    public void mo828a(Object obj) {
        if (obj instanceof AbstractC3054b) {
            AbstractC3054b abstractC3054b = (AbstractC3054b) obj;
            if (abstractC3054b.mo1356m()) {
                this.f11634a.offer(abstractC3054b);
                return;
            }
            throw new IllegalArgumentException("buf is empty. Forgot to call flip()?");
        }
        this.f11634a.offer(obj);
        this.f11635b = false;
    }
}
