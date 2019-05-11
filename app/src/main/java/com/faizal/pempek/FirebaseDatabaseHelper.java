package com.faizal.pempek;

import android.support.annotation.NonNull;

import com.faizal.pempek.Model.Produk;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferencesProduks;
    private List<Produk> produks = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Produk> produks, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper(){
        mDatabase = FirebaseDatabase.getInstance();
        mReferencesProduks = mDatabase.getReference("produks");

    }
    public void readProduks(final DataStatus dataStatus){
        mReferencesProduks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                produks.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Produk produk = keyNode.getValue(Produk.class);
                    produks.add(produk);
                }
                dataStatus.DataIsLoaded(produks,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void addProduk(Produk produk, final DataStatus dataStatus){
        String key = mReferencesProduks.push().getKey();
        mReferencesProduks.child(key).setValue(produk)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsInserted();
                    }
                });
    }
    public void updateProduk(String key, Produk produk, final DataStatus dataStatus){
        mReferencesProduks.child(key).setValue(produk)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsUpdated();
                    }
                });
    }
    public void deleteProduk(String key, final DataStatus dataStatus){
        mReferencesProduks.child(key).setValue(null)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsDeleted();
                    }
                });
    }
}
