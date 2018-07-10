package com.android.shopping.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@android.arch.persistence.room.Entity(tableName = "table")
public class Entity {

    @PrimaryKey(autoGenerate = true)
    int id;
    String itemName;

    public Entity(int id, String itemName) {
        this.id = id;
        this.itemName = itemName;
    }
    @Ignore
    public Entity(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
