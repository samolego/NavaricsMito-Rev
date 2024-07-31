package io.objectbox.query;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.p092b.DataObserver;
import io.objectbox.p092b.DataPublisher;
import io.objectbox.p092b.DataPublisherUtils;
import io.objectbox.p092b.DataSubscription;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Internal
/* renamed from: io.objectbox.query.c */
/* loaded from: classes2.dex */
public class QueryPublisher<T> implements DataPublisher<List<T>> {

    /* renamed from: a */
    private final Query<T> f9577a;

    /* renamed from: b */
    private final Box<T> f9578b;

    /* renamed from: c */
    private final Set<DataObserver<List<T>>> f9579c = new CopyOnWriteArraySet();

    /* renamed from: d */
    private DataObserver<Class<T>> f9580d;

    /* renamed from: e */
    private DataSubscription f9581e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryPublisher(Query<T> query, Box<T> box) {
        this.f9577a = query;
        this.f9578b = box;
    }

    @Override // io.objectbox.p092b.DataPublisher
    /* renamed from: a */
    public synchronized void mo3281a(DataObserver<List<T>> dataObserver, @Nullable Object obj) {
        BoxStore m3415f = this.f9578b.m3415f();
        if (this.f9580d == null) {
            this.f9580d = new DataObserver<Class<T>>() { // from class: io.objectbox.query.c.1
                @Override // io.objectbox.p092b.DataObserver
                /* renamed from: a */
                public void onData(Class<T> cls) {
                    QueryPublisher.this.m3282a();
                }
            };
        }
        if (this.f9579c.isEmpty()) {
            if (this.f9581e != null) {
                throw new IllegalStateException("Existing subscription found");
            }
            this.f9581e = m3415f.m3472e(this.f9578b.m3414g()).m3364a().m3360b().m3363a(this.f9580d);
        }
        this.f9579c.add(dataObserver);
    }

    @Override // io.objectbox.p092b.DataPublisher
    /* renamed from: c */
    public void mo3277c(final DataObserver<List<T>> dataObserver, @Nullable Object obj) {
        this.f9578b.m3415f().m3479b(new Runnable() { // from class: io.objectbox.query.c.2
            @Override // java.lang.Runnable
            public void run() {
                dataObserver.onData(QueryPublisher.this.f9577a.m3300e());
            }
        });
    }

    /* renamed from: a */
    void m3282a() {
        this.f9578b.m3415f().m3479b(new Runnable() { // from class: io.objectbox.query.c.3
            @Override // java.lang.Runnable
            public void run() {
                List<T> m3300e = QueryPublisher.this.f9577a.m3300e();
                for (DataObserver dataObserver : QueryPublisher.this.f9579c) {
                    dataObserver.onData(m3300e);
                }
            }
        });
    }

    @Override // io.objectbox.p092b.DataPublisher
    /* renamed from: b */
    public synchronized void mo3279b(DataObserver<List<T>> dataObserver, @Nullable Object obj) {
        DataPublisherUtils.m3371a(this.f9579c, dataObserver);
        if (this.f9579c.isEmpty()) {
            this.f9581e.mo3370a();
            this.f9581e = null;
        }
    }
}
