package com.navatics.app.p048a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.navatics.app.activities.base.BasePresenter;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.framework.firmware.FirmwareUpdateInfo;
import com.navatics.app.framework.firmware.FirmwareUpdateManager;
import com.navatics.app.framework.p055g.RxUtils;
import com.navatics.robot.transport.NvDeviceInfo;
import io.reactivex.p096b.Consumer;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: com.navatics.app.a.a */
/* loaded from: classes.dex */
public class FirmwareUpdatePresenter extends BasePresenter<IFirmwareUpdateView> {

    /* renamed from: c */
    private Context f3473c;

    @Override // com.navatics.app.activities.base.IPresenter
    /* renamed from: a */
    public void mo8968a(Bundle bundle) {
    }

    @Override // com.navatics.app.activities.base.IPresenter
    /* renamed from: g */
    public void mo8961g() {
    }

    public FirmwareUpdatePresenter(Context context) {
        this.f3473c = context;
        FirmwareUpdateManager.m8212a(this.f3473c).m8207a(new FirmwareUpdateManager.InterfaceC1830a() { // from class: com.navatics.app.a.a.1
            @Override // com.navatics.app.framework.firmware.FirmwareUpdateManager.InterfaceC1830a
            /* renamed from: a */
            public void mo8177a(Throwable th) {
            }

            @Override // com.navatics.app.framework.firmware.FirmwareUpdateManager.InterfaceC1830a
            /* renamed from: a */
            public void mo8178a(FirmwareUpdateInfo firmwareUpdateInfo) {
                if (FirmwareUpdatePresenter.this.m8972a() != null) {
                    ((IFirmwareUpdateView) FirmwareUpdatePresenter.this.m8972a()).mo7475a(firmwareUpdateInfo);
                }
            }
        });
    }

    /* renamed from: h */
    public void m9507h() {
        ArrayList arrayList = new ArrayList();
        SharedPreferences sharedPreferences = this.f3473c.getSharedPreferences("app_settings", 0);
        String string = sharedPreferences.getString("MITO", "0");
        String string2 = sharedPreferences.getString("Controller", "0");
        FirmwareUpdateInfo firmwareUpdateInfo = new FirmwareUpdateInfo();
        if (string.equals("0")) {
            firmwareUpdateInfo.m8229a(4);
        } else {
            firmwareUpdateInfo.m8227a(string);
            firmwareUpdateInfo.m8229a(4);
        }
        firmwareUpdateInfo.m8222c(0);
        firmwareUpdateInfo.m8224b("MITO");
        FirmwareUpdateInfo firmwareUpdateInfo2 = new FirmwareUpdateInfo();
        if (string2.equals("0")) {
            firmwareUpdateInfo2.m8229a(4);
        } else {
            firmwareUpdateInfo2.m8227a(string2);
            firmwareUpdateInfo2.m8229a(4);
        }
        firmwareUpdateInfo2.m8222c(1);
        firmwareUpdateInfo2.m8224b("Controller");
        arrayList.add(firmwareUpdateInfo);
        arrayList.add(firmwareUpdateInfo2);
        m8972a().mo7473a(arrayList);
    }

    /* renamed from: a */
    public void m9513a(NvDeviceInfo nvDeviceInfo) {
        FirmwareUpdateManager.m8212a(this.f3473c).m8199a(nvDeviceInfo).m3092a(RxUtils.m8072a()).m3107a(new Consumer<FirmwareUpdateInfo>() { // from class: com.navatics.app.a.a.2
            @Override // io.reactivex.p096b.Consumer
            /* renamed from: a */
            public void accept(FirmwareUpdateInfo firmwareUpdateInfo) throws Exception {
                if (FirmwareUpdatePresenter.this.m8972a() != null) {
                    ((IFirmwareUpdateView) FirmwareUpdatePresenter.this.m8972a()).mo7475a(firmwareUpdateInfo);
                }
            }
        }, new Consumer<Throwable>() { // from class: com.navatics.app.a.a.3
            @Override // io.reactivex.p096b.Consumer
            /* renamed from: a */
            public void accept(Throwable th) throws Exception {
            }
        });
    }

    /* renamed from: a */
    public void m9514a(NvRobot nvRobot) {
        try {
            FirmwareUpdateManager.m8212a(this.f3473c).m8200a(nvRobot).m3092a(RxUtils.m8072a()).m3107a(new Consumer<FirmwareUpdateInfo>() { // from class: com.navatics.app.a.a.4
                @Override // io.reactivex.p096b.Consumer
                /* renamed from: a */
                public void accept(FirmwareUpdateInfo firmwareUpdateInfo) throws Exception {
                    if (FirmwareUpdatePresenter.this.m8972a() != null) {
                        ((IFirmwareUpdateView) FirmwareUpdatePresenter.this.m8972a()).mo7475a(firmwareUpdateInfo);
                    }
                }
            }, new Consumer<Throwable>() { // from class: com.navatics.app.a.a.5
                @Override // io.reactivex.p096b.Consumer
                /* renamed from: a */
                public void accept(Throwable th) throws Exception {
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m9515a(FirmwareUpdateInfo firmwareUpdateInfo) {
        FirmwareUpdateManager.m8212a(this.f3473c).m8211a(firmwareUpdateInfo);
    }
}
