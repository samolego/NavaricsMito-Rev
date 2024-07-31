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
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import butterknife.internal.C0506b;
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
import com.navatics.robot.utils.logging.LoggerUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/* loaded from: classes.dex */
public class SearchDeviceActivity extends StatusBarLightActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: b */
    private static final Logger logger = Logger.getLogger(SearchDeviceActivity.class);

    /* renamed from: a */
    ObjectAnimator f3890a;

    @BindView
    AVLoadingIndicatorView avloadingAnimView;

    @BindView
    Button btnConnect;

    /* renamed from: c */
    private MyAdapter f3891c;

    /* renamed from: d */
    private LinearLayoutManager f3892d;

    /* renamed from: g */
    private C1522b f3895g;

    /* renamed from: i */
    private C1521a f3897i;

    @BindView
    ImageView ivBack;

    @BindView
    ImageView ivConnectingRotatingIcon;

    /* renamed from: j */
    private boolean f3898j;

    /* renamed from: k */
    private String f3899k;

    /* renamed from: l */
    private Snackbar snackbar;

    @BindView
    ViewGroup rootLayout;

    @BindView
    RecyclerView rvDeviceList;

    @BindView
    TextView tvNoResult;

    /* renamed from: e */
    private List<NvDeviceEntry> f3893e = new ArrayList();

    /* renamed from: f */
    private C1525e f3894f = new C1525e();

    /* renamed from: h */
    private C1523c f3896h = new C1523c();

    /* renamed from: m */
    private Handler f3901m = new HandlerC1524d(this);

    /* loaded from: classes.dex */
    public class MyViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b */
        private MyViewHolder f3905b;

        @UiThread
        public MyViewHolder_ViewBinding(MyViewHolder myViewHolder, View view) {
            this.f3905b = myViewHolder;
            myViewHolder.deviceTypePicContainer = C0506b.m157a(view, R.id.deviceTypePicContainer, "field 'deviceTypePicContainer'");
            myViewHolder.ivDeviceTypeName = (ImageView) C0506b.m158a(view, R.id.ivDeviceTypeName, "field 'ivDeviceTypeName'", ImageView.class);
            myViewHolder.ivDeviceTypePic = (ImageView) C0506b.m158a(view, R.id.ivDeviceTypePic, "field 'ivDeviceTypePic'", ImageView.class);
            myViewHolder.tvDeviceSN = (TextView) C0506b.m158a(view, R.id.tvDeviceSN, "field 'tvDeviceSN'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        /* renamed from: a */
        public void mo155a() {
            MyViewHolder myViewHolder = this.f3905b;
            if (myViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f3905b = null;
            myViewHolder.deviceTypePicContainer = null;
            myViewHolder.ivDeviceTypeName = null;
            myViewHolder.ivDeviceTypePic = null;
            myViewHolder.tvDeviceSN = null;
        }
    }

    @Override // com.navatics.app.activities.StatusBarLightActivity, com.navatics.app.NvBaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_device);
        ButterKnife.m151a(this);
        SharedPreferences sharedPreferences = getSharedPreferences("developer_setting", 0);
        this.f3898j = sharedPreferences.getBoolean("enableAutoConn", getResources().getBoolean(R.bool.enable_auto_connect));
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        if (this.f3898j) {
            this.btnConnect.setClickable(false);
        } else {
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg);
            this.btnConnect.setText(getResources().getString(R.string.search_device));
        }
        this.f3901m.sendEmptyMessageDelayed(33, 10000L);
        this.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$KavAG8N67d54FE8i3u3SWxkdrqk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchDeviceActivity.this.m3897c(view);
            }
        });
        this.btnConnect.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$wJZH-iKPV7OFfHIgeEWZhiBNnjs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchDeviceActivity.this.searchDevices(view);
            }
        });
        this.rvDeviceList.setHasFixedSize(true);
        this.f3892d = new LinearLayoutManager(this, 0, false);
        this.rvDeviceList.setLayoutManager(this.f3892d);
        RecyclerView recyclerView = this.rvDeviceList;
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.InterfaceC1815a() { // from class: com.navatics.app.activities.SearchDeviceActivity.1
            @Override // com.navatics.app.utils.RecyclerItemClickListener.InterfaceC1815a
            /* renamed from: b */
            public void mo3909b(View view, int i) {
            }

            @Override // com.navatics.app.utils.RecyclerItemClickListener.InterfaceC1815a
            /* renamed from: a */
            public void mo3908a(View view, int i) {
                if (i < 0 || i >= SearchDeviceActivity.this.f3893e.size()) {
                    return;
                }
                NvDeviceEntry nvDeviceEntry = (NvDeviceEntry) SearchDeviceActivity.this.f3893e.get(i);
                SearchDeviceActivity.this.f3899k = nvDeviceEntry.m5167a().getSerialNumber();
                ((MyViewHolder) SearchDeviceActivity.this.rvDeviceList.getChildViewHolder(view)).deviceTypePicContainer.setBackgroundResource(R.drawable.search_page_item_bg_selected);
                SearchDeviceActivity searchDeviceActivity = SearchDeviceActivity.this;
                searchDeviceActivity.updateBtnState((NvDeviceEntry) searchDeviceActivity.f3893e.get(i));
            }
        }));
        this.f3891c = new MyAdapter(null);
        this.rvDeviceList.setAdapter(this.f3891c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m3897c(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void searchDevices(View view) {
        searchForDevices();
    }

    /* renamed from: b */
    public void searchForDevices() {
        NvDeviceEntry deviceEntry;
        Snackbar snackbar = this.snackbar;
        if (snackbar != null) {
            snackbar.dismiss();
        }
        if (this.f3898j) {
            if (TextUtils.isEmpty(this.f3899k) || (deviceEntry = m3890b(this.f3899k)) == null) {
                return;
            }
            connectToDevice(deviceEntry);
            return;
        }
        GroundStation groundStation = Navatics.getGroundStation();
        if (this.f3898j || groundStation == null) {
            return;
        }
        groundStation.searchDevices();
    }

    /* renamed from: d */
    private void m3899d() {
        if (this.f3890a != null) {
            return;
        }
        this.tvNoResult.setVisibility(8);
        this.rvDeviceList.setVisibility(4);
        this.ivConnectingRotatingIcon.setVisibility(0);
        this.f3890a = ObjectAnimator.ofFloat(this.ivConnectingRotatingIcon, "rotation", 0.0f, 360.0f);
        this.f3890a.setDuration(500L);
        this.f3890a.setRepeatCount(-1);
        this.f3890a.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3900e() {
        if (this.f3890a != null) {
            this.ivConnectingRotatingIcon.setVisibility(8);
            this.f3890a.cancel();
            this.f3890a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3889a(String str) {
        Snackbar snackbar = this.snackbar;
        if (snackbar == null) {
            this.snackbar = Snackbar.make(this.rootLayout, str, -2);
            View view = this.snackbar.getView();
            view.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(InputDeviceCompat.SOURCE_ANY);
            this.snackbar.setAction("OK", new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$Ug5Zxg_4nVuYjaaC0FV0SLOY29U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchDeviceActivity.this.removeSnackbar(view2);
                }
            });
            this.snackbar.show();
            return;
        }
        ((TextView) snackbar.getView().findViewById(R.id.snackbar_text)).setText(str);
        if (this.snackbar.isShown()) {
            return;
        }
        this.snackbar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void removeSnackbar(View view) {
        this.snackbar.dismiss();
        this.snackbar = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void updateBtnState(NvDeviceEntry nvDeviceEntry) {
        String str;
        logger.conditionalLog((Object) ("updateBtnState : " + NvDeviceEntry.m5165a(nvDeviceEntry.m5179j())));
        if (nvDeviceEntry.m5171b()) {
            this.btnConnect.setText(getString(R.string.connect));
            this.btnConnect.setEnabled(true);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg);
            return;
        }
        if (nvDeviceEntry.m5172c()) {
            if (this.f3890a == null) {
                m3899d();
            }
            this.btnConnect.setText(getString(R.string.connecting_min));
            this.btnConnect.setEnabled(false);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg_deactivated);
            return;
        }
        if (nvDeviceEntry.m5173d()) {
            this.btnConnect.setText(getString(R.string.connected));
            this.btnConnect.setEnabled(true);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg);
            return;
        }
        if (nvDeviceEntry.m5174e()) {
            this.btnConnect.setText(getString(R.string.authenticating));
            this.btnConnect.setEnabled(false);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg_deactivated);
            return;
        }
        if (nvDeviceEntry.m5175f()) {
            this.btnConnect.setText(getString(R.string.authenticated));
            this.btnConnect.setEnabled(false);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg_deactivated);
            m3900e();
            NvEventLoop.m6663b().mo6528a(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$zRZpxI_YwQ_B3lcV1i-REO0RnXM
                @Override // java.lang.Runnable
                public final void run() {
                    SearchDeviceActivity.this.m3902f();
                }
            }, 500L);
            return;
        }
        if (nvDeviceEntry.m5176g()) {
            this.btnConnect.setText(getString(R.string.bind_device));
            this.btnConnect.setEnabled(false);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg_deactivated);
            return;
        }
        if (nvDeviceEntry.m5177h()) {
            this.btnConnect.setText(getString(R.string.not_bound));
            this.btnConnect.setEnabled(false);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg_deactivated);
            IntentUtils.m5506b((Context) this);
            return;
        }
        if (nvDeviceEntry.m5178i()) {
            if (nvDeviceEntry.m5180k().m6630a() == 51) {
                str = "NOT THE OWNER";
            } else {
                str = "Unknown error(" + nvDeviceEntry.m5180k().m6630a() + ")";
            }
            this.btnConnect.setText(str);
            this.btnConnect.setEnabled(false);
            this.btnConnect.setBackgroundResource(R.drawable.search_page_search_btn_bg_deactivated);
            return;
        }
        throw new RuntimeException("unknown state : " + nvDeviceEntry.m5179j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m3902f() {
        startActivity(new Intent(this, (Class<?>) HomepageActivity.class));
        finish();
    }

    /* renamed from: b */
    private NvDeviceEntry m3890b(String str) {
        for (NvDeviceEntry nvDeviceEntry : this.f3893e) {
            logger.conditionalLog3((Object) ("device : " + nvDeviceEntry.m5167a().getSerialNumber() + ", state : " + nvDeviceEntry.m5179j()));
            if (nvDeviceEntry.m5167a().getSerialNumber().equals(str) && nvDeviceEntry.m5171b() && !nvDeviceEntry.m5172c()) {
                return nvDeviceEntry;
            }
        }
        return null;
    }

    /* renamed from: b */
    private void connectToDevice(NvDeviceEntry nvDeviceEntry) {
        if (nvDeviceEntry == null) {
            logger.conditionalLog2("connectToDevice failed, NvDeviceEntry is null.");
            return;
        }
        GroundStation groundStation = Navatics.getGroundStation();
        if (groundStation != null) {
            groundStation.m4865a(nvDeviceEntry.m5167a(), (Map<String, Object>) null);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("enableAutoConn".equals(str)) {
            this.f3898j = sharedPreferences.getBoolean(str, getResources().getBoolean(R.bool.enable_auto_connect));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getSharedPreferences("developer_setting", 0).unregisterOnSharedPreferenceChangeListener(this);
        logger.conditionalLog3((Object) "onDestroy");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        logger.conditionalLog3((Object) "onStart");
        Navatics.m4985a(this.f3894f);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        m3900e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        logger.conditionalLog3((Object) "onStop");
        Navatics.m4992b(this.f3894f);
        NvDisposableHandler.m5190a((NvDisposableHandler) this.f3896h);
        NvDisposableHandler.m5190a((NvDisposableHandler) this.f3897i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
            ButterKnife.m152a(this, view);
        }
    }

    /* loaded from: classes.dex */
    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        /* renamed from: b */
        private List<NvDeviceEntry> f3904b;

        MyAdapter(List<NvDeviceEntry> list) {
            this.f3904b = list;
        }

        /* renamed from: a */
        public void m3912a(List<NvDeviceEntry> list) {
            this.f3904b = list;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_page_item, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            NvDeviceEntry nvDeviceEntry = this.f3904b.get(i);
            String serialNumber = nvDeviceEntry.m5167a().getSerialNumber();
            myViewHolder.tvDeviceSN.setText(serialNumber);
            SearchDeviceActivity.logger.conditionalLog3((Object) ("onBindViewHolder position " + i + ", SelectedDevice=" + SearchDeviceActivity.this.f3899k + ", sn= " + serialNumber));
            if (SearchDeviceActivity.this.f3899k != null && SearchDeviceActivity.this.f3899k.equals(serialNumber)) {
                myViewHolder.deviceTypePicContainer.setBackgroundResource(R.drawable.search_page_item_bg_selected);
            } else {
                myViewHolder.deviceTypePicContainer.setBackgroundResource(R.drawable.search_page_item_bg_normal);
            }
            SearchDeviceActivity.this.updateBtnState(nvDeviceEntry);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<NvDeviceEntry> list = this.f3904b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.activities.SearchDeviceActivity$e */
    /* loaded from: classes.dex */
    public class C1525e implements NvRootHandler {
        @Override // com.navatics.app.framework.NvRootHandler
        /* renamed from: a */
        public void mo3924a(GroundStation groundStation) {
        }

        C1525e() {
        }

        @Override // com.navatics.app.framework.NvRootHandler
        /* renamed from: a */
        public void mo3925a(GroundStation groundStation, GroundStation groundStation2) {
            if (groundStation2 == null) {
                return;
            }
            NvDisposableHandler.m5190a((NvDisposableHandler) SearchDeviceActivity.this.f3895g);
            NvDisposableHandler.m5190a((NvDisposableHandler) SearchDeviceActivity.this.f3896h);
            SearchDeviceActivity searchDeviceActivity = SearchDeviceActivity.this;
            searchDeviceActivity.f3896h = new C1523c();
            groundStation2.notifySearchStateChanged(SearchDeviceActivity.this.f3896h);
            SearchDeviceActivity searchDeviceActivity2 = SearchDeviceActivity.this;
            searchDeviceActivity2.f3895g = new C1522b();
            groundStation2.m4862a(SearchDeviceActivity.this.f3895g);
        }

        @Override // com.navatics.app.framework.NvRootHandler
        /* renamed from: b */
        public void onGroundStationDisconnected(GroundStation groundStation) {
            SearchDeviceActivity.logger.conditionalLog3((Object) "onGroundStationDisconnected");
            NvDisposableHandler.m5190a((NvDisposableHandler) SearchDeviceActivity.this.f3895g);
            NvDisposableHandler.m5190a((NvDisposableHandler) SearchDeviceActivity.this.f3896h);
            SearchDeviceActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$e$KUaQqqux7tlYHr_V-Ww39FwJAek
                @Override // java.lang.Runnable
                public final void run() {
                    SearchDeviceActivity.C1525e.this.m3923a();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m3923a() {
            SearchDeviceActivity searchDeviceActivity = SearchDeviceActivity.this;
            Toast.makeText(searchDeviceActivity, searchDeviceActivity.getString(R.string.controller_disconnected), 0).show();
            if (!SearchDeviceActivity.this.avloadingAnimView.m5816a()) {
                SearchDeviceActivity.this.avloadingAnimView.m5817b();
            }
            SearchDeviceActivity.this.m3900e();
        }

        @Override // com.navatics.app.framework.NvRootHandler
        /* renamed from: c */
        public void onNewGroundStation(GroundStation groundStation) {
            SearchDeviceActivity.logger.conditionalLog3((Object) "onNewGroundStation");
            SearchDeviceActivity.this.m3900e();
            Intent intent = new Intent(SearchDeviceActivity.this, (Class<?>) BindRemoteActivity.class);
            intent.putExtra("remote_id", groundStation.getRemoteId());
            SearchDeviceActivity.this.startActivity(intent);
            SearchDeviceActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.activities.SearchDeviceActivity$c */
    /* loaded from: classes.dex */
    public class C1523c extends AbstractGroundStationHandler {
        C1523c() {
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void onConnectionChanged(GroundStation groundStation, NvConnection nvConnection, NvConnection newConn) {
            if (newConn == null) {
                SearchDeviceActivity.logger.conditionalLog2("onConnectionChanged newConn is null");
                return;
            }
            SearchDeviceActivity.logger.conditionalLog3((Object) ("onConnectionChanged, newConn.isAuthed " + newConn.isAuthed()));
            if (!SearchDeviceActivity.this.f3898j && newConn.isAuthed()) {
                SearchDeviceActivity.this.m3900e();
                SearchDeviceActivity searchDeviceActivity = SearchDeviceActivity.this;
                searchDeviceActivity.startActivity(new Intent(searchDeviceActivity, (Class<?>) HomepageActivity.class));
                SearchDeviceActivity.this.finish();
                return;
            }
            SearchDeviceActivity searchDeviceActivity2 = SearchDeviceActivity.this;
            searchDeviceActivity2.f3897i = new C1521a();
            newConn.m5051a(SearchDeviceActivity.this.f3897i);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo3920a(GroundStation groundStation, int i) {
            if (i == 0) {
                SearchDeviceActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$c$D6307jz0xFoF0r2Zfto0bFG9i8Q
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchDeviceActivity.C1523c.this.m3919c();
                    }
                });
            } else if (i == 2) {
                SearchDeviceActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$c$g3Ccmow18rFdnI_EbHIG2UXWlPM
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchDeviceActivity.C1523c.this.m3918b();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m3919c() {
            if (SearchDeviceActivity.this.f3893e == null || SearchDeviceActivity.this.f3893e.size() >= 1) {
                return;
            }
            SearchDeviceActivity.this.avloadingAnimView.setVisibility(0);
            SearchDeviceActivity.this.avloadingAnimView.m5818c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m3918b() {
            if (SearchDeviceActivity.this.f3893e == null || SearchDeviceActivity.this.f3893e.size() <= 0) {
                return;
            }
            SearchDeviceActivity.this.avloadingAnimView.m5817b();
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void onNewDevice1(GroundStation groundStation, NvConnection nvConnection) {
            LoggerUtil.m6926a("onNewDevice1");
            SearchDeviceActivity.this.m3900e();
            Intent intent = new Intent(SearchDeviceActivity.this, (Class<?>) BindRobotActivity.class);
            intent.putExtra("remote_id", groundStation.getRemoteId());
            intent.putExtra("conn_id", nvConnection.getConnectionId());
            SearchDeviceActivity.this.startActivity(intent);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void connect(GroundStation groundStation, int i, NvError nvError) {
            if (i == 16711681) {
                SearchDeviceActivity.this.m3900e();
                SearchDeviceActivity.this.rvDeviceList.setVisibility(0);
                if (nvError.m6630a() == 54) {
                    return;
                }
                if (nvError.m6630a() == 49) {
                    SearchDeviceActivity.this.m3889a("Connect error because of invalid params.");
                    return;
                }
                if (nvError.m6630a() == 48) {
                    SearchDeviceActivity.this.m3889a("I/O error when connecting to roller.");
                } else if (nvError.m6630a() == 255) {
                    SearchDeviceActivity.this.m3889a("Connection failed for unknown reason");
                } else {
                    SearchDeviceActivity.this.m3889a(NvError.getType(nvError.m6630a()));
                }
            }
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void destroyDevice(NvDeviceInfo nvDeviceInfo) {
            SearchDeviceActivity.logger.conditionalLog2("GroundStation " + nvDeviceInfo.getSerialNumber() + " destroyed.");
            if (SearchDeviceActivity.this.f3901m != null) {
                SearchDeviceActivity.this.f3901m.removeCallbacksAndMessages(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.activities.SearchDeviceActivity$a */
    /* loaded from: classes.dex */
    public class C1521a extends AbstractConnectionHandler {
        C1521a() {
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: b */
        public void onAuthSuccess(NvConnection nvConnection) {
            SearchDeviceActivity.logger.conditionalLog3((Object) "SearchDeviceActivity onAuthSuccess");
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: a */
        public void onBindSuccess(NvConnection nvConnection) {
            SearchDeviceActivity.logger.conditionalLog3((Object) "SearchDeviceActivity onBindSuccess");
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: a */
        public void mo3420a(NvConnection nvConnection, final int i, final NvError nvError) {
            SearchDeviceActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$a$UJhY8s7qzTyfoW45LD5IlIPYia4
                @Override // java.lang.Runnable
                public final void run() {
                    SearchDeviceActivity.C1521a.this.m3913a(i, nvError);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m3913a(int i, NvError nvError) {
            if (i != 16711682) {
                return;
            }
            SearchDeviceActivity.logger.log((Object) (SearchDeviceActivity.this.getString(R.string.authentication_failed) + nvError));
            if (nvError.m6630a() == 51) {
                SearchDeviceActivity searchDeviceActivity = SearchDeviceActivity.this;
                searchDeviceActivity.m3889a(searchDeviceActivity.getString(R.string.device_already_registered));
            } else if (nvError.m6630a() == 50) {
                SearchDeviceActivity searchDeviceActivity2 = SearchDeviceActivity.this;
                searchDeviceActivity2.m3889a(searchDeviceActivity2.getString(R.string.usb_not_ready));
            } else if (nvError.m6630a() != 48) {
                SearchDeviceActivity.this.m3889a(NvError.getType(nvError.m6630a()));
            } else {
                SearchDeviceActivity searchDeviceActivity3 = SearchDeviceActivity.this;
                searchDeviceActivity3.m3889a(searchDeviceActivity3.getString(R.string.IO_error));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.activities.SearchDeviceActivity$b */
    /* loaded from: classes.dex */
    public class C1522b extends AbstractGndStaDeviceItemUpdateHandler {
        C1522b() {
        }

        @Override // com.navatics.app.framework.AbstractGndStaDeviceItemUpdateHandler, com.navatics.app.framework.GroundStationDeviceItemUpdateHandler
        /* renamed from: a */
        public void onDeviceItemListUpdate(List<NvDeviceEntry> list) {
            SearchDeviceActivity.logger.conditionalLog((Object) "onDeviceItemListUpdate");
            SearchDeviceActivity.this.f3893e = list;
            SearchDeviceActivity.this.f3891c.m3912a(SearchDeviceActivity.this.f3893e);
            if (SearchDeviceActivity.this.f3893e != null && !SearchDeviceActivity.this.f3893e.isEmpty()) {
                SearchDeviceActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$b$TkLKejQBpJdD6LnM9QX-BR00oaI
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchDeviceActivity.C1522b.this.m3916c();
                    }
                });
            } else {
                SearchDeviceActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$SearchDeviceActivity$b$h5LeDulE-y_i0DPX6yhRmGjOJv0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchDeviceActivity.C1522b.this.searchDevices();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m3916c() {
            if (Navatics.getGroundStation() != null && SearchDeviceActivity.this.ivConnectingRotatingIcon.getVisibility() != 0) {
                SearchDeviceActivity searchDeviceActivity = SearchDeviceActivity.this;
                searchDeviceActivity.f3899k = ((NvDeviceEntry) searchDeviceActivity.f3893e.get(0)).m5167a().getSerialNumber();
                SearchDeviceActivity.this.rvDeviceList.setVisibility(0);
                SearchDeviceActivity.this.tvNoResult.setVisibility(4);
            }
            if (SearchDeviceActivity.this.f3893e.size() > 0) {
                SearchDeviceActivity.this.f3901m.removeMessages(33);
                if (!SearchDeviceActivity.this.avloadingAnimView.m5816a()) {
                    SearchDeviceActivity.this.avloadingAnimView.m5817b();
                }
            }
            SearchDeviceActivity.this.f3891c.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void searchDevices() {
            SearchDeviceActivity.this.rvDeviceList.setVisibility(4);
            SearchDeviceActivity.this.tvNoResult.setVisibility(0);
            SearchDeviceActivity.this.tvNoResult.setText("Searching, Please wait...");
        }
    }

    /* renamed from: com.navatics.app.activities.SearchDeviceActivity$d */
    /* loaded from: classes.dex */
    class HandlerC1524d extends Handler {

        /* renamed from: a */
        WeakReference<SearchDeviceActivity> f3909a;

        HandlerC1524d(SearchDeviceActivity searchDeviceActivity) {
            this.f3909a = new WeakReference<>(searchDeviceActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f3909a.get() != null && message.what == 33) {
                SearchDeviceActivity.this.tvNoResult.setText(SearchDeviceActivity.this.getString(R.string.no_device_found));
            }
        }
    }
}