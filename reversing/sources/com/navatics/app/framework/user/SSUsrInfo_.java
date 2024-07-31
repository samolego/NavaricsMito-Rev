package com.navatics.app.framework.user;

import com.navatics.app.framework.user.SSUsrInfoCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

/* loaded from: classes.dex */
public final class SSUsrInfo_ implements EntityInfo<SSUsrInfo> {
    public static final Property<SSUsrInfo>[] __ALL_PROPERTIES;
    public static final String __DB_NAME = "SSUsrInfo";
    public static final int __ENTITY_ID = 4;
    public static final String __ENTITY_NAME = "SSUsrInfo";
    public static final Property<SSUsrInfo> __ID_PROPERTY;
    public static final Class<SSUsrInfo> __ENTITY_CLASS = SSUsrInfo.class;
    public static final CursorFactory<SSUsrInfo> __CURSOR_FACTORY = new SSUsrInfoCursor.C1853a();
    @Internal
    static final C1854a __ID_GETTER = new C1854a();
    public static final SSUsrInfo_ __INSTANCE = new SSUsrInfo_();

    /* renamed from: id */
    public static final Property<SSUsrInfo> f4837id = new Property<>(__INSTANCE, 0, 1, Long.TYPE, "id", true, "id");
    public static final Property<SSUsrInfo> openid = new Property<>(__INSTANCE, 1, 2, String.class, "openid");
    public static final Property<SSUsrInfo> uuid = new Property<>(__INSTANCE, 2, 3, String.class, "uuid");
    public static final Property<SSUsrInfo> accessToken = new Property<>(__INSTANCE, 3, 4, String.class, "accessToken");
    public static final Property<SSUsrInfo> expiresIn = new Property<>(__INSTANCE, 4, 5, String.class, "expiresIn");
    public static final Property<SSUsrInfo> tokenType = new Property<>(__INSTANCE, 5, 6, String.class, "tokenType");
    public static final Property<SSUsrInfo> scope = new Property<>(__INSTANCE, 6, 7, String.class, "scope");
    public static final Property<SSUsrInfo> refreshToken = new Property<>(__INSTANCE, 7, 8, String.class, "refreshToken");

    @Override // io.objectbox.EntityInfo
    public String getDbName() {
        return "SSUsrInfo";
    }

    @Override // io.objectbox.EntityInfo
    public int getEntityId() {
        return 4;
    }

    @Override // io.objectbox.EntityInfo
    public String getEntityName() {
        return "SSUsrInfo";
    }

    static {
        Property<SSUsrInfo> property = f4837id;
        __ALL_PROPERTIES = new Property[]{property, openid, uuid, accessToken, expiresIn, tokenType, scope, refreshToken};
        __ID_PROPERTY = property;
    }

    @Override // io.objectbox.EntityInfo
    public Class<SSUsrInfo> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override // io.objectbox.EntityInfo
    public Property<SSUsrInfo>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override // io.objectbox.EntityInfo
    public Property<SSUsrInfo> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override // io.objectbox.EntityInfo
    public IdGetter<SSUsrInfo> getIdGetter() {
        return __ID_GETTER;
    }

    @Override // io.objectbox.EntityInfo
    public CursorFactory<SSUsrInfo> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    @Internal
    /* renamed from: com.navatics.app.framework.user.SSUsrInfo_$a */
    /* loaded from: classes.dex */
    static final class C1854a implements IdGetter<SSUsrInfo> {
        C1854a() {
        }

        @Override // io.objectbox.internal.IdGetter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public long mo3317a(SSUsrInfo sSUsrInfo) {
            return sSUsrInfo.f4828id;
        }
    }
}
