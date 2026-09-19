/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import model.produk;
import model.transaksi;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI THIN 15
 */
public class toko {
    private String nama;
    private List<produk> daftarProduk;
    private int nomorTransaksi;

    public toko(String nama) {
        this.nama = nama;
        this.daftarProduk = new ArrayList<>();
        this.nomorTransaksi = 1;
    }

    public String getNama() {
        return nama;
    }

    public void tambahProduk(produk produk) {
        daftarProduk.add(produk);
    }

    public produk cariProduk(String id) {
        for (produk produk : daftarProduk) {
            if (produk.getId().equalsIgnoreCase(id)) {
                return produk;
            }
        }
        return null;
    }

    public void tampilkanProduk() {
        System.out.println("\n================ DAFTAR PRODUK ================");
        System.out.printf("%-8s %-20s %-12s %-8s %-12s%n",
                "ID", "Nama", "Harga", "Stok", "Jenis");
        System.out.println("------------------------------------------------");
        for (produk produk : daftarProduk) {
            produk.tampilkanInfo();
        }
        System.out.println("================================================");
    }

    public void tambahStok(String id, int jumlah) {
        produk produk = cariProduk(id);
        if (produk == null) {
            System.out.println("Produk tidak ditemukan.");
            return;
        }
        produk.tambahStok(jumlah);
        System.out.println("Stok berhasil ditambahkan.");
    }

    public void prosesTransaksi(java.util.Scanner scanner) {
        transaksi transaksi = new transaksi(String.format("TRX%03d", nomorTransaksi));
        System.out.println("\nMasukkan produk yang dibeli. Ketik 'selesai' jika sudah.");

        while (true) {
            System.out.print("ID Produk: ");
            String id = scanner.nextLine().trim();

            if (id.equalsIgnoreCase("selesai")) break;

            produk produk = cariProduk(id);
            if (produk == null) {
                System.out.println("Produk tidak ditemukan.");
                continue;
            }

            System.out.print("Jumlah: ");
            int jumlah = bacaInteger(scanner);

            if (jumlah <= 0) {
                System.out.println("Jumlah harus lebih dari 0.");
                continue;
            }

            if (!produk.kurangiStok(jumlah)) {
                System.out.println("Stok tidak mencukupi.");
                continue;
            }

            transaksi.tambahItem(produk, jumlah);
            System.out.println("Produk ditambahkan ke transaksi.");
        }

        if (transaksi.isKosong()) {
            System.out.println("Transaksi dibatalkan karena belum ada produk.");
            return;
        }

        transaksi.cetakStruk();
        nomorTransaksi++;
    }

    private int bacaInteger(java.util.Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Masukkan angka yang valid: ");
            }
        }
    }
}

