package com.example.matkaexhibitioncenter.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.matkaexhibitioncenter.R;
import com.example.matkaexhibitioncenter.fragments.ContactFragment;
import com.example.matkaexhibitioncenter.fragments.ExhibitsFragment;
import com.example.matkaexhibitioncenter.fragments.HistoryFragment;
import com.example.matkaexhibitioncenter.fragments.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //hide action bar
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_item_home);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (menuItem.getItemId()) {
            case R.id.menu_item_home:
                ft.replace(R.id.frameId, ExhibitsFragment.newInstance(ExhibitsFragment.EXHIBITS), ExhibitsFragment.TAG);
                ft.commit();
                return true;
            case R.id.menu_item__video:
                ft.replace(R.id.frameId, VideoFragment.newInstance(VideoFragment.VIDEO), VideoFragment.TAG);
                ft.commit();
                return true;
            case R.id.menu_item_history:
                ft.replace(R.id.frameId, HistoryFragment.newInstance(HistoryFragment.HISTORY), HistoryFragment.TAG);
                ft.commit();
                return true;
            case R.id.menu_item_contact:
                ft.replace(R.id.frameId, ContactFragment.newInstance(ContactFragment.CONTACT), ContactFragment.TAG);
                ft.commit();
                return true;
        }
        return false;
    }

}
