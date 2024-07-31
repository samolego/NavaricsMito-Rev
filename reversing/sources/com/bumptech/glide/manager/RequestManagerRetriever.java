package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.FragmentActivity;
import android.support.p008v4.util.ArrayMap;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.C0791i;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.manager.l */
/* loaded from: classes.dex */
public class RequestManagerRetriever implements Handler.Callback {

    /* renamed from: i */
    private static final InterfaceC0773a f1173i = new InterfaceC0773a() { // from class: com.bumptech.glide.manager.l.1
        @Override // com.bumptech.glide.manager.RequestManagerRetriever.InterfaceC0773a
        @NonNull
        /* renamed from: a */
        public RequestManager mo11769a(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };

    /* renamed from: c */
    private volatile RequestManager f1176c;

    /* renamed from: d */
    private final Handler f1177d;

    /* renamed from: e */
    private final InterfaceC0773a f1178e;
    @VisibleForTesting

    /* renamed from: a */
    final Map<FragmentManager, RequestManagerFragment> f1174a = new HashMap();
    @VisibleForTesting

    /* renamed from: b */
    final Map<android.support.p008v4.app.FragmentManager, SupportRequestManagerFragment> f1175b = new HashMap();

    /* renamed from: f */
    private final ArrayMap<View, Fragment> f1179f = new ArrayMap<>();

    /* renamed from: g */
    private final ArrayMap<View, android.app.Fragment> f1180g = new ArrayMap<>();

    /* renamed from: h */
    private final Bundle f1181h = new Bundle();

    /* compiled from: RequestManagerRetriever.java */
    /* renamed from: com.bumptech.glide.manager.l$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0773a {
        @NonNull
        /* renamed from: a */
        RequestManager mo11769a(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context);
    }

    public RequestManagerRetriever(@Nullable InterfaceC0773a interfaceC0773a) {
        this.f1178e = interfaceC0773a == null ? f1173i : interfaceC0773a;
        this.f1177d = new Handler(Looper.getMainLooper(), this);
    }

    @NonNull
    /* renamed from: b */
    private RequestManager m11773b(@NonNull Context context) {
        if (this.f1176c == null) {
            synchronized (this) {
                if (this.f1176c == null) {
                    this.f1176c = this.f1178e.mo11769a(Glide.m12523a(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                }
            }
        }
        return this.f1176c;
    }

    @NonNull
    /* renamed from: a */
    public RequestManager m11779a(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (C0791i.m11557c() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return m11776a((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return m11781a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return m11779a(((ContextWrapper) context).getBaseContext());
            }
        }
        return m11773b(context);
    }

    @NonNull
    /* renamed from: a */
    public RequestManager m11776a(@NonNull FragmentActivity fragmentActivity) {
        if (C0791i.m11555d()) {
            return m11779a(fragmentActivity.getApplicationContext());
        }
        m11771c(fragmentActivity);
        return m11777a(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, m11770d(fragmentActivity));
    }

    @NonNull
    /* renamed from: a */
    public RequestManager m11781a(@NonNull Activity activity) {
        if (C0791i.m11555d()) {
            return m11779a(activity.getApplicationContext());
        }
        m11771c(activity);
        return m11778a(activity, activity.getFragmentManager(), (android.app.Fragment) null, m11770d(activity));
    }

    @TargetApi(17)
    /* renamed from: c */
    private static void m11771c(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @Deprecated
    /* renamed from: b */
    public RequestManagerFragment m11774b(Activity activity) {
        return m11780a(activity.getFragmentManager(), (android.app.Fragment) null, m11770d(activity));
    }

    @NonNull
    /* renamed from: a */
    private RequestManagerFragment m11780a(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null && (requestManagerFragment = this.f1174a.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.m11789a(fragment);
            if (z) {
                requestManagerFragment.m11791a().m11801a();
            }
            this.f1174a.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f1177d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    @NonNull
    @Deprecated
    /* renamed from: a */
    private RequestManager m11778a(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment m11780a = m11780a(fragmentManager, fragment, z);
        RequestManager m11786b = m11780a.m11786b();
        if (m11786b == null) {
            RequestManager mo11769a = this.f1178e.mo11769a(Glide.m12523a(context), m11780a.m11791a(), m11780a.m11784c(), context);
            m11780a.m11788a(mo11769a);
            return mo11769a;
        }
        return m11786b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: b */
    public SupportRequestManagerFragment m11772b(FragmentActivity fragmentActivity) {
        return m11775a(fragmentActivity.getSupportFragmentManager(), (Fragment) null, m11770d(fragmentActivity));
    }

    /* renamed from: d */
    private static boolean m11770d(Activity activity) {
        return !activity.isFinishing();
    }

    @NonNull
    /* renamed from: a */
    private SupportRequestManagerFragment m11775a(@NonNull android.support.p008v4.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f1175b.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.m11810a(fragment);
            if (z) {
                supportRequestManagerFragment.m11811a().m11801a();
            }
            this.f1175b.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f1177d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    @NonNull
    /* renamed from: a */
    private RequestManager m11777a(@NonNull Context context, @NonNull android.support.p008v4.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment m11775a = m11775a(fragmentManager, fragment, z);
        RequestManager m11806b = m11775a.m11806b();
        if (m11806b == null) {
            RequestManager mo11769a = this.f1178e.mo11769a(Glide.m12523a(context), m11775a.m11811a(), m11775a.m11804c(), context);
            m11775a.m11808a(mo11769a);
            return mo11769a;
        }
        return m11806b;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ComponentCallbacks remove;
        Object obj = null;
        boolean z = true;
        switch (message.what) {
            case 1:
                obj = (FragmentManager) message.obj;
                remove = this.f1174a.remove(obj);
                break;
            case 2:
                obj = (android.support.p008v4.app.FragmentManager) message.obj;
                remove = this.f1175b.remove(obj);
                break;
            default:
                z = false;
                remove = null;
                break;
        }
        if (z && remove == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }
}
