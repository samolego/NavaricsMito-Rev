package com.navatics.app.activities.test;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class UnbindActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private UnbindActivity f4013b;

    /* renamed from: c */
    private View f4014c;

    /* renamed from: d */
    private View f4015d;

    @UiThread
    public UnbindActivity_ViewBinding(final UnbindActivity unbindActivity, View view) {
        this.f4013b = unbindActivity;
        View m12800a = Utils.m12800a(view, R.id.btnUnbindRemote, "field 'btnUnbindRemote' and method 'onUnBindRemoteClicked'");
        unbindActivity.btnUnbindRemote = (Button) Utils.m12798b(m12800a, R.id.btnUnbindRemote, "field 'btnUnbindRemote'", Button.class);
        this.f4014c = m12800a;
        m12800a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.test.UnbindActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                unbindActivity.onUnBindRemoteClicked(view2);
            }
        });
        View m12800a2 = Utils.m12800a(view, R.id.btnUnbindCoreboard, "field 'btnUnbindCoreboard' and method 'onUnBindDeviceClicked'");
        unbindActivity.btnUnbindCoreboard = (Button) Utils.m12798b(m12800a2, R.id.btnUnbindCoreboard, "field 'btnUnbindCoreboard'", Button.class);
        this.f4015d = m12800a2;
        m12800a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.test.UnbindActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                unbindActivity.onUnBindDeviceClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        UnbindActivity unbindActivity = this.f4013b;
        if (unbindActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f4013b = null;
        unbindActivity.btnUnbindRemote = null;
        unbindActivity.btnUnbindCoreboard = null;
        this.f4014c.setOnClickListener(null);
        this.f4014c = null;
        this.f4015d.setOnClickListener(null);
        this.f4015d = null;
    }
}
