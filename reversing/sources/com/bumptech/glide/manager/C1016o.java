package com.bumptech.glide.manager;

import android.support.annotation.NonNull;
import com.bumptech.glide.request.p031a.Target;
import com.bumptech.glide.util.C0791i;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.manager.o */
/* loaded from: classes.dex */
public final class TargetTracker implements LifecycleListener {

    /* renamed from: a */
    private final Set<Target<?>> f1185a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: a */
    public void m11760a(@NonNull Target<?> target) {
        this.f1185a.add(target);
    }

    /* renamed from: b */
    public void m11758b(@NonNull Target<?> target) {
        this.f1185a.remove(target);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: c */
    public void mo11695c() {
        for (Target target : C0791i.m11565a(this.f1185a)) {
            target.mo11695c();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: d */
    public void mo11693d() {
        for (Target target : C0791i.m11565a(this.f1185a)) {
            target.mo11693d();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: e */
    public void mo11692e() {
        for (Target target : C0791i.m11565a(this.f1185a)) {
            target.mo11692e();
        }
    }

    @NonNull
    /* renamed from: a */
    public List<Target<?>> m11761a() {
        return C0791i.m11565a(this.f1185a);
    }

    /* renamed from: b */
    public void m11759b() {
        this.f1185a.clear();
    }
}
