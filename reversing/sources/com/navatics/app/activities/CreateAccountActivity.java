package com.navatics.app.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.Result;
import com.navatics.app.framework.user.UserServiceException;
import com.navatics.app.utils.StringUtils;
import com.navatics.robot.utils.p065a.LoggerUtil;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p099e.Schedulers;
import java.util.regex.Pattern;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class CreateAccountActivity extends NvBaseActivity {

    /* renamed from: d */
    private static final C3044k f3500d = C3044k.m1564a(LoginActivity.class);

    /* renamed from: a */
    EditText f3501a;

    /* renamed from: b */
    EditText f3502b;
    @BindView
    Button btnOK;

    /* renamed from: c */
    boolean f3503c;

    /* renamed from: e */
    private CompositeDisposable f3504e = new CompositeDisposable();
    @BindView
    EditText etEmail;

    /* renamed from: f */
    private TextView f3505f;

    /* renamed from: g */
    private LinearLayout.LayoutParams f3506g;
    @BindView
    LinearLayout inputContainer;
    @BindView
    TextView txSignIn;

    public static /* synthetic */ void lambda$7uwB5vhpGvRl30ekLPGxBUpTtgs(CreateAccountActivity createAccountActivity, Throwable th) {
        createAccountActivity.m9472a(th);
    }

    public static /* synthetic */ void lambda$OjOXtqE2p2hM1O7n8MHYj6GreKI(CreateAccountActivity createAccountActivity, Throwable th) {
        createAccountActivity.m9469b(th);
    }

    public static /* synthetic */ void lambda$_7bZ4WAoTtBX_Ogn6XCZfbnsMRc(CreateAccountActivity createAccountActivity, Result result) {
        createAccountActivity.m9476a(result);
    }

    public static /* synthetic */ void lambda$zyI8IU6l4we5N56M7MEIaY5R6QA(CreateAccountActivity createAccountActivity, String str, String str2, Result result) {
        createAccountActivity.m9473a(str, str2, result);
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_create_account);
        ButterKnife.m12805a(this);
        getWindow().setFlags(1024, 1024);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.user_activity_exit_in, R.anim.user_activity_exit_out);
    }

    /* renamed from: a */
    private EditText m9474a(String str, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics()), 0, 0);
        EditText editText = (EditText) getLayoutInflater().inflate(R.layout.login_pwd_input, (ViewGroup) null);
        editText.setHint(str);
        this.inputContainer.addView(editText, i, layoutParams);
        return editText;
    }

    /* renamed from: b */
    private boolean m9470b(String str) {
        return str.length() >= 8;
    }

    /* renamed from: a */
    public boolean m9475a(String str) {
        return Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[\\\\(\\\\)])+$)([^(0-9a-zA-Z)]|[\\\\(\\\\)]|[a-zA-Z]|[0-9])").matcher(str).find();
    }

    @OnClick
    public void onClicked(View view) {
        int id = view.getId();
        if (id == R.id.btnOK) {
            final String obj = this.etEmail.getText().toString();
            if (this.f3503c) {
                String obj2 = this.f3501a.getText().toString();
                String obj3 = this.f3502b.getText().toString();
                if (StringUtils.m7354a(obj2)) {
                    m9477a(R.string.pwd_1_null);
                    return;
                } else if (StringUtils.m7354a(obj3)) {
                    m9477a(R.string.pwd_2_null);
                    return;
                } else {
                    final String trim = obj2.trim();
                    if (!trim.equals(obj3.trim())) {
                        m9477a(R.string.pwd_not_match);
                        return;
                    } else if (!m9470b(trim)) {
                        m9477a(R.string.pwd_length_not_match);
                        return;
                    } else if (!m9475a(trim)) {
                        m9477a(R.string.pwd_not_valid);
                        return;
                    } else {
                        m9478a();
                        this.f3504e.mo3187a(NvUserManager.m7828b().m7821b(obj).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$CreateAccountActivity$zyI8IU6l4we5N56M7MEIaY5R6QA
                            @Override // io.reactivex.p096b.Consumer
                            public final void accept(Object obj4) {
                                CreateAccountActivity.lambda$zyI8IU6l4we5N56M7MEIaY5R6QA(CreateAccountActivity.this, obj, trim, (Result) obj4);
                            }
                        }, new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$CreateAccountActivity$OjOXtqE2p2hM1O7n8MHYj6GreKI
                            @Override // io.reactivex.p096b.Consumer
                            public final void accept(Object obj4) {
                                CreateAccountActivity.lambda$OjOXtqE2p2hM1O7n8MHYj6GreKI(CreateAccountActivity.this, (Throwable) obj4);
                            }
                        }));
                        return;
                    }
                }
            }
            m9478a();
            this.f3504e.mo3187a(NvUserManager.m7828b().m7839a(obj).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$CreateAccountActivity$_7bZ4WAoTtBX_Ogn6XCZfbnsMRc
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj4) {
                    CreateAccountActivity.lambda$_7bZ4WAoTtBX_Ogn6XCZfbnsMRc(CreateAccountActivity.this, (Result) obj4);
                }
            }, new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$CreateAccountActivity$7uwB5vhpGvRl30ekLPGxBUpTtgs
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj4) {
                    CreateAccountActivity.lambda$7uwB5vhpGvRl30ekLPGxBUpTtgs(CreateAccountActivity.this, (Throwable) obj4);
                }
            }));
            return;
        }
        if (id == R.id.ivBack) {
            LoggerUtil.m5930a("ivback");
            finish();
        } else if (id == R.id.txSignIn) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }
        f3500d.mo1504b((Object) "unknown view clicked.");
    }

    /* renamed from: a */
    public /* synthetic */ void m9473a(String str, String str2, Result result) throws Exception {
        if (result.getCode() == 0) {
            Bundle bundle = new Bundle();
            bundle.putString("key_type", "register");
            bundle.putString("key_email", str);
            bundle.putString("key_pwd", str2);
            Intent intent = new Intent(this, VerificationCodeActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
            overridePendingTransition(R.anim.user_activity_enter_in, R.anim.user_activity_enter_out);
            finish();
            return;
        }
        m9467c(result.getMsg());
        m9471b();
    }

    /* renamed from: b */
    public /* synthetic */ void m9469b(Throwable th) throws Exception {
        m9471b();
        if (th instanceof UserServiceException) {
            m9467c(((UserServiceException) th).getMsg());
            return;
        }
        th.printStackTrace();
        m9467c("Unknown Exception.");
    }

    /* renamed from: a */
    public /* synthetic */ void m9476a(Result result) throws Exception {
        m9471b();
        if (result.getCode() == 0) {
            this.f3503c = true;
            m9468c();
            this.f3501a = m9474a("Password", 2);
            this.f3502b = m9474a("Confirm Password", 3);
            this.f3501a.requestFocus();
        } else if (result.getCode() == 1005) {
            m9477a(R.string.err_1005);
        } else {
            m9467c(getResources().getString(R.string.err_unknown_with_error_code, Integer.valueOf(result.getCode())));
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m9472a(Throwable th) throws Exception {
        m9467c(getResources().getString(R.string.err_unknown_with_exception, th.getClass().getSimpleName()));
        m9471b();
    }

    /* renamed from: a */
    private void m9478a() {
        this.btnOK.setEnabled(false);
        this.btnOK.setText("Loading");
        this.btnOK.setBackgroundColor(Color.parseColor("#96AAB5"));
    }

    /* renamed from: b */
    private void m9471b() {
        this.btnOK.setEnabled(true);
        this.btnOK.setText("OK");
        this.btnOK.setBackgroundResource(R.drawable.login_signin_btn_bg);
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f3504e.m3224a();
    }

    /* renamed from: c */
    private void m9467c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f3506g == null) {
            this.f3506g = new LinearLayout.LayoutParams(-1, -2);
            this.f3506g.bottomMargin = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
            this.f3506g.topMargin = (int) TypedValue.applyDimension(1, 9.0f, getResources().getDisplayMetrics());
        }
        if (this.f3505f == null) {
            this.f3505f = (TextView) getLayoutInflater().inflate(R.layout.login_errmsg_hint, (ViewGroup) null);
        }
        if (!this.f3505f.isShown()) {
            this.inputContainer.addView(this.f3505f, 2, this.f3506g);
        }
        this.f3505f.setText(str);
    }

    /* renamed from: a */
    private void m9477a(int i) {
        if (this.f3506g == null) {
            this.f3506g = new LinearLayout.LayoutParams(-1, -2);
            this.f3506g.bottomMargin = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
            this.f3506g.topMargin = (int) TypedValue.applyDimension(1, 9.0f, getResources().getDisplayMetrics());
        }
        if (this.f3505f == null) {
            this.f3505f = (TextView) getLayoutInflater().inflate(R.layout.login_errmsg_hint, (ViewGroup) null);
        }
        if (!this.f3505f.isShown()) {
            this.inputContainer.addView(this.f3505f, 2, this.f3506g);
        }
        this.f3505f.setText(i);
    }

    /* renamed from: c */
    private void m9468c() {
        TextView textView = this.f3505f;
        if (textView == null || !textView.isShown()) {
            return;
        }
        this.inputContainer.removeView(this.f3505f);
    }
}
