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

public class ChickenActivity extends AppCompatActivity {
    RecyclerView.Adapter adapter;
    private RecyclerView catlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken);
        recyclerCat();
        getSupportActionBar().setTitle("Click on Your Favourite..");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void recyclerCat() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        catlist=findViewById(R.id.chicken_view);
        catlist.setLayoutManager(linearLayoutManager);

        ArrayList<RiceDomain> chickenList= new ArrayList<>();

        chickenList.add(new RiceDomain("Broasted Chicken","c7","Yummy,spices, 12 pieces, crispy, boneless chicken.",115.0));
        chickenList.add(new RiceDomain("Chicken Kebab Plate","c6","Olive oil, spicy, grilled, delicious, hot",170.0));
        chickenList.add(new RiceDomain("Chicken Kebab","c3","Olive oil, spicy, grilled, delicious, hot",250.0));
        chickenList.add(new RiceDomain("Chicken 65","c2","bite size pieces, spicy",185.0));
        chickenList.add(new RiceDomain("Chicken Manchurian","c1","crispy fried chicken, sweet sauce, spicy masala",125.0));
        chickenList.add(new RiceDomain("Chicken Masala","c4","crispy fried chicken, sweet sauce, spicy masala",130.0));

        adapter=new RiceAdapter(chickenList);
        catlist.setAdapter(adapter);
    }


}