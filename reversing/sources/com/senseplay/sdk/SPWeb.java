package com.senseplay.sdk;

import android.content.Context;
import android.content.Intent;
import com.senseplay.sdk.activity.SPWebActivity;
import com.senseplay.sdk.model.account.AccountHttp;

/* loaded from: classes2.dex */
public class SPWeb {
    private static SPWeb spWeb;
    private AccountHttp accountHttp;
    private Context mContext;

    public static SPWeb getInstance() {
        if (spWeb == null) {
            synchronized (SPWeb.class) {
                if (spWeb == null) {
                    spWeb = new SPWeb();
                }
            }
        }
        return spWeb;
    }

    private SPWeb() {
    }

    public void loadUrl(String str) {
        SPManager.getInstance();
        Context content = SPManager.getContent();
        Intent intent = new Intent();
        intent.setClass(content, SPWebActivity.class);
        intent.putExtra("url", str);
        this.mContext.startActivity(intent);
    }
}
