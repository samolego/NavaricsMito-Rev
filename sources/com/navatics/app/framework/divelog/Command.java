package com.navatics.app.framework.divelog;

import com.example.divelog.dao.entity.CommandCard;
import io.objectbox.BoxStore;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.InterfaceC2825Id;
import io.objectbox.relation.ToOne;
import java.util.Date;

@Entity
/* loaded from: classes.dex */
public class Command {
    private static final long serialVersionUID = 1;
    transient BoxStore __boxStore;
    private String command;
    private Date createTime;
    private String detailIndex;
    private String filedName;
    @InterfaceC2825Id

    /* renamed from: id */
    long f4321id;
    private String json;
    public ToOne<LocalDiveLogRecord> parent = new ToOne<>(this, Command_.parent);
    private String startTime;
    private int version;

    /* renamed from: a */
    public Command m8532a(CommandCard commandCard) {
        m8531a(commandCard.getCommand());
        m8530a(commandCard.getCreateTime());
        m8526c(commandCard.getDetailIndex());
        m8522e(commandCard.getFiledName());
        m8524d(commandCard.getJson());
        m8528b(commandCard.getStartTime());
        m8533a(commandCard.getVersion());
        return this;
    }

    /* renamed from: a */
    public CommandCard m8534a() {
        CommandCard commandCard = new CommandCard();
        commandCard.setCommand(this.command);
        commandCard.setCreateTime(this.createTime);
        commandCard.setFiledName(this.filedName);
        commandCard.setDetailIndex(this.detailIndex);
        commandCard.setJson(this.json);
        commandCard.setStartTime(this.startTime);
        commandCard.setVersion(this.version);
        return commandCard;
    }

    /* renamed from: b */
    public String m8529b() {
        return this.command;
    }

    /* renamed from: a */
    public void m8531a(String str) {
        this.command = str;
    }

    /* renamed from: c */
    public String m8527c() {
        return this.startTime;
    }

    /* renamed from: b */
    public void m8528b(String str) {
        this.startTime = str;
    }

    /* renamed from: d */
    public String m8525d() {
        return this.detailIndex;
    }

    /* renamed from: c */
    public void m8526c(String str) {
        this.detailIndex = str;
    }

    /* renamed from: e */
    public int m8523e() {
        return this.version;
    }

    /* renamed from: a */
    public void m8533a(int i) {
        this.version = i;
    }

    /* renamed from: f */
    public Date m8521f() {
        return this.createTime;
    }

    /* renamed from: a */
    public void m8530a(Date date) {
        this.createTime = date;
    }

    /* renamed from: g */
    public String m8520g() {
        return this.json;
    }

    /* renamed from: d */
    public void m8524d(String str) {
        this.json = str;
    }

    /* renamed from: h */
    public String m8519h() {
        return this.filedName;
    }

    /* renamed from: e */
    public void m8522e(String str) {
        this.filedName = str;
    }
}
