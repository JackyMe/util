package com.jackyz.util.utilmy;

/**
 * 项目名称:easyto
 * 作者：qiang.zhang on 2017/10/13 14:38
 * 邮箱：tryzq521@126.com
 * 类描述:  调用第三方地图工具类-以及国外地图渲染(须集成高德地图)
 */
public class MapUtilsGaode {
    private static final String TAG = MapUtilsGaode.class.getSimpleName();

//    /**
//     * 首先实现OnCameraChangeListener , 在onCameraChangeFinish() 回调中调用此方法
//     * 实现地图的谷歌弱图层自动加载与 免加载
//     *
//     * @param amap
//     * @param cameraPosition
//     * @param context
//     * @return
//     */
//    public static boolean AutoOverlay(AMap amap, CameraPosition cameraPosition, Context context) {
//        LogUtils.w(TAG, "onCameraChangeFinish:" + cameraPosition.toString());
//
//        LatLng target = cameraPosition.target;
//        float zoom = cameraPosition.zoom;
//
//        //判断中心点坐标是否在国内
//        boolean dataAvailable = new CoordinateConverter(context).isAMapDataAvailable(target.latitude, target.longitude);
//        //判断是否符合 谷歌图层加载条件
//        boolean isOverLayed = !dataAvailable && zoom > 5.5;
//
//        LogUtils.d("TAG", "坐标是否在国内:" + dataAvailable + "  ,缩放级别zoom" + zoom + "  ,是否开启覆盖" + isOverLayed);
//        overlay(amap, isOverLayed, dataAvailable, zoom);//中心点不在国内比并且缩放层级大于5才覆盖,否则清除
//
//        return isCleared;
//    }
//
//
//    /**
//     * 清除或者加载 谷歌图层
//     *
//     * @param amap  全局map操作对象
//     * @param overlay  是否满足加载谷歌图层条件
//     * @param dataAvailable  当前中心点是否在国内
//     * @param zoom  当前缩放层级
//     * <p>
//     * mt0可以取值mt3
//     * lyrs=y为混合地图，s为卫星地图，m为普通地图
//     */
//    private static boolean isCleared = true; //标记当前是否为图层清除状态  默认为是
//
//    public static void overlay(AMap amap, boolean overlay, boolean dataAvailable, float zoom) {
//        TileOverlay tileOverlay;
//        if (overlay) {
//            isCleared = false;
//            final String url = "http://mt3.google.cn/vt/lyrs=m@198&hl=zh-CN&gl=cn&src=app&x=%d&y=%d&z=%d&s=";
//            TileProvider tileProvider = new UrlTileProvider(256, 256) {
//                public URL getTileUrl(int x, int y, int zoom) {
//                    try {
//                        return new URL(String.format(url, x, y, zoom));
//                    } catch (MalformedURLException e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//                }
//            };
//            if (tileProvider != null) {
//                tileOverlay = amap.addTileOverlay(new TileOverlayOptions().tileProvider(tileProvider).diskCacheEnabled(true).diskCacheDir("/storage/emulated/0/amap/cache").diskCacheSize(100000).memoryCacheEnabled(true).memCacheSize(100000));
//            }//
//
//        } else {
//            if (!isCleared) { //若是清除过的就不要清除  == > 注 此方法调用会导致 由国外地图覆盖状态 回到国内时清除一次所有图层/标记/导航等
//                Log.e(TAG, "清除图层及覆盖");
//                amap.clear();//
//                isCleared = true;
//            }
//        }
//    }
//
//
//    /**
//     * 导航协助----试验调用  非真实数据
//     * 若location为空则导航到当前数据
//     */
//    public static void Shownavagation(final Context context, final String lat, final String lon, final Activity activity) {
//        new MaterialDialog.Builder(activity).title(R.string.select_map).items(R.array.alerdialog_item).itemsCallbackSingleChoice(2, new MaterialDialog.ListCallbackSingleChoice() {
//            @Override
//            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
//                switch (which) {
//                    case 0:
//                        callGoogleMap(context, lon, lat, activity);
//                        break;
//                    case 1:
//                        callGaodeMap(context, lon, lat, activity);
//                        break;
//                    case 2:
//                        callBaiduMap(context, lon, lat, activity);
//                        break;
//                }
//                dialog.dismiss();
//                return true; // allow selection
//            }
//        }).negativeText(R.string.dialog_no).positiveText(R.string.dialog_yes).positiveColor(ContextCompat.getColor(context, R.color.guide_selector)).negativeColor(ContextCompat.getColor(context, R.color.guide_selector)).onNegative(new MaterialDialog.SingleButtonCallback() {
//            @Override
//            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                dialog.dismiss();
//            }
//        }).show();
//    }
//
//    /**
//     * 调用高德地图导航
//     */
//    private static void callGaodeMap(Context context, String lon, String lat, Activity activity) {
//        if (isInstallByRead("com.autonavi.minimap")) {
//            goToNaviActivity(activity, "com.easyto.travel", null, lat, lon, "1", "2");
//        } else {
//            ToastUtils.showShort(activity, context.getString(R.string.no_gaode));
//        }
//    }
//
//    /**
//     * 启动高德App进行导航
//     * @param sourceApplication 必填 第三方调用应用名称。如 amap
//     * @param poiname 非必填 POI 名称
//     * @param lat 必填 纬度
//     * @param lon 必填 经度
//     * @param dev 必填 是否偏移(0:lat 和 lon 是已经加密后的,不需要国测加密; 1:需要国测加密)
//     * @param style 必填 导航方式(0 速度快; 1 费用少; 2 路程短; 3 不走高速；4 躲避拥堵；5 不走高速且避免收费；6 不走高速且躲避拥堵；7 躲避收费和拥堵；8 不走高速躲避收费和拥堵))
//     */
//    public static  void goToNaviActivity(Context context, String sourceApplication , String poiname , String lat , String lon , String dev , String style){
//        StringBuilder stringBuilder  = new StringBuilder("androidamap://navi?sourceApplication=")
//                .append(sourceApplication);
//        if (!TextUtils.isEmpty(poiname)){
//            stringBuilder.append("&poiname=").append(poiname);
//        }
//        stringBuilder.append("&lat=").append(lat)
//                .append("&lon=").append(lon)
//                .append("&dev=").append(dev)
//                .append("&style=").append(style);
//        Intent intent = new Intent("android.intent.action.VIEW", android.net.Uri.parse(stringBuilder.toString()));
//        intent.setPackage("com.autonavi.minimap");
//        context.startActivity(intent);
//    }
//    /**
//     * 调用谷歌地图导航
//     */
//    private static void callGoogleMap(Context context, String lon, String lat, Activity activity) {
//        if (isInstallByRead("com.google.android.apps.maps")) {
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ditu.google.cn/maps?hl=zh&mrt=loc&q=" + lat + "," + lon));
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK & Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
//            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
//            activity.startActivity(intent);
//        } else {
//            ToastUtils.showShort( context.getString(R.string.no_google));
//        }
//    }
//
//   /* */
//
//    /**
//     * 调用百度地图导航
//     */
//    private static void callBaiduMap(Context context, String lon, String lat, Activity activity) {
//
//        if (isInstallByRead("com.baidu.BaiduMap")) {//传入指定应用包名
//            String[] location = getUserAndLocation();
//
//            Intent intent;
//            try {
//                //intent = Intent.getIntent("intent://map/direction?origin=latlng:34.264642646862,108.95108518068|name:我家&destination=大雁塔&mode=driving®ion=西安&src=yourCompanyName|yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
//                intent = Intent.getIntent("intent://map/direction?" + "origin=latlng:" + location[0] + "," + location[1] + "&destination=latlng:" + lat + "," + lon + "&mode=driving&" + "&src=com.tianqihulian|easyto#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
//                activity.startActivity(intent); //启动调用
//            } catch (URISyntaxException e) {
//                LogUtils.e("intent", e.getMessage());
//            }
//        } else {//未安装
//            Uri uri = Uri.parse("market://details?id=com.baidu.BaiduMap");
//            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            activity.startActivity(intent);
//            ToastUtils.showShort( context.getString(R.string.no_baidu));
//        }
//    }
//
//    private static String[] getUserAndLocation() {
//        String locations = SPUtils.getInstance().getValue(BaseStringKey.MY_LOCATION, "");
//        String[] location;
//        if (!"".equals(locations)) {
//
//            location = locations.split(",");
//        } else {
//            location = new String[]{"0", "0"};
//        }
//        LogUtils.w("getUserAndLocation:" + location[0] + "," + location[1]);
//        return location;
//    }
//
//
//    /**
//     * 判断某软件包名是否存--用于判断某软件是安装(有局限性)
//     *
//     * @param packageName
//     * @return
//     */
//    public static boolean isInstallByRead(String packageName) {
//        return new File("/data/data/" + packageName).exists();
//    }
}
