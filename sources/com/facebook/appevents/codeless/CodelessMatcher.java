package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.RCTCodelessLoggingEventListener;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.facebook.appevents.codeless.c */
/* loaded from: classes.dex */
public class CodelessMatcher {

    /* renamed from: a */
    private static final String f1629a = CodelessMatcher.class.getCanonicalName();

    /* renamed from: g */
    private static CodelessMatcher f1630g = null;

    /* renamed from: b */
    private final Handler f1631b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private Set<Activity> f1632c = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: d */
    private Set<ViewTreeObserver$OnGlobalLayoutListenerC0861b> f1633d = new HashSet();

    /* renamed from: e */
    private HashSet<String> f1634e = new HashSet<>();

    /* renamed from: f */
    private HashMap<Integer, HashSet<String>> f1635f = new HashMap<>();

    private CodelessMatcher() {
    }

    /* renamed from: a */
    public static synchronized CodelessMatcher m11161a() {
        CodelessMatcher codelessMatcher;
        synchronized (CodelessMatcher.class) {
            if (f1630g == null) {
                f1630g = new CodelessMatcher();
            }
            codelessMatcher = f1630g;
        }
        return codelessMatcher;
    }

    /* renamed from: a */
    public void m11160a(Activity activity) {
        if (InternalSettings.m10643b()) {
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
        }
        this.f1632c.add(activity);
        this.f1634e.clear();
        if (this.f1635f.containsKey(Integer.valueOf(activity.hashCode()))) {
            this.f1634e = this.f1635f.get(Integer.valueOf(activity.hashCode()));
        }
        m11155c();
    }

    /* renamed from: b */
    public void m11156b(Activity activity) {
        if (InternalSettings.m10643b()) {
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
        }
        this.f1632c.remove(activity);
        this.f1633d.clear();
        this.f1635f.put(Integer.valueOf(activity.hashCode()), (HashSet) this.f1634e.clone());
        this.f1634e.clear();
    }

    /* renamed from: c */
    public void m11154c(Activity activity) {
        this.f1635f.remove(Integer.valueOf(activity.hashCode()));
    }

