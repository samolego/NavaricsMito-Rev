package com.navatics.app;

import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.FragmentManager;
import android.support.p008v4.app.FragmentPagerAdapter;
import android.support.p008v4.view.ViewPager;
import android.util.SparseArray;
import com.navatics.app.fragments.IMultiSelectPage;
import com.navatics.app.fragments.IMultiSelectPageContainer;
import com.navatics.app.fragments.MediaLibraryPhotoFragment;
import com.navatics.app.fragments.MediaLibraryVideoFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TabFragmentPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    private String[] f3470a;

    /* renamed from: b */
    private SparseArray<Fragment> f3471b;

    /* renamed from: c */
    private List<IMultiSelectPage> f3472c;

    @Override // android.support.p008v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    public TabFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f3470a = new String[]{"Photo", "Video"};
        this.f3471b = new SparseArray<>();
        this.f3472c = new ArrayList();
        MediaLibraryPhotoFragment m8745c = MediaLibraryPhotoFragment.m8745c();
        this.f3472c.add(m8745c);
        this.f3471b.put(0, m8745c);
        MediaLibraryVideoFragment m8732c = MediaLibraryVideoFragment.m8732c();
        this.f3472c.add(m8732c);
        this.f3471b.put(1, m8732c);
    }

    /* renamed from: a */
    public void m9561a(IMultiSelectPageContainer iMultiSelectPageContainer) {
        for (IMultiSelectPage iMultiSelectPage : this.f3472c) {
            iMultiSelectPage.mo8736a(iMultiSelectPageContainer);
        }
    }

    /* renamed from: a */
    public List<IMultiSelectPage> m9562a() {
        return this.f3472c;
    }

    @Override // android.support.p008v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.f3471b.get(i);
    }

    @Override // android.support.p008v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.f3470a[i];
    }
}
