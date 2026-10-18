package com.yftech.avmservice.common;

import com.yftech.avmservice.common.CameraDataDef;

/* loaded from: /home/user/work/dex/classes.dex */
public interface IRadarControl {

    /* loaded from: /home/user/work/dex/classes.dex */
    public interface IRadarListener {
        void onRadarInfo(CameraDataDef.RadarInfo radarInfo);
    }

    CameraDataDef.RadarInfo getRadarInfo();

    boolean isFrontRadarErr();

    boolean isRearRadarErr();

    boolean requestRadarClose();

    boolean requestRadarOpen();

    void setRadarListener(IRadarListener iRadarListener);
}
