package com.navatics.app.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.navatics.app.R;
import com.tencent.p075mm.opensdk.modelbase.BaseReq;
import com.tencent.p075mm.opensdk.modelbase.BaseResp;
import com.tencent.p075mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.p075mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.p075mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p075mm.opensdk.openapi.IWXAPI;
import com.tencent.p075mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.p075mm.opensdk.openapi.WXAPIFactory;

/* loaded from: classes.dex */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    /* renamed from: a */
    private IWXAPI f5784a;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.wx_entry);
        this.f5784a = WXAPIFactory.createWXAPI(this, getResources().getString(R.string.WX_APP_ID), false);
        try {
            this.f5784a.handleIntent(getIntent(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f5784a.handleIntent(intent, this);
    }

    @Override // com.tencent.p075mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        switch (baseReq.getType()) {
            case 3:
                m6873a();
                return;
            case 4:
                m6872a((ShowMessageFromWX.Req) baseReq);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.p075mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        int i;
        finish();
        Toast.makeText(this, "baseresp.getType = " + baseResp.getType(), 0).show();
        int i2 = baseResp.errCode;
        if (i2 == -2) {
            i = R.string.errcode_cancel;
        } else if (i2 != 0) {
            switch (i2) {
                case BaseResp.ErrCode.ERR_UNSUPPORT /* -5 */:
                    i = R.string.errcode_unsupported;
                    break;
                case -4:
                    i = R.string.errcode_deny;
                    break;
                default:
                    i = R.string.errcode_unknown;
                    break;
            }
        } else {
            i = R.string.errcode_success;
        }
        Toast.makeText(this, i, 1).show();
    }

    /* renamed from: a */
    private void m6873a() {
        Log.d("WXEntryActivity", "goToGetMsg");
    }

    /* renamed from: a */
    private void m6872a(ShowMessageFromWX.Req req) {
        WXMediaMessage wXMediaMessage = req.message;
        WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) wXMediaMessage.mediaObject;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("description: ");
        stringBuffer.append(wXMediaMessage.description);
        stringBuffer.append("\n");
        stringBuffer.append("extInfo: ");
        stringBuffer.append(wXAppExtendObject.extInfo);
        stringBuffer.append("\n");
        stringBuffer.append("filePath: ");
        stringBuffer.append(wXAppExtendObject.filePath);
        Log.d("WXEntryActivity", "goToShowMsg = " + stringBuffer.toString());
    }
}
