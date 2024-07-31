package com.navatics.app.framework.divelog;

import com.navatics.app.framework.divelog.DiveLogEntryCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import io.objectbox.internal.ToOneGetter;
import io.objectbox.relation.RelationInfo;
import io.objectbox.relation.ToOne;

/* loaded from: classes.dex */
public final class DiveLogEntry_ implements EntityInfo<DiveLogEntry> {
    public static final Property<DiveLogEntry>[] __ALL_PROPERTIES;
    public static final String __DB_NAME = "DiveLogEntry";
    public static final int __ENTITY_ID = 2;
    public static final String __ENTITY_NAME = "DiveLogEntry";
    public static final Property<DiveLogEntry> __ID_PROPERTY;
    public static final RelationInfo<DiveLogEntry, DiveLog> parent;
    public static final Class<DiveLogEntry> __ENTITY_CLASS = DiveLogEntry.class;
    public static final CursorFactory<DiveLogEntry> __CURSOR_FACTORY = new DiveLogEntryCursor.C1772a();
    @Internal
    static final C1774a __ID_GETTER = new C1774a();
    public static final DiveLogEntry_ __INSTANCE = new DiveLogEntry_();

    /* renamed from: id */
    public static final Property<DiveLogEntry> f4394id = new Property<>(__INSTANCE, 0, 1, Long.TYPE, "id", true, "id");
    public static final Property<DiveLogEntry> timestamp = new Property<>(__INSTANCE, 1, 2, Long.TYPE, "timestamp");
    public static final Property<DiveLogEntry> detailIndex = new Property<>(__INSTANCE, 2, 40, String.class, "detailIndex");
    public static final Property<DiveLogEntry> airTemperature = new Property<>(__INSTANCE, 3, 3, Float.TYPE, "airTemperature");
    public static final Property<DiveLogEntry> waterTemperature = new Property<>(__INSTANCE, 4, 4, Float.TYPE, "waterTemperature");
    public static final Property<DiveLogEntry> weather = new Property<>(__INSTANCE, 5, 5, String.class, "weather");
    public static final Property<DiveLogEntry> windVelocity = new Property<>(__INSTANCE, 6, 6, Float.TYPE, "windVelocity");
    public static final Property<DiveLogEntry> windDirection = new Property<>(__INSTANCE, 7, 7, Float.TYPE, "windDirection");
    public static final Property<DiveLogEntry> buoyLongitude = new Property<>(__INSTANCE, 8, 8, Float.TYPE, "buoyLongitude");
    public static final Property<DiveLogEntry> buoyLatitude = new Property<>(__INSTANCE, 9, 9, Float.TYPE, "buoyLatitude");
    public static final Property<DiveLogEntry> phoneLongitude = new Property<>(__INSTANCE, 10, 10, Float.TYPE, "phoneLongitude");
    public static final Property<DiveLogEntry> phoneLatitude = new Property<>(__INSTANCE, 11, 11, Float.TYPE, "phoneLatitude");
    public static final Property<DiveLogEntry> stateQuaternionW = new Property<>(__INSTANCE, 12, 12, Short.TYPE, "stateQuaternionW");
    public static final Property<DiveLogEntry> stateQuaternionX = new Property<>(__INSTANCE, 13, 13, Short.TYPE, "stateQuaternionX");
    public static final Property<DiveLogEntry> stateQuaternionY = new Property<>(__INSTANCE, 14, 14, Short.TYPE, "stateQuaternionY");
    public static final Property<DiveLogEntry> stateQuaternionZ = new Property<>(__INSTANCE, 15, 15, Short.TYPE, "stateQuaternionZ");
    public static final Property<DiveLogEntry> refStateQuaternionW = new Property<>(__INSTANCE, 16, 16, Short.TYPE, "refStateQuaternionW");
    public static final Property<DiveLogEntry> refStateQuaternionX = new Property<>(__INSTANCE, 17, 17, Short.TYPE, "refStateQuaternionX");
    public static final Property<DiveLogEntry> refStateQuaternionY = new Property<>(__INSTANCE, 18, 18, Short.TYPE, "refStateQuaternionY");
    public static final Property<DiveLogEntry> refStateQuaternionZ = new Property<>(__INSTANCE, 19, 19, Short.TYPE, "refStateQuaternionZ");
    public static final Property<DiveLogEntry> temperature = new Property<>(__INSTANCE, 20, 20, Integer.TYPE, "temperature");
    public static final Property<DiveLogEntry> stateDepth = new Property<>(__INSTANCE, 21, 21, Integer.TYPE, "stateDepth");
    public static final Property<DiveLogEntry> refStateDepth = new Property<>(__INSTANCE, 22, 22, Integer.TYPE, "refStateDepth");
    public static final Property<DiveLogEntry> rpmMotor0 = new Property<>(__INSTANCE, 23, 23, Short.TYPE, "rpmMotor0");
    public static final Property<DiveLogEntry> rpmMotor1 = new Property<>(__INSTANCE, 24, 24, Short.TYPE, "rpmMotor1");
    public static final Property<DiveLogEntry> rpmMotor2 = new Property<>(__INSTANCE, 25, 25, Short.TYPE, "rpmMotor2");
    public static final Property<DiveLogEntry> rpmMotor3 = new Property<>(__INSTANCE, 26, 26, Short.TYPE, "rpmMotor3");
    public static final Property<DiveLogEntry> ledState = new Property<>(__INSTANCE, 27, 27, Integer.TYPE, "ledState");
    public static final Property<DiveLogEntry> batteryState = new Property<>(__INSTANCE, 28, 28, Integer.TYPE, "batteryState");
    public static final Property<DiveLogEntry> sensorsState = new Property<>(__INSTANCE, 29, 29, Integer.TYPE, "sensorsState");
    public static final Property<DiveLogEntry> robotOperationState = new Property<>(__INSTANCE, 30, 30, Integer.TYPE, "robotOperationState");
    public static final Property<DiveLogEntry> remoteBattery = new Property<>(__INSTANCE, 31, 31, Integer.TYPE, "remoteBattery");
    public static final Property<DiveLogEntry> buoyBattery = new Property<>(__INSTANCE, 32, 32, Integer.TYPE, "buoyBattery");
    public static final Property<DiveLogEntry> phoneBattery = new Property<>(__INSTANCE, 33, 33, Integer.TYPE, "phoneBattery");
    public static final Property<DiveLogEntry> remoteLinkState = new Property<>(__INSTANCE, 34, 34, Boolean.TYPE, "remoteLinkState");
    public static final Property<DiveLogEntry> remotePER = new Property<>(__INSTANCE, 35, 35, Integer.TYPE, "remotePER");
    public static final Property<DiveLogEntry> remoteRSSI = new Property<>(__INSTANCE, 36, 36, Integer.TYPE, "remoteRSSI");
    public static final Property<DiveLogEntry> remoteSNR = new Property<>(__INSTANCE, 37, 37, Integer.TYPE, "remoteSNR");
    public static final Property<DiveLogEntry> photoUri = new Property<>(__INSTANCE, 38, 38, String.class, "photoUri");
    public static final Property<DiveLogEntry> parentId = new Property<>(__INSTANCE, 39, 39, Long.TYPE, "parentId", true);

