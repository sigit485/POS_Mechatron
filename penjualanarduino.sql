-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 18 Mar 2019 pada 17.39
-- Versi Server: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualanarduino`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kd_barang` int(8) NOT NULL,
  `nama_barang` varchar(70) NOT NULL,
  `stok` int(10) NOT NULL,
  `berat` int(8) NOT NULL,
  `deskripsi` varchar(30) NOT NULL,
  `supplier` varchar(15) NOT NULL,
  `harga` int(10) NOT NULL,
  `harga_beli` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kd_barang`, `nama_barang`, `stok`, `berat`, `deskripsi`, `supplier`, `harga`, `harga_beli`) VALUES
(2, 'Lego NXT', 456, 100, 'abc', 'asd', 10000, 5000),
(3, 'bangku', 495, 10, 'wer', 'asd', 10000, 5000),
(1, 'Arduino', 228, 500, 'arduino alat microcontroller', 'tes', 50000, 30000),
(4, 'Kabel Jumper', 100, 500, 'abc', 'Robotik Jakarta', 15000, 10000),
(5, 'Kabel Jumper Male to Female', 100, 500, 'abc', 'Robot', 15000, 10000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', '123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `kd_pelanggan` varchar(15) NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `kontak` varchar(30) NOT NULL,
  `email` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`kd_pelanggan`, `nama_pelanggan`, `kontak`, `email`, `alamat`) VALUES
('01', 'UMUM', '08978181282', 'sadfsadfas', 'sdadad'),
('02', 'Agus', '813', 'agus@gmail.com', 'otista'),
('03', 'Opal', '9932', 'opal@gmail.com', 'jengki'),
('04', 'Sigit', '123', 'asdada', 'sada');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `no_faktur` varchar(20) NOT NULL,
  `tgl_faktur` varchar(20) NOT NULL,
  `pembeli` varchar(20) NOT NULL,
  `kd_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `harga` int(30) NOT NULL,
  `banyak` int(15) NOT NULL,
  `total` int(25) NOT NULL,
  `dibayar` int(25) NOT NULL,
  `uang_kembali` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`no_faktur`, `tgl_faktur`, `pembeli`, `kd_barang`, `nama_barang`, `harga`, `banyak`, `total`, `dibayar`, `uang_kembali`) VALUES
('T0001', '2019-02-18', '', '1', 'sada', 2123131, 1, 1, 1, 1),
('T0002', '2019-02-18', '', '2', 'asda', 241241, 1, 12, 12, 12),
('T0003', '2019-02-18', '', '1', 'sada', 2123131, 1, 1, 1, 1),
('T0004', '2019-02-18', '', '1', 'sada', 2123131, 1, 1, 1, 1),
('T0005', '2019-02-18', 'ssss', '1', 'sada', 2123131, 1, 1, 1, 1),
('T0006', '2019-02-18', 'ssss', '1', 'sada', 2123131, 1, 1, 1, 1),
('T0007', '2019-02-19', 'ssss', '1', 'sada', 2123131, 1, 1, 1, 1),
('T0008', '2019-02-19', 'ssss', '1', 'sada', 2123131, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `kd_supplier` varchar(30) NOT NULL,
  `nama_supplier` varchar(50) NOT NULL,
  `kontak` varchar(50) NOT NULL,
  `email` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`kd_supplier`, `nama_supplier`, `kontak`, `email`, `alamat`) VALUES
