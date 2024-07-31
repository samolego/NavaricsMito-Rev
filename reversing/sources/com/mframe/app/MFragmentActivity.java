package com.mframe.app;

import android.content.Context;
import android.os.Bundle;
import android.support.p008v4.app.FragmentActivity;
import android.support.p008v4.app.FragmentManager;

/* loaded from: classes.dex */
public class MFragmentActivity extends FragmentActivity {

    /* renamed from: a */
    protected Context f3452a;

    /* renamed from: b */
    private FragmentManager f3453b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3452a = this;
        this.f3453b = getSupportFragmentManager();
    }
}
