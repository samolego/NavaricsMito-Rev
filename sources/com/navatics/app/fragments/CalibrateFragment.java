package com.navatics.app.fragments;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.view.InputDeviceCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.navatics.app.R;
import com.navatics.app.activities.PreviewActivityV2;
import com.navatics.app.fragments.CalibrateFragment;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.RobotSensorStateHandler;
import com.navatics.app.framework.RobotStatus;
import com.navatics.app.framework.SensorStatus;
import com.navatics.app.utils.AnimatorEndListener;
import com.navatics.app.utils.NoDoubleClickListener;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class CalibrateFragment extends Fragment {

    /* renamed from: k */
    private static final C3044k f4042k = C3044k.m1564a(CalibrateFragment.class);

    /* renamed from: a */
    View f4043a;

    /* renamed from: b */
    ListView f4044b;

    /* renamed from: c */
    C1713b f4045c;

    /* renamed from: d */
    List<C1712a> f4046d;

    /* renamed from: e */
    C1715c f4047e;

    /* renamed from: f */
    NvRobot f4048f;

    /* renamed from: g */
    Button f4049g;

    /* renamed from: h */
    Button f4050h;

    /* renamed from: i */
    ViewGroup f4051i;

    /* renamed from: j */
    ViewGroup f4052j;

    public static /* synthetic */ void lambda$6Txo6Bl4aBgL45DElCDYCHtj3nU(CalibrateFragment calibrateFragment, View view) {
        calibrateFragment.m8799a(view);
    }

    public static /* synthetic */ void lambda$A13ghuiXYpF6wsJZiowf8AH3If4(CalibrateFragment calibrateFragment, View view) {
        calibrateFragment.m8795c(view);
    }

    public static /* synthetic */ void lambda$CLOMSnj_uWEBdfpDsr6Q73weTZI(CalibrateFragment calibrateFragment, View view) {
        calibrateFragment.m8797b(view);
    }

    public static /* synthetic */ void lambda$ipgPjRIxBjfaBCGWJ5YQnHN0vtI(CalibrateFragment calibrateFragment, View view) {
        calibrateFragment.m8794d(view);
    }

    @Override // android.support.p008v4.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.calibrate_setting_panel, viewGroup, false);
        this.f4043a = inflate;
        this.f4051i = (ViewGroup) inflate.findViewById(R.id.compCaliNotiContainer);
        this.f4052j = (ViewGroup) inflate.findViewById(R.id.gyroCaliNotiContainer);
        this.f4049g = (Button) inflate.findViewById(R.id.btnStartCalibrateCompass);
        this.f4050h = (Button) inflate.findViewById(R.id.btnStartCalibrateGyro);
        this.f4049g.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$CalibrateFragment$ipgPjRIxBjfaBCGWJ5YQnHN0vtI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalibrateFragment.lambda$ipgPjRIxBjfaBCGWJ5YQnHN0vtI(CalibrateFragment.this, view);
            }
        });
        this.f4050h.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$CalibrateFragment$A13ghuiXYpF6wsJZiowf8AH3If4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalibrateFragment.lambda$A13ghuiXYpF6wsJZiowf8AH3If4(CalibrateFragment.this, view);
            }
        });
        GroundStation m7931h = Navatics.m7931h();
        if (m7931h != null) {
            NvConnection m8098m = m7931h.m8098m();
            if (m8098m != null) {
                NvRobot nvRobot = (NvRobot) m8098m.m7898a(InputDeviceCompat.SOURCE_TOUCHSCREEN);
                if (nvRobot != null) {
                    this.f4048f = nvRobot;
                } else {
                    f4042k.mo1504b((Object) "robot is null");
                }
            } else {
                f4042k.mo1504b((Object) "No connection found");
            }
        } else {
            f4042k.mo1504b((Object) "No connection found");
        }
        NvRobot nvRobot2 = this.f4048f;
        RobotStatus m7693f = nvRobot2 != null ? nvRobot2.m7693f() : null;
        SensorStatus m8628z = m7693f != null ? m7693f.m8628z() : null;
        int m8626a = m8628z != null ? m8628z.m8626a() : 0;
        int m8624b = m8628z != null ? m8628z.m8624b() : 0;
        this.f4046d = new ArrayList();
        this.f4046d.add(new C1712a(1, R.drawable.setting_gyroscope, R.string.imu_setting_gyro_title, true, m8626a, new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$CalibrateFragment$CLOMSnj_uWEBdfpDsr6Q73weTZI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalibrateFragment.lambda$CLOMSnj_uWEBdfpDsr6Q73weTZI(CalibrateFragment.this, view);
            }
        }));
        this.f4046d.add(new C1712a(3, R.drawable.setting_compass, R.string.imu_setting_compass_title, true, m8624b, new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$CalibrateFragment$6Txo6Bl4aBgL45DElCDYCHtj3nU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalibrateFragment.lambda$6Txo6Bl4aBgL45DElCDYCHtj3nU(CalibrateFragment.this, view);
            }
        }));
        this.f4044b = (ListView) inflate.findViewById(R.id.imuSettingList);
        this.f4045c = new C1713b(this.f4046d);
        this.f4044b.setAdapter((ListAdapter) this.f4045c);
        this.f4047e = new C1715c();
        NvRobot nvRobot3 = this.f4048f;
        if (nvRobot3 != null) {
            nvRobot3.m7709a((RobotSensorStateHandler) this.f4047e);
        }
        return inflate;
    }

    /* renamed from: d */
    public /* synthetic */ void m8794d(View view) {
        m8798a(false);
        NvRobot nvRobot = this.f4048f;
        if (nvRobot != null) {
            nvRobot.m7674t();
        }
        ((PreviewActivityV2) getActivity()).m9225g();
    }

    /* renamed from: c */
    public /* synthetic */ void m8795c(View view) {
        m8796b(false);
        NvRobot nvRobot = this.f4048f;
        if (nvRobot != null) {
            nvRobot.m7673u();
        }
    }

    /* renamed from: b */
    public /* synthetic */ void m8797b(View view) {
        m8796b(true);
    }

    /* renamed from: a */
    public /* synthetic */ void m8799a(View view) {
        m8798a(true);
    }

    @Override // android.support.p008v4.app.Fragment
    public void onDestroyView() {
        NvRobot nvRobot = this.f4048f;
        if (nvRobot != null) {
            nvRobot.m7701b(this.f4047e);
        }
        super.onDestroyView();
    }

    /* renamed from: b */
    private void m8796b(boolean z) {
        if (!z) {
            float x = this.f4052j.getX();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f4052j, "x", x, this.f4052j.getWidth() + x);
            ofFloat.setDuration(200L);
            ofFloat.addListener(new AnimatorEndListener() { // from class: com.navatics.app.fragments.CalibrateFragment.1
                {
                    CalibrateFragment.this = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    CalibrateFragment.this.f4052j.setVisibility(4);
                }
            });
            ofFloat.start();
            return;
        }
        this.f4052j.setVisibility(0);
        float width = this.f4043a.getWidth();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f4052j, "x", width, width - this.f4052j.getMeasuredWidth());
        ofFloat2.setDuration(200L);
        ofFloat2.start();
    }

    /* renamed from: a */
    public void m8798a(boolean z) {
        if (!z) {
            float x = this.f4051i.getX();
            Log.i("info1", "showEnsureCalibrateCompassView: " + x);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f4051i, "x", x, ((float) this.f4051i.getWidth()) + x);
            ofFloat.setDuration(200L);
            ofFloat.addListener(new AnimatorEndListener() { // from class: com.navatics.app.fragments.CalibrateFragment.2
                {
                    CalibrateFragment.this = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    CalibrateFragment.this.f4051i.setVisibility(4);
                }
            });
            ofFloat.start();
            return;
        }
        this.f4051i.setVisibility(0);
        float width = this.f4043a.getWidth();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f4051i, "x", width, width - this.f4051i.getMeasuredWidth());
        ofFloat2.setDuration(200L);
        ofFloat2.start();
    }

    /* renamed from: com.navatics.app.fragments.CalibrateFragment$c */
    /* loaded from: classes.dex */
    public class C1715c implements RobotSensorStateHandler {
        public static /* synthetic */ void lambda$bOIEacASGQgeUn1WoH_UJRJ0ldQ(C1715c c1715c) {
            c1715c.m8793a();
        }

        C1715c() {
            CalibrateFragment.this = r1;
        }

        @Override // com.navatics.app.framework.RobotSensorStateHandler
        /* renamed from: a */
        public void mo8673a(SensorStatus sensorStatus) {
            int m8626a = sensorStatus.m8626a();
            sensorStatus.m8622c();
            boolean z = true;
            int m8620d = (sensorStatus.m8620d() << 1) | sensorStatus.m8624b();
            boolean z2 = false;
            if (CalibrateFragment.this.f4046d.get(0).f4059e != m8626a) {
                CalibrateFragment.this.f4046d.get(0).f4059e = m8626a;
                z2 = true;
            }
            if (CalibrateFragment.this.f4046d.get(1).f4059e != m8620d) {
                CalibrateFragment.this.f4046d.get(1).f4059e = m8620d;
            } else {
                z = z2;
            }
            if (!z || CalibrateFragment.this.getActivity() == null) {
                return;
            }
            CalibrateFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.navatics.app.fragments.-$$Lambda$CalibrateFragment$c$bOIEacASGQgeUn1WoH_UJRJ0ldQ
                @Override // java.lang.Runnable
                public final void run() {
                    CalibrateFragment.C1715c.lambda$bOIEacASGQgeUn1WoH_UJRJ0ldQ(CalibrateFragment.C1715c.this);
                }
            });
        }

        /* renamed from: a */
        public /* synthetic */ void m8793a() {
            CalibrateFragment.this.f4045c.notifyDataSetChanged();
        }
    }

    /* renamed from: com.navatics.app.fragments.CalibrateFragment$b */
    /* loaded from: classes.dex */
    public class C1713b extends BaseAdapter {

        /* renamed from: a */
        List<C1712a> f4062a;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        C1713b(List<C1712a> list) {
            CalibrateFragment.this = r1;
            this.f4062a = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<C1712a> list = this.f4062a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            List<C1712a> list = this.f4062a;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C1716d c1716d;
            if (CalibrateFragment.this.getContext() == null) {
                return view;
            }
            C1712a c1712a = this.f4062a.get(i);
            if (view == null) {
                LayoutInflater layoutInflater = (LayoutInflater) CalibrateFragment.this.getContext().getSystemService("layout_inflater");
                if (layoutInflater == null) {
                    throw new RuntimeException("Can't get LAYOUT_INFLATER_SERVICE service");
                }
                view = layoutInflater.inflate(R.layout.imu_setting_list_item, viewGroup, false);
                c1716d = new C1716d();
                c1716d.f4066a = (ImageView) view.findViewById(R.id.ivImuItemImg);
                c1716d.f4067b = (TextView) view.findViewById(R.id.ivItemTitle);
                c1716d.f4068c = (ImageView) view.findViewById(R.id.ivItemStatus);
                c1716d.f4069d = (ImageView) view.findViewById(R.id.ivItemStatusInterference);
                c1716d.f4070e = (Button) view.findViewById(R.id.btnCalirate);
                c1716d.f4070e.setOnClickListener(new NoDoubleClickListener() { // from class: com.navatics.app.fragments.CalibrateFragment.b.1
                    {
                        C1713b.this = this;
                    }

                    @Override // com.navatics.app.utils.NoDoubleClickListener
                    /* renamed from: a */
                    protected void mo7367a(View view2) {
                        C1712a c1712a2 = (C1712a) view2.getTag();
                        if (c1712a2 == null || c1712a2.f4060f == null) {
                            return;
                        }
                        c1712a2.f4060f.onClick(view2);
                    }
                });
                view.setTag(c1716d);
            } else {
                c1716d = (C1716d) view.getTag();
            }
            c1716d.f4070e.setTag(c1712a);
            c1716d.f4066a.setImageResource(c1712a.f4056b);
            c1716d.f4067b.setText(c1712a.f4057c);
            if (c1712a.f4058d) {
                c1716d.f4068c.setVisibility(0);
                if (c1712a.f4055a == 3) {
                    int i2 = c1712a.f4059e;
                    if ((i2 & 1) == 1) {
                        c1716d.f4068c.setImageResource(R.drawable.imu_item_status_ok);
                    } else {
                        c1716d.f4068c.setImageResource(R.drawable.imu_item_status_error);
                    }
                    if ((i2 & 2) == 2) {
                        c1716d.f4069d.setVisibility(0);
                    } else {
                        c1716d.f4069d.setVisibility(8);
                    }
                } else if (c1712a.f4059e == 1) {
                    c1716d.f4068c.setImageResource(R.drawable.imu_item_status_ok);
                } else if (c1712a.f4059e == 0) {
                    c1716d.f4068c.setImageResource(R.drawable.imu_item_status_error);
                }
            } else {
                c1716d.f4068c.setVisibility(8);
                c1716d.f4069d.setVisibility(8);
            }
            return view;
        }
    }

    /* renamed from: com.navatics.app.fragments.CalibrateFragment$d */
    /* loaded from: classes.dex */
    class C1716d {

        /* renamed from: a */
        ImageView f4066a;

        /* renamed from: b */
        TextView f4067b;

        /* renamed from: c */
        ImageView f4068c;

        /* renamed from: d */
        ImageView f4069d;

        /* renamed from: e */
        Button f4070e;

        C1716d() {
            CalibrateFragment.this = r1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.navatics.app.fragments.CalibrateFragment$a */
    /* loaded from: classes.dex */
    public class C1712a {

        /* renamed from: a */
        int f4055a;

        /* renamed from: b */
        int f4056b;

        /* renamed from: c */
        int f4057c;

        /* renamed from: d */
        boolean f4058d;

        /* renamed from: e */
        int f4059e;

        /* renamed from: f */
        View.OnClickListener f4060f;

        C1712a(int i, int i2, int i3, boolean z, int i4, View.OnClickListener onClickListener) {
            CalibrateFragment.this = r1;
            this.f4055a = i;
            this.f4056b = i2;
            this.f4057c = i3;
            this.f4058d = z;
            this.f4059e = i4;
            this.f4060f = onClickListener;
        }
    }
}
