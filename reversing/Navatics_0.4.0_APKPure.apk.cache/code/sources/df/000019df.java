package com.navatics.app.utils;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AbstractViewPagerAdapter<T> extends PagerAdapter {

    /* renamed from: a */
    private SparseArray<View> f5139a;

    /* renamed from: b */
    protected List<T> f5140b;

    /* renamed from: a */
    public abstract View mo3936a(int i);

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public AbstractViewPagerAdapter(List<T> list) {
        this.f5140b = list;
        this.f5139a = new SparseArray<>(list.size());
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.f5140b.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        View view = this.f5139a.get(i);
        if (view == null) {
            view = mo3936a(i);
            this.f5139a.put(i, view);
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        viewGroup.addView(view);
        return view;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.f5139a.get(i));
    }
}