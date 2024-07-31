package com.takisoft.fix.support.p069v7.preference;

import android.content.Context;
import android.support.p011v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

/* renamed from: com.takisoft.fix.support.v7.preference.EditTextPreference */
/* loaded from: classes2.dex */
public class EditTextPreference extends android.support.p011v7.preference.EditTextPreference {
    private EditText editText;

    public EditTextPreference(Context context) {
        this(context, null);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C2380R.attr.editTextPreferenceStyle);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.editText = new AppCompatEditText(context, attributeSet);
        this.editText.setId(16908291);
    }

    public EditText getEditText() {
        return this.editText;
    }

    @Override // android.support.p011v7.preference.EditTextPreference
    public void setText(String str) {
        String text = getText();
        super.setText(str);
        if (TextUtils.equals(str, text)) {
            return;
        }
        notifyChanged();
    }
}
