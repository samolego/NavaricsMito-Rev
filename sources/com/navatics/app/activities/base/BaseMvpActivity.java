package com.navatics.app.activities.base;

import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.activities.base.IPresenter;

/* loaded from: classes.dex */
public abstract class BaseMvpActivity<P extends IPresenter> extends NvBaseActivity implements IBaseView {

    /* renamed from: a */
    protected P f3974a;

    /* renamed from: b */
    private Unbinder f3975b;

    /* renamed from: a */
    protected abstract P mo7476a();

    /* renamed from: b */
    protected abstract void mo7472b();

    /* renamed from: c */
    protected abstract int mo7471c();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(mo7471c());
        this.f3975b = ButterKnife.m12805a(this);
        this.f3974a = mo7476a();
        P p = this.f3974a;
        if (p == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        p.mo8967a(this, bundle);
        this.f3974a.mo8969a(this);
        mo7472b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        P p = this.f3974a;
        if (p != null) {
            p.mo8965c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        P p = this.f3974a;
        if (p != null) {
            p.mo8964d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        P p = this.f3974a;
        if (p != null) {
            p.mo8963e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        P p = this.f3974a;
        if (p != null) {
            p.mo8962f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        P p = this.f3974a;
        if (p != null) {
            p.mo8968a(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        P p = this.f3974a;
        if (p != null) {
            p.mo8966a(false);
            this.f3974a.mo8961g();
        }
        Unbinder unbinder = this.f3975b;
        if (unbinder != null) {
            unbinder.mo7436a();
        }
    }
}
