package com.example.aplikasilaundry_a11202012754;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.aplikasilaundry_a11202012754.database.dao.LaundryDao;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LaundryViewModel {
    LiveData<List<ModelLaundry>> mModelLaundry;
    LaundryDao laundryDao;

    public LaundryViewModel(@NonNull Application application) {
        super(application);

        laundryDao = com.azhar.laundry.database.DatabaseClient.getInstance(application).getAppDatabase().laundryDao();
        mModelLaundry = laundryDao.getAll();
    }

    public LiveData<List<ModelLaundry>> getDataLaundry() {
        return mModelLaundry;
    }

    public void deleteDataById(final int uid) {
        Completable.fromAction(() -> laundryDao.deleteSingleData(uid))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}
