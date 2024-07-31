package com.usbsearch;

/* loaded from: classes2.dex */
public class UsbAttribute {
    public short BusNum;
    public short InterfaceNum;
    public String Manufacturer;
    public String Modalias;
    public short PID;
    public String Path;
    public String Product;
    public short Speed;
    public short VID;

    public UsbAttribute Cpy() {
        UsbAttribute usbAttribute = new UsbAttribute();
        usbAttribute.Path = this.Path;
        usbAttribute.Modalias = this.Modalias;
        usbAttribute.PID = this.PID;
        usbAttribute.VID = this.VID;
        usbAttribute.Manufacturer = this.Manufacturer;
        usbAttribute.Product = this.Product;
        usbAttribute.Speed = this.Speed;
        usbAttribute.BusNum = this.BusNum;
        usbAttribute.InterfaceNum = this.InterfaceNum;
        return usbAttribute;
    }

    public boolean isArtosynUsb() {
        return -21865 == this.PID && -21846 == this.VID;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0054, code lost:
    
        if (r1.equals(com.usbsearch.Constants.PATH) != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void SetAttribute(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = ":"
            java.lang.String[] r4 = r4.split(r0)
            r0 = 0
            r1 = r4[r0]
            int r2 = r1.hashCode()
            switch(r2) {
                case 79211: goto L61;
                case 84977: goto L57;
                case 2448421: goto L4e;
                case 79104039: goto L44;
                case 159903886: goto L3a;
                case 252009992: goto L30;
                case 347933649: goto L26;
                case 408508623: goto L1c;
                case 1375981779: goto L11;
                default: goto L10;
            }
        L10:
            goto L6b
        L11:
            java.lang.String r0 = "NUM_INTERFACES"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6b
            r0 = 8
            goto L6c
        L1c:
            java.lang.String r0 = "PRODUCT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6b
            r0 = 5
            goto L6c
        L26:
            java.lang.String r0 = "MANUFACTURER"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6b
            r0 = 4
            goto L6c
        L30:
            java.lang.String r0 = "BUS_NUMBER"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6b
            r0 = 7
            goto L6c
        L3a:
            java.lang.String r0 = "MODALIAS"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6b
            r0 = 1
            goto L6c
        L44:
            java.lang.String r0 = "SPEED"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6b
            r0 = 6
            goto L6c
        L4e:
            java.lang.String r2 = "PATH"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L6b
            goto L6c
        L57:
            java.lang.String r0 = "VID"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6b
            r0 = 3
            goto L6c
        L61:
            java.lang.String r0 = "PID"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6b
            r0 = 2
            goto L6c
        L6b:
            r0 = -1
        L6c:
            switch(r0) {
                case 0: goto Lb2;
                case 1: goto Lab;
                case 2: goto La2;
                case 3: goto L99;
                case 4: goto L92;
                case 5: goto L8b;
                case 6: goto L82;
                case 7: goto L79;
                case 8: goto L70;
                default: goto L6f;
            }
        L6f:
            goto Lb8
        L70:
            com.usbsearch.STR_TYPE r0 = com.usbsearch.STR_TYPE.IS_DEC
            short r4 = r3.GetShortNum(r4, r0)
            r3.InterfaceNum = r4
            goto Lb8
        L79:
            com.usbsearch.STR_TYPE r0 = com.usbsearch.STR_TYPE.IS_DEC
            short r4 = r3.GetShortNum(r4, r0)
            r3.BusNum = r4
            goto Lb8
        L82:
            com.usbsearch.STR_TYPE r0 = com.usbsearch.STR_TYPE.IS_DEC
            short r4 = r3.GetShortNum(r4, r0)
            r3.Speed = r4
            goto Lb8
        L8b:
            java.lang.String r4 = r3.GetContent(r4)
            r3.Product = r4
            goto Lb8
        L92:
            java.lang.String r4 = r3.GetContent(r4)
            r3.Manufacturer = r4
            goto Lb8
        L99:
            com.usbsearch.STR_TYPE r0 = com.usbsearch.STR_TYPE.IS_HEX
            short r4 = r3.GetShortNum(r4, r0)
            r3.VID = r4
            goto Lb8
        La2:
            com.usbsearch.STR_TYPE r0 = com.usbsearch.STR_TYPE.IS_HEX
            short r4 = r3.GetShortNum(r4, r0)
            r3.PID = r4
            goto Lb8
        Lab:
            java.lang.String r4 = r3.GetContent(r4)
            r3.Modalias = r4
            goto Lb8
        Lb2:
            java.lang.String r4 = r3.GetContent(r4)
            r3.Path = r4
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.usbsearch.UsbAttribute.SetAttribute(java.lang.String):void");
    }

    private String GetContent(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                sb.append(strArr[i]);
            }
        }
        return sb.toString().trim();
    }

    private short GetShortNum(String[] strArr, STR_TYPE str_type) {
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
}