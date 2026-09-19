/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSI THIN 15
 */
public class produkMinuman extends produk {
    private int volumeMl;

    public produkMinuman(String id, String nama, double harga, int stok, int volumeMl) {
        super(id, nama, harga, stok);
        this.volumeMl = volumeMl;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    @Override
    public String getJenis() {
        return "Minuman";
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("         Volume: " + volumeMl + " ml");
    }
}

