package com.common;

/* loaded from: classes.dex */
public class LOGIN_ACK_REL {
    public static final String DEV_TAG = "DEV_LOG_ACK";
    public static final byte LOGIN_ACK_REL_AS_ID_EMPTY = 8;
    public static final byte LOGIN_ACK_REL_AS_ID_ERR = 7;
    public static final byte LOGIN_ACK_REL_CRC_ERR = 1;
    public static final byte LOGIN_ACK_REL_DATA_LEN_ERR = 9;
    public static final byte LOGIN_ACK_REL_OK = 0;
    public static final byte LOGIN_ACK_REL_REPEAT_LOGIN = 12;
    public static final byte LOGIN_ACK_REL_SN_EMPTY = 11;
    public static final byte LOGIN_ACK_REL_SN_ERR = 13;
    public static final byte LOGIN_ACK_REL_UID_EMPTY = 5;
    public static final byte LOGIN_ACK_REL_UID_ERR = 10;
    public static final byte LOGIN_ACK_REL_UID_EXIST = 6;
    public static final byte LOGIN_ACK_REL_UNKNOW_OPER_CODE = 3;
    public static final byte LOGIN_ACK_REL_UNKNOW_SUB_CMD = 2;
    public static final byte LOGIN_ACK_REL_UNUSE_UID_LOGIN = 4;

    public static final String PrintDevAckErrInfo(String str, byte b) {
        switch (b) {
            case 0:
                return str + " Ack OK : " + ((int) b);
            case 1:
                return str + " CRC 错误: " + ((int) b);
            case 2:
                return str + " 未知的子命令: " + ((int) b);
            case 3:
                return str + " 未知的操作码: " + ((int) b);
            case 4:
                return str + " 未使用uid登录: " + ((int) b);
            case 5:
                return str + " uid为空: " + ((int) b);
            case 6:
                return str + " uid已存在，写入失败: " + ((int) b);
            case 7:
                return str + " as id 错误: " + ((int) b);
            case 8:
                return str + " as id 为空: " + ((int) b);
            case 9:
                return str + " 数据长度错误: " + ((int) b);
            case 10:
                return str + " uid 错误: " + ((int) b);
            case 11:
                return str + " SN为空: " + ((int) b);
            case 12:
                return str + " 重复登录:  " + ((int) b);
            case 13:
                return str + " SN 错误: " + ((int) b);
            default:
                return str + " Dev Ack Unknow err code: " + ((int) b);
        }
    }
}