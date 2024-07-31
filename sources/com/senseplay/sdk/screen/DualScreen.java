package com.senseplay.sdk.screen;

import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

/* loaded from: classes2.dex */
public class DualScreen extends Presentation {
    private Context mContext;
    private int mResId;
    private View mView;

    public DualScreen(Context context, Display display) {
        super(context, display);
        this.mContext = context;
    }

    public void setLayoutView(View view) {
        this.mView = view;
    }

    public void setLayoutView(int i) {
        this.mResId = i;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = this.mResId;
        if (i != 0) {
            setContentView(i);
        } else {
            setContentView(this.mView);
        }
    }
}
