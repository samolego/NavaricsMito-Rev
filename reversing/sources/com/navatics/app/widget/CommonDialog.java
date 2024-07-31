package com.navatics.app.widget;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.app.DialogFragment;
import android.support.p008v4.app.FragmentActivity;
import android.support.p008v4.app.FragmentManager;
import android.support.p008v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.HashMap;

/* loaded from: classes.dex */
public class CommonDialog extends DialogFragment {

    /* renamed from: e */
    private View f5175e;

    /* renamed from: f */
    private FragmentActivity f5176f;

    /* renamed from: g */
    private int f5177g;

    /* renamed from: j */
    private InterfaceC1914a f5180j;

    /* renamed from: b */
    private int f5172b = 0;

    /* renamed from: c */
    private int f5173c = 0;

    /* renamed from: d */
    private int f5174d = 17;

    /* renamed from: a */
    HashMap<Integer, View> f5171a = new HashMap<>();

    /* renamed from: h */
    private int f5178h = -1;

    /* renamed from: i */
    private boolean f5179i = false;

    /* renamed from: com.navatics.app.widget.CommonDialog$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1914a {
        /* renamed from: a */
        void mo7336a();
    }

    /* renamed from: com.navatics.app.widget.CommonDialog$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1915b {
        /* renamed from: a */
        void mo7335a(CommonDialog commonDialog);
    }

    public CommonDialog() {
    }

    @SuppressLint({"ValidFragment"})
    public CommonDialog(FragmentActivity fragmentActivity, int i) {
        this.f5176f = fragmentActivity;
        this.f5175e = LayoutInflater.from(fragmentActivity).inflate(i, (ViewGroup) null, false);
    }

    @Override // android.support.p008v4.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return this.f5175e;
    }

    @Override // android.support.p008v4.app.DialogFragment, android.support.p008v4.app.Fragment
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        int i = this.f5173c;
        if (i != 0) {
            attributes.height = i;
        }
        attributes.gravity = this.f5174d;
        int i2 = this.f5172b;
        if (i2 != 0) {
            attributes.width = i2;
        }
        int i3 = this.f5177g;
        if (i3 != 0) {
            attributes.windowAnimations = i3;
        }
        if (this.f5178h != -1) {
            getDialog().getWindow().setDimAmount(this.f5178h);
        }
        getDialog().getWindow().setDimAmount(0.0f);
        getDialog().getWindow().setAttributes(attributes);
        getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.navatics.app.widget.CommonDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (CommonDialog.this.f5180j != null) {
                    CommonDialog.this.f5180j.mo7336a();
                }
            }
        });
    }

    /* renamed from: a */
    public CommonDialog m7344a(int i, int i2) {
        this.f5172b = i;
        this.f5173c = i2;
        return this;
    }

    /* renamed from: a */
    public CommonDialog m7342a(int i, String str) {
        ((TextView) m7337c(i)).setText(str);
        return this;
    }

    /* renamed from: a */
    public CommonDialog m7343a(int i, final InterfaceC1915b interfaceC1915b) {
        m7337c(i).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.widget.CommonDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                interfaceC1915b.mo7335a(CommonDialog.this);
            }
        });
        return this;
    }

    /* renamed from: c */
    private View m7337c(int i) {
        if (this.f5171a.containsKey(Integer.valueOf(i))) {
            return this.f5171a.get(Integer.valueOf(i));
        }
        View findViewById = this.f5175e.findViewById(i);
        this.f5171a.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // android.support.p008v4.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            try {
                Field declaredField = getClass().getSuperclass().getDeclaredField("mDismissed");
                Field declaredField2 = getClass().getSuperclass().getDeclaredField("mShownByMe");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                declaredField.setBoolean(this, false);
                declaredField2.setBoolean(this, true);
                if (isAdded()) {
                    return;
                }
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                beginTransaction.add(this, str);
                beginTransaction.commitAllowingStateLoss();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m7346a() {
        if (this.f5179i) {
            return;
        }
        this.f5179i = true;
        show(this.f5176f.getSupportFragmentManager(), "commonDialog");
    }

    public void setonDissmissLinsener(InterfaceC1914a interfaceC1914a) {
        this.f5180j = interfaceC1914a;
    }

    /* renamed from: a */
    public CommonDialog m7340a(boolean z) {
        setCancelable(z);
        return this;
    }

    /* renamed from: b */
    public void m7339b() {
        if (this.f5179i) {
            this.f5179i = false;
            try {
                dismiss();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public CommonDialog m7345a(int i) {
        this.f5174d = i;
        return this;
    }

    /* renamed from: b */
    public CommonDialog m7338b(int i) {
        this.f5177g = i;
        return this;
    }
}
