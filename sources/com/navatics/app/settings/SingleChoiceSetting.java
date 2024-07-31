package com.navatics.app.settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.navatics.app.settings.SettingEntry;

/* renamed from: com.navatics.app.settings.j */
/* loaded from: classes.dex */
public abstract class SingleChoiceSetting extends SimpleSetting implements SettingEntry.InterfaceC1906a {

    /* renamed from: a */
    private String f5108a;

    /* renamed from: b */
    private int f5109b;

    /* renamed from: c */
    private String[] f5110c;

    public static /* synthetic */ void lambda$KCBp9y30cZG4eC2kwiBgdCpWnQA(SingleChoiceSetting singleChoiceSetting, SharedPreferences sharedPreferences, int i, DialogInterface dialogInterface, int i2) {
        singleChoiceSetting.m7416a(sharedPreferences, i, dialogInterface, i2);
    }

    public SingleChoiceSetting(Activity activity, String str, String[] strArr, String str2, int i) {
        super(activity, str);
        this.f5110c = strArr;
        this.f5109b = i;
        this.f5108a = str2;
        int i2 = m7426g().getSharedPreferences("app_settings", 0).getInt(this.f5108a, this.f5109b);
        m7421b(true);
        m7422b(this.f5110c[i2]);
        setOnClickListener(this);
    }

    @Override // com.navatics.app.settings.SettingEntry.InterfaceC1906a
    public void onClick(SettingEntry settingEntry) {
        final SharedPreferences sharedPreferences = m7426g().getSharedPreferences("app_settings", 0);
        final int i = sharedPreferences.getInt(this.f5108a, this.f5109b);
        new AlertDialog.Builder(m7426g()).setSingleChoiceItems(this.f5110c, i, new DialogInterface.OnClickListener() { // from class: com.navatics.app.settings.-$$Lambda$j$KCBp9y30cZG4eC2kwiBgdCpWnQA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                SingleChoiceSetting.lambda$KCBp9y30cZG4eC2kwiBgdCpWnQA(SingleChoiceSetting.this, sharedPreferences, i, dialogInterface, i2);
            }
        }).create().show();
    }

    /* renamed from: a */
    public /* synthetic */ void m7416a(SharedPreferences sharedPreferences, int i, DialogInterface dialogInterface, int i2) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (i2 != i) {
            edit.putInt(this.f5108a, i2);
            edit.apply();
            m7422b(this.f5110c[i2]);
        }
        dialogInterface.dismiss();
    }
}
