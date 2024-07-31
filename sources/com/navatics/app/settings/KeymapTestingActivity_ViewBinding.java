package com.navatics.app.settings;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class KeymapTestingActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private KeymapTestingActivity f5054b;

    /* renamed from: c */
    private View f5055c;

    /* renamed from: d */
    private View f5056d;

    /* renamed from: e */
    private View f5057e;

    /* renamed from: f */
    private View f5058f;

    /* renamed from: g */
    private View f5059g;

    @UiThread
    public KeymapTestingActivity_ViewBinding(final KeymapTestingActivity keymapTestingActivity, View view) {
        this.f5054b = keymapTestingActivity;
        View m12800a = Utils.m12800a(view, R.id.btnDownload, "method 'onBtnDownloadClicked'");
        this.f5055c = m12800a;
        m12800a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.settings.KeymapTestingActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                keymapTestingActivity.onBtnDownloadClicked(view2);
            }
        });
        View m12800a2 = Utils.m12800a(view, R.id.btnWrite, "method 'onBtnWriteClicked'");
        this.f5056d = m12800a2;
        m12800a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.settings.KeymapTestingActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                keymapTestingActivity.onBtnWriteClicked(view2);
            }
        });
        View m12800a3 = Utils.m12800a(view, R.id.btnGetFromSp, "method 'onBtnGetClicked'");
        this.f5057e = m12800a3;
        m12800a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.settings.KeymapTestingActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                keymapTestingActivity.onBtnGetClicked(view2);
            }
        });
        View m12800a4 = Utils.m12800a(view, R.id.correctKeymap, "method 'onBtnCorrectClicked'");
        this.f5058f = m12800a4;
        m12800a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.settings.KeymapTestingActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                keymapTestingActivity.onBtnCorrectClicked(view2);
            }
        });
        View m12800a5 = Utils.m12800a(view, R.id.wrongKeymap, "method 'onBtnWrongClicked'");
        this.f5059g = m12800a5;
        m12800a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.settings.KeymapTestingActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                keymapTestingActivity.onBtnWrongClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        if (this.f5054b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f5054b = null;
        this.f5055c.setOnClickListener(null);
        this.f5055c = null;
        this.f5056d.setOnClickListener(null);
        this.f5056d = null;
        this.f5057e.setOnClickListener(null);
        this.f5057e = null;
        this.f5058f.setOnClickListener(null);
        this.f5058f = null;
        this.f5059g.setOnClickListener(null);
        this.f5059g = null;
    }
}
