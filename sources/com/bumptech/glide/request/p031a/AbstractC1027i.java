package com.bumptech.glide.request.p031a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.bumptech.glide.request.a.i */
/* loaded from: classes.dex */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {

    /* renamed from: b */
    private static boolean f1222b;
    @Nullable

    /* renamed from: c */
    private static Integer f1223c;

    /* renamed from: a */
    protected final T f1224a;

    /* renamed from: d */
    private final C0775a f1225d;
    @Nullable

    /* renamed from: e */
    private View.OnAttachStateChangeListener f1226e;

    /* renamed from: f */
    private boolean f1227f;

    /* renamed from: g */
    private boolean f1228g;

    public ViewTarget(@NonNull T t) {
        this.f1224a = (T) Preconditions.m11580a(t);
        this.f1225d = new C0775a(t);
    }

    @Override // com.bumptech.glide.request.p031a.BaseTarget, com.bumptech.glide.request.p031a.Target
    @CallSuper
    /* renamed from: b */
    public void mo11697b(@Nullable Drawable drawable) {
        super.mo11697b(drawable);
        m11721b();
    }

    /* renamed from: b */
    private void m11721b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f1226e;
        if (onAttachStateChangeListener == null || this.f1228g) {
            return;
        }
        this.f1224a.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f1228g = true;
    }

    /* renamed from: f */
    private void m11720f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f1226e;
        if (onAttachStateChangeListener == null || !this.f1228g) {
            return;
        }
        this.f1224a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f1228g = false;
    }

    @Override // com.bumptech.glide.request.p031a.Target
    @CallSuper
    /* renamed from: a */
    public void mo11702a(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f1225d.m11713a(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.p031a.Target
    @CallSuper
    /* renamed from: b */
    public void mo11696b(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f1225d.m11710b(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.p031a.BaseTarget, com.bumptech.glide.request.p031a.Target
    @CallSuper
    /* renamed from: a */
    public void mo11703a(@Nullable Drawable drawable) {
        super.mo11703a(drawable);
        this.f1225d.m11712b();
        if (this.f1227f) {
            return;
        }
        m11720f();
    }

    @Override // com.bumptech.glide.request.p031a.BaseTarget, com.bumptech.glide.request.p031a.Target
    /* renamed from: a */
    public void mo11701a(@Nullable Request request) {
        m11722a((Object) request);
    }

    @Override // com.bumptech.glide.request.p031a.BaseTarget, com.bumptech.glide.request.p031a.Target
    @Nullable
    /* renamed from: a */
    public Request mo11704a() {
        Object m11719g = m11719g();
        if (m11719g != null) {
            if (m11719g instanceof Request) {
                return (Request) m11719g;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    public String toString() {
        return "Target for: " + this.f1224a;
    }

    /* renamed from: a */
    private void m11722a(@Nullable Object obj) {
        Integer num = f1223c;
        if (num == null) {
            f1222b = true;
            this.f1224a.setTag(obj);
            return;
        }
        this.f1224a.setTag(num.intValue(), obj);
    }

    @Nullable
    /* renamed from: g */
    private Object m11719g() {
        Integer num = f1223c;
        if (num == null) {
            return this.f1224a.getTag();
        }
        return this.f1224a.getTag(num.intValue());
    }

    /* compiled from: ViewTarget.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.request.a.i$a */
    /* loaded from: classes.dex */
    static final class C0775a {
        @VisibleForTesting
        @Nullable

        /* renamed from: a */
        static Integer f1229a;

        /* renamed from: b */
        boolean f1230b;

        /* renamed from: c */
        private final View f1231c;

        /* renamed from: d */
        private final List<SizeReadyCallback> f1232d = new ArrayList();
        @Nullable

        /* renamed from: e */
        private ViewTreeObserver$OnPreDrawListenerC0776a f1233e;

        /* renamed from: a */
        private boolean m11717a(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        C0775a(@NonNull View view) {
            this.f1231c = view;
        }

        /* renamed from: a */
        private static int m11714a(@NonNull Context context) {
            if (f1229a == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.m11580a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f1229a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f1229a.intValue();
        }

        /* renamed from: a */
        private void m11716a(int i, int i2) {
            Iterator it = new ArrayList(this.f1232d).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).mo11723a(i, i2);
            }
        }

        /* renamed from: a */
        void m11718a() {
            if (this.f1232d.isEmpty()) {
                return;
            }
            int m11708d = m11708d();
            int m11709c = m11709c();
            if (m11711b(m11708d, m11709c)) {
                m11716a(m11708d, m11709c);
                m11712b();
            }
        }

        /* renamed from: a */
        void m11713a(@NonNull SizeReadyCallback sizeReadyCallback) {
            int m11708d = m11708d();
            int m11709c = m11709c();
            if (m11711b(m11708d, m11709c)) {
                sizeReadyCallback.mo11723a(m11708d, m11709c);
                return;
            }
            if (!this.f1232d.contains(sizeReadyCallback)) {
                this.f1232d.add(sizeReadyCallback);
            }
            if (this.f1233e == null) {
                ViewTreeObserver viewTreeObserver = this.f1231c.getViewTreeObserver();
                this.f1233e = new ViewTreeObserver$OnPreDrawListenerC0776a(this);
                viewTreeObserver.addOnPreDrawListener(this.f1233e);
            }
        }

        /* renamed from: b */
        void m11710b(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.f1232d.remove(sizeReadyCallback);
        }

        /* renamed from: b */
        void m11712b() {
            ViewTreeObserver viewTreeObserver = this.f1231c.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f1233e);
            }
            this.f1233e = null;
            this.f1232d.clear();
        }

        /* renamed from: b */
        private boolean m11711b(int i, int i2) {
            return m11717a(i) && m11717a(i2);
        }

        /* renamed from: c */
        private int m11709c() {
            int paddingTop = this.f1231c.getPaddingTop() + this.f1231c.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f1231c.getLayoutParams();
            return m11715a(this.f1231c.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        /* renamed from: d */
        private int m11708d() {
            int paddingLeft = this.f1231c.getPaddingLeft() + this.f1231c.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f1231c.getLayoutParams();
            return m11715a(this.f1231c.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* renamed from: a */
        private int m11715a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f1230b && this.f1231c.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f1231c.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return m11714a(this.f1231c.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ViewTarget.java */
        /* renamed from: com.bumptech.glide.request.a.i$a$a */
        /* loaded from: classes.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC0776a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            private final WeakReference<C0775a> f1234a;

            ViewTreeObserver$OnPreDrawListenerC0776a(@NonNull C0775a c0775a) {
                this.f1234a = new WeakReference<>(c0775a);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                C0775a c0775a = this.f1234a.get();
                if (c0775a != null) {
                    c0775a.m11718a();
                    return true;
                }
                return true;
            }
        }
    }
}
