package com.navatics.robot.protocol.p061a;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.navatics.robot.protocol.a.b */
/* loaded from: classes.dex */
public class MCMOperation {

    /* renamed from: a */
    private List<MCMParam> f6201a = new ArrayList();

    /* renamed from: b */
    private int f6202b;

    public MCMOperation(int i) {
        this.f6202b = i;
    }

    /* renamed from: a */
    public int m6556a() {
        return this.f6202b;
    }

    /* renamed from: a */
    public void m6555a(String str, Object obj) {
        this.f6201a.add(new MCMParam(str, obj));
    }

    /* compiled from: MCMOperation.java */
    /* renamed from: com.navatics.robot.protocol.a.b$a */
    /* loaded from: classes.dex */
    public static class C2095a {

        /* renamed from: a */
        private MCMOperation f6203a;

        /* renamed from: b */
        private Object[] f6204b;

        public C2095a(MCMOperation mCMOperation, Object... objArr) {
            this.f6203a = mCMOperation;
            this.f6204b = objArr;
        }

        /* renamed from: a */
        public int m6554a() {
            Object[] objArr = this.f6204b;
            if (objArr == null) {
                return 0;
            }
            return objArr.length;
        }

        /* renamed from: a */
        public Object m6553a(int i) {
            if (i >= m6554a()) {
                return null;
            }
            return this.f6204b[i];
        }
    }
}
