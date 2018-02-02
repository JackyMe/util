package com.jackyz.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static final String HEAD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/img";
    public static final String IMAGE_FILE_NAME = "/faceImage.jpg";//用户头像
    private TextView onClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClick = (TextView) findViewById(R.id.onClick);

    }
}
