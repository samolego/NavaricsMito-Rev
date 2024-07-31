package com.yayandroid.locationmanager.p086d.p087a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.p011v7.app.AlertDialog;

/* renamed from: com.yayandroid.locationmanager.d.a.b */
/* loaded from: classes2.dex */
public class SimpleMessageDialogProvider extends DialogProvider implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private String f9372a;

    public SimpleMessageDialogProvider(String str) {
        this.f9372a = str;
    }

    @Override // com.yayandroid.locationmanager.p086d.p087a.DialogProvider
    /* renamed from: a */
    public Dialog mo3605a(@NonNull Context context) {
        return new AlertDialog.Builder(context).setMessage(this.f9372a).setCancelable(false).setPositiveButton(17039370, this).setNegativeButton(17039360, this).create();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -2:
                if (m3607a() != null) {
                    m3607a().mo3516f_();
                    return;
                }
                return;
            case -1:
                if (m3607a() != null) {
                    m3607a().mo3521a();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
