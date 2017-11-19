package com.jackyz.util.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by JackyZ on 2017/6/26.
 */

public class RoundedImageViewLeft extends AppCompatImageView {

    /*圆角的半径，依次为左上角xy半径，右上角，右下角，左下角*/
    private float[] rids = {20.0f,20.0f,0.0f,0.0f,0.0f,0.0f,20.0f,20.0f};

    public RoundedImageViewLeft(Context context) {
        super(context);
    }

    public RoundedImageViewLeft(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundedImageViewLeft(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 画图
     * @param canvas
     */
    protected void onDraw(Canvas canvas) {
        Path path = new Path();
        int w = this.getWidth();
        int h = this.getHeight();
        /*向路径中添加圆角矩形。radii数组定义圆角矩形的四个圆角的x,y半径。radii长度必须为8*/
        path.addRoundRect(new RectF(0,0,w,h),rids, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
