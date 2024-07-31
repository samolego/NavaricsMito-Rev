package com.tencent.bugly.proguard;

import com.common.LOGIN_ACK_REL;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.j */
/* loaded from: classes2.dex */
public final class C2478j {

    /* renamed from: a */
    private ByteBuffer f7656a;

    /* renamed from: b */
    private String f7657b;

    public C2478j(int i) {
        this.f7657b = "GBK";
        this.f7656a = ByteBuffer.allocate(i);
    }

    public C2478j() {
        this(128);
    }

    /* renamed from: a */
    public final ByteBuffer m5215a() {
        return this.f7656a;
    }

    /* renamed from: b */
    public final byte[] m5201b() {
        byte[] bArr = new byte[this.f7656a.position()];
        System.arraycopy(this.f7656a.array(), 0, bArr, 0, this.f7656a.position());
        return bArr;
    }

    /* renamed from: a */
    private void m5213a(int i) {
        if (this.f7656a.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f7656a.capacity() + i) << 1);
            allocate.put(this.f7656a.array(), 0, this.f7656a.position());
            this.f7656a = allocate;
        }
    }

    /* renamed from: b */
    private void m5200b(byte b, int i) {
        if (i < 15) {
            this.f7656a.put((byte) (b | (i << 4)));
        } else if (i < 256) {
            this.f7656a.put((byte) (b | 240));
            this.f7656a.put((byte) i);
        } else {
            throw new C2469b("tag is too large: " + i);
        }
    }

    /* renamed from: a */
    public final void m5203a(boolean z, int i) {
        m5214a(z ? (byte) 1 : (byte) 0, i);
    }

    /* renamed from: a */
    public final void m5214a(byte b, int i) {
        m5213a(3);
        if (b == 0) {
            m5200b(LOGIN_ACK_REL.LOGIN_ACK_REL_REPEAT_LOGIN, i);
            return;
        }
        m5200b((byte) 0, i);
        this.f7656a.put(b);
    }

    /* renamed from: a */
    public final void m5204a(short s, int i) {
        m5213a(4);
        if (s >= -128 && s <= 127) {
            m5214a((byte) s, i);
            return;
        }
        m5200b((byte) 1, i);
        this.f7656a.putShort(s);
    }

    /* renamed from: a */
    public final void m5212a(int i, int i2) {
        m5213a(6);
        if (i >= -32768 && i <= 32767) {
            m5204a((short) i, i2);
            return;
        }
        m5200b((byte) 2, i2);
        this.f7656a.putInt(i);
    }

    /* renamed from: a */
    public final void m5211a(long j, int i) {
        m5213a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            m5212a((int) j, i);
            return;
        }
        m5200b((byte) 3, i);
        this.f7656a.putLong(j);
    }

    /* renamed from: a */
    public final void m5207a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f7657b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        m5213a(bytes.length + 10);
        if (bytes.length > 255) {
            m5200b((byte) 7, i);
            this.f7656a.putInt(bytes.length);
            this.f7656a.put(bytes);
            return;
        }
        m5200b((byte) 6, i);
        this.f7656a.put((byte) bytes.length);
        this.f7656a.put(bytes);
    }

    /* renamed from: a */
    public final <K, V> void m5205a(Map<K, V> map, int i) {
        m5213a(8);
        m5200b((byte) 8, i);
        m5212a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                m5209a(entry.getKey(), 0);
                m5209a(entry.getValue(), 1);
            }
        }
    }

    /* renamed from: a */
    public final void m5202a(byte[] bArr, int i) {
        m5213a(bArr.length + 8);
        m5200b(LOGIN_ACK_REL.LOGIN_ACK_REL_SN_ERR, i);
        m5200b((byte) 0, 0);
        m5212a(bArr.length, 0);
        this.f7656a.put(bArr);
    }

    /* renamed from: a */
    public final <T> void m5206a(Collection<T> collection, int i) {
        m5213a(8);
        m5200b((byte) 9, i);
        m5212a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T t : collection) {
                m5209a(t, 0);
            }
        }
    }

    /* renamed from: a */
    public final void m5210a(AbstractC2479k abstractC2479k, int i) {
        m5213a(2);
        m5200b((byte) 10, i);
        abstractC2479k.mo5198a(this);
        m5213a(2);
        m5200b(LOGIN_ACK_REL.LOGIN_ACK_REL_SN_EMPTY, 0);
    }

    /* renamed from: a */
    public final void m5209a(Object obj, int i) {
        if (obj instanceof Byte) {
            m5214a(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            m5214a(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0, i);
        } else if (obj instanceof Short) {
            m5204a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            m5212a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            m5211a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            m5213a(6);
            m5200b((byte) 4, i);
            this.f7656a.putFloat(floatValue);
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            m5213a(10);
            m5200b((byte) 5, i);
            this.f7656a.putDouble(doubleValue);
        } else if (obj instanceof String) {
            m5207a((String) obj, i);
        } else if (obj instanceof Map) {
            m5205a((Map) obj, i);
        } else if (obj instanceof List) {
            m5206a((Collection) ((List) obj), i);
        } else if (obj instanceof AbstractC2479k) {
            m5213a(2);
            m5200b((byte) 10, i);
            ((AbstractC2479k) obj).mo5198a(this);
            m5213a(2);
            m5200b(LOGIN_ACK_REL.LOGIN_ACK_REL_SN_EMPTY, 0);
        } else if (obj instanceof byte[]) {
            m5202a((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            m5213a(8);
            m5200b((byte) 9, i);
            m5212a(zArr.length, 0);
            for (boolean z : zArr) {
                m5214a(z ? (byte) 1 : (byte) 0, 0);
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            m5213a(8);
            m5200b((byte) 9, i);
            m5212a(sArr.length, 0);
            for (short s : sArr) {
                m5204a(s, 0);
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            m5213a(8);
            m5200b((byte) 9, i);
            m5212a(iArr.length, 0);
            for (int i2 : iArr) {
                m5212a(i2, 0);
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            m5213a(8);
            m5200b((byte) 9, i);
            m5212a(jArr.length, 0);
            for (long j : jArr) {
                m5211a(j, 0);
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            m5213a(8);
            m5200b((byte) 9, i);
            m5212a(fArr.length, 0);
            for (float f : fArr) {
                m5213a(6);
                m5200b((byte) 4, 0);
                this.f7656a.putFloat(f);
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            m5213a(8);
            m5200b((byte) 9, i);
            m5212a(dArr.length, 0);
            for (double d : dArr) {
                m5213a(10);
                m5200b((byte) 5, 0);
                this.f7656a.putDouble(d);
            }
        } else if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            m5213a(8);
            m5200b((byte) 9, i);
            m5212a(objArr.length, 0);
            for (Object obj2 : objArr) {
                m5209a(obj2, 0);
            }
        } else if (obj instanceof Collection) {
            m5206a((Collection) obj, i);
        } else {
            throw new C2469b("write object error: unsupport type. " + obj.getClass());
        }
    }

    /* renamed from: a */
    public final int m5208a(String str) {
        this.f7657b = str;
        return 0;
    }
}
