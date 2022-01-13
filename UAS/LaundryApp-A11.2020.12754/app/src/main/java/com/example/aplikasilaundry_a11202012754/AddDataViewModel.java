package com.example.aplikasilaundry_a11202012754;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.aplikasilaundry_a11202012754.database.dao.LaundryDao;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AddDataViewModel {
    LaundryDao pengeluaranDao = com.example.aplikasilaundry_a11202012754.database.;

    public AddDataViewModel(@NonNull Application application) {
        super();

        ().().laundryDao();
    }

    public void addDataLaundry(final String nama_jasa, final int items, final String alamat, final int price) {
        Completable.fromAction(() -> {
            ModelLaundry pengeluaran = new ModelLaundry();
            pengeluaran.nama_jasa = nama_jasa;
            pengeluaran.items = items;
            pengeluaran.alamat = alamat;
            pengeluaran.harga = price;
            pengeluaranDao.insertData(pengeluaran);
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}
