package com.senseplay.sdk.model.slam;

import android.util.Log;
import com.adapt.SPM_Ar;
import com.adapt.SPM_Manager;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public class SlamThread extends Thread {
    private boolean flag;
    private SlamListener slamListener;
    private final int size = 102400;
    private SPM_Ar spm_ar = SPM_Manager.GetInstance().GetAr();

    /* loaded from: classes2.dex */
    public interface SlamListener {
        void arData(byte[] bArr, int i);

        void slamData(String str, int i);
    }

    public SlamThread() {
        this.flag = false;
        this.flag = true;
    }

    public void setSlamListener(SlamListener slamListener) {
        this.slamListener = slamListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        byte[] bArr = new byte[102400];
        byte[] bArr2 = new byte[102400];
        while (this.flag) {
            int GetArData = this.spm_ar.GetArData(bArr);
            if (GetArData > 0) {
                toArData(bArr, GetArData);
            }
            int GetLocalInfo = this.spm_ar.GetLocalInfo(bArr2);
            if (GetLocalInfo > 0) {
                toSlamData(bArr2, GetLocalInfo);
            }
            try {
                sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void toArData(byte[] bArr, int i) {
        Log.w("arData", "" + bArr);
        Log.w("arData", "" + bArr.length);
        SlamListener slamListener = this.slamListener;
        if (slamListener != null) {
            slamListener.arData(bArr, i);
        }
    }

    private void toSlamData(byte[] bArr, int i) {
        String bytesToString = bytesToString(bArr, i);
        SlamListener slamListener = this.slamListener;
        if (slamListener != null) {
            slamListener.slamData(bytesToString, i);
        }
    }

    private String bytesToString(byte[] bArr, int i) {
        String str;
        try {
            str = new String(bArr, 0, i, "UTF-8");
            try {
                Log.w("arresult", "" + str);
                Log.w("arresult", "" + str.length());
            } catch (UnsupportedEncodingException e) {
                e = e;
                e.printStackTrace();
                return str;
            }
        } catch (UnsupportedEncodingException e2) {
            e = e2;
            str = null;
        }
        return str;
    }

    public void release() {
        this.flag = false;
    }
}
