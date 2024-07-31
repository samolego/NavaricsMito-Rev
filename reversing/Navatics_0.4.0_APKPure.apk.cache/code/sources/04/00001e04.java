package com.senseplay.sdk.model.keymap;

/* loaded from: classes2.dex */
public class KeyMapFormat {
    private int analog_count;
    private String analog_params;
    private String command;
    private String command_ver;
    private int condition_count;
    private String event;
    private String keymap_type;
    private String optional_conditions;
    private int transparent_count;
    private String transparent_params;

    public String getKeymap_type() {
        return this.keymap_type;
    }

    public void setKeymap_type(String str) {
        this.keymap_type = str;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String str) {
        this.event = str;
    }

    public int getCondition_count() {
        return this.condition_count;
    }

    public void setCondition_count(int i) {
        this.condition_count = i;
    }

    public String getOptional_conditions() {
        return this.optional_conditions;
    }

    public void setOptional_conditions(String str) {
        this.optional_conditions = str;
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public String getCommand_ver() {
        return this.command_ver;
    }

    public void setCommand_ver(String str) {
        this.command_ver = str;
    }

    public int getAnalog_count() {
        return this.analog_count;
    }

    public void setAnalog_count(int i) {
        this.analog_count = i;
    }

    public String getAnalog_params() {
        return this.analog_params;
    }

    public void setAnalog_params(String str) {
        this.analog_params = str;
    }

    public int getTransparent_count() {
        return this.transparent_count;
    }

    public void setTransparent_count(int i) {
        this.transparent_count = i;
    }

    public String getTransparent_params() {
        return this.transparent_params;
    }

    public void setTransparent_params(String str) {
        this.transparent_params = str;
    }

    public String toKeyMapString() {
        String str = getKeymap_type() + toDefString(getEvent()) + to16Hex(getCondition_count()) + toString(getOptional_conditions()) + getCommand() + getCommand_ver() + toString(getParams());
        return to16Hex(str.length() / 2) + str;
    }

    private String to16Hex(int i) {
        return KeyMapTool.to16Hex(i);
    }

    private String toString(String str) {
        return (str == null || "".equals(str)) ? "" : str;
    }

    private String toDefString(String str) {
        return (str == null || "".equals(str)) ? "00" : str;
    }

    private String getParams() {
        String str;
        if (getAnalog_count() == 0) {
            str = "00";
        } else {
            str = to16Hex(getAnalog_count()) + toString(getAnalog_params());
        }
        if (getTransparent_count() == 0) {
            return str + "00";
        }
        return str + to16Hex(getTransparent_count()) + toString(getTransparent_params());
    }
}