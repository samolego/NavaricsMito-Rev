package com.senseplay.sdk.model.keymap;

import java.util.List;

/* loaded from: classes2.dex */
public class KeyMap {
    private String COMMAND;
    private List<KeyMapConditions> CONDITIONS;
    private String EVENT;
    private String KEYMAP_TYPE;
    private KeyMapParamsStyle OP_STYLE;
    private List<KeyMapParams> PARAMS;

    public String getCOMMAND() {
        return this.COMMAND;
    }

    public void setCOMMAND(String str) {
        this.COMMAND = str;
    }

    public String getKEYMAP_TYPE() {
        return this.KEYMAP_TYPE;
    }

    public void setKEYMAP_TYPE(String str) {
        this.KEYMAP_TYPE = str;
    }

    public String getEVENT() {
        return this.EVENT;
    }

    public void setEVENT(String str) {
        this.EVENT = str;
    }

    public KeyMapParamsStyle getOP_STYLE() {
        return this.OP_STYLE;
    }

    public void setOP_STYLE(KeyMapParamsStyle keyMapParamsStyle) {
        this.OP_STYLE = keyMapParamsStyle;
    }

    public List<KeyMapConditions> getCONDITIONS() {
        return this.CONDITIONS;
    }

    public void setCONDITIONS(List<KeyMapConditions> list) {
        this.CONDITIONS = list;
    }

    public List<KeyMapParams> getPARAMS() {
        return this.PARAMS;
    }

    public void setPARAMS(List<KeyMapParams> list) {
        this.PARAMS = list;
    }
}
