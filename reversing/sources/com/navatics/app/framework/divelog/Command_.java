package com.navatics.app.framework.divelog;

import com.navatics.app.framework.divelog.CommandCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import io.objectbox.internal.ToOneGetter;
import io.objectbox.relation.RelationInfo;
import io.objectbox.relation.ToOne;
import java.util.Date;

/* loaded from: classes.dex */
public final class Command_ implements EntityInfo<Command> {
    public static final Property<Command>[] __ALL_PROPERTIES;
    public static final String __DB_NAME = "Command";
    public static final int __ENTITY_ID = 8;
    public static final String __ENTITY_NAME = "Command";
    public static final Property<Command> __ID_PROPERTY;
    public static final RelationInfo<Command, LocalDiveLogRecord> parent;
    public static final Class<Command> __ENTITY_CLASS = Command.class;
    public static final CursorFactory<Command> __CURSOR_FACTORY = new CommandCursor.C1765a();
    @Internal
    static final C1767a __ID_GETTER = new C1767a();
    public static final Command_ __INSTANCE = new Command_();
    public static final Property<Command> command = new Property<>(__INSTANCE, 0, 11, String.class, "command");
    public static final Property<Command> startTime = new Property<>(__INSTANCE, 1, 12, String.class, "startTime");
    public static final Property<Command> detailIndex = new Property<>(__INSTANCE, 2, 13, String.class, "detailIndex");
    public static final Property<Command> version = new Property<>(__INSTANCE, 3, 14, Integer.TYPE, "version");
    public static final Property<Command> createTime = new Property<>(__INSTANCE, 4, 15, Date.class, "createTime");
    public static final Property<Command> json = new Property<>(__INSTANCE, 5, 16, String.class, "json");
    public static final Property<Command> filedName = new Property<>(__INSTANCE, 6, 17, String.class, "filedName");

    /* renamed from: id */
    public static final Property<Command> f4331id = new Property<>(__INSTANCE, 7, 1, Long.TYPE, "id", true, "id");
    public static final Property<Command> parentId = new Property<>(__INSTANCE, 8, 10, Long.TYPE, "parentId", true);

    @Override // io.objectbox.EntityInfo
    public String getDbName() {
        return "Command";
    }

    @Override // io.objectbox.EntityInfo
    public int getEntityId() {
        return 8;
    }

    @Override // io.objectbox.EntityInfo
    public String getEntityName() {
        return "Command";
    }

    static {
        Property<Command> property = f4331id;
        __ALL_PROPERTIES = new Property[]{command, startTime, detailIndex, version, createTime, json, filedName, property, parentId};
        __ID_PROPERTY = property;
        parent = new RelationInfo<>(__INSTANCE, LocalDiveLogRecord_.__INSTANCE, parentId, new ToOneGetter<Command>() { // from class: com.navatics.app.framework.divelog.Command_.1
            @Override // io.objectbox.internal.ToOneGetter
            public ToOne<LocalDiveLogRecord> getToOne(Command command2) {
                return command2.parent;
            }
        });
    }

    @Override // io.objectbox.EntityInfo
    public Class<Command> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override // io.objectbox.EntityInfo
    public Property<Command>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override // io.objectbox.EntityInfo
    public Property<Command> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override // io.objectbox.EntityInfo
    public IdGetter<Command> getIdGetter() {
        return __ID_GETTER;
    }

    @Override // io.objectbox.EntityInfo
    public CursorFactory<Command> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Internal
    /* renamed from: com.navatics.app.framework.divelog.Command_$a */
    /* loaded from: classes.dex */
    public static final class C1767a implements IdGetter<Command> {
        C1767a() {
        }

        @Override // io.objectbox.internal.IdGetter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public long mo3317a(Command command) {
            return command.f4321id;
        }
    }
}
