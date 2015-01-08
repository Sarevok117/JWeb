-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 08 Janvier 2015 à 16:32
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `jweb`
--

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `date` date NOT NULL,
  `user` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FOREIGN` (`user`(1))
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `comment`
--

INSERT INTO `comment` (`id`, `content`, `date`, `user`, `email`) VALUES
(1, 'lolzekgozjpag', '2015-01-08', 'lol', 'lol@lol.lol'),
(2, 'Enter text here...', '2015-01-08', 'lol', 'lol@lol.lol'),
(3, 'Enter text here...', '2015-01-08', 'lol', 'lol@lol.lol'),
(4, 'Enter text here...', '2015-01-08', 'lol', 'lol@lol.lol'),
(5, 'Enter text here...', '2015-01-08', 'lol', 'lol@lol.lol'),
(6, 'lol', '2015-01-08', 'lol', 'lol@lol.lol'),
(7, 'Enter text here...', '2015-01-08', 'lol', 'lol@lol.lol'),
(8, 'Enter text here...', '2015-01-08', 'lol', 'lol@lol.lol');

-- --------------------------------------------------------

--
-- Structure de la table `news`
--

CREATE TABLE IF NOT EXISTS `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `date` date NOT NULL,
  `user` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `news`
--

INSERT INTO `news` (`id`, `content`, `date`, `user`) VALUES
(1, 'lol', '2015-01-08', 'lol@lol.lol'),
(2, 'le topkek', '2015-01-08', 'lol@lol.lol');

-- --------------------------------------------------------

--
-- Structure de la table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `description` text NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` char(56) NOT NULL,
  `admin` tinyint(1) NOT NULL,
  `news` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`, `admin`, `news`) VALUES
(1, 'henri', 'test@email.fr', '1234', 0, 0),
(2, 'jean', 'test@mail.com', '1234', 0, 0),
(3, 'john', 'john@mail.com', '1234', 0, 0),
(4, 'lol', 'lol@mail.com', 'lol', 0, 0),
(5, 'lolilol', 'moi@mail.com', 'lol', 0, 0),
(6, 'jean', 'jean@mail.com', 'lol', 0, 0),
(11, 'lol', 'lol@lol.lol', 'lol', 1, 0),
(12, 'kkk', 'k@k.k', 'kkk', 0, 1),
(15, 'iii', 'i@i.i', 'iii', 0, 0),
(16, 'ooo', 'o@o.o', 'ooo', 0, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
