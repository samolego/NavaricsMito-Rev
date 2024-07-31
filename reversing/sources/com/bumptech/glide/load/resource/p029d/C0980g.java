package com.bumptech.glide.load.resource.p029d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.p017d.ObjectKey;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.p031a.SimpleTarget;
import com.bumptech.glide.request.p032b.Transition;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bumptech.glide.load.resource.d.g */
/* loaded from: classes.dex */
public class GifFrameLoader {

    /* renamed from: a */
    final RequestManager f1112a;

    /* renamed from: b */
    private final GifDecoder f1113b;

    /* renamed from: c */
    private final Handler f1114c;

    /* renamed from: d */
    private final List<InterfaceC0764b> f1115d;

    /* renamed from: e */
    private final BitmapPool f1116e;

    /* renamed from: f */
    private boolean f1117f;

    /* renamed from: g */
    private boolean f1118g;

    /* renamed from: h */
    private boolean f1119h;

    /* renamed from: i */
    private RequestBuilder<Bitmap> f1120i;

    /* renamed from: j */
    private C0763a f1121j;

    /* renamed from: k */
    private boolean f1122k;

    /* renamed from: l */
    private C0763a f1123l;

    /* renamed from: m */
    private Bitmap f1124m;

    /* renamed from: n */
    private Transformation<Bitmap> f1125n;

    /* renamed from: o */
    private C0763a f1126o;
    @Nullable

    /* renamed from: p */
    private InterfaceC0766d f1127p;

    /* compiled from: GifFrameLoader.java */
    /* renamed from: com.bumptech.glide.load.resource.d.g$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0764b {
        /* renamed from: f */
        void mo11827f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.d.g$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0766d {
        /* renamed from: a */
        void m11826a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i, int i2, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(glide.m12525a(), Glide.m12516b(glide.m12514c()), gifDecoder, null, m11848a(Glide.m12516b(glide.m12514c()), i, i2), transformation, bitmap);
    }

    GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, Handler handler, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f1115d = new ArrayList();
        this.f1112a = requestManager;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new C0765c()) : handler;
        this.f1116e = bitmapPool;
        this.f1114c = handler;
        this.f1120i = requestBuilder;
        this.f1113b = gifDecoder;
        m11847a(transformation, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11847a(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f1125n = (Transformation) Preconditions.m11580a(transformation);
        this.f1124m = (Bitmap) Preconditions.m11580a(bitmap);
        this.f1120i = this.f1120i.mo8828a(new RequestOptions().mo9536b(transformation));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap m11849a() {
        return this.f1124m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11845a(InterfaceC0764b interfaceC0764b) {
        if (this.f1122k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f1115d.contains(interfaceC0764b)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.f1115d.isEmpty();
        this.f1115d.add(interfaceC0764b);
        if (isEmpty) {
            m11834k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m11843b(InterfaceC0764b interfaceC0764b) {
        this.f1115d.remove(interfaceC0764b);
        if (this.f1115d.isEmpty()) {
            m11833l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m11844b() {
        return m11836i().getWidth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public int m11842c() {
        return m11836i().getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public int m11841d() {
        return this.f1113b.mo12457g() + m11835j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public int m11840e() {
        C0763a c0763a = this.f1121j;
        if (c0763a != null) {
            return c0763a.f1128a;
        }
        return -1;
    }

    /* renamed from: j */
    private int m11835j() {
        return C0791i.m11570a(m11836i().getWidth(), m11836i().getHeight(), m11836i().getConfig());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public ByteBuffer m11839f() {
        return this.f1113b.mo12471a().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public int m11838g() {
        return this.f1113b.mo12460d();
    }

    /* renamed from: k */
    private void m11834k() {
        if (this.f1117f) {
            return;
        }
        this.f1117f = true;
        this.f1122k = false;
        m11832m();
    }

    /* renamed from: l */
    private void m11833l() {
        this.f1117f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public void m11837h() {
        this.f1115d.clear();
        m11831n();
        m11833l();
        C0763a c0763a = this.f1121j;
        if (c0763a != null) {
            this.f1112a.m12437a(c0763a);
            this.f1121j = null;
        }
        C0763a c0763a2 = this.f1123l;
        if (c0763a2 != null) {
            this.f1112a.m12437a(c0763a2);
            this.f1123l = null;
        }
        C0763a c0763a3 = this.f1126o;
        if (c0763a3 != null) {
            this.f1112a.m12437a(c0763a3);
            this.f1126o = null;
        }
        this.f1113b.mo12455i();
        this.f1122k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public Bitmap m11836i() {
        C0763a c0763a = this.f1121j;
        return c0763a != null ? c0763a.m11828b_() : this.f1124m;
    }

    /* renamed from: m */
    private void m11832m() {
        if (!this.f1117f || this.f1118g) {
            return;
        }
        if (this.f1119h) {
            Preconditions.m11576a(this.f1126o == null, "Pending target must be null when starting from the first frame");
            this.f1113b.mo12458f();
            this.f1119h = false;
        }
        C0763a c0763a = this.f1126o;
        if (c0763a != null) {
            this.f1126o = null;
            m11846a(c0763a);
            return;
        }
        this.f1118g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.f1113b.mo12462c();
        this.f1113b.mo12464b();
        this.f1123l = new C0763a(this.f1114c, this.f1113b.mo12459e(), uptimeMillis);
        this.f1120i.mo8828a(RequestOptions.m11678a(m11830o())).mo8826a(this.f1113b).m12447a((RequestBuilder<Bitmap>) this.f1123l);
    }

    /* renamed from: n */
    private void m11831n() {
        Bitmap bitmap = this.f1124m;
        if (bitmap != null) {
            this.f1116e.mo11931a(bitmap);
            this.f1124m = null;
        }
    }

    @VisibleForTesting
    void setOnEveryFrameReadyListener(@Nullable InterfaceC0766d interfaceC0766d) {
        this.f1127p = interfaceC0766d;
    }

    @VisibleForTesting
    /* renamed from: a */
    void m11846a(C0763a c0763a) {
        InterfaceC0766d interfaceC0766d = this.f1127p;
        if (interfaceC0766d != null) {
            interfaceC0766d.m11826a();
        }
        this.f1118g = false;
        if (this.f1122k) {
            this.f1114c.obtainMessage(2, c0763a).sendToTarget();
        } else if (!this.f1117f) {
            this.f1126o = c0763a;
        } else {
            if (c0763a.m11828b_() != null) {
                m11831n();
                C0763a c0763a2 = this.f1121j;
                this.f1121j = c0763a;
                for (int size = this.f1115d.size() - 1; size >= 0; size--) {
                    this.f1115d.get(size).mo11827f();
                }
                if (c0763a2 != null) {
                    this.f1114c.obtainMessage(2, c0763a2).sendToTarget();
                }
            }
            m11832m();
        }
    }

    /* compiled from: GifFrameLoader.java */
    /* renamed from: com.bumptech.glide.load.resource.d.g$c */
    /* loaded from: classes.dex */
    private class C0765c implements Handler.Callback {
        C0765c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                GifFrameLoader.this.m11846a((C0763a) message.obj);
                return true;
            } else if (message.what == 2) {
                GifFrameLoader.this.f1112a.m12437a((C0763a) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.d.g$a */
    /* loaded from: classes.dex */
    public static class C0763a extends SimpleTarget<Bitmap> {

        /* renamed from: a */
        final int f1128a;

        /* renamed from: b */
        private final Handler f1129b;

        /* renamed from: c */
        private final long f1130c;

        /* renamed from: d */
        private Bitmap f1131d;

        @Override // com.bumptech.glide.request.p031a.Target
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo11699a(@NonNull Object obj, @Nullable Transition transition) {
            m11829a((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }

        C0763a(Handler handler, int i, long j) {
            this.f1129b = handler;
            this.f1128a = i;
            this.f1130c = j;
        }

        /* renamed from: b_ */
        Bitmap m11828b_() {
            return this.f1131d;
        }

        /* renamed from: a */
        public void m11829a(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            this.f1131d = bitmap;
            this.f1129b.sendMessageAtTime(this.f1129b.obtainMessage(1, this), this.f1130c);
        }
    }

    /* renamed from: a */
    private static RequestBuilder<Bitmap> m11848a(RequestManager requestManager, int i, int i2) {
        return requestManager.mo8810f().mo8828a(RequestOptions.m11677a(DiskCacheStrategy.f896b).mo9545a(true).mo9532b(true).mo9550a(i, i2));
    }

    /* renamed from: o */
    private static Key m11830o() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }
}
