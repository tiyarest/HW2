package com.example.admin.tiktok;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.tiktok.chat.chatActivity;

import java.io.InputStream;
import java.util.List;

/**
 * Created by admin on 2019/1/19.
 */

public class MessagePage extends AppCompatActivity implements MassageAdpter.ListItemClickListener{

    private RecyclerView mMassageLiestView;
    private MassageAdpter messageApter;
    private List<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.massage_page);
        mMassageLiestView= findViewById(R.id.massage_listview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mMassageLiestView.setLayoutManager(layoutManager);

        mMassageLiestView.setHasFixedSize(true);

        try {
            InputStream assetInput = getAssets().open("data.xml");
            messages = PullParser.pull2xml(assetInput);
            messageApter = new MassageAdpter(messages,this);
            mMassageLiestView.setAdapter(messageApter);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
   }
    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent = new Intent(MessagePage.this,chatActivity.class);
        intent.putExtra("Icon",messages.get(clickedItemIndex).getIcon());
        startActivity(intent);
 }
}
