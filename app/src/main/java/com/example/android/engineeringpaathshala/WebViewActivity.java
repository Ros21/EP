package com.example.android.engineeringpaathshala;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.android.engineeringpaathshala.ButtonContainer.ButtonValue;

/**
 * Created by Roshan on 10/20/2016.
 */
public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    private String url;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview1);

        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        switch ( ButtonValue.buttonClicked) {
            case 1: {
               // Log.v("WebViewActivity", "value of button2 is "+ButtonValue.buttonClicked);
                url = "https://drive.google.com/file/d/0B9N4HvlxCb1zZjlPWEJWRXZZSEk/view";
                break;
            }
            case 2: {
                url = "https://drive.google.com/open?id=0B9N4HvlxCb1zTzU1cUh6RjFaWnM";
                //Log.v("WebViewActivity", "value of button2 is "+ButtonValue.buttonClicked);
                break;
            }
        }
        webView.loadUrl(url);

    }

}

