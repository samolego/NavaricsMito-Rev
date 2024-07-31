package com.senseplay.sdk.screen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.view.Display;

/* loaded from: classes2.dex */
public class DualScreenHelper {
    private static DualScreenHelper helper;
    private DualScreen dualScreen;
    private Context mContext;
    private DualScreenListener mListener;
    private final int type_dual = 10;

    public static DualScreenHelper getInstance(Context context) {
        if (helper == null) {
            synchronized (DualScreenHelper.class) {
                if (helper == null) {
                    helper = new DualScreenHelper(context);
                }
            }
        }
        return helper;
    }

    private DualScreenHelper(Context context) {
        this.mContext = context;
    }

    public void showScreen(DualScreenListener dualScreenListener) {
        this.mListener = dualScreenListener;
        if (checkOverlayPermission()) {
            showSecScreen(this.mContext);
        }
    }

    public boolean hasTwoScreen(Context context) {
        return ((DisplayManager) context.getSystemService("display")).getDisplays().length >= 2;
    }

    private void showSecScreen(Context context) {
        Display[] displays = ((DisplayManager) context.getSystemService("display")).getDisplays();
        if (displays.length >= 2 && this.mListener != null) {
            DualScreen dualScreen = new DualScreen(context, displays[displays.length - 1]);
            dualScreen.getWindow().setType(2038);
            this.mListener.dualDisplay(dualScreen);
        }
    }

    @RequiresApi(api = 17)
    public void showSecScreenAgain(Context context, DualScreenListener dualScreenListener) {
        this.mListener = dualScreenListener;
        Display[] displays = ((DisplayManager) context.getSystemService("display")).getDisplays();
        if (displays.length >= 2 && dualScreenListener != null) {
            DualScreen dualScreen = new DualScreen(context, displays[displays.length - 1]);
            if (Build.VERSION.SDK_INT > 26) {
                dualScreen.getWindow().setType(2038);
            } else {
                dualScreen.getWindow().setType(2002);
            }
            dualScreenListener.dualDisplay(dualScreen);
        }
    }

    private boolean checkOverlayPermission() {
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this.mContext)) {
            return true;
        }
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.fromParts("package", this.mContext.getPackageName(), null));
        ((Activity) this.mContext).startActivityForResult(intent, 10);
        return false;
    }

    public void onActivityResult(int i) {
        if (10 == i && Build.VERSION.SDK_INT >= 23 && Settings.canDrawOverlays(this.mContext)) {
            showSecScreen(this.mContext);
        }
    }
}
