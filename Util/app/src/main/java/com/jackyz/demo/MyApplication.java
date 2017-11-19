package com.jackyz.demo;

import com.jackyz.util.base.BaseApplication;
import com.jackyz.util.net.RequestManager;
import com.jackyz.util.util.Utils;

/**
 * author  : Created by JackyZ
 * date    : on 2017/11/19.
 * blog&git: http://blog.csdn.net/u011200604 & https://github.com/JackyMe/github.io
 * <p>
 * desc    :
 */

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
        //初始化网络
        RequestManager.init(this);
    }
}
