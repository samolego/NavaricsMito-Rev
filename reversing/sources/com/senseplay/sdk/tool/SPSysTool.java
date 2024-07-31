package com.senseplay.sdk.tool;

import com.senseplay.sdk.log.SPDebug;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
public class SPSysTool {
    private static final String TAG = "SPSysTool";

    public static String readFile(String str) {
        if (SPUtilTool.isNull(str)) {
            return "";
        }
        try {
            return new BufferedReader(new FileReader(str)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean writeFile(String str, String str2) {
        if (SPUtilTool.isNull(str) || SPUtilTool.isNull(str2)) {
            return false;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str));
            bufferedWriter.write(str2);
            bufferedWriter.close();
            String str3 = TAG;
            SPDebug.m5815d(str3, "功能已激活 angle " + str);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            String str4 = TAG;
            SPDebug.m5813e(str4, "can't write the " + str);
            return false;
        }
    }

    public static void sendKeyCode(int i) {
        try {
            Runtime.getRuntime().exec("input keyevent " + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
