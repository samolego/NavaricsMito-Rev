package com.tencent.bugly.proguard;

import com.adapt.SPM_Rc;
import com.github.mikephil.charting.utils.Utils;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.i */
/* loaded from: classes2.dex */
public final class C2476i {

    /* renamed from: a */
    private ByteBuffer f7652a;

    /* renamed from: b */
    private String f7653b = "GBK";

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.i$a */
    /* loaded from: classes2.dex */
    public static class C2477a {

        /* renamed from: a */
        public byte f7654a;

        /* renamed from: b */
        public int f7655b;
    }

    public C2476i() {
    }

    public C2476i(byte[] bArr) {
        this.f7652a = ByteBuffer.wrap(bArr);
    }

    public C2476i(byte[] bArr, int i) {
        this.f7652a = ByteBuffer.wrap(bArr);
        this.f7652a.position(4);
    }

    /* renamed from: a */
    public final void m5226a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f7652a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f7652a = ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    private static int m5233a(C2477a c2477a, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        c2477a.f7654a = (byte) (b & SPM_Rc.VIBRATION_MODE.MAX_VOLUME);
        c2477a.f7655b = (b & 240) >> 4;
        if (c2477a.f7655b == 15) {
            c2477a.f7655b = byteBuffer.get();
            return 2;
        }
        return 1;
    }

