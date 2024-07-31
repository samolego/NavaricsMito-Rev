package com.navatics.app.activities;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.navatics.app.framework.user.LastUserInfo;
import com.navatics.app.framework.user.NvUserEvent;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.Result;
import com.navatics.app.framework.user.UserInfo;
import com.navatics.app.framework.user.UserServiceException;
import com.navatics.app.framework.user.UserSetting;
import com.navatics.app.utils.AnimatorEndListener;
import io.reactivex.disposables.Disposable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p099e.Schedulers;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class LoginActivity extends NvBaseActivity {

    /* renamed from: a */
    private static final C3044k f3612a = C3044k.m1564a(LoginActivity.class);

    /* renamed from: b */
    private TextView f3613b;
    @BindView
    ImageView btnBack;
    @BindView
    Button btnSignIn;

    /* renamed from: c */
    private Snackbar f3614c;

    /* renamed from: d */
    private Disposable f3615d;

    /* renamed from: e */
    private Disposable f3616e;
    @BindView
    EditText etEmail;
    @BindView
    EditText etPwd;

    /* renamed from: f */
    private AnimatorSet f3617f;

    /* renamed from: g */
    private AnimatorSet f3618g;
    @BindView
    LinearLayout inputContainer;
    @BindView
    RelativeLayout loginRootContainer;
    @BindView
    TextView txCreateNew;
    @BindView
    TextView txForgotPwd;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_login);
        ButterKnife.m12805a(this);
        LastUserInfo m7758d = UserSetting.m7766a().m7758d();
        if (m7758d != null) {
            this.etEmail.setText(m7758d.getEmail());
            this.etPwd.setText(m7758d.getEncryptedPwd());
        }
        m9383a();
    }

    /* renamed from: a */
    private void m9383a() {
        this.f3617f = new AnimatorSet();
        this.f3617f.setDuration(300L);
        LinearLayout linearLayout = this.inputContainer;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "alpha", linearLayout.getAlpha(), 0.0f);
        TextView textView = this.txCreateNew;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, "alpha", textView.getAlpha(), 0.0f);
        ImageView imageView = this.btnBack;
        this.f3617f.play(ofFloat).with(ofFloat2).with(ObjectAnimator.ofFloat(imageView, "alpha", imageView.getAlpha(), 0.0f));
        this.f3617f.addListener(new AnimatorEndListener() { // from class: com.navatics.app.activities.LoginActivity.1
            {
                LoginActivity.this = this;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LoginActivity.this.inputContainer.setEnabled(false);
                LoginActivity.this.txCreateNew.setEnabled(false);
                LoginActivity.this.btnBack.setEnabled(false);
            }
        });
        this.f3618g = new AnimatorSet();
        this.f3618g.setDuration(200L);
        LinearLayout linearLayout2 = this.inputContainer;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout2, "alpha", linearLayout2.getAlpha(), 1.0f);
        TextView textView2 = this.txCreateNew;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(textView2, "alpha", textView2.getAlpha(), 1.0f);
        ImageView imageView2 = this.btnBack;
        this.f3618g.play(ofFloat3).with(ofFloat4).with(ObjectAnimator.ofFloat(imageView2, "alpha", imageView2.getAlpha(), 1.0f));
        this.f3618g.addListener(new AnimatorEndListener() { // from class: com.navatics.app.activities.LoginActivity.2
            {
                LoginActivity.this = this;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LoginActivity.this.inputContainer.setEnabled(true);
                LoginActivity.this.txCreateNew.setEnabled(true);
                LoginActivity.this.btnBack.setEnabled(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f3616e = NvUserManager.m7828b().m7791i().m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$LoginActivity$bLAOaPZwzL1rXY9mAX42DslVc5I
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                LoginActivity.this.m9380a((NvUserEvent) obj);
            }
        }, new $$Lambda$LoginActivity$5q9kUS79MNNDwfwfcfwIbhaXa70(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Disposable disposable = this.f3616e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f3616e = null;
    }

    /* renamed from: a */
    public void m9380a(NvUserEvent nvUserEvent) {
        switch (nvUserEvent.m7777b()) {
            case -1:
                UserServiceException m7776c = nvUserEvent.m7776c();
                if (m7776c.getCode() != -1) {
                    m9379a(m7776c.getMsg());
                    return;
                }
                return;
            case 0:
            case 1:
            case 2:
            case 4:
                finish();
                return;
            case 3:
                m9376b(getString(R.string.logging));
                return;
            case 5:
                m9376b("Validating...");
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void m9378a(Throwable th) {
        m9377b();
        m9379a(getString(R.string.try_again));
        th.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.f3615d;
        if (disposable != null && !disposable.isDisposed()) {
            this.f3615d.dispose();
        }
        AnimatorSet animatorSet = this.f3618g;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f3617f;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
    }

    @OnClick
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack /* 2131296317 */:
                finish();
                return;
            case R.id.btnSignIn /* 2131296339 */:
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
                if (inputMethodManager != null && inputMethodManager.isActive() && getCurrentFocus() != null) {
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
                m9376b(getString(R.string.logging));
                this.f3615d = NvUserManager.m7828b().m7835a(this.etEmail.getText().toString().trim(), this.etPwd.getText().toString()).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer<Result<UserInfo>>() { // from class: com.navatics.app.activities.LoginActivity.3
                    {
                        LoginActivity.this = this;
                    }

                    @Override // io.reactivex.p096b.Consumer
                    /* renamed from: a */
                    public void accept(Result<UserInfo> result) throws Exception {
                        if (result.getCode() != 0) {
                            LoginActivity.this.m9377b();
                            result.getCode();
                            LoginActivity.this.m9379a(result.getMsg());
                            return;
                        }
                        LoginActivity loginActivity = LoginActivity.this;
                        loginActivity.startActivity(new Intent(loginActivity, HomepageActivity.class));
                        LoginActivity.this.finish();
                    }
                }, new $$Lambda$LoginActivity$5q9kUS79MNNDwfwfcfwIbhaXa70(this));
                return;
            case R.id.txCreateNew /* 2131297047 */:
                startActivity(new Intent(this, CreateAccountActivity.class));
                overridePendingTransition(R.anim.user_activity_enter_in, R.anim.user_activity_enter_out);
                return;
            case R.id.txForgotPwd /* 2131297048 */:
                Snackbar snackbar = this.f3614c;
                if (snackbar != null) {
                    snackbar.dismiss();
                }
                startActivity(new Intent(this, ForgetPwdActivity.class));
                return;
            default:
                f3612a.mo1504b((Object) "unknown view clicked.");
                return;
        }
    }

    /* renamed from: a */
    public void m9379a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f3613b == null) {
            this.f3613b = (TextView) getLayoutInflater().inflate(R.layout.login_errmsg_hint, (ViewGroup) null);
        }
        if (!this.f3613b.isShown()) {
            this.inputContainer.addView(this.f3613b, 0);
        }
        this.f3613b.setText(str);
    }

    /* renamed from: b */
    private void m9376b(String str) {
        AnimatorSet animatorSet = this.f3618g;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f3617f.start();
        this.f3614c = Snackbar.make(this.loginRootContainer, str, -2);
        View view = this.f3614c.getView();
        view.setBackgroundColor(855638016);
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextAlignment(4);
        this.f3614c.show();
    }

    /* renamed from: b */
    public void m9377b() {
        AnimatorSet animatorSet = this.f3617f;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Snackbar snackbar = this.f3614c;
        if (snackbar != null) {
            snackbar.dismiss();
        }
        this.f3618g.start();
    }
}
