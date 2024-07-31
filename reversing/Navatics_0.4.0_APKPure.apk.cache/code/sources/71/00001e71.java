package com.senseplay.sdk.tool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class UTool {
    public static void floatToByte(float f) {
    }

    public static byte[] shortToByte(short s) {
        byte[] bArr = new byte[2];
        int i = 0;
        int i2 = s;
        while (i < bArr.length) {
            bArr[i] = new Integer(i2 & 255).byteValue();
            i++;
            i2 >>= 8;
        }
        return bArr;
    }

    public static short byteToShort(byte[] bArr) {
        return (short) (((short) (((short) (bArr[1] & 255)) << 8)) | ((short) (bArr[0] & 255)));
    }

    public static int byteToInteger(byte[] bArr) {
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    public static byte[] intToByte(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = new Integer(i & 255).byteValue();
            i >>= 8;
        }
        return bArr;
    }

    public static int byteToInt(byte[] bArr) {
        int i = bArr[0] & 255;
        int i2 = bArr[1] & 255;
        return ((bArr[3] & 255) << 24) | i | (i2 << 8) | ((bArr[2] & 255) << 16);
    }

    public static byte[] longToByte(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = new Long(255 & j).byteValue();
        }
        return bArr;
    }

    public static long byteToLong(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 24) | ((bArr[4] & 255) << 32) | ((bArr[5] & 255) << 40) | ((bArr[6] & 255) << 48) | ((bArr[7] & 255) << 56);
    }

    public static byte[] doubleToByte(double d) {
        byte[] bArr = new byte[8];
        long doubleToLongBits = Double.doubleToLongBits(d);
        for (int i = 0; i < 8; i++) {
            bArr[i] = new Long(doubleToLongBits).byteValue();
            doubleToLongBits >>= 8;
        }
        return bArr;
    }

    public static double getDouble(byte[] bArr) {
        return Double.longBitsToDouble((((((((((((((bArr[0] & 255) | (bArr[1] << 8)) & 65535) | (bArr[2] << 16)) & 16777215) | (bArr[3] << 24)) & 4294967295L) | (bArr[4] << 32)) & 1099511627775L) | (bArr[5] << 40)) & 281474976710655L) | (bArr[6] << 48)) & 72057594037927935L) | (bArr[7] << 56));
    }

    public static float getFloat(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i |= (bArr[i2] & 255) << (i2 * 8);
        }
        return Float.intBitsToFloat(i);
    }

    public static byte[] charToByte(char c) {
        return new byte[]{(byte) ((65280 & c) >> 8), (byte) (c & 255)};
    }

    public static char byteToChar(byte[] bArr) {
        return (char) ((bArr[1] & 255) | ((bArr[0] & 255) << 8));
    }

    public static byte[] stringToByte(String str) {
        try {
            return str.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String bytesToString(byte[] bArr) {
        try {
            return new String(bArr, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void testObject2ByteArray() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(new Integer[]{1, 3, 4});
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        objectOutputStream.close();
        System.out.println(Arrays.toString(byteArray));
        System.out.println(Arrays.asList((Integer[]) testByteArray2Object(byteArray)));
        byte[] intToByte = intToByte(123);
        System.out.println(Arrays.toString(intToByte));
        System.out.println(byteToInt(intToByte));
    }

    private Object testByteArray2Object(byte[] bArr) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object readObject = objectInputStream.readObject();
        byteArrayInputStream.close();
        objectInputStream.close();
        System.out.println(readObject);
        return readObject;
    }

    public static void main(String[] strArr) {
        intToByte(10);
        stringToByte("1234567890");
        System.out.println((int) new byte[]{-48, -28}[0]);
    }
}