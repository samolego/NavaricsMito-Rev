package com.example.divelog.dao.entity;

import com.example.divelog.dao.entity.CommandCard;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.example.divelog.dao.entity.a */
/* loaded from: classes.dex */
public class LocalDiveLogRecordCard<T extends CommandCard> {

    /* renamed from: a */
    private List<T> f1414a;

    /* renamed from: b */
    private int f1415b = 0;

    /* renamed from: a */
    public List<T> m11461a() {
        if (this.f1414a == null) {
            this.f1414a = new ArrayList();
        }
        return this.f1414a;
    }

    /* renamed from: a */
    public void m11459a(T t) {
        if (this.f1414a == null) {
            this.f1414a = new ArrayList();
        }
        this.f1414a.add(t);
    }

    /* renamed from: b */
    public int m11458b() {
        return this.f1415b;
    }

    /* renamed from: a */
    public void m11460a(int i) {
        this.f1415b = i;
    }
}
