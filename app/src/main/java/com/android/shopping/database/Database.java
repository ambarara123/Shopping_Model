package com.android.shopping.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;
@android.arch.persistence.room.Database(entities = {Entity.class},version = 1,exportSchema = false)
public abstract class Database extends RoomDatabase{

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "data.db";
    private static Database instance;

    public static Database getInstance(Context context) {
        if (instance == null) {
            //only one instance at a time
            synchronized (LOCK) {

                instance = Room.databaseBuilder(context.getApplicationContext(),
                        Database.class,
                        Database.DATABASE_NAME)
                        //just for some operation
                         .allowMainThreadQueries()
                        .build();
            }
        }
        //to know that Database is being instantiating
        Log.d("Database","getting Database instance");

        return instance;
    }

    public abstract DataDao dataDao();

}
