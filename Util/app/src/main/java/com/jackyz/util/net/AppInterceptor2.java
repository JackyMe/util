package com.jackyz.util.net;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by luoyu on 2017/5/10.
 * https://segmentfault.com/q/1010000004561994
 * http://blog.csdn.net/u013290250/article/details/54090981 参考文章
 */

public class AppInterceptor2 implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Map<String, String> paramsMap = new HashMap();
        /**添加拦截器*/
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder();
        requestBuilder.addHeader("os_type", "Android");
        Request mRequest = null;

        if ("POST".equals(original.method())) {  //若是post请求

        } else {   //若是get请求

        }
        Response response = chain.proceed(mRequest);

        return response;
    }

}