    /* renamed from: a */
    public static Bundle m11158a(EventBinding eventBinding, View view, View view2) {
        List<ParameterComponent> m11121b;
        List<C0860a> m11145a;
        Bundle bundle = new Bundle();
        if (eventBinding != null && (m11121b = eventBinding.m11121b()) != null) {
            for (ParameterComponent parameterComponent : m11121b) {
                if (parameterComponent.f1688b != null && parameterComponent.f1688b.length() > 0) {
                    bundle.putString(parameterComponent.f1687a, parameterComponent.f1688b);
                } else if (parameterComponent.f1689c.size() > 0) {
                    if (parameterComponent.f1690d.equals("relative")) {
                        m11145a = ViewTreeObserver$OnGlobalLayoutListenerC0861b.m11145a(eventBinding, view2, parameterComponent.f1689c, 0, -1, view2.getClass().getSimpleName());
                    } else {
                        m11145a = ViewTreeObserver$OnGlobalLayoutListenerC0861b.m11145a(eventBinding, view, parameterComponent.f1689c, 0, -1, view.getClass().getSimpleName());
                    }
                    Iterator<C0860a> it = m11145a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            C0860a next = it.next();
                            if (next.m11152a() != null) {
                                String m11099e = ViewHierarchy.m11099e(next.m11152a());
                                if (m11099e.length() > 0) {
                                    bundle.putString(parameterComponent.f1687a, m11099e);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return bundle;
    }

    /* renamed from: c */
    private void m11155c() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            m11153d();
        } else {
            this.f1631b.post(new Runnable() { // from class: com.facebook.appevents.codeless.c.1
                @Override // java.lang.Runnable
                public void run() {
                    CodelessMatcher.this.m11153d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m11153d() {
        for (Activity activity : this.f1632c) {
            if (activity != null) {
                this.f1633d.add(new ViewTreeObserver$OnGlobalLayoutListenerC0861b(activity.getWindow().getDecorView().getRootView(), this.f1631b, this.f1634e, activity.getClass().getSimpleName()));
            }
        }
    }

    /* compiled from: CodelessMatcher.java */
    /* renamed from: com.facebook.appevents.codeless.c$a */
    /* loaded from: classes.dex */
    public static class C0860a {

        /* renamed from: a */
        private WeakReference<View> f1637a;

        /* renamed from: b */
        private String f1638b;

        public C0860a(View view, String str) {
            this.f1637a = new WeakReference<>(view);
            this.f1638b = str;
        }

        @Nullable
        /* renamed from: a */
        public View m11152a() {
            WeakReference<View> weakReference = this.f1637a;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        /* renamed from: b */
        public String m11151b() {
            return this.f1638b;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: CodelessMatcher.java */
    /* renamed from: com.facebook.appevents.codeless.c$b */
    /* loaded from: classes.dex */
    public static class ViewTreeObserver$OnGlobalLayoutListenerC0861b implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {

        /* renamed from: a */
        private WeakReference<View> f1639a;
        @Nullable

        /* renamed from: b */
        private List<EventBinding> f1640b;

        /* renamed from: c */
        private final Handler f1641c;

        /* renamed from: d */
        private HashSet<String> f1642d;

        /* renamed from: e */
        private final String f1643e;

        public ViewTreeObserver$OnGlobalLayoutListenerC0861b(View view, Handler handler, HashSet<String> hashSet, String str) {
            this.f1639a = new WeakReference<>(view);
            this.f1641c = handler;
            this.f1642d = hashSet;
            this.f1643e = str;
            this.f1641c.postDelayed(this, 200L);
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            FetchedAppSettings m10808a = FetchedAppSettingsManager.m10808a(FacebookSdk.m10865l());
            if (m10808a == null || !m10808a.m10684h()) {
                return;
            }
            this.f1640b = EventBinding.m11123a(m10808a.m10683i());
            if (this.f1640b == null || (view = this.f1639a.get()) == null) {
                return;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
                viewTreeObserver.addOnScrollChangedListener(this);
            }
            m11150a();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            m11150a();
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            m11150a();
        }

        /* renamed from: a */
        private void m11150a() {
            if (this.f1640b == null || this.f1639a.get() == null) {
                return;
            }
            for (int i = 0; i < this.f1640b.size(); i++) {
                m11146a(this.f1640b.get(i), this.f1639a.get());
            }
        }

        /* renamed from: a */
        public void m11146a(EventBinding eventBinding, View view) {
            if (eventBinding == null || view == null) {
                return;
            }
            if (TextUtils.isEmpty(eventBinding.m11119d()) || eventBinding.m11119d().equals(this.f1643e)) {
                List<PathComponent> m11124a = eventBinding.m11124a();
                if (m11124a.size() > 25) {
                    return;
                }
                for (C0860a c0860a : m11145a(eventBinding, view, m11124a, 0, -1, this.f1643e)) {
                    m11147a(c0860a, view, eventBinding);
                }
            }
        }

        /* renamed from: a */
        public static List<C0860a> m11145a(EventBinding eventBinding, View view, List<PathComponent> list, int i, int i2, String str) {
            String str2 = str + "." + String.valueOf(i2);
            ArrayList arrayList = new ArrayList();
            if (view == null) {
                return arrayList;
            }
            if (i >= list.size()) {
                arrayList.add(new C0860a(view, str2));
            } else {
                PathComponent pathComponent = list.get(i);
                if (pathComponent.f1677a.equals("..")) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        List<View> m11148a = m11148a((ViewGroup) parent);
                        int size = m11148a.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            arrayList.addAll(m11145a(eventBinding, m11148a.get(i3), list, i + 1, i3, str2));
                        }
                    }
                    return arrayList;
                } else if (pathComponent.f1677a.equals(".")) {
                    arrayList.add(new C0860a(view, str2));
                    return arrayList;
                } else if (!m11149a(view, pathComponent, i2)) {
                    return arrayList;
                } else {
                    if (i == list.size() - 1) {
                        arrayList.add(new C0860a(view, str2));
                    }
                }
            }
            if (view instanceof ViewGroup) {
                List<View> m11148a2 = m11148a((ViewGroup) view);
                int size2 = m11148a2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    arrayList.addAll(m11145a(eventBinding, m11148a2.get(i4), list, i + 1, i4, str2));
                }
            }
            return arrayList;
        }

        /* renamed from: a */
        private static boolean m11149a(View view, PathComponent pathComponent, int i) {
            if (pathComponent.f1678b == -1 || i == pathComponent.f1678b) {
                if (!view.getClass().getCanonicalName().equals(pathComponent.f1677a)) {
                    if (!pathComponent.f1677a.matches(".*android\\..*")) {
                        return false;
                    }
                    String[] split = pathComponent.f1677a.split("\\.");
                    if (split.length <= 0) {
                        return false;
                    }
                    if (!view.getClass().getSimpleName().equals(split[split.length - 1])) {
                        return false;
                    }
                }
                if ((pathComponent.f1684h & PathComponent.MatchBitmaskType.ID.getValue()) <= 0 || pathComponent.f1679c == view.getId()) {
                    if ((pathComponent.f1684h & PathComponent.MatchBitmaskType.TEXT.getValue()) > 0) {
                        String str = pathComponent.f1680d;
                        String m11099e = ViewHierarchy.m11099e(view);
                        String m10527a = Utility.m10527a(Utility.m10497c(m11099e), "");
                        if (!str.equals(m11099e) && !str.equals(m10527a)) {
                            return false;
                        }
                    }
                    if ((pathComponent.f1684h & PathComponent.MatchBitmaskType.DESCRIPTION.getValue()) > 0) {
                        String str2 = pathComponent.f1682f;
                        String valueOf = view.getContentDescription() == null ? "" : String.valueOf(view.getContentDescription());
                        String m10527a2 = Utility.m10527a(Utility.m10497c(valueOf), "");
                        if (!str2.equals(valueOf) && !str2.equals(m10527a2)) {
                            return false;
                        }
                    }
                    if ((pathComponent.f1684h & PathComponent.MatchBitmaskType.HINT.getValue()) > 0) {
                        String str3 = pathComponent.f1683g;
                        String m11098f = ViewHierarchy.m11098f(view);
                        String m10527a3 = Utility.m10527a(Utility.m10497c(m11098f), "");
                        if (!str3.equals(m11098f) && !str3.equals(m10527a3)) {
                            return false;
                        }
                    }
                    if ((pathComponent.f1684h & PathComponent.MatchBitmaskType.TAG.getValue()) > 0) {
                        String str4 = pathComponent.f1681e;
                        String valueOf2 = view.getTag() == null ? "" : String.valueOf(view.getTag());
                        String m10527a4 = Utility.m10527a(Utility.m10497c(valueOf2), "");
                        if (!str4.equals(valueOf2) && !str4.equals(m10527a4)) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        /* renamed from: a */
        private static List<View> m11148a(ViewGroup viewGroup) {
            ArrayList arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    arrayList.add(childAt);
                }
            }
            return arrayList;
        }

        /* renamed from: a */
        private void m11147a(C0860a c0860a, View view, EventBinding eventBinding) {
            if (eventBinding == null) {
                return;
            }
            try {
                View m11152a = c0860a.m11152a();
                if (m11152a == null) {
                    return;
                }
                View m11094j = ViewHierarchy.m11094j(m11152a);
                if (m11094j != null && ViewHierarchy.m11105a(m11152a, m11094j)) {
                    m11142d(c0860a, view, eventBinding);
                } else if (m11152a.getClass().getName().startsWith("com.facebook.react")) {
                } else {
                    if (!(m11152a instanceof AdapterView)) {
                        m11144b(c0860a, view, eventBinding);
                    } else if (m11152a instanceof ListView) {
                        m11143c(c0860a, view, eventBinding);
                    }
                }
            } catch (Exception e) {
                Utility.m10528a(CodelessMatcher.f1629a, e);
            }
        }

        /* renamed from: b */
        private void m11144b(C0860a c0860a, View view, EventBinding eventBinding) {
            View m11152a = c0860a.m11152a();
            if (m11152a == null) {
                return;
            }
            String m11151b = c0860a.m11151b();
            View.OnClickListener m11097g = ViewHierarchy.m11097g(m11152a);
            boolean z = (m11097g instanceof CodelessLoggingEventListener.View$OnClickListenerC0855a) && ((CodelessLoggingEventListener.View$OnClickListenerC0855a) m11097g).m11178a();
            if (this.f1642d.contains(m11151b) || z) {
                return;
            }
            m11152a.setOnClickListener(CodelessLoggingEventListener.m11182a(eventBinding, view, m11152a));
            this.f1642d.add(m11151b);
        }

        /* renamed from: c */
        private void m11143c(C0860a c0860a, View view, EventBinding eventBinding) {
            AdapterView adapterView = (AdapterView) c0860a.m11152a();
            if (adapterView == null) {
                return;
            }
            String m11151b = c0860a.m11151b();
            AdapterView.OnItemClickListener onItemClickListener = adapterView.getOnItemClickListener();
            boolean z = (onItemClickListener instanceof CodelessLoggingEventListener.C0856b) && ((CodelessLoggingEventListener.C0856b) onItemClickListener).m11177a();
            if (this.f1642d.contains(m11151b) || z) {
                return;
            }
            adapterView.setOnItemClickListener(CodelessLoggingEventListener.m11181a(eventBinding, view, adapterView));
            this.f1642d.add(m11151b);
        }

        /* renamed from: d */
        private void m11142d(C0860a c0860a, View view, EventBinding eventBinding) {
            View m11152a = c0860a.m11152a();
            if (m11152a == null) {
                return;
            }
            String m11151b = c0860a.m11151b();
            View.OnTouchListener m11096h = ViewHierarchy.m11096h(m11152a);
            boolean z = (m11096h instanceof RCTCodelessLoggingEventListener.View$OnTouchListenerC0862a) && ((RCTCodelessLoggingEventListener.View$OnTouchListenerC0862a) m11096h).m11140a();
            if (this.f1642d.contains(m11151b) || z) {
                return;
            }
            m11152a.setOnTouchListener(RCTCodelessLoggingEventListener.m11141a(eventBinding, view, m11152a));
            this.f1642d.add(m11151b);
        }
    }
}
