package com.example.divelog.dao.entity;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class CommandCard implements Serializable, Comparable<CommandCard> {
    public static final String ADD = "ADD";
    public static final String ADD_ITEM = "ADD_ITME";
    public static final String CREATE = "CREATE";
    public static final String DELETE = "DELETE";
    public static final String DELETE_ITEM = "DELETE_ITEM";
    public static final String NODO = "NODO";
    public static final String RESTRORE_DIVELOG = "RESTRORE_DIVELOG";
    public static final String REUPLOAD_DIVELOG = "REUPLOAD_DIVELOG";
    public static final String REUPLOAD_DIVELOG_ITEM = "REUPLOAD_DIVELOG_ITEM";
    public static final String UPDATE = "UPDATE";
    public static final String UPDATE_ITEM = "UPDATE_ITEM";
    private static final long serialVersionUID = 1;
    private String command;
    private Date createTime;
    private String detailIndex;
    private String filedName;

    /* renamed from: id */
    private Integer f1418id;
    private String json;
    private String startTime;
    private int version;

    public CommandCard() {
        this.createTime = new Date();
    }

    private CommandCard(Date date) {
        this.createTime = date;
    }

    public String getFiledName() {
        return this.filedName;
    }

    public CommandCard setFiledName(String str) {
        this.filedName = str;
        return this;
    }

    public static CommandCard builder() {
        return new CommandCard();
    }

    public static CommandCard builder(Date date) {
        return new CommandCard(date);
    }

    public String getCommand() {
        return this.command;
    }

    public CommandCard setCommand(String str) {
        this.command = str;
        return this;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public CommandCard setStartTime(String str) {
        this.startTime = str;
        return this;
    }

    public int getVersion() {
        return this.version;
    }

    public CommandCard setVersion(int i) {
        this.version = i;
        return this;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public CommandCard setCreateTime(Date date) {
        this.createTime = date;
        return this;
    }

    public String getDetailIndex() {
        return this.detailIndex;
    }

    public CommandCard setDetailIndex(String str) {
        this.detailIndex = str;
        return this;
    }

    public String getJson() {
        return this.json;
    }

    public CommandCard setJson(String str) {
        this.json = str;
        return this;
    }

    public CommandCard setJson(Object obj) {
        try {
            this.json = new Gson().toJson(obj);
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(CommandCard commandCard) {
        return getCreateTime().getTime() > commandCard.getCreateTime().getTime() ? 1 : -1;
    }
}