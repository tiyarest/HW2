package com.example.admin.tiktok.chat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.tiktok.R;
import com.example.admin.tiktok.widget.CircleImageView;

import java.util.List;

/**
 * Created by admin on 2019/1/19.
 */

public class chatAdpter extends RecyclerView.Adapter<chatAdpter.ChatViewHolder>{
    private List<chatMessage> list;

    private final ListItemClickListener mOnClickListener;

    private static int viewHolderCount;

    public chatAdpter(List<chatMessage> Messagelist,ListItemClickListener listener) {
        list = Messagelist;
        mOnClickListener = listener;
        viewHolderCount = 0;

    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.my_chat_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        ChatViewHolder viewHolder = new ChatViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull chatAdpter.ChatViewHolder holder, int position) {
        holder.bind(position);
    }



    @Override
    public int getItemCount() {
        return list.size();
    }


    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public class ChatViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        private final CircleImageView  mycircleImageView;
        private final CircleImageView  yourcircleImageView;
        private final TextView mycontent;
        private final TextView yourcontent;
        private final TextView time;
        private final FrameLayout myframeLayout;
        private final FrameLayout yourframeLayout;


        public ChatViewHolder(View itemView) {
            super(itemView);
            mycircleImageView=itemView.findViewById(R.id.my_icon);
            yourcircleImageView=itemView.findViewById(R.id.your_icon);
            mycontent=itemView.findViewById(R.id.my_content);
            yourcontent=itemView.findViewById(R.id.your_content);
            time=itemView.findViewById(R.id.chat_time);
            myframeLayout=itemView.findViewById(R.id.my_frame);
            yourframeLayout=itemView.findViewById(R.id.your_frame);
        }

        public  void bind(int position){
            chatMessage ms = list.get(position);
            if(ms.getTpye()==1){
                time.setVisibility(View.VISIBLE);
                time.setText(ms.getTime());
            }
            else if(ms.getTpye()==2) {//my
                myframeLayout.setVisibility(View.VISIBLE);
                mycontent.setVisibility(View.VISIBLE);
                mycontent.setText(list.get(position).getContent());
                mycircleImageView.setImageResource(R.drawable.icon_girl);


            }
            else if(ms.getTpye()==3){//your
                yourframeLayout.setVisibility(View.VISIBLE);
                yourcontent.setVisibility(View.VISIBLE);
                yourcontent.setText(list.get(position).getContent());
                yourcircleImageView.setImageResource(choosePic(list.get(position).getIcon()));

            }

        }
        public int choosePic(String tpye) {
            int id;
            if (tpye.equals("TYPE_SYSTEM"))
                id = R.drawable.session_system_notice;
            else if (tpye.equals("TYPE_STRANGER"))
                id = R.drawable.session_stranger;
            else if (tpye.equals("TYPE_USER"))
                id = R.drawable.icon_girl;
            else if (tpye.equals("TYPE_ROBOT"))
                id = R.drawable.session_robot;
            else
                id = R.drawable.icon_micro_game_comment;
            return id;
        }

        @Override
        public void onClick(View view) {

        }
    }
}
