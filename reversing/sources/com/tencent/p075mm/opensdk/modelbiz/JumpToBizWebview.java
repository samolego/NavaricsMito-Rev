package com.tencent.p075mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p075mm.opensdk.modelbase.BaseReq;
import com.tencent.p075mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.JumpToBizWebview */
/* loaded from: classes2.dex */
public final class JumpToBizWebview {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.JumpToBizWebview$Req */
    /* loaded from: classes2.dex */
    public static class Req extends BaseReq {
        private static final int EXT_MSG_LENGTH = 1024;
        private static final String TAG = "MicroMsg.SDK.JumpToBizWebview.Req";
        public String extMsg;
        public int scene = 1;
        public String toUserName;
        public int webType;

        @Override // com.tencent.p075mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            String str2;
            String str3 = this.toUserName;
            if (str3 == null || str3.length() <= 0) {
                str = TAG;
                str2 = "checkArgs fail, toUserName is invalid";
            } else {
                String str4 = this.extMsg;
                if (str4 == null || str4.length() <= 1024) {
                    return true;
                }
                str = TAG;
                str2 = "ext msg is not null, while the length exceed 1024 bytes";
            }
            Log.m5000e(str, str2);
            return false;
        }

        @Override // com.tencent.p075mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 8;
        }

        @Override // com.tencent.p075mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_webview_req_ext_msg", this.extMsg);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_web_type", this.webType);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_scene", this.scene);
        }
    }
}
