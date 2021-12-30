package com.example.mylbs_vidio13;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mylbs_vidio13.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, AdapterView.OnItemSelectedListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    public static final String nama_pulau[] ={"Pilih pulau","Sumatra","Jawa","Kalimantan","Sulawesi","Bali"};
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);

        spinner=findViewById(R.id.pilihpulau);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,nama_pulau);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }
    @Override
    public void onItemSelected(AdapterView<?> paarent, View view, int position, long id){
        double latitude,longitude;

        switch (position)
        {
            case 0:
                mMap.clear();
                break;
            case 1:
                mMap.clear();
                // Sumatra
                LatLng aceh = new LatLng(5.5951474, 95.3833878);
                mMap.addMarker(new MarkerOptions().position(aceh).title("NAD"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(aceh));

                LatLng medan = new LatLng(3.6405366, 98.5307445);
                mMap.addMarker(new MarkerOptions().position(medan).title("MEDAN"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(medan));

                LatLng padang = new LatLng(-0.9342375, 100.2511803);
                mMap.addMarker(new MarkerOptions().position(padang).title("PADANG"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(padang));

                LatLng palembang = new LatLng(-2.9547949, 104.6929233);
                mMap.addMarker(new MarkerOptions().position(palembang).title("PALEMBANG"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(palembang));
                break;
            case 2:
                mMap.clear();
                // Jawa
                LatLng surabaya = new LatLng(-7.2982391, 112.6679387);
                mMap.addMarker(new MarkerOptions().position(surabaya).title("SURABAYA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(surabaya));

                LatLng semarang = new LatLng(-7.0245542, 110.347024);
                mMap.addMarker(new MarkerOptions().position(semarang).title("SEMARANG"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(semarang));

                LatLng bandung = new LatLng(-6.9032739, 107.5731163);
                mMap.addMarker(new MarkerOptions().position(bandung).title("BANDUNG"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(bandung));

                LatLng jakarta = new LatLng(-6.229728, 106.6894271);
                mMap.addMarker(new MarkerOptions().position(jakarta).title("JAKARTA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(jakarta));

                LatLng jogja = new LatLng(-7.803249, 110.3398251);
                mMap.addMarker(new MarkerOptions().position(jogja).title("JOGJA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(jogja));
                break;
            case 3:
                mMap.clear();
                // Kalimanatan
                LatLng pontianak = new LatLng(-0.0398506, 109.2973554);
                mMap.addMarker(new MarkerOptions().position(pontianak).title("PONTIANAK"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(pontianak));

                LatLng palangkaraya = new LatLng(-2.2096162, 113.8666453);
                mMap.addMarker(new MarkerOptions().position(palangkaraya).title("PALANGKARAYA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(palangkaraya));

                LatLng banjarmasin = new LatLng(-3.4226849, 114.7517007);
                mMap.addMarker(new MarkerOptions().position(banjarmasin).title("BANJARMASIN"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(banjarmasin));

                LatLng balikpapan = new LatLng(-1.1742562, 116.7016585);
                mMap.addMarker(new MarkerOptions().position(balikpapan).title("BALIKPAPAN"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(balikpapan));
                break;
            case 4:
                mMap.clear();
                // Sulawesi
                LatLng makasar = new LatLng(-5.1111323, 119.2625381);
                mMap.addMarker(new MarkerOptions().position(makasar).title("MAKASAR"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(makasar));

                LatLng palu = new LatLng(-0.7892164, 119.7591844);
                mMap.addMarker(new MarkerOptions().position(palu).title("PALU"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(palu));

                LatLng gorontalo = new LatLng(0.5490078, 123.0050008);
                mMap.addMarker(new MarkerOptions().position(gorontalo).title("GORONTALO"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(gorontalo));

                LatLng manado = new LatLng(1.5411542, 124.6443969);
                mMap.addMarker(new MarkerOptions().position(manado).title("MANADO"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(manado));
                break;
            case 5:
                mMap.clear();
                // Bali
                LatLng denpasar = new LatLng(-8.6726769, 115.1542316);
                mMap.addMarker(new MarkerOptions().position(denpasar).title("DENPASAR"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(denpasar));

                LatLng buleleng = new LatLng(-8.2223736, 114.6644399);
                mMap.addMarker(new MarkerOptions().position(buleleng).title("BULELENG"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(buleleng));
            default:
                Toast.makeText(this, "pilihan tidak ada", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}