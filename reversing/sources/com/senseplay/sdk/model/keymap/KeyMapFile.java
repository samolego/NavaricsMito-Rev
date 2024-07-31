package com.senseplay.sdk.model.keymap;

/* loaded from: classes2.dex */
public class KeyMapFile {
    private KeyMapFileAttr file_command;
    private KeyMapFileAttr file_keycode;
    private KeyMapFileType file_keymap;
    private KeyMapFileType file_keymap_beta;
    private KeyMapFileAttr file_rc;

    public KeyMapFileAttr getFile_rc() {
        return this.file_rc;
    }

    public void setFile_rc(KeyMapFileAttr keyMapFileAttr) {
        this.file_rc = keyMapFileAttr;
    }

    public KeyMapFileAttr getFile_keycode() {
        return this.file_keycode;
    }

    public void setFile_keycode(KeyMapFileAttr keyMapFileAttr) {
        this.file_keycode = keyMapFileAttr;
    }

    public KeyMapFileAttr getFile_command() {
        return this.file_command;
    }

    public void setFile_command(KeyMapFileAttr keyMapFileAttr) {
        this.file_command = keyMapFileAttr;
    }

    public KeyMapFileType getFile_keymap() {
        return this.file_keymap;
    }

    public void setFile_keymap(KeyMapFileType keyMapFileType) {
        this.file_keymap = keyMapFileType;
    }

    public KeyMapFileType getFile_keymap_beta() {
        return this.file_keymap_beta;
    }

    public void setFile_keymap_beta(KeyMapFileType keyMapFileType) {
        this.file_keymap_beta = keyMapFileType;
    }
}
