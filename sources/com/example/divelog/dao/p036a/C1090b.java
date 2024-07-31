package com.example.divelog.dao.p036a;

import android.util.Log;
import com.example.divelog.dao.entity.CommandCard;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.example.divelog.dao.a.b */
/* loaded from: classes.dex */
public class ConflictHelper<T extends CommandCard> {

    /* renamed from: a */
    private List<Strategy<T>> f1397a;

    /* renamed from: a */
    public void m11487a(T t, T t2) {
        if (this.f1397a == null) {
            this.f1397a = new ArrayList();
            this.f1397a.add(new LocalStrategy());
            this.f1397a.add(new NewUploadDiveLogItemStrategy());
            this.f1397a.add(new NewUploadDiveLogStrategy());
            this.f1397a.add(new SameIgnoreStrategy());
            this.f1397a.add(new SameUpdateStrategy());
        }
        for (int i = 0; i < this.f1397a.size(); i++) {
            if (this.f1397a.get(i).mo11462a(t, t2)) {
                Log.i("info1", "resolveConflict: " + i);
                return;
            }
        }
    }
}
