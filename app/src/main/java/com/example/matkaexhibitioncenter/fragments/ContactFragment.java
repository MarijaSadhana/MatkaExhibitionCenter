package com.example.matkaexhibitioncenter.fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matkaexhibitioncenter.R;

import static com.example.matkaexhibitioncenter.fragments.ExhibitsFragment.TYPE;

public class ContactFragment extends Fragment {

    public static final String TAG = ContactFragment.class.getSimpleName();
    public static final int CONTACT = 0;

    TextView telNumber;
    ImageView location, bus1, taxi1, airport, bus2, taxi2;

    public ContactFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(int contact) {
        ContactFragment contactFragment = new ContactFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE, contact);
        contactFragment.setArguments(bundle);
        return contactFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_contact, container, false);

        location = view.findViewById(R.id.image_cover_maps);
        telNumber = view.findViewById(R.id.telNumber);
        bus1 = view.findViewById(R.id.bus_1);
        bus2 = view.findViewById(R.id.bus_2);
        taxi1 = view.findViewById(R.id.taxi_1);
        taxi2 = view.findViewById(R.id.taxi_2);
        airport = view.findViewById(R.id.airport);

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/search/matka/@41.9528457,21.2979605,320m/data=!3m1!1e3"));
                startActivity(intent);
            }
        });

        telNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(getContext(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    //Creating intents for making a call
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:+38972935105"));
                    startActivity(callIntent);

                }else{
                    Toast.makeText(getContext(), "You don't assign permission.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://www.jsp.com.mk/PlanskiVozenRed.aspx"));
                startActivity(intent);

            }
        });

        bus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://www.sas.com.mk/en/"));
                startActivity(intent);

            }
        });

        taxi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://zk.mk/taksi-kompanii/skopje"));
                startActivity(intent);

            }
        });

        taxi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://zk.mk/taksi-kompanii/skopje"));
                startActivity(intent);

            }
        });

        airport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://skp.airports.com.mk/default.aspx?ItemID=345"));
                startActivity(intent);

            }
        });

        return view;
    }

}
