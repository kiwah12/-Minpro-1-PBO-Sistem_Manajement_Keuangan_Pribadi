/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import model.produkMakanan;
import model.produkMinuman;
import java.util.Scanner;
/**
 *
 * @author MSI THIN 15
 */
public class main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        toko toko = new toko("Sistem Manajemen Toko Madura");

        // Data awal
        toko.tambahProduk(new produkMakanan("M001", "Roti Cokelat", 12000, 20, "30-12-2026"));
        toko.tambahProduk(new produkMakanan("M002", "Biskuit", 10000, 15, "15-01-2027"));
        toko.tambahProduk(new produkMinuman("N001", "Air Mineral", 5000, 30, 600));
        toko.tambahProduk(new produkMinuman("N002", "Teh Botol", 7000, 25, 450));

        int pilihan;
        do {
            tampilkanMenu(toko.getNama());
            pilihan = bacaInteger();

            switch (pilihan) {
                case 1 -> toko.tampilkanProduk();
                case 2 -> toko.prosesTransaksi(scanner);
                case 3 -> tambahStok(toko);
                case 4 -> tambahProduk(toko);
                case 0 -> System.out.println("\nTerima kasih telah menggunakan program.");
                default -> System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 0);
    }

    private static void tampilkanMenu(String namaToko) {
        System.out.println("\n====================================");
        System.out.println("       " + namaToko.toUpperCase());
        System.out.println("====================================");
        System.out.println("1. Lihat Daftar Produk");
        System.out.println("2. Transaksi Penjualan");
        System.out.println("3. Tambah Stok");
        System.out.println("4. Tambah Produk");
        System.out.println("0. Keluar");
        System.out.println("====================================");
        System.out.print("Pilih menu: ");
    }

    private static int bacaInteger() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Masukkan angka yang valid: ");
            }
        }
    }

    private static void tambahStok(toko toko) {
        System.out.print("ID Produk: ");
        String id = scanner.nextLine();

        System.out.print("Jumlah stok: ");
        int jumlah = bacaInteger();

        toko.tambahStok(id, jumlah);
    }

    private static void tambahProduk(toko toko) {
        System.out.println("\nJenis produk:");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
        System.out.print("Pilih: ");
        int jenis = bacaInteger();

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Harga: ");
        double harga = bacaDouble();

        System.out.print("Stok: ");
        int stok = bacaInteger();

        if (jenis == 1) {
            System.out.print("Tanggal kedaluwarsa (DD-MM-YYYY): ");
            String tanggal = scanner.nextLine();
            toko.tambahProduk(new produkMakanan(id, nama, harga, stok, tanggal));
            System.out.println("Produk makanan berhasil ditambahkan.");
        } else if (jenis == 2) {
            System.out.print("Volume (ml): ");
            int volume = bacaInteger();
            toko.tambahProduk(new produkMinuman(id, nama, harga, stok, volume));
            System.out.println("Produk minuman berhasil ditambahkan.");
        } else {
            System.out.println("Jenis produk tidak valid.");
        }
    }

    private static double bacaDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Masukkan angka yang valid: ");
            }
        }
    }
}
