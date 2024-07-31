package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.p029d.GifDrawable;
import com.bumptech.glide.load.resource.p029d.GifDrawableTransformation;
import com.bumptech.glide.p017d.EmptySignature;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import java.util.Map;

/* renamed from: com.bumptech.glide.request.g */
/* loaded from: classes.dex */
public class RequestOptions implements Cloneable {
    @Nullable

    /* renamed from: a */
    private static RequestOptions f1249a;

    /* renamed from: A */
    private boolean f1250A;

    /* renamed from: b */
    private int f1251b;
    @Nullable

    /* renamed from: f */
    private Drawable f1255f;

    /* renamed from: g */
    private int f1256g;
    @Nullable

    /* renamed from: h */
    private Drawable f1257h;

    /* renamed from: i */
    private int f1258i;

    /* renamed from: n */
    private boolean f1263n;
    @Nullable

    /* renamed from: p */
    private Drawable f1265p;

    /* renamed from: q */
    private int f1266q;

    /* renamed from: u */
    private boolean f1270u;
    @Nullable

    /* renamed from: v */
    private Resources.Theme f1271v;

    /* renamed from: w */
    private boolean f1272w;

    /* renamed from: x */
    private boolean f1273x;

    /* renamed from: y */
    private boolean f1274y;

    /* renamed from: c */
    private float f1252c = 1.0f;
    @NonNull

    /* renamed from: d */
    private DiskCacheStrategy f1253d = DiskCacheStrategy.f899e;
    @NonNull

    /* renamed from: e */
    private Priority f1254e = Priority.NORMAL;

    /* renamed from: j */
    private boolean f1259j = true;

    /* renamed from: k */
    private int f1260k = -1;

    /* renamed from: l */
    private int f1261l = -1;
    @NonNull

    /* renamed from: m */
    private Key f1262m = EmptySignature.m12526a();

    /* renamed from: o */
    private boolean f1264o = true;
    @NonNull

    /* renamed from: r */
    private Options f1267r = new Options();
    @NonNull

    /* renamed from: s */
    private Map<Class<?>, Transformation<?>> f1268s = new CachedHashCodeArrayMap();
    @NonNull

    /* renamed from: t */
    private Class<?> f1269t = Object.class;

    /* renamed from: z */
    private boolean f1275z = true;

