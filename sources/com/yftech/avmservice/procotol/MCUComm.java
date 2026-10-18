package com.yftech.avmservice.procotol;

import com.yftech.avmservice.common.IMcuCommListener;
import java.nio.ByteBuffer;

/* loaded from: /home/user/work/dex/classes.dex */
public class MCUComm {

    /* loaded from: /home/user/work/dex/classes.dex */
    private static class SingletonFactory {
        private static MCUComm instance = new MCUComm();

        private SingletonFactory() {
        }
    }

    public static MCUComm getInstance() {
        return SingletonFactory.instance;
    }

    private MCUComm() {
        init();
    }

    public int init() {
        return MCUCommNative.getInstance().mcuCommInit();
    }

    public int SendData(ByteBuffer byteBuffer, int i) {
        return MCUCommNative.getInstance().sendDataToMcu(byteBuffer, i, 1);
    }

    public void setAvmListener(IMcuCommListener iMcuCommListener) {
        MCUCommNative.getInstance().registerMcuCommCallback(iMcuCommListener);
    }
}
