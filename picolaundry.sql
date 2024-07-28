-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Jul 2024 pada 18.44
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `picolaundry`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `jurnal`
--

CREATE TABLE `jurnal` (
  `nomor` varchar(60) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` varchar(60) NOT NULL,
  `tipe` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `jurnal`
--

INSERT INTO `jurnal` (`nomor`, `tanggal`, `keterangan`, `tipe`) VALUES
('GK01', '2024-07-12', 'Pembayaran Gaji', 'JKK'),
('JMK11', '2024-07-04', 'Kas', 'JU'),
('JU012', '2024-07-16', 'Pembayaran PT Daia Softener', 'JU'),
('JU1', '2024-07-16', 'Piutang Dagang', 'JU'),
('JU11', '2024-07-04', 'Laporan Akhir Bulan Pico Laundry', 'JU'),
('JU112', '2024-07-16', 'Pembelian Bahan Baku', 'JU'),
('JU912', '2024-07-16', 'Pengambilan Prive', 'JU');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jurnal_detail`
--

CREATE TABLE `jurnal_detail` (
  `id` int(11) NOT NULL,
  `debet` int(20) NOT NULL,
  `kredit` int(20) NOT NULL,
  `perkiraan` varchar(60) NOT NULL,
  `jurnal` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `jurnal_detail`
--

INSERT INTO `jurnal_detail` (`id`, `debet`, `kredit`, `perkiraan`, `jurnal`) VALUES
(1, 250000, 0, '101', 'JU11'),
(2, 650000, 0, '103', 'JU11'),
(3, 0, 900000, '105', 'JU11'),
(4, 32000, 0, '103', 'JMK11'),
(5, 0, 32000, '101', 'JMK11'),
(6, 0, 1600000, '101', 'GK01'),
(7, 1250000, 0, '613', 'GK01'),
(8, 100000, 0, '613', 'GK01'),
(9, 250000, 0, '613', 'GK01'),
(10, 10000, 0, '101', 'JU1'),
(11, 0, 10000, '102', 'JU1'),
(12, 0, 50000, '101', 'JU112'),
(13, 50000, 5000, '102', 'JU112'),
(14, 5000, 0, '106', 'JU112'),
(15, 0, 200000, '101', 'JU012'),
(16, 200000, 0, '102', 'JU012'),
(17, 0, 5000000, '101', 'JU912'),
(18, 5000000, 0, '312', 'JU912');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id` int(11) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `telepon` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id`, `nama`, `alamat`, `telepon`) VALUES
(1, 'Misbakhul Hanif', 'Jl. Raya Ketitang , Kec. Bojong , Kab.Pekalongan Barat', '08659019201'),
(3, 'Elviana Mashitoh', 'Jl.Manunggal Padukuhan Kraton', '085239092200'),
(4, 'Dani Dwi Octaviany', 'Desa Sukorejo, Kec.Pegalongan, Kab. Banyumas', '086572612722');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemesanan`
--

CREATE TABLE `pemesanan` (
  `id_pemesanan` char(11) NOT NULL,
  `pelanggan` varchar(60) NOT NULL,
  `pesanan_masuk` date NOT NULL,
  `pesanan_selesai` date NOT NULL,
  `status_pesanan` varchar(60) NOT NULL,
  `jenis_layanan` varchar(60) NOT NULL,
  `total_biaya` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pemesanan`
--

INSERT INTO `pemesanan` (`id_pemesanan`, `pelanggan`, `pesanan_masuk`, `pesanan_selesai`, `status_pesanan`, `jenis_layanan`, `total_biaya`) VALUES
('F211', 'Misbakhul Hanif', '2024-07-16', '2024-07-16', 'Dikerjakan', 'Express', 200),
('FK01', 'Misbakhul Hanif', '2024-06-21', '2024-06-22', 'Selesai', 'One Day', 5000),
('FK0123', 'Dani Dwi', '2024-06-28', '2024-06-28', 'Selesai', 'Express', 200),
('FK02', 'Misbakhul Hanif', '2024-06-21', '2024-06-21', 'Selesai', 'Express', 4000),
('FK021', 'Misbakhul Hanif', '2024-06-28', '2024-06-28', 'Selesai', 'Express', 20000),
('FK0211', 'Dani Dwi Octaviany', '2024-07-16', '2024-07-16', 'Dikerjakan', 'Express', 20000),
('FK02113', 'Elviana Mashitoh', '2024-07-16', '2024-07-16', 'Dikerjakan', 'Express', 2000),
('FK0212', 'Dani Dwi Octaviany', '2024-07-16', '2024-07-16', 'Dikerjakan', 'Express', 2000),
('FK0291', 'Misbakhul Hanif', '2024-07-16', '2024-07-16', 'Dikerjakan', 'Express', 2000),
('FK1255', 'Elviana Mashitoh', '2024-07-16', '2024-07-16', 'Dikerjakan', 'Express', 100),
('FK225', 'Dani Dwi Octaviany', '2024-07-16', '2024-07-16', 'Dikerjakan', 'Express', 4600),
('FK919', 'Danang', '2024-06-28', '2024-06-28', 'Selesai', 'Express', 4300),
('FK921', 'IPAN', '2024-06-28', '2024-06-28', 'Selesai', 'Express', 2300),
('FR21', 'SAD', '2024-06-28', '2024-06-28', 'Selesai', 'Express', 100),
('SDS22', 'SAD', '2024-06-28', '2024-06-28', 'Selesai', 'Express', 2200);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemesanan_detail`
--

CREATE TABLE `pemesanan_detail` (
  `id` int(11) NOT NULL,
  `id_pemesanan` char(11) NOT NULL,
  `item` varchar(60) NOT NULL,
  `jumlah` int(20) NOT NULL,
  `harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pemesanan_detail`
--

INSERT INTO `pemesanan_detail` (`id`, `id_pemesanan`, `item`, `jumlah`, `harga`) VALUES
(1, 'FK01', 'Jaket', 1, 1000),
(2, 'FK01', 'Dress', 1, 2000),
(3, 'FK01', 'Cutbray', 1, 2000),
(4, 'FK02', 'Jaket', 1, 1000),
(5, 'FK02', 'Celana Jeans', 1, 3000),
(6, 'FK0123', 'Jaket', 1, 200),
(7, 'FK921', 'SA', 1, 200),
(8, 'FK921', 'SASD', 1, 2100),
(9, 'FK919', 'SA', 1, 200),
(10, 'FK919', 'SASD', 1, 2100),
(11, 'FK919', 'ads', 2, 2000),
(12, 'FK021', 'Baju', 1, 20000),
(13, 'FR21', 'ASDA', 1, 100),
(14, 'SDS22', 'ASDA', 1, 2200),
(15, 'FK0291', 'Jaket', 1, 2000),
(16, 'FK0211', 'Jaket', 1, 20000),
(17, 'FK02113', 'Hoodie', 1, 2000),
(18, 'FK0212', 'Jaket', 2, 2000),
(19, 'F211', 'SDS', 1, 200),
(20, 'FK1255', 'SDA', 1, 100),
(21, 'FK225', 'SAD', 1, 100),
(22, 'FK225', 'SADAS', 1, 2000),
(23, 'FK225', 'ASXDSA', 1, 1000),
(24, 'FK225', 'ASDSD', 1, 200),
(25, 'FK225', 'SD', 1, 300),
(26, 'FK225', 'ASDX', 1, 1000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `penerimaan`
--

CREATE TABLE `penerimaan` (
  `nomor` char(15) NOT NULL,
  `tanggal` date NOT NULL,
  `pembayaran_dari` varchar(100) NOT NULL,
  `keterangan` varchar(100) NOT NULL,
  `jumlah_dibayarkan` int(20) NOT NULL,
  `sub_total` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `penerimaan`
--

INSERT INTO `penerimaan` (`nomor`, `tanggal`, `pembayaran_dari`, `keterangan`, `jumlah_dibayarkan`, `sub_total`) VALUES
('FK-01', '2024-06-21', 'Elviana Mashitoh', 'Bayar', 3000, 3000),
('FK01', '2024-06-28', 'Misbakhul Hanif', 'Bayar', 5000, 5000),
('FK0123', '2024-06-28', 'Dani Dwi', 'Pelunasan ', 200, 200),
('FK02', '2024-06-28', 'Misbakhul Hanif', 'Pembayaran', 0, 0),
('FK021', '2024-06-28', 'Misbakhul Hanif', 'test', 20000, 20000),
('FK919', '2024-06-28', 'Danang', 'bayar', 4300, 4300),
('FK921', '2024-06-28', 'IPAN', 'asd', 0, 0),
('FR21', '2024-06-28', 'SAD', 'SA', 100, 100),
('SDS22', '2024-06-28', 'SAD', 'ASDSD', 2200, 2200);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran`
--

CREATE TABLE `pengeluaran` (
  `nomor` char(20) NOT NULL,
  `tanggal` date NOT NULL,
  `catatan` varchar(200) NOT NULL,
  `rekanan` varchar(60) NOT NULL,
  `perkiraan_kas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pengeluaran`
--

INSERT INTO `pengeluaran` (`nomor`, `tanggal`, `catatan`, `rekanan`, `perkiraan_kas`) VALUES
('GK01', '2024-07-12', 'Pembayaran Gaji', 'Dandi', '101');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran_detail`
--

CREATE TABLE `pengeluaran_detail` (
  `id` int(11) NOT NULL,
  `keterangan` varchar(500) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `perkiraan_beban` varchar(20) NOT NULL,
  `kas_keluar` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pengeluaran_detail`
--

INSERT INTO `pengeluaran_detail` (`id`, `keterangan`, `jumlah`, `perkiraan_beban`, `kas_keluar`) VALUES
(1, 'Gaji Pokok', 1250000, '613', 'GK01'),
(2, 'Upah Lembur', 100000, '613', 'GK01'),
(3, 'Uang Transport', 250000, '613', 'GK01');

-- --------------------------------------------------------

--
-- Struktur dari tabel `perkiraan`
--

CREATE TABLE `perkiraan` (
  `kode` int(11) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `tipe` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `perkiraan`
--

INSERT INTO `perkiraan` (`kode`, `nama`, `tipe`) VALUES
(101, 'Kas', 'Kas atau bank'),
(102, 'Persediaan Barang Dagang', 'Kas atau bank'),
(103, 'Piutang Usaha', 'Kas atau bank'),
(104, 'Penyisihan Piutang Usaha', 'Kas atau bank'),
(105, 'Wesel Tagih', 'Kas atau bank'),
(106, 'Perlengkapan', 'Kas atau bank'),
(107, 'Iklan dibayar dimuka', 'Kas atau bank'),
(108, 'Sewa dibayar dimuka', 'Kas atau bank'),
(109, 'Asuransi dibayar dimuka', 'Kas atau bank'),
(111, 'Persekot Asuransi', 'Harta lancar lainnya'),
(112, 'Persekot Lainya', 'Harta lancar lainnya'),
(113, 'Persekot Iklan', 'Harta lancar lainnya'),
(121, 'Peralatan', 'Harta tetap'),
(122, 'Akm. Peny. Peralatan', 'Harta tetap'),
(123, 'Gedung', 'Harta tetap'),
(124, 'Akm.Peny.Gedung', 'Harta tetap'),
(125, 'Kendaraan', 'Harta tetap'),
(126, 'Akm.Peny.Kendaraan', 'Harta tetap'),
(211, 'Hutang Usaha', 'Hutang usaha'),
(212, 'Hutang Gaji', 'Hutang usaha'),
(213, 'Hutang PPh', 'Hutang usaha'),
(214, 'Hutang Obligasi', 'Hutang usaha'),
(311, 'Modal', 'Modal'),
(312, 'Prive', 'Modal'),
(411, 'Penjualan', 'Pendapatan'),
(412, 'Retur Penjualan', 'Pendapatan'),
(413, 'Potongan Penjualan', 'Pendapatan'),
(611, 'Beban Usaha', 'Beban'),
(612, 'Beban Listrik', 'Beban'),
(613, 'Beban Gaji Karyawan', 'Beban');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rekanans`
--

CREATE TABLE `rekanans` (
  `kode` char(5) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `alamat` varchar(70) NOT NULL,
  `telepon` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `rekanans`
--

INSERT INTO `rekanans` (`kode`, `nama`, `alamat`, `telepon`) VALUES
('K01', 'Dandi', 'Ketingan', '01234567897');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `username` varchar(60) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('admin', '21232f297a57a5a743894a0e4a801fc3'),
('hanif@picolaundry.com', 'da40526f219afb8a602e12c727aed58d'),
('hanifadmin', '0192023a7bbd73250516f069df18b500'),
('hanifadmin@pico', '827ccb0eea8a706c4c34a16891f84e7b');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `jurnal`
--
ALTER TABLE `jurnal`
  ADD PRIMARY KEY (`nomor`);

--
-- Indeks untuk tabel `jurnal_detail`
--
ALTER TABLE `jurnal_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`id_pemesanan`);

--
-- Indeks untuk tabel `pemesanan_detail`
--
ALTER TABLE `pemesanan_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `penerimaan`
--
ALTER TABLE `penerimaan`
  ADD PRIMARY KEY (`nomor`);

--
-- Indeks untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD PRIMARY KEY (`nomor`);

--
-- Indeks untuk tabel `pengeluaran_detail`
--
ALTER TABLE `pengeluaran_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `perkiraan`
--
ALTER TABLE `perkiraan`
  ADD PRIMARY KEY (`kode`);

--
-- Indeks untuk tabel `rekanans`
--
ALTER TABLE `rekanans`
  ADD PRIMARY KEY (`kode`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `jurnal_detail`
--
ALTER TABLE `jurnal_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT untuk tabel `pemesanan_detail`
--
ALTER TABLE `pemesanan_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT untuk tabel `pengeluaran_detail`
--
ALTER TABLE `pengeluaran_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
