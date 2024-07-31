package com.navatics.app.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.view.PagerAdapter;
import android.support.p008v4.view.ViewPager;
import android.support.p011v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.navatics.app.R;
import com.navatics.app.utils.AbstractViewPagerAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class TestViewPagerActivity extends AppCompatActivity {

    /* renamed from: a */
    private static final C3044k f3919a = C3044k.m1564a(TestViewPagerActivity.class);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        m9021a();
    }

    /* renamed from: a */
    public void m9021a() {
        setContentView(R.layout.test_viewpager_activity2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1675a(0, "text0"));
        arrayList.add(new C1675a(1, "text1"));
        arrayList.add(new C1675a(2, "text2"));
        arrayList.add(new C1675a(3, "text3"));
        arrayList.add(new C1675a(4, "text4"));
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setPageMargin(-100);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(new MyPagerAdapter2(arrayList));
        viewPager.setCurrentItem(2);
    }

    /* loaded from: classes.dex */
    public class MyPagerAdapter2 extends AbstractViewPagerAdapter<C1675a> {
        MyPagerAdapter2(List<C1675a> list) {
            super(list);
        }

        @Override // com.navatics.app.utils.AbstractViewPagerAdapter
        /* renamed from: a */
        public View mo7409a(int i) {
            C3044k c3044k = TestViewPagerActivity.f3919a;
            c3044k.mo1500c((Object) ("newView " + i));
            View inflate = View.inflate(TestViewPagerActivity.this, R.layout.test_viewpager_item, null);
            ((TextView) inflate.findViewById(R.id.tvTestItem)).setText(String.format(Locale.getDefault(), "position : %d", Integer.valueOf(i)));
            return inflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.activities.TestViewPagerActivity$a */
    /* loaded from: classes.dex */
    public class C1675a {

        /* renamed from: a */
        int f3922a;

        /* renamed from: b */
        String f3923b;

        C1675a(int i, String str) {
            this.f3922a = i;
            this.f3923b = str;
        }
    }

    /* loaded from: classes.dex */
    public class AZPagerAdapter extends PagerAdapter {

        /* renamed from: a */
        protected List<View> f3920a;

        @Override // android.support.p008v4.view.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.p008v4.view.PagerAdapter
        public int getCount() {
            return this.f3920a.size();
        }

        @Override // android.support.p008v4.view.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            viewGroup.removeView(this.f3920a.get(i));
        }

        @Override // android.support.p008v4.view.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            if (this.f3920a.get(i).getParent() != null) {
                ((ViewGroup) this.f3920a.get(i).getParent()).removeView(this.f3920a.get(i));
            }
            viewGroup.addView(this.f3920a.get(i));
            return this.f3920a.get(i);
        }
    }
}
