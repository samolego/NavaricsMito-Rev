package com.senseplay.sdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p008v4.app.ActivityCompat;
import com.senseplay.sdk.log.SPToast;

/* loaded from: classes2.dex */
public class BaseActivity extends Activity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
    }

    protected void initPermission() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}, 10);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (10 == i && iArr[0] == -1) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA")) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 10);
            } else {
                SPToast.shortShow(this, "拍照权限被禁用，请在权限管理修改");
            }
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 10);
            } else {
                SPToast.shortShow(this, "磁盘读写权限被禁用，请在权限管理修改");
            }
        }
    }
}
