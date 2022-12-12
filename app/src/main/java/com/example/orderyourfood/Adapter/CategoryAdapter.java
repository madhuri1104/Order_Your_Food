package com.example.orderyourfood.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.orderyourfood.Activity.BurgerActivity;
import com.example.orderyourfood.Activity.ChickenActivity;
import com.example.orderyourfood.Activity.CurryActivity;
import com.example.orderyourfood.Activity.DrinkActivity;
import com.example.orderyourfood.Activity.IceCreamActivity;
import com.example.orderyourfood.Activity.InsideCategoryActivity;
import com.example.orderyourfood.Activity.PizzaActivity;
import com.example.orderyourfood.Activity.RiceActivity;
import com.example.orderyourfood.Activity.RotiActivity;
import com.example.orderyourfood.Activity.ShowDetailsActivity;
import com.example.orderyourfood.Domain.CategoryDomain;
import com.example.orderyourfood.Domain.FoodDomain;
import com.example.orderyourfood.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
holder.catName.setText(categoryDomains.get(position).getTitle());

String picUrl="";
switch (position){
    case 0:{
        picUrl="cat_1";
        break;
    }
    case 1:{
        picUrl="cat_2";
        break;
    }
    case 2:{
        picUrl="rice";
        break;
    }
    case 3:{
        picUrl="cat_4";
        break;
    }
    case 4:{
        picUrl="icecream";
        break;
    }
    case 5:{
        picUrl="curry";
        break;
    }
    case 6:{
        picUrl="c2";
        break;
    }
    case 7:{
        picUrl="roti";
        break;
    }
}



int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.catImg);

        holder.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(holder.itemView.getContext(), InsideCategoryActivity.class);
//                intent.putExtra("object",categoryDomains.get(position));
//                holder.itemView.getContext().startActivity(intent);

                switch (position) {
                    case 0: {
                        Intent intent=new Intent(holder.itemView.getContext(), PizzaActivity.class);
                        holder.itemView.getContext().startActivity(intent);
                        break;
                    }
                    case 1: {
                        Intent intent=new Intent(holder.itemView.getContext(), BurgerActivity.class);
                        holder.itemView.getContext().startActivity(intent);
                        break;
                    }
                    case 2: {
                        Intent intent=new Intent(holder.itemView.getContext(), RiceActivity.class);
                        holder.itemView.getContext().startActivity(intent);
                        break;
                    }
                    case 3: {
                        Intent intent=new Intent(holder.itemView.getContext(), DrinkActivity.class);
                        holder.itemView.getContext().startActivity(intent);
                        break;
                    }
                    case 4: {
                        Intent intent=new Intent(holder.itemView.getContext(), IceCreamActivity.class);
                        holder.itemView.getContext().startActivity(intent);
                        break;
                    }
                    case 5: {
                        Intent intent=new Intent(holder.itemView.getContext(), CurryActivity.class);
                        holder.itemView.getContext().startActivity(intent);
                        break;
                    }
                    case 6: {
                        Intent intent=new Intent(holder.itemView.getContext(), ChickenActivity.class);
                        holder.itemView.getContext().startActivity(intent);
                        break;
                    }
                    case 7: {
                        Intent intent=new Intent(holder.itemView.getContext(), RotiActivity.class);
                        holder.itemView.getContext().startActivity(intent);
                        break;
                    }
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView catName;
        ImageView catImg;
        ConstraintLayout l;



        public ViewHolder(@NonNull View itemView){
            super(itemView);

            catName=itemView.findViewById(R.id.catName);
            catImg=itemView.findViewById(R.id.catImg);
            l=itemView.findViewById(R.id.mainLayCat);

        }
    }
}

