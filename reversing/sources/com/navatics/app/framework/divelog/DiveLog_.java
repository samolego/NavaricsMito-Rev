package com.navatics.app.framework.divelog;

import android.support.p008v4.app.NotificationCompat;
import com.navatics.app.framework.divelog.DiveLogCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import io.objectbox.internal.ToManyGetter;
import io.objectbox.internal.ToOneGetter;
import io.objectbox.relation.RelationInfo;
import io.objectbox.relation.ToOne;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public final class DiveLog_ implements EntityInfo<DiveLog> {
    public static final Property<DiveLog>[] __ALL_PROPERTIES;
    public static final String __DB_NAME = "DiveLog";
    public static final int __ENTITY_ID = 1;
    public static final String __ENTITY_NAME = "DiveLog";
    public static final Property<DiveLog> __ID_PROPERTY;
    public static final RelationInfo<DiveLog, DiveLogEntry> entries;
    public static final Class<DiveLog> __ENTITY_CLASS = DiveLog.class;
    public static final CursorFactory<DiveLog> __CURSOR_FACTORY = new DiveLogCursor.C1771a();
    @Internal
    static final C1777a __ID_GETTER = new C1777a();
    public static final DiveLog_ __INSTANCE = new DiveLog_();

    /* renamed from: id */
    public static final Property<DiveLog> f4395id = new Property<>(__INSTANCE, 0, 1, Long.TYPE, "id", true, "id");
    public static final Property<DiveLog> email = new Property<>(__INSTANCE, 1, 2, String.class, "email");
    public static final Property<DiveLog> place = new Property<>(__INSTANCE, 2, 3, String.class, "place");
    public static final Property<DiveLog> date = new Property<>(__INSTANCE, 3, 4, Date.class, "date");
    public static final Property<DiveLog> longitude = new Property<>(__INSTANCE, 4, 5, String.class, "longitude");
    public static final Property<DiveLog> latitude = new Property<>(__INSTANCE, 5, 6, String.class, "latitude");
    public static final Property<DiveLog> weather = new Property<>(__INSTANCE, 6, 7, String.class, "weather");
    public static final Property<DiveLog> startTime = new Property<>(__INSTANCE, 7, 8, Long.TYPE, "startTime");
    public static final Property<DiveLog> endTime = new Property<>(__INSTANCE, 8, 9, Long.TYPE, "endTime");
    public static final Property<DiveLog> averageDepth = new Property<>(__INSTANCE, 9, 10, Integer.TYPE, "averageDepth");
    public static final Property<DiveLog> temperature = new Property<>(__INSTANCE, 10, 11, Integer.TYPE, "temperature");
    public static final Property<DiveLog> comment = new Property<>(__INSTANCE, 11, 12, String.class, "comment");
    public static final Property<DiveLog> uploaded = new Property<>(__INSTANCE, 12, 13, Boolean.TYPE, "uploaded");
    public static final Property<DiveLog> status = new Property<>(__INSTANCE, 13, 14, Integer.TYPE, NotificationCompat.CATEGORY_STATUS);
    public static final Property<DiveLog> maxDepth = new Property<>(__INSTANCE, 14, 15, Integer.TYPE, "maxDepth");
    public static final Property<DiveLog> minDepth = new Property<>(__INSTANCE, 15, 16, Integer.TYPE, "minDepth");
    public static final Property<DiveLog> maxTemp = new Property<>(__INSTANCE, 16, 17, Integer.TYPE, "maxTemp");
    public static final Property<DiveLog> minTemp = new Property<>(__INSTANCE, 17, 18, Integer.TYPE, "minTemp");
    public static final Property<DiveLog> fakeDelete = new Property<>(__INSTANCE, 18, 19, Boolean.TYPE, "fakeDelete");

    @Override // io.objectbox.EntityInfo
    public String getDbName() {
        return "DiveLog";
    }

    @Override // io.objectbox.EntityInfo
    public int getEntityId() {
        return 1;
    }

    @Override // io.objectbox.EntityInfo
    public String getEntityName() {
        return "DiveLog";
    }

    static {
        Property<DiveLog> property = f4395id;
        __ALL_PROPERTIES = new Property[]{property, email, place, date, longitude, latitude, weather, startTime, endTime, averageDepth, temperature, comment, uploaded, status, maxDepth, minDepth, maxTemp, minTemp, fakeDelete};
        __ID_PROPERTY = property;
        entries = new RelationInfo<>(__INSTANCE, DiveLogEntry_.__INSTANCE, new ToManyGetter<DiveLog>() { // from class: com.navatics.app.framework.divelog.DiveLog_.1
            @Override // io.objectbox.internal.ToManyGetter
            public List<DiveLogEntry> getToMany(DiveLog diveLog) {
                return diveLog.entries;
            }
        }, DiveLogEntry_.parentId, new ToOneGetter<DiveLogEntry>() { // from class: com.navatics.app.framework.divelog.DiveLog_.2
            @Override // io.objectbox.internal.ToOneGetter
            public ToOne<DiveLog> getToOne(DiveLogEntry diveLogEntry) {
                return diveLogEntry.parent;
            }
        });
    }

    @Override // io.objectbox.EntityInfo
    public Class<DiveLog> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override // io.objectbox.EntityInfo
    public Property<DiveLog>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override // io.objectbox.EntityInfo
    public Property<DiveLog> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override // io.objectbox.EntityInfo
    public IdGetter<DiveLog> getIdGetter() {
        return __ID_GETTER;
    }

    @Override // io.objectbox.EntityInfo
    public CursorFactory<DiveLog> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    @Internal
    /* renamed from: com.navatics.app.framework.divelog.DiveLog_$a */
    /* loaded from: classes.dex */
    static final class C1777a implements IdGetter<DiveLog> {
        C1777a() {
        }

        @Override // io.objectbox.internal.IdGetter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public long mo3317a(DiveLog diveLog) {
            return diveLog.f4332id;
        }
    }
}
