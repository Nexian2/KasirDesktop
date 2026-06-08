/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Zorich
 */
public class ItemTransaksi {
    private Barang barang;
    private int jumlah;

    public ItemTransaksi(Barang barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getSubtotal() {
        return barang.getHargaBarang() * jumlah;
    }

    public double getDiskon() {
        return barang.hitungDiskon(jumlah);
    }

    public double getTotalSetelahDiskon() {
        return getSubtotal() - getDiskon();
    }
}
