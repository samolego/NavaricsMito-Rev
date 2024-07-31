package com.facebook.appevents.p041c;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.p042ml.ModelManager;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.facebook.appevents.c.f */
/* loaded from: classes.dex */
public final class ViewOnClickListener implements View.OnClickListener {

    /* renamed from: a */
    private static final String f1594a = ViewOnClickListener.class.getCanonicalName();

    /* renamed from: c */
    private static final Set<Integer> f1595c = new HashSet();
    @Nullable

    /* renamed from: b */
    private View.OnClickListener f1596b;

    /* renamed from: d */
    private WeakReference<View> f1597d;

    /* renamed from: e */
    private WeakReference<View> f1598e;

    /* renamed from: f */
    private String f1599f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m11189a(View view, View view2, String str) {
        int hashCode = view.hashCode();
        if (f1595c.contains(Integer.valueOf(hashCode))) {
            return;
        }
        ViewHierarchy.m11106a(view, new ViewOnClickListener(view, view2, str));
        f1595c.add(Integer.valueOf(hashCode));
    }

    private ViewOnClickListener(View view, View view2, String str) {
        this.f1596b = ViewHierarchy.m11097g(view);
        this.f1598e = new WeakReference<>(view);
        this.f1597d = new WeakReference<>(view2);
        this.f1599f = str.toLowerCase().replace("activity", "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.f1596b;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        m11190a();
    }

    /* renamed from: a */
    private void m11190a() {
        View view = this.f1597d.get();
        View view2 = this.f1598e.get();
        if (view == null || view2 == null) {
            return;
        }
        try {
            String m11209a = PredictionHistoryManager.m11209a(view2);
            if (m11209a == null) {
                return;
            }
            String m11099e = ViewHierarchy.m11099e(view2);
            if (m11187a(m11209a, m11099e)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("view", SuggestedEventViewHierarchy.m11205a(view, view2));
            jSONObject.put("screenname", this.f1599f);
            m11186a(m11209a, m11099e, jSONObject);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private static boolean m11187a(String str, final String str2) {
        final String m11208a = PredictionHistoryManager.m11208a(str);
        if (m11208a == null) {
            return false;
        }
        if (m11208a.equals("other")) {
            return true;
        }
        Utility.m10531a(new Runnable() { // from class: com.facebook.appevents.c.f.1
            @Override // java.lang.Runnable
            public void run() {
                ViewOnClickListener.m11184b(m11208a, str2, new float[0]);
            }
        });
        return true;
    }

    /* renamed from: a */
    private void m11186a(final String str, final String str2, final JSONObject jSONObject) {
        Utility.m10531a(new Runnable() { // from class: com.facebook.appevents.c.f.2
            @Override // java.lang.Runnable
            public void run() {
                String m10933a;
                try {
                    String lowerCase = Utility.m10481g(FacebookSdk.m10869h()).toLowerCase();
                    float[] m11218a = FeatureExtractor.m11218a(jSONObject, lowerCase);
                    String m11221a = FeatureExtractor.m11221a(str2, ViewOnClickListener.this.f1599f, lowerCase);
                    if (m11218a == null || (m10933a = ModelManager.m10933a("SUGGEST_EVENT", m11218a, m11221a)) == null) {
                        return;
                    }
                    PredictionHistoryManager.m11207a(str, m10933a);
                    if (m10933a.equals("other")) {
                        return;
                    }
                    ViewOnClickListener.m11184b(m10933a, str2, m11218a);
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m11184b(String str, String str2, float[] fArr) {
        if (SuggestedEventsManager.m11201a(str)) {
            new InternalAppEventsLogger(FacebookSdk.m10869h()).m11058a(str, str2);
        } else if (SuggestedEventsManager.m11199b(str)) {
            m11183c(str, str2, fArr);
        }
    }

    /* renamed from: c */
    private static void m11183c(String str, String str2, float[] fArr) {
        Bundle bundle = new Bundle();
        try {
            bundle.putString("event_name", str);
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder();
            for (float f : fArr) {
                sb.append(f);
                sb.append(",");
            }
            jSONObject.put("dense", sb.toString());
            jSONObject.put("button_text", str2);
            bundle.putString("metadata", jSONObject.toString());
            GraphRequest m11394a = GraphRequest.m11394a((AccessToken) null, String.format(Locale.US, "%s/suggested_events", FacebookSdk.m10865l()), (JSONObject) null, (GraphRequest.InterfaceC0829b) null);
            m11394a.m11397a(bundle);
            m11394a.m11349i();
        } catch (JSONException unused) {
        }
    }
}
