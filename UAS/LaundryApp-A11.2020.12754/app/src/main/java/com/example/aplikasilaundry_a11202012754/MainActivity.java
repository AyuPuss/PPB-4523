package com.example.aplikasilaundry_a11202012754;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import im.delight.android.location.SimpleLocation;

public class MainActivity<GoogleMap> extends AppCompatActivity implements {

    int REQ_PERMISSION = 100;
    double strCurrentLattiude;
    double strCurrentLongitude;
    String strCurrentLocation;
    GoogleMap mapsview
    private MainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); setStatusbar();
        setPermission();
        setLocation();
        setInitLayout();
        setMenu();
        getLocationViewModel();
    }

    private void setLocation() {
        SimpleLocation simpleLocation = new SimpleLocation(this);

        if (!simpleLocation.hasLocationEnabled()) {
            SimpleLocation.openSettings(this);
        }

        //get location
        String strCurrentLatitude = simpleLocation.getLatitude();
        strCurrentLongitude = simpleLocation.getLongitude();

        //set location lat long
        strCurrentLocation = strCurrentLatitude + "," + strCurrentLongitude;
    }

    private void setInitLayout() {
        Menu = findViewById(R.id.Menu);
        Rekomendasi = findViewById(R.id.Rekomendasi);
        View layoutHistory = findViewById(R.id.layoutHistory);

        AlertDialog.Builder progressDialog;
        progressDialog.setTitle("Mohon Tunggu…");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("sedang menampilkan lokasi");

        Menu.setLayoutManager(new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false));
        Menu.setHasFixedSize(true);

        MainAdapter mainAdapter = new MainAdapter(this);
        Rekomendasi.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        Rekomendasi.setAdapter(mainAdapter);
        Rekomendasi.setHasFixedSize(true);

        layoutHistory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);
        });
    }

    private void setPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQ_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int grantResult : grantResults) {
            if (grantResult == PackageManager.PERMISSION_GRANTED) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.mapsview = googleMap;

        //viewmodel
        getLocationViewModel();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_PERMISSION && resultCode == RESULT_OK) {

            //load viewmodel
            getLocationViewModel();
        }
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

    private void setMenu() {
        ModelMenu modelMenu = new ModelMenu("Cuci Basah", R.drawable.ic_cuci_basah);
        LayoutInflater modelMenuList;
        modelMenuList.add(modelMenu);
        modelMenu = new ModelMenu("Dry Cleaning", R.drawable.ic_dry_cleaning);
        modelMenuList.add(modelMenu);
        modelMenu = new ModelMenu("Premium Wash", R.drawable.ic_premium_wash);
        modelMenuList.add(modelMenu);
        modelMenu = new ModelMenu("Setrika", R.drawable.ic_setrika);
        modelMenuList.add(modelMenu);

        MenuAdapter menuAdapter = new MenuAdapter(this, modelMenuList);
        Menu.setAdapter(menuAdapter);

        menuAdapter.setOnItemClickListener(modelMenu -> {
            if (modelMenu.getTitle().equals("Cuci Basah")) {
                Intent intent = new Intent(new Intent(MainActivity.this, CuciBasahActivity.class));
                intent.putExtra(CuciBasahActivity.DATA_TITLE, modelMenu.getTitle());
                startActivity(intent);
            } else if (modelMenu.getTitle().equals("Dry Cleaning")) {
                Intent intent = new Intent(new Intent(MainActivity.this, DryCleanActivity.class));
                intent.putExtra(DryCleanActivity.DATA_TITLE, modelMenu.getTitle());
                startActivity(intent);
            } else if (modelMenu.getTitle().equals("Premium Wash")) {
                Intent intent = new Intent(new Intent(MainActivity.this, PremiumWashActivity.class));
                intent.putExtra(PremiumWashActivity.DATA_TITLE, modelMenu.getTitle());
                startActivity(intent);
            } else if (modelMenu.getTitle().equals("Setrika")) {
                Intent intent = new Intent(new Intent(MainActivity.this, IroningActivity.class));
                intent.putExtra(IroningActivity.DATA_TITLE, modelMenu.getTitle());
                startActivity(intent);
            }
        });
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

    private void getLocationViewModel() {
        Object mainViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainViewModel.class);
        mainViewModel.setMarkerLocation(strCurrentLocation);
        progressDialog.show();
        mainViewModel.getMarkerLocation().observe(this, modelResults -> {
            if (modelResults.size() != 0) {
                mainAdapter.setLocationAdapter(modelResults);
                progressDialog.dismiss();
            } else {
                progressDialog.show();
            }
            progressDialog.dismiss();
        });

    }
}