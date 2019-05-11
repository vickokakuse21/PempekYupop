package com.faizal.pempek.Model;

public class Produk {
    private String produk, price, count;

    public Produk(){

    }

    public Produk(String produk, String price, String count) {
        this.produk = produk;
        this.price = price;
        this.count = count;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
