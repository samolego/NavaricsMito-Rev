package com.tencent.p075mm.opensdk.diffdev.p077a;

import android.os.AsyncTask;
import com.tencent.p075mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p075mm.opensdk.diffdev.OAuthListener;
import com.tencent.p075mm.opensdk.utils.Log;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.f */
/* loaded from: classes2.dex */
final class AsyncTaskC2513f extends AsyncTask<Void, Void, C2514a> {

    /* renamed from: ah */
    private OAuthListener f7808ah;

    /* renamed from: ak */
    private String f7809ak;

    /* renamed from: aq */
    private int f7810aq;
    private String url;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.f$a */
    /* loaded from: classes2.dex */
    static class C2514a {

        /* renamed from: aj */
        public OAuthErrCode f7811aj;

        /* renamed from: ar */
        public String f7812ar;

        /* renamed from: as */
        public int f7813as;

        C2514a() {
        }

        /* renamed from: d */
        public static C2514a m5007d(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String str;
            String str2;
            Object[] objArr;
            OAuthErrCode oAuthErrCode2;
            C2514a c2514a = new C2514a();
            if (bArr == null || bArr.length == 0) {
                Log.m5000e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        c2514a.f7813as = jSONObject.getInt("wx_errcode");
                        Log.m5001d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(c2514a.f7813as)));
                        int i = c2514a.f7813as;
                        if (i == 408) {
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                        } else if (i != 500) {
                            switch (i) {
                                case 402:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Timeout;
                                    break;
                                case 403:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Cancel;
                                    break;
                                case 404:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                                    break;
                                case 405:
                                    c2514a.f7811aj = OAuthErrCode.WechatAuth_Err_OK;
                                    c2514a.f7812ar = jSONObject.getString("wx_code");
                                    break;
                                default:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                    break;
                            }
                            return c2514a;
                        } else {
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                        }
                        c2514a.f7811aj = oAuthErrCode2;
                        return c2514a;
                    } catch (Exception e) {
                        str = "MicroMsg.SDK.NoopingResult";
                        str2 = "parse json fail, ex = %s";
                        objArr = new Object[]{e.getMessage()};
                        Log.m5000e(str, String.format(str2, objArr));
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        c2514a.f7811aj = oAuthErrCode;
                        return c2514a;
                    }
                } catch (Exception e2) {
                    str = "MicroMsg.SDK.NoopingResult";
                    str2 = "parse fail, build String fail, ex = %s";
                    objArr = new Object[]{e2.getMessage()};
                }
            }
            c2514a.f7811aj = oAuthErrCode;
            return c2514a;
        }
    }

    public AsyncTaskC2513f(String str, OAuthListener oAuthListener) {
        this.f7809ak = str;
        this.f7808ah = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ C2514a doInBackground(Void[] voidArr) {
        C2514a c2514a;
        OAuthErrCode oAuthErrCode;
        String str;
        String str2 = this.f7809ak;
        if (str2 == null || str2.length() == 0) {
            Log.m5000e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            c2514a = new C2514a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        } else {
            while (!isCancelled()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.url);
                if (this.f7810aq == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.f7810aq;
                }
                sb.append(str);
                String sb2 = sb.toString();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] m5008h = C2512e.m5008h(sb2);
                long currentTimeMillis2 = System.currentTimeMillis();
                C2514a m5007d = C2514a.m5007d(m5008h);
                Log.m5001d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, m5007d.f7811aj.toString(), Integer.valueOf(m5007d.f7813as), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                if (m5007d.f7811aj != OAuthErrCode.WechatAuth_Err_OK) {
                    Log.m5000e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", m5007d.f7811aj.toString(), Integer.valueOf(m5007d.f7813as)));
                    return m5007d;
                }
                this.f7810aq = m5007d.f7813as;
                if (m5007d.f7813as == EnumC2515g.UUID_SCANED.getCode()) {
                    this.f7808ah.onQrcodeScanned();
                } else if (m5007d.f7813as != EnumC2515g.UUID_KEEP_CONNECT.getCode() && m5007d.f7813as == EnumC2515g.UUID_CONFIRM.getCode()) {
                    if (m5007d.f7812ar == null || m5007d.f7812ar.length() == 0) {
                        Log.m5000e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                        m5007d.f7811aj = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                    return m5007d;
                }
            }
            Log.m4999i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            c2514a = new C2514a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        }
        c2514a.f7811aj = oAuthErrCode;
        return c2514a;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(C2514a c2514a) {
        C2514a c2514a2 = c2514a;
        this.f7808ah.onAuthFinish(c2514a2.f7811aj, c2514a2.f7812ar);
    }
}
