package com.navatics.app.utils;

import android.view.View;
import java.util.Calendar;

/* compiled from: NoDoubleClickListener.java */
/* renamed from: com.navatics.app.utils.m */
/* loaded from: classes.dex */
public abstract class AbstractViewOnClickListenerC1828m implements View.OnClickListener {

    /* renamed from: a */
    private long f5155a = 0;

    /* renamed from: a */
    protected abstract void mo4166a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.f5155a > 1000) {
            this.f5155a = timeInMillis;
            mo4166a(view);
        }
    }
}