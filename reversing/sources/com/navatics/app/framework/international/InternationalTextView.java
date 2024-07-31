package com.navatics.app.framework.international;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p011v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.navatics.app.framework.R;
import com.navatics.robot.transport.NvDimension;
import com.navatics.robot.transport.NvUnit;
import com.navatics.robot.transport.NvValue;
import com.navatics.robot.transport.p062a.IDimension;
import com.navatics.robot.utils.C2160n;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class InternationalTextView extends AppCompatTextView {

    /* renamed from: a */
    private static final C3044k f4684a = C3044k.m1564a(InternationalTextView.class);

    /* renamed from: b */
    private TextViewInternationalHelper f4685b;

    public InternationalTextView(Context context) {
        super(context);
        m8059a(context, null, 0);
    }

    public InternationalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8059a(context, attributeSet, 0);
    }

    public InternationalTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8059a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m8059a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.InternationalTextView, i, i);
        String string = obtainStyledAttributes.getString(R.styleable.InternationalTextView_itv_dimension);
        if (C2160n.m5855a((CharSequence) string)) {
            throw new RuntimeException("dimension of InternationalTextView can't be empty");
        }
        IDimension m6272a = NvDimension.m6272a(string);
        if (m6272a == null) {
            throw new RuntimeException("can't find dimension : " + string);
        }
        NvUnit m6274a = NvDimension.m6274a(m6272a.mo6268a(), 0);
        this.f4685b = new TextViewInternationalHelper(this, m6272a);
        this.f4685b.m8051b(m6274a);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.InternationalTextView_itv_value_size, -1);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.InternationalTextView_itv_sym_size, -1);
        String string2 = obtainStyledAttributes.getString(R.styleable.InternationalTextView_itv_value_typeface);
        String string3 = obtainStyledAttributes.getString(R.styleable.InternationalTextView_itv_sym_typeface);
        C3044k c3044k = f4684a;
        c3044k.mo1500c((Object) ("valueTypeface " + string2 + ", symbolTypeface " + string3));
        NvValue.C2147b c2147b = new NvValue.C2147b();
        if (dimensionPixelSize != -1) {
            c2147b.m5958a(dimensionPixelSize);
        }
        if (dimensionPixelSize2 != -1) {
            c2147b.m5956c(dimensionPixelSize2);
        }
        if (string2 != null) {
            c2147b.m5957b(string2.equals("bold") ? 1 : 0);
        }
        if (string3 != null) {
            c2147b.m5955d(string3.equals("bold") ? 1 : 0);
        }
        NvValue.C2146a m5959a = c2147b.m5959a();
        C3044k c3044k2 = f4684a;
        c3044k2.mo1511a((Object) ("create : " + m5959a));
        this.f4685b.m8052a(m5959a);
        this.f4685b.m8055a(obtainStyledAttributes.getInt(R.styleable.InternationalTextView_itv_decimals, getResources().getInteger(R.integer.default_decimals_temperature)));
        obtainStyledAttributes.recycle();
        this.f4685b.m8058a();
    }

    public void setOutputUnit(NvUnit nvUnit) {
        this.f4685b.m8053a(nvUnit);
    }

    public void setInputUnit(NvUnit nvUnit) {
        this.f4685b.m8051b(nvUnit);
    }

    /* renamed from: a */
    public void m8060a(double d) {
        this.f4685b.m8057a(d);
    }
}