    @Override // io.objectbox.EntityInfo
    public String getDbName() {
        return "DiveLogEntry";
    }

    @Override // io.objectbox.EntityInfo
    public int getEntityId() {
        return 2;
    }

    @Override // io.objectbox.EntityInfo
    public String getEntityName() {
        return "DiveLogEntry";
    }

    static {
        Property<DiveLogEntry> property = f4394id;
        __ALL_PROPERTIES = new Property[]{property, timestamp, detailIndex, airTemperature, waterTemperature, weather, windVelocity, windDirection, buoyLongitude, buoyLatitude, phoneLongitude, phoneLatitude, stateQuaternionW, stateQuaternionX, stateQuaternionY, stateQuaternionZ, refStateQuaternionW, refStateQuaternionX, refStateQuaternionY, refStateQuaternionZ, temperature, stateDepth, refStateDepth, rpmMotor0, rpmMotor1, rpmMotor2, rpmMotor3, ledState, batteryState, sensorsState, robotOperationState, remoteBattery, buoyBattery, phoneBattery, remoteLinkState, remotePER, remoteRSSI, remoteSNR, photoUri, parentId};
        __ID_PROPERTY = property;
        parent = new RelationInfo<>(__INSTANCE, DiveLog_.__INSTANCE, parentId, new ToOneGetter<DiveLogEntry>() { // from class: com.navatics.app.framework.divelog.DiveLogEntry_.1
            @Override // io.objectbox.internal.ToOneGetter
            public ToOne<DiveLog> getToOne(DiveLogEntry diveLogEntry) {
                return diveLogEntry.parent;
            }
        });
    }

    @Override // io.objectbox.EntityInfo
    public Class<DiveLogEntry> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override // io.objectbox.EntityInfo
    public Property<DiveLogEntry>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override // io.objectbox.EntityInfo
    public Property<DiveLogEntry> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override // io.objectbox.EntityInfo
    public IdGetter<DiveLogEntry> getIdGetter() {
        return __ID_GETTER;
    }

    @Override // io.objectbox.EntityInfo
    public CursorFactory<DiveLogEntry> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    @Internal
    /* renamed from: com.navatics.app.framework.divelog.DiveLogEntry_$a */
    /* loaded from: classes.dex */
    static final class C1774a implements IdGetter<DiveLogEntry> {
        C1774a() {
        }

        @Override // io.objectbox.internal.IdGetter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public long mo3317a(DiveLogEntry diveLogEntry) {
            return diveLogEntry.f4353id;
        }
    }
}
