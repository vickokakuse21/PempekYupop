package com.faizal.pempek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdminAddNewProductActivity extends AppCompatActivity {

    private ImageView pempek,tekwan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_product);

        pempek=(ImageView) findViewById(R.id.pic_pempek);
        tekwan=(ImageView) findViewById(R.id.pic_tekwan);

        pempek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminAddNewProductActivity.this,PempekActivity.class);
                startActivity(intent);
            }
        });
        tekwan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminAddNewProductActivity.this,TekwanActivity.class);
                startActivity(intent);
            }
        });
    }
}
