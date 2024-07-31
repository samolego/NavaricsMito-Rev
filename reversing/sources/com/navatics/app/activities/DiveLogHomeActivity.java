package com.navatics.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.p008v4.app.FragmentActivity;
import android.support.p008v4.widget.SwipeRefreshLayout;
import android.support.p011v7.widget.LinearLayoutManager;
import android.support.p011v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.C0594b;
import com.bumptech.glide.ComponentCallbacks2C0668e;
import com.bumptech.glide.request.C1041g;
import com.example.divelog.dao.entity.CommandCard;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.navatics.app.framework.C2353p;
import com.navatics.app.framework.divelog.DiveLog;
import com.navatics.app.framework.divelog.DiveLog_;
import com.navatics.app.framework.divelog.SharedPreferences$OnSharedPreferenceChangeListenerC2239a;
import com.navatics.app.framework.p052d.C2211a;
import com.navatics.app.framework.user.C2374a;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.utils.C2464d;
import com.navatics.app.utils.C2468h;
import com.navatics.app.utils.C2477p;
import com.navatics.app.utils.C2478q;
import com.navatics.robot.utils.C2893f;
import com.navatics.robot.utils.C2906o;
import com.yanzhenjie.recyclerview.C3735i;
import com.yanzhenjie.recyclerview.C3737k;
import com.yanzhenjie.recyclerview.InterfaceC3731e;
import com.yanzhenjie.recyclerview.InterfaceC3733g;
import com.yanzhenjie.recyclerview.InterfaceC3736j;
import com.yanzhenjie.recyclerview.SwipeMenu;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import com.yanzhenjie.recyclerview.widget.DefaultItemDecoration;
import io.objectbox.Property;
import io.objectbox.android.HandlerC3807b;
import io.objectbox.p092b.InterfaceC3811a;
import io.objectbox.p092b.InterfaceC3814d;
import io.reactivex.disposables.InterfaceC3877b;
import io.reactivex.p093a.p095b.C3857a;
import io.reactivex.p096b.InterfaceC3868e;
import io.reactivex.p099e.C3880a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: classes.dex */
public class DiveLogHomeActivity extends NvBaseActivity implements SharedPreferences$OnSharedPreferenceChangeListenerC2239a.InterfaceC2250c {

    /* renamed from: c */
    private static final Logger f3539c = Logger.m1561a(DiveLogHomeActivity.class);

    /* renamed from: a */
    InterfaceC3877b f3540a;

    /* renamed from: b */
    InterfaceC3814d f3541b;
    @BindView
    ViewGroup containerEmptyLog;

    /* renamed from: d */
    private List f3542d;

    /* renamed from: e */
    private MyAdapter f3543e;

