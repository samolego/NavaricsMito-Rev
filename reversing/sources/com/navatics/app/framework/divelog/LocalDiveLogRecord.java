package com.navatics.app.framework.divelog;

import com.example.divelog.dao.entity.CommandCard;
import com.example.divelog.dao.entity.LocalDiveLogRecordCard;
import com.navatics.app.framework.Navatics;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.InterfaceC2825Id;
import io.objectbox.relation.ToMany;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
/* loaded from: classes.dex */
public class LocalDiveLogRecord {
    transient BoxStore __boxStore;
    String email;
    @Backlink
    public ToMany<Command> entries = new ToMany<>(this, LocalDiveLogRecord_.entries);
    @InterfaceC2825Id

    /* renamed from: id */
    long f4396id;
    String startTime;
    int version;

    /* renamed from: a */
    public void m8502a(String str) {
        this.startTime = str;
    }

    /* renamed from: a */
    public int m8505a() {
        return this.version;
    }

    /* renamed from: b */
    public void m8498b(String str) {
        this.email = str;
    }

    /* renamed from: b */
    public void m8500b() {
        Navatics.m7933f().m3485a(new Runnable() { // from class: com.navatics.app.framework.divelog.LocalDiveLogRecord.1
            @Override // java.lang.Runnable
            public void run() {
                Box m3474d = Navatics.m7933f().m3474d(Command.class);
                Iterator<Command> it = LocalDiveLogRecord.this.entries.iterator();
                while (it.hasNext()) {
                    m3474d.m3418c((Box) it.next());
                }
                Navatics.m7933f().m3474d(LocalDiveLogRecord.class).m3424b(LocalDiveLogRecord.this.f4396id);
            }
        });
    }

    /* renamed from: c */
    public LocalDiveLogRecordCard m8497c() {
        LocalDiveLogRecordCard localDiveLogRecordCard = new LocalDiveLogRecordCard();
        Iterator<Command> it = this.entries.iterator();
        while (it.hasNext()) {
            localDiveLogRecordCard.m11459a((LocalDiveLogRecordCard) it.next().m8534a());
        }
        localDiveLogRecordCard.m11460a(this.version);
        return localDiveLogRecordCard;
    }

    /* renamed from: a */
    public void m8503a(CommandCard commandCard) {
        Iterator<Command> it = this.entries.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Command next = it.next();
            if (next.m8525d() == commandCard.getDetailIndex()) {
                this.entries.remove(next);
                break;
            }
        }
        m8495e();
    }

    /* renamed from: d */
    public void m8496d() {
        this.entries.clear();
        m8495e();
    }

    /* renamed from: a */
    public void m8501a(List<CommandCard> list) {
        ArrayList arrayList = new ArrayList();
        for (CommandCard commandCard : list) {
            Command command = new Command();
            command.m8532a(commandCard).parent.setTargetId(this.f4396id);
            arrayList.add(command);
        }
        this.entries.addAll(arrayList);
        m8495e();
    }

    /* renamed from: b */
    public void m8499b(CommandCard commandCard) {
        Command command = new Command();
        command.m8532a(commandCard).parent.setTargetId(this.f4396id);
        this.entries.add(command);
        m8495e();
    }

    /* renamed from: a */
    public void m8504a(int i) {
        this.version = i;
        m8495e();
    }

    /* renamed from: e */
    public void m8495e() {
        try {
            Navatics.m7933f().m3474d(LocalDiveLogRecord.class).m3421b((Box) this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public ToMany<Command> m8494f() {
        return this.entries;
    }
}
