README - APLIKASI KASIR 

DESKRIPSI APLIKASI
==========================

Aplikasi Kasir adalah aplikasi desktop berbasis Java yang dibuat untuk membantu proses transaksi penjualan barang pada sebuah toko modern.

Aplikasi ini dapat digunakan untuk mengelola data barang, menampilkan daftar barang, melakukan transaksi pembelian, menghitung total harga, menghitung diskon, serta menampilkan struk pembayaran pelanggan.

Project ini dibuat dengan menerapkan konsep Object Oriented Programming (OOP), yaitu:

1. Enkapsulasi
2. Pewarisan / Inheritance
3. Polimorfisme

Aplikasi ini dibuat dengan menggunakan Java dan dijalankan melalui NetBeans.

FITUR APLIKASI
==================================================

Fitur yang terdapat pada aplikasi ini berupa:

1. Login sederhana pengguna
2. Menu utama aplikasi
3. Input data barang
4. Menampilkan daftar barang
5. Proses transaksi pembelian
6. Perhitungan total harga
7. Perhitungan diskon berdasarkan jenis barang
8. Perhitungan pajak / total pembayaran
9. Cetak atau menampilkan struk pembayaran
10. Penyimpanan data sederhana menggunakan ArrayList
11. Tampilan desktop menggunakan Java Swing


TAMPILAN MENU PADA APLIKASI
==================================================

Aplikasi ini memiliki beberapa tab utama, yaitu:

1. Data Barang
   Digunakan untuk menambahkan, melihat, dan mengelola data barang.

2. Transaksi
   Digunakan untuk melakukan proses pembelian barang oleh pelanggan.

3. Struk
   Digunakan untuk menampilkan hasil transaksi atau struk pembayaran.


PENERAPAN PADA OOP
==================================================

1. Enkapsulasi

Konsep enkapsulasi diterapkan dengan cara membuat atribut pada class menjadi private, kemudian mengaksesnya menggunakan method getter dan setter.

Contoh atribut:

- kodeBarang
- namaBarang
- kategoriBarang
- hargaBarang
- stokBarang

Contoh penerapan:

private String namaBarang;
private double hargaBarang;
private int stokBarang;

public String getNamaBarang() {
    return namaBarang;
}

public void setNamaBarang(String namaBarang) {
    this.namaBarang = namaBarang;
}

2. Pewarisan / Inheritance

Konsep inheritance diterapkan dengan membuat class induk dan class turunan.

Class induk:

- Barang

Class turunan:

- Makanan
- Minuman

Class Makanan dan Minuman mewarisi atribut dan method dari class Barang.

Contoh:

Barang
Berisi
--Makanan
--Minuman

3. Polimorfisme

Konsep polimorfisme diterapkan pada method hitungDiskon().

Setiap class turunan memiliki perhitungan diskon yang berbeda.

Contoh:

- Makanan mendapatkan diskon 10%
- Minuman mendapatkan diskon 5%

Dengan begitu, method yang sama dapat menghasilkan perilaku yang berbeda sesuai dengan objek yang digunakan.


STRUKTUR CLASS
==================================================

Berikut adalah contoh struktur class yang digunakan dalam aplikasi:

1. Barang.java
   Class induk untuk menyimpan data umum barang.

2. Makanan.java
   Class turunan dari Barang untuk kategori makanan.

3. Minuman.java
   Class turunan dari Barang untuk kategori minuman.

4. Transaksi.java
   Class untuk mengelola proses transaksi pembelian barang.

5. Struk.java
   Class untuk menampilkan hasil pembayaran atau struk.

6. Login.java
   Class untuk proses login sederhana pengguna.

7. Main.java / KasirApp.java
   Class utama untuk menjalankan aplikasi.


CONTOH DATA BARANG
==================================================

Beberapa contoh data barang yang digunakan dalam aplikasi:

Kode  : M001
Nama  : Roti Tawar
Kategori : Makanan
Harga : Rp15.000
Stok  : 20

