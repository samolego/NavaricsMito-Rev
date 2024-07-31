package com.navatics.app.framework.user;

import com.github.mikephil.charting.utils.Utils;
import com.navatics.app.framework.user.SSUsrInfo_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;

/* loaded from: classes.dex */
public final class SSUsrInfoCursor extends Cursor<SSUsrInfo> {

    /* renamed from: i */
    private static final SSUsrInfo_.C1854a f4829i = SSUsrInfo_.__ID_GETTER;

    /* renamed from: j */
    private static final int f4830j = SSUsrInfo_.openid.f9437id;

    /* renamed from: k */
    private static final int f4831k = SSUsrInfo_.uuid.f9437id;

    /* renamed from: l */
    private static final int f4832l = SSUsrInfo_.accessToken.f9437id;

    /* renamed from: m */
    private static final int f4833m = SSUsrInfo_.expiresIn.f9437id;

    /* renamed from: n */
    private static final int f4834n = SSUsrInfo_.tokenType.f9437id;

    /* renamed from: o */
    private static final int f4835o = SSUsrInfo_.scope.f9437id;

    /* renamed from: p */
    private static final int f4836p = SSUsrInfo_.refreshToken.f9437id;

    @Internal
    /* renamed from: com.navatics.app.framework.user.SSUsrInfoCursor$a */
    /* loaded from: classes.dex */
    static final class C1853a implements CursorFactory<SSUsrInfo> {
        @Override // io.objectbox.internal.CursorFactory
        /* renamed from: a */
        public Cursor<SSUsrInfo> mo3318a(Transaction transaction, long j, BoxStore boxStore) {
            return new SSUsrInfoCursor(transaction, j, boxStore);
        }
    }

    public SSUsrInfoCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, SSUsrInfo_.__INSTANCE, boxStore);
    }

    @Override // io.objectbox.Cursor
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final long mo3451b(SSUsrInfo sSUsrInfo) {
        return f4829i.mo3317a(sSUsrInfo);
    }

    @Override // io.objectbox.Cursor
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public final long mo3456a(SSUsrInfo sSUsrInfo) {
        String str = sSUsrInfo.openid;
        int i = str != null ? f4830j : 0;
        String str2 = sSUsrInfo.uuid;
        int i2 = str2 != null ? f4831k : 0;
        String str3 = sSUsrInfo.accessToken;
        int i3 = str3 != null ? f4832l : 0;
        String str4 = sSUsrInfo.expiresIn;
        collect400000(this.f9431d, 0L, 1, i, str, i2, str2, i3, str3, str4 != null ? f4833m : 0, str4);
        String str5 = sSUsrInfo.tokenType;
        int i4 = str5 != null ? f4834n : 0;
        String str6 = sSUsrInfo.scope;
        int i5 = str6 != null ? f4835o : 0;
        String str7 = sSUsrInfo.refreshToken;
        long collect313311 = collect313311(this.f9431d, sSUsrInfo.f4828id, 2, i4, str5, i5, str6, str7 != null ? f4836p : 0, str7, 0, null, 0, 0L, 0, 0L, 0, 0L, 0, 0, 0, 0, 0, 0, 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        sSUsrInfo.f4828id = collect313311;
        return collect313311;
    }
}
