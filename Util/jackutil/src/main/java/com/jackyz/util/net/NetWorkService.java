package com.jackyz.util.net;

import com.jackyz.util.bean.UpLoadBean;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * author  : Created by JackyZ
 * date    : on 2017/10/13.
 * blog&git: http://blog.csdn.net/u011200604 & https://github.com/JackyMe/github.io
 * <p>
 * desc    :
 */

public interface NetWorkService {

    @Multipart
    @POST("http://news.easyto.test/api/ppx/user/upload/fileUpload")
    Call<UpLoadBean> uploadFile(
            @Part("description") RequestBody description,
            @Part MultipartBody.Part file);

}
