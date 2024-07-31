package com.navatics.app.activities;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.navatics.app.R;
import com.navatics.app.activities.ActivationActivity;
import com.navatics.app.framework.AbstractConnectionHandler;
import com.navatics.app.framework.AbstractGroundStationHandler;
import com.navatics.app.framework.GroundStation;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.NvConnection;
import com.navatics.app.framework.NvDisposableHandler;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.SSUsrInfo;
import com.navatics.robot.transport.NvError;
import com.navatics.robot.utils.p065a.LoggerUtil;
import java.util.HashMap;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class ActivationActivity extends StatusBarLightActivity {

    /* renamed from: e */
    private static final C3044k f3479e = C3044k.m1564a(ActivationActivity.class);

    /* renamed from: a */
    ObjectAnimator f3480a;

    /* renamed from: b */
    Handler f3481b;

    /* renamed from: c */
    C1552b f3482c;

    /* renamed from: d */
    C1551a f3483d;
    @BindView
    ImageView ivActivationProgress;
    @BindView
    ImageView ivActivationStatus;
    @BindView
    TextView tvActivateResult;

    /* renamed from: b */
    public void m9498b() {
        startActivity(new Intent(this, HomepageActivity.class));
    }

    /* renamed from: com.navatics.app.activities.ActivationActivity$b */
    /* loaded from: classes.dex */
    public class C1552b extends AbstractGroundStationHandler {
        /* renamed from: lambda$-QOup3bRZPVOkYxNFtSwhV-4MSs */
        public static /* synthetic */ void m12965lambda$QOup3bRZPVOkYxNFtSwhV4MSs(C1552b c1552b, int i, NvError nvError) {
            c1552b.m9493a(i, nvError);
        }

        /* renamed from: lambda$-oGTbbRH9rlTX3xl-o5v1PizjII */
        public static /* synthetic */ void m12966lambda$oGTbbRH9rlTX3xlo5v1PizjII(C1552b c1552b) {
            c1552b.m9491b();
        }

        public static /* synthetic */ void lambda$3sK3UyDSHhtHj9_4FbWSz0s6j14(ActivationActivity activationActivity) {
            activationActivity.m9498b();
        }

        C1552b() {
            ActivationActivity.this = r1;
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7730a(GroundStation groundStation) {
            ActivationActivity.f3479e.mo1500c((Object) "bind success");
            ActivationActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$ActivationActivity$b$-oGTbbRH9rlTX3xl-o5v1PizjII
                @Override // java.lang.Runnable
                public final void run() {
                    ActivationActivity.C1552b.m12966lambda$oGTbbRH9rlTX3xlo5v1PizjII(ActivationActivity.C1552b.this);
                }
            });
        }

        /* renamed from: b */
        public /* synthetic */ void m9491b() {
            ActivationActivity.this.m9499a(true);
            Handler handler = ActivationActivity.this.f3481b;
            final ActivationActivity activationActivity = ActivationActivity.this;
            handler.postDelayed(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$ActivationActivity$b$3sK3UyDSHhtHj9_4FbWSz0s6j14
                @Override // java.lang.Runnable
                public final void run() {
                    ActivationActivity.C1552b.lambda$3sK3UyDSHhtHj9_4FbWSz0s6j14(ActivationActivity.this);
                }
            }, 800L);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7507a(GroundStation groundStation, NvConnection nvConnection, NvConnection nvConnection2) {
            ActivationActivity.f3479e.mo1511a((Object) "onConnectionChanged");
            ActivationActivity activationActivity = ActivationActivity.this;
            activationActivity.f3483d = new C1551a();
            nvConnection2.m7896a(ActivationActivity.this.f3483d);
        }

        @Override // com.navatics.app.framework.AbstractGroundStationHandler, com.navatics.app.framework.NvGroundStationHandler
        /* renamed from: a */
        public void mo7728a(GroundStation groundStation, final int i, final NvError nvError) {
            C3044k c3044k = ActivationActivity.f3479e;
            c3044k.mo1504b((Object) ("err " + i + ", cause:" + nvError.m6263b()));
            ActivationActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$ActivationActivity$b$-QOup3bRZPVOkYxNFtSwhV-4MSs
                @Override // java.lang.Runnable
                public final void run() {
                    ActivationActivity.C1552b.m12965lambda$QOup3bRZPVOkYxNFtSwhV4MSs(ActivationActivity.C1552b.this, i, nvError);
                }
            });
        }

        /* renamed from: a */
        public /* synthetic */ void m9493a(int i, NvError nvError) {
            if (i == 16711686) {
                TextView textView = ActivationActivity.this.tvActivateResult;
                textView.setText("Device Activation Failed: " + nvError.m6263b());
                ActivationActivity.this.m9499a(false);
            }
        }
    }

    /* renamed from: com.navatics.app.activities.ActivationActivity$a */
    /* loaded from: classes.dex */
    public class C1551a extends AbstractConnectionHandler {
        /* renamed from: lambda$Hu-5dBuykXcwSoDZIlbimWMALE4 */
        public static /* synthetic */ void m12963lambda$Hu5dBuykXcwSoDZIlbimWMALE4(C1551a c1551a) {
            c1551a.m9494b();
        }

        /* renamed from: lambda$qhfPYccpAiYa0UA9mE3d43-uuL4 */
        public static /* synthetic */ void m12964lambda$qhfPYccpAiYa0UA9mE3d43uuL4(C1551a c1551a, NvError nvError) {
            c1551a.m9495a(nvError);
        }

        C1551a() {
            ActivationActivity.this = r1;
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: a */
        public void mo7861a(NvConnection nvConnection) {
            ActivationActivity.f3479e.mo1511a((Object) "onBindSuccess");
            ActivationActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$ActivationActivity$a$Hu-5dBuykXcwSoDZIlbimWMALE4
                @Override // java.lang.Runnable
                public final void run() {
                    ActivationActivity.C1551a.m12963lambda$Hu5dBuykXcwSoDZIlbimWMALE4(ActivationActivity.C1551a.this);
                }
            });
        }

        /* renamed from: b */
        public /* synthetic */ void m9494b() {
            ActivationActivity.this.m9499a(true);
            Handler handler = ActivationActivity.this.f3481b;
            final ActivationActivity activationActivity = ActivationActivity.this;
            handler.postDelayed(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$7VMA8zEk0MG94lEdTWVE5Uf3Wh0
                @Override // java.lang.Runnable
                public final void run() {
                    ActivationActivity.this.finish();
                }
            }, 800L);
        }

        @Override // com.navatics.app.framework.AbstractConnectionHandler, com.navatics.app.framework.NvConnectionHandler
        /* renamed from: a */
        public void mo7860a(NvConnection nvConnection, int i, final NvError nvError) {
            C3044k c3044k = ActivationActivity.f3479e;
            c3044k.mo1504b((Object) ("err " + i + ", cause:" + nvError.m6263b()));
            if (i == 16711683) {
                ActivationActivity.this.runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$ActivationActivity$a$qhfPYccpAiYa0UA9mE3d43-uuL4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ActivationActivity.C1551a.m12964lambda$qhfPYccpAiYa0UA9mE3d43uuL4(ActivationActivity.C1551a.this, nvError);
                    }
                });
            }
        }

        /* renamed from: a */
        public /* synthetic */ void m9495a(NvError nvError) {
            ActivationActivity.this.m9499a(false);
            TextView textView = ActivationActivity.this.tvActivateResult;
            textView.setText("Device Activation Failed: " + nvError.m6263b());
        }
    }

    /* renamed from: c */
    private SSUsrInfo m9497c() {
        NvUser m7806d = NvUserManager.m7828b().m7806d();
        if (m7806d == null) {
            f3479e.mo1504b((Object) "user is null");
            return null;
        } else if (m7806d.getSsUsrInfo() == null) {
            f3479e.mo1504b((Object) "user doesn't have ss info");
            return null;
        } else {
            return m7806d.getSsUsrInfo().getTarget();
        }
    }

    @Override // com.navatics.app.activities.StatusBarLightActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activation_activity);
        ButterKnife.m12805a(this);
        this.f3481b = new Handler();
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            f3479e.mo1504b((Object) "data is null");
            finish();
            return;
        }
        SSUsrInfo m9497c = m9497c();
        if (m9497c == null) {
            f3479e.mo1504b((Object) "ssUsrInfo is null");
            finish();
            return;
        }
        int i = extras.getInt("activation_type");
        C3044k c3044k = f3479e;
        c3044k.mo1511a((Object) ("activationType = " + i));
        if (1 == i) {
            long j = extras.getLong("remote_id");
            GroundStation m7958a = Navatics.m7958a(j);
            if (m7958a == null) {
                C3044k c3044k2 = f3479e;
                c3044k2.mo1504b((Object) ("can not find GroundStation with id " + j));
                finish();
                return;
            }
            String string = extras.getString("qrcode");
            String serialNumber = m7958a.m8104g().getSerialNumber();
            String uuid = m9497c.getUuid();
            String accessToken = m9497c.getAccessToken();
            HashMap hashMap = new HashMap();
            hashMap.put("qrCode", string);
            hashMap.put("sn", serialNumber);
            hashMap.put("uuid", uuid);
            hashMap.put("access_token", accessToken);
            this.f3482c = new C1552b();
            f3479e.mo1511a((Object) "registerHandler");
            m7958a.m8137a(this.f3482c);
            m9496d();
            m7958a.m8121b(hashMap);
        } else if (2 == i) {
            long j2 = extras.getLong("remote_id");
            LoggerUtil.m5930a("activationType");
            GroundStation m7958a2 = Navatics.m7958a(j2);
            if (m7958a2 == null) {
                TextView textView = this.tvActivateResult;
                textView.setText(getString(R.string.not_find_groundstation_id) + j2);
                this.tvActivateResult.setVisibility(0);
                m9499a(false);
                return;
            }
            long j3 = extras.getLong("conn_id");
            NvConnection m8128b = m7958a2.m8128b(j3);
            if (m8128b == null) {
                TextView textView2 = this.tvActivateResult;
                textView2.setText(getString(R.string.not_find_nvConnection_id) + j3);
                this.tvActivateResult.setVisibility(0);
                m9499a(false);
                return;
            }
            String string2 = extras.getString("qrcode");
            String serialNumber2 = m8128b.m7876i().getSerialNumber();
            String uuid2 = m9497c.getUuid();
            String accessToken2 = m9497c.getAccessToken();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("qrCode", string2);
            hashMap2.put("sn", serialNumber2);
            hashMap2.put("uuid", uuid2);
            hashMap2.put("access_token", accessToken2);
            this.f3483d = new C1551a();
            m8128b.m7896a(this.f3483d);
            f3479e.mo1511a((Object) "activation robot start.");
            m9496d();
            m8128b.m7887b(hashMap2);
        } else {
            f3479e.mo1504b((Object) "unknown activation type");
        }
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        NvDisposableHandler.m7731a((NvDisposableHandler) this.f3482c);
        NvDisposableHandler.m7731a((NvDisposableHandler) this.f3483d);
        ObjectAnimator objectAnimator = this.f3480a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f3480a = null;
        }
    }

    /* renamed from: d */
    private void m9496d() {
        this.f3480a = ObjectAnimator.ofFloat(this.ivActivationProgress, "rotation", 0.0f, 360.0f);
        this.f3480a.setDuration(500L);
        this.f3480a.setRepeatCount(-1);
        this.f3480a.start();
    }

    /* renamed from: a */
    public void m9499a(boolean z) {
        ObjectAnimator objectAnimator = this.f3480a;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f3480a.cancel();
        this.f3480a = null;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ivActivationProgress, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ivActivationProgress, "scaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.ivActivationProgress, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.ivActivationStatus, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.ivActivationStatus, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.ivActivationStatus, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6);
        if (z) {
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.navatics.app.activities.ActivationActivity.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                {
                    ActivationActivity.this = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ActivationActivity.this.ivActivationStatus.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ActivationActivity.this.ivActivationProgress.setVisibility(4);
                }
            });
            animatorSet.setDuration(250L);
        } else {
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.navatics.app.activities.ActivationActivity.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                {
                    ActivationActivity.this = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ActivationActivity.this.tvActivateResult.setVisibility(0);
                    ActivationActivity.this.ivActivationStatus.setImageResource(R.drawable.activation_failed);
                    ActivationActivity.this.ivActivationStatus.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ActivationActivity.this.ivActivationProgress.setVisibility(4);
                }
            });
            animatorSet.setDuration(250L);
        }
        animatorSet.start();
    }
}
