package com.mframe.adapter;

import android.support.p008v4.app.FragmentPagerAdapter;
import com.mframe.app.MFragment;
import java.util.List;

/* loaded from: classes.dex */
public class MFragmentPagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a */
    private List<MFragment> f3446a;

    @Override // android.support.p008v4.app.FragmentPagerAdapter
    /* renamed from: a */
    public MFragment getItem(int i) {
        List<MFragment> list = this.f3446a;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f3446a.get(i);
    }

    @Override // android.support.p008v4.view.PagerAdapter
    public int getCount() {
        List<MFragment> list = this.f3446a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
