package com.takisoft.fix.support.p069v7.preference;

import android.os.Bundle;
import android.support.p011v7.preference.PreferenceDialogFragmentCompat;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;

/* renamed from: com.takisoft.fix.support.v7.preference.EditTextPreferenceDialogFragmentCompat */
/* loaded from: classes2.dex */
public class EditTextPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private EditText mEditText;

    @Override // android.support.p011v7.preference.PreferenceDialogFragmentCompat
    protected boolean needInputMethod() {
        return true;
    }

    public static EditTextPreferenceDialogFragmentCompat newInstance(String str) {
        EditTextPreferenceDialogFragmentCompat editTextPreferenceDialogFragmentCompat = new EditTextPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        editTextPreferenceDialogFragmentCompat.setArguments(bundle);
        return editTextPreferenceDialogFragmentCompat;
    }

    @Override // android.support.p011v7.preference.PreferenceDialogFragmentCompat
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        this.mEditText = getEditTextPreference().getEditText();
        this.mEditText.setText(getEditTextPreference().getText());
        Editable text = this.mEditText.getText();
        if (text != null) {
            this.mEditText.setSelection(text.length(), text.length());
        }
        ViewParent parent = this.mEditText.getParent();
        if (parent != view) {
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.mEditText);
            }
            onAddEditTextToDialogView(view, this.mEditText);
        }
    }

    private EditTextPreference getEditTextPreference() {
        return (EditTextPreference) getPreference();
    }

    protected void onAddEditTextToDialogView(View view, EditText editText) {
        ViewGroup viewGroup;
        View findViewById = view.findViewById(16908291);
        if (findViewById == null || (viewGroup = (ViewGroup) findViewById.getParent()) == null) {
            return;
        }
        viewGroup.removeView(findViewById);
        viewGroup.addView(editText, -1, -2);
    }

    @Override // android.support.p011v7.preference.PreferenceDialogFragmentCompat
    public void onDialogClosed(boolean z) {
        if (z) {
            String obj = this.mEditText.getText().toString();
            if (getEditTextPreference().callChangeListener(obj)) {
                getEditTextPreference().setText(obj);
            }
        }
    }
}
