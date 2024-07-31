package com.navatics.app.settings;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: SettingEntry.java */
/* renamed from: com.navatics.app.settings.h */
/* loaded from: classes.dex */
public abstract class SettingEntry {

    /* renamed from: a */
    private a f5113a;

    /* renamed from: b */
    private Activity f5114b;

    /* renamed from: g */
    protected View f5115g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingEntry.java */
    /* renamed from: com.navatics.app.settings.h$a */
    /* loaded from: classes.dex */
    public interface a {
        void onClick(SettingEntry settingEntry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract View mo5398a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5399b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5400c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingEntry(Activity activity) {
        this.f5114b = activity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m5467e() {
        View m5468f = m5468f();
        if (m5468f != null) {
            m5468f.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.settings.-$$Lambda$h$sQDs3xg8NImJQC3jikrR5U9h6g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingEntry.this.m5465a(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m5465a(View view) {
        a aVar = this.f5113a;
        if (aVar != null) {
            aVar.onClick(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5466a(Runnable runnable) {
        this.f5114b.runOnUiThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public View m5468f() {
        return this.f5115g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public Context m5469g() {
        return this.f5114b;
    }

    public void setOnClickListener(a aVar) {
        this.f5113a = aVar;
    }
}