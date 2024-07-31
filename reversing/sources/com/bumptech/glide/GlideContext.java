package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.p031a.ImageViewTargetFactory;
import com.bumptech.glide.request.p031a.ViewTarget;
import java.util.Map;

/* renamed from: com.bumptech.glide.g */
/* loaded from: classes.dex */
public class GlideContext extends ContextWrapper {
    @VisibleForTesting

    /* renamed from: a */
    static final TransitionOptions<?, ?> f451a = new GenericTransitionOptions();

    /* renamed from: b */
    private final Handler f452b;

    /* renamed from: c */
    private final ArrayPool f453c;

    /* renamed from: d */
    private final Registry f454d;

    /* renamed from: e */
    private final ImageViewTargetFactory f455e;

    /* renamed from: f */
    private final RequestOptions f456f;

    /* renamed from: g */
    private final Map<Class<?>, TransitionOptions<?, ?>> f457g;

    /* renamed from: h */
    private final Engine f458h;

    /* renamed from: i */
    private final int f459i;

    public GlideContext(@NonNull Context context, @NonNull ArrayPool arrayPool, @NonNull Registry registry, @NonNull ImageViewTargetFactory imageViewTargetFactory, @NonNull RequestOptions requestOptions, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull Engine engine, int i) {
        super(context.getApplicationContext());
        this.f453c = arrayPool;
        this.f454d = registry;
        this.f455e = imageViewTargetFactory;
        this.f456f = requestOptions;
        this.f457g = map;
        this.f458h = engine;
        this.f459i = i;
        this.f452b = new Handler(Looper.getMainLooper());
    }

    /* renamed from: a */
    public RequestOptions m12501a() {
        return this.f456f;
    }

    @NonNull
    /* renamed from: a */
    public <T> TransitionOptions<?, T> m12499a(@NonNull Class<T> cls) {
        TransitionOptions<?, T> transitionOptions = (TransitionOptions<?, T>) this.f457g.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry<Class<?>, TransitionOptions<?, ?>> entry : this.f457g.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions<?, T>) entry.getValue();
                }
            }
        }
        return transitionOptions == null ? (TransitionOptions<?, T>) f451a : transitionOptions;
    }

    @NonNull
    /* renamed from: a */
    public <X> ViewTarget<ImageView, X> m12500a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f455e.m11724a(imageView, cls);
    }

    @NonNull
    /* renamed from: b */
    public Handler m12498b() {
        return this.f452b;
    }

    @NonNull
    /* renamed from: c */
    public Engine m12497c() {
        return this.f458h;
    }

    @NonNull
    /* renamed from: d */
    public Registry m12496d() {
        return this.f454d;
    }

    /* renamed from: e */
    public int m12495e() {
        return this.f459i;
    }

    @NonNull
    /* renamed from: f */
    public ArrayPool m12494f() {
        return this.f453c;
    }
}
