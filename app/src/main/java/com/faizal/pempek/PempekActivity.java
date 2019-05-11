package com.faizal.pempek;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.faizal.pempek.Model.Produk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;

public class PempekActivity extends AppCompatActivity {

    private Button AddPempek;
    private EditText  Price, Count;
    private ProgressDialog loadingBar;
    private String key,pempek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pempek);

        AddPempek = findViewById(R.id.pempek_btn);
        Price = findViewById(R.id.price_pempek);
        Count = findViewById(R.id.count_pempek);
        key = "1";
        pempek ="pempek";
        AddPempek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produk produk = new Produk();
                produk.setProduk(pempek);
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
                        Toast.makeText(PempekActivity.this,"data berhasil ditambahkan",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
        }

}
