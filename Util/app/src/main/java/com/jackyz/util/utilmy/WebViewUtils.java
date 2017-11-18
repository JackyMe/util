package com.jackyz.util.utilmy;

import android.net.http.SslError;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jackyz.util.assist.OnWebViewSettingsListener;


/**
 * author  : Created by JackyZ
 * date    : on 2017/10/11.
 * blog&git: http://blog.csdn.net/u011200604 & https://github.com/JackyMe/github.io
 * desc    : WebView 初始化相关工具类
 */

public class WebViewUtils {

    private static WebView webView;
    private static OnWebViewSettingsListener onWebViewSettingsListener;


    public static void initWebView(WebView web, OnWebViewSettingsListener listener, String url) {
        webView = web;
        onWebViewSettingsListener = listener;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setLoadsImagesAutomatically(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                onWebViewSettingsListener.shouldOverrideUrlLoading(view, url);
                return true;
            }
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                //super.onReceivedSslError(view, handler, error);
                //接受所有证书
                handler.proceed();
            }
        });
        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                onWebViewSettingsListener.onConsoleMessage(consoleMessage);
                return true;
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                onWebViewSettingsListener.onReceivedTitle(view, title);
            }
        });
        webView.loadUrl(url);
    }

    ;
}
