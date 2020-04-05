package com.example.matkaexhibitioncenter.fragments;


import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matkaexhibitioncenter.activity.ExhibitDetailsActivity;
import com.example.matkaexhibitioncenter.model.Exhibit;
import com.example.matkaexhibitioncenter.adapter.ExhibitsAdapter;
import com.example.matkaexhibitioncenter.interfaces.OnItemClickListener;
import com.example.matkaexhibitioncenter.R;
import com.example.matkaexhibitioncenter.model.Video;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ExhibitsFragment extends Fragment implements OnItemClickListener {

    public static final String TAG = ExhibitsFragment.class.getSimpleName();
    public static final int EXHIBITS = 0;
    public static final String TYPE = "TYPE";

    RecyclerView recyclerView;
    ArrayList<Exhibit> exhibitsList = new ArrayList<>();
    ExhibitsAdapter exhibitsAdapter;
    int exhibitType;

    public static ExhibitsFragment newInstance(int exibit) {
        ExhibitsFragment exhibitsFragment = new ExhibitsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE, exibit);
        exhibitsFragment.setArguments(bundle);
        return exhibitsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null){
            exhibitType = getArguments().getInt(TYPE, exhibitType);
        }
    }

    public ExhibitsFragment(){
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exhibits, container, false);

        loadExhibits();

        recyclerView = view.findViewById(R.id.recycler_view_exhibits);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        exhibitsAdapter = new ExhibitsAdapter(getContext(), exhibitsList, this);
        recyclerView.setAdapter(exhibitsAdapter);

        return view;
    }

    @Override
    public void onItemClick(ClipData.Item item) {

    }

    @Override
    public void onItemClick(Exhibit exhibits) {
        Intent intent = new Intent(getActivity(), ExhibitDetailsActivity.class);
        intent.putExtra(ExhibitDetailsActivity.EXHIBIT, (Parcelable) exhibits);
        startActivity(intent);

    }

    @Override
    public void onItemClick(Video videos) {
    }

    public void loadExhibits() {

        Exhibit exhibit1 = new Exhibit();
        exhibit1.setExibitTitle("Електрификација на Македонија");
        exhibit1.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit1.setExhibitImage(String.valueOf(R.drawable.elektrifikacija_na_makedonija));
        exhibitsList.add(exhibit1);

        Exhibit exhibit2 = new Exhibit();
        exhibit2.setExibitTitle("Употреба на електричната енергија во светот");
        exhibit2.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit2.setExhibitImage(String.valueOf(R.drawable.upotreba_na_elektricnata_energija_vo_svetot));
        exhibitsList.add(exhibit2);

        Exhibit exhibit3 = new Exhibit();
        exhibit3.setExibitTitle("Цитати на научници");
        exhibit3.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit3.setExhibitImage(String.valueOf(R.drawable.citati_na_naucnici));
        exhibitsList.add(exhibit3);

        Exhibit exhibit4 = new Exhibit();
        exhibit4.setExibitTitle("Контролна соба");
        exhibit4.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit4.setExhibitImage(String.valueOf(R.drawable.kontrolna_soba));
        exhibitsList.add(exhibit4);

        Exhibit exhibit5 = new Exhibit();
        exhibit5.setExibitTitle("Машинска сала");
        exhibit5.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit5.setExhibitImage(String.valueOf(R.drawable.masinska_sala));
        exhibitsList.add(exhibit5);

        Exhibit exhibit6 = new Exhibit();
        exhibit6.setExibitTitle("Оригинален алат");
        exhibit6.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit6.setExhibitImage(String.valueOf(R.drawable.originalen_alat));
        exhibitsList.add(exhibit6);

        Exhibit exhibit7 = new Exhibit();
        exhibit7.setExibitTitle("Електрификација на Македонија - Тест");
        exhibit7.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit7.setExhibitImage(String.valueOf(R.drawable.elektrifikacija_na_mak_test));
        exhibitsList.add(exhibit7);

        Exhibit exhibit8 = new Exhibit();
        exhibit8.setExibitTitle("Диспечерска табла од седумдесеттите");
        exhibit8.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit8.setExhibitImage(String.valueOf(R.drawable.disprecerska_tabla_od_sedumdesetite));
        exhibitsList.add(exhibit8);

        Exhibit exhibit9 = new Exhibit();
        exhibit9.setExibitTitle("Контролна соба - однадвор");
        exhibit9.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit9.setExhibitImage(String.valueOf(R.drawable.kontrolna_soba_odnadvor));
        exhibitsList.add(exhibit9);

        Exhibit exhibit10 = new Exhibit();
        exhibit10.setExibitTitle("Трансформатор");
        exhibit10.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit10.setExhibitImage(String.valueOf(R.drawable.transformator));
        exhibitsList.add(exhibit10);

        Exhibit exhibit11 = new Exhibit();
        exhibit11.setExibitTitle("Ветерница");
        exhibit11.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibitsList.add(exhibit11);

        Exhibit exhibit12 = new Exhibit();
        exhibit12.setExibitTitle("Макета на систем: производство, пренос, дистрибуција");
        exhibit12.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit12.setExhibitImage(String.valueOf(R.drawable.maketa_na_sistem));
        exhibitsList.add(exhibit12);

        Exhibit exhibit13 = new Exhibit();
        exhibit13.setExibitTitle("Плазма топка");
        exhibit13.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit13.setExhibitImage(String.valueOf(R.drawable.plazma_topka));
        exhibitsList.add(exhibit13);

        Exhibit exhibit14 = new Exhibit();
        exhibit14.setExibitTitle("Плазма панели");
        exhibit14.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit14.setExhibitImage(String.valueOf(R.drawable.plazma_paneli));
        exhibitsList.add(exhibit14);

        Exhibit exhibit15 = new Exhibit();
        exhibit15.setExibitTitle("Трансформатор");
        exhibit15.setExibitDetails("Во поставката на изложбаниот центар можат да се видат оригинални стари предмети, архивски материјали, филмови, фотографии, интервјуа, реални компоненти на електроенергетски сиситем како и уникатни едукативни експонати изработени специјално за центарот и наменети за учење преку интеракција.\n" +
                "\n" +
                "Темите кои ги опфаќаат експонатите се:\n" +
                "\n" +
                "историја на електрификација на Македонија\n" +
                "историја на хидроцентралата Матка\n" +
                "поим за електрицитет и електрична енергија\n" +
                "електро-енергетски систем\n" +
                "обновлива енергија: хидроенергија, соларна енергија, ветер\n" +
                "енергетска ефикасност");
        exhibit15.setExhibitImage(String.valueOf(R.drawable.transformator2));
        exhibitsList.add(exhibit15);


    }


}
