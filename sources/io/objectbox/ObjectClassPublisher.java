package io.objectbox;

import io.objectbox.annotation.apihint.Internal;
import io.objectbox.p092b.DataObserver;
import io.objectbox.p092b.DataPublisher;
import io.objectbox.p092b.DataPublisherUtils;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import javax.annotation.Nullable;
import org.greenrobot.essentials.collections.MultimapSet;

/* JADX INFO: Access modifiers changed from: package-private */
@Internal
/* renamed from: io.objectbox.f */
/* loaded from: classes2.dex */
public class ObjectClassPublisher implements DataPublisher<Class>, Runnable {

    /* renamed from: a */
    final BoxStore f9530a;

    /* renamed from: b */
    final MultimapSet<Integer, DataObserver<Class>> f9531b = MultimapSet.m758a(MultimapSet.SetType.THREAD_SAFE);

    /* renamed from: c */
    final Deque<int[]> f9532c = new ArrayDeque();

    /* renamed from: d */
    volatile boolean f9533d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectClassPublisher(BoxStore boxStore) {
        this.f9530a = boxStore;
    }

    @Override // io.objectbox.p092b.DataPublisher
    /* renamed from: a */
    public void mo3281a(DataObserver<Class> dataObserver, @Nullable Object obj) {
        if (obj == null) {
            for (int i : this.f9530a.m3481b()) {
                this.f9531b.m754a((MultimapSet<Integer, DataObserver<Class>>) Integer.valueOf(i), (Integer) dataObserver);
            }
            return;
        }
        this.f9531b.m754a((MultimapSet<Integer, DataObserver<Class>>) Integer.valueOf(this.f9530a.m3480b((Class) obj)), (Integer) dataObserver);
    }

    @Override // io.objectbox.p092b.DataPublisher
    /* renamed from: b */
    public void mo3279b(DataObserver<Class> dataObserver, @Nullable Object obj) {
        if (obj != null) {
            m3323a(dataObserver, this.f9530a.m3480b((Class) obj));
            return;
        }
        for (int i : this.f9530a.m3481b()) {
            m3323a(dataObserver, i);
        }
    }

    /* renamed from: a */
    private void m3323a(DataObserver<Class> dataObserver, int i) {
        DataPublisherUtils.m3371a(this.f9531b.get(Integer.valueOf(i)), dataObserver);
    }

    @Override // io.objectbox.p092b.DataPublisher
    /* renamed from: c */
    public void mo3277c(final DataObserver<Class> dataObserver, @Nullable final Object obj) {
        this.f9530a.m3479b(new Runnable() { // from class: io.objectbox.f.1
            @Override // java.lang.Runnable
            public void run() {
                Object obj2 = obj;
                for (Class cls : obj2 != null ? Collections.singletonList((Class) obj2) : ObjectClassPublisher.this.f9530a.m3491a()) {
                    try {
                        dataObserver.onData(cls);
                    } catch (RuntimeException unused) {
                        ObjectClassPublisher.this.m3321a(cls);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3321a(Class cls) {
        RuntimeException runtimeException = new RuntimeException("Observer failed while processing data for " + cls + ". Consider using an ErrorObserver");
        runtimeException.printStackTrace();
        throw runtimeException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3320a(int[] iArr) {
        synchronized (this.f9532c) {
            this.f9532c.add(iArr);
            if (!this.f9533d) {
                this.f9533d = true;
                this.f9530a.m3479b(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] pollFirst;
        while (true) {
            try {
            } finally {
            }
            synchronized (this.f9532c) {
                pollFirst = this.f9532c.pollFirst();
                if (pollFirst == null) {
                    this.f9533d = false;
                    return;
                }
                this.f9533d = false;
            }
            for (int i : pollFirst) {
                Collection<DataObserver> a = this.f9531b.get(Integer.valueOf(i));
                if (a != null && !a.isEmpty()) {
                    Class m3490a = this.f9530a.m3490a(i);
                    try {
                        for (DataObserver dataObserver : a) {
                            dataObserver.onData(m3490a);
                        }
                    } catch (RuntimeException unused) {
                        m3321a(m3490a);
                    }
                }
            }
        }
    }
}
