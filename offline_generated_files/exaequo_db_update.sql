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

ALTER TABLE `Botteghe` 
  CHANGE `nome` `nome` varchar(200) NOT NULL,
  CHANGE `descrizione` `descrizione` longtext,
  CHANGE `indirizzo` `indirizzo` varchar(200) NOT NULL,
  CHANGE `regione` `regione` int(10) NOT NULL,
  CHANGE `provincia` `provincia` int(10) NOT NULL,
  CHANGE `comune` `comune` int(10) NOT NULL,
  CHANGE `cap` `cap` varchar(200) NOT NULL,
  CHANGE `telefono` `telefono` varchar(200),
  CHANGE `email` `email` varchar(200),
  CHANGE `web` `web` varchar(200),
  CHANGE `note` `note` longtext,
  CHANGE `fax` `fax` varchar(200),
        CHANGE `foto` `foto` int(10),
  CHANGE `allegato` `allegato` int(10),
CHANGE `ID_Cooperative_botteghe` `ID_Cooperative_botteghe` int(10) NOT NULL,
INDEX(`ID_Cooperative_botteghe`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `CondizioniLibretto` 
  CHANGE `codice_condizione` `codice_condizione` varchar(200),
  CHANGE `data_inizio_validita` `data_inizio_validita` DATE NOT NULL,
  CHANGE `data_fine_validita` `data_fine_validita` DATE,
  CHANGE `tipologia_deposito` `tipologia_deposito` int(10) NOT NULL,
  CHANGE `vincolo` `vincolo` int(10),
  CHANGE `modalita_calcolo_interessi` `modalita_calcolo_interessi` int(10),
  CHANGE `note` `note` longtext,
    CHANGE `ID_Cooperative_condizioni_libretti` `ID_Cooperative_condizioni_libretti` int(10) NOT NULL,
INDEX(`ID_Cooperative_condizioni_libretti`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`),
UNIQUE KEY (`codice_condizione`)

;

ALTER TABLE `Consumatori` 
  CHANGE `cognome` `cognome` varchar(200) NOT NULL,
  CHANGE `nome` `nome` varchar(200) NOT NULL,
  CHANGE `anno_iscrizione` `anno_iscrizione` int(10) NOT NULL,
  CHANGE `anno_rinnovo` `anno_rinnovo` int(10),
  CHANGE `tipo_via` `tipo_via` int(10),
  CHANGE `presso` `presso` varchar(200),
  CHANGE `indirizzo` `indirizzo` varchar(200),
  CHANGE `regione` `regione` int(10),
  CHANGE `provincia` `provincia` int(10),
  CHANGE `comune` `comune` int(10),
  CHANGE `cap` `cap` varchar(200),
      CHANGE `email` `email` varchar(200),
  CHANGE `note` `note` longtext,
  CHANGE `ID_Soci_dati_consumatore` `ID_Soci_dati_consumatore` int(10),
CHANGE `ID_Botteghe_consumatori` `ID_Botteghe_consumatori` int(10) NOT NULL,
INDEX(`ID_Botteghe_consumatori`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `Cooperative` 
  CHANGE `ragione_sociale` `ragione_sociale` varchar(200) NOT NULL,
  CHANGE `tipo_cooperativa` `tipo_cooperativa` int(10),
  CHANGE `descrizione` `descrizione` longtext,
  CHANGE `indirizzo` `indirizzo` varchar(200) NOT NULL,
  CHANGE `regione` `regione` int(10) NOT NULL,
  CHANGE `provincia` `provincia` int(10) NOT NULL,
  CHANGE `comune` `comune` int(10) NOT NULL,
  CHANGE `cap` `cap` varchar(200) NOT NULL,
  CHANGE `telefono` `telefono` varchar(200) NOT NULL,
  CHANGE `fax` `fax` varchar(200),
  CHANGE `email` `email` varchar(200),
  CHANGE `web` `web` varchar(200),
  CHANGE `nome_mailing_list` `nome_mailing_list` varchar(200),
  CHANGE `email_admin_mailing_list` `email_admin_mailing_list` varchar(200),
  CHANGE `data_chiusura_bilancio` `data_chiusura_bilancio` varchar(200),
  CHANGE `valore_quota` `valore_quota` int(10),
  CHANGE `numero_quote_associazione` `numero_quote_associazione` varchar(200),
  CHANGE `delibera_cda_adesione` `delibera_cda_adesione` int(10),
  CHANGE `delibera_cda_recesso` `delibera_cda_recesso` int(10),
  CHANGE `liquidazione_quote_esercizio_giorni` `liquidazione_quote_esercizio_giorni` varchar(200),
    CHANGE `ID_RegolamentoPrestito_inverse_of_regolamento_prestito` `ID_RegolamentoPrestito_inverse_of_regolamento_prestito` int(10),
            CHANGE `foto` `foto` int(10),
  CHANGE `allegato` `allegato` int(10),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `CorsiFormazione` 
  CHANGE `titolo` `titolo` varchar(200) NOT NULL,
  CHANGE `organizzatore` `organizzatore` varchar(200) NOT NULL,
  CHANGE `abstract` `abstract` longtext NOT NULL,
  CHANGE `luogo` `luogo` varchar(200) NOT NULL,
    CHANGE `logo` `logo` int(10),
  CHANGE `periodo` `periodo` varchar(200),
    CHANGE `allegato` `allegato` int(10),
  CHANGE `allegato_1` `allegato_1` int(10),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `Estrattoconto` 
  CHANGE `data` `data` DATE NOT NULL,
  CHANGE `importo_prestito` `importo_prestito` double NOT NULL,
  CHANGE `importo_capitale` `importo_capitale` double NOT NULL,
  CHANGE `interessi_lordi` `interessi_lordi` double NOT NULL,
  CHANGE `interessi_netti` `interessi_netti` double NOT NULL,
  CHANGE `importo_altre_quote` `importo_altre_quote` double NOT NULL,
  CHANGE `interessi_indeducibili` `interessi_indeducibili` double NOT NULL,
  CHANGE `inviato_il` `inviato_il` DATE,
  CHANGE `esito_invio` `esito_invio` tinyint(1),
  CHANGE `note` `note` longtext,
  CHANGE `pdf` `pdf` int(10) NOT NULL,
  CHANGE `allegato` `allegato` int(10),
CHANGE `ID_Libretti_estratticonto` `ID_Libretti_estratticonto` int(10) NOT NULL,
INDEX(`ID_Libretti_estratticonto`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `Iniziative` 
  CHANGE `nome_iniziativa` `nome_iniziativa` varchar(200) NOT NULL,
  CHANGE `data` `data` DATE NOT NULL,
  CHANGE `descrizione` `descrizione` longtext NOT NULL,
    CHANGE `foto` `foto` int(10),
  CHANGE `allegato_1` `allegato_1` int(10),
  CHANGE `allegato` `allegato` int(10),
CHANGE `ID_Cooperative_cooperativa_iniziative` `ID_Cooperative_cooperativa_iniziative` int(10) NOT NULL,
INDEX(`ID_Cooperative_cooperativa_iniziative`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `InteressiIndeducibili` 
  CHANGE `tasso_interesse` `tasso_interesse` double NOT NULL,
  CHANGE `data_inizio_validita` `data_inizio_validita` DATE NOT NULL,
  CHANGE `data_fine_validita` `data_fine_validita` DATE,
  CHANGE `note` `note` longtext,
  CHANGE `allegato` `allegato` int(10),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `Libretti` 
    CHANGE `codice_contratto` `codice_contratto` varchar(200) NOT NULL,
  CHANGE `data_apertura` `data_apertura` DATE NOT NULL,
  CHANGE `data_rinnovo` `data_rinnovo` DATE,
  CHANGE `modalita_rinnovo` `modalita_rinnovo` int(10) NOT NULL,
  CHANGE `data_scadenza` `data_scadenza` DATE,
  CHANGE `stato_libretto` `stato_libretto` int(10) NOT NULL,
  CHANGE `delega` `delega` int(10),
  CHANGE `banca_di_riferimento` `banca_di_riferimento` varchar(200),
  CHANGE `conto_corrente` `conto_corrente` varchar(200),
  CHANGE `iban` `iban` varchar(27),
    CHANGE `note_contratto` `note_contratto` longtext,
  CHANGE `data_chiusura` `data_chiusura` DATE,
  CHANGE `motivazione_chiusura` `motivazione_chiusura` longtext,
  CHANGE `ID_CondizioniLibretto_inverse_of_tipo_libretto` `ID_CondizioniLibretto_inverse_of_tipo_libretto` int(10) NOT NULL,
INDEX(`ID_CondizioniLibretto_inverse_of_tipo_libretto`),
CHANGE `ID_Soci_risparmio` `ID_Soci_risparmio` int(10) NOT NULL,
INDEX(`ID_Soci_risparmio`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `Movimenti_Libretti` 
  CHANGE `data_movimento` `data_movimento` DATE NOT NULL,
  CHANGE `causale_libretto` `causale_libretto` int(10) NOT NULL,
  CHANGE `importo` `importo` int(10) NOT NULL,
  CHANGE `mezzo` `mezzo` int(10) NOT NULL,
  CHANGE `note` `note` longtext,
  CHANGE `numero_effetto` `numero_effetto` varchar(27),
  CHANGE `banca_di_riferimento_movimento` `banca_di_riferimento_movimento` varchar(200),
  CHANGE `data_valuta` `data_valuta` DATE,
  CHANGE `allegato` `allegato` int(10),
CHANGE `ID_Libretti_movimenti` `ID_Libretti_movimenti` int(10) NOT NULL,
INDEX(`ID_Libretti_movimenti`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `Movimenti_Quote` 
  CHANGE `data_movimento` `data_movimento` DATE NOT NULL,
  CHANGE `causale_quota` `causale_quota` int(10) NOT NULL,
  CHANGE `numero_quote` `numero_quote` int(10),
  CHANGE `numero_quote_rimborsate` `numero_quote_rimborsate` int(10),
  CHANGE `di_valore` `di_valore` int(10) NOT NULL,
  CHANGE `note` `note` varchar(200),
CHANGE `ID_Libretti_quote_relative` `ID_Libretti_quote_relative` int(10) NOT NULL,
INDEX(`ID_Libretti_quote_relative`),
CHANGE `ID_Soci_movimenti_quote` `ID_Soci_movimenti_quote` int(10) NOT NULL,
INDEX(`ID_Soci_movimenti_quote`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `Newsletter` 
  CHANGE `title` `title` varchar(200) NOT NULL,
  CHANGE `teaser` `teaser` longtext,
  CHANGE `body` `body` longtext NOT NULL,
  CHANGE `thumbnail` `thumbnail` int(10),
  CHANGE `allegato` `allegato` int(10) NOT NULL,
  CHANGE `allegato_1` `allegato_1` int(10),
CHANGE `ID_Cooperative_newsletter_di_coop` `ID_Cooperative_newsletter_di_coop` int(10) NOT NULL,
INDEX(`ID_Cooperative_newsletter_di_coop`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `Organizzazioni` 
  CHANGE `nome` `nome` varchar(200) NOT NULL,
  CHANGE `tipo_organizzazione` `tipo_organizzazione` int(10),
  CHANGE `numero` `numero` varchar(200),
  CHANGE `tipo_via` `tipo_via` int(10),
  CHANGE `indirizzo` `indirizzo` varchar(200),
  CHANGE `regione` `regione` int(10),
  CHANGE `provincia` `provincia` int(10),
  CHANGE `comune` `comune` int(10),
  CHANGE `cap` `cap` varchar(200),
  CHANGE `telefono` `telefono` varchar(200),
  CHANGE `fax` `fax` varchar(200),
  CHANGE `email` `email` varchar(200),
  CHANGE `web` `web` varchar(200),
  CHANGE `legale_rappresentante` `legale_rappresentante` varchar(200),
  CHANGE `ID_Soci_dati_organizzazione` `ID_Soci_dati_organizzazione` int(10),
  CHANGE `settore_attivita` `settore_attivita` int(10),
  CHANGE `anno_iscrizione` `anno_iscrizione` int(10),
  CHANGE `anno_rinnovo` `anno_rinnovo` int(10),
  CHANGE `note` `note` longtext,
  CHANGE `ID_Botteghe_organizzazioni` `ID_Botteghe_organizzazioni` int(10) NOT NULL,
INDEX(`ID_Botteghe_organizzazioni`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `Prodotti` 
  CHANGE `nome` `nome` varchar(200) NOT NULL,
  CHANGE `descrizione` `descrizione` longtext NOT NULL,
  CHANGE `foto` `foto` int(10) NOT NULL,
  CHANGE `categoria` `categoria` int(10) NOT NULL,
  CHANGE `sotto_categoria` `sotto_categoria` int(10),
  CHANGE `codice` `codice` varchar(200),
  CHANGE `fornitore` `fornitore` int(10) NOT NULL,
  CHANGE `provenienza` `provenienza` varchar(200) NOT NULL,
  CHANGE `produttore` `produttore` varchar(200) NOT NULL,
  CHANGE `quantita` `quantita` int(10) NOT NULL,
  CHANGE `prezzo` `prezzo` int(10) NOT NULL,
  CHANGE `allegato` `allegato` int(10),
  CHANGE `note` `note` longtext,
CHANGE `ID_Botteghe_prodotti_mercatino` `ID_Botteghe_prodotti_mercatino` int(10) NOT NULL,
INDEX(`ID_Botteghe_prodotti_mercatino`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `RegolamentoPrestito` 
  CHANGE `importo_massimo_prestito` `importo_massimo_prestito` double NOT NULL,
  CHANGE `ritenuta_fiscale` `ritenuta_fiscale` double NOT NULL,
  CHANGE `accredito_interessi` `accredito_interessi` varchar(5) NOT NULL,
  CHANGE `liquidazione_interessi_chiusura` `liquidazione_interessi_chiusura` int(10),
  CHANGE `apertura_libretto_dopo_adesione_giorni` `apertura_libretto_dopo_adesione_giorni` int(10),
  CHANGE `rapporto_prestito_capitale` `rapporto_prestito_capitale` int(10),
  CHANGE `spese_tenuta_conto` `spese_tenuta_conto` double,
  CHANGE `costo_singola_operazione` `costo_singola_operazione` double,
  CHANGE `spese_richiesta_documentazione` `spese_richiesta_documentazione` double,
  CHANGE `giorni_valuta` `giorni_valuta` int(10),
  CHANGE `comuniqcazione_modifiche_giorni` `comuniqcazione_modifiche_giorni` int(10),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `SessioniCorsi` 
  CHANGE `title` `title` varchar(200) NOT NULL,
  CHANGE `argomenti` `argomenti` longtext,
  CHANGE `docenti` `docenti` longtext,
  CHANGE `data` `data` DATE,
    CHANGE `luogo` `luogo` varchar(200),
CHANGE `ID_CorsiFormazione_sessioni` `ID_CorsiFormazione_sessioni` int(10) NOT NULL,
INDEX(`ID_CorsiFormazione_sessioni`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

CREATE TABLE `SimulazioneEstrattoconto` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  ADD`codice_libretto` varchar(200) NOT NULL,
  ADD`data` DATE NOT NULL,
  ADD`di_socio` varchar(200) NOT NULL,
  ADD`importo_altre_quote` double NOT NULL,
  ADD`importo_capitale` double NOT NULL,
  ADD`importo_prestito` double NOT NULL,
  ADD`interessi_indeducibili` double NOT NULL,
  ADD`interessi_lordi` double NOT NULL,
  ADD`interessi_netti` double NOT NULL,
  ADD`note` longtext,
  `owner_user` int(10) unsigned NULL,
  `owner_group` int(10) unsigned NULL,
  `creation_date` date NOT NULL,
  `creation_user` varchar(100) NOT NULL,
  `last_modification_date` date,
  `last_modification_user` varchar(100),
  `deletion_date` date,
  `deletion_user` varchar(100),
  `deletion_flag` tinyint(1) NOT NULL,
  `activation_flag` tinyint(1) NOT NULL,
PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)) ENGINE=InnoDB;

ALTER TABLE `Soci` 
  CHANGE `numero_socio` `numero_socio` varchar(200),
  CHANGE `regione_nascita` `regione_nascita` int(10),
  CHANGE `stato_nascita` `stato_nascita` varchar(200),
  CHANGE `numero_domanda` `numero_domanda` varchar(200),
  CHANGE `codice_fiscale` `codice_fiscale` varchar(16) NOT NULL,
  CHANGE `partita_iva` `partita_iva` varchar(16),
  CHANGE `data_nascita` `data_nascita` DATE,
  CHANGE `genere` `genere` int(10),
  CHANGE `comune_nascita` `comune_nascita` int(10),
  CHANGE `provincia_nascita` `provincia_nascita` int(10),
  CHANGE `data_delibera_domanda_organizzazione` `data_delibera_domanda_organizzazione` DATE,
  CHANGE `telefono_casa` `telefono_casa` varchar(200),
  CHANGE `telefono_lavoro` `telefono_lavoro` varchar(200),
  CHANGE `telefono_cellulare` `telefono_cellulare` varchar(200),
  CHANGE `professione` `professione` varchar(200),
  CHANGE `residenza_regione` `residenza_regione` int(10) NOT NULL,
  CHANGE `data_domanda` `data_domanda` DATE NOT NULL,
  CHANGE `data_ammissione` `data_ammissione` DATE,
  CHANGE `data_domanda_recesso` `data_domanda_recesso` DATE,
  CHANGE `data_delibera_recesso` `data_delibera_recesso` DATE,
  CHANGE `carica` `carica` varchar(200),
  CHANGE `residenza_tipo_via` `residenza_tipo_via` int(10) NOT NULL,
  CHANGE `residenza_indirizzo` `residenza_indirizzo` varchar(200) NOT NULL,
  CHANGE `residenza_comune` `residenza_comune` int(10) NOT NULL,
  CHANGE `residenza_provincia` `residenza_provincia` int(10) NOT NULL,
  CHANGE `residenza_numero` `residenza_numero` varchar(200) NOT NULL,
  CHANGE `residenza_cap` `residenza_cap` varchar(200) NOT NULL,
    CHANGE `ID_Cooperative_i_soci` `ID_Cooperative_i_soci` int(10) NOT NULL,
INDEX(`ID_Cooperative_i_soci`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `Tag` 
  CHANGE `nome` `nome` varchar(200) NOT NULL,
    CHANGE `ID_Cooperative_tag_coop` `ID_Cooperative_tag_coop` int(10) NOT NULL,
INDEX(`ID_Cooperative_tag_coop`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

ALTER TABLE `TassoInteresseLibretto` 
  CHANGE `tasso_interesse` `tasso_interesse` double NOT NULL,
  CHANGE `data_inizio_validita` `data_inizio_validita` DATE,
  CHANGE `data_fine_validita` `data_fine_validita` DATE,
  CHANGE `note` `note` longtext,
CHANGE `ID_CondizioniLibretto_tassi_di_interesse` `ID_CondizioniLibretto_tassi_di_interesse` int(10) NOT NULL,
INDEX(`ID_CondizioniLibretto_tassi_di_interesse`),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`),
UNIQUE KEY (`ID_CondizioniLibretto_tassi_di_interesse`, `data_inizio_validita`)

;

ALTER TABLE `_system_document` 
  CHANGE `title` `title` varchar(200) NOT NULL,
  CHANGE `teaser` `teaser` longtext NOT NULL,
  CHANGE `category` `category` int(10) NOT NULL,
  CHANGE `author` `author` varchar(200),
  CHANGE `file_type` `file_type` int(10) NOT NULL,
  CHANGE `thumbnail` `thumbnail` int(10),
      CHANGE `attachment` `attachment` int(10) NOT NULL,
  CHANGE `attachment_1` `attachment_1` int(10),
DROP PRIMARY KEY,
ADD PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)
;

