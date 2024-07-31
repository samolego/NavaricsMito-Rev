package com.usbsearch;

/* loaded from: classes2.dex */
public class Constants {
    public static final String AUDIO_INTERFACE = "ArtosynAudio";
    public static final String BUS_NUMBER = "BUS_NUMBER";
    public static final String COMMAND_GET_USB_INFO = "for DEVICE in %s*; do echo PATH: $DEVICE; %s done";
    public static final String COMM_INTERFACE = "ArtosynComm";
    public static final String CUSTOMER_INTERFACE = "ArtosynCustomer";
    public static final String INDIVIDUAL_COMMAND = " [ -f $DEVICE/%s ] && echo %s: $(cat $DEVICE/%s);";
    public static final String INTERFACE = "INTERFACE";
    public static final String INTERFACE_CLASS = "INTERFACE_CLASS";
    public static final String INTERFACE_NUMBER = "INTERFACE_NUMBER";
    public static final String MANUFACTURER = "MANUFACTURER";
    public static final String MODALIAS = "MODALIAS";
    public static final String NUM_ENDPOINTS = "NUM_ENDPOINTS";
    public static final String NUM_INTERFACES = "NUM_INTERFACES";
    public static final String PATH = "PATH";
    public static final String PATH_SYS_BUS_USB = "/sys/bus/usb/devices/";
    public static final short PID = -21865;
    public static final String PID_STR = "PID";
    public static final String PRODUCT = "PRODUCT";
    public static final String SPEED = "SPEED";
    public static final String USB_MANUFACTURER = "ArtosynMicroelectronics";
    public static final String USB_PRODUCT = "HID Joystick in HS Mode";
    public static final short VID = -21846;
    public static final String VIDEO0_INTERFACE = "ArtosynVideo0";
    public static final String VID_STR = "VID";

    private Constants() {
    }
}
