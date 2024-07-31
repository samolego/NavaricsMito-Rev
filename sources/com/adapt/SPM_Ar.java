package com.adapt;

import com.hwfit.common.StatisticsInfo;
import com.jnilib.CppSDKConnectors;
import com.p035dg.ConfigManager;
import com.p035dg.SpSdkDirectory;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public class SPM_Ar {
    private int cnt = 0;

    public int GetLocalInfo(byte[] bArr) {
        return CppSDKConnectors.GetLocalInfo(bArr);
    }

    public int GetArData(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int GetArData = CppSDKConnectors.GetArData(bArr);
        StatisticsInfo.ArU3DGetRate += GetArData;
        if (GetArData > 0 && ConfigManager.GetInstance().getConfig().isArKitRelSaveToFile()) {
            try {
                File file = new File(SpSdkDirectory.arRelFoldrt, "AR_R" + this.cnt + "_" + GetArData + ".bin");
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bArr, 0, GetArData);
                fileOutputStream.close();
                this.cnt = this.cnt + 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return GetArData;
    }
}
