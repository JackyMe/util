package com.jackyz.util.util2;

/**
 * author  : Created by JackyZ
 * date    : on 2017/11/23.
 * blog&git: http://blog.csdn.net/u011200604 & https://github.com/JackyMe/github.io
 * <p>
 * desc    :  手电筒/闪光灯， 开启、关闭闪光灯。
 * * Call requires API level 5
 * <uses-permission android:name="android.permission.FLASHLIGHT"/>
 * <uses-permission android:name="android.permission.CAMERA"/>
 */


import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;

public class FlashLightUtil {

    private Camera camera;
    private Handler handler = new Handler();

    /**
     * 超过3分钟自动关闭，防止损伤硬件
     */
    private static final int OFF_TIME = 3 * 60 * 1000;

    public boolean turnOnFlashLight() {
        if (camera == null) {
            camera = Camera.open();
            camera.startPreview();
            Camera.Parameters parameter = camera.getParameters();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
                parameter.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            } else {
                parameter.set("flash-mode", "torch");
            }
            camera.setParameters(parameter);
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    turnOffFlashLight();
                }
            }, OFF_TIME);
        }
        return true;
    }

    public boolean turnOffFlashLight() {
        if (camera != null) {
            handler.removeCallbacksAndMessages(null);
            Camera.Parameters parameter = camera.getParameters();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
                parameter.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            } else {
                parameter.set("flash-mode", "off");
            }
            camera.setParameters(parameter);
            camera.stopPreview();
            camera.release();
            camera = null;
        }
        return true;
    }
}
