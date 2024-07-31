package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.view.View;
import android.widget.AdapterView;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.appevents.codeless.a */
/* loaded from: classes.dex */
public class CodelessLoggingEventListener {

    /* renamed from: a */
    private static final String f1606a = CodelessLoggingEventListener.class.getCanonicalName();

    /* renamed from: a */
    public static View$OnClickListenerC0855a m11182a(EventBinding eventBinding, View view, View view2) {
        return new View$OnClickListenerC0855a(eventBinding, view, view2);
    }

    /* renamed from: a */
    public static C0856b m11181a(EventBinding eventBinding, View view, AdapterView adapterView) {
        return new C0856b(eventBinding, view, adapterView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m11179c(EventBinding eventBinding, View view, View view2) {
        final String m11120c = eventBinding.m11120c();
        final Bundle m11158a = CodelessMatcher.m11158a(eventBinding, view, view2);
        if (m11158a.containsKey("_valueToSum")) {
            m11158a.putDouble("_valueToSum", AppEventUtility.m11018a(m11158a.getString("_valueToSum")));
        }
        m11158a.putString("_is_fb_codeless", "1");
        FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.appevents.codeless.a.1
            @Override // java.lang.Runnable
            public void run() {
                AppEventsLogger.m11290a(FacebookSdk.m10869h()).m11287a(m11120c, m11158a);
            }
        });
    }

    /* compiled from: CodelessLoggingEventListener.java */
    /* renamed from: com.facebook.appevents.codeless.a$a */
    /* loaded from: classes.dex */
    public static class View$OnClickListenerC0855a implements View.OnClickListener {

        /* renamed from: a */
        private EventBinding f1609a;

        /* renamed from: b */
        private WeakReference<View> f1610b;

        /* renamed from: c */
        private WeakReference<View> f1611c;
        @Nullable

        /* renamed from: d */
        private View.OnClickListener f1612d;

        /* renamed from: e */
        private boolean f1613e;

        private View$OnClickListenerC0855a(EventBinding eventBinding, View view, View view2) {
            this.f1613e = false;
            if (eventBinding == null || view == null || view2 == null) {
                return;
            }
            this.f1612d = ViewHierarchy.m11097g(view2);
            this.f1609a = eventBinding;
            this.f1610b = new WeakReference<>(view2);
            this.f1611c = new WeakReference<>(view);
            this.f1613e = true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f1612d;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            if (this.f1611c.get() == null || this.f1610b.get() == null) {
                return;
            }
            CodelessLoggingEventListener.m11179c(this.f1609a, this.f1611c.get(), this.f1610b.get());
        }

        /* renamed from: a */
        public boolean m11178a() {
            return this.f1613e;
        }
    }

    /* compiled from: CodelessLoggingEventListener.java */
    /* renamed from: com.facebook.appevents.codeless.a$b */
    /* loaded from: classes.dex */
    public static class C0856b implements AdapterView.OnItemClickListener {

        /* renamed from: a */
        private EventBinding f1614a;

        /* renamed from: b */
        private WeakReference<AdapterView> f1615b;

        /* renamed from: c */
        private WeakReference<View> f1616c;
        @Nullable

        /* renamed from: d */
        private AdapterView.OnItemClickListener f1617d;

        /* renamed from: e */
        private boolean f1618e;

        private C0856b(EventBinding eventBinding, View view, AdapterView adapterView) {
            this.f1618e = false;
            if (eventBinding == null || view == null || adapterView == null) {
                return;
            }
            this.f1617d = adapterView.getOnItemClickListener();
            this.f1614a = eventBinding;
            this.f1615b = new WeakReference<>(adapterView);
            this.f1616c = new WeakReference<>(view);
            this.f1618e = true;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AdapterView.OnItemClickListener onItemClickListener = this.f1617d;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
            if (this.f1616c.get() == null || this.f1615b.get() == null) {
                return;
            }
            CodelessLoggingEventListener.m11179c(this.f1614a, this.f1616c.get(), this.f1615b.get());
        }

        /* renamed from: a */
        public boolean m11177a() {
            return this.f1618e;
        }
    }
}
