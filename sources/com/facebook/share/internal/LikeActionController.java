package com.facebook.share.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p008v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Logger;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.internal.WorkQueue;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.widget.LikeView;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@Deprecated
/* renamed from: com.facebook.share.internal.c */
/* loaded from: classes.dex */
public class LikeActionController {

    /* renamed from: a */
    private static final String f2298a = "c";

    /* renamed from: b */
    private static FileLruCache f2299b;

    /* renamed from: c */
    private static final ConcurrentHashMap<String, LikeActionController> f2300c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private static WorkQueue f2301d = new WorkQueue(1);

    /* renamed from: e */
    private static WorkQueue f2302e = new WorkQueue(1);

    /* renamed from: f */
    private static Handler f2303f;

    /* renamed from: g */
    private static String f2304g;

    /* renamed from: h */
    private static boolean f2305h;

    /* renamed from: i */
    private static volatile int f2306i;

    /* renamed from: j */
    private static AccessTokenTracker f2307j;

    /* renamed from: k */
    private String f2308k;

    /* renamed from: l */
    private LikeView.ObjectType f2309l;

    /* renamed from: m */
    private boolean f2310m;

    /* renamed from: n */
    private String f2311n;

    /* renamed from: o */
    private String f2312o;

    /* renamed from: p */
    private String f2313p;

    /* renamed from: q */
    private String f2314q;

    /* renamed from: r */
    private String f2315r;

    /* renamed from: s */
    private String f2316s;

    /* renamed from: t */
    private boolean f2317t;

    /* renamed from: u */
    private boolean f2318u;

    /* renamed from: v */
    private boolean f2319v;

    /* renamed from: w */
    private Bundle f2320w;

    /* renamed from: x */
    private InternalAppEventsLogger f2321x;

    /* compiled from: LikeActionController.java */
    @Deprecated
    /* renamed from: com.facebook.share.internal.c$c */
    /* loaded from: classes.dex */
    public interface InterfaceC1059c {
        /* renamed from: a */
        void mo9719a(LikeActionController likeActionController, FacebookException facebookException);
    }

    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$i */
    /* loaded from: classes.dex */
    private interface InterfaceC1065i extends InterfaceC1070n {
        /* renamed from: b */
        boolean mo10079b();

        /* renamed from: c */
        String mo10078c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$m */
    /* loaded from: classes.dex */
    public interface InterfaceC1069m {
        /* renamed from: a */
        void mo10075a();
    }

    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$n */
    /* loaded from: classes.dex */
    private interface InterfaceC1070n {
        /* renamed from: a */
        FacebookRequestError mo10074a();

        /* renamed from: a */
        void mo10073a(GraphRequestBatch graphRequestBatch);
    }

    @Deprecated
    /* renamed from: e */
    public boolean m10105e() {
        return false;
    }

    @Deprecated
    /* renamed from: a */
    public static void m10134a(String str, LikeView.ObjectType objectType, InterfaceC1059c interfaceC1059c) {
        if (!f2305h) {
            m10094j();
        }
        LikeActionController m10138a = m10138a(str);
        if (m10138a != null) {
            m10144a(m10138a, objectType, interfaceC1059c);
        } else {
            f2302e.m10421a(new RunnableC1058b(str, objectType, interfaceC1059c));
        }
    }

    /* renamed from: a */
    private static void m10144a(LikeActionController likeActionController, LikeView.ObjectType objectType, InterfaceC1059c interfaceC1059c) {
        FacebookException facebookException;
        LikeView.ObjectType m9946a = ShareInternalUtility.m9946a(objectType, likeActionController.f2309l);
        if (m9946a == null) {
            facebookException = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", likeActionController.f2308k, likeActionController.f2309l.toString(), objectType.toString());
            likeActionController = null;
        } else {
            likeActionController.f2309l = m9946a;
            facebookException = null;
        }
        m10148a(interfaceC1059c, likeActionController, facebookException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m10112c(String str, LikeView.ObjectType objectType, InterfaceC1059c interfaceC1059c) {
        LikeActionController m10138a = m10138a(str);
        if (m10138a != null) {
            m10144a(m10138a, objectType, interfaceC1059c);
            return;
        }
        LikeActionController m10122b = m10122b(str);
        if (m10122b == null) {
            m10122b = new LikeActionController(str, objectType);
            m10089l(m10122b);
        }
        m10135a(str, m10122b);
        f2303f.post(new Runnable() { // from class: com.facebook.share.internal.c.4
            @Override // java.lang.Runnable
            public void run() {
                LikeActionController.this.m10086n();
            }
        });
        m10148a(interfaceC1059c, m10122b, (FacebookException) null);
    }

    /* renamed from: j */
    private static synchronized void m10094j() {
        synchronized (LikeActionController.class) {
            if (f2305h) {
                return;
            }
            f2303f = new Handler(Looper.getMainLooper());
            f2306i = FacebookSdk.m10869h().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getInt("OBJECT_SUFFIX", 1);
            f2299b = new FileLruCache(f2298a, new FileLruCache.C0965c());
            m10092k();
            CallbackManagerImpl.m10820a(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), new CallbackManagerImpl.InterfaceC0921a() { // from class: com.facebook.share.internal.c.5
            });
            f2305h = true;
        }
    }

    /* renamed from: a */
    private static void m10148a(final InterfaceC1059c interfaceC1059c, final LikeActionController likeActionController, final FacebookException facebookException) {
        if (interfaceC1059c == null) {
            return;
        }
        f2303f.post(new Runnable() { // from class: com.facebook.share.internal.c.6
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC1059c.this.mo9719a(likeActionController, facebookException);
            }
        });
    }

