package com.jackyz.util.utilmy;

import android.graphics.drawable.AnimationDrawable;
import android.widget.PopupWindow;


/**
 * author  : Created by JackyZ
 * date    : on 2017/10/11.
 * blog&git: http://blog.csdn.net/u011200604 & https://github.com/JackyMe/github.io
 * desc    : 弹窗工具类--加载等
 */
public class PopUtils {

    private static PopupWindow pop;
    private static AnimationDrawable animationDrawable;

//    //    显示登录弹出框
//    public static PopupWindow showLoadPop(final Activity mActivity, View anView) {
//        View view = LayoutInflater.from(mActivity).inflate(R.layout.pop_open_ble, null);
//        TextView tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
//        TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
//        TextView tv_ok = (TextView) view.findViewById(R.id.tv_ok);
//        tv_content.setText("暂未登录，去登录");
//        tv_ok.setText("去登录");
//
//        DisplayMetrics dm = new DisplayMetrics();
//        mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int screenWidth = dm.widthPixels;
//
//        ColorDrawable dw = new ColorDrawable(mActivity.getResources().getColor(R.color.color_black_01));
//        final PopupWindow pop = new PopupWindow((int) (screenWidth - mActivity.getResources().getDimension(R.dimen.dimen_20)), ViewPager.LayoutParams.WRAP_CONTENT);
//        pop.setContentView(view);
//        pop.setBackgroundDrawable(dw);
//
//        // 产生背景变暗效果，设置透明度
//        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
//        lp.alpha = 0.4f;
//        mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        mActivity.getWindow().setAttributes(lp);
//        pop.showAtLocation(anView, Gravity.CENTER, 0, 0);
//
//        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
//                lp.alpha = 1f;
//
//                mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//                mActivity.getWindow().setAttributes(lp);
//            }
//        });
//
//        tv_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pop.dismiss();
//            }
//        });
//
//        tv_ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                pop.dismiss();
//            }
//        });
//        return pop;
//    }
//
//
//    //    加载的弹出窗
//    public static PopupWindow showLoadingPop(final Activity mActivity, String title) {
//        View view = LayoutInflater.from(mActivity).inflate(R.layout.pop_conn_load, null);
//        ImageView iv_conn = (ImageView) view.findViewById(R.id.iv_conn);
//        TextView tv_conn = (TextView) view.findViewById(R.id.tv_conn);
//        tv_conn.setText(title);
//        AnimationDrawable animationDrawable = (AnimationDrawable) iv_conn.getBackground();
//        animationDrawable.start();
//
//        if (pop == null) {
//            pop = new PopupWindow((int) (AppUtils.getScreenWidth(mActivity) - mActivity.getResources().getDimension(R.dimen.dimen_20)), ViewPager.LayoutParams.WRAP_CONTENT);
//        }
//        // 产生背景变暗效果，设置透明度
//        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
//        lp.alpha = 0.4f;
//        mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        mActivity.getWindow().setAttributes(lp);
//        pop.setContentView(view);
//        pop.showAtLocation(mActivity.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
//        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
//                lp.alpha = 1f;
//
//                mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//                mActivity.getWindow().setAttributes(lp);
//            }
//        });
//        return pop;
//    }
//
//
//    //    wifi连接成功弹出框
//    public static PopupWindow showSuccessPop(final Activity mActivity) {
//        PopupWindow pop = new PopupWindow((int) (AppUtils.getScreenWidth(mActivity) - mActivity.getResources().getDimension(R.dimen.dimen_20)), ViewPager.LayoutParams.WRAP_CONTENT);
//        // 产生背景变暗效果，设置透明度
//        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
//        lp.alpha = 0.4f;
//        mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        mActivity.getWindow().setAttributes(lp);
//        View view = LayoutInflater.from(mActivity).inflate(R.layout.pop_conn_success, null);
//        pop.setContentView(view);
//        pop.showAtLocation(mActivity.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
//        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
//                lp.alpha = 1f;
//
//                mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//                mActivity.getWindow().setAttributes(lp);
//            }
//        });
//        return pop;
//    }
//
//
//    //    wifi连接失败弹出框
//    public static PopupWindow showFailPop(final Activity mActivity) {
//        View view = LayoutInflater.from(mActivity).inflate(R.layout.pop_conn_success, null);
//        ImageView iv_conn = (ImageView) view.findViewById(R.id.iv_conn);
//        TextView tv_conn = (TextView) view.findViewById(R.id.tv_conn);
//        iv_conn.setImageResource(R.mipmap.wifi_fail);
//        tv_conn.setText("连接失败");
//
//        PopupWindow pop = new PopupWindow((int) (AppUtils.getScreenWidth(mActivity) - mActivity.getResources().getDimension(R.dimen.dimen_20)), ViewPager.LayoutParams.WRAP_CONTENT);
//        // 产生背景变暗效果，设置透明度
//        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
//        lp.alpha = 0.4f;
//        mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        mActivity.getWindow().setAttributes(lp);
//        pop.setContentView(view);
//        pop.setBackgroundDrawable(new BitmapDrawable());
//        pop.setOutsideTouchable(true);
//        pop.setTouchable(false);
//        pop.showAtLocation(mActivity.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
//        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
//                lp.alpha = 1f;
//
//                mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//                mActivity.getWindow().setAttributes(lp);
//            }
//        });
//        return pop;
//    }
//
//
//    public static PopupWindow showVoicePop(final Activity mActivity, int resId) {
//        View view = LayoutInflater.from(mActivity).inflate(resId, null);
//        PopupWindow pop = new PopupWindow(ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT);
//        // 产生背景变暗效果，设置透明度
//        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
//        lp.alpha = 0.4f;
//        mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        mActivity.getWindow().setAttributes(lp);
//        pop.setContentView(view);
//        if (resId == R.layout.pop_voice_not) {
//            pop.setBackgroundDrawable(new BitmapDrawable());
//            pop.setOutsideTouchable(true);
//            pop.setTouchable(false);
//        } else if (resId == R.layout.pop_voice_init) {
//            ImageView iv_load = (ImageView) view.findViewById(R.id.iv_load);
//            animationDrawable = (AnimationDrawable) iv_load.getBackground();
//            animationDrawable.start();
//        } else if (resId == R.layout.pop_voice_spot) {
//            ImageView iv_load = (ImageView) view.findViewById(R.id.iv_load);
//            animationDrawable = (AnimationDrawable) iv_load.getBackground();
//            animationDrawable.start();
//        }
//        pop.showAtLocation(mActivity.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
//
//
//        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
//                lp.alpha = 1f;
//
//                mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//                mActivity.getWindow().setAttributes(lp);
//                if (animationDrawable != null && animationDrawable.isRunning()) {
//                    animationDrawable.stop();
//                }
//            }
//        });
//        return pop;
//    }
//
//    //    开始录音时
//    public static PopupWindow showInitPop(final Activity mActivity, View view) {
//
//        PopupWindow pop = new PopupWindow(ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT);
//        // 产生背景变暗效果，设置透明度
//        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
//        lp.alpha = 0.4f;
//        mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        mActivity.getWindow().setAttributes(lp);
//        pop.setContentView(view);
//        pop.showAtLocation(mActivity.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
//
//
//        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
//                lp.alpha = 1f;
//
//                mActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//                mActivity.getWindow().setAttributes(lp);
//                if (animationDrawable != null && animationDrawable.isRunning()) {
//                    animationDrawable.stop();
//                }
//            }
//        });
//        return pop;
//    }
//
//
//    public static AlertDialog showPayLoading(Activity activity, String title) {
//        View view = LayoutInflater.from(activity).inflate(R.layout.pop_conn_load, null);
//
//        ImageView iv_conn = (ImageView) view.findViewById(R.id.iv_conn);
//        TextView tv_conn = (TextView) view.findViewById(R.id.tv_conn);
//        tv_conn.setText(title);
//        final AnimationDrawable animationDrawable = (AnimationDrawable) iv_conn.getBackground();
//        animationDrawable.start();
//        AlertDialog dialog = new AlertDialog.Builder(activity, R.style.dialogNoBg).setCancelable(false).setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialogInterface) {
//                if (animationDrawable != null) {
//                    animationDrawable.stop();
//                }
//            }
//        }).setView(view).show();
//        return dialog;
//    }
//
//    //  设置蓝牙弹窗
//    public static void showBlePop(final Activity activity) {
//        AlertDialog dialog = null;
//        View view = LayoutInflater.from(activity).inflate(R.layout.pop_open_ble, null);
//        TextView tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
//        TextView tv_ok = (TextView) view.findViewById(R.id.tv_ok);
//        dialog = new AlertDialog.Builder(activity, R.style.dialogNoBg).setView(view).show();
//
//        final AlertDialog finalDialog = dialog;
//        tv_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finalDialog.dismiss();
//            }
//        });
//
//        final AlertDialog finalDialog1 = dialog;
//        tv_ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction(Settings.ACTION_BLUETOOTH_SETTINGS);
//                try {
//                    activity.startActivityForResult(intent, 1002);
//                } catch (ActivityNotFoundException ex) {
//                    ex.printStackTrace();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                finalDialog1.dismiss();
//            }
//        });
//    }
}
