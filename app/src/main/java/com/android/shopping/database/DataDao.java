package com.android.shopping.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface DataDao {
    //getting data list from this
    @Query("SELECT * FROM `table`")
    List<Entity> getFavourite();

    @Insert
    void insert(Entity entity);

    @Delete
    void delete(Entity entity );

    @Update(onConflict = REPLACE)
    void update(Entity entity);

    @Query("DELETE FROM `table` WHERE itemName =:name")
    void deleteByName(String name);
    //get row of name
    @Query("SELECT * FROM `table` WHERE itemName = :name")
    List<Entity> getByName(String name);

    @Query("DELETE FROM `table` WHERE id=:id")
    void deleteById(int id);


}
