-- phpMyAdmin SQL Dump
-- version 3.1.2deb1ubuntu0.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generato il: 15 gen, 2010 at 05:03 PM
-- Versione MySQL: 5.0.75
-- Versione PHP: 5.2.6-3ubuntu4.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `iniziative`
--


--
-- Struttura per la vista `View_Consumatori_Non_Soci`
--
DROP VIEW IF EXISTS `View_Consumatori_Non_Soci`;

CREATE VIEW `View_Consumatori_Non_Soci` AS select `Consumatori`.`ID` AS `ID`,`Consumatori`.`numero` AS `numero`,`Consumatori`.`nome` AS `nome`,`Consumatori`.`cognome` AS `cognome`,`Consumatori`.`tipo_via` AS `tipo_via`,`Consumatori`.`anno_rinnovo` AS `anno_rinnovo`,`Consumatori`.`anno_iscrizione` AS `anno_iscrizione`,`Consumatori`.`indirizzo` AS `indirizzo`,`Consumatori`.`presso` AS `presso`,`Consumatori`.`comune` AS `comune`,`Consumatori`.`cap` AS `cap`,`Consumatori`.`provincia` AS `provincia`,`Consumatori`.`email` AS `email`,`Consumatori`.`ID_Soci_dati_consumatore` AS `ID_Soci_dati_consumatore`,`Consumatori`.`note` AS `note`,`Consumatori`.`creation_date` AS `creation_date`,`Consumatori`.`creation_user` AS `creation_user`,`Consumatori`.`last_modification_date` AS `last_modification_date`,`Consumatori`.`last_modification_user` AS `last_modification_user`,`Consumatori`.`deletion_date` AS `deletion_date`,`Consumatori`.`deletion_user` AS `deletion_user`,`Consumatori`.`deletion_flag` AS `deletion_flag`,`Consumatori`.`activation_flag` AS `activation_flag`,`Consumatori`.`ID_Botteghe_consumatori` AS `ID_Botteghe_consumatori`,`Consumatori`.`regione` AS `regione` from `Consumatori` where (isnull(`Consumatori`.`ID_Soci_dati_consumatore`) and (`Consumatori`.`activation_flag` = 1) and (`Consumatori`.`deletion_flag` = 0));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Organizzazioni_Non_Soci`
--
DROP VIEW IF EXISTS `View_Organizzazioni_Non_Soci`;

CREATE VIEW `View_Organizzazioni_Non_Soci` AS select `Organizzazioni`.`ID` AS `ID`,`Organizzazioni`.`nome` AS `nome`,`Organizzazioni`.`ID_Soci_dati_organizzazione` AS `ID_Soci_dati_organizzazione`,`Organizzazioni`.`email` AS `email`,`Organizzazioni`.`numero` AS `numero`,`Organizzazioni`.`tipo_via` AS `tipo_via`,`Organizzazioni`.`indirizzo` AS `indirizzo`,`Organizzazioni`.`comune` AS `comune`,`Organizzazioni`.`cap` AS `cap`,`Organizzazioni`.`provincia` AS `provincia`,`Organizzazioni`.`telefono` AS `telefono`,`Organizzazioni`.`fax` AS `fax`,`Organizzazioni`.`legale_rappresentante` AS `legale_rappresentante`,`Organizzazioni`.`settore_attivita` AS `settore_attivita`,`Organizzazioni`.`note` AS `note`,`Organizzazioni`.`creation_date` AS `creation_date`,`Organizzazioni`.`creation_user` AS `creation_user`,`Organizzazioni`.`last_modification_date` AS `last_modification_date`,`Organizzazioni`.`last_modification_user` AS `last_modification_user`,`Organizzazioni`.`deletion_date` AS `deletion_date`,`Organizzazioni`.`deletion_user` AS `deletion_user`,`Organizzazioni`.`deletion_flag` AS `deletion_flag`,`Organizzazioni`.`activation_flag` AS `activation_flag`,`Organizzazioni`.`ID_Botteghe_organizzazioni` AS `ID_Botteghe_organizzazioni`,`Organizzazioni`.`tipo_organizzazione` AS `tipo_organizzazione`,`Organizzazioni`.`anno_iscrizione` AS `anno_iscrizione`,`Organizzazioni`.`anno_rinnovo` AS `anno_rinnovo`,`Organizzazioni`.`regione` AS `regione`,`Organizzazioni`.`web` AS `web` from `Organizzazioni` where (isnull(`Organizzazioni`.`ID_Soci_dati_organizzazione`) and (`Organizzazioni`.`activation_flag` = 1) and (`Organizzazioni`.`deletion_flag` = 0));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Attesa_Delibera_Ammissione`
--
DROP VIEW IF EXISTS `View_Soci_Attesa_Delibera_Ammissione`;

