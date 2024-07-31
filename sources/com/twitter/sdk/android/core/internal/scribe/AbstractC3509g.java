package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.CommonUtils;
import com.twitter.sdk.android.core.internal.CurrentTimeProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.g */
/* loaded from: classes2.dex */
public abstract class EventsFilesManager<T> {

    /* renamed from: a */
    protected final Context f8613a;

    /* renamed from: b */
    protected final EventTransform<T> f8614b;

    /* renamed from: c */
    protected final CurrentTimeProvider f8615c;

    /* renamed from: d */
    protected final EventsStorage f8616d;

    /* renamed from: e */
    protected volatile long f8617e;

    /* renamed from: f */
    protected final List<EventsStorageListener> f8618f = new CopyOnWriteArrayList();

    /* renamed from: g */
    private final int f8619g;

    /* renamed from: b */
    protected abstract String mo4274b();

    /* renamed from: d */
    protected int m4333d() {
        return 8000;
    }

    public EventsFilesManager(Context context, EventTransform<T> eventTransform, CurrentTimeProvider currentTimeProvider, EventsStorage eventsStorage, int i) throws IOException {
        this.f8613a = context.getApplicationContext();
        this.f8614b = eventTransform;
        this.f8616d = eventsStorage;
        this.f8615c = currentTimeProvider;
        this.f8617e = this.f8615c.mo4427a();
        this.f8619g = i;
    }

    /* renamed from: a */
    public void m4338a(T t) throws IOException {
        byte[] mo4276a = this.f8614b.mo4276a(t);
        m4340a(mo4276a.length);
        this.f8616d.mo4287a(mo4276a);
    }

    /* renamed from: a */
    public void m4339a(EventsStorageListener eventsStorageListener) {
        if (eventsStorageListener != null) {
            this.f8618f.add(eventsStorageListener);
        }
    }

    /* renamed from: a */
    public boolean m4341a() throws IOException {
        String str;
        boolean z = true;
        if (this.f8616d.mo4286b()) {
            str = null;
            z = false;
        } else {
            str = mo4274b();
            this.f8616d.mo4289a(str);
            CommonUtils.m4455a(this.f8613a, 4, "Twitter", String.format(Locale.US, "generated new file %s", str));
            this.f8617e = this.f8615c.mo4427a();
        }
        m4335b(str);
        return z;
    }

    /* renamed from: a */
    private void m4340a(int i) throws IOException {
        if (this.f8616d.mo4292a(i, m4333d())) {
            return;
        }
        CommonUtils.m4455a(this.f8613a, 4, "Twitter", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", Integer.valueOf(this.f8616d.mo4294a()), Integer.valueOf(i), Integer.valueOf(m4333d())));
        m4341a();
    }

    /* renamed from: c */
    protected int m4334c() {
        return this.f8619g;
    }

    /* renamed from: b */
    private void m4335b(String str) {
        for (EventsStorageListener eventsStorageListener : this.f8618f) {
            try {
                eventsStorageListener.mo4325a(str);
            } catch (Exception e) {
                CommonUtils.m4452a(this.f8613a, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    /* renamed from: e */
    public List<File> m4332e() {
        return this.f8616d.mo4293a(1);
    }

    /* renamed from: a */
    public void m4336a(List<File> list) {
        this.f8616d.mo4288a(list);
    }

    /* renamed from: f */
    public void m4331f() {
        List<File> mo4285c = this.f8616d.mo4285c();
        int m4334c = m4334c();
        if (mo4285c.size() <= m4334c) {
            return;
        }
        int size = mo4285c.size() - m4334c;
        CommonUtils.m4454a(this.f8613a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", Integer.valueOf(mo4285c.size()), Integer.valueOf(m4334c), Integer.valueOf(size)));
        TreeSet treeSet = new TreeSet(new Comparator<C2680a>() { // from class: com.twitter.sdk.android.core.internal.scribe.g.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(C2680a c2680a, C2680a c2680a2) {
                return (int) (c2680a.f8622b - c2680a2.f8622b);
            }
        });
        for (File file : mo4285c) {
            treeSet.add(new C2680a(file, m4337a(file.getName())));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((C2680a) it.next()).f8621a);
            if (arrayList.size() == size) {
                break;
            }
        }
        this.f8616d.mo4288a(arrayList);
    }

    /* renamed from: a */
    public long m4337a(String str) {
        String[] split = str.split("_");
        if (split.length != 3) {
            return 0L;
        }
        try {
            return Long.valueOf(split[2]).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventsFilesManager.java */
    /* renamed from: com.twitter.sdk.android.core.internal.scribe.g$a */
    /* loaded from: classes2.dex */
    public static class C2680a {

        /* renamed from: a */
        final File f8621a;

        /* renamed from: b */
        final long f8622b;

        public C2680a(File file, long j) {
            this.f8621a = file;
            this.f8622b = j;
        }
    }
}
