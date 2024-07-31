package com.navatics.app.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p008v4.app.DialogFragment;
import android.support.p011v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class ParametersInputDialog extends DialogFragment {

    /* renamed from: a */
    private InterfaceC1944a f5430a;

    /* renamed from: b */
    private int f5431b;

    /* renamed from: c */
    private EditText f5432c;

    /* renamed from: com.navatics.app.widget.ParametersInputDialog$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1944a {
        /* renamed from: a */
        void mo7160a(ParametersInputDialog parametersInputDialog);

        /* renamed from: b */
        void mo7159b(ParametersInputDialog parametersInputDialog);
    }

    /* renamed from: a */
    public void m7164a(InterfaceC1944a interfaceC1944a) {
        this.f5430a = interfaceC1944a;
    }

    /* renamed from: a */
    public int m7165a() {
        return this.f5431b;
    }

    @Override // android.support.p008v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (getContext() == null) {
            throw new IllegalStateException("wtf ?! getContext is null");
        }
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (layoutInflater == null) {
            throw new IllegalStateException("wtf ?! inflater is null");
        }
        View inflate = layoutInflater.inflate(R.layout.parameter_input_layout, (ViewGroup) null);
        this.f5432c = (EditText) inflate.findViewById(R.id.etParamValue);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(inflate).setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.navatics.app.widget.ParametersInputDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ParametersInputDialog parametersInputDialog = ParametersInputDialog.this;
                parametersInputDialog.f5431b = Integer.valueOf(parametersInputDialog.f5432c.getText().toString()).intValue();
                ParametersInputDialog.this.f5430a.mo7160a(ParametersInputDialog.this);
            }
        }).setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.navatics.app.widget.ParametersInputDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ParametersInputDialog.this.f5430a.mo7159b(ParametersInputDialog.this);
            }
        });
        return builder.create();
    }
}
