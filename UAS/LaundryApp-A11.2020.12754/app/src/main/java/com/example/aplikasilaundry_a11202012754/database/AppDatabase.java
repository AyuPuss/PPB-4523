package com.azhar.laundry.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.aplikasilaundry_a11202012754.database.RoomDatabase;
import com.example.aplikasilaundry_a11202012754.database.dao.LaundryDao;
import com.azhar.laundry.model.ModelLaundry;

@Database(entities = {ModelLaundry.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LaundryDao laundryDao();
}
