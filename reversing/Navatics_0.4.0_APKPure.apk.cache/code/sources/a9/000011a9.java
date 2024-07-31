package com.google.android.gms.internal;

import com.tencent.bugly.Bugly;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public class zzaqa implements Closeable, Flushable {
    private static final String[] bov = new String[128];
    private static final String[] bow;
    private boolean bkN;
    private boolean bkO;
    private boolean bnY;
    private int[] bog = new int[32];
    private int boh = 0;
    private String box;
    private String boy;
    private final Writer out;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            bov[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = bov;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        bow = (String[]) strArr.clone();
        String[] strArr2 = bow;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public zzaqa(Writer writer) {
        zzagw(6);
        this.separator = ":";
        this.bkN = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    /* renamed from: bL */
    private int m3308bL() {
        int i = this.boh;
        if (i != 0) {
            return this.bog[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* renamed from: bM */
    private void m3309bM() throws IOException {
        if (this.boy != null) {
            m3311bO();
            zzuw(this.boy);
            this.boy = null;
        }
    }

    /* renamed from: bN */
    private void m3310bN() throws IOException {
        if (this.box == null) {
            return;
        }
        this.out.write("\n");
        int i = this.boh;
        for (int i2 = 1; i2 < i; i2++) {
            this.out.write(this.box);
        }
    }

    /* renamed from: bO */
    private void m3311bO() throws IOException {
        int m3308bL = m3308bL();
        if (m3308bL == 5) {
            this.out.write(44);
        } else if (m3308bL != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m3310bN();
        zzagy(4);
    }

    private void zzagw(int i) {
        int i2 = this.boh;
        int[] iArr = this.bog;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.bog = iArr2;
        }
        int[] iArr3 = this.bog;
        int i3 = this.boh;
        this.boh = i3 + 1;
        iArr3[i3] = i;
    }

    private void zzagy(int i) {
        this.bog[this.boh - 1] = i;
    }

    private zzaqa zzc(int i, int i2, String str) throws IOException {
        int m3308bL = m3308bL();
        if (m3308bL != i2 && m3308bL != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        String str2 = this.boy;
        if (str2 != null) {
            String valueOf = String.valueOf(str2);
            throw new IllegalStateException(valueOf.length() != 0 ? "Dangling name: ".concat(valueOf) : new String("Dangling name: "));
        }
        this.boh--;
        if (m3308bL == i2) {
            m3310bN();
        }
        this.out.write(str);
        return this;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    private void zzdj(boolean z) throws IOException {
        int i;
        switch (m3308bL()) {
            case 1:
                zzagy(2);
                m3310bN();
                return;
            case 2:
                this.out.append(',');
                m3310bN();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.out.append((CharSequence) this.separator);
                i = 5;
                zzagy(i);
                return;
            case 7:
                if (!this.bnY) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            case 6:
                if (!this.bnY && !z) {
                    throw new IllegalStateException("JSON must start with an array or an object.");
                }
                i = 7;
                zzagy(i);
                return;
        }
    }

    private zzaqa zzq(int i, String str) throws IOException {
        zzdj(true);
        zzagw(i);
        this.out.write(str);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void zzuw(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.bkO
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.android.gms.internal.zzaqa.bow
            goto L9
        L7:
            java.lang.String[] r0 = com.google.android.gms.internal.zzaqa.bov
        L9:
            java.io.Writer r1 = r7.out
            java.lang.String r2 = "\""
            r1.write(r2)
            int r1 = r8.length()
            r2 = 0
            r3 = 0
        L16:
            if (r2 >= r1) goto L45
            char r4 = r8.charAt(r2)
            r5 = 128(0x80, float:1.8E-43)
            if (r4 >= r5) goto L25
            r4 = r0[r4]
            if (r4 != 0) goto L32
            goto L42
        L25:
            r5 = 8232(0x2028, float:1.1535E-41)
            if (r4 != r5) goto L2c
            java.lang.String r4 = "\\u2028"
            goto L32
        L2c:
            r5 = 8233(0x2029, float:1.1537E-41)
            if (r4 != r5) goto L42
            java.lang.String r4 = "\\u2029"
        L32:
            if (r3 >= r2) goto L3b
            java.io.Writer r5 = r7.out
            int r6 = r2 - r3
            r5.write(r8, r3, r6)
        L3b:
            java.io.Writer r3 = r7.out
            r3.write(r4)
            int r3 = r2 + 1
        L42:
            int r2 = r2 + 1
            goto L16
        L45:
            if (r3 >= r1) goto L4d
            java.io.Writer r0 = r7.out
            int r1 = r1 - r3
            r0.write(r8, r3, r1)
        L4d:
            java.io.Writer r8 = r7.out
            java.lang.String r0 = "\""
            r8.write(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaqa.zzuw(java.lang.String):void");
    }

    /* renamed from: bJ */
    public final boolean m3312bJ() {
        return this.bkO;
    }

    /* renamed from: bK */
    public final boolean m3313bK() {
        return this.bkN;
    }

    /* renamed from: bt */
    public zzaqa mo3292bt() throws IOException {
        m3309bM();
        return zzq(1, "[");
    }

    /* renamed from: bu */
    public zzaqa mo3293bu() throws IOException {
        return zzc(1, 2, "]");
    }

    /* renamed from: bv */
    public zzaqa mo3294bv() throws IOException {
        m3309bM();
        return zzq(3, "{");
    }

    /* renamed from: bw */
    public zzaqa mo3295bw() throws IOException {
        return zzc(3, 5, "}");
    }

    /* renamed from: bx */
    public zzaqa mo3296bx() throws IOException {
        if (this.boy != null) {
            if (!this.bkN) {
                this.boy = null;
                return this;
            }
            m3309bM();
        }
        zzdj(false);
        this.out.write("null");
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.boh;
        if (i > 1 || (i == 1 && this.bog[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.boh = 0;
    }

    public void flush() throws IOException {
        if (this.boh == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    public boolean isLenient() {
        return this.bnY;
    }

    public final void setIndent(String str) {
        String str2;
        if (str.length() == 0) {
            this.box = null;
            str2 = ":";
        } else {
            this.box = str;
            str2 = ": ";
        }
        this.separator = str2;
    }

    public final void setLenient(boolean z) {
        this.bnY = z;
    }

    public zzaqa zza(Number number) throws IOException {
        if (number == null) {
            return mo3296bx();
        }
        m3309bM();
        String obj = number.toString();
        if (this.bnY || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            zzdj(false);
            this.out.append((CharSequence) obj);
            return this;
        }
        String valueOf = String.valueOf(number);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
        sb.append("Numeric values must be finite, but was ");
        sb.append(valueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    public zzaqa zzcu(long j) throws IOException {
        m3309bM();
        zzdj(false);
        this.out.write(Long.toString(j));
        return this;
    }

    public zzaqa zzdf(boolean z) throws IOException {
        m3309bM();
        zzdj(false);
        this.out.write(z ? "true" : Bugly.SDK_IS_DEV);
        return this;
    }

    public final void zzdh(boolean z) {
        this.bkO = z;
    }

    public final void zzdi(boolean z) {
        this.bkN = z;
    }

    public zzaqa zzus(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.boy != null) {
            throw new IllegalStateException();
        }
        if (this.boh == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.boy = str;
        return this;
    }

    public zzaqa zzut(String str) throws IOException {
        if (str == null) {
            return mo3296bx();
        }
        m3309bM();
        zzdj(false);
        zzuw(str);
        return this;
    }
}