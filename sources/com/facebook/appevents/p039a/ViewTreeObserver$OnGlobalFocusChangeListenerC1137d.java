package com.facebook.appevents.p039a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.EditText;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.appevents.a.d */
/* loaded from: classes.dex */
final class MetadataViewObserver implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* renamed from: a */
    private static final String f1543a = MetadataViewObserver.class.getCanonicalName();

    /* renamed from: b */
    private static final Map<Integer, MetadataViewObserver> f1544b = new HashMap();

    /* renamed from: e */
    private WeakReference<Activity> f1547e;

    /* renamed from: c */
    private final Set<String> f1545c = new HashSet();

    /* renamed from: d */
    private final Handler f1546d = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private AtomicBoolean f1548f = new AtomicBoolean(false);

    private MetadataViewObserver(Activity activity) {
        this.f1547e = new WeakReference<>(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m11260a(Activity activity) {
        MetadataViewObserver metadataViewObserver;
        int hashCode = activity.hashCode();
        if (!f1544b.containsKey(Integer.valueOf(hashCode))) {
            metadataViewObserver = new MetadataViewObserver(activity);
            f1544b.put(Integer.valueOf(activity.hashCode()), metadataViewObserver);
        } else {
            metadataViewObserver = f1544b.get(Integer.valueOf(hashCode));
        }
        metadataViewObserver.m11261a();
    }

    /* renamed from: a */
    private void m11261a() {
        View m11256b;
        if (this.f1548f.getAndSet(true) || (m11256b = m11256b()) == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = m11256b.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalFocusChangeListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(@Nullable View view, @Nullable View view2) {
        if (view != null) {
            m11259a(view);
        }
        if (view2 != null) {
            m11259a(view2);
        }
    }

    /* renamed from: a */
    private void m11259a(final View view) {
        m11257a(new Runnable() { // from class: com.facebook.appevents.a.d.1
            @Override // java.lang.Runnable
            public void run() {
                View view2 = view;
                if (view2 instanceof EditText) {
                    MetadataViewObserver.this.m11255b(view2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11255b(View view) {
        String trim = ((EditText) view).getText().toString().trim();
        if (trim.isEmpty() || this.f1545c.contains(trim) || trim.length() > 100) {
            return;
        }
        this.f1545c.add(trim);
        HashMap hashMap = new HashMap();
        List<String> list = null;
        ArrayList arrayList = null;
        for (MetadataRule metadataRule : MetadataRule.m11268a()) {
            if (MetadataMatcher.m11272a(trim, metadataRule.m11263d())) {
                if (list == null) {
                    list = MetadataMatcher.m11273a(view);
                }
                if (MetadataMatcher.m11270a(list, metadataRule.m11264c())) {
                    hashMap.put(metadataRule.m11265b(), trim);
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        ViewGroup m11107a = ViewHierarchy.m11107a(view);
                        if (m11107a != null) {
                            for (View view2 : ViewHierarchy.m11102b(m11107a)) {
                                if (view != view2) {
                                    arrayList.addAll(MetadataMatcher.m11269b(view2));
                                }
                            }
                        }
                    }
                    if (MetadataMatcher.m11270a(arrayList, metadataRule.m11264c())) {
                        hashMap.put(metadataRule.m11265b(), trim);
                    }
                }
            }
        }
        InternalAppEventsLogger.m11055a(hashMap);
    }

    /* renamed from: a */
    private void m11257a(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.f1546d.post(runnable);
        }
    }

    @Nullable
    /* renamed from: b */
    private View m11256b() {
        Window window;
        Activity activity = this.f1547e.get();
        if (activity == null || (window = activity.getWindow()) == null) {
            return null;
        }
        return window.getDecorView().getRootView();
    }
}