    /* renamed from: b */
    private static boolean m11670b(int i, int i2) {
        return (i & i2) != 0;
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public static RequestOptions m11677a(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return new RequestOptions().mo9537b(diskCacheStrategy);
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public static RequestOptions m11678a(@NonNull Key key) {
        return new RequestOptions().mo9539b(key);
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public static RequestOptions m11679a() {
        if (f1249a == null) {
            f1249a = new RequestOptions().mo9519i().mo9517k();
        }
        return f1249a;
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public static RequestOptions m11676a(@NonNull Transformation<Bitmap> transformation) {
        return new RequestOptions().mo9536b(transformation);
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public static RequestOptions m11672a(@NonNull Class<?> cls) {
        return new RequestOptions().mo9533b(cls);
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestOptions mo9552a(@FloatRange(from = 0.0d, m12847to = 1.0d) float f) {
        if (this.f1272w) {
            return clone().mo9552a(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f1252c = f;
        this.f1251b |= 2;
        return m11680J();
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestOptions mo9545a(boolean z) {
        if (this.f1272w) {
            return clone().mo9545a(z);
        }
        this.f1250A = z;
        this.f1251b |= 1048576;
        return m11680J();
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public RequestOptions mo9537b(@NonNull DiskCacheStrategy diskCacheStrategy) {
        if (this.f1272w) {
            return clone().mo9537b(diskCacheStrategy);
        }
        this.f1253d = (DiskCacheStrategy) Preconditions.m11580a(diskCacheStrategy);
        this.f1251b |= 4;
        return m11680J();
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestOptions mo9549a(@NonNull Priority priority) {
        if (this.f1272w) {
            return clone().mo9549a(priority);
        }
        this.f1254e = (Priority) Preconditions.m11580a(priority);
        this.f1251b |= 8;
        return m11680J();
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestOptions mo9551a(@DrawableRes int i) {
        if (this.f1272w) {
            return clone().mo9551a(i);
        }
        this.f1258i = i;
        this.f1251b |= 128;
        return m11680J();
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public RequestOptions mo9542b(@DrawableRes int i) {
        if (this.f1272w) {
            return clone().mo9542b(i);
        }
        this.f1256g = i;
        this.f1251b |= 32;
        return m11680J();
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public RequestOptions mo9532b(boolean z) {
        if (this.f1272w) {
            return clone().mo9532b(true);
        }
        this.f1259j = !z;
        this.f1251b |= 256;
        return m11680J();
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestOptions mo9550a(int i, int i2) {
        if (this.f1272w) {
            return clone().mo9550a(i, i2);
        }
        this.f1261l = i;
        this.f1260k = i2;
        this.f1251b |= 512;
        return m11680J();
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public RequestOptions mo9539b(@NonNull Key key) {
        if (this.f1272w) {
            return clone().mo9539b(key);
        }
        this.f1262m = (Key) Preconditions.m11580a(key);
        this.f1251b |= 1024;
        return m11680J();
    }

    @Override // 
    @CheckResult
    /* renamed from: b */
    public RequestOptions clone() {
        try {
            RequestOptions requestOptions = (RequestOptions) super.clone();
            requestOptions.f1267r = new Options();
            requestOptions.f1267r.m12011a(this.f1267r);
            requestOptions.f1268s = new CachedHashCodeArrayMap();
            requestOptions.f1268s.putAll(this.f1268s);
            requestOptions.f1270u = false;
            requestOptions.f1272w = false;
            return requestOptions;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public <T> RequestOptions mo9548a(@NonNull Option<T> option, @NonNull T t) {
        if (this.f1272w) {
            return clone().mo9548a((Option<Option<T>>) option, (Option<T>) t);
        }
        Preconditions.m11580a(option);
        Preconditions.m11580a(t);
        this.f1267r.m12013a(option, t);
        return m11680J();
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public RequestOptions mo9533b(@NonNull Class<?> cls) {
        if (this.f1272w) {
            return clone().mo9533b(cls);
        }
        this.f1269t = (Class) Preconditions.m11580a(cls);
        this.f1251b |= 4096;
        return m11680J();
    }

    /* renamed from: c */
    public final boolean m11668c() {
        return this.f1264o;
    }

    /* renamed from: d */
    public final boolean m11665d() {
        return m11667c(2048);
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestOptions mo9547a(@NonNull DownsampleStrategy downsampleStrategy) {
        return mo9548a((Option<Option<DownsampleStrategy>>) DownsampleStrategy.f1019h, (Option<DownsampleStrategy>) Preconditions.m11580a(downsampleStrategy));
    }

    @CheckResult
    @NonNull
    /* renamed from: e */
    public RequestOptions mo9523e() {
        return m11674a(DownsampleStrategy.f1013b, new CenterCrop());
    }

    @CheckResult
    @NonNull
    /* renamed from: f */
    public RequestOptions mo9522f() {
        return m11664d(DownsampleStrategy.f1012a, new FitCenter());
    }

    @CheckResult
    @NonNull
    /* renamed from: g */
    public RequestOptions mo9521g() {
        return m11666c(DownsampleStrategy.f1012a, new FitCenter());
    }

    @CheckResult
    @NonNull
    /* renamed from: h */
    public RequestOptions mo9520h() {
        return m11664d(DownsampleStrategy.f1016e, new CenterInside());
    }

    @CheckResult
    @NonNull
    /* renamed from: i */
    public RequestOptions mo9519i() {
        return m11669b(DownsampleStrategy.f1016e, new CircleCrop());
    }

    @NonNull
    /* renamed from: a */
    final RequestOptions m11674a(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.f1272w) {
            return clone().m11674a(downsampleStrategy, transformation);
        }
        mo9547a(downsampleStrategy);
        return m11675a(transformation, false);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    final RequestOptions m11669b(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.f1272w) {
            return clone().m11669b(downsampleStrategy, transformation);
        }
        mo9547a(downsampleStrategy);
        return mo9536b(transformation);
    }

    @NonNull
    /* renamed from: c */
    private RequestOptions m11666c(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        return m11673a(downsampleStrategy, transformation, true);
    }

    @NonNull
    /* renamed from: d */
    private RequestOptions m11664d(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        return m11673a(downsampleStrategy, transformation, false);
    }

    @NonNull
    /* renamed from: a */
    private RequestOptions m11673a(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation, boolean z) {
        RequestOptions m11669b = z ? m11669b(downsampleStrategy, transformation) : m11674a(downsampleStrategy, transformation);
        m11669b.f1275z = true;
        return m11669b;
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public RequestOptions mo9536b(@NonNull Transformation<Bitmap> transformation) {
        return m11675a(transformation, true);
    }

    @NonNull
    /* renamed from: a */
    private RequestOptions m11675a(@NonNull Transformation<Bitmap> transformation, boolean z) {
        if (this.f1272w) {
            return clone().m11675a(transformation, z);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z);
        m11671a(Bitmap.class, transformation, z);
        m11671a(Drawable.class, drawableTransformation, z);
        m11671a(BitmapDrawable.class, drawableTransformation.m11930a(), z);
        m11671a(GifDrawable.class, new GifDrawableTransformation(transformation), z);
        return m11680J();
    }

    @NonNull
    /* renamed from: a */
    private <T> RequestOptions m11671a(@NonNull Class<T> cls, @NonNull Transformation<T> transformation, boolean z) {
        if (this.f1272w) {
            return clone().m11671a(cls, transformation, z);
        }
        Preconditions.m11580a(cls);
        Preconditions.m11580a(transformation);
        this.f1268s.put(cls, transformation);
        this.f1251b |= 2048;
        this.f1264o = true;
        this.f1251b |= 65536;
        this.f1275z = false;
        if (z) {
            this.f1251b |= 131072;
            this.f1263n = true;
        }
        return m11680J();
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestOptions mo9546a(@NonNull RequestOptions requestOptions) {
        if (this.f1272w) {
            return clone().mo9546a(requestOptions);
        }
        if (m11670b(requestOptions.f1251b, 2)) {
            this.f1252c = requestOptions.f1252c;
        }
        if (m11670b(requestOptions.f1251b, 262144)) {
            this.f1273x = requestOptions.f1273x;
        }
        if (m11670b(requestOptions.f1251b, 1048576)) {
            this.f1250A = requestOptions.f1250A;
        }
        if (m11670b(requestOptions.f1251b, 4)) {
            this.f1253d = requestOptions.f1253d;
        }
        if (m11670b(requestOptions.f1251b, 8)) {
            this.f1254e = requestOptions.f1254e;
        }
        if (m11670b(requestOptions.f1251b, 16)) {
            this.f1255f = requestOptions.f1255f;
        }
        if (m11670b(requestOptions.f1251b, 32)) {
            this.f1256g = requestOptions.f1256g;
        }
        if (m11670b(requestOptions.f1251b, 64)) {
            this.f1257h = requestOptions.f1257h;
        }
        if (m11670b(requestOptions.f1251b, 128)) {
            this.f1258i = requestOptions.f1258i;
        }
        if (m11670b(requestOptions.f1251b, 256)) {
            this.f1259j = requestOptions.f1259j;
        }
        if (m11670b(requestOptions.f1251b, 512)) {
            this.f1261l = requestOptions.f1261l;
            this.f1260k = requestOptions.f1260k;
        }
        if (m11670b(requestOptions.f1251b, 1024)) {
            this.f1262m = requestOptions.f1262m;
        }
        if (m11670b(requestOptions.f1251b, 4096)) {
            this.f1269t = requestOptions.f1269t;
        }
        if (m11670b(requestOptions.f1251b, 8192)) {
            this.f1265p = requestOptions.f1265p;
        }
        if (m11670b(requestOptions.f1251b, 16384)) {
            this.f1266q = requestOptions.f1266q;
        }
        if (m11670b(requestOptions.f1251b, 32768)) {
            this.f1271v = requestOptions.f1271v;
        }
        if (m11670b(requestOptions.f1251b, 65536)) {
            this.f1264o = requestOptions.f1264o;
        }
        if (m11670b(requestOptions.f1251b, 131072)) {
            this.f1263n = requestOptions.f1263n;
        }
        if (m11670b(requestOptions.f1251b, 2048)) {
            this.f1268s.putAll(requestOptions.f1268s);
            this.f1275z = requestOptions.f1275z;
        }
        if (m11670b(requestOptions.f1251b, 524288)) {
            this.f1274y = requestOptions.f1274y;
        }
        if (!this.f1264o) {
            this.f1268s.clear();
            this.f1251b &= -2049;
            this.f1263n = false;
            this.f1251b &= -131073;
            this.f1275z = true;
        }
        this.f1251b |= requestOptions.f1251b;
        this.f1267r.m12011a(requestOptions.f1267r);
        return m11680J();
    }

    public boolean equals(Object obj) {
        if (obj instanceof RequestOptions) {
            RequestOptions requestOptions = (RequestOptions) obj;
            return Float.compare(requestOptions.f1252c, this.f1252c) == 0 && this.f1256g == requestOptions.f1256g && C0791i.m11566a(this.f1255f, requestOptions.f1255f) && this.f1258i == requestOptions.f1258i && C0791i.m11566a(this.f1257h, requestOptions.f1257h) && this.f1266q == requestOptions.f1266q && C0791i.m11566a(this.f1265p, requestOptions.f1265p) && this.f1259j == requestOptions.f1259j && this.f1260k == requestOptions.f1260k && this.f1261l == requestOptions.f1261l && this.f1263n == requestOptions.f1263n && this.f1264o == requestOptions.f1264o && this.f1273x == requestOptions.f1273x && this.f1274y == requestOptions.f1274y && this.f1253d.equals(requestOptions.f1253d) && this.f1254e == requestOptions.f1254e && this.f1267r.equals(requestOptions.f1267r) && this.f1268s.equals(requestOptions.f1268s) && this.f1269t.equals(requestOptions.f1269t) && C0791i.m11566a(this.f1262m, requestOptions.f1262m) && C0791i.m11566a(this.f1271v, requestOptions.f1271v);
        }
        return false;
    }

    public int hashCode() {
        return C0791i.m11567a(this.f1271v, C0791i.m11567a(this.f1262m, C0791i.m11567a(this.f1269t, C0791i.m11567a(this.f1268s, C0791i.m11567a(this.f1267r, C0791i.m11567a(this.f1254e, C0791i.m11567a(this.f1253d, C0791i.m11564a(this.f1274y, C0791i.m11564a(this.f1273x, C0791i.m11564a(this.f1264o, C0791i.m11564a(this.f1263n, C0791i.m11559b(this.f1261l, C0791i.m11559b(this.f1260k, C0791i.m11564a(this.f1259j, C0791i.m11567a(this.f1265p, C0791i.m11559b(this.f1266q, C0791i.m11567a(this.f1257h, C0791i.m11559b(this.f1258i, C0791i.m11567a(this.f1255f, C0791i.m11559b(this.f1256g, C0791i.m11574a(this.f1252c)))))))))))))))))))));
    }

    @NonNull
    /* renamed from: j */
    public RequestOptions mo9518j() {
        this.f1270u = true;
        return this;
    }

    @NonNull
    /* renamed from: k */
    public RequestOptions mo9517k() {
        if (this.f1270u && !this.f1272w) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f1272w = true;
        return mo9518j();
    }

    @NonNull
    /* renamed from: J */
    private RequestOptions m11680J() {
        if (this.f1270u) {
            throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
        }
        return this;
    }

    @NonNull
    /* renamed from: l */
    public final Map<Class<?>, Transformation<?>> m11663l() {
        return this.f1268s;
    }

    /* renamed from: m */
    public final boolean m11662m() {
        return this.f1263n;
    }

    @NonNull
    /* renamed from: n */
    public final Options m11661n() {
        return this.f1267r;
    }

    @NonNull
    /* renamed from: o */
    public final Class<?> m11660o() {
        return this.f1269t;
    }

    @NonNull
    /* renamed from: p */
    public final DiskCacheStrategy m11659p() {
        return this.f1253d;
    }

    @Nullable
    /* renamed from: q */
    public final Drawable m11658q() {
        return this.f1255f;
    }

    /* renamed from: r */
    public final int m11657r() {
        return this.f1256g;
    }

    /* renamed from: s */
    public final int m11656s() {
        return this.f1258i;
    }

    @Nullable
    /* renamed from: t */
    public final Drawable m11655t() {
        return this.f1257h;
    }

    /* renamed from: u */
    public final int m11654u() {
        return this.f1266q;
    }

    @Nullable
    /* renamed from: v */
    public final Drawable m11653v() {
        return this.f1265p;
    }

    @Nullable
    /* renamed from: w */
    public final Resources.Theme m11652w() {
        return this.f1271v;
    }

    /* renamed from: x */
    public final boolean m11651x() {
        return this.f1259j;
    }

    @NonNull
    /* renamed from: y */
    public final Key m11650y() {
        return this.f1262m;
    }

    /* renamed from: z */
    public final boolean m11649z() {
        return m11667c(8);
    }

    @NonNull
    /* renamed from: A */
    public final Priority m11689A() {
        return this.f1254e;
    }

    /* renamed from: B */
    public final int m11688B() {
        return this.f1261l;
    }

    /* renamed from: C */
    public final boolean m11687C() {
        return C0791i.m11571a(this.f1261l, this.f1260k);
    }

    /* renamed from: D */
    public final int m11686D() {
        return this.f1260k;
    }

    /* renamed from: E */
    public final float m11685E() {
        return this.f1252c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: F */
    public boolean m11684F() {
        return this.f1275z;
    }

    /* renamed from: c */
    private boolean m11667c(int i) {
        return m11670b(this.f1251b, i);
    }

    /* renamed from: G */
    public final boolean m11683G() {
        return this.f1273x;
    }

    /* renamed from: H */
    public final boolean m11682H() {
        return this.f1250A;
    }

    /* renamed from: I */
    public final boolean m11681I() {
        return this.f1274y;
    }
}
