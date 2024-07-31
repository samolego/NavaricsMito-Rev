package com.navatics.app.activities.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p008v4.view.ViewCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.navatics.app.R;
import com.navatics.app.activities.OperationalRobotActivity;
import com.navatics.app.framework.NvRobot;
import com.navatics.app.widget.PreviewLoadingOverlay;
import com.navatics.robot.transport.StorageInfo;
import com.navatics.robot.transport.WhiteBalance;
import com.navatics.robot.transport.p063b.NvExceptionHandler;
import com.navatics.robot.transport.p063b.NvObserver;
import hu.akarnokd.rxjava2.consumers.CompletableConsumers;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class CmdTestActivity extends OperationalRobotActivity {

    /* renamed from: b */
    private static final C3044k f3994b = C3044k.m1564a(CmdTestActivity.class);
    @BindView
    Button btnReset;
    @BindView
    Button btnSend;

    /* renamed from: c */
    private HashMap<String, Object> f3995c = new HashMap<>();

    /* renamed from: d */
    private CompositeDisposable f3996d = new CompositeDisposable();
    @BindView
    Switch getCameraMode;
    @BindView
    Switch getExposeMode;
    @BindView
    Switch getExposeValue;
    @BindView
    Switch getFps;
    @BindView
    Switch getISO;
    @BindView
    Switch getRes;
    @BindView
    Switch getSdInfo;
    @BindView
    Switch getShutterSpeed;
    @BindView
    Switch getWBMode;
    @BindView
    Switch getWBValue;
    @BindView
    Switch getWideAngleMode;
    @BindView
    PreviewLoadingOverlay loadingOverlay;
    @BindView
    Switch recordStart;
    @BindView
    Switch recordStop;
    @BindView
    Switch setExposureMode;
    @BindView
    Switch setExposureValue;
    @BindView
    Switch setFPS;
    @BindView
    Switch setISO;
    @BindView
    Switch setRes;
    @BindView
    Switch setShutterSpeed;
    @BindView
    Switch setWBMode;
    @BindView
    Switch setWBValue;
    @BindView
    Switch setWideAngle;
    @BindView
    Switch switchCameraMode;
    @BindView
    Switch takePhoto;

    /* renamed from: lambda$-L_UPQbMmWmjYSVGcM9eYqtLLTY */
    public static /* synthetic */ void m13028lambda$L_UPQbMmWmjYSVGcM9eYqtLLTY(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, Integer num) {
        cmdTestActivity.m8909b(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$0a7Y46eQ24gv0azuIreQbdQPaFs(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8875k(completableEmitter);
    }

    public static /* synthetic */ void lambda$2JwXTexN1Wc4PA4VND9UE_mGqD8(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, Integer num) {
        cmdTestActivity.m8914a(completableEmitter, num);
    }

    /* renamed from: lambda$2Zav1wWtNkCM2Nx_UR1-G9Zn1BM */
    public static /* synthetic */ void m13029lambda$2Zav1wWtNkCM2Nx_UR1G9Zn1BM(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$30uhsk_jKPQlwhHI8wYFSnmgjyo(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8890g(completableEmitter);
    }

    public static /* synthetic */ void lambda$3BC_QAnhNBgbGVYQMSF8uO4139c(CmdTestActivity cmdTestActivity) {
        cmdTestActivity.m8853x();
    }

    /* renamed from: lambda$4L_k_ojY8N-mjQigtnIVQ_az0ms */
    public static /* synthetic */ void m13030lambda$4L_k_ojY8NmjQigtnIVQ_az0ms(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8902d(completableEmitter);
    }

    public static /* synthetic */ void lambda$588JIzp2aZWMmcl1SyBCQdC5sCw(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$6GwObgrB4lYt5q9iErkw_Nhn7XI(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, StorageInfo storageInfo) {
        cmdTestActivity.m8917a(completableEmitter, storageInfo);
    }

    public static /* synthetic */ void lambda$6THjUsH3zOjSWUZWb_pNaJrwsBI(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$8j5uTbRAPS37OdPv9j6WF2G4iNE(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$AV7vs8Aw2wfJcW3gUz_1dIRQ7j8(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    /* renamed from: lambda$CGHyk17-YWynVhgoeKFNn1Qp5-E */
    public static /* synthetic */ void m13031lambda$CGHyk17YWynVhgoeKFNn1Qp5E(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, Boolean bool) {
        cmdTestActivity.m8901d(completableEmitter, bool);
    }

    /* renamed from: lambda$EPudYX5NTi7alq-Go0rt0KMePcE */
    public static /* synthetic */ void m13032lambda$EPudYX5NTi7alqGo0rt0KMePcE(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8882i(completableEmitter);
    }

    public static /* synthetic */ void lambda$FQLwX8pyhh0hZ7__JlpkNZril3Y(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$FaI8z0k3Jsfc1PkzWs0Mdurd8Pc(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8918a(completableEmitter);
    }

    public static /* synthetic */ void lambda$HqFVjg0bjslvMeCLRCtaAgkNLRc(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, Boolean bool) {
        cmdTestActivity.m8905c(completableEmitter, bool);
    }

    public static /* synthetic */ void lambda$P843IS37tibsY0pvICrZmAG6xPo(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, Integer num) {
        cmdTestActivity.m8881i(completableEmitter, num);
    }

    /* renamed from: lambda$PEnTrEROvMBD2uERZJrliXFV0-8 */
    public static /* synthetic */ void m13033lambda$PEnTrEROvMBD2uERZJrliXFV08(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$Pif3xu6D0p0bAAsEHu4VwiMnRjM(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, Integer num) {
        cmdTestActivity.m8900d(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$T29IkP5B0ukE7YKc_OmEPLpgCQM(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8866n(completableEmitter);
    }

    public static /* synthetic */ void lambda$THv8_EPZuXvnZg2tgH1dEQ2VWCU(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8872l(completableEmitter);
    }

    /* renamed from: lambda$Tocu6WnYu_FwXiLWkvglKb_8-OQ */
    public static /* synthetic */ void m13034lambda$Tocu6WnYu_FwXiLWkvglKb_8OQ(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    /* renamed from: lambda$YJ-p1hJIC2PByIMP-hBcCSC798U */
    public static /* synthetic */ void m13035lambda$YJp1hJIC2PByIMPhBcCSC798U(CmdTestActivity cmdTestActivity) {
        cmdTestActivity.m8852y();
    }

    public static /* synthetic */ void lambda$_hPualJNeTxTTVnGiLbkGP5NGXM(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, Integer num) {
        cmdTestActivity.m8885h(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$aCTf9TDbq3g2A1a7Jti1jai0iHo(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, Integer num) {
        cmdTestActivity.m8889g(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$aPXLKhiH6CWRZeGfKdkPo59wCmk(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8886h(completableEmitter);
    }

    public static /* synthetic */ void lambda$d_hDmT4sC6Eoil57BTNLgoD9GBE(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8911b(completableEmitter);
    }

    public static /* synthetic */ void lambda$e9CUgjfAYqdkU7Mw6FSnU9CpXoQ(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$fUtuTVS5oPQzju4QfcXoF2KCEg8(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8878j(completableEmitter);
    }

    public static /* synthetic */ void lambda$gfE8v8sYHRk4eNOosqjSD2Ia8AY(CmdTestActivity cmdTestActivity) {
        cmdTestActivity.m8851z();
    }

    public static /* synthetic */ void lambda$gfWRP2_SWeLKqCl4dtoJsmtYtDM(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8898e(completableEmitter);
    }

    public static /* synthetic */ void lambda$hT2_vAN1h1KPxoxtu8tABZ7fLT4(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8863o(completableEmitter);
    }

    public static /* synthetic */ void lambda$iB67468r398h6MLt8OPZvlkpCKo(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$iHcVuMiLmiFLOXSi3u_SvElcmxE(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, WhiteBalance whiteBalance) {
        cmdTestActivity.m8916a(completableEmitter, whiteBalance);
    }

    public static /* synthetic */ void lambda$ivfzELiwPG9tdkLcavWFg6FhYIY(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, Boolean bool) {
        cmdTestActivity.m8910b(completableEmitter, bool);
    }

    public static /* synthetic */ void lambda$jOlTGuvgNygmCVfh4BthvKEL6YM(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, Integer num) {
        cmdTestActivity.m8893f(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$kNqWeI_MnhuxdA7mRINTy0XhZbo(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, Integer num) {
        cmdTestActivity.m8904c(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$kzMdBaZ9kqLQROGk04lyOU893MY(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$oHKy6yVH_jWTepXlCzZD5LIoH28(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8894f(completableEmitter);
    }

    public static /* synthetic */ void lambda$odrRibkFM34BoUpqhQBnpD_rThs(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$p32BLHofcALPdqT8CvRr9VKHZH4(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    /* renamed from: lambda$rE61tLR6GyAcP-L8WrLCH9N0GeE */
    public static /* synthetic */ void m13036lambda$rE61tLR6GyAcPL8WrLCH9N0GeE(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8906c(completableEmitter);
    }

    public static /* synthetic */ void lambda$t_OWaPH8B27hb6GMJojAdfiT2xg(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    /* renamed from: lambda$vruaXYOCyyhhGrJ42-C_TK0Lnb8 */
    public static /* synthetic */ void m13037lambda$vruaXYOCyyhhGrJ42C_TK0Lnb8(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter) {
        cmdTestActivity.m8869m(completableEmitter);
    }

    /* renamed from: lambda$y4aJ5-diGbkR6oziCQq-h4fHC4A */
    public static /* synthetic */ void m13038lambda$y4aJ5diGbkR6oziCQqh4fHC4A(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, Boolean bool) {
        cmdTestActivity.m8915a(completableEmitter, bool);
    }

    public static /* synthetic */ void lambda$yaZOEhtjKm8WFsQge_vs8ePstic(CmdTestActivity cmdTestActivity, CompletableEmitter completableEmitter, Integer num) {
        cmdTestActivity.m8897e(completableEmitter, num);
    }

    public static /* synthetic */ void lambda$ysm2vx2Bgt7uwz690Vvx54PxEpo(CompletableEmitter completableEmitter, Throwable th) {
        completableEmitter.tryOnError(th);
    }

    public static /* synthetic */ void lambda$zwUVv73pCEptqnOlq_6mgQLPM1c(CmdTestActivity cmdTestActivity, Throwable th) {
        cmdTestActivity.m8912a(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.activities.LocationActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.cmd_test_activity);
        ButterKnife.m12805a(this);
    }

    @OnClick
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnReset) {
            m8895f();
        } else if (id != R.id.btnSend) {
        } else {
            m8891g();
        }
    }

    /* renamed from: f */
    private void m8895f() {
        this.recordStart.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.recordStop.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.takePhoto.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.getCameraMode.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.getFps.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.getRes.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.getWideAngleMode.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.getExposeMode.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.getExposeValue.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.getISO.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.getShutterSpeed.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.getWBMode.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.getWBValue.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.setFPS.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.setExposureMode.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.setExposureValue.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.setISO.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.setRes.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.setShutterSpeed.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.setWBMode.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.setWBValue.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.setWideAngle.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.getSdInfo.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f3995c.clear();
    }

    /* renamed from: g */
    private void m8891g() {
        f3994b.mo1511a((Object) "handleSend");
        ArrayList arrayList = new ArrayList();
        if (this.getSdInfo.isChecked()) {
            arrayList.add(m8870m());
        }
        if (this.recordStart.isChecked()) {
            arrayList.add(m8883i());
        }
        if (this.recordStop.isChecked()) {
            arrayList.add(m8879j());
        }
        if (this.takePhoto.isChecked()) {
            arrayList.add(m8876k());
        }
        if (this.switchCameraMode.isChecked()) {
            arrayList.add(m8873l());
        }
        if (this.getCameraMode.isChecked()) {
            arrayList.add(m8867n());
        }
        if (this.getFps.isChecked()) {
            arrayList.add(m8856u());
        }
        if (this.getRes.isChecked()) {
            arrayList.add(m8857t());
        }
        if (this.getWideAngleMode.isChecked()) {
            arrayList.add(m8858s());
        }
        if (this.getExposeMode.isChecked()) {
            arrayList.add(m8859r());
        }
        if (this.getExposeValue.isChecked()) {
            arrayList.add(m8860q());
        }
        if (this.getISO.isChecked()) {
            arrayList.add(m8861p());
        }
        if (this.getShutterSpeed.isChecked()) {
            arrayList.add(m8864o());
        }
        if (this.getWBMode.isChecked()) {
            arrayList.add(m8855v());
        }
        if (this.getWBValue.isChecked()) {
            arrayList.add(m8854w());
        }
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("handleSend, list size " + arrayList.size()));
        m8907b(true);
        CompletableConsumers.m3494a(Completable.m3258a(arrayList).m3259a(AndroidSchedulers.m3250a()), this.f3996d, new InterfaceC2848a() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$gfE8v8sYHRk4eNOosqjSD2Ia8AY
            @Override // io.reactivex.p096b.InterfaceC2848a
            public final void run() {
                CmdTestActivity.lambda$gfE8v8sYHRk4eNOosqjSD2Ia8AY(CmdTestActivity.this);
            }
        }, new Consumer() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$zwUVv73pCEptqnOlq_6mgQLPM1c
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                CmdTestActivity.lambda$zwUVv73pCEptqnOlq_6mgQLPM1c(CmdTestActivity.this, (Throwable) obj);
            }
        });
    }

    /* renamed from: z */
    public /* synthetic */ void m8851z() throws Exception {
        m8887h();
        m8907b(false);
        f3994b.mo1511a((Object) "loadSettingFromRobot done. showLoadingCover false");
    }

    /* renamed from: a */
    public /* synthetic */ void m8912a(Throwable th) throws Exception {
        th.printStackTrace();
        m8887h();
        m8907b(false);
        f3994b.mo1504b((Object) "loadSettingFromRobot err. showLoadingCover false");
    }

    /* renamed from: h */
    private void m8887h() {
        if (this.f3995c.containsKey("get_sdinfo")) {
            this.getSdInfo.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("sw_cm_mode")) {
            this.switchCameraMode.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("start_record")) {
            this.recordStart.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("stop_record")) {
            this.recordStop.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("take_photo")) {
            this.takePhoto.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("get_cm_mode")) {
            this.getCameraMode.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("get_iso")) {
            this.getISO.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("get_exposure_value")) {
            this.getExposeValue.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("get_exposure_mode")) {
            this.getExposeMode.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("get_wide_angle_mode")) {
            this.getWideAngleMode.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("get_res")) {
            this.getRes.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("get_fps")) {
            this.getFps.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("get_wb_mode")) {
            this.getWBMode.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("get_wb_value")) {
            this.getWBValue.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("get_sdinfo")) {
            this.getSdInfo.setTextColor(-16711936);
        }
        if (this.f3995c.containsKey("get_shutter_speed")) {
            this.getShutterSpeed.setTextColor(-16711936);
        }
    }

    /* renamed from: b */
    private void m8907b(boolean z) {
        if (z) {
            runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$YJ-p1hJIC2PByIMP-hBcCSC798U
                @Override // java.lang.Runnable
                public final void run() {
                    CmdTestActivity.m13035lambda$YJp1hJIC2PByIMPhBcCSC798U(CmdTestActivity.this);
                }
            });
        } else {
            runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$3BC_QAnhNBgbGVYQMSF8uO4139c
                @Override // java.lang.Runnable
                public final void run() {
                    CmdTestActivity.lambda$3BC_QAnhNBgbGVYQMSF8uO4139c(CmdTestActivity.this);
                }
            });
        }
    }

    /* renamed from: y */
    public /* synthetic */ void m8852y() {
        this.loadingOverlay.setVisibility(0);
    }

    /* renamed from: x */
    public /* synthetic */ void m8853x() {
        this.loadingOverlay.setVisibility(8);
    }

    /* renamed from: i */
    private Completable m8883i() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$hT2_vAN1h1KPxoxtu8tABZ7fLT4
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.lambda$hT2_vAN1h1KPxoxtu8tABZ7fLT4(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: o */
    public /* synthetic */ void m8863o(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("recordStart but not connected"));
        } else {
            robot.m7683k().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$CGHyk17-YWynVhgoeKFNn1Qp5-E
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.m13031lambda$CGHyk17YWynVhgoeKFNn1Qp5E(CmdTestActivity.this, completableEmitter, (Boolean) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$p32BLHofcALPdqT8CvRr9VKHZH4
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.lambda$p32BLHofcALPdqT8CvRr9VKHZH4(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: d */
    public /* synthetic */ void m8901d(CompletableEmitter completableEmitter, Boolean bool) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("start_record value : " + bool));
        this.f3995c.put("start_record", bool);
        completableEmitter.onComplete();
    }

    /* renamed from: j */
    private Completable m8879j() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$T29IkP5B0ukE7YKc_OmEPLpgCQM
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.lambda$T29IkP5B0ukE7YKc_OmEPLpgCQM(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: n */
    public /* synthetic */ void m8866n(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("recordStop but not connected"));
        } else {
            robot.m7682l().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$HqFVjg0bjslvMeCLRCtaAgkNLRc
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.lambda$HqFVjg0bjslvMeCLRCtaAgkNLRc(CmdTestActivity.this, completableEmitter, (Boolean) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$iB67468r398h6MLt8OPZvlkpCKo
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.lambda$iB67468r398h6MLt8OPZvlkpCKo(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: c */
    public /* synthetic */ void m8905c(CompletableEmitter completableEmitter, Boolean bool) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("stop_record value : " + bool));
        this.f3995c.put("stop_record", bool);
        completableEmitter.onComplete();
    }

    /* renamed from: k */
    private Completable m8876k() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$vruaXYOCyyhhGrJ42-C_TK0Lnb8
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.m13037lambda$vruaXYOCyyhhGrJ42C_TK0Lnb8(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: m */
    public /* synthetic */ void m8869m(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("takePhoto but not connected"));
        } else {
            robot.m7679o().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$ivfzELiwPG9tdkLcavWFg6FhYIY
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.lambda$ivfzELiwPG9tdkLcavWFg6FhYIY(CmdTestActivity.this, completableEmitter, (Boolean) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$e9CUgjfAYqdkU7Mw6FSnU9CpXoQ
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.lambda$e9CUgjfAYqdkU7Mw6FSnU9CpXoQ(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: b */
    public /* synthetic */ void m8910b(CompletableEmitter completableEmitter, Boolean bool) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("take_photo value : " + bool));
        this.f3995c.put("take_photo", bool);
        completableEmitter.onComplete();
    }

    /* renamed from: l */
    private Completable m8873l() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$THv8_EPZuXvnZg2tgH1dEQ2VWCU
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.lambda$THv8_EPZuXvnZg2tgH1dEQ2VWCU(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: l */
    public /* synthetic */ void m8872l(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("switchMode but not connected"));
        } else {
            robot.m7713a(1).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$y4aJ5-diGbkR6oziCQq-h4fHC4A
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.m13038lambda$y4aJ5diGbkR6oziCQqh4fHC4A(CmdTestActivity.this, completableEmitter, (Boolean) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$2Zav1wWtNkCM2Nx_UR1-G9Zn1BM
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.m13029lambda$2Zav1wWtNkCM2Nx_UR1G9Zn1BM(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m8915a(CompletableEmitter completableEmitter, Boolean bool) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("sw_cm_mode value : " + bool));
        this.f3995c.put("sw_cm_mode", bool);
        completableEmitter.onComplete();
    }

    /* renamed from: m */
    private Completable m8870m() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$0a7Y46eQ24gv0azuIreQbdQPaFs
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.lambda$0a7Y46eQ24gv0azuIreQbdQPaFs(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: k */
    public /* synthetic */ void m8875k(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getSdInfo but not connected"));
        } else {
            robot.m7719E().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$6GwObgrB4lYt5q9iErkw_Nhn7XI
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.lambda$6GwObgrB4lYt5q9iErkw_Nhn7XI(CmdTestActivity.this, completableEmitter, (StorageInfo) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$6THjUsH3zOjSWUZWb_pNaJrwsBI
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.lambda$6THjUsH3zOjSWUZWb_pNaJrwsBI(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m8917a(CompletableEmitter completableEmitter, StorageInfo storageInfo) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("getSdInfo value : " + storageInfo));
        this.f3995c.put("get_sdinfo", storageInfo);
        completableEmitter.onComplete();
    }

    /* renamed from: n */
    private Completable m8867n() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$fUtuTVS5oPQzju4QfcXoF2KCEg8
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.lambda$fUtuTVS5oPQzju4QfcXoF2KCEg8(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: j */
    public /* synthetic */ void m8878j(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getCameraMode but not connected"));
        } else {
            robot.m7675s().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$P843IS37tibsY0pvICrZmAG6xPo
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.lambda$P843IS37tibsY0pvICrZmAG6xPo(CmdTestActivity.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$AV7vs8Aw2wfJcW3gUz_1dIRQ7j8
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.lambda$AV7vs8Aw2wfJcW3gUz_1dIRQ7j8(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: i */
    public /* synthetic */ void m8881i(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("getCameraMode value : " + num));
        this.f3995c.put("get_cm_mode", num);
        completableEmitter.onComplete();
    }

    /* renamed from: o */
    private Completable m8864o() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$EPudYX5NTi7alq-Go0rt0KMePcE
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.m13032lambda$EPudYX5NTi7alqGo0rt0KMePcE(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: i */
    public /* synthetic */ void m8882i(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getShutterSpeed but not connected"));
        } else {
            robot.m7723A().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$_hPualJNeTxTTVnGiLbkGP5NGXM
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.lambda$_hPualJNeTxTTVnGiLbkGP5NGXM(CmdTestActivity.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$odrRibkFM34BoUpqhQBnpD_rThs
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.lambda$odrRibkFM34BoUpqhQBnpD_rThs(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: h */
    public /* synthetic */ void m8885h(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("getShutterSpeed value : " + num));
        this.f3995c.put("get_shutter_speed", num);
        completableEmitter.onComplete();
    }

    /* renamed from: p */
    private Completable m8861p() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$aPXLKhiH6CWRZeGfKdkPo59wCmk
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.lambda$aPXLKhiH6CWRZeGfKdkPo59wCmk(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: h */
    public /* synthetic */ void m8886h(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getISO but not connected"));
        } else {
            robot.m7722B().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$aCTf9TDbq3g2A1a7Jti1jai0iHo
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.lambda$aCTf9TDbq3g2A1a7Jti1jai0iHo(CmdTestActivity.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$588JIzp2aZWMmcl1SyBCQdC5sCw
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.lambda$588JIzp2aZWMmcl1SyBCQdC5sCw(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: g */
    public /* synthetic */ void m8889g(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("getISO value : " + num));
        this.f3995c.put("get_iso", num);
        completableEmitter.onComplete();
    }

    /* renamed from: q */
    private Completable m8860q() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$30uhsk_jKPQlwhHI8wYFSnmgjyo
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.lambda$30uhsk_jKPQlwhHI8wYFSnmgjyo(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: g */
    public /* synthetic */ void m8890g(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getExposureValue but not connected"));
        } else {
            robot.m7668z().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$jOlTGuvgNygmCVfh4BthvKEL6YM
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.lambda$jOlTGuvgNygmCVfh4BthvKEL6YM(CmdTestActivity.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$Tocu6WnYu_FwXiLWkvglKb_8-OQ
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.m13034lambda$Tocu6WnYu_FwXiLWkvglKb_8OQ(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: f */
    public /* synthetic */ void m8893f(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("getExposureValue value : " + num));
        this.f3995c.put("get_exposure_value", num);
        completableEmitter.onComplete();
    }

    /* renamed from: r */
    private Completable m8859r() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$oHKy6yVH_jWTepXlCzZD5LIoH28
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.lambda$oHKy6yVH_jWTepXlCzZD5LIoH28(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: f */
    public /* synthetic */ void m8894f(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getExposureMode but not connected"));
        } else {
            robot.m7669y().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$yaZOEhtjKm8WFsQge_vs8ePstic
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.lambda$yaZOEhtjKm8WFsQge_vs8ePstic(CmdTestActivity.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$FQLwX8pyhh0hZ7__JlpkNZril3Y
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.lambda$FQLwX8pyhh0hZ7__JlpkNZril3Y(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: e */
    public /* synthetic */ void m8897e(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("getExposureMode value : " + num));
        this.f3995c.put("get_exposure_mode", num);
        completableEmitter.onComplete();
    }

    /* renamed from: s */
    private Completable m8858s() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$gfWRP2_SWeLKqCl4dtoJsmtYtDM
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.lambda$gfWRP2_SWeLKqCl4dtoJsmtYtDM(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: e */
    public /* synthetic */ void m8898e(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getFOVMode but not connected"));
        } else {
            robot.m7670x().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$Pif3xu6D0p0bAAsEHu4VwiMnRjM
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.lambda$Pif3xu6D0p0bAAsEHu4VwiMnRjM(CmdTestActivity.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$ysm2vx2Bgt7uwz690Vvx54PxEpo
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.lambda$ysm2vx2Bgt7uwz690Vvx54PxEpo(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: d */
    public /* synthetic */ void m8900d(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("getFOVMode value : " + num));
        this.f3995c.put("get_wide_angle_mode", num);
        completableEmitter.onComplete();
    }

    /* renamed from: t */
    private Completable m8857t() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$4L_k_ojY8N-mjQigtnIVQ_az0ms
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.m13030lambda$4L_k_ojY8NmjQigtnIVQ_az0ms(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: d */
    public /* synthetic */ void m8902d(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getResolution but not connected"));
        } else {
            robot.m7672v().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$kNqWeI_MnhuxdA7mRINTy0XhZbo
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.lambda$kNqWeI_MnhuxdA7mRINTy0XhZbo(CmdTestActivity.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$kzMdBaZ9kqLQROGk04lyOU893MY
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.lambda$kzMdBaZ9kqLQROGk04lyOU893MY(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: c */
    public /* synthetic */ void m8904c(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("getResolution value : " + num));
        this.f3995c.put("get_res", num);
        completableEmitter.onComplete();
    }

    /* renamed from: u */
    private Completable m8856u() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$rE61tLR6GyAcP-L8WrLCH9N0GeE
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.m13036lambda$rE61tLR6GyAcPL8WrLCH9N0GeE(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: c */
    public /* synthetic */ void m8906c(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getFPS but not connected"));
        } else {
            robot.m7671w().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$-L_UPQbMmWmjYSVGcM9eYqtLLTY
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.m13028lambda$L_UPQbMmWmjYSVGcM9eYqtLLTY(CmdTestActivity.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$t_OWaPH8B27hb6GMJojAdfiT2xg
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.lambda$t_OWaPH8B27hb6GMJojAdfiT2xg(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: b */
    public /* synthetic */ void m8909b(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("getFPS value : " + num));
        this.f3995c.put("get_fps", num);
        completableEmitter.onComplete();
    }

    /* renamed from: v */
    private Completable m8855v() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$d_hDmT4sC6Eoil57BTNLgoD9GBE
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.lambda$d_hDmT4sC6Eoil57BTNLgoD9GBE(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: b */
    public /* synthetic */ void m8911b(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getWhiteBalanceMode but not connected"));
        } else {
            robot.m7721C().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$2JwXTexN1Wc4PA4VND9UE_mGqD8
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.lambda$2JwXTexN1Wc4PA4VND9UE_mGqD8(CmdTestActivity.this, completableEmitter, (Integer) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$8j5uTbRAPS37OdPv9j6WF2G4iNE
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.lambda$8j5uTbRAPS37OdPv9j6WF2G4iNE(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m8914a(CompletableEmitter completableEmitter, Integer num) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("getWhiteBalanceMode value : " + num));
        this.f3995c.put("get_wb_mode", num);
        completableEmitter.onComplete();
    }

    /* renamed from: w */
    private Completable m8854w() {
        return Completable.m3260a(new CompletableOnSubscribe() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$FaI8z0k3Jsfc1PkzWs0Mdurd8Pc
            @Override // io.reactivex.CompletableOnSubscribe
            public final void subscribe(CompletableEmitter completableEmitter) {
                CmdTestActivity.lambda$FaI8z0k3Jsfc1PkzWs0Mdurd8Pc(CmdTestActivity.this, completableEmitter);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m8918a(final CompletableEmitter completableEmitter) throws Exception {
        NvRobot robot = getRobot();
        if (robot == null) {
            completableEmitter.onError(new RuntimeException("getWhiteBalanceValue but not connected"));
        } else {
            robot.m7720D().mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$iHcVuMiLmiFLOXSi3u_SvElcmxE
                @Override // com.navatics.robot.transport.p063b.NvObserver
                public final void onNext(Object obj) {
                    CmdTestActivity.lambda$iHcVuMiLmiFLOXSi3u_SvElcmxE(CmdTestActivity.this, completableEmitter, (WhiteBalance) obj);
                }
            }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdTestActivity$PEnTrEROvMBD2uERZJrliXFV0-8
                @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                public final void onError(Throwable th) {
                    CmdTestActivity.m13033lambda$PEnTrEROvMBD2uERZJrliXFV08(CompletableEmitter.this, th);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m8916a(CompletableEmitter completableEmitter, WhiteBalance whiteBalance) throws Exception {
        C3044k c3044k = f3994b;
        c3044k.mo1511a((Object) ("getWhiteBalanceValue value : " + whiteBalance));
        this.f3995c.put("get_wb_value", whiteBalance);
        completableEmitter.onComplete();
    }
}
