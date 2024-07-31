package com.navatics.app.activities.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.navatics.app.R;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.SPAuth;
import com.senseplay.sdk.SPManager;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.model.account.AuthorizeBean;

/* loaded from: classes.dex */
public class AuthActivity extends Activity {

    /* renamed from: a */
    EditText f3980a;

    /* renamed from: b */
    SPAuth f3981b;

    /* renamed from: c */
    String f3982c = "Henry.liyanto@navatics.com";

    /* renamed from: d */
    String f3983d = "123456";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sp_activity_auth);
        this.f3980a = (EditText) findViewById(R.id.editText);
        SPManager.getInstance().init(this);
        SPManager.getInstance().setClient("44E7F9DC2DE558BFBC5D808E38267111", "F851C75F9F55610C2C321F1AC167BBBB");
        this.f3981b = SPAuth.getInstance();
        ((Button) findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.test.AuthActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AuthActivity.this.f3981b.sendCode(AuthActivity.this.f3982c, new MCallBack<CallBackMsg>() { // from class: com.navatics.app.activities.test.AuthActivity.1.1
                    @Override // com.senseplay.mframe.client.MCallBack
                    /* renamed from: a */
                    public void onResult(CallBackMsg callBackMsg) {
                        if (callBackMsg != null) {
                            Log.w("auth", "" + callBackMsg.getCode());
                        }
                    }
                });
            }
        });
        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.test.AuthActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AuthActivity.this.f3981b.registEmail(AuthActivity.this.f3982c, AuthActivity.this.f3980a.getText().toString(), AuthActivity.this.f3983d, AuthActivity.this.f3983d, new MCallBack<CallBackMsg>() { // from class: com.navatics.app.activities.test.AuthActivity.2.1
                    @Override // com.senseplay.mframe.client.MCallBack
                    /* renamed from: a */
                    public void onResult(CallBackMsg callBackMsg) {
                        if (callBackMsg != null) {
                            Log.w("auth", "" + callBackMsg.getCode());
                        }
                    }
                });
            }
        });
        ((Button) findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() { // from class: com.navatics.app.activities.test.AuthActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AuthActivity.this.f3981b.login(AuthActivity.this.f3982c, AuthActivity.this.f3983d, "ep", new MCallBack<AuthorizeBean>() { // from class: com.navatics.app.activities.test.AuthActivity.3.1
                    @Override // com.senseplay.mframe.client.MCallBack
                    /* renamed from: a */
                    public void onResult(AuthorizeBean authorizeBean) {
                        if (authorizeBean != null) {
                            Log.w("auth", "" + authorizeBean.getUuid());
                        }
                    }
                });
            }
        });
    }
}
