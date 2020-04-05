package com.example.matkaexhibitioncenter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matkaexhibitioncenter.R;
import com.example.matkaexhibitioncenter.model.Exhibit;

public class ExhibitDetailsActivity extends AppCompatActivity {


    public static final String EXHIBIT = "exhibit";
    public static final String TAG = ExhibitDetailsActivity.class.getSimpleName();

    ImageView exhibitImage;
    TextView exhibitTitle, exhibitDetails;
    int exhibitType;
    Exhibit exhibits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibits_details);

        Intent intent = getIntent();
        if (getIntent().getExtras() != null){
            exhibitType = intent.getIntExtra(String.valueOf(exhibitType), -1);
        }

        exhibitImage = (ImageView) findViewById(R.id.exhibit_cover_image);
        exhibitTitle = (TextView) findViewById(R.id.exhibit_title);
        exhibitDetails = (TextView) findViewById(R.id.exibit_details);

        exhibits = (Exhibit) getIntent().getParcelableExtra(EXHIBIT);
        exhibitImage.setImageDrawable(Drawable.createFromPath(exhibits.getExhibitImage()));
        exhibitTitle.setText(exhibits.getExibitTitle());
        exhibitDetails.setText(exhibits.getExibitDetails());

        loadExhibits(exhibitType);

    }

    private void loadExhibits(int exhibitType) {

    }
}


