package com.example.tampillistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.UiAutomation;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BantuDatabase db;
    public static ListView listView;
    public static EditText editText;
    Button tblTambah;

    ArrayAdapter adapter;
    ArrayList<String> listviewku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listdatabuah);
        editText=findViewById(R.id.databuah);
        tblTambah=findViewById(R.id.tbltambah);
        db=new BantuDatabase(this);

        listviewku=new ArrayList<>();
        tampilkan_buah();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String noid=listviewku.get(i);
                final String nomor=noid.substring(0,2);
                editText.setText(nomor.toString());
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Perhatian !")
                        .setTitle("Yakin ingin menghapus data ini?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                db.hapusRecord(Integer.parseInt(nomor));
                                listviewku.remove(i);
                                listView.invalidateViews();

                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return false;
            }
        });
        tblTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.tambahData(editText.getText().toString());
                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                listviewku.clear();
                tampilkan_buah();
            }
        });

    }

    private void tampilkan_buah() {
        Cursor cursor=db.tampilBuah();
        if (cursor.getCount()==0)
        {
            Toast.makeText(MainActivity.this, "Record Kosong Coy", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext())
            {
                listviewku.add(String.valueOf(cursor.getInt(0))+" "+cursor getString(1));
            }
            adapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,listviewku);
            listView.setAdapter(adapter);
        }
    }
}