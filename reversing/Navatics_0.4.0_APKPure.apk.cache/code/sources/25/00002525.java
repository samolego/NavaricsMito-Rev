package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: MediaType.java */
/* renamed from: okhttp3.v */
/* loaded from: classes2.dex */
public final class C2983v {

    /* renamed from: a */
    private static final Pattern f10603a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b */
    private static final Pattern f10604b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c */
    private final String f10605c;

    /* renamed from: d */
    private final String f10606d;

    /* renamed from: e */
    private final String f10607e;

    /* renamed from: f */
    @Nullable
    private final String f10608f;

    private C2983v(String str, String str2, String str3, @Nullable String str4) {
        this.f10605c = str;
        this.f10606d = str2;
        this.f10607e = str3;
        this.f10608f = str4;
    }

    /* renamed from: a */
    public static C2983v m10434a(String str) {
        Matcher matcher = f10603a.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        String str2 = null;
        Matcher matcher2 = f10604b.matcher(str);
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + '\"');
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                String group2 = matcher2.group(2);
                if (group2 != null) {
                    if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                        group2 = group2.substring(1, group2.length() - 1);
                    }
                } else {
                    group2 = matcher2.group(3);
                }
                if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + group2 + "\" for: \"" + str + '\"');
                }
                str2 = group2;
            }
        }
        return new C2983v(str, lowerCase, lowerCase2, str2);
    }

    @Nullable
    /* renamed from: b */
    public static C2983v m10435b(String str) {
        try {
            return m10434a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String m10436a() {
        return this.f10606d;
    }

    @Nullable
    /* renamed from: b */
    public Charset m10438b() {
        return m10437a((Charset) null);
    }

    @Nullable
    /* renamed from: a */
    public Charset m10437a(@Nullable Charset charset) {
        try {
            return this.f10608f != null ? Charset.forName(this.f10608f) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String toString() {
        return this.f10605c;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C2983v) && ((C2983v) obj).f10605c.equals(this.f10605c);
    }

    public int hashCode() {
        return this.f10605c.hashCode();
    }
}