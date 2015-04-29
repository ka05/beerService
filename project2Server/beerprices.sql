-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 22, 2015 at 08:59 PM
-- Server version: 5.6.21
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `beerprices`
--
CREATE DATABASE IF NOT EXISTS `beerprices` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `beerprices`;

-- --------------------------------------------------------

--
-- Table structure for table `beers`
--

DROP TABLE IF EXISTS `beers`;
CREATE TABLE IF NOT EXISTS `beers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beername` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `beerprice` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `beers`
--

INSERT INTO `beers` (`id`, `beername`, `beerprice`) VALUES
(1, 'Bud', '12.00'),
(2, 'Coors', '8.49'),
(3, 'Corona', '13.99'),
(4, 'Genesee', '4.99'),
(5, 'Guiness Draught', '12.99'),
(6, 'Labatt', '7.99'),
(7, 'Sam Adams', '12.49');

-- --------------------------------------------------------

--
-- Table structure for table `tokens`
--

DROP TABLE IF EXISTS `tokens`;
CREATE TABLE IF NOT EXISTS `tokens` (
  `tokenId` varchar(160) NOT NULL,
  `userId` int(11) NOT NULL,
  `expDate` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(160) NOT NULL,
  `accesslevel` varchar(10) NOT NULL DEFAULT 'public',
  `age` int(11) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `username`, `password`, `accesslevel`, `age`) VALUES
(10, 'john', 'a66e44736e753d4533746ced572ca821', 'admin', 21),
(11, 'tim', 'b15d47e99831ee63e3f47cf3d4478e9a', 'public', 10),
(12, 'fred', '570a90bfbf8c7eab5dc5d4e26832d5b1', 'public', 21);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
