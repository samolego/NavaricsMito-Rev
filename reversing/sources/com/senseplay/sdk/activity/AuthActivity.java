package com.senseplay.sdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.C2189R;
import com.senseplay.sdk.SPAuth;
import com.senseplay.sdk.SPManager;
import com.senseplay.sdk.bean.CallBackMsg;
import com.senseplay.sdk.model.account.AuthorizeBean;

/* loaded from: classes2.dex */
public class AuthActivity extends Activity {
    EditText editText;
    String email = "jing.qiu@sensethink.cn";
    String password = "123456";
    SPAuth spAuth;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2189R.layout.sp_activity_auth);
        this.editText = (EditText) findViewById(C2189R.C2191id.editText);
        SPManager.getInstance().init(this);
        SPManager.getInstance().setClient("44E7F9DC2DE558BFBC5D808E38267111", "F851C75F9F55610C2C321F1AC167BBBB");
        this.spAuth = SPAuth.getInstance();
        ((Button) findViewById(C2189R.C2191id.button1)).setOnClickListener(new View.OnClickListener() { // from class: com.senseplay.sdk.activity.AuthActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AuthActivity.this.spAuth.sendCode(AuthActivity.this.email, new MCallBack<CallBackMsg>() { // from class: com.senseplay.sdk.activity.AuthActivity.1.1
                    @Override // com.senseplay.mframe.client.MCallBack
                    public void onResult(CallBackMsg callBackMsg) {
                        if (callBackMsg != null) {
                            Log.w("auth", "" + callBackMsg.getCode() + "  " + callBackMsg.getMessage());
                        }
                    }
                });
            }
        });
        ((Button) findViewById(C2189R.C2191id.button2)).setOnClickListener(new View.OnClickListener() { // from class: com.senseplay.sdk.activity.AuthActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AuthActivity.this.spAuth.registEmail(AuthActivity.this.email, AuthActivity.this.editText.getText().toString(), AuthActivity.this.password, AuthActivity.this.password, new MCallBack<CallBackMsg>() { // from class: com.senseplay.sdk.activity.AuthActivity.2.1
                    @Override // com.senseplay.mframe.client.MCallBack
                    public void onResult(CallBackMsg callBackMsg) {
                        if (callBackMsg != null) {
                            Log.w("auth", "" + callBackMsg.getCode() + "  " + callBackMsg.getMessage());
                        }
                    }
                });
            }
        });
        ((Button) findViewById(C2189R.C2191id.button3)).setOnClickListener(new View.OnClickListener() { // from class: com.senseplay.sdk.activity.AuthActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AuthActivity.this.spAuth.login(AuthActivity.this.email, AuthActivity.this.password, "ep", new MCallBack<AuthorizeBean>() { // from class: com.senseplay.sdk.activity.AuthActivity.3.1
                    @Override // com.senseplay.mframe.client.MCallBack
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
