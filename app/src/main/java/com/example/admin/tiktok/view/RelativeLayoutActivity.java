package com.example.admin.tiktok.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.tiktok.R;

import java.util.ArrayList;
import java.util.List;


public class RelativeLayoutActivity extends AppCompatActivity {

    private int sum=0;
    private TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativelayout);
        View view = View.inflate(RelativeLayoutActivity.this,R.layout.activity_relativelayout,null);
        getAllChildViewCount(view);
        tv= findViewById(R.id.tv_center);
        tv.setText(String.valueOf(sum));

    }
    public int getAllChildViewCount(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup vp = (ViewGroup) view;
            for (int i = 0; i < vp.getChildCount(); i++) {
                View viewchild = vp.getChildAt(i);
                getAllChildViewCount(viewchild);
            }
        }
        else
            sum++;
        return 0;
    }
}