    /* renamed from: f */
    private SimpleDateFormat f3544f = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());

    /* renamed from: g */
    private InterfaceC3736j f3545g = new C19651();
    @BindView
    ImageView ivBottomRobotIcon;
    @BindView
    ImageView ivMediaLibraryIcon;
    @BindView
    ImageView ivUsrImg;
    @BindView
    SwipeRecyclerView lvDivelogList;
    @BindView
    SwipeRefreshLayout swipeLayout;
    @BindView
    TextView tvLogCount;
    @BindView
    TextView tvTotalTime;
    @BindView
    TextView tvUsrName;

    public static /* synthetic */ void lambda$2KMdmDVlAYOITZYg84ybvN9Mrrk(DiveLogHomeActivity diveLogHomeActivity, C2374a c2374a) {
        diveLogHomeActivity.m9418a(c2374a);
    }

    public static /* synthetic */ void lambda$5qcKblX7TNuhctaGZoujKKbZhGc(DiveLogHomeActivity diveLogHomeActivity, List list) {
        diveLogHomeActivity.m9417a(list);
    }

    public static /* synthetic */ void lambda$AP8M05JJzwLxKZTPkpDFufUlpDg(DiveLogHomeActivity diveLogHomeActivity, View view) {
        diveLogHomeActivity.m9421a(view);
    }

    /* renamed from: lambda$S3tTXr5_L-tJlYrwc3Sb8cllvYk */
    public static /* synthetic */ void m12973lambda$S3tTXr5_LtJlYrwc3Sb8cllvYk() {
        m9412e();
    }

    public static /* synthetic */ void lambda$ayhKnxBtN4PzxIgVUWU71uALn3Q(DiveLogHomeActivity diveLogHomeActivity) {
        diveLogHomeActivity.m9413d();
    }

    public static /* synthetic */ void lambda$x7H_xbkS_iZfEZhcdF88x2gTB3c(DiveLogHomeActivity diveLogHomeActivity, View view) {
        diveLogHomeActivity.m9416b(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MyAdapter extends RecyclerView.Adapter {

        /* renamed from: a */
        SimpleDateFormat f3552a = new SimpleDateFormat("MMM dd", Locale.ENGLISH);

        /* renamed from: b */
        SimpleDateFormat f3553b = new SimpleDateFormat("HH:mm", Locale.ENGLISH);

        /* loaded from: classes.dex */
        public class ViewHolder_ViewBinding implements Unbinder {

            /* renamed from: b */
            private ViewHolder f3556b;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.f3556b = viewHolder;
                viewHolder.tvDate = (TextView) C0594b.m12770a(view, R.id.tvDate, "field 'tvDate'", TextView.class);
                viewHolder.tvLocation = (TextView) C0594b.m12770a(view, R.id.tvLocation, "field 'tvLocation'", TextView.class);
                viewHolder.tvDuration = (TextView) C0594b.m12770a(view, R.id.tvDuration, "field 'tvDuration'", TextView.class);
            }

            @CallSuper
            /* renamed from: a */
            public void mo7438a() {
                ViewHolder viewHolder = this.f3556b;
                if (viewHolder == null) {
                    throw new IllegalStateException("Bindings already cleared.");
                }
                this.f3556b = null;
                viewHolder.tvDate = null;
                viewHolder.tvLocation = null;
                viewHolder.tvDuration = null;
            }
        }

        MyAdapter() {
        }

        @NonNull
        /* renamed from: a */
        public ViewHolder mo12941onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(DiveLogHomeActivity.this).inflate(R.layout.divelog_homepage_item2, viewGroup, false));
        }

        /* renamed from: a */
        public void mo9409a(@NonNull ViewHolder viewHolder, int i) {
            DiveLog diveLog = (DiveLog) DiveLogHomeActivity.m9420a(DiveLogHomeActivity.this).get(i);
            if (diveLog.getDate() == null) {
                viewHolder.tvDate.setText("Unknown");
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(diveLog.getDate());
                String m5848a = C2906o.m5848a(calendar.get(5));
                TextView textView = viewHolder.tvDate;
                textView.setText(this.f3552a.format(diveLog.getDate()) + m5848a);
            }
            String place = diveLog.getPlace();
            TextView textView2 = viewHolder.tvLocation;
            if (C2477p.m7356a(place)) {
                place = "";
            }
            textView2.setText(place);
            viewHolder.tvDuration.setText(this.f3553b.format(new Date(diveLog.getStartTime())));
        }

        public long getItemId(int i) {
            if (DiveLogHomeActivity.m9420a(DiveLogHomeActivity.this) == null) {
                return 0L;
            }
            return ((DiveLog) DiveLogHomeActivity.m9420a(DiveLogHomeActivity.this).get(i)).getId();
        }

        public int getItemCount() {
            return DiveLogHomeActivity.m9420a(DiveLogHomeActivity.this).size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView
            TextView tvDate;
            @BindView
            TextView tvDuration;
            @BindView
            TextView tvLocation;

            ViewHolder(View view) {
                super(view);
                ButterKnife.m12774a(this, view);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ List m9420a(DiveLogHomeActivity diveLogHomeActivity) {
        return diveLogHomeActivity.f3542d;
    }

    /* renamed from: b */
    static /* synthetic */ MyAdapter m9415b(DiveLogHomeActivity diveLogHomeActivity) {
        return diveLogHomeActivity.f3543e;
    }

    /* renamed from: com.navatics.app.activities.DiveLogHomeActivity$1 */
    /* loaded from: classes.dex */
    class C19651 implements InterfaceC3736j {
        C19651() {
        }

        /* renamed from: a */
        public void mo3794a(SwipeMenu swipeMenu, SwipeMenu swipeMenu2, int i) {
            swipeMenu2.m3856a(new C3737k(DiveLogHomeActivity.this).m3792a(R.drawable.delete_yellow).m3786c(C2893f.m5882a(DiveLogHomeActivity.this, 75.0f)).m3784d(-1).m3789b(R.drawable.log_delete_black));
        }
    }

    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (NvUserManager.m7829b().getUser() == null) {
            finish();
            return;
        }
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_divelog_home);
        ButterKnife.m12776a(this);
        this.ivBottomRobotIcon.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogHomeActivity$x7H_xbkS_iZfEZhcdF88x2gTB3c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiveLogHomeActivity.lambda$x7H_xbkS_iZfEZhcdF88x2gTB3c(DiveLogHomeActivity.this, view);
            }
        });
        this.ivMediaLibraryIcon.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogHomeActivity$AP8M05JJzwLxKZTPkpDFufUlpDg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiveLogHomeActivity.lambda$AP8M05JJzwLxKZTPkpDFufUlpDg(DiveLogHomeActivity.this, view);
            }
        });
        this.lvDivelogList.setSwipeItemMenuEnabled(true);
        this.lvDivelogList.setSwipeMenuCreator(this.f3545g);
        this.lvDivelogList.addItemDecoration(new DefaultItemDecoration(getResources().getColor(R.color.color_0000000), -1, C2893f.m5882a(this, 12.0f)));
        this.lvDivelogList.setOnItemMenuClickListener(new C19662());
        this.lvDivelogList.setOnItemClickListener(new C19683());
        this.f3543e = new MyAdapter();
        this.lvDivelogList.setVerticalScrollBarEnabled(false);
        this.lvDivelogList.setLayoutManager(new LinearLayoutManager(this));
        this.lvDivelogList.setAdapter(this.f3543e);
        SharedPreferences$OnSharedPreferenceChangeListenerC2239a.m8473b().addSyncListener(this);
        this.swipeLayout.setDistanceToTriggerSync(IjkMediaCodecInfo.RANK_SECURE);
        this.swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogHomeActivity$S3tTXr5_L-tJlYrwc3Sb8cllvYk
            @Override // android.support.p008v4.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                DiveLogHomeActivity.m12973lambda$S3tTXr5_LtJlYrwc3Sb8cllvYk();
            }
        });
        this.ivUsrImg.setOnClickListener(new View$OnClickListenerC19694());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m9416b(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m9421a(View view) {
        startActivity(new Intent(this, MediaLibraryActivity.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.activities.DiveLogHomeActivity$2 */
    /* loaded from: classes.dex */
    public class C19662 implements InterfaceC3733g {
        C19662() {
        }

        /* renamed from: a */
        public void mo3802a(C3735i c3735i, int i) {
            int m3795a = c3735i.m3795a();
            DiveLog diveLog = (DiveLog) DiveLogHomeActivity.m9420a(DiveLogHomeActivity.this).get(i);
            if (m3795a == 0) {
                diveLog.setFakeDelete(true);
                diveLog.save();
                CommandCard builder = CommandCard.builder(new Date());
                C2211a.m8554a((DiveLog) DiveLogHomeActivity.m9420a(DiveLogHomeActivity.this).get(i), builder.setStartTime(((DiveLog) DiveLogHomeActivity.m9420a(DiveLogHomeActivity.this).get(i)).getStartTime() + "").setCommand(CommandCard.DELETE)).m3072b(C3880a.m3214b()).m3088a(C3857a.m3247a()).m3068c(new C19671(diveLog));
                DiveLogHomeActivity.m9420a(DiveLogHomeActivity.this).remove(i);
                DiveLogHomeActivity.m9415b(DiveLogHomeActivity.this).notifyItemRemoved(i);
            }
        }

        /* renamed from: com.navatics.app.activities.DiveLogHomeActivity$2$1 */
        /* loaded from: classes.dex */
        class C19671 implements InterfaceC3868e {

            /* renamed from: a */
            final /* synthetic */ DiveLog f3548a;

            C19671(DiveLog diveLog) {
                this.f3548a = diveLog;
            }

            /* renamed from: a */
            public void mo9497a(Boolean bool) throws Exception {
                if (bool.booleanValue()) {
                    this.f3548a.delete();
                }
            }
        }
    }

    /* renamed from: com.navatics.app.activities.DiveLogHomeActivity$3 */
    /* loaded from: classes.dex */
    class C19683 implements InterfaceC3731e {
        C19683() {
        }

        /* renamed from: a */
        public void mo3804a(View view, int i) {
            DiveLog diveLog = (DiveLog) DiveLogHomeActivity.m9420a(DiveLogHomeActivity.this).get(i);
            Intent intent = new Intent(DiveLogHomeActivity.this, DiveLogActivity.class);
            Bundle bundle = new Bundle();
            Log.i("info1", "onCreate: KEY_DIVELOG_ID key_divelog_id" + diveLog.getId());
            bundle.putLong("key_divelog_id", diveLog.getId());
            intent.putExtras(bundle);
            C2464d.m7404a(diveLog);
            DiveLogHomeActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ void m9412e() {
        SharedPreferences$OnSharedPreferenceChangeListenerC2239a.m8473b().m8461g();
    }

    /* renamed from: com.navatics.app.activities.DiveLogHomeActivity$4 */
    /* loaded from: classes.dex */
    class View$OnClickListenerC19694 implements View.OnClickListener {
        View$OnClickListenerC19694() {
        }

        public void onClick(View view) {
            C2468h.m7390a((Activity) DiveLogHomeActivity.this);
        }
    }

    protected void onStart() {
        super.onStart();
        NvUser user = NvUserManager.m7829b().getUser();
        if (user == null) {
            finish();
            return;
        }
        SharedPreferences$OnSharedPreferenceChangeListenerC2239a.m8473b().addSyncListener(this);
        this.f3540a = NvUserManager.m7829b().m7792i().m3072b(C3880a.m3214b()).m3088a(C3857a.m3247a()).m3104a(new InterfaceC3868e() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogHomeActivity$2KMdmDVlAYOITZYg84ybvN9Mrrk
            @Override // io.reactivex.p096b.InterfaceC3868e
            /* renamed from: accept */
            public final void mo9497a(Object obj) {
                DiveLogHomeActivity.lambda$2KMdmDVlAYOITZYg84ybvN9Mrrk(DiveLogHomeActivity.this, (C2374a) obj);
            }
        }, C$$Lambda$e27Kr4VJxN1zC_AGmQwWE7CADQ.INSTANCE);
        this.f3541b = C2353p.m7934f().m3470d(DiveLog.class).m3412e().m3287a(DiveLog_.email, user.getEmail()).m3286a((Property) DiveLog_.fakeDelete, false).m3289a((Property) DiveLog_.startTime, 1).m3285b().m3296f().m3358a(HandlerC3807b.m3378a()).m3359a(new InterfaceC3811a() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogHomeActivity$5qcKblX7TNuhctaGZoujKKbZhGc
            @Override // io.objectbox.p092b.InterfaceC3811a
            /* renamed from: onData */
            public final void mo3273a(Object obj) {
                DiveLogHomeActivity.lambda$5qcKblX7TNuhctaGZoujKKbZhGc(DiveLogHomeActivity.this, (List) obj);
            }
        });
    }

    protected void onStop() {
        super.onStop();
        SharedPreferences$OnSharedPreferenceChangeListenerC2239a.m8473b().removeSyncListener(this);
        InterfaceC3877b interfaceC3877b = this.f3540a;
        if (interfaceC3877b != null && !interfaceC3877b.isDisposed()) {
            this.f3540a.dispose();
        }
        InterfaceC3814d interfaceC3814d = this.f3541b;
        if (interfaceC3814d == null || interfaceC3814d.mo3364b()) {
            return;
        }
        this.f3541b.mo3366a();
    }

    /* renamed from: a */
    public void mo8444a() {
        runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogHomeActivity$ayhKnxBtN4PzxIgVUWU71uALn3Q
            @Override // java.lang.Runnable
            public final void run() {
                DiveLogHomeActivity.lambda$ayhKnxBtN4PzxIgVUWU71uALn3Q(DiveLogHomeActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m9413d() {
        this.swipeLayout.setRefreshing(true);
    }

    protected NvBaseActivity.C1917a onCreateConfig() {
        return new NvBaseActivity.C1917a.C1918a().m9544a(true).m9543b();
    }

    /* renamed from: b */
    public void mo8443b() {
        this.swipeLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9418a(C2374a c2374a) {
        switch (c2374a.m7778b()) {
            case 0:
                finish();
                return;
            case 1:
            case 2:
                m9419a(c2374a.m7779a());
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m9419a(NvUser nvUser) {
        if (nvUser != null) {
            ComponentCallbacks2C0668e.m12493a((FragmentActivity) this).mo8811b(nvUser.getUsrImgLowres() + "?token=" + nvUser.getToken()).mo8818b(C1041g.m11657a().mo9522c(R.drawable.ic_launcher_round).mo9521c(new C2478q(NvUserManager.m7829b().m7800f()))).m12421a(this.ivUsrImg);
            this.tvUsrName.setText(nvUser.getNickName());
            return;
        }
        f3539c.mo1496d("updateUI user is null ");
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* renamed from: c */
    private void m9414c() {
        this.containerEmptyLog.setVisibility(0);
        this.swipeLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9417a(List list) {
        String format;
        Logger logger = f3539c;
        StringBuilder sb = new StringBuilder();
        sb.append("diveLogList count ");
        sb.append(list == null ? 0 : list.size());
        logger.mo1508a((Object) sb.toString());
        if (list == null || list.size() == 0) {
            m9414c();
            return;
        }
        int size = list.size();
        if (size < 10) {
            format = String.format(Locale.getDefault(), "# %2d", Integer.valueOf(size));
        } else {
            format = String.format(Locale.getDefault(), "# %d", Integer.valueOf(size));
        }
        this.tvLogCount.setText(format);
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            DiveLog diveLog = (DiveLog) it.next();
            if (diveLog.getEndTime() - diveLog.getStartTime() < 0) {
                f3539c.mo1508a((Object) ("divelog #" + diveLog.getId() + ", start " + diveLog.getStartTime() + ", end " + diveLog.getEndTime()));
                it.remove();
            } else {
                j += diveLog.getEndTime() - diveLog.getStartTime();
            }
        }
        f3539c.mo1508a((Object) ("totalDuration " + j));
        this.tvTotalTime.setText(String.format(Locale.getDefault(), "%dh%dmin", Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(j)))));
        this.containerEmptyLog.setVisibility(8);
        this.swipeLayout.setVisibility(0);
        this.f3542d = list;
        f3539c.mo1508a((Object) ("mDiveLogList count : " + this.f3542d.size()));
        this.f3543e.notifyDataSetChanged();
    }
}
