package com.jackyz.util.utilmy;

/**
 * author  : Created by JackyZ
 * date    : on 2017/10/11.
 * blog&git: http://blog.csdn.net/u011200604 & https://github.com/JackyMe/github.io
 * desc    : 科大讯飞 语音 初始化工具类 -- 须集成科大讯飞
 */
public class VoiceUtils {

//    private static SpeechRecognizer mIat;
//    private static SpeechSynthesizer mTts;
//    // 语音听写UI
//    private static RecognizerDialog mIatDialog;
//    // 用HashMap存储听写结果
//    private static HashMap<String, String> mIatResults = new LinkedHashMap<String, String>();
//    private static Toast mToast;
//    private static String Tag;
//    private static Activity activity;
//    private static PopupWindow pop;
//    private static ImageView iv_load;
//
//    // 缓冲进度
//    private static int mPercentForBuffering = 0;
//    // 播放进度
//    private static int mPercentForPlaying = 0;
//    private static View view;
//
//
//    /****************************************讯飞语音相关*************************************************/
//    public static void initVoiceData(Activity mActivity) {
//        activity = mActivity;
//        /**讯飞语音相关*/
//        mToast = Toast.makeText(mActivity, "", Toast.LENGTH_SHORT);
//        /**初始化讯飞的听读功能*/
//        // 使用SpeechRecognizer对象，可根据回调消息自定义界面；
//        mIat = SpeechRecognizer.createRecognizer(mActivity, mInitListener);
//
//        mTts = SpeechSynthesizer.createSynthesizer(mActivity, mInitListener);
//
//        // 初始化听写Dialog，如果只使用有UI听写功能，无需创建SpeechRecognizer
//        mIatDialog = new RecognizerDialog(mActivity, mInitListener);
//
//        //初始化语音参数
//        setVoiceParam();
//
//        setTranParam();
//    }
//
//
//    /**
//     * 初始化监听器。
//     */
//    private static InitListener mInitListener = new InitListener() {
//
//        @Override
//        public void onInit(int code) {
//            Log.e("tag", "SpeechRecognizer downRecordData() code = " + code);
//            if (code != ErrorCode.SUCCESS) {
//                showTip("初始化失败，错误码：" + code);
//            }
//        }
//
//    };
//
//    // 引擎类型
//    private static String mEngineType = SpeechConstant.TYPE_CLOUD;
//
//
//    public static void setVoiceParam() {
//        // 清空参数
//        mIat.setParameter(SpeechConstant.PARAMS, null);
//
//        // 设置听写引擎
//        mIat.setParameter(SpeechConstant.ENGINE_TYPE, mEngineType);
//        // 设置返回结果格式
//        mIat.setParameter(SpeechConstant.RESULT_TYPE, "json");
//
//        String lag = "zh_cn";
//        if (lag.equals("en_us")) {
//            // 设置语言
//            mIat.setParameter(SpeechConstant.LANGUAGE, "en_us");
//        } else {
//            // 设置语言
//            mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
//            // 设置语言区域
//            mIat.setParameter(SpeechConstant.ACCENT, lag);
//        }
//
//        // 设置语音前端点:静音超时时间，即用户多长时间不说话则当做超时处理
//        mIat.setParameter(SpeechConstant.VAD_BOS, "2000");
//
//        // 设置语音后端点:后端点静音检测时间，即用户停止说话多长时间内即认为不再输入， 自动停止录音
//        mIat.setParameter(SpeechConstant.VAD_EOS, "1000");
//
//        // 设置标点符号,设置为"0"返回结果无标点,设置为"1"返回结果有标点
//        mIat.setParameter(SpeechConstant.ASR_PTT, "");
//
//        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
//        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
//        mIat.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
//        mIat.setParameter(SpeechConstant.ASR_AUDIO_PATH, Environment.getExternalStorageDirectory() + "/AA_Voice/识别iat.wav");
//    }
//
//
//    private static void showTip(final String str) {
//        mToast.setText(str);
//        mToast.show();
//    }
//
//
//    public static void startListening(final String tag) {
//        mIat.setParameter(SpeechConstant.VAD_EOS, "500");
//        Tag = tag;
//        mIat.startListening(new RecognizerListener() {
//            @Override
//            public void onVolumeChanged(int i, byte[] bytes) {
//                if (iv_load != null) {
//                    if (i == 0) {
//                        iv_load.setImageResource(R.mipmap.listener);
//                    } else if (i > 0 && i <= 10) {
//                        iv_load.setImageResource(R.mipmap.listener01);
//                    } else if (i > 10 && i <= 20) {
//                        iv_load.setImageResource(R.mipmap.listener02);
//                    } else if (i > 20 && i <= 30) {
//                        iv_load.setImageResource(R.mipmap.listener03);
//                    } else if (i > 30 && i <= 40) {
//                        iv_load.setImageResource(R.mipmap.listener04);
//                    } else if (i > 40 && i <= 50) {
//                        iv_load.setImageResource(R.mipmap.listener05);
//                    } else if (i > 50 && i <= 60) {
//                        iv_load.setImageResource(R.mipmap.listener06);
//                    } else if (i > 60 && i <= 70) {
//                        iv_load.setImageResource(R.mipmap.listener07);
//                    } else if (i > 70 && i <= 80) {
//                        iv_load.setImageResource(R.mipmap.listener08);
//                    }
//                }
//            }
//
//            @Override
//            public void onBeginOfSpeech() {
//                LogUtils.e("====开始录音=====");
//                if (Tag.equals("chat")) {
//                    if (pop != null && pop.isShowing()) {
//                        pop.dismiss();
//                    }
//                    if (iv_load == null) {
//                        view = LayoutInflater.from(activity).inflate(R.layout.pop_voice_init, null);
//                        iv_load = (ImageView) view.findViewById(R.id.iv_load);
//                    }
//                    pop = PopUtils.showInitPop(activity, view);
//                }
//            }
//
//            @Override
//            public void onEndOfSpeech() {
//                if (Tag.equals("chat")) {
//                    if (pop != null && pop.isShowing()) {
//                        pop.dismiss();
//                    }
//                    LogUtils.e("====结束录音====");
//                    LogUtils.e("=====开始识别====");
//                    pop = PopUtils.showVoicePop(activity, R.layout.pop_voice_spot);
//                }
//            }
//
//            @Override
//            public void onResult(RecognizerResult recognizerResult, boolean b) {
//                if (Tag.equals("chat")) {
//                    if (pop != null && pop.isShowing()) {
//                        pop.dismiss();
//                    }
//                }
//                printResult(recognizerResult);
//            }
//
//            @Override
//            public void onError(SpeechError speechError) {
//                LogUtils.e("========识别出错=========");
//                if (Tag.equals("chat")) {
//                    if (pop != null && pop.isShowing()) {
//                        pop.dismiss();
//                    }
//                    pop = PopUtils.showVoicePop(activity, R.layout.pop_voice_not);
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            if (pop != null && pop.isShowing()) {
//                                pop.dismiss();
//                            }
//                        }
//                    }, 2000);
//                }
//                RxBus.getDefault().post(new VoiceBean(Tag, null));
//            }
//
//            @Override
//            public void onEvent(int i, int i1, int i2, Bundle bundle) {
//
//            }
//        });
//    }
//
//
//    public static void stopListening() {
//        if (mIat.isListening()) {
//            mIat.stopListening();
//
//        }
//    }
//
//
//    /**
//     * 语音结果
//     *
//     * @param results
//     */
//    public static void printResult(RecognizerResult results) {
//
//        String text = JsonParser.parseIatResult(results.getResultString());
//        LogUtils.w("解析text:" + text);
//        String sn = null;
//        // 读取json结果中的sn字段
//        try {
//            org.json.JSONObject resultJson = new org.json.JSONObject(results.getResultString());
//            sn = resultJson.optString("sn");
//        } catch (JSONException e) {
//            LogUtils.e("获取语音出错：" + e.getMessage());
//            e.printStackTrace();
//        }
//
//        mIatResults.put(sn, text);
//
//        StringBuffer resultBuffer = new StringBuffer();
//        for (String key : mIatResults.keySet()) {
//            resultBuffer.append(mIatResults.get(key));
//        }
//
//        //去除标点 && !text.contains("。") && !text.contains(",")&&!text.contains("?")&& !text.contains("!")
//        if (!resultBuffer.toString().equals("") && text.length() > 1) {
//            //MessgeOut(resultBuffer.toString());
//            LogUtils.e("printResult 讯飞语音解析结果....---:" + resultBuffer.toString());
//            sendText(resultBuffer.toString());
//        }
//    }
//
//
//    /**
//     * 语音转换文字后发送消息
//     *
//     * @param text
//     */
//    private static void sendText(String text) {
//        LogUtils.e("========识别结束=========");
//        RxBus.getDefault().post(new VoiceBean(Tag, text));
//
//    }
//
//
////******************************** 文字转语音 start ******************************
//
//    private static void setTranParam() {
//        mIat.setParameter(SpeechConstant.ENGINE_TYPE, mEngineType);
//// 清空参数
//        mTts.setParameter(SpeechConstant.PARAMS, null);
//        // 根据合成引擎设置相应参数
//        if (mEngineType.equals(SpeechConstant.TYPE_CLOUD)) {
//            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
//            // 设置在线合成发音人
//            mTts.setParameter(SpeechConstant.VOICE_NAME, "");
//            //设置合成语速
//            mTts.setParameter(SpeechConstant.SPEED, "50");
//            //设置合成音调
//            mTts.setParameter(SpeechConstant.PITCH, "50");
//            //设置合成音量
//            mTts.setParameter(SpeechConstant.VOLUME, "100");
//        } else {
//            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL);
//            // 设置本地合成发音人 voicer为空，默认通过语记界面指定发音人。
//            mTts.setParameter(SpeechConstant.VOICE_NAME, "");
//            /**
//             * TODO 本地合成不设置语速、音调、音量，默认使用语记设置
//             * 开发者如需自定义参数，请参考在线合成参数设置
//             */
//        }
//        //设置播放器音频流类型
//        mTts.setParameter(SpeechConstant.STREAM_TYPE, "3");
//        // 设置播放合成音频打断音乐播放，默认为true
//        mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");
//
//        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
//        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
//        mTts.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
//        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, Environment.getExternalStorageDirectory() + "/msc/tts.wav");
//    }
//
//    public static void startSpeaking(Activity context, String text) {
//        LogUtils.e("开始说话啦");
//        FlowerCollector.onEvent(context, "tts_play");
//
//        // 设置参数
//        setTranParam();
//        int code = mTts.startSpeaking(text, mTtsListener);
//        if (code != ErrorCode.SUCCESS) {
//            showTip("语音合成失败,错误码: " + code);
//        }
//    }
//
//    public static void stopSpeaking() {
//        if (mTts != null) {
//            mTts.stopSpeaking();
//        }
//
//    }
//
//    public static void pauseSpeaking() {
//        if (mTts != null) {
//            mTts.pauseSpeaking();
//        }
//    }
//
//    public static void resumeSpeaking() {
//        if (mTts != null) {
//            mTts.resumeSpeaking();
//        }
//    }
//
//    public static boolean isSpeaking() {
//        if (mTts != null) {
//            return mTts.isSpeaking();
//        }
//        return false;
//    }
//
//    /**
//     * 合成回调监听。
//     */
//    private static SynthesizerListener mTtsListener = new SynthesizerListener() {
//
//        @Override
//        public void onSpeakBegin() {
////            showTip("开始播放");
//        }
//
//        @Override
//        public void onSpeakPaused() {
////            showTip("暂停播放");
//        }
//
//        @Override
//        public void onSpeakResumed() {
////            showTip("继续播放");
//        }
//
//        @Override
//        public void onBufferProgress(int percent, int beginPos, int endPos, String info) {
//            // 合成进度
//            mPercentForBuffering = percent;
////            showTip("合成进度"+ mPercentForBuffering+mPercentForPlaying);
//        }
//
//        @Override
//        public void onSpeakProgress(int percent, int beginPos, int endPos) {
//            // 播放进度
//            mPercentForPlaying = percent;
////            showTip("播放进度"+
////                    mPercentForBuffering+  mPercentForPlaying);
//        }
//
//        @Override
//        public void onCompleted(SpeechError error) {
//            if (error == null) {
////                showTip("播放完成");
//            } else if (error != null) {
////                showTip(error.getPlainDescription(true));
//                LogUtils.e("播放失败");
//            }
//        }
//
//        @Override
//        public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
//            // 以下代码用于获取与云端的会话id，当业务出错时将会话id提供给技术支持人员，可用于查询会话日志，定位出错原因
//            // 若使用本地能力，会话id为null
//            //	if (SpeechEvent.EVENT_SESSION_ID == eventType) {
//            //		String sid = obj.getString(SpeechEvent.KEY_EVENT_SESSION_ID);
//            //		Log.d(TAG, "session id =" + sid);
//            //	}
//        }
//    };

    //******************************** 文字转语音 end ******************************
}