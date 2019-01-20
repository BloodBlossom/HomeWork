package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class myAdapter extends RecyclerView.Adapter<myAdapter.NumberViewHolder> {


    List<Message> mData;

    public myAdapter(List<Message> data ) {
        mData =data;
    }

    @NonNull
    @Override
    public  NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View myview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.new_layout,viewGroup,false);
        NumberViewHolder viewHolder = new NumberViewHolder(myview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder viewHolder, int position) {
        Message msg = mData.get(position);
        viewHolder.updateUI(msg);
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView t_title;
        private TextView t_hashtag;
        private TextView t_time;
        private CircleImageView t_icon;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            t_title = (TextView)itemView.findViewById(R.id.tv_title_number);
            t_hashtag = (TextView)itemView.findViewById(R.id.tv_tag_number);
            t_time = (TextView)itemView.findViewById(R.id.tv_time_number);
            t_icon = (CircleImageView)itemView.findViewById(R.id.iv_icon_number);
        }



        @Override
        public void onClick(View view) {

        }

        public void updateUI(Message msg) {
            t_title.setText(msg.getTitle());
            t_hashtag.setText(msg.getDescription());
            t_time.setText(msg.getTime());
            t_icon.setImageResource(msg.getIcon());
        }
    }

}
