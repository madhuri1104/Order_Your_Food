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

public class BurgerActivity extends AppCompatActivity {
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

        ArrayList<RiceDomain> burgerList= new ArrayList<>();

        burgerList.add(new RiceDomain("Cheese Burger","burger","beef, Gouda cheese, Special sauce, Lettuce, tomato",80.0));
        burgerList.add(new RiceDomain("Cheddar Cheese Burger","burger_cheddar","Gouda cheese, Special sauce, Lettuce, tomato.",125.0));
        burgerList.add(new RiceDomain("Chicken Burger","burger_chicken","Chicken, Yummy, spicy, delicious, hot.",155.0));
        burgerList.add(new RiceDomain("Fried Meat Burger","burger_fried_meat","Chicken, Yummy, spicy, delicious, hot.",125.0));
        burgerList.add(new RiceDomain("HamBurger","burger_ham","Patty of ground meat, typically beef—placed inside a sliced bun or bread roll.",130.0));
        burgerList.add(new RiceDomain("King Burger","burger_king","juicy flame-grilled beef topped with fresh tomatoes and lettuce, tangy ketchup, crunchy pickles, and sliced white onions on a soft sesame seed bun.",190.0));
        burgerList.add(new RiceDomain("Mega Burger","burger_mega","Juicy flame-grilled beef topped with fresh tomatoes and lettuce,sliced white onions on a soft sesame seed bun",110.0));
        burgerList.add(new RiceDomain("Vegan Burger","burger_vegan","beans, soybeans, tofu, nuts, grains.",140.0));

        adapter=new RiceAdapter(burgerList);
        catlist.setAdapter(adapter);
    }


}