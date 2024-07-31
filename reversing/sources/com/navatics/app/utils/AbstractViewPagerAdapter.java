package com.navatics.app.utils;

import android.support.annotation.NonNull;
import android.support.p008v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AbstractViewPagerAdapter<T> extends PagerAdapter {

    /* renamed from: a */
    private SparseArray<View> f5117a;

    /* renamed from: b */
    protected List<T> f5118b;

    /* renamed from: a */
    public abstract View mo7409a(int i);

    @Override // android.support.p008v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public AbstractViewPagerAdapter(List<T> list) {
        this.f5118b = list;
        this.f5117a = new SparseArray<>(list.size());
    }

    @Override // android.support.p008v4.view.PagerAdapter
    public int getCount() {
        return this.f5118b.size();
    }

    @Override // android.support.p008v4.view.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        View view = this.f5117a.get(i);
        if (view == null) {
            view = mo7409a(i);
            this.f5117a.put(i, view);
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        viewGroup.addView(view);
        return view;
    }

    @Override // android.support.p008v4.view.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.f5117a.get(i));
    }
}
