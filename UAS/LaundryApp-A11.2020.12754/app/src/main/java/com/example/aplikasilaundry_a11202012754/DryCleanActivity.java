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

public class DryCleanActivity extends AppCompatActivity {
    public static final String DATA_TITLE = "TITLE";
    int hargaKaos = 8000, hargaCelana = 6000, hargaJaket = 9000, hargaSprei = 65000, hargaKarpet = 200000;
    int itemCount1 = 0, itemCount2 = 0, itemCount3 = 0, itemCount4 = 0, itemCount5 = 0;
    int countKaos, countCelana, countJaket, countSprei, countKarpet, totalItems, totalPrice;
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
    private Activity PriceKaos;
    private FungctionHelper;
    private FungctionHelper;
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
        strCurrentLatitude = simpleLocation.getLatitude();
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
        Title = Title.findViewById(R.id.Title);
        Info = Info.findViewById(R.id.Info);

        JumlahBarang = JumlahBarang.findViewById(R.id.JumlahBarang);
        TotalPrice = TotalPrice.findViewById(R.id.TotalPrice);

        Kaos = Kaos.findViewById(R.id.Kaos);
        Celana = Celana.findViewById(R.id.Celana);
        Jaket = Jaket.findViewById(R.id.Jaket);
        Sprei = Sprei.findViewById(R.id.Seprei);
        Karpet = Karpet.findViewById(R.id.Karpet);
        HargaKaos = HargaKaos.findViewById(R.id.HargaKaos);
        HargaCelana = HargaCelana.findViewById(R.id.HargaCelana);
        HargaJaket = HargaJaket.findViewById(R.id.HargaJaket);
        HargaSprei = HargaSprei.findViewById(R.id.HargaSprei);
        HargaKarpet = HargaKarpet.findViewById(R.id.HargaKarpet);

        imageAdd1 = imageAdd1.findViewById(R.id.imageAdd1);
        imageAdd2 = imageAdd2.findViewById(R.id.imageAdd2);
        imageAdd3 = imageAdd3.findViewById(R.id.imageAdd3);
        imageAdd4 = imageAdd4.findViewById(R.id.imageAdd4);
        imageAdd5 = imageAdd4.findViewById(R.id.imageAdd5);
        GambarMin1 = GambarMin1.findViewById(R.id.GambarMin1);
        GambarMin2 = GambarMin2.findViewById(R.id.GambarMin2);
        GambarMin3 = GambarMin3.findViewById(R.id.GambarMin3);
        GambarMin4 = GambarMin4.findViewById(R.id.GambarMin4);
        GambarMin5 = GambarMin5.findViewById(R.id.GambarMin5);

        Checkout = Checkout.findViewById(R.id.CheckOut);

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
        Info.setText("Cuci kering adalah proses pencucian pakaian menggunakan bahan kimia dan teknik tertentu tanpa air.");
    }

    private void setDataKaos() {
        Kaos.getText(FunctionHelper.rupiahFormat(hargaKaos));
        imageAdd1.setOnClickListener(v -> {
            itemCount1 = itemCount1 + 1;
            PriceKaos.getText(itemCount1);
            countKaos = hargaKaos * itemCount1;
            setTotalPrice();
        });

        GambarMin1.setOnClickListener(v -> {
            if (itemCount1 > 0) {
                itemCount1 = itemCount1 - 1;
                PriceKaos.getText(itemCount1);
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

    private void setDataSprei() {
        Sprei.setText(FunctionHelper.rupiahFormat(hargaSprei));
        imageAdd4.setOnClickListener(v -> {
            itemCount4 = itemCount4 + 1;
            HargaSprei.setText(itemCount4);
            countSprei = hargaSprei * itemCount4;
            setTotalPrice();
        });

        GambarMin4.setOnClickListener(v -> {
            if (itemCount4 > 0) {
                itemCount4 = itemCount4 - 1;
                HargaSprei.setText(itemCount4);
            }
            countSprei = hargaSprei * itemCount4;
            setTotalPrice();
        });
    }

    private void setDataKarpet() {
        Karpet.setText(FunctionHelper.rupiahFormat(hargaKarpet));
        imageAdd5.setOnClickListener(v -> {
            itemCount5 = itemCount5 + 1;
            HargaKarpet.setText(itemCount5);
            countKarpet = hargaKarpet * itemCount5;
            setTotalPrice();
        });

        GambarMin5.setOnClickListener(v -> {
            if (itemCount5 > 0) {
                itemCount5 = itemCount5 - 1;
                HargaKarpet.setText(itemCount5);
            }
            countKarpet = hargaKarpet * itemCount5;
            setTotalPrice();
        });
    }

    private void setTotalPrice() {
        totalItems = itemCount1 + itemCount2 + itemCount3 + itemCount4 + itemCount5;
        totalPrice = countKaos + countCelana + countJaket + countSprei + countKarpet;

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
                Toast.makeText(DryCleanActivity.this, "Harap pilih jenis barang!", Toast.LENGTH_SHORT).show();
            } else {
                addDataViewModel.addDataLaundry(strTitle, totalItems, strCurrentLocation, totalPrice);
                Toast.makeText(DryCleanActivity.this, "Pesanan Anda sedang diproses, cek di menu riwayat", Toast.LENGTH_SHORT).show();
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
