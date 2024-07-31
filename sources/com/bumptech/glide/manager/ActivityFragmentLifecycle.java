package com.bumptech.glide.manager;

import android.support.annotation.NonNull;
import com.bumptech.glide.util.C0791i;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.manager.a */
/* loaded from: classes.dex */
class ActivityFragmentLifecycle implements Lifecycle {

    /* renamed from: a */
    private final Set<LifecycleListener> f1157a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private boolean f1158b;

    /* renamed from: c */
    private boolean f1159c;

    @Override // com.bumptech.glide.manager.Lifecycle
    /* renamed from: a */
    public void mo11793a(@NonNull LifecycleListener lifecycleListener) {
        this.f1157a.add(lifecycleListener);
        if (this.f1159c) {
            lifecycleListener.mo11692e();
        } else if (this.f1158b) {
            lifecycleListener.mo11695c();
        } else {
            lifecycleListener.mo11693d();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    /* renamed from: b */
    public void mo11792b(@NonNull LifecycleListener lifecycleListener) {
        this.f1157a.remove(lifecycleListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11801a() {
        this.f1158b = true;
        for (LifecycleListener lifecycleListener : C0791i.m11565a(this.f1157a)) {
            lifecycleListener.mo11695c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m11800b() {
        this.f1158b = false;
        for (LifecycleListener lifecycleListener : C0791i.m11565a(this.f1157a)) {
            lifecycleListener.mo11693d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m11799c() {
        this.f1159c = true;
        for (LifecycleListener lifecycleListener : C0791i.m11565a(this.f1157a)) {
            lifecycleListener.mo11692e();
        }
    }
}
