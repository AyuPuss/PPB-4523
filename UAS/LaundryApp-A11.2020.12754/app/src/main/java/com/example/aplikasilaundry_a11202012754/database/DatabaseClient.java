package com.azhar.laundry.database;

import android.content.Context;

import androidx.room.Room;

//

public class DatabaseClient {

    private static DatabaseClient mInstance;
    com.azhar.laundry.database.AppDatabase mAppDatabase;

    private DatabaseClient(Context context) {
        mAppDatabase = Room.databaseBuilder(context, com.azhar.laundry.database.AppDatabase.class, "laundry_db")
                .fallbackToDestructiveMigration()
                .build();
    }

    public static synchronized DatabaseClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(context);
        }
        return mInstance;
    }

    public com.azhar.laundry.database.AppDatabase getAppDatabase() {
        return mAppDatabase;
    }

}