CREATE VIEW `View_Soci_Attesa_Delibera_Ammissione` AS select `Soci`.`ID` AS `ID`,`Soci`.`numero_socio` AS `numero_socio`,`Soci`.`telefono_casa` AS `telefono_casa`,`Soci`.`telefono_lavoro` AS `telefono_lavoro`,`Soci`.`telefono_cellulare` AS `telefono_cellulare`,`Soci`.`data_nascita` AS `data_nascita`,`Soci`.`comune_nascita` AS `comune_nascita`,`Soci`.`provincia_nascita` AS `provincia_nascita`,`Soci`.`professione` AS `professione`,`Soci`.`numero_domanda` AS `numero_domanda`,`Soci`.`data_domanda` AS `data_domanda`,`Soci`.`data_ammissione` AS `data_ammissione`,`Soci`.`codice_fiscale` AS `codice_fiscale`,`Soci`.`data_domanda_recesso` AS `data_domanda_recesso`,`Soci`.`data_delibera_recesso` AS `data_delibera_recesso`,`Soci`.`carica` AS `carica`,`Soci`.`creation_date` AS `creation_date`,`Soci`.`creation_user` AS `creation_user`,`Soci`.`last_modification_date` AS `last_modification_date`,`Soci`.`last_modification_user` AS `last_modification_user`,`Soci`.`deletion_date` AS `deletion_date`,`Soci`.`deletion_user` AS `deletion_user`,`Soci`.`deletion_flag` AS `deletion_flag`,`Soci`.`activation_flag` AS `activation_flag`,`Soci`.`residenza_numero` AS `residenza_numero`,`Soci`.`residenza_tipo_via` AS `residenza_tipo_via`,`Soci`.`residenza_indirizzo` AS `residenza_indirizzo`,`Soci`.`residenza_comune` AS `residenza_comune`,`Soci`.`residenza_cap` AS `residenza_cap`,`Soci`.`residenza_provincia` AS `residenza_provincia`,`Soci`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`Soci`.`regione_nascita` AS `regione_nascita`,`Soci`.`residenza_regione` AS `residenza_regione`,`Soci`.`partita_iva` AS `partita_iva`,`Soci`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`Soci`.`genere` AS `genere` from `Soci` where (exists(select 1 AS `1` from `Movimenti_Quote` `q` where ((`q`.`activation_flag` = 1) and (`q`.`deletion_flag` = 0) and (`q`.`ID_Soci_movimenti_quote` = `Soci`.`ID`))) and isnull(`Soci`.`data_ammissione`));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Attesa_Delibera_Recesso`
--
DROP VIEW IF EXISTS `View_Soci_Attesa_Delibera_Recesso`;

CREATE VIEW `View_Soci_Attesa_Delibera_Recesso` AS select `Soci`.`ID` AS `ID`,`Soci`.`numero_socio` AS `numero_socio`,`Soci`.`telefono_casa` AS `telefono_casa`,`Soci`.`telefono_lavoro` AS `telefono_lavoro`,`Soci`.`telefono_cellulare` AS `telefono_cellulare`,`Soci`.`data_nascita` AS `data_nascita`,`Soci`.`comune_nascita` AS `comune_nascita`,`Soci`.`provincia_nascita` AS `provincia_nascita`,`Soci`.`professione` AS `professione`,`Soci`.`numero_domanda` AS `numero_domanda`,`Soci`.`data_domanda` AS `data_domanda`,`Soci`.`data_ammissione` AS `data_ammissione`,`Soci`.`codice_fiscale` AS `codice_fiscale`,`Soci`.`data_domanda_recesso` AS `data_domanda_recesso`,`Soci`.`data_delibera_recesso` AS `data_delibera_recesso`,`Soci`.`carica` AS `carica`,`Soci`.`creation_date` AS `creation_date`,`Soci`.`creation_user` AS `creation_user`,`Soci`.`last_modification_date` AS `last_modification_date`,`Soci`.`last_modification_user` AS `last_modification_user`,`Soci`.`deletion_date` AS `deletion_date`,`Soci`.`deletion_user` AS `deletion_user`,`Soci`.`deletion_flag` AS `deletion_flag`,`Soci`.`activation_flag` AS `activation_flag`,`Soci`.`residenza_numero` AS `residenza_numero`,`Soci`.`residenza_tipo_via` AS `residenza_tipo_via`,`Soci`.`residenza_indirizzo` AS `residenza_indirizzo`,`Soci`.`residenza_comune` AS `residenza_comune`,`Soci`.`residenza_cap` AS `residenza_cap`,`Soci`.`residenza_provincia` AS `residenza_provincia`,`Soci`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`Soci`.`regione_nascita` AS `regione_nascita`,`Soci`.`residenza_regione` AS `residenza_regione`,`Soci`.`partita_iva` AS `partita_iva`,`Soci`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`Soci`.`genere` AS `genere` from `Soci` where (exists(select 1 AS `1` from `Movimenti_Quote` `q` where ((`q`.`activation_flag` = 1) and (`q`.`deletion_flag` = 0) and (`q`.`ID_Soci_movimenti_quote` = `Soci`.`ID`))) and (`Soci`.`data_ammissione` is not null) and (`Soci`.`data_domanda_recesso` is not null) and isnull(`Soci`.`data_delibera_recesso`));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Attesa_Rimborso_Quote`
--
DROP VIEW IF EXISTS `View_Soci_Attesa_Rimborso_Quote`;

