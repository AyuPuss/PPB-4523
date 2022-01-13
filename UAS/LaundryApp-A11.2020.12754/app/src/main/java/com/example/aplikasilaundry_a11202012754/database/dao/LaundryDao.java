package com.example.aplikasilaundry_a11202012754.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.aplikasilaundry_a11202012754.ModelLaundry;

import java.util.List;

public abstract class LaundryDao {
    public abstract void insertData(ModelLaundry pengeluaran);

    public abstract LiveData<List<ModelLaundry>> getAll();

    public abstract void deleteSingleData(int uid);


        @Query("SELECT * FROM tbl_laundry")
        LiveData<List<ModelLaundry>> getAll();

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertData(ModelLaundry... modelLaundries);

        @Query("DELETE FROM tbl_laundry WHERE uid= :uid")
        void deleteSingleData(int uid);

    }
