package com.jackyz.util.net;

import android.content.Context;

import com.jackyz.util.constant.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author  : Created by JackyZ
 * date    : on 2017/10/13.
 * blog&git: http://blog.csdn.net/u011200604 & https://github.com/JackyMe/github.io
 * <p>
 * desc    :
 */

public class RequestManager {
    private static Context context;
    private static Retrofit mRetrofit;
    private static NetWorkService mService;

    public static void init(Context mContext){
        context = mContext;
        //带拦截器
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor( new AppInterceptor2())//增加App级别的拦截器，可以在较底层处理请求和返回的数据  new AppInterceptor
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = mRetrofit.create(NetWorkService.class);



    }

    /**
     * 带拦截器
     * @return
     */
    public static NetWorkService getService(){
        return mService;
    }

}
