package com.ltz.my_empl;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.ltz.my_empl.util.StatusBar;

@SuppressLint("SetJavaScriptEnabled")
public class WebActivity extends AppCompatActivity {

    private boolean isLightMode = true;
    private WebView webView;
    private String jsonData;
    private Object obj = new Object();

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        StatusBar.setStatusBarTransparent(this);
        StatusBar.setStatusBarLightMode(this, isLightMode);

        webView = findViewById(R.id.webView);
        //设置为ChromeClient 才能执行js代码
        WebChromeClient webChromeClient = new WebChromeClient();
        webView.setWebChromeClient(webChromeClient);

        //设置开启js支持
        webView.getSettings().setJavaScriptEnabled(true);
        // 踩坑：name不能用大写字母
        webView.addJavascriptInterface(new Back(), "back");
        //是否支持缩放
        webView.getSettings().setSupportZoom(false);
        //加载网页
        webView.loadUrl("file:///android_asset/newsDetail.html");

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            jsonData = bundle.getString("jsonData");
            obj = JSON.parse(jsonData);
        }
        // 将 JSON 字符串传递给 HTML 页面
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.evaluateJavascript("javascript:updateData(" + obj + ")", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                    }
                });
            }
        });
    }

    class Back {
        @JavascriptInterface
        public void back() {
            finish();
        }
    }

}
