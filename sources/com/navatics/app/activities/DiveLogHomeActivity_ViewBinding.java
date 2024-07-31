package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p008v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

/* loaded from: classes.dex */
public class DiveLogHomeActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private DiveLogHomeActivity f3557b;

    @UiThread
    public DiveLogHomeActivity_ViewBinding(DiveLogHomeActivity diveLogHomeActivity, View view) {
        this.f3557b = diveLogHomeActivity;
        diveLogHomeActivity.ivUsrImg = (ImageView) Utils.m12799a(view, R.id.ivUsrImg, "field 'ivUsrImg'", ImageView.class);
        diveLogHomeActivity.tvUsrName = (TextView) Utils.m12799a(view, R.id.tvUsrName, "field 'tvUsrName'", TextView.class);
        diveLogHomeActivity.tvLogCount = (TextView) Utils.m12799a(view, R.id.tvLogCount, "field 'tvLogCount'", TextView.class);
        diveLogHomeActivity.tvTotalTime = (TextView) Utils.m12799a(view, R.id.tvTotalTime, "field 'tvTotalTime'", TextView.class);
        diveLogHomeActivity.lvDivelogList = (SwipeRecyclerView) Utils.m12799a(view, R.id.lvDivelogList, "field 'lvDivelogList'", SwipeRecyclerView.class);
        diveLogHomeActivity.ivBottomRobotIcon = (ImageView) Utils.m12799a(view, R.id.ivBottomRobotIcon, "field 'ivBottomRobotIcon'", ImageView.class);
        diveLogHomeActivity.ivMediaLibraryIcon = (ImageView) Utils.m12799a(view, R.id.ivMediaLibraryIcon, "field 'ivMediaLibraryIcon'", ImageView.class);
        diveLogHomeActivity.swipeLayout = (SwipeRefreshLayout) Utils.m12799a(view, R.id.swipeLayout, "field 'swipeLayout'", SwipeRefreshLayout.class);
        diveLogHomeActivity.containerEmptyLog = (ViewGroup) Utils.m12799a(view, R.id.containerEmptyLog, "field 'containerEmptyLog'", ViewGroup.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        DiveLogHomeActivity diveLogHomeActivity = this.f3557b;
        if (diveLogHomeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3557b = null;
        diveLogHomeActivity.ivUsrImg = null;
        diveLogHomeActivity.tvUsrName = null;
        diveLogHomeActivity.tvLogCount = null;
        diveLogHomeActivity.tvTotalTime = null;
        diveLogHomeActivity.lvDivelogList = null;
        diveLogHomeActivity.ivBottomRobotIcon = null;
        diveLogHomeActivity.ivMediaLibraryIcon = null;
        diveLogHomeActivity.swipeLayout = null;
        diveLogHomeActivity.containerEmptyLog = null;
    }
}
