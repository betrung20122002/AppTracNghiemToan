package com.example.um;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
   private LayoutInflater inflater;
   private String[] stitles;
   private String[] scontent;
   Adapter(Context context,String[] titles,String[]contents){
       this.inflater = LayoutInflater.from(context);
       this.stitles = titles;
       this.scontent = contents;
   }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_view,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       String title = stitles[position];
       String contents = scontent[position];
       holder.storytitle.setText(title);
       holder.storyContent.setText(contents);
    }

    @Override
    public int getItemCount() {
        return stitles.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
       TextView storytitle,storyContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //implement onclick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),Details.class);
                    i.putExtra("titleOfStory",stitles[getAdapterPosition()]);
                    i.putExtra("contentOfStory",scontent[getAdapterPosition()]);
                    v.getContext().startActivity(i);
                }
            });
            //lấy danh sách tên truyện và nội dung trong mảng chuỗi
            storytitle = itemView.findViewById(R.id.storyTitle);
            storyContent = itemView.findViewById(R.id.storyContents);

        }
    }
}
