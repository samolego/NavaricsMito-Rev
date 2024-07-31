package com.navatics.app.framework.p053e;

import com.navatics.app.framework.Settings;
import com.navatics.robot.utils.CargoMsg;
import com.navatics.robot.utils.CargoThread;
import com.senseplay.sdk.tool.IniEditor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.navatics.app.framework.e.a */
/* loaded from: classes.dex */
public class FileLogger implements MessageLogger {

    /* renamed from: a */
    private volatile boolean f4448a;

    /* renamed from: b */
    private String f4449b;

    /* renamed from: c */
    private C1794a f4450c;

    /* renamed from: d */
    private Writer f4451d;

    /* renamed from: e */
    private File f4452e;

    /* renamed from: f */
    private SimpleDateFormat f4453f;

    /* renamed from: g */
    private Date f4454g;

    /* renamed from: h */
    private StringBuilder f4455h;

    /* renamed from: i */
    private boolean f4456i;

    /* renamed from: j */
    private long f4457j;

    /* renamed from: k */
    private final int f4458k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileLogger(String str, long j) {
        this(str, j, false);
    }

    FileLogger(String str, long j, boolean z) {
        this.f4455h = new StringBuilder();
        this.f4458k = 1;
        this.f4449b = str;
        this.f4457j = j;
        this.f4456i = z;
    }

    /* renamed from: b */
    private boolean m8428b() {
        try {
            this.f4451d = m8429a(true);
            this.f4453f = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
            this.f4454g = new Date();
            this.f4450c = new C1794a();
            this.f4450c.start();
            this.f4448a = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Writer m8429a(boolean z) throws Exception {
        String m8603i = Settings.m8618a().m8603i();
        String str = m8603i + File.separator + this.f4449b;
        File file = new File(m8603i);
        if (file.exists() || file.mkdirs()) {
            this.f4452e = new File(str);
            return new FileWriter(this.f4452e, z);
        }
        return null;
    }

    /* renamed from: b */
    private void m8426b(String str) throws IOException {
        try {
            this.f4450c.m5897a(str);
        } catch (IOException e) {
            throw new IOException("msgQueue was interrupted", e);
        }
    }

    @Override // com.navatics.app.framework.p053e.MessageLogger
    /* renamed from: a */
    public void mo8421a(String str) {
        if (this.f4448a || m8428b()) {
            try {
                this.f4454g.setTime(System.currentTimeMillis());
                String format = this.f4453f.format(this.f4454g);
                StringBuilder sb = this.f4455h;
                sb.append(IniEditor.Section.HEADER_START);
                sb.append(format);
                sb.append(IniEditor.Section.HEADER_END);
                sb.append(str);
                sb.append('\n');
                m8426b(this.f4455h.toString());
                this.f4455h.setLength(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.navatics.app.framework.p053e.MessageLogger
    /* renamed from: a */
    public void mo8422a() {
        if (this.f4448a || m8428b()) {
            try {
                if (this.f4450c != null) {
                    this.f4450c.m5900a(1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FileLogger.java */
    /* renamed from: com.navatics.app.framework.e.a$a */
    /* loaded from: classes.dex */
    public class C1794a extends CargoThread {
        C1794a() {
        }

        /* renamed from: d */
        private void m8423d() {
            if (FileLogger.this.f4457j != 0 && FileLogger.this.f4452e.length() > FileLogger.this.f4457j) {
                try {
                    FileLogger.this.f4451d.close();
                    FileLogger.this.f4451d = FileLogger.this.m8429a(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.navatics.robot.utils.CargoThread
        /* renamed from: a */
        protected void mo5898a(CargoMsg cargoMsg) throws Exception {
            if (cargoMsg.m5909a() != 1) {
                FileLogger.this.f4451d.write((String) cargoMsg.m5902d());
                if (FileLogger.this.f4456i) {
                    FileLogger.this.f4451d.flush();
                }
                m8423d();
            } else if (cargoMsg.m5904b() != 1) {
            } else {
                FileLogger.this.f4451d.flush();
                m8423d();
            }
        }

        @Override // com.navatics.robot.utils.CargoThread
        /* renamed from: a */
        protected void mo5901a() {
            try {
                FileLogger.this.f4451d.flush();
                FileLogger.this.f4451d.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
