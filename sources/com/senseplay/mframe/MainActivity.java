package com.senseplay.mframe;

import android.os.Bundle;
import android.support.p011v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.mframe.client.MClientHelper;
import com.senseplay.mframe.client.MReqListener;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class MainActivity extends AppCompatActivity {
    private MClientHelper helper;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.helper = MClientHelper.getInstance(this);
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() { // from class: com.senseplay.mframe.MainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.getAllFile("44E7F9DC2DE558BFBC5D808E38267589", "2bc22808ed4f305235177aec694dfc040c45cfb6", new MCallBack<String>() { // from class: com.senseplay.mframe.MainActivity.1.1
                    @Override // com.senseplay.mframe.client.MCallBack
                    public void onResult(String str) {
                        Log.w("fffffff", "fffffffff" + str);
                    }
                });
            }
        });
    }

    public void getAllFile(String str, String str2, MCallBack<String> mCallBack) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("client_id", str);
        hashMap.put("access_token", str2);
        this.helper.request("http://test.cloud.senseplay.cn/api/sn/devices/STRCS00118A0200004", 2, hashMap, new MReqListener<String>(mCallBack) { // from class: com.senseplay.mframe.MainActivity.2
            @Override // com.senseplay.mframe.client.MReqListener
            public String onResponse(String str3) throws Exception {
                return str3;
            }
        });
    }
}
