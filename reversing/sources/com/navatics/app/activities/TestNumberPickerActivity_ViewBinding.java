package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.navatics.app.R;
import com.navatics.app.widget.NvNumberPicker;

/* loaded from: classes.dex */
public class TestNumberPickerActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private TestNumberPickerActivity f3909b;

    /* renamed from: c */
    private View f3910c;

    /* renamed from: d */
    private View f3911d;

    @UiThread
    public TestNumberPickerActivity_ViewBinding(final TestNumberPickerActivity testNumberPickerActivity, View view) {
        this.f3909b = testNumberPickerActivity;
        View m12800a = Utils.m12800a(view, R.id.btn1, "field 'btn1' and method 'onClick'");
        testNumberPickerActivity.btn1 = (Button) Utils.m12798b(m12800a, R.id.btn1, "field 'btn1'", Button.class);
        this.f3910c = m12800a;
        m12800a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.TestNumberPickerActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                testNumberPickerActivity.onClick(view2);
            }
        });
        View m12800a2 = Utils.m12800a(view, R.id.btn2, "field 'btn2' and method 'onClick'");
        testNumberPickerActivity.btn2 = (Button) Utils.m12798b(m12800a2, R.id.btn2, "field 'btn2'", Button.class);
        this.f3911d = m12800a2;
        m12800a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.navatics.app.activities.TestNumberPickerActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* renamed from: a */
            public void mo7462a(View view2) {
                testNumberPickerActivity.onClick(view2);
            }
        });
        testNumberPickerActivity.testPicker = (NvNumberPicker) Utils.m12799a(view, R.id.testPicker, "field 'testPicker'", NvNumberPicker.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        TestNumberPickerActivity testNumberPickerActivity = this.f3909b;
        if (testNumberPickerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3909b = null;
        testNumberPickerActivity.btn1 = null;
        testNumberPickerActivity.btn2 = null;
        testNumberPickerActivity.testPicker = null;
        this.f3910c.setOnClickListener(null);
        this.f3910c = null;
        this.f3911d.setOnClickListener(null);
        this.f3911d = null;
    }
}
