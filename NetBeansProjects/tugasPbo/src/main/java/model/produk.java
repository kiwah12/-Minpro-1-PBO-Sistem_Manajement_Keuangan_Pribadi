/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSI THIN 15
 */
public abstract class produk {
    private String id;
    private String nama;
    private double harga;
    private int stok;

    public produk(String id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public void setHarga(double harga) { this.harga = harga; }
    public void setStok(int stok) { this.stok = stok; }

    public boolean kurangiStok(int jumlah) {
        if (jumlah <= 0 || jumlah > stok) return false;
        stok -= jumlah;
        return true;
    }

    public void tambahStok(int jumlah) {
        if (jumlah > 0) stok += jumlah;
    }

    public abstract String getJenis();

    public void tampilkanInfo() {
        System.out.printf("%-8s %-20s %-12.0f %-8d %-12s%n",
                id, nama, harga, stok, getJenis());
    }
}
 
