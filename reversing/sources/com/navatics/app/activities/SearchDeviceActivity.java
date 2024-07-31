package com.navatics.app.activities;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.design.widget.Snackbar;
import android.support.p008v4.internal.view.SupportMenu;
import android.support.p008v4.view.InputDeviceCompat;
import android.support.p011v7.widget.LinearLayoutManager;
import android.support.p011v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.navatics.app.R;
import com.navatics.app.activities.SearchDeviceActivity;
import com.navatics.app.framework.AbstractConnectionHandler;
import com.navatics.app.framework.AbstractGndStaDeviceItemUpdateHandler;
import com.navatics.app.framework.AbstractGroundStationHandler;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvDeviceEntry;
import com.navatics.app.framework.NvDisposableHandler;
import com.navatics.app.framework.NvRootHandler;
import com.navatics.app.utils.IntentUtils;
import com.navatics.app.utils.RecyclerItemClickListener;
import com.navatics.app.widget.avloading.AVLoadingIndicatorView;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvError;
import com.navatics.robot.transport.NvEventLoop;
import com.navatics.robot.utils.p065a.LoggerUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class SearchDeviceActivity extends StatusBarLightActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: b */
    private static final C3044k f3868b = C3044k.m1564a(SearchDeviceActivity.class);

    /* renamed from: a */
    ObjectAnimator f3869a;
    @BindView
    AVLoadingIndicatorView avloadingAnimView;
    @BindView
    Button btnConnect;

    /* renamed from: c */
    private MyAdapter f3870c;

    /* renamed from: d */
    private LinearLayoutManager f3871d;

    /* renamed from: g */
    private C1664b f3874g;

    /* renamed from: i */
    private C1663a f3876i;
    @BindView
    ImageView ivBack;
    @BindView
    ImageView ivConnectingRotatingIcon;

    /* renamed from: j */
    private boolean f3877j;

    /* renamed from: k */
    private String f3878k;

    /* renamed from: l */
    private Snackbar f3879l;
    @BindView
    ViewGroup rootLayout;
    @BindView
    RecyclerView rvDeviceList;
    @BindView
    TextView tvNoResult;

    /* renamed from: e */
    private List<NvDeviceEntry> f3872e = new ArrayList();

    /* renamed from: f */
    private C1667e f3873f = new C1667e();

    /* renamed from: h */
    private C1665c f3875h = new C1665c();

    /* renamed from: m */
    private Handler f3880m = new HandlerC1666d(this);

    public static /* synthetic */ void lambda$KavAG8N67d54FE8i3u3SWxkdrqk(SearchDeviceActivity searchDeviceActivity, View view) {
        searchDeviceActivity.m9050c(view);
    }

    public static /* synthetic */ void lambda$Ug5Zxg_4nVuYjaaC0FV0SLOY29U(SearchDeviceActivity searchDeviceActivity, View view) {
        searchDeviceActivity.m9067a(view);
    }

    /* renamed from: lambda$wJZH-iKPV7OFfHIgeEWZhiBNnjs */
    public static /* synthetic */ void m13000lambda$wJZHiKPV7OFfHIgeEWZhiBNnjs(SearchDeviceActivity searchDeviceActivity, View view) {
        searchDeviceActivity.m9056b(view);
    }

    /* renamed from: lambda$zRZpxI_YwQ_B3lcV1i-REO0RnXM */
    public static /* synthetic */ void m13001lambda$zRZpxI_YwQ_B3lcV1iREO0RnXM(SearchDeviceActivity searchDeviceActivity) {
        searchDeviceActivity.m9044f();
    }

    /* loaded from: classes.dex */
    public class MyViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b */
        private MyViewHolder f3884b;

        @UiThread
        public MyViewHolder_ViewBinding(MyViewHolder myViewHolder, View view) {
            this.f3884b = myViewHolder;
            myViewHolder.deviceTypePicContainer = Utils.m12800a(view, R.id.deviceTypePicContainer, "field 'deviceTypePicContainer'");
            myViewHolder.ivDeviceTypeName = (ImageView) Utils.m12799a(view, R.id.ivDeviceTypeName, "field 'ivDeviceTypeName'", ImageView.class);
            myViewHolder.ivDeviceTypePic = (ImageView) Utils.m12799a(view, R.id.ivDeviceTypePic, "field 'ivDeviceTypePic'", ImageView.class);
            myViewHolder.tvDeviceSN = (TextView) Utils.m12799a(view, R.id.tvDeviceSN, "field 'tvDeviceSN'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        /* renamed from: a */
        public void mo7436a() {
            MyViewHolder myViewHolder = this.f3884b;
            if (myViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f3884b = null;
            myViewHolder.deviceTypePicContainer = null;
            myViewHolder.ivDeviceTypeName = null;
            myViewHolder.ivDeviceTypePic = null;
            myViewHolder.tvDeviceSN = null;
        }
    }

    @Override // com.navatics.app.activities.StatusBarLightActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_device);
        ButterKnife.m12805a(this);
        SharedPreferences sharedPreferences = getSharedPreferences("developer_setting", 0);
        this.f3877j = sharedPreferences.getBoolean("enableAutoConn", getResources().getBoolean(R.bool.enable_auto_connect));
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        if (this.f3877j) {
            this.btnConnect.setClickable(false);
        } else {
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg);
            this.btnConnect.setText(getResources().getString(R.string.search_device));
        }
        this.f3880m.sendEmptyMessageDelayed(33, 10000L);
        this.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$KavAG8N67d54FE8i3u3SWxkdrqk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchDeviceActivity.lambda$KavAG8N67d54FE8i3u3SWxkdrqk(SearchDeviceActivity.this, view);
            }
        });
        this.btnConnect.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$wJZH-iKPV7OFfHIgeEWZhiBNnjs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchDeviceActivity.m13000lambda$wJZHiKPV7OFfHIgeEWZhiBNnjs(SearchDeviceActivity.this, view);
            }
        });
        this.rvDeviceList.setHasFixedSize(true);
        this.f3871d = new LinearLayoutManager(this, 0, false);
        this.rvDeviceList.setLayoutManager(this.f3871d);
        RecyclerView recyclerView = this.rvDeviceList;
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.InterfaceC1910a() { // from class: com.navatics.app.activities.SearchDeviceActivity.1
            @Override // com.navatics.app.utils.RecyclerItemClickListener.InterfaceC1910a
            /* renamed from: b */
            public void mo7406b(View view, int i) {
            }

            {
                SearchDeviceActivity.this = this;
            }

            @Override // com.navatics.app.utils.RecyclerItemClickListener.InterfaceC1910a
            /* renamed from: a */
            public void mo7407a(View view, int i) {
                if (i < 0 || i >= SearchDeviceActivity.this.f3872e.size()) {
                    return;
                }
                SearchDeviceActivity.this.f3878k = ((NvDeviceEntry) SearchDeviceActivity.this.f3872e.get(i)).m7757a().getSerialNumber();
                ((MyViewHolder) SearchDeviceActivity.this.rvDeviceList.getChildViewHolder(view)).deviceTypePicContainer.setBackgroundResource(R.drawable.search_page_item_bg_selected);
                SearchDeviceActivity searchDeviceActivity = SearchDeviceActivity.this;
                searchDeviceActivity.m9059a((NvDeviceEntry) searchDeviceActivity.f3872e.get(i));
            }
        }));
        this.f3870c = new MyAdapter(null);
        this.rvDeviceList.setAdapter(this.f3870c);
    }

    /* renamed from: c */
    public /* synthetic */ void m9050c(View view) {
        finish();
    }

    /* renamed from: b */
    public /* synthetic */ void m9056b(View view) {
        m9057b();
    }

    /* renamed from: b */
    public void m9057b() {
        NvDeviceEntry m9052b;
        Snackbar snackbar = this.f3879l;
        if (snackbar != null) {
            snackbar.dismiss();
        }
        if (this.f3877j) {
            if (TextUtils.isEmpty(this.f3878k) || (m9052b = m9052b(this.f3878k)) == null) {
                return;
            }
            m9053b(m9052b);
            return;
        }
        GroundStation m7931h = Navatics.m7931h();
        if (this.f3877j || m7931h == null) {
            return;
        }
        m7931h.m8099l();
    }

    /* renamed from: d */
    private void m9048d() {
        if (this.f3869a != null) {
            return;
        }
        this.tvNoResult.setVisibility(8);
        this.rvDeviceList.setVisibility(4);
        this.ivConnectingRotatingIcon.setVisibility(0);
        this.f3869a = ObjectAnimator.ofFloat(this.ivConnectingRotatingIcon, "rotation", 0.0f, 360.0f);
        this.f3869a.setDuration(500L);
        this.f3869a.setRepeatCount(-1);
        this.f3869a.start();
    }

    /* renamed from: e */
    public void m9046e() {
        if (this.f3869a != null) {
            this.ivConnectingRotatingIcon.setVisibility(8);
            this.f3869a.cancel();
            this.f3869a = null;
        }
    }

    /* renamed from: a */
    public void m9058a(String str) {
        Snackbar snackbar = this.f3879l;
        if (snackbar == null) {
            this.f3879l = Snackbar.make(this.rootLayout, str, -2);
            View view = this.f3879l.getView();
            view.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(InputDeviceCompat.SOURCE_ANY);
            this.f3879l.setAction("OK", new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$Ug5Zxg_4nVuYjaaC0FV0SLOY29U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchDeviceActivity.lambda$Ug5Zxg_4nVuYjaaC0FV0SLOY29U(SearchDeviceActivity.this, view2);
                }
            });
            this.f3879l.show();
            return;
        }
        ((TextView) snackbar.getView().findViewById(R.id.snackbar_text)).setText(str);
        if (this.f3879l.isShown()) {
            return;
        }
        this.f3879l.show();
    }

    /* renamed from: a */
    public /* synthetic */ void m9067a(View view) {
        this.f3879l.dismiss();
        this.f3879l = null;
    }

    /* renamed from: a */
    public void m9059a(NvDeviceEntry nvDeviceEntry) {
        String str;
        f3868b.mo1500c((Object) ("updateBtnState : " + NvDeviceEntry.m7756a(nvDeviceEntry.m7743j())));
        if (nvDeviceEntry.m7752b()) {
            this.btnConnect.setText(getString(R.string.connect));
            this.btnConnect.setEnabled(true);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg);
        } else if (nvDeviceEntry.m7750c()) {
            if (this.f3869a == null) {
                m9048d();
            }
            this.btnConnect.setText(getString(R.string.connecting_min));
            this.btnConnect.setEnabled(false);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg_deactivated);
        } else if (nvDeviceEntry.m7749d()) {
            this.btnConnect.setText(getString(R.string.connected));
            this.btnConnect.setEnabled(true);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg);
        } else if (nvDeviceEntry.m7748e()) {
            this.btnConnect.setText(getString(R.string.authenticating));
            this.btnConnect.setEnabled(false);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg_deactivated);
        } else if (nvDeviceEntry.m7747f()) {
            this.btnConnect.setText(getString(R.string.authenticated));
            this.btnConnect.setEnabled(false);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg_deactivated);
            m9046e();
            NvEventLoop.m6231b().mo6285a(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$zRZpxI_YwQ_B3lcV1i-REO0RnXM
                @Override // java.lang.Runnable
                public final void run() {
                    SearchDeviceActivity.m13001lambda$zRZpxI_YwQ_B3lcV1iREO0RnXM(SearchDeviceActivity.this);
                }
            }, 500L);
        } else if (nvDeviceEntry.m7746g()) {
            this.btnConnect.setText(getString(R.string.bind_device));
            this.btnConnect.setEnabled(false);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg_deactivated);
        } else if (nvDeviceEntry.m7745h()) {
            this.btnConnect.setText(getString(R.string.not_bound));
            this.btnConnect.setEnabled(false);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg_deactivated);
            IntentUtils.m7384b((Context) this);
        } else if (nvDeviceEntry.m7744i()) {
            if (nvDeviceEntry.m7742k().m6266a() == 51) {
                str = "NOT THE OWNER";
            } else {
                str = "Unknown error(" + nvDeviceEntry.m7742k().m6266a() + ")";
            }
            this.btnConnect.setText(str);
            this.btnConnect.setEnabled(false);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg_deactivated);
        } else {
            throw new RuntimeException("unknown state : " + nvDeviceEntry.m7743j());
        }
    }

    /* renamed from: f */
    public /* synthetic */ void m9044f() {
        startActivity(new Intent(this, HomepageActivity.class));
        finish();
    }

    /* renamed from: b */
    private NvDeviceEntry m9052b(String str) {
        for (NvDeviceEntry nvDeviceEntry : this.f3872e) {
            C3044k c3044k = f3868b;
            c3044k.mo1511a((Object) ("device : " + nvDeviceEntry.m7757a().getSerialNumber() + ", state : " + nvDeviceEntry.m7743j()));
            if (nvDeviceEntry.m7757a().getSerialNumber().equals(str) && nvDeviceEntry.m7752b() && !nvDeviceEntry.m7750c()) {
                return nvDeviceEntry;
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m9053b(NvDeviceEntry nvDeviceEntry) {
        if (nvDeviceEntry == null) {
            f3868b.mo1499d("connectToDevice failed, NvDeviceEntry is null.");
            return;
        }
        GroundStation m7931h = Navatics.m7931h();
        if (m7931h != null) {
            m7931h.m8135a(nvDeviceEntry.m7757a(), (Map<String, Object>) null);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("enableAutoConn".equals(str)) {
            this.f3877j = sharedPreferences.getBoolean(str, getResources().getBoolean(R.bool.enable_auto_connect));
        }
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getSharedPreferences("developer_setting", 0).unregisterOnSharedPreferenceChangeListener(this);
        f3868b.mo1511a((Object) "onDestroy");
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        f3868b.mo1511a((Object) "onStart");
        Navatics.m7952a(this.f3873f);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        m9046e();
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        f3868b.mo1511a((Object) "onStop");
        Navatics.m7945b(this.f3873f);
        NvDisposableHandler.m7731a((NvDisposableHandler) this.f3875h);
        NvDisposableHandler.m7731a((NvDisposableHandler) this.f3876i);
    }

    /* loaded from: classes.dex */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView
        View deviceTypePicContainer;
        @BindView
        ImageView ivDeviceTypeName;
        @BindView
        ImageView ivDeviceTypePic;
        @BindView
        TextView tvDeviceSN;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.m12803a(this, view);
        }
    }

    /* loaded from: classes.dex */
    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        /* renamed from: b */
        private List<NvDeviceEntry> f3883b;

        MyAdapter(List<NvDeviceEntry> list) {
            SearchDeviceActivity.this = r1;
            this.f3883b = list;
        }

        /* renamed from: a */
        public void m9037a(List<NvDeviceEntry> list) {
            this.f3883b = list;
        }

        @Override // android.support.p011v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: a */
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_page_item, viewGroup, false));
        }

        @Override // android.support.p011v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            NvDeviceEntry nvDeviceEntry = this.f3883b.get(i);
            String serialNumber = nvDeviceEntry.m7757a().getSerialNumber();
            myViewHolder.tvDeviceSN.setText(serialNumber);
            C3044k c3044k = SearchDeviceActivity.f3868b;
            c3044k.mo1511a((Object) ("onBindViewHolder position " + i + ", SelectedDevice=" + SearchDeviceActivity.this.f3878k + ", sn= " + serialNumber));
            if (SearchDeviceActivity.this.f3878k != null && SearchDeviceActivity.this.f3878k.equals(serialNumber)) {
                myViewHolder.deviceTypePicContainer.setBackgroundResource(R.drawable.search_page_item_bg_selected);
            } else {
                myViewHolder.deviceTypePicContainer.setBackgroundResource(R.drawable.search_page_item_bg_normal);
            }
            SearchDeviceActivity.this.m9059a(nvDeviceEntry);
        }

        @Override // android.support.p011v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<NvDeviceEntry> list = this.f3883b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* renamed from: com.navatics.app.activities.SearchDeviceActivity$e */
    /* loaded from: classes.dex */
    public class C1667e implements NvRootHandler {
        /* renamed from: lambda$KUaQqqux7tlYHr_V-Ww39FwJAek */
        public static /* synthetic */ void m13004lambda$KUaQqqux7tlYHr_VWw39FwJAek(C1667e c1667e) {
            c1667e.m9031a();
        }

        @Override // com.navatics.app.framework.NvRootHandler
        /* renamed from: a */
        public void mo7664a(GroundStation groundStation) {
        }

        C1667e() {
            SearchDeviceActivity.this = r1;
        }

        @Override // com.navatics.app.framework.NvRootHandler
        /* renamed from: a */
        public void mo7502a(GroundStation groundStation, GroundStation groundStation2) {
            if (groundStation2 == null) {
                return;
            }
            NvDisposableHandler.m7731a((NvDisposableHandler) SearchDeviceActivity.this.f3874g);
            NvDisposableHandler.m7731a((NvDisposableHandler) SearchDeviceActivity.this.f3875h);
            SearchDeviceActivity searchDeviceActivity = SearchDeviceActivity.this;
            searchDeviceActivity.f3875h = new C1665c();
            groundStation2.m8137a(SearchDeviceActivity.this.f3875h);
            SearchDeviceActivity searchDeviceActivity2 = SearchDeviceActivity.this;
            searchDeviceActivity2.f3874g = new C1664b();
            groundStation2.m8141a(SearchDeviceActivity.this.f3874g);
        }

        @Override // com.navatics.app.framework.NvRootHandler
        /* renamed from: b */
        public void mo7500b(GroundStation groundStation) {
            SearchDeviceActivity.f3868b.mo1511a((Object) "onGroundStationDisconnected");
            NvDisposableHandler.m7731a((NvDisposableHandler) SearchDeviceActivity.this.f3874g);
            NvDisposableHandler.m7731a((NvDisposableHandler) SearchDeviceActivity.this.f3875h);
            SearchDeviceActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$e$KUaQqqux7tlYHr_V-Ww39FwJAek
                @Override // java.lang.Runnable
                public final void run() {
                    SearchDeviceActivity.C1667e.m13004lambda$KUaQqqux7tlYHr_VWw39FwJAek(SearchDeviceActivity.C1667e.this);
                }
            });
        }

        /* renamed from: a */
        public /* synthetic */ void m9031a() {
            SearchDeviceActivity searchDeviceActivity = SearchDeviceActivity.this;
            Toast.makeText(searchDeviceActivity, searchDeviceActivity.getString(R.string.controller_disconnected), 0).show();
            if (!SearchDeviceActivity.this.avloadingAnimView.m7058a()) {
                SearchDeviceActivity.this.avloadingAnimView.m7051b();
            }
            SearchDeviceActivity.this.m9046e();
        }

        @Override // com.navatics.app.framework.NvRootHandler
        /* renamed from: c */
        public void mo7663c(GroundStation groundStation) {
            SearchDeviceActivity.f3868b.mo1511a((Object) "onNewGroundStation");
            SearchDeviceActivity.this.m9046e();
            Intent intent = new Intent(SearchDeviceActivity.this, BindRemoteActivity.class);
            intent.putExtra("remote_id", groundStation.m8129b());
            SearchDeviceActivity.this.startActivity(intent);
            SearchDeviceActivity.this.finish();
        }
    }

    /* renamed from: com.navatics.app.activities.SearchDeviceActivity$c */
    /* loaded from: classes.dex */
    public class C1665c extends AbstractGroundStationHandler {
        public static /* synthetic */ void lambda$D6307jz0xFoF0r2Zfto0bFG9i8Q(C1665c c1665c) {
            c1665c.m9032c();
        }

        public static /* synthetic */ void lambda$g3Ccmow18rFdnI_EbHIG2UXWlPM(C1665c c1665c) {
            c1665c.m9033b();
        }

        C1665c() {
            SearchDeviceActivity.this = r1;
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7507a(GroundStation groundStation, NvConnection nvConnection, NvConnection nvConnection2) {
            if (nvConnection2 == null) {
                SearchDeviceActivity.f3868b.mo1499d("onConnectionChanged newConn is null");
                return;
            }
            C3044k c3044k = SearchDeviceActivity.f3868b;
            c3044k.mo1511a((Object) ("onConnectionChanged, newConn.isAuthed " + nvConnection2.m7875j()));
            if (!SearchDeviceActivity.this.f3877j && nvConnection2.m7875j()) {
                SearchDeviceActivity.this.m9046e();
                SearchDeviceActivity searchDeviceActivity = SearchDeviceActivity.this;
                searchDeviceActivity.startActivity(new Intent(searchDeviceActivity, HomepageActivity.class));
                SearchDeviceActivity.this.finish();
                return;
            }
            SearchDeviceActivity searchDeviceActivity2 = SearchDeviceActivity.this;
            searchDeviceActivity2.f3876i = new C1663a();
            nvConnection2.m7896a(SearchDeviceActivity.this.f3876i);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7729a(GroundStation groundStation, int i) {
            if (i == 0) {
                SearchDeviceActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$c$D6307jz0xFoF0r2Zfto0bFG9i8Q
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchDeviceActivity.C1665c.lambda$D6307jz0xFoF0r2Zfto0bFG9i8Q(SearchDeviceActivity.C1665c.this);
                    }
                });
            } else if (i == 2) {
                SearchDeviceActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$c$g3Ccmow18rFdnI_EbHIG2UXWlPM
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchDeviceActivity.C1665c.lambda$g3Ccmow18rFdnI_EbHIG2UXWlPM(SearchDeviceActivity.C1665c.this);
                    }
                });
            }
        }

        /* renamed from: c */
        public /* synthetic */ void m9032c() {
            if (SearchDeviceActivity.this.f3872e == null || SearchDeviceActivity.this.f3872e.size() >= 1) {
                return;
            }
            SearchDeviceActivity.this.avloadingAnimView.setVisibility(0);
            SearchDeviceActivity.this.avloadingAnimView.m7049c();
        }

        /* renamed from: b */
        public /* synthetic */ void m9033b() {
            if (SearchDeviceActivity.this.f3872e == null || SearchDeviceActivity.this.f3872e.size() <= 0) {
                return;
            }
            SearchDeviceActivity.this.avloadingAnimView.m7051b();
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7508a(GroundStation groundStation, NvConnection nvConnection) {
            LoggerUtil.m5930a("onNewDevice1");
            SearchDeviceActivity.this.m9046e();
            Intent intent = new Intent(SearchDeviceActivity.this, BindRobotActivity.class);
            intent.putExtra("remote_id", groundStation.m8129b());
            intent.putExtra("conn_id", nvConnection.m7881e());
            SearchDeviceActivity.this.startActivity(intent);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7728a(GroundStation groundStation, int i, NvError nvError) {
            if (i == 16711681) {
                SearchDeviceActivity.this.m9046e();
                SearchDeviceActivity.this.rvDeviceList.setVisibility(0);
                if (nvError.m6266a() == 54) {
                    return;
                }
                if (nvError.m6266a() == 49) {
                    SearchDeviceActivity.this.m9058a("Connect error because of invalid params.");
                } else if (nvError.m6266a() == 48) {
                    SearchDeviceActivity.this.m9058a("I/O error when connecting to roller.");
                } else if (nvError.m6266a() == 255) {
                    SearchDeviceActivity.this.m9058a("Connection failed for unknown reason");
                } else {
                    SearchDeviceActivity.this.m9058a(NvError.m6265a(nvError.m6266a()));
                }
            }
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7727a(NvDeviceInfo nvDeviceInfo) {
            C3044k c3044k = SearchDeviceActivity.f3868b;
            c3044k.mo1499d("GroundStation " + nvDeviceInfo.getSerialNumber() + " destroyed.");
            if (SearchDeviceActivity.this.f3880m != null) {
                SearchDeviceActivity.this.f3880m.removeCallbacksAndMessages(null);
            }
        }
    }

    /* renamed from: com.navatics.app.activities.SearchDeviceActivity$a */
    /* loaded from: classes.dex */
    public class C1663a extends AbstractConnectionHandler {
        public static /* synthetic */ void lambda$UJhY8s7qzTyfoW45LD5IlIPYia4(C1663a c1663a, int i, NvError nvError) {
            c1663a.m9036a(i, nvError);
        }

        C1663a() {
            SearchDeviceActivity.this = r1;
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: b */
        public void mo7511b(NvConnection nvConnection) {
            SearchDeviceActivity.f3868b.mo1511a((Object) "SearchDeviceActivity onAuthSuccess");
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: a */
        public void mo7861a(NvConnection nvConnection) {
            SearchDeviceActivity.f3868b.mo1511a((Object) "SearchDeviceActivity onBindSuccess");
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: a */
        public void mo7860a(NvConnection nvConnection, final int i, final NvError nvError) {
            SearchDeviceActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$a$UJhY8s7qzTyfoW45LD5IlIPYia4
                @Override // java.lang.Runnable
                public final void run() {
                    SearchDeviceActivity.C1663a.lambda$UJhY8s7qzTyfoW45LD5IlIPYia4(SearchDeviceActivity.C1663a.this, i, nvError);
                }
            });
        }

        /* renamed from: a */
        public /* synthetic */ void m9036a(int i, NvError nvError) {
            if (i != 16711682) {
                return;
            }
            C3044k c3044k = SearchDeviceActivity.f3868b;
            c3044k.mo1504b((Object) (SearchDeviceActivity.this.getString(R.string.authentication_failed) + nvError));
            if (nvError.m6266a() == 51) {
                SearchDeviceActivity searchDeviceActivity = SearchDeviceActivity.this;
                searchDeviceActivity.m9058a(searchDeviceActivity.getString(R.string.device_already_registered));
            } else if (nvError.m6266a() == 50) {
                SearchDeviceActivity searchDeviceActivity2 = SearchDeviceActivity.this;
                searchDeviceActivity2.m9058a(searchDeviceActivity2.getString(R.string.usb_not_ready));
            } else if (nvError.m6266a() != 48) {
                SearchDeviceActivity.this.m9058a(NvError.m6265a(nvError.m6266a()));
            } else {
                SearchDeviceActivity searchDeviceActivity3 = SearchDeviceActivity.this;
                searchDeviceActivity3.m9058a(searchDeviceActivity3.getString(R.string.IO_error));
            }
        }
    }

    /* renamed from: com.navatics.app.activities.SearchDeviceActivity$b */
    /* loaded from: classes.dex */
    public class C1664b extends AbstractGndStaDeviceItemUpdateHandler {
        /* renamed from: lambda$TkLKejQBpJdD6LnM9QX-BR00oaI */
        public static /* synthetic */ void m13002lambda$TkLKejQBpJdD6LnM9QXBR00oaI(C1664b c1664b) {
            c1664b.m9034c();
        }

        /* renamed from: lambda$h5LeDulE-y_i0DPX6yhRmGjOJv0 */
        public static /* synthetic */ void m13003lambda$h5LeDulEy_i0DPX6yhRmGjOJv0(C1664b c1664b) {
            c1664b.m9035b();
        }

        C1664b() {
            SearchDeviceActivity.this = r1;
        }

        @Override // com.navatics.app.framework.AbstractGndStaDeviceItemUpdateHandler, com.navatics.app.framework.GroundStationDeviceItemUpdateHandler
        /* renamed from: a */
        public void mo8062a(List<NvDeviceEntry> list) {
            SearchDeviceActivity.f3868b.mo1500c((Object) "onDeviceItemListUpdate");
            SearchDeviceActivity.this.f3872e = list;
            SearchDeviceActivity.this.f3870c.m9037a(SearchDeviceActivity.this.f3872e);
            if (SearchDeviceActivity.this.f3872e != null && !SearchDeviceActivity.this.f3872e.isEmpty()) {
                SearchDeviceActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$b$TkLKejQBpJdD6LnM9QX-BR00oaI
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchDeviceActivity.C1664b.m13002lambda$TkLKejQBpJdD6LnM9QXBR00oaI(SearchDeviceActivity.C1664b.this);
                    }
                });
            } else {
                SearchDeviceActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$b$h5LeDulE-y_i0DPX6yhRmGjOJv0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchDeviceActivity.C1664b.m13003lambda$h5LeDulEy_i0DPX6yhRmGjOJv0(SearchDeviceActivity.C1664b.this);
                    }
                });
            }
        }

        /* renamed from: c */
        public /* synthetic */ void m9034c() {
            if (Navatics.m7931h() != null && SearchDeviceActivity.this.ivConnectingRotatingIcon.getVisibility() != 0) {
                SearchDeviceActivity searchDeviceActivity = SearchDeviceActivity.this;
                searchDeviceActivity.f3878k = ((NvDeviceEntry) searchDeviceActivity.f3872e.get(0)).m7757a().getSerialNumber();
                SearchDeviceActivity.this.rvDeviceList.setVisibility(0);
                SearchDeviceActivity.this.tvNoResult.setVisibility(4);
            }
            if (SearchDeviceActivity.this.f3872e.size() > 0) {
                SearchDeviceActivity.this.f3880m.removeMessages(33);
                if (!SearchDeviceActivity.this.avloadingAnimView.m7058a()) {
                    SearchDeviceActivity.this.avloadingAnimView.m7051b();
                }
            }
            SearchDeviceActivity.this.f3870c.notifyDataSetChanged();
        }

        /* renamed from: b */
        public /* synthetic */ void m9035b() {
            SearchDeviceActivity.this.rvDeviceList.setVisibility(4);
            SearchDeviceActivity.this.tvNoResult.setVisibility(0);
            SearchDeviceActivity.this.tvNoResult.setText("Searching, Please wait...");
        }
    }

    /* renamed from: com.navatics.app.activities.SearchDeviceActivity$d */
    /* loaded from: classes.dex */
    class HandlerC1666d extends Handler {

        /* renamed from: a */
        WeakReference<SearchDeviceActivity> f3888a;

        HandlerC1666d(SearchDeviceActivity searchDeviceActivity) {
            SearchDeviceActivity.this = r1;
            this.f3888a = new WeakReference<>(searchDeviceActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f3888a.get() != null && message.what == 33) {
                SearchDeviceActivity.this.tvNoResult.setText(SearchDeviceActivity.this.getString(R.string.no_device_found));
            }
        }
    }
}
