package com.navatics.app.framework.divelog;

import com.example.divelog.dao.entity.BaseDiveLogInfo;
import com.example.divelog.dao.entity.CommandCard;
import com.example.divelog.dao.entity.DiveLogItem;
import com.example.divelog.dao.p036a.IDiveLogNetHelper;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.Result;
import java.io.IOException;
import java.util.List;
import retrofit2.C3204l;

/* renamed from: com.navatics.app.framework.divelog.b */
/* loaded from: classes.dex */
public class DiveLogNetHelper implements IDiveLogNetHelper<CommandCard> {

    /* renamed from: a */
    public NvUserManager f4442a;

    public DiveLogNetHelper(NvUserManager nvUserManager) {
        this.f4442a = nvUserManager;
    }

    @Override // com.example.divelog.dao.p036a.IDiveLogNetHelper
    /* renamed from: a */
    public List<CommandCard> mo8438a(String str, int i) throws IOException {
        return this.f4442a.m7838a(str, i).mo142a().m67e().getData();
    }

    @Override // com.example.divelog.dao.p036a.IDiveLogNetHelper
    /* renamed from: a */
    public Integer mo8435a(String str, String str2, DiveLogItem diveLogItem, int i) throws IOException {
        C3204l<Result<Integer>> mo142a = this.f4442a.m7832a(str, str2, diveLogItem, i).mo142a();
        if (mo142a.m67e().getCode() == 0) {
            return mo142a.m67e().getData();
        }
        if (mo142a.m67e().getCode() == 2001) {
            return -2;
        }
        return -1;
    }

    @Override // com.example.divelog.dao.p036a.IDiveLogNetHelper
    /* renamed from: a */
    public Integer mo8436a(String str, String str2, BaseDiveLogInfo baseDiveLogInfo, int i) throws IOException {
        C3204l<Result<Integer>> mo142a = this.f4442a.m7833a(str, str2, baseDiveLogInfo, i).mo142a();
        if (mo142a.m67e().getCode() == 0) {
            return mo142a.m67e().getData();
        }
        if (mo142a.m67e().getCode() == 2001) {
            return -2;
        }
        return -1;
    }

    @Override // com.example.divelog.dao.p036a.IDiveLogNetHelper
    /* renamed from: b */
    public Integer mo8434b(String str, int i) throws IOException {
        C3204l<Result<Integer>> mo142a = this.f4442a.m7820b(str, i).mo142a();
        if (mo142a.m67e().getCode() == 0) {
            return mo142a.m67e().getData();
        }
        if (mo142a.m67e().getCode() == 2001) {
            return -2;
        }
        return -1;
    }

    @Override // com.example.divelog.dao.p036a.IDiveLogNetHelper
    /* renamed from: a */
    public Integer mo8437a(String str, String str2, int i) throws IOException {
        C3204l<Result<Integer>> mo142a = this.f4442a.m7834a(str, str2, i).mo142a();
        if (mo142a.m67e().getCode() == 0) {
            return mo142a.m67e().getData();
        }
        if (mo142a.m67e().getCode() == 2001) {
            return -2;
        }
        return -1;
    }

    @Override // com.example.divelog.dao.p036a.IDiveLogNetHelper
    /* renamed from: a */
    public Integer mo8441a(BaseDiveLogInfo baseDiveLogInfo) throws IOException {
        C3204l<Result<Integer>> mo142a = this.f4442a.m7850a(baseDiveLogInfo).mo142a();
        Result<Integer> m67e = mo142a.m67e();
        if (m67e.getCode() == 0) {
            return m67e.getData();
        }
        if (mo142a.m67e().getCode() == 2001) {
            return -2;
        }
        return -1;
    }

    @Override // com.example.divelog.dao.p036a.IDiveLogNetHelper
    /* renamed from: a */
    public Integer mo8440a(DiveLogItem diveLogItem, int i) throws IOException {
        C3204l<Result<Integer>> mo142a = this.f4442a.m7849a(diveLogItem, i).mo142a();
        Result<Integer> m67e = mo142a.m67e();
        if (m67e.getCode() == 0) {
            return m67e.getData();
        }
        if (mo142a.m67e().getCode() == 2001) {
            return -2;
        }
        return -1;
    }

    @Override // com.example.divelog.dao.p036a.IDiveLogNetHelper
    /* renamed from: a */
    public int mo8439a(String str) throws IOException {
        Result<Integer> m67e = this.f4442a.m7800e(str).mo142a().m67e();
        if (m67e.getCode() == 0) {
            return m67e.getData().intValue();
        }
        return 0;
    }
}
