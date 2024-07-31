package com.navatics.app.framework.international;

import android.content.SharedPreferences;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.github.mikephil.charting.utils.Utils;
import com.navatics.robot.transport.NvDimension;
import com.navatics.robot.transport.NvUnit;
import com.navatics.robot.transport.NvValue;
import com.navatics.robot.transport.p062a.IDimension;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.international.a */
/* loaded from: classes.dex */
public class TextViewInternationalHelper implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a */
    private static final C3044k f4686a = C3044k.m1564a(TextViewInternationalHelper.class);

    /* renamed from: b */
    private TextView f4687b;

    /* renamed from: c */
    private NvValue f4688c;

    /* renamed from: d */
    private IDimension f4689d;

    /* renamed from: e */
    private int f4690e;

    /* renamed from: f */
    private NvUnit f4691f;

    /* renamed from: g */
    private SparseArray<NvUnit> f4692g;

    public TextViewInternationalHelper(TextView textView, IDimension iDimension) {
        this(textView, iDimension, null, Utils.DOUBLE_EPSILON);
    }

    public TextViewInternationalHelper(TextView textView, IDimension iDimension, NvUnit nvUnit, double d) {
        this.f4692g = new SparseArray<>();
        this.f4687b = textView;
        this.f4689d = iDimension;
        this.f4687b.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.navatics.app.framework.international.a.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                TextViewInternationalHelper.this.f4687b.getContext().getSharedPreferences("app_settings", 0).unregisterOnSharedPreferenceChangeListener(TextViewInternationalHelper.this);
            }
        });
        SharedPreferences sharedPreferences = this.f4687b.getContext().getSharedPreferences("app_settings", 0);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.f4690e = sharedPreferences.getInt("key_dimension_setting", 0);
        this.f4691f = NvDimension.m6274a(this.f4689d.mo6268a(), 0);
        C3044k c3044k = f4686a;
        c3044k.mo1511a((Object) ("initOutputUnit " + nvUnit + ", system " + NvDimension.m6275a(this.f4690e)));
        nvUnit = nvUnit == null ? NvDimension.m6274a(this.f4689d.mo6268a(), this.f4690e) : nvUnit;
        if (nvUnit == null || !iDimension.mo6269b(nvUnit) || !NvDimension.m6273a(nvUnit, this.f4690e)) {
            throw new RuntimeException(nvUnit + ", " + iDimension + ", CurrentSystem " + NvDimension.m6275a(this.f4690e));
        }
        this.f4688c = NvValue.m5978a(nvUnit, d);
        this.f4692g.put(this.f4689d.mo6268a(), nvUnit);
    }

    /* renamed from: a */
    public void m8053a(NvUnit nvUnit) {
        if (this.f4689d.mo6268a() != nvUnit.m6004c()) {
            throw new RuntimeException("except dimension " + this.f4689d + ", but got " + NvDimension.m6271b(nvUnit.m6004c()));
        }
        this.f4688c = this.f4688c.m5979a(nvUnit);
        this.f4692g.put(this.f4689d.mo6268a(), nvUnit);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("key_dimension_setting".equals(str)) {
            int i = sharedPreferences.getInt(str, 0);
            C3044k c3044k = f4686a;
            c3044k.mo1511a((Object) ("dimension changed to " + NvDimension.m6275a(i)));
            if (i == this.f4690e) {
                return;
            }
            this.f4690e = i;
            int i2 = this.f4690e;
            NvUnit m5972b = this.f4688c.m5972b();
            NvUnit nvUnit = this.f4692g.get(this.f4690e);
            if (nvUnit == null) {
                nvUnit = NvDimension.m6274a(this.f4689d.mo6268a(), this.f4690e);
            }
            if (nvUnit == null) {
                throw new RuntimeException("can't found unit for dimen " + this.f4689d.mo6267b() + " in system " + NvDimension.m6275a(this.f4690e));
            }
            this.f4688c = this.f4688c.m5979a(nvUnit);
            this.f4692g.put(i2, m5972b);
        }
    }

    /* renamed from: a */
    public void m8058a() {
        this.f4687b.setText(this.f4688c.m5984a());
    }

    /* renamed from: a */
    public void m8056a(double d, NvUnit nvUnit) {
        this.f4688c.m5982a(d, nvUnit);
        m8058a();
    }

    /* renamed from: b */
    public void m8051b(NvUnit nvUnit) {
        this.f4691f = nvUnit;
    }

    /* renamed from: a */
    public void m8057a(double d) {
        m8056a(d, this.f4691f);
    }

    /* renamed from: a */
    public void m8052a(NvValue.C2146a c2146a) {
        this.f4688c.m5975a(c2146a);
        m8058a();
    }

    /* renamed from: a */
    public void m8055a(int i) {
        this.f4688c.m5980a(i);
    }
}
