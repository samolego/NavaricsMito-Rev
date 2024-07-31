package com.example.divelog.dao.p036a;

import com.example.divelog.dao.entity.CommandCard;

/* renamed from: com.example.divelog.dao.a.h */
/* loaded from: classes.dex */
public class SameIgnoreStrategy<T extends CommandCard> implements Strategy<T> {
    @Override // com.example.divelog.dao.p036a.Strategy
    /* renamed from: a */
    public boolean mo11462a(T t, T t2) {
        if (!t.getCommand().equals(t2.getCommand()) || t2.getCommand().equals(CommandCard.UPDATE) || t2.getCommand().equals(CommandCard.UPDATE_ITEM)) {
            return false;
        }
        t.setCommand(CommandCard.NODO);
        t2.setCommand(CommandCard.NODO);
        return true;
    }
}
