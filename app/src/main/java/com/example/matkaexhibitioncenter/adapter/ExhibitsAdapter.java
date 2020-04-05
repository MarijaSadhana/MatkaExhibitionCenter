package com.example.matkaexhibitioncenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matkaexhibitioncenter.R;
import com.example.matkaexhibitioncenter.interfaces.OnItemClickListener;
import com.example.matkaexhibitioncenter.model.Exhibit;

import java.util.ArrayList;

public class ExhibitsAdapter extends RecyclerView.Adapter<ExhibitsAdapter.ExhibitViewHolder> {

    ArrayList<Exhibit> exhibitsList;
    Context context;
    OnItemClickListener onItemClickListener;
    LayoutInflater inflater;

    public ExhibitsAdapter(Context context, ArrayList<Exhibit> exhibitsList, OnItemClickListener onItemClickListener) {

        this.context = context;
        this.exhibitsList = exhibitsList;
        this.onItemClickListener = onItemClickListener;
        this.inflater = LayoutInflater.from(context);

    }

    @NonNull
    public ExhibitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_exhibit, parent, false);
        return new ExhibitViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ExhibitViewHolder holder, int position) {

        final Exhibit exhibits = exhibitsList.get(position);

        holder.imageView.setImageResource(R.drawable.evn_logo);
        holder.exhibitTitle.setText(exhibits.getExibitTitle());

    }

    @Override
        public int getItemCount() {
            return exhibitsList.size();
        }

    public class ExhibitViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView exhibitTitle;

        public ExhibitViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.exhibit_image);
            exhibitTitle = (TextView) itemView.findViewById(R.id.exibit_title);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null){
                        onItemClickListener.onItemClick(exhibitsList.get(getAdapterPosition()));
                    }
                }
            });

        }
    }

}






