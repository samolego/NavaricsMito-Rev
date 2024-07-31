package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.C2938c;

/* compiled from: Headers.java */
/* renamed from: okhttp3.s */
/* loaded from: classes2.dex */
public final class C2980s {

    /* renamed from: a */
    private final String[] f10583a;

    C2980s(a aVar) {
        this.f10583a = (String[]) aVar.f10584a.toArray(new String[aVar.f10584a.size()]);
    }

    private C2980s(String[] strArr) {
        this.f10583a = strArr;
    }

    @Nullable
    /* renamed from: a */
    public String m10365a(String str) {
        return m10361a(this.f10583a, str);
    }

    /* renamed from: a */
    public int m10363a() {
        return this.f10583a.length / 2;
    }

    /* renamed from: a */
    public String m10364a(int i) {
        return this.f10583a[i * 2];
    }

    /* renamed from: b */
    public String m10366b(int i) {
        return this.f10583a[(i * 2) + 1];
    }

    /* renamed from: b */
    public List<String> m10367b(String str) {
        int m10363a = m10363a();
        ArrayList arrayList = null;
        for (int i = 0; i < m10363a; i++) {
            if (str.equalsIgnoreCase(m10364a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m10366b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* renamed from: b */
    public a m10368b() {
        a aVar = new a();
        Collections.addAll(aVar.f10584a, this.f10583a);
        return aVar;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C2980s) && Arrays.equals(((C2980s) obj).f10583a, this.f10583a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f10583a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int m10363a = m10363a();
        for (int i = 0; i < m10363a; i++) {
            sb.append(m10364a(i));
            sb.append(": ");
            sb.append(m10366b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m10361a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C2980s m10362a(String... strArr) {
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
        return new C2980s(strArr2);
    }

    /* compiled from: Headers.java */
    /* renamed from: okhttp3.s$a */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        final List<String> f10584a = new ArrayList(20);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public a m10370a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return m10374b(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return m10374b("", str.substring(1));
            }
            return m10374b("", str);
        }

        /* renamed from: a */
        public a m10371a(String str, String str2) {
            m10369d(str, str2);
            return m10374b(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public a m10374b(String str, String str2) {
            this.f10584a.add(str);
            this.f10584a.add(str2.trim());
            return this;
        }

        /* renamed from: b */
        public a m10373b(String str) {
            int i = 0;
            while (i < this.f10584a.size()) {
                if (str.equalsIgnoreCase(this.f10584a.get(i))) {
                    this.f10584a.remove(i);
                    this.f10584a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: c */
        public a m10375c(String str, String str2) {
            m10369d(str, str2);
            m10373b(str);
            m10374b(str, str2);
            return this;
        }

        /* renamed from: d */
        private void m10369d(String str, String str2) {
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
                    throw new IllegalArgumentException(C2938c.m9976a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char charAt2 = str2.charAt(i2);
                if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                    throw new IllegalArgumentException(C2938c.m9976a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        /* renamed from: a */
        public C2980s m10372a() {
            return new C2980s(this);
        }
    }
}