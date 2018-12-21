-- phpMyAdmin SQL Dump
-- version 2.11.3deb1ubuntu1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generato il: 17 Giu, 2008 at 05:14 PM
-- Versione MySQL: 5.0.51
-- Versione PHP: 5.2.4-2ubuntu5.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `prova`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `rel__system_user_user_groups_to__system_group_group_users`
--

DROP TABLE IF EXISTS `rel__system_user_user_groups_to__system_group_group_users`;
CREATE TABLE IF NOT EXISTS `rel__system_user_user_groups_to__system_group_group_users` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `ID__system_user_user_groups` int(10) NOT NULL default '0',
  `ID__system_group_group_users` int(10) NOT NULL default '0',
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=44 ;

--
-- Dump dei dati per la tabella `rel__system_user_user_groups_to__system_group_group_users`
--

INSERT INTO `rel__system_user_user_groups_to__system_group_group_users` (`ID`, `ID__system_user_user_groups`, `ID__system_group_group_users`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `_system_attachment`
--

DROP TABLE IF EXISTS `_system_attachment`;
CREATE TABLE IF NOT EXISTS `_system_attachment` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `sa_alt_text` text,
  `sa_path` text,
  `sa_link_text` text,
  `sa_content_type` varchar(101) default NULL,
  `sa_filename` text,
  `sa_type` int(11) default NULL,
  `sa_size` int(10) default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(101) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(101) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(101) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=168 ;

--
-- Dump dei dati per la tabella `_system_attachment`
--


-- --------------------------------------------------------

--
-- Struttura della tabella `_system_banner`
--

DROP TABLE IF EXISTS `_system_banner`;
CREATE TABLE IF NOT EXISTS `_system_banner` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `_sb_link` varchar(100) default NULL,
  `_sb_order` int(10) default NULL,
  `_sb_name` varchar(100) NOT NULL default '',
  `_sb_bgcolor` varchar(100) default NULL,
  `_sb_type` int(10) default NULL,
  `_sb_attachment` int(11) default NULL,
  `_sb_is_active` tinyint(1) default NULL,
  `_sb_alt` varchar(100) default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  PRIMARY KEY  (`_sb_name`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dump dei dati per la tabella `_system_banner`
--


-- --------------------------------------------------------

--
-- Struttura della tabella `_system_class_auth`
--

DROP TABLE IF EXISTS `_system_class_auth`;
CREATE TABLE IF NOT EXISTS `_system_class_auth` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `sca_class` varchar(101) default NULL,
  `sca_permissions` varchar(101) default NULL,
  `ID__system_group_group_class_auth` int(10) default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=19 ;

--
-- Dump dei dati per la tabella `_system_class_auth`
--
INSERT INTO `_system_class_auth` (`ID`, `sca_class`, `sca_permissions`, `ID__system_group_group_class_auth`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`) VALUES
(1, '_system_log', '222', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(2, '_system_access', '222', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1); 


-- --------------------------------------------------------

--
-- Struttura della tabella `_system_cms_node`
--

DROP TABLE IF EXISTS `_system_cms_node`;
CREATE TABLE IF NOT EXISTS `_system_cms_node` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `publication_to` varchar(200) collate latin1_general_ci default NULL,
  `publication_from` varchar(200) collate latin1_general_ci default NULL,
  `ID__system_menu_item_present_in_menu_as` int(10) default NULL,
  `keywords` varchar(200) collate latin1_general_ci default NULL,
  `title` varchar(200) collate latin1_general_ci default NULL,
  `body` text collate latin1_general_ci,
  `category` int(10) default NULL,
  `progressive` int(10) default NULL,
  `teaser` text collate latin1_general_ci,
  `creation_date` date default NULL,
  `creation_user` varchar(100) collate latin1_general_ci default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) collate latin1_general_ci default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) collate latin1_general_ci default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  `extra` text collate latin1_general_ci,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=14 ;

--
-- Dump dei dati per la tabella `_system_cms_node`
--

INSERT INTO `_system_cms_node` (`ID`, `publication_to`, `publication_from`, `ID__system_menu_item_present_in_menu_as`, `keywords`, `title`, `body`, `category`, `progressive`, `teaser`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`, `extra`) VALUES
(1, NULL, NULL, 21, NULL, 'Chi siamo', 'Contatti...<br /><br />......<br />.....<br />........<br /><br /><a class="link" target="_blank" href="http://www.servizidisabili.it" title="Banca Dati Regionale Servizi Disabili"></a>', 1, NULL, NULL, '2008-03-25', 'afrascari', '2008-06-13', 'mtassetti', NULL, NULL, 0, 1, NULL),
(2, NULL, NULL, NULL, NULL, 'Home page', 'Pagina di accesso all''applicazione<br />', NULL, NULL, ' ', '0008-05-14', 'afrascari', '2008-06-13', 'mtassetti', NULL, NULL, 0, 1, NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `_system_decode`
--

DROP TABLE IF EXISTS `_system_decode`;
CREATE TABLE IF NOT EXISTS `_system_decode` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `sd_description` varchar(201) default NULL,
  `sd_value` int(10) default NULL,
  `sd_locale` varchar(101) default NULL,
  `sd_notes` varchar(101) default NULL,
  `ID__system_decode_sd_parent` int(11) default NULL,
  `sd_image` int(11) default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  `sd_class` int(10) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=275 ;

--
-- Dump dei dati per la tabella `_system_decode`
--

INSERT INTO `_system_decode` (`ID`, `sd_description`, `sd_value`, `sd_locale`, `sd_notes`, `ID__system_decode_sd_parent`, `sd_image`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`, `sd_class`) VALUES
(141, 'Enna', 32, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(140, 'Catanzaro', 31, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(139, 'Catania', 30, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(12, 'home page only', 1, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 1),
(13, 'always: static', 2, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 1),
(14, 'always: dynamic', 3, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 1),
(15, 'always: static, reload on logon', 4, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 1),
(16, 'Generale', 1, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 10),
(138, 'Cosenza', 29, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(137, 'Cremona', 28, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(136, 'Como', 27, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(135, 'Cuneo', 26, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(134, 'Caltanissetta', 25, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(133, 'Carbonia Iglesias', 24, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(112, 'Agrigento', 3, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(2, 'Bologna', 2, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(1, 'Emilia-Romagna', 1, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(132, 'Chieti', 23, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(131, 'Caserta', 22, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(130, 'Campobasso', 21, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(129, 'Cagliari', 20, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(128, 'Bolzano', 19, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(127, 'Brescia', 18, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(126, 'Brindisi', 17, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(125, 'Benevento', 16, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(124, 'Belluno', 15, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(122, 'Biella', 13, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(123, 'Bergamo', 14, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(120, 'Avellino', 11, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(121, 'Bari', 12, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(119, 'Asti', 10, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(117, 'Aquila', 8, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(118, 'Arezzo', 9, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(116, 'Ascoli Piceno', 7, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(114, 'Ancona', 5, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(115, 'Aosta', 6, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(113, 'Alessandria', 4, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(142, 'Forli-Cesena', 33, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(143, 'Ferrara', 34, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(144, 'Foggia', 35, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(145, 'Firenze', 36, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(146, 'Frosinone', 37, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(147, 'Genova', 38, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(148, 'Grosseto', 39, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(149, 'Gorizia', 40, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(150, 'Isernia', 41, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(151, 'Crotone', 42, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(152, 'Lecco', 43, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(153, 'Lecce', 44, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(154, 'Livorno', 45, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(155, 'Lodi', 46, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(156, 'Latina', 47, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(157, 'Lucca', 48, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(158, 'Macerata', 49, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(159, 'Messina', 50, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(160, 'Milano', 51, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(161, 'Mantova', 52, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(162, 'Modena', 53, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(163, 'Massa Carrara', 54, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(164, 'Matera', 55, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(165, 'Napoli', 56, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(166, 'Novara', 57, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(167, 'Nuoro', 58, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(168, 'Olbia-Tempio', 59, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(169, 'Oristano', 60, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(170, 'Palermo', 61, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(171, 'Piacenza', 62, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(172, 'Padova', 63, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(173, 'Pescara', 64, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(174, 'Perugia', 65, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(175, 'Pisa', 66, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(176, 'Pordenone', 67, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(177, 'Prato', 68, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(178, 'Parma', 69, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(179, 'Pistoia', 70, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(180, 'Pesaro Urbino', 71, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(181, 'Pavia', 72, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(182, 'Potenza', 73, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(183, 'Ravenna', 74, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(184, 'Reggio Calabria', 75, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(185, 'Reggio Emilia', 76, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(186, 'Ragusa', 77, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(187, 'Rieti', 78, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(188, 'Roma', 79, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(189, 'Rimini', 80, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(190, 'Rovigo', 81, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(191, 'Salerno', 82, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(192, 'Siena', 83, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(193, 'Sondrio', 84, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(194, 'La-Spezia', 85, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(195, 'Siracusa', 86, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(196, 'Sassari', 87, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(197, 'Savona', 88, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(198, 'Taranto', 89, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(199, 'Teramo', 90, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(200, 'Trento', 91, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(201, 'Torino', 92, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(202, 'Trapani', 93, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(203, 'Trieste', 94, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(204, 'Terni', 95, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(205, 'Treviso', 96, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(206, 'Udine', 97, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(207, 'Varese', 98, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(208, 'Verbania', 99, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(209, 'Vercelli', 100, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(210, 'Venezia', 101, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(211, 'Vicenza', 102, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(212, 'Verona', 103, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(213, 'Medio Campidano', 104, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(214, 'Viterbo', 105, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(215, 'Vibo Valentia', 106, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 21),
(216, 'Abruzzo', 2, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(217, 'Basilicata', 3, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(218, 'Calabria', 4, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(219, 'Campania', 5, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(220, 'Friuli Venezia Giulia', 6, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(221, 'Lazio', 7, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(222, 'Liguria', 8, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(223, 'Lombardia', 9, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(224, 'Marche', 10, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(225, 'Molise', 11, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(226, 'Piemonte', 12, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(227, 'Puglia', 13, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(228, 'Sardegna', 14, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(229, 'Sicilia', 15, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(230, 'Toscana', 16, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(231, 'Trentino Alto Adige', 17, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(232, 'Umbria', 18, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(233, 'Valle d''Aosta', 19, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(234, 'Veneto', 20, 'it', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 20),
(235, 'Imperia', 107, 'it', 'Liguria', NULL, NULL, '2008-01-09', 'afrascari', '2008-01-09', 'afrascari', NULL, NULL, 0, 1, 21),
(274, 'Redazione', 2, 'it', NULL, NULL, NULL, '2008-03-28', 'afrascari', '2008-03-28', 'afrascari', NULL, NULL, 0, 1, 10);

-- --------------------------------------------------------

--
-- Struttura della tabella `_system_decode_class`
--

DROP TABLE IF EXISTS `_system_decode_class`;
CREATE TABLE IF NOT EXISTS `_system_decode_class` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `sdc_description` varchar(101) default NULL,
  `sdc_name` varchar(101) default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=208 ;

--
-- Dump dei dati per la tabella `_system_decode_class`
--

INSERT INTO `_system_decode_class` (`ID`, `sdc_description`, `sdc_name`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`) VALUES
(1, 'Proprietà caricamento modulo', 'caricamento modulo', NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(20, 'Regioni', 'Regioni', NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(10, 'Categorie nodi cms', 'Categorie nodi cms', NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(105, NULL, 'tipi banner', NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(21, 'Province', 'Province', NULL, NULL, NULL, NULL, NULL, NULL, 0, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `_system_group`
--

DROP TABLE IF EXISTS `_system_group`;
CREATE TABLE IF NOT EXISTS `_system_group` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `group_name` varchar(101) default NULL,
  `group_description` varchar(101) default NULL,
  `group_default_permissions` varchar(3) default NULL,
  `group_direct_publishing` tinyint(1) default NULL,
  `ID__system_profile_group_profile` int(11) default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Dump dei dati per la tabella `_system_group`
--

INSERT INTO `_system_group` (`ID`, `group_name`, `group_description`, `group_default_permissions`, `group_direct_publishing`, `ID__system_profile_group_profile`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`) VALUES
(1, 'Admin', 'amministratori di sistema', '333', 1, 1, NULL, NULL, '2007-11-14', 'afrascari', NULL, NULL, 0, 1),
(2, 'Operatori', 'operatori accesso completo (in base al profilo?)', '222', 1, 2, NULL, NULL, '2008-03-25', 'afrascari', NULL, NULL, 0, 1),
(3, 'Operatori accesso limitato', 'operatori accesso limitato (in base al profilo?)', '111', 1, 3, NULL, NULL, '2007-09-13', 'afrascari', NULL, NULL, 0, 1),
(4, 'Everyone', 'utenti non loggati', '111', 0, 3, NULL, NULL, '2007-10-31', 'afrascari', NULL, NULL, 0, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `_system_instance_auth`
--

DROP TABLE IF EXISTS `_system_instance_auth`;
CREATE TABLE IF NOT EXISTS `_system_instance_auth` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `sia_permissions` varchar(101) default NULL,
  `sia_class` varchar(101) default NULL,
  `ID__system_group_sia_group` int(10) default NULL,
  `sia_instance` int(10) default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

--
-- Dump dei dati per la tabella `_system_instance_auth`
--

INSERT INTO `_system_instance_auth` (`ID`, `sia_permissions`, `sia_class`, `ID__system_group_sia_group`, `sia_instance`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`) VALUES
(2, '111', '_system_module', 4, 2, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(1, '111', '_system_module', 4, 1, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(3, '111', '_system_module', 4, 5, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(7, '111', '_system_module', 4, 28, '2008-02-19', 'afrascari', '2008-02-19', 'afrascari', NULL, NULL, 0, 1),
(4, '333', '_system_module', 1, 4, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(6, '111', '_system_module', 4, 27, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(8, '111', '_system_module', 4, 9, '2008-02-20', 'afrascari', '2008-02-20', 'afrascari', NULL, NULL, 0, 1),
(9, '111', '_system_module', 4, 6, '2008-02-20', 'afrascari', '2008-02-20', 'afrascari', NULL, NULL, 0, 1),
(10, '111', '_system_module', 4, 7, '2008-02-20', 'afrascari', '2008-02-20', 'afrascari', NULL, NULL, 0, 1),
(11, '111', '_system_module', 4, 16, '2008-02-20', 'afrascari', '2008-02-20', 'afrascari', NULL, NULL, 0, 1),
(12, '111', '_system_module', 4, 3, '2008-02-21', 'afrascari', '2008-02-21', 'afrascari', NULL, NULL, 0, 1),
(13, '111', '_system_module', 4, 12, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(5, '333', '_system_module', 1, 14, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(14, '111', '_system_module', 4, 8, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(15, '111', '_system_module', 4, 18, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(16, '111', '_system_module', 4, 17, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(17, '111', '_system_module', 4, 19, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(18, '111', '_system_module', 4, 20, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(19, '111', '_system_module', 4, 10, '2008-06-13', 'mtassetti', '2008-06-13', 'mtassetti', NULL, NULL, 0, 1),
(20, '111', '_system_module', 4, 11, '2008-06-13', 'mtassetti', '2008-06-13', 'mtassetti', NULL, NULL, 0, 1),
(21, '111', '_system_module', 4, 13, '2008-06-13', 'mtassetti', '2008-06-13', 'mtassetti', NULL, NULL, 0, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `_system_menu_item`
--

DROP TABLE IF EXISTS `_system_menu_item`;
CREATE TABLE IF NOT EXISTS `_system_menu_item` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `smi_title` varchar(101) default NULL,
  `smi_order` int(10) default NULL,
  `smi_locale` varchar(101) default NULL,
  `smi_association` varchar(101) default NULL,
  `smi_href` varchar(101) default NULL,
  `smi_alternative_text` varchar(101) default NULL,
  `ID__system_menu_item_smi_children` int(10) default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- Dump dei dati per la tabella `_system_menu_item`
--

INSERT INTO `_system_menu_item` (`ID`, `smi_title`, `smi_order`, `smi_locale`, `smi_association`, `smi_href`, `smi_alternative_text`, `ID__system_menu_item_smi_children`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`) VALUES
(3, 'Utenti', 5, 'it', NULL, 'object/filter//p=_system_user', 'Utenti', 17, '2007-06-13', 'afrascari', '2007-11-08', 'afrascari', NULL, NULL, 0, 1),
(2, 'Gruppi', 1, 'it', NULL, 'object/filter//p=_system_group', 'Gruppi', 1, '2007-06-13', 'afrascari', '2007-06-13', 'afrascari', NULL, NULL, 0, 1),
(1, 'Amministrazione', 2, 'it', NULL, '', 'Amministrazione', NULL, '2007-06-13', 'afrascari', '2007-06-13', 'afrascari', NULL, NULL, 0, 1),
(4, 'Voci di Menu', 3, 'it', NULL, 'object/filter//p=_system_menu_item', 'Voci di Menu', 1, '2007-06-13', 'afrascari', '2007-06-13', 'afrascari', NULL, NULL, 0, 1),
(5, 'Moduli', 4, 'it', NULL, 'object/filter//p=_system_module_admin', 'Moduli', 1, '2007-06-13', 'afrascari', '2007-06-13', 'afrascari', NULL, NULL, 0, 1),
(6, 'Metambienti', 5, 'it', NULL, 'object/filter//p=_system_meta_environment', 'Metambienti', 1, '2007-06-13', 'afrascari', '2007-06-13', 'afrascari', NULL, NULL, 0, 1),
(7, 'Decodifiche: istanza', 7, 'it', NULL, 'object/filter//p=_system_decode', 'Istanze di decodifiche', 1, '2007-06-13', 'afrascari', '2007-06-13', 'afrascari', NULL, NULL, 0, 1),
(8, 'Profili', 7, 'it', NULL, 'object/filter//p=_system_profile', 'Profili', 1, '2007-06-13', 'afrascari', '2007-06-13', 'afrascari', NULL, NULL, 0, 1),
(9, 'Autorizzazioni classi', 8, 'it', NULL, 'object/filter//p=_system_class_auth', 'Autorizzazioni a livello di classi', 1, '2007-06-13', 'afrascari', '2007-06-13', 'afrascari', NULL, NULL, 0, 1),
(10, 'Autorizzazioni istanze', 9, 'it', NULL, 'object/filter//p=_system_instance_auth', 'Autorizzazioni a livello di istanze', 1, '2007-06-13', 'afrascari', '2007-06-13', 'afrascari', NULL, NULL, 0, 1),
(12, 'Pagine informative', 5, 'it', NULL, 'object/filter//p=_system_cms_node', 'Contenuti cms', 17, NULL, NULL, '2007-09-26', 'afrascari', NULL, NULL, 0, 1),
(17, 'Contenuti', 1, 'it', NULL, '', 'gestione contenuti', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(19, 'Decodifiche: classi', 6, 'it', NULL, 'object/filter//p=_system_decode_class', 'classi di decodifica', 1, '2007-09-03', 'afrascari', '2007-09-03', 'afrascari', NULL, NULL, 0, 1),
(20, 'Banner', 3, 'it', NULL, 'object/filter//p=_system_banner', 'gestione banner', 17, '2007-09-11', 'afrascari', '2007-09-11', 'afrascari', NULL, NULL, 0, 0),
(11, 'Gestione contenuti', 1, 'it', NULL, '', 'Amministrazione', NULL, '2007-06-13', 'afrascari', '2007-06-13', 'afrascari', NULL, NULL, 0, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `_system_meta_environment`
--

DROP TABLE IF EXISTS `_system_meta_environment`;
CREATE TABLE IF NOT EXISTS `_system_meta_environment` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `sme_name` varchar(101) default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dump dei dati per la tabella `_system_meta_environment`
--

INSERT INTO `_system_meta_environment` (`ID`, `sme_name`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`) VALUES
(1, 'Standard', NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(2, 'Redazione', '2007-10-31', 'afrascari', '2007-10-31', 'afrascari', NULL, NULL, 0, 1),
(3, 'Homepage', NULL, NULL, NULL, NULL, NULL, NULL, 0, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `_system_module`
--

DROP TABLE IF EXISTS `_system_module`;
CREATE TABLE IF NOT EXISTS `_system_module` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `ID__system_menu_item_sm_menu` int(10) default NULL,
  `sm_name` varchar(101) default NULL,
  `sm_order` int(10) default NULL,
  `sm_java_class` varchar(101) default NULL,
  `sm_alternative_text` varchar(101) default NULL,
  `sm_description` varchar(101) default NULL,
  `sm_show` varchar(101) default NULL,
  `sm_position` int(10) default NULL,
  `sm_default_parameters` varchar(100) default NULL,
  `sm_default_call` varchar(100) default NULL,
  `sm_auto_load` int(11) default NULL,
  `ID__system_meta_environment_sme_modules` int(10) default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=30 ;

--
-- Dump dei dati per la tabella `_system_module`
--

INSERT INTO `_system_module` (`ID`, `ID__system_menu_item_sm_menu`, `sm_name`, `sm_order`, `sm_java_class`, `sm_alternative_text`, `sm_description`, `sm_show`, `sm_position`, `sm_default_parameters`, `sm_default_call`, `sm_auto_load`, `ID__system_meta_environment_sme_modules`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`) VALUES
(1, NULL, 'area', 1, 'eu.anastasis.serena.application.modules.object.ObjectModule', NULL, NULL, NULL, 5, '', NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(2, NULL, 'object', 1, 'eu.anastasis.serena.application.modules.object.ObjectModule', NULL, NULL, NULL, 5, '', NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(4, 1, 'Amministrazione', 4, 'eu.anastasis.serena.application.modules.menu.MenuModule', 'Menu amministrazione sistema', 'Menu amministrazione sistema', 'Amministrazione', 2, NULL, 'call', 4, 1, '2007-06-14', 'afrascari', '2007-10-31', 'afrascari', NULL, NULL, 0, 1),
(5, NULL, 'login', 1, 'eu.anastasis.serena.application.modules.login.LoginModule', 'Entra nell''applicazione per accedere alle tue funzionalità', 'Entra nell''applicazione per accedere alle tue funzionalità', 'Accesso redazione', 2, NULL, 'call', 4, 1, '2007-06-15', 'mtassetti', '2008-06-13', 'afrascari', NULL, NULL, 0, 1),
(6, NULL, 'search', 1, 'eu.anastasis.serena.application.modules.searchEngine.SearchModule', 'risultati ricerca', NULL, 'risultati ricerca', 5, '', NULL, 0, 1, NULL, 'afrascari', NULL, 'afrascari', NULL, NULL, 0, 1),
(3, NULL, 'hp_news', 1, 'eu.anastasis.serena.application.modules.object.ObjectModule', NULL, NULL, 'news home page', 3, 'class=_system_news/dimension=5', 'list', 1, 1, '2008-02-21', 'afrascari', '2008-02-21', 'afrascari', NULL, NULL, 1, 0),
(7, NULL, 'Calendar', 1, 'eu.anastasis.serena.application.modules.CalendarModule', NULL, NULL, 'Calendario eventi', 7, 'calendario/static', NULL, 2, 1, NULL, 'afrascari', '2008-02-20', 'afrascari', NULL, NULL, 0, 1),
(8, NULL, 'Newsletter', 3, 'eu.anastasis.serena.application.modules.StaticHtmlModule', NULL, NULL, 'Newsletter', 7, 'newsletter/static', NULL, 2, 1, NULL, 'afrascari', NULL, 'afrascari', NULL, NULL, 1, 1),
(9, 17, 'Contenuti', 2, 'eu.anastasis.serena.application.modules.menu.MenuModule', 'Menu Redazione sistema', 'Menu amministrazione sistema', 'Contenuti', 2, NULL, 'call', 4, 1, '2007-06-14', 'afrascari', '2007-10-31', 'afrascari', NULL, NULL, 0, 1),
(10, NULL, 'homepage', 1, 'eu.anastasis.serena.application.modules.object.ObjectModule', 'home page', NULL, 'home page', 5, 'ID=2/class=_system_cms_node/dimension=1', 'detail', 1, 1, '2008-02-21', 'afrascari', '2008-06-13', 'mtassetti', NULL, NULL, 0, 1),
(11, NULL, 'map', 2, 'eu.anastasis.serena.application.modules.map.MapModule', '5', 'Modulo mappe', NULL, 5, NULL, NULL, NULL, 1, '0000-00-00', '2007-07-12', '2008-06-13', 'mtassetti', NULL, '0', 0, 1),
(12, 0, 'Report', 1, 'eu.anastasis.serena.application.modules.report.ReportModule', '', 'Modulo creazione Report', '', 5, '', '', NULL, 1, '0000-00-00', '0000-00-00', '0000-00-00', NULL, NULL, '0', 0, 1),
(13, NULL, 'stat', 20, 'eu.anastasis.serena.application.modules.stat.StatModule', 'stat', 'stat', 'stat', 5, NULL, NULL, NULL, 1, '2007-12-14', 'mtassetti', '2008-06-13', 'mtassetti', NULL, NULL, 0, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `_system_news`
--

DROP TABLE IF EXISTS `_system_news`;
CREATE TABLE IF NOT EXISTS `_system_news` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `title` varchar(200) default NULL,
  `teaser` longtext,
  `thumbnail` int(10) default NULL,
  `category` int(10) default NULL,
  `source` int(10) default NULL,
  `event_date` datetime default NULL,
  `body` longtext,
  `image` int(10) default NULL,
  `publication_from` datetime default NULL,
  `publication_to` datetime default NULL,
  `attach` int(11) default NULL,
  `attach_1` int(10) default NULL,
  `attach_2` int(10) default NULL,
  `link_1` int(10) default NULL,
  `link_2` int(10) default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dump dei dati per la tabella `_system_news`
--


-- --------------------------------------------------------

--
-- Struttura della tabella `_system_profile`
--

DROP TABLE IF EXISTS `_system_profile`;
CREATE TABLE IF NOT EXISTS `_system_profile` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `sp_description` varchar(101) default NULL,
  `sp_name` varchar(101) default NULL,
  `sp_level` int(10) unsigned default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dump dei dati per la tabella `_system_profile`
--

INSERT INTO `_system_profile` (`ID`, `sp_description`, `sp_name`, `sp_level`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`) VALUES
(1, 'profilo completo: tutti i dati su gli utenti', 'admin', 10, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(2, 'profilo ad accesso limitato', 'user', 20, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1),
(3, 'profilo ad accesso limitato e read only', 'restricted_user', 30, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `_system_user`
--

DROP TABLE IF EXISTS `_system_user`;
CREATE TABLE IF NOT EXISTS `_system_user` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `user_name` varchar(101) default NULL,
  `user_sercret_pharse` varchar(101) default NULL,
  `user_password` varchar(101) default NULL,
  `user_secret_answer` varchar(101) default NULL,
  `user_user_id` varchar(101) default NULL,
  `user_email` varchar(101) default NULL,
  `user_phone_number` varchar(101) default NULL,
  `user_uniqueId` varchar(101) default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Dump dei dati per la tabella `_system_user`
--

INSERT INTO `_system_user` (`ID`, `user_name`, `user_sercret_pharse`, `user_password`, `user_secret_answer`, `user_user_id`, `user_email`, `user_phone_number`,   	`user_uniqueId`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`) VALUES
(1, 'Utente amministratore', NULL, '7Ur75vJmKJprqH3Rge4Hz96ViLUCrlKE', NULL, 'admin', '', '',NULL, NULL, NULL, '2008-06-13', 'afrascari', NULL, NULL, 0, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `_system_access`
--


CREATE TABLE `_system_access` (
`ID` int(10) unsigned NOT NULL auto_increment,
`sac_session` varchar(200) default NULL,
`sac_notes` varchar(200) default NULL,
`sac_action` varchar(200) default NULL,
`sac_class` varchar(200) default NULL,
`sac_instance` varchar(200) default NULL,
`sac_username` varchar(200) default NULL,
`sac_time` datetime default NULL,
`sac_instance_title` varchar(200) default NULL,
`creation_date` date default NULL,
`creation_user` varchar(100) default NULL,
`last_modification_date` date default NULL,
`last_modification_user` varchar(100) default NULL,
`deletion_date` date default NULL,
`deletion_user` varchar(100) default NULL,
`deletion_flag` tinyint(1) default NULL,
`activation_flag` tinyint(1) default NULL,
PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;
