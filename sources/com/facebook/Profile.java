package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() { // from class: com.facebook.Profile.2
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Profile createFromParcel(Parcel parcel) {
            return new Profile(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Profile[] newArray(int i) {
            return new Profile[i];
        }
    };

    /* renamed from: a */
    private static final String f1511a = "Profile";
    @Nullable

    /* renamed from: b */
    private final String f1512b;
    @Nullable

    /* renamed from: c */
    private final String f1513c;
    @Nullable

    /* renamed from: d */
    private final String f1514d;
    @Nullable

    /* renamed from: e */
    private final String f1515e;
    @Nullable

    /* renamed from: f */
    private final String f1516f;
    @Nullable

    /* renamed from: g */
    private final Uri f1517g;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    public static Profile m11320a() {
        return ProfileManager.m10403a().m10399b();
    }

    /* renamed from: a */
    public static void m11319a(@Nullable Profile profile) {
        ProfileManager.m10403a().m10402a(profile);
    }

    /* renamed from: b */
    public static void m11318b() {
        AccessToken m11457a = AccessToken.m11457a();
        if (!AccessToken.m11451b()) {
            m11319a(null);
        } else {
            Utility.m10529a(m11457a.m11448d(), new Utility.InterfaceC0984a() { // from class: com.facebook.Profile.1
                @Override // com.facebook.internal.Utility.InterfaceC0984a
                /* renamed from: a */
                public void mo10341a(JSONObject jSONObject) {
                    String optString = jSONObject.optString("id");
                    if (optString == null) {
                        return;
                    }
                    String optString2 = jSONObject.optString("link");
                    Profile.m11319a(new Profile(optString, jSONObject.optString("first_name"), jSONObject.optString("middle_name"), jSONObject.optString("last_name"), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
                }

                @Override // com.facebook.internal.Utility.InterfaceC0984a
                /* renamed from: a */
                public void mo10342a(FacebookException facebookException) {
                    String str = Profile.f1511a;
                    Log.e(str, "Got unexpected exception: " + facebookException);
                }
            });
        }
    }

    public Profile(String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Uri uri) {
        Validate.m10468a(str, "id");
        this.f1512b = str;
        this.f1513c = str2;
        this.f1514d = str3;
        this.f1515e = str4;
        this.f1516f = str5;
        this.f1517g = uri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Profile) {
            Profile profile = (Profile) obj;
            if (this.f1512b.equals(profile.f1512b) && this.f1513c == null) {
                return profile.f1513c == null;
            } else if (this.f1513c.equals(profile.f1513c) && this.f1514d == null) {
                return profile.f1514d == null;
            } else if (this.f1514d.equals(profile.f1514d) && this.f1515e == null) {
                return profile.f1515e == null;
            } else if (this.f1515e.equals(profile.f1515e) && this.f1516f == null) {
                return profile.f1516f == null;
            } else if (this.f1516f.equals(profile.f1516f) && this.f1517g == null) {
                return profile.f1517g == null;
            } else {
                return this.f1517g.equals(profile.f1517g);
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = 527 + this.f1512b.hashCode();
        String str = this.f1513c;
        if (str != null) {
            hashCode = (hashCode * 31) + str.hashCode();
        }
        String str2 = this.f1514d;
        if (str2 != null) {
            hashCode = (hashCode * 31) + str2.hashCode();
        }
        String str3 = this.f1515e;
        if (str3 != null) {
            hashCode = (hashCode * 31) + str3.hashCode();
        }
        String str4 = this.f1516f;
        if (str4 != null) {
            hashCode = (hashCode * 31) + str4.hashCode();
        }
        Uri uri = this.f1517g;
        return uri != null ? (hashCode * 31) + uri.hashCode() : hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public JSONObject m11317c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f1512b);
            jSONObject.put("first_name", this.f1513c);
            jSONObject.put("middle_name", this.f1514d);
            jSONObject.put("last_name", this.f1515e);
            jSONObject.put("name", this.f1516f);
            if (this.f1517g != null) {
                jSONObject.put("link_uri", this.f1517g.toString());
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Profile(JSONObject jSONObject) {
        this.f1512b = jSONObject.optString("id", null);
        this.f1513c = jSONObject.optString("first_name", null);
        this.f1514d = jSONObject.optString("middle_name", null);
        this.f1515e = jSONObject.optString("last_name", null);
        this.f1516f = jSONObject.optString("name", null);
        String optString = jSONObject.optString("link_uri", null);
        this.f1517g = optString != null ? Uri.parse(optString) : null;
    }

    private Profile(Parcel parcel) {
        this.f1512b = parcel.readString();
        this.f1513c = parcel.readString();
        this.f1514d = parcel.readString();
        this.f1515e = parcel.readString();
        this.f1516f = parcel.readString();
        String readString = parcel.readString();
        this.f1517g = readString == null ? null : Uri.parse(readString);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1512b);
        parcel.writeString(this.f1513c);
        parcel.writeString(this.f1514d);
        parcel.writeString(this.f1515e);
        parcel.writeString(this.f1516f);
        Uri uri = this.f1517g;
        parcel.writeString(uri == null ? null : uri.toString());
    }
}
