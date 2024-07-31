package com.takisoft.fix.support.p069v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.AttributeSet;

/* renamed from: com.takisoft.fix.support.v7.preference.AutoSummaryEditTextPreference */
/* loaded from: classes2.dex */
public class AutoSummaryEditTextPreference extends EditTextPreference {
    private String passwordSubstitute;
    private int passwordSubstituteLength;
    private CharSequence summary;
    private CharSequence summaryHasText;

    public AutoSummaryEditTextPreference(Context context) {
        this(context, null);
    }

    public AutoSummaryEditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C2380R.attr.editTextPreferenceStyle);
    }

    public AutoSummaryEditTextPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public AutoSummaryEditTextPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2380R.styleable.AutoSummaryEditTextPreference, i, 0);
        this.summaryHasText = obtainStyledAttributes.getText(C2380R.styleable.AutoSummaryEditTextPreference_pref_summaryHasText);
        this.passwordSubstitute = obtainStyledAttributes.getString(C2380R.styleable.AutoSummaryEditTextPreference_pref_summaryPasswordSubstitute);
        this.passwordSubstituteLength = obtainStyledAttributes.getInt(C2380R.styleable.f7108x76bdd3b, 5);
        if (this.passwordSubstitute == null) {
            this.passwordSubstitute = "•";
        }
        obtainStyledAttributes.recycle();
        this.summary = super.getSummary();
    }

    @Override // android.support.p011v7.preference.Preference
    public CharSequence getSummary() {
        String text = getText();
        if (!(!TextUtils.isEmpty(text))) {
            return this.summary;
        }
        int inputType = getEditText().getInputType();
        if ((inputType & 16) == 16 || (inputType & 128) == 128 || (inputType & 224) == 224) {
            int i = this.passwordSubstituteLength;
            if (i <= 0) {
                i = text.length();
            }
            text = new String(new char[i]).replaceAll("\u0000", this.passwordSubstitute);
        }
        CharSequence charSequence = this.summaryHasText;
        return charSequence != null ? String.format(charSequence.toString(), text) : text;
    }

    @Override // android.support.p011v7.preference.Preference
    public void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null && this.summary != null) {
            this.summary = null;
        } else if (charSequence == null || charSequence.equals(this.summary)) {
        } else {
            this.summary = charSequence.toString();
        }
    }

    @Nullable
    public CharSequence getSummaryHasText() {
        return this.summaryHasText;
    }

    public void setSummaryHasText(@StringRes int i) {
        setSummaryHasText(getContext().getString(i));
    }

    public void setSummaryHasText(@Nullable CharSequence charSequence) {
        if (charSequence == null && this.summaryHasText != null) {
            this.summaryHasText = null;
        } else if (charSequence != null && !charSequence.equals(this.summaryHasText)) {
            this.summaryHasText = charSequence.toString();
        }
        notifyChanged();
    }

    public CharSequence getPasswordSubstitute() {
        return this.passwordSubstitute;
    }

    public void setPasswordSubstitute(@StringRes int i) {
        setPasswordSubstitute(getContext().getString(i));
    }

    public void setPasswordSubstitute(String str) {
        this.passwordSubstitute = str;
    }

    public int getPasswordSubstituteLength() {
        return this.passwordSubstituteLength;
    }

    public void setPasswordSubstituteLength(int i) {
        this.passwordSubstituteLength = i;
    }
}
