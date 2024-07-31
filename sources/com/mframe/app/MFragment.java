package com.mframe.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.FragmentManager;

/* loaded from: classes.dex */
public class MFragment extends Fragment {

    /* renamed from: a */
    private FragmentManager f3450a;

    /* renamed from: b */
    protected Context f3451b;

    @Override // android.support.p008v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3451b = getActivity();
        this.f3450a = getFragmentManager();
    }

    @Override // android.support.p008v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3451b = activity;
    }
}