CREATE TABLE IF NOT EXISTS `rel_Tag_per_consumatori_to_Consumatori_consumatori_tags` (
  `ID_Tag_per_consumatori` int(10) NOT NULL,
  `ID_Consumatori_consumatori_tags` int(10) NOT NULL,
PRIMARY KEY  (`ID_Tag_per_consumatori` ,`ID_Consumatori_consumatori_tags`),
INDEX (`ID_Tag_per_consumatori`),
INDEX (`ID_Consumatori_consumatori_tags`)
) TYPE=InnoDB;

CREATE TABLE IF NOT EXISTS `rel_Iniziative_partecipanti_to_Consumatori_ha_partecipato_a` (
  `ID_Iniziative_partecipanti` int(10) NOT NULL,
  `ID_Consumatori_ha_partecipato_a` int(10) NOT NULL,
PRIMARY KEY  (`ID_Iniziative_partecipanti` ,`ID_Consumatori_ha_partecipato_a`),
INDEX (`ID_Iniziative_partecipanti`),
INDEX (`ID_Consumatori_ha_partecipato_a`)
) TYPE=InnoDB;

CREATE TABLE IF NOT EXISTS `rel__system_document_per_corso_to_CorsiFormazione_documenti_co` (
  `ID__system_document_per_corso` int(10) NOT NULL,
  `ID_CorsiFormazione_documenti_corso` int(10) NOT NULL,
PRIMARY KEY  (`ID__system_document_per_corso` ,`ID_CorsiFormazione_documenti_corso`),
INDEX (`ID__system_document_per_corso`),
INDEX (`ID_CorsiFormazione_documenti_corso`)
) TYPE=InnoDB;

