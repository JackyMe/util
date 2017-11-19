package com.jackyz.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import com.jackyz.util.bean.UpLoadBean;
import com.jackyz.util.net.RequestManager;
import com.jackyz.util.util.LogUtils;
import com.jackyz.util.util.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {
    public static final String HEAD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/img";
    public static final String IMAGE_FILE_NAME = "/faceImage.jpg";//用户头像
    private TextView onClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClick = (TextView) findViewById(R.id.onClick);
        onClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                upRecommendFile();
                upload();
            }
        });
    }


    public void upRecommendFile() {
        ToastUtils.showShort("上传..");
        File myFile = new File(Environment.getExternalStorageDirectory(), "/img/faceImage.jpg");
        if (!myFile.exists()) {
            myFile.mkdirs();
            try {
                myFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        OkHttpUtils.post().url("http://news.easyto.test/api/ppx/user/upload/fileUpload").addParams("user_id", "e684cbceb34378fd64e67a2686189497").addParams("token", "91B655057D1D3BA91B554BD0CA92B37D").addParams("device_id", "865982025363394").addFile("myfiles", "/faceImage.jpg", myFile).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                LogUtils.a("onError:" + e.getMessage());

            }

            @Override
            public void onResponse(String response, int id) {
                LogUtils.a("onResponse : " + response);
            }
        });
    }

    private void upload() {
        // use the FileUtils to get the actual file by uri
        File file = new File(Environment.getExternalStorageDirectory(), "/img/faceImage.jpg");
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("myfiles", file.getName(), requestFile);
        // add another part within the multipart request
        String descriptionString = "hello, this is description speaking";
        RequestBody description = RequestBody.create(MediaType.parse("multipart/form-data"), descriptionString);

        RequestManager.getService().uploadFile(description, body).enqueue(new Callback<UpLoadBean>() {
            @Override
            public void onResponse(retrofit2.Call<UpLoadBean> call, Response<UpLoadBean> response) {
                ToastUtils.showShort(response.body().getRes_msg());

            }

            @Override
            public void onFailure(retrofit2.Call<UpLoadBean> call, Throwable t) {

            }
        });
    }
}
