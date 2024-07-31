package com.navatics.robot.utils.p065a;

/* renamed from: com.navatics.robot.utils.a.j */
/* loaded from: classes2.dex */
public class PrettyFormatStrategy implements FormatStrategy {

    /* renamed from: a */
    private final int f6740a;

    /* renamed from: b */
    private final int f6741b;

    /* renamed from: c */
    private final boolean f6742c;

    /* renamed from: d */
    private final LogStrategy f6743d;

    /* renamed from: e */
    private final String f6744e;

    private PrettyFormatStrategy(C2154a c2154a) {
        this.f6740a = c2154a.f6745a;
        this.f6741b = c2154a.f6746b;
        this.f6742c = c2154a.f6747c;
        this.f6743d = c2154a.f6748d;
        this.f6744e = c2154a.f6749e;
    }

    /* renamed from: a */
    public static C2154a m5927a() {
        return new C2154a();
    }

    @Override // com.navatics.robot.utils.p065a.FormatStrategy
    /* renamed from: a */
    public void mo5924a(int i, String str, String str2) {
        String m5919b = m5919b(str);
        m5926a(i, m5919b);
        m5925a(i, m5919b, this.f6740a);
        byte[] bytes = str2.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            if (this.f6740a > 0) {
                m5918c(i, m5919b);
            }
            m5920b(i, m5919b, str2);
            m5921b(i, m5919b);
            return;
        }
        if (this.f6740a > 0) {
            m5918c(i, m5919b);
        }
        for (int i2 = 0; i2 < length; i2 += 4000) {
            m5920b(i, m5919b, new String(bytes, i2, Math.min(length - i2, 4000)));
        }
        m5921b(i, m5919b);
    }

    /* renamed from: a */
    private void m5926a(int i, String str) {
        m5917c(i, str, "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    /* renamed from: a */
    private void m5925a(int i, String str, int i2) {
        int i3;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.f6742c) {
            m5917c(i, str, "│ Thread: " + Thread.currentThread().getName());
            m5918c(i, str);
        }
        String str2 = "";
        int m5922a = m5922a(stackTrace) + this.f6741b;
        if (i2 + m5922a > stackTrace.length) {
            i2 = (stackTrace.length - m5922a) - 1;
        }
        while (i2 > 0) {
            if (i2 + m5922a < stackTrace.length) {
                str2 = str2 + "   ";
                m5917c(i, str, "│ " + str2 + m5923a(stackTrace[i3].getClassName()) + "." + stackTrace[i3].getMethodName() + "  (" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ")");
            }
            i2--;
        }
    }

    /* renamed from: b */
    private void m5921b(int i, String str) {
        m5917c(i, str, "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    /* renamed from: c */
    private void m5918c(int i, String str) {
        m5917c(i, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
    }

    /* renamed from: b */
    private void m5920b(int i, String str, String str2) {
        String[] split;
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            m5917c(i, str, "│ " + str3);
        }
    }

    /* renamed from: c */
    private void m5917c(int i, String str, String str2) {
        this.f6743d.mo5942a(i, str, str2);
    }

    /* renamed from: a */
    private String m5923a(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    /* renamed from: a */
    private int m5922a(StackTraceElement[] stackTraceElementArr) {
        for (int i = 5; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(LoggerPrinter.class.getName()) && !className.equals(C2152g.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }

    /* renamed from: b */
    private String m5919b(String str) {
        if (C2155l.m5912a(this.f6744e)) {
            return str;
        }
        if (!C2155l.m5912a(str) && !C2155l.m5911a(this.f6744e, str)) {
            return this.f6744e + "-" + str;
        }
        return this.f6744e;
    }

    /* compiled from: PrettyFormatStrategy.java */
    /* renamed from: com.navatics.robot.utils.a.j$a */
    /* loaded from: classes2.dex */
    public static class C2154a {

        /* renamed from: a */
        int f6745a;

        /* renamed from: b */
        int f6746b;

        /* renamed from: c */
        boolean f6747c;

        /* renamed from: d */
        LogStrategy f6748d;

        /* renamed from: e */
        String f6749e;

        private C2154a() {
            this.f6745a = 2;
            this.f6746b = 0;
            this.f6747c = true;
            this.f6749e = "";
        }

        /* renamed from: a */
        public PrettyFormatStrategy m5916a() {
            if (this.f6748d == null) {
                this.f6748d = new LogcatLogStrategy();
            }
            return new PrettyFormatStrategy(this);
        }
    }
}
