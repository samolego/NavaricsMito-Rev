package com.navatics.app.widget.dialog;

import android.content.DialogInterface;

/* loaded from: classes.dex */
public class MiniLoadingDialog extends BaseDialog {

    /* renamed from: a */
    private MiniLoadingView f5649a;

    /* renamed from: b */
    private LoadingCancelListener f5650b;

    @Override // android.app.Dialog
    public void show() {
        super.show();
        MiniLoadingView miniLoadingView = this.f5649a;
        if (miniLoadingView != null) {
            miniLoadingView.m6979a();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        MiniLoadingView miniLoadingView = this.f5649a;
        if (miniLoadingView != null) {
            miniLoadingView.m6975b();
        }
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (z) {
            setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.navatics.app.widget.dialog.MiniLoadingDialog.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (MiniLoadingDialog.this.f5650b != null) {
                        MiniLoadingDialog.this.f5650b.m6971a();
                    }
                }
            });
        }
    }
}
