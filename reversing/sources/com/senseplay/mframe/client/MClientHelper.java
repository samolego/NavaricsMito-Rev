package com.senseplay.mframe.client;

import android.content.Context;
import android.os.Handler;
import com.senseplay.mframe.tool.MDebug;
import com.senseplay.mframe.tool.MNetworkTool;
import com.senseplay.mframe.tool.MUtilTool;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class MClientHelper {
    public static final int TYPE_DELETE = 3;
    public static final int TYPE_GET = 0;
    public static final int TYPE_POST = 1;
    public static final int TYPE_PUT = 2;
    private static volatile MClientHelper mHelper;
    private Context mContext;
    private Handler mHandler;

    MClientHelper(Context context) {
        this.mContext = context;
        if (context != null) {
            this.mHandler = new Handler(context.getMainLooper());
        }
    }

    public static MClientHelper getInstance(Context context) {
        MClientHelper mClientHelper = mHelper;
        if (mClientHelper == null) {
            synchronized (MClientHelper.class) {
                mClientHelper = mHelper;
                if (mClientHelper == null && context != null) {
                    mClientHelper = new MClientHelper(context.getApplicationContext());
                    mHelper = mClientHelper;
                }
            }
        }
        return mClientHelper;
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.senseplay.mframe.client.MClientHelper$1] */
    public <T> void request(final String str, final int i, final HashMap<String, String> hashMap, final MReqListener<T> mReqListener) {
        if (mReqListener == null) {
            return;
        }
        final MCallBack<T> callBack = mReqListener.getCallBack();
        if (!MNetworkTool.isNetworkConnected(this.mContext)) {
            failedCallBack("网络异常", callBack);
        } else {
            new Thread() { // from class: com.senseplay.mframe.client.MClientHelper.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    String str2 = "";
                    switch (i) {
                        case 0:
                            str2 = MHttpURLClient.requestGet(str, hashMap);
                            break;
                        case 1:
                            str2 = MHttpURLClient.requestPost(MHttpURLClient.Method_Post, str, hashMap);
                            break;
                        case 2:
                            str2 = MHttpURLClient.requestPost(MHttpURLClient.Method_Put, str, hashMap);
                            break;
                        case 3:
                            str2 = MHttpURLClient.requestPost(MHttpURLClient.Method_Del, str, hashMap);
                            break;
                    }
                    if (MUtilTool.isNull(str2)) {
                        MClientHelper.this.failedCallBack("数据异常", callBack);
                        return;
                    }
                    try {
                        MClientHelper.this.successCallBack(mReqListener.onResponse_(str2), callBack);
                    } catch (Exception e) {
                        MDebug.m5825e("http", e.getMessage());
                        e.printStackTrace();
                        MClientHelper.this.failedCallBack("解析错误", callBack);
                    }
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void successCallBack(final T t, final MCallBack<T> mCallBack) {
        this.mHandler.post(new Runnable() { // from class: com.senseplay.mframe.client.MClientHelper.2
            @Override // java.lang.Runnable
            public void run() {
                MCallBack mCallBack2 = mCallBack;
                if (mCallBack2 != null) {
                    mCallBack2.onResult(t);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void failedCallBack(String str, final MCallBack<T> mCallBack) {
        this.mHandler.post(new Runnable() { // from class: com.senseplay.mframe.client.MClientHelper.3
            @Override // java.lang.Runnable
            public void run() {
                MCallBack mCallBack2 = mCallBack;
                if (mCallBack2 != null) {
                    mCallBack2.onResult(null);
                }
            }
        });
    }
}
