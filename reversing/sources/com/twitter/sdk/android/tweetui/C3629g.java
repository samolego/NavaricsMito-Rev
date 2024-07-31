package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.support.p008v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.tweetui.internal.GalleryImageView;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.twitter.sdk.android.tweetui.g */
/* loaded from: classes2.dex */
class GalleryAdapter extends PagerAdapter {

    /* renamed from: a */
    final List<MediaEntity> f8966a = new ArrayList();

    /* renamed from: b */
    final Context f8967b;

    /* renamed from: c */
    final SwipeToDismissTouchListener.InterfaceC2759a f8968c;

    @Override // android.support.p008v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GalleryAdapter(Context context, SwipeToDismissTouchListener.InterfaceC2759a interfaceC2759a) {
        this.f8967b = context;
        this.f8968c = interfaceC2759a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4069a(List<MediaEntity> list) {
        this.f8966a.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.support.p008v4.view.PagerAdapter
    public int getCount() {
        return this.f8966a.size();
    }

    @Override // android.support.p008v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        GalleryImageView galleryImageView = new GalleryImageView(this.f8967b);
        galleryImageView.setSwipeToDismissCallback(this.f8968c);
        viewGroup.addView(galleryImageView);
        Picasso.m5798a(this.f8967b).m5787a(this.f8966a.get(i).mediaUrlHttps).m5651a(galleryImageView);
        return galleryImageView;
    }

    @Override // android.support.p008v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
