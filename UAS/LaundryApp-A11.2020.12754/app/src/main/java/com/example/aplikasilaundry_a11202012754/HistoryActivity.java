package com.example.aplikasilaundry_a11202012754;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.MediaRouteButton;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity {
    List<ModelLaundry> modelLaundryList = new ArrayList<>();
    HistoryAdapter historyAdapter;
    LaundryViewModel laundryViewModel;
    RecyclerView History;
    TextView NotFound;
    private MediaRouteButton NotFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        setStatusbar();
        setInitLayout();
        setViewModel();
    }

    private void setContentView(int activity_history) {
    }

    private void setStatusbar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private Window getWindow() {
    }

    private void setInitLayout() {
        History = History.findViewById(R.id.History);
        NotFound = NotFound.findViewById(R.id.NotFound);

        NotFound.setVisibility(View.GONE);

        historyAdapter = new HistoryAdapter(this, modelLaundryList, this);
        History.setHasFixedSize(true);
        History.setLayoutManager(new LinearLayoutManager(this));
        History.setAdapter(historyAdapter);
    }

    private void setViewModel() {
        laundryViewModel = ViewModelProviders.of(this).get(LaundryViewModel.class);
        laundryViewModel.getDataLaundry().observe(this, modelLaundryList -> {
            if (modelLaundryList.size() != 0) {
                historyAdapter.setDataAdapter(modelLaundryList);
            } else {
                NotFound.setVisibility(View.VISIBLE);
                History.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onDelete(ModelLaundry modelLaundry) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Hapus riwayat ini?");
        alertDialogBuilder.setPositiveButton("Ya, Hapus", (dialogInterface, i) -> {
            int uid = modelLaundry.uid;
            laundryViewModel.deleteDataById(uid);
            Toast.makeText(HistoryActivity.this, "Data yang dipilih sudah dihapus", Toast.LENGTH_SHORT).show();
        });

        alertDialogBuilder.setNegativeButton("Batal", (dialogInterface, i) -> dialogInterface.cancel());

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (on) {
            layoutParams.flags |= bits;
        } else {
            layoutParams.flags &= ~bits;
        }
        window.setAttributes(layoutParams);
    }
}
