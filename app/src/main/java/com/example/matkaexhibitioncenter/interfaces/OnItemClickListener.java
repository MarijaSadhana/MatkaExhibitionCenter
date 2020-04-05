package com.example.matkaexhibitioncenter.interfaces;


import android.content.ClipData;

import com.example.matkaexhibitioncenter.model.Exhibit;
import com.example.matkaexhibitioncenter.model.Video;

public interface OnItemClickListener {

    void onItemClick(ClipData.Item item);

    void onItemClick (Exhibit exhibits);

    void onItemClick (Video videos);

}
