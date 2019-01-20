package com.example.admin.tiktok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.admin.tiktok.R;

import com.example.admin.tiktok.chat.chatActivity;
import com.example.admin.tiktok.lifecycle.LifeCycleActivity;
import com.example.admin.tiktok.view.RelativeLayoutActivity;
import com.example.admin.tiktok.widget.CircleImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleImageView circleImageView = findViewById(R.id.circle_view);
        circleImageView.setImageResource(R.drawable.icon_micro_game_comment);
        findViewById(R.id.btn_exercises1).setOnClickListener(this);
        findViewById(R.id.btn_exercises2).setOnClickListener(this);
        findViewById(R.id.btn_exercises3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_exercises1:
                startActivity(new Intent(this, LifeCycleActivity.class));
                break;
            case R.id.btn_exercises2:
                startActivity(new Intent(this, RelativeLayoutActivity.class));
                break;
            case R.id.btn_exercises3:
                startActivity(new Intent(this, MessagePage.class));
                break;
        }
    }
}
