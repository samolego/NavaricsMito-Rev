package com.senseplay.sdk.zxing.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.p008v4.app.ActivityCompat;
import android.support.p008v4.content.ContextCompat;
import android.support.p011v7.app.AlertDialog;
import android.util.Log;
import com.senseplay.sdk.C2189R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PermissionsUtil {
    public static final int APP_SETTINGS_REQUEST_CODE = 222;
    public static final int HANDLER_LEFT = 444;
    public static final int HANDLER_RIGHT = 555;
    private static final String PACKAGE_URL_SCHEME = "package:";
    public static final int PERMISSION_REQUEST_CODE = 111;
    private static final String TAG = "PermissionsUtil";
    private static PermissionsUtil permissionsUtil;
    private boolean isRequireCheck = true;
    private List<String> permissionList = new ArrayList();

    public static PermissionsUtil getInstance() {
        if (permissionsUtil == null) {
            synchronized (PermissionsUtil.class) {
                if (permissionsUtil == null) {
                    permissionsUtil = new PermissionsUtil();
                }
            }
        }
        return permissionsUtil;
    }

    public void init(Context context, String... strArr) {
        this.isRequireCheck = true;
        if (this.isRequireCheck) {
            setPermissions(context, strArr);
        }
    }

    public void setPermissions(Context context, String... strArr) {
        if (strArr == null || strArr.length <= 0 || Build.VERSION.SDK_INT < 23 || !lacksPermissions(context, strArr)) {
            return;
        }
        requestPermissions((Activity) context, strArr);
    }

    public boolean lacksPermissions(Context context, String... strArr) {
        for (String str : strArr) {
            if (lacksPermission(context, str)) {
                return true;
            }
        }
        return false;
    }

    private boolean lacksPermission(Context context, String str) {
        if (ContextCompat.checkSelfPermission(context, str) == -1) {
            Log.e(TAG, "判断是否缺少权限 : true");
        } else {
            Log.e(TAG, "判断是否缺少权限 : false");
        }
        return ContextCompat.checkSelfPermission(context, str) == -1;
    }

    public void requestPermissions(Activity activity, String... strArr) {
        ActivityCompat.requestPermissions(activity, strArr, 111);
    }

    public void onResume(Context context, String... strArr) {
        if (this.isRequireCheck) {
            setPermissions(context, strArr);
        }
    }

    public void onRequestPermissionResult(final Context context, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 111) {
            if (hasAllPermissionsGranted(iArr)) {
                this.isRequireCheck = false;
                return;
            }
            this.isRequireCheck = false;
            showMissingPermissionDialog(context, new Handler() { // from class: com.senseplay.sdk.zxing.utils.PermissionsUtil.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (message.what == 444) {
                        ((Activity) context).finish();
                    } else if (message.what == 555) {
                        PermissionsUtil.this.isRequireCheck = true;
                    }
                }
            });
        }
    }

    public boolean hasAllPermissionsGranted(@NonNull int[] iArr) {
        for (int i : iArr) {
            if (i == -1) {
                return false;
            }
        }
        return true;
    }

    public void showMissingPermissionDialog(final Context context, final Handler handler) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(C2189R.string.help);
        builder.setMessage(C2189R.string.string_help_text);
        builder.setNegativeButton(C2189R.string.quit, new DialogInterface.OnClickListener() { // from class: com.senseplay.sdk.zxing.utils.PermissionsUtil.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                handler.sendEmptyMessage(PermissionsUtil.HANDLER_LEFT);
            }
        });
        builder.setPositiveButton(C2189R.string.settings, new DialogInterface.OnClickListener() { // from class: com.senseplay.sdk.zxing.utils.PermissionsUtil.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                handler.sendEmptyMessage(PermissionsUtil.HANDLER_RIGHT);
                PermissionsUtil.this.startAppSettings(context);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAppSettings(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse(PACKAGE_URL_SCHEME + context.getPackageName()));
        context.startActivity(intent);
    }
}
