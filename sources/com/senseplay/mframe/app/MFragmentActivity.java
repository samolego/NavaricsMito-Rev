package com.senseplay.mframe.app;

import android.content.Context;
import android.os.Bundle;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.FragmentActivity;
import android.support.p008v4.app.FragmentManager;
import android.support.p008v4.app.FragmentTransaction;

/* loaded from: classes2.dex */
public class MFragmentActivity extends FragmentActivity {

    /* renamed from: fm */
    private FragmentManager f6823fm;
    protected Context mContext;
    private Fragment mFragment;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.f6823fm = getSupportFragmentManager();
    }

    protected void switchFragment(int i, Fragment fragment) {
        if (i != 0) {
            try {
                if (this.f6823fm == null || fragment == null || fragment == null || this.mFragment == fragment) {
                    return;
                }
                FragmentTransaction beginTransaction = this.f6823fm.beginTransaction();
                if (this.mFragment == null) {
                    beginTransaction.add(i, fragment).commit();
                } else if (!fragment.isAdded()) {
                    beginTransaction.hide(this.mFragment).add(i, fragment).commit();
                } else {
                    beginTransaction.hide(this.mFragment).show(fragment).commit();
                }
                this.mFragment = fragment;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void addFragment(int i, Fragment fragment) {
        FragmentManager fragmentManager;
        if (i == 0 || (fragmentManager = this.f6823fm) == null || fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(i, fragment);
        beginTransaction.commit();
    }

    protected void addFragment(int i, Fragment fragment, String str) {
        FragmentManager fragmentManager;
        if (i == 0 || (fragmentManager = this.f6823fm) == null || fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(i, fragment, str);
        beginTransaction.commit();
    }

    protected void replaceFragment(int i, Fragment fragment) {
        FragmentManager fragmentManager;
        if (i == 0 || (fragmentManager = this.f6823fm) == null || fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(i, fragment);
        beginTransaction.commit();
    }

    protected void replaceFragment(int i, Fragment fragment, String str) {
        FragmentManager fragmentManager = this.f6823fm;
        if (fragmentManager == null || fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(i, fragment, str);
        beginTransaction.commit();
    }

    protected void removeFragment(Fragment fragment) {
        FragmentManager fragmentManager = this.f6823fm;
        if (fragmentManager == null || fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.remove(fragment);
        beginTransaction.commit();
    }
}
