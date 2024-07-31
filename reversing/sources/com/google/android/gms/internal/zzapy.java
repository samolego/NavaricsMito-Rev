package com.google.android.gms.internal;

import com.senseplay.sdk.tool.IniEditor;
import com.tencent.bugly.BUGLY;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;

/* loaded from: classes.dex */
public class zzapy implements Closeable {
    private static final char[] bnX = ")]}'\n".toCharArray();
    private long bod;
    private int boe;
    private String bof;
    private int boh;
    private String[] boi;
    private int[] boj;

    /* renamed from: in */
    private final Reader f3072in;
    private boolean bnY = false;
    private final char[] bnZ = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int boa = 0;
    private int bob = 0;
    private int boc = 0;
    private int[] bog = new int[32];

    static {
        zzapd.blQ = new zzapd() { // from class: com.google.android.gms.internal.zzapy.1
            @Override // com.google.android.gms.internal.zzapd
            public void zzi(zzapy zzapyVar) throws IOException {
                int i;
                if (zzapyVar instanceof zzapo) {
                    ((zzapo) zzapyVar).m9641bq();
                    return;
                }
                int i2 = zzapyVar.boc;
                if (i2 == 0) {
                    i2 = zzapyVar.m9636bA();
                }
                if (i2 == 13) {
                    i = 9;
                } else if (i2 == 12) {
                    i = 8;
                } else if (i2 != 14) {
                    String valueOf = String.valueOf(zzapyVar.mo9627bn());
                    int lineNumber = zzapyVar.getLineNumber();
                    int columnNumber = zzapyVar.getColumnNumber();
                    String path = zzapyVar.getPath();
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 70 + String.valueOf(path).length());
                    sb.append("Expected a name but was ");
                    sb.append(valueOf);
                    sb.append(" ");
                    sb.append(" at line ");
                    sb.append(lineNumber);
                    sb.append(" column ");
                    sb.append(columnNumber);
                    sb.append(" path ");
                    sb.append(path);
                    throw new IllegalStateException(sb.toString());
                } else {
                    i = 10;
                }
                zzapyVar.boc = i;
            }
        };
    }

    public zzapy(Reader reader) {
        this.boh = 0;
        int[] iArr = this.bog;
        int i = this.boh;
        this.boh = i + 1;
        iArr[i] = 6;
        this.boi = new String[32];
        this.boj = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f3072in = reader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bA */
    public int m9636bA() throws IOException {
        int i;
        int zzdg;
        int[] iArr = this.bog;
        int i2 = this.boh;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 != 2) {
            if (i3 == 3 || i3 == 5) {
                this.bog[this.boh - 1] = 4;
                if (i3 == 5 && (zzdg = zzdg(true)) != 44) {
                    if (zzdg != 59) {
                        if (zzdg == 125) {
                            this.boc = 2;
                            return 2;
                        }
                        throw zzuv("Unterminated object");
                    }
                    m9631bF();
                }
                int zzdg2 = zzdg(true);
                if (zzdg2 == 34) {
                    i = 13;
                } else if (zzdg2 == 39) {
                    m9631bF();
                    i = 12;
                } else if (zzdg2 == 125) {
                    if (i3 != 5) {
                        this.boc = 2;
                        return 2;
                    }
                    throw zzuv("Expected name");
                } else {
                    m9631bF();
                    this.pos--;
                    if (!zze((char) zzdg2)) {
                        throw zzuv("Expected name");
                    }
                    i = 14;
                }
            } else if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int zzdg3 = zzdg(true);
                if (zzdg3 != 58) {
                    if (zzdg3 != 61) {
                        throw zzuv("Expected ':'");
                    }
                    m9631bF();
                    if (this.pos < this.limit || zzagx(1)) {
                        char[] cArr = this.bnZ;
                        int i4 = this.pos;
                        if (cArr[i4] == '>') {
                            this.pos = i4 + 1;
                        }
                    }
                }
            } else if (i3 == 6) {
                if (this.bnY) {
                    m9628bI();
                }
                this.bog[this.boh - 1] = 7;
            } else if (i3 == 7) {
                if (zzdg(false) == -1) {
                    i = 17;
                } else {
                    m9631bF();
                    this.pos--;
                }
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            this.boc = i;
            return i;
        } else {
            int zzdg4 = zzdg(true);
            if (zzdg4 != 44) {
                if (zzdg4 != 59) {
                    if (zzdg4 == 93) {
                        this.boc = 4;
                        return 4;
                    }
                    throw zzuv("Unterminated array");
                }
                m9631bF();
            }
        }
        int zzdg5 = zzdg(true);
        if (zzdg5 != 34) {
            if (zzdg5 == 39) {
                m9631bF();
                this.boc = 8;
                return 8;
            }
            if (zzdg5 != 44 && zzdg5 != 59) {
                if (zzdg5 == 91) {
                    this.boc = 3;
                    return 3;
                } else if (zzdg5 != 93) {
                    if (zzdg5 == 123) {
                        this.boc = 1;
                        return 1;
                    }
                    this.pos--;
                    if (this.boh == 1) {
                        m9631bF();
                    }
                    int m9635bB = m9635bB();
                    if (m9635bB != 0) {
                        return m9635bB;
                    }
                    int m9634bC = m9634bC();
                    if (m9634bC != 0) {
                        return m9634bC;
                    }
                    if (!zze(this.bnZ[this.pos])) {
                        throw zzuv("Expected value");
                    }
                    m9631bF();
                    i = 10;
                } else if (i3 == 1) {
                    this.boc = 4;
                    return 4;
                }
            }
            if (i3 == 1 || i3 == 2) {
                m9631bF();
                this.pos--;
                this.boc = 7;
                return 7;
            }
            throw zzuv("Unexpected value");
        }
        if (this.boh == 1) {
            m9631bF();
        }
        i = 9;
        this.boc = i;
        return i;
    }

    /* renamed from: bB */
    private int m9635bB() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.bnZ[this.pos];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = BUGLY.SDK_IS_DEV;
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.pos + i2 >= this.limit && !zzagx(i2 + 1)) {
                return 0;
            }
            char c2 = this.bnZ[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || zzagx(length + 1)) && zze(this.bnZ[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.boc = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0097, code lost:
        if (zze(r14) != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0099, code lost:
        if (r9 != 2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009b, code lost:
        if (r10 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a3, code lost:
        if (r13 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a5, code lost:
        if (r13 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a8, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a9, code lost:
        r18.bod = r11;
        r18.pos += r3;
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b2, code lost:
        r18.boc = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b4, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b5, code lost:
        if (r9 == 2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b8, code lost:
        if (r9 == 4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00bb, code lost:
        if (r9 != 7) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00be, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c0, code lost:
        r18.boe = r3;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c5, code lost:
        return 0;
     */
    /* renamed from: bC */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m9634bC() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzapy.m9634bC():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
        r0 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /* renamed from: bD */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m9633bD() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            r2 = r1
        L3:
            r1 = 0
        L4:
            int r3 = r6.pos
            int r4 = r3 + r1
            int r5 = r6.limit
            if (r4 >= r5) goto L1b
            char[] r4 = r6.bnZ
            int r3 = r3 + r1
            char r3 = r4[r3]
            switch(r3) {
                case 9: goto L29;
                case 10: goto L29;
                case 12: goto L29;
                case 13: goto L29;
                case 32: goto L29;
                case 35: goto L17;
                case 44: goto L29;
                case 47: goto L17;
                case 58: goto L29;
                case 59: goto L17;
                case 61: goto L17;
                case 91: goto L29;
                case 92: goto L17;
                case 93: goto L29;
                case 123: goto L29;
                case 125: goto L29;
                default: goto L14;
            }
        L14:
            int r1 = r1 + 1
            goto L4
        L17:
            r6.m9631bF()
            goto L29
        L1b:
            char[] r3 = r6.bnZ
            int r3 = r3.length
            if (r1 >= r3) goto L2b
            int r3 = r1 + 1
            boolean r3 = r6.zzagx(r3)
            if (r3 == 0) goto L29
            goto L4
        L29:
            r0 = r1
            goto L45
        L2b:
            if (r2 != 0) goto L32
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L32:
            char[] r3 = r6.bnZ
            int r4 = r6.pos
            r2.append(r3, r4, r1)
            int r3 = r6.pos
            int r3 = r3 + r1
            r6.pos = r3
            r1 = 1
            boolean r1 = r6.zzagx(r1)
            if (r1 != 0) goto L3
        L45:
            if (r2 != 0) goto L51
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.bnZ
            int r3 = r6.pos
            r1.<init>(r2, r3, r0)
            goto L5c
        L51:
            char[] r1 = r6.bnZ
            int r3 = r6.pos
            r2.append(r1, r3, r0)
            java.lang.String r1 = r2.toString()
        L5c:
            int r2 = r6.pos
            int r2 = r2 + r0
            r6.pos = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzapy.m9633bD():java.lang.String");
    }

    /* renamed from: bE */
    private void m9632bE() throws IOException {
        do {
            int i = 0;
            while (true) {
                int i2 = this.pos;
                if (i2 + i < this.limit) {
                    switch (this.bnZ[i2 + i]) {
                        case '\t':
                        case '\n':
                        case '\f':
                        case '\r':
                        case ' ':
                        case ',':
                        case ':':
                        case '[':
                        case ']':
                        case '{':
                        case '}':
                            break;
                        case '#':
                        case '/':
                        case ';':
                        case '=':
                        case '\\':
                            m9631bF();
                            break;
                        default:
                            i++;
                    }
                } else {
                    this.pos = i2 + i;
                }
            }
            this.pos += i;
            return;
        } while (zzagx(1));
    }

    /* renamed from: bF */
    private void m9631bF() throws IOException {
        if (!this.bnY) {
            throw zzuv("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: bG */
    private void m9630bG() throws IOException {
        char c;
        do {
            if (this.pos >= this.limit && !zzagx(1)) {
                return;
            }
            char[] cArr = this.bnZ;
            int i = this.pos;
            this.pos = i + 1;
            c = cArr[i];
            if (c == '\n') {
                this.boa++;
                this.bob = this.pos;
                return;
            }
        } while (c != '\r');
    }

    /* renamed from: bH */
    private char m9629bH() throws IOException {
        int i;
        int i2;
        if (this.pos != this.limit || zzagx(1)) {
            char[] cArr = this.bnZ;
            int i3 = this.pos;
            this.pos = i3 + 1;
            char c = cArr[i3];
            if (c != '\n') {
                if (c != 'b') {
                    if (c != 'f') {
                        if (c != 'n') {
                            if (c != 'r') {
                                switch (c) {
                                    case 't':
                                        return '\t';
                                    case 'u':
                                        if (this.pos + 4 <= this.limit || zzagx(4)) {
                                            char c2 = 0;
                                            int i4 = this.pos;
                                            int i5 = i4 + 4;
                                            while (i4 < i5) {
                                                char c3 = this.bnZ[i4];
                                                char c4 = (char) (c2 << 4);
                                                if (c3 < '0' || c3 > '9') {
                                                    if (c3 >= 'a' && c3 <= 'f') {
                                                        i = c3 - 'a';
                                                    } else if (c3 < 'A' || c3 > 'F') {
                                                        String valueOf = String.valueOf(new String(this.bnZ, this.pos, 4));
                                                        throw new NumberFormatException(valueOf.length() != 0 ? "\\u".concat(valueOf) : new String("\\u"));
                                                    } else {
                                                        i = c3 - 'A';
                                                    }
                                                    i2 = i + 10;
                                                } else {
                                                    i2 = c3 - '0';
                                                }
                                                c2 = (char) (c4 + i2);
                                                i4++;
                                            }
                                            this.pos += 4;
                                            return c2;
                                        }
                                        throw zzuv("Unterminated escape sequence");
                                }
                            }
                            return '\r';
                        }
                        return '\n';
                    }
                    return '\f';
                }
                return '\b';
            }
            this.boa++;
            this.bob = this.pos;
            return c;
        }
        throw zzuv("Unterminated escape sequence");
    }

    /* renamed from: bI */
    private void m9628bI() throws IOException {
        zzdg(true);
        this.pos--;
        int i = this.pos;
        char[] cArr = bnX;
        if (i + cArr.length > this.limit && !zzagx(cArr.length)) {
            return;
        }
        int i2 = 0;
        while (true) {
            char[] cArr2 = bnX;
            if (i2 >= cArr2.length) {
                this.pos += cArr2.length;
                return;
            } else if (this.bnZ[this.pos + i2] != cArr2[i2]) {
                return;
            } else {
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getColumnNumber() {
        return (this.pos - this.bob) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLineNumber() {
        return this.boa + 1;
    }

    private void zzagw(int i) {
        int i2 = this.boh;
        int[] iArr = this.bog;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            int[] iArr3 = new int[i2 * 2];
            String[] strArr = new String[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.boj, 0, iArr3, 0, this.boh);
            System.arraycopy(this.boi, 0, strArr, 0, this.boh);
            this.bog = iArr2;
            this.boj = iArr3;
            this.boi = strArr;
        }
        int[] iArr4 = this.bog;
        int i3 = this.boh;
        this.boh = i3 + 1;
        iArr4[i3] = i;
    }

    private boolean zzagx(int i) throws IOException {
        int i2;
        char[] cArr = this.bnZ;
        int i3 = this.bob;
        int i4 = this.pos;
        this.bob = i3 - i4;
        int i5 = this.limit;
        if (i5 != i4) {
            this.limit = i5 - i4;
            System.arraycopy(cArr, i4, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.f3072in;
            int i6 = this.limit;
            int read = reader.read(cArr, i6, cArr.length - i6);
            if (read == -1) {
                return false;
            }
            this.limit += read;
            if (this.boa == 0 && (i2 = this.bob) == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.bob = i2 + 1;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
        if (r1 != '/') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006f, code lost:
        r7.pos = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
        if (r4 != r2) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
        r7.pos--;
        r2 = zzagx(2);
        r7.pos++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0082, code lost:
        if (r2 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
        m9631bF();
        r2 = r7.pos;
        r3 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008e, code lost:
        if (r3 == '*') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0090, code lost:
        if (r3 == '/') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0093, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009c, code lost:
        r7.pos = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a6, code lost:
        if (zzuu("*\/") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b3, code lost:
        throw zzuv("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b6, code lost:
        if (r1 != '#') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b8, code lost:
        r7.pos = r4;
        m9631bF();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00be, code lost:
        r7.pos = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c0, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int zzdg(boolean r8) throws java.io.IOException {
        /*
            r7 = this;
            char[] r0 = r7.bnZ
        L2:
            int r1 = r7.pos
        L4:
            int r2 = r7.limit
        L6:
            r3 = 1
            if (r1 != r2) goto L4e
            r7.pos = r1
            boolean r1 = r7.zzagx(r3)
            if (r1 != 0) goto L4a
            if (r8 != 0) goto L15
            r8 = -1
            return r8
        L15:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.String r0 = "End of input at line "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r7.getLineNumber()
            int r2 = r7.getColumnNumber()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r0)
            int r4 = r4.length()
            int r4 = r4 + 30
            r3.<init>(r4)
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = " column "
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            r8.<init>(r0)
            throw r8
        L4a:
            int r1 = r7.pos
            int r2 = r7.limit
        L4e:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L5e
            int r1 = r7.boa
            int r1 = r1 + r3
            r7.boa = r1
            r7.bob = r4
            goto Lc1
        L5e:
            r5 = 32
            if (r1 == r5) goto Lc1
            r5 = 13
            if (r1 == r5) goto Lc1
            r5 = 9
            if (r1 != r5) goto L6b
            goto Lc1
        L6b:
            r5 = 47
            if (r1 != r5) goto Lb4
            r7.pos = r4
            r6 = 2
            if (r4 != r2) goto L85
            int r2 = r7.pos
            int r2 = r2 - r3
            r7.pos = r2
            boolean r2 = r7.zzagx(r6)
            int r4 = r7.pos
            int r4 = r4 + r3
            r7.pos = r4
            if (r2 != 0) goto L85
            return r1
        L85:
            r7.m9631bF()
            int r2 = r7.pos
            char r3 = r0[r2]
            r4 = 42
            if (r3 == r4) goto L9c
            if (r3 == r5) goto L93
            return r1
        L93:
            int r2 = r2 + 1
            r7.pos = r2
        L97:
            r7.m9630bG()
            goto L2
        L9c:
            int r2 = r2 + 1
            r7.pos = r2
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r7.zzuu(r1)
            if (r1 == 0) goto Lad
            int r1 = r7.pos
            int r1 = r1 + r6
            goto L4
        Lad:
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.zzuv(r8)
            throw r8
        Lb4:
            r2 = 35
            if (r1 != r2) goto Lbe
            r7.pos = r4
            r7.m9631bF()
            goto L97
        Lbe:
            r7.pos = r4
            return r1
        Lc1:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzapy.zzdg(boolean):int");
    }

    private boolean zze(char c) throws IOException {
        switch (c) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                return false;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                m9631bF();
                return false;
            default:
                return true;
        }
    }

    private String zzf(char c) throws IOException {
        char[] cArr = this.bnZ;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = this.pos;
            int i2 = this.limit;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.pos = i3;
                        sb.append(cArr, i, (i3 - i) - 1);
                        return sb.toString();
                    } else if (c2 == '\\') {
                        this.pos = i3;
                        sb.append(cArr, i, (i3 - i) - 1);
                        sb.append(m9629bH());
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.boa++;
                            this.bob = i3;
                        }
                        i = i3;
                    }
                } else {
                    sb.append(cArr, i, i - i);
                    this.pos = i;
                    if (!zzagx(1)) {
                        throw zzuv("Unterminated string");
                    }
                }
            }
        }
    }

    private void zzg(char c) throws IOException {
        char[] cArr = this.bnZ;
        while (true) {
            int i = this.pos;
            int i2 = this.limit;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.pos = i3;
                        return;
                    } else if (c2 == '\\') {
                        this.pos = i3;
                        m9629bH();
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.boa++;
                            this.bob = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.pos = i;
                    if (!zzagx(1)) {
                        throw zzuv("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean zzuu(String str) throws IOException {
        while (true) {
            if (this.pos + str.length() > this.limit && !zzagx(str.length())) {
                return false;
            }
            char[] cArr = this.bnZ;
            int i = this.pos;
            if (cArr[i] != '\n') {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    if (this.bnZ[this.pos + i2] != str.charAt(i2)) {
                        break;
                    }
                }
                return true;
            }
            this.boa++;
            this.bob = i + 1;
            this.pos++;
        }
    }

    private IOException zzuv(String str) throws IOException {
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45 + String.valueOf(path).length());
        sb.append(str);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        sb.append(" path ");
        sb.append(path);
        throw new zzaqb(sb.toString());
    }

    public void beginArray() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m9636bA();
        }
        if (i == 3) {
            zzagw(1);
            this.boj[this.boh - 1] = 0;
            this.boc = 0;
            return;
        }
        String valueOf = String.valueOf(mo9627bn());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 74 + String.valueOf(path).length());
        sb.append("Expected BEGIN_ARRAY but was ");
        sb.append(valueOf);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        sb.append(" path ");
        sb.append(path);
        throw new IllegalStateException(sb.toString());
    }

    public void beginObject() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m9636bA();
        }
        if (i == 1) {
            zzagw(3);
            this.boc = 0;
            return;
        }
        String valueOf = String.valueOf(mo9627bn());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 75 + String.valueOf(path).length());
        sb.append("Expected BEGIN_OBJECT but was ");
        sb.append(valueOf);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        sb.append(" path ");
        sb.append(path);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: bn */
    public zzapz mo9627bn() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m9636bA();
        }
        switch (i) {
            case 1:
                return zzapz.BEGIN_OBJECT;
            case 2:
                return zzapz.END_OBJECT;
            case 3:
                return zzapz.BEGIN_ARRAY;
            case 4:
                return zzapz.END_ARRAY;
            case 5:
            case 6:
                return zzapz.BOOLEAN;
            case 7:
                return zzapz.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return zzapz.STRING;
            case 12:
            case 13:
            case 14:
                return zzapz.NAME;
            case 15:
            case 16:
                return zzapz.NUMBER;
            case 17:
                return zzapz.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.boc = 0;
        this.bog[0] = 8;
        this.boh = 1;
        this.f3072in.close();
    }

    public void endArray() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m9636bA();
        }
        if (i == 4) {
            this.boh--;
            int[] iArr = this.boj;
            int i2 = this.boh - 1;
            iArr[i2] = iArr[i2] + 1;
            this.boc = 0;
            return;
        }
        String valueOf = String.valueOf(mo9627bn());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 72 + String.valueOf(path).length());
        sb.append("Expected END_ARRAY but was ");
        sb.append(valueOf);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        sb.append(" path ");
        sb.append(path);
        throw new IllegalStateException(sb.toString());
    }

    public void endObject() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m9636bA();
        }
        if (i == 2) {
            this.boh--;
            String[] strArr = this.boi;
            int i2 = this.boh;
            strArr[i2] = null;
            int[] iArr = this.boj;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.boc = 0;
            return;
        }
        String valueOf = String.valueOf(mo9627bn());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 73 + String.valueOf(path).length());
        sb.append("Expected END_OBJECT but was ");
        sb.append(valueOf);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        sb.append(" path ");
        sb.append(path);
        throw new IllegalStateException(sb.toString());
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = this.boh;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.bog[i2]) {
                case 1:
                case 2:
                    sb.append(IniEditor.Section.HEADER_START);
                    sb.append(this.boj[i2]);
                    sb.append(IniEditor.Section.HEADER_END);
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String[] strArr = this.boi;
                    if (strArr[i2] != null) {
                        sb.append(strArr[i2]);
                        break;
                    } else {
                        break;
                    }
            }
        }
        return sb.toString();
    }

    public boolean hasNext() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m9636bA();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.bnY;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m9636bA();
        }
        if (i == 5) {
            this.boc = 0;
            int[] iArr = this.boj;
            int i2 = this.boh - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.boc = 0;
            int[] iArr2 = this.boj;
            int i3 = this.boh - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            String valueOf = String.valueOf(mo9627bn());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 72 + String.valueOf(path).length());
            sb.append("Expected a boolean but was ");
            sb.append(valueOf);
            sb.append(" at line ");
            sb.append(lineNumber);
            sb.append(" column ");
            sb.append(columnNumber);
            sb.append(" path ");
            sb.append(path);
            throw new IllegalStateException(sb.toString());
        }
    }

    public double nextDouble() throws IOException {
        String zzf;
        int i = this.boc;
        if (i == 0) {
            i = m9636bA();
        }
        if (i == 15) {
            this.boc = 0;
            int[] iArr = this.boj;
            int i2 = this.boh - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.bod;
        }
        if (i == 16) {
            this.bof = new String(this.bnZ, this.pos, this.boe);
            this.pos += this.boe;
        } else {
            if (i == 8 || i == 9) {
                zzf = zzf(i == 8 ? '\'' : '\"');
            } else if (i == 10) {
                zzf = m9633bD();
            } else if (i != 11) {
                String valueOf = String.valueOf(mo9627bn());
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71 + String.valueOf(path).length());
                sb.append("Expected a double but was ");
                sb.append(valueOf);
                sb.append(" at line ");
                sb.append(lineNumber);
                sb.append(" column ");
                sb.append(columnNumber);
                sb.append(" path ");
                sb.append(path);
                throw new IllegalStateException(sb.toString());
            }
            this.bof = zzf;
        }
        this.boc = 11;
        double parseDouble = Double.parseDouble(this.bof);
        if (this.bnY || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.bof = null;
            this.boc = 0;
            int[] iArr2 = this.boj;
            int i3 = this.boh - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        int lineNumber2 = getLineNumber();
        int columnNumber2 = getColumnNumber();
        String path2 = getPath();
        StringBuilder sb2 = new StringBuilder(String.valueOf(path2).length() + 102);
        sb2.append("JSON forbids NaN and infinities: ");
        sb2.append(parseDouble);
        sb2.append(" at line ");
        sb2.append(lineNumber2);
        sb2.append(" column ");
        sb2.append(columnNumber2);
        sb2.append(" path ");
        sb2.append(path2);
        throw new zzaqb(sb2.toString());
    }

    public int nextInt() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m9636bA();
        }
        if (i == 15) {
            long j = this.bod;
            int i2 = (int) j;
            if (j == i2) {
                this.boc = 0;
                int[] iArr = this.boj;
                int i3 = this.boh - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            StringBuilder sb = new StringBuilder(String.valueOf(path).length() + 89);
            sb.append("Expected an int but was ");
            sb.append(j);
            sb.append(" at line ");
            sb.append(lineNumber);
            sb.append(" column ");
            sb.append(columnNumber);
            sb.append(" path ");
            sb.append(path);
            throw new NumberFormatException(sb.toString());
        }
        if (i == 16) {
            this.bof = new String(this.bnZ, this.pos, this.boe);
            this.pos += this.boe;
        } else if (i != 8 && i != 9) {
            String valueOf = String.valueOf(mo9627bn());
            int lineNumber2 = getLineNumber();
            int columnNumber2 = getColumnNumber();
            String path2 = getPath();
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path2).length());
            sb2.append("Expected an int but was ");
            sb2.append(valueOf);
            sb2.append(" at line ");
            sb2.append(lineNumber2);
            sb2.append(" column ");
            sb2.append(columnNumber2);
            sb2.append(" path ");
            sb2.append(path2);
            throw new IllegalStateException(sb2.toString());
        } else {
            this.bof = zzf(i == 8 ? '\'' : '\"');
            try {
                int parseInt = Integer.parseInt(this.bof);
                this.boc = 0;
                int[] iArr2 = this.boj;
                int i4 = this.boh - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.boc = 11;
        double parseDouble = Double.parseDouble(this.bof);
        int i5 = (int) parseDouble;
        if (i5 == parseDouble) {
            this.bof = null;
            this.boc = 0;
            int[] iArr3 = this.boj;
            int i6 = this.boh - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        }
        String str = this.bof;
        int lineNumber3 = getLineNumber();
        int columnNumber3 = getColumnNumber();
        String path3 = getPath();
        StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path3).length());
        sb3.append("Expected an int but was ");
        sb3.append(str);
        sb3.append(" at line ");
        sb3.append(lineNumber3);
        sb3.append(" column ");
        sb3.append(columnNumber3);
        sb3.append(" path ");
        sb3.append(path3);
        throw new NumberFormatException(sb3.toString());
    }

    public long nextLong() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m9636bA();
        }
        if (i == 15) {
            this.boc = 0;
            int[] iArr = this.boj;
            int i2 = this.boh - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.bod;
        }
        if (i == 16) {
            this.bof = new String(this.bnZ, this.pos, this.boe);
            this.pos += this.boe;
        } else if (i != 8 && i != 9) {
            String valueOf = String.valueOf(mo9627bn());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path).length());
            sb.append("Expected a long but was ");
            sb.append(valueOf);
            sb.append(" at line ");
            sb.append(lineNumber);
            sb.append(" column ");
            sb.append(columnNumber);
            sb.append(" path ");
            sb.append(path);
            throw new IllegalStateException(sb.toString());
        } else {
            this.bof = zzf(i == 8 ? '\'' : '\"');
            try {
                long parseLong = Long.parseLong(this.bof);
                this.boc = 0;
                int[] iArr2 = this.boj;
                int i3 = this.boh - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.boc = 11;
        double parseDouble = Double.parseDouble(this.bof);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.bof = null;
            this.boc = 0;
            int[] iArr3 = this.boj;
            int i4 = this.boh - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return j;
        }
        String str = this.bof;
        int lineNumber2 = getLineNumber();
        int columnNumber2 = getColumnNumber();
        String path2 = getPath();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path2).length());
        sb2.append("Expected a long but was ");
        sb2.append(str);
        sb2.append(" at line ");
        sb2.append(lineNumber2);
        sb2.append(" column ");
        sb2.append(columnNumber2);
        sb2.append(" path ");
        sb2.append(path2);
        throw new NumberFormatException(sb2.toString());
    }

    public String nextName() throws IOException {
        char c;
        String zzf;
        int i = this.boc;
        if (i == 0) {
            i = m9636bA();
        }
        if (i == 14) {
            zzf = m9633bD();
        } else {
            if (i == 12) {
                c = '\'';
            } else if (i != 13) {
                String valueOf = String.valueOf(mo9627bn());
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path).length());
                sb.append("Expected a name but was ");
                sb.append(valueOf);
                sb.append(" at line ");
                sb.append(lineNumber);
                sb.append(" column ");
                sb.append(columnNumber);
                sb.append(" path ");
                sb.append(path);
                throw new IllegalStateException(sb.toString());
            } else {
                c = '\"';
            }
            zzf = zzf(c);
        }
        this.boc = 0;
        this.boi[this.boh - 1] = zzf;
        return zzf;
    }

    public void nextNull() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m9636bA();
        }
        if (i == 7) {
            this.boc = 0;
            int[] iArr = this.boj;
            int i2 = this.boh - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        String valueOf = String.valueOf(mo9627bn());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 67 + String.valueOf(path).length());
        sb.append("Expected null but was ");
        sb.append(valueOf);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        sb.append(" path ");
        sb.append(path);
        throw new IllegalStateException(sb.toString());
    }

    public String nextString() throws IOException {
        String str;
        char c;
        int i = this.boc;
        if (i == 0) {
            i = m9636bA();
        }
        if (i == 10) {
            str = m9633bD();
        } else {
            if (i == 8) {
                c = '\'';
            } else if (i == 9) {
                c = '\"';
            } else if (i == 11) {
                str = this.bof;
                this.bof = null;
            } else if (i == 15) {
                str = Long.toString(this.bod);
            } else if (i != 16) {
                String valueOf = String.valueOf(mo9627bn());
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71 + String.valueOf(path).length());
                sb.append("Expected a string but was ");
                sb.append(valueOf);
                sb.append(" at line ");
                sb.append(lineNumber);
                sb.append(" column ");
                sb.append(columnNumber);
                sb.append(" path ");
                sb.append(path);
                throw new IllegalStateException(sb.toString());
            } else {
                str = new String(this.bnZ, this.pos, this.boe);
                this.pos += this.boe;
            }
            str = zzf(c);
        }
        this.boc = 0;
        int[] iArr = this.boj;
        int i2 = this.boh - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final void setLenient(boolean z) {
        this.bnY = z;
    }

    public void skipValue() throws IOException {
        char c;
        int i = 0;
        do {
            int i2 = this.boc;
            if (i2 == 0) {
                i2 = m9636bA();
            }
            if (i2 == 3) {
                zzagw(1);
            } else if (i2 == 1) {
                zzagw(3);
            } else {
                if (i2 == 4 || i2 == 2) {
                    this.boh--;
                    i--;
                } else if (i2 == 14 || i2 == 10) {
                    m9632bE();
                } else {
                    if (i2 == 8 || i2 == 12) {
                        c = '\'';
                    } else if (i2 == 9 || i2 == 13) {
                        c = '\"';
                    } else if (i2 == 16) {
                        this.pos += this.boe;
                    }
                    zzg(c);
                }
                this.boc = 0;
            }
            i++;
            this.boc = 0;
        } while (i != 0);
        int[] iArr = this.boj;
        int i3 = this.boh;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.boi[i3 - 1] = "null";
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
        sb.append(valueOf);
        sb.append(" at line ");
        sb.append(lineNumber);
        sb.append(" column ");
        sb.append(columnNumber);
        return sb.toString();
    }
}