    /* renamed from: k */
    private static void m10092k() {
        f2307j = new AccessTokenTracker() { // from class: com.facebook.share.internal.c.7
            @Override // com.facebook.AccessTokenTracker
            /* renamed from: a */
            protected void mo10083a(AccessToken accessToken, AccessToken accessToken2) {
                Context m10869h = FacebookSdk.m10869h();
                if (accessToken2 == null) {
                    int unused = LikeActionController.f2306i = (LikeActionController.f2306i + 1) % 1000;
                    m10869h.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", LikeActionController.f2306i).apply();
                    LikeActionController.f2300c.clear();
                    LikeActionController.f2299b.m10672a();
                }
                LikeActionController.m10108d((LikeActionController) null, "com.facebook.sdk.LikeActionController.DID_RESET");
            }
        };
    }

    /* renamed from: a */
    private static void m10135a(String str, LikeActionController likeActionController) {
        String m10106d = m10106d(str);
        f2301d.m10421a(new RunnableC1066j(m10106d, true));
        f2300c.put(m10106d, likeActionController);
    }

    /* renamed from: a */
    private static LikeActionController m10138a(String str) {
        String m10106d = m10106d(str);
        LikeActionController likeActionController = f2300c.get(m10106d);
        if (likeActionController != null) {
            f2301d.m10421a(new RunnableC1066j(m10106d, false));
        }
        return likeActionController;
    }

