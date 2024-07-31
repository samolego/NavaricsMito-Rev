package com.navatics.app.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p011v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.navatics.app.R;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.Result;
import com.navatics.app.framework.user.UserServiceException;
import io.reactivex.disposables.Disposable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p099e.Schedulers;

/* loaded from: classes.dex */
public class ForgetPwdActivity extends AppCompatActivity {

    /* renamed from: a */
    Disposable f3558a;

    /* renamed from: b */
    Disposable f3559b;
    @BindView
    Button btnResend;
    @BindView
    EditText etInputBox;
    @BindView
    TextView txHelpText;

    public static /* synthetic */ void lambda$Ad3phsxdkssuVtbkY8CEKtRZglw(ForgetPwdActivity forgetPwdActivity, String str, Result result) {
        forgetPwdActivity.m9415a(str, result);
    }

    public static /* synthetic */ void lambda$kRsg5n09wXz2ZwCopziXuie6XIk(ForgetPwdActivity forgetPwdActivity, Throwable th) {
        forgetPwdActivity.m9414a(th);
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forget_pwd_activity);
        ButterKnife.m12805a(this);
        getWindow().setFlags(1024, 1024);
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.f3558a;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f3559b;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.f3558a = null;
        this.f3559b = null;
    }

    @OnClick
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btnResend) {
            if (id != R.id.tvCancel) {
                return;
            }
            finish();
            return;
        }
        String obj = this.etInputBox.getText().toString();
        this.etInputBox.getText().clear();
        this.f3559b = m9416a(obj);
    }

    /* renamed from: a */
    private Disposable m9416a(final String str) {
        this.btnResend.setEnabled(false);
        this.btnResend.setBackgroundColor(Color.parseColor("#96AAB5"));
        this.btnResend.setText("Loading...");
        return NvUserManager.m7828b().m7810c(str).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$ForgetPwdActivity$Ad3phsxdkssuVtbkY8CEKtRZglw
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                ForgetPwdActivity.lambda$Ad3phsxdkssuVtbkY8CEKtRZglw(ForgetPwdActivity.this, str, (Result) obj);
            }
        }, new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$ForgetPwdActivity$kRsg5n09wXz2ZwCopziXuie6XIk
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                ForgetPwdActivity.lambda$kRsg5n09wXz2ZwCopziXuie6XIk(ForgetPwdActivity.this, (Throwable) obj);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m9415a(String str, Result result) throws Exception {
        if (result.getCode() == 0) {
            Bundle bundle = new Bundle();
            bundle.putString("key_type", "resetPwd");
            bundle.putString("key_email", str);
            Intent intent = new Intent(this, VerificationCodeActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
            overridePendingTransition(R.anim.user_activity_enter_in, R.anim.user_activity_enter_out);
            finish();
            return;
        }
        m9413b(result.getMsg());
        m9417a();
    }

    /* renamed from: a */
    public /* synthetic */ void m9414a(Throwable th) throws Exception {
        if (th instanceof UserServiceException) {
            m9413b(((UserServiceException) th).getMsg());
        } else {
            th.printStackTrace();
            m9413b("Unknown Exception.");
        }
        m9417a();
    }

    /* renamed from: a */
    private void m9417a() {
        this.btnResend.setEnabled(true);
        this.btnResend.setText("Get verification code");
        this.btnResend.setBackgroundResource(R.drawable.login_signin_btn_bg);
    }

    /* renamed from: b */
    private void m9413b(String str) {
        this.txHelpText.setText(str);
    }
}
