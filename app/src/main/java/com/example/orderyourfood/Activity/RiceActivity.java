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

public class RiceActivity extends AppCompatActivity {
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

        ArrayList<RiceDomain> riceList= new ArrayList<>();

       riceList.add(new RiceDomain("Veg Biryani","r1","Yummy, aromatic rice dish made with basmati rice, spices & mixed veggies.",175.0));
        riceList.add(new RiceDomain("Hyderabadi Biryani","r2","Hyderabadi chicken biryani is an aromatic, mouth watering and authentic Indian dish with succulent chicken in layers of fluffy rice.",175.0));
        riceList.add(new RiceDomain("Chicken Dum Biryani","r3","Yummy, aromatic rice dish made with basmati rice, spicy, grilled, delicious, hot.",175.0));
        riceList.add(new RiceDomain("Mix Veg Biryani","r4","Yummy, aromatic rice dish made with basmati rice, spices & mixed veggies.",175.0));
        riceList.add(new RiceDomain("Paneer Fried Rice","r5","Yummy, aromatic rice dish made with basmati rice, spices , mixed veggies and Panner.",175.0));

        adapter=new RiceAdapter(riceList);
        catlist.setAdapter(adapter);
    }


}