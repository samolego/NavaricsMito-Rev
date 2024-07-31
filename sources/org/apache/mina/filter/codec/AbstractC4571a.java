package org.apache.mina.filter.codec;

import java.util.LinkedList;
import java.util.Queue;

/* renamed from: org.apache.mina.filter.codec.a */
/* loaded from: classes2.dex */
public abstract class AbstractProtocolDecoderOutput implements ProtocolDecoderOutput {

    /* renamed from: a */
    private final Queue<Object> f11614a = new LinkedList();

    /* renamed from: a */
    public Queue<Object> m865a() {
        return this.f11614a;
    }

    @Override // org.apache.mina.filter.codec.ProtocolDecoderOutput
    /* renamed from: a */
    public void mo832a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("message");
        }
        this.f11614a.add(obj);
    }
}
