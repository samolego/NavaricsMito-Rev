package com.navatics.app.activities.base;

import android.content.Context;
import android.os.Bundle;
import com.navatics.app.activities.base.IBaseView;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/* renamed from: com.navatics.app.activities.base.a */
/* loaded from: classes.dex */
public abstract class BasePresenter<V extends IBaseView> implements IPresenter<V> {

    /* renamed from: a */
    protected Reference<V> f3976a;

    /* renamed from: b */
    protected Reference<Context> f3977b;

    /* renamed from: c */
    private CompositeDisposable f3978c;

    @Override // com.navatics.app.activities.base.IPresenter
    /* renamed from: c */
    public void mo8965c() {
    }

    @Override // com.navatics.app.activities.base.IPresenter
    /* renamed from: d */
    public void mo8964d() {
    }

    @Override // com.navatics.app.activities.base.IPresenter
    /* renamed from: e */
    public void mo8963e() {
    }

    @Override // com.navatics.app.activities.base.IPresenter
    /* renamed from: f */
    public void mo8962f() {
    }

    /* renamed from: a */
    public void m8971a(V v) {
        this.f3976a = new SoftReference(v);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public V m8972a() {
        Reference<V> reference = this.f3976a;
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    /* renamed from: b */
    public void m8970b() {
        Reference<V> reference = this.f3976a;
        if (reference != null) {
            reference.clear();
            this.f3976a = null;
        }
        Reference<Context> reference2 = this.f3977b;
        if (reference2 != null) {
            reference2.clear();
            this.f3977b = null;
        }
        CompositeDisposable compositeDisposable = this.f3978c;
        if (compositeDisposable != null) {
            compositeDisposable.m3224a();
        }
    }

    @Override // com.navatics.app.activities.base.IPresenter
    /* renamed from: a */
    public void mo8967a(V v, Bundle bundle) {
        m8971a((BasePresenter<V>) v);
    }

    @Override // com.navatics.app.activities.base.IPresenter
    /* renamed from: a */
    public void mo8966a(boolean z) {
        m8970b();
    }

    @Override // com.navatics.app.activities.base.IPresenter
    /* renamed from: a */
    public void mo8969a(Context context) {
        this.f3977b = new SoftReference(context);
    }
}
