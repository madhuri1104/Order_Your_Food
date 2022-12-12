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

public class DrinkActivity extends AppCompatActivity {
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

        ArrayList<RiceDomain> drinkList= new ArrayList<>();

        drinkList.add(new RiceDomain("Red Bull","d1","Caffeine, taurine, glucuronolactone, sucrose and glucose, B-group vitamins, and water, 250ml",99.0));
        drinkList.add(new RiceDomain("Pepsi","d2","250ml, Carbonated Water, Sugar, Colour (Caramel E150d), Acid (Phosphoric Acid),Flavourings (including Caffeine)",40.0));
        drinkList.add(new RiceDomain("Monster","d3","350ml, Carbonated Water, Sucrose, Glucose Syrup, Acid (Citric Acid), Flavourings, Taurine (0.4%), Acidity Regulator (Sodium Citrates), Caffeine (0.03%), Colour (Anthocyanins), Vitamins (B3, B6, B2, B12), Sweetener (Sucralose)",110.0));
        drinkList.add(new RiceDomain("Mocktail","d4","Spicy Watermelon Mint Agua Fresca · Mango Mule · Citrus Fizz · Dry Cranberry Spitzer · Virgin Cucumber Gimlet.",199.0));
        drinkList.add(new RiceDomain("Sprite","d5","750ml, Carbonated Water, Sugar, Acidity Regulators (330, 331), Preservative (211), Contains Added Flavours (Natural Flavouring Substances), Contains no Fruit.",40.0));
        drinkList.add(new RiceDomain("Fanta","d6","Carbonated Water, Grape Juice from Concentrate 3%, Colour (Anthocyanins), Citric Acid, Fruit and Vegetable Concentrate (Apple and Hibiscus),",45.0));
        drinkList.add(new RiceDomain("Falooda","d7","Yummy, mango, sugar, kesar ",75.0));
        drinkList.add(new RiceDomain("Coca Cola","d8","300ml, CARBONATED WATER, HIGH FRUCTOSE CORN SYRUP, CARAMEL COLOR, PHOSPHORIC ACID, NATURAL FLAVORS, CAFFEINE. ",38.0));

        adapter=new RiceAdapter(drinkList);
        catlist.setAdapter(adapter);
    }


}