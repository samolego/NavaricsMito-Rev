package com.navatics.app.activities;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.p008v4.app.FragmentActivity;
import android.support.p008v4.app.LoaderManager;
import android.support.p008v4.content.CursorLoader;
import android.support.p008v4.content.Loader;
import android.support.p008v4.view.PagerAdapter;
import android.support.p008v4.view.ViewCompat;
import android.support.p008v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.navatics.app.framework.provider.PhotosProvider;
import com.navatics.app.model.Photo;
import com.navatics.app.model.PhotoContainer;
import com.navatics.app.widget.PinchImageView;
import com.navatics.nvtsshare.NvtsShare;
import java.io.File;
import java.util.LinkedList;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class PhotoViewer extends NvBaseActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    /* renamed from: a */
    private static final C3044k f3698a = C3044k.m1564a(PhotoViewer.class);

    /* renamed from: b */
    private int f3699b;

    /* renamed from: c */
    private PhotoContainer f3700c;

    /* renamed from: d */
    private ImageView f3701d;

    /* renamed from: e */
    private ViewGroup f3702e;

    /* renamed from: f */
    private ViewPager f3703f;

    /* renamed from: g */
    private PagerAdapter f3704g;

    /* renamed from: h */
    private ViewGroup f3705h;

    /* renamed from: i */
    private ImageView f3706i;

    /* renamed from: j */
    private ImageView f3707j;

    /* renamed from: k */
    private ImageView f3708k;

    /* renamed from: l */
    private ImageView f3709l;

    /* renamed from: m */
    private AnimatorSet f3710m;

    /* renamed from: n */
    private ViewMode f3711n = ViewMode.NORMAL;

    /* renamed from: o */
    private RequestOptions f3712o = new RequestOptions().mo9521g();

    /* loaded from: classes.dex */
    public enum ViewMode {
        NORMAL,
        CINEMA
    }

    public static /* synthetic */ void lambda$Eo5YdIhSoF65x6KyUTH6ACzUs2A(PhotoViewer photoViewer, String str, BottomSheetDialog bottomSheetDialog, View view) {
        photoViewer.m9289d(str, bottomSheetDialog, view);
    }

    public static /* synthetic */ void lambda$HXY3ePQntZAD05d1RpDChazLdPg(PhotoViewer photoViewer, String str, BottomSheetDialog bottomSheetDialog, View view) {
        photoViewer.m9299a(str, bottomSheetDialog, view);
    }

    public static /* synthetic */ void lambda$O9vRnCGS00jyF2AKeAJZeikt9LE(BottomSheetDialog bottomSheetDialog, View view) {
        bottomSheetDialog.dismiss();
    }

    /* renamed from: lambda$vptqUuAfBOcVy82R-DuGeUAfaRY */
    public static /* synthetic */ void m12980lambda$vptqUuAfBOcVy82RDuGeUAfaRY(PhotoViewer photoViewer, String str, BottomSheetDialog bottomSheetDialog, View view) {
        photoViewer.m9292c(str, bottomSheetDialog, view);
    }

    public static /* synthetic */ void lambda$zyM7fR9gdTpnUcSN78M9UQFEBi4(PhotoViewer photoViewer, String str, BottomSheetDialog bottomSheetDialog, View view) {
        photoViewer.m9295b(str, bottomSheetDialog, view);
    }

    /* renamed from: a */
    private boolean m9306a(Bundle bundle) {
        int i;
        if (bundle != null && (i = bundle.getInt("key_path_of_photo", -1)) >= 0) {
            this.f3699b = i;
            return true;
        }
        return false;
    }

    @Override // android.support.p008v4.app.LoaderManager.LoaderCallbacks
    @NonNull
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, PhotosProvider.f4766a, null, null, null, null);
    }

    @Override // android.support.p008v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a */
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        this.f3700c = PhotoContainer.from(cursor);
        this.f3704g.notifyDataSetChanged();
        this.f3703f.setCurrentItem(this.f3699b, false);
    }

    @Override // android.support.p008v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        this.f3700c = PhotoContainer.emptyList();
        this.f3704g.notifyDataSetChanged();
        this.f3703f.setCurrentItem(this.f3699b, false);
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    @SuppressLint({"CheckResult"})
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        if (!m9306a(getIntent().getExtras())) {
            finish();
            return;
        }
        setContentView(R.layout.photo_viewer_activity);
        m9297b();
        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f3698a.mo1500c((Object) "onDestroy");
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        f3698a.mo1500c((Object) "onStart");
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        f3698a.mo1500c((Object) "onStop");
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.photo_viewer_activity);
        m9297b();
        if (this.f3711n == ViewMode.CINEMA) {
            this.f3702e.setBackgroundColor(getResources().getColor(R.color.black));
            this.f3705h.setAlpha(0.0f);
            m9298a(false);
            return;
        }
        this.f3702e.setBackgroundColor(getResources().getColor(R.color.lightGray));
        this.f3705h.setAlpha(1.0f);
        m9298a(true);
    }

    /* renamed from: a */
    private void m9298a(boolean z) {
        this.f3706i.setClickable(z);
        this.f3707j.setClickable(z);
        this.f3708k.setClickable(z);
        this.f3709l.setClickable(z);
    }

    /* renamed from: b */
    private void m9297b() {
        this.f3701d = (ImageView) findViewById(R.id.ivImageContent);
        this.f3702e = (ViewGroup) findViewById(R.id.photoViewBackground);
        this.f3705h = (ViewGroup) findViewById(R.id.photoViewerNavigationBar);
        this.f3701d.setOnClickListener(new View$OnClickListenerC1624a());
        this.f3703f = (ViewPager) findViewById(R.id.viewPager);
        this.f3704g = new C1625b();
        this.f3703f.setAdapter(this.f3704g);
        this.f3703f.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.navatics.app.activities.PhotoViewer.1
            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            {
                PhotoViewer.this = this;
            }

            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                PhotoViewer.this.f3699b = i;
            }
        });
        ViewCompat.setElevation(this.f3705h, 2.0f);
        this.f3706i = (ImageView) findViewById(R.id.ivBack);
        this.f3706i.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PhotoViewer.2
            {
                PhotoViewer.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoViewer.this.m9294c();
            }
        });
        this.f3707j = (ImageView) findViewById(R.id.ivDelete);
        this.f3707j.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PhotoViewer.3
            {
                PhotoViewer.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PhotoViewer.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle(R.string.ensure_delete_dlg_title);
                builder.setMessage(R.string.ensure_delete_dlg_content);
                builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.navatics.app.activities.PhotoViewer.3.1
                    {
                        View$OnClickListenerC16183.this = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (new File(PhotoViewer.this.f3700c.get(PhotoViewer.this.f3699b).getUri()).delete()) {
                            Toast.makeText(PhotoViewer.this, (int) R.string.delete_success_msg, 0).show();
                            PhotoViewer.this.finish();
                            return;
                        }
                        Toast.makeText(PhotoViewer.this, (int) R.string.delete_fail_msg, 0).show();
                    }
                });
                builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() { // from class: com.navatics.app.activities.PhotoViewer.3.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }

                    {
                        View$OnClickListenerC16183.this = this;
                    }
                });
                builder.setCancelable(true);
                builder.create().show();
            }
        });
        this.f3708k = (ImageView) findViewById(R.id.ivEdit);
        this.f3708k.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PhotoViewer.4
            {
                PhotoViewer.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoViewer.f3698a.mo1511a((Object) "ivEdit_Nav onClick");
                String uri = PhotoViewer.this.f3700c.get(PhotoViewer.this.f3699b).getUri();
                Intent intent = new Intent(PhotoViewer.this, PhotoEditor.class);
                Bundle bundle = new Bundle();
                bundle.putString("key_path_of_photo", uri);
                intent.putExtras(bundle);
                PhotoViewer.this.startActivity(intent);
                PhotoViewer.this.overridePendingTransition(0, 0);
            }
        });
        this.f3709l = (ImageView) findViewById(R.id.ivShare);
        this.f3709l.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.PhotoViewer.5
            {
                PhotoViewer.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoViewer photoViewer = PhotoViewer.this;
                photoViewer.m9300a(photoViewer.f3700c.get(PhotoViewer.this.f3699b).getUri());
            }
        });
    }

    /* renamed from: a */
    public void m9300a(final String str) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View inflate = getLayoutInflater().inflate(R.layout.share_panel_layout, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.ivFacebook)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PhotoViewer$Eo5YdIhSoF65x6KyUTH6ACzUs2A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoViewer.lambda$Eo5YdIhSoF65x6KyUTH6ACzUs2A(PhotoViewer.this, str, bottomSheetDialog, view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.ivTwitter)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PhotoViewer$vptqUuAfBOcVy82R-DuGeUAfaRY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoViewer.m12980lambda$vptqUuAfBOcVy82RDuGeUAfaRY(PhotoViewer.this, str, bottomSheetDialog, view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.tvInstagram)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PhotoViewer$zyM7fR9gdTpnUcSN78M9UQFEBi4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoViewer.lambda$zyM7fR9gdTpnUcSN78M9UQFEBi4(PhotoViewer.this, str, bottomSheetDialog, view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.ivWeChat)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PhotoViewer$HXY3ePQntZAD05d1RpDChazLdPg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoViewer.lambda$HXY3ePQntZAD05d1RpDChazLdPg(PhotoViewer.this, str, bottomSheetDialog, view);
            }
        });
        ((ImageButton) inflate.findViewById(R.id.btnCancel)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$PhotoViewer$O9vRnCGS00jyF2AKeAJZeikt9LE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoViewer.lambda$O9vRnCGS00jyF2AKeAJZeikt9LE(BottomSheetDialog.this, view);
            }
        });
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.show();
    }

    /* renamed from: d */
    public /* synthetic */ void m9289d(String str, BottomSheetDialog bottomSheetDialog, View view) {
        NvtsShare.m6614a(this).m6589d().m6596a(str).m6602a(this).mo6594a();
        bottomSheetDialog.dismiss();
    }

    /* renamed from: c */
    public /* synthetic */ void m9292c(String str, BottomSheetDialog bottomSheetDialog, View view) {
        NvtsShare.m6614a(this).m6591b().m6597a(str).mo6594a();
        bottomSheetDialog.dismiss();
    }

    /* renamed from: b */
    public /* synthetic */ void m9295b(String str, BottomSheetDialog bottomSheetDialog, View view) {
        NvtsShare.m6614a(this).m6590c().m6596a(str).mo6594a();
        bottomSheetDialog.dismiss();
    }

    /* renamed from: a */
    public /* synthetic */ void m9299a(String str, BottomSheetDialog bottomSheetDialog, View view) {
        NvtsShare.m6614a(this).m6592a().m6597a(str).mo6594a();
        bottomSheetDialog.dismiss();
    }

    /* renamed from: c */
    public void m9294c() {
        finish();
    }

    /* renamed from: d */
    public void m9291d() {
        AnimatorSet animatorSet = this.f3710m;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f3710m.cancel();
        }
        switch (this.f3711n) {
            case NORMAL:
                int color = getResources().getColor(R.color.black);
                this.f3710m = new AnimatorSet();
                ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f3702e, "backgroundColor", color);
                ofInt.setEvaluator(new ArgbEvaluator());
                this.f3710m.play(ofInt).with(ObjectAnimator.ofFloat(this.f3705h, "alpha", 0.0f));
                this.f3710m.setDuration(500L);
                this.f3710m.start();
                m9298a(false);
                this.f3711n = ViewMode.CINEMA;
                return;
            case CINEMA:
                int i = ViewCompat.MEASURED_STATE_MASK;
                Drawable background = this.f3702e.getBackground();
                if (background instanceof ColorDrawable) {
                    i = ((ColorDrawable) background).getColor();
                }
                int color2 = getResources().getColor(R.color.lightGray);
                this.f3710m = new AnimatorSet();
                ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this.f3702e, "backgroundColor", i, color2);
                ofInt2.setEvaluator(new ArgbEvaluator());
                this.f3710m.play(ofInt2).with(ObjectAnimator.ofFloat(this.f3705h, "alpha", 1.0f));
                this.f3710m.setDuration(500L);
                this.f3710m.start();
                m9298a(true);
                this.f3711n = ViewMode.NORMAL;
                return;
            default:
                C3044k c3044k = f3698a;
                c3044k.mo1504b((Object) ("unknown ViewMode : " + this.f3711n));
                return;
        }
    }

    /* renamed from: com.navatics.app.activities.PhotoViewer$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC1624a implements View.OnClickListener {
        View$OnClickListenerC1624a() {
            PhotoViewer.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoViewer.this.m9291d();
        }
    }

    /* renamed from: com.navatics.app.activities.PhotoViewer$b */
    /* loaded from: classes.dex */
    public class C1625b extends PagerAdapter {

        /* renamed from: b */
        private LinkedList<View> f3724b = new LinkedList<>();

        @Override // android.support.p008v4.view.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }

        C1625b() {
            PhotoViewer.this = r1;
        }

        @Override // android.support.p008v4.view.PagerAdapter
        public int getCount() {
            if (PhotoViewer.this.f3700c == null) {
                return 0;
            }
            return PhotoViewer.this.f3700c.size();
        }

        @Override // android.support.p008v4.view.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            View removeFirst;
            C1626a c1626a;
            if (this.f3724b.size() == 0) {
                removeFirst = LayoutInflater.from(PhotoViewer.this).inflate(R.layout.photo_viewer_pagerview_item, (ViewGroup) null, false);
                c1626a = new C1626a();
                c1626a.f3725a = (PinchImageView) removeFirst.findViewById(R.id.page_image);
                removeFirst.setTag(c1626a);
            } else {
                removeFirst = this.f3724b.removeFirst();
                c1626a = (C1626a) removeFirst.getTag();
            }
            Photo photo = PhotoViewer.this.f3700c.get(i);
            c1626a.f3725a.setOnClickListener(new View$OnClickListenerC1624a());
            Glide.m12521a((FragmentActivity) PhotoViewer.this).mo8814a(photo.getUri()).mo8828a(PhotoViewer.this.f3712o).m12449a((ImageView) c1626a.f3725a);
            viewGroup.addView(removeFirst, -1, -1);
            return removeFirst;
        }

        @Override // android.support.p008v4.view.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            Log.e("test", "destroyItem " + i);
            View view = (View) obj;
            viewGroup.removeView(view);
            this.f3724b.add(view);
        }

        /* renamed from: com.navatics.app.activities.PhotoViewer$b$a */
        /* loaded from: classes.dex */
        class C1626a {

            /* renamed from: a */
            PinchImageView f3725a;

            C1626a() {
                C1625b.this = r1;
            }
        }
    }
}
