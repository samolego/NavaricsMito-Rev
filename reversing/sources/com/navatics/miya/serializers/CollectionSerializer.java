package com.navatics.miya.serializers;

import com.navatics.miya.Miya;
import com.navatics.miya.Serializer;
import com.navatics.miya.p059a.Output;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CollectionSerializer<T extends Collection> extends Serializer<T> {

    /* renamed from: a */
    private boolean f6055a = true;

    /* renamed from: b */
    private Serializer f6056b;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface BindCollection {
    }

    /* renamed from: b */
    protected void m6641b(Miya miya, Output output, T t) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.navatics.miya.Serializer
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo6619a(Miya miya, Output output, Object obj) {
        m6642a(miya, output, (Output) ((Collection) obj));
    }

    public CollectionSerializer() {
        m6648a(true);
    }

    /* renamed from: a */
    public void m6642a(Miya miya, Output output, T t) {
        Class m6707c;
        if (t == null) {
            output.m6763a((byte) 0);
            return;
        }
        int size = t.size();
        if (size == 0) {
            output.m6748b(1);
            m6641b(miya, output, t);
            return;
        }
        boolean z = this.f6055a;
        Serializer serializer = this.f6056b;
        if (serializer == null && (m6707c = miya.m6725f().m6707c()) != null && miya.m6724f(m6707c)) {
            serializer = miya.m6726e(m6707c);
        }
        if (serializer != null) {
            if (z) {
                Iterator it = t.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next() == null) {
                            output.m6751a(true, size + 1, true);
                            break;
                        }
                    } else {
                        output.m6751a(false, size + 1, true);
                        z = false;
                        break;
                    }
                }
            } else {
                output.m6758a(size + 1, true);
            }
            m6641b(miya, output, t);
        } else {
            Class<?> cls = null;
            Iterator it2 = t.iterator();
            boolean z2 = false;
            while (true) {
                if (it2.hasNext()) {
                    Object next = it2.next();
                    if (next == null) {
                        z2 = true;
                    } else if (cls == null) {
                        cls = next.getClass();
                    } else if (next.getClass() != cls) {
                        output.m6751a(false, size + 1, true);
                        m6641b(miya, output, t);
                        break;
                    }
                } else {
                    output.m6751a(true, size + 1, true);
                    m6641b(miya, output, t);
                    if (cls == null) {
                        output.m6763a((byte) 0);
                        return;
                    }
                    miya.m6743a(output, (Class) cls);
                    serializer = miya.m6726e(cls);
                    if (z) {
                        output.m6752a(z2);
                        z = z2;
                    }
                }
            }
        }
        if (serializer == null) {
            for (Object obj : t) {
                miya.m6735b(output, obj);
            }
        } else if (z) {
            for (Object obj2 : t) {
                miya.m6734b(output, obj2, serializer);
            }
        } else {
            for (Object obj3 : t) {
                miya.m6741a(output, obj3, serializer);
            }
        }
        miya.m6725f().m6713a();
    }
}
