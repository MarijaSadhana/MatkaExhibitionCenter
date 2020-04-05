package com.example.matkaexhibitioncenter.fragments;


import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matkaexhibitioncenter.R;
import com.example.matkaexhibitioncenter.adapter.VideoAdapter;
import com.example.matkaexhibitioncenter.interfaces.OnItemClickListener;
import com.example.matkaexhibitioncenter.model.Exhibit;
import com.example.matkaexhibitioncenter.model.Video;

import java.util.ArrayList;

import static com.example.matkaexhibitioncenter.fragments.ExhibitsFragment.TYPE;

public class VideoFragment extends Fragment implements OnItemClickListener{

    public static final String TAG = VideoFragment.class.getSimpleName();
    public static final int VIDEO = 0;

    int videoTitle;
    RecyclerView recyclerView;
    VideoAdapter videoAdapter;
    ArrayList<Video> videoList = new ArrayList<>();

    public VideoFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(int video) {
        VideoFragment videoFragment = new VideoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE, video);
        videoFragment.setArguments(bundle);
        return videoFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            videoTitle = getArguments().getInt(TYPE, videoTitle);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        loadVideos();

        recyclerView = view.findViewById(R.id.recycler_view_video);
        recyclerView.setLayoutManager( new GridLayoutManager(getActivity(), 2,
                GridLayoutManager.HORIZONTAL, false));
        videoAdapter = new VideoAdapter(getContext(), videoList, this);
        recyclerView.setAdapter(videoAdapter);

        return view;

    }

    public void loadVideos() {

        Video video1 = new Video();
        video1.setVideoTitle("Денот на Тесла");
        video1.setVideoId("ui2-ca-Cr7o");
        videoList.add(video1);

        Video video2 = new Video();
        video2.setVideoTitle("Цртежи - Денот на Тесла");
        video2.setVideoId("g28xG1R15Lo");
        videoList.add(video2);

        Video video3 = new Video();
        video3.setVideoTitle("Историја на електрификација во Македонија");
        video3.setVideoId("ci93H59m2IY");
        videoList.add(video3);

        Video video4 = new Video();
        video4.setVideoTitle("Енергетска ефикасност");
        video4.setVideoId("u8Yr9vqyU_8");
        videoList.add(video4);

        Video video5 = new Video();
        video5.setVideoTitle("Патот на струјата");
        video5.setVideoId("mXEulg0a1Yk");
        videoList.add(video5);

        Video video6 = new Video();
        video6.setVideoTitle("Како се пренесува струјата");
        video6.setVideoId("Y0roxYTwLwQ");
        videoList.add(video6);

        Video video7 = new Video();
        video7.setVideoTitle("Обновливи извори на енергија");
        video7.setVideoId("qwkQVShCklw");
        videoList.add(video7);

        Video video8 = new Video();
        video8.setVideoTitle("Што е струја?");
        video8.setVideoId("ohWQvr7y93k");
        videoList.add(video8);

    }

    @Override
    public void onItemClick(ClipData.Item item) {

    }

    @Override
    public void onItemClick(Exhibit exhibits) {

    }

    @Override
    public void onItemClick(Video videos) {

        String videoId = "ui2-ca-Cr7o";


//        String [] videoId = {
//                "ui2-ca-Cr7o",
//                "g28xG1R15Lo",
//                "ci93H59m2IY",
//                "u8Yr9vqyU_8",
//                "mXEulg0a1Yk",
//                "Y0roxYTwLwQ",
//                "qwkQVShCklw",
//                "ohWQvr7y93k"
//        };

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
        intent.putExtra("VIDEO_ID", videoId);
        intent.putExtra("force_fullscreen",true);
        startActivity(intent);

    }


}
