package com.navatics.app.utils;

import android.view.View;
import java.util.Calendar;

/* renamed from: com.navatics.app.utils.m */
/* loaded from: classes.dex */
public abstract class NoDoubleClickListener implements View.OnClickListener {

    /* renamed from: a */
    private long f5133a = 0;

    /* renamed from: a */
    protected abstract void mo7367a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.f5133a > 1000) {
            this.f5133a = timeInMillis;
            mo7367a(view);
        }
    }
}