    /* renamed from: l */
    private static void m10089l(LikeActionController likeActionController) {
        String m10087m = m10087m(likeActionController);
        String m10106d = m10106d(likeActionController.f2308k);
        if (Utility.m10530a(m10087m) || Utility.m10530a(m10106d)) {
            return;
        }
        f2302e.m10421a(new RunnableC1071o(m10106d, m10087m));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m10120b(String str, String str2) {
        OutputStream outputStream = null;
        try {
            try {
                outputStream = f2299b.m10664b(str);
                outputStream.write(str2.getBytes());
                if (outputStream == null) {
                    return;
                }
            } catch (IOException e) {
                Log.e(f2298a, "Unable to serialize controller to disk", e);
                if (outputStream == null) {
                    return;
                }
            }
            Utility.m10538a(outputStream);
        } catch (Throwable th) {
            if (outputStream != null) {
                Utility.m10538a(outputStream);
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r5 != null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        com.facebook.internal.Utility.m10538a((java.io.Closeable) r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if (r5 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.facebook.share.internal.LikeActionController m10122b(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.String r5 = m10106d(r5)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L29
            com.facebook.internal.m r1 = com.facebook.share.internal.LikeActionController.f2299b     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L29
            java.io.InputStream r5 = r1.m10669a(r5)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L29
            if (r5 == 0) goto L1e
            java.lang.String r1 = com.facebook.internal.Utility.m10536a(r5)     // Catch: java.io.IOException -> L1c java.lang.Throwable -> L36
            boolean r2 = com.facebook.internal.Utility.m10530a(r1)     // Catch: java.io.IOException -> L1c java.lang.Throwable -> L36
            if (r2 != 0) goto L1e
            com.facebook.share.internal.c r0 = m10113c(r1)     // Catch: java.io.IOException -> L1c java.lang.Throwable -> L36
            goto L1e
        L1c:
            r1 = move-exception
            goto L2b
        L1e:
            if (r5 == 0) goto L35
        L20:
            com.facebook.internal.Utility.m10538a(r5)
            goto L35
        L24:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L37
        L29:
            r1 = move-exception
            r5 = r0
        L2b:
            java.lang.String r2 = com.facebook.share.internal.LikeActionController.f2298a     // Catch: java.lang.Throwable -> L36
            java.lang.String r3 = "Unable to deserialize controller from disk"
            android.util.Log.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L36
            if (r5 == 0) goto L35
            goto L20
        L35:
            return r0
        L36:
            r0 = move-exception
        L37:
            if (r5 == 0) goto L3c
            com.facebook.internal.Utility.m10538a(r5)
        L3c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.LikeActionController.m10122b(java.lang.String):com.facebook.share.internal.c");
    }

    /* renamed from: c */
    private static LikeActionController m10113c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("com.facebook.share.internal.LikeActionController.version", -1) != 3) {
                return null;
            }
            LikeActionController likeActionController = new LikeActionController(jSONObject.getString("object_id"), LikeView.ObjectType.fromInt(jSONObject.optInt("object_type", LikeView.ObjectType.UNKNOWN.getValue())));
            likeActionController.f2311n = jSONObject.optString("like_count_string_with_like", null);
            likeActionController.f2312o = jSONObject.optString("like_count_string_without_like", null);
            likeActionController.f2313p = jSONObject.optString("social_sentence_with_like", null);
            likeActionController.f2314q = jSONObject.optString("social_sentence_without_like", null);
            likeActionController.f2310m = jSONObject.optBoolean("is_object_liked");
            likeActionController.f2315r = jSONObject.optString("unlike_token", null);
            JSONObject optJSONObject = jSONObject.optJSONObject("facebook_dialog_analytics_bundle");
            if (optJSONObject != null) {
                likeActionController.f2320w = BundleJSONConverter.m10739a(optJSONObject);
            }
            return likeActionController;
        } catch (JSONException e) {
            Log.e(f2298a, "Unable to deserialize controller from JSON", e);
            return null;
        }
    }

    /* renamed from: m */
    private static String m10087m(LikeActionController likeActionController) {
        JSONObject m10740a;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("com.facebook.share.internal.LikeActionController.version", 3);
            jSONObject.put("object_id", likeActionController.f2308k);
            jSONObject.put("object_type", likeActionController.f2309l.getValue());
            jSONObject.put("like_count_string_with_like", likeActionController.f2311n);
            jSONObject.put("like_count_string_without_like", likeActionController.f2312o);
            jSONObject.put("social_sentence_with_like", likeActionController.f2313p);
            jSONObject.put("social_sentence_without_like", likeActionController.f2314q);
            jSONObject.put("is_object_liked", likeActionController.f2310m);
            jSONObject.put("unlike_token", likeActionController.f2315r);
            if (likeActionController.f2320w != null && (m10740a = BundleJSONConverter.m10740a(likeActionController.f2320w)) != null) {
                jSONObject.put("facebook_dialog_analytics_bundle", m10740a);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.e(f2298a, "Unable to serialize controller to JSON", e);
            return null;
        }
    }

    /* renamed from: d */
    private static String m10106d(String str) {
        String m11448d = AccessToken.m11451b() ? AccessToken.m11457a().m11448d() : null;
        if (m11448d != null) {
            m11448d = Utility.m10506b(m11448d);
        }
        return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", str, Utility.m10527a(m11448d, ""), Integer.valueOf(f2306i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m10108d(LikeActionController likeActionController, String str) {
        m10124b(likeActionController, str, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m10124b(LikeActionController likeActionController, String str, Bundle bundle) {
        Intent intent = new Intent(str);
        if (likeActionController != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", likeActionController.m10152a());
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(FacebookSdk.m10869h()).sendBroadcast(intent);
    }

    private LikeActionController(String str, LikeView.ObjectType objectType) {
        this.f2308k = str;
        this.f2309l = objectType;
    }

    @Deprecated
    /* renamed from: a */
    public String m10152a() {
        return this.f2308k;
    }

    @Deprecated
    /* renamed from: b */
    public String m10129b() {
        return this.f2310m ? this.f2311n : this.f2312o;
    }

    @Deprecated
    /* renamed from: c */
    public String m10118c() {
        return this.f2310m ? this.f2313p : this.f2314q;
    }

    @Deprecated
    /* renamed from: d */
    public boolean m10111d() {
        return this.f2310m;
    }

    @Deprecated
    /* renamed from: a */
    public void m10150a(Activity activity, FragmentWrapper fragmentWrapper, Bundle bundle) {
        boolean z = !this.f2310m;
        if (m10088m()) {
            m10119b(z);
            if (this.f2319v) {
                m10090l().m11053b("fb_like_control_did_undo_quickly", bundle);
                return;
            } else if (m10131a(z, bundle)) {
                return;
            } else {
                m10119b(z ? false : true);
                m10128b(activity, fragmentWrapper, bundle);
                return;
            }
        }
        m10128b(activity, fragmentWrapper, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public InternalAppEventsLogger m10090l() {
        if (this.f2321x == null) {
            this.f2321x = new InternalAppEventsLogger(FacebookSdk.m10869h());
        }
        return this.f2321x;
    }

    /* renamed from: a */
    private boolean m10131a(boolean z, Bundle bundle) {
        if (m10088m()) {
            if (z) {
                m10127b(bundle);
                return true;
            } else if (!Utility.m10530a(this.f2315r)) {
                m10117c(bundle);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10132a(boolean z) {
        m10119b(z);
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
        m10124b(this, "com.facebook.sdk.LikeActionController.DID_ERROR", bundle);
    }

    /* renamed from: b */
    private void m10119b(boolean z) {
        m10130a(z, this.f2311n, this.f2312o, this.f2313p, this.f2314q, this.f2315r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10130a(boolean z, String str, String str2, String str3, String str4, String str5) {
        String m10527a = Utility.m10527a(str, (String) null);
        String m10527a2 = Utility.m10527a(str2, (String) null);
        String m10527a3 = Utility.m10527a(str3, (String) null);
        String m10527a4 = Utility.m10527a(str4, (String) null);
        String m10527a5 = Utility.m10527a(str5, (String) null);
        if ((z == this.f2310m && Utility.m10533a(m10527a, this.f2311n) && Utility.m10533a(m10527a2, this.f2312o) && Utility.m10533a(m10527a3, this.f2313p) && Utility.m10533a(m10527a4, this.f2314q) && Utility.m10533a(m10527a5, this.f2315r)) ? false : true) {
            this.f2310m = z;
            this.f2311n = m10527a;
            this.f2312o = m10527a2;
            this.f2313p = m10527a3;
            this.f2314q = m10527a4;
            this.f2315r = m10527a5;
            m10089l(this);
            m10108d(this, "com.facebook.sdk.LikeActionController.UPDATED");
        }
    }

    /* renamed from: b */
    private void m10128b(Activity activity, FragmentWrapper fragmentWrapper, Bundle bundle) {
        String objectType;
        String str = null;
        if (LikeDialog.m10068e()) {
            str = "fb_like_control_did_present_dialog";
        } else if (LikeDialog.m10067f()) {
            str = "fb_like_control_did_present_fallback_dialog";
        } else {
            m10137a("present_dialog", bundle);
            Utility.m10505b(f2298a, "Cannot show the Like Dialog on this device.");
            m10108d((LikeActionController) null, "com.facebook.sdk.LikeActionController.UPDATED");
        }
        if (str != null) {
            LikeView.ObjectType objectType2 = this.f2309l;
            if (objectType2 != null) {
                objectType = objectType2.toString();
            } else {
                objectType = LikeView.ObjectType.UNKNOWN.toString();
            }
            LikeContent m10174a = new LikeContent.C1038a().m10172a(this.f2308k).m10170b(objectType).m10174a();
            if (fragmentWrapper != null) {
                new LikeDialog(fragmentWrapper).mo10070b(m10174a);
            } else {
                new LikeDialog(activity).mo10070b(m10174a);
            }
            m10149a(bundle);
            m10090l().m11053b("fb_like_control_did_present_dialog", bundle);
        }
    }

    /* renamed from: a */
    private void m10149a(Bundle bundle) {
        m10103e(this.f2308k);
        this.f2320w = bundle;
        m10089l(this);
    }

    /* renamed from: e */
    private static void m10103e(String str) {
        f2304g = str;
        FacebookSdk.m10869h().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", f2304g).apply();
    }

    /* renamed from: m */
    private boolean m10088m() {
        AccessToken m11457a = AccessToken.m11457a();
        return (this.f2317t || this.f2316s == null || !AccessToken.m11451b() || m11457a.m11445g() == null || !m11457a.m11445g().contains("publish_actions")) ? false : true;
    }

    /* renamed from: b */
    private void m10127b(final Bundle bundle) {
        this.f2319v = true;
        m10147a(new InterfaceC1069m() { // from class: com.facebook.share.internal.c.8
            @Override // com.facebook.share.internal.LikeActionController.InterfaceC1069m
            /* renamed from: a */
            public void mo10075a() {
                if (Utility.m10530a(LikeActionController.this.f2316s)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
                    LikeActionController.m10124b(LikeActionController.this, "com.facebook.sdk.LikeActionController.DID_ERROR", bundle2);
                    return;
                }
                GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
                LikeActionController likeActionController = LikeActionController.this;
                final C1067k c1067k = new C1067k(likeActionController.f2316s, LikeActionController.this.f2309l);
                c1067k.mo10073a(graphRequestBatch);
                graphRequestBatch.m10844a(new GraphRequestBatch.InterfaceC0919a() { // from class: com.facebook.share.internal.c.8.1
                    @Override // com.facebook.GraphRequestBatch.InterfaceC0919a
                    /* renamed from: a */
                    public void mo10082a(GraphRequestBatch graphRequestBatch2) {
                        LikeActionController.this.f2319v = false;
                        if (c1067k.mo10074a() != null) {
                            LikeActionController.this.m10132a(false);
                            return;
                        }
                        LikeActionController.this.f2315r = Utility.m10527a(c1067k.f2373e, (String) null);
                        LikeActionController.this.f2318u = true;
                        LikeActionController.this.m10090l().m11059a("fb_like_control_did_like", (Double) null, bundle);
                        LikeActionController.this.m10110d(bundle);
                    }
                });
                graphRequestBatch.m10835h();
            }
        });
    }

    /* renamed from: c */
    private void m10117c(final Bundle bundle) {
        this.f2319v = true;
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        final C1068l c1068l = new C1068l(this.f2315r);
        c1068l.mo10073a(graphRequestBatch);
        graphRequestBatch.m10844a(new GraphRequestBatch.InterfaceC0919a() { // from class: com.facebook.share.internal.c.9
            @Override // com.facebook.GraphRequestBatch.InterfaceC0919a
            /* renamed from: a */
            public void mo10082a(GraphRequestBatch graphRequestBatch2) {
                LikeActionController.this.f2319v = false;
                if (c1068l.mo10074a() != null) {
                    LikeActionController.this.m10132a(true);
                    return;
                }
                LikeActionController.this.f2315r = null;
                LikeActionController.this.f2318u = false;
                LikeActionController.this.m10090l().m11059a("fb_like_control_did_unlike", (Double) null, bundle);
                LikeActionController.this.m10110d(bundle);
            }
        });
        graphRequestBatch.m10835h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m10086n() {
        if (!AccessToken.m11451b()) {
            m10085o();
        } else {
            m10147a(new InterfaceC1069m() { // from class: com.facebook.share.internal.c.10
                @Override // com.facebook.share.internal.LikeActionController.InterfaceC1069m
                /* renamed from: a */
                public void mo10075a() {
                    final InterfaceC1065i c1064h;
                    if (C10483.f2331a[LikeActionController.this.f2309l.ordinal()] == 1) {
                        LikeActionController likeActionController = LikeActionController.this;
                        c1064h = new C1064h(likeActionController.f2316s);
                    } else {
                        LikeActionController likeActionController2 = LikeActionController.this;
                        c1064h = new C1062f(likeActionController2.f2316s, LikeActionController.this.f2309l);
                    }
                    LikeActionController likeActionController3 = LikeActionController.this;
                    final C1060d c1060d = new C1060d(likeActionController3.f2316s, LikeActionController.this.f2309l);
                    GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
                    c1064h.mo10073a(graphRequestBatch);
                    c1060d.mo10073a(graphRequestBatch);
                    graphRequestBatch.m10844a(new GraphRequestBatch.InterfaceC0919a() { // from class: com.facebook.share.internal.c.10.1
                        @Override // com.facebook.GraphRequestBatch.InterfaceC0919a
                        /* renamed from: a */
                        public void mo10082a(GraphRequestBatch graphRequestBatch2) {
                            if (c1064h.mo10074a() == null && c1060d.mo10074a() == null) {
                                LikeActionController.this.m10130a(c1064h.mo10079b(), c1060d.f2352e, c1060d.f2353f, c1060d.f2354g, c1060d.f2355h, c1064h.mo10078c());
                            } else {
                                Logger.m10633a(LoggingBehavior.REQUESTS, LikeActionController.f2298a, "Unable to refresh like state for id: '%s'", LikeActionController.this.f2308k);
                            }
                        }
                    });
                    graphRequestBatch.m10835h();
                }
            });
        }
    }

    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$3 */
    /* loaded from: classes.dex */
    static /* synthetic */ class C10483 {

        /* renamed from: a */
        static final /* synthetic */ int[] f2331a = new int[LikeView.ObjectType.values().length];

        static {
            try {
                f2331a[LikeView.ObjectType.PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: o */
    private void m10085o() {
        LikeStatusClient likeStatusClient = new LikeStatusClient(FacebookSdk.m10869h(), FacebookSdk.m10865l(), this.f2308k);
        if (likeStatusClient.m10564a()) {
            likeStatusClient.m10562a(new PlatformServiceClient.InterfaceC0981a() { // from class: com.facebook.share.internal.c.1
                @Override // com.facebook.internal.PlatformServiceClient.InterfaceC0981a
                /* renamed from: a */
                public void mo10084a(Bundle bundle) {
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    String str5;
                    if (bundle == null || !bundle.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED")) {
                        return;
                    }
                    boolean z = bundle.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
                    if (!bundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE")) {
                        str = LikeActionController.this.f2311n;
                    } else {
                        str = bundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
                    }
                    if (!bundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE")) {
                        str2 = LikeActionController.this.f2312o;
                    } else {
                        str2 = bundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
                    }
                    if (!bundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE")) {
                        str3 = LikeActionController.this.f2313p;
                    } else {
                        str3 = bundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
                    }
                    if (!bundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE")) {
                        str4 = LikeActionController.this.f2314q;
                    } else {
                        str4 = bundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
                    }
                    if (!bundle.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN")) {
                        str5 = LikeActionController.this.f2315r;
                    } else {
                        str5 = bundle.getString("com.facebook.platform.extra.UNLIKE_TOKEN");
                    }
                    LikeActionController.this.m10130a(z, str, str2, str3, str4, str5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m10110d(Bundle bundle) {
        boolean z = this.f2310m;
        if (z == this.f2318u || m10131a(z, bundle)) {
            return;
        }
        m10132a(!this.f2310m);
    }

    /* renamed from: a */
    private void m10147a(final InterfaceC1069m interfaceC1069m) {
        if (!Utility.m10530a(this.f2316s)) {
            if (interfaceC1069m != null) {
                interfaceC1069m.mo10075a();
                return;
            }
            return;
        }
        final C1061e c1061e = new C1061e(this.f2308k, this.f2309l);
        final C1063g c1063g = new C1063g(this.f2308k, this.f2309l);
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        c1061e.mo10073a(graphRequestBatch);
        c1063g.mo10073a(graphRequestBatch);
        graphRequestBatch.m10844a(new GraphRequestBatch.InterfaceC0919a() { // from class: com.facebook.share.internal.c.2
            @Override // com.facebook.GraphRequestBatch.InterfaceC0919a
            /* renamed from: a */
            public void mo10082a(GraphRequestBatch graphRequestBatch2) {
                FacebookRequestError a;
                LikeActionController.this.f2316s = c1061e.f2357e;
                if (Utility.m10530a(LikeActionController.this.f2316s)) {
                    LikeActionController.this.f2316s = c1063g.f2364e;
                    LikeActionController.this.f2317t = c1063g.f2365f;
                }
                if (Utility.m10530a(LikeActionController.this.f2316s)) {
                    Logger.m10633a(LoggingBehavior.DEVELOPER_ERRORS, LikeActionController.f2298a, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", LikeActionController.this.f2308k);
                    LikeActionController likeActionController = LikeActionController.this;
                    if (c1063g.mo10074a() != null) {
                        a = c1063g.mo10074a();
                    } else {
                        a = c1061e.mo10074a();
                    }
                    likeActionController.m10136a("get_verified_id", a);
                }
                InterfaceC1069m interfaceC1069m2 = interfaceC1069m;
                if (interfaceC1069m2 != null) {
                    interfaceC1069m2.mo10075a();
                }
            }
        });
        graphRequestBatch.m10835h();
    }

    /* renamed from: a */
    private void m10137a(String str, Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("object_id", this.f2308k);
        bundle2.putString("object_type", this.f2309l.toString());
        bundle2.putString("current_action", str);
        m10090l().m11059a("fb_like_control_error", (Double) null, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10136a(String str, FacebookRequestError facebookRequestError) {
        JSONObject m11404f;
        Bundle bundle = new Bundle();
        if (facebookRequestError != null && (m11404f = facebookRequestError.m11404f()) != null) {
            bundle.putString(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, m11404f.toString());
        }
        m10137a(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$e */
    /* loaded from: classes.dex */
    public class C1061e extends AbstractC1056a {

        /* renamed from: e */
        String f2357e;

        C1061e(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "og_object.fields(id)");
            bundle.putString("ids", str);
            m10081a(new GraphRequest(AccessToken.m11457a(), "", bundle, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10077a(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.m11405e().contains("og_object")) {
                this.f2345c = null;
            } else {
                Logger.m10633a(LoggingBehavior.REQUESTS, LikeActionController.f2298a, "Error getting the FB id for object '%s' with type '%s' : %s", this.f2343a, this.f2344b, facebookRequestError);
            }
        }

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10076a(GraphResponse graphResponse) {
            JSONObject optJSONObject;
            JSONObject m10502b = Utility.m10502b(graphResponse.m10824b(), this.f2343a);
            if (m10502b == null || (optJSONObject = m10502b.optJSONObject("og_object")) == null) {
                return;
            }
            this.f2357e = optJSONObject.optString("id");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$g */
    /* loaded from: classes.dex */
    public class C1063g extends AbstractC1056a {

        /* renamed from: e */
        String f2364e;

        /* renamed from: f */
        boolean f2365f;

        C1063g(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id");
            bundle.putString("ids", str);
            m10081a(new GraphRequest(AccessToken.m11457a(), "", bundle, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10076a(GraphResponse graphResponse) {
            JSONObject m10502b = Utility.m10502b(graphResponse.m10824b(), this.f2343a);
            if (m10502b != null) {
                this.f2364e = m10502b.optString("id");
                this.f2365f = !Utility.m10530a(this.f2364e);
            }
        }

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10077a(FacebookRequestError facebookRequestError) {
            Logger.m10633a(LoggingBehavior.REQUESTS, LikeActionController.f2298a, "Error getting the FB id for object '%s' with type '%s' : %s", this.f2343a, this.f2344b, facebookRequestError);
        }
    }

    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$k */
    /* loaded from: classes.dex */
    private class C1067k extends AbstractC1056a {

        /* renamed from: e */
        String f2373e;

        C1067k(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("object", str);
            m10081a(new GraphRequest(AccessToken.m11457a(), "me/og.likes", bundle, HttpMethod.POST));
        }

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10076a(GraphResponse graphResponse) {
            this.f2373e = Utility.m10513a(graphResponse.m10824b(), "id");
        }

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10077a(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.m11408b() == 3501) {
                this.f2345c = null;
                return;
            }
            Logger.m10633a(LoggingBehavior.REQUESTS, LikeActionController.f2298a, "Error liking object '%s' with type '%s' : %s", this.f2343a, this.f2344b, facebookRequestError);
            LikeActionController.this.m10136a("publish_like", facebookRequestError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$l */
    /* loaded from: classes.dex */
    public class C1068l extends AbstractC1056a {

        /* renamed from: f */
        private String f2376f;

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10076a(GraphResponse graphResponse) {
        }

        C1068l(String str) {
            super(null, null);
            this.f2376f = str;
            m10081a(new GraphRequest(AccessToken.m11457a(), str, null, HttpMethod.DELETE));
        }

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10077a(FacebookRequestError facebookRequestError) {
            Logger.m10633a(LoggingBehavior.REQUESTS, LikeActionController.f2298a, "Error unliking object with unlike token '%s' : %s", this.f2376f, facebookRequestError);
            LikeActionController.this.m10136a("publish_unlike", facebookRequestError);
        }
    }

    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$h */
    /* loaded from: classes.dex */
    private class C1064h extends AbstractC1056a implements InterfaceC1065i {

        /* renamed from: f */
        private boolean f2368f;

        /* renamed from: g */
        private String f2369g;

        @Override // com.facebook.share.internal.LikeActionController.InterfaceC1065i
        /* renamed from: c */
        public String mo10078c() {
            return null;
        }

        C1064h(String str) {
            super(str, LikeView.ObjectType.PAGE);
            this.f2368f = LikeActionController.this.f2310m;
            this.f2369g = str;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id");
            AccessToken m11457a = AccessToken.m11457a();
            m10081a(new GraphRequest(m11457a, "me/likes/" + str, bundle, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10076a(GraphResponse graphResponse) {
            JSONArray m10494c = Utility.m10494c(graphResponse.m10824b(), "data");
            if (m10494c == null || m10494c.length() <= 0) {
                return;
            }
            this.f2368f = true;
        }

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10077a(FacebookRequestError facebookRequestError) {
            Logger.m10633a(LoggingBehavior.REQUESTS, LikeActionController.f2298a, "Error fetching like status for page id '%s': %s", this.f2369g, facebookRequestError);
            LikeActionController.this.m10136a("get_page_like", facebookRequestError);
        }

        @Override // com.facebook.share.internal.LikeActionController.InterfaceC1065i
        /* renamed from: b */
        public boolean mo10079b() {
            return this.f2368f;
        }
    }

    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$f */
    /* loaded from: classes.dex */
    private class C1062f extends AbstractC1056a implements InterfaceC1065i {

        /* renamed from: f */
        private boolean f2360f;

        /* renamed from: g */
        private String f2361g;

        /* renamed from: h */
        private final String f2362h;

        /* renamed from: i */
        private final LikeView.ObjectType f2363i;

        C1062f(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            this.f2360f = LikeActionController.this.f2310m;
            this.f2362h = str;
            this.f2363i = objectType;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id,application");
            bundle.putString("object", this.f2362h);
            m10081a(new GraphRequest(AccessToken.m11457a(), "me/og.likes", bundle, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10076a(GraphResponse graphResponse) {
            JSONArray m10494c = Utility.m10494c(graphResponse.m10824b(), "data");
            if (m10494c != null) {
                for (int i = 0; i < m10494c.length(); i++) {
                    JSONObject optJSONObject = m10494c.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.f2360f = true;
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("application");
                        AccessToken m11457a = AccessToken.m11457a();
                        if (optJSONObject2 != null && AccessToken.m11451b() && Utility.m10533a(m11457a.m11440l(), optJSONObject2.optString("id"))) {
                            this.f2361g = optJSONObject.optString("id");
                        }
                    }
                }
            }
        }

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10077a(FacebookRequestError facebookRequestError) {
            Logger.m10633a(LoggingBehavior.REQUESTS, LikeActionController.f2298a, "Error fetching like status for object '%s' with type '%s' : %s", this.f2362h, this.f2363i, facebookRequestError);
            LikeActionController.this.m10136a("get_og_object_like", facebookRequestError);
        }

        @Override // com.facebook.share.internal.LikeActionController.InterfaceC1065i
        /* renamed from: b */
        public boolean mo10079b() {
            return this.f2360f;
        }

        @Override // com.facebook.share.internal.LikeActionController.InterfaceC1065i
        /* renamed from: c */
        public String mo10078c() {
            return this.f2361g;
        }
    }

    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$d */
    /* loaded from: classes.dex */
    private class C1060d extends AbstractC1056a {

        /* renamed from: e */
        String f2352e;

        /* renamed from: f */
        String f2353f;

        /* renamed from: g */
        String f2354g;

        /* renamed from: h */
        String f2355h;

        C1060d(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            this.f2352e = LikeActionController.this.f2311n;
            this.f2353f = LikeActionController.this.f2312o;
            this.f2354g = LikeActionController.this.f2313p;
            this.f2355h = LikeActionController.this.f2314q;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
            bundle.putString("locale", Locale.getDefault().toString());
            m10081a(new GraphRequest(AccessToken.m11457a(), str, bundle, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10076a(GraphResponse graphResponse) {
            JSONObject m10502b = Utility.m10502b(graphResponse.m10824b(), "engagement");
            if (m10502b != null) {
                this.f2352e = m10502b.optString("count_string_with_like", this.f2352e);
                this.f2353f = m10502b.optString("count_string_without_like", this.f2353f);
                this.f2354g = m10502b.optString("social_sentence_with_like", this.f2354g);
                this.f2355h = m10502b.optString("social_sentence_without_like", this.f2355h);
            }
        }

        @Override // com.facebook.share.internal.LikeActionController.AbstractC1056a
        /* renamed from: a */
        protected void mo10077a(FacebookRequestError facebookRequestError) {
            Logger.m10633a(LoggingBehavior.REQUESTS, LikeActionController.f2298a, "Error fetching engagement for object '%s' with type '%s' : %s", this.f2343a, this.f2344b, facebookRequestError);
            LikeActionController.this.m10136a("get_engagement", facebookRequestError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$a */
    /* loaded from: classes.dex */
    public abstract class AbstractC1056a implements InterfaceC1070n {

        /* renamed from: a */
        protected String f2343a;

        /* renamed from: b */
        protected LikeView.ObjectType f2344b;

        /* renamed from: c */
        protected FacebookRequestError f2345c;

        /* renamed from: e */
        private GraphRequest f2347e;

        /* renamed from: a */
        protected abstract void mo10076a(GraphResponse graphResponse);

        protected AbstractC1056a(String str, LikeView.ObjectType objectType) {
            this.f2343a = str;
            this.f2344b = objectType;
        }

        @Override // com.facebook.share.internal.LikeActionController.InterfaceC1070n
        /* renamed from: a */
        public void mo10073a(GraphRequestBatch graphRequestBatch) {
            graphRequestBatch.add(this.f2347e);
        }

        @Override // com.facebook.share.internal.LikeActionController.InterfaceC1070n
        /* renamed from: a */
        public FacebookRequestError mo10074a() {
            return this.f2345c;
        }

        /* renamed from: a */
        protected void m10081a(GraphRequest graphRequest) {
            this.f2347e = graphRequest;
            graphRequest.m11384a(FacebookSdk.m10868i());
            graphRequest.m11393a(new GraphRequest.InterfaceC0829b() { // from class: com.facebook.share.internal.c.a.1
                @Override // com.facebook.GraphRequest.InterfaceC0829b
                /* renamed from: a */
                public void mo10080a(GraphResponse graphResponse) {
                    AbstractC1056a.this.f2345c = graphResponse.m10831a();
                    if (AbstractC1056a.this.f2345c != null) {
                        AbstractC1056a abstractC1056a = AbstractC1056a.this;
                        abstractC1056a.mo10077a(abstractC1056a.f2345c);
                        return;
                    }
                    AbstractC1056a.this.mo10076a(graphResponse);
                }
            });
        }

        /* renamed from: a */
        protected void mo10077a(FacebookRequestError facebookRequestError) {
            Logger.m10633a(LoggingBehavior.REQUESTS, LikeActionController.f2298a, "Error running request for object '%s' with type '%s' : %s", this.f2343a, this.f2344b, facebookRequestError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$j */
    /* loaded from: classes.dex */
    public static class RunnableC1066j implements Runnable {

        /* renamed from: a */
        private static ArrayList<String> f2370a = new ArrayList<>();

        /* renamed from: b */
        private String f2371b;

        /* renamed from: c */
        private boolean f2372c;

        RunnableC1066j(String str, boolean z) {
            this.f2371b = str;
            this.f2372c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f2371b;
            if (str != null) {
                f2370a.remove(str);
                f2370a.add(0, this.f2371b);
            }
            if (!this.f2372c || f2370a.size() < 128) {
                return;
            }
            while (64 < f2370a.size()) {
                ArrayList<String> arrayList = f2370a;
                LikeActionController.f2300c.remove(arrayList.remove(arrayList.size() - 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$o */
    /* loaded from: classes.dex */
    public static class RunnableC1071o implements Runnable {

        /* renamed from: a */
        private String f2377a;

        /* renamed from: b */
        private String f2378b;

        RunnableC1071o(String str, String str2) {
            this.f2377a = str;
            this.f2378b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            LikeActionController.m10120b(this.f2377a, this.f2378b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$b */
    /* loaded from: classes.dex */
    public static class RunnableC1058b implements Runnable {

        /* renamed from: a */
        private String f2349a;

        /* renamed from: b */
        private LikeView.ObjectType f2350b;

        /* renamed from: c */
        private InterfaceC1059c f2351c;

        RunnableC1058b(String str, LikeView.ObjectType objectType, InterfaceC1059c interfaceC1059c) {
            this.f2349a = str;
            this.f2350b = objectType;
            this.f2351c = interfaceC1059c;
        }

        @Override // java.lang.Runnable
        public void run() {
            LikeActionController.m10112c(this.f2349a, this.f2350b, this.f2351c);
        }
    }
}
