package com.navatics.app.framework.user;

import com.navatics.app.framework.user.NvUserCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.InterfaceC3837a;
import io.objectbox.internal.InterfaceC3838b;
import io.objectbox.internal.ToOneGetter;
import io.objectbox.relation.RelationInfo;
import io.objectbox.relation.ToOne;

/* loaded from: classes.dex */
public final class NvUser_ implements EntityInfo<NvUser> {
    public static final Property<NvUser>[] __ALL_PROPERTIES;
    public static final String __DB_NAME = "NvUser";
    public static final int __ENTITY_ID = 3;
    public static final String __ENTITY_NAME = "NvUser";
    public static final Property<NvUser> __ID_PROPERTY;
    public static final RelationInfo<NvUser, SSUsrInfo> ssUsrInfo;
    public static final Class<NvUser> __ENTITY_CLASS = NvUser.class;
    public static final InterfaceC3837a<NvUser> __CURSOR_FACTORY = new NvUserCursor.C2365a();
    @Internal
    static final C2371a __ID_GETTER = new C2371a();
    public static final NvUser_ __INSTANCE = new NvUser_();

    /* renamed from: id */
    public static final Property<NvUser> f4827id = new Property<>(__INSTANCE, 0, 1, Long.TYPE, "id", true, "id");
    public static final Property<NvUser> usrId = new Property<>(__INSTANCE, 1, 2, String.class, "usrId");
    public static final Property<NvUser> email = new Property<>(__INSTANCE, 2, 3, String.class, "email");
    public static final Property<NvUser> nickName = new Property<>(__INSTANCE, 3, 4, String.class, "nickName");
    public static final Property<NvUser> gender = new Property<>(__INSTANCE, 4, 5, Integer.TYPE, "gender");
    public static final Property<NvUser> age = new Property<>(__INSTANCE, 5, 6, Integer.TYPE, "age");
    public static final Property<NvUser> usrImgLowres = new Property<>(__INSTANCE, 6, 7, String.class, "usrImgLowres");
    public static final Property<NvUser> usrImgHighres = new Property<>(__INSTANCE, 7, 8, String.class, "usrImgHighres");
    public static final Property<NvUser> token = new Property<>(__INSTANCE, 8, 9, String.class, "token");
    public static final Property<NvUser> ssUsrInfoId = new Property<>(__INSTANCE, 9, 10, Long.TYPE, "ssUsrInfoId", true);

    @Override // io.objectbox.EntityInfo
    public String getDbName() {
        return "NvUser";
    }

    @Override // io.objectbox.EntityInfo
    public int getEntityId() {
        return 3;
    }

    @Override // io.objectbox.EntityInfo
    public String getEntityName() {
        return "NvUser";
    }

    static {
        Property<NvUser> property = f4827id;
        __ALL_PROPERTIES = new Property[]{property, usrId, email, nickName, gender, age, usrImgLowres, usrImgHighres, token, ssUsrInfoId};
        __ID_PROPERTY = property;
        ssUsrInfo = new RelationInfo<>(__INSTANCE, SSUsrInfo_.__INSTANCE, ssUsrInfoId, new ToOneGetter<NvUser>() { // from class: com.navatics.app.framework.user.NvUser_.1
            @Override // io.objectbox.internal.ToOneGetter
            public ToOne<SSUsrInfo> getToOne(NvUser nvUser) {
                return nvUser.ssUsrInfo;
            }
        });
    }

    @Override // io.objectbox.EntityInfo
    public Class<NvUser> getEntityClass() {
        return __ENTITY_CLASS;
    }

    @Override // io.objectbox.EntityInfo
    public Property<NvUser>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    @Override // io.objectbox.EntityInfo
    public Property<NvUser> getIdProperty() {
        return __ID_PROPERTY;
    }

    @Override // io.objectbox.EntityInfo
    public InterfaceC3838b<NvUser> getIdGetter() {
        return __ID_GETTER;
    }

    @Override // io.objectbox.EntityInfo
    public InterfaceC3837a<NvUser> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Internal
    /* renamed from: com.navatics.app.framework.user.NvUser_$a */
    /* loaded from: classes.dex */
    public static final class C2371a implements InterfaceC3838b<NvUser> {
        C2371a() {
        }

        @Override // io.objectbox.internal.InterfaceC3838b
        /* renamed from: a */
        public long mo8516a(NvUser nvUser) {
            return nvUser.id;
        }
    }
}
