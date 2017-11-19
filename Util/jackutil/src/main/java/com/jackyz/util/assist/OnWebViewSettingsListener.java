package com.jackyz.util.assist;

import android.webkit.ConsoleMessage;
import android.webkit.WebView;

/**
 * Created by admin on 2017/10/13.
 */

public interface OnWebViewSettingsListener {


     void onReceivedTitle(WebView view, String title);

     void shouldOverrideUrlLoading(WebView view, String url);

     void onConsoleMessage(ConsoleMessage consoleMessage);

}
