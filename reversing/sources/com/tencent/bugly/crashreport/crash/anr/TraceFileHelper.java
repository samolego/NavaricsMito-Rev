package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.C2499x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$a */
    /* loaded from: classes2.dex */
    public static class C2429a {

        /* renamed from: a */
        public long f7387a;

        /* renamed from: b */
        public String f7388b;

        /* renamed from: c */
        public long f7389c;

        /* renamed from: d */
        public Map<String, String[]> f7390d;
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b */
    /* loaded from: classes2.dex */
    public interface InterfaceC2430b {
        /* renamed from: a */
        boolean mo5380a(long j);

        /* renamed from: a */
        boolean mo5379a(long j, long j2, String str);

        /* renamed from: a */
        boolean mo5378a(String str, int i, String str2, String str3);
    }

    public static C2429a readTargetDumpInfo(final String str, String str2, final boolean z) {
        if (str == null || str2 == null) {
            return null;
        }
        final C2429a c2429a = new C2429a();
        readTraceFile(str2, new InterfaceC2430b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.1
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC2430b
            /* renamed from: a */
            public final boolean mo5378a(String str3, int i, String str4, String str5) {
                C2499x.m5085c("new thread %s", str3);
                if (C2429a.this.f7387a <= 0 || C2429a.this.f7389c <= 0 || C2429a.this.f7388b == null) {
                    return true;
                }
                if (C2429a.this.f7390d == null) {
                    C2429a.this.f7390d = new HashMap();
                }
                Map<String, String[]> map = C2429a.this.f7390d;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                map.put(str3, new String[]{str4, str5, sb.toString()});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC2430b
            /* renamed from: a */
            public final boolean mo5379a(long j, long j2, String str3) {
                C2499x.m5085c("new process %s", str3);
                if (str3.equals(str)) {
                    C2429a c2429a2 = C2429a.this;
                    c2429a2.f7387a = j;
                    c2429a2.f7388b = str3;
                    c2429a2.f7389c = j2;
                    return z;
                }
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC2430b
            /* renamed from: a */
            public final boolean mo5380a(long j) {
                C2499x.m5085c("process end %d", Long.valueOf(j));
                return C2429a.this.f7387a <= 0 || C2429a.this.f7389c <= 0 || C2429a.this.f7388b == null;
            }
        });
        if (c2429a.f7387a <= 0 || c2429a.f7389c <= 0 || c2429a.f7388b == null) {
            return null;
        }
        return c2429a;
    }

    public static C2429a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            C2499x.m5083e("path:%s", str);
            return null;
        }
        final C2429a c2429a = new C2429a();
        readTraceFile(str, new InterfaceC2430b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC2430b
            /* renamed from: a */
            public final boolean mo5378a(String str2, int i, String str3, String str4) {
                C2499x.m5085c("new thread %s", str2);
                if (C2429a.this.f7390d == null) {
                    C2429a.this.f7390d = new HashMap();
                }
                Map<String, String[]> map = C2429a.this.f7390d;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                map.put(str2, new String[]{str3, str4, sb.toString()});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC2430b
            /* renamed from: a */
            public final boolean mo5379a(long j, long j2, String str2) {
                C2499x.m5085c("new process %s", str2);
                C2429a c2429a2 = C2429a.this;
                c2429a2.f7387a = j;
                c2429a2.f7388b = str2;
                c2429a2.f7389c = j2;
                return z;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC2430b
            /* renamed from: a */
            public final boolean mo5380a(long j) {
                C2499x.m5085c("process end %d", Long.valueOf(j));
                return false;
            }
        });
        if (c2429a.f7387a <= 0 || c2429a.f7389c <= 0 || c2429a.f7388b == null) {
            C2499x.m5083e("first dump error %s", c2429a.f7387a + " " + c2429a.f7389c + " " + c2429a.f7388b);
            return null;
        }
        return c2429a;
    }

    public static void readTraceFile(String str, InterfaceC2430b interfaceC2430b) {
        Throwable th;
        BufferedReader bufferedReader;
        if (str == null || interfaceC2430b == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        file.lastModified();
        file.length();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    while (true) {
                        Object[] m5382a = m5382a(bufferedReader, compile);
                        if (m5382a == null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e) {
                                if (C2499x.m5089a(e)) {
                                    return;
                                }
                                e.printStackTrace();
                                return;
                            }
                        }
                        String[] split = m5382a[1].toString().split("\\s");
                        long parseLong = Long.parseLong(split[2]);
                        long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                        Object[] m5382a2 = m5382a(bufferedReader, compile3);
                        if (m5382a2 == null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e2) {
                                if (C2499x.m5089a(e2)) {
                                    return;
                                }
                                e2.printStackTrace();
                                return;
                            }
                        }
                        Matcher matcher = compile3.matcher(m5382a2[1].toString());
                        matcher.find();
                        matcher.group(1);
                        if (!interfaceC2430b.mo5379a(parseLong, time, matcher.group(1))) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e3) {
                                if (C2499x.m5089a(e3)) {
                                    return;
                                }
                                e3.printStackTrace();
                                return;
                            }
                        }
                        while (true) {
                            Object[] m5382a3 = m5382a(bufferedReader, compile4, compile2);
                            if (m5382a3 == null) {
                                break;
                            } else if (m5382a3[0] == compile4) {
                                String obj = m5382a3[1].toString();
                                Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                matcher2.find();
                                String group = matcher2.group();
                                String substring = group.substring(1, group.length() - 1);
                                obj.contains("NATIVE");
                                Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                                matcher3.find();
                                String group2 = matcher3.group();
                                interfaceC2430b.mo5378a(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), m5383a(bufferedReader), m5381b(bufferedReader));
                            } else if (!interfaceC2430b.mo5380a(Long.parseLong(m5382a3[1].toString().split("\\s")[2]))) {
                                try {
                                    bufferedReader.close();
                                    return;
                                } catch (IOException e4) {
                                    if (C2499x.m5089a(e4)) {
                                        return;
                                    }
                                    e4.printStackTrace();
                                    return;
                                }
                            }
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    bufferedReader2 = bufferedReader;
                    if (!C2499x.m5089a(e)) {
                        e.printStackTrace();
                    }
                    C2499x.m5084d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e6) {
                            if (C2499x.m5089a(e6)) {
                                return;
                            }
                            e6.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                            if (!C2499x.m5089a(e7)) {
                                e7.printStackTrace();
                            }
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
            }
        } catch (Exception e8) {
            e = e8;
        }
    }

    /* renamed from: a */
    private static Object[] m5382a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader == null || patternArr == null) {
            return null;
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            for (Pattern pattern : patternArr) {
                if (pattern.matcher(readLine).matches()) {
                    return new Object[]{pattern, readLine};
                }
            }
        }
    }

    /* renamed from: a */
    private static String m5383a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private static String m5381b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }
}
