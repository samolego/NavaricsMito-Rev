package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p008v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;
import com.navatics.app.widget.DivelogDiagram;
import com.navatics.dsbridge.DWebView;
import com.stx.xhb.commontitlebar.CustomTitleBar;

/* loaded from: classes.dex */
public class DiveLogActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private DiveLogActivity f3538b;

    @UiThread
    public DiveLogActivity_ViewBinding(DiveLogActivity diveLogActivity, View view) {
        this.f3538b = diveLogActivity;
        diveLogActivity.titlebar = (CustomTitleBar) Utils.m12799a(view, R.id.titlebar, "field 'titlebar'", CustomTitleBar.class);
        diveLogActivity.divelogBanner = (ViewPager) Utils.m12799a(view, R.id.divelogBanner, "field 'divelogBanner'", ViewPager.class);
        diveLogActivity.divelogCoverPic = (ImageView) Utils.m12799a(view, R.id.divelogCoverPic, "field 'divelogCoverPic'", ImageView.class);
        diveLogActivity.scrollView = (ScrollView) Utils.m12799a(view, R.id.scrollView, "field 'scrollView'", ScrollView.class);
        diveLogActivity.divelogDiagram = (DivelogDiagram) Utils.m12799a(view, R.id.divelogDiagram, "field 'divelogDiagram'", DivelogDiagram.class);
        diveLogActivity.mapWebView = (DWebView) Utils.m12799a(view, R.id.mapWebView, "field 'mapWebView'", DWebView.class);
        diveLogActivity.mapContainer = (ViewGroup) Utils.m12799a(view, R.id.mapContainer, "field 'mapContainer'", ViewGroup.class);
        diveLogActivity.noteContainer = (RelativeLayout) Utils.m12799a(view, R.id.noteContainer, "field 'noteContainer'", RelativeLayout.class);
        diveLogActivity.btnAddNote = (Button) Utils.m12799a(view, R.id.btnAddNote, "field 'btnAddNote'", Button.class);
        diveLogActivity.tvNote = (TextView) Utils.m12799a(view, R.id.tvNote, "field 'tvNote'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        DiveLogActivity diveLogActivity = this.f3538b;
        if (diveLogActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3538b = null;
        diveLogActivity.titlebar = null;
        diveLogActivity.divelogBanner = null;
        diveLogActivity.divelogCoverPic = null;
        diveLogActivity.scrollView = null;
        diveLogActivity.divelogDiagram = null;
        diveLogActivity.mapWebView = null;
        diveLogActivity.mapContainer = null;
        diveLogActivity.noteContainer = null;
        diveLogActivity.btnAddNote = null;
        diveLogActivity.tvNote = null;
    }
}
