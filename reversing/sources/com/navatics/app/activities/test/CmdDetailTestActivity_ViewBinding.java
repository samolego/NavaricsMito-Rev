package com.navatics.app.activities.test;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.navatics.app.R;
import com.navatics.app.widget.PreviewLoadingOverlay;

/* loaded from: classes.dex */
public class CmdDetailTestActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private CmdDetailTestActivity f3990b;

    /* renamed from: c */
    private View f3991c;

    @UiThread
    public CmdDetailTestActivity_ViewBinding(final CmdDetailTestActivity cmdDetailTestActivity, View view) {
        this.f3990b = cmdDetailTestActivity;
        cmdDetailTestActivity.requestSelector = (Spinner) Utils.m12799a(view, R.id.requestSelector, "field 'requestSelector'", Spinner.class);
        View m12800a = Utils.m12800a(view, R.id.btnSend, "field 'btnSend' and method 'onClick'");
        cmdDetailTestActivity.btnSend = (Button) Utils.m12798b(m12800a, R.id.btnSend, "field 'btnSend'", Button.class);
        this.f3991c = m12800a;
        m12800a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.test.CmdDetailTestActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                cmdDetailTestActivity.onClick(view2);
            }
        });
        cmdDetailTestActivity.tvSendText = (TextView) Utils.m12799a(view, R.id.tvSendText, "field 'tvSendText'", TextView.class);
        cmdDetailTestActivity.tvRecvText = (TextView) Utils.m12799a(view, R.id.tvRecvText, "field 'tvRecvText'", TextView.class);
        cmdDetailTestActivity.loadingOverlay = (PreviewLoadingOverlay) Utils.m12799a(view, R.id.loadingOverlay, "field 'loadingOverlay'", PreviewLoadingOverlay.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        CmdDetailTestActivity cmdDetailTestActivity = this.f3990b;
        if (cmdDetailTestActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3990b = null;
        cmdDetailTestActivity.requestSelector = null;
        cmdDetailTestActivity.btnSend = null;
        cmdDetailTestActivity.tvSendText = null;
        cmdDetailTestActivity.tvRecvText = null;
        cmdDetailTestActivity.loadingOverlay = null;
        this.f3991c.setOnClickListener(null);
        this.f3991c = null;
    }
}
