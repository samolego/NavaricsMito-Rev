package com.usbsearch;

import java.util.Locale;

/* loaded from: classes2.dex */
public class FindUsbDev {
    public static boolean exec() {
        UsbProperty[] values;
        StringBuilder sb = new StringBuilder();
        ExecTerminal execTerminal = new ExecTerminal();
        for (UsbProperty usbProperty : UsbProperty.values()) {
            sb.append(String.format(Locale.US, Constants.INDIVIDUAL_COMMAND, usbProperty.getFileName(), usbProperty.name(), usbProperty.getFileName()));
        }
        execTerminal.exec(String.format(Locale.US, Constants.COMMAND_GET_USB_INFO, Constants.PATH_SYS_BUS_USB, sb.toString()));
        return execTerminal.findUsb();
    }
}
