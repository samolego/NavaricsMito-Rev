package com.senseplay.sdk.model.keymap;

import java.util.List;

/* loaded from: classes2.dex */
public class KeyMapSet {
    private int key_count;
    private int keymap_length;
    private String keymap_type;
    private List<KeyMapSetVal> valArray;
    private String values;

    public int getKeymap_length() {
        return this.keymap_length;
    }

    public void setKeymap_length(int i) {
        this.keymap_length = i;
    }

    public String getKeymap_type() {
        return this.keymap_type;
    }

    public void setKeymap_type(String str) {
        this.keymap_type = str;
    }

    public int getKey_count() {
        return this.key_count;
    }

    public void setKey_count(int i) {
        this.key_count = i;
    }

    public List<KeyMapSetVal> getValArray() {
        return this.valArray;
    }

    public void setValArray(List<KeyMapSetVal> list) {
        this.valArray = list;
    }

    public String getValues() {
        return this.values;
    }

    public void setValues(String str) {
        this.values = str;
    }

    public String toKeymapSetString() {
        String str = getKeymap_type() + to16Hex(getKey_count()) + getValues();
        this.keymap_length = str.length() / 2;
        return to16Hex(this.keymap_length) + str;
    }

    private String to16Hex(int i) {
        return KeyMapTool.to16Hex(i);
    }

    private String toString(String str) {
        return (str == null || "".equals(str)) ? "" : str;
    }
}