package com.navatics.app.activities;

import android.accounts.NetworkErrorException;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p011v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
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
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class ResetPwdActivity extends AppCompatActivity {

    /* renamed from: a */
    public static final C3044k f3853a = C3044k.m1564a(ResetPwdActivity.class);

    /* renamed from: b */
    String f3854b;
    @BindView
    Button btnOK;

    /* renamed from: c */
    String f3855c;

    /* renamed from: d */
    Disposable f3856d;

    /* renamed from: e */
    private LinearLayout.LayoutParams f3857e;
    @BindView
    EditText etPwd1;
    @BindView
    EditText etPwd2;

    /* renamed from: f */
    private TextView f3858f;
    @BindView
    LinearLayout inputContainer;
    @BindView
    TextView tvCancel;

    public static /* synthetic */ void lambda$Zi4HfPHtLNoZt4Oyb5uMWkgWhUI(ResetPwdActivity resetPwdActivity, Throwable th) {
        resetPwdActivity.m9072a(th);
    }

    /* renamed from: lambda$p2euX23z91OaZXNq-6KEBMMPlsQ */
    public static /* synthetic */ void m12999lambda$p2euX23z91OaZXNq6KEBMMPlsQ(ResetPwdActivity resetPwdActivity, Result result) {
        resetPwdActivity.m9074a(result);
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.reset_pwd_activity);
        ButterKnife.m12805a(this);
        getWindow().setFlags(1024, 1024);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        this.f3855c = extras.getString("email");
        this.f3854b = extras.getString("verification_code");
        if (TextUtils.isEmpty(this.f3854b)) {
            Toast.makeText(this, "Verification Code Invalid", 1).show();
            finish();
        } else if (TextUtils.isEmpty(this.f3855c)) {
            Toast.makeText(this, "Email Invalid", 1).show();
            finish();
        }
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.f3856d;
        if (disposable != null && !disposable.isDisposed()) {
            this.f3856d.dispose();
        }
        this.f3856d = null;
    }

    @OnClick
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btnOK) {
            if (id != R.id.tvCancel) {
                return;
            }
            finish();
            return;
        }
        String obj = this.etPwd1.getText().toString();
        if (!obj.equals(this.etPwd2.getText().toString())) {
            m9075a(R.string.pwd_not_match);
        } else if (!m9073a(obj)) {
            m9075a(R.string.pwd_length_not_match);
        } else if (!m9070b(obj)) {
            m9075a(R.string.pwd_not_valid);
        } else {
            m9076a();
            this.f3856d = NvUserManager.m7828b().m7817b(this.f3855c, this.f3854b, obj).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$ResetPwdActivity$p2euX23z91OaZXNq-6KEBMMPlsQ
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj2) {
                    ResetPwdActivity.m12999lambda$p2euX23z91OaZXNq6KEBMMPlsQ(ResetPwdActivity.this, (Result) obj2);
                }
            }, new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$ResetPwdActivity$Zi4HfPHtLNoZt4Oyb5uMWkgWhUI
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj2) {
                    ResetPwdActivity.lambda$Zi4HfPHtLNoZt4Oyb5uMWkgWhUI(ResetPwdActivity.this, (Throwable) obj2);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m9074a(Result result) throws Exception {
        if (result.getCode() == 0) {
            Toast.makeText(this, "Password has been changed", 1).show();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }
        m9068c("Error : " + result.getCode() + ", please contact support@navatics.com");
        f3853a.mo1504b((Object) result.toString());
        m9071b();
    }

    /* renamed from: a */
    public /* synthetic */ void m9072a(Throwable th) throws Exception {
        m9071b();
        th.printStackTrace();
        if (th instanceof UserServiceException) {
            m9068c(((UserServiceException) th).getMsg());
        } else if (th instanceof TimeoutException) {
            m9068c("Connection timeout, please try again later");
        } else if (th instanceof NetworkErrorException) {
            m9068c("Connectivity issue, please check your network");
        } else {
            m9068c("Unknown error : " + th.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private boolean m9073a(String str) {
        return str.length() >= 8;
    }

    /* renamed from: b */
    private boolean m9070b(String str) {
        return Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[\\\\(\\\\)])+$)([^(0-9a-zA-Z)]|[\\\\(\\\\)]|[a-zA-Z]|[0-9])").matcher(str).find();
    }

    /* renamed from: a */
    private void m9076a() {
        m9069c();
        this.btnOK.setEnabled(false);
        this.btnOK.setText("Loading");
        this.btnOK.setBackgroundColor(Color.parseColor("#96AAB5"));
    }

    /* renamed from: b */
    private void m9071b() {
        this.btnOK.setEnabled(true);
        this.btnOK.setText("OK");
        this.btnOK.setBackgroundResource(R.drawable.login_signin_btn_bg);
    }

    /* renamed from: c */
    private void m9068c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f3857e == null) {
            this.f3857e = new LinearLayout.LayoutParams(-1, -2);
            this.f3857e.bottomMargin = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
            this.f3857e.topMargin = (int) TypedValue.applyDimension(1, 9.0f, getResources().getDisplayMetrics());
        }
        if (this.f3858f == null) {
            this.f3858f = (TextView) getLayoutInflater().inflate(R.layout.login_errmsg_hint, (ViewGroup) null);
        }
        if (!this.f3858f.isShown()) {
            this.inputContainer.addView(this.f3858f, 2, this.f3857e);
        }
        this.f3858f.setText(str);
    }

    /* renamed from: a */
    private void m9075a(int i) {
        if (this.f3857e == null) {
            this.f3857e = new LinearLayout.LayoutParams(-1, -2);
            this.f3857e.bottomMargin = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
            this.f3857e.topMargin = (int) TypedValue.applyDimension(1, 9.0f, getResources().getDisplayMetrics());
        }
        if (this.f3858f == null) {
            this.f3858f = (TextView) getLayoutInflater().inflate(R.layout.login_errmsg_hint, (ViewGroup) null);
        }
        if (!this.f3858f.isShown()) {
            this.inputContainer.addView(this.f3858f, 2, this.f3857e);
        }
        this.f3858f.setText(i);
    }

    /* renamed from: c */
    private void m9069c() {
        TextView textView = this.f3858f;
        if (textView == null || !textView.isShown()) {
            return;
        }
        this.inputContainer.removeView(this.f3858f);
    }
}
