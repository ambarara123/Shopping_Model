package com.android.shopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.shopping.adapter.DataRecyclerAdapter;
import com.android.shopping.adapter.RecyclerAdapter;
import com.android.shopping.database.Database;
import com.android.shopping.database.Entity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddToCartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DataRecyclerAdapter adapter;
    List<Entity> list;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);
        recyclerView = findViewById(R.id.itemRecyclercart);
        database = Database.getInstance(this);
    list = database.dataDao().getFavourite();



        adapter = new DataRecyclerAdapter(list, this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}
