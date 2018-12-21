-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.27-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO,MYSQL323' */;


--
-- Create schema (null)
--




-- Parte dinamica

ALTER TABLE `Consumatori` 
  CHANGE `nome` `nome` varchar(200),
  CHANGE `cognome` `cognome` varchar(200),
  CHANGE `ragione_sociale` `ragione_sociale` varchar(200),
  CHANGE `anno_iscrizione` `anno_iscrizione` int(10),
  CHANGE `anno_rinnovo` `anno_rinnovo` int(10),
  CHANGE `tipo_via` `tipo_via` int(10),
  CHANGE `indirizzo` `indirizzo` varchar(200),
  CHANGE `numero` `numero` varchar(200),
  CHANGE `comune` `comune` int(10),
  CHANGE `cap` `cap` varchar(200),
  CHANGE `provincia` `provincia` int(10),
  CHANGE `presso` `presso` varchar(200),
  CHANGE `email` `email` varchar(200),
  CHANGE `note` `note` longtext,
  CHANGE `ID_Soci_dati_consumatore` `ID_Soci_dati_consumatore` int(10),
DROP PRIMARY KEY,
ADD PRIMARY KEY  (`ID`)
;

ALTER TABLE `Libretti` 
  CHANGE `numero_libretto` `numero_libretto` varchar(200),
  CHANGE `codice_contratto` `codice_contratto` varchar(200),
  CHANGE `tipo_contratto` `tipo_contratto` int(10),
  CHANGE `tasso_interesse` `tasso_interesse` int(10),
  CHANGE `delega` `delega` int(10),
  CHANGE `anno_contratto` `anno_contratto` int(10),
  CHANGE `data_contratto` `data_contratto` DATETIME,
  CHANGE `note_contratto` `note_contratto` longtext,
  CHANGE `rinnovo` `rinnovo` int(10),
  CHANGE `data_ultimo_rinnovo` `data_ultimo_rinnovo` DATETIME,
  CHANGE `data_chiusura` `data_chiusura` DATETIME,
  CHANGE `motivazione_chiusura` `motivazione_chiusura` longtext,
  CHANGE `banca_di_riferimento` `banca_di_riferimento` varchar(200),
  CHANGE `conto_corrente` `conto_corrente` varchar(200),
CHANGE `ID_Soci_risparmio` `ID_Soci_risparmio` int(10),
DROP PRIMARY KEY,
ADD PRIMARY KEY  (`ID`)
;

ALTER TABLE `Movimenti_Quote` 
  CHANGE `data_movimento` `data_movimento` varchar(200),
  CHANGE `rimborsate` `rimborsate` int(10),
  CHANGE `sottoscritte` `sottoscritte` int(10),
CHANGE `ID_Soci_movimenti_quote` `ID_Soci_movimenti_quote` int(10),
DROP PRIMARY KEY,
ADD PRIMARY KEY  (`ID`)
;

CREATE TABLE `Prodotti` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  ADD`nome` varchar(200),
  ADD`categoria` int(10),
  ADD`fornitore` int(10),
  ADD`provenienza` varchar(200),
  ADD`codice` varchar(200),
  ADD`produttore` varchar(200),
  ADD`prezzo` int(10),
  ADD`foto` int(10),
  ADD`sotto_categoria` int(10),
  ADD`allegato` int(10),
  ADD`cooperativa` int(10),
  ADD`bottega` int(10),
  ADD`quantita` int(10),
  ADD`descrizione` longtext,
  ADD`note` longtext,
  `creation_date` date,
  `creation_user` varchar(100),
  `last_modification_date` date,
  `last_modification_user` varchar(100),
  `deletion_date` date,
  `deletion_user` varchar(100),
  `deletion_flag` tinyint(1),
  `activation_flag` tinyint(1),
PRIMARY KEY  (`ID`)) TYPE=MyISAM;

ALTER TABLE `Soci` 
    CHANGE `numero_socio` `numero_socio` varchar(200),
  CHANGE `codice_fiscale` `codice_fiscale` varchar(200),
  CHANGE `data_nascita` `data_nascita` DATETIME,
  CHANGE `comune_nascita` `comune_nascita` int(10),
  CHANGE `provincia_nascita` `provincia_nascita` int(10),
  CHANGE `telefono_casa` `telefono_casa` varchar(200),
  CHANGE `tipologia` `tipologia` int(10),
  CHANGE `telefono_lavoro` `telefono_lavoro` varchar(200),
  CHANGE `telefono_cellulare` `telefono_cellulare` varchar(200),
  CHANGE `professione` `professione` varchar(200),
  CHANGE `numero_domanda` `numero_domanda` varchar(200),
  CHANGE `data_domanda` `data_domanda` DATETIME,
  CHANGE `data_ammissione` `data_ammissione` DATETIME,
  CHANGE `quote_adesione` `quote_adesione` varchar(200),
  CHANGE `valore_quote` `valore_quote` float,
  CHANGE `stato` `stato` int(10),
  CHANGE `data_domanda_recesso` `data_domanda_recesso` DATETIME,
  CHANGE `data_delibera_recesso` `data_delibera_recesso` DATETIME,
  CHANGE `carica` `carica` varchar(200),
  CHANGE `residenza_indirizzo` `residenza_indirizzo` varchar(200),
  CHANGE `residenza_tipo_via` `residenza_tipo_via` int(10),
  CHANGE `residenza_provincia` `residenza_provincia` int(10),
  CHANGE `residenza_numero` `residenza_numero` varchar(200),
  CHANGE `residenza_cap` `residenza_cap` varchar(200),
  CHANGE `residenza_comune` `residenza_comune` int(10),
  DROP PRIMARY KEY,
ADD PRIMARY KEY  (`ID`)
;




-- Fine parte dinamica 



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
