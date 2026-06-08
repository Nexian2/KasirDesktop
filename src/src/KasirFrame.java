/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author Zorich
 */
public class KasirFrame extends JFrame {
    private final ArrayList<Barang> daftarBarang = new ArrayList<>();
    private final NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    private final DefaultTableModel barangModel = new DefaultTableModel(new String[]{"Kode", "Nama", "Kategori", "Harga", "Stok"}, 0);
    private final DefaultTableModel transaksiModel = new DefaultTableModel(new String[]{"Nama", "Kategori", "Jumlah", "Subtotal", "Diskon"}, 0);
    private final JTable barangTable = new JTable(barangModel);
    private final JTable transaksiTable = new JTable(transaksiModel);
    private final JTextField kodeField = new JTextField();
    private final JTextField namaField = new JTextField();
    private final JTextField hargaField = new JTextField();
    private final JTextField stokField = new JTextField();
    private final JTextField pelangganField = new JTextField("Umum");
    private final JTextField bayarField = new JTextField("0");
    private final JSpinner jumlahSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 999, 1));
    private final JComboBox<String> kategoriBox = new JComboBox<>(new String[]{"Makanan", "Minuman"});
    private final JTextArea strukArea = new JTextArea();
    private Transaksi transaksi = new Transaksi("Umum");

    public KasirFrame() {
        setTitle("Aplikasi Kasir Toko Modern");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1120, 720));
        isiDataAwal();
        setContentPane(buatTampilan());
        tampilkanBarang();
        setLocationRelativeTo(null);
    }

    private JPanel buatTampilan() {
        JPanel root = new JPanel(new BorderLayout(12, 12));
        root.setBorder(new EmptyBorder(12, 12, 12, 12));
        root.setBackground(new Color(238, 238, 238));

        JLabel title = new JLabel("Aplikasi Kasir Toko Modern");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(new Color(28, 28, 28));
        root.add(title, BorderLayout.NORTH);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Data Barang", panelDataBarang());
        tabs.addTab("Transaksi", panelTransaksi());
        tabs.addTab("Struk", panelStruk());
        root.add(tabs, BorderLayout.CENTER);
        return root;
    }

    private JPanel panelDataBarang() {
        JPanel panel = panel(new BorderLayout(10, 10));
        panel.add(new JScrollPane(barangTable), BorderLayout.CENTER);

        JPanel form = new JPanel(new GridLayout(2, 6, 8, 8));
        form.setOpaque(false);
        form.add(label("Kode"));
        form.add(label("Nama"));
        form.add(label("Kategori"));
        form.add(label("Harga"));
        form.add(label("Stok"));
        form.add(new JLabel(""));
        form.add(kodeField);
        form.add(namaField);
        form.add(kategoriBox);
        form.add(hargaField);
        form.add(stokField);
        JButton tambahButton = tombol("Tambah Barang");
        tambahButton.addActionListener(e -> tambahBarang());
        form.add(tambahButton);
        panel.add(form, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel panelTransaksi() {
        JPanel panel = panel(new BorderLayout(10, 10));
        panel.add(new JScrollPane(transaksiTable), BorderLayout.CENTER);

        JPanel kanan = new JPanel(new GridLayout(10, 1, 8, 8));
        kanan.setOpaque(false);
        kanan.setPreferredSize(new Dimension(280, 100));
        kanan.add(label("Pelanggan"));
        kanan.add(pelangganField);
        kanan.add(label("Jumlah Beli"));
        kanan.add(jumlahSpinner);
        JButton tambahButton = tombol("Tambah Ke Transaksi");
        tambahButton.addActionListener(e -> tambahTransaksi());
        kanan.add(tambahButton);
        kanan.add(label("Uang Bayar"));
        kanan.add(bayarField);
        JButton bayarButton = tombol("Proses Pembayaran");
        bayarButton.addActionListener(e -> prosesBayar());
        JButton resetButton = tombol("Transaksi Baru");
        resetButton.addActionListener(e -> resetTransaksi());
        kanan.add(bayarButton);
        kanan.add(resetButton);
        panel.add(kanan, BorderLayout.EAST);
        return panel;
    }

    private JPanel panelStruk() {
        JPanel panel = panel(new BorderLayout(8, 8));
        strukArea.setEditable(false);
        strukArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        strukArea.setText("Struk akan muncul setelah pembayaran diproses.");
        panel.add(new JScrollPane(strukArea), BorderLayout.CENTER);
        return panel;
    }

    private JPanel panel(LayoutManager layout) {
        JPanel panel = new JPanel(layout);
        panel.setBackground(new Color(255, 255, 255, 225));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(190, 190, 190)),
                new EmptyBorder(12, 12, 12, 12)
        ));
        return panel;
    }

    private JLabel label(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        return label;
    }

    private JButton tombol(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBackground(new Color(220, 220, 220));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        return button;
    }

    private void isiDataAwal() {
        daftarBarang.add(new Makanan("M001", "Roti Tawar", 15000, 20));
        daftarBarang.add(new Makanan("M002", "Biskuit Coklat", 12000, 25));
        daftarBarang.add(new Makanan("M003", "Mie Instan", 3500, 80));
        daftarBarang.add(new Minuman("N001", "Air Mineral", 4000, 60));
        daftarBarang.add(new Minuman("N002", "Teh Botol", 6000, 40));
        daftarBarang.add(new Minuman("N003", "Kopi Kaleng", 9000, 35));
    }

    private void tampilkanBarang() {
        barangModel.setRowCount(0);
        for (Barang barang : daftarBarang) {
            barangModel.addRow(new Object[]{
                    barang.getKodeBarang(),
                    barang.getNamaBarang(),
                    barang.getKategori(),
                    rupiah.format(barang.getHargaBarang()),
                    barang.getStokBarang()
            });
        }
    }

    private void tambahBarang() {
        try {
            String kode = kodeField.getText().trim();
            String nama = namaField.getText().trim();
            double harga = Double.parseDouble(hargaField.getText().trim());
            int stok = Integer.parseInt(stokField.getText().trim());
            if (kode.isEmpty() || nama.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kode dan nama barang wajib diisi.");
                return;
            }
            Barang barang = kategoriBox.getSelectedItem().equals("Makanan")
                    ? new Makanan(kode, nama, harga, stok)
                    : new Minuman(kode, nama, harga, stok);
            daftarBarang.add(barang);
            tampilkanBarang();
            kodeField.setText("");
            namaField.setText("");
            hargaField.setText("");
            stokField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Harga dan stok harus berupa angka.");
        }
    }

    private Barang barangTerpilih() {
        int row = barangTable.getSelectedRow();
        if (row < 0) {
            throw new IllegalStateException("Pilih barang dari tabel Data Barang terlebih dahulu.");
        }
        String kode = barangTable.getValueAt(row, 0).toString();
        return daftarBarang.stream()
                .filter(barang -> barang.getKodeBarang().equals(kode))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Barang tidak ditemukan."));
    }

    private void tambahTransaksi() {
        try {
            transaksi.setNamaPelanggan(pelangganField.getText().trim().isEmpty() ? "Umum" : pelangganField.getText().trim());
            Barang barang = barangTerpilih();
            int jumlah = (Integer) jumlahSpinner.getValue();
            transaksi.tambahItem(barang, jumlah);
            transaksiModel.addRow(new Object[]{
                    barang.getNamaBarang(),
                    barang.getKategori(),
                    jumlah,
                    rupiah.format(barang.getHargaBarang() * jumlah),
                    rupiah.format(barang.hitungDiskon(jumlah))
            });
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void prosesBayar() {
        try {
            double bayar = Double.parseDouble(bayarField.getText().trim());
            transaksi.setUangBayar(bayar);
            if (transaksi.getDaftarItem().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Transaksi masih kosong.");
                return;
            }
            if (transaksi.getKembalian() < 0) {
                JOptionPane.showMessageDialog(this, "Uang bayar kurang.");
                return;
            }
            transaksi.selesai();
            strukArea.setText(transaksi.buatStruk());
            tampilkanBarang();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Uang bayar harus berupa angka.");
        }
    }

    private void resetTransaksi() {
        transaksi = new Transaksi("Umum");
        transaksiModel.setRowCount(0);
        bayarField.setText("0");
        strukArea.setText("Struk akan muncul setelah pembayaran diproses.");
    }
}
