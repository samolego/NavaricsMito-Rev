package com.bumptech.glide.manager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.C0791i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.manager.n */
/* loaded from: classes.dex */
public class RequestTracker {

    /* renamed from: a */
    private final Set<Request> f1182a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private final List<Request> f1183b = new ArrayList();

    /* renamed from: c */
    private boolean f1184c;

    /* renamed from: a */
    public void m11767a(@NonNull Request request) {
        this.f1182a.add(request);
        if (!this.f1184c) {
            request.mo11646a();
            return;
        }
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f1183b.add(request);
    }

    /* renamed from: b */
    public boolean m11764b(@Nullable Request request) {
        return m11766a(request, true);
    }

    /* renamed from: a */
    private boolean m11766a(@Nullable Request request, boolean z) {
        boolean z2 = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.f1182a.remove(request);
        if (!this.f1183b.remove(request) && !remove) {
            z2 = false;
        }
        if (z2) {
            request.mo11641c();
            if (z) {
                request.mo11631i();
            }
        }
        return z2;
    }

    /* renamed from: a */
    public void m11768a() {
        this.f1184c = true;
        for (Request request : C0791i.m11565a(this.f1182a)) {
            if (request.mo11639d()) {
                request.mo11643b();
                this.f1183b.add(request);
            }
        }
    }

    /* renamed from: b */
    public void m11765b() {
        this.f1184c = false;
        for (Request request : C0791i.m11565a(this.f1182a)) {
            if (!request.mo11637e() && !request.mo11633g() && !request.mo11639d()) {
                request.mo11646a();
            }
        }
        this.f1183b.clear();
    }

    /* renamed from: c */
    public void m11763c() {
        for (Request request : C0791i.m11565a(this.f1182a)) {
            m11766a(request, false);
        }
        this.f1183b.clear();
    }

    /* renamed from: d */
    public void m11762d() {
        for (Request request : C0791i.m11565a(this.f1182a)) {
            if (!request.mo11637e() && !request.mo11633g()) {
                request.mo11643b();
                if (!this.f1184c) {
                    request.mo11646a();
                } else {
                    this.f1183b.add(request);
                }
            }
        }
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f1182a.size() + ", isPaused=" + this.f1184c + "}";
    }
}
