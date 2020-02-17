package com.example.plugintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button pluginTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }
    private void initEvent() {
        pluginTest.setOnClickListener(mListener);
    }

    private void initView(){
        pluginTest = findViewById(R.id.plugin_test);
    }
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, PluginTestActivity.class);
            startActivity(intent);
        }
    };
}
