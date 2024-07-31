package com.navatics.app.activities;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p011v7.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.navatics.app.R;
import com.navatics.app.framework.WeatherManager;
import com.navatics.app.framework.divelog.DiveLog;
import com.navatics.app.framework.divelog.DiveLogEntry;
import com.navatics.app.framework.divelog.DiveLogManager;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.robot.utils.DpiUtils;
import com.navatics.robot.utils.RandomUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class TestDiveLogActivity extends AppCompatActivity {

    /* renamed from: d */
    private static final C3044k f3892d = C3044k.m1564a(TestDiveLogActivity.class);

    /* renamed from: a */
    LineChart f3893a;

    /* renamed from: b */
    Random f3894b = new Random();

    /* renamed from: c */
    List<Entry> f3895c;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r9v9, types: [com.navatics.app.activities.TestDiveLogActivity$1] */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.test_dive_log_activity);
        this.f3893a = (LineChart) findViewById(R.id.lineChart);
        this.f3895c = new ArrayList();
        for (int i = 0; i < 20; i++) {
            C1670a c1670a = new C1670a(i, m9028a(0.0f, -40.0f));
            this.f3895c.add(new Entry((float) c1670a.f3898a, c1670a.f3899b));
        }
        LineDataSet lineDataSet = new LineDataSet(this.f3895c, "Label");
        lineDataSet.setLineWidth(3.0f);
        lineDataSet.setHighlightEnabled(false);
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.setCubicIntensity(0.1f);
        lineDataSet.setColor(Color.parseColor("#C00D3F86"));
        lineDataSet.setDrawValues(false);
        lineDataSet.setDrawIcons(true);
        XAxis xAxis = this.f3893a.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawLabels(false);
        YAxis axisLeft = this.f3893a.getAxisLeft();
        axisLeft.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        axisLeft.setXOffset(DpiUtils.m5887a(this, 50.0f));
        axisLeft.setDrawAxisLine(false);
        axisLeft.setAxisMinimum(-50.0f);
        axisLeft.setAxisMaximum(10.0f);
        axisLeft.setTextSize(10.0f);
        axisLeft.setTextColor(Color.parseColor("#4c000000"));
        axisLeft.enableGridDashedLine(DpiUtils.m5887a(this, 3.0f), DpiUtils.m5887a(this, 6.0f), 0.0f);
        this.f3893a.getAxisRight().setEnabled(false);
        this.f3893a.getDescription().setEnabled(false);
        this.f3893a.setBackgroundColor(-1);
        LineChart lineChart = this.f3893a;
        lineChart.setRendererLeftYAxis(new MyYAxisRenderer(lineChart.getViewPortHandler(), axisLeft, this.f3893a.getTransformer(YAxis.AxisDependency.LEFT)));
        this.f3893a.getLegend().setEnabled(false);
        this.f3893a.setData(new LineData(lineDataSet));
        this.f3893a.invalidate();
        new Thread() { // from class: com.navatics.app.activities.TestDiveLogActivity.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TestDiveLogActivity.this.getResources(), BitmapFactory.decodeResource(TestDiveLogActivity.this.getResources(), R.drawable.assist_screen_account_nol));
                for (int i2 = 0; i2 < TestDiveLogActivity.this.f3895c.size(); i2++) {
                    if (i2 % 2 == 0) {
                        TestDiveLogActivity.this.f3895c.get(i2).setIcon(bitmapDrawable);
                    }
                }
                TestDiveLogActivity.this.m9029a();
                TestDiveLogActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.TestDiveLogActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TestDiveLogActivity.this.f3893a.invalidate();
                    }
                });
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9029a() {
        int m9027a;
        DiveLogManager m8472b = DiveLogManager.m8472b();
        WeatherManager m8592b = WeatherManager.m8592b();
        DiveLog m8473a = m8472b.m8473a(true);
        f3892d.mo1500c((Object) ("new Divelog, id " + m8473a.getId() + ", date " + m8473a.getDate()));
        long startTime = m8473a.getStartTime();
        f3892d.mo1500c((Object) ("startTime : " + startTime));
        NvUser m7806d = NvUserManager.m7828b().m7806d();
        if (m7806d == null) {
            throw new RuntimeException("user is null");
        }
        m8473a.setEmail(m7806d.getEmail());
        m8473a.setDate(new Date());
        int i = 1800;
        short s = 0;
        long j = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        long currentTimeMillis = System.currentTimeMillis();
        int i5 = 0;
        int i6 = 0;
        while (i2 < i) {
            DiveLogEntry diveLogEntry = new DiveLogEntry();
            diveLogEntry.setTimestamp(currentTimeMillis);
            diveLogEntry.setAirTemperature(m8592b.m8591c());
            diveLogEntry.setWeather(m8592b.m8590d());
            diveLogEntry.setWindVelocity(m8592b.m8588f());
            diveLogEntry.setWindDirection(m8592b.m8587g());
            diveLogEntry.setBuoyLongitude(0.0f);
            diveLogEntry.setBuoyLatitude(0.0f);
            diveLogEntry.setPhoneLongitude(0.0f);
            diveLogEntry.setPhoneLatitude(0.0f);
            diveLogEntry.setStateQuaternionW(s);
            diveLogEntry.setStateQuaternionX(s);
            diveLogEntry.setStateQuaternionY(s);
            diveLogEntry.setStateQuaternionZ(s);
            diveLogEntry.setRefStateQuaternionW(s);
            diveLogEntry.setRefStateQuaternionX(s);
            diveLogEntry.setRefStateQuaternionY(s);
            diveLogEntry.setRefStateQuaternionZ(s);
            if (i3 <= 0) {
                m9027a = RandomUtils.m5869a(1630, 3260);
            } else if (i3 > 22937) {
                m9027a = m9027a(100);
            } else if (i2 < 600) {
                m9027a = m9027a(25);
            } else if (i2 < 1200) {
                m9027a = m9027a(50);
            } else {
                m9027a = m9027a(75);
            }
            i3 += m9027a;
            if (i3 < 0) {
                i3 = 0;
            }
            int i7 = (int) (((i5 + i3) * 1.0f) / 2.0f);
            if (i3 > i6) {
                i6 = i3;
            }
            diveLogEntry.setStateDepth(i3);
            diveLogEntry.setRefStateDepth(0);
            diveLogEntry.setRpmMotor0((short) 0);
            diveLogEntry.setRpmMotor1((short) 0);
            diveLogEntry.setRpmMotor2((short) 0);
            diveLogEntry.setRpmMotor3((short) 0);
            diveLogEntry.setLedState(0);
            diveLogEntry.setBatteryState(0);
            diveLogEntry.setSensorsState(0);
            diveLogEntry.setRobotOperationState(0);
            diveLogEntry.setRemoteBattery(0);
            diveLogEntry.setBuoyBattery(0);
            diveLogEntry.setPhoneBattery(0);
            diveLogEntry.setRemotePER(0);
            diveLogEntry.setRemoteRSSI(0);
            diveLogEntry.setRemoteSNR(0);
            diveLogEntry.setTemperature(RandomUtils.m5869a(10, 30));
            int i8 = i6;
            diveLogEntry.parent.setTargetId(m8473a.getId());
            if (i2 % 128 == 0 && i4 <= 14) {
                diveLogEntry.setPhotoUri("/mnt/sdcard/Navatics/Photos/test_" + i4 + ".png");
                i4++;
            }
            m8473a.entries.add(diveLogEntry);
            i2++;
            i = 1800;
            i5 = i7;
            i6 = i8;
            s = 0;
            j = currentTimeMillis;
            currentTimeMillis = 1000 + currentTimeMillis;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        long currentTimeMillis3 = System.currentTimeMillis();
        f3892d.mo1500c((Object) ("total delta : " + (currentTimeMillis3 - startTime) + ", save time : " + (currentTimeMillis3 - currentTimeMillis2)));
        m8472b.m8488a(j, m8473a, i5, i6);
    }

    /* renamed from: a */
    private int m9027a(int i) {
        int m5869a = RandomUtils.m5869a(1, 100);
        int m5869a2 = RandomUtils.m5869a(650, 1300);
        return m5869a > i ? m5869a2 : m5869a2 * (-1);
    }

    /* renamed from: com.navatics.app.activities.TestDiveLogActivity$a */
    /* loaded from: classes.dex */
    class C1670a {

        /* renamed from: a */
        long f3898a;

        /* renamed from: b */
        float f3899b;

        C1670a(long j, float f) {
            this.f3898a = j;
            this.f3899b = f;
        }
    }

    /* renamed from: a */
    public float m9028a(float f, float f2) {
        return f == f2 ? f : f + ((f2 - f) * this.f3894b.nextFloat());
    }
}
