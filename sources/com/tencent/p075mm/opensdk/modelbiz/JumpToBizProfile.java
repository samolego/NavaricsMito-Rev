package com.tencent.p075mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.p075mm.opensdk.modelbase.BaseReq;
import com.tencent.p075mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.modelbiz.JumpToBizProfile */
/* loaded from: classes2.dex */
public class JumpToBizProfile {
    public static final int JUMP_TO_HARD_WARE_BIZ_PROFILE = 1;
    public static final int JUMP_TO_NORMAL_BIZ_PROFILE = 0;

    /* renamed from: com.tencent.mm.opensdk.modelbiz.JumpToBizProfile$Req */
    /* loaded from: classes2.dex */
    public static class Req extends BaseReq {
        private static final int EXT_MSG_LENGTH = 1024;
        private static final String TAG = "MicroMsg.SDK.JumpToBizProfile.Req";
        public String extMsg;
        public int profileType = 0;
        public String toUserName;

        @Override // com.tencent.p075mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            String str2;
            String str3;
            String str4 = this.toUserName;
            if (str4 == null || str4.length() == 0) {
                str = TAG;
                str2 = "checkArgs fail, toUserName is invalid";
            } else {
                String str5 = this.extMsg;
                if (str5 != null && str5.length() > 1024) {
                    str = TAG;
                    str2 = "ext msg is not null, while the length exceed 1024 bytes";
                } else if (this.profileType != 1 || ((str3 = this.extMsg) != null && str3.length() != 0)) {
                    return true;
                } else {
                    str = TAG;
                    str2 = "scene is jump to hardware profile, while extmsg is null";
                }
            }
            Log.m5000e(str, str2);
            return false;
        }

        @Override // com.tencent.p075mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.toUserName = bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name");
            this.extMsg = bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg");
        }

        @Override // com.tencent.p075mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 7;
        }

        @Override // com.tencent.p075mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_profile_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_profile_req_ext_msg", this.extMsg);
            bundle.putInt("_wxapi_jump_to_biz_profile_req_scene", 0);
            bundle.putInt("_wxapi_jump_to_biz_profile_req_profile_type", this.profileType);
        }
    }
}
