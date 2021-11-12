package com.example.appmenumakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> fotoMakanan = new ArrayList<>();
    private ArrayList<String> namaMakanan = new ArrayList<>();
    private ArrayList<String> infoMakanan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataFromInternet();
    }

    private void prosesRecyclerViewAdapter(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(fotoMakanan, namaMakanan, infoMakanan, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataFromInternet(){
        fotoMakanan.add("https://uprint.id/blog/wp-content/uploads/2016/11/makanan-indonesia-04.jpg");
        namaMakanan.add("Rendang");
        infoMakanan.add("Harga Rp20.000. Kelezatan rendang sudah dikenal dunia. Bahan utama rendang adalah daging. Dimasak dengan aneka bumbu khas Indonesia dan proses memasak suhu rendah dalam waktu lama hingga daging empuk, rasa rendang menjadi tiada duanya. Banyak orang yang langsung ketagihan pada saat pertama kali mereka mencicipi rendang.");

        fotoMakanan.add("https://uprint.id/blog/wp-content/uploads/2016/11/makanan-indonesia-05.jpg");
        namaMakanan.add("Sate Ayam");
        infoMakanan.add("Harga Rp 10.000. Sate atau satai adalah makanan yang terbuat dari daging yang dipotong kecil-kecil dan ditusuk sedemikian rupa dengan tusukan lidi tulang daun kelapa atau bambu, kemudian dipanggang menggunakan bara arang kayu. Sate disajikan dengan berbagai macam bumbu yang bergantung pada variasi resep sate.");

        fotoMakanan.add("https://uprint.id/blog/wp-content/uploads/2016/11/makanan-indonesia-01.jpg");
        namaMakanan.add("Gado-gado");
        infoMakanan.add("Harga Rp 8.000. Gado-gado adalah makanan khas Indonesia yang sehat. Isinya adalah sayur-sayuran. Dicampur dengan bumbu kacang super lezat membuat gado-gado menjadi salah satu makanan berisi sayuran yang paling banyak disukai.");

        fotoMakanan.add("https://uprint.id/blog/wp-content/uploads/2016/11/makanan-indonesia-03.jpg");
        namaMakanan.add("Pempek");
        infoMakanan.add("Harga Rp 12.000. Pempek adalah sebutan untuk makanan ini. Pempek biasanya dimakan menggunakan bumbunya yang terbuat dari cuka yang dicampur dengan gula. Jika gambar makanan di atas sudah mampu membuatmu lapar, maka bayangkan betapa menggiurkan rasanya.");

        fotoMakanan.add("https://uprint.id/blog/wp-content/uploads/2016/11/makanan-indonesia-08.jpg");
        namaMakanan.add("Bakso");
        infoMakanan.add("Harga Rp 10.000. Bakso, si makanan berbentuk bulat ini rasanya sungguh-sungguh lezat. Bakso yang umumnya dikonsumsi adalah bakso sapi dan bakso ikan. Tergantung selera masing-masing, namun menurut kami bakso sapi adalah yang ternikmat.");

        fotoMakanan.add("https://uprint.id/blog/wp-content/uploads/2016/11/Resep-Rawon.jpeg");
        namaMakanan.add("Rawon");
        infoMakanan.add("Harga Rp 8.000. Rawon adalah makanan berkuah hitam pekat yang berasal dari provinsi Jawa Timur. Terbuat dari dua bahan utama, yaitu daging sapi dan kluwek, Rawon paling nikmat disantap hangat-hangat.");

        fotoMakanan.add("https://uprint.id/blog/wp-content/uploads/2016/11/makanan-indonesia-13.jpg");
        namaMakanan.add("Opor Ayam");
        infoMakanan.add("Harga Rp 15.000. Opor ayam merupakan masakan sejenis kari ayam yang sangat dikenal di Indonesia. Opor ayam sebenarnya adalah ayam rebus yang diberi bumbu kental dari santan yang ditambah berbagai bumbu seperti serai, kencur, dan sebagainya.");

        fotoMakanan.add("https://uprint.id/blog/wp-content/uploads/2016/11/soto-ayam-ponorogo.jpeg.600x0_q85_crop-smart_upscale.jpg");
        namaMakanan.add("Soto");
        infoMakanan.add("Harga Rp 8.000. Soto adalah sup tradisional Indonesia yang terutama terdiri dari kaldu, daging, dan sayuran. Banyak sup tradisional disebut soto, sedangkan sup yang dipengaruhi asing dan Barat disebut sop.");

        fotoMakanan.add("https://uprint.id/blog/wp-content/uploads/2016/11/makanan-indonesia-14.jpg");
        namaMakanan.add("Pepes");
        infoMakanan.add("Harga Rp 7.000. Pepes atau Pais merupakan suatu cara memasak khas masyarakat Sunda untuk mengolah bahan makanan dengan bantuan daun pisang untuk membungkus ikan beserta bumbunya. Cara membuatnya adalah bumbu dan rempah dihaluskan dan ditambah daun kemangi, tomat, dan cabai dibalur/dibalut bersama ikan mas yang sudah dibersihkan.");

        fotoMakanan.add("https://uprint.id/blog/wp-content/uploads/2016/11/makanan-indonesia-07.jpg");
        namaMakanan.add("Nasi Goreng");
        infoMakanan.add("Harga Rp 11.000. Nasi goreng adalah sebuah makanan berupa nasi yang digoreng dan diaduk dalam minyak goreng, margarin, atau mentega. Biasanya ditambah kecap manis, bawang merah, bawang putih, asam jawa, lada dan bumbu-bumbu lainnya; seperti telur, ayam, dan kerupuk.");

        prosesRecyclerViewAdapter();

    }
}