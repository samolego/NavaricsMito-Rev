package com.navatics.app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p011v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.navatics.app.R;
import com.navatics.robot.protocol.p061a.MCMOperation;
import com.navatics.robot.protocol.p061a.MCMSocket;
import com.navatics.robot.protocol.p061a.MediaEntity;
import java.util.List;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class TestDownloadActivity extends AppCompatActivity implements MCMSocket.InterfaceC2100d {

    /* renamed from: e */
    private static final C3044k f3901e = C3044k.m1564a(TestDownloadActivity.class);

    /* renamed from: a */
    ListView f3902a;

    /* renamed from: b */
    C1671a f3903b;

    /* renamed from: c */
    List<MediaEntity> f3904c;

    /* renamed from: d */
    MCMSocket f3905d;

    /* renamed from: lambda$uJTL-nrxaazyUfFLX4xriyDu6_s */
    public static /* synthetic */ void m13005lambda$uJTLnrxaazyUfFLX4xriyDu6_s(TestDownloadActivity testDownloadActivity) {
        testDownloadActivity.m9025a();
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_test_download);
        this.f3902a = (ListView) findViewById(R.id.listPhoto);
        this.f3903b = new C1671a();
        this.f3902a.setAdapter((ListAdapter) this.f3903b);
        MCMOperation mCMOperation = new MCMOperation(1);
        mCMOperation.m6555a("m", 2);
        this.f3905d = new MCMSocket(null);
        this.f3905d.m6545a(mCMOperation);
    }

    @Override // com.navatics.robot.protocol.p061a.MCMSocket.InterfaceC2100d
    /* renamed from: a */
    public void mo6538a(MCMOperation.C2095a c2095a) {
        if (c2095a.m6554a() != 1) {
            C3044k c3044k = f3901e;
            c3044k.mo1504b((Object) ("logger count is " + c2095a.m6554a()));
            return;
        }
        this.f3904c = (List) c2095a.m6553a(0);
        runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$TestDownloadActivity$uJTL-nrxaazyUfFLX4xriyDu6_s
            @Override // java.lang.Runnable
            public final void run() {
                TestDownloadActivity.m13005lambda$uJTLnrxaazyUfFLX4xriyDu6_s(TestDownloadActivity.this);
            }
        });
        C3044k c3044k2 = f3901e;
        c3044k2.mo1500c((Object) ("media count is " + this.f3904c.size()));
    }

    /* renamed from: a */
    public /* synthetic */ void m9025a() {
        this.f3903b.notifyDataSetChanged();
    }

    /* renamed from: com.navatics.app.activities.TestDownloadActivity$a */
    /* loaded from: classes.dex */
    public class C1671a extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        C1671a() {
            TestDownloadActivity.this = r1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (TestDownloadActivity.this.f3904c == null) {
                return 0;
            }
            return TestDownloadActivity.this.f3904c.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return TestDownloadActivity.this.f3904c.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C1672a c1672a;
            if (view == null) {
                View inflate = TestDownloadActivity.this.getLayoutInflater().inflate(R.layout.test_media_list_item, (ViewGroup) null);
                c1672a = new C1672a();
                c1672a.f3907a = (TextView) inflate.findViewById(R.id.mediaName);
                inflate.setTag(c1672a);
            } else {
                c1672a = (C1672a) view.getTag();
            }
            c1672a.f3907a.setText(TestDownloadActivity.this.f3904c.get(i).m6536a());
            return null;
        }

        /* renamed from: com.navatics.app.activities.TestDownloadActivity$a$a */
        /* loaded from: classes.dex */
        class C1672a {

            /* renamed from: a */
            TextView f3907a;

            C1672a() {
                C1671a.this = r1;
            }
        }
    }
}
