package com.example.admin.tiktok.chat;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.tiktok.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2019/1/19.
 */

public class chatActivity extends AppCompatActivity implements chatAdpter.ListItemClickListener{

    private Button chat;
    private EditText content;
    private List<chatMessage> list= new ArrayList<>();
    private RecyclerView mMassageLiestView;
    private chatAdpter chatadpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_list);
        Intent intent = getIntent();
        final String icon = intent.getStringExtra("Icon");
        chat=findViewById(R.id.send);
        content=findViewById(R.id.send_content);
        mMassageLiestView= findViewById(R.id.massage_listview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mMassageLiestView.setLayoutManager(layoutManager);

        mMassageLiestView.setHasFixedSize(true);
        chatadpter = new chatAdpter(list,chatActivity.this);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chatMessage message = new chatMessage(1);
                Date d = new Date();
                message.setTime(String.valueOf(d.getHours())+":"+String.valueOf(d.getHours()));
                list.add(message);
                chatMessage message1 = new chatMessage(2);
                message1.setContent(content.getText().toString());
                list.add(message1);
                chatMessage message2 = new chatMessage(3);
                message2.setIcon(icon);
                message2.setContent(content.getText().toString());
                list.add(message2);
                mMassageLiestView.setAdapter(chatadpter);
            }
        });

    }


    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}
