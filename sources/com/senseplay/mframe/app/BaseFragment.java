package com.senseplay.mframe.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public abstract class BaseFragment extends MFragment {
    private boolean initData;
    private boolean isInitData = false;
    protected View view;

    protected abstract int getViewResId();

    protected abstract void initData();

    protected abstract void initView();

    protected void onNetworkRefresh() {
    }

    protected void onNoDataClick() {
    }

    @Override // android.support.p008v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(getViewResId(), viewGroup, false);
        initIntent();
        return onCreateView(this.view);
    }

    protected View onCreateView(View view) {
        initIntent();
        initView();
        if (this.initData) {
            initData_();
        }
        return view;
    }

    public void showData() {
        if (this.isInitData) {
            return;
        }
        initData_();
        this.isInitData = true;
    }

    public boolean isInitData() {
        return this.isInitData;
    }

    private void initData_() {
        initData();
        this.isInitData = true;
    }

    private void initIntent() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.initData = arguments.getBoolean("initData", false);
        }
    }

    public void setInitData(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("initData", true);
        setArguments(bundle);
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
