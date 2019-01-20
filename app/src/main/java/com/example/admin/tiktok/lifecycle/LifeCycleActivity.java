package com.example.admin.tiktok.lifecycle;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.admin.tiktok.R;


/**
 *
 *
 */
public class LifeCycleActivity extends AppCompatActivity {

    private static final String TAG = "wangyi";


    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private String s="";
    public MyApplication myApplication;


    private TextView mLifecycleDisplay;


    private void logAndAppend(String lifecycleEvent) {
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);
//        myApplication.setMessage(myApplication.getMessage()+lifecycleEvent+"\n");
         mLifecycleDisplay.append(lifecycleEvent+"\n");
    }

    public void resetLifecycleDisplay(View view) {
        mLifecycleDisplay.setText("Lifecycle callbacks:\n");
    }

    public void showSaveInstance(View view) {
        startActivity(new Intent(this, SaveInstanceStateActivity.class));
    }

    public void showUpgradeDialog(View view) {
        new AlertDialog.Builder(this)
                .setTitle("应用升级")
                .setMessage("抖音1.1版本升级")
                .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        mLifecycleDisplay = findViewById(R.id.tv_loglifecycle);
        myApplication = (MyApplication) getApplication();
        if(myApplication.getMessage()!=null){
            mLifecycleDisplay.setText(myApplication.getMessage());
        }
        logAndAppend(ON_CREATE);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logAndAppend(ON_RESTART);

    }

    @Override
    protected void onStart() {
        super.onStart();
        s=s+ON_START+"\n";
        myApplication.setMessage(s);
        logAndAppend(ON_START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        s=s+ON_RESUME+"\n";
        logAndAppend(ON_RESUME);
    }


    @Override
    protected void onPause() {
        super.onPause();
        s=s+ON_PAUSE+"\n";
        logAndAppend(ON_PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        s=s+ON_STOP+"\n";
        logAndAppend(ON_STOP);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        s=s+ON_DESTROY+"\n";
        logAndAppend(ON_DESTROY);
        myApplication.setMessage(mLifecycleDisplay.getText().toString());
    }

}
