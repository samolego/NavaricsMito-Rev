package com.facebook.internal;

import android.app.Activity;
import android.content.Intent;
import android.support.p008v4.app.Fragment;

/* renamed from: com.facebook.internal.n */
/* loaded from: classes.dex */
public class FragmentWrapper {

    /* renamed from: a */
    private Fragment f2013a;

    /* renamed from: b */
    private android.app.Fragment f2014b;

    public FragmentWrapper(Fragment fragment) {
        Validate.m10469a(fragment, "fragment");
        this.f2013a = fragment;
    }

    public FragmentWrapper(android.app.Fragment fragment) {
        Validate.m10469a(fragment, "fragment");
        this.f2014b = fragment;
    }

    /* renamed from: a */
    public android.app.Fragment m10648a() {
        return this.f2014b;
    }

    /* renamed from: b */
    public Fragment m10646b() {
        return this.f2013a;
    }

    /* renamed from: a */
    public void m10647a(Intent intent, int i) {
        Fragment fragment = this.f2013a;
        if (fragment != null) {
            fragment.startActivityForResult(intent, i);
        } else {
            this.f2014b.startActivityForResult(intent, i);
        }
    }

    /* renamed from: c */
    public final Activity m10645c() {
        Fragment fragment = this.f2013a;
        if (fragment != null) {
            return fragment.getActivity();
        }
        return this.f2014b.getActivity();
    }
}
