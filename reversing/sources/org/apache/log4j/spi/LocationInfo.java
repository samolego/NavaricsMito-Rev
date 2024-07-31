package org.apache.log4j.spi;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.Method;
import org.apache.log4j.helpers.LogLog;

/* loaded from: classes2.dex */
public class LocationInfo implements Serializable {

    /* renamed from: c */
    private static Method f11275c = null;
    static Class class$java$lang$Throwable = null;

    /* renamed from: d */
    private static Method f11276d = null;

    /* renamed from: e */
    private static Method f11277e = null;

    /* renamed from: f */
    private static Method f11278f = null;

    /* renamed from: g */
    private static Method f11279g = null;
    static boolean inVisualAge = false;
    static final long serialVersionUID = -1325822038990805636L;
    transient String className;
    transient String fileName;
    public String fullInfo;
    transient String lineNumber;
    transient String methodName;

    /* renamed from: a */
    private static StringWriter f11273a = new StringWriter();

    /* renamed from: b */
    private static PrintWriter f11274b = new PrintWriter(f11273a);

    /* renamed from: NA */
    public static final String f11272NA = "?";
    public static final LocationInfo NA_LOCATION_INFO = new LocationInfo(f11272NA, f11272NA, f11272NA, f11272NA);

    static {
        Class cls;
        inVisualAge = false;
        try {
            inVisualAge = Class.forName("com.ibm.uvm.tools.DebugSupport") != null;
            LogLog.m1600a("Detected IBM VisualAge environment.");
        } catch (Throwable unused) {
        }
        try {
            if (class$java$lang$Throwable == null) {
                cls = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls;
            } else {
                cls = class$java$lang$Throwable;
            }
            f11275c = cls.getMethod("getStackTrace", null);
            Class<?> cls2 = Class.forName("java.lang.StackTraceElement");
            f11276d = cls2.getMethod("getClassName", null);
            f11277e = cls2.getMethod("getMethodName", null);
            f11278f = cls2.getMethod("getFileName", null);
            f11279g = cls2.getMethod("getLineNumber", null);
        } catch (ClassNotFoundException unused2) {
            LogLog.m1600a("LocationInfo will use pre-JDK 1.4 methods to determine location.");
        } catch (NoSuchMethodException unused3) {
            LogLog.m1600a("LocationInfo will use pre-JDK 1.4 methods to determine location.");
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0124, code lost:
        if (r8 != (-1)) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LocationInfo(java.lang.Throwable r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.log4j.spi.LocationInfo.<init>(java.lang.Throwable, java.lang.String):void");
    }

    /* renamed from: a */
    private static final void m1526a(StringBuffer stringBuffer, String str) {
        if (str == null) {
            stringBuffer.append(f11272NA);
        } else {
            stringBuffer.append(str);
        }
    }

    public LocationInfo(String str, String str2, String str3, String str4) {
        this.fileName = str;
        this.className = str2;
        this.methodName = str3;
        this.lineNumber = str4;
        StringBuffer stringBuffer = new StringBuffer();
        m1526a(stringBuffer, str2);
        stringBuffer.append(".");
        m1526a(stringBuffer, str3);
        stringBuffer.append("(");
        m1526a(stringBuffer, str);
        stringBuffer.append(":");
        m1526a(stringBuffer, str4);
        stringBuffer.append(")");
        this.fullInfo = stringBuffer.toString();
    }

    public String getClassName() {
        String str = this.fullInfo;
        if (str == null) {
            return f11272NA;
        }
        if (this.className == null) {
            int lastIndexOf = str.lastIndexOf(40);
            if (lastIndexOf == -1) {
                this.className = f11272NA;
            } else {
                int lastIndexOf2 = this.fullInfo.lastIndexOf(46, lastIndexOf);
                int lastIndexOf3 = inVisualAge ? this.fullInfo.lastIndexOf(32, lastIndexOf2) + 1 : 0;
                if (lastIndexOf2 == -1) {
                    this.className = f11272NA;
                } else {
                    this.className = this.fullInfo.substring(lastIndexOf3, lastIndexOf2);
                }
            }
        }
        return this.className;
    }

    public String getFileName() {
        String str = this.fullInfo;
        if (str == null) {
            return f11272NA;
        }
        if (this.fileName == null) {
            int lastIndexOf = str.lastIndexOf(58);
            if (lastIndexOf == -1) {
                this.fileName = f11272NA;
            } else {
                this.fileName = this.fullInfo.substring(this.fullInfo.lastIndexOf(40, lastIndexOf - 1) + 1, lastIndexOf);
            }
        }
        return this.fileName;
    }

    public String getLineNumber() {
        String str = this.fullInfo;
        if (str == null) {
            return f11272NA;
        }
        if (this.lineNumber == null) {
            int lastIndexOf = str.lastIndexOf(41);
            int lastIndexOf2 = this.fullInfo.lastIndexOf(58, lastIndexOf - 1);
            if (lastIndexOf2 == -1) {
                this.lineNumber = f11272NA;
            } else {
                this.lineNumber = this.fullInfo.substring(lastIndexOf2 + 1, lastIndexOf);
            }
        }
        return this.lineNumber;
    }

    public String getMethodName() {
        String str = this.fullInfo;
        if (str == null) {
            return f11272NA;
        }
        if (this.methodName == null) {
            int lastIndexOf = str.lastIndexOf(40);
            int lastIndexOf2 = this.fullInfo.lastIndexOf(46, lastIndexOf);
            if (lastIndexOf2 == -1) {
                this.methodName = f11272NA;
            } else {
                this.methodName = this.fullInfo.substring(lastIndexOf2 + 1, lastIndexOf);
            }
        }
        return this.methodName;
    }
}
