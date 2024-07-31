package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class ScanQRCodeActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private ScanQRCodeActivity f3867b;

    @UiThread
    public ScanQRCodeActivity_ViewBinding(ScanQRCodeActivity scanQRCodeActivity, View view) {
        this.f3867b = scanQRCodeActivity;
        scanQRCodeActivity.zxView = (ZXingView) Utils.m12799a(view, R.id.zxView, "field 'zxView'", ZXingView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        ScanQRCodeActivity scanQRCodeActivity = this.f3867b;
        if (scanQRCodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3867b = null;
        scanQRCodeActivity.zxView = null;
    }
}
