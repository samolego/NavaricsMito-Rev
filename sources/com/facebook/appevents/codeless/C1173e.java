package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.appevents.codeless.e */
/* loaded from: classes.dex */
public class ViewIndexer {

    /* renamed from: a */
    private static final String f1653a = ViewIndexer.class.getCanonicalName();

    /* renamed from: f */
    private static ViewIndexer f1654f;

    /* renamed from: c */
    private WeakReference<Activity> f1656c;

    /* renamed from: d */
    private Timer f1657d;

    /* renamed from: e */
    private String f1658e = null;

    /* renamed from: b */
    private final Handler f1655b = new Handler(Looper.getMainLooper());

    public ViewIndexer(Activity activity) {
        this.f1656c = new WeakReference<>(activity);
        f1654f = this;
    }

    /* renamed from: a */
    public void m11138a() {
        final TimerTask timerTask = new TimerTask() { // from class: com.facebook.appevents.codeless.e.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                String str;
                try {
                    Activity activity = (Activity) ViewIndexer.this.f1656c.get();
                    if (activity == null) {
                        return;
                    }
                    String simpleName = activity.getClass().getSimpleName();
                    View rootView = activity.getWindow().getDecorView().getRootView();
                    if (CodelessManager.m11164d()) {
                        if (InternalSettings.m10643b()) {
                            UnityReflection.m11111a();
                            return;
                        }
                        FutureTask futureTask = new FutureTask(new CallableC0868a(rootView));
                        ViewIndexer.this.f1655b.post(futureTask);
                        try {
                            str = (String) futureTask.get(1L, TimeUnit.SECONDS);
                        } catch (Exception e) {
                            Log.e(ViewIndexer.f1653a, "Failed to take screenshot.", e);
                            str = "";
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("screenname", simpleName);
                            jSONObject.put("screenshot", str);
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(ViewHierarchy.m11101c(rootView));
                            jSONObject.put("view", jSONArray);
                        } catch (JSONException unused) {
                            Log.e(ViewIndexer.f1653a, "Failed to create JSONObject");
                        }
                        ViewIndexer.this.m11134a(jSONObject.toString());
                    }
                } catch (Exception e2) {
                    Log.e(ViewIndexer.f1653a, "UI Component tree indexing failure!", e2);
                }
            }
        };
        FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.appevents.codeless.e.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ViewIndexer.this.f1657d != null) {
                        ViewIndexer.this.f1657d.cancel();
                    }
                    ViewIndexer.this.f1658e = null;
                    ViewIndexer.this.f1657d = new Timer();
                    ViewIndexer.this.f1657d.scheduleAtFixedRate(timerTask, 0L, 1000L);
                } catch (Exception e) {
                    Log.e(ViewIndexer.f1653a, "Error scheduling indexing job", e);
                }
            }
        });
    }

    /* renamed from: b */
    public void m11132b() {
        Timer timer;
        if (this.f1656c.get() == null || (timer = this.f1657d) == null) {
            return;
        }
        try {
            timer.cancel();
            this.f1657d = null;
        } catch (Exception e) {
            Log.e(f1653a, "Error unscheduling indexing job", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11134a(final String str) {
        FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.appevents.codeless.e.3
            @Override // java.lang.Runnable
            public void run() {
                GraphRequest m11133a;
                String m10506b = Utility.m10506b(str);
                AccessToken m11457a = AccessToken.m11457a();
                if ((m10506b == null || !m10506b.equals(ViewIndexer.this.f1658e)) && (m11133a = ViewIndexer.m11133a(str, m11457a, FacebookSdk.m10865l(), "app_indexing")) != null) {
                    GraphResponse m11349i = m11133a.m11349i();
                    try {
                        JSONObject m10824b = m11349i.m10824b();
                        if (m10824b == null) {
                            String str2 = ViewIndexer.f1653a;
                            Log.e(str2, "Error sending UI component tree to Facebook: " + m11349i.m10831a());
                            return;
                        }
                        if ("true".equals(m10824b.optString("success"))) {
                            Logger.m10634a(LoggingBehavior.APP_EVENTS, ViewIndexer.f1653a, "Successfully send UI component tree to server");
                            ViewIndexer.this.f1658e = m10506b;
                        }
                        if (m10824b.has("is_app_indexing_enabled")) {
                            CodelessManager.m11174a(Boolean.valueOf(m10824b.getBoolean("is_app_indexing_enabled")));
                        }
                    } catch (JSONException e) {
                        Log.e(ViewIndexer.f1653a, "Error decoding server response.", e);
                    }
                }
            }
        });
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: a */
    public static GraphRequest m11133a(String str, AccessToken accessToken, String str2, String str3) {
        if (str == null) {
            return null;
        }
        GraphRequest m11394a = GraphRequest.m11394a(accessToken, String.format(Locale.US, "%s/app_indexing", str2), (JSONObject) null, (GraphRequest.InterfaceC0829b) null);
        Bundle m11358e = m11394a.m11358e();
        if (m11358e == null) {
            m11358e = new Bundle();
        }
        m11358e.putString("tree", str);
        m11358e.putString("app_version", AppEventUtility.m11014d());
        m11358e.putString("platform", "android");
        m11358e.putString("request_type", str3);
        if (str3.equals("app_indexing")) {
            m11358e.putString("device_session_id", CodelessManager.m11168c());
        }
        m11394a.m11397a(m11358e);
        m11394a.m11393a(new GraphRequest.InterfaceC0829b() { // from class: com.facebook.appevents.codeless.e.4
            @Override // com.facebook.GraphRequest.InterfaceC0829b
            /* renamed from: a */
            public void mo10080a(GraphResponse graphResponse) {
                Logger.m10634a(LoggingBehavior.APP_EVENTS, ViewIndexer.f1653a, "App index sent to FB!");
            }
        });
        return m11394a;
    }

    /* compiled from: ViewIndexer.java */
    /* renamed from: com.facebook.appevents.codeless.e$a */
    /* loaded from: classes.dex */
    private static class CallableC0868a implements Callable<String> {

        /* renamed from: a */
        private WeakReference<View> f1664a;

        CallableC0868a(View view) {
            this.f1664a = new WeakReference<>(view);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() {
            View view = this.f1664a.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        }
    }
}
