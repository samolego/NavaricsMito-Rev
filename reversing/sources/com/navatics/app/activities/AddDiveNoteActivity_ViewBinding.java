package com.navatics.app.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class AddDiveNoteActivity_ViewBinding implements Unbinder {

    /* renamed from: b */
    private AddDiveNoteActivity f3492b;

    @UiThread
    public AddDiveNoteActivity_ViewBinding(AddDiveNoteActivity addDiveNoteActivity, View view) {
        this.f3492b = addDiveNoteActivity;
        addDiveNoteActivity.etNote = (EditText) Utils.m12799a(view, R.id.etNote, "field 'etNote'", EditText.class);
        addDiveNoteActivity.btnSave = (Button) Utils.m12799a(view, R.id.btnSave, "field 'btnSave'", Button.class);
        addDiveNoteActivity.btnBack = (ImageView) Utils.m12799a(view, R.id.btnBack, "field 'btnBack'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    /* renamed from: a */
    public void mo7436a() {
        AddDiveNoteActivity addDiveNoteActivity = this.f3492b;
        if (addDiveNoteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f3492b = null;
        addDiveNoteActivity.etNote = null;
        addDiveNoteActivity.btnSave = null;
        addDiveNoteActivity.btnBack = null;
    }
}
