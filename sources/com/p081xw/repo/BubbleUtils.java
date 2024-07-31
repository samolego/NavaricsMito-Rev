package com.p081xw.repo;

import android.content.res.Resources;
import android.os.Environment;
import android.util.TypedValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* renamed from: com.xw.repo.BubbleUtils */
/* loaded from: classes2.dex */
class BubbleUtils {
    private static Properties sBuildProperties;
    private static final File BUILD_PROP_FILE = new File(Environment.getRootDirectory(), "build.prop");
    private static final Object sBuildPropertiesLock = new Object();

    BubbleUtils() {
    }

    private static Properties getBuildProperties() {
        FileInputStream fileInputStream;
        synchronized (sBuildPropertiesLock) {
            if (sBuildProperties == null) {
                sBuildProperties = new Properties();
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(BUILD_PROP_FILE);
                        try {
                            sBuildProperties.load(fileInputStream);
                        } catch (IOException e) {
                            e = e;
                            fileInputStream2 = fileInputStream;
                            e.printStackTrace();
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    return sBuildProperties;
                                }
                            }
                            return sBuildProperties;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e4) {
                    e = e4;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    e = e5;
                    e.printStackTrace();
                    return sBuildProperties;
                }
            }
        }
        return sBuildProperties;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isMIUI() {
        return getBuildProperties().containsKey("ro.miui.ui.version.name");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int sp2px(int i) {
        return (int) TypedValue.applyDimension(2, i, Resources.getSystem().getDisplayMetrics());
    }
}
