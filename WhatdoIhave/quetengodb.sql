-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 18, 2021 at 10:58 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quetengodb`
--
CREATE DATABASE IF NOT EXISTS `quetengodb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `quetengodb`;

-- --------------------------------------------------------

--
-- Table structure for table `quetengotable`
--

CREATE TABLE `quetengotable` (
  `id` int(4) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cantidad` int(2) NOT NULL,
  `lugar` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `quetengotable`
--

INSERT INTO `quetengotable` (`id`, `nombre`, `cantidad`, `lugar`) VALUES
(1, 'pollo', 1, 'nevera'),
(2, 'cerdo', 1, 'nevera'),
(3, 'lechuga', 1, 'nevera'),
(4, 'tomate', 1, 'nevera'),
(5, 'huevo', 12, 'nevera'),
(6, 'queso', 1, 'nevera'),
(7, 'jamón', 1, 'nevera'),
(8, 'aguacate', 1, 'nevera'),
(9, 'avena', 1, 'nevera'),
(10, 'lechuga', 1, 'nevera'),
(11, 'gyozas', 1, 'congelador'),
(23, 'salmorejo', 1, 'nevera'),
(25, 'salsa barbacoa', 1, 'nevera'),
(26, 'salsa césar', 1, 'nevera'),
(27, 'pizza 4 quesos', 1, 'congelador'),
(28, 'tortilla de fajita', 1, 'fuera'),
(29, 'yogur', 6, 'nevera'),
(30, 'fideos', 1, 'fuera'),
(31, 'garbanzos', 1, 'fuera'),
(32, 'tomate triturado', 1, 'fuera'),
(33, 'aceite de girasol', 1, 'fuera'),
(34, 'espaguetis', 1, 'fuera'),
(35, 'manzana', 4, 'fuera'),
(36, 'salchicha', 1, 'nevera'),
(37, 'plátano', 5, 'fuera'),
(39, 'ajo', 1, 'fuera'),
(40, 'cebolla', 1, 'fuera'),
(41, 'patata', 5, 'fuera'),
(42, 'batata', 2, 'fuera'),
(43, 'pan de molde', 1, 'fuera'),
(44, 'cereales', 1, 'fuera'),
(45, 'harina', 1, 'fuera'),
(46, 'sal', 1, 'fuera'),
(47, 'azúcar', 1, 'fuera'),
(48, 'aceite de oliva', 1, 'fuera'),
(49, 'pimiento', 3, 'nevera'),
(50, 'tomate', 1, 'nevera');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `quetengotable`
--
ALTER TABLE `quetengotable`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `quetengotable`
--
ALTER TABLE `quetengotable`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
