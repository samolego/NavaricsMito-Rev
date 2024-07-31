package com.navatics.app.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.p011v7.app.AlertDialog;
import android.widget.Toast;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.R;
import com.navatics.app.framework.Navatics;
import com.p012a.p013a.RxPermissions;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.p096b.BiFunction;
import io.reactivex.p096b.Consumer;
import java.io.File;

/* loaded from: classes.dex */
public class WelcomeActivity extends NvBaseActivity {

    /* renamed from: a */
    private Disposable f3965a;

    /* renamed from: lambda$1quj0waqLJv068wH100x--XRvAw */
    public static /* synthetic */ void m13014lambda$1quj0waqLJv068wH100xXRvAw(WelcomeActivity welcomeActivity, Boolean bool) {
        welcomeActivity.m8980a(bool);
    }

    public static /* synthetic */ void lambda$2Nfzk8ntnae8H6Jr5HffBbEdVII(Throwable th) {
        m8979a(th);
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_welcome);
        getWindow().setFlags(1024, 1024);
        this.f3965a = Observable.m3093a(new RxPermissions(this).m12642b("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.CAMERA"), Navatics.m7959a(), new BiFunction<Boolean, Boolean, Boolean>() { // from class: com.navatics.app.activities.WelcomeActivity.1
            {
                WelcomeActivity.this = this;
            }

            @Override // io.reactivex.p096b.BiFunction
            /* renamed from: a */
            public Boolean mo3248a(Boolean bool, Boolean bool2) throws Exception {
                if (!bool.booleanValue()) {
                    WelcomeActivity.this.m8977c();
                }
                return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
            }
        }).m3107a(new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$WelcomeActivity$1quj0waqLJv068wH100x--XRvAw
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                WelcomeActivity.m13014lambda$1quj0waqLJv068wH100xXRvAw(WelcomeActivity.this, (Boolean) obj);
            }
        }, new Consumer() { // from class: com.navatics.app.activities.-$$Lambda$WelcomeActivity$2Nfzk8ntnae8H6Jr5HffBbEdVII
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                WelcomeActivity.lambda$2Nfzk8ntnae8H6Jr5HffBbEdVII((Throwable) obj);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m8980a(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            m8982a();
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m8979a(Throwable th) throws Exception {
        th.printStackTrace();
        Process.killProcess(Process.myPid());
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f3965a.dispose();
    }

    @Override // com.navatics.app.NvBaseActivity
    protected NvBaseActivity.C1517a onCreateConfig() {
        return new NvBaseActivity.C1517a.C1518a().m9563b(true).m9564b();
    }

    /* renamed from: a */
    private void m8982a() {
        m8978b();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (defaultSharedPreferences.getBoolean("key_first_start", true)) {
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.putBoolean("key_first_start", false);
            edit.apply();
            startActivity(new Intent(this, GuideActivity.class));
            finish();
            return;
        }
        startActivity(new Intent(this, HomepageActivity.class));
        finish();
    }

    /* renamed from: b */
    private void m8978b() {
        File file = new File(Environment.getExternalStorageDirectory(), "Navatics");
        if (file.exists() || file.mkdirs()) {
            return;
        }
        Toast.makeText(this, getString(R.string.setup_ext_folder_failed), 0).show();
    }

    /* renamed from: c */
    public void m8977c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Navatics can NOT run without proper permission..").setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.navatics.app.activities.WelcomeActivity.3
            {
                WelcomeActivity.this = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Process.killProcess(Process.myPid());
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.navatics.app.activities.WelcomeActivity.2
            {
                WelcomeActivity.this = this;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Process.killProcess(Process.myPid());
            }
        });
        builder.create().show();
    }
}
