package com.mframe.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class BaseFragment extends MFragment {

    /* renamed from: a */
    protected View f3447a;

    /* renamed from: c */
    private boolean f3448c = false;

    /* renamed from: d */
    private boolean f3449d;

    /* renamed from: a */
    protected abstract int m9579a();

    /* renamed from: b */
    protected abstract void m9577b();

    /* renamed from: c */
    protected abstract void m9576c();

    @Override // android.support.p008v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3447a = layoutInflater.inflate(m9579a(), viewGroup, false);
        m9574e();
        return m9578a(this.f3447a);
    }

    /* renamed from: a */
    protected View m9578a(View view) {
        m9574e();
        m9577b();
        if (this.f3449d) {
            m9575d();
        }
        return view;
    }

    /* renamed from: d */
    private void m9575d() {
        m9576c();
        this.f3448c = true;
    }

    /* renamed from: e */
    private void m9574e() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f3449d = arguments.getBoolean("initData", false);
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.p008v4.app.Fragment
    public void onPause() {
        super.onPause();
    }
}
