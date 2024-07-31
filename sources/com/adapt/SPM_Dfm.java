package com.adapt;

import com.common.SP_REQUEST_REL;
import com.common.SP_Util;
import com.jnilib.CppSDKConnectors;
import com.misc.C1514util;

/* loaded from: classes.dex */
public class SPM_Dfm {
    byte[] cid = new byte[7];
    byte[] mRequestSnBuff = new byte[32];

    public int WriteChipID(byte[] bArr) {
        return CppSDKConnectors.DfmWriteChipID(bArr);
    }

    public int GetCidWriteRel() {
        return CppSDKConnectors.DfmGetCidWriteRel();
    }

    public int RequestCid() {
        return CppSDKConnectors.DfmRequestCid();
    }

    public void GetRequestCidRel(byte[] bArr, SP_REQUEST_REL sp_request_rel) {
        if (bArr == null || sp_request_rel == null) {
            return;
        }
        CppSDKConnectors.DfmGetRequestCidRel(this.cid, sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
        int length = bArr.length < sp_request_rel.REL_LEN ? bArr.length : sp_request_rel.REL_LEN;
        sp_request_rel.REL_LEN = (byte) (length & 255);
        if (length >= 0) {
            System.arraycopy(this.cid, 0, bArr, 0, length);
        }
    }

    public int WriteSn(byte[] bArr) {
        byte[] bArr2 = new byte[32];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length < 32 ? bArr.length : 32);
        return CppSDKConnectors.DfmWriteSn(bArr2);
    }

    public int GetSnWriteRel() {
        return CppSDKConnectors.DfmGetSnWriteRel();
    }

    public int RequestSn() {
        return CppSDKConnectors.DfmRequestSn();
    }

    public void GetRequestSnRel(byte[] bArr, SP_REQUEST_REL sp_request_rel) {
        if (bArr == null || sp_request_rel == null) {
            return;
        }
        CppSDKConnectors.DfmGetRequestSnRel(this.mRequestSnBuff, sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
        byte[] validBytes = C1514util.getValidBytes(this.mRequestSnBuff);
        int length = bArr.length < validBytes.length ? bArr.length : validBytes.length;
        sp_request_rel.REL_LEN = (byte) (length & 255);
        System.arraycopy(validBytes, 0, bArr, 0, length);
    }

    public int WriteFlag(int i) {
        return CppSDKConnectors.DfmWriteFlag(SP_Util.intToByteArr(i));
    }

    public int GetWriteFlagRel() {
        return CppSDKConnectors.DfmGetWriteFlagRel();
    }

    public int RequestFlag() {
        return CppSDKConnectors.DfmRequestFlag();
    }

    public void GetRequestFlagRel(byte[] bArr, SP_REQUEST_REL sp_request_rel) {
        if (sp_request_rel == null) {
            return;
        }
        if (bArr == null) {
            sp_request_rel.ERR_CODE = (byte) -2;
            sp_request_rel.REL_LEN = (byte) 0;
            return;
        }
        CppSDKConnectors.DfmGetRequestFlagRel(bArr, sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
    }

    public void dfmSwitch(boolean z) {
        CppSDKConnectors.DfmSwitch(z);
    }

    public int getKeycode(byte[] bArr) {
        return CppSDKConnectors.getKeycode(bArr);
    }

    public int requestMfiState() {
        return CppSDKConnectors.requestMfiState();
    }

    public void GetRequestMfiStateRel(byte[] bArr, SP_REQUEST_REL sp_request_rel) {
        CppSDKConnectors.getRequestMfiStateRel(bArr, sp_request_rel.getBuff());
        sp_request_rel.fill(sp_request_rel.getBuff());
    }
}
