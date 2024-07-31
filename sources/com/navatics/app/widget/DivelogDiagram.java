package com.navatics.app.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.RequestOptions;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.navatics.app.R;
import com.navatics.app.activities.MyLineChartRenderer;
import com.navatics.app.activities.MyYAxisRenderer;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.RobotStatus;
import com.navatics.app.framework.divelog.DiveLog;
import com.navatics.app.framework.divelog.DiveLogEntry;
import com.navatics.app.framework.divelog.DiveLog_;
import com.navatics.app.framework.divelog.EntryWrapper;
import com.navatics.app.framework.international.InternationalTextView;
import com.navatics.app.utils.CircleCropWithBorder;
import com.navatics.app.utils.MyChartHighlighter;
import com.navatics.app.widget.DivelogDiagram;
import com.navatics.app.widget.DivelogSeekbar;
import com.navatics.robot.utils.DpiUtils;
import io.objectbox.p092b.DataObserver;
import io.objectbox.p092b.DataSubscription;
import io.objectbox.relation.ToMany;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.Function;
import io.reactivex.p096b.InterfaceC2848a;
import io.reactivex.p099e.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class DivelogDiagram extends RelativeLayout {

    /* renamed from: a */
    private static final C3044k f5192a = C3044k.m1564a(DivelogDiagram.class);

    /* renamed from: b */
    private long f5193b;

    /* renamed from: c */
    private DiveLog f5194c;

    /* renamed from: d */
    private DataSubscription f5195d;

    /* renamed from: e */
    private boolean f5196e;

    /* renamed from: f */
    private LineChart f5197f;

    /* renamed from: g */
    private MyChartHighlighter f5198g;

    /* renamed from: h */
    private List<EntryWrapper> f5199h;

    /* renamed from: i */
    private List<EntryWrapper> f5200i;

    /* renamed from: j */
    private int f5201j;

    /* renamed from: k */
    private InterfaceC1919b f5202k;

    /* renamed from: l */
    private InterfaceC1918a f5203l;

    /* renamed from: m */
    private int f5204m;

    /* renamed from: n */
    private TextView f5205n;

    /* renamed from: o */
    private InternationalTextView f5206o;

    /* renamed from: p */
    private InternationalTextView f5207p;

    /* renamed from: q */
    private InternationalTextView f5208q;

    /* renamed from: r */
    private DivelogSeekbar f5209r;

    /* renamed from: s */
    private Paint f5210s;

    /* renamed from: t */
    private Paint f5211t;

    /* renamed from: u */
    private Rect f5212u;

    /* renamed from: v */
    private CompositeDisposable f5213v;

    /* renamed from: com.navatics.app.widget.DivelogDiagram$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1918a {
        /* renamed from: a */
        void mo7305a(DivelogDiagram divelogDiagram);

        /* renamed from: b */
        void mo7304b(DivelogDiagram divelogDiagram);

        /* renamed from: c */
        void mo7303c(DivelogDiagram divelogDiagram);
    }

    /* renamed from: com.navatics.app.widget.DivelogDiagram$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1919b {
        /* renamed from: a */
        void mo7302a(ILineDataSet iLineDataSet, Entry entry);
    }

    /* renamed from: lambda$BXKeMQU2as1RvLgW-yaR7b1MDv8 */
    public static /* synthetic */ List m13098lambda$BXKeMQU2as1RvLgWyaR7b1MDv8(DivelogDiagram divelogDiagram, List list) {
        return divelogDiagram.m7317b(list);
    }

    public static /* synthetic */ void lambda$Boc0NvuO0GsO8sqD_EJneYXNs3U(DivelogDiagram divelogDiagram) {
        divelogDiagram.m7307g();
    }

    public static /* synthetic */ ObservableSource lambda$DWgUZM5WjN4YUYs8_zGq_LS_GAU(DivelogDiagram divelogDiagram, List list) {
        return divelogDiagram.m7314c(list);
    }

    public static /* synthetic */ void lambda$IoNrgdEhvh1wMO4TCrFFxAZ0W5s(DivelogDiagram divelogDiagram, List list) {
        divelogDiagram.m7309e(list);
    }

    public static /* synthetic */ void lambda$X1TDrhdbpXEPyRWWh5UOEJ29Nbc(DivelogDiagram divelogDiagram, List list) {
        divelogDiagram.m7311d(list);
    }

    public static /* synthetic */ void lambda$ao1sphceFGUkjE3dcvitMOe31oM(DivelogDiagram divelogDiagram, Throwable th) {
        divelogDiagram.m7324a(th);
    }

    public static /* synthetic */ void lambda$b23Nne2RgLXqqb0fxpfDMf7KhlA(DivelogDiagram divelogDiagram, EntryWrapper entryWrapper) {
        divelogDiagram.m7328a(entryWrapper);
    }

    public static /* synthetic */ void lambda$eL5bs7W8FGcp3aVkm5hmAr15yII(DivelogDiagram divelogDiagram, List list) {
        divelogDiagram.m7323a(list);
    }

    public static /* synthetic */ void lambda$jc6ifxF9sY5udZ_8TUAtdRe_aeM(EntryWrapper entryWrapper) {
        m7320b(entryWrapper);
    }

    public DivelogDiagram(Context context) {
        this(context, null);
    }

    public DivelogDiagram(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DivelogDiagram(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DivelogDiagram(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f5201j = 10;
        this.f5204m = -1;
        this.f5212u = new Rect();
        this.f5213v = new CompositeDisposable();
        context.obtainStyledAttributes(attributeSet, R.styleable.DivelogDiagram, i, i2).recycle();
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.divelog_diagram_layout, (ViewGroup) this, true);
        this.f5207p = (InternationalTextView) findViewById(R.id.tvCurDepth);
        this.f5208q = (InternationalTextView) findViewById(R.id.tvCurTemperature);
        this.f5197f = (LineChart) findViewById(R.id.divelogChart);
        this.f5209r = (DivelogSeekbar) findViewById(R.id.sbDivelog);
        this.f5205n = (TextView) findViewById(R.id.tvDivingTime);
        this.f5206o = (InternationalTextView) findViewById(R.id.tvMaxDepth);
        this.f5209r.setOnSeekBarChangeListener(new C1920c());
        setWillNotDraw(false);
        this.f5210s = new Paint();
        this.f5210s.setColor(Color.parseColor("#EEEEEE"));
        this.f5210s.setAntiAlias(true);
        this.f5210s.setStyle(Paint.Style.STROKE);
        this.f5210s.setStrokeWidth(DpiUtils.m5887a(getContext(), 2.0f));
        this.f5211t = new Paint();
        this.f5211t.setColor(Color.parseColor("#1A7DA2"));
        this.f5211t.setAntiAlias(true);
        this.f5211t.setStyle(Paint.Style.FILL);
        m7313d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DataSubscription dataSubscription = this.f5195d;
        if (dataSubscription != null) {
            dataSubscription.mo3370a();
            this.f5195d = null;
        }
        this.f5213v.dispose();
    }

    /* renamed from: b */
    private void m7322b() {
        InterfaceC1918a interfaceC1918a = this.f5203l;
        if (interfaceC1918a != null) {
            interfaceC1918a.mo7305a(this);
        }
    }

    /* renamed from: c */
    private void m7316c() {
        InterfaceC1918a interfaceC1918a = this.f5203l;
        if (interfaceC1918a != null) {
            interfaceC1918a.mo7303c(this);
        }
    }

    public void setDivelogId(long j) {
        DataSubscription dataSubscription = this.f5195d;
        if (dataSubscription != null && !dataSubscription.mo3368b()) {
            this.f5195d.mo3370a();
            this.f5195d = null;
        }
        this.f5193b = j;
        m7322b();
        this.f5195d = Navatics.m7933f().m3474d(DiveLog.class).m3416e().m3291a(DiveLog_.f4395id, j).m3288b().m3299f().m3363a(new DataObserver() { // from class: com.navatics.app.widget.-$$Lambda$DivelogDiagram$eL5bs7W8FGcp3aVkm5hmAr15yII
            @Override // io.objectbox.p092b.DataObserver
            public final void onData(Object obj) {
                DivelogDiagram.lambda$eL5bs7W8FGcp3aVkm5hmAr15yII(DivelogDiagram.this, (List) obj);
            }
        });
    }

    public DiveLog getCurDivelog() {
        return this.f5194c;
    }

    public void setSbDielogThumbOffset(int i) {
        DivelogSeekbar divelogSeekbar = this.f5209r;
        if (divelogSeekbar != null) {
            divelogSeekbar.setThumbOffset(i);
        }
    }

    public List<EntryWrapper> getEntryWrapperListHasPic() {
        return this.f5199h;
    }

    /* renamed from: a */
    public void m7323a(List<DiveLog> list) {
        C3044k c3044k = f5192a;
        c3044k.mo1511a((Object) ("DEBUG_DIVE_LOG onDataChanged, Thread : " + Thread.currentThread().getName()));
        if (list == null || list.isEmpty()) {
            f5192a.mo1504b((Object) "data is empty");
        } else if (this.f5196e) {
            f5192a.mo1499d("still loading, skip this update.");
        } else {
            this.f5194c = list.get(0);
            this.f5213v.mo3187a(Observable.m3097a((ObservableOnSubscribe) new C19161()).m3079b(new Consumer() { // from class: com.navatics.app.widget.-$$Lambda$DivelogDiagram$IoNrgdEhvh1wMO4TCrFFxAZ0W5s
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    DivelogDiagram.lambda$IoNrgdEhvh1wMO4TCrFFxAZ0W5s(DivelogDiagram.this, (List) obj);
                }
            }).m3091a(AndroidSchedulers.m3250a()).m3079b(new Consumer() { // from class: com.navatics.app.widget.-$$Lambda$DivelogDiagram$X1TDrhdbpXEPyRWWh5UOEJ29Nbc
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    DivelogDiagram.lambda$X1TDrhdbpXEPyRWWh5UOEJ29Nbc(DivelogDiagram.this, (List) obj);
                }
            }).m3091a(Schedulers.m3217b()).m3070c(new Function() { // from class: com.navatics.app.widget.-$$Lambda$DivelogDiagram$BXKeMQU2as1RvLgW-yaR7b1MDv8
                @Override // io.reactivex.p096b.Function
                public final Object apply(Object obj) {
                    return DivelogDiagram.m13098lambda$BXKeMQU2as1RvLgWyaR7b1MDv8(DivelogDiagram.this, (List) obj);
                }
            }).m3078b(new Function() { // from class: com.navatics.app.widget.-$$Lambda$DivelogDiagram$DWgUZM5WjN4YUYs8_zGq_LS_GAU
                @Override // io.reactivex.p096b.Function
                public final Object apply(Object obj) {
                    return DivelogDiagram.lambda$DWgUZM5WjN4YUYs8_zGq_LS_GAU(DivelogDiagram.this, (List) obj);
                }
            }).m3079b(new Consumer() { // from class: com.navatics.app.widget.-$$Lambda$DivelogDiagram$b23Nne2RgLXqqb0fxpfDMf7KhlA
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    DivelogDiagram.lambda$b23Nne2RgLXqqb0fxpfDMf7KhlA(DivelogDiagram.this, (EntryWrapper) obj);
                }
            }).m3067d(1L, TimeUnit.SECONDS).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3106a(new Consumer() { // from class: com.navatics.app.widget.-$$Lambda$DivelogDiagram$jc6ifxF9sY5udZ_8TUAtdRe_aeM
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    DivelogDiagram.lambda$jc6ifxF9sY5udZ_8TUAtdRe_aeM((EntryWrapper) obj);
                }
            }, new Consumer() { // from class: com.navatics.app.widget.-$$Lambda$DivelogDiagram$ao1sphceFGUkjE3dcvitMOe31oM
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    DivelogDiagram.lambda$ao1sphceFGUkjE3dcvitMOe31oM(DivelogDiagram.this, (Throwable) obj);
                }
            }, new InterfaceC2848a() { // from class: com.navatics.app.widget.-$$Lambda$DivelogDiagram$Boc0NvuO0GsO8sqD_EJneYXNs3U
                @Override // io.reactivex.p096b.InterfaceC2848a
                public final void run() {
                    DivelogDiagram.lambda$Boc0NvuO0GsO8sqD_EJneYXNs3U(DivelogDiagram.this);
                }
            }));
        }
    }

    /* renamed from: com.navatics.app.widget.DivelogDiagram$1 */
    /* loaded from: classes.dex */
    public class C19161 implements ObservableOnSubscribe<List<EntryWrapper>> {
        /* renamed from: lambda$JRNeQRQ-bmwF1AtNsY3sdAVICXU */
        public static /* synthetic */ void m13099lambda$JRNeQRQbmwF1AtNsY3sdAVICXU(List list, int i, DiveLogEntry diveLogEntry) {
            m7306a(list, i, diveLogEntry);
        }

        C19161() {
            DivelogDiagram.this = r1;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<List<EntryWrapper>> observableEmitter) throws Exception {
            DivelogDiagram.this.f5196e = true;
            final ArrayList arrayList = new ArrayList();
            DivelogDiagram.this.f5194c.transverse(new DiveLog.InterfaceC1770b() { // from class: com.navatics.app.widget.-$$Lambda$DivelogDiagram$1$JRNeQRQ-bmwF1AtNsY3sdAVICXU
                @Override // com.navatics.app.framework.divelog.DiveLog.InterfaceC1770b
                public final void onItem(int i, DiveLogEntry diveLogEntry) {
                    DivelogDiagram.C19161.m13099lambda$JRNeQRQbmwF1AtNsY3sdAVICXU(arrayList, i, diveLogEntry);
                }
            });
            observableEmitter.onNext(arrayList);
            observableEmitter.onComplete();
        }

        /* renamed from: a */
        public static /* synthetic */ void m7306a(List list, int i, DiveLogEntry diveLogEntry) {
            if (diveLogEntry.getPhotoUri() != null) {
                list.add(new EntryWrapper(i, diveLogEntry, null));
            }
        }
    }

    /* renamed from: e */
    public /* synthetic */ void m7309e(List list) throws Exception {
        m7310e();
    }

    /* renamed from: d */
    public /* synthetic */ void m7311d(List list) throws Exception {
        m7308f();
        this.f5199h = list;
        InterfaceC1918a interfaceC1918a = this.f5203l;
        if (interfaceC1918a != null) {
            interfaceC1918a.mo7304b(this);
        }
    }

    /* renamed from: c */
    public /* synthetic */ ObservableSource m7314c(List list) throws Exception {
        this.f5200i = list;
        return Observable.m3089a((Iterable) list);
    }

    /* renamed from: b */
    public static /* synthetic */ void m7320b(EntryWrapper entryWrapper) throws Exception {
        f5192a.mo1511a((Object) "loading......");
    }

    /* renamed from: a */
    public /* synthetic */ void m7324a(Throwable th) throws Exception {
        this.f5196e = false;
        th.printStackTrace();
    }

    /* renamed from: g */
    public /* synthetic */ void m7307g() throws Exception {
        f5192a.mo1511a((Object) "load done. refresh.");
        this.f5198g.m7369a(this.f5200i);
        float applyDimension = (int) TypedValue.applyDimension(1, 72.0f, getResources().getDisplayMetrics());
        this.f5198g.m7370a(applyDimension);
        this.f5198g.m7368b(applyDimension);
        this.f5197f.invalidate();
        invalidate();
        this.f5196e = false;
        m7316c();
    }

    public void setOnSelectedItemChangedListener(InterfaceC1919b interfaceC1919b) {
        this.f5202k = interfaceC1919b;
    }

    public void setOnDataUpdateListener(InterfaceC1918a interfaceC1918a) {
        this.f5203l = interfaceC1918a;
    }

    /* renamed from: d */
    private void m7313d() {
        this.f5198g = new MyChartHighlighter(this.f5197f);
        LineChart lineChart = this.f5197f;
        lineChart.setRenderer(new MyLineChartRenderer(lineChart, lineChart.getAnimator(), this.f5197f.getViewPortHandler()));
        this.f5197f.setOnChartValueSelectedListener(new OnChartValueSelectedListener() { // from class: com.navatics.app.widget.DivelogDiagram.2
            {
                DivelogDiagram.this = this;
            }

            @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
            public void onValueSelected(Entry entry, Highlight highlight) {
                DivelogDiagram.f5192a.mo1511a((Object) "onValueSelected");
                if (DivelogDiagram.this.f5202k != null) {
                    DivelogDiagram.this.f5202k.mo7302a((ILineDataSet) ((LineData) DivelogDiagram.this.f5197f.getData()).getDataSetByIndex(0), entry);
                }
            }

            @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
            public void onNothingSelected() {
                DivelogDiagram.f5192a.mo1511a((Object) "onNothingSelected");
            }
        });
        this.f5197f.setHighlighter(this.f5198g);
        XAxis xAxis = this.f5197f.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawLabels(false);
        YAxis axisLeft = this.f5197f.getAxisLeft();
        axisLeft.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        axisLeft.setXOffset(DpiUtils.m5887a(getContext(), 50.0f));
        axisLeft.setDrawAxisLine(false);
        axisLeft.setAxisMinimum(-50.0f);
        axisLeft.setAxisMaximum(10.0f);
        axisLeft.setTextSize(10.0f);
        axisLeft.setInverted(true);
        axisLeft.setTextColor(Color.parseColor("#4c000000"));
        axisLeft.enableGridDashedLine(DpiUtils.m5887a(getContext(), 3.0f), DpiUtils.m5887a(getContext(), 6.0f), 0.0f);
        this.f5197f.setScaleEnabled(false);
        this.f5197f.getAxisRight().setEnabled(false);
        this.f5197f.getDescription().setEnabled(false);
        LineChart lineChart2 = this.f5197f;
        lineChart2.setRendererLeftYAxis(new MyYAxisRenderer(lineChart2.getViewPortHandler(), axisLeft, this.f5197f.getTransformer(YAxis.AxisDependency.LEFT)));
        this.f5197f.getLegend().setEnabled(false);
    }

    /* renamed from: e */
    private void m7310e() {
        C3044k c3044k = f5192a;
        c3044k.mo1500c((Object) ("updateLineChart, Thread : " + Thread.currentThread().getName()));
        DiveLog diveLog = this.f5194c;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ToMany<DiveLogEntry> entries = diveLog.getEntries();
        if (entries == null || entries.isEmpty()) {
            f5192a.mo1504b((Object) "DEBUG_DIVE_LOG wtf ??? diveLogEntryList is null ?");
            return;
        }
        long startTime = diveLog.getStartTime();
        float m8668a = RobotStatus.m8668a(diveLog.getMinDepth());
        float m8668a2 = RobotStatus.m8668a(diveLog.getMaxDepth());
        for (int i = 0; i < entries.size(); i++) {
            DiveLogEntry diveLogEntry = entries.get(i);
            diveLogEntry.getStateDepth();
            float m8668a3 = RobotStatus.m8668a(diveLogEntry.getStateDepth());
            float timestamp = (float) (diveLogEntry.getTimestamp() - startTime);
            arrayList.add(new Entry(timestamp, m8668a3, diveLogEntry));
            if (m8668a3 == m8668a2) {
                this.f5204m = i;
            }
            arrayList2.add(new Entry(timestamp, RobotStatus.m8668a(m7329a(diveLog, diveLogEntry.getTemperature())), diveLogEntry));
        }
        if (this.f5204m == -1) {
            throw new RuntimeException("maxDepthEntry is null");
        }
        YAxis axisLeft = this.f5197f.getAxisLeft();
        axisLeft.setAxisMinimum(m8668a);
        axisLeft.setAxisMaximum(m8668a2);
        LineDataSet lineDataSet = new LineDataSet(arrayList, "depth");
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setLineWidth(2.0f);
        lineDataSet.setHighlightEnabled(true);
        lineDataSet.setColor(Color.parseColor("#C00D3F86"));
        lineDataSet.setDrawValues(false);
        lineDataSet.setDrawIcons(true);
        lineDataSet.setDrawCircles(false);
        LineDataSet lineDataSet2 = new LineDataSet(arrayList2, "temperature");
        lineDataSet2.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet2.setDrawHighlightIndicators(false);
        lineDataSet2.setLineWidth(2.0f);
        lineDataSet2.setHighlightEnabled(false);
        lineDataSet2.setColor(Color.parseColor("#FECE00"));
        lineDataSet2.setDrawValues(false);
        lineDataSet2.setDrawIcons(true);
        lineDataSet2.setDrawCircles(false);
        this.f5197f.setData(new LineData(lineDataSet, lineDataSet2));
        this.f5197f.postInvalidate();
    }

    /* renamed from: a */
    private int m7329a(DiveLog diveLog, int i) {
        return (((i - diveLog.getMinTemp()) * (diveLog.getMaxDepth() - diveLog.getMinDepth())) / ((diveLog.getMaxTemp() + 5) - diveLog.getMinTemp())) + diveLog.getMinDepth();
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.github.mikephil.charting.data.Entry] */
    /* renamed from: f */
    private void m7308f() {
        XAxis xAxis = this.f5197f.getXAxis();
        ?? entryForIndex = ((ILineDataSet) this.f5197f.getLineData().getDataSetByIndex(0)).getEntryForIndex(this.f5204m);
        entryForIndex.getX();
        xAxis.getAxisMinimum();
        xAxis.getAxisMaximum();
        xAxis.getAxisMinimum();
        ILineDataSet iLineDataSet = (ILineDataSet) this.f5197f.getLineData().getDataSetByIndex(0);
        this.f5209r.setProgress((int) ((entryForIndex.getX() / iLineDataSet.getXMax()) * this.f5209r.getMax()));
        this.f5209r.setIndicatorProgress((int) ((entryForIndex.getX() / iLineDataSet.getXMax()) * this.f5209r.getMax()));
        DiveLogEntry diveLogEntry = (DiveLogEntry) entryForIndex.getData();
        this.f5207p.m8060a(entryForIndex.getY());
        if (diveLogEntry.getWaterTemperature() != 0.0f) {
            this.f5208q.m8060a(diveLogEntry.getWaterTemperature());
        } else {
            this.f5208q.m8060a(diveLogEntry.getTemperature());
        }
        this.f5205n.setText(String.valueOf((this.f5194c.getEndTime() - this.f5194c.getStartTime()) / 60000));
        this.f5206o.m8060a(entryForIndex.getY());
    }

    /* renamed from: b */
    public List<EntryWrapper> m7317b(List<EntryWrapper> list) {
        ArrayList arrayList = new ArrayList();
        float size = (list.size() * 1.0f) / this.f5201j;
        float f = 0.0f;
        for (int i = 0; i < list.size(); i++) {
            if (i >= f) {
                arrayList.add(list.get(i));
                f += size;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.github.mikephil.charting.data.Entry] */
    /* renamed from: a */
    public void m7328a(EntryWrapper entryWrapper) throws Exception {
        Drawable drawable;
        int applyDimension = (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        RequestOptions mo9517k = new RequestOptions().mo9536b((Transformation<Bitmap>) new CircleCropWithBorder((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()), Color.parseColor("#0D3F86"))).mo9517k();
        try {
            drawable = Glide.m12516b(getContext()).mo8814a(entryWrapper.f4444b.getPhotoUri()).mo8828a(mo9517k).m12450a(applyDimension, applyDimension).get();
        } catch (Exception unused) {
            drawable = Glide.m12516b(getContext()).mo8815a(Integer.valueOf((int) R.drawable.filter2)).mo8828a(mo9517k).m12450a(applyDimension, applyDimension).get();
        }
        ((LineDataSet) this.f5197f.getLineData().getDataSetByIndex(0)).getEntryForIndex(entryWrapper.f4443a).setIcon(drawable);
        C3044k c3044k = f5192a;
        c3044k.mo1511a((Object) ("load icon for " + entryWrapper.f4444b.getPhotoUri() + " complete."));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        m7330a(canvas);
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    private void m7330a(Canvas canvas) {
        float progress = (this.f5209r.getProgress() * getWidth()) / 100;
        canvas.drawLine(progress, this.f5209r.getBottom(), progress, getHeight(), this.f5210s);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.github.mikephil.charting.data.Entry] */
    /* renamed from: a */
    public void m7331a(int i) {
        if (this.f5197f.getLineData() == null) {
            return;
        }
        ILineDataSet iLineDataSet = (ILineDataSet) this.f5197f.getLineData().getDataSetByIndex(0);
        float xMax = (i * iLineDataSet.getXMax()) / this.f5209r.getMax();
        ?? entryForXValue = iLineDataSet.getEntryForXValue(xMax, Float.NaN);
        if (entryForXValue == 0) {
            C3044k c3044k = f5192a;
            c3044k.mo1504b((Object) ("can not find entry for x : " + xMax));
            return;
        }
        this.f5207p.m8060a(entryForXValue.getY());
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.github.mikephil.charting.data.Entry] */
    /* renamed from: b */
    public void m7321b(int i) {
        if (this.f5197f.getLineData() == null) {
            return;
        }
        ILineDataSet iLineDataSet = (ILineDataSet) this.f5197f.getLineData().getDataSetByIndex(1);
        float xMax = (i * iLineDataSet.getXMax()) / this.f5209r.getMax();
        ?? entryForXValue = iLineDataSet.getEntryForXValue(xMax, Float.NaN);
        if (entryForXValue == 0) {
            C3044k c3044k = f5192a;
            c3044k.mo1504b((Object) ("can not find entry for x : " + xMax));
            return;
        }
        this.f5208q.m8060a(((DiveLogEntry) entryForXValue.getData()).getTemperature());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.widget.DivelogDiagram$c */
    /* loaded from: classes.dex */
    public class C1920c implements DivelogSeekbar.InterfaceC1923a {
        @Override // com.navatics.app.widget.DivelogSeekbar.InterfaceC1923a
        /* renamed from: a */
        public void mo7274a(DivelogSeekbar divelogSeekbar) {
        }

        @Override // com.navatics.app.widget.DivelogSeekbar.InterfaceC1923a
        /* renamed from: b */
        public void mo7272b(DivelogSeekbar divelogSeekbar) {
        }

        C1920c() {
            DivelogDiagram.this = r1;
        }

        @Override // com.navatics.app.widget.DivelogSeekbar.InterfaceC1923a
        /* renamed from: a */
        public void mo7273a(DivelogSeekbar divelogSeekbar, int i, boolean z) {
            if (!z || DivelogDiagram.this.f5196e) {
                return;
            }
            DivelogDiagram.this.m7331a(i);
            DivelogDiagram.this.m7321b(i);
            DivelogDiagram.this.invalidate();
        }
    }
}
