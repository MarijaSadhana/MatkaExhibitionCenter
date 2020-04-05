package com.example.matkaexhibitioncenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matkaexhibitioncenter.R;
import com.example.matkaexhibitioncenter.interfaces.OnItemClickListener;
import com.example.matkaexhibitioncenter.model.Video;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    ArrayList<Video> videoList;
    Context context;
    OnItemClickListener onItemClickListener;
    LayoutInflater inflater;

    public VideoAdapter(Context context, ArrayList<Video> videoList, OnItemClickListener onItemClickListener ){

        this.context = context;
        this.videoList = videoList;
        this.onItemClickListener = onItemClickListener;
        this.inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_video, parent, false);
        return new VideoAdapter.VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        final Video videos = videoList.get(position);

        holder.imageView.setImageResource(R.drawable.evn_logo);
        holder.videoTitle.setText(videos.getVideoTitle());

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView videoTitle;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.video_image);
            videoTitle = (TextView) itemView.findViewById(R.id.video_title);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null){
                        onItemClickListener.onItemClick(videoList.get(getAdapterPosition()));
                    }
                }
            });


        }
    }
}
