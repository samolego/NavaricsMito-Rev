package com.facebook.p037a.p038a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import android.support.p008v4.view.ViewCompat;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.a.a.a */
/* loaded from: classes.dex */
public class DeviceRequestsHelper {

    /* renamed from: a */
    private static final String f1521a = DeviceRequestsHelper.class.getCanonicalName();

    /* renamed from: b */
    private static HashMap<String, NsdManager.RegistrationListener> f1522b = new HashMap<>();

    /* renamed from: a */
    public static String m11304a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", Build.DEVICE);
            jSONObject.put("model", Build.MODEL);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public static boolean m11303a(String str) {
        if (m11302b()) {
            return m11299d(str);
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m11302b() {
        FetchedAppSettings m10808a = FetchedAppSettingsManager.m10808a(FacebookSdk.m10865l());
        return Build.VERSION.SDK_INT >= 16 && m10808a != null && m10808a.m10688d().contains(SmartLoginOption.Enabled);
    }

    /* renamed from: b */
    public static Bitmap m11301b(String str) {
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put((EnumMap) EncodeHintType.MARGIN, (EncodeHintType) 2);
        try {
            BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 200, 200, enumMap);
            int height = encode.getHeight();
            int width = encode.getWidth();
            int[] iArr = new int[height * width];
            for (int i = 0; i < height; i++) {
                int i2 = i * width;
                for (int i3 = 0; i3 < width; i3++) {
                    iArr[i2 + i3] = encode.get(i3, i) ? ViewCompat.MEASURED_STATE_MASK : -1;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            try {
                createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                return createBitmap;
            } catch (WriterException unused) {
                return createBitmap;
            }
        } catch (WriterException unused2) {
            return null;
        }
    }

    /* renamed from: c */
    public static void m11300c(String str) {
        m11298e(str);
    }

    @TargetApi(16)
    /* renamed from: d */
    private static boolean m11299d(final String str) {
        if (f1522b.containsKey(str)) {
            return true;
        }
        final String format = String.format("%s_%s_%s", "fbsdk", String.format("%s-%s", "android", FacebookSdk.m10867j().replace('.', '|')), str);
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        nsdServiceInfo.setServiceType("_fb._tcp.");
        nsdServiceInfo.setServiceName(format);
        nsdServiceInfo.setPort(80);
        NsdManager.RegistrationListener registrationListener = new NsdManager.RegistrationListener() { // from class: com.facebook.a.a.a.1
            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo2) {
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo2, int i) {
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onServiceRegistered(NsdServiceInfo nsdServiceInfo2) {
                if (format.equals(nsdServiceInfo2.getServiceName())) {
                    return;
                }
                DeviceRequestsHelper.m11300c(str);
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo2, int i) {
                DeviceRequestsHelper.m11300c(str);
            }
        };
        f1522b.put(str, registrationListener);
        ((NsdManager) FacebookSdk.m10869h().getSystemService("servicediscovery")).registerService(nsdServiceInfo, 1, registrationListener);
        return true;
    }

    @TargetApi(16)
    /* renamed from: e */
    private static void m11298e(String str) {
        NsdManager.RegistrationListener registrationListener = f1522b.get(str);
        if (registrationListener != null) {
            try {
                ((NsdManager) FacebookSdk.m10869h().getSystemService("servicediscovery")).unregisterService(registrationListener);
            } catch (IllegalArgumentException e) {
                Utility.m10528a(f1521a, (Exception) e);
            }
            f1522b.remove(str);
        }
    }
}
