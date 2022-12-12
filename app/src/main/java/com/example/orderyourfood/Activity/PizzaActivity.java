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

public class PizzaActivity extends AppCompatActivity {
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

        ArrayList<RiceDomain> pizzaList= new ArrayList<>();

        pizzaList.add(new RiceDomain("Pepperoni Pizza","pizza1","slices pepperoni, mozzerella cheese, fresh organo, ground black pepper",130.0));
        pizzaList.add(new RiceDomain("Vegetable Pizza","pizza2","Olive oil, Vegetable oil, pitted kalamata, cherry tomato, fresh organo, basil",150.0));
        pizzaList.add(new RiceDomain("Cheese Pizza","cheese_pizza","Yummy,cheesy, spicy, grilled, delicious, hot.",290.0));
        pizzaList.add(new RiceDomain("Olive Mixed Pizza","olive_mixed_pizza","Olive oil, Vegetable oil, pitted kalamata, cherry tomato, fresh organo, basil.",245.0));
        pizzaList.add(new RiceDomain("Sea-Food Pizza","seafood_pizza","Made with seafoods like fish (including salmon, tuna, anchovy), shellfish, clams, scallops, mussels, shrimp, squid lobster and scungilli (sea snail)",195.0));
        pizzaList.add(new RiceDomain("Paneer Pizza","pizza_paneer","Made with  toppings of Paneer (Indian cottage cheese), pizza sauce, mix veggies on a whole wheat crust.",195.0));

        adapter=new RiceAdapter(pizzaList);
        catlist.setAdapter(adapter);
    }


}