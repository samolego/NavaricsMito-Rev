package com.facebook.appevents.p041c;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.facebook.appevents.c.e */
/* loaded from: classes.dex */
public final class ViewObserver implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    private static final String f1588a = ViewObserver.class.getCanonicalName();

    /* renamed from: e */
    private static final Map<Integer, ViewObserver> f1589e = new HashMap();

    /* renamed from: b */
    private WeakReference<Activity> f1590b;

    /* renamed from: c */
    private final Handler f1591c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private AtomicBoolean f1592d = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m11197a(Activity activity) {
        int hashCode = activity.hashCode();
        if (f1589e.containsKey(Integer.valueOf(hashCode))) {
            return;
        }
        ViewObserver viewObserver = new ViewObserver(activity);
        f1589e.put(Integer.valueOf(hashCode), viewObserver);
        viewObserver.m11198a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m11194b(Activity activity) {
        int hashCode = activity.hashCode();
        if (f1589e.containsKey(Integer.valueOf(hashCode))) {
            f1589e.remove(Integer.valueOf(hashCode));
            f1589e.get(Integer.valueOf(hashCode)).m11195b();
        }
    }

    private ViewObserver(Activity activity) {
        this.f1590b = new WeakReference<>(activity);
    }

    /* renamed from: a */
    private void m11198a() {
        View m11191d;
        if (this.f1592d.getAndSet(true) || (m11191d = m11191d()) == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = m11191d.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
            m11192c();
        }
    }

    /* renamed from: b */
    private void m11195b() {
        View m11191d;
        if (this.f1592d.getAndSet(false) && (m11191d = m11191d()) != null) {
            ViewTreeObserver viewTreeObserver = m11191d.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                if (Build.VERSION.SDK_INT < 16) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                } else {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        m11192c();
    }

    /* renamed from: c */
    private void m11192c() {
        Runnable runnable = new Runnable() { // from class: com.facebook.appevents.c.e.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    View m11191d = ViewObserver.this.m11191d();
                    Activity activity = (Activity) ViewObserver.this.f1590b.get();
                    if (m11191d != null && activity != null) {
                        for (View view : SuggestedEventViewHierarchy.m11206a(m11191d)) {
                            if (!SensitiveUserDataUtils.m11118a(view)) {
                                String m11099e = ViewHierarchy.m11099e(view);
                                if (!m11099e.isEmpty() && m11099e.length() <= 300) {
                                    ViewOnClickListener.m11189a(view, m11191d, activity.getLocalClassName());
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.f1591c.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    /* renamed from: d */
    public View m11191d() {
        Window window;
        Activity activity = this.f1590b.get();
        if (activity == null || (window = activity.getWindow()) == null) {
            return null;
        }
        return window.getDecorView().getRootView();
    }
}
