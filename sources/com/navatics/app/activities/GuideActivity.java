package com.navatics.app.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.FragmentManager;
import android.support.p008v4.app.FragmentPagerAdapter;
import android.support.p008v4.content.ContextCompat;
import android.support.p008v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.yanzhenjie.sofia.Sofia;

/* loaded from: classes.dex */
public class GuideActivity extends NvBaseActivity {

    /* renamed from: a */
    private SectionsPagerAdapter f3567a;

    /* renamed from: b */
    private ViewPager f3568b;

    /* renamed from: c */
    private TextView f3569c;

    /* renamed from: d */
    private ImageView[] f3570d;

    /* renamed from: e */
    private int[] f3571e;

    public static /* synthetic */ void lambda$RrZwAEJ2L9AexjVmNzinTrNPO_Y(GuideActivity guideActivity, View view) {
        guideActivity.m9410a(view);
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_guide);
        Sofia.m3725a(this).mo3731a().mo3730a(Color.parseColor("#0E1A23"));
        m9412a();
        this.f3569c = (TextView) findViewById(R.id.tvSignIn);
        this.f3570d = new ImageView[]{(ImageView) findViewById(R.id.imageViewIndicator0), (ImageView) findViewById(R.id.imageViewIndicator1), (ImageView) findViewById(R.id.imageViewIndicator2)};
        this.f3567a = new SectionsPagerAdapter(getSupportFragmentManager());
        this.f3568b = (ViewPager) findViewById(R.id.container);
        this.f3568b.setAdapter(this.f3567a);
        this.f3568b.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.navatics.app.activities.GuideActivity.1
            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            {
                GuideActivity.this = this;
            }

            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                GuideActivity.this.m9411a(i);
            }
        });
        this.f3569c.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$GuideActivity$RrZwAEJ2L9AexjVmNzinTrNPO_Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuideActivity.lambda$RrZwAEJ2L9AexjVmNzinTrNPO_Y(GuideActivity.this, view);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m9410a(View view) {
        startActivity(new Intent(this, LoginActivity.class));
        overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out2);
        finish();
    }

    /* renamed from: a */
    private void m9412a() {
        this.f3571e = new int[]{ContextCompat.getColor(this, R.color.colorPrimary), ContextCompat.getColor(this, R.color.cyan_500), ContextCompat.getColor(this, R.color.light_blue_500)};
    }

    /* renamed from: a */
    public void m9411a(int i) {
        int i2 = 0;
        while (true) {
            ImageView[] imageViewArr = this.f3570d;
            if (i2 >= imageViewArr.length) {
                return;
            }
            imageViewArr[i2].setBackgroundResource(i2 == i ? R.drawable.onboarding_indicator_selected : R.drawable.onboarding_indicator_unselected);
            i2++;
        }
    }

    /* loaded from: classes.dex */
    public static class PlaceholderFragment extends Fragment {
        /* renamed from: a */
        public static PlaceholderFragment m9408a(int i) {
            PlaceholderFragment placeholderFragment = new PlaceholderFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("section_number", i);
            placeholderFragment.setArguments(bundle);
            return placeholderFragment;
        }

        @Override // android.support.p008v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(R.layout.fragment_guide, viewGroup, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.ivTopImage);
            TextView textView = (TextView) inflate.findViewById(R.id.tvTitle);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tvDetail);
            switch (getArguments().getInt("section_number")) {
                case 1:
                    imageView.setImageResource(R.drawable.guide1);
                    textView.setText(getString(R.string.guide1_title_text));
                    textView2.setText(getString(R.string.guide1_detail_text));
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.guide2);
                    textView.setText(getString(R.string.guide2_title_text));
                    textView2.setText(getString(R.string.guide2_detail_text));
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.guide3);
                    textView.setText(getString(R.string.guide3_title_text));
                    textView2.setText(getString(R.string.guide3_detail_text));
                    break;
            }
            return inflate;
        }
    }

    /* loaded from: classes.dex */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        @Override // android.support.p008v4.view.PagerAdapter
        public int getCount() {
            return 3;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SectionsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            GuideActivity.this = r1;
        }

        @Override // android.support.p008v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return PlaceholderFragment.m9408a(i + 1);
        }
    }
}
