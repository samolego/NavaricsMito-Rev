package com.yanzhenjie.recyclerview;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SwipeMenu {

    /* renamed from: a */
    private SwipeMenuLayout f9160a;

    /* renamed from: b */
    private int f9161b = 0;

    /* renamed from: c */
    private List<SwipeMenuItem> f9162c = new ArrayList(2);

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface OrientationMode {
    }

    public SwipeMenu(SwipeMenuLayout swipeMenuLayout) {
        this.f9160a = swipeMenuLayout;
    }

    /* renamed from: a */
    public int m3861a() {
        return this.f9161b;
    }

    /* renamed from: a */
    public void m3860a(SwipeMenuItem swipeMenuItem) {
        this.f9162c.add(swipeMenuItem);
    }

    /* renamed from: b */
    public List<SwipeMenuItem> m3859b() {
        return this.f9162c;
    }

    /* renamed from: c */
    public boolean m3858c() {
        return !this.f9162c.isEmpty();
    }
}
