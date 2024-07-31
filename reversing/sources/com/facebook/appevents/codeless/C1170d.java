package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.appevents.codeless.d */
/* loaded from: classes.dex */
public class RCTCodelessLoggingEventListener {

    /* renamed from: a */
    private static final String f1644a = RCTCodelessLoggingEventListener.class.getCanonicalName();

    /* renamed from: a */
    public static View$OnTouchListenerC0862a m11141a(EventBinding eventBinding, View view, View view2) {
        return new View$OnTouchListenerC0862a(eventBinding, view, view2);
    }

    /* compiled from: RCTCodelessLoggingEventListener.java */
    /* renamed from: com.facebook.appevents.codeless.d$a */
    /* loaded from: classes.dex */
    public static class View$OnTouchListenerC0862a implements View.OnTouchListener {

        /* renamed from: a */
        private EventBinding f1645a;

        /* renamed from: b */
        private WeakReference<View> f1646b;

        /* renamed from: c */
        private WeakReference<View> f1647c;
        @Nullable

        /* renamed from: d */
        private View.OnTouchListener f1648d;

        /* renamed from: e */
        private boolean f1649e;

        public View$OnTouchListenerC0862a(EventBinding eventBinding, View view, View view2) {
            this.f1649e = false;
            if (eventBinding == null || view == null || view2 == null) {
                return;
            }
            this.f1648d = ViewHierarchy.m11096h(view2);
            this.f1645a = eventBinding;
            this.f1646b = new WeakReference<>(view2);
            this.f1647c = new WeakReference<>(view);
            this.f1649e = true;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                m11139b();
            }
            View.OnTouchListener onTouchListener = this.f1648d;
            return onTouchListener != null && onTouchListener.onTouch(view, motionEvent);
        }

        /* renamed from: b */
        private void m11139b() {
            EventBinding eventBinding = this.f1645a;
            if (eventBinding == null) {
                return;
            }
            final String m11120c = eventBinding.m11120c();
            final Bundle m11158a = CodelessMatcher.m11158a(this.f1645a, this.f1647c.get(), this.f1646b.get());
            if (m11158a.containsKey("_valueToSum")) {
                m11158a.putDouble("_valueToSum", AppEventUtility.m11018a(m11158a.getString("_valueToSum")));
            }
            m11158a.putString("_is_fb_codeless", "1");
            FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.appevents.codeless.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    AppEventsLogger.m11290a(FacebookSdk.m10869h()).m11287a(m11120c, m11158a);
                }
            });
        }

        /* renamed from: a */
        public boolean m11140a() {
            return this.f1649e;
        }
    }
}
