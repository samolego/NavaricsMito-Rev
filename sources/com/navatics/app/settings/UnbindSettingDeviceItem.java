package com.navatics.app.settings;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.navatics.app.R;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.annotation.EventHandler;
import com.navatics.app.framework.p050b.EventPipeline;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvError;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class UnbindSettingDeviceItem extends SettingEntry {

    /* renamed from: a */
    EventPipeline f5085a;

    /* renamed from: b */
    EventPipeline f5086b;
    @BindView
    ViewGroup btnContainer;
    @BindView
    Button btnUnbind;

    /* renamed from: c */
    private final C3044k f5087c;

    /* renamed from: d */
    private NvDeviceInfo f5088d;
    @BindView
    ImageView ivDeviceIcon;
    @BindView
    ProgressBar pgUnbind;
    @BindView
    TextView tvDeviceSN;
    @BindView
    TextView tvDeviceType;

    public static /* synthetic */ void lambda$YnzuZIVJtmHCHzUrTXV14HJa4TE(UnbindSettingDeviceItem unbindSettingDeviceItem, View view) {
        unbindSettingDeviceItem.m7445a(view);
    }

    /* renamed from: lambda$anVbU5o-6ONjArOLsQEnnfYAzII */
    public static /* synthetic */ void m13093lambda$anVbU5o6ONjArOLsQEnnfYAzII(UnbindSettingDeviceItem unbindSettingDeviceItem, View view) {
        unbindSettingDeviceItem.m7443b(view);
    }

    public UnbindSettingDeviceItem(Activity activity, NvDeviceInfo nvDeviceInfo) {
        super(activity);
        this.f5087c = C3044k.m1564a(UnbindSettingDeviceItem.class);
        this.f5088d = nvDeviceInfo;
    }

    /* renamed from: d */
    private void m7442d() {
        NvConnection m7943b;
        Navatics.m7947b().m8577a(this);
        if (this.f5088d.getType() == 3) {
            GroundStation m7948a = Navatics.m7948a(this.f5088d.getSerialNumber());
            if (m7948a == null) {
                return;
            }
            this.f5085a = m7948a.m8146a();
            this.f5085a.m8577a(this);
        } else if (this.f5088d.getType() != 2 || (m7943b = Navatics.m7943b(this.f5088d.getSerialNumber())) == null) {
        } else {
            this.f5086b = m7943b.m7883d();
            this.f5086b.m8577a(this);
        }
    }

    /* renamed from: h */
    private void m7441h() {
        Navatics.m7947b().m8573b(this);
    }

    @Override // com.navatics.app.settings.SettingEntry
    /* renamed from: b */
    public void mo7430b() {
        super.mo7430b();
        m7442d();
    }

    @Override // com.navatics.app.settings.SettingEntry
    /* renamed from: c */
    public void mo7429c() {
        super.mo7429c();
        m7441h();
    }

    @Override // com.navatics.app.settings.SettingEntry
    /* renamed from: a */
    public View mo7411a() {
        this.f5093g = ((LayoutInflater) m7426g().getSystemService("layout_inflater")).inflate(R.layout.unbind_setting_device_item_layout, (ViewGroup) null, false);
        ButterKnife.m12803a(this, this.f5093g);
        if (this.f5088d.getType() == 3) {
            this.ivDeviceIcon.setImageResource(R.drawable.unbind_remote_icon);
            this.tvDeviceType.setText(m7426g().getString(R.string.remote_control));
        } else {
            this.ivDeviceIcon.setImageResource(R.drawable.unbind_buoy_icon);
            this.tvDeviceType.setText(m7426g().getString(R.string.buoy));
        }
        this.tvDeviceSN.setText(this.f5088d.getSerialNumber());
        if (m7440i()) {
            this.btnUnbind.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.settings.-$$Lambda$UnbindSettingDeviceItem$anVbU5o-6ONjArOLsQEnnfYAzII
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UnbindSettingDeviceItem.m13093lambda$anVbU5o6ONjArOLsQEnnfYAzII(UnbindSettingDeviceItem.this, view);
                }
            });
        } else {
            this.btnContainer.setBackgroundResource(R.drawable.setting_btn_disable_bg);
            this.btnUnbind.setText("UNUSABLE");
            this.btnUnbind.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.settings.-$$Lambda$UnbindSettingDeviceItem$YnzuZIVJtmHCHzUrTXV14HJa4TE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UnbindSettingDeviceItem.lambda$YnzuZIVJtmHCHzUrTXV14HJa4TE(UnbindSettingDeviceItem.this, view);
                }
            });
        }
        m7442d();
        return this.f5093g;
    }

    /* renamed from: b */
    public /* synthetic */ void m7443b(View view) {
        if (this.f5088d.getType() == 3) {
            m7438k();
        } else {
            m7437l();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m7445a(View view) {
        Toast.makeText(m7426g(), m7426g().getString(R.string.connected_device_to_unbind), 0).show();
    }

    /* renamed from: i */
    private boolean m7440i() {
        String serialNumber = this.f5088d.getSerialNumber();
        GroundStation m7948a = Navatics.m7948a(serialNumber);
        if (m7948a == null || !m7948a.m8120c()) {
            for (GroundStation groundStation : Navatics.m7932g()) {
                NvConnection m8132a = groundStation.m8132a(serialNumber);
                if (m8132a != null && m8132a.m7875j()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private void m7444a(boolean z) {
        if (z) {
            this.btnUnbind.setClickable(false);
            this.btnUnbind.setVisibility(4);
            this.pgUnbind.setVisibility(0);
            return;
        }
        this.btnUnbind.setClickable(true);
        this.btnUnbind.setVisibility(0);
        this.pgUnbind.setVisibility(4);
    }

    /* renamed from: j */
    private void m7439j() {
        this.btnContainer.setBackgroundResource(R.drawable.setting_btn_disable_bg);
        this.btnUnbind.setClickable(false);
        this.btnUnbind.setVisibility(0);
        this.btnUnbind.setText(m7426g().getString(R.string.unbind_success));
        this.pgUnbind.setVisibility(4);
    }

    /* renamed from: k */
    private void m7438k() {
        this.f5087c.mo1511a((Object) "remoteUnbind 0");
        GroundStation m7931h = Navatics.m7931h();
        if (m7931h != null) {
            this.f5087c.mo1511a((Object) "remoteUnbind 1");
            m7444a(true);
            m7931h.m8106f();
            return;
        }
        this.f5087c.mo1504b((Object) "remoteUnbind sta is null");
    }

    /* renamed from: l */
    private void m7437l() {
        this.f5087c.mo1511a((Object) "deviceUnbind 0");
        NvConnection m7930i = Navatics.m7930i();
        if (m7930i == null) {
            Toast.makeText(m7426g(), m7426g().getString(R.string.device_not_connected), 0).show();
            return;
        }
        this.f5087c.mo1511a((Object) "deviceUnbind 1");
        if (!m7930i.m7875j()) {
            Toast.makeText(m7426g(), m7426g().getString(R.string.device_not_authenticated), 0).show();
            return;
        }
        this.f5087c.mo1511a((Object) "deviceUnbind 2");
        m7444a(true);
        m7930i.m7873l();
    }

    @EventHandler(m8585b = 65566, m8584c = 1)
    void onGndStaUnbindSuccess(GroundStation groundStation) {
        this.f5087c.mo1511a((Object) "onGndStaUnbindSuccess");
        if (this.f5088d.getSerialNumber().equals(groundStation.m8104g().getSerialNumber())) {
            m7439j();
        }
    }

    @EventHandler(m8585b = 16711687, m8584c = 1)
    void onGndStaUnbindError(GroundStation groundStation, NvError nvError) {
        C3044k c3044k = this.f5087c;
        c3044k.mo1511a((Object) ("onGndStaUnbindError : " + nvError.toString()));
        if (this.f5088d.getSerialNumber().equals(groundStation.m8104g().getSerialNumber())) {
            m7444a(false);
            Context g = m7426g();
            Toast.makeText(g, m7426g().getString(R.string.remote_unbind_err) + nvError, 1).show();
        }
    }

    @EventHandler(m8585b = 65567, m8584c = 1)
    void onDeviceUnbindSuccess(NvConnection nvConnection) {
        this.f5087c.mo1511a((Object) "onDeviceUnbindSuccess");
        if (this.f5088d.getSerialNumber().equals(nvConnection.m7876i().getSerialNumber())) {
            m7439j();
        }
    }

    @EventHandler(m8585b = 16711688, m8584c = 1)
    void onDeviceUnbindError(NvConnection nvConnection, NvError nvError) {
        C3044k c3044k = this.f5087c;
        c3044k.mo1511a((Object) ("onDeviceUnbindError : " + nvError.toString()));
        if (this.f5088d.getSerialNumber().equals(nvConnection.m7876i().getSerialNumber())) {
            m7444a(false);
            Context g = m7426g();
            Toast.makeText(g, "device unbind error:" + nvError, 1).show();
        }
    }
}
