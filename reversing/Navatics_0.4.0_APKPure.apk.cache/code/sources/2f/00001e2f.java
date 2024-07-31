package com.senseplay.sdk.model.sn;

/* loaded from: classes2.dex */
public class SNData {
    public static SNInfo getSNInfo(String str) {
        SNInfo sNInfo = new SNInfo();
        if (str != null && str.length() >= 13) {
            sNInfo.setManufacturerId(str.substring(0, 2));
            sNInfo.setClassId(str.substring(2, 4));
            sNInfo.setModelId(str.substring(4, 8));
            sNInfo.setBatch(str.substring(8, 13));
            sNInfo.setBatchNum(str.substring(13));
        }
        return sNInfo;
    }
}