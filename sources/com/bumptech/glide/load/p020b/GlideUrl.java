package com.bumptech.glide.load.p020b;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.b.g */
/* loaded from: classes.dex */
public class GlideUrl implements Key {

    /* renamed from: b */
    private final Headers f625b;
    @Nullable

    /* renamed from: c */
    private final URL f626c;
    @Nullable

    /* renamed from: d */
    private final String f627d;
    @Nullable

    /* renamed from: e */
    private String f628e;
    @Nullable

    /* renamed from: f */
    private URL f629f;
    @Nullable

    /* renamed from: g */
    private volatile byte[] f630g;

    /* renamed from: h */
    private int f631h;

    public GlideUrl(URL url) {
        this(url, Headers.f633b);
    }

    public GlideUrl(String str) {
        this(str, Headers.f633b);
    }

    public GlideUrl(URL url, Headers headers) {
        this.f626c = (URL) Preconditions.m11580a(url);
        this.f627d = null;
        this.f625b = (Headers) Preconditions.m11580a(headers);
    }

    public GlideUrl(String str, Headers headers) {
        this.f626c = null;
        this.f627d = Preconditions.m11578a(str);
        this.f625b = (Headers) Preconditions.m11580a(headers);
    }

    /* renamed from: a */
    public URL m12343a() throws MalformedURLException {
        return m12339e();
    }

    /* renamed from: e */
    private URL m12339e() throws MalformedURLException {
        if (this.f629f == null) {
            this.f629f = new URL(m12338f());
        }
        return this.f629f;
    }

    /* renamed from: b */
    public String m12342b() {
        return m12338f();
    }

    /* renamed from: f */
    private String m12338f() {
        if (TextUtils.isEmpty(this.f628e)) {
            String str = this.f627d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) Preconditions.m11580a(this.f626c)).toString();
            }
            this.f628e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f628e;
    }

    /* renamed from: c */
    public Map<String, String> m12341c() {
        return this.f625b.mo12336a();
    }

    /* renamed from: d */
    public String m12340d() {
        String str = this.f627d;
        return str != null ? str : ((URL) Preconditions.m11580a(this.f626c)).toString();
    }

    public String toString() {
        return m12340d();
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(m12337g());
    }

    /* renamed from: g */
    private byte[] m12337g() {
        if (this.f630g == null) {
            this.f630g = m12340d().getBytes(f695a);
        }
        return this.f630g;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GlideUrl) {
            GlideUrl glideUrl = (GlideUrl) obj;
            return m12340d().equals(glideUrl.m12340d()) && this.f625b.equals(glideUrl.f625b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.f631h == 0) {
            this.f631h = m12340d().hashCode();
            this.f631h = (this.f631h * 31) + this.f625b.hashCode();
        }
        return this.f631h;
    }
}
