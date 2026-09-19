/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSI THIN 15
 */
public class produkMakanan extends produk {
    private String tanggalKedaluwarsa;

    public produkMakanan(String id, String nama, double harga, int stok, String tanggalKedaluwarsa) {
        super(id, nama, harga, stok);
        this.tanggalKedaluwarsa = tanggalKedaluwarsa;
    }

    public String getTanggalKedaluwarsa() {
        return tanggalKedaluwarsa;
    }

    @Override
    public String getJenis() {
        return "Makanan";
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("         Kedaluwarsa: " + tanggalKedaluwarsa);
    }
}
