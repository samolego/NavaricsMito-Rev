package com.navatics.app.framework.divelog;

import com.github.mikephil.charting.utils.Utils;
import com.navatics.app.framework.divelog.DiveLogEntry_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.relation.ToOne;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class DiveLogEntryCursor extends Cursor<DiveLogEntry> {

    /* renamed from: i */
    private static final DiveLogEntry_.C1774a f4376i = DiveLogEntry_.__ID_GETTER;

    /* renamed from: j */
    private static final int f4377j = DiveLogEntry_.timestamp.f9437id;

    /* renamed from: k */
    private static final int f4378k = DiveLogEntry_.detailIndex.f9437id;

    /* renamed from: l */
    private static final int f4379l = DiveLogEntry_.airTemperature.f9437id;

    /* renamed from: m */
    private static final int f4380m = DiveLogEntry_.waterTemperature.f9437id;

    /* renamed from: n */
    private static final int f4381n = DiveLogEntry_.weather.f9437id;

    /* renamed from: o */
    private static final int f4382o = DiveLogEntry_.windVelocity.f9437id;

    /* renamed from: p */
    private static final int f4383p = DiveLogEntry_.windDirection.f9437id;

    /* renamed from: q */
    private static final int f4384q = DiveLogEntry_.buoyLongitude.f9437id;

    /* renamed from: r */
    private static final int f4385r = DiveLogEntry_.buoyLatitude.f9437id;

    /* renamed from: s */
    private static final int f4386s = DiveLogEntry_.phoneLongitude.f9437id;

    /* renamed from: t */
    private static final int f4387t = DiveLogEntry_.phoneLatitude.f9437id;

    /* renamed from: u */
    private static final int f4388u = DiveLogEntry_.stateQuaternionW.f9437id;

    /* renamed from: v */
    private static final int f4389v = DiveLogEntry_.stateQuaternionX.f9437id;

    /* renamed from: w */
    private static final int f4390w = DiveLogEntry_.stateQuaternionY.f9437id;

    /* renamed from: x */
    private static final int f4391x = DiveLogEntry_.stateQuaternionZ.f9437id;

    /* renamed from: y */
    private static final int f4392y = DiveLogEntry_.refStateQuaternionW.f9437id;

    /* renamed from: z */
    private static final int f4393z = DiveLogEntry_.refStateQuaternionX.f9437id;

    /* renamed from: A */
    private static final int f4354A = DiveLogEntry_.refStateQuaternionY.f9437id;

    /* renamed from: B */
    private static final int f4355B = DiveLogEntry_.refStateQuaternionZ.f9437id;

    /* renamed from: C */
    private static final int f4356C = DiveLogEntry_.temperature.f9437id;

    /* renamed from: D */
    private static final int f4357D = DiveLogEntry_.stateDepth.f9437id;

    /* renamed from: E */
    private static final int f4358E = DiveLogEntry_.refStateDepth.f9437id;

    /* renamed from: F */
    private static final int f4359F = DiveLogEntry_.rpmMotor0.f9437id;

    /* renamed from: G */
    private static final int f4360G = DiveLogEntry_.rpmMotor1.f9437id;

    /* renamed from: H */
    private static final int f4361H = DiveLogEntry_.rpmMotor2.f9437id;

    /* renamed from: I */
    private static final int f4362I = DiveLogEntry_.rpmMotor3.f9437id;

    /* renamed from: J */
    private static final int f4363J = DiveLogEntry_.ledState.f9437id;

    /* renamed from: K */
    private static final int f4364K = DiveLogEntry_.batteryState.f9437id;

    /* renamed from: L */
    private static final int f4365L = DiveLogEntry_.sensorsState.f9437id;

    /* renamed from: M */
    private static final int f4366M = DiveLogEntry_.robotOperationState.f9437id;

    /* renamed from: N */
    private static final int f4367N = DiveLogEntry_.remoteBattery.f9437id;

    /* renamed from: O */
    private static final int f4368O = DiveLogEntry_.buoyBattery.f9437id;

    /* renamed from: P */
    private static final int f4369P = DiveLogEntry_.phoneBattery.f9437id;

    /* renamed from: Q */
    private static final int f4370Q = DiveLogEntry_.remoteLinkState.f9437id;

    /* renamed from: R */
    private static final int f4371R = DiveLogEntry_.remotePER.f9437id;

    /* renamed from: S */
    private static final int f4372S = DiveLogEntry_.remoteRSSI.f9437id;

    /* renamed from: T */
    private static final int f4373T = DiveLogEntry_.remoteSNR.f9437id;

    /* renamed from: U */
    private static final int f4374U = DiveLogEntry_.photoUri.f9437id;

    /* renamed from: V */
    private static final int f4375V = DiveLogEntry_.parentId.f9437id;

    @Internal
    /* renamed from: com.navatics.app.framework.divelog.DiveLogEntryCursor$a */
    /* loaded from: classes.dex */
    static final class C1772a implements CursorFactory<DiveLogEntry> {
        @Override // io.objectbox.internal.CursorFactory
        /* renamed from: a */
        public Cursor<DiveLogEntry> mo3318a(Transaction transaction, long j, BoxStore boxStore) {
            return new DiveLogEntryCursor(transaction, j, boxStore);
        }
    }

    public DiveLogEntryCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, DiveLogEntry_.__INSTANCE, boxStore);
    }

    @Override // io.objectbox.Cursor
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final long mo3451b(DiveLogEntry diveLogEntry) {
        return f4376i.mo3317a(diveLogEntry);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.objectbox.Cursor
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public final long mo3456a(DiveLogEntry diveLogEntry) {
        ToOne<DiveLog> toOne = diveLogEntry.parent;
        if (toOne != 0 && toOne.internalRequiresPutTarget()) {
            Closeable a = m3457a(DiveLog.class);
            try {
                toOne.internalPutTarget(a);
            } finally {
                a.close();
            }
        }
        String str = diveLogEntry.detailIndex;
        int i = str != null ? f4378k : 0;
        String str2 = diveLogEntry.weather;
        int i2 = str2 != null ? f4381n : 0;
        String str3 = diveLogEntry.photoUri;
        collect313311(this.f9431d, 0L, 1, i, str, i2, str2, str3 != null ? f4374U : 0, str3, 0, null, f4377j, diveLogEntry.timestamp, f4375V, diveLogEntry.parent.getTargetId(), f4356C, diveLogEntry.temperature, f4357D, diveLogEntry.stateDepth, f4358E, diveLogEntry.refStateDepth, f4363J, diveLogEntry.ledState, f4379l, diveLogEntry.airTemperature, 0, Utils.DOUBLE_EPSILON);
        collect313311(this.f9431d, 0L, 0, 0, null, 0, null, 0, null, 0, null, f4364K, diveLogEntry.batteryState, f4365L, diveLogEntry.sensorsState, f4366M, diveLogEntry.robotOperationState, f4367N, diveLogEntry.remoteBattery, f4368O, diveLogEntry.buoyBattery, f4369P, diveLogEntry.phoneBattery, f4380m, diveLogEntry.waterTemperature, 0, Utils.DOUBLE_EPSILON);
        collect313311(this.f9431d, 0L, 0, 0, null, 0, null, 0, null, 0, null, f4371R, diveLogEntry.remotePER, f4372S, diveLogEntry.remoteRSSI, f4373T, diveLogEntry.remoteSNR, f4388u, diveLogEntry.stateQuaternionW, f4389v, diveLogEntry.stateQuaternionX, f4390w, diveLogEntry.stateQuaternionY, f4382o, diveLogEntry.windVelocity, 0, Utils.DOUBLE_EPSILON);
        collect313311(this.f9431d, 0L, 0, 0, null, 0, null, 0, null, 0, null, f4391x, diveLogEntry.stateQuaternionZ, f4392y, diveLogEntry.refStateQuaternionW, f4393z, diveLogEntry.refStateQuaternionX, f4354A, diveLogEntry.refStateQuaternionY, f4355B, diveLogEntry.refStateQuaternionZ, f4359F, diveLogEntry.rpmMotor0, f4383p, diveLogEntry.windDirection, 0, Utils.DOUBLE_EPSILON);
        collect002033(this.f9431d, 0L, 0, f4360G, diveLogEntry.rpmMotor1, f4361H, diveLogEntry.rpmMotor2, f4384q, diveLogEntry.buoyLongitude, f4385r, diveLogEntry.buoyLatitude, f4386s, diveLogEntry.phoneLongitude, 0, Utils.DOUBLE_EPSILON, 0, Utils.DOUBLE_EPSILON, 0, Utils.DOUBLE_EPSILON);
        long collect313311 = collect313311(this.f9431d, diveLogEntry.f4353id, 2, 0, null, 0, null, 0, null, 0, null, f4362I, diveLogEntry.rpmMotor3, f4370Q, diveLogEntry.remoteLinkState ? 1L : 0L, 0, 0L, 0, 0, 0, 0, 0, 0, f4387t, diveLogEntry.phoneLatitude, 0, Utils.DOUBLE_EPSILON);
        diveLogEntry.f4353id = collect313311;
        m8508c(diveLogEntry);
        return collect313311;
    }

    /* renamed from: c */
    private void m8508c(DiveLogEntry diveLogEntry) {
        diveLogEntry.__boxStore = this.f9433f;
    }
}
