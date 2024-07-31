package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.CommonUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.p */
/* loaded from: classes2.dex */
public class QueueFileEventStorage implements EventsStorage {

    /* renamed from: a */
    private final Context f8646a;

    /* renamed from: b */
    private final File f8647b;

    /* renamed from: c */
    private final String f8648c;

    /* renamed from: d */
    private final File f8649d;

    /* renamed from: e */
    private QueueFile f8650e;

    /* renamed from: f */
    private File f8651f;

    public QueueFileEventStorage(Context context, File file, String str, String str2) throws IOException {
        this.f8646a = context;
        this.f8647b = file;
        this.f8648c = str2;
        this.f8649d = new File(this.f8647b, str);
        this.f8650e = new QueueFile(this.f8649d);
        m4284d();
    }

    /* renamed from: d */
    private void m4284d() {
        this.f8651f = new File(this.f8647b, this.f8648c);
        if (this.f8651f.exists()) {
            return;
        }
        this.f8651f.mkdirs();
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    /* renamed from: a */
    public void mo4287a(byte[] bArr) throws IOException {
        this.f8650e.m4309a(bArr);
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    /* renamed from: a */
    public int mo4294a() {
        return this.f8650e.m4320a();
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    /* renamed from: a */
    public void mo4289a(String str) throws IOException {
        this.f8650e.close();
        m4290a(this.f8649d, new File(this.f8651f, str));
        this.f8650e = new QueueFile(this.f8649d);
    }

    /* renamed from: a */
    private void m4290a(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                outputStream = m4291a(file2);
                CommonUtils.m4448a(fileInputStream, outputStream, new byte[1024]);
                CommonUtils.m4449a(fileInputStream, "Failed to close file input stream");
                CommonUtils.m4449a(outputStream, "Failed to close output stream");
                file.delete();
            } catch (Throwable th) {
                th = th;
                CommonUtils.m4449a(fileInputStream, "Failed to close file input stream");
                CommonUtils.m4449a(outputStream, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    /* renamed from: a */
    public OutputStream m4291a(File file) throws IOException {
        return new FileOutputStream(file);
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    /* renamed from: a */
    public List<File> mo4293a(int i) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f8651f.listFiles()) {
            arrayList.add(file);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    /* renamed from: a */
    public void mo4288a(List<File> list) {
        for (File file : list) {
            CommonUtils.m4454a(this.f8646a, String.format("deleting sent analytics file %s", file.getName()));
            file.delete();
        }
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    /* renamed from: c */
    public List<File> mo4285c() {
        return Arrays.asList(this.f8651f.listFiles());
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    /* renamed from: b */
    public boolean mo4286b() {
        return this.f8650e.m4305b();
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    /* renamed from: a */
    public boolean mo4292a(int i, int i2) {
        return this.f8650e.m4318a(i, i2);
    }
}
