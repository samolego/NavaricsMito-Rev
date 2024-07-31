package com.navatics.app.framework.user;

import com.github.mikephil.charting.utils.Utils;
import com.navatics.app.framework.user.NvUser_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.InterfaceC3837a;
import io.objectbox.relation.ToOne;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class NvUserCursor extends Cursor<NvUser> {

    /* renamed from: i */
    private static final NvUser_.C2371a f4799i = NvUser_.__ID_GETTER;

    /* renamed from: j */
    private static final int f4800j = NvUser_.usrId.f9437id;

    /* renamed from: k */
    private static final int f4801k = NvUser_.email.f9437id;

    /* renamed from: l */
    private static final int f4802l = NvUser_.nickName.f9437id;

    /* renamed from: m */
    private static final int f4803m = NvUser_.gender.f9437id;

    /* renamed from: n */
    private static final int f4804n = NvUser_.age.f9437id;

    /* renamed from: o */
    private static final int f4805o = NvUser_.usrImgLowres.f9437id;

    /* renamed from: p */
    private static final int f4806p = NvUser_.usrImgHighres.f9437id;

    /* renamed from: q */
    private static final int f4807q = NvUser_.token.f9437id;

    /* renamed from: r */
    private static final int f4808r = NvUser_.ssUsrInfoId.f9437id;

    @Internal
    /* renamed from: com.navatics.app.framework.user.NvUserCursor$a */
    /* loaded from: classes.dex */
    static final class C2365a implements InterfaceC3837a<NvUser> {
        @Override // io.objectbox.internal.InterfaceC3837a
        /* renamed from: a */
        public Cursor<NvUser> mo3315a(Transaction transaction, long j, BoxStore boxStore) {
            return new NvUserCursor(transaction, j, boxStore);
        }
    }

    public NvUserCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, NvUser_.__INSTANCE, boxStore);
    }

    @Override // io.objectbox.Cursor
    /* renamed from: a */
    public final long mo8519a(NvUser nvUser) {
        return f4799i.mo7783a(nvUser);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.objectbox.Cursor
    /* renamed from: b */
    public final long mo8518b(NvUser nvUser) {
        ToOne<SSUsrInfo> toOne = nvUser.ssUsrInfo;
        if (toOne != 0 && toOne.internalRequiresPutTarget()) {
            Closeable a = m3453a(SSUsrInfo.class);
            try {
                toOne.internalPutTarget(a);
            } finally {
                a.close();
            }
        }
        String str = nvUser.usrId;
        int i = str != null ? f4800j : 0;
        String str2 = nvUser.email;
        int i2 = str2 != null ? f4801k : 0;
        String str3 = nvUser.nickName;
        int i3 = str3 != null ? f4802l : 0;
        String str4 = nvUser.usrImgLowres;
        collect400000(this.f9431d, 0L, 1, i, str, i2, str2, i3, str3, str4 != null ? f4805o : 0, str4);
        String str5 = nvUser.usrImgHighres;
        int i4 = str5 != null ? f4806p : 0;
        String str6 = nvUser.token;
        long collect313311 = collect313311(this.f9431d, nvUser.id, 2, i4, str5, str6 != null ? f4807q : 0, str6, 0, null, 0, null, f4808r, nvUser.ssUsrInfo.getTargetId(), f4803m, nvUser.gender, f4804n, nvUser.age, 0, 0, 0, 0, 0, 0, 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        nvUser.id = collect313311;
        m7853c(nvUser);
        return collect313311;
    }

    /* renamed from: c */
    private void m7853c(NvUser nvUser) {
        nvUser.__boxStore = this.f9433f;
    }
}
