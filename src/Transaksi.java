/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Zorich
 */
public class Transaksi {
    private String namaPelanggan;
    private ArrayList<ItemTransaksi> daftarItem;
    private double uangBayar;

    public Transaksi(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
        this.daftarItem = new ArrayList<>();
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public ArrayList<ItemTransaksi> getDaftarItem() {
        return daftarItem;
    }

    public void setDaftarItem(ArrayList<ItemTransaksi> daftarItem) {
        this.daftarItem = daftarItem;
    }

    public double getUangBayar() {
        return uangBayar;
    }

    public void setUangBayar(double uangBayar) {
        this.uangBayar = uangBayar;
    }

    public void tambahItem(Barang barang, int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah harus lebih dari 0.");
        }
        if (jumlah > barang.getStokBarang()) {
            throw new IllegalArgumentException("Stok barang tidak cukup.");
        }
        daftarItem.add(new ItemTransaksi(barang, jumlah));
    }

    public void selesai() {
        for (ItemTransaksi item : daftarItem) {
            item.getBarang().kurangiStok(item.getJumlah());
        }
    }

    public double getSubtotal() {
        return daftarItem.stream().mapToDouble(ItemTransaksi::getSubtotal).sum();
    }

    public double getTotalDiskon() {
        return daftarItem.stream().mapToDouble(ItemTransaksi::getDiskon).sum();
    }

    public double getPajak() {
        return (getSubtotal() - getTotalDiskon()) * 0.10;
    }

    public double getTotalBayar() {
        return getSubtotal() - getTotalDiskon() + getPajak();
    }

    public double getKembalian() {
        return uangBayar - getTotalBayar();
    }

    public String buatStruk() {
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        StringBuilder struk = new StringBuilder();
        struk.append("FORM TOKO\n");
        struk.append("Struk Pembayaran\n");
        struk.append("Tanggal   : ").append(LocalDateTime.now().format(formatter)).append("\n");
        struk.append("Pelanggan : ").append(namaPelanggan).append("\n");
        struk.append("----------------------------------------\n");
        for (ItemTransaksi item : daftarItem) {
            struk.append(item.getBarang().getNamaBarang()).append("\n");
            struk.append(item.getJumlah()).append(" x ").append(rupiah.format(item.getBarang().getHargaBarang()));
            struk.append(" = ").append(rupiah.format(item.getSubtotal())).append("\n");
            struk.append("Diskon ").append(item.getBarang().getKategori()).append(": ").append(rupiah.format(item.getDiskon())).append("\n");
        }
        struk.append("----------------------------------------\n");
        struk.append("Subtotal : ").append(rupiah.format(getSubtotal())).append("\n");
        struk.append("Diskon   : ").append(rupiah.format(getTotalDiskon())).append("\n");
        struk.append("Pajak    : ").append(rupiah.format(getPajak())).append("\n");
        struk.append("Total    : ").append(rupiah.format(getTotalBayar())).append("\n");
        struk.append("Bayar    : ").append(rupiah.format(uangBayar)).append("\n");
        struk.append("Kembali  : ").append(rupiah.format(getKembalian())).append("\n");
        return struk.toString();
    }
}
