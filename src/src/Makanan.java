/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Zorich
 */
public class Makanan extends Barang {
    public Makanan(String kodeBarang, String namaBarang, double hargaBarang, int stokBarang) {
        super(kodeBarang, namaBarang, hargaBarang, stokBarang);
    }

    public String getKategori() {
        return "Makanan";
    }

    public double hitungDiskon(int jumlah) {
        return getHargaBarang() * jumlah * 0.10;
    }
}
