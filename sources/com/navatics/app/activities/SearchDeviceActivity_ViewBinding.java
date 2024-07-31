package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p011v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;
import com.navatics.app.widget.avloading.AVLoadingIndicatorView;

/* loaded from: classes.dex */
public class SearchDeviceActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private SearchDeviceActivity f3891b;

    @UiThread
    public SearchDeviceActivity_ViewBinding(SearchDeviceActivity searchDeviceActivity, View view) {
        this.f3891b = searchDeviceActivity;
        searchDeviceActivity.rvDeviceList = (RecyclerView) Utils.m12799a(view, R.id.rvDeviceList, "field 'rvDeviceList'", RecyclerView.class);
        searchDeviceActivity.tvNoResult = (TextView) Utils.m12799a(view, R.id.tvNoResult, "field 'tvNoResult'", TextView.class);
        searchDeviceActivity.ivConnectingRotatingIcon = (ImageView) Utils.m12799a(view, R.id.ivConnectingRotatingIcon, "field 'ivConnectingRotatingIcon'", ImageView.class);
        searchDeviceActivity.avloadingAnimView = (AVLoadingIndicatorView) Utils.m12799a(view, R.id.avloadingAnimView, "field 'avloadingAnimView'", AVLoadingIndicatorView.class);
        searchDeviceActivity.btnConnect = (Button) Utils.m12799a(view, R.id.btnConnect, "field 'btnConnect'", Button.class);
        searchDeviceActivity.ivBack = (ImageView) Utils.m12799a(view, R.id.ivBack, "field 'ivBack'", ImageView.class);
        searchDeviceActivity.rootLayout = (ViewGroup) Utils.m12799a(view, R.id.rootLayout, "field 'rootLayout'", ViewGroup.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        SearchDeviceActivity searchDeviceActivity = this.f3891b;
        if (searchDeviceActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3891b = null;
        searchDeviceActivity.rvDeviceList = null;
        searchDeviceActivity.tvNoResult = null;
        searchDeviceActivity.ivConnectingRotatingIcon = null;
        searchDeviceActivity.avloadingAnimView = null;
        searchDeviceActivity.btnConnect = null;
        searchDeviceActivity.ivBack = null;
        searchDeviceActivity.rootLayout = null;
    }
}
