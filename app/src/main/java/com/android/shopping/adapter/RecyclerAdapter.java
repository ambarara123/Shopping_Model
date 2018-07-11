package com.android.shopping.adapter;

import android.content.Context;
import android.content.Entity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.shopping.Fragment.FashionFragment;
import com.android.shopping.R;
import com.android.shopping.database.Database;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<String> names;
    Context context;

    public RecyclerAdapter(ArrayList<String> name, Context context) {
        this.names = name;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list, parent ,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Database database = Database.getInstance(context);
        holder.itemTextView.setText(names.get(position));
        if (database.dataDao().getByName(names.get(position)).isEmpty()) {
            holder.cartButton.setText("Add to Cart");
        }else {
            holder.cartButton.setText("Added to cart");
        }
        final com.android.shopping.database.Entity entity = new com.android.shopping.database.Entity(names.get(position));
        holder.cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (database.dataDao().getByName(names.get(position)).isEmpty()) {
                    database.dataDao().insert(entity);
                    holder.cartButton.setText("Added to cart");
                    Toast.makeText(context, names.get(position) + " is added to cart", Toast.LENGTH_SHORT).show();
                }else {
                    holder.cartButton.setText("Added to cart");
                    Toast.makeText(context, "Already in cart", Toast.LENGTH_SHORT).show();
                }
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
            itemTextView = itemView.findViewById(R.id.itemtextView);
            cartButton = itemView.findViewById(R.id.itemButton);
        }
    }
}
