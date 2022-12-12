package com.example.orderyourfood.Adapter;

import android.annotation.SuppressLint;
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
import com.example.orderyourfood.Activity.ShowDetailsActivity;
import com.example.orderyourfood.Domain.FoodDomain;
import com.example.orderyourfood.R;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {

    ArrayList<FoodDomain> FoodDomains;

    public RecommendedAdapter(ArrayList<FoodDomain> FoodDomains) {
        this.FoodDomains = FoodDomains;
    }

    @NonNull
    @Override
    public RecommendedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recommended,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedAdapter.ViewHolder holder, int position) {
holder.title.setText(FoodDomains.get(position).getTitle());
holder.fee.setText("Rs."+String.valueOf(FoodDomains.get(position).getFee()));

int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(FoodDomains.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

     holder.addbtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent=new Intent(holder.itemView.getContext(), ShowDetailsActivity.class);
              intent.putExtra("object",FoodDomains.get(position));
              holder.itemView.getContext().startActivity(intent);
         }
     });
    }

    @Override
    public int getItemCount() {
        return FoodDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
    ImageView addbtn;



        public ViewHolder(@NonNull View itemView){
            super(itemView);

            title=itemView.findViewById(R.id.title_rec);
            pic=itemView.findViewById(R.id.pic);
            addbtn=itemView.findViewById(R.id.addbtn);
            fee=itemView.findViewById(R.id.fee);
        }
    }
}

