package com.navatics.app.settings;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class ConnectionStateSetting_ViewBinding implements Unbinder {

    /* renamed from: b */
    private ConnectionStateSetting f5022b;

    @UiThread
    public ConnectionStateSetting_ViewBinding(ConnectionStateSetting connectionStateSetting, View view) {
        this.f5022b = connectionStateSetting;
        connectionStateSetting.ivPhone = (ImageView) Utils.m12799a(view, R.id.ivPhone, "field 'ivPhone'", ImageView.class);
        connectionStateSetting.ivConnSymbol1 = (ImageView) Utils.m12799a(view, R.id.ivConnSymbol1, "field 'ivConnSymbol1'", ImageView.class);
        connectionStateSetting.ivRemote = (ImageView) Utils.m12799a(view, R.id.ivRemote, "field 'ivRemote'", ImageView.class);
        connectionStateSetting.ivInProgress = (ImageView) Utils.m12799a(view, R.id.ivInProgress, "field 'ivInProgress'", ImageView.class);
        connectionStateSetting.ivBuoy = (ImageView) Utils.m12799a(view, R.id.ivBuoy, "field 'ivBuoy'", ImageView.class);
        connectionStateSetting.ivConnSymbol2 = (ImageView) Utils.m12799a(view, R.id.ivConnSymbol2, "field 'ivConnSymbol2'", ImageView.class);
        connectionStateSetting.ivRobot = (ImageView) Utils.m12799a(view, R.id.ivRobot, "field 'ivRobot'", ImageView.class);
        connectionStateSetting.btnContainer = (ViewGroup) Utils.m12799a(view, R.id.btnContainer, "field 'btnContainer'", ViewGroup.class);
        connectionStateSetting.tvDisconnect = (TextView) Utils.m12799a(view, R.id.tvDisconnect, "field 'tvDisconnect'", TextView.class);
        connectionStateSetting.pgDisconnect = (ProgressBar) Utils.m12799a(view, R.id.pgDisconnect, "field 'pgDisconnect'", ProgressBar.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        ConnectionStateSetting connectionStateSetting = this.f5022b;
        if (connectionStateSetting == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f5022b = null;
        connectionStateSetting.ivPhone = null;
        connectionStateSetting.ivConnSymbol1 = null;
        connectionStateSetting.ivRemote = null;
        connectionStateSetting.ivInProgress = null;
        connectionStateSetting.ivBuoy = null;
        connectionStateSetting.ivConnSymbol2 = null;
        connectionStateSetting.ivRobot = null;
        connectionStateSetting.btnContainer = null;
        connectionStateSetting.tvDisconnect = null;
        connectionStateSetting.pgDisconnect = null;
    }
}
