package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* renamed from: okhttp3.v */
/* loaded from: classes2.dex */
public final class MediaType {

    /* renamed from: a */
    private static final Pattern f10562a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b */
    private static final Pattern f10563b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c */
    private final String f10564c;

    /* renamed from: d */
    private final String f10565d;

    /* renamed from: e */
    private final String f10566e;
    @Nullable

    /* renamed from: f */
    private final String f10567f;

    private MediaType(String str, String str2, String str3, @Nullable String str4) {
        this.f10564c = str;
        this.f10565d = str2;
        this.f10566e = str3;
        this.f10567f = str4;
    }

    /* renamed from: a */
    public static MediaType m2421a(String str) {
        Matcher matcher = f10562a.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        String str2 = null;
        Matcher matcher2 = f10563b.matcher(str);
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
        return new MediaType(str, lowerCase, lowerCase2, str2);
    }

    @Nullable
    /* renamed from: b */
    public static MediaType m2418b(String str) {
        try {
            return m2421a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String m2422a() {
        return this.f10565d;
    }

    @Nullable
    /* renamed from: b */
    public Charset m2419b() {
        return m2420a((Charset) null);
    }

    @Nullable
    /* renamed from: a */
    public Charset m2420a(@Nullable Charset charset) {
        try {
            return this.f10567f != null ? Charset.forName(this.f10567f) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String toString() {
        return this.f10564c;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f10564c.equals(this.f10564c);
    }

    public int hashCode() {
        return this.f10564c.hashCode();
    }
}
