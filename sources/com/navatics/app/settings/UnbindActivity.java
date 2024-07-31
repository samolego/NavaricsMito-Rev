package com.navatics.app.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.utils.StringUtils;
import com.navatics.robot.transport.NvDeviceInfo;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.SPCloud;
import com.senseplay.sdk.model.cloud.BindDevice;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;
import io.reactivex.p099e.Schedulers;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class UnbindActivity extends SettingsActivity {

    /* renamed from: d */
    Disposable f5084d;

    /* renamed from: lambda$rR-B6L1kinAuSXFLV14xYpxQZ1I */
    public static /* synthetic */ void m13092lambda$rRB6L1kinAuSXFLV14xYpxQZ1I(UnbindActivity unbindActivity, NvDeviceInfo nvDeviceInfo) {
        unbindActivity.m7449a(nvDeviceInfo);
    }

    public static /* synthetic */ void lambda$t9_pnJ68txPdPyWDu_1ahifwxS0(UnbindActivity unbindActivity, ObservableEmitter observableEmitter, List list) {
        unbindActivity.m7447a(observableEmitter, list);
    }

    public static /* synthetic */ void lambda$vrRkajRQEvuzFGlb53bgIC2sWP0(UnbindActivity unbindActivity, ObservableEmitter observableEmitter) {
        unbindActivity.m7448a(observableEmitter);
    }

    @Override // com.navatics.app.settings.SettingsActivity, com.navatics.app.activities.StatusBarLightActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        m7454a(new UnbindDescription(this));
        m7453b();
    }

    @Override // com.navatics.app.settings.SettingsActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f5084d = m7446c().m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3106a(new Consumer() { // from class: com.navatics.app.settings.-$$Lambda$UnbindActivity$rR-B6L1kinAuSXFLV14xYpxQZ1I
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                UnbindActivity.m13092lambda$rRB6L1kinAuSXFLV14xYpxQZ1I(UnbindActivity.this, (NvDeviceInfo) obj);
            }
        }, new Consumer() { // from class: com.navatics.app.settings.-$$Lambda$e27-Kr4VJxN1zC_AGmQwWE7CADQ
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }, new InterfaceC2848a() { // from class: com.navatics.app.settings.-$$Lambda$7AjERsauZq1fJNtW3C1mDp8hkUo
            @Override // io.reactivex.p096b.InterfaceC2848a
            public final void run() {
                UnbindActivity.this.m7453b();
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m7449a(NvDeviceInfo nvDeviceInfo) throws Exception {
        m7454a(new UnbindSettingDeviceItem(this, nvDeviceInfo));
    }

    @Override // com.navatics.app.settings.SettingsActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Disposable disposable = this.f5084d;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.f5084d.dispose();
    }

    /* renamed from: c */
    private Observable<NvDeviceInfo> m7446c() {
        return Observable.m3097a(new ObservableOnSubscribe() { // from class: com.navatics.app.settings.-$$Lambda$UnbindActivity$vrRkajRQEvuzFGlb53bgIC2sWP0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                UnbindActivity.lambda$vrRkajRQEvuzFGlb53bgIC2sWP0(UnbindActivity.this, observableEmitter);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m7448a(final ObservableEmitter observableEmitter) throws Exception {
        NvUser m7806d = NvUserManager.m7828b().m7806d();
        if (m7806d == null) {
            observableEmitter.onComplete();
        } else {
            SPCloud.getInstance().getBindList(m7806d.getSsUsrInfo().getTarget().getAccessToken(), new MCallBack() { // from class: com.navatics.app.settings.-$$Lambda$UnbindActivity$t9_pnJ68txPdPyWDu_1ahifwxS0
                @Override // com.senseplay.mframe.client.MCallBack
                public final void onResult(Object obj) {
                    UnbindActivity.lambda$t9_pnJ68txPdPyWDu_1ahifwxS0(UnbindActivity.this, observableEmitter, (List) obj);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m7447a(ObservableEmitter observableEmitter, List list) {
        NvDeviceInfo m7450a;
        if (list == null) {
            observableEmitter.onComplete();
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BindDevice bindDevice = (BindDevice) it.next();
            String type = bindDevice.getType();
            if (!StringUtils.m7354a(type) && type.equals("device")) {
                m7450a = m7450a(2, bindDevice);
            } else {
                m7450a = m7450a(3, bindDevice);
            }
            observableEmitter.onNext(m7450a);
        }
        observableEmitter.onComplete();
    }

    /* renamed from: a */
    private NvDeviceInfo m7450a(int i, BindDevice bindDevice) {
        return new NvDeviceInfo(i, null, null, null, bindDevice.getSn(), null, null, null, null);
    }
}
