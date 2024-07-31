package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.common.info.b */
/* loaded from: classes2.dex */
public class C2420b {

    /* renamed from: a */
    private static final String[] f7281a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* renamed from: b */
    private static final String[] f7282b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: c */
    private static final String[] f7283c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    /* renamed from: d */
    private static String f7284d = null;

    /* renamed from: e */
    private static String f7285e = null;

    /* renamed from: d */
    public static String m5428d() {
        return "null";
    }

    /* renamed from: e */
    public static String m5426e() {
        return "null";
    }

    /* renamed from: f */
    public static String m5424f() {
        return "null";
    }

    /* renamed from: a */
    public static String m5435a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: b */
    public static String m5432b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: c */
    public static int m5430c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public static String m5434a(Context context) {
        String str = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return str == null ? "null" : str.toLowerCase();
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                C2499x.m5090a("Failed to get Android ID.", new Object[0]);
            }
            return str;
        }
    }

    /* renamed from: b */
    public static String m5431b(Context context) {
        String str = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = telephonyManager.getSimSerialNumber();
                return str == null ? "null" : str;
            }
            return "fail";
        } catch (Throwable unused) {
            C2499x.m5090a("Failed to get SIM serial number.", new Object[0]);
            return str;
        }
    }

    /* renamed from: g */
    public static String m5422g() {
        try {
            return Build.SERIAL;
        } catch (Throwable unused) {
            C2499x.m5090a("Failed to get hardware serial number.", new Object[0]);
            return "fail";
        }
    }

    /* renamed from: t */
    private static boolean m5403t() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
        r0 = java.lang.System.getProperty("os.arch");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m5433a(android.content.Context r3, boolean r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L4d
            java.lang.String r4 = "ro.product.cpu.abilist"
            java.lang.String r4 = com.tencent.bugly.proguard.C2503z.m5055a(r3, r4)     // Catch: java.lang.Throwable -> L4b
            boolean r1 = com.tencent.bugly.proguard.C2503z.m5043a(r4)     // Catch: java.lang.Throwable -> L4b
            if (r1 != 0) goto L17
            java.lang.String r1 = "fail"
            boolean r1 = r4.equals(r1)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L1d
        L17:
            java.lang.String r4 = "ro.product.cpu.abi"
            java.lang.String r4 = com.tencent.bugly.proguard.C2503z.m5055a(r3, r4)     // Catch: java.lang.Throwable -> L4b
        L1d:
            boolean r3 = com.tencent.bugly.proguard.C2503z.m5043a(r4)     // Catch: java.lang.Throwable -> L4b
            if (r3 != 0) goto L4d
            java.lang.String r3 = "fail"
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> L4b
            if (r3 == 0) goto L2c
            goto L4d
        L2c:
            java.lang.Class<com.tencent.bugly.crashreport.common.info.b> r3 = com.tencent.bugly.crashreport.common.info.C2420b.class
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b
            java.lang.String r1 = "ABI list: "
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L4b
            r0.append(r4)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L4b
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L4b
            com.tencent.bugly.proguard.C2499x.m5088b(r3, r0, r2)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r3 = ","
            java.lang.String[] r3 = r4.split(r3)     // Catch: java.lang.Throwable -> L4b
            r0 = r3[r1]     // Catch: java.lang.Throwable -> L4b
            goto L4d
        L4b:
            r3 = move-exception
            goto L62
        L4d:
            if (r0 != 0) goto L55
            java.lang.String r3 = "os.arch"
            java.lang.String r0 = java.lang.System.getProperty(r3)     // Catch: java.lang.Throwable -> L4b
        L55:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b
            r3.<init>()     // Catch: java.lang.Throwable -> L4b
            r3.append(r0)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L4b
            return r3
        L62:
            boolean r4 = com.tencent.bugly.proguard.C2499x.m5089a(r3)
            if (r4 != 0) goto L6b
            r3.printStackTrace()
        L6b:
            java.lang.String r3 = "fail"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C2420b.m5433a(android.content.Context, boolean):java.lang.String");
    }

    /* renamed from: h */
    public static long m5420h() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* renamed from: i */
    public static long m5418i() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: j */
    public static long m5416j() {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C2420b.m5416j():long");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: k */
    public static long m5414k() {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C2420b.m5414k():long");
    }

    /* renamed from: l */
    public static long m5412l() {
        if (m5403t()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (C2499x.m5089a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    /* renamed from: m */
    public static long m5410m() {
        if (m5403t()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (C2499x.m5089a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    /* renamed from: n */
    public static String m5409n() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: o */
    public static String m5408o() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: c */
    public static String m5429c(Context context) {
        TelephonyManager telephonyManager;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                return "unknown";
            }
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 4:
                    return "CDMA";
                case 5:
                    return "EVDO_0";
                case 6:
                    return "EVDO_A";
                case 7:
                    return "1xRTT";
                case 8:
                    return "HSDPA";
                case 9:
                    return "HSUPA";
                case 10:
                    return "HSPA";
                case 11:
                    return "iDen";
                case 12:
                    return "EVDO_B";
                case 13:
                    return "LTE";
                case 14:
                    return "eHRPD";
                case 15:
                    return "HSPA+";
                default:
                    return "MOBILE(" + networkType + ")";
            }
        } catch (Exception e) {
            if (C2499x.m5089a(e)) {
                return "unknown";
            }
            e.printStackTrace();
            return "unknown";
        }
    }

    /* renamed from: d */
    public static String m5427d(Context context) {
        String m5055a = C2503z.m5055a(context, "ro.miui.ui.version.name");
        if (!C2503z.m5043a(m5055a) && !m5055a.equals("fail")) {
            return "XiaoMi/MIUI/" + m5055a;
        }
        String m5055a2 = C2503z.m5055a(context, "ro.build.version.emui");
        if (!C2503z.m5043a(m5055a2) && !m5055a2.equals("fail")) {
            return "HuaWei/EMOTION/" + m5055a2;
        }
        String m5055a3 = C2503z.m5055a(context, "ro.lenovo.series");
        if (!C2503z.m5043a(m5055a3) && !m5055a3.equals("fail")) {
            String m5055a4 = C2503z.m5055a(context, "ro.build.version.incremental");
            return "Lenovo/VIBE/" + m5055a4;
        }
        String m5055a5 = C2503z.m5055a(context, "ro.build.nubia.rom.name");
        if (!C2503z.m5043a(m5055a5) && !m5055a5.equals("fail")) {
            return "Zte/NUBIA/" + m5055a5 + "_" + C2503z.m5055a(context, "ro.build.nubia.rom.code");
        }
        String m5055a6 = C2503z.m5055a(context, "ro.meizu.product.model");
        if (!C2503z.m5043a(m5055a6) && !m5055a6.equals("fail")) {
            return "Meizu/FLYME/" + C2503z.m5055a(context, "ro.build.display.id");
        }
        String m5055a7 = C2503z.m5055a(context, "ro.build.version.opporom");
        if (!C2503z.m5043a(m5055a7) && !m5055a7.equals("fail")) {
            return "Oppo/COLOROS/" + m5055a7;
        }
        String m5055a8 = C2503z.m5055a(context, "ro.vivo.os.build.display.id");
        if (!C2503z.m5043a(m5055a8) && !m5055a8.equals("fail")) {
            return "vivo/FUNTOUCH/" + m5055a8;
        }
        String m5055a9 = C2503z.m5055a(context, "ro.aa.romver");
        if (!C2503z.m5043a(m5055a9) && !m5055a9.equals("fail")) {
            return "htc/" + m5055a9 + "/" + C2503z.m5055a(context, "ro.build.description");
        }
        String m5055a10 = C2503z.m5055a(context, "ro.lewa.version");
        if (!C2503z.m5043a(m5055a10) && !m5055a10.equals("fail")) {
            return "tcl/" + m5055a10 + "/" + C2503z.m5055a(context, "ro.build.display.id");
        }
        String m5055a11 = C2503z.m5055a(context, "ro.gn.gnromvernumber");
        if (!C2503z.m5043a(m5055a11) && !m5055a11.equals("fail")) {
            return "amigo/" + m5055a11 + "/" + C2503z.m5055a(context, "ro.build.display.id");
        }
        String m5055a12 = C2503z.m5055a(context, "ro.build.tyd.kbstyle_version");
        if (!C2503z.m5043a(m5055a12) && !m5055a12.equals("fail")) {
            return "dido/" + m5055a12;
        }
        return C2503z.m5055a(context, "ro.build.fingerprint") + "/" + C2503z.m5055a(context, "ro.build.rom.id");
    }

    /* renamed from: e */
    public static String m5425e(Context context) {
        return C2503z.m5055a(context, "ro.board.platform");
    }

    /* renamed from: p */
    public static boolean m5407p() {
        boolean z;
        String[] strArr = f7281a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (new File(strArr[i]).exists()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        return (Build.TAGS != null && Build.TAGS.contains("test-keys")) || z;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: q */
    public static java.lang.String m5406q() {
        /*
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La7
            r1.<init>()     // Catch: java.lang.Throwable -> La7
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "/sys/block/mmcblk0/device/type"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> La7
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> La7
            if (r2 == 0) goto L2c
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> La7
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = "/sys/block/mmcblk0/device/type"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> La7
            r2.<init>(r3)     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = r2.readLine()     // Catch: java.lang.Throwable -> L95
            if (r3 == 0) goto L28
            r1.append(r3)     // Catch: java.lang.Throwable -> L95
        L28:
            r2.close()     // Catch: java.lang.Throwable -> L95
            goto L2d
        L2c:
            r2 = r0
        L2d:
            java.lang.String r3 = ","
            r1.append(r3)     // Catch: java.lang.Throwable -> L95
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L95
            java.lang.String r4 = "/sys/block/mmcblk0/device/name"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L95
            boolean r3 = r3.exists()     // Catch: java.lang.Throwable -> L95
            if (r3 == 0) goto L5e
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L95
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L95
            java.lang.String r5 = "/sys/block/mmcblk0/device/name"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L95
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L95
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L5c
            if (r2 == 0) goto L54
            r1.append(r2)     // Catch: java.lang.Throwable -> L5c
        L54:
            r3.close()     // Catch: java.lang.Throwable -> L5c
            r2 = r3
            goto L5e
        L59:
            r0 = move-exception
            r2 = r3
            goto L9c
        L5c:
            r2 = r3
            goto La8
        L5e:
            java.lang.String r3 = ","
            r1.append(r3)     // Catch: java.lang.Throwable -> L95
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L95
            java.lang.String r4 = "/sys/block/mmcblk0/device/cid"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L95
            boolean r3 = r3.exists()     // Catch: java.lang.Throwable -> L95
            if (r3 == 0) goto L86
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L95
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L95
            java.lang.String r5 = "/sys/block/mmcblk0/device/cid"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L95
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L95
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L5c
            if (r2 == 0) goto L85
            r1.append(r2)     // Catch: java.lang.Throwable -> L5c
        L85:
            r2 = r3
        L86:
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L95
            if (r2 == 0) goto L94
            r2.close()     // Catch: java.io.IOException -> L90
            goto L94
        L90:
            r1 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r1)
        L94:
            return r0
        L95:
            goto La8
        L97:
            r0 = move-exception
            goto L9c
        L99:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L9c:
            if (r2 == 0) goto La6
            r2.close()     // Catch: java.io.IOException -> La2
            goto La6
        La2:
            r1 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r1)
        La6:
            throw r0
        La7:
            r2 = r0
        La8:
            if (r2 == 0) goto Lb2
            r2.close()     // Catch: java.io.IOException -> Lae
            goto Lb2
        Lae:
            r1 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r1)
        Lb2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C2420b.m5406q():java.lang.String");
    }

    /* renamed from: f */
    public static String m5423f(Context context) {
        StringBuilder sb = new StringBuilder();
        String m5055a = C2503z.m5055a(context, "ro.genymotion.version");
        if (m5055a != null) {
            sb.append("ro.genymotion.version");
            sb.append("|");
            sb.append(m5055a);
            sb.append("\n");
        }
        String m5055a2 = C2503z.m5055a(context, "androVM.vbox_dpi");
        if (m5055a2 != null) {
            sb.append("androVM.vbox_dpi");
            sb.append("|");
            sb.append(m5055a2);
            sb.append("\n");
        }
        String m5055a3 = C2503z.m5055a(context, "qemu.sf.fake_camera");
        if (m5055a3 != null) {
            sb.append("qemu.sf.fake_camera");
            sb.append("|");
            sb.append(m5055a3);
        }
        return sb.toString();
    }

    /* renamed from: g */
    public static String m5421g(Context context) {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        StringBuilder sb = new StringBuilder();
        if (f7284d == null) {
            f7284d = C2503z.m5055a(context, "ro.secure");
        }
        if (f7284d != null) {
            sb.append("ro.secure");
            sb.append("|");
            sb.append(f7284d);
            sb.append("\n");
        }
        if (f7285e == null) {
            f7285e = C2503z.m5055a(context, "ro.debuggable");
        }
        if (f7285e != null) {
            sb.append("ro.debuggable");
            sb.append("|");
            sb.append(f7285e);
            sb.append("\n");
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        C2499x.m5089a(th);
                        return sb.toString();
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                C2499x.m5089a(e);
                            }
                        }
                    }
                }
            } while (!readLine.startsWith("TracerPid:"));
            if (readLine != null) {
                String trim = readLine.substring(10).trim();
                sb.append("tracer_pid");
                sb.append("|");
                sb.append(trim);
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                C2499x.m5089a(e2);
            }
            return sb2;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: r */
    public static java.lang.String m5405r() {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> Lae
            java.lang.String r3 = "/sys/class/power_supply/ac/online"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lae
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> Lae
            if (r2 == 0) goto L3e
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lae
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> Lae
            java.lang.String r4 = "/sys/class/power_supply/ac/online"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lae
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L32
            java.lang.String r3 = "ac_online"
            r0.append(r3)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "|"
            r0.append(r3)     // Catch: java.lang.Throwable -> L3b
            r0.append(r1)     // Catch: java.lang.Throwable -> L3b
        L32:
            r2.close()     // Catch: java.lang.Throwable -> L3b
            r1 = r2
            goto L3e
        L37:
            r0 = move-exception
            r1 = r2
            goto Lb1
        L3b:
            r1 = r2
            goto Lbc
        L3e:
            java.lang.String r2 = "\n"
            r0.append(r2)     // Catch: java.lang.Throwable -> Lae
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> Lae
            java.lang.String r3 = "/sys/class/power_supply/usb/online"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lae
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> Lae
            if (r2 == 0) goto L73
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lae
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> Lae
            java.lang.String r4 = "/sys/class/power_supply/usb/online"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lae
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L6f
            java.lang.String r3 = "usb_online"
            r0.append(r3)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "|"
            r0.append(r3)     // Catch: java.lang.Throwable -> L3b
            r0.append(r1)     // Catch: java.lang.Throwable -> L3b
        L6f:
            r2.close()     // Catch: java.lang.Throwable -> L3b
            r1 = r2
        L73:
            java.lang.String r2 = "\n"
            r0.append(r2)     // Catch: java.lang.Throwable -> Lae
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> Lae
            java.lang.String r3 = "/sys/class/power_supply/battery/capacity"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lae
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> Lae
            if (r2 == 0) goto La8
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lae
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> Lae
            java.lang.String r4 = "/sys/class/power_supply/battery/capacity"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lae
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto La4
            java.lang.String r3 = "battery_capacity"
            r0.append(r3)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "|"
            r0.append(r3)     // Catch: java.lang.Throwable -> L3b
            r0.append(r1)     // Catch: java.lang.Throwable -> L3b
        La4:
            r2.close()     // Catch: java.lang.Throwable -> L3b
            r1 = r2
        La8:
            if (r1 == 0) goto Lc6
            r1.close()     // Catch: java.io.IOException -> Lc2
            goto Lc6
        Lae:
            goto Lbc
        Lb0:
            r0 = move-exception
        Lb1:
            if (r1 == 0) goto Lbb
            r1.close()     // Catch: java.io.IOException -> Lb7
            goto Lbb
        Lb7:
            r1 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r1)
        Lbb:
            throw r0
        Lbc:
            if (r1 == 0) goto Lc6
            r1.close()     // Catch: java.io.IOException -> Lc2
            goto Lc6
        Lc2:
            r1 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r1)
        Lc6:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.C2420b.m5405r():java.lang.String");
    }

    /* renamed from: h */
    public static String m5419h(Context context) {
        StringBuilder sb = new StringBuilder();
        String m5055a = C2503z.m5055a(context, "gsm.sim.state");
        if (m5055a != null) {
            sb.append("gsm.sim.state");
            sb.append("|");
            sb.append(m5055a);
        }
        sb.append("\n");
        String m5055a2 = C2503z.m5055a(context, "gsm.sim.state2");
        if (m5055a2 != null) {
            sb.append("gsm.sim.state2");
            sb.append("|");
            sb.append(m5055a2);
        }
        return sb.toString();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0030 -> B:35:0x0047). Please submit an issue!!! */
    /* renamed from: s */
    public static long m5404s() {
        float f = 0.0f;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/uptime"));
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        f = ((float) (System.currentTimeMillis() / 1000)) - Float.parseFloat(readLine.split(" ")[0]);
                    }
                    bufferedReader2.close();
                } catch (Throwable unused) {
                    bufferedReader = bufferedReader2;
                    try {
                        C2499x.m5090a("Failed to get boot time of device.", new Object[0]);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return f;
                    } catch (Throwable th) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                C2499x.m5089a(e);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable unused2) {
            }
        } catch (IOException e2) {
            C2499x.m5089a(e2);
        }
        return f;
    }

    /* renamed from: i */
    public static boolean m5417i(Context context) {
        int i;
        if (m5413k(context) == null) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                String[] strArr = f7283c;
                if (i >= strArr.length) {
                    break;
                } else if (i == 0) {
                    i = new File(strArr[i]).exists() ? i + 1 : 0;
                    arrayList.add(Integer.valueOf(i));
                } else {
                    if (!new File(strArr[i]).exists()) {
                    }
                    arrayList.add(Integer.valueOf(i));
                }
            }
            return (arrayList.isEmpty() ? null : arrayList.toString()) != null;
        }
        return true;
    }

    /* renamed from: k */
    private static String m5413k(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = f7282b;
            if (i >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i], 1);
                arrayList.add(Integer.valueOf(i));
            } catch (PackageManager.NameNotFoundException unused) {
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    /* renamed from: j */
    public static boolean m5415j(Context context) {
        return (((m5411l(context) | m5401v()) | m5400w()) | m5402u()) > 0;
    }

    /* renamed from: u */
    private static int m5402u() {
        try {
            Method method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
            return method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy") ? 256 : 0;
        } catch (Exception unused) {
            return 256;
        }
    }

    /* renamed from: l */
    private static int m5411l(Context context) {
        int i;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i = 1;
        } catch (Exception unused) {
            i = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i | 2;
        } catch (Exception unused2) {
            return i;
        }
    }

    /* renamed from: v */
    private static int m5401v() {
        StackTraceElement[] stackTrace;
        try {
            throw new Exception("detect hook");
        } catch (Exception e) {
            int i = 0;
            int i2 = 0;
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("main")) {
                    i |= 4;
                }
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                    i |= 32;
                }
            }
            return i;
        }
    }

    /* renamed from: w */
    private static int m5400w() {
        BufferedReader bufferedReader;
        IOException e;
        UnsupportedEncodingException e2;
        FileNotFoundException e3;
        int i = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    HashSet hashSet = new HashSet();
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/maps"), "utf-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                                hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                            }
                        } catch (FileNotFoundException e4) {
                            e3 = e4;
                            e3.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return i;
                        } catch (UnsupportedEncodingException e5) {
                            e2 = e5;
                            e2.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return i;
                        } catch (IOException e6) {
                            e = e6;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return i;
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (((String) next).toLowerCase().contains("xposed")) {
                            i |= 64;
                        }
                        if (((String) next).contains("com.saurik.substrate")) {
                            i |= 128;
                        }
                    }
                    bufferedReader.close();
                } catch (FileNotFoundException e7) {
                    bufferedReader = null;
                    e3 = e7;
                } catch (UnsupportedEncodingException e8) {
                    bufferedReader = null;
                    e2 = e8;
                } catch (IOException e9) {
                    bufferedReader = null;
                    e = e9;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            return i;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
