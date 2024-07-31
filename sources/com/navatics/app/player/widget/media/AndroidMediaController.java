package com.navatics.app.player.widget.media;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.p011v7.app.ActionBar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class AndroidMediaController extends MediaController implements IMediaController {

    /* renamed from: a */
    private ActionBar f4895a;

    /* renamed from: b */
    private ArrayList<View> f4896b;

    /* renamed from: c */
    private InterfaceC1865a f4897c;

    /* renamed from: com.navatics.app.player.widget.media.AndroidMediaController$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1865a {
        /* renamed from: a */
        void m7635a();

        /* renamed from: b */
        void m7634b();
    }

    /* renamed from: a */
    private void m7636a(Context context) {
    }

    public AndroidMediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4896b = new ArrayList<>();
        m7636a(context);
    }

    public AndroidMediaController(Context context, boolean z) {
        super(context, z);
        this.f4896b = new ArrayList<>();
        m7636a(context);
    }

    public AndroidMediaController(Context context) {
        super(context);
        this.f4896b = new ArrayList<>();
        m7636a(context);
    }

    public void setSupportActionBar(@Nullable ActionBar actionBar) {
        this.f4895a = actionBar;
        if (isShowing()) {
            actionBar.show();
        } else {
            actionBar.hide();
        }
    }

    @Override // android.widget.MediaController, com.navatics.app.player.widget.media.IMediaController
    public void show() {
        super.show();
        if (this.f4895a != null) {
            if (this.f4897c != null) {
                Log.i("info1", "show0: ");
                this.f4897c.m7635a();
            }
            Log.i("info1", "show1: ");
            this.f4895a.show();
        }
        Log.i("info1", "show2: ");
    }

    @Override // android.widget.MediaController, com.navatics.app.player.widget.media.IMediaController
    public void hide() {
        super.hide();
        if (this.f4895a != null) {
            if (this.f4897c != null) {
                Log.i("info1", "hide: ");
                this.f4897c.m7634b();
            }
            this.f4895a.hide();
        }
        Log.i("info1", "show1: ");
        Iterator<View> it = this.f4896b.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        this.f4896b.clear();
    }

    public void setOnShowListener(InterfaceC1865a interfaceC1865a) {
        this.f4897c = interfaceC1865a;
    }
}
