package com.navatics.app.player;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.navatics.app.R;

/* compiled from: Settings.java */
/* renamed from: com.navatics.app.player.a */
/* loaded from: classes.dex */
public class Settings {

    /* renamed from: a */
    private static Settings settings;

    /* renamed from: b */
    private Context context;

    /* renamed from: c */
    private SharedPreferences sharedPrefs;

    public Settings(Context context) {
        this.context = context.getApplicationContext();
        this.sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this.context);
        settings = this;
    }

    /* renamed from: a */
    public boolean enableBackgroundPlay() {
        return this.sharedPrefs.getBoolean(this.context.getString(R.string.pref_key_enable_background_play), false);
    }

    /* renamed from: b */
    public int m5251b() {
        try {
            return Integer.valueOf(this.sharedPrefs.getString(this.context.getString(R.string.pref_key_player), "")).intValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* renamed from: c */
    public boolean usingMediaCodec() {
        return this.sharedPrefs.getBoolean(this.context.getString(R.string.pref_key_using_media_codec), false);
    }

    /* renamed from: d */
    public boolean m5253d() {
        return this.sharedPrefs.getBoolean(this.context.getString(R.string.pref_key_using_media_codec_auto_rotate), false);
    }

    /* renamed from: e */
    public boolean m5254e() {
        return this.sharedPrefs.getBoolean(this.context.getString(R.string.pref_key_media_codec_handle_resolution_change), false);
    }

    /* renamed from: f */
    public boolean m5255f() {
        return this.sharedPrefs.getBoolean(this.context.getString(R.string.pref_key_using_opensl_es), false);
    }

    /* renamed from: g */
    public String m5256g() {
        return this.sharedPrefs.getString(this.context.getString(R.string.pref_key_pixel_format), "");
    }

    /* renamed from: h */
    public boolean m5257h() {
        return this.sharedPrefs.getBoolean(this.context.getString(R.string.pref_key_enable_no_view), false);
    }

    /* renamed from: i */
    public boolean m5258i() {
        return this.sharedPrefs.getBoolean(this.context.getString(R.string.pref_key_enable_surface_view), false);
    }

    /* renamed from: j */
    public boolean m5259j() {
        return this.sharedPrefs.getBoolean(this.context.getString(R.string.pref_key_enable_texture_view), true);
    }

    /* renamed from: k */
    public boolean m5260k() {
        return this.sharedPrefs.getBoolean(this.context.getString(R.string.pref_key_enable_detached_surface_texture), false);
    }

    /* renamed from: l */
    public boolean m5261l() {
        return this.sharedPrefs.getBoolean(this.context.getString(R.string.pref_key_using_mediadatasource), false);
    }
}