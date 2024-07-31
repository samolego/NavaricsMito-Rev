package com.navatics.app.utils;

import android.support.p008v4.app.FragmentActivity;
import com.navatics.app.R;
import com.navatics.app.widget.CommonDialog;

/* renamed from: com.navatics.app.utils.e */
/* loaded from: classes.dex */
public class DialogFactory {
    /* renamed from: a */
    public static CommonDialog m7401a(FragmentActivity fragmentActivity) {
        return new CommonDialog(fragmentActivity, R.layout.dialog_common_layout);
    }

    /* renamed from: b */
    public static CommonDialog m7400b(FragmentActivity fragmentActivity) {
        return new CommonDialog(fragmentActivity, R.layout.dialog_common_hint);
    }

    /* renamed from: c */
    public static CommonDialog m7399c(FragmentActivity fragmentActivity) {
        CommonDialog commonDialog = new CommonDialog(fragmentActivity, R.layout.usrinfo_bottom_menu);
        commonDialog.m7345a(80).m7344a(-1, -2).m7338b(R.style.AnimBottom);
        return commonDialog;
    }
}
