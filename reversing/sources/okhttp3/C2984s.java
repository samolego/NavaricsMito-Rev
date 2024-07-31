package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.C2930c;

/* compiled from: Headers.java */
/* renamed from: okhttp3.s */
/* loaded from: classes2.dex */
public final class C2984s {

    /* renamed from: a */
    private final String[] f10542a;

    C2984s(C2985a c2985a) {
        this.f10542a = (String[]) c2985a.f10543a.toArray(new String[c2985a.f10543a.size()]);
    }

    private C2984s(String[] strArr) {
        this.f10542a = strArr;
    }

    @Nullable
    /* renamed from: a */
    public String m2500a(String str) {
        return m2498a(this.f10542a, str);
    }

    /* renamed from: a */
    public int m2502a() {
        return this.f10542a.length / 2;
    }

    /* renamed from: a */
    public String m2501a(int i) {
        return this.f10542a[i * 2];
    }

    /* renamed from: b */
    public String m2496b(int i) {
        return this.f10542a[(i * 2) + 1];
    }

    /* renamed from: b */
    public List<String> m2495b(String str) {
        int m2502a = m2502a();
        ArrayList arrayList = null;
        for (int i = 0; i < m2502a; i++) {
            if (str.equalsIgnoreCase(m2501a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m2496b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* renamed from: b */
    public C2985a m2497b() {
        C2985a c2985a = new C2985a();
        Collections.addAll(c2985a.f10543a, this.f10542a);
        return c2985a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C2984s) && Arrays.equals(((C2984s) obj).f10542a, this.f10542a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f10542a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int m2502a = m2502a();
        for (int i = 0; i < m2502a; i++) {
            sb.append(m2501a(i));
            sb.append(": ");
            sb.append(m2496b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m2498a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C2984s m2499a(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = strArr2[i].trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
                throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
            }
        }
        return new C2984s(strArr2);
    }

    /* compiled from: Headers.java */
    /* renamed from: okhttp3.s$a */
    /* loaded from: classes2.dex */
    public static final class C2985a {

        /* renamed from: a */
        final List<String> f10543a = new ArrayList(20);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public C2985a m2493a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return m2490b(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return m2490b("", str.substring(1));
            }
            return m2490b("", str);
        }

        /* renamed from: a */
        public C2985a m2492a(String str, String str2) {
            m2488d(str, str2);
            return m2490b(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public C2985a m2490b(String str, String str2) {
            this.f10543a.add(str);
            this.f10543a.add(str2.trim());
            return this;
        }

        /* renamed from: b */
        public C2985a m2491b(String str) {
            int i = 0;
            while (i < this.f10543a.size()) {
                if (str.equalsIgnoreCase(this.f10543a.get(i))) {
                    this.f10543a.remove(i);
                    this.f10543a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: c */
        public C2985a m2489c(String str, String str2) {
            m2488d(str, str2);
            m2491b(str);
            m2490b(str, str2);
            return this;
        }

        /* renamed from: d */
        private void m2488d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(C2930c.m2886a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char charAt2 = str2.charAt(i2);
                if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                    throw new IllegalArgumentException(C2930c.m2886a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        /* renamed from: a */
        public C2984s m2494a() {
            return new C2984s(this);
        }
    }
}
