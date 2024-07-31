package com.navatics.app.settings;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.navatics.app.R;
import com.navatics.app.activities.StatusBarLightActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class SettingsActivity extends StatusBarLightActivity {

    /* renamed from: a */
    List<SettingEntry> f5075a = new ArrayList();

    /* renamed from: b */
    Map<SettingEntry, View> f5076b = new HashMap();

    /* renamed from: c */
    C1905a f5077c;
    @BindView
    ImageView ivBack;
    @BindView
    ListView lvList;

    public static /* synthetic */ void lambda$4DYlDMppR9gOLGnM2cCouq4A7CI(SettingsActivity settingsActivity, View view) {
        settingsActivity.m7455a(view);
    }

    @Override // com.navatics.app.activities.StatusBarLightActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        ButterKnife.m12805a(this);
        getWindow().setStatusBarColor(Color.parseColor("#F5F5F5"));
        this.f5077c = new C1905a();
        this.lvList.setAdapter((ListAdapter) this.f5077c);
        this.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.settings.-$$Lambda$SettingsActivity$4DYlDMppR9gOLGnM2cCouq4A7CI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.lambda$4DYlDMppR9gOLGnM2cCouq4A7CI(SettingsActivity.this, view);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m7455a(View view) {
        finish();
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        for (SettingEntry settingEntry : this.f5075a) {
            if (settingEntry.m7427f() != null) {
                settingEntry.mo7430b();
            }
        }
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        for (SettingEntry settingEntry : this.f5075a) {
            if (settingEntry.m7427f() != null) {
                settingEntry.mo7429c();
            }
        }
    }

    /* renamed from: a */
    public void m7454a(SettingEntry settingEntry) {
        this.f5075a.add(settingEntry);
    }

    /* renamed from: b */
    public void m7453b() {
        C1905a c1905a = this.f5077c;
        if (c1905a != null) {
            c1905a.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.settings.SettingsActivity$a */
    /* loaded from: classes.dex */
    public class C1905a extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        C1905a() {
            SettingsActivity.this = r1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return SettingsActivity.this.f5075a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return SettingsActivity.this.f5075a.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            SettingEntry settingEntry = SettingsActivity.this.f5075a.get(i);
            View view2 = SettingsActivity.this.f5076b.get(settingEntry);
            if (view2 == null) {
                View mo7411a = settingEntry.mo7411a();
                settingEntry.m7428e();
                settingEntry.mo7430b();
                SettingsActivity.this.f5076b.put(settingEntry, mo7411a);
                return mo7411a;
            }
            return view2;
        }
    }
}
