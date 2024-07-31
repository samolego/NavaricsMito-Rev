package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.C2344aa;
import com.squareup.picasso.Picasso;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.squareup.picasso.p */
/* loaded from: classes2.dex */
public class PicassoExecutorService extends ThreadPoolExecutor {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PicassoExecutorService() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C2344aa.ThreadFactoryC2350e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public void m5672a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            m5673a(3);
            return;
        }
        int type = networkInfo.getType();
        if (type != 6 && type != 9) {
            switch (type) {
                case 0:
                    int subtype = networkInfo.getSubtype();
                    switch (subtype) {
                        case 1:
                        case 2:
                            m5673a(1);
                            return;
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            break;
                        default:
                            switch (subtype) {
                                case 12:
                                    break;
                                case 13:
                                case 14:
                                case 15:
                                    m5673a(3);
                                    return;
                                default:
                                    m5673a(3);
                                    return;
                            }
                    }
                    m5673a(2);
                    return;
                case 1:
                    break;
                default:
                    m5673a(3);
                    return;
            }
        }
        m5673a(4);
    }

    /* renamed from: a */
    private void m5673a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        C2364a c2364a = new C2364a((BitmapHunter) runnable);
        execute(c2364a);
        return c2364a;
    }

    /* compiled from: PicassoExecutorService.java */
    /* renamed from: com.squareup.picasso.p$a */
    /* loaded from: classes2.dex */
    private static final class C2364a extends FutureTask<BitmapHunter> implements Comparable<C2364a> {

        /* renamed from: a */
        private final BitmapHunter f6975a;

        public C2364a(BitmapHunter bitmapHunter) {
            super(bitmapHunter, null);
            this.f6975a = bitmapHunter;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C2364a c2364a) {
            Picasso.Priority m5720n = this.f6975a.m5720n();
            Picasso.Priority m5720n2 = c2364a.f6975a.m5720n();
            return m5720n == m5720n2 ? this.f6975a.f6902a - c2364a.f6975a.f6902a : m5720n2.ordinal() - m5720n.ordinal();
        }
    }
}
