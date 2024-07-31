package com.senseplay.sdk.tool;

import com.senseplay.sdk.bean.CallBackMsg;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: classes2.dex */
public class ErrorMsg {
    private static ErrorMsg errorMsg;
    private static String[] message = {"", "CRC 错误", "未知的子命令", "未知的操作码", "未使用uid登录", "设备未激活", "uid已存在，重复登陆", "as id错误", "as id为空", "数据长度错误", "uid错误", "SN为空", "重复登陆", "SN 错误", "此命令的操作码不支持", "Own_id检测错误", "sn检测错误", "assecc检测出错", "未登陆", "未知错误"};

    public static ErrorMsg getInstance() {
        if (errorMsg == null) {
            errorMsg = new ErrorMsg();
        }
        return errorMsg;
    }

    public String getMsgStr(int i) {
        String[] strArr;
        return i == -1 ? "unkown device" : (i < 0 || (strArr = message) == null || strArr.length <= i) ? "Error" : strArr[i];
    }

    public CallBackMsg newMsg(int i, String str) {
        CallBackMsg callBackMsg = new CallBackMsg();
        callBackMsg.setCode(i);
        callBackMsg.setMessage(str);
        return callBackMsg;
    }

    public CallBackMsg getMsg(int i) {
        CallBackMsg callBackMsg = new CallBackMsg();
        callBackMsg.setCode(i);
        callBackMsg.setMessage(getMsgStr(i));
        return callBackMsg;
    }

    public CallBackMsg noHttp() {
        CallBackMsg callBackMsg = new CallBackMsg();
        callBackMsg.setCode(IMediaPlayer.MEDIA_INFO_TIMED_TEXT_ERROR);
        callBackMsg.setMessage("http request error");
        return callBackMsg;
    }

    public CallBackMsg noLink() {
        CallBackMsg callBackMsg = new CallBackMsg();
        callBackMsg.setCode(998);
        callBackMsg.setMessage("no link the device");
        return callBackMsg;
    }

    public CallBackMsg noLoginMsg() {
        CallBackMsg callBackMsg = new CallBackMsg();
        callBackMsg.setCode(999);
        callBackMsg.setMessage("no login");
        return callBackMsg;
    }

    public CallBackMsg httpError() {
        CallBackMsg callBackMsg = new CallBackMsg();
        callBackMsg.setCode(IMediaPlayer.MEDIA_INFO_UNSUPPORTED_SUBTITLE);
        callBackMsg.setMessage("http request error");
        return callBackMsg;
    }
}
