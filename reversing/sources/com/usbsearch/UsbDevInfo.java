package com.usbsearch;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class UsbDevInfo {
    private UsbAttribute UsbAttributeTemp;
    private UsbInterfaceInfo UsbInterfaceInfoTemp;
    public UsbAttribute mUsbAttribute = new UsbAttribute();
    public List<UsbInterfaceInfo> mUsbInterfaceInfo = new ArrayList();
    private boolean isUsbAttribute = false;

    public boolean findArtosynUsb() {
        UsbAttribute usbAttribute = this.mUsbAttribute;
        if (usbAttribute != null && usbAttribute.isArtosynUsb()) {
            int i = 0;
            for (UsbInterfaceInfo usbInterfaceInfo : this.mUsbInterfaceInfo) {
                if (usbInterfaceInfo.isArtosynUsb()) {
                    i++;
                }
            }
            return 4 == i;
        }
        return false;
    }

    public void addLine(String str) {
        UsbAttribute usbAttribute;
        String[] split = str.split(":");
        if (split.length < 2) {
            return;
        }
        if (Constants.PATH.equals(split[0])) {
            UsbAttribute usbAttribute2 = this.UsbAttributeTemp;
            if (usbAttribute2 != null && usbAttribute2.isArtosynUsb()) {
                this.mUsbAttribute = this.UsbAttributeTemp.Cpy();
            }
            UsbInterfaceInfo usbInterfaceInfo = this.UsbInterfaceInfoTemp;
            if (usbInterfaceInfo != null && usbInterfaceInfo.isArtosynUsb()) {
                this.mUsbInterfaceInfo.add(this.UsbInterfaceInfoTemp.Cpy());
            }
            this.UsbAttributeTemp = null;
            this.UsbInterfaceInfoTemp = null;
            if (2 == split.length) {
                this.isUsbAttribute = true;
                this.UsbAttributeTemp = new UsbAttribute();
            } else {
                this.isUsbAttribute = false;
                this.UsbInterfaceInfoTemp = new UsbInterfaceInfo();
            }
        }
        if (this.isUsbAttribute && (usbAttribute = this.UsbAttributeTemp) != null) {
            usbAttribute.SetAttribute(str);
            return;
        }
        UsbInterfaceInfo usbInterfaceInfo2 = this.UsbInterfaceInfoTemp;
        if (usbInterfaceInfo2 != null) {
            usbInterfaceInfo2.SetAttribute(str);
        }
    }
}
