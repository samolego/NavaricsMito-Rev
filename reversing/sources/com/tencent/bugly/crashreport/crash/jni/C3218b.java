package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.jni.b */
/* loaded from: classes2.dex */
public final class C2448b {

    /* renamed from: a */
    private static List<File> f7511a = new ArrayList();

    /* renamed from: d */
    private static Map<String, Integer> m5281d(String str) {
        String[] split;
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(",")) {
                String[] split2 = str2.split(":");
                if (split2.length != 2) {
                    C2499x.m5083e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
            }
            return hashMap;
        } catch (Exception e) {
            C2499x.m5083e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static String m5289a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static CrashDetailBean m5291a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        String str;
        String str2;
        String str3;
        String str4;
        HashMap hashMap;
        Map<String, String> map2;
        if (map == null) {
            return null;
        }
        if (C2419a.m5474a(context) == null) {
            C2499x.m5083e("abnormal com info not created", new Object[0]);
            return null;
        }
        String str5 = map.get("intStateStr");
        if (str5 == null || str5.trim().length() <= 0) {
            C2499x.m5083e("no intStateStr", new Object[0]);
            return null;
        }
        Map<String, Integer> m5281d = m5281d(str5);
        if (m5281d == null) {
            C2499x.m5083e("parse intSateMap fail", Integer.valueOf(map.size()));
            return null;
        }
        try {
            m5281d.get("sino").intValue();
            m5281d.get("sud").intValue();
            String str6 = map.get("soVersion");
            if (str6 == null) {
                C2499x.m5083e("error format at version", new Object[0]);
                return null;
            }
            String str7 = map.get("errorAddr");
            if (str7 == null) {
                str7 = "unknown";
            }
            String str8 = str7;
            String str9 = map.get("codeMsg");
            if (str9 == null) {
                str9 = "unknown";
            }
            String str10 = map.get("tombPath");
            if (str10 == null) {
                str10 = "unknown";
            }
            String str11 = str10;
            String str12 = map.get("signalName");
            if (str12 == null) {
                str12 = "unknown";
            }
            map.get("errnoMsg");
            String str13 = map.get("stack");
            if (str13 == null) {
                str13 = "unknown";
            }
            String str14 = map.get("jstack");
            if (str14 != null) {
                str13 = str13 + "java:\n" + str14;
            }
            Integer num = m5281d.get("sico");
            if (num == null || num.intValue() <= 0) {
                str = str9;
                str2 = str12;
            } else {
                str2 = str12 + "(" + str9 + ")";
                str = "KERNEL";
            }
            String str15 = map.get("nativeLog");
            byte[] m5047a = (str15 == null || str15.isEmpty()) ? null : C2503z.m5047a((File) null, str15, "BuglyNativeLog.txt");
            String str16 = map.get("sendingProcess");
            if (str16 == null) {
                str16 = "unknown";
            }
            Integer num2 = m5281d.get("spd");
            if (num2 != null) {
                str3 = str16 + "(" + num2 + ")";
            } else {
                str3 = str16;
            }
            String str17 = map.get("threadName");
            if (str17 == null) {
                str17 = "unknown";
            }
            Integer num3 = m5281d.get("et");
            if (num3 != null) {
                str4 = str17 + "(" + num3 + ")";
            } else {
                str4 = str17;
            }
            String str18 = map.get("processName");
            if (str18 == null) {
                str18 = "unknown";
            }
            Integer num4 = m5281d.get("ep");
            if (num4 != null) {
                str18 = str18 + "(" + num4 + ")";
            }
            String str19 = map.get("key-value");
            if (str19 != null) {
                HashMap hashMap2 = new HashMap();
                String[] split = str19.split("\n");
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String[] split2 = split[i].split("=");
                    String[] strArr = split;
                    if (split2.length == 2) {
                        hashMap2.put(split2[0], split2[1]);
                    }
                    i++;
                    split = strArr;
                }
                hashMap = hashMap2;
            } else {
                hashMap = null;
            }
            CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str18, str4, (m5281d.get("ets").intValue() * 1000) + (m5281d.get("etms").intValue() / 1000), str2, str8, m5289a(str13), str, str3, str11, map.get("sysLogPath"), map.get("jniLogPath"), str6, m5047a, hashMap, false, false);
            if (packageCrashDatas != null) {
                String str20 = map.get("userId");
                if (str20 != null) {
                    C2499x.m5085c("[Native record info] userId: %s", str20);
                    packageCrashDatas.f7362m = str20;
                }
                String str21 = map.get("sysLog");
                if (str21 != null) {
                    packageCrashDatas.f7372w = str21;
                }
                String str22 = map.get("appVersion");
                if (str22 != null) {
                    C2499x.m5085c("[Native record info] appVersion: %s", str22);
                    packageCrashDatas.f7355f = str22;
                }
                String str23 = map.get("isAppForeground");
                if (str23 != null) {
                    C2499x.m5085c("[Native record info] isAppForeground: %s", str23);
                    packageCrashDatas.f7340N = str23.equalsIgnoreCase("true");
                }
                String str24 = map.get("launchTime");
                if (str24 != null) {
                    C2499x.m5085c("[Native record info] launchTime: %s", str24);
                    try {
                        packageCrashDatas.f7339M = Long.parseLong(str24);
                        map2 = null;
                    } catch (NumberFormatException e) {
                        if (C2499x.m5089a(e)) {
                            map2 = null;
                        } else {
                            e.printStackTrace();
                            map2 = null;
                        }
                    }
                } else {
                    map2 = null;
                }
                packageCrashDatas.f7375z = map2;
                packageCrashDatas.f7360k = true;
            }
            return packageCrashDatas;
        } catch (Throwable th) {
            C2499x.m5083e("error format", new Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static String m5290a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bufferedInputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int read = bufferedInputStream.read();
                    if (read == -1) {
                        byteArrayOutputStream.close();
                        break;
                    } else if (read == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    } else {
                        byteArrayOutputStream.write(read);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        C2499x.m5089a(th);
                        return null;
                    } finally {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* renamed from: a */
    public static CrashDetailBean m5292a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        BufferedInputStream bufferedInputStream;
        if (context == null || str == null || nativeExceptionHandler == null) {
            C2499x.m5083e("get eup record file args error", new Object[0]);
            return null;
        }
        File file = new File(str, "rqd_record.eup");
        if (file.exists()) {
            BufferedInputStream canRead = file.canRead();
            try {
                if (canRead != 0) {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    } catch (IOException e) {
                        e = e;
                        bufferedInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        canRead = 0;
                        if (canRead != 0) {
                            try {
                                canRead.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    try {
                        String m5290a = m5290a(bufferedInputStream);
                        if (m5290a != null && m5290a.equals("NATIVE_RQD_REPORT")) {
                            HashMap hashMap = new HashMap();
                            String str2 = null;
                            while (true) {
                                String m5290a2 = m5290a(bufferedInputStream);
                                if (m5290a2 == null) {
                                    break;
                                } else if (str2 == null) {
                                    str2 = m5290a2;
                                } else {
                                    hashMap.put(str2, m5290a2);
                                    str2 = null;
                                }
                            }
                            if (str2 != null) {
                                C2499x.m5083e("record not pair! drop! %s", str2);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                                return null;
                            }
                            CrashDetailBean m5291a = m5291a(context, hashMap, nativeExceptionHandler);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            return m5291a;
                        }
                        C2499x.m5083e("record read fail! %s", m5290a);
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        return null;
                    } catch (IOException e6) {
                        e = e6;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006f, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0074, code lost:
        com.tencent.bugly.proguard.C2499x.m5089a(r9);
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m5284b(java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "reg_record.txt"
            java.io.BufferedReader r9 = com.tencent.bugly.proguard.C2503z.m5041a(r9, r0)
            r0 = 0
            if (r9 != 0) goto La
            return r0
        La:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7a
            r1.<init>()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r2 = r9.readLine()     // Catch: java.lang.Throwable -> L7a
            if (r2 == 0) goto L6d
            boolean r10 = r2.startsWith(r10)     // Catch: java.lang.Throwable -> L7a
            if (r10 != 0) goto L1c
            goto L6d
        L1c:
            java.lang.String r10 = "                "
            r2 = 18
            r3 = 0
            r2 = 0
            r4 = 18
            r5 = 0
        L25:
            java.lang.String r6 = r9.readLine()     // Catch: java.lang.Throwable -> L7a
            if (r6 == 0) goto L59
            int r7 = r2 % 4
            if (r7 != 0) goto L3c
            if (r2 <= 0) goto L36
            java.lang.String r5 = "\n"
            r1.append(r5)     // Catch: java.lang.Throwable -> L7a
        L36:
            java.lang.String r5 = "  "
            r1.append(r5)     // Catch: java.lang.Throwable -> L7a
            goto L4f
        L3c:
            int r7 = r6.length()     // Catch: java.lang.Throwable -> L7a
            r8 = 16
            if (r7 <= r8) goto L46
            r4 = 28
        L46:
            int r5 = r4 - r5
            java.lang.String r5 = r10.substring(r3, r5)     // Catch: java.lang.Throwable -> L7a
            r1.append(r5)     // Catch: java.lang.Throwable -> L7a
        L4f:
            int r5 = r6.length()     // Catch: java.lang.Throwable -> L7a
            r1.append(r6)     // Catch: java.lang.Throwable -> L7a
            int r2 = r2 + 1
            goto L25
        L59:
            java.lang.String r10 = "\n"
            r1.append(r10)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> L7a
            if (r9 == 0) goto L6c
            r9.close()     // Catch: java.lang.Exception -> L68
            goto L6c
        L68:
            r9 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r9)
        L6c:
            return r10
        L6d:
            if (r9 == 0) goto L77
            r9.close()     // Catch: java.lang.Exception -> L73
            goto L77
        L73:
            r9 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r9)
        L77:
            return r0
        L78:
            r10 = move-exception
            goto L89
        L7a:
            r10 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r10)     // Catch: java.lang.Throwable -> L78
            if (r9 == 0) goto L88
            r9.close()     // Catch: java.lang.Exception -> L84
            goto L88
        L84:
            r9 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r9)
        L88:
            return r0
        L89:
            if (r9 == 0) goto L93
            r9.close()     // Catch: java.lang.Exception -> L8f
            goto L93
        L8f:
            r9 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r9)
        L93:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C2448b.m5284b(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
        com.tencent.bugly.proguard.C2499x.m5089a(r3);
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m5282c(java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "map_record.txt"
            java.io.BufferedReader r3 = com.tencent.bugly.proguard.C2503z.m5041a(r3, r0)
            r0 = 0
            if (r3 != 0) goto La
            return r0
        La:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c
            r1.<init>()     // Catch: java.lang.Throwable -> L4c
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L4c
            if (r2 == 0) goto L3f
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Throwable -> L4c
            if (r4 != 0) goto L1c
            goto L3f
        L1c:
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> L4c
            if (r4 == 0) goto L30
            java.lang.String r2 = "  "
            r1.append(r2)     // Catch: java.lang.Throwable -> L4c
            r1.append(r4)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r4 = "\n"
            r1.append(r4)     // Catch: java.lang.Throwable -> L4c
            goto L1c
        L30:
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L4c
            if (r3 == 0) goto L3e
            r3.close()     // Catch: java.lang.Exception -> L3a
            goto L3e
        L3a:
            r3 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r3)
        L3e:
            return r4
        L3f:
            if (r3 == 0) goto L49
            r3.close()     // Catch: java.lang.Exception -> L45
            goto L49
        L45:
            r3 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r3)
        L49:
            return r0
        L4a:
            r4 = move-exception
            goto L5b
        L4c:
            r4 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r4)     // Catch: java.lang.Throwable -> L4a
            if (r3 == 0) goto L5a
            r3.close()     // Catch: java.lang.Exception -> L56
            goto L5a
        L56:
            r3 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r3)
        L5a:
            return r0
        L5b:
            if (r3 == 0) goto L65
            r3.close()     // Catch: java.lang.Exception -> L61
            goto L65
        L61:
            r3 = move-exception
            com.tencent.bugly.proguard.C2499x.m5089a(r3)
        L65:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C2448b.m5282c(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m5287a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String m5284b = m5284b(str, str2);
        if (m5284b != null && !m5284b.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(m5284b);
        }
        String m5282c = m5282c(str, str2);
        if (m5282c != null && !m5282c.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(m5282c);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m5285b(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* renamed from: c */
    public static void m5283c(String str) {
        File[] listFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        C2499x.m5085c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            C2499x.m5089a(th);
        }
    }

    /* renamed from: a */
    public static void m5286a(boolean z, String str) {
        if (str != null) {
            f7511a.add(new File(str, "rqd_record.eup"));
            f7511a.add(new File(str, "reg_record.txt"));
            f7511a.add(new File(str, "map_record.txt"));
            f7511a.add(new File(str, "backup_record.txt"));
            if (z) {
                m5283c(str);
            }
        }
        List<File> list = f7511a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f7511a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                C2499x.m5085c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.String] */
    /* renamed from: a */
    public static String m5288a(String str, int i, String str2, boolean z) {
        BufferedReader bufferedReader = null;
        if (str == null || i <= 0) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            C2499x.m5090a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
            f7511a.add(file);
            C2499x.m5085c("Add this record file to list for cleaning lastly.", new Object[0]);
            if (str2 == null) {
                return C2503z.m5049a(new File(str), i, z);
            }
            String sb = new StringBuilder();
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (Pattern.compile(str2 + "[ ]*:").matcher(readLine).find()) {
                                sb.append(readLine);
                                sb.append("\n");
                            }
                            if (i > 0 && sb.length() > i) {
                                if (z) {
                                    sb.delete(i, sb.length());
                                    break;
                                }
                                sb.delete(0, sb.length() - i);
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            try {
                                C2499x.m5089a(th);
                                sb.append("\n[error:" + th.toString() + "]");
                                String sb2 = sb.toString();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                    sb = sb2;
                                    return sb;
                                }
                                return sb2;
                            } catch (Throwable th2) {
                                BufferedReader bufferedReader3 = bufferedReader;
                                if (bufferedReader3 != null) {
                                    try {
                                        bufferedReader3.close();
                                    } catch (Exception e) {
                                        C2499x.m5089a(e);
                                    }
                                }
                                throw th2;
                            }
                        }
                    }
                    String sb3 = sb.toString();
                    bufferedReader2.close();
                    sb = sb3;
                } catch (Throwable th3) {
                    th = th3;
                }
                return sb;
            } catch (Exception e2) {
                C2499x.m5089a(e2);
                return sb;
            }
        }
        return null;
    }
}
