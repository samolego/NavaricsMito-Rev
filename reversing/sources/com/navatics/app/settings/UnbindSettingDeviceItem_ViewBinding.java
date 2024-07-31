package com.navatics.app.settings;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class UnbindSettingDeviceItem_ViewBinding implements Unbinder {

    /* renamed from: b */
    private UnbindSettingDeviceItem f5089b;

    @UiThread
    public UnbindSettingDeviceItem_ViewBinding(UnbindSettingDeviceItem unbindSettingDeviceItem, View view) {
        this.f5089b = unbindSettingDeviceItem;
        unbindSettingDeviceItem.ivDeviceIcon = (ImageView) Utils.m12799a(view, R.id.ivDeviceIcon, "field 'ivDeviceIcon'", ImageView.class);
        unbindSettingDeviceItem.tvDeviceType = (TextView) Utils.m12799a(view, R.id.tvDeviceType, "field 'tvDeviceType'", TextView.class);
        unbindSettingDeviceItem.tvDeviceSN = (TextView) Utils.m12799a(view, R.id.tvDeviceSN, "field 'tvDeviceSN'", TextView.class);
        unbindSettingDeviceItem.btnUnbind = (Button) Utils.m12799a(view, R.id.btnUnbind, "field 'btnUnbind'", Button.class);
        unbindSettingDeviceItem.pgUnbind = (ProgressBar) Utils.m12799a(view, R.id.pgUnbind, "field 'pgUnbind'", ProgressBar.class);
        unbindSettingDeviceItem.btnContainer = (ViewGroup) Utils.m12799a(view, R.id.btnContainer, "field 'btnContainer'", ViewGroup.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        UnbindSettingDeviceItem unbindSettingDeviceItem = this.f5089b;
        if (unbindSettingDeviceItem == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f5089b = null;
        unbindSettingDeviceItem.ivDeviceIcon = null;
        unbindSettingDeviceItem.tvDeviceType = null;
        unbindSettingDeviceItem.tvDeviceSN = null;
        unbindSettingDeviceItem.btnUnbind = null;
        unbindSettingDeviceItem.pgUnbind = null;
        unbindSettingDeviceItem.btnContainer = null;
    }
}
