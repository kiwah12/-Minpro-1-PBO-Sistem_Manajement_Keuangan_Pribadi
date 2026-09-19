/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI THIN 15
 */
public class transaksi {
    private String idTransaksi;
    private List<itemTransaksi> items;

    public transaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
        this.items = new ArrayList<>();
    }

    public void tambahItem(produk produk, int jumlah) {
        items.add(new itemTransaksi(produk, jumlah));
    }

    public double getTotal() {
        double total = 0;
        for (itemTransaksi item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public boolean isKosong() {
        return items.isEmpty();
    }

    public void cetakStruk() {
        System.out.println("\n========== STRUK TRANSAKSI ==========");
        System.out.println("ID Transaksi : " + idTransaksi);
        System.out.println("-------------------------------------");

        for (itemTransaksi item : items) {
            System.out.printf("%-18s x%-3d %10.0f%n",
                    item.getProduk().getNama(),
                    item.getJumlah(),
                    item.getSubtotal());
        }

        System.out.println("-------------------------------------");
        System.out.printf("TOTAL          : Rp%,.0f%n", getTotal());
        System.out.println("=====================================");
    }
}