('01', 'Robot', '09888767676', 'asasd', 'sadad'),
('02', 'Robot123', '09888566578', 'asasd', 'sadad'),
('03', 'Mikrobot', '21312313', 'asasd', 'sadad');

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_jual`
--

CREATE TABLE `t_jual` (
  `jual_nofa` varchar(15) NOT NULL,
  `jual_tgl` date NOT NULL,
  `jual_pelanggan` varchar(20) NOT NULL,
  `jual_total` int(20) NOT NULL,
  `jual_cash` varchar(15) NOT NULL,
  `jual_kembali` varchar(15) NOT NULL,
  `jual_barangid` varchar(20) NOT NULL,
  `jual_harga` varchar(20) NOT NULL,
  `jual_qty` varchar(20) NOT NULL,
  `jual_subtotal` varchar(20) NOT NULL,
  `jual_nama_barang` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `t_jual`
--

INSERT INTO `t_jual` (`jual_nofa`, `jual_tgl`, `jual_pelanggan`, `jual_total`, `jual_cash`, `jual_kembali`, `jual_barangid`, `jual_harga`, `jual_qty`, `jual_subtotal`, `jual_nama_barang`) VALUES
('19022700002', '2019-02-27', 'Sigit', 50000, '100000', '50000', '1', '50000', '1', '50000', 'Arduino'),
('19030100002', '2019-03-01', 'Agus', 50000, '60000', '10000', '1', '50000', '1', '50000', 'Arduino'),
('19030100003', '2019-03-01', 'aziz', 15000, '16000', '1000', '5', '5000', '1', '5000', 'Baterai'),
('19030100003', '2019-03-01', 'aziz', 15000, '16000', '1000', '2', '10000', '1', '10000', 'Lego NXT'),
('19030700001', '2019-03-07', 'Opal', 50000, '53000', '3000', '3', '10000', '5', '50000', 'bangku'),
('19031400001', '2019-03-14', 'UMUM', 10000, '12000', '2000', '2', '10000', '1', '10000', 'Lego NXT'),
('19031400002', '2019-03-14', 'tessss', 50000, '52000', '2000', '1', '50000', '1', '50000', 'Arduino'),
('19031800001', '2019-03-18', 'UMUM', 110000, '111000', '1000', '1', '50000', '2', '100000', 'Arduino'),
('19031800001', '2019-03-18', 'UMUM', 110000, '111000', '1000', '2', '10000', '1', '10000', 'Lego NXT');

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_pembelian`
--

CREATE TABLE `t_pembelian` (
  `beli_nofa` varchar(15) NOT NULL,
  `beli_tgl` date NOT NULL,
  `beli_pelanggan` varchar(20) NOT NULL,
  `beli_total` int(20) NOT NULL,
  `beli_cash` varchar(15) NOT NULL,
  `beli_kembali` varchar(15) NOT NULL,
  `beli_barangid` varchar(20) NOT NULL,
  `beli_harga` varchar(25) NOT NULL,
  `beli_qty` varchar(25) NOT NULL,
  `beli_subtotal` varchar(25) NOT NULL,
  `beli_nama_barang` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `t_pembelian`
--

INSERT INTO `t_pembelian` (`beli_nofa`, `beli_tgl`, `beli_pelanggan`, `beli_total`, `beli_cash`, `beli_kembali`, `beli_barangid`, `beli_harga`, `beli_qty`, `beli_subtotal`, `beli_nama_barang`) VALUES
('19031400004', '2019-03-14', 'Robot', 30000, '32000', '2000', '1', '30000', '1', '30000', 'Arduino'),
('19031400005', '2019-03-14', 'Robot123', 5000, '10000', '5000', '2', '5000', '1', '5000', 'Lego NXT'),
('19031400008', '2019-03-14', 'Robot', 300000, '400000', '100000', '1', '30000', '10', '300000', 'Arduino');

-- --------------------------------------------------------

--
-- Struktur dari tabel `t_return`
--

CREATE TABLE `t_return` (
  `jual_nofa` varchar(30) NOT NULL,
  `jual_tgl` varchar(20) NOT NULL,
  `jual_pelanggan` varchar(20) NOT NULL,
  `jual_total` int(20) NOT NULL,
  `jual_barangid` varchar(25) NOT NULL,
  `jual_harga` varchar(25) NOT NULL,
  `jual_qty` varchar(25) NOT NULL,
  `jual_subtotal` varchar(20) NOT NULL,
  `jual_nama_barang` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `t_return`
--

INSERT INTO `t_return` (`jual_nofa`, `jual_tgl`, `jual_pelanggan`, `jual_total`, `jual_barangid`, `jual_harga`, `jual_qty`, `jual_subtotal`, `jual_nama_barang`) VALUES
('19022700006', '2019-02-27', 'Sigit', 50000, '1', '50000', '1', '50000', 'Arduino'),
('19022700002', '2019-02-27', 'Sigit', 60000, '1', '50000', '1', '50000', 'Arduino'),
('19022700002', '2019-02-27', 'Sigit', 60000, '2', '10000', '1', '10000', 'Lego NXT'),
('19022800001', '2019-02-28', 'Sigit', 50000, '1', '50000', '1', '50000', 'Arduino'),
('19030700001', '2019-03-07', 'Opal', 20000, '3', '10000', '2', '20000', 'bangku'),
('19031400002', '2019-03-14', 'Sigit', 50000, '1', '50000', '1', '50000', 'Arduino');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
