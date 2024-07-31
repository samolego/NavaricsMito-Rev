package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.os.Bundle;
import android.support.p008v4.view.ViewPager;
import com.github.mikephil.charting.utils.Utils;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class GalleryActivity extends Activity {

    /* renamed from: a */
    GalleryItem f8893a;

    /* renamed from: b */
    final GalleryScribeClient f8894b = new GalleryScribeClientImpl(TweetUi.m4100a());

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tw__gallery_activity);
        this.f8893a = m4154c();
        if (bundle == null) {
            m4153d();
        }
        GalleryAdapter galleryAdapter = new GalleryAdapter(this, m4155b());
        galleryAdapter.m4069a(this.f8893a.mediaEntities);
        ViewPager viewPager = (ViewPager) findViewById(R.id.tw__view_pager);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.tw__gallery_page_margin));
        viewPager.addOnPageChangeListener(m4157a());
        viewPager.setAdapter(galleryAdapter);
        viewPager.setCurrentItem(this.f8893a.mediaEntityIndex);
    }

    /* renamed from: a */
    ViewPager.OnPageChangeListener m4157a() {
        return new ViewPager.OnPageChangeListener() { // from class: com.twitter.sdk.android.tweetui.GalleryActivity.1

            /* renamed from: a */
            int f8895a = -1;

            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (this.f8895a == -1 && i == 0 && f == Utils.DOUBLE_EPSILON) {
                    GalleryActivity.this.m4156a(i);
                    this.f8895a++;
                }
            }

            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (this.f8895a >= 0) {
                    GalleryActivity.this.m4151f();
                }
                this.f8895a++;
                GalleryActivity.this.m4156a(i);
            }
        };
    }

    /* renamed from: b */
    SwipeToDismissTouchListener.InterfaceC2759a m4155b() {
        return new SwipeToDismissTouchListener.InterfaceC2759a() { // from class: com.twitter.sdk.android.tweetui.GalleryActivity.2
            @Override // com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.InterfaceC2759a
            /* renamed from: a */
            public void mo3931a(float f) {
            }

            @Override // com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.InterfaceC2759a
            /* renamed from: a */
            public void mo3932a() {
                GalleryActivity.this.m4152e();
                GalleryActivity.this.finish();
                GalleryActivity.this.overridePendingTransition(0, R.anim.tw__slide_out);
            }
        };
    }

    /* renamed from: c */
    GalleryItem m4154c() {
        MediaEntity mediaEntity = (MediaEntity) getIntent().getSerializableExtra("MEDIA_ENTITY");
        if (mediaEntity != null) {
            return new GalleryItem(0, Collections.singletonList(mediaEntity));
        }
        return (GalleryItem) getIntent().getSerializableExtra("GALLERY_ITEM");
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m4152e();
        super.onBackPressed();
        overridePendingTransition(0, R.anim.tw__slide_out);
    }

    /* renamed from: d */
    void m4153d() {
        this.f8894b.mo4068a();
    }

    /* renamed from: e */
    void m4152e() {
        this.f8894b.mo4065c();
    }

    /* renamed from: a */
    void m4156a(int i) {
        this.f8894b.mo4067a(ScribeItem.fromMediaEntity(this.f8893a.tweetId, this.f8893a.mediaEntities.get(i)));
    }

    /* renamed from: f */
    void m4151f() {
        this.f8894b.mo4066b();
    }

    /* loaded from: classes2.dex */
    public static class GalleryItem implements Serializable {
        public final List<MediaEntity> mediaEntities;
        public final int mediaEntityIndex;
        public final long tweetId;

        public GalleryItem(int i, List<MediaEntity> list) {
            this(0L, i, list);
        }

        public GalleryItem(long j, int i, List<MediaEntity> list) {
            this.tweetId = j;
            this.mediaEntityIndex = i;
            this.mediaEntities = list;
        }
    }
}
