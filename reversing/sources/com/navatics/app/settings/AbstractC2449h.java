package com.navatics.app.settings;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* renamed from: com.navatics.app.settings.h */
/* loaded from: classes.dex */
public abstract class SettingEntry {

    /* renamed from: a */
    private InterfaceC1906a f5091a;

    /* renamed from: b */
    private Activity f5092b;

    /* renamed from: g */
    protected View f5093g;

    /* compiled from: SettingEntry.java */
    /* renamed from: com.navatics.app.settings.h$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1906a {
        void onClick(SettingEntry settingEntry);
    }

    public static /* synthetic */ void lambda$sQDs3xg8NImJQC3jikrR5U9h6g0(SettingEntry settingEntry, View view) {
        settingEntry.m7432a(view);
    }

    /* renamed from: a */
    public abstract View mo7411a();

    /* renamed from: b */
    public void mo7430b() {
    }

    /* renamed from: c */
    public void mo7429c() {
    }

    public SettingEntry(Activity activity) {
        this.f5092b = activity;
    }

    /* renamed from: e */
    public void m7428e() {
        View m7427f = m7427f();
        if (m7427f != null) {
            m7427f.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.settings.-$$Lambda$h$sQDs3xg8NImJQC3jikrR5U9h6g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingEntry.lambda$sQDs3xg8NImJQC3jikrR5U9h6g0(SettingEntry.this, view);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m7432a(View view) {
        InterfaceC1906a interfaceC1906a = this.f5091a;
        if (interfaceC1906a != null) {
            interfaceC1906a.onClick(this);
        }
    }

    /* renamed from: a */
    public void m7431a(Runnable runnable) {
        this.f5092b.runOnUiThread(runnable);
    }

    /* renamed from: f */
    public View m7427f() {
        return this.f5093g;
    }

    /* renamed from: g */
    public Context m7426g() {
        return this.f5092b;
    }

    public void setOnClickListener(InterfaceC1906a interfaceC1906a) {
        this.f5091a = interfaceC1906a;
    }
}
