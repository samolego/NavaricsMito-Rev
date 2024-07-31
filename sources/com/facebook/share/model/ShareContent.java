package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.support.annotation.Nullable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareContent.AbstractC1102a;
import com.facebook.share.model.ShareHashtag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ShareContent<P extends ShareContent, E extends AbstractC1102a> implements ShareModel {

    /* renamed from: a */
    private final Uri f2436a;

    /* renamed from: b */
    private final List<String> f2437b;

    /* renamed from: c */
    private final String f2438c;

    /* renamed from: d */
    private final String f2439d;

    /* renamed from: e */
    private final String f2440e;

    /* renamed from: f */
    private final ShareHashtag f2441f;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareContent(AbstractC1102a abstractC1102a) {
        this.f2436a = abstractC1102a.f2442a;
        this.f2437b = abstractC1102a.f2443b;
        this.f2438c = abstractC1102a.f2444c;
        this.f2439d = abstractC1102a.f2445d;
        this.f2440e = abstractC1102a.f2446e;
        this.f2441f = abstractC1102a.f2447f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareContent(Parcel parcel) {
        this.f2436a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2437b = m9892a(parcel);
        this.f2438c = parcel.readString();
        this.f2439d = parcel.readString();
        this.f2440e = parcel.readString();
        this.f2441f = new ShareHashtag.C1104a().m9869a(parcel).m9870a();
    }

    @Nullable
    /* renamed from: h */
    public Uri m9891h() {
        return this.f2436a;
    }

    @Nullable
    /* renamed from: i */
    public List<String> m9890i() {
        return this.f2437b;
    }

    @Nullable
    /* renamed from: j */
    public String m9889j() {
        return this.f2438c;
    }

    @Nullable
    /* renamed from: k */
    public String m9888k() {
        return this.f2439d;
    }

    @Nullable
    /* renamed from: l */
    public String m9887l() {
        return this.f2440e;
    }

    @Nullable
    /* renamed from: m */
    public ShareHashtag m9886m() {
        return this.f2441f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2436a, 0);
        parcel.writeStringList(this.f2437b);
        parcel.writeString(this.f2438c);
        parcel.writeString(this.f2439d);
        parcel.writeString(this.f2440e);
        parcel.writeParcelable(this.f2441f, 0);
    }

    /* renamed from: a */
    private List<String> m9892a(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.size() == 0) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: com.facebook.share.model.ShareContent$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1102a<P extends ShareContent, E extends AbstractC1102a> {

        /* renamed from: a */
        private Uri f2442a;

        /* renamed from: b */
        private List<String> f2443b;

        /* renamed from: c */
        private String f2444c;

        /* renamed from: d */
        private String f2445d;

        /* renamed from: e */
        private String f2446e;

        /* renamed from: f */
        private ShareHashtag f2447f;

        /* renamed from: a */
        public E m9885a(@Nullable Uri uri) {
            this.f2442a = uri;
            return this;
        }

        /* renamed from: a */
        public E m9881a(@Nullable List<String> list) {
            this.f2443b = list == null ? null : Collections.unmodifiableList(list);
            return this;
        }

        /* renamed from: a */
        public E m9882a(@Nullable String str) {
            this.f2444c = str;
            return this;
        }

        /* renamed from: b */
        public E m9879b(@Nullable String str) {
            this.f2445d = str;
            return this;
        }

        /* renamed from: c */
        public E m9877c(@Nullable String str) {
            this.f2446e = str;
            return this;
        }

        /* renamed from: a */
        public E m9883a(@Nullable ShareHashtag shareHashtag) {
            this.f2447f = shareHashtag;
            return this;
        }

        /* renamed from: a */
        public E mo9777a(P p) {
            return p == null ? this : (E) m9885a(p.m9891h()).m9881a(p.m9890i()).m9882a(p.m9889j()).m9879b(p.m9888k()).m9877c(p.m9887l()).m9883a(p.m9886m());
        }
    }
}
