package com.example.divelog.dao.entity;

import com.example.divelog.dao.entity.CommandCard;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LocalDiveLogRecordCard.java */
/* renamed from: com.example.divelog.dao.entity.a, reason: use source file name */
/* loaded from: classes.dex */
public class LocalDiveLogRecordCard<T extends CommandCard> {

    /* renamed from: a */
    private List<T> f1420a;

    /* renamed from: b */
    private int f1421b = 0;

    /* renamed from: a */
    public List<T> m1498a() {
        if (this.f1420a == null) {
            this.f1420a = new ArrayList();
        }
        return this.f1420a;
    }

    /* renamed from: a */
    public void m1500a(T t) {
        if (this.f1420a == null) {
            this.f1420a = new ArrayList();
        }
        this.f1420a.add(t);
    }

    /* renamed from: b */
    public int m1501b() {
        return this.f1421b;
    }

    /* renamed from: a */
    public void m1499a(int i) {
        this.f1421b = i;
    }
}