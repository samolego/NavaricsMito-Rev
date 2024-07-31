package com.navatics.app.framework.user;

import com.navatics.app.framework.C2353p;
import io.objectbox.BoxStore;
import io.objectbox.C3800a;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.InterfaceC3810Id;
import io.objectbox.relation.ToOne;

@Entity
/* loaded from: classes.dex */
public class NvUser {
    public static final int AGE_UNKNOWN = -1;
    public static final int GENDER_FEMALE = 1;
    public static final int GENDER_MALE = 0;
    public static final int GENDER_UNKNOWN = -1;
    public static final int INVALID_USR_ID = -1;
    transient BoxStore __boxStore;
    int age;
    String email;
    int gender;
    @InterfaceC3810Id
    long id;
    String nickName;
    ToOne<SSUsrInfo> ssUsrInfo = new ToOne<>(this, NvUser_.ssUsrInfo);
    String token;
    String usrId;
    String usrImgHighres;
    String usrImgLowres;

    public NvUser() {
    }

    public NvUser(String usrId, String email, String nickname, int gender, int age, String usrImgLowres, String usrImgHighres, String token, SSUsrInfo sSUsrInfo) {
        this.usrId = usrId;
        this.email = email;
        this.nickName = nickname;
        this.gender = gender;
        this.age = age;
        this.usrImgLowres = usrImgLowres;
        this.usrImgHighres = usrImgHighres;
        this.token = token;
        this.ssUsrInfo.setTarget(sSUsrInfo);
    }

    public NvUser(long j, String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, long j2) {
        this.id = j;
        this.usrId = str;
        this.email = str2;
        this.nickName = str3;
        this.gender = i;
        this.age = i2;
        this.usrImgLowres = str4;
        this.usrImgHighres = str5;
        this.token = str6;
        this.ssUsrInfo.setTargetId(j2);
    }

    public long getId() {
        return this.id;
    }

    public String getUsrId() {
        return this.usrId;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    public String getUsrImgLowres() {
        return this.usrImgLowres;
    }

    public String getUsrImgHighres() {
        return this.usrImgHighres;
    }

    public String getToken() {
        return this.token;
    }

    public void setUsrId(String str) {
        this.usrId = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setAge(int i) {
        this.age = i;
    }

    public void setUsrImgLowres(String str) {
        this.usrImgLowres = str;
    }

    public void setUsrImgHighres(String str) {
        this.usrImgHighres = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public ToOne<SSUsrInfo> getSsUsrInfo() {
        return this.ssUsrInfo;
    }

    public void setSsUsrInfo(SSUsrInfo sSUsrInfo) {
        if (this.ssUsrInfo.getTarget() != null) {
            SSUsrInfo target = this.ssUsrInfo.getTarget();
            target.setOpenid(sSUsrInfo.getOpenid());
            target.setUuid(sSUsrInfo.getUuid());
            target.setAccessToken(sSUsrInfo.getAccessToken());
            target.setExpiresIn(sSUsrInfo.getExpiresIn());
            target.setTokenType(sSUsrInfo.getTokenType());
            target.setScope(sSUsrInfo.getScope());
            target.setRefreshToken(sSUsrInfo.getRefreshToken());
            target.save();
            return;
        }
        this.ssUsrInfo.setTarget(sSUsrInfo);
    }

    public void save() {
        C2353p.m7934f().m3470d(NvUser.class).m3417b((C3800a) this);
    }

    public void deleteFromDb() {
        C2353p.m7934f().m3470d(NvUser.class).m3420b(this.id);
    }

    public String toString() {
        return "NvUser{usrId='" + this.usrId + "', email='" + this.email + "', nickName='" + this.nickName + "', gender=" + this.gender + ", age=" + this.age + ", usrImgLowres='" + this.usrImgLowres + "', usrImgHighres='" + this.usrImgHighres + "', token='" + this.token + "'}";
    }
}
