package com.navatics.app.player;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.navatics.app.R;

/* compiled from: Settings.java */
/* renamed from: com.navatics.app.player.a */
/* loaded from: classes.dex */
public class C1860a {

    /* renamed from: a */
    private static C1860a f4879a;

    /* renamed from: b */
    private Context f4880b;

    /* renamed from: c */
    private SharedPreferences f4881c;

    public C1860a(Context context) {
        this.f4880b = context.getApplicationContext();
        this.f4881c = PreferenceManager.getDefaultSharedPreferences(this.f4880b);
        f4879a = this;
    }

    /* renamed from: a */
    public boolean m7662a() {
        return this.f4881c.getBoolean(this.f4880b.getString(R.string.pref_key_enable_background_play), false);
    }

    /* renamed from: b */
    public int m7661b() {
        try {
            return Integer.valueOf(this.f4881c.getString(this.f4880b.getString(R.string.pref_key_player), "")).intValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* renamed from: c */
    public boolean m7660c() {
        return this.f4881c.getBoolean(this.f4880b.getString(R.string.pref_key_using_media_codec), false);
    }

    /* renamed from: d */
    public boolean m7659d() {
        return this.f4881c.getBoolean(this.f4880b.getString(R.string.pref_key_using_media_codec_auto_rotate), false);
    }

    /* renamed from: e */
    public boolean m7658e() {
        return this.f4881c.getBoolean(this.f4880b.getString(R.string.pref_key_media_codec_handle_resolution_change), false);
    }

    /* renamed from: f */
    public boolean m7657f() {
        return this.f4881c.getBoolean(this.f4880b.getString(R.string.pref_key_using_opensl_es), false);
    }

    /* renamed from: g */
    public String m7656g() {
        return this.f4881c.getString(this.f4880b.getString(R.string.pref_key_pixel_format), "");
    }

    /* renamed from: h */
    public boolean m7655h() {
        return this.f4881c.getBoolean(this.f4880b.getString(R.string.pref_key_enable_no_view), false);
    }

    /* renamed from: i */
    public boolean m7654i() {
        return this.f4881c.getBoolean(this.f4880b.getString(R.string.pref_key_enable_surface_view), false);
    }

    /* renamed from: j */
    public boolean m7653j() {
        return this.f4881c.getBoolean(this.f4880b.getString(R.string.pref_key_enable_texture_view), true);
    }

    /* renamed from: k */
    public boolean m7652k() {
        return this.f4881c.getBoolean(this.f4880b.getString(R.string.pref_key_enable_detached_surface_texture), false);
    }

    /* renamed from: l */
    public boolean m7651l() {
        return this.f4881c.getBoolean(this.f4880b.getString(R.string.pref_key_using_mediadatasource), false);
    }
}
