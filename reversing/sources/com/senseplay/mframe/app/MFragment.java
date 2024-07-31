package com.senseplay.mframe.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.FragmentManager;
import android.support.p008v4.app.FragmentTransaction;

/* loaded from: classes2.dex */
public class MFragment extends Fragment {

    /* renamed from: fm */
    private FragmentManager f6822fm;
    protected Context mContext;
    private Fragment mFragment;

    @Override // android.support.p008v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getActivity();
        this.f6822fm = getFragmentManager();
    }

    private void initIntent() {
        getArguments();
    }

    protected void switchFragment(int i, Fragment fragment) {
        if (i != 0) {
            try {
                if (this.f6822fm == null || fragment == null || fragment == null || this.mFragment == fragment) {
                    return;
                }
                FragmentTransaction beginTransaction = this.f6822fm.beginTransaction();
                if (this.mFragment == null) {
                    beginTransaction.add(i, fragment).commitAllowingStateLoss();
                } else if (!fragment.isAdded()) {
                    beginTransaction.hide(this.mFragment).add(i, fragment).commitAllowingStateLoss();
                } else {
                    beginTransaction.hide(this.mFragment).show(fragment).commitAllowingStateLoss();
                }
                this.mFragment = fragment;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void addFragment(int i, Fragment fragment) {
        FragmentManager fragmentManager;
        if (i == 0 || (fragmentManager = this.f6822fm) == null || fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(i, fragment);
        beginTransaction.commitAllowingStateLoss();
    }

    protected void addFragment(int i, Fragment fragment, String str) {
        FragmentManager fragmentManager;
        if (i == 0 || (fragmentManager = this.f6822fm) == null || fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(i, fragment, str);
        beginTransaction.commitAllowingStateLoss();
    }

    protected void replaceFragment(int i, Fragment fragment) {
        FragmentManager fragmentManager;
        if (i == 0 || (fragmentManager = this.f6822fm) == null || fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(i, fragment);
        beginTransaction.commitAllowingStateLoss();
    }

    protected void replaceFragment(int i, Fragment fragment, String str) {
        FragmentManager fragmentManager = this.f6822fm;
        if (fragmentManager == null || fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(i, fragment, str);
        beginTransaction.commitAllowingStateLoss();
    }

    protected void removeFragment(Fragment fragment) {
        FragmentManager fragmentManager = this.f6822fm;
        if (fragmentManager == null || fragment == null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.remove(fragment);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // android.support.p008v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mContext = activity;
    }
}