CREATE TABLE IF NOT EXISTS `rel_Tag_per_organizzazioni_to_Organizzazioni_i_tag_relativi` (
  `ID_Tag_per_organizzazioni` int(10) NOT NULL,
  `ID_Organizzazioni_i_tag_relativi` int(10) NOT NULL,
PRIMARY KEY  (`ID_Tag_per_organizzazioni` ,`ID_Organizzazioni_i_tag_relativi`),
INDEX (`ID_Tag_per_organizzazioni`),
INDEX (`ID_Organizzazioni_i_tag_relativi`)
) TYPE=InnoDB;

CREATE TABLE IF NOT EXISTS `rel__system_document_di_sessione_to_SessioniCorsi_documenti` (
  `ID__system_document_di_sessione` int(10) NOT NULL,
  `ID_SessioniCorsi_documenti` int(10) NOT NULL,
PRIMARY KEY  (`ID__system_document_di_sessione` ,`ID_SessioniCorsi_documenti`),
INDEX (`ID__system_document_di_sessione`),
INDEX (`ID_SessioniCorsi_documenti`)
) TYPE=InnoDB;


CREATE TABLE IF NOT EXISTS `rel_CorsiFormazione_tema` (
`ID_CorsiFormazione` int(10) NOT NULL,
`ID_tema` int(10) NOT NULL,
PRIMARY KEY  (`ID_CorsiFormazione`,`ID_tema`)
) ENGINE=InnoDB;


-- Fine parte dinamica 



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