CREATE VIEW `View_Soci_Attesa_Rimborso_Quote` AS select `Soci`.`ID` AS `ID`,`Soci`.`numero_socio` AS `numero_socio`,`Soci`.`telefono_casa` AS `telefono_casa`,`Soci`.`telefono_lavoro` AS `telefono_lavoro`,`Soci`.`telefono_cellulare` AS `telefono_cellulare`,`Soci`.`data_nascita` AS `data_nascita`,`Soci`.`comune_nascita` AS `comune_nascita`,`Soci`.`provincia_nascita` AS `provincia_nascita`,`Soci`.`professione` AS `professione`,`Soci`.`numero_domanda` AS `numero_domanda`,`Soci`.`data_domanda` AS `data_domanda`,`Soci`.`data_ammissione` AS `data_ammissione`,`Soci`.`codice_fiscale` AS `codice_fiscale`,`Soci`.`data_domanda_recesso` AS `data_domanda_recesso`,`Soci`.`data_delibera_recesso` AS `data_delibera_recesso`,`Soci`.`carica` AS `carica`,`Soci`.`creation_date` AS `creation_date`,`Soci`.`creation_user` AS `creation_user`,`Soci`.`last_modification_date` AS `last_modification_date`,`Soci`.`last_modification_user` AS `last_modification_user`,`Soci`.`deletion_date` AS `deletion_date`,`Soci`.`deletion_user` AS `deletion_user`,`Soci`.`deletion_flag` AS `deletion_flag`,`Soci`.`activation_flag` AS `activation_flag`,`Soci`.`residenza_numero` AS `residenza_numero`,`Soci`.`residenza_tipo_via` AS `residenza_tipo_via`,`Soci`.`residenza_indirizzo` AS `residenza_indirizzo`,`Soci`.`residenza_comune` AS `residenza_comune`,`Soci`.`residenza_cap` AS `residenza_cap`,`Soci`.`residenza_provincia` AS `residenza_provincia`,`Soci`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`Soci`.`regione_nascita` AS `regione_nascita`,`Soci`.`residenza_regione` AS `residenza_regione`,`Soci`.`partita_iva` AS `partita_iva`,`Soci`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`Soci`.`genere` AS `genere` from `Soci` where ((not(exists(select 1 AS `1` from `Movimenti_Quote` `q` where ((`q`.`activation_flag` = 1) and (`q`.`deletion_flag` = 0) and (`q`.`ID_Soci_movimenti_quote` = `Soci`.`ID`) and (`q`.`causale_quota` = 3))))) and (`Soci`.`data_ammissione` is not null) and (`Soci`.`data_domanda_recesso` is not null) and (`Soci`.`data_delibera_recesso` is not null));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Attesa_Sottoscrizione`
--
DROP VIEW IF EXISTS `View_Soci_Attesa_Sottoscrizione`;

CREATE VIEW `View_Soci_Attesa_Sottoscrizione` AS select `Soci`.`ID` AS `ID`,`Soci`.`numero_socio` AS `numero_socio`,`Soci`.`telefono_casa` AS `telefono_casa`,`Soci`.`telefono_lavoro` AS `telefono_lavoro`,`Soci`.`telefono_cellulare` AS `telefono_cellulare`,`Soci`.`data_nascita` AS `data_nascita`,`Soci`.`comune_nascita` AS `comune_nascita`,`Soci`.`provincia_nascita` AS `provincia_nascita`,`Soci`.`professione` AS `professione`,`Soci`.`numero_domanda` AS `numero_domanda`,`Soci`.`data_domanda` AS `data_domanda`,`Soci`.`data_ammissione` AS `data_ammissione`,`Soci`.`codice_fiscale` AS `codice_fiscale`,`Soci`.`data_domanda_recesso` AS `data_domanda_recesso`,`Soci`.`data_delibera_recesso` AS `data_delibera_recesso`,`Soci`.`carica` AS `carica`,`Soci`.`creation_date` AS `creation_date`,`Soci`.`creation_user` AS `creation_user`,`Soci`.`last_modification_date` AS `last_modification_date`,`Soci`.`last_modification_user` AS `last_modification_user`,`Soci`.`deletion_date` AS `deletion_date`,`Soci`.`deletion_user` AS `deletion_user`,`Soci`.`deletion_flag` AS `deletion_flag`,`Soci`.`activation_flag` AS `activation_flag`,`Soci`.`residenza_numero` AS `residenza_numero`,`Soci`.`residenza_tipo_via` AS `residenza_tipo_via`,`Soci`.`residenza_indirizzo` AS `residenza_indirizzo`,`Soci`.`residenza_comune` AS `residenza_comune`,`Soci`.`residenza_cap` AS `residenza_cap`,`Soci`.`residenza_provincia` AS `residenza_provincia`,`Soci`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`Soci`.`regione_nascita` AS `regione_nascita`,`Soci`.`residenza_regione` AS `residenza_regione`,`Soci`.`partita_iva` AS `partita_iva`,`Soci`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`Soci`.`genere` AS `genere` from `Soci` where (not(exists(select 1 AS `1` from `Movimenti_Quote` `q` where ((`q`.`activation_flag` = 1) and (`q`.`deletion_flag` = 0) and (`q`.`ID_Soci_movimenti_quote` = `Soci`.`ID`)))));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Attivi`
--
DROP VIEW IF EXISTS `View_Soci_Attivi`;

