package com.example.facebookv2.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.facebookv2.R;
import com.example.facebookv2.pojo.PostModel;


import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<PostModel> postList=new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        setHolderData(holder,position);
    }

    //either use this method from outside to pass the list to the recyclerView or
    //pass it in the recyclerView Constructor
    public void setList(List<PostModel> postList)
    {
        this.postList=postList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV;
        TextView userIdTV;
        TextView bodyTV;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV=itemView.findViewById(R.id.titleTV);
            userIdTV=itemView.findViewById(R.id.userIdTV);
            bodyTV=itemView.findViewById(R.id.bodyTV);
        }
    }
    public void setHolderData(PostViewHolder holder,int position)
    {
        holder.bodyTV.setText(postList.get(position).getBody());
        holder.titleTV.setText(postList.get(position).getTitle());
        holder.userIdTV.setText(postList.get(position).getUserId()+""); // to make it string
    }

}
