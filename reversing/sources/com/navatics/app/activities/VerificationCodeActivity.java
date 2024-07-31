package com.navatics.app.activities;

import android.accounts.NetworkErrorException;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p011v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.navatics.app.R;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.Result;
import com.navatics.app.framework.user.UserServiceException;
import com.navatics.app.utils.StringUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p096b.InterfaceC2848a;
import io.reactivex.p099e.Schedulers;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class VerificationCodeActivity extends AppCompatActivity {

    /* renamed from: g */
    private static final C3044k f3944g = C3044k.m1564a(VerificationCodeActivity.class);

    /* renamed from: a */
    String f3945a;

    /* renamed from: b */
    String f3946b;
    @BindView
    Button btnResend;

    /* renamed from: c */
    String f3947c;

    /* renamed from: d */
    Disposable f3948d;

    /* renamed from: e */
    Disposable f3949e;
    @BindView
    EditText etCode1;
    @BindView
    EditText etCode2;
    @BindView
    EditText etCode3;
    @BindView
    EditText etCode4;
    @BindView
    EditText etCode5;
    @BindView
    EditText etCode6;

    /* renamed from: f */
    Disposable f3950f;

    /* renamed from: h */
    private TextView f3951h;

    /* renamed from: i */
    private LinearLayout.LayoutParams f3952i;
    @BindView
    LinearLayout inputContainer;
    @BindView
    TextView tvCancel;

    /* renamed from: lambda$06HfwMkMM9coATK1cPQKjCJ-u0w */
    public static /* synthetic */ void m13008lambda$06HfwMkMM9coATK1cPQKjCJu0w(VerificationCodeActivity verificationCodeActivity, Throwable th) {
        verificationCodeActivity.m8985d(th);
    }

    public static /* synthetic */ void lambda$2JaUL6KdqptgQC2xlhqLuCKIvPQ(VerificationCodeActivity verificationCodeActivity, Throwable th) {
        verificationCodeActivity.m8987c(th);
    }

    /* renamed from: lambda$5-JIczDG6rlFef8bV3DuQstzgtg */
    public static /* synthetic */ void m13009lambda$5JIczDG6rlFef8bV3DuQstzgtg(VerificationCodeActivity verificationCodeActivity, String str, Result result) {
        verificationCodeActivity.m8996a(str, result);
    }

    /* renamed from: lambda$7En_q-WLTBasVkA4OWxJvBEU91s */
    public static /* synthetic */ void m13010lambda$7En_qWLTBasVkA4OWxJvBEU91s(VerificationCodeActivity verificationCodeActivity, View view) {
        verificationCodeActivity.m9001a(view);
    }

    public static /* synthetic */ void lambda$EiT1sszH91o7G5BTVZO0mCmvzlI(VerificationCodeActivity verificationCodeActivity, Result result) {
        verificationCodeActivity.m8988c(result);
    }

    public static /* synthetic */ void lambda$En44XrXmfhenv2nCgx0aY_is8wQ(VerificationCodeActivity verificationCodeActivity, Throwable th) {
        verificationCodeActivity.m8995a(th);
    }

    public static /* synthetic */ void lambda$L6JBMrXttEY7qXtd5gClqGEzndI(VerificationCodeActivity verificationCodeActivity) {
        verificationCodeActivity.m8984e();
    }

    public static /* synthetic */ void lambda$de_eh4LMoi2ymquLIeG56fW2b7A(VerificationCodeActivity verificationCodeActivity, View view) {
        verificationCodeActivity.m8993b(view);
    }

    /* renamed from: lambda$jy-Ir26CBnD3FYPyYB1vNfKN3YA */
    public static /* synthetic */ void m13011lambda$jyIr26CBnD3FYPyYB1vNfKN3YA(VerificationCodeActivity verificationCodeActivity, Result result) {
        verificationCodeActivity.m8999a(result);
    }

    public static /* synthetic */ void lambda$o2LVy6gUF1eKVwuCY49sx7cc7XQ(VerificationCodeActivity verificationCodeActivity, Result result) {
        verificationCodeActivity.m8992b(result);
    }

    /* renamed from: lambda$sN7LLX-GCTure4-a0hAbORMs4KI */
    public static /* synthetic */ void m13012lambda$sN7LLXGCTure4a0hAbORMs4KI(VerificationCodeActivity verificationCodeActivity, Throwable th) {
        verificationCodeActivity.m8990b(th);
    }

    /* renamed from: lambda$yH7aeX-XLK2flxAvWHYZ-xSFKIk */
    public static /* synthetic */ void m13013lambda$yH7aeXXLK2flxAvWHYZxSFKIk(VerificationCodeActivity verificationCodeActivity, Long l) {
        verificationCodeActivity.m8998a(l);
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_verification_code);
        ButterKnife.m12805a(this);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        this.f3945a = extras.getString("key_type", null);
        this.f3946b = extras.getString("key_email", null);
        if ("register".equals(this.f3945a)) {
            this.f3947c = extras.getString("key_pwd", null);
            if (StringUtils.m7354a(this.f3946b) || StringUtils.m7354a(this.f3947c)) {
                finish();
                return;
            }
        } else if (!"resetPwd".equals(this.f3945a)) {
            finish();
            return;
        }
        this.btnResend.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$VerificationCodeActivity$de_eh4LMoi2ymquLIeG56fW2b7A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerificationCodeActivity.lambda$de_eh4LMoi2ymquLIeG56fW2b7A(VerificationCodeActivity.this, view);
            }
        });
        this.tvCancel.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$VerificationCodeActivity$7En_q-WLTBasVkA4OWxJvBEU91s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerificationCodeActivity.m13010lambda$7En_qWLTBasVkA4OWxJvBEU91s(VerificationCodeActivity.this, view);
            }
        });
        EditText editText = this.etCode1;
        editText.addTextChangedListener(new C1684a(editText.getId()));
        EditText editText2 = this.etCode2;
        editText2.addTextChangedListener(new C1684a(editText2.getId()));
        EditText editText3 = this.etCode3;
        editText3.addTextChangedListener(new C1684a(editText3.getId()));
        EditText editText4 = this.etCode4;
        editText4.addTextChangedListener(new C1684a(editText4.getId()));
        EditText editText5 = this.etCode5;
        editText5.addTextChangedListener(new C1684a(editText5.getId()));
        EditText editText6 = this.etCode6;
        editText6.addTextChangedListener(new C1684a(editText6.getId()));
        this.f3949e = m8986d();
        this.etCode1.requestFocus();
    }

    /* renamed from: b */
    public /* synthetic */ void m8993b(View view) {
        m8983f();
        this.etCode1.getText().clear();
        this.etCode2.getText().clear();
        this.etCode3.getText().clear();
        this.etCode4.getText().clear();
        this.etCode5.getText().clear();
        this.etCode6.getText().clear();
        this.f3950f = m9003a();
        this.f3949e = m8986d();
        this.etCode1.requestFocus();
    }

    /* renamed from: a */
    public /* synthetic */ void m9001a(View view) {
        finish();
    }

    /* renamed from: a */
    private Disposable m9003a() {
        if ("register".equals(this.f3945a)) {
            return m8994b();
        }
        if ("register".equals(this.f3945a)) {
            return m8989c();
        }
        return null;
    }

    /* renamed from: b */
    private Disposable m8994b() {
        return NvUserManager.m7828b().m7821b(this.f3946b).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$VerificationCodeActivity$EiT1sszH91o7G5BTVZO0mCmvzlI
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                VerificationCodeActivity.lambda$EiT1sszH91o7G5BTVZO0mCmvzlI(VerificationCodeActivity.this, (Result) obj);
            }
        }, new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$VerificationCodeActivity$06HfwMkMM9coATK1cPQKjCJ-u0w
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                VerificationCodeActivity.m13008lambda$06HfwMkMM9coATK1cPQKjCJu0w(VerificationCodeActivity.this, (Throwable) obj);
            }
        });
    }

    /* renamed from: c */
    public /* synthetic */ void m8988c(Result result) throws Exception {
        if (result.getCode() == 0) {
            m8991b("Email has been sent, please check your email.");
            return;
        }
        m8991b(result.getMsg());
        m8984e();
    }

    /* renamed from: d */
    public /* synthetic */ void m8985d(Throwable th) throws Exception {
        if (th instanceof UserServiceException) {
            m8991b(((UserServiceException) th).getMsg());
        } else {
            th.printStackTrace();
            m8991b("Unknown Exception.");
        }
        m8984e();
    }

    /* renamed from: c */
    private Disposable m8989c() {
        return NvUserManager.m7828b().m7810c(this.f3946b).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$VerificationCodeActivity$o2LVy6gUF1eKVwuCY49sx7cc7XQ
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                VerificationCodeActivity.lambda$o2LVy6gUF1eKVwuCY49sx7cc7XQ(VerificationCodeActivity.this, (Result) obj);
            }
        }, new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$VerificationCodeActivity$2JaUL6KdqptgQC2xlhqLuCKIvPQ
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                VerificationCodeActivity.lambda$2JaUL6KdqptgQC2xlhqLuCKIvPQ(VerificationCodeActivity.this, (Throwable) obj);
            }
        });
    }

    /* renamed from: b */
    public /* synthetic */ void m8992b(Result result) throws Exception {
        if (result.getCode() == 0) {
            m8991b("Email has been sent, please check your email.");
            return;
        }
        m8991b(result.getMsg());
        m8984e();
    }

    /* renamed from: c */
    public /* synthetic */ void m8987c(Throwable th) throws Exception {
        if (th instanceof UserServiceException) {
            m8991b(((UserServiceException) th).getMsg());
        } else {
            th.printStackTrace();
            m8991b("Unknown Exception.");
        }
        m8984e();
    }

    /* renamed from: d */
    private Disposable m8986d() {
        this.btnResend.setEnabled(false);
        this.btnResend.setBackgroundColor(Color.parseColor("#96AAB5"));
        return Observable.m3113a(0L, 1L, TimeUnit.SECONDS).m3114a(60L).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3106a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$VerificationCodeActivity$yH7aeX-XLK2flxAvWHYZ-xSFKIk
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                VerificationCodeActivity.m13013lambda$yH7aeXXLK2flxAvWHYZxSFKIk(VerificationCodeActivity.this, (Long) obj);
            }
        }, $$Lambda$e27Kr4VJxN1zC_AGmQwWE7CADQ.INSTANCE, new InterfaceC2848a() { // from class: com.navatics.app.activities.-$$Lambda$VerificationCodeActivity$L6JBMrXttEY7qXtd5gClqGEzndI
            @Override // io.reactivex.p096b.InterfaceC2848a
            public final void run() {
                VerificationCodeActivity.lambda$L6JBMrXttEY7qXtd5gClqGEzndI(VerificationCodeActivity.this);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m8998a(Long l) throws Exception {
        this.btnResend.setText(String.format(Locale.getDefault(), "%dS", Long.valueOf(60 - l.longValue())));
    }

    /* renamed from: e */
    public void m8984e() {
        this.btnResend.setEnabled(true);
        this.btnResend.setText("RESEND");
        this.btnResend.setBackgroundColor(Color.parseColor("#6CB0FF"));
    }

    /* renamed from: com.navatics.app.activities.VerificationCodeActivity$a */
    /* loaded from: classes.dex */
    class C1684a implements TextWatcher {

        /* renamed from: a */
        int f3953a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        C1684a(int i) {
            VerificationCodeActivity.this = r1;
            this.f3953a = i;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EditText editText;
            String obj = editable.toString();
            switch (this.f3953a) {
                case R.id.etCode1 /* 2131296480 */:
                    editText = VerificationCodeActivity.this.etCode2;
                    break;
                case R.id.etCode2 /* 2131296481 */:
                    String obj2 = VerificationCodeActivity.this.etCode2.getText().toString();
                    if (StringUtils.m7354a(obj2)) {
                        editText = VerificationCodeActivity.this.etCode1;
                        break;
                    } else if (obj2.length() <= 1) {
                        editText = VerificationCodeActivity.this.etCode3;
                        break;
                    } else {
                        return;
                    }
                case R.id.etCode3 /* 2131296482 */:
                    String obj3 = VerificationCodeActivity.this.etCode3.getText().toString();
                    if (StringUtils.m7354a(obj3)) {
                        editText = VerificationCodeActivity.this.etCode2;
                        break;
                    } else if (obj3.length() <= 1) {
                        editText = VerificationCodeActivity.this.etCode4;
                        break;
                    } else {
                        return;
                    }
                case R.id.etCode4 /* 2131296483 */:
                    String obj4 = VerificationCodeActivity.this.etCode4.getText().toString();
                    if (StringUtils.m7354a(obj4)) {
                        editText = VerificationCodeActivity.this.etCode3;
                        break;
                    } else if (obj4.length() <= 1) {
                        editText = VerificationCodeActivity.this.etCode5;
                        break;
                    } else {
                        return;
                    }
                case R.id.etCode5 /* 2131296484 */:
                    String obj5 = VerificationCodeActivity.this.etCode5.getText().toString();
                    if (StringUtils.m7354a(obj5)) {
                        editText = VerificationCodeActivity.this.etCode4;
                        break;
                    } else if (obj5.length() <= 1) {
                        editText = VerificationCodeActivity.this.etCode6;
                        break;
                    } else {
                        return;
                    }
                case R.id.etCode6 /* 2131296485 */:
                    String obj6 = VerificationCodeActivity.this.etCode6.getText().toString();
                    if (StringUtils.m7354a(obj6)) {
                        editText = VerificationCodeActivity.this.etCode5;
                        break;
                    } else if (obj6.length() > 1) {
                        return;
                    } else {
                        String obj7 = VerificationCodeActivity.this.etCode1.getText().toString();
                        String obj8 = VerificationCodeActivity.this.etCode2.getText().toString();
                        String obj9 = VerificationCodeActivity.this.etCode3.getText().toString();
                        String obj10 = VerificationCodeActivity.this.etCode4.getText().toString();
                        String obj11 = VerificationCodeActivity.this.etCode5.getText().toString();
                        if (StringUtils.m7354a(obj7) || StringUtils.m7354a(obj8) || StringUtils.m7354a(obj9) || StringUtils.m7354a(obj10) || StringUtils.m7354a(obj11) || StringUtils.m7354a(obj6)) {
                            return;
                        }
                        String str = obj7 + obj8 + obj9 + obj10 + obj11 + obj6;
                        InputMethodManager inputMethodManager = (InputMethodManager) VerificationCodeActivity.this.getSystemService("input_method");
                        if (inputMethodManager != null && inputMethodManager.isActive() && VerificationCodeActivity.this.getCurrentFocus() != null) {
                            inputMethodManager.hideSoftInputFromWindow(VerificationCodeActivity.this.getCurrentFocus().getWindowToken(), 0);
                        }
                        if (VerificationCodeActivity.this.f3949e != null) {
                            VerificationCodeActivity.this.f3949e.dispose();
                            VerificationCodeActivity.this.f3949e = null;
                        }
                        VerificationCodeActivity.this.btnResend.setText("Loading...");
                        VerificationCodeActivity.this.btnResend.setEnabled(false);
                        VerificationCodeActivity.this.m8997a(str);
                        return;
                    }
                    break;
                default:
                    return;
            }
            if (StringUtils.m7354a(obj) || editText == null) {
                return;
            }
            editText.requestFocus();
        }
    }

    /* renamed from: a */
    public void m8997a(final String str) {
        NvUserManager m7828b = NvUserManager.m7828b();
        if ("register".equals(this.f3945a)) {
            this.f3948d = m7828b.m7830a(this.f3947c, this.f3946b, str).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$VerificationCodeActivity$jy-Ir26CBnD3FYPyYB1vNfKN3YA
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    VerificationCodeActivity.m13011lambda$jyIr26CBnD3FYPyYB1vNfKN3YA(VerificationCodeActivity.this, (Result) obj);
                }
            }, new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$VerificationCodeActivity$sN7LLX-GCTure4-a0hAbORMs4KI
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    VerificationCodeActivity.m13012lambda$sN7LLXGCTure4a0hAbORMs4KI(VerificationCodeActivity.this, (Throwable) obj);
                }
            });
        } else if ("resetPwd".equals(this.f3945a)) {
            this.f3948d = m7828b.m7819b(this.f3946b, str).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$VerificationCodeActivity$5-JIczDG6rlFef8bV3DuQstzgtg
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    VerificationCodeActivity.m13009lambda$5JIczDG6rlFef8bV3DuQstzgtg(VerificationCodeActivity.this, str, (Result) obj);
                }
            }, new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$VerificationCodeActivity$En44XrXmfhenv2nCgx0aY_is8wQ
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    VerificationCodeActivity.lambda$En44XrXmfhenv2nCgx0aY_is8wQ(VerificationCodeActivity.this, (Throwable) obj);
                }
            });
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m8999a(Result result) throws Exception {
        if (result.getCode() == 0) {
            startActivity(new Intent(this, HomepageActivity.class));
            return;
        }
        if (result.getCode() == 1003) {
            m9002a(R.string.err_1003);
        } else if (result.getCode() == 1006) {
            m9002a(R.string.err_1006);
        } else {
            m8991b(getString(R.string.err_unknown_with_error_code, new Object[]{Integer.valueOf(result.getCode())}));
        }
        m8984e();
    }

    /* renamed from: b */
    public /* synthetic */ void m8990b(Throwable th) throws Exception {
        th.printStackTrace();
        if (th instanceof TimeoutException) {
            m9002a(R.string.err_network_timeout);
        } else if (th instanceof NetworkErrorException) {
            m9002a(R.string.err_network_err);
        } else {
            m8991b(getString(R.string.err_unknown_with_exception, new Object[]{th.getClass().getSimpleName()}));
        }
        m8984e();
    }

    /* renamed from: a */
    public /* synthetic */ void m8996a(String str, Result result) throws Exception {
        if (result.getCode() == 0) {
            Bundle bundle = new Bundle();
            bundle.putString("verification_code", str);
            bundle.putString("email", this.f3946b);
            Intent intent = new Intent(this, ResetPwdActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
            return;
        }
        if (result.getCode() == 1003) {
            m9002a(R.string.err_1003);
        } else if (result.getCode() == 1004) {
            m9002a(R.string.err_1004);
        } else {
            m8991b("Error : " + result.getCode() + ", please contact support@navatics.com");
        }
        m8984e();
    }

    /* renamed from: a */
    public /* synthetic */ void m8995a(Throwable th) throws Exception {
        if (th instanceof TimeoutException) {
            m8991b("Connection timeout, please try again later");
        } else if (th instanceof NetworkErrorException) {
            m8991b("Connectivity issue, please check your network");
        } else {
            m8991b("Unknown error : " + th.getClass().getSimpleName());
        }
        th.printStackTrace();
        m8984e();
    }

    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.f3950f;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f3948d;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.f3949e;
        if (disposable3 != null) {
            disposable3.dispose();
        }
    }

    /* renamed from: b */
    private void m8991b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f3952i == null) {
            this.f3952i = new LinearLayout.LayoutParams(-1, -2);
            this.f3952i.topMargin = (int) TypedValue.applyDimension(1, 9.0f, getResources().getDisplayMetrics());
        }
        if (this.f3951h == null) {
            this.f3951h = (TextView) getLayoutInflater().inflate(R.layout.login_errmsg_hint, (ViewGroup) null);
        }
        if (!this.f3951h.isShown()) {
            this.inputContainer.addView(this.f3951h, 1, this.f3952i);
        }
        this.f3951h.setText(str);
    }

    /* renamed from: a */
    private void m9002a(int i) {
        if (this.f3952i == null) {
            this.f3952i = new LinearLayout.LayoutParams(-1, -2);
            this.f3952i.bottomMargin = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
            this.f3952i.topMargin = (int) TypedValue.applyDimension(1, 9.0f, getResources().getDisplayMetrics());
        }
        if (this.f3951h == null) {
            this.f3951h = (TextView) getLayoutInflater().inflate(R.layout.login_errmsg_hint, (ViewGroup) null);
        }
        if (!this.f3951h.isShown()) {
            this.inputContainer.addView(this.f3951h, 2, this.f3952i);
        }
        this.f3951h.setText(i);
    }

    /* renamed from: f */
    private void m8983f() {
        TextView textView = this.f3951h;
        if (textView == null || !textView.isShown()) {
            return;
        }
        this.inputContainer.removeView(this.f3951h);
    }
}