CREATE VIEW `View_Soci_Attivi` AS select `aliasSoci`.`ID` AS `ID`,`aliasSoci`.`numero_socio` AS `numero_socio`,`aliasSoci`.`telefono_casa` AS `telefono_casa`,`aliasSoci`.`telefono_lavoro` AS `telefono_lavoro`,`aliasSoci`.`telefono_cellulare` AS `telefono_cellulare`,`aliasSoci`.`data_nascita` AS `data_nascita`,`aliasSoci`.`comune_nascita` AS `comune_nascita`,`aliasSoci`.`provincia_nascita` AS `provincia_nascita`,`aliasSoci`.`professione` AS `professione`,`aliasSoci`.`numero_domanda` AS `numero_domanda`,`aliasSoci`.`data_domanda` AS `data_domanda`,`aliasSoci`.`data_ammissione` AS `data_ammissione`,`aliasSoci`.`codice_fiscale` AS `codice_fiscale`,`aliasSoci`.`data_domanda_recesso` AS `data_domanda_recesso`,`aliasSoci`.`data_delibera_recesso` AS `data_delibera_recesso`,`aliasSoci`.`carica` AS `carica`,`aliasSoci`.`creation_date` AS `creation_date`,`aliasSoci`.`creation_user` AS `creation_user`,`aliasSoci`.`last_modification_date` AS `last_modification_date`,`aliasSoci`.`last_modification_user` AS `last_modification_user`,`aliasSoci`.`deletion_date` AS `deletion_date`,`aliasSoci`.`deletion_user` AS `deletion_user`,`aliasSoci`.`deletion_flag` AS `deletion_flag`,`aliasSoci`.`activation_flag` AS `activation_flag`,`aliasSoci`.`residenza_numero` AS `residenza_numero`,`aliasSoci`.`residenza_tipo_via` AS `residenza_tipo_via`,`aliasSoci`.`residenza_indirizzo` AS `residenza_indirizzo`,`aliasSoci`.`residenza_comune` AS `residenza_comune`,`aliasSoci`.`residenza_cap` AS `residenza_cap`,`aliasSoci`.`residenza_provincia` AS `residenza_provincia`,`aliasSoci`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`aliasSoci`.`regione_nascita` AS `regione_nascita`,`aliasSoci`.`residenza_regione` AS `residenza_regione`,`aliasSoci`.`partita_iva` AS `partita_iva`,`aliasSoci`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`aliasSoci`.`genere` AS `genere` from `Soci` `aliasSoci` where (exists(select 1 AS `1` from `Movimenti_Quote` `q` where ((`q`.`activation_flag` = 1) and (`q`.`deletion_flag` = 0) and (`q`.`ID_Soci_movimenti_quote` = `aliasSoci`.`ID`))) and (`aliasSoci`.`data_ammissione` is not null) and isnull(`aliasSoci`.`data_domanda_recesso`));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Receduti`
--
DROP VIEW IF EXISTS `View_Soci_Receduti`;

CREATE VIEW `View_Soci_Receduti` AS select `Soci`.`ID` AS `ID`,`Soci`.`numero_socio` AS `numero_socio`,`Soci`.`telefono_casa` AS `telefono_casa`,`Soci`.`telefono_lavoro` AS `telefono_lavoro`,`Soci`.`telefono_cellulare` AS `telefono_cellulare`,`Soci`.`data_nascita` AS `data_nascita`,`Soci`.`comune_nascita` AS `comune_nascita`,`Soci`.`provincia_nascita` AS `provincia_nascita`,`Soci`.`professione` AS `professione`,`Soci`.`numero_domanda` AS `numero_domanda`,`Soci`.`data_domanda` AS `data_domanda`,`Soci`.`data_ammissione` AS `data_ammissione`,`Soci`.`codice_fiscale` AS `codice_fiscale`,`Soci`.`data_domanda_recesso` AS `data_domanda_recesso`,`Soci`.`data_delibera_recesso` AS `data_delibera_recesso`,`Soci`.`carica` AS `carica`,`Soci`.`creation_date` AS `creation_date`,`Soci`.`creation_user` AS `creation_user`,`Soci`.`last_modification_date` AS `last_modification_date`,`Soci`.`last_modification_user` AS `last_modification_user`,`Soci`.`deletion_date` AS `deletion_date`,`Soci`.`deletion_user` AS `deletion_user`,`Soci`.`deletion_flag` AS `deletion_flag`,`Soci`.`activation_flag` AS `activation_flag`,`Soci`.`residenza_numero` AS `residenza_numero`,`Soci`.`residenza_tipo_via` AS `residenza_tipo_via`,`Soci`.`residenza_indirizzo` AS `residenza_indirizzo`,`Soci`.`residenza_comune` AS `residenza_comune`,`Soci`.`residenza_cap` AS `residenza_cap`,`Soci`.`residenza_provincia` AS `residenza_provincia`,`Soci`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`Soci`.`regione_nascita` AS `regione_nascita`,`Soci`.`residenza_regione` AS `residenza_regione`,`Soci`.`partita_iva` AS `partita_iva`,`Soci`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`Soci`.`genere` AS `genere` from `Soci` where (exists(select 1 AS `1` from `Movimenti_Quote` `q` where ((`q`.`activation_flag` = 1) and (`q`.`deletion_flag` = 0) and (`q`.`ID_Soci_movimenti_quote` = `Soci`.`ID`) and (`q`.`causale_quota` = 3))) and (`Soci`.`data_ammissione` is not null) and (`Soci`.`data_domanda_recesso` is not null) and (`Soci`.`data_delibera_recesso` is not null));