    /* renamed from: a */
    private boolean m5237a(int i) {
        try {
            C2477a c2477a = new C2477a();
            while (true) {
                int m5233a = m5233a(c2477a, this.f7652a.duplicate());
                if (i <= c2477a.f7655b || c2477a.f7654a == 11) {
                    break;
                }
                this.f7652a.position(this.f7652a.position() + m5233a);
                m5241a(c2477a.f7654a);
            }
            return i == c2477a.f7655b;
        } catch (C2474g | BufferUnderflowException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m5242a() {
        C2477a c2477a = new C2477a();
        do {
            m5233a(c2477a, this.f7652a);
            m5241a(c2477a.f7654a);
        } while (c2477a.f7654a != 11);
    }

    /* renamed from: a */
    private void m5241a(byte b) {
        int i = 0;
        switch (b) {
            case 0:
                ByteBuffer byteBuffer = this.f7652a;
                byteBuffer.position(byteBuffer.position() + 1);
                return;
            case 1:
                ByteBuffer byteBuffer2 = this.f7652a;
                byteBuffer2.position(byteBuffer2.position() + 2);
                return;
            case 2:
                ByteBuffer byteBuffer3 = this.f7652a;
                byteBuffer3.position(byteBuffer3.position() + 4);
                return;
            case 3:
                ByteBuffer byteBuffer4 = this.f7652a;
                byteBuffer4.position(byteBuffer4.position() + 8);
                return;
            case 4:
                ByteBuffer byteBuffer5 = this.f7652a;
                byteBuffer5.position(byteBuffer5.position() + 4);
                return;
            case 5:
                ByteBuffer byteBuffer6 = this.f7652a;
                byteBuffer6.position(byteBuffer6.position() + 8);
                return;
            case 6:
                int i2 = this.f7652a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                ByteBuffer byteBuffer7 = this.f7652a;
                byteBuffer7.position(byteBuffer7.position() + i2);
                return;
            case 7:
                int i3 = this.f7652a.getInt();
                ByteBuffer byteBuffer8 = this.f7652a;
                byteBuffer8.position(byteBuffer8.position() + i3);
                return;
            case 8:
                int m5236a = m5236a(0, 0, true);
                while (i < (m5236a << 1)) {
                    C2477a c2477a = new C2477a();
                    m5233a(c2477a, this.f7652a);
                    m5241a(c2477a.f7654a);
                    i++;
                }
                return;
            case 9:
                int m5236a2 = m5236a(0, 0, true);
                while (i < m5236a2) {
                    C2477a c2477a2 = new C2477a();
                    m5233a(c2477a2, this.f7652a);
                    m5241a(c2477a2.f7654a);
                    i++;
                }
                return;
            case 10:
                m5242a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                C2477a c2477a3 = new C2477a();
                m5233a(c2477a3, this.f7652a);
                if (c2477a3.f7654a != 0) {
                    throw new C2474g("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) c2477a3.f7654a));
                }
                int m5236a3 = m5236a(0, 0, true);
                ByteBuffer byteBuffer9 = this.f7652a;
                byteBuffer9.position(byteBuffer9.position() + m5236a3);
                return;
            default:
                throw new C2474g("invalid type.");
        }
    }

    /* renamed from: a */
    public final boolean m5235a(int i, boolean z) {
        return m5240a((byte) 0, i, z) != 0;
    }

    /* renamed from: a */
    public final byte m5240a(byte b, int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return b;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        byte b2 = c2477a.f7654a;
        if (b2 != 0) {
            if (b2 == 12) {
                return (byte) 0;
            }
            throw new C2474g("type mismatch.");
        }
        return this.f7652a.get();
    }

    /* renamed from: a */
    public final short m5227a(short s, int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return s;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        byte b = c2477a.f7654a;
        if (b != 12) {
            switch (b) {
                case 0:
                    return this.f7652a.get();
                case 1:
                    return this.f7652a.getShort();
                default:
                    throw new C2474g("type mismatch.");
            }
        }
        return (short) 0;
    }

    /* renamed from: a */
    public final int m5236a(int i, int i2, boolean z) {
        if (!m5237a(i2)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return i;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        byte b = c2477a.f7654a;
        if (b != 12) {
            switch (b) {
                case 0:
                    return this.f7652a.get();
                case 1:
                    return this.f7652a.getShort();
                case 2:
                    return this.f7652a.getInt();
                default:
                    throw new C2474g("type mismatch.");
            }
        }
        return 0;
    }

    /* renamed from: a */
    public final long m5234a(long j, int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return j;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        byte b = c2477a.f7654a;
        if (b != 12) {
            switch (b) {
                case 0:
                    return this.f7652a.get();
                case 1:
                    return this.f7652a.getShort();
                case 2:
                    return this.f7652a.getInt();
                case 3:
                    return this.f7652a.getLong();
                default:
                    throw new C2474g("type mismatch.");
            }
        }
        return 0L;
    }

    /* renamed from: a */
    private float m5238a(float f, int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return f;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        byte b = c2477a.f7654a;
        if (b != 4) {
            if (b == 12) {
                return 0.0f;
            }
            throw new C2474g("type mismatch.");
        }
        return this.f7652a.getFloat();
    }

    /* renamed from: a */
    private double m5239a(double d, int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return d;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        byte b = c2477a.f7654a;
        if (b != 12) {
            switch (b) {
                case 4:
                    return this.f7652a.getFloat();
                case 5:
                    return this.f7652a.getDouble();
                default:
                    throw new C2474g("type mismatch.");
            }
        }
        return Utils.DOUBLE_EPSILON;
    }

    /* renamed from: b */
    public final String m5224b(int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return null;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        switch (c2477a.f7654a) {
            case 6:
                int i2 = this.f7652a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.f7652a.get(bArr);
                try {
                    return new String(bArr, this.f7653b);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr);
                }
            case 7:
                int i3 = this.f7652a.getInt();
                if (i3 > 104857600 || i3 < 0) {
                    throw new C2474g("String too long: " + i3);
                }
                byte[] bArr2 = new byte[i3];
                this.f7652a.get(bArr2);
                try {
                    return new String(bArr2, this.f7653b);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            default:
                throw new C2474g("type mismatch.");
        }
    }

    /* renamed from: a */
    public final <K, V> HashMap<K, V> m5229a(Map<K, V> map, int i, boolean z) {
        return (HashMap) m5228a(new HashMap(), map, i, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private <K, V> Map<K, V> m5228a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry<K, V> next = map2.entrySet().iterator().next();
        K key = next.getKey();
        V value = next.getValue();
        if (m5237a(i)) {
            C2477a c2477a = new C2477a();
            m5233a(c2477a, this.f7652a);
            if (c2477a.f7654a == 8) {
                int m5236a = m5236a(0, 0, true);
                if (m5236a < 0) {
                    throw new C2474g("size invalid: " + m5236a);
                }
                for (int i2 = 0; i2 < m5236a; i2++) {
                    map.put(m5231a((C2476i) key, 0, true), m5231a((C2476i) value, 1, true));
                }
            } else {
                throw new C2474g("type mismatch.");
            }
        } else if (z) {
            throw new C2474g("require field not exist.");
        }
        return map;
    }

    /* renamed from: d */
    private boolean[] m5221d(int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return null;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        if (c2477a.f7654a == 9) {
            int m5236a = m5236a(0, 0, true);
            if (m5236a < 0) {
                throw new C2474g("size invalid: " + m5236a);
            }
            boolean[] zArr = new boolean[m5236a];
            for (int i2 = 0; i2 < m5236a; i2++) {
                zArr[i2] = m5240a((byte) 0, 0, true) != 0;
            }
            return zArr;
        }
        throw new C2474g("type mismatch.");
    }

    /* renamed from: c */
    public final byte[] m5222c(int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return null;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        byte b = c2477a.f7654a;
        if (b == 9) {
            int m5236a = m5236a(0, 0, true);
            if (m5236a < 0) {
                throw new C2474g("size invalid: " + m5236a);
            }
            byte[] bArr = new byte[m5236a];
            for (int i2 = 0; i2 < m5236a; i2++) {
                bArr[i2] = m5240a(bArr[0], 0, true);
            }
            return bArr;
        } else if (b == 13) {
            C2477a c2477a2 = new C2477a();
            m5233a(c2477a2, this.f7652a);
            if (c2477a2.f7654a != 0) {
                throw new C2474g("type mismatch, tag: " + i + ", type: " + ((int) c2477a.f7654a) + ", " + ((int) c2477a2.f7654a));
            }
            int m5236a2 = m5236a(0, 0, true);
            if (m5236a2 < 0) {
                throw new C2474g("invalid size, tag: " + i + ", type: " + ((int) c2477a.f7654a) + ", " + ((int) c2477a2.f7654a) + ", size: " + m5236a2);
            }
            byte[] bArr2 = new byte[m5236a2];
            this.f7652a.get(bArr2);
            return bArr2;
        } else {
            throw new C2474g("type mismatch.");
        }
    }

    /* renamed from: e */
    private short[] m5220e(int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return null;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        if (c2477a.f7654a == 9) {
            int m5236a = m5236a(0, 0, true);
            if (m5236a < 0) {
                throw new C2474g("size invalid: " + m5236a);
            }
            short[] sArr = new short[m5236a];
            for (int i2 = 0; i2 < m5236a; i2++) {
                sArr[i2] = m5227a(sArr[0], 0, true);
            }
            return sArr;
        }
        throw new C2474g("type mismatch.");
    }

    /* renamed from: f */
    private int[] m5219f(int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return null;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        if (c2477a.f7654a == 9) {
            int m5236a = m5236a(0, 0, true);
            if (m5236a < 0) {
                throw new C2474g("size invalid: " + m5236a);
            }
            int[] iArr = new int[m5236a];
            for (int i2 = 0; i2 < m5236a; i2++) {
                iArr[i2] = m5236a(iArr[0], 0, true);
            }
            return iArr;
        }
        throw new C2474g("type mismatch.");
    }

    /* renamed from: g */
    private long[] m5218g(int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return null;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        if (c2477a.f7654a == 9) {
            int m5236a = m5236a(0, 0, true);
            if (m5236a < 0) {
                throw new C2474g("size invalid: " + m5236a);
            }
            long[] jArr = new long[m5236a];
            for (int i2 = 0; i2 < m5236a; i2++) {
                jArr[i2] = m5234a(jArr[0], 0, true);
            }
            return jArr;
        }
        throw new C2474g("type mismatch.");
    }

    /* renamed from: h */
    private float[] m5217h(int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return null;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        if (c2477a.f7654a == 9) {
            int m5236a = m5236a(0, 0, true);
            if (m5236a < 0) {
                throw new C2474g("size invalid: " + m5236a);
            }
            float[] fArr = new float[m5236a];
            for (int i2 = 0; i2 < m5236a; i2++) {
                fArr[i2] = m5238a(fArr[0], 0, true);
            }
            return fArr;
        }
        throw new C2474g("type mismatch.");
    }

    /* renamed from: i */
    private double[] m5216i(int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return null;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        if (c2477a.f7654a == 9) {
            int m5236a = m5236a(0, 0, true);
            if (m5236a < 0) {
                throw new C2474g("size invalid: " + m5236a);
            }
            double[] dArr = new double[m5236a];
            for (int i2 = 0; i2 < m5236a; i2++) {
                dArr[i2] = m5239a(dArr[0], 0, true);
            }
            return dArr;
        }
        throw new C2474g("type mismatch.");
    }

    /* renamed from: a */
    private <T> T[] m5225a(T[] tArr, int i, boolean z) {
        if (tArr == null || tArr.length == 0) {
            throw new C2474g("unable to get type of key and value.");
        }
        return (T[]) m5223b(tArr[0], i, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private <T> T[] m5223b(T t, int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return null;
        }
        C2477a c2477a = new C2477a();
        m5233a(c2477a, this.f7652a);
        if (c2477a.f7654a == 9) {
            int m5236a = m5236a(0, 0, true);
            if (m5236a < 0) {
                throw new C2474g("size invalid: " + m5236a);
            }
            T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), m5236a));
            for (int i2 = 0; i2 < m5236a; i2++) {
                tArr[i2] = m5231a((C2476i) t, 0, true);
            }
            return tArr;
        }
        throw new C2474g("type mismatch.");
    }

    /* renamed from: a */
    public final AbstractC2479k m5232a(AbstractC2479k abstractC2479k, int i, boolean z) {
        if (!m5237a(i)) {
            if (z) {
                throw new C2474g("require field not exist.");
            }
            return null;
        }
        try {
            AbstractC2479k abstractC2479k2 = (AbstractC2479k) abstractC2479k.getClass().newInstance();
            C2477a c2477a = new C2477a();
            m5233a(c2477a, this.f7652a);
            if (c2477a.f7654a != 10) {
                throw new C2474g("type mismatch.");
            }
            abstractC2479k2.mo5199a(this);
            m5242a();
            return abstractC2479k2;
        } catch (Exception e) {
            throw new C2474g(e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final <T> Object m5231a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(m5240a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(m5240a((byte) 0, i, z) != 0);
        } else if (t instanceof Short) {
            return Short.valueOf(m5227a((short) 0, i, z));
        } else {
            if (t instanceof Integer) {
                return Integer.valueOf(m5236a(0, i, z));
            }
            if (t instanceof Long) {
                return Long.valueOf(m5234a(0L, i, z));
            }
            if (t instanceof Float) {
                return Float.valueOf(m5238a(0.0f, i, z));
            }
            if (t instanceof Double) {
                return Double.valueOf(m5239a((double) Utils.DOUBLE_EPSILON, i, z));
            }
            if (t instanceof String) {
                return String.valueOf(m5224b(i, z));
            }
            if (t instanceof Map) {
                return (HashMap) m5228a(new HashMap(), (Map) t, i, z);
            } else if (t instanceof List) {
                List list = (List) t;
                if (list == null || list.isEmpty()) {
                    return new ArrayList();
                }
                Object[] m5223b = m5223b(list.get(0), i, z);
                if (m5223b == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : m5223b) {
                    arrayList.add(obj);
                }
                return arrayList;
            } else if (t instanceof AbstractC2479k) {
                return m5232a((AbstractC2479k) t, i, z);
            } else {
                if (t.getClass().isArray()) {
                    if ((t instanceof byte[]) || (t instanceof Byte[])) {
                        return m5222c(i, z);
                    }
                    if (t instanceof boolean[]) {
                        return m5221d(i, z);
                    }
                    if (t instanceof short[]) {
                        return m5220e(i, z);
                    }
                    if (t instanceof int[]) {
                        return m5219f(i, z);
                    }
                    if (t instanceof long[]) {
                        return m5218g(i, z);
                    }
                    if (t instanceof float[]) {
                        return m5217h(i, z);
                    }
                    if (t instanceof double[]) {
                        return m5216i(i, z);
                    }
                    return m5225a((Object[]) t, i, z);
                }
                throw new C2474g("read object error: unsupport type.");
            }
        }
    }

    /* renamed from: a */
    public final int m5230a(String str) {
        this.f7653b = str;
        return 0;
    }
}
