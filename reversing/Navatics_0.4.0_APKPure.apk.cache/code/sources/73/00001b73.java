package com.navatics.robot.protocol.p054a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: MCMOperation.java */
/* renamed from: com.navatics.robot.protocol.a.b, reason: use source file name */
/* loaded from: classes.dex */
public class MCMOperation {

    /* renamed from: a */
    private List<MCMParam> f6229a = new ArrayList();

    /* renamed from: b */
    private int f6230b;

    public MCMOperation(int i) {
        this.f6230b = i;
    }

    /* renamed from: a */
    public int m6305a() {
        return this.f6230b;
    }

    /* renamed from: a */
    public void m6306a(String str, Object obj) {
        this.f6229a.add(new MCMParam(str, obj));
    }

    /* compiled from: MCMOperation.java */
    /* renamed from: com.navatics.robot.protocol.a.b$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private MCMOperation f6231a;

        /* renamed from: b */
        private Object[] f6232b;

        public a(MCMOperation mCMOperation, Object... objArr) {
            this.f6231a = mCMOperation;
            this.f6232b = objArr;
        }

        /* renamed from: a */
        public int m6307a() {
            Object[] objArr = this.f6232b;
            if (objArr == null) {
                return 0;
            }
            return objArr.length;
        }

        /* renamed from: a */
        public Object m6308a(int i) {
            if (i >= m6307a()) {
                return null;
            }
            return this.f6232b[i];
        }
    }
}