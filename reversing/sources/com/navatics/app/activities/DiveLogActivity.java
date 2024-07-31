package com.navatics.app.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomSheetDialog;
import android.support.p008v4.app.FragmentActivity;
import android.support.p008v4.view.PagerAdapter;
import android.support.p008v4.view.ViewPager;
import android.text.Html;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.divelog.dao.entity.CommandCard;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.gson.JsonObject;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.navatics.app.framework.Settings;
import com.navatics.app.framework.divelog.DiveLog;
import com.navatics.app.framework.divelog.EntryWrapper;
import com.navatics.app.framework.p052d.DiveLogBuildHelper;
import com.navatics.app.utils.CurrentDiveLogHolder;
import com.navatics.app.utils.ImageUtils;
import com.navatics.app.utils.StringUtils;
import com.navatics.app.widget.DivelogDiagram;
import com.navatics.dsbridge.DWebView;
import com.navatics.nvtsshare.NvtsShare;
import com.navatics.robot.utils.TimeUtils;
import com.stx.xhb.commontitlebar.CustomTitleBar;
import io.reactivex.p096b.Consumer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class DiveLogActivity extends StatusBarLightActivity {

    /* renamed from: d */
    private static final C3044k f3518d = C3044k.m1564a(DiveLogActivity.class);

    /* renamed from: a */
    ImageView f3519a;

    /* renamed from: b */
    ImageView f3520b;
    @BindView
    Button btnAddNote;

    /* renamed from: c */
    JsApi f3521c;
    @BindView
    ViewPager divelogBanner;
    @BindView
    ImageView divelogCoverPic;
    @BindView
    DivelogDiagram divelogDiagram;

    /* renamed from: f */
    private ImageHistAdapter f3523f;

    /* renamed from: g */
    private boolean f3524g;

    /* renamed from: h */
    private View f3525h;

    /* renamed from: i */
    private List<EntryWrapper> f3526i;
    @BindView
    ViewGroup mapContainer;
    @BindView
    DWebView mapWebView;
    @BindView
    RelativeLayout noteContainer;
    @BindView
    ScrollView scrollView;
    @BindView
    CustomTitleBar titlebar;
    @BindView
    TextView tvNote;

    /* renamed from: e */
    private int f3522e = 2;

    /* renamed from: j */
    private RequestOptions f3527j = new RequestOptions().mo9551a(R.mipmap.ic_launcher).mo9542b(R.mipmap.ic_launcher).mo9521g();

    /* renamed from: lambda$8art-hDm20KKlc2-Wa60MLOXFeY */
    public static /* synthetic */ void m12969lambda$8arthDm20KKlc2Wa60MLOXFeY(DiveLogActivity diveLogActivity, View view) {
        diveLogActivity.m9453b(view);
    }

    public static /* synthetic */ void lambda$DcBLRAL4FJ1vEgtga3dtoKmmLu8(BottomSheetDialog bottomSheetDialog, View view) {
        bottomSheetDialog.dismiss();
    }

    /* renamed from: lambda$GOn3aOIa0KcU4-X07h3sJV3a_sA */
    public static /* synthetic */ void m12970lambda$GOn3aOIa0KcU4X07h3sJV3a_sA(DiveLogActivity diveLogActivity, BottomSheetDialog bottomSheetDialog, View view) {
        diveLogActivity.m9450c(bottomSheetDialog, view);
    }

    public static /* synthetic */ void lambda$VHDG9DfYneayhyq1vE0q63mkcqw(DiveLogActivity diveLogActivity, View view) {
        diveLogActivity.m9462a(view);
    }

    public static /* synthetic */ void lambda$YkbEHZDDrPmQ2a9d2LudYxpLA6c(DiveLogActivity diveLogActivity, View view) {
        diveLogActivity.m9443e(view);
    }

    public static /* synthetic */ void lambda$cRoQRlJWPBH9Qw0OsB0us3KdlKQ(DiveLogActivity diveLogActivity, View view) {
        diveLogActivity.m9446d(view);
    }

    public static /* synthetic */ void lambda$iX61WSzzm1BOjHASeD75OAWBNBs(DiveLogActivity diveLogActivity) {
        diveLogActivity.m9433n();
    }

    public static /* synthetic */ void lambda$mTW7LSHmQurPqiybgQWIlYrfsPM(DiveLogActivity diveLogActivity, BottomSheetDialog bottomSheetDialog, View view) {
        diveLogActivity.m9444e(bottomSheetDialog, view);
    }

    public static /* synthetic */ void lambda$pOOmZVMMlHBJCyF9aBXD7pQUTxs(DiveLogActivity diveLogActivity, View view) {
        diveLogActivity.m9449c(view);
    }

    /* renamed from: lambda$tRlr_Oj87D8-QZc3xRmAdasokxs */
    public static /* synthetic */ void m12971lambda$tRlr_Oj87D8QZc3xRmAdasokxs(DiveLogActivity diveLogActivity, View view) {
        diveLogActivity.m9441f(view);
    }

    public static /* synthetic */ void lambda$uQYXTLoSF45AFiQQbeBgAx2p3Oc(DiveLogActivity diveLogActivity, BottomSheetDialog bottomSheetDialog, View view) {
        diveLogActivity.m9454b(bottomSheetDialog, view);
    }

    /* renamed from: lambda$yedtYTdgbK8JKynw8Tj-jIUrlVI */
    public static /* synthetic */ void m12972lambda$yedtYTdgbK8JKynw8TjjIUrlVI(DiveLogActivity diveLogActivity, BottomSheetDialog bottomSheetDialog, View view) {
        diveLogActivity.m9447d(bottomSheetDialog, view);
    }

    /* loaded from: classes.dex */
    public class ImageHistAdapter extends PagerAdapter {

        /* renamed from: b */
        private LinkedList<View> f3533b = new LinkedList<>();

        /* renamed from: c */
        private List<EntryWrapper> f3534c;

        @Override // android.support.p008v4.view.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }

        /* loaded from: classes.dex */
        public class ViewHolder_ViewBinding implements Unbinder {

            /* renamed from: b */
            private ViewHolder f3536b;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.f3536b = viewHolder;
                viewHolder.image = (ImageView) Utils.m12799a(view, R.id.bannerImage, "field 'image'", ImageView.class);
            }

            @Override // butterknife.Unbinder
            @CallSuper
            /* renamed from: a */
            public void mo7436a() {
                ViewHolder viewHolder = this.f3536b;
                if (viewHolder == null) {
                    throw new IllegalStateException("Bindings already cleared.");
                }
                this.f3536b = null;
                viewHolder.image = null;
            }
        }

        ImageHistAdapter() {
            DiveLogActivity.this = r1;
        }

        /* renamed from: a */
        public void m9431a(List<EntryWrapper> list) {
            this.f3534c = list;
            if (this.f3534c != null) {
                C3044k c3044k = DiveLogActivity.f3518d;
                c3044k.mo1511a((Object) ("gallery data size : " + list.size()));
                notifyDataSetChanged();
            }
        }

        @Override // android.support.p008v4.view.PagerAdapter
        public int getCount() {
            List<EntryWrapper> list = this.f3534c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.support.p008v4.view.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            View removeFirst;
            ViewHolder viewHolder;
            if (this.f3533b.size() == 0) {
                removeFirst = LayoutInflater.from(DiveLogActivity.this).inflate(R.layout.divelog_banner_item, (ViewGroup) null, false);
                viewHolder = new ViewHolder(removeFirst);
                removeFirst.setTag(viewHolder);
            } else {
                removeFirst = this.f3533b.removeFirst();
                viewHolder = (ViewHolder) removeFirst.getTag();
            }
            Glide.m12521a((FragmentActivity) DiveLogActivity.this).mo8814a(CurrentDiveLogHolder.m7403a().getEntries().get(this.f3534c.get(i).f4443a).getPhotoUri()).mo8828a(DiveLogActivity.this.f3527j).m12449a(viewHolder.image);
            viewGroup.addView(removeFirst, -1, -1);
            return removeFirst;
        }

        @Override // android.support.p008v4.view.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            View view = (View) obj;
            viewGroup.removeView(view);
            this.f3533b.add(view);
        }

        /* loaded from: classes.dex */
        class ViewHolder {
            @BindView
            ImageView image;

            public ViewHolder(View view) {
                ImageHistAdapter.this = r1;
                ButterKnife.m12803a(this, view);
            }
        }
    }

    /* renamed from: com.navatics.app.activities.DiveLogActivity$a */
    /* loaded from: classes.dex */
    class C1561a implements DivelogDiagram.InterfaceC1918a, DivelogDiagram.InterfaceC1919b {
        @Override // com.navatics.app.widget.DivelogDiagram.InterfaceC1918a
        /* renamed from: a */
        public void mo7305a(DivelogDiagram divelogDiagram) {
        }

        @Override // com.navatics.app.widget.DivelogDiagram.InterfaceC1918a
        /* renamed from: c */
        public void mo7303c(DivelogDiagram divelogDiagram) {
        }

        C1561a() {
            DiveLogActivity.this = r1;
        }

        @Override // com.navatics.app.widget.DivelogDiagram.InterfaceC1918a
        /* renamed from: b */
        public void mo7304b(DivelogDiagram divelogDiagram) {
            DiveLogActivity.this.f3526i = divelogDiagram.getEntryWrapperListHasPic();
            DiveLogActivity diveLogActivity = DiveLogActivity.this;
            diveLogActivity.m9456a(diveLogActivity.divelogDiagram.getCurDivelog());
        }

        @Override // com.navatics.app.widget.DivelogDiagram.InterfaceC1919b
        /* renamed from: a */
        public void mo7302a(ILineDataSet iLineDataSet, Entry entry) {
            int entryIndex = iLineDataSet.getEntryIndex(entry);
            int m9466a = DiveLogActivity.this.m9466a(entryIndex);
            if (entryIndex < 0) {
                return;
            }
            DiveLogActivity.this.divelogBanner.setCurrentItem(m9466a, true);
        }
    }

    @Override // com.navatics.app.activities.StatusBarLightActivity
    /* renamed from: e_ */
    protected int mo9030e_() {
        return Color.parseColor("#EFEFEF");
    }

    @Override // com.navatics.app.activities.StatusBarLightActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_divelog);
        ButterKnife.m12805a(this);
        long m9464a = m9464a(getIntent().getExtras());
        if (m9464a == -1) {
            C3044k c3044k = f3518d;
            c3044k.mo1504b((Object) ("invalid divelog id : " + m9464a));
            finish();
            return;
        }
        m9439h();
        m9435l();
        m9434m();
        m9451c();
        this.divelogDiagram.setDivelogId(m9464a);
        C1561a c1561a = new C1561a();
        this.divelogDiagram.setOnDataUpdateListener(c1561a);
        this.divelogDiagram.setOnSelectedItemChangedListener(c1561a);
        this.scrollView.post(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogActivity$iX61WSzzm1BOjHASeD75OAWBNBs
            @Override // java.lang.Runnable
            public final void run() {
                DiveLogActivity.lambda$iX61WSzzm1BOjHASeD75OAWBNBs(DiveLogActivity.this);
            }
        });
    }

    /* renamed from: n */
    public /* synthetic */ void m9433n() {
        this.scrollView.fullScroll(33);
    }

    /* renamed from: c */
    private void m9451c() {
        this.btnAddNote.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogActivity$tRlr_Oj87D8-QZc3xRmAdasokxs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiveLogActivity.m12971lambda$tRlr_Oj87D8QZc3xRmAdasokxs(DiveLogActivity.this, view);
            }
        });
        this.tvNote.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogActivity$YkbEHZDDrPmQ2a9d2LudYxpLA6c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiveLogActivity.lambda$YkbEHZDDrPmQ2a9d2LudYxpLA6c(DiveLogActivity.this, view);
            }
        });
    }

    /* renamed from: f */
    public /* synthetic */ void m9441f(View view) {
        startActivity(new Intent(this, AddDiveNoteActivity.class));
    }

    /* renamed from: e */
    public /* synthetic */ void m9443e(View view) {
        m9448d();
    }

    /* renamed from: d */
    private void m9448d() {
        if (this.f3524g) {
            this.noteContainer.removeView(this.f3525h);
        } else {
            if (this.f3525h == null) {
                this.f3525h = getLayoutInflater().inflate(R.layout.divelog_note_edit_btn, (ViewGroup) null);
                this.f3519a = (ImageView) this.f3525h.findViewById(R.id.ivDelNote);
                this.f3519a.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogActivity$cRoQRlJWPBH9Qw0OsB0us3KdlKQ
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DiveLogActivity.lambda$cRoQRlJWPBH9Qw0OsB0us3KdlKQ(DiveLogActivity.this, view);
                    }
                });
                this.f3520b = (ImageView) this.f3525h.findViewById(R.id.ivEditNote);
                this.f3520b.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogActivity$pOOmZVMMlHBJCyF9aBXD7pQUTxs
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DiveLogActivity.lambda$pOOmZVMMlHBJCyF9aBXD7pQUTxs(DiveLogActivity.this, view);
                    }
                });
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, this.tvNote.getId());
            layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, 18.0f, getResources().getDisplayMetrics()), 0, (int) TypedValue.applyDimension(1, 17.0f, getResources().getDisplayMetrics()));
            this.noteContainer.addView(this.f3525h, layoutParams);
        }
        this.f3524g = !this.f3524g;
    }

    /* renamed from: d */
    public /* synthetic */ void m9446d(View view) {
        final DiveLog m7403a = CurrentDiveLogHolder.m7403a();
        if (m7403a == null || StringUtils.m7354a(m7403a.getComment())) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("comment", " ");
        CommandCard filedName = CommandCard.builder().setCommand(CommandCard.UPDATE).setFiledName("comment");
        DiveLogBuildHelper.m8553a(m7403a, filedName.setStartTime(m7403a.getStartTime() + "").setCreateTime(new Date()).setJson(jsonObject.toString())).m3071c(new Consumer<Boolean>() { // from class: com.navatics.app.activities.DiveLogActivity.1
            {
                DiveLogActivity.this = this;
            }

            @Override // io.reactivex.p096b.Consumer
            /* renamed from: a */
            public void accept(Boolean bool) throws Exception {
                if (bool.booleanValue()) {
                    m7403a.setComment(null);
                    m7403a.save();
                }
            }
        });
    }

    /* renamed from: c */
    public /* synthetic */ void m9449c(View view) {
        startActivity(new Intent(this, AddDiveNoteActivity.class));
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m9445e();
    }

    /* renamed from: e */
    private void m9445e() {
        DiveLog m7403a = CurrentDiveLogHolder.m7403a();
        if (StringUtils.m7354a(m7403a.getComment())) {
            m9442f();
            return;
        }
        this.tvNote.setText(m7403a.getComment());
        m9440g();
    }

    /* renamed from: a */
    public int m9466a(int i) {
        for (int i2 = 0; i2 < this.f3526i.size(); i2++) {
            if (this.f3526i.get(i2).f4443a == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private long m9464a(Bundle bundle) {
        if (bundle == null) {
            return -1L;
        }
        return bundle.getLong("key_divelog_id", -1L);
    }

    /* renamed from: a */
    public void m9456a(DiveLog diveLog) {
        CurrentDiveLogHolder.m7402a(diveLog);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd", Locale.ENGLISH);
        CustomTitleBar customTitleBar = (CustomTitleBar) findViewById(R.id.titlebar);
        if (diveLog.getDate() != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(diveLog.getDate());
            String m5853a = TimeUtils.m5853a(calendar.get(5));
            customTitleBar.m5604a(simpleDateFormat.format(diveLog.getDate()) + m5853a).setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            customTitleBar.m5604a("Unknown").setTypeface(Typeface.DEFAULT_BOLD);
        }
        String place = diveLog.getPlace();
        if (StringUtils.m7354a(place)) {
            place = "";
        } else if (place.contains("null")) {
            place = place.replace(",", "").replace(", ", "").replace("null", "");
        }
        customTitleBar.setSubTitle(place);
        List<EntryWrapper> list = this.f3526i;
        if (list == null || list.isEmpty()) {
            this.divelogCoverPic.setVisibility(0);
            this.divelogBanner.setVisibility(8);
        } else {
            this.divelogCoverPic.setVisibility(8);
            this.divelogBanner.setVisibility(0);
        }
        this.f3523f.m9431a(this.f3526i);
        if (StringUtils.m7354a(diveLog.getComment())) {
            if (this.f3524g) {
                m9448d();
            }
            m9442f();
        } else {
            m9440g();
        }
        if (!StringUtils.m7354a(diveLog.getLongitude()) && !StringUtils.m7354a(diveLog.getLatitude())) {
            this.mapContainer.setVisibility(0);
            this.f3521c.m8974a(diveLog.getLongitude());
            this.f3521c.m8973b(diveLog.getLatitude());
            this.f3521c.m8975a();
            return;
        }
        this.mapContainer.setVisibility(8);
    }

    /* renamed from: f */
    private void m9442f() {
        this.btnAddNote.setVisibility(0);
        this.btnAddNote.setFocusable(true);
        this.tvNote.setVisibility(4);
        this.tvNote.setFocusable(false);
    }

    /* renamed from: g */
    private void m9440g() {
        this.btnAddNote.setVisibility(4);
        this.btnAddNote.setFocusable(false);
        this.tvNote.setVisibility(0);
        this.tvNote.setFocusable(true);
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DWebView dWebView = this.mapWebView;
        if (dWebView != null) {
            dWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.mapWebView.clearHistory();
            ((ViewGroup) this.mapWebView.getParent()).removeView(this.mapWebView);
            this.mapWebView.destroy();
            this.mapWebView = null;
        }
    }

    /* renamed from: h */
    private void m9439h() {
        CustomTitleBar customTitleBar = (CustomTitleBar) findViewById(R.id.titlebar);
        customTitleBar.m5603b().setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogActivity$8art-hDm20KKlc2-Wa60MLOXFeY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiveLogActivity.m12969lambda$8arthDm20KKlc2Wa60MLOXFeY(DiveLogActivity.this, view);
            }
        });
        customTitleBar.m5608a(R.drawable.divelog_share, R.id.topbar_right_button).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogActivity$VHDG9DfYneayhyq1vE0q63mkcqw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiveLogActivity.lambda$VHDG9DfYneayhyq1vE0q63mkcqw(DiveLogActivity.this, view);
            }
        });
        if (Build.VERSION.SDK_INT >= 24) {
            customTitleBar.m5604a(Html.fromHtml("<b>2018.06.09</b>", 0).toString());
        } else {
            customTitleBar.m5604a(Html.fromHtml("<b>2018.06.09</b>").toString());
        }
        customTitleBar.setSubTitle("Tulamben, Indonesia");
    }

    /* renamed from: b */
    public /* synthetic */ void m9453b(View view) {
        finish();
    }

    /* renamed from: a */
    public /* synthetic */ void m9462a(View view) {
        m9438i();
    }

    /* renamed from: i */
    private void m9438i() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View inflate = getLayoutInflater().inflate(R.layout.share_panel_layout, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.ivFacebook)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogActivity$mTW7LSHmQurPqiybgQWIlYrfsPM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiveLogActivity.lambda$mTW7LSHmQurPqiybgQWIlYrfsPM(DiveLogActivity.this, bottomSheetDialog, view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.ivTwitter)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogActivity$yedtYTdgbK8JKynw8Tj-jIUrlVI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiveLogActivity.m12972lambda$yedtYTdgbK8JKynw8TjjIUrlVI(DiveLogActivity.this, bottomSheetDialog, view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.tvInstagram)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogActivity$GOn3aOIa0KcU4-X07h3sJV3a_sA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiveLogActivity.m12970lambda$GOn3aOIa0KcU4X07h3sJV3a_sA(DiveLogActivity.this, bottomSheetDialog, view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.ivWeChat)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogActivity$uQYXTLoSF45AFiQQbeBgAx2p3Oc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiveLogActivity.lambda$uQYXTLoSF45AFiQQbeBgAx2p3Oc(DiveLogActivity.this, bottomSheetDialog, view);
            }
        });
        ((ImageButton) inflate.findViewById(R.id.btnCancel)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$DiveLogActivity$DcBLRAL4FJ1vEgtga3dtoKmmLu8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiveLogActivity.lambda$DcBLRAL4FJ1vEgtga3dtoKmmLu8(BottomSheetDialog.this, view);
            }
        });
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.show();
    }

    /* renamed from: e */
    public /* synthetic */ void m9444e(BottomSheetDialog bottomSheetDialog, View view) {
        String m9437j = m9437j();
        if (m9437j == null) {
            return;
        }
        NvtsShare.m6614a(this).m6589d().m6596a(m9437j).m6602a(this).mo6594a();
        bottomSheetDialog.dismiss();
    }

    /* renamed from: d */
    public /* synthetic */ void m9447d(BottomSheetDialog bottomSheetDialog, View view) {
        String m9437j = m9437j();
        if (m9437j == null) {
            return;
        }
        NvtsShare.m6614a(this).m6591b().m6597a(m9437j).mo6594a();
        bottomSheetDialog.dismiss();
    }

    /* renamed from: c */
    public /* synthetic */ void m9450c(BottomSheetDialog bottomSheetDialog, View view) {
        String m9437j = m9437j();
        if (m9437j == null) {
            return;
        }
        NvtsShare.m6614a(this).m6590c().m6596a(m9437j).mo6594a();
        bottomSheetDialog.dismiss();
    }

    /* renamed from: b */
    public /* synthetic */ void m9454b(BottomSheetDialog bottomSheetDialog, View view) {
        String m9437j = m9437j();
        if (m9437j == null) {
            return;
        }
        NvtsShare.m6614a(this).m6592a().m6597a(m9437j).mo6594a();
        bottomSheetDialog.dismiss();
    }

    /* renamed from: j */
    private String m9437j() {
        Bitmap m9465a = m9465a(m9436k(), m9461a((ViewGroup) this.scrollView));
        if (m9465a == null) {
            Toast.makeText(this, (int) R.string.capture_error, 0).show();
            return null;
        }
        String m8605g = Settings.m8618a().m8605g();
        if (TextUtils.isEmpty(m8605g)) {
            Toast.makeText(this, (int) R.string.capture_error, 0).show();
            return null;
        }
        String m7392a = ImageUtils.m7392a(this, m9465a, m8605g, ImageUtils.m7390a(m8605g));
        if (m7392a != null) {
            return m7392a;
        }
        Toast.makeText(this, (int) R.string.capture_error, 0).show();
        return null;
    }

    @Override // com.navatics.app.NvBaseActivity
    protected NvBaseActivity.C1517a onCreateConfig() {
        return new NvBaseActivity.C1517a.C1518a().m9565a(true).m9564b();
    }

    /* renamed from: k */
    private Bitmap m9436k() {
        Bitmap createBitmap = Bitmap.createBitmap(this.titlebar.getWidth(), this.titlebar.getHeight(), Bitmap.Config.ARGB_8888);
        this.titlebar.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* renamed from: a */
    private Bitmap m9461a(ViewGroup viewGroup) {
        int i = 0;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            i += viewGroup.getChildAt(i2).getHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getWidth(), i, Bitmap.Config.ARGB_8888);
        viewGroup.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* renamed from: a */
    private Bitmap m9465a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight() + bitmap2.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, 0.0f, bitmap.getHeight(), (Paint) null);
        return createBitmap;
    }

    /* renamed from: l */
    private void m9435l() {
        this.f3523f = new ImageHistAdapter();
        this.divelogBanner.setOffscreenPageLimit(4);
        this.divelogBanner.setAdapter(this.f3523f);
        this.divelogBanner.setCurrentItem(this.f3522e);
        this.divelogBanner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.navatics.app.activities.DiveLogActivity.2
            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            {
                DiveLogActivity.this = this;
            }

            @Override // android.support.p008v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                DiveLogActivity.this.f3522e = i;
            }
        });
    }

    /* renamed from: m */
    private void m9434m() {
        DWebView.setWebContentsDebuggingEnabled(true);
        this.f3521c = new JsApi(this.mapWebView);
        this.mapWebView.m6800a(this.f3521c, (String) null);
        this.mapWebView.loadUrl("file:///android_asset/divelog_map.html");
        this.mapWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.navatics.app.activities.DiveLogActivity.3
            {
                DiveLogActivity.this = this;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ((DWebView) view).requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }
}
