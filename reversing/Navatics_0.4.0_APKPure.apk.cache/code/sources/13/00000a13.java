package com.adapt;

import android.view.Surface;
import com.jnilib.CppSDKConnectors;

/* loaded from: classes.dex */
public class SPM_NvDecodec {
    private static SPM_NvDecodec mInatance;

    public static SPM_NvDecodec getInstance() {
        synchronized (SPM_NvDecodec.class) {
            if (mInatance == null) {
                mInatance = new SPM_NvDecodec();
            }
        }
        return mInatance;
    }

    public void InitDecodec(int i, int i2, int i3, Surface surface) {
        CppSDKConnectors.initVideoDecodec(i, i2, i3, surface);
    }

    public void pushStreamPkt(int i, byte[] bArr, int i2) {
        CppSDKConnectors.videoPushStreamData(i, bArr, i2);
    }
}