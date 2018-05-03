-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2018 at 08:12 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `edubooks`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `isbn` text NOT NULL,
  `call_time` text NOT NULL,
  `title` text NOT NULL,
  `author` text NOT NULL,
  `ship_weight` text NOT NULL,
  `sellers` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `isbn`
--

CREATE TABLE `isbn` (
  `id` int(11) NOT NULL,
  `isbn` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `isbn`
--

INSERT INTO `isbn` (`id`, `isbn`) VALUES
(1, '9780226902869'),
(2, '9780226901039'),
(3, '9780226894430'),
(4, '9780226894034'),
(5, '9780226894027'),
(6, '9780226886640'),
(7, '9780226870380'),
(8, '9780226856711'),
(9, '9780226853208'),
(10, '9780226849768'),
(11, '9780226848730'),
(12, '9780226848693'),
(13, '9780226808550'),
(14, '9780226797625'),
(15, '9780226797618'),
(16, '9780226794211'),
(17, '9780226794204'),
(18, '9780226790367'),
(19, '9780226790350'),
(20, '9780226775241'),
(21, '9780226775234'),
(22, '9780226774923'),
(23, '9780226774916'),
(24, '9780226774473'),
(25, '9780226774466'),
(26, '9780226774442'),
(27, '9780226768748'),
(28, '9780226768731'),
(29, '9780226767932'),
(30, '9780226767925'),
(31, '9780226767321'),
(32, '9780226767314'),
(33, '9780226764559'),
(34, '9780226761343'),
(35, '9780226757001'),
(36, '9780226756103'),
(37, '9780226756097'),
(38, '9780226752570'),
(39, '9780226752563'),
(40, '9780226749181'),
(41, '9780226749174'),
(42, '9780226746654'),
(43, '9780226746630');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `isbn`
--
ALTER TABLE `isbn`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `isbn`
--
ALTER TABLE `isbn`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
