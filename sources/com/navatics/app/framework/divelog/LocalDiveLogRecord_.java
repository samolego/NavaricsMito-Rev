package com.navatics.app.framework.divelog;

import com.navatics.app.framework.divelog.LocalDiveLogRecordCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import io.objectbox.internal.ToManyGetter;
import io.objectbox.internal.ToOneGetter;
import io.objectbox.relation.RelationInfo;
import io.objectbox.relation.ToOne;
import java.util.List;

/* loaded from: classes.dex */
public final class LocalDiveLogRecord_ implements EntityInfo<LocalDiveLogRecord> {
    public static final Property<LocalDiveLogRecord>[] __ALL_PROPERTIES;
    public static final String __DB_NAME = "LocalDiveLogRecord";
    public static final int __ENTITY_ID = 9;
    public static final String __ENTITY_NAME = "LocalDiveLogRecord";
    public static final Property<LocalDiveLogRecord> __ID_PROPERTY;
    public static final RelationInfo<LocalDiveLogRecord, Command> entries;
    public static final Class<LocalDiveLogRecord> __ENTITY_CLASS = LocalDiveLogRecord.class;
    public static final CursorFactory<LocalDiveLogRecord> __CURSOR_FACTORY = new LocalDiveLogRecordCursor.C1779a();
    @Internal
    static final C1782a __ID_GETTER = new C1782a();
    public static final LocalDiveLogRecord_ __INSTANCE = new LocalDiveLogRecord_();

    /* renamed from: id */
    public static final Property<LocalDiveLogRecord> f4402id = new Property<>(__INSTANCE, 0, 1, Long.TYPE, "id", true, "id");
    public static final Property<LocalDiveLogRecord> email = new Property<>(__INSTANCE, 1, 2, String.class, "email");
    public static final Property<LocalDiveLogRecord> startTime = new Property<>(__INSTANCE, 2, 3, String.class, "startTime");
    public static final Property<LocalDiveLogRecord> version = new Property<>(__INSTANCE, 3, 4, Integer.TYPE, "version");

    @Override // io.objectbox.EntityInfo
    public String getDbName() {
        return "LocalDiveLogRecord";
    }

    @Override // io.objectbox.EntityInfo
    public int getEntityId() {
        return 9;
    }

    @Override // io.objectbox.EntityInfo
    public String getEntityName() {
        return "LocalDiveLogRecord";
    }

    static {
        Property<LocalDiveLogRecord> property = f4402id;
        __ALL_PROPERTIES = new Property[]{property, email, startTime, version};
        __ID_PROPERTY = property;
        entries = new RelationInfo<>(__INSTANCE, Command_.__INSTANCE, new ToManyGetter<LocalDiveLogRecord>() { // from class: com.navatics.app.framework.divelog.LocalDiveLogRecord_.1
            @Override // io.objectbox.internal.ToManyGetter
            public List<Command> getToMany(LocalDiveLogRecord localDiveLogRecord) {
                return localDiveLogRecord.entries;
            }
        }, Command_.parentId, new ToOneGetter<Command>() { // from class: com.navatics.app.framework.divelog.LocalDiveLogRecord_.2
            @Override // io.objectbox.internal.ToOneGetter
            public ToOne<LocalDiveLogRecord> getToOne(Command command) {
                return command.parent;
            }
        });
    }

    @Override // io.objectbox.EntityInfo
    public Class<LocalDiveLogRecord> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override // io.objectbox.EntityInfo
    public Property<LocalDiveLogRecord>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override // io.objectbox.EntityInfo
    public Property<LocalDiveLogRecord> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override // io.objectbox.EntityInfo
    public IdGetter<LocalDiveLogRecord> getIdGetter() {
        return __ID_GETTER;
    }

    @Override // io.objectbox.EntityInfo
    public CursorFactory<LocalDiveLogRecord> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    @Internal
    /* renamed from: com.navatics.app.framework.divelog.LocalDiveLogRecord_$a */
    /* loaded from: classes.dex */
    static final class C1782a implements IdGetter<LocalDiveLogRecord> {
        C1782a() {
        }

        @Override // io.objectbox.internal.IdGetter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public long mo3317a(LocalDiveLogRecord localDiveLogRecord) {
            return localDiveLogRecord.f4396id;
        }
    }
}
