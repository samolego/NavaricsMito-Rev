package com.p035dg;

import android.os.Environment;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.dg.SpSdkDirectory */
/* loaded from: classes.dex */
public class SpSdkDirectory {
    static DataOutputStream bfw;
    static DataOutputStream h264;
    static DataOutputStream searchFrameH264;
    public static String externalStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String sdkFolder = externalStorage + "/SP_SDK_Temp";
    public static String iniFolder = sdkFolder + "/ini";
    public static String logFolder = sdkFolder + "/log";
    public static String h264Folder = sdkFolder + "/h264";
    public static String escFolder = sdkFolder + "/esc";
    public static String otaFolder = sdkFolder + "/OTA";
    public static String arFolder = sdkFolder + "/AR";
    public static String arRelFoldrt = sdkFolder + "/AR_Rel";
    public static String sdkConfig = sdkFolder + "/Configs";
    public static String binFiles = sdkFolder + "/BIN";
    public static String timerSubDir = "";
    public static String sdkEnvironmentVariableFile = sdkConfig + "/Configs.json";

    public static void folderCreated() {
        timerSubDir = getSysTimerToDirName();
        File file = new File(sdkFolder);
        if (!file.exists() && !file.mkdir()) {
            Log.v("SDK_DIR", sdkFolder + " create not success!");
        }
        File file2 = new File(iniFolder);
        if (!file2.exists() && !file2.mkdir()) {
            Log.v("SDK_DIR", iniFolder + " create not success!");
        }
        File file3 = new File(logFolder);
        if (!file3.exists() && !file3.mkdir()) {
            Log.v("SDK_DIR", logFolder + " create not success!");
        }
        File file4 = new File(escFolder);
        if (!file4.exists() && !file4.mkdir()) {
            Log.v("SDK_DIR", escFolder + " create not success!");
        }
        File file5 = new File(otaFolder);
        if (!file5.exists() && !file5.mkdir()) {
            Log.v("SDK_DIR", otaFolder + " create not success!");
        }
        File file6 = new File(h264Folder);
        if (!file6.exists() && !file6.mkdir()) {
            Log.v("SDK_DIR", h264Folder + " create not success!");
        }
        File file7 = new File(arFolder);
        if (!file7.exists() && !file7.mkdir()) {
            Log.v("SDK_DIR", arFolder + " create not success!");
        }
        File file8 = new File(arRelFoldrt);
        if (!file8.exists() && !file8.mkdir()) {
            Log.v("SDK_DIR", arRelFoldrt + " create not success!");
        }
        File file9 = new File(sdkConfig);
        if (!file9.exists() && !file9.mkdir()) {
            Log.v("SDK_DIR", sdkConfig + " create not success!");
        }
        File file10 = new File(binFiles);
        if (!file10.exists() && !file10.mkdir()) {
            Log.v("SDK_DIR", binFiles + " create not success!");
        }
        arFolder += "/" + timerSubDir;
        arRelFoldrt += "/" + timerSubDir;
        Log.v("II", arFolder);
        Log.v("II", arRelFoldrt);
        File file11 = new File(arFolder);
        if (!file11.exists() && !file11.mkdir()) {
            Log.v("SDK_DIR", arFolder + " create not success!");
        }
        File file12 = new File(arRelFoldrt);
        if (file12.exists() || file12.mkdir()) {
            return;
        }
        Log.v("SDK_DIR", arRelFoldrt + " create not success!");
    }

    public static String getSdkConfigsString() {
        File file = new File(sdkEnvironmentVariableFile);
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                return readLine;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void saveSdkConfigToFile(String str) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(sdkEnvironmentVariableFile, true));
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getSysTimerToDirName() {
        String replace = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString().replace(":", "").replace("-", "").replace(" ", "_");
        return replace.substring(4, replace.length() - 1);
    }

    public static void DumpFile(byte[] bArr, int i) {
        try {
            if (bfw == null) {
                bfw = new DataOutputStream(new FileOutputStream(new File(binFiles + "/ArData.bin")));
            }
            bfw.write(bArr, 0, i);
            bfw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void DumpH264Data(byte[] bArr, int i) {
        try {
            if (h264 == null) {
                h264 = new DataOutputStream(new FileOutputStream(new File(h264Folder + "/video.h264")));
            }
            h264.write(bArr, 0, i);
            h264.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void DumpSearchFrameH264Data(byte[] bArr, int i) {
        try {
            if (searchFrameH264 == null) {
                searchFrameH264 = new DataOutputStream(new FileOutputStream(new File(h264Folder + "/SearchFrame.h264")));
            }
            searchFrameH264.write(bArr, 0, i);
            searchFrameH264.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
