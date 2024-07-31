package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.C2365q;
import com.squareup.picasso.Picasso;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.squareup.picasso.r */
/* loaded from: classes2.dex */
public class RequestCreator {

    /* renamed from: a */
    private static final AtomicInteger f7010a = new AtomicInteger();

    /* renamed from: b */
    private final Picasso f7011b;

    /* renamed from: c */
    private final C2365q.C2367a f7012c;

    /* renamed from: d */
    private boolean f7013d;

    /* renamed from: e */
    private boolean f7014e;

    /* renamed from: f */
    private boolean f7015f;

    /* renamed from: g */
    private int f7016g;

    /* renamed from: h */
    private int f7017h;

    /* renamed from: i */
    private int f7018i;

    /* renamed from: j */
    private int f7019j;

    /* renamed from: k */
    private Drawable f7020k;

    /* renamed from: l */
    private Drawable f7021l;

    /* renamed from: m */
    private Object f7022m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestCreator(Picasso picasso, Uri uri, int i) {
        this.f7015f = true;
        if (picasso.f6860m) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.f7011b = picasso;
        this.f7012c = new C2365q.C2367a(uri, i, picasso.f6857j);
    }

    RequestCreator() {
        this.f7015f = true;
        this.f7011b = null;
        this.f7012c = new C2365q.C2367a(null, 0, null);
    }

    /* renamed from: a */
    public RequestCreator m5654a(Drawable drawable) {
        if (!this.f7015f) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        }
        if (this.f7016g != 0) {
            throw new IllegalStateException("Placeholder image already set.");
        }
        this.f7020k = drawable;
        return this;
    }

    /* renamed from: a */
    public RequestCreator m5657a(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        }
        if (this.f7021l != null) {
            throw new IllegalStateException("Error image already set.");
        }
        this.f7017h = i;
        return this;
    }

    /* renamed from: a */
    public RequestCreator m5658a() {
        this.f7014e = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public RequestCreator m5650b() {
        this.f7014e = false;
        return this;
    }

    /* renamed from: a */
    public RequestCreator m5656a(int i, int i2) {
        this.f7012c.m5662a(i, i2);
        return this;
    }

    /* renamed from: c */
    public RequestCreator m5649c() {
        this.f7012c.m5660c();
        return this;
    }

    /* renamed from: a */
    public void m5651a(InterfaceC2371w interfaceC2371w) {
        Bitmap m5785b;
        long nanoTime = System.nanoTime();
        C2344aa.m5770a();
        if (interfaceC2371w == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (this.f7014e) {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
        if (!this.f7012c.m5663a()) {
            this.f7011b.m5789a(interfaceC2371w);
            interfaceC2371w.mo4057b(this.f7015f ? m5648d() : null);
            return;
        }
        C2365q m5655a = m5655a(nanoTime);
        String m5761a = C2344aa.m5761a(m5655a);
        if (MemoryPolicy.shouldReadFromMemoryCache(this.f7018i) && (m5785b = this.f7011b.m5785b(m5761a)) != null) {
            this.f7011b.m5789a(interfaceC2371w);
            interfaceC2371w.mo4059a(m5785b, Picasso.LoadedFrom.MEMORY);
            return;
        }
        interfaceC2371w.mo4057b(this.f7015f ? m5648d() : null);
        this.f7011b.m5792a((Action) new TargetAction(this.f7011b, interfaceC2371w, m5655a, this.f7018i, this.f7019j, this.f7021l, m5761a, this.f7022m, this.f7017h));
    }

    /* renamed from: a */
    public void m5653a(ImageView imageView) {
        m5652a(imageView, (Callback) null);
    }

    /* renamed from: a */
    public void m5652a(ImageView imageView, Callback callback) {
        Bitmap m5785b;
        long nanoTime = System.nanoTime();
        C2344aa.m5770a();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (!this.f7012c.m5663a()) {
            this.f7011b.m5795a(imageView);
            if (this.f7015f) {
                PicassoDrawable.m5674a(imageView, m5648d());
                return;
            }
            return;
        }
        if (this.f7014e) {
            if (this.f7012c.m5661b()) {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 || height == 0) {
                if (this.f7015f) {
                    PicassoDrawable.m5674a(imageView, m5648d());
                }
                this.f7011b.m5794a(imageView, new DeferredRequestCreator(this, imageView, callback));
                return;
            }
            this.f7012c.m5662a(width, height);
        }
        C2365q m5655a = m5655a(nanoTime);
        String m5761a = C2344aa.m5761a(m5655a);
        if (MemoryPolicy.shouldReadFromMemoryCache(this.f7018i) && (m5785b = this.f7011b.m5785b(m5761a)) != null) {
            this.f7011b.m5795a(imageView);
            PicassoDrawable.m5675a(imageView, this.f7011b.f6850c, m5785b, Picasso.LoadedFrom.MEMORY, this.f7013d, this.f7011b.f6858k);
            if (this.f7011b.f6859l) {
                String m5669b = m5655a.m5669b();
                C2344aa.m5754a("Main", "completed", m5669b, "from " + Picasso.LoadedFrom.MEMORY);
            }
            if (callback != null) {
                callback.mo4021a();
                return;
            }
            return;
        }
        if (this.f7015f) {
            PicassoDrawable.m5674a(imageView, m5648d());
        }
        this.f7011b.m5792a((Action) new ImageViewAction(this.f7011b, imageView, m5655a, this.f7018i, this.f7019j, this.f7017h, this.f7021l, m5761a, this.f7022m, callback, this.f7013d));
    }

    /* renamed from: d */
    private Drawable m5648d() {
        if (this.f7016g != 0) {
            return this.f7011b.f6850c.getResources().getDrawable(this.f7016g);
        }
        return this.f7020k;
    }

    /* renamed from: a */
    private C2365q m5655a(long j) {
        int andIncrement = f7010a.getAndIncrement();
        C2365q m5659d = this.f7012c.m5659d();
        m5659d.f6977a = andIncrement;
        m5659d.f6978b = j;
        boolean z = this.f7011b.f6859l;
        if (z) {
            C2344aa.m5754a("Main", "created", m5659d.m5669b(), m5659d.toString());
        }
        C2365q m5790a = this.f7011b.m5790a(m5659d);
        if (m5790a != m5659d) {
            m5790a.f6977a = andIncrement;
            m5790a.f6978b = j;
            if (z) {
                String m5670a = m5790a.m5670a();
                C2344aa.m5754a("Main", "changed", m5670a, "into " + m5790a);
            }
        }
        return m5790a;
    }
}
