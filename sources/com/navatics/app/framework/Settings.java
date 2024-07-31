package com.navatics.app.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.navatics.robot.transport.INvTransport;
import com.navatics.robot.transport.NvAddressExtra;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvTransport;
import com.navatics.robot.transport.RuntimeTypeAdapterFactory;
import com.navatics.robot.utils.C2160n;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.ag */
/* loaded from: classes.dex */
public class Settings {

    /* renamed from: a */
    private static final C3044k f4247a = C3044k.m1564a(Settings.class);

    /* renamed from: b */
    private static Settings f4248b;

    /* renamed from: c */
    private Context f4249c;

    /* renamed from: d */
    private SharedPreferences f4250d;

    /* renamed from: e */
    private Map<String, String> f4251e = new HashMap();

    /* renamed from: f */
    private Gson f4252f;

    private Settings(Context context) {
        this.f4249c = context.getApplicationContext();
        this.f4250d = PreferenceManager.getDefaultSharedPreferences(this.f4249c);
        f4248b = this;
    }

    /* renamed from: a */
    public static synchronized void m8617a(Context context) {
        synchronized (Settings.class) {
            if (f4248b == null) {
                f4248b = new Settings(context);
            }
        }
    }

    /* renamed from: a */
    public static Settings m8618a() {
        return f4248b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m8613b() {
        RuntimeTypeAdapterFactory m5951a = RuntimeTypeAdapterFactory.m5951a(NvAddressExtra.class);
        for (INvTransport iNvTransport : NvTransport.m6013b()) {
            Class<? extends NvAddressExtra> mo6049b = iNvTransport.mo6049b();
            if (mo6049b != null) {
                m5951a.m5948b(mo6049b);
            }
        }
        this.f4252f = new GsonBuilder().registerTypeAdapterFactory(m5951a).create();
    }

    /* renamed from: l */
    private String m8600l() {
        File externalStorageDirectory;
        String string = this.f4249c.getString(R.string.pref_key_firmware_folder);
        String str = this.f4251e.get(string);
        if (C2160n.m5855a((CharSequence) str)) {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                f4247a.mo1504b((Object) ("external storage not mounted : " + Environment.getExternalStorageState()));
                return null;
            }
            if (Environment.getExternalStorageDirectory() == null) {
                f4247a.mo1504b((Object) "extDir is null.");
                return null;
            }
            String str2 = externalStorageDirectory.getAbsolutePath() + File.separator + "Navatics" + File.separator + "Firmware";
            this.f4251e.put(string, str2);
            return str2;
        }
        return str;
    }

