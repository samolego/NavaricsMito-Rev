package com.navatics.app.settings;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.navatics.app.R;
import com.navatics.robot.utils.DpiUtils;

/* renamed from: com.navatics.app.settings.k */
/* loaded from: classes.dex */
public class SingleToggleSetting extends SettingEntry {

    /* renamed from: a */
    private Switch f5111a;

    /* renamed from: b */
    private InterfaceC1908a f5112b;

    /* renamed from: c */
    private String f5113c;

    /* renamed from: d */
    private String f5114d;

    /* renamed from: e */
    private boolean f5115e;

    /* compiled from: SingleToggleSetting.java */
    /* renamed from: com.navatics.app.settings.k$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1908a {
        /* renamed from: a */
        void m7413a(SingleToggleSetting singleToggleSetting, boolean z);
    }

    public SingleToggleSetting(Activity activity, String str, String str2, boolean z) {
        super(activity);
        this.f5113c = str;
        this.f5115e = z;
        this.f5114d = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.navatics.app.settings.SettingEntry
    /* renamed from: a */
    public View mo7411a() {
        this.f5093g = ((LayoutInflater) m7426g().getSystemService("layout_inflater")).inflate(R.layout.single_toggle_setting_layout, (ViewGroup) null, false);
        this.f5093g.setLayoutParams(new RelativeLayout.LayoutParams(-1, DpiUtils.m5887a(m7426g(), 65.0f)));
        this.f5111a = (Switch) this.f5093g.findViewById(R.id.swSwitch);
        this.f5111a.setChecked(m7426g().getSharedPreferences("app_settings", 0).getBoolean(this.f5114d, this.f5115e));
        this.f5111a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.navatics.app.settings.k.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SharedPreferences.Editor edit = SingleToggleSetting.this.m7426g().getSharedPreferences("app_settings", 0).edit();
                edit.putBoolean(SingleToggleSetting.this.f5114d, z);
                edit.apply();
                if (SingleToggleSetting.this.f5112b != null) {
                    SingleToggleSetting.this.f5112b.m7413a(SingleToggleSetting.this, z);
                }
            }
        });
        ((TextView) this.f5093g.findViewById(R.id.tvDisplayText)).setText(this.f5113c);
        return this.f5093g;
    }

    public void setOnStateChangedListener(InterfaceC1908a interfaceC1908a) {
        this.f5112b = interfaceC1908a;
    }
}
