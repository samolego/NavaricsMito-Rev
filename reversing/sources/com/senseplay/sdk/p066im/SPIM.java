package com.senseplay.sdk.p066im;

import android.content.Context;
import android.content.Intent;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.SPManager;
import com.senseplay.sdk.activity.SPWebActivity;
import com.senseplay.sdk.model.account.AuthorizeBean;

/* renamed from: com.senseplay.sdk.im.SPIM */
/* loaded from: classes2.dex */
public class SPIM {
    private static Context mContext;
    private static SPIM spim;
    public static MCallBack<AuthorizeBean> webCallBack;

    public static SPIM getInstance(Context context) {
        mContext = context;
        if (spim == null) {
            synchronized (SPIM.class) {
                if (spim == null) {
                    spim = new SPIM(context);
                }
            }
        }
        return spim;
    }

    private SPIM(Context context) {
    }

    public void talk(String str, String str2) {
        Intent intent = new Intent();
        intent.setClass(mContext, SPWebActivity.class);
        intent.putExtra("url", String.format(ImUrl.TalkUrl, SPManager.getClientId(), str, str2));
        mContext.startActivity(intent);
    }
}
