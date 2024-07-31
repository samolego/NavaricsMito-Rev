package com.navatics.app.settings;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.navatics.app.R;
import com.navatics.app.widget.badge.BadgeView;
import com.navatics.robot.utils.DpiUtils;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.settings.i */
/* loaded from: classes.dex */
public class SimpleSetting extends SettingEntry {

    /* renamed from: a */
    private static final C3044k f5094a = C3044k.m1564a(SimpleSetting.class);

    /* renamed from: b */
    private CharSequence f5095b;

    /* renamed from: c */
    private TextView f5096c;

    /* renamed from: d */
    private ImageView f5097d;

    /* renamed from: e */
    private CharSequence f5098e;

    /* renamed from: f */
    private TextView f5099f;

    /* renamed from: h */
    private boolean f5100h;

    /* renamed from: i */
    private boolean f5101i;

    /* renamed from: j */
    private boolean f5102j;

    /* renamed from: k */
    private boolean f5103k;

    /* renamed from: l */
    private int f5104l;

    /* renamed from: m */
    private boolean f5105m;

    /* renamed from: n */
    private BadgeView f5106n;

    /* renamed from: o */
    private Context f5107o;

    public SimpleSetting(Activity activity, String str) {
        super(activity);
        this.f5100h = false;
        this.f5107o = activity;
        this.f5095b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.navatics.app.settings.SettingEntry
    /* renamed from: a */
    public View mo7411a() {
        this.f5093g = ((LayoutInflater) m7426g().getSystemService("layout_inflater")).inflate(R.layout.simple_setting_layout, (ViewGroup) null, false);
        this.f5093g.setLayoutParams(new RelativeLayout.LayoutParams(-1, DpiUtils.m5887a(m7426g(), 65.0f)));
        if (this.f5103k) {
            this.f5093g.setBackgroundColor(this.f5104l);
        }
        this.f5097d = (ImageView) this.f5093g.findViewById(R.id.ivRightArrow);
        this.f5097d.setVisibility(this.f5101i ? 8 : 0);
        this.f5099f = (TextView) this.f5093g.findViewById(R.id.tvIndicatorText);
        if (this.f5102j) {
            this.f5099f.setVisibility(0);
            this.f5099f.setText(this.f5098e);
        } else {
            this.f5099f.setVisibility(8);
        }
        this.f5096c = (TextView) this.f5093g.findViewById(R.id.tvDisplayText);
        if (this.f5105m) {
            m7417j();
        }
        this.f5096c.setText(this.f5095b);
        if (this.f5100h) {
            BadgeView badgeView = this.f5106n;
            if (badgeView == null) {
                this.f5106n = new BadgeView(this.f5107o);
                this.f5106n.m7016a(this.f5096c);
                this.f5106n.m7015a("");
                this.f5106n.m7022a(10.0f, 0.0f, true);
                this.f5106n.m7010b(false);
            } else {
                badgeView.setVisibility(0);
            }
        } else {
            BadgeView badgeView2 = this.f5106n;
            if (badgeView2 != null) {
                badgeView2.setVisibility(8);
            }
        }
        return this.f5093g;
    }

    /* renamed from: a */
    public void m7424a(CharSequence charSequence) {
        this.f5095b = charSequence;
        TextView textView = this.f5096c;
        if (textView != null) {
            textView.setText(this.f5095b);
        }
    }

    /* renamed from: a */
    public void m7423a(boolean z) {
        this.f5100h = z;
    }

    /* renamed from: d */
    public CharSequence m7420d() {
        return this.f5095b;
    }

    /* renamed from: h */
    public void m7419h() {
        this.f5101i = true;
        ImageView imageView = this.f5097d;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    /* renamed from: b */
    public void m7421b(boolean z) {
        this.f5102j = z;
    }

    /* renamed from: b */
    public void m7422b(CharSequence charSequence) {
        this.f5098e = charSequence;
        TextView textView = this.f5099f;
        if (textView != null) {
            textView.setText(this.f5098e);
        }
    }

    /* renamed from: i */
    public void m7418i() {
        this.f5105m = true;
        if (this.f5096c != null) {
            m7417j();
        }
    }

    /* renamed from: j */
    private void m7417j() {
        ((RelativeLayout.LayoutParams) this.f5096c.getLayoutParams()).addRule(14);
    }

    /* renamed from: a */
    public void m7425a(int i) {
        this.f5104l = i;
        this.f5103k = true;
        if (this.f5093g != null) {
            this.f5093g.findViewById(R.id.settingEntryContainer).setBackgroundColor(i);
        }
    }
}
