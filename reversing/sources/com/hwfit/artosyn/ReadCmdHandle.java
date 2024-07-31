package com.hwfit.artosyn;

import com.hwfit.common.OTA_Proc;

/* loaded from: classes.dex */
public class ReadCmdHandle {
    private static ReadCmdHandle mInatance;

    private ReadCmdHandle() {
    }

    public static ReadCmdHandle GetInstance() {
        synchronized (OTA_Proc.class) {
            if (mInatance == null) {
                mInatance = new ReadCmdHandle();
            }
        }
        return mInatance;
    }
}
