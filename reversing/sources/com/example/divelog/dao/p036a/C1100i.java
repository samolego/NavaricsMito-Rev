package com.example.divelog.dao.p036a;

import com.example.divelog.dao.entity.CommandCard;

/* renamed from: com.example.divelog.dao.a.i */
/* loaded from: classes.dex */
public class SameUpdateStrategy<T extends CommandCard> implements Strategy<T> {
    @Override // com.example.divelog.dao.p036a.Strategy
    /* renamed from: a */
    public boolean mo11462a(T t, T t2) {
        if (t.getCommand().equals(t2.getCommand()) && ((t2.getCommand().equals(CommandCard.UPDATE_ITEM) || t2.getCommand().equals(CommandCard.UPDATE)) && t2.getFiledName().equals(t.getFiledName()))) {
            if (t.getCreateTime().getTime() > t2.getCreateTime().getTime()) {
                t2.setCommand(CommandCard.NODO);
            } else {
                t.setCommand(CommandCard.NODO);
            }
            return true;
        } else if (((t.getCommand().equals(CommandCard.ADD_ITEM) && t2.getCommand().equals(CommandCard.DELETE_ITEM)) || (t.getCommand().equals(CommandCard.UPDATE_ITEM) && (t2.getCommand().equals(CommandCard.ADD_ITEM) || t2.getCommand().equals(CommandCard.DELETE_ITEM)))) && t.getDetailIndex().equals(t2.getDetailIndex())) {
            if (t.getCreateTime().getTime() > t2.getCreateTime().getTime()) {
                t2.setCommand(CommandCard.NODO);
            } else {
                t.setCommand(CommandCard.NODO);
            }
            return true;
        } else if (t2.getCommand().equals(CommandCard.DELETE)) {
            if (t.getCommand().equals(CommandCard.UPDATE) || t.getCommand().equals(CommandCard.UPDATE_ITEM) || t.getCommand().equals(CommandCard.DELETE_ITEM)) {
                if (t.getCreateTime().getTime() > t2.getCreateTime().getTime()) {
                    t2.setCommand(CommandCard.RESTRORE_DIVELOG);
                } else {
                    t.setCommand(CommandCard.NODO);
                }
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}
