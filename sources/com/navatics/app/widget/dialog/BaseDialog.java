package com.navatics.app.widget.dialog;

import android.content.Context;
import android.support.p011v7.app.AppCompatDialog;
import android.view.View;
import android.view.ViewGroup;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class BaseDialog extends AppCompatDialog {

    /* renamed from: a */
    private View f5648a;

    public BaseDialog(Context context, int i) {
        this(context, R.style.dialogCustom, i);
    }

    public BaseDialog(Context context, int i, int i2) {
        super(context, i);
        m6982a(i2);
    }

    /* renamed from: a */
    public void m6982a(int i) {
        m6981a(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        getWindow().setBackgroundDrawableResource(17170445);
    }

    /* renamed from: a */
    private void m6981a(View view) {
        setContentView(view);
        this.f5648a = view;
        setCanceledOnTouchOutside(true);
    }

    @Override // android.support.p011v7.app.AppCompatDialog, android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) this.f5648a.findViewById(i);
    }
}
