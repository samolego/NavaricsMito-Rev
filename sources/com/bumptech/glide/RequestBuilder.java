package com.bumptech.glide;

import android.content.Context;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.p017d.ApplicationVersionSignature;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.p031a.Target;
import com.bumptech.glide.request.p031a.ViewTarget;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.h */
/* loaded from: classes.dex */
public class RequestBuilder<TranscodeType> implements Cloneable {

    /* renamed from: a */
    protected static final RequestOptions f509a = new RequestOptions().mo9537b(DiskCacheStrategy.f897c).mo9549a(Priority.LOW).mo9532b(true);
    @NonNull

    /* renamed from: b */
    protected RequestOptions f510b;

    /* renamed from: c */
    private final Context f511c;

    /* renamed from: d */
    private final RequestManager f512d;

    /* renamed from: e */
    private final Class<TranscodeType> f513e;

    /* renamed from: f */
    private final RequestOptions f514f;

    /* renamed from: g */
    private final Glide f515g;

    /* renamed from: h */
    private final GlideContext f516h;
    @NonNull

    /* renamed from: i */
    private TransitionOptions<?, ? super TranscodeType> f517i;
    @Nullable

    /* renamed from: j */
    private Object f518j;
    @Nullable

    /* renamed from: k */
    private RequestListener<TranscodeType> f519k;
    @Nullable

    /* renamed from: l */
    private RequestBuilder<TranscodeType> f520l;
    @Nullable

    /* renamed from: m */
    private RequestBuilder<TranscodeType> f521m;
    @Nullable

    /* renamed from: n */
    private Float f522n;

    /* renamed from: o */
    private boolean f523o = true;

    /* renamed from: p */
    private boolean f524p;

    /* renamed from: q */
    private boolean f525q;

