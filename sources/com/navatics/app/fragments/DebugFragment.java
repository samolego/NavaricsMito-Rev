package com.navatics.app.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.media.ExifInterface;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.adapt.SPM_Manager;
import com.adapt.SPM_Rc;
import com.navatics.app.R;
import com.navatics.app.framework.BuoyStatus;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvBuoy;
import com.navatics.app.framework.NvConnection;
import com.navatics.robot.protocol.OutputMessage;
import com.navatics.robot.protocol.ResetMotorDriverMessage;
import com.navatics.robot.protocol.TestMessage;
import com.navatics.robot.utils.RxTimer;
import com.senseplay.sdk.SPUsb;
import com.senseplay.sdk.model.keymap.PackUtil;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class DebugFragment extends Fragment {

    /* renamed from: b */
    private static final C3044k f4072b = C3044k.m1564a(DebugFragment.class);

    /* renamed from: A */
    private Button f4073A;

    /* renamed from: B */
    private RxTimer f4074B;

    /* renamed from: a */
    View f4075a;

    /* renamed from: c */
    private String f4076c = "50";

    /* renamed from: d */
    private String f4077d = "15";

    /* renamed from: e */
    private String f4078e = ExifInterface.GPS_MEASUREMENT_3D;

    /* renamed from: f */
    private String f4079f = "1";

    /* renamed from: g */
    private String f4080g = ExifInterface.GPS_MEASUREMENT_3D;

    /* renamed from: h */
    private String f4081h = ExifInterface.GPS_MEASUREMENT_2D;

    /* renamed from: i */
    private EditText f4082i;

    /* renamed from: j */
    private EditText f4083j;

    /* renamed from: k */
    private EditText f4084k;

    /* renamed from: l */
    private EditText f4085l;

    /* renamed from: m */
    private EditText f4086m;

    /* renamed from: n */
    private EditText f4087n;

    /* renamed from: o */
    private Button f4088o;

    /* renamed from: p */
    private Button f4089p;

    /* renamed from: q */
    private Button f4090q;

    /* renamed from: r */
    private TextView f4091r;

    /* renamed from: s */
    private TextView f4092s;

    /* renamed from: t */
    private TextView f4093t;

    /* renamed from: u */
    private TextView f4094u;

    /* renamed from: v */
    private TextView f4095v;

    /* renamed from: w */
    private Button f4096w;

    /* renamed from: x */
    private Button f4097x;

    /* renamed from: y */
    private Button f4098y;

    /* renamed from: z */
    private Button f4099z;

    public static /* synthetic */ void lambda$2ujZrPXjFdut5wRNXsLA11iKezg(DebugFragment debugFragment, View view) {
        debugFragment.m8777d(view);
    }

    public static /* synthetic */ void lambda$9bwTCLsGpqhgWpM91oSMiYtsoyY(DebugFragment debugFragment, View view) {
        debugFragment.m8791a(view);
    }

    public static /* synthetic */ void lambda$Bu4gqg5yNWZI0Ayp1I2aW4rH1aE(DebugFragment debugFragment, View view) {
        debugFragment.m8784b(view);
    }

    public static /* synthetic */ void lambda$dxSjhhGeyN2XDXUBI_ZyAzSc8wA(DebugFragment debugFragment, View view) {
        debugFragment.m8780c(view);
    }

    /* renamed from: lambda$hfIpF9qK4SlllugtBsjz-wGRdyU */
    public static /* synthetic */ void m13042lambda$hfIpF9qK4SlllugtBsjzwGRdyU(DebugFragment debugFragment, View view) {
        debugFragment.m8774e(view);
    }

    @Override // android.support.p008v4.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.debug_setting_panel, viewGroup, false);
        this.f4075a = inflate;
        this.f4091r = (TextView) inflate.findViewById(R.id.tvLongitude);
        this.f4092s = (TextView) inflate.findViewById(R.id.tvLatitude);
        this.f4093t = (TextView) inflate.findViewById(R.id.tvRSSI);
        this.f4094u = (TextView) inflate.findViewById(R.id.tvPER);
        this.f4095v = (TextView) inflate.findViewById(R.id.tvSNR);
        this.f4082i = (EditText) inflate.findViewById(R.id.etNum1);
        this.f4083j = (EditText) inflate.findViewById(R.id.etNum2);
        this.f4084k = (EditText) inflate.findViewById(R.id.etNum3);
        this.f4085l = (EditText) inflate.findViewById(R.id.etNum4);
        this.f4086m = (EditText) inflate.findViewById(R.id.etNum5);
        this.f4087n = (EditText) inflate.findViewById(R.id.etNum6);
        m8785b();
        this.f4082i.setText(this.f4076c);
        this.f4083j.setText(this.f4077d);
        this.f4084k.setText(this.f4078e);
        this.f4085l.setText(this.f4079f);
        this.f4086m.setText(this.f4080g);
        this.f4087n.setText(this.f4081h);
        this.f4096w = (Button) inflate.findViewById(R.id.btnTest1);
        this.f4096w.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$DebugFragment$hfIpF9qK4SlllugtBsjz-wGRdyU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugFragment.m13042lambda$hfIpF9qK4SlllugtBsjzwGRdyU(DebugFragment.this, view);
            }
        });
        this.f4097x = (Button) inflate.findViewById(R.id.btnTest2);
        this.f4097x.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$DebugFragment$2ujZrPXjFdut5wRNXsLA11iKezg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugFragment.lambda$2ujZrPXjFdut5wRNXsLA11iKezg(DebugFragment.this, view);
            }
        });
        this.f4098y = (Button) inflate.findViewById(R.id.btnTest3);
        this.f4098y.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$DebugFragment$dxSjhhGeyN2XDXUBI_ZyAzSc8wA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugFragment.lambda$dxSjhhGeyN2XDXUBI_ZyAzSc8wA(DebugFragment.this, view);
            }
        });
        this.f4099z = (Button) inflate.findViewById(R.id.btnTest4);
        this.f4099z.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$DebugFragment$Bu4gqg5yNWZI0Ayp1I2aW4rH1aE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugFragment.lambda$Bu4gqg5yNWZI0Ayp1I2aW4rH1aE(DebugFragment.this, view);
            }
        });
        this.f4073A = (Button) inflate.findViewById(R.id.btnTest5);
        this.f4073A.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$DebugFragment$9bwTCLsGpqhgWpM91oSMiYtsoyY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugFragment.lambda$9bwTCLsGpqhgWpM91oSMiYtsoyY(DebugFragment.this, view);
            }
        });
        ((Button) inflate.findViewById(R.id.btnSendSizNum)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.DebugFragment.1
            {
                DebugFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DebugFragment debugFragment = DebugFragment.this;
                debugFragment.f4076c = debugFragment.f4082i.getText().toString();
                DebugFragment debugFragment2 = DebugFragment.this;
                debugFragment2.f4077d = debugFragment2.f4083j.getText().toString();
                DebugFragment debugFragment3 = DebugFragment.this;
                debugFragment3.f4078e = debugFragment3.f4084k.getText().toString();
                DebugFragment debugFragment4 = DebugFragment.this;
                debugFragment4.f4079f = debugFragment4.f4085l.getText().toString();
                DebugFragment debugFragment5 = DebugFragment.this;
                debugFragment5.f4080g = debugFragment5.f4086m.getText().toString();
                DebugFragment debugFragment6 = DebugFragment.this;
                debugFragment6.f4081h = debugFragment6.f4087n.getText().toString();
                SPM_Manager GetInstance = SPM_Manager.GetInstance();
                C3044k c3044k = DebugFragment.f4072b;
                c3044k.mo1511a((Object) ("Num1=" + DebugFragment.this.f4076c));
                C3044k c3044k2 = DebugFragment.f4072b;
                c3044k2.mo1511a((Object) ("Num2=" + DebugFragment.this.f4077d));
                C3044k c3044k3 = DebugFragment.f4072b;
                c3044k3.mo1511a((Object) ("Num3=" + DebugFragment.this.f4078e));
                C3044k c3044k4 = DebugFragment.f4072b;
                c3044k4.mo1511a((Object) ("Num4=" + DebugFragment.this.f4079f));
                C3044k c3044k5 = DebugFragment.f4072b;
                c3044k5.mo1511a((Object) ("Num5=" + DebugFragment.this.f4080g));
                byte[] bArr = {SPM_Rc.VIBRATION_MODE.CYCLE_MODE, Byte.valueOf(DebugFragment.this.f4076c).byteValue(), Byte.valueOf(DebugFragment.this.f4077d).byteValue(), Byte.valueOf(DebugFragment.this.f4078e).byteValue(), Byte.valueOf(DebugFragment.this.f4079f).byteValue(), Byte.valueOf(DebugFragment.this.f4080g).byteValue(), Byte.valueOf(DebugFragment.this.f4081h).byteValue()};
                C3044k c3044k6 = DebugFragment.f4072b;
                c3044k6.mo1511a((Object) ("Num6=" + DebugFragment.this.f4081h));
                DebugFragment.this.m8792a();
                GetInstance.GetUserCmd().SendCmd((byte) -16, bArr);
            }
        });
        this.f4088o = (Button) inflate.findViewById(R.id.btnRestoreKeymap);
        this.f4088o.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.DebugFragment.2
            {
                DebugFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DebugFragment.this.m8786a("[{\"COMMAND\":\"MARINE_MOVE\",\"KEYMAP_TYPE\":\"COMMAND_DRIVE\",\"PARAMS\":[{\"TYPE\":\"ANALOG\",\"VALUE\":\"J0_Y\"},{\"TYPE\":\"ANALOG\",\"VALUE\":\"J1_Y\"},{\"TYPE\":\"ANALOG\",\"VALUE\":\"J1_X\"}]},{\"COMMAND\":\"SET_NEXT_LED_MODE\",\"KEYMAP_TYPE\":\"EVENT_DRIVE\",\"EVENT\":\"Y_CLICK\"},{\"COMMAND\":\"FLOAT\",\"KEYMAP_TYPE\":\"EVENT_DRIVE\",\"EVENT\":\"A_CLICK\"},{\"COMMAND\":\"SET_FLAT\",\"KEYMAP_TYPE\":\"EVENT_DRIVE\",\"EVENT\":\"X_CLICK\"},{\"COMMAND\":\"SINK\",\"KEYMAP_TYPE\":\"EVENT_DRIVE\",\"EVENT\":\"B_CLICK\"},{\"COMMAND\":\"START_ENGINE\",\"KEYMAP_TYPE\":\"EVENT_DRIVE\",\"EVENT\":\"LB_CLICK\"}]");
            }
        });
        this.f4089p = (Button) inflate.findViewById(R.id.btnStopKeymap);
        this.f4089p.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.DebugFragment.3
            {
                DebugFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DebugFragment.this.m8786a("[]");
            }
        });
        this.f4090q = (Button) inflate.findViewById(R.id.btnRstMotorDriver);
        this.f4090q.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.DebugFragment.4
            {
                DebugFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DebugFragment.this.m8787a(ResetMotorDriverMessage.m6512c());
            }
        });
        this.f4074B = RxTimer.m5859a(new C1721a(), 500L, true);
        this.f4074B.m5860a();
        return inflate;
    }

    /* renamed from: e */
    public /* synthetic */ void m8774e(View view) {
        m8787a(TestMessage.m6476a(145));
    }

    /* renamed from: d */
    public /* synthetic */ void m8777d(View view) {
        m8787a(TestMessage.m6476a(146));
    }

    /* renamed from: c */
    public /* synthetic */ void m8780c(View view) {
        m8787a(TestMessage.m6476a(147));
    }

    /* renamed from: b */
    public /* synthetic */ void m8784b(View view) {
        m8787a(TestMessage.m6476a(148));
    }

    /* renamed from: a */
    public /* synthetic */ void m8791a(View view) {
        m8787a(TestMessage.m6476a(149));
    }

    /* renamed from: a */
    public void m8787a(OutputMessage outputMessage) {
        SPM_Manager.GetInstance().GetUserCmd().SendCmd((byte) -16, outputMessage.mo6368b());
        outputMessage.mo6369a();
    }

    /* renamed from: com.navatics.app.fragments.DebugFragment$a */
    /* loaded from: classes.dex */
    class C1721a implements RxTimer.InterfaceC2159a {
        C1721a() {
            DebugFragment.this = r1;
        }

        @Override // com.navatics.robot.utils.RxTimer.InterfaceC2159a
        /* renamed from: a */
        public void mo5856a(RxTimer rxTimer) {
            NvConnection m7930i = Navatics.m7930i();
            if (m7930i != null) {
                GroundStation m7931h = Navatics.m7931h();
                BuoyStatus m7907a = ((NvBuoy) m7930i.m7898a(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)).m7907a();
                if (m7907a == null) {
                    return;
                }
                TextView textView = DebugFragment.this.f4091r;
                textView.setText("Longitude : " + m7907a.m8416a());
                TextView textView2 = DebugFragment.this.f4092s;
                textView2.setText("Latitude : " + m7907a.m8412b());
                TextView textView3 = DebugFragment.this.f4093t;
                textView3.setText("RSSI : " + m7931h.m8094q());
                TextView textView4 = DebugFragment.this.f4094u;
                textView4.setText("PER : " + m7931h.m8093r());
                TextView textView5 = DebugFragment.this.f4095v;
                textView5.setText("SNR : " + m7931h.m8092s());
            }
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4074B.m5857b();
    }

    /* renamed from: a */
    void m8792a() {
        SharedPreferences sharedPreferences = this.f4075a.getContext().getSharedPreferences(this.f4075a.getResources().getString(R.string.pref_setting_name), 0);
        if (sharedPreferences == null) {
            f4072b.mo1504b((Object) "sp is null");
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("key_num_1", this.f4076c);
        edit.putString("key_num_2", this.f4077d);
        edit.putString("key_num_3", this.f4078e);
        edit.putString("key_num_4", this.f4079f);
        edit.putString("key_num_5", this.f4080g);
        edit.putString("key_num_6", this.f4081h);
        edit.apply();
    }

    /* renamed from: b */
    void m8785b() {
        SharedPreferences sharedPreferences = this.f4075a.getContext().getSharedPreferences(this.f4075a.getResources().getString(R.string.pref_setting_name), 0);
        if (sharedPreferences == null) {
            f4072b.mo1504b((Object) "sp is null");
            return;
        }
        this.f4076c = sharedPreferences.getString("key_num_1", "50");
        this.f4077d = sharedPreferences.getString("key_num_2", "15");
        this.f4078e = sharedPreferences.getString("key_num_3", ExifInterface.GPS_MEASUREMENT_3D);
        this.f4079f = sharedPreferences.getString("key_num_4", "1");
        this.f4080g = sharedPreferences.getString("key_num_5", ExifInterface.GPS_MEASUREMENT_3D);
        this.f4081h = sharedPreferences.getString("key_num_6", ExifInterface.GPS_MEASUREMENT_2D);
    }

    /* renamed from: a */
    public void m8786a(String str) {
        SPUsb sPUsb = SPUsb.getInstance();
        f4072b.mo1511a((Object) "writeKeyMap 1");
        if (sPUsb.checkUsb()) {
            f4072b.mo1511a((Object) "writeKeyMap 2");
            if (str == null || "".equals(str)) {
                Toast.makeText(getContext(), "没有keymap信息，请联网下载", 0).show();
                return;
            }
            f4072b.mo1511a((Object) "writeKeyMap 3");
            boolean Write = SPM_Manager.GetInstance().GetKeymap().Write(PackUtil.pack(str));
            C3044k c3044k = f4072b;
            c3044k.mo1511a((Object) ("writeKeyMap 4, result = " + Write));
            if (Write) {
                Toast.makeText(getContext(), "write succ", 0).show();
            } else {
                Toast.makeText(getContext(), "write fail", 0).show();
            }
        }
    }
}
