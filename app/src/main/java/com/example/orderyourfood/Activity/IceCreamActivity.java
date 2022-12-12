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

public class IceCreamActivity extends AppCompatActivity {
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

        ArrayList<RiceDomain> iceList= new ArrayList<>();

        iceList.add(new RiceDomain("Chocolate Toppings","i1","delicious, decadent, creamy, rich, sweet, and nutritious",100.0));
        iceList.add(new RiceDomain("Vanilla Toppings","i2","delicious, decadent, creamy, rich, sweet, and nutritious",100.0));
        iceList.add(new RiceDomain("Chocolate Cornetto","i3","delicious, decadent, creamy, rich, sweet, and nutritious",45.0));
        iceList.add(new RiceDomain("Mix Flavoured Ice Cream","i4","delicious, decadent, creamy, rich, sweet, and nutritious",60.0));
        iceList.add(new RiceDomain("Strawberry Icecream","i5","delicious, decadent, creamy, rich, sweet, and nutritious",75.0));
        iceList.add(new RiceDomain("Falooda","d7","Yummy, mango, sugar, kesar ",75.0));

        adapter=new RiceAdapter(iceList);
        catlist.setAdapter(adapter);
    }


}