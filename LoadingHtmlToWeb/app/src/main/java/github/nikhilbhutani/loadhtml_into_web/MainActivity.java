package github.nikhilbhutani.loadhtml_into_web;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView1);

        //get complete setting of the webview
        WebSettings webSetting = webView.getSettings();

        //Zoom-in-out Controls
        webSetting.setBuiltInZoomControls(true);
        webSetting.setJavaScriptEnabled(true);


        webView.setWebViewClient(new WebViewClient());

        //Calling the index.html in the assets folder
        webView.loadUrl("file:///android_asset/index.html");

    }

    private class WebViewClient extends android.webkit.WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
