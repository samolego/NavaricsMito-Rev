package com.senseplay.sdk.model.keymap;

/* loaded from: classes2.dex */
public class KeyMapConditions {
    private String CONDITION_JUDGE_TYPE;
    private String CONDITION_TYPE;
    private String CONDITION_VALUE;
    private String KEYCODE;
    private KeyMapParamsStyle OP_STYLE;

    public String getCONDITION_JUDGE_TYPE() {
        return this.CONDITION_JUDGE_TYPE;
    }

    public void setCONDITION_JUDGE_TYPE(String str) {
        this.CONDITION_JUDGE_TYPE = str;
    }

    public String getCONDITION_TYPE() {
        return this.CONDITION_TYPE;
    }

    public void setCONDITION_TYPE(String str) {
        this.CONDITION_TYPE = str;
    }

    public String getCONDITION_VALUE() {
        return this.CONDITION_VALUE;
    }

    public void setCONDITION_VALUE(String str) {
        this.CONDITION_VALUE = str;
    }

    public String getKEYCODE() {
        return this.KEYCODE;
    }

    public void setKEYCODE(String str) {
        this.KEYCODE = str;
    }

    public KeyMapParamsStyle getOP_STYLE() {
        return this.OP_STYLE;
    }

    public void setOP_STYLE(KeyMapParamsStyle keyMapParamsStyle) {
        this.OP_STYLE = keyMapParamsStyle;
    }
}