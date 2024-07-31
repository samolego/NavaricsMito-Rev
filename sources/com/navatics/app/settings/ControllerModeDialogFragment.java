package com.navatics.app.settings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class ControllerModeDialogFragment extends DialogFragment {

    /* renamed from: a */
    private TextView f5038a;

    /* renamed from: b */
    private TextView f5039b;

    /* renamed from: c */
    private ImageView f5040c;

    /* renamed from: d */
    private InterfaceC1896a f5041d;

    /* renamed from: e */
    private int f5042e;

    /* renamed from: f */
    private int f5043f;

    /* renamed from: g */
    private ImageView f5044g;

    /* renamed from: h */
    private boolean f5045h;

    /* renamed from: com.navatics.app.settings.ControllerModeDialogFragment$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1896a {
        /* renamed from: a */
        void mo7478a(int i);
    }

    @Override // android.support.p008v4.app.DialogFragment, android.support.p008v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R.style.DialogFragmentStyle);
    }

    @Override // android.support.p008v4.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().setCanceledOnTouchOutside(true);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.gravity = 81;
        getDialog().getWindow().setAttributes(attributes);
        View inflate = layoutInflater.inflate(R.layout.dialog_controller_mode, viewGroup);
        this.f5038a = (TextView) inflate.findViewById(R.id.tv_mode);
        this.f5040c = (ImageView) inflate.findViewById(R.id.iv_controller_mode);
        this.f5039b = (TextView) inflate.findViewById(R.id.tv_use);
        this.f5044g = (ImageView) inflate.findViewById(R.id.iv_touchpad);
        m7484a(this.f5042e, this.f5043f);
        return inflate;
    }

    /* renamed from: a */
    public void m7483a(int i, int i2, boolean z) {
        this.f5042e = i;
        this.f5043f = i2;
        this.f5045h = z;
    }

    /* renamed from: a */
    private void m7484a(final int i, int i2) {
        if (i == 1) {
            this.f5038a.setText(getString(R.string.mode1));
            this.f5044g.setImageResource(R.drawable.keymap_touchpad);
            this.f5040c.setImageResource(R.drawable.keymap_mode1);
        } else if (i == 2) {
            this.f5038a.setText(getString(R.string.mode2));
            this.f5044g.setImageResource(R.drawable.keymap_touchpad);
            this.f5040c.setImageResource(R.drawable.keymap_mode2);
        } else if (i == 3) {
            this.f5038a.setText(getString(R.string.mode3));
            this.f5044g.setImageResource(R.drawable.keymap_lanchpad_3);
            this.f5040c.setImageResource(R.drawable.keymap_mode3);
        }
        if (i == i2) {
            m7485a();
        } else {
            this.f5039b.setText(getString(R.string.use));
            this.f5039b.setTextColor(getResources().getColor(R.color.color_497096));
            this.f5039b.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.settings.ControllerModeDialogFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ControllerModeDialogFragment.this.f5045h) {
                        ControllerModeDialogFragment.this.m7485a();
                    }
                    if (ControllerModeDialogFragment.this.f5041d != null) {
                        ControllerModeDialogFragment.this.f5041d.mo7478a(i);
                    }
                }
            });
        }
        this.f5038a.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.settings.ControllerModeDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ControllerModeDialogFragment.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7485a() {
        this.f5039b.setText(getString(R.string.using));
        this.f5039b.setTextColor(getResources().getColor(R.color.color_5FB500));
    }

    /* renamed from: a */
    public void m7482a(InterfaceC1896a interfaceC1896a) {
        this.f5041d = interfaceC1896a;
    }
}
