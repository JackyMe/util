package com.jackyz.util.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 工程名：easyto
 * 说明：自定义圆形进度条
 */
public class CircleBar extends View {
    private int progress = 0; //当前进度
    private int max = 100; //最大进度
    private int roundColor = Color.GRAY; //圆环的颜色
    private int roundProgressColor = Color.GREEN; //圆环进度的颜色
    private float roundWidth = 10; //圆环的宽度
    private float textSize = 20; //文字的大小
    private int textColor = Color.RED; //文字的颜色

    private int viewWidth;
    private Paint paint;


    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        //强制重绘
        postInvalidate();
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getRoundColor() {
        return roundColor;
    }

    public void setRoundColor(int roundColor) {
        this.roundColor = roundColor;
    }

    public int getRoundProgressColor() {
        return roundProgressColor;
    }

    public void setRoundProgressColor(int roundProgressColor) {
        this.roundProgressColor = roundProgressColor;
    }

    public float getRoundWidth() {
        return roundWidth;
    }

    public void setRoundWidth(float roundWidth) {
        this.roundWidth = roundWidth;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
    public CircleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();//创建画笔
        paint.setAntiAlias(true);//看据齿轮
    }
    //获取视图的宽度
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        viewWidth=getMeasuredWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float cx = viewWidth / 2;
        paint.setColor(roundColor);//圆环的颜色
        paint.setStrokeWidth(roundWidth);//圆环的宽度
        paint.setStyle(Paint.Style.STROKE);//镂空
        canvas.drawCircle(cx,cx,cx-roundWidth/2,paint);//画圆

        //绘制进度圆弧
        RectF oval = new RectF(roundWidth / 2, roundWidth / 2,
                viewWidth - roundWidth / 2, viewWidth - roundWidth / 2);
        paint.setColor(roundProgressColor);
        canvas.drawArc(oval, 0, progress * 360 / max, false, paint);
    }
}
