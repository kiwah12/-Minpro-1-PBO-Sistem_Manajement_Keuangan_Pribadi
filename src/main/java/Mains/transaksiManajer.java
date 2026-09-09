/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mains;
import Mains.Transaksi;
import java.util.ArrayList;
/**
 *
 * @author MSI THIN 15
 */
public class transaksiManajer {
private ArrayList<Transaksi> daftarTransaksi;
    private int idCounter;
 
    public transaksiManajer () {
        this.daftarTransaksi = new ArrayList<>();
        this.idCounter = 1;
    }
 
    public void tambahTransaksi(String tanggal, String jenis, String kategori, double jumlah) {
        Transaksi t = new Transaksi(idCounter, tanggal, jenis,kategori, jumlah);
        daftarTransaksi.add(t);
        idCounter++;
        System.out.println(">> Transaksi berhasil ditambahkan.");
    }
 
public void tampilkanSemuaTransaksi() {

    if (daftarTransaksi.isEmpty()) {
        System.out.println(">> Belum ada data transaksi.");
        return;
    }

    System.out.println("=====================================================================");
    System.out.printf("%-4s %-12s %-12s %-15s %s%n",
            "ID", "Tanggal", "Jenis", "Kategori", "Jumlah");
    System.out.println("=====================================================================");

    for (Transaksi t : daftarTransaksi) {
        System.out.println(t);
    }

    System.out.println("=====================================================================");

    double pemasukan = hitungTotalPemasukan();
    double pengeluaran = hitungTotalPengeluaran();
    double saldo = hitungSaldo();

    System.out.printf("Total Pemasukan   : Rp%,.2f%n", pemasukan);
    System.out.printf("Total Pengeluaran : Rp%,.2f%n", pengeluaran);
    System.out.println("---------------------------------------------");
    System.out.printf("Saldo Akhir       : Rp%,.2f%n", saldo);

    System.out.println("=====================================================================");
}
    // Mencari transaksi berdasarkan ID
    public Transaksi cariTransaksi(int id) {
        for (Transaksi t : daftarTransaksi) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public double hitungTotalPemasukan() {
        double total = 0;
        for (Transaksi t : daftarTransaksi) {
            if (t.getJenis().equalsIgnoreCase("Pemasukan")) {
                total += t.getJumlah();
            }
        }
        return total;
    }
 
    public double hitungTotalPengeluaran() {
        double total = 0;
        for (Transaksi t : daftarTransaksi) {
            if (t.getJenis().equalsIgnoreCase("Pengeluaran")) {
                total += t.getJumlah();
            }
        }
        return total;
    }
 
    public double hitungSaldo() {
        return hitungTotalPemasukan() - hitungTotalPengeluaran();
    }
 
    public ArrayList<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }
}
