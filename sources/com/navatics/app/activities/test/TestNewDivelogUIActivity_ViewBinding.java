package com.navatics.app.activities.test;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;
import com.navatics.app.widget.DivelogSeekbar;

/* loaded from: classes.dex */
public class TestNewDivelogUIActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private TestNewDivelogUIActivity f4005b;

    @UiThread
    public TestNewDivelogUIActivity_ViewBinding(TestNewDivelogUIActivity testNewDivelogUIActivity, View view) {
        this.f4005b = testNewDivelogUIActivity;
        testNewDivelogUIActivity.divelogSeekbar = (DivelogSeekbar) Utils.m12799a(view, R.id.divelogSeekbar, "field 'divelogSeekbar'", DivelogSeekbar.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        TestNewDivelogUIActivity testNewDivelogUIActivity = this.f4005b;
        if (testNewDivelogUIActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4005b = null;
        testNewDivelogUIActivity.divelogSeekbar = null;
    }
}
