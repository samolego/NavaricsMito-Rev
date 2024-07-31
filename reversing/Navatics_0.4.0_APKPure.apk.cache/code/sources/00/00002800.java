package org.slf4j.helpers;

import com.senseplay.sdk.tool.IniEditor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MessageFormatter.java */
/* renamed from: org.slf4j.helpers.b, reason: use source file name */
/* loaded from: classes2.dex */
public final class MessageFormatter {
    /* renamed from: a */
    public static final FormattingTuple m12594a(String str, Object obj) {
        return m12596a(str, new Object[]{obj});
    }

    /* renamed from: a */
    public static final FormattingTuple m12595a(String str, Object obj, Object obj2) {
        return m12596a(str, new Object[]{obj, obj2});
    }

    /* renamed from: a */
    static final Throwable m12593a(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    /* renamed from: a */
    public static final FormattingTuple m12596a(String str, Object[] objArr) {
        Throwable m12593a = m12593a(objArr);
        if (m12593a != null) {
            objArr = m12611b(objArr);
        }
        return m12597a(str, objArr, m12593a);
    }

    /* renamed from: b */
    private static Object[] m12611b(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        return objArr2;
    }

    /* renamed from: a */
    public static final FormattingTuple m12597a(String str, Object[] objArr, Throwable th) {
        int i;
        if (str == null) {
            return new FormattingTuple(null, objArr, th);
        }
        if (objArr == null) {
            return new FormattingTuple(str);
        }
        StringBuilder sb = new StringBuilder(str.length() + 50);
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length) {
            int indexOf = str.indexOf("{}", i3);
            if (indexOf == -1) {
                if (i3 == 0) {
                    return new FormattingTuple(str, objArr, th);
                }
                sb.append((CharSequence) str, i3, str.length());
                return new FormattingTuple(sb.toString(), objArr, th);
            }
            if (m12609a(str, indexOf)) {
                if (!m12610b(str, indexOf)) {
                    i2--;
                    sb.append((CharSequence) str, i3, indexOf - 1);
                    sb.append('{');
                    i = indexOf + 1;
                } else {
                    sb.append((CharSequence) str, i3, indexOf - 1);
                    m12599a(sb, objArr[i2], new HashMap());
                    i = indexOf + 2;
                }
            } else {
                sb.append((CharSequence) str, i3, indexOf);
                m12599a(sb, objArr[i2], new HashMap());
                i = indexOf + 2;
            }
            i3 = i;
            i2++;
        }
        sb.append((CharSequence) str, i3, str.length());
        return new FormattingTuple(sb.toString(), objArr, th);
    }

    /* renamed from: a */
    static final boolean m12609a(String str, int i) {
        return i != 0 && str.charAt(i - 1) == '\\';
    }

    /* renamed from: b */
    static final boolean m12610b(String str, int i) {
        return i >= 2 && str.charAt(i - 2) == '\\';
    }

    /* renamed from: a */
    private static void m12599a(StringBuilder sb, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            sb.append("null");
            return;
        }
        if (!obj.getClass().isArray()) {
            m12598a(sb, obj);
            return;
        }
        if (obj instanceof boolean[]) {
            m12608a(sb, (boolean[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            m12600a(sb, (byte[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            m12601a(sb, (char[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            m12607a(sb, (short[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            m12604a(sb, (int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            m12605a(sb, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            m12603a(sb, (float[]) obj);
        } else if (obj instanceof double[]) {
            m12602a(sb, (double[]) obj);
        } else {
            m12606a(sb, (Object[]) obj, map);
        }
    }

    /* renamed from: a */
    private static void m12598a(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            C3498g.m12625a("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
            sb.append("[FAILED toString()]");
        }
    }

    /* renamed from: a */
    private static void m12606a(StringBuilder sb, Object[] objArr, Map<Object[], Object> map) {
        sb.append(IniEditor.Section.HEADER_START);
        if (!map.containsKey(objArr)) {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                m12599a(sb, objArr[i], map);
                if (i != length - 1) {
                    sb.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            sb.append("...");
        }
        sb.append(IniEditor.Section.HEADER_END);
    }

    /* renamed from: a */
    private static void m12608a(StringBuilder sb, boolean[] zArr) {
        sb.append(IniEditor.Section.HEADER_START);
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(zArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(IniEditor.Section.HEADER_END);
    }

    /* renamed from: a */
    private static void m12600a(StringBuilder sb, byte[] bArr) {
        sb.append(IniEditor.Section.HEADER_START);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append((int) bArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(IniEditor.Section.HEADER_END);
    }

    /* renamed from: a */
    private static void m12601a(StringBuilder sb, char[] cArr) {
        sb.append(IniEditor.Section.HEADER_START);
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(cArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(IniEditor.Section.HEADER_END);
    }

    /* renamed from: a */
    private static void m12607a(StringBuilder sb, short[] sArr) {
        sb.append(IniEditor.Section.HEADER_START);
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            sb.append((int) sArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(IniEditor.Section.HEADER_END);
    }

    /* renamed from: a */
    private static void m12604a(StringBuilder sb, int[] iArr) {
        sb.append(IniEditor.Section.HEADER_START);
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(iArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(IniEditor.Section.HEADER_END);
    }

    /* renamed from: a */
    private static void m12605a(StringBuilder sb, long[] jArr) {
        sb.append(IniEditor.Section.HEADER_START);
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(jArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(IniEditor.Section.HEADER_END);
    }

    /* renamed from: a */
    private static void m12603a(StringBuilder sb, float[] fArr) {
        sb.append(IniEditor.Section.HEADER_START);
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(fArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(IniEditor.Section.HEADER_END);
    }

    /* renamed from: a */
    private static void m12602a(StringBuilder sb, double[] dArr) {
        sb.append(IniEditor.Section.HEADER_START);
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(dArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(IniEditor.Section.HEADER_END);
    }
}