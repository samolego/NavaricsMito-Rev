package com.navatics.app.widget.dialog;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.view.ViewGroup;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class BaseDialog extends AppCompatDialog {

    /* renamed from: a */
    private View f5670a;

    public BaseDialog(Context context, int i) {
        this(context, R.style.dialogCustom, i);
    }

    public BaseDialog(Context context, int i, int i2) {
        super(context, i);
        m5884a(i2);
    }

    /* renamed from: a */
    public void m5884a(int i) {
        m5883a(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    /* renamed from: a */
    private void m5883a(View view) {
        setContentView(view);
        this.f5670a = view;
        setCanceledOnTouchOutside(true);
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) this.f5670a.findViewById(i);
    }
}