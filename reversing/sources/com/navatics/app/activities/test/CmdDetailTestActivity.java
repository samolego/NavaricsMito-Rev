package com.navatics.app.activities.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.navatics.app.R;
import com.navatics.app.activities.OperationalRobotActivity;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.widget.PreviewLoadingOverlay;
import com.navatics.robot.protocol.Dawn;
import com.navatics.robot.protocol.InputMessage;
import com.navatics.robot.protocol.OutputMessage;
import com.navatics.robot.transport.StorageInfo;
import com.navatics.robot.transport.WhiteBalance;
import com.navatics.robot.transport.p063b.NvAction;
import com.navatics.robot.transport.p063b.NvExceptionHandler;
import com.navatics.robot.transport.p063b.NvObserver;
import com.navatics.robot.transport.p063b.NvObserverExecutor;
import com.navatics.robot.utils.HexUtil;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class CmdDetailTestActivity extends OperationalRobotActivity implements Dawn.InterfaceC2107c {
    @BindView
    Button btnSend;
    @BindView
    PreviewLoadingOverlay loadingOverlay;
    @BindView
    Spinner requestSelector;
    @BindView
    TextView tvRecvText;
    @BindView
    TextView tvSendText;

    public static /* synthetic */ void lambda$06JCwbylLkNypufHDC54SwWsQZg(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8920o(th);
    }

    public static /* synthetic */ void lambda$42PNG3J0GM8sPgm9YI5zAhPNFYs(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8953a(th);
    }

    public static /* synthetic */ void lambda$4Y2a0SvTAdMXN9UYUpBYYanBBPU(CmdDetailTestActivity cmdDetailTestActivity, Boolean bool) {
        cmdDetailTestActivity.m8955a(bool);
    }

    public static /* synthetic */ void lambda$5vWwc2H1k2euJUlGxxu7yKsUCh8(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8925j(th);
    }

    public static /* synthetic */ void lambda$8jJ5iGJpS1Xze5vYX71hy94N6L4(CmdDetailTestActivity cmdDetailTestActivity, Integer num) {
        cmdDetailTestActivity.m8946c(num);
    }

    public static /* synthetic */ void lambda$9UoswCSjUSlAO4a6VgnrZRQfCZ4(CmdDetailTestActivity cmdDetailTestActivity, Boolean bool) {
        cmdDetailTestActivity.m8947c(bool);
    }

    public static /* synthetic */ void lambda$Ay0Ir8dizm9xDeJsHSBwMivhnyQ(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8923l(th);
    }

    public static /* synthetic */ void lambda$BS01VRYeMGMFrlcPZrQ5Bbax6Jo(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8944c(th);
    }

    /* renamed from: lambda$BS_-3-IRw5FXGPhFQMSWmfpBT6s */
    public static /* synthetic */ void m13015lambda$BS_3IRw5FXGPhFQMSWmfpBT6s(CmdDetailTestActivity cmdDetailTestActivity, WhiteBalance whiteBalance) {
        cmdDetailTestActivity.m8956a(whiteBalance);
    }

    public static /* synthetic */ void lambda$CcLcStfIXIOlUwh48sTwiUFbcZc(CmdDetailTestActivity cmdDetailTestActivity) {
        cmdDetailTestActivity.m8928i();
    }

    /* renamed from: lambda$EHz5TTiX-IJ_7yRwA7PYaMXcAN8 */
    public static /* synthetic */ void m13016lambda$EHz5TTiXIJ_7yRwA7PYaMXcAN8(CmdDetailTestActivity cmdDetailTestActivity, Integer num) {
        cmdDetailTestActivity.m8954a(num);
    }

    public static /* synthetic */ void lambda$HbnuAfvoKfp6cntJw7ssnIPwfPs(CmdDetailTestActivity cmdDetailTestActivity) {
        cmdDetailTestActivity.m8934g();
    }

    public static /* synthetic */ void lambda$IeX26EVLXTQFlWdFQGE4UEdeaXE(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8924k(th);
    }

    public static /* synthetic */ void lambda$JADlNFlXwIIE3Xm0qN94YCTab0Q(CmdDetailTestActivity cmdDetailTestActivity, byte[] bArr, int i, int i2) {
        cmdDetailTestActivity.m8952a(bArr, i, i2);
    }

    public static /* synthetic */ void lambda$OI42wG_0CKdetsO5PXmChQCxIGg(CmdDetailTestActivity cmdDetailTestActivity, Integer num) {
        cmdDetailTestActivity.m8942d(num);
    }

    public static /* synthetic */ void lambda$PV2mdOiCTg0OQphtvgbjb824N50(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8938e(th);
    }

    /* renamed from: lambda$PWYjSLHMqFP-v1qaq7cpRqoJgZw */
    public static /* synthetic */ void m13017lambda$PWYjSLHMqFPv1qaq7cpRqoJgZw(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8929h(th);
    }

    public static /* synthetic */ void lambda$U5Qr4PE98UcEBaYVKMlHXlOxD1w(CmdDetailTestActivity cmdDetailTestActivity, Boolean bool) {
        cmdDetailTestActivity.m8943d(bool);
    }

    public static /* synthetic */ void lambda$USJEZ8VPummAX_Iubh9CCSFusqI(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8935f(th);
    }

    /* renamed from: lambda$ZV4IJhw6gjfFKuI9jF3Vd3-xI6w */
    public static /* synthetic */ void m13018lambda$ZV4IJhw6gjfFKuI9jF3Vd3xI6w(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8926i(th);
    }

    public static /* synthetic */ void lambda$Zu6h94MKgtHEN978Ahw3HWvIvsE(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8949b(th);
    }

    public static /* synthetic */ void lambda$btm2msShoCf2w_84wnYungMpcf4(CmdDetailTestActivity cmdDetailTestActivity, Integer num) {
        cmdDetailTestActivity.m8930h(num);
    }

    public static /* synthetic */ void lambda$d1Pil8NgXXfzfmP275jTbuXgpbU(CmdDetailTestActivity cmdDetailTestActivity, Integer num) {
        cmdDetailTestActivity.m8939e(num);
    }

    public static /* synthetic */ void lambda$dAgEbXRbvb1wzxJMuSuV0ZOj68U(CmdDetailTestActivity cmdDetailTestActivity, StorageInfo storageInfo) {
        cmdDetailTestActivity.m8957a(storageInfo);
    }

    /* renamed from: lambda$e5cpQeYnzjBU-X5NGLpb4IT05j0 */
    public static /* synthetic */ void m13019lambda$e5cpQeYnzjBUX5NGLpb4IT05j0(CmdDetailTestActivity cmdDetailTestActivity, Integer num) {
        cmdDetailTestActivity.m8927i(num);
    }

    /* renamed from: lambda$gWrTgvdsCjh3jM2rz94xXp-L4JA */
    public static /* synthetic */ void m13020lambda$gWrTgvdsCjh3jM2rz94xXpL4JA(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8922m(th);
    }

    /* renamed from: lambda$jInsmYaWW1a1r-mCTNxo1P8a6SY */
    public static /* synthetic */ void m13021lambda$jInsmYaWW1a1rmCTNxo1P8a6SY(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8932g(th);
    }

    /* renamed from: lambda$jcF5Kz-pXK0gOHG9EgEJeYttG2g */
    public static /* synthetic */ void m13022lambda$jcF5KzpXK0gOHG9EgEJeYttG2g() {
        m8937f();
    }

    /* renamed from: lambda$kPc-Wsunt8ratsfxA398M2tyTDc */
    public static /* synthetic */ void m13023lambda$kPcWsunt8ratsfxA398M2tyTDc(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8941d(th);
    }

    public static /* synthetic */ void lambda$oxkh836eUOu0fIeM2tP5uGn1rFA(CmdDetailTestActivity cmdDetailTestActivity, String str) {
        cmdDetailTestActivity.m8945c(str);
    }

    /* renamed from: lambda$ri-3qSMRr5NpHfiRxIH5EMMrW1A */
    public static /* synthetic */ void m13024lambda$ri3qSMRr5NpHfiRxIH5EMMrW1A(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8921n(th);
    }

    public static /* synthetic */ void lambda$s0ELZYkjvd3R2EUye6Ye7vmhb4Q(CmdDetailTestActivity cmdDetailTestActivity, Boolean bool) {
        cmdDetailTestActivity.m8951b(bool);
    }

    public static /* synthetic */ void lambda$sFF3PcplA6dMeTdHViLS4Fs9_DI(CmdDetailTestActivity cmdDetailTestActivity, Integer num) {
        cmdDetailTestActivity.m8936f(num);
    }

    public static /* synthetic */ void lambda$sk2Tbw9D4qLpxOnJLIXSRfc5tqM(CmdDetailTestActivity cmdDetailTestActivity, Integer num) {
        cmdDetailTestActivity.m8933g(num);
    }

    /* renamed from: lambda$smJMnZsd4uH7D-jJajIFGKdNK_8 */
    public static /* synthetic */ void m13025lambda$smJMnZsd4uH7DjJajIFGKdNK_8(CmdDetailTestActivity cmdDetailTestActivity) {
        cmdDetailTestActivity.m8931h();
    }

    /* renamed from: lambda$uAMdx2lzfZLblV-k_KVg2rl25ak */
    public static /* synthetic */ void m13026lambda$uAMdx2lzfZLblVk_KVg2rl25ak(CmdDetailTestActivity cmdDetailTestActivity, Throwable th) {
        cmdDetailTestActivity.m8919p(th);
    }

    public static /* synthetic */ void lambda$uiHtzmJ8kYQFfdyKX4ZlCjynm4I(CmdDetailTestActivity cmdDetailTestActivity, Integer num) {
        cmdDetailTestActivity.m8950b(num);
    }

    /* renamed from: lambda$umiNS0ql3l-4nqgnwvwSQA9LN4E */
    public static /* synthetic */ void m13027lambda$umiNS0ql3l4nqgnwvwSQA9LN4E(CmdDetailTestActivity cmdDetailTestActivity, Boolean bool) {
        cmdDetailTestActivity.m8940e(bool);
    }

    @Override // com.navatics.robot.protocol.Dawn.InterfaceC2107c
    /* renamed from: a */
    public void mo6382a(OutputMessage outputMessage, InputMessage inputMessage) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.activities.LocationActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.cmd_detail_test_activity);
        ButterKnife.m12805a(this);
        Dawn m6419a = Dawn.m6419a();
        if (m6419a == null) {
            throw new RuntimeException("dawn is null");
        }
        m6419a.m6414a(this);
    }

    @Override // com.navatics.app.NvBaseActivity
    public void onGroundStationStateUpdate(GroundStation groundStation) {
        f3654a.mo1511a((Object) "onGroundStationStateUpdate");
    }

    /* renamed from: b */
    private void m8948b(boolean z) {
        if (z) {
            runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$CcLcStfIXIOlUwh48sTwiUFbcZc
                @Override // java.lang.Runnable
                public final void run() {
                    CmdDetailTestActivity.lambda$CcLcStfIXIOlUwh48sTwiUFbcZc(CmdDetailTestActivity.this);
                }
            });
        } else {
            runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$smJMnZsd4uH7D-jJajIFGKdNK_8
                @Override // java.lang.Runnable
                public final void run() {
                    CmdDetailTestActivity.m13025lambda$smJMnZsd4uH7DjJajIFGKdNK_8(CmdDetailTestActivity.this);
                }
            });
        }
    }

    /* renamed from: i */
    public /* synthetic */ void m8928i() {
        this.loadingOverlay.setVisibility(0);
    }

    /* renamed from: h */
    public /* synthetic */ void m8931h() {
        this.loadingOverlay.setVisibility(8);
    }

    @Override // com.navatics.robot.protocol.Dawn.InterfaceC2107c
    /* renamed from: a */
    public void mo6383a(OutputMessage outputMessage) {
        final String obj = outputMessage.toString();
        runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$oxkh836eUOu0fIeM2tP5uGn1rFA
            @Override // java.lang.Runnable
            public final void run() {
                CmdDetailTestActivity.lambda$oxkh836eUOu0fIeM2tP5uGn1rFA(CmdDetailTestActivity.this, obj);
            }
        });
    }

    /* renamed from: c */
    public /* synthetic */ void m8945c(String str) {
        this.tvSendText.setText(str);
    }

    @Override // com.navatics.robot.protocol.Dawn.InterfaceC2107c
    /* renamed from: a */
    public void mo6381a(OutputMessage outputMessage, final byte[] bArr, final int i, final int i2) {
        runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$JADlNFlXwIIE3Xm0qN94YCTab0Q
            @Override // java.lang.Runnable
            public final void run() {
                CmdDetailTestActivity.lambda$JADlNFlXwIIE3Xm0qN94YCTab0Q(CmdDetailTestActivity.this, bArr, i2, i);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m8952a(byte[] bArr, int i, int i2) {
        if (bArr == null || i == 0) {
            this.tvRecvText.setText("response is null");
        } else {
            this.tvRecvText.setText(new String(HexUtil.m5884a(bArr, i2, i)));
        }
    }

    /* renamed from: g */
    public /* synthetic */ void m8934g() {
        this.tvSendText.setText("Timeout");
    }

    @Override // com.navatics.robot.protocol.Dawn.InterfaceC2107c
    /* renamed from: b */
    public void mo6380b(OutputMessage outputMessage) {
        runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$HbnuAfvoKfp6cntJw7ssnIPwfPs
            @Override // java.lang.Runnable
            public final void run() {
                CmdDetailTestActivity.lambda$HbnuAfvoKfp6cntJw7ssnIPwfPs(CmdDetailTestActivity.this);
            }
        });
    }

    @OnClick
    public void onClick(View view) {
        m8948b(true);
        C3044k c3044k = f3654a;
        c3044k.mo1511a((Object) ("SelectedItemPosition " + this.requestSelector.getSelectedItemPosition()));
        switch (this.requestSelector.getSelectedItemPosition()) {
            case 0:
                getRobot().m7683k().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$umiNS0ql3l-4nqgnwvwSQA9LN4E
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.m13027lambda$umiNS0ql3l4nqgnwvwSQA9LN4E(CmdDetailTestActivity.this, (Boolean) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$uAMdx2lzfZLblV-k_KVg2rl25ak
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.m13026lambda$uAMdx2lzfZLblVk_KVg2rl25ak(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 1:
                getRobot().m7682l().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$U5Qr4PE98UcEBaYVKMlHXlOxD1w
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.lambda$U5Qr4PE98UcEBaYVKMlHXlOxD1w(CmdDetailTestActivity.this, (Boolean) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$06JCwbylLkNypufHDC54SwWsQZg
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.lambda$06JCwbylLkNypufHDC54SwWsQZg(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 2:
                getRobot().m7679o().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$9UoswCSjUSlAO4a6VgnrZRQfCZ4
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.lambda$9UoswCSjUSlAO4a6VgnrZRQfCZ4(CmdDetailTestActivity.this, (Boolean) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$ri-3qSMRr5NpHfiRxIH5EMMrW1A
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.m13024lambda$ri3qSMRr5NpHfiRxIH5EMMrW1A(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 3:
                getRobot().m7675s().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$e5cpQeYnzjBU-X5NGLpb4IT05j0
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.m13019lambda$e5cpQeYnzjBUX5NGLpb4IT05j0(CmdDetailTestActivity.this, (Integer) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$gWrTgvdsCjh3jM2rz94xXp-L4JA
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.m13020lambda$gWrTgvdsCjh3jM2rz94xXpL4JA(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 4:
                getRobot().m7713a(2).mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$s0ELZYkjvd3R2EUye6Ye7vmhb4Q
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.lambda$s0ELZYkjvd3R2EUye6Ye7vmhb4Q(CmdDetailTestActivity.this, (Boolean) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$Ay0Ir8dizm9xDeJsHSBwMivhnyQ
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.lambda$Ay0Ir8dizm9xDeJsHSBwMivhnyQ(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 5:
                getRobot().m7713a(1).mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$4Y2a0SvTAdMXN9UYUpBYYanBBPU
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.lambda$4Y2a0SvTAdMXN9UYUpBYYanBBPU(CmdDetailTestActivity.this, (Boolean) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$IeX26EVLXTQFlWdFQGE4UEdeaXE
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.lambda$IeX26EVLXTQFlWdFQGE4UEdeaXE(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 6:
                getRobot().m7672v().mo6311a(NvObserverExecutor.m6303b()).mo6313a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$btm2msShoCf2w_84wnYungMpcf4
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.lambda$btm2msShoCf2w_84wnYungMpcf4(CmdDetailTestActivity.this, (Integer) obj);
                    }
                }, new NvAction() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$jcF5Kz-pXK0gOHG9EgEJeYttG2g
                    @Override // com.navatics.robot.transport.p063b.NvAction
                    public final void run() {
                        CmdDetailTestActivity.m13022lambda$jcF5KzpXK0gOHG9EgEJeYttG2g();
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$5vWwc2H1k2euJUlGxxu7yKsUCh8
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.lambda$5vWwc2H1k2euJUlGxxu7yKsUCh8(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 7:
                getRobot().m7671w().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$sk2Tbw9D4qLpxOnJLIXSRfc5tqM
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.lambda$sk2Tbw9D4qLpxOnJLIXSRfc5tqM(CmdDetailTestActivity.this, (Integer) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$ZV4IJhw6gjfFKuI9jF3Vd3-xI6w
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.m13018lambda$ZV4IJhw6gjfFKuI9jF3Vd3xI6w(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 8:
                getRobot().m7670x().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$sFF3PcplA6dMeTdHViLS4Fs9_DI
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.lambda$sFF3PcplA6dMeTdHViLS4Fs9_DI(CmdDetailTestActivity.this, (Integer) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$PWYjSLHMqFP-v1qaq7cpRqoJgZw
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.m13017lambda$PWYjSLHMqFPv1qaq7cpRqoJgZw(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 9:
                getRobot().m7719E().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$dAgEbXRbvb1wzxJMuSuV0ZOj68U
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.lambda$dAgEbXRbvb1wzxJMuSuV0ZOj68U(CmdDetailTestActivity.this, (StorageInfo) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$jInsmYaWW1a1r-mCTNxo1P8a6SY
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.m13021lambda$jInsmYaWW1a1rmCTNxo1P8a6SY(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 10:
                getRobot().m7669y().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$d1Pil8NgXXfzfmP275jTbuXgpbU
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.lambda$d1Pil8NgXXfzfmP275jTbuXgpbU(CmdDetailTestActivity.this, (Integer) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$USJEZ8VPummAX_Iubh9CCSFusqI
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.lambda$USJEZ8VPummAX_Iubh9CCSFusqI(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 11:
                getRobot().m7668z().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$OI42wG_0CKdetsO5PXmChQCxIGg
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.lambda$OI42wG_0CKdetsO5PXmChQCxIGg(CmdDetailTestActivity.this, (Integer) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$PV2mdOiCTg0OQphtvgbjb824N50
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.lambda$PV2mdOiCTg0OQphtvgbjb824N50(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 12:
                getRobot().m7723A().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$8jJ5iGJpS1Xze5vYX71hy94N6L4
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.lambda$8jJ5iGJpS1Xze5vYX71hy94N6L4(CmdDetailTestActivity.this, (Integer) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$kPc-Wsunt8ratsfxA398M2tyTDc
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.m13023lambda$kPcWsunt8ratsfxA398M2tyTDc(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 13:
                getRobot().m7722B().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$uiHtzmJ8kYQFfdyKX4ZlCjynm4I
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.lambda$uiHtzmJ8kYQFfdyKX4ZlCjynm4I(CmdDetailTestActivity.this, (Integer) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$BS01VRYeMGMFrlcPZrQ5Bbax6Jo
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.lambda$BS01VRYeMGMFrlcPZrQ5Bbax6Jo(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 14:
                getRobot().m7721C().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$EHz5TTiX-IJ_7yRwA7PYaMXcAN8
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.m13016lambda$EHz5TTiXIJ_7yRwA7PYaMXcAN8(CmdDetailTestActivity.this, (Integer) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$Zu6h94MKgtHEN978Ahw3HWvIvsE
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.lambda$Zu6h94MKgtHEN978Ahw3HWvIvsE(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 15:
                getRobot().m7720D().mo6311a(NvObserverExecutor.m6303b()).mo6312a(new NvObserver() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$BS_-3-IRw5FXGPhFQMSWmfpBT6s
                    @Override // com.navatics.robot.transport.p063b.NvObserver
                    public final void onNext(Object obj) {
                        CmdDetailTestActivity.m13015lambda$BS_3IRw5FXGPhFQMSWmfpBT6s(CmdDetailTestActivity.this, (WhiteBalance) obj);
                    }
                }, new NvExceptionHandler() { // from class: com.navatics.app.activities.test.-$$Lambda$CmdDetailTestActivity$42PNG3J0GM8sPgm9YI5zAhPNFYs
                    @Override // com.navatics.robot.transport.p063b.NvExceptionHandler
                    public final void onError(Throwable th) {
                        CmdDetailTestActivity.lambda$42PNG3J0GM8sPgm9YI5zAhPNFYs(CmdDetailTestActivity.this, th);
                    }
                });
                return;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                return;
            default:
                throw new RuntimeException("unknown item " + this.requestSelector.getSelectedItemPosition());
        }
    }

    /* renamed from: e */
    public /* synthetic */ void m8940e(Boolean bool) throws Exception {
        m8948b(false);
    }

    /* renamed from: p */
    public /* synthetic */ void m8919p(Throwable th) {
        m8948b(false);
    }

    /* renamed from: d */
    public /* synthetic */ void m8943d(Boolean bool) throws Exception {
        m8948b(false);
    }

    /* renamed from: o */
    public /* synthetic */ void m8920o(Throwable th) {
        m8948b(false);
    }

    /* renamed from: c */
    public /* synthetic */ void m8947c(Boolean bool) throws Exception {
        m8948b(false);
    }

    /* renamed from: n */
    public /* synthetic */ void m8921n(Throwable th) {
        m8948b(false);
    }

    /* renamed from: i */
    public /* synthetic */ void m8927i(Integer num) throws Exception {
        m8948b(false);
    }

    /* renamed from: m */
    public /* synthetic */ void m8922m(Throwable th) {
        m8948b(false);
    }

    /* renamed from: b */
    public /* synthetic */ void m8951b(Boolean bool) throws Exception {
        m8948b(false);
    }

    /* renamed from: l */
    public /* synthetic */ void m8923l(Throwable th) {
        m8948b(false);
    }

    /* renamed from: a */
    public /* synthetic */ void m8955a(Boolean bool) throws Exception {
        m8948b(false);
    }

    /* renamed from: k */
    public /* synthetic */ void m8924k(Throwable th) {
        m8948b(false);
    }

    /* renamed from: h */
    public /* synthetic */ void m8930h(Integer num) throws Exception {
        m8948b(false);
        C3044k c3044k = f3654a;
        c3044k.mo1511a((Object) ("Transaction_DEBUG getRobot().getResolution() result " + num));
    }

    /* renamed from: f */
    public static /* synthetic */ void m8937f() throws Exception {
        f3654a.mo1511a((Object) "Transaction_DEBUG getRobot().getResolution() finish");
    }

    /* renamed from: j */
    public /* synthetic */ void m8925j(Throwable th) {
        m8948b(false);
        f3654a.mo1511a((Object) "Transaction_DEBUG getRobot().getResolution() error");
    }

    /* renamed from: g */
    public /* synthetic */ void m8933g(Integer num) throws Exception {
        m8948b(false);
    }

    /* renamed from: i */
    public /* synthetic */ void m8926i(Throwable th) {
        m8948b(false);
    }

    /* renamed from: f */
    public /* synthetic */ void m8936f(Integer num) throws Exception {
        m8948b(false);
    }

    /* renamed from: h */
    public /* synthetic */ void m8929h(Throwable th) {
        m8948b(false);
    }

    /* renamed from: a */
    public /* synthetic */ void m8957a(StorageInfo storageInfo) throws Exception {
        m8948b(false);
    }

    /* renamed from: g */
    public /* synthetic */ void m8932g(Throwable th) {
        m8948b(false);
    }

    /* renamed from: e */
    public /* synthetic */ void m8939e(Integer num) throws Exception {
        m8948b(false);
    }

    /* renamed from: f */
    public /* synthetic */ void m8935f(Throwable th) {
        m8948b(false);
    }

    /* renamed from: d */
    public /* synthetic */ void m8942d(Integer num) throws Exception {
        m8948b(false);
    }

    /* renamed from: e */
    public /* synthetic */ void m8938e(Throwable th) {
        m8948b(false);
    }

    /* renamed from: c */
    public /* synthetic */ void m8946c(Integer num) throws Exception {
        m8948b(false);
    }

    /* renamed from: d */
    public /* synthetic */ void m8941d(Throwable th) {
        m8948b(false);
    }

    /* renamed from: b */
    public /* synthetic */ void m8950b(Integer num) throws Exception {
        m8948b(false);
    }

    /* renamed from: c */
    public /* synthetic */ void m8944c(Throwable th) {
        m8948b(false);
    }

    /* renamed from: a */
    public /* synthetic */ void m8954a(Integer num) throws Exception {
        m8948b(false);
    }

    /* renamed from: b */
    public /* synthetic */ void m8949b(Throwable th) {
        m8948b(false);
    }

    /* renamed from: a */
    public /* synthetic */ void m8956a(WhiteBalance whiteBalance) throws Exception {
        m8948b(false);
    }

    /* renamed from: a */
    public /* synthetic */ void m8953a(Throwable th) {
        m8948b(false);
    }
}
