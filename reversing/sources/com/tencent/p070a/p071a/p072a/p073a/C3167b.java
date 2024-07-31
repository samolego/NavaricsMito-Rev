package com.tencent.p070a.p071a.p072a.p073a;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* renamed from: com.tencent.a.a.a.a.b */
/* loaded from: classes2.dex */
final class C2395b extends AbstractC2399f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C2395b(Context context) {
        super(context);
    }

    @Override // com.tencent.p070a.p071a.p072a.p073a.AbstractC2399f
    /* renamed from: a */
    protected final void mo5569a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to InternalStorage");
            C2394a.m5575a(Environment.getExternalStorageDirectory() + "/" + C2401h.m5555c("6X8Y4XdM2Vhvn0I="));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), C2401h.m5555c("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))));
                bufferedWriter.write(C2401h.m5555c("4kU71lN96TJUomD1vOU9lgj9Tw==") + "," + str);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (Exception e) {
                Log.w("MID", e);
            }
        }
    }

    @Override // com.tencent.p070a.p071a.p072a.p073a.AbstractC2399f
    /* renamed from: a */
    protected final boolean mo5571a() {
        return C2401h.m5561a(this.f7115a, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted");
    }

    @Override // com.tencent.p070a.p071a.p072a.p073a.AbstractC2399f
    /* renamed from: b */
    protected final String mo5568b() {
        String str;
        synchronized (this) {
            Log.i("MID", "read mid from InternalStorage");
            try {
                for (String str2 : C2394a.m5576a(new File(Environment.getExternalStorageDirectory(), C2401h.m5555c("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=")))) {
                    String[] split = str2.split(",");
                    if (split.length == 2 && split[0].equals(C2401h.m5555c("4kU71lN96TJUomD1vOU9lgj9Tw=="))) {
                        Log.i("MID", "read mid from InternalStorage:" + split[1]);
                        str = split[1];
                        break;
                    }
                }
            } catch (IOException e) {
                Log.w("MID", e);
            }
            str = null;
        }
        return str;
    }
}