    /* renamed from: m */
    private String m8599m() {
        File externalStorageDirectory;
        String string = this.f4249c.getString(R.string.pref_key_log_folder);
        String str = this.f4251e.get(string);
        if (C2160n.m5855a((CharSequence) str)) {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                f4247a.mo1504b((Object) ("external storage not mounted : " + Environment.getExternalStorageState()));
                return null;
            }
            if (Environment.getExternalStorageDirectory() == null) {
                f4247a.mo1504b((Object) "extDir is null.");
                return null;
            }
            String str2 = externalStorageDirectory.getAbsolutePath() + File.separator + "Navatics" + File.separator + "Log";
            this.f4251e.put(string, str2);
            return str2;
        }
        return str;
    }

    /* renamed from: n */
    private String m8598n() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            C3044k c3044k = f4247a;
            c3044k.mo1504b((Object) ("external storage not mounted : " + Environment.getExternalStorageState()));
            return null;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            f4247a.mo1504b((Object) "extDir is null.");
            return null;
        }
        return externalStorageDirectory.getAbsolutePath() + File.separator + "Navatics" + File.separator + "Photos";
    }

    /* renamed from: o */
    private String m8597o() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            C3044k c3044k = f4247a;
            c3044k.mo1504b((Object) ("external storage not mounted : " + Environment.getExternalStorageState()));
            return null;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            f4247a.mo1504b((Object) "extDir is null.");
            return null;
        }
        return externalStorageDirectory.getAbsolutePath() + File.separator + "Navatics" + File.separator + "ScreenSnapshot";
    }

    /* renamed from: p */
    private String m8596p() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            C3044k c3044k = f4247a;
            c3044k.mo1504b((Object) ("external storage not mounted : " + Environment.getExternalStorageState()));
            return null;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            f4247a.mo1504b((Object) "extDir is null.");
            return null;
        }
        return externalStorageDirectory.getAbsolutePath() + File.separator + "Navatics" + File.separator + "Movies";
    }

    /* renamed from: q */
    private String m8595q() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            C3044k c3044k = f4247a;
            c3044k.mo1504b((Object) ("external storage not mounted : " + Environment.getExternalStorageState()));
            return null;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            f4247a.mo1504b((Object) "extDir is null.");
            return null;
        }
        return externalStorageDirectory.getAbsolutePath() + File.separator + "Navatics";
    }

    /* renamed from: c */
    public String m8611c() {
        return this.f4250d.getString(this.f4249c.getString(R.string.pref_key_root_folder), m8595q());
    }

    /* renamed from: d */
    public String m8609d() {
        return this.f4250d.getString(this.f4249c.getString(R.string.pref_key_my_gallery_folder), m8598n());
    }

    /* renamed from: e */
    public String m8607e() {
        return this.f4250d.getString(this.f4249c.getString(R.string.pref_key_my_movie_folder), m8596p());
    }

    /* renamed from: f */
    public String m8606f() {
        return this.f4250d.getString(this.f4249c.getString(R.string.pref_key_image_save_folder), m8598n());
    }

    /* renamed from: g */
    public String m8605g() {
        return this.f4250d.getString(this.f4249c.getString(R.string.pref_key_screen_snapshot_folder), m8597o());
    }

    /* renamed from: a */
    public void m8615a(String str) {
        String string = this.f4249c.getString(R.string.pref_key_latest_img_path);
        SharedPreferences.Editor edit = this.f4250d.edit();
        edit.putString(string, str);
        edit.apply();
    }

    /* renamed from: h */
    public String m8604h() {
        return this.f4250d.getString(this.f4249c.getString(R.string.pref_key_firmware_folder), m8600l());
    }

    /* renamed from: i */
    public String m8603i() {
        return this.f4250d.getString(this.f4249c.getString(R.string.pref_key_log_folder), m8599m());
    }

    /* renamed from: j */
    public NvDeviceInfo m8602j() {
        String string = this.f4250d.getString(this.f4249c.getString(R.string.pref_key_last_connected_device), null);
        if (string == null) {
            return null;
        }
        return (NvDeviceInfo) this.f4252f.fromJson(string, (Class<Object>) NvDeviceInfo.class);
    }

    /* renamed from: k */
    public void m8601k() {
        SharedPreferences.Editor edit = this.f4250d.edit();
        edit.remove(this.f4249c.getString(R.string.pref_key_last_connected_device));
        edit.apply();
    }

    /* renamed from: a */
    public void m8616a(NvDeviceInfo nvDeviceInfo) {
        if (nvDeviceInfo == null) {
            return;
        }
        SharedPreferences.Editor edit = this.f4250d.edit();
        String json = this.f4252f.toJson(nvDeviceInfo);
        if (C2160n.m5855a((CharSequence) json)) {
            C3044k c3044k = f4247a;
            c3044k.mo1504b((Object) ("can not serialize object NvDeviceInfo : " + nvDeviceInfo));
            return;
        }
        edit.putString(this.f4249c.getString(R.string.pref_key_last_connected_device), json);
        edit.apply();
    }

    /* renamed from: r */
    private String m8594r() {
        String string = this.f4250d.getString(this.f4249c.getString(R.string.pref_key_last_login_user_info), null);
        if (string == null) {
            return null;
        }
        return string;
    }

    /* renamed from: d */
    private boolean m8608d(String str) {
        if (C2160n.m5855a((CharSequence) str)) {
            f4247a.mo1504b((Object) "saveLastLoginUserInfo json is null");
            return false;
        }
        SharedPreferences.Editor edit = this.f4250d.edit();
        edit.putString(this.f4249c.getString(R.string.pref_key_last_login_user_info), str);
        edit.apply();
        return true;
    }

    /* renamed from: b */
    public String m8612b(String str) {
        if (str.startsWith("user") && str.substring(5).equals("last_login_user_info")) {
            return m8594r();
        }
        return null;
    }

    /* renamed from: c */
    public int m8610c(String str) {
        if (str.startsWith("robot")) {
            String substring = str.substring(6);
            if (substring.startsWith("camera")) {
                String substring2 = substring.substring(7);
                if (substring2.equals("camera_mode")) {
                    return this.f4249c.getResources().getInteger(R.integer.default_camera_mode);
                }
                if (substring2.equals("fps")) {
                    return this.f4249c.getResources().getInteger(R.integer.default_camera_fps);
                }
                if (substring2.equals("res")) {
                    return this.f4249c.getResources().getInteger(R.integer.default_camera_res);
                }
                if (substring2.equals("fov")) {
                    return this.f4249c.getResources().getInteger(R.integer.default_camera_fov);
                }
                if (substring2.equals("camera_mode")) {
                    return this.f4249c.getResources().getInteger(R.integer.default_camera_iso);
                }
                if (substring2.equals("camera_mode")) {
                    return this.f4249c.getResources().getInteger(R.integer.default_camera_shutter_speed);
                }
                if (substring2.equals("camera_mode")) {
                    return this.f4249c.getResources().getInteger(R.integer.default_camera_exposure_mode);
                }
                if (substring2.equals("camera_mode")) {
                    return this.f4249c.getResources().getInteger(R.integer.default_camera_exposure_value);
                }
                if (substring2.equals("camera_mode")) {
                    return this.f4249c.getResources().getInteger(R.integer.default_camera_wb_mode);
                }
                if (substring2.equals("camera_mode")) {
                    return this.f4249c.getResources().getInteger(R.integer.default_camera_wb_red);
                }
                if (substring2.equals("camera_mode")) {
                    return this.f4249c.getResources().getInteger(R.integer.default_camera_wb_blue);
                }
                return Integer.MIN_VALUE;
            }
            return Integer.MIN_VALUE;
        }
        return Integer.MIN_VALUE;
    }

    /* renamed from: a */
    public boolean m8614a(String str, String str2) {
        if (str.startsWith("user") && str.substring(5).equals("last_login_user_info")) {
            return m8608d(str2);
        }
        return false;
    }
}
