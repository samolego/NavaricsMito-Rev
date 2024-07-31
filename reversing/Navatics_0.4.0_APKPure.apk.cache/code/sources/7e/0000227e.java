package com.usbsearch;

import android.support.annotation.NonNull;
import android.util.Log;

/* loaded from: classes2.dex */
public class UsbInterfaceInfo {
    public short Class;
    public short EndpointNum;
    public String Modalias;
    public String Name;
    public short Num;
    public String Path;

    public UsbInterfaceInfo Cpy() {
        UsbInterfaceInfo usbInterfaceInfo = new UsbInterfaceInfo();
        usbInterfaceInfo.Path = this.Path;
        usbInterfaceInfo.Modalias = this.Modalias;
        usbInterfaceInfo.EndpointNum = this.EndpointNum;
        usbInterfaceInfo.Name = this.Name;
        usbInterfaceInfo.Class = this.Class;
        usbInterfaceInfo.Num = this.Num;
        return usbInterfaceInfo;
    }

    public boolean isArtosynUsb() {
        String str = this.Name;
        if (str == null) {
            return false;
        }
        return Constants.COMM_INTERFACE.equals(str) || Constants.VIDEO0_INTERFACE.equals(this.Name) || Constants.AUDIO_INTERFACE.equals(this.Name) || Constants.CUSTOMER_INTERFACE.equals(this.Name);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0035, code lost:
    
        if (r1.equals(com.usbsearch.Constants.PATH) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void SetAttribute(@android.support.annotation.NonNull java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = ":"
            java.lang.String[] r4 = r4.split(r0)
            r0 = 0
            r1 = r4[r0]
            int r2 = r1.hashCode()
            switch(r2) {
                case -1005748967: goto L42;
                case -517519419: goto L38;
                case 2448421: goto L2f;
                case 27761330: goto L25;
                case 159903886: goto L1b;
                case 1184174383: goto L11;
                default: goto L10;
            }
        L10:
            goto L4c
        L11:
            java.lang.String r0 = "INTERFACE_NUMBER"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 5
            goto L4d
        L1b:
            java.lang.String r0 = "MODALIAS"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 1
            goto L4d
        L25:
            java.lang.String r0 = "INTERFACE_CLASS"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 4
            goto L4d
        L2f:
            java.lang.String r2 = "PATH"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L4c
            goto L4d
        L38:
            java.lang.String r0 = "NUM_ENDPOINTS"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 2
            goto L4d
        L42:
            java.lang.String r0 = "INTERFACE"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 3
            goto L4d
        L4c:
            r0 = -1
        L4d:
            switch(r0) {
                case 0: goto L7f;
                case 1: goto L78;
                case 2: goto L6f;
                case 3: goto L63;
                case 4: goto L5a;
                case 5: goto L51;
                default: goto L50;
            }
        L50:
            goto L85
        L51:
            com.usbsearch.STR_TYPE r0 = com.usbsearch.STR_TYPE.IS_DEC
            short r4 = r3.GetShortNum(r4, r0)
            r3.Num = r4
            goto L85
        L5a:
            com.usbsearch.STR_TYPE r0 = com.usbsearch.STR_TYPE.IS_DEC
            short r4 = r3.GetShortNum(r4, r0)
            r3.Class = r4
            goto L85
        L63:
            java.lang.String r4 = r3.GetContent(r4)
            r3.Name = r4
            java.lang.String r4 = r3.Name
            r3.log(r4)
            goto L85
        L6f:
            com.usbsearch.STR_TYPE r0 = com.usbsearch.STR_TYPE.IS_DEC
            short r4 = r3.GetShortNum(r4, r0)
            r3.EndpointNum = r4
            goto L85
        L78:
            java.lang.String r4 = r3.GetContent(r4)
            r3.Modalias = r4
            goto L85
        L7f:
            java.lang.String r4 = r3.GetContent(r4)
            r3.Path = r4
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.usbsearch.UsbInterfaceInfo.SetAttribute(java.lang.String):void");
    }

    private String GetContent(@NonNull String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                sb.append(strArr[i]);
            }
        }
        return sb.toString().trim();
    }

    private short GetShortNum(@NonNull String[] strArr, STR_TYPE str_type) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                sb.append(strArr[i]);
            }
        }
        if (sb.length() <= 0) {
            return (short) -1;
        }
        String trim = sb.toString().trim();
        if (STR_TYPE.IS_HEX == str_type) {
            return UsbTool.hexStr2Short(trim);
        }
        return Integer.valueOf(trim).shortValue();
    }

    private void log(String str) {
        Log.v("SetAttribute", str);
    }
}