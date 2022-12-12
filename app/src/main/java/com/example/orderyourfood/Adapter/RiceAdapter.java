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
import com.example.orderyourfood.Activity.Show_Cart_inside_Activity;
import com.example.orderyourfood.Domain.FoodDomain;
import com.example.orderyourfood.Domain.RiceDomain;
import com.example.orderyourfood.R;

import java.util.ArrayList;

public class RiceAdapter extends RecyclerView.Adapter<RiceAdapter.ViewHolder> {

    ArrayList<RiceDomain> RiceDomains;

    public RiceAdapter(ArrayList<RiceDomain> RiceDomains) {

        this.RiceDomains = RiceDomains;
    }

    @NonNull
    @Override
    public RiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_inside_cart,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RiceAdapter.ViewHolder holder, int position) {

        holder.title.setText(RiceDomains.get(position).getTitle());
        holder.fee.setText("Rs."+String.valueOf(RiceDomains.get(position).getFee()));

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(RiceDomains.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

        holder.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(), Show_Cart_inside_Activity.class);
                intent.putExtra("object",RiceDomains.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return RiceDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
       // ImageView addbtn;
        ConstraintLayout l;



        public ViewHolder(@NonNull View itemView){
            super(itemView);

            title=itemView.findViewById(R.id.title_cart_inside);
            pic=itemView.findViewById(R.id.img_cart_inside);
            l=itemView.findViewById(R.id.cart_nside_layout);
            fee=itemView.findViewById(R.id.total_cart_inside);
        }
    }
}

