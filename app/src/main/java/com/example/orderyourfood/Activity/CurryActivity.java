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

public class CurryActivity extends AppCompatActivity {
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

        ArrayList<RiceDomain> curryList= new ArrayList<>();

        curryList.add(new RiceDomain("Chicken Curry","cu1","Yummy, spices & chicken.",225.0));
        curryList.add(new RiceDomain("Mix Veg Masala","cu2","vegetables like, potatoes, capsicum, cauliflower, paneer, carrot, peas and beans.",185.0));
        curryList.add(new RiceDomain("Prawns Masala","cu3","prawns, oil, garlic, ginger, chilli powder",220.0));
        curryList.add(new RiceDomain("Butter Chicken","cu4","Yummy, spices & chicken.",195.0));
        curryList.add(new RiceDomain("Kadai Chicken","cu5","A super tasty North Indian Style Chicken curry with a flavor-packed and rich masala. Goes well with rice and roti.",190.0));
        curryList.add(new RiceDomain("Paneer Masala","cu6","Yummy, aromatic, spices, mixed veggies and Panner.",275.0));

        adapter=new RiceAdapter(curryList);
        catlist.setAdapter(adapter);
    }


}