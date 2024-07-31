package com.navatics.app.activities.test;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class CmdTestMainActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private CmdTestMainActivity f4004b;

    @UiThread
    public CmdTestMainActivity_ViewBinding(CmdTestMainActivity cmdTestMainActivity, View view) {
        this.f4004b = cmdTestMainActivity;
        cmdTestMainActivity.btnRecvTest = (Button) Utils.m12799a(view, R.id.btnRecvTest, "field 'btnRecvTest'", Button.class);
        cmdTestMainActivity.btnDataTest = (Button) Utils.m12799a(view, R.id.btnDataTest, "field 'btnDataTest'", Button.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        CmdTestMainActivity cmdTestMainActivity = this.f4004b;
        if (cmdTestMainActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4004b = null;
        cmdTestMainActivity.btnRecvTest = null;
        cmdTestMainActivity.btnDataTest = null;
    }
}
