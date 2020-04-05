package com.example.matkaexhibitioncenter.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matkaexhibitioncenter.R;

import static com.example.matkaexhibitioncenter.fragments.ExhibitsFragment.TYPE;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    public static final String TAG = HistoryFragment.class.getSimpleName();
    public static final int HISTORY = 0;

    RecyclerView recyclerView;



    public HistoryFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(int history) {
        HistoryFragment historyFragment = new HistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE, history);
        historyFragment.setArguments(bundle);
        return historyFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);

    }

}
