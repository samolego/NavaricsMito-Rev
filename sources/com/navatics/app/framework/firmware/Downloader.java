package com.navatics.app.framework.firmware;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.support.p008v4.app.NotificationCompat;
import com.navatics.app.framework.Settings;
import com.navatics.robot.utils.C2160n;
import java.io.File;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.firmware.c */
/* loaded from: classes.dex */
public class Downloader {

    /* renamed from: a */
    private static final C3044k f4540a = C3044k.m1564a(Downloader.class);

    /* renamed from: b */
    private long f4541b;

    /* renamed from: c */
    private Context f4542c;

    /* renamed from: d */
    private DownloadManager f4543d;

    /* renamed from: e */
    private InterfaceC1805a f4544e;

    /* renamed from: f */
    private String f4545f;

    /* renamed from: g */
    private BroadcastReceiver f4546g = new BroadcastReceiver() { // from class: com.navatics.app.framework.firmware.c.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Downloader.this.m8321a();
        }
    };

    /* compiled from: Downloader.java */
    /* renamed from: com.navatics.app.framework.firmware.c$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1805a {
        /* renamed from: a */
        void mo8241a();

        /* renamed from: b */
        void mo8240b();
    }

    public Downloader(Context context, InterfaceC1805a interfaceC1805a) {
        this.f4542c = context;
        this.f4544e = interfaceC1805a;
    }

    /* renamed from: a */
    public boolean m8319a(String str, String str2) {
        if (C2160n.m5855a((CharSequence) str2)) {
            return false;
        }
        this.f4545f = str2;
        File file = new File(Settings.m8618a().m8604h(), str2);
        if (!file.exists() || file.delete()) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setNotificationVisibility(2);
            request.setAllowedNetworkTypes(2);
            request.setNotificationVisibility(2);
            request.setVisibleInDownloadsUi(true);
            request.setTitle("Navatics");
            request.setDescription("Navatics Firmware Download");
            request.setAllowedNetworkTypes(2);
            request.setDestinationUri(Uri.fromFile(new File(Settings.m8618a().m8604h() + File.separator + str2)));
            this.f4543d = (DownloadManager) this.f4542c.getSystemService("download");
            this.f4541b = this.f4543d.enqueue(request);
            this.f4542c.registerReceiver(this.f4546g, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            C3044k c3044k = f4540a;
            c3044k.mo1511a((Object) ("downloading " + str2));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8321a() {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(this.f4541b);
        Cursor query2 = this.f4543d.query(query);
        if (query2 == null) {
            return;
        }
        if (query2.moveToFirst()) {
            int i = query2.getInt(query2.getColumnIndex(NotificationCompat.CATEGORY_STATUS));
            if (i != 4) {
                if (i == 8) {
                    this.f4544e.mo8241a();
                } else if (i != 16) {
                    switch (i) {
                    }
                } else {
                    this.f4544e.mo8240b();
                }
            }
            C3044k c3044k = f4540a;
            c3044k.mo1504b((Object) ("unexpected state : " + i));
        }
        query2.close();
    }
}
