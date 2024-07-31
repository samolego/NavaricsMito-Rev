package com.navatics.app.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.navatics.app.R;
import java.lang.ref.WeakReference;
import java.util.UUID;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.widget.c */
/* loaded from: classes.dex */
public class NotificationView implements View.OnClickListener {

    /* renamed from: a */
    protected static final C3044k f5638a = C3044k.m1564a(NotificationView.class);

    /* renamed from: b */
    private WeakReference<Activity> f5639b;

    /* renamed from: c */
    private WeakReference<FrameLayout> f5640c;

    /* renamed from: e */
    private String f5642e;

    /* renamed from: h */
    private String f5645h;

    /* renamed from: d */
    private InterfaceC1966a f5641d = null;

    /* renamed from: f */
    private boolean f5643f = true;

    /* renamed from: g */
    private int f5644g = 1000;

    /* renamed from: i */
    private final Handler f5646i = new Handler();

    /* renamed from: j */
    private final Runnable f5647j = new Runnable() { // from class: com.navatics.app.widget.-$$Lambda$PhaYzsKii6PR5W-7YgK8PuW4kx8
        @Override // java.lang.Runnable
        public final void run() {
            NotificationView.this.m6995a();
        }
    };

    /* compiled from: NotificationView.java */
    /* renamed from: com.navatics.app.widget.c$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1966a {
        /* renamed from: a */
        void m6986a();
    }

    /* renamed from: a */
    public static NotificationView m6993a(Activity activity) {
        return new NotificationView(activity);
    }

    private NotificationView(Activity activity) {
        this.f5639b = new WeakReference<>(activity);
    }

    /* renamed from: a */
    public NotificationView m6994a(int i) {
        this.f5644g = i;
        return this;
    }

    /* renamed from: a */
    public NotificationView m6991a(String str) {
        this.f5642e = str;
        return this;
    }

    /* renamed from: a */
    public void m6995a() {
        View m6987d = m6987d();
        if (m6987d != null && ((String) m6987d.getTag()).equals(this.f5645h)) {
            m6987d.startAnimation(AnimationUtils.loadAnimation(m6988c(), R.anim.popup_hide));
            InterfaceC1966a interfaceC1966a = this.f5641d;
            if (interfaceC1966a != null) {
                interfaceC1966a.m6986a();
            }
            synchronized (NotificationView.class) {
                m6989b(this.f5639b.get()).removeView(m6987d());
            }
        }
    }

    /* renamed from: b */
    public void m6990b() {
        synchronized (NotificationView.class) {
            ViewGroup m6989b = m6989b(this.f5639b.get());
            m6992a(m6989b);
            ((LayoutInflater) m6988c().getSystemService("layout_inflater")).inflate(R.layout.notification_view_layout, m6989b, true);
            FrameLayout frameLayout = (FrameLayout) m6989b.findViewById(R.id.notificationLayout);
            this.f5640c = new WeakReference<>(frameLayout);
            this.f5645h = UUID.randomUUID().toString();
            frameLayout.setTag(this.f5645h);
            frameLayout.setOnClickListener(this);
            ((TextView) frameLayout.findViewById(R.id.tvNotificationViewText)).setText(this.f5642e);
            frameLayout.startAnimation(AnimationUtils.loadAnimation(m6988c(), R.anim.popup_show));
            if (this.f5643f) {
                this.f5646i.removeCallbacks(this.f5647j);
                this.f5646i.postDelayed(this.f5647j, this.f5644g);
            }
        }
    }

    /* renamed from: a */
    private static void m6992a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getId() == R.id.notificationLayout) {
                viewGroup.removeView(childAt);
            }
            if (childAt instanceof ViewGroup) {
                m6992a((ViewGroup) childAt);
            }
        }
    }

    /* renamed from: c */
    private Context m6988c() {
        return this.f5639b.get();
    }

    /* renamed from: d */
    private View m6987d() {
        return this.f5640c.get();
    }

    /* renamed from: b */
    private static ViewGroup m6989b(Activity activity) {
        return (ViewGroup) activity.getWindow().getDecorView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m6995a();
    }
}
