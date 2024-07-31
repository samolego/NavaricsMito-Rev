package com.senseplay.sdk.model.slam;

import android.content.Context;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class SlamTool {
    public static String getSlam(Context context, String str) {
        InputStreamReader inputStreamReader;
        String str2 = "";
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    inputStreamReader = new InputStreamReader(context.getResources().getAssets().open(str));
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null) {
                                    str2 = str2 + readLine + "\n";
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                return str2;
                            } catch (IOException e4) {
                                e = e4;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                return str2;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (inputStreamReader == null) {
                                    throw th;
                                }
                                try {
                                    inputStreamReader.close();
                                    throw th;
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    throw th;
                                }
                            }
                        }
                        bufferedReader2.close();
                        try {
                            inputStreamReader.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                        return str2;
                    } catch (FileNotFoundException e9) {
                        e = e9;
                    } catch (IOException e10) {
                        e = e10;
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                    inputStreamReader = null;
                } catch (IOException e12) {
                    e = e12;
                    inputStreamReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e13) {
            e13.printStackTrace();
        }
    }

    public static SlamInfo getSlamList(Context context, String str) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        SlamInfo slamInfo = new SlamInfo();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    inputStreamReader = new InputStreamReader(context.getResources().getAssets().open(str));
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        boolean z = false;
                        boolean z2 = false;
                        boolean z3 = false;
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    try {
                                        break;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                } else if (readLine.contains("MATRIX")) {
                                    z = true;
                                } else {
                                    if (z && "".equals(readLine)) {
                                        System.out.println(slamInfo.getMatrix().size());
                                        z = false;
                                    }
                                    if (z) {
                                        slamInfo.getMatrix().add(toFloat(readLine.split(" ")));
                                    }
                                    if (readLine.contains("POINTS")) {
                                        z2 = true;
                                    } else {
                                        if (z2 && "".equals(readLine)) {
                                            System.out.println(slamInfo.getPoints().size());
                                            z2 = false;
                                        }
                                        if (z2) {
                                            slamInfo.getPoints().add(toFloat(readLine.split(" ")));
                                        }
                                        if (readLine.contains("POLYGONS")) {
                                            z3 = true;
                                        } else {
                                            if (z3 && "".equals(readLine)) {
                                                System.out.println(slamInfo.getPolygons().size());
                                                z3 = false;
                                            }
                                            if (z3) {
                                                slamInfo.getPolygons().add(toInt(readLine.split(" ")));
                                            }
                                        }
                                    }
                                }
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                bufferedReader2 = bufferedReader;
                                e.printStackTrace();
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                return slamInfo;
                            } catch (IOException e4) {
                                e = e4;
                                bufferedReader2 = bufferedReader;
                                e.printStackTrace();
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                return slamInfo;
                            } catch (Throwable th) {
                                th = th;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (inputStreamReader == null) {
                                    throw th;
                                }
                                try {
                                    inputStreamReader.close();
                                    throw th;
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    throw th;
                                }
                            }
                        }
                        bufferedReader.close();
                        try {
                            inputStreamReader.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                        return slamInfo;
                    } catch (FileNotFoundException e9) {
                        e = e9;
                    } catch (IOException e10) {
                        e = e10;
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                    inputStreamReader = null;
                } catch (IOException e12) {
                    e = e12;
                    inputStreamReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                    inputStreamReader = null;
                }
            } catch (IOException e13) {
                e13.printStackTrace();
                return slamInfo;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    private static float[] toFloat(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        float[] fArr = new float[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            fArr[i] = Float.parseFloat(strArr[i]);
        }
        return fArr;
    }

    private static int[] toInt(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = Integer.parseInt(strArr[i]);
        }
        return iArr;
    }

    public static void main(String[] strArr) {
        getSlamList(null, "");
    }
}