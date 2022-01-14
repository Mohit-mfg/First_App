package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.first.databinding.ActivityWebViewBinding;

import java.net.URL;

public class WebView extends AppCompatActivity {
    private ActivityWebViewBinding binding;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWebViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ProgressBar progressBar=new ProgressBar(WebView.this);
        progressBar.isShown();


//        binding.webId.loadUrl("https://www.calculator.net/bmi-calculator.html");
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(getString(R.string.app_name));
        progressDialog.setMessage("Please wait, while loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        binding.webId.loadUrl("https://www.instagram.com");
        binding.webId.setWebViewClient(new MyWebViewClient());
    }

    public class MyWebViewClient extends WebViewClient {

//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
////            if ("https://developer.android.com".equals(request.getUrl().getHost())){
////                return false;
////            }else {
////                Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
////                startActivity(intent);
////            }
//            return true;
//        }


        @Override
        public boolean shouldOverrideUrlLoading(android.webkit.WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageFinished(android.webkit.WebView view, String url) {
            super.onPageFinished(view, url);
//            if (binding.progressBar.isShown()) binding.progressBar.setVisibility(View.GONE);
            if (progressDialog.isShowing()) progressDialog.hide();
        }
    }

}