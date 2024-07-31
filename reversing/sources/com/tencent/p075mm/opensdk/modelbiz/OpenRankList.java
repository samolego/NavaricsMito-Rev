package com.tencent.p075mm.opensdk.modelbiz;

import com.tencent.p075mm.opensdk.modelbase.BaseReq;

/* renamed from: com.tencent.mm.opensdk.modelbiz.OpenRankList */
/* loaded from: classes2.dex */
public class OpenRankList {

    /* renamed from: com.tencent.mm.opensdk.modelbiz.OpenRankList$Req */
    /* loaded from: classes2.dex */
    public static class Req extends BaseReq {
        @Override // com.tencent.p075mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.p075mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 11;
        }
    }
}
