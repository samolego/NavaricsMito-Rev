package com.senseplay.sdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.p008v4.app.ActivityCompat;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.C2189R;
import com.senseplay.sdk.SPAccount;
import com.senseplay.sdk.config.SPConfig;
import com.senseplay.sdk.constant.SPWebConstant;
import com.senseplay.sdk.listener.WebLoginListener;
import com.senseplay.sdk.log.SPDebug;
import com.senseplay.sdk.log.SPToast;
import com.senseplay.sdk.model.account.AccountHttp;
import com.senseplay.sdk.model.account.AuthorizeBean;
import com.senseplay.sdk.model.pciture.PictureData;
import com.senseplay.sdk.tool.LanguageTool;
import com.senseplay.sdk.view.SPWebView;

/* loaded from: classes2.dex */
public class SPWebActivity extends Activity {
    AccountHttp accountHttp;
    PictureData pictureData;
    SPWebView spWebView;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        int webScreen = SPConfig.getWebScreen();
        if (webScreen == 1) {
            setRequestedOrientation(1);
        } else if (webScreen == 2) {
            setRequestedOrientation(0);
        } else if (webScreen == 3) {
            setRequestedOrientation(7);
        } else if (webScreen == 4) {
            setRequestedOrientation(6);
        } else {
            setRequestedOrientation(1);
        }
        setContentView(C2189R.layout.sp_activity_web);
        this.spWebView = (SPWebView) findViewById(C2189R.C2191id.sp_web_view);
        init();
    }

    public void init() {
        String str = getIntent().getStringExtra("url") + "&language=" + LanguageTool.getLanguage();
        SPDebug.m5807w("url", "" + str);
        this.spWebView.init();
        this.spWebView.setWebSettings();
        this.spWebView.loadUrl(str);
        this.spWebView.setWebLoginListener(new WebLoginListener() { // from class: com.senseplay.sdk.activity.SPWebActivity.1
            @Override // com.senseplay.sdk.listener.WebLoginListener
            public void setAccountInfo(String str2) {
                SPWebActivity.this.getAccountInfo(str2);
            }

            @Override // com.senseplay.sdk.listener.WebLoginListener
            public void logout() {
                SPWebActivity.this.webLogout();
            }
        });
        this.pictureData = new PictureData(this);
        this.spWebView.setPicture(this.pictureData);
        if (getIntent().getBooleanExtra(SPWebConstant.Permission, false)) {
            initPermissionForCamera();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SPWebView sPWebView = this.spWebView;
        if (sPWebView != null) {
            sPWebView.destroy();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3) {
            Uri cropUri = intent != null ? this.pictureData.getCropUri() : null;
            SPWebView sPWebView = this.spWebView;
            if (sPWebView != null) {
                sPWebView.uploadUri(cropUri);
            }
        } else if (i == 2 || i == 1) {
            if (i2 == -1) {
                this.pictureData.onActivityResult(i, i2, intent);
                return;
            }
            SPWebView sPWebView2 = this.spWebView;
            if (sPWebView2 != null) {
                sPWebView2.uploadUri(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAccountInfo(String str) {
        if (this.accountHttp == null) {
            this.accountHttp = new AccountHttp(this);
        }
        this.accountHttp.getAccountByUrl(str, new MCallBack<AuthorizeBean>() { // from class: com.senseplay.sdk.activity.SPWebActivity.2
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(AuthorizeBean authorizeBean) {
                if (SPAccount.webCallBack != null) {
                    SPAccount.webCallBack.onResult(authorizeBean);
                }
                SPWebActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void webLogout() {
        if (SPAccount.logoutCallBack != null) {
            SPAccount.logoutCallBack.onResult(true);
        }
    }

    private void initPermissionForCamera() {
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
