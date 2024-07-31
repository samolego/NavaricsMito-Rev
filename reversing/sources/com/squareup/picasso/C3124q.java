package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import com.senseplay.sdk.tool.IniEditor;
import com.squareup.picasso.Picasso;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: Request.java */
/* renamed from: com.squareup.picasso.q */
/* loaded from: classes2.dex */
public final class C2365q {

    /* renamed from: s */
    private static final long f6976s = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a */
    int f6977a;

    /* renamed from: b */
    long f6978b;

    /* renamed from: c */
    int f6979c;

    /* renamed from: d */
    public final Uri f6980d;

    /* renamed from: e */
    public final int f6981e;

    /* renamed from: f */
    public final String f6982f;

    /* renamed from: g */
    public final List<InterfaceC2372y> f6983g;

    /* renamed from: h */
    public final int f6984h;

    /* renamed from: i */
    public final int f6985i;

    /* renamed from: j */
    public final boolean f6986j;

    /* renamed from: k */
    public final boolean f6987k;

    /* renamed from: l */
    public final boolean f6988l;

    /* renamed from: m */
    public final float f6989m;

    /* renamed from: n */
    public final float f6990n;

    /* renamed from: o */
    public final float f6991o;

    /* renamed from: p */
    public final boolean f6992p;

    /* renamed from: q */
    public final Bitmap.Config f6993q;

    /* renamed from: r */
    public final Picasso.Priority f6994r;

    private C2365q(Uri uri, int i, String str, List<InterfaceC2372y> list, int i2, int i3, boolean z, boolean z2, boolean z3, float f, float f2, float f3, boolean z4, Bitmap.Config config, Picasso.Priority priority) {
        this.f6980d = uri;
        this.f6981e = i;
        this.f6982f = str;
        if (list == null) {
            this.f6983g = null;
        } else {
            this.f6983g = Collections.unmodifiableList(list);
        }
        this.f6984h = i2;
        this.f6985i = i3;
        this.f6986j = z;
        this.f6987k = z2;
        this.f6988l = z3;
        this.f6989m = f;
        this.f6990n = f2;
        this.f6991o = f3;
        this.f6992p = z4;
        this.f6993q = config;
        this.f6994r = priority;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i = this.f6981e;
        if (i > 0) {
            sb.append(i);
        } else {
            sb.append(this.f6980d);
        }
        List<InterfaceC2372y> list = this.f6983g;
        if (list != null && !list.isEmpty()) {
            for (InterfaceC2372y interfaceC2372y : this.f6983g) {
                sb.append(' ');
                sb.append(interfaceC2372y.m5617a());
            }
        }
        if (this.f6982f != null) {
            sb.append(" stableKey(");
            sb.append(this.f6982f);
            sb.append(')');
        }
        if (this.f6984h > 0) {
            sb.append(" resize(");
            sb.append(this.f6984h);
            sb.append(',');
            sb.append(this.f6985i);
            sb.append(')');
        }
        if (this.f6986j) {
            sb.append(" centerCrop");
        }
        if (this.f6987k) {
            sb.append(" centerInside");
        }
        if (this.f6989m != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.f6989m);
            if (this.f6992p) {
                sb.append(" @ ");
                sb.append(this.f6990n);
                sb.append(',');
                sb.append(this.f6991o);
            }
            sb.append(')');
        }
        if (this.f6993q != null) {
            sb.append(' ');
            sb.append(this.f6993q);
        }
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m5670a() {
        long nanoTime = System.nanoTime() - this.f6978b;
        if (nanoTime > f6976s) {
            return m5669b() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's';
        }
        return m5669b() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public String m5669b() {
        return "[R" + this.f6977a + IniEditor.Section.HEADER_END;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public String m5668c() {
        Uri uri = this.f6980d;
        if (uri != null) {
            return String.valueOf(uri.getPath());
        }
        return Integer.toHexString(this.f6981e);
    }

    /* renamed from: d */
    public boolean m5667d() {
        return (this.f6984h == 0 && this.f6985i == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean m5666e() {
        return m5665f() || m5664g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean m5665f() {
        return m5667d() || this.f6989m != 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean m5664g() {
        return this.f6983g != null;
    }

    /* compiled from: Request.java */
    /* renamed from: com.squareup.picasso.q$a */
    /* loaded from: classes2.dex */
    public static final class C2367a {

        /* renamed from: a */
        private Uri f6995a;

        /* renamed from: b */
        private int f6996b;

        /* renamed from: c */
        private String f6997c;

        /* renamed from: d */
        private int f6998d;

        /* renamed from: e */
        private int f6999e;

        /* renamed from: f */
        private boolean f7000f;

        /* renamed from: g */
        private boolean f7001g;

        /* renamed from: h */
        private boolean f7002h;

        /* renamed from: i */
        private float f7003i;

        /* renamed from: j */
        private float f7004j;

        /* renamed from: k */
        private float f7005k;

        /* renamed from: l */
        private boolean f7006l;

        /* renamed from: m */
        private List<InterfaceC2372y> f7007m;

        /* renamed from: n */
        private Bitmap.Config f7008n;

        /* renamed from: o */
        private Picasso.Priority f7009o;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C2367a(Uri uri, int i, Bitmap.Config config) {
            this.f6995a = uri;
            this.f6996b = i;
            this.f7008n = config;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean m5663a() {
            return (this.f6995a == null && this.f6996b == 0) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean m5661b() {
            return (this.f6998d == 0 && this.f6999e == 0) ? false : true;
        }

        /* renamed from: a */
        public C2367a m5662a(int i, int i2) {
            if (i >= 0) {
                if (i2 >= 0) {
                    if (i2 == 0 && i == 0) {
                        throw new IllegalArgumentException("At least one dimension has to be positive number.");
                    }
                    this.f6998d = i;
                    this.f6999e = i2;
                    return this;
                }
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
            throw new IllegalArgumentException("Width must be positive number or 0.");
        }

        /* renamed from: c */
        public C2367a m5660c() {
            if (this.f7001g) {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            }
            this.f7000f = true;
            return this;
        }

        /* renamed from: d */
        public C2365q m5659d() {
            if (this.f7001g && this.f7000f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (this.f7000f && this.f6998d == 0 && this.f6999e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (this.f7001g && this.f6998d == 0 && this.f6999e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            }
            if (this.f7009o == null) {
                this.f7009o = Picasso.Priority.NORMAL;
            }
            return new C2365q(this.f6995a, this.f6996b, this.f6997c, this.f7007m, this.f6998d, this.f6999e, this.f7000f, this.f7001g, this.f7002h, this.f7003i, this.f7004j, this.f7005k, this.f7006l, this.f7008n, this.f7009o);
        }
    }
}
