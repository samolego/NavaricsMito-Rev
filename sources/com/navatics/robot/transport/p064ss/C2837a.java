package com.navatics.robot.transport.p064ss;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;
import com.navatics.robot.transport.KeyMapProvider;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.SPKeyMap;
import com.senseplay.sdk.model.keymap.KeyMapData;
import com.senseplay.sdk.model.keymap.KeyMapParse;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* renamed from: com.navatics.robot.transport.ss.a */
/* loaded from: classes2.dex */
public class LocalKeyMapProvider implements KeyMapProvider {

    /* renamed from: a */
    private Context f6585a;

    public LocalKeyMapProvider(Context context) {
        this.f6585a = context;
    }

    @Override // com.navatics.robot.transport.KeyMapProvider
    /* renamed from: a */
    public String mo6220a(String str, String str2, String str3) {
        try {
            return KeyMapParse.parse(m6219b(KeyMapData.FILE_RC), m6219b("KEYCODES"), m6219b("COMMANDS"), m6219b(str), str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.navatics.robot.transport.KeyMapProvider
    /* renamed from: a */
    public Observable mo6221a(final String str) {
        return Observable.m3097a((ObservableOnSubscribe) new ObservableOnSubscribe<Boolean>() { // from class: com.navatics.robot.transport.ss.a.1
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(final ObservableEmitter<Boolean> observableEmitter) throws Exception {
                SPKeyMap.getInstance().writeKeyMap(str, new MCallBack<Boolean>() { // from class: com.navatics.robot.transport.ss.a.1.1
                    @Override // com.senseplay.mframe.client.MCallBack
                    /* renamed from: a */
                    public void onResult(Boolean bool) {
                        if (bool.booleanValue()) {
                            Toast.makeText(LocalKeyMapProvider.this.f6585a, "Change control mode successfully", 0).show();
                            observableEmitter.onNext(true);
                        } else {
                            Toast.makeText(LocalKeyMapProvider.this.f6585a, "Failed to change control mode", 0).show();
                            observableEmitter.onNext(false);
                        }
                        observableEmitter.onComplete();
                    }
                });
            }
        });
    }

    /* renamed from: b */
    private String m6219b(String str) {
        try {
            AssetManager assets = this.f6585a.getAssets();
            InputStreamReader inputStreamReader = new InputStreamReader(assets.open(str + ".json"), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    inputStreamReader.close();
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
