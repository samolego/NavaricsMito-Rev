package com.facebook.appevents.p042ml;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Model.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.appevents.ml.a */
/* loaded from: classes.dex */
public final class C0889a {

    /* renamed from: a */
    private static final List<String> f1774a = Arrays.asList("fb_mobile_add_to_cart", "fb_mobile_complete_registration", "other", "fb_mobile_purchase");

    /* renamed from: w */
    private static final Map<String, String> f1775w = new HashMap<String, String>() { // from class: com.facebook.appevents.ml.Model$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            put("embedding.weight", "embed.weight");
            put("dense1.weight", "fc1.weight");
            put("dense2.weight", "fc2.weight");
            put("dense3.weight", "fc3.weight");
            put("dense1.bias", "fc1.bias");
            put("dense2.bias", "fc2.bias");
            put("dense3.bias", "fc3.bias");
        }
    };

    /* renamed from: b */
    private String f1776b;

    /* renamed from: c */
    private File f1777c;

    /* renamed from: d */
    private File f1778d;

    /* renamed from: e */
    private File f1779e = new File(FacebookSdk.m10869h().getFilesDir(), "facebook_ml/");

    /* renamed from: f */
    private int f1780f;

    /* renamed from: g */
    private float[] f1781g;
    @Nullable

    /* renamed from: h */
    private String f1782h;
    @Nullable

    /* renamed from: i */
    private String f1783i;
    @Nullable

    /* renamed from: j */
    private C0892b f1784j;
    @Nullable

    /* renamed from: k */
    private C0892b f1785k;
    @Nullable

    /* renamed from: l */
    private C0892b f1786l;
    @Nullable

    /* renamed from: m */
    private C0892b f1787m;
    @Nullable

    /* renamed from: n */
    private C0892b f1788n;
    @Nullable

    /* renamed from: o */
    private C0892b f1789o;
    @Nullable

    /* renamed from: p */
    private C0892b f1790p;
    @Nullable

    /* renamed from: q */
    private C0892b f1791q;
    @Nullable

    /* renamed from: r */
    private C0892b f1792r;
    @Nullable

    /* renamed from: s */
    private C0892b f1793s;
    @Nullable

    /* renamed from: t */
    private C0892b f1794t;
    @Nullable

    /* renamed from: u */
    private C0892b f1795u;
    @Nullable

    /* renamed from: v */
    private C0892b f1796v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0889a(String str, int i, String str2, @Nullable String str3, float[] fArr) {
        this.f1776b = str;
        this.f1780f = i;
        this.f1781g = fArr;
        this.f1782h = str2;
        this.f1783i = str3;
        if (!this.f1779e.exists()) {
            this.f1779e.mkdirs();
        }
        File file = this.f1779e;
        this.f1777c = new File(file, str + "_" + i);
        File file2 = this.f1779e;
        this.f1778d = new File(file2, str + "_" + i + "_rule");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10946a(final Runnable runnable) {
        m10942b(new Runnable() { // from class: com.facebook.appevents.ml.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (C0889a.this.m10940c()) {
                    C0889a.this.m10939c(runnable);
                }
            }
        });
        m10943b();
    }

    /* renamed from: b */
    private void m10943b() {
        File[] listFiles = this.f1779e.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        String str = this.f1776b + "_" + this.f1780f;
        for (File file : listFiles) {
            String name = file.getName();
            if (name.startsWith(this.f1776b) && !name.startsWith(str)) {
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public File m10949a() {
        return this.f1778d;
    }

    /* renamed from: b */
    private void m10942b(Runnable runnable) {
        if (this.f1777c.exists()) {
            runnable.run();
            return;
        }
        String str = this.f1782h;
        if (str != null) {
            new AsyncTaskC0891a(str, this.f1777c, runnable).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m10939c(Runnable runnable) {
        String str;
        if (this.f1778d.exists() || (str = this.f1783i) == null) {
            runnable.run();
        } else {
            new AsyncTaskC0891a(str, this.f1778d, runnable).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m10940c() {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f1777c);
            int available = fileInputStream.available();
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            byte[] bArr = new byte[available];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            if (available < 4) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 4);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i = wrap.getInt();
            int i2 = i + 4;
            if (available < i2) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(new String(bArr, 4, i));
            JSONArray names = jSONObject.names();
            String[] strArr = new String[names.length()];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                strArr[i3] = names.getString(i3);
            }
            Arrays.sort(strArr);
            HashMap hashMap = new HashMap();
            int length = strArr.length;
            int i4 = i2;
            int i5 = 0;
            while (i5 < length) {
                String str = strArr[i5];
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int[] iArr = new int[jSONArray.length()];
                int i6 = 1;
                for (int i7 = 0; i7 < iArr.length; i7++) {
                    iArr[i7] = jSONArray.getInt(i7);
                    i6 *= iArr[i7];
                }
                int i8 = i6 * 4;
                int i9 = i4 + i8;
                if (i9 > available) {
                    return false;
                }
                ByteBuffer wrap2 = ByteBuffer.wrap(bArr, i4, i8);
                wrap2.order(ByteOrder.LITTLE_ENDIAN);
                float[] fArr = new float[i6];
                wrap2.asFloatBuffer().get(fArr, 0, i6);
                if (f1775w.containsKey(str)) {
                    str = f1775w.get(str);
                }
                hashMap.put(str, new C0892b(iArr, fArr));
                i5++;
                i4 = i9;
            }
            this.f1784j = (C0892b) hashMap.get("embed.weight");
            this.f1785k = (C0892b) hashMap.get("convs.0.weight");
            this.f1786l = (C0892b) hashMap.get("convs.1.weight");
            this.f1787m = (C0892b) hashMap.get("convs.2.weight");
            this.f1785k.f1803b = Operator.m10916a(this.f1785k.f1803b, this.f1785k.f1802a[0], this.f1785k.f1802a[1], this.f1785k.f1802a[2]);
            this.f1786l.f1803b = Operator.m10916a(this.f1786l.f1803b, this.f1786l.f1802a[0], this.f1786l.f1802a[1], this.f1786l.f1802a[2]);
            this.f1787m.f1803b = Operator.m10916a(this.f1787m.f1803b, this.f1787m.f1802a[0], this.f1787m.f1802a[1], this.f1787m.f1802a[2]);
            this.f1788n = (C0892b) hashMap.get("convs.0.bias");
            this.f1789o = (C0892b) hashMap.get("convs.1.bias");
            this.f1790p = (C0892b) hashMap.get("convs.2.bias");
            this.f1791q = (C0892b) hashMap.get("fc1.weight");
            this.f1792r = (C0892b) hashMap.get("fc2.weight");
            this.f1793s = (C0892b) hashMap.get("fc3.weight");
            this.f1791q.f1803b = Operator.m10917a(this.f1791q.f1803b, this.f1791q.f1802a[0], this.f1791q.f1802a[1]);
            this.f1792r.f1803b = Operator.m10917a(this.f1792r.f1803b, this.f1792r.f1802a[0], this.f1792r.f1802a[1]);
            this.f1793s.f1803b = Operator.m10917a(this.f1793s.f1803b, this.f1793s.f1802a[0], this.f1793s.f1802a[1]);
            this.f1794t = (C0892b) hashMap.get("fc1.bias");
            this.f1795u = (C0892b) hashMap.get("fc2.bias");
            this.f1796v = (C0892b) hashMap.get("fc3.bias");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public String m10944a(float[] fArr, String str) {
        float[] m10911a = Operator.m10911a(C0898d.m10906a(str, 128), this.f1784j.f1803b, 1, 128, 64);
        float[] m10913a = Operator.m10913a(m10911a, this.f1785k.f1803b, 1, 128, 64, this.f1785k.f1802a[2], this.f1785k.f1802a[0]);
        float[] m10913a2 = Operator.m10913a(m10911a, this.f1786l.f1803b, 1, 128, 64, this.f1786l.f1802a[2], this.f1786l.f1802a[0]);
        float[] m10913a3 = Operator.m10913a(m10911a, this.f1787m.f1803b, 1, 128, 64, this.f1787m.f1802a[2], this.f1787m.f1802a[0]);
        Operator.m10914a(m10913a, this.f1788n.f1803b, 1, (128 - this.f1785k.f1802a[2]) + 1, this.f1785k.f1802a[0]);
        Operator.m10914a(m10913a2, this.f1789o.f1803b, 1, (128 - this.f1786l.f1802a[2]) + 1, this.f1786l.f1802a[0]);
        Operator.m10914a(m10913a3, this.f1790p.f1803b, 1, (128 - this.f1787m.f1802a[2]) + 1, this.f1787m.f1802a[0]);
        Operator.m10918a(m10913a, ((128 - this.f1785k.f1802a[2]) + 1) * this.f1785k.f1802a[0]);
        Operator.m10918a(m10913a2, ((128 - this.f1786l.f1802a[2]) + 1) * this.f1786l.f1802a[0]);
        Operator.m10918a(m10913a3, ((128 - this.f1787m.f1802a[2]) + 1) * this.f1787m.f1802a[0]);
        float[] m10909b = Operator.m10909b(m10913a, (128 - this.f1785k.f1802a[2]) + 1, this.f1785k.f1802a[0], (128 - this.f1785k.f1802a[2]) + 1);
        float[] m10909b2 = Operator.m10909b(m10913a2, (128 - this.f1786l.f1802a[2]) + 1, this.f1786l.f1802a[0], (128 - this.f1786l.f1802a[2]) + 1);
        float[] m10912a = Operator.m10912a(Operator.m10915a(Operator.m10915a(Operator.m10915a(m10909b, m10909b2), Operator.m10909b(m10913a3, (128 - this.f1787m.f1802a[2]) + 1, this.f1787m.f1802a[0], (128 - this.f1787m.f1802a[2]) + 1)), fArr), this.f1791q.f1803b, this.f1794t.f1803b, 1, this.f1791q.f1802a[1], this.f1791q.f1802a[0]);
        Operator.m10918a(m10912a, this.f1794t.f1802a[0]);
        float[] m10912a2 = Operator.m10912a(m10912a, this.f1792r.f1803b, this.f1795u.f1803b, 1, this.f1792r.f1802a[1], this.f1792r.f1802a[0]);
        Operator.m10918a(m10912a2, this.f1795u.f1802a[0]);
        float[] m10912a3 = Operator.m10912a(m10912a2, this.f1793s.f1803b, this.f1796v.f1803b, 1, this.f1793s.f1802a[1], this.f1793s.f1802a[0]);
        Operator.m10910b(m10912a3, this.f1796v.f1802a[0]);
        return m10945a(m10912a3);
    }

    @Nullable
    /* renamed from: a */
    String m10945a(float[] fArr) {
        if (fArr.length == 0 || this.f1781g.length == 0) {
            return null;
        }
        if (this.f1776b.equals("SUGGEST_EVENT")) {
            return m10941b(fArr);
        }
        if (this.f1776b.equals("DATA_DETECTION_ADDRESS")) {
            return m10938c(fArr);
        }
        return null;
    }

    @Nullable
    /* renamed from: b */
    String m10941b(float[] fArr) {
        if (this.f1781g.length != fArr.length) {
            return null;
        }
        int i = 0;
        while (true) {
            float[] fArr2 = this.f1781g;
            if (i >= fArr2.length) {
                return "other";
            }
            if (fArr[i] >= fArr2[i]) {
                return f1774a.get(i);
            }
            i++;
        }
    }

    @Nullable
    /* renamed from: c */
    String m10938c(float[] fArr) {
        if (fArr[1] >= this.f1781g[0]) {
            return "SHOULD_FILTER";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Model.java */
    /* renamed from: com.facebook.appevents.ml.a$a */
    /* loaded from: classes.dex */
    public static class AsyncTaskC0891a extends AsyncTask<String, Void, Boolean> {

        /* renamed from: a */
        Runnable f1799a;

        /* renamed from: b */
        File f1800b;

        /* renamed from: c */
        String f1801c;

        AsyncTaskC0891a(String str, File file, Runnable runnable) {
            this.f1801c = str;
            this.f1800b = file;
            this.f1799a = runnable;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(String... strArr) {
            try {
                URL url = new URL(this.f1801c);
                int contentLength = url.openConnection().getContentLength();
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                byte[] bArr = new byte[contentLength];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.f1800b));
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                dataOutputStream.close();
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                this.f1799a.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Model.java */
    /* renamed from: com.facebook.appevents.ml.a$b */
    /* loaded from: classes.dex */
    public static class C0892b {

        /* renamed from: a */
        public int[] f1802a;

        /* renamed from: b */
        public float[] f1803b;

        C0892b(int[] iArr, float[] fArr) {
            this.f1802a = iArr;
            this.f1803b = fArr;
        }
    }
}
