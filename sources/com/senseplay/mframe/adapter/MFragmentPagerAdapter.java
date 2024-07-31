package com.senseplay.mframe.adapter;

import android.support.p008v4.app.FragmentManager;
import android.support.p008v4.app.FragmentPagerAdapter;
import com.senseplay.mframe.app.MFragment;
import java.util.List;

/* loaded from: classes2.dex */
public class MFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<MFragment> fragmentList;

    public MFragmentPagerAdapter(FragmentManager fragmentManager, List<MFragment> list) {
        super(fragmentManager);
        this.fragmentList = list;
    }

    @Override // android.support.p008v4.app.FragmentPagerAdapter
    public MFragment getItem(int i) {
        List<MFragment> list = this.fragmentList;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.fragmentList.get(i);
    }

    @Override // android.support.p008v4.view.PagerAdapter
    public int getCount() {
        List<MFragment> list = this.fragmentList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
