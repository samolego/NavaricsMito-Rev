package com.navatics.app.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p008v4.view.ViewCompat;
import android.support.p008v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.navatics.app.MyViewPager;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.navatics.app.TabFragmentPagerAdapter;
import com.navatics.app.fragments.IMultiSelectPage;
import com.navatics.app.fragments.IMultiSelectPageContainer;
import java.util.List;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class MediaLibraryActivity extends NvBaseActivity implements IMultiSelectPageContainer {

    /* renamed from: a */
    private static final C3044k f3635a = C3044k.m1564a(MediaLibraryActivity.class);

    /* renamed from: b */
    private IMultiSelectPage f3636b;

    /* renamed from: c */
    private IMultiSelectPage.Mode f3637c;

    /* renamed from: d */
    private List<IMultiSelectPage> f3638d;

    /* renamed from: e */
    private ViewGroup f3639e;

    /* renamed from: f */
    private View f3640f;

    /* renamed from: g */
    private View f3641g;

    /* renamed from: h */
    private ImageView f3642h;

    /* renamed from: i */
    private ImageView f3643i;

    /* renamed from: j */
    private TextView f3644j;

    /* renamed from: k */
    private TextView f3645k;

    /* renamed from: l */
    private TextView f3646l;

    /* renamed from: m */
    private TextView f3647m;

    /* renamed from: n */
    private ImageView f3648n;

    /* renamed from: o */
    private ImageView f3649o;

    public static /* synthetic */ void lambda$Wcmizg7BTtCKAahrBf_aU2GmLiw(MediaLibraryActivity mediaLibraryActivity, View view) {
        mediaLibraryActivity.m9373a(view);
    }

    public static /* synthetic */ void lambda$YtGZbY2t6ImNgNsLFrsFhdWxo5o(MediaLibraryActivity mediaLibraryActivity, MyViewPager myViewPager, View view) {
        mediaLibraryActivity.m9372a(myViewPager, view);
    }

    public static /* synthetic */ void lambda$qZIMZN25_xOnG8xFwY7m6t3Dxac(MediaLibraryActivity mediaLibraryActivity, MyViewPager myViewPager, View view) {
        mediaLibraryActivity.m9367b(myViewPager, view);
    }

    public static /* synthetic */ void lambda$w8Zg9fbn4JcFmWJrS7BFWc8x7v0(MediaLibraryActivity mediaLibraryActivity, View view) {
        mediaLibraryActivity.m9368b(view);
    }

    /* renamed from: lambda$x8qp4-PA_nibt80u6SKmG0rlQyY */
    public static /* synthetic */ void m12978lambda$x8qp4PA_nibt80u6SKmG0rlQyY(MediaLibraryActivity mediaLibraryActivity, View view) {
        mediaLibraryActivity.m9365c(view);
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.medialibrary_fragment);
        this.f3644j = (TextView) findViewById(R.id.tvPhotoTab);
        this.f3645k = (TextView) findViewById(R.id.tvVideoTab);
        this.f3646l = (TextView) findViewById(R.id.tvChoose);
        this.f3647m = (TextView) findViewById(R.id.tvSelected);
        this.f3648n = (ImageView) findViewById(R.id.ivBottomRobotIcon);
        this.f3648n.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$MediaLibraryActivity$x8qp4-PA_nibt80u6SKmG0rlQyY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaLibraryActivity.m12978lambda$x8qp4PA_nibt80u6SKmG0rlQyY(MediaLibraryActivity.this, view);
            }
        });
        this.f3649o = (ImageView) findViewById(R.id.ivDiveLogIcon);
        this.f3649o.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$MediaLibraryActivity$w8Zg9fbn4JcFmWJrS7BFWc8x7v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaLibraryActivity.lambda$w8Zg9fbn4JcFmWJrS7BFWc8x7v0(MediaLibraryActivity.this, view);
            }
        });
        this.f3641g = findViewById(R.id.multiSelectionBar);
        this.f3640f = findViewById(R.id.bottomContainer);
        final MyViewPager myViewPager = (MyViewPager) findViewById(R.id.tab_viewpager);
        TabFragmentPagerAdapter tabFragmentPagerAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager());
        tabFragmentPagerAdapter.m9561a(this);
        this.f3638d = tabFragmentPagerAdapter.m9562a();
        this.f3636b = this.f3638d.get(0);
        this.f3636b.mo8735a(true);
        this.f3637c = IMultiSelectPage.Mode.CommonMode;
        this.f3644j.setTypeface(Typeface.DEFAULT_BOLD);
        myViewPager.setEnableSwipe(false);
        myViewPager.setAdapter(tabFragmentPagerAdapter);
        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.navatics.app.activities.MediaLibraryActivity.1
            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            {
                MediaLibraryActivity.this = this;
            }

            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                C3044k c3044k = MediaLibraryActivity.f3635a;
                c3044k.mo1500c((Object) ("onPageSelected " + i));
                if (MediaLibraryActivity.this.f3636b != null) {
                    MediaLibraryActivity.this.f3636b.mo8735a(false);
                }
                MediaLibraryActivity mediaLibraryActivity = MediaLibraryActivity.this;
                mediaLibraryActivity.f3636b = (IMultiSelectPage) mediaLibraryActivity.f3638d.get(i);
                if (i == 1) {
                    MediaLibraryActivity.this.f3643i.setVisibility(8);
                } else if (i == 0) {
                    MediaLibraryActivity.this.f3643i.setVisibility(0);
                }
                MediaLibraryActivity.this.f3636b.mo8735a(true);
            }
        });
        this.f3644j.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$MediaLibraryActivity$qZIMZN25_xOnG8xFwY7m6t3Dxac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaLibraryActivity.lambda$qZIMZN25_xOnG8xFwY7m6t3Dxac(MediaLibraryActivity.this, myViewPager, view);
            }
        });
        this.f3645k.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$MediaLibraryActivity$YtGZbY2t6ImNgNsLFrsFhdWxo5o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaLibraryActivity.lambda$YtGZbY2t6ImNgNsLFrsFhdWxo5o(MediaLibraryActivity.this, myViewPager, view);
            }
        });
        this.f3646l.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$MediaLibraryActivity$Wcmizg7BTtCKAahrBf_aU2GmLiw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaLibraryActivity.lambda$Wcmizg7BTtCKAahrBf_aU2GmLiw(MediaLibraryActivity.this, view);
            }
        });
        this.f3639e = (ViewGroup) findViewById(R.id.tab_container);
        ViewCompat.setElevation(this.f3639e, 2.0f);
        ViewCompat.setElevation(this.f3640f, 2.0f);
        this.f3642h = (ImageView) this.f3641g.findViewById(R.id.ivDelete);
        this.f3642h.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.MediaLibraryActivity.2
            {
                MediaLibraryActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaLibraryActivity.this.f3636b != null) {
                    MediaLibraryActivity.this.f3636b.mo8739a();
                }
            }
        });
        this.f3643i = (ImageView) this.f3641g.findViewById(R.id.ivShare);
        this.f3643i.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.MediaLibraryActivity.3
            {
                MediaLibraryActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaLibraryActivity.this.f3636b != null) {
                    MediaLibraryActivity.this.f3636b.mo8734b();
                }
            }
        });
    }

    /* renamed from: c */
    public /* synthetic */ void m9365c(View view) {
        finish();
        overridePendingTransition(0, 0);
    }

    /* renamed from: b */
    public /* synthetic */ void m9368b(View view) {
        startActivity(new Intent(this, DiveLogHomeActivity.class));
        finish();
        overridePendingTransition(0, 0);
    }

    /* renamed from: b */
    public /* synthetic */ void m9367b(MyViewPager myViewPager, View view) {
        if (this.f3637c != IMultiSelectPage.Mode.CommonMode) {
            Toast.makeText(this, getString(R.string.cancel_multiple_selection), 0).show();
            return;
        }
        this.f3644j.setTypeface(Typeface.DEFAULT_BOLD);
        this.f3645k.setTypeface(Typeface.DEFAULT);
        myViewPager.setCurrentItem(0);
    }

    /* renamed from: a */
    public /* synthetic */ void m9372a(MyViewPager myViewPager, View view) {
        if (this.f3637c != IMultiSelectPage.Mode.CommonMode) {
            Toast.makeText(this, getString(R.string.cancel_multiple_selection), 0).show();
            return;
        }
        this.f3645k.setTypeface(Typeface.DEFAULT_BOLD);
        this.f3644j.setTypeface(Typeface.DEFAULT);
        myViewPager.setCurrentItem(1);
    }

    /* renamed from: a */
    public /* synthetic */ void m9373a(View view) {
        m9369b();
        IMultiSelectPage iMultiSelectPage = this.f3636b;
        if (iMultiSelectPage != null) {
            iMultiSelectPage.mo8738a(this.f3637c);
        }
    }

    @Override // com.navatics.app.NvBaseActivity
    protected NvBaseActivity.C1517a onCreateConfig() {
        return new NvBaseActivity.C1517a.C1518a().m9565a(true).m9564b();
    }

    @Override // com.navatics.app.fragments.IMultiSelectPageContainer
    /* renamed from: a */
    public void mo8703a(int i) {
        TextView textView = this.f3647m;
        textView.setText(i + " selected");
        if (i == 0) {
            this.f3642h.setImageResource(R.drawable.delete_gray);
            this.f3642h.setClickable(false);
            this.f3643i.setImageResource(R.drawable.share_gray);
            this.f3643i.setClickable(false);
        } else if (i == 1) {
            this.f3642h.setClickable(true);
            this.f3643i.setClickable(true);
            this.f3642h.setImageResource(R.drawable.delete);
            this.f3643i.setImageResource(R.drawable.share);
        } else if (i == 2) {
            this.f3643i.setImageResource(R.drawable.share_gray);
            this.f3643i.setClickable(false);
        }
    }

    /* renamed from: b */
    private void m9369b() {
        switch (this.f3637c) {
            case CommonMode:
                this.f3637c = IMultiSelectPage.Mode.MultiSelectMode;
                this.f3647m.setVisibility(0);
                this.f3640f.setVisibility(4);
                this.f3640f.setEnabled(false);
                this.f3641g.setVisibility(0);
                this.f3641g.setEnabled(true);
                this.f3642h.setImageResource(R.drawable.delete_gray);
                this.f3642h.setClickable(false);
                this.f3643i.setImageResource(R.drawable.share_gray);
                this.f3643i.setClickable(false);
                this.f3646l.setText(getString(R.string.cancel));
                return;
            case MultiSelectMode:
                this.f3637c = IMultiSelectPage.Mode.CommonMode;
                this.f3647m.setVisibility(4);
                this.f3640f.setVisibility(0);
                this.f3640f.setEnabled(true);
                this.f3641g.setVisibility(4);
                this.f3641g.setEnabled(false);
                this.f3646l.setText(getString(R.string.choose));
                return;
            default:
                return;
        }
    }
}
