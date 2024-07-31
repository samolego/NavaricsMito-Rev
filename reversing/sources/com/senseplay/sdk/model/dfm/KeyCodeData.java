package com.senseplay.sdk.model.dfm;

import android.support.media.ExifInterface;
import com.adapt.SPM_Rc;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.senseplay.sdk.tool.UTool;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class KeyCodeData {
    static byte[] bytes = {SPM_Rc.VIBRATION_MODE.PLAY_ONCE, 17, 18, 19, 20, 21, 22, 23, -93, -88, -87, -86, -85, -48, -28, -1};
    static String[] key = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "X", "Y", ExpandedProductParsedResult.POUND, "RB", "LT", "RT", "F_C", "F_U", "F_R", "F_D", "F_L", "T0", "T1", "SWT"};
    private static Map<Integer, String> map = null;
    public static int type_joystick = 2;
    public static int type_key = 0;
    public static int type_touch = 1;
    public static int type_va = 3;

    private static void setMap() {
        map = new HashMap();
        int i = 0;
        while (true) {
            byte[] bArr = bytes;
            if (i >= bArr.length) {
                return;
            }
            map.put(Integer.valueOf(bArr[i]), key[i]);
            i++;
        }
    }

    public static String getKey(int i) {
        if (map == null) {
            setMap();
        }
        return map.get(Integer.valueOf(i));
    }

    public static void getKeyEvent(byte b, int i, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return;
        }
        keyEvent.setValue(i);
        if (i == 0) {
            keyEvent.setPressed(true);
        } else if (i == b + 16) {
            keyEvent.setClick(true);
        } else if (i == b + 32) {
            keyEvent.setDoubleClick(true);
        } else if (i == b + 48) {
            keyEvent.setLongPress(true);
        }
    }

    public static void getTouchEvent(byte[] bArr, TouchEvent touchEvent) {
        if (touchEvent == null || bArr == null || bArr.length < 6) {
            return;
        }
        touchEvent.setX(UTool.byteToShort(new byte[]{bArr[2], bArr[3]}));
        touchEvent.setY(UTool.byteToShort(new byte[]{bArr[4], bArr[5]}));
    }

    public static void getCommonEvent(byte[] bArr, CommonEvent commonEvent) {
        if (commonEvent == null || bArr == null || bArr.length < 6) {
            return;
        }
        commonEvent.setVal1(UTool.byteToInteger(new byte[]{bArr[2], bArr[3]}));
        commonEvent.setVal2(UTool.byteToInteger(new byte[]{bArr[4], bArr[5]}));
    }
}
