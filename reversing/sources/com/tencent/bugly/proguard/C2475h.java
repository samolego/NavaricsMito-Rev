package com.tencent.bugly.proguard;

import com.senseplay.sdk.tool.IniEditor;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.h */
/* loaded from: classes2.dex */
public final class C2475h {

    /* renamed from: a */
    private StringBuilder f7650a;

    /* renamed from: b */
    private int f7651b;

    /* renamed from: a */
    private void m5249a(String str) {
        for (int i = 0; i < this.f7651b; i++) {
            this.f7650a.append('\t');
        }
        if (str != null) {
            StringBuilder sb = this.f7650a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public C2475h(StringBuilder sb, int i) {
        this.f7651b = 0;
        this.f7650a = sb;
        this.f7651b = i;
    }

    /* renamed from: a */
    public final C2475h m5245a(boolean z, String str) {
        m5249a(str);
        StringBuilder sb = this.f7650a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public final C2475h m5254a(byte b, String str) {
        m5249a(str);
        StringBuilder sb = this.f7650a;
        sb.append((int) b);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public final C2475h m5246a(short s, String str) {
        m5249a(str);
        StringBuilder sb = this.f7650a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public final C2475h m5253a(int i, String str) {
        m5249a(str);
        StringBuilder sb = this.f7650a;
        sb.append(i);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public final C2475h m5252a(long j, String str) {
        m5249a(str);
        StringBuilder sb = this.f7650a;
        sb.append(j);
        sb.append('\n');
        return this;
    }

    /* renamed from: a */
    public final C2475h m5248a(String str, String str2) {
        m5249a(str2);
        if (str == null) {
            this.f7650a.append("null\n");
        } else {
            StringBuilder sb = this.f7650a;
            sb.append(str);
            sb.append('\n');
        }
        return this;
    }

    /* renamed from: a */
    public final C2475h m5244a(byte[] bArr, String str) {
        m5249a(str);
        if (bArr == null) {
            this.f7650a.append("null\n");
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb = this.f7650a;
            sb.append(bArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f7650a;
            sb2.append(bArr.length);
            sb2.append(", [\n");
            C2475h c2475h = new C2475h(this.f7650a, this.f7651b + 1);
            for (byte b : bArr) {
                c2475h.m5249a(null);
                StringBuilder sb3 = c2475h.f7650a;
                sb3.append((int) b);
                sb3.append('\n');
            }
            m5249a(null);
            StringBuilder sb4 = this.f7650a;
            sb4.append(IniEditor.Section.HEADER_END);
            sb4.append('\n');
            return this;
        }
    }

    /* renamed from: a */
    public final <K, V> C2475h m5247a(Map<K, V> map, String str) {
        m5249a(str);
        if (map == null) {
            this.f7650a.append("null\n");
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb = this.f7650a;
            sb.append(map.size());
            sb.append(", {}\n");
            return this;
        } else {
            StringBuilder sb2 = this.f7650a;
            sb2.append(map.size());
            sb2.append(", {\n");
            C2475h c2475h = new C2475h(this.f7650a, this.f7651b + 1);
            C2475h c2475h2 = new C2475h(this.f7650a, this.f7651b + 2);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                c2475h.m5249a(null);
                StringBuilder sb3 = c2475h.f7650a;
                sb3.append('(');
                sb3.append('\n');
                c2475h2.m5250a((C2475h) entry.getKey(), (String) null);
                c2475h2.m5250a((C2475h) entry.getValue(), (String) null);
                c2475h.m5249a(null);
                StringBuilder sb4 = c2475h.f7650a;
                sb4.append(')');
                sb4.append('\n');
            }
            m5249a(null);
            StringBuilder sb5 = this.f7650a;
            sb5.append('}');
            sb5.append('\n');
            return this;
        }
    }

    /* renamed from: a */
    private <T> C2475h m5243a(T[] tArr, String str) {
        m5249a(str);
        if (tArr == null) {
            this.f7650a.append("null\n");
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb = this.f7650a;
            sb.append(tArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f7650a;
            sb2.append(tArr.length);
            sb2.append(", [\n");
            C2475h c2475h = new C2475h(this.f7650a, this.f7651b + 1);
            for (T t : tArr) {
                c2475h.m5250a((C2475h) t, (String) null);
            }
            m5249a(null);
            StringBuilder sb3 = this.f7650a;
            sb3.append(IniEditor.Section.HEADER_END);
            sb3.append('\n');
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private <T> C2475h m5250a(T t, String str) {
        if (t == null) {
            this.f7650a.append("null\n");
        } else if (t instanceof Byte) {
            byte byteValue = ((Byte) t).byteValue();
            m5249a(str);
            StringBuilder sb = this.f7650a;
            sb.append((int) byteValue);
            sb.append('\n');
        } else if (t instanceof Boolean) {
            boolean booleanValue = ((Boolean) t).booleanValue();
            m5249a(str);
            StringBuilder sb2 = this.f7650a;
            sb2.append(booleanValue ? 'T' : 'F');
            sb2.append('\n');
        } else if (t instanceof Short) {
            short shortValue = ((Short) t).shortValue();
            m5249a(str);
            StringBuilder sb3 = this.f7650a;
            sb3.append((int) shortValue);
            sb3.append('\n');
        } else if (t instanceof Integer) {
            int intValue = ((Integer) t).intValue();
            m5249a(str);
            StringBuilder sb4 = this.f7650a;
            sb4.append(intValue);
            sb4.append('\n');
        } else if (t instanceof Long) {
            long longValue = ((Long) t).longValue();
            m5249a(str);
            StringBuilder sb5 = this.f7650a;
            sb5.append(longValue);
            sb5.append('\n');
        } else if (t instanceof Float) {
            float floatValue = ((Float) t).floatValue();
            m5249a(str);
            StringBuilder sb6 = this.f7650a;
            sb6.append(floatValue);
            sb6.append('\n');
        } else if (t instanceof Double) {
            double doubleValue = ((Double) t).doubleValue();
            m5249a(str);
            StringBuilder sb7 = this.f7650a;
            sb7.append(doubleValue);
            sb7.append('\n');
        } else if (t instanceof String) {
            m5248a((String) t, str);
        } else if (t instanceof Map) {
            m5247a((Map) t, str);
        } else if (t instanceof List) {
            List list = (List) t;
            if (list == null) {
                m5249a(str);
                this.f7650a.append("null\t");
            } else {
                m5243a(list.toArray(), str);
            }
        } else if (t instanceof AbstractC2479k) {
            m5251a((AbstractC2479k) t, str);
        } else if (t instanceof byte[]) {
            m5244a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            m5250a((C2475h) ((boolean[]) t), str);
        } else {
            int i = 0;
            if (t instanceof short[]) {
                short[] sArr = (short[]) t;
                m5249a(str);
                if (sArr == null) {
                    this.f7650a.append("null\n");
                } else if (sArr.length == 0) {
                    StringBuilder sb8 = this.f7650a;
                    sb8.append(sArr.length);
                    sb8.append(", []\n");
                } else {
                    StringBuilder sb9 = this.f7650a;
                    sb9.append(sArr.length);
                    sb9.append(", [\n");
                    C2475h c2475h = new C2475h(this.f7650a, this.f7651b + 1);
                    int length = sArr.length;
                    while (i < length) {
                        short s = sArr[i];
                        c2475h.m5249a(null);
                        StringBuilder sb10 = c2475h.f7650a;
                        sb10.append((int) s);
                        sb10.append('\n');
                        i++;
                    }
                    m5249a(null);
                    StringBuilder sb11 = this.f7650a;
                    sb11.append(IniEditor.Section.HEADER_END);
                    sb11.append('\n');
                }
            } else if (t instanceof int[]) {
                int[] iArr = (int[]) t;
                m5249a(str);
                if (iArr == null) {
                    this.f7650a.append("null\n");
                } else if (iArr.length == 0) {
                    StringBuilder sb12 = this.f7650a;
                    sb12.append(iArr.length);
                    sb12.append(", []\n");
                } else {
                    StringBuilder sb13 = this.f7650a;
                    sb13.append(iArr.length);
                    sb13.append(", [\n");
                    C2475h c2475h2 = new C2475h(this.f7650a, this.f7651b + 1);
                    int length2 = iArr.length;
                    while (i < length2) {
                        int i2 = iArr[i];
                        c2475h2.m5249a(null);
                        StringBuilder sb14 = c2475h2.f7650a;
                        sb14.append(i2);
                        sb14.append('\n');
                        i++;
                    }
                    m5249a(null);
                    StringBuilder sb15 = this.f7650a;
                    sb15.append(IniEditor.Section.HEADER_END);
                    sb15.append('\n');
                }
            } else if (t instanceof long[]) {
                long[] jArr = (long[]) t;
                m5249a(str);
                if (jArr == null) {
                    this.f7650a.append("null\n");
                } else if (jArr.length == 0) {
                    StringBuilder sb16 = this.f7650a;
                    sb16.append(jArr.length);
                    sb16.append(", []\n");
                } else {
                    StringBuilder sb17 = this.f7650a;
                    sb17.append(jArr.length);
                    sb17.append(", [\n");
                    C2475h c2475h3 = new C2475h(this.f7650a, this.f7651b + 1);
                    int length3 = jArr.length;
                    while (i < length3) {
                        long j = jArr[i];
                        c2475h3.m5249a(null);
                        StringBuilder sb18 = c2475h3.f7650a;
                        sb18.append(j);
                        sb18.append('\n');
                        i++;
                    }
                    m5249a(null);
                    StringBuilder sb19 = this.f7650a;
                    sb19.append(IniEditor.Section.HEADER_END);
                    sb19.append('\n');
                }
            } else if (t instanceof float[]) {
                float[] fArr = (float[]) t;
                m5249a(str);
                if (fArr == null) {
                    this.f7650a.append("null\n");
                } else if (fArr.length == 0) {
                    StringBuilder sb20 = this.f7650a;
                    sb20.append(fArr.length);
                    sb20.append(", []\n");
                } else {
                    StringBuilder sb21 = this.f7650a;
                    sb21.append(fArr.length);
                    sb21.append(", [\n");
                    C2475h c2475h4 = new C2475h(this.f7650a, this.f7651b + 1);
                    int length4 = fArr.length;
                    while (i < length4) {
                        float f = fArr[i];
                        c2475h4.m5249a(null);
                        StringBuilder sb22 = c2475h4.f7650a;
                        sb22.append(f);
                        sb22.append('\n');
                        i++;
                    }
                    m5249a(null);
                    StringBuilder sb23 = this.f7650a;
                    sb23.append(IniEditor.Section.HEADER_END);
                    sb23.append('\n');
                }
            } else if (t instanceof double[]) {
                double[] dArr = (double[]) t;
                m5249a(str);
                if (dArr == null) {
                    this.f7650a.append("null\n");
                } else if (dArr.length == 0) {
                    StringBuilder sb24 = this.f7650a;
                    sb24.append(dArr.length);
                    sb24.append(", []\n");
                } else {
                    StringBuilder sb25 = this.f7650a;
                    sb25.append(dArr.length);
                    sb25.append(", [\n");
                    C2475h c2475h5 = new C2475h(this.f7650a, this.f7651b + 1);
                    int length5 = dArr.length;
                    while (i < length5) {
                        double d = dArr[i];
                        c2475h5.m5249a(null);
                        StringBuilder sb26 = c2475h5.f7650a;
                        sb26.append(d);
                        sb26.append('\n');
                        i++;
                    }
                    m5249a(null);
                    StringBuilder sb27 = this.f7650a;
                    sb27.append(IniEditor.Section.HEADER_END);
                    sb27.append('\n');
                }
            } else if (t.getClass().isArray()) {
                m5243a((Object[]) t, str);
            } else {
                throw new C2469b("write object error: unsupport type.");
            }
        }
        return this;
    }

    /* renamed from: a */
    public final C2475h m5251a(AbstractC2479k abstractC2479k, String str) {
        m5249a(str);
        StringBuilder sb = this.f7650a;
        sb.append('{');
        sb.append('\n');
        if (abstractC2479k == null) {
            StringBuilder sb2 = this.f7650a;
            sb2.append('\t');
            sb2.append("null");
        } else {
            abstractC2479k.mo5197a(this.f7650a, this.f7651b + 1);
        }
        m5249a(null);
        StringBuilder sb3 = this.f7650a;
        sb3.append('}');
        sb3.append('\n');
        return this;
    }
}