    /* JADX INFO: Access modifiers changed from: protected */
    public RequestBuilder(Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        this.f515g = glide;
        this.f512d = requestManager;
        this.f513e = cls;
        this.f514f = requestManager.m12431h();
        this.f511c = context;
        this.f517i = requestManager.m12433b(cls);
        this.f510b = this.f514f;
        this.f516h = glide.m12510e();
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestBuilder<TranscodeType> mo8828a(@NonNull RequestOptions requestOptions) {
        Preconditions.m11580a(requestOptions);
        this.f510b = m12451a().mo9546a(requestOptions);
        return this;
    }

    @NonNull
    /* renamed from: a */
    protected RequestOptions m12451a() {
        RequestOptions requestOptions = this.f514f;
        RequestOptions requestOptions2 = this.f510b;
        return requestOptions == requestOptions2 ? requestOptions2.clone() : requestOptions2;
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestBuilder<TranscodeType> mo8829a(@Nullable RequestListener<TranscodeType> requestListener) {
        this.f519k = requestListener;
        return this;
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestBuilder<TranscodeType> mo8826a(@Nullable Object obj) {
        return m12439b(obj);
    }

    @NonNull
    /* renamed from: b */
    private RequestBuilder<TranscodeType> m12439b(@Nullable Object obj) {
        this.f518j = obj;
        this.f524p = true;
        return this;
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestBuilder<TranscodeType> mo8825a(@Nullable String str) {
        return m12439b(str);
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public RequestBuilder<TranscodeType> mo8827a(@RawRes @DrawableRes @Nullable Integer num) {
        return m12439b(num).mo8828a(RequestOptions.m11678a(ApplicationVersionSignature.m12530a(this.f511c)));
    }

    @Override // 
    @CheckResult
    /* renamed from: b */
    public RequestBuilder<TranscodeType> clone() {
        try {
            RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.clone();
            requestBuilder.f510b = requestBuilder.f510b.clone();
            requestBuilder.f517i = (TransitionOptions<?, ? super TranscodeType>) requestBuilder.f517i.clone();
            return requestBuilder;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    /* renamed from: a */
    public <Y extends Target<TranscodeType>> Y m12447a(@NonNull Y y) {
        return (Y) m12446a((RequestBuilder<TranscodeType>) y, (RequestListener) null);
    }

    @NonNull
    /* renamed from: a */
    <Y extends Target<TranscodeType>> Y m12446a(@NonNull Y y, @Nullable RequestListener<TranscodeType> requestListener) {
        return (Y) m12444a(y, requestListener, m12451a());
    }

    /* renamed from: a */
    private <Y extends Target<TranscodeType>> Y m12444a(@NonNull Y y, @Nullable RequestListener<TranscodeType> requestListener, @NonNull RequestOptions requestOptions) {
        C0791i.m11575a();
        Preconditions.m11580a(y);
        if (!this.f524p) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        RequestOptions mo9517k = requestOptions.mo9517k();
        Request m12440b = m12440b(y, requestListener, mo9517k);
        Request mo11704a = y.mo11704a();
        if (m12440b.mo11645a(mo11704a) && !m12442a(mo9517k, mo11704a)) {
            m12440b.mo11631i();
            if (!((Request) Preconditions.m11580a(mo11704a)).mo11639d()) {
                mo11704a.mo11646a();
            }
            return y;
        }
        this.f512d.m12437a((Target<?>) y);
        y.mo11701a(m12440b);
        this.f512d.m12436a(y, m12440b);
        return y;
    }

    /* renamed from: a */
    private boolean m12442a(RequestOptions requestOptions, Request request) {
        return !requestOptions.m11651x() && request.mo11637e();
    }

    @NonNull
    /* renamed from: a */
    public ViewTarget<ImageView, TranscodeType> m12449a(@NonNull ImageView imageView) {
        C0791i.m11575a();
        Preconditions.m11580a(imageView);
        RequestOptions requestOptions = this.f510b;
        if (!requestOptions.m11665d() && requestOptions.m11668c() && imageView.getScaleType() != null) {
            switch (C06092.f528a[imageView.getScaleType().ordinal()]) {
                case 1:
                    requestOptions = requestOptions.clone().mo9523e();
                    break;
                case 2:
                    requestOptions = requestOptions.clone().mo9520h();
                    break;
                case 3:
                case 4:
                case 5:
                    requestOptions = requestOptions.clone().mo9522f();
                    break;
                case 6:
                    requestOptions = requestOptions.clone().mo9520h();
                    break;
            }
        }
        return (ViewTarget) m12444a(this.f516h.m12500a(imageView, this.f513e), null, requestOptions);
    }

    @NonNull
    /* renamed from: a */
    public FutureTarget<TranscodeType> m12450a(int i, int i2) {
        final RequestFutureTarget requestFutureTarget = new RequestFutureTarget(this.f516h.m12498b(), i, i2);
        if (C0791i.m11555d()) {
            this.f516h.m12498b().post(new Runnable() { // from class: com.bumptech.glide.h.1
                @Override // java.lang.Runnable
                public void run() {
                    if (requestFutureTarget.isCancelled()) {
                        return;
                    }
                    RequestBuilder requestBuilder = RequestBuilder.this;
                    RequestFutureTarget requestFutureTarget2 = requestFutureTarget;
                    requestBuilder.m12446a((RequestBuilder) requestFutureTarget2, (RequestListener) requestFutureTarget2);
                }
            });
        } else {
            m12446a((RequestBuilder<TranscodeType>) requestFutureTarget, requestFutureTarget);
        }
        return requestFutureTarget;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBuilder.java */
    /* renamed from: com.bumptech.glide.h$2 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C06092 {

        /* renamed from: a */
        static final /* synthetic */ int[] f528a;

        static {
            try {
                f529b[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f529b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f529b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f529b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f528a = new int[ImageView.ScaleType.values().length];
            try {
                f528a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f528a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f528a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f528a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f528a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f528a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f528a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f528a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @NonNull
    /* renamed from: a */
    private Priority m12448a(@NonNull Priority priority) {
        switch (priority) {
            case LOW:
                return Priority.NORMAL;
            case NORMAL:
                return Priority.HIGH;
            case HIGH:
            case IMMEDIATE:
                return Priority.IMMEDIATE;
            default:
                throw new IllegalArgumentException("unknown priority: " + this.f510b.m11689A());
        }
    }

    /* renamed from: b */
    private Request m12440b(Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, RequestOptions requestOptions) {
        return m12445a(target, requestListener, (RequestCoordinator) null, this.f517i, requestOptions.m11689A(), requestOptions.m11688B(), requestOptions.m11686D(), requestOptions);
    }

    /* renamed from: a */
    private Request m12445a(Target<TranscodeType> target, @Nullable RequestListener<TranscodeType> requestListener, @Nullable RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, RequestOptions requestOptions) {
        ErrorRequestCoordinator errorRequestCoordinator;
        ErrorRequestCoordinator errorRequestCoordinator2;
        int i3;
        int i4;
        if (this.f521m != null) {
            errorRequestCoordinator2 = new ErrorRequestCoordinator(requestCoordinator);
            errorRequestCoordinator = errorRequestCoordinator2;
        } else {
            errorRequestCoordinator = null;
            errorRequestCoordinator2 = requestCoordinator;
        }
        Request m12441b = m12441b(target, requestListener, errorRequestCoordinator2, transitionOptions, priority, i, i2, requestOptions);
        if (errorRequestCoordinator == null) {
            return m12441b;
        }
        int m11688B = this.f521m.f510b.m11688B();
        int m11686D = this.f521m.f510b.m11686D();
        if (!C0791i.m11571a(i, i2) || this.f521m.f510b.m11687C()) {
            i3 = m11688B;
            i4 = m11686D;
        } else {
            i3 = requestOptions.m11688B();
            i4 = requestOptions.m11686D();
        }
        RequestBuilder<TranscodeType> requestBuilder = this.f521m;
        ErrorRequestCoordinator errorRequestCoordinator3 = errorRequestCoordinator;
        errorRequestCoordinator3.m11736a(m12441b, requestBuilder.m12445a(target, requestListener, errorRequestCoordinator, requestBuilder.f517i, requestBuilder.f510b.m11689A(), i3, i4, this.f521m.f510b));
        return errorRequestCoordinator3;
    }

    /* renamed from: b */
    private Request m12441b(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, @Nullable RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, RequestOptions requestOptions) {
        int i3;
        int i4;
        RequestBuilder<TranscodeType> requestBuilder = this.f520l;
        if (requestBuilder != null) {
            if (this.f525q) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            TransitionOptions<?, ? super TranscodeType> transitionOptions2 = requestBuilder.f523o ? transitionOptions : requestBuilder.f517i;
            Priority m11689A = this.f520l.f510b.m11649z() ? this.f520l.f510b.m11689A() : m12448a(priority);
            int m11688B = this.f520l.f510b.m11688B();
            int m11686D = this.f520l.f510b.m11686D();
            if (!C0791i.m11571a(i, i2) || this.f520l.f510b.m11687C()) {
                i3 = m11688B;
                i4 = m11686D;
            } else {
                i3 = requestOptions.m11688B();
                i4 = requestOptions.m11686D();
            }
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(requestCoordinator);
            Request m12443a = m12443a(target, requestListener, requestOptions, thumbnailRequestCoordinator, transitionOptions, priority, i, i2);
            this.f525q = true;
            RequestBuilder<TranscodeType> requestBuilder2 = this.f520l;
            Request m12445a = requestBuilder2.m12445a(target, requestListener, thumbnailRequestCoordinator, transitionOptions2, m11689A, i3, i4, requestBuilder2.f510b);
            this.f525q = false;
            thumbnailRequestCoordinator.m11644a(m12443a, m12445a);
            return thumbnailRequestCoordinator;
        } else if (this.f522n != null) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(requestCoordinator);
            thumbnailRequestCoordinator2.m11644a(m12443a(target, requestListener, requestOptions, thumbnailRequestCoordinator2, transitionOptions, priority, i, i2), m12443a(target, requestListener, requestOptions.clone().mo9552a(this.f522n.floatValue()), thumbnailRequestCoordinator2, transitionOptions, m12448a(priority), i, i2));
            return thumbnailRequestCoordinator2;
        } else {
            return m12443a(target, requestListener, requestOptions, requestCoordinator, transitionOptions, priority, i, i2);
        }
    }

    /* renamed from: a */
    private Request m12443a(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestOptions requestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2) {
        Context context = this.f511c;
        GlideContext glideContext = this.f516h;
        return SingleRequest.m11755a(context, glideContext, this.f518j, this.f513e, requestOptions, i, i2, priority, target, requestListener, this.f519k, requestCoordinator, glideContext.m12497c(), transitionOptions.m12429b());
    }
}