Kode  : M002
Nama  : Biskuit Coklat
Kategori : Makanan
Harga : Rp12.000
Stok  : 25

Kode  : N001
Nama  : Air Mineral
Kategori : Minuman
Harga : Rp4.000
Stok  : 60

Kode  : N002
Nama  : Teh Botol
Kategori : Minuman
Harga : Rp6.000
Stok  : 40


CARA MENJALANKAN APLIKASI INI
==================================================

1. Buka aplikasi NetBeans.
2. Pilih menu File.
3. Pilih Open Project.
4. Cari folder project Aplikasi Kasir Toko Modern.
5. Klik Open Project.
6. Pastikan semua file Java sudah berada di dalam folder src.
7. Jalankan file utama, misalnya Main.java atau KasirApp.java.
8. Klik kanan pada file utama.
9. Pilih Run File.
10. Aplikasi kasir akan terbuka.


CARA MENGGUNAKAN APLIKASI INI
==================================================

1. Jalankan aplikasi melalui NetBeans.
2. Login menggunakan username dan password yang tersedia.
3. Masuk ke menu utama aplikasi.
4. Buka tab Data Barang untuk melihat daftar barang.
5. Tambahkan data barang dengan mengisi:
   - Kode
   - Nama
   - Kategori
   - Harga
   - Stok
6. Klik tombol Tambah Barang untuk menyimpan data.
7. Buka tab Transaksi untuk melakukan pembelian.
8. Pilih barang yang ingin dibeli.
9. Masukkan jumlah pembelian.
10. Sistem akan menghitung total harga.
11. Sistem akan menghitung diskon sesuai kategori barang.
12. Sistem akan menampilkan total pembayaran.
13. Buka tab Struk untuk melihat bukti pembayaran.


KETENTUAN DISKON YANG BERLAKU
==================================================

Diskon pada aplikasi ini menggunakan aturan berikut:

1. Barang kategori Makanan
   Mendapatkan diskon sebesar 10%.

2. Barang kategori Minuman
   Mendapatkan diskon sebesar 5%.

Contoh:

Harga Makanan : Rp15.000
Diskon 10%    : Rp1.500
Total Bayar   : Rp13.500

Harga Minuman : Rp6.000
Diskon 5%     : Rp300
Total Bayar   : Rp5.700


PENYIMPANAN DATA
==================================================

Aplikasi ini menggunakan penyimpanan data sederhana berupa ArrayList.

Data barang yang ditambahkan akan disimpan sementara selama aplikasi berjalan.

Contoh:

ArrayList<Barang> daftarBarang = new ArrayList<>();

Kelebihan penggunaan ArrayList:

1. Mudah digunakan.
2. Cocok untuk project sederhana.
3. Dapat menyimpan banyak objek barang.
4. Sesuai dengan materi dasar Java OOP.

ALAT DAN BAHAN-BAHAN
==================================================

Alat yang digunakan untuk membuat aplikasi ini:

1. Laptop / Komputer
2. NetBeans
3. Java Development Kit / JDK
4. Web Browser
5. Koneksi Internet
6. Akun GitHub

HASIL PROJECT
==================================================
Hasilya
<img width="1091" height="708" alt="image" src="https://github.com/user-attachments/assets/b0c7eddb-f5ee-4878-ad01-93d70d25dc56" />

KESIMPULAN
==================================================

Aplikasi Kasir Toko Modern berhasil dibuat sebagai aplikasi desktop sederhana menggunakan bahasa pemrograman Java.

Aplikasi ini dapat mengelola data barang, menampilkan daftar barang, melakukan transaksi pembelian, menghitung total harga, menghitung diskon, dan menampilkan struk pembayaran.

Melalui project ini, konsep Object Oriented Programming dapat diterapkan dengan baik, terutama pada bagian enkapsulasi, inheritance, dan polimorfisme.

Project ini juga melatih kemampuan dalam membuat aplikasi desktop menggunakan Java Swing, mengatur data menggunakan ArrayList, serta menyusun struktur program agar lebih rapi dan mudah dikembangkan.
