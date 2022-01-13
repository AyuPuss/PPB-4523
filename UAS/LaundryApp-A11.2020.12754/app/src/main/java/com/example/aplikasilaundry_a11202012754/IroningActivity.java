package com.example.aplikasilaundry_a11202012754;

import android.app.Activity;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import im.delight.android.location.SimpleLocation;

public class IroningActivity extends AppCompatActivity {
    public static final String DATA_TITLE = "TITLE";
    int hargaKaos = 3000, hargaCelana = 4000, hargaJaket = 6000, hargaSprei = 0, hargaKarpet = 0;
    int itemCount1 = 0, itemCount2 = 0, itemCount3 = 0;
    int countKaos, countCelana, countJaket, totalItems, totalPrice;
    String strTitle, strCurrentLocation, strCurrentLatLong;
    double strCurrentLatitude;
    double strCurrentLongitude;
    SimpleLocation simpleLocation;
    AddDataViewModel addDataViewModel;
    Button Checkout;
    ImageView imageAdd1, imageAdd2, imageAdd3, imageAdd4, imageAdd5,
            GambarMin1, GambarMin2, GambarMin3, GambarMin4, GambarMin5;
    TextView Title, Info, JumlahBarang, TotalPrice, Kaos, Celana, Jaket, Sprei, Karpet,
                HargaKaos, HargaCelana, HargaJaket, HargaSprei, HargaKarpet;
    private FungctionHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry);

        setLocation();
        setStatusbar();
        setInitLayout();
        setDataKaos();
        setDataCelana();
        setDataJaket();
        setDataSprei();
        setDataKarpet();
        setInputData();
        getCurrentLocation();
    }

    private void setLocation() {
        simpleLocation = new SimpleLocation(this);

        if (!simpleLocation.hasLocationEnabled()) {
            SimpleLocation.openSettings(this);
        }

        //get location
        strCurrentLatitude = simpleLocation.getLongitude();
        strCurrentLongitude = simpleLocation.getLongitude();

        //set location lat long
        strCurrentLatLong = strCurrentLatitude + "," + strCurrentLongitude;
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

    private void setInitLayout() {
        Title = findViewById(R.id.Title);
        Info = findViewById(R.id.Info);

        JumlahBarang = findViewById(R.id.JumlahBarang);
        TotalPrice = findViewById(R.id.TotalPrice);

        Kaos = findViewById(R.id.Kaos);
        Celana = findViewById(R.id.Celana);
        Jaket = findViewById(R.id.Jaket);
        Sprei = findViewById(R.id.Seprei);
        Karpet = findViewById(R.id.Karpet);
        HargaKaos = findViewById(R.id.HargaKaos);
        HargaCelana = findViewById(R.id.HargaCelana);
        HargaJaket = findViewById(R.id.HargaJaket);
        HargaSprei = findViewById(R.id.HargaSprei);
        HargaKarpet = findViewById(R.id.HargaKarpet);

        imageAdd1 = findViewById(R.id.imageAdd1);
        imageAdd2 = findViewById(R.id.imageAdd2);
        imageAdd3 = findViewById(R.id.imageAdd3);
        imageAdd4 = findViewById(R.id.imageAdd4);
        imageAdd5 = findViewById(R.id.imageAdd5);
        GambarMin1 = findViewById(R.id.GambarMin1);
        GambarMin2 = findViewById(R.id.GambarMin2);
        GambarMin3 = findViewById(R.id.GambarMin3);
        GambarMin4 = findViewById(R.id.GambarMin4);
        GambarMin5 = findViewById(R.id.GambarMin5);

        Checkout = findViewById(R.id.CheckOut);

        strTitle = getIntent().getExtras().getString(DATA_TITLE);
        if (strTitle != null) {
            Title.setText(strTitle);
        }

        addDataViewModel = new ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(this.getApplication()))
                .get(AddDataViewModel.class);

        JumlahBarang.setText("0 items");
        TotalPrice.setText("Rp 0");
        Info.setText("Hilangkan kerutan dari pakaian Anda dengan setrika listrik & uap.");
    }

    private void setDataKaos() {
        Kaos.setText(FunctionHelper.rupiahFormat(hargaKaos));
        imageAdd1.setOnClickListener(v -> {
            itemCount1 = itemCount1 + 1;
            HargaKaos.setText(itemCount1);
            countKaos = hargaKaos * itemCount1;
            setTotalPrice();
        });

        GambarMin1.setOnClickListener(v -> {
            if (itemCount1 > 0) {
                itemCount1 = itemCount1 - 1;
                HargaKaos.setText(itemCount1);
            }
            countKaos = hargaKaos * itemCount1;
            setTotalPrice();
        });
    }

    private void setDataCelana() {
        Celana.setText(FunctionHelper.rupiahFormat(hargaCelana));
        imageAdd2.setOnClickListener(v -> {
            itemCount2 = itemCount2 + 1;
            HargaCelana.setText(itemCount2);
            countCelana = hargaCelana * itemCount2;
            setTotalPrice();
        });

        GambarMin2.setOnClickListener(v -> {
            if (itemCount2 > 0) {
                itemCount2 = itemCount2 - 1;
                HargaCelana.setText(itemCount2);
            }
            countCelana = hargaCelana * itemCount2;
            setTotalPrice();
        });
    }

    private void setDataJaket() {
        Jaket.setText(FunctionHelper.rupiahFormat(hargaJaket));
        imageAdd3.setOnClickListener(v -> {
            itemCount3 = itemCount3 + 1;
            HargaJaket.setText(itemCount3);
            countJaket = hargaJaket * itemCount3;
            setTotalPrice();
        });

        GambarMin3.setOnClickListener(v -> {
            if (itemCount3 > 0) {
                itemCount3 = itemCount3 - 1;
                HargaJaket.setText(itemCount3);
            }
            countJaket = hargaJaket * itemCount3;
            setTotalPrice();
        });
    }
    ;
    private void setDataSprei() {
        Sprei.setText(FunctionHelper.rupiahFormat(hargaSprei));
        imageAdd4.setOnClickListener(v -> Toast.makeText(IroningActivity.this, "Layanan tidak tersedia untuk sprei!", Toast.LENGTH_SHORT).show());

        GambarMin4.setOnClickListener(v -> Toast.makeText(IroningActivity.this, "Layanan tidak tersedia untuk sprei!", Toast.LENGTH_SHORT).show());
    }

    private void setDataKarpet() {
        Karpet.setText(FunctionHelper.rupiahFormat(hargaKarpet));
        imageAdd5.setOnClickListener(v -> Toast.makeText(IroningActivity.this, "Layanan tidak tersedia untuk karpet!", Toast.LENGTH_SHORT).show());

        GambarMin5.setOnClickListener(v -> Toast.makeText(IroningActivity.this, "Layanan tidak tersedia untuk karpet!", Toast.LENGTH_SHORT).show());
    }

    private void setTotalPrice() {
        totalItems = itemCount1 + itemCount2 + itemCount3;
        totalPrice = countKaos + countCelana + countJaket;

        JumlahBarang.setText(totalItems + " items");
        TotalPrice.setText(FunctionHelper.rupiahFormat(totalPrice));
    }

    private void getCurrentLocation() {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addressList = geocoder.getFromLocation(strCurrentLatitude, strCurrentLongitude, 1);
            if (addressList != null && addressList.size() > 0) {
                strCurrentLocation = addressList.get(0).getLocality();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setInputData() {
        Checkout.setOnClickListener(v -> {
            if (totalItems == 0 || totalPrice == 0) {
                Toast.makeText(IroningActivity.this, "Harap pilih jenis barang!", Toast.LENGTH_SHORT).show();
            } else {
                addDataViewModel.addDataLaundry(strTitle, totalItems, strCurrentLocation, totalPrice);
                Toast.makeText(IroningActivity.this, "Pesanan Anda sedang diproses, cek di menu riwayat", Toast.LENGTH_SHORT).show();
                finish();
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
}
