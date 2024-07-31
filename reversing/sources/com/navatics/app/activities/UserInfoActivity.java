package com.navatics.app.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p008v4.app.FragmentActivity;
import android.support.p011v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserEvent;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.Result;
import com.navatics.app.utils.DialogFactory;
import com.navatics.app.utils.UserIconSignature;
import com.navatics.app.widget.CommonDialog;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import io.reactivex.p099e.Schedulers;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public class UserInfoActivity extends StatusBarLightActivity {

    /* renamed from: b */
    private static final C3044k f3925b = C3044k.m1564a(UserInfoActivity.class);

    /* renamed from: a */
    CompositeDisposable f3926a = new CompositeDisposable();
    @BindView
    Button btnSignOut;
    @BindView
    EditText etName;
    @BindView
    ImageView ivBack;
    @BindView
    ImageView ivUsrImg;
    @BindView
    LinearLayout llEditName;
    @BindView
    TextView tvCancel;
    @BindView
    TextView tvSave;
    @BindView
    TextView tvUsrName;

    /* renamed from: lambda$BcTkfgQx-IqMKV6ZbTZGQ2hszUs */
    public static /* synthetic */ void m13006lambda$BcTkfgQxIqMKV6ZbTZGQ2hszUs(UserInfoActivity userInfoActivity, Result result) {
        userInfoActivity.m9015a(result);
    }

    public static /* synthetic */ void lambda$FqGfw6c8GfQsaG2qXLQPnvR1PRc(UserInfoActivity userInfoActivity, NvUserEvent nvUserEvent) {
        userInfoActivity.m9014a(nvUserEvent);
    }

    public static /* synthetic */ void lambda$JRoxTUngxRIurM_cqemFuQmjIW0(UserInfoActivity userInfoActivity, DialogInterface dialogInterface, int i) {
        userInfoActivity.m9019a(dialogInterface, i);
    }

    public static /* synthetic */ void lambda$PuRKT21dXa0Ju_D3p5sMEDyqyHs(UserInfoActivity userInfoActivity, Result result) {
        userInfoActivity.m9010b(result);
    }

    /* renamed from: lambda$ZHQghnJcDNWSrutNiBm52E-dzQ0 */
    public static /* synthetic */ void m13007lambda$ZHQghnJcDNWSrutNiBm52EdzQ0(UserInfoActivity userInfoActivity, Throwable th) {
        userInfoActivity.m9009b(th);
    }

    public static /* synthetic */ void lambda$ui1_c6cuFpJBKDWFYw8_AfGBKMg(UserInfoActivity userInfoActivity, Throwable th) {
        userInfoActivity.m9012a(th);
    }

    @Override // com.navatics.app.activities.StatusBarLightActivity, com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_userinfo);
        ButterKnife.m12805a(this);
        this.f3926a.mo3187a(NvUserManager.m7828b().m7791i().m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$UserInfoActivity$FqGfw6c8GfQsaG2qXLQPnvR1PRc
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                UserInfoActivity.lambda$FqGfw6c8GfQsaG2qXLQPnvR1PRc(UserInfoActivity.this, (NvUserEvent) obj);
            }
        }, $$Lambda$e27Kr4VJxN1zC_AGmQwWE7CADQ.INSTANCE));
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f3926a.m3224a();
    }

    @Override // com.navatics.app.NvBaseActivity
    protected NvBaseActivity.C1517a onCreateConfig() {
        return new NvBaseActivity.C1517a.C1518a().m9565a(true).m9564b();
    }

    /* renamed from: a */
    public void m9014a(NvUserEvent nvUserEvent) {
        C3044k c3044k = f3925b;
        c3044k.mo1511a((Object) ("handleUserEvent, event : " + nvUserEvent.m7777b()));
        switch (nvUserEvent.m7777b()) {
            case 0:
                finish();
                return;
            case 1:
            case 2:
                m9016a(nvUserEvent.m7778a());
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m9016a(NvUser nvUser) {
        if (nvUser != null) {
            NvUserManager m7828b = NvUserManager.m7828b();
            String str = nvUser.getUsrImgLowres() + "?token=" + nvUser.getToken();
            f3925b.mo1511a((Object) ("updateUI img url : " + str));
            Glide.m12521a((FragmentActivity) this).mo8814a(str).mo8828a(RequestOptions.m11679a().mo9551a(R.drawable.ic_launcher_round).mo9539b(new UserIconSignature(m7828b.m7799f()))).m12449a(this.ivUsrImg);
            this.tvUsrName.setText(nvUser.getNickName());
            return;
        }
        f3925b.mo1499d("updateUI user is null ");
    }

    /* renamed from: c */
    private void m9008c() {
        this.f3926a.mo3187a(NvUserManager.m7828b().m7796g().m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer<Result<String>>() { // from class: com.navatics.app.activities.UserInfoActivity.1
            {
                UserInfoActivity.this = this;
            }

            @Override // io.reactivex.p096b.Consumer
            /* renamed from: a */
            public void accept(Result<String> result) throws Exception {
                if (result.getCode() != 0) {
                    C3044k c3044k = UserInfoActivity.f3925b;
                    c3044k.mo1504b((Object) ("logout err : " + result.getCode() + ", msg=" + result.getMsg()));
                    if (result.getCode() == 1006) {
                        NvUserManager.m7828b().m7793h();
                        UserInfoActivity userInfoActivity = UserInfoActivity.this;
                        userInfoActivity.startActivity(new Intent(userInfoActivity, HomepageActivity.class));
                        return;
                    }
                    Toast.makeText(UserInfoActivity.this, result.getMsg(), 0).show();
                    return;
                }
                UserInfoActivity userInfoActivity2 = UserInfoActivity.this;
                userInfoActivity2.startActivity(new Intent(userInfoActivity2, HomepageActivity.class));
            }
        }, new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$UserInfoActivity$ZHQghnJcDNWSrutNiBm52E-dzQ0
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                UserInfoActivity.m13007lambda$ZHQghnJcDNWSrutNiBm52EdzQ0(UserInfoActivity.this, (Throwable) obj);
            }
        }));
    }

    /* renamed from: b */
    public /* synthetic */ void m9009b(Throwable th) throws Exception {
        Toast.makeText(this, "Logout Failed", 0).show();
        th.printStackTrace();
    }

    /* renamed from: d */
    private void m9007d() {
        this.llEditName.setVisibility(0);
        this.tvCancel.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.UserInfoActivity.2
            {
                UserInfoActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserInfoActivity.this.llEditName.setVisibility(8);
            }
        });
        this.tvSave.setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.UserInfoActivity.3
            {
                UserInfoActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserInfoActivity userInfoActivity = UserInfoActivity.this;
                userInfoActivity.m9013a(userInfoActivity.etName.getText().toString());
            }
        });
    }

    /* renamed from: a */
    public void m9013a(String str) {
        this.f3926a.mo3187a(NvUserManager.m7828b().m7837a(str, 0, 0).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$UserInfoActivity$PuRKT21dXa0Ju_D3p5sMEDyqyHs
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                UserInfoActivity.lambda$PuRKT21dXa0Ju_D3p5sMEDyqyHs(UserInfoActivity.this, (Result) obj);
            }
        }, new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$UserInfoActivity$ui1_c6cuFpJBKDWFYw8_AfGBKMg
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                UserInfoActivity.lambda$ui1_c6cuFpJBKDWFYw8_AfGBKMg(UserInfoActivity.this, (Throwable) obj);
            }
        }));
    }

    /* renamed from: b */
    public /* synthetic */ void m9010b(Result result) throws Exception {
        C3044k c3044k = f3925b;
        c3044k.mo1511a((Object) ("uploadImageResultResult : " + result.getCode() + ", msg = " + result.getMsg()));
        if (result.getCode() == 0) {
            NvUserManager.m7828b().m7802e();
            this.llEditName.setVisibility(8);
        } else if (result.getCode() == 1006) {
            Toast.makeText(this, getString(R.string.token_expired_login_agin), 0).show();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m9012a(Throwable th) throws Exception {
        Toast.makeText(this, getString(R.string.try_again_later), 0).show();
    }

    @OnClick
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnSignOut) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.logging_out));
            builder.setMessage(getString(R.string.logout_hint));
            builder.setPositiveButton(getString(R.string.logout), new DialogInterface.OnClickListener() { // from class: com.navatics.app.activities.-$$Lambda$UserInfoActivity$JRoxTUngxRIurM_cqemFuQmjIW0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UserInfoActivity.lambda$JRoxTUngxRIurM_cqemFuQmjIW0(UserInfoActivity.this, dialogInterface, i);
                }
            });
            builder.setCancelable(true);
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            create.show();
        } else if (id == R.id.ivBack) {
            finish();
        } else if (id == R.id.ivUsrImg) {
            m9005f();
        } else if (id != R.id.tvUsrName) {
        } else {
            m9007d();
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m9019a(DialogInterface dialogInterface, int i) {
        m9008c();
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 203) {
            CropImage.ActivityResult m4739a = CropImage.m4739a(intent);
            if (i2 != -1) {
                if (i2 == 204) {
                    m4739a.m4693c().printStackTrace();
                    Toast.makeText(this, getString(R.string.error_image_selection), 0).show();
                    return;
                }
                f3925b.mo1511a((Object) "pick result unknown");
                return;
            }
            Uri b = m4739a.m4694b();
            C3044k c3044k = f3925b;
            c3044k.mo1511a((Object) ("pick result : " + b.toString()));
            this.f3926a.mo3187a(NvUserManager.m7828b().m7803d(b.getPath()).m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a()).m3107a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$UserInfoActivity$BcTkfgQx-IqMKV6ZbTZGQ2hszUs
                @Override // io.reactivex.p096b.Consumer
                public final void accept(Object obj) {
                    UserInfoActivity.m13006lambda$BcTkfgQxIqMKV6ZbTZGQ2hszUs(UserInfoActivity.this, (Result) obj);
                }
            }, $$Lambda$e27Kr4VJxN1zC_AGmQwWE7CADQ.INSTANCE));
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m9015a(Result result) throws Exception {
        C3044k c3044k = f3925b;
        c3044k.mo1511a((Object) ("uploadImageResultResult : " + result.getCode() + ", msg = " + result.getMsg()));
        if (result.getCode() == 0) {
            m9016a(NvUserManager.m7828b().m7806d());
        }
    }

    /* renamed from: e */
    public void m9006e() {
        CropImage.m4747a().m4732a(1, 1).m4727a(true).m4728a(CropImageView.Guidelines.ON).m4731a((Activity) this);
    }

    /* renamed from: f */
    private void m9005f() {
        DialogFactory.m7399c(this).m7343a(R.id.btnChangeIcon, new CommonDialog.InterfaceC1915b() { // from class: com.navatics.app.activities.UserInfoActivity.4
            {
                UserInfoActivity.this = this;
            }

            @Override // com.navatics.app.widget.CommonDialog.InterfaceC1915b
            /* renamed from: a */
            public void mo7335a(CommonDialog commonDialog) {
                UserInfoActivity.this.m9006e();
                commonDialog.dismiss();
            }
        }).m7346a();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_enter_from_right, R.anim.slide_exit_to_left);
    }
}
