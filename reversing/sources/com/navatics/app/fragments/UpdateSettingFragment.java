package com.navatics.app.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.app.Fragment;
import android.support.p011v7.app.AlertDialog;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.navatics.app.R;
import com.navatics.app.fragments.UpdateSettingFragment;
import com.navatics.app.framework.RobotVersionInfo;
import com.navatics.app.framework.firmware.FirmwareInfo;
import com.navatics.app.framework.firmware.FirmwareManager;
import com.navatics.app.framework.firmware.UpdateLogger;
import com.navatics.robot.transport.NvError;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class UpdateSettingFragment extends Fragment implements FirmwareManager.InterfaceC1816c {

    /* renamed from: i */
    private static final C3044k f4176i = C3044k.m1564a(UpdateSettingFragment.class);

    /* renamed from: a */
    Button f4177a;

    /* renamed from: b */
    ProgressBar f4178b;

    /* renamed from: c */
    TextView f4179c;

    /* renamed from: d */
    View f4180d;

    /* renamed from: e */
    ScrollView f4181e;

    /* renamed from: f */
    RobotVersionInfo f4182f;

    /* renamed from: g */
    FirmwareInfo f4183g;

    /* renamed from: h */
    HandlerC1745b f4184h = new HandlerC1745b(this);

    /* renamed from: a */
    public static /* synthetic */ void m8715a(DialogInterface dialogInterface, int i) {
    }

    /* renamed from: lambda$G9-8feoZ0vb5Z1-oIBFVbnVyzIE */
    public static /* synthetic */ void m13047lambda$G98feoZ0vb5Z1oIBFVbnVyzIE(DialogInterface dialogInterface, int i) {
        m8715a(dialogInterface, i);
    }

    public static /* synthetic */ void lambda$m5n9G64ipvh6f6VpW160ZK2AiAg(UpdateSettingFragment updateSettingFragment, View view) {
        updateSettingFragment.m8714a(view);
    }

    /* renamed from: a */
    public void m8711a(CharSequence charSequence) {
        this.f4179c.append(charSequence);
        int lineCount = this.f4179c.getLineCount() - 100;
        if (lineCount > 0) {
            CharSequence text = this.f4179c.getText();
            int i = -1;
            for (int i2 = 0; i2 < lineCount; i2++) {
                do {
                    i++;
                    if (i < text.length()) {
                    }
                } while (text.charAt(i) != '\n');
            }
            if (i < text.length()) {
                this.f4179c.getEditableText().delete(0, i + 1);
            } else {
                m8711a("");
            }
        }
    }

    @Override // android.support.p008v4.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        f4176i.mo1511a((Object) "onCreateView");
        View inflate = layoutInflater.inflate(R.layout.update_setting_panel, viewGroup, false);
        this.f4180d = inflate;
        this.f4179c = (TextView) inflate.findViewById(R.id.tvUpdateText);
        this.f4178b = (ProgressBar) inflate.findViewById(R.id.updateProgress);
        this.f4181e = (ScrollView) inflate.findViewById(R.id.scrollView);
        this.f4177a = (Button) inflate.findViewById(R.id.btnUpdate);
        if (FirmwareManager.m8271b().f4569a) {
            this.f4178b.setVisibility(0);
            this.f4179c.setText(getString(R.string.updating));
            this.f4177a.setText(getString(R.string.updating));
            return inflate;
        }
        this.f4178b.setVisibility(4);
        this.f4179c.setText(getString(R.string.no_firmware_information));
        this.f4177a.setText(getString(R.string.update));
        FirmwareManager m8271b = FirmwareManager.m8271b();
        FirmwareManager.m8271b().m8296a(1, this);
        RobotVersionInfo m8297a = m8271b.m8297a(1);
        FirmwareInfo m8270b = m8271b.m8270b(1);
        FirmwareManager.m8271b().m8288a(new C1746c(new C1744a()));
        if (m8297a == null || m8270b == null) {
            this.f4179c.setText(getResources().getString(R.string.check_firmware_info));
            m8271b.m8259c();
        }
        return inflate;
    }

    @Override // android.support.p008v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FirmwareManager.m8271b().unregisterFirmwareManagerEventListener(this);
    }

    @Override // com.navatics.app.framework.firmware.FirmwareManager.InterfaceC1816c
    /* renamed from: a */
    public void mo8234a(RobotVersionInfo robotVersionInfo, NvError nvError) {
        C3044k c3044k = f4176i;
        c3044k.mo1500c((Object) ("onRobotFirmwareVersion " + robotVersionInfo));
        if (nvError.m6266a() != 0) {
            m8711a(Html.fromHtml("<font color='#ff0000'>(" + nvError.m6263b() + ")</font><br>"));
            return;
        }
        this.f4182f = robotVersionInfo;
        if (this.f4178b.getVisibility() == 0) {
            this.f4178b.setVisibility(8);
        }
        m8712a(robotVersionInfo);
    }

    @Override // com.navatics.app.framework.firmware.FirmwareManager.InterfaceC1816c
    /* renamed from: a */
    public void mo8233a(FirmwareInfo firmwareInfo, NvError nvError) {
        C3044k c3044k = f4176i;
        c3044k.mo1500c((Object) ("onServerLatestFirmwareVersion " + firmwareInfo));
    }

    @Override // com.navatics.app.framework.firmware.FirmwareManager.InterfaceC1816c
    /* renamed from: a */
    public void mo8235a(RobotVersionInfo robotVersionInfo, FirmwareInfo firmwareInfo) {
        C3044k c3044k = f4176i;
        c3044k.mo1500c((Object) ("onNewVersionAvailable : " + robotVersionInfo + ", " + firmwareInfo));
        this.f4183g = firmwareInfo;
        m8708b(this.f4182f, this.f4183g);
    }

    /* renamed from: b */
    public void m8710b() {
        this.f4177a.setText(getString(R.string.update));
        this.f4177a.setEnabled(true);
        this.f4177a.setBackgroundResource(R.drawable.firmware_update_btn_update_bg);
        this.f4177a.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$UpdateSettingFragment$m5n9G64ipvh6f6VpW160ZK2AiAg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpdateSettingFragment.lambda$m5n9G64ipvh6f6VpW160ZK2AiAg(UpdateSettingFragment.this, view);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m8714a(View view) {
        if (FirmwareManager.m8271b().m8297a(1) == null) {
            if (getContext() == null) {
                return;
            }
            new AlertDialog.Builder(getContext()).setIcon(17301543).setTitle("Warning!").setMessage("We don't know the firmware version of the robot, version downgrade is unsupported, use it on your own risk.").setPositiveButton("YES, I know what will happen.", new DialogInterface.OnClickListener() { // from class: com.navatics.app.fragments.UpdateSettingFragment.1
                {
                    UpdateSettingFragment.this = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    UpdateSettingFragment.this.m8707c();
                }
            }).setNegativeButton("NO", new DialogInterface.OnClickListener() { // from class: com.navatics.app.fragments.-$$Lambda$UpdateSettingFragment$G9-8feoZ0vb5Z1-oIBFVbnVyzIE
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UpdateSettingFragment.m13047lambda$G98feoZ0vb5Z1oIBFVbnVyzIE(dialogInterface, i);
                }
            }).create().show();
            return;
        }
        m8707c();
    }

    /* renamed from: c */
    public void m8707c() {
        this.f4177a.setEnabled(false);
        this.f4177a.setBackgroundResource(R.drawable.firmware_update_btn_disable);
        FirmwareManager.m8271b().m8292a(this.f4183g);
    }

    /* renamed from: b */
    private void m8708b(RobotVersionInfo robotVersionInfo, FirmwareInfo firmwareInfo) {
        this.f4179c.setText("");
        if (robotVersionInfo != null) {
            this.f4179c.setText(String.format(getResources().getString(R.string.current_firmware_version), robotVersionInfo.toString()));
        } else {
            TextView textView = this.f4179c;
            textView.setText(getString(R.string.get_robot_version_failed) + "\n");
        }
        this.f4179c.append("\n");
        C3044k c3044k = f4176i;
        c3044k.mo1511a((Object) ("robotVersionInfo = " + robotVersionInfo + ", firmwareInfo " + firmwareInfo));
        if (firmwareInfo != null) {
            TextView textView2 = this.f4179c;
            textView2.append(getResources().getString(R.string.latest_version_) + firmwareInfo.getVersionValue() + "\n");
            if (robotVersionInfo == null || FirmwareManager.m8291a(firmwareInfo, robotVersionInfo)) {
                this.f4179c.append(firmwareInfo.getRemark());
                m8710b();
                return;
            }
            this.f4177a.setEnabled(false);
            this.f4177a.setBackgroundResource(R.drawable.firmware_update_btn_disable);
            return;
        }
        this.f4179c.append("\n");
        this.f4179c.append(getResources().getString(R.string.get_server_version_failed));
    }

    /* renamed from: a */
    private void m8712a(RobotVersionInfo robotVersionInfo) {
        this.f4179c.setText("");
        if (robotVersionInfo != null) {
            this.f4179c.setText(String.format(getResources().getString(R.string.current_firmware_version), robotVersionInfo.toString()));
        } else {
            TextView textView = this.f4179c;
            textView.setText(getString(R.string.get_robot_version_failed) + "\n");
        }
        this.f4179c.append("\n");
        C3044k c3044k = f4176i;
        c3044k.mo1511a((Object) ("robotVersionInfo = " + robotVersionInfo));
        this.f4179c.append("\n");
        this.f4179c.append(getResources().getString(R.string.latest_version));
        this.f4177a.setEnabled(false);
        this.f4177a.setBackgroundResource(R.drawable.firmware_update_btn_disable);
    }

    /* renamed from: com.navatics.app.fragments.UpdateSettingFragment$c */
    /* loaded from: classes.dex */
    public class C1746c extends FirmwareManager.AbstractC1817d {
        public static /* synthetic */ void lambda$5s_qHbCRCDqxTBJFxxtFOn4Wjs0(C1746c c1746c) {
            c1746c.m8705d();
        }

        public static /* synthetic */ void lambda$ypKKLn6tm9w0BRXG1sbaVV1xty4(C1746c c1746c, long j) {
            c1746c.m8706b(j);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1746c(UpdateLogger updateLogger) {
            super(updateLogger);
            UpdateSettingFragment.this = r1;
        }

        @Override // com.navatics.app.framework.firmware.FirmwareManager.AbstractC1817d
        /* renamed from: a */
        public void mo8232a(FirmwareInfo firmwareInfo, NvError nvError) {
            if (nvError.m6266a() != 0) {
                UpdateSettingFragment.this.m8711a(Html.fromHtml("<br><font color='#ff0000'>Download firmware from server failed</font><br>"));
                UpdateSettingFragment.this.m8710b();
            }
        }

        @Override // com.navatics.app.framework.firmware.Firmware.InterfaceC1807b
        /* renamed from: a */
        public void mo8184a() {
            UpdateSettingFragment.f4176i.mo1511a((Object) "onUpdateStart");
            UpdateSettingFragment.this.f4180d.post(new Runnable() { // from class: com.navatics.app.fragments.-$$Lambda$UpdateSettingFragment$c$5s_qHbCRCDqxTBJFxxtFOn4Wjs0
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateSettingFragment.C1746c.lambda$5s_qHbCRCDqxTBJFxxtFOn4Wjs0(UpdateSettingFragment.C1746c.this);
                }
            });
        }

        /* renamed from: d */
        public /* synthetic */ void m8705d() {
            UpdateSettingFragment.this.f4179c.setText(UpdateSettingFragment.this.getResources().getString(R.string.updating));
            UpdateSettingFragment.this.f4177a.setText(UpdateSettingFragment.this.getResources().getString(R.string.updating));
            UpdateSettingFragment.this.f4177a.setBackgroundResource(R.drawable.firmware_update_btn_disable);
            UpdateSettingFragment.this.f4177a.setClickable(false);
            UpdateSettingFragment.this.f4178b.setProgress(0);
            UpdateSettingFragment.this.f4178b.setVisibility(0);
        }

        /* renamed from: b */
        public /* synthetic */ void m8706b(long j) {
            UpdateSettingFragment.this.f4178b.setProgress((int) j);
        }

        @Override // com.navatics.app.framework.firmware.Firmware.InterfaceC1807b
        /* renamed from: a */
        public void mo8183a(final long j) {
            UpdateSettingFragment.this.f4180d.post(new Runnable() { // from class: com.navatics.app.fragments.-$$Lambda$UpdateSettingFragment$c$ypKKLn6tm9w0BRXG1sbaVV1xty4
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateSettingFragment.C1746c.lambda$ypKKLn6tm9w0BRXG1sbaVV1xty4(UpdateSettingFragment.C1746c.this, j);
                }
            });
        }

        @Override // com.navatics.app.framework.firmware.Firmware.InterfaceC1807b
        /* renamed from: b */
        public void mo8181b() {
            UpdateSettingFragment.f4176i.mo1511a((Object) "onUpdateSuccess");
            UpdateSettingFragment.this.f4179c.setText(UpdateSettingFragment.this.getResources().getString(R.string.update_success));
            UpdateSettingFragment.this.f4177a.setText(UpdateSettingFragment.this.getResources().getString(R.string.update_success));
        }

        @Override // com.navatics.app.framework.firmware.Firmware.InterfaceC1807b
        /* renamed from: a */
        public void mo8182a(Throwable th) {
            UpdateSettingFragment.this.f4179c.setText(UpdateSettingFragment.this.getResources().getString(R.string.update_error));
        }
    }

    /* renamed from: com.navatics.app.fragments.UpdateSettingFragment$b */
    /* loaded from: classes.dex */
    static class HandlerC1745b extends Handler {

        /* renamed from: a */
        UpdateSettingFragment f4187a;

        HandlerC1745b(UpdateSettingFragment updateSettingFragment) {
            this.f4187a = updateSettingFragment;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (message.arg1 == 1) {
                        UpdateSettingFragment updateSettingFragment = this.f4187a;
                        updateSettingFragment.m8711a(Html.fromHtml("<font color='#000000'>" + message.obj + "</font><br>"));
                    } else if (message.arg1 == 2) {
                        UpdateSettingFragment updateSettingFragment2 = this.f4187a;
                        updateSettingFragment2.m8711a(Html.fromHtml("<font color='#00ff00'>" + message.obj + "</font><br>"));
                    } else if (message.arg1 == 3) {
                        UpdateSettingFragment updateSettingFragment3 = this.f4187a;
                        updateSettingFragment3.m8711a(Html.fromHtml("<font color='#FFFF00'>" + message.obj + "</font><br>"));
                    } else if (message.arg1 == 4) {
                        UpdateSettingFragment updateSettingFragment4 = this.f4187a;
                        updateSettingFragment4.m8711a(Html.fromHtml("<font color='#ff0000'>" + message.obj + "</font><br>"));
                    }
                    this.f4187a.f4181e.scrollTo(0, this.f4187a.f4179c.getBottom());
                    return;
                case 2:
                    int i = (message.arg1 * 100) / message.arg2;
                    this.f4187a.f4178b.setProgress(i);
                    Button button = this.f4187a.f4177a;
                    button.setText(i + "%");
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.navatics.app.fragments.UpdateSettingFragment$a */
    /* loaded from: classes.dex */
    class C1744a implements UpdateLogger {
        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: a */
        public void mo8157a(String str) {
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: a */
        public void mo8156a(String str, Throwable th) {
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: b */
        public void mo8155b(String str) {
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: c */
        public void mo8154c(String str) {
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: d */
        public void mo8153d(String str) {
        }

        C1744a() {
            UpdateSettingFragment.this = r1;
        }

        @Override // com.navatics.app.framework.firmware.UpdateLogger
        /* renamed from: a */
        public void mo8158a(long j, long j2) {
            UpdateSettingFragment.this.f4184h.obtainMessage(2, (int) j, (int) j2).sendToTarget();
        }
    }
}
