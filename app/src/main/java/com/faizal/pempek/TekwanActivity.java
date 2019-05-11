package com.faizal.pempek;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.faizal.pempek.Model.Produk;

import java.util.List;

public class TekwanActivity extends AppCompatActivity {
    private Button AddTekwan;
    private EditText Price, Count;
    private ProgressDialog loadingBar;
    private String key,tekwan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tekwan);
        AddTekwan = findViewById(R.id.tekwan_btn);
        Price = findViewById(R.id.price_tekwan);
        Count = findViewById(R.id.count_tekwan);
        key = "2";
        tekwan ="tekwan";
        AddTekwan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produk produk = new Produk();
                produk.setProduk(tekwan);
                produk.setCount(Count.getText().toString());
                produk.setPrice(Price.getText().toString());
                new FirebaseDatabaseHelper().updateProduk(key, produk, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Produk> produks, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(TekwanActivity.this,"data berhasil ditambahkan",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
    }
}
