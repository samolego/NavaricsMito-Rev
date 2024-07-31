package com.senseplay.sdk.model.dfm;

/* loaded from: classes2.dex */
public class KeyEvent {
    private boolean click;
    private boolean doubleClick;
    private String key;
    private boolean longPress;
    private boolean pressed;
    private int value;

    public int getValue() {
        return this.value;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public boolean isPressed() {
        return this.pressed;
    }

    public void setPressed(boolean z) {
        this.pressed = z;
    }

    public boolean isClick() {
        return this.click;
    }

    public void setClick(boolean z) {
        this.click = z;
    }

    public boolean isDoubleClick() {
        return this.doubleClick;
    }

    public void setDoubleClick(boolean z) {
        this.doubleClick = z;
    }

    public boolean isLongPress() {
        return this.longPress;
    }

    public void setLongPress(boolean z) {
        this.longPress = z;
    }
}