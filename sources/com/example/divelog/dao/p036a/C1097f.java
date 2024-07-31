package com.example.divelog.dao.p036a;

import com.example.divelog.dao.entity.CommandCard;

/* renamed from: com.example.divelog.dao.a.f */
/* loaded from: classes.dex */
public class NewUploadDiveLogItemStrategy<T extends CommandCard> implements Strategy<T> {
    @Override // com.example.divelog.dao.p036a.Strategy
    /* renamed from: a */
    public boolean mo11462a(T t, T t2) {
        if (t.getCommand().equals(CommandCard.DELETE_ITEM) && t2.getCommand().equals(CommandCard.UPDATE_ITEM)) {
            if (t2.getCreateTime().getTime() > t.getCreateTime().getTime()) {
                t.setCommand(CommandCard.REUPLOAD_DIVELOG_ITEM);
                t2.setCommand(CommandCard.NODO);
                return true;
            }
            t2.setCommand(CommandCard.NODO);
            return true;
        }
        return false;
    }
}
