package com.tencent.p075mm.opensdk.diffdev.p077a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import com.tencent.p075mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p075mm.opensdk.diffdev.OAuthListener;
import com.tencent.p075mm.opensdk.utils.Log;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.d */
/* loaded from: classes2.dex */
public final class AsyncTaskC2510d extends AsyncTask<Void, Void, C2511a> {

    /* renamed from: ad */
    private static final String f7795ad = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/oauth_qrcode.png";

    /* renamed from: ae */
    private static String f7796ae;

    /* renamed from: af */
    private String f7797af;

    /* renamed from: ag */
    private String f7798ag;

    /* renamed from: ah */
    private OAuthListener f7799ah;

    /* renamed from: ai */
    private AsyncTaskC2513f f7800ai;
    private String appId;
    private String scope;
    private String signature;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.d$a */
    /* loaded from: classes2.dex */
    static class C2511a {

        /* renamed from: aj */
        public OAuthErrCode f7801aj;

        /* renamed from: ak */
        public String f7802ak;

        /* renamed from: al */
        public String f7803al;

        /* renamed from: am */
        public String f7804am;

        /* renamed from: an */
        public int f7805an;

        /* renamed from: ao */
        public String f7806ao;

        /* renamed from: ap */
        public byte[] f7807ap;

        private C2511a() {
        }

        /* renamed from: c */
        public static C2511a m5009c(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String str;
            String str2;
            Object[] objArr;
            C2511a c2511a = new C2511a();
            if (bArr == null || bArr.length == 0) {
                Log.m5000e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i = jSONObject.getInt("errcode");
                        if (i != 0) {
                            Log.m5000e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i)));
                            c2511a.f7801aj = OAuthErrCode.WechatAuth_Err_NormalErr;
                            c2511a.f7805an = i;
                            c2511a.f7806ao = jSONObject.optString("errmsg");
                            return c2511a;
                        }
                        String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (string != null && string.length() != 0) {
                            byte[] decode = Base64.decode(string, 0);
                            if (decode != null && decode.length != 0) {
                                c2511a.f7801aj = OAuthErrCode.WechatAuth_Err_OK;
                                c2511a.f7807ap = decode;
                                c2511a.f7802ak = jSONObject.getString("uuid");
                                c2511a.f7803al = jSONObject.getString("appname");
                                Log.m5001d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", c2511a.f7802ak, c2511a.f7803al, Integer.valueOf(c2511a.f7807ap.length)));
                                return c2511a;
                            }
                            Log.m5000e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                            c2511a.f7801aj = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            return c2511a;
                        }
                        Log.m5000e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                        c2511a.f7801aj = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return c2511a;
                    } catch (Exception e) {
                        str = "MicroMsg.SDK.GetQRCodeResult";
                        str2 = "parse json fail, ex = %s";
                        objArr = new Object[]{e.getMessage()};
                        Log.m5000e(str, String.format(str2, objArr));
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        c2511a.f7801aj = oAuthErrCode;
                        return c2511a;
                    }
                } catch (Exception e2) {
                    str = "MicroMsg.SDK.GetQRCodeResult";
                    str2 = "parse fail, build String fail, ex = %s";
                    objArr = new Object[]{e2.getMessage()};
                }
            }
            c2511a.f7801aj = oAuthErrCode;
            return c2511a;
        }
    }

    static {
        f7796ae = null;
        f7796ae = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
    }

    public AsyncTaskC2510d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.f7797af = str3;
        this.f7798ag = str4;
        this.signature = str5;
        this.f7799ah = oAuthListener;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ C2511a doInBackground(Void[] voidArr) {
        Log.m4999i("MicroMsg.SDK.GetQRCodeTask", "external storage available = false");
        String format = String.format(f7796ae, this.appId, this.f7797af, this.f7798ag, this.scope, this.signature);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] m5008h = C2512e.m5008h(format);
        Log.m5001d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return C2511a.m5009c(m5008h);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(C2511a c2511a) {
        C2511a c2511a2 = c2511a;
        if (c2511a2.f7801aj != OAuthErrCode.WechatAuth_Err_OK) {
            Log.m5000e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", c2511a2.f7801aj));
            this.f7799ah.onAuthFinish(c2511a2.f7801aj, null);
            return;
        }
        Log.m5001d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success");
        this.f7799ah.onAuthGotQrcode(c2511a2.f7804am, c2511a2.f7807ap);
        this.f7800ai = new AsyncTaskC2513f(c2511a2.f7802ak, this.f7799ah);
        AsyncTaskC2513f asyncTaskC2513f = this.f7800ai;
        if (Build.VERSION.SDK_INT >= 11) {
            asyncTaskC2513f.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            asyncTaskC2513f.execute(new Void[0]);
        }
    }

    /* renamed from: q */
    public final boolean m5010q() {
        Log.m4999i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        AsyncTaskC2513f asyncTaskC2513f = this.f7800ai;
        return asyncTaskC2513f == null ? cancel(true) : asyncTaskC2513f.cancel(true);
    }
}
