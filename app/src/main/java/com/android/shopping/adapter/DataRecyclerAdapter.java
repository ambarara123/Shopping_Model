package com.android.shopping.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.shopping.R;
import com.android.shopping.database.Database;
import com.android.shopping.database.Entity;

import java.util.ArrayList;
import java.util.List;

public class DataRecyclerAdapter extends RecyclerView.Adapter<DataRecyclerAdapter.ViewHolder> {

    List<Entity> names;
    Context context;

    public DataRecyclerAdapter(List<Entity> name, Context context) {
        this.names = name;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cart_list, parent ,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.itemTextView.setText(names.get(position).getItemName().toString());
        com.android.shopping.database.Entity entity = new com.android.shopping.database.Entity(names.get(position).getItemName());
        holder.cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database database = Database.getInstance(context);
                database.dataDao().deleteById(position);
                Toast.makeText(context, names.get(position).getItemName()+" is removed from cart", Toast.LENGTH_SHORT).show();

                names.remove(position);
                notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemTextView;
        Button cartButton;
        public ViewHolder(View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.itemtextView1);
            cartButton = itemView.findViewById(R.id.itemButton1);
        }

    }
}