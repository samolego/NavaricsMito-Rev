package com.example.divelog.dao.p036a;

import com.example.divelog.dao.entity.BaseDiveLogInfo;
import com.example.divelog.dao.entity.CommandCard;
import com.example.divelog.dao.entity.DiveLogItem;
import java.io.IOException;
import java.util.List;

/* renamed from: com.example.divelog.dao.a.d */
/* loaded from: classes.dex */
public interface IDiveLogNetHelper<T extends CommandCard> {
    /* renamed from: a */
    int mo8439a(String str) throws IOException;

    /* renamed from: a */
    Integer mo8441a(BaseDiveLogInfo baseDiveLogInfo) throws IOException;

    /* renamed from: a */
    Integer mo8440a(DiveLogItem diveLogItem, int i) throws IOException;

    /* renamed from: a */
    Integer mo8437a(String str, String str2, int i) throws IOException;

    /* renamed from: a */
    Integer mo8436a(String str, String str2, BaseDiveLogInfo baseDiveLogInfo, int i) throws IOException;

    /* renamed from: a */
    Integer mo8435a(String str, String str2, DiveLogItem diveLogItem, int i) throws IOException;

    /* renamed from: a */
    List<T> mo8438a(String str, int i) throws IOException;

    /* renamed from: b */
    Integer mo8434b(String str, int i) throws IOException;
}
