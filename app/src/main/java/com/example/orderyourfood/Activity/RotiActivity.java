package com.example.orderyourfood.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.orderyourfood.Adapter.RiceAdapter;
import com.example.orderyourfood.Domain.CategoryDomain;
import com.example.orderyourfood.Domain.RiceDomain;
import com.example.orderyourfood.R;

import java.util.ArrayList;

public class RotiActivity extends AppCompatActivity {
    RecyclerView.Adapter adapter;
    private RecyclerView catlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice);
        recyclerCat();
        getSupportActionBar().setTitle("Click on Your Favourite..");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void recyclerCat() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        catlist=findViewById(R.id.rice_view);
        catlist.setLayoutManager(linearLayoutManager);

        ArrayList<RiceDomain> rotiList= new ArrayList<>();

        rotiList.add(new RiceDomain("Roti","roti","",15.0));
        rotiList.add(new RiceDomain("Butter Roti","butter_roti","",25.0));
        rotiList.add(new RiceDomain("Bhakari","bhakari","",30.0));
        rotiList.add(new RiceDomain("Naan","naan","",20.0));
        rotiList.add(new RiceDomain("Chapati","chapati","",25.0));

        adapter=new RiceAdapter(rotiList);
        catlist.setAdapter(adapter);
    }


}