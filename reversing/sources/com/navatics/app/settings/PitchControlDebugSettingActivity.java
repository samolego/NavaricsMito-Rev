package com.navatics.app.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.adapt.SPM_Manager;
import com.navatics.app.R;
import com.navatics.app.activities.OperationalRobotActivity;
import com.navatics.app.framework.RobotStatus;
import com.navatics.robot.math.Quaternion;
import com.navatics.robot.protocol.OutputMessage;
import com.navatics.robot.protocol.PitchCtrlMessage;
import com.navatics.robot.transport.NvValue;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class PitchControlDebugSettingActivity extends OperationalRobotActivity {

    /* renamed from: b */
    int f5070b;
    @BindView
    Button btnPitchSend;

    /* renamed from: c */
    private final C3044k f5071c = C3044k.m1564a(PitchControlDebugSettingActivity.class);
    @BindView
    SeekBar sbPitchSetting;
    @BindView
    TextView tvPitchValue;
    @BindView
    TextView tvStatePitch;
    @BindView
    TextView tvStateQuaternion;

    /* renamed from: l */
    public int m7458l(int i) {
        return i - 45;
    }

    /* renamed from: lambda$AtG5My-gTVUNs_J_ECnvdb4X_7c */
    public static /* synthetic */ void m13090lambda$AtG5MygTVUNs_J_ECnvdb4X_7c(PitchControlDebugSettingActivity pitchControlDebugSettingActivity, View view) {
        pitchControlDebugSettingActivity.m7461a(view);
    }

    @Override // com.navatics.app.activities.LocationActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pitch_control_debug_setting_activity);
        ButterKnife.m12805a(this);
        this.sbPitchSetting.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.navatics.app.settings.PitchControlDebugSettingActivity.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            {
                PitchControlDebugSettingActivity.this = this;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    int m7458l = PitchControlDebugSettingActivity.this.m7458l(i);
                    TextView textView = PitchControlDebugSettingActivity.this.tvPitchValue;
                    textView.setText("Value = " + m7458l);
                    PitchControlDebugSettingActivity.this.f5070b = m7458l;
                }
            }
        });
        this.btnPitchSend.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.settings.-$$Lambda$PitchControlDebugSettingActivity$AtG5My-gTVUNs_J_ECnvdb4X_7c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PitchControlDebugSettingActivity.m13090lambda$AtG5MygTVUNs_J_ECnvdb4X_7c(PitchControlDebugSettingActivity.this, view);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m7461a(View view) {
        m7457m(this.f5070b);
    }

    /* renamed from: m */
    private void m7457m(int i) {
        m7459a(PitchCtrlMessage.m6525a(i));
    }

    /* renamed from: a */
    private void m7459a(OutputMessage outputMessage) {
        C3044k c3044k = this.f5071c;
        c3044k.mo1511a((Object) ("send bytes : [" + outputMessage.toString() + "]"));
        SPM_Manager.GetInstance().GetUserCmd().SendCmd((byte) -16, outputMessage.mo6368b());
        outputMessage.mo6369a();
    }

    @Override // com.navatics.app.NvBaseActivity
    public void onRobotStatusUpdate(RobotStatus robotStatus) {
        float m8671B = robotStatus.m8671B();
        Quaternion m8651f = robotStatus.m8651f();
        String m5971b = NvValue.m5971b(m8651f.f6115x);
        String m5971b2 = NvValue.m5971b(m8651f.f6116y);
        String m5971b3 = NvValue.m5971b(m8651f.f6117z);
        String m5971b4 = NvValue.m5971b(m8651f.f6114w);
        String m5971b5 = NvValue.m5971b(m8671B);
        this.tvStateQuaternion.setText(String.format("Quaternion: x=%s, y=%s, z=%s, w=%s", m5971b, m5971b2, m5971b3, m5971b4));
        this.tvStatePitch.setText(String.format("Pitch: %s", m5971b5));
    }
}
