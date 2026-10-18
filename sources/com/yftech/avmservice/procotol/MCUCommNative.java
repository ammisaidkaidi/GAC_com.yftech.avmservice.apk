package com.yftech.avmservice.procotol;

import com.yftech.avmservice.common.IMcuCommListener;
import com.yftech.avmservice.util.LogUtil;
import java.nio.ByteBuffer;

/* loaded from: /home/user/work/dex/classes.dex */
public class MCUCommNative {
    private static boolean isLoaded = false;

    private native int nativeMcuCommInit();

    private native int nativeRegisterMcuCommCallback(IMcuCommListener iMcuCommListener);

    private native int nativeSendDataToMcu(ByteBuffer byteBuffer, int i, int i2);

    static {
        if (isLoaded) {
            return;
        }
        LogUtil.e("MCUCommNative", "loadLibrary  AvmMcuComm in", new Object[0]);
        try {
            System.loadLibrary("AvmMcuComm");
        } catch (Exception e) {
            LogUtil.e("MCUCommNative", "loadLibrary ", e);
        }
        LogUtil.e("MCUCommNative", "loadLibrary  AvmMcuComm out", new Object[0]);
        isLoaded = true;
    }

    /* loaded from: /home/user/work/dex/classes.dex */
    private static class SingletonFactory {
        private static MCUCommNative instance = new MCUCommNative();

        private SingletonFactory() {
        }
    }

    public static MCUCommNative getInstance() {
        return SingletonFactory.instance;
    }

    public int mcuCommInit() {
        return nativeMcuCommInit();
    }

    public int sendDataToMcu(ByteBuffer byteBuffer, int i, int i2) {
        return nativeSendDataToMcu(byteBuffer, i, i2);
    }

    public int registerMcuCommCallback(IMcuCommListener iMcuCommListener) {
        return nativeRegisterMcuCommCallback(iMcuCommListener);
    }
}
