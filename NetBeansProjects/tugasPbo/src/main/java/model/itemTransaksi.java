/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSI THIN 15
 */
public class itemTransaksi {
    private produk produk;
    private int jumlah;

    public itemTransaksi(produk produk, int jumlah) {
        this.produk = produk;
        this.jumlah = jumlah;
    }

    public produk getProduk() { return produk; }
    public int getJumlah() { return jumlah; }

    public double getSubtotal() {
        return produk.getHarga() * jumlah;
    }
}
