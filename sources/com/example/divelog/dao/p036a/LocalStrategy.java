package com.example.divelog.dao.p036a;

import com.example.divelog.dao.entity.CommandCard;

/* renamed from: com.example.divelog.dao.a.e */
/* loaded from: classes.dex */
public class LocalStrategy<T extends CommandCard> implements Strategy<T> {
    @Override // com.example.divelog.dao.p036a.Strategy
    /* renamed from: a */
    public boolean mo11462a(T t, T t2) {
        if (t.getCommand().equals(CommandCard.ADD_ITEM)) {
            if (t2.getCommand().equals(CommandCard.UPDATE_ITEM) || t2.getCommand().equals(CommandCard.DELETE)) {
                t.setCommand(CommandCard.NODO);
                return true;
            }
            return false;
        }
        return false;
    }
}
