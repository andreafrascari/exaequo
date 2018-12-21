
DELETE FROM `_system_class_auth` WHERE `sca_class` = '_system_module' AND `ID__system_group_group_class_auth` =4;

DROP TABLE IF EXISTS `_system_log`;
CREATE TABLE IF NOT EXISTS `_system_log` (
`ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
`date` datetime NOT NULL,
`onclass` varchar(101) NOT NULL,
`oninstance` int(11) NOT NULL,
`operation` text NOT NULL,
`result` varchar(200) NOT NULL,
`creation_date` date NOT NULL,
`creation_user` varchar(100) NOT NULL,
`last_modification_date` date DEFAULT NULL,
`last_modification_user` varchar(100) DEFAULT NULL,
`deletion_date` date DEFAULT NULL,
`deletion_user` varchar(100) DEFAULT NULL,
`deletion_flag` tinyint(1) NOT NULL,
`activation_flag` tinyint(1) NOT NULL,
PRIMARY KEY (`ID`),
UNIQUE KEY `date` (`date`,`onclass`,`oninstance`),
KEY `date_2` (`date`),
KEY `onclass` (`onclass`),
KEY `oninstance` (`oninstance`),
KEY `creation_date` (`creation_date`),
KEY `creation_user` (`creation_user`),
KEY `activation_flag` (`activation_flag`),
KEY `deletion_flag` (`deletion_flag`),
KEY `result` (`result`)
);


CREATE TABLE `Estrattoconto` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `allegato` int(10),
  `data` DATE NOT NULL,
  `esito_invio` tinyint(1),
  `importo_altre_quote` double NOT NULL,
  `importo_capitale` double NOT NULL,
  `importo_prestito` double NOT NULL,
  `interessi_indeducibili` double NOT NULL,
  `interessi_lordi` double,
  `interessi_netti` double NOT NULL,
  `inviato_il` DATE,
  `note` longtext,
  `pdf` int(10),
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
`ID_Libretti_estratticonto` int(10) NOT NULL,
INDEX(`ID_Libretti_estratticonto`),
PRIMARY KEY ( `ID` ),
INDEX (`owner_user`),
INDEX (`owner_group`),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)) ENGINE=InnoDB;


CREATE TABLE `InteressiIndeducibili` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `allegato` int(10),
  `data_fine_validita` DATE,
  `data_inizio_validita` DATE NOT NULL,
  `note` longtext,
  `tasso_interesse` double NOT NULL,
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


INSERT INTO `InteressiIndeducibili` (`ID`, `allegato`, `data_fine_validita`, `data_inizio_validita`, `note`, `tasso_interesse`, `owner_user`, `owner_group`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`) VALUES
(1, NULL, '2015-02-22', '2014-01-01', NULL, 1.15, NULL, NULL, '2015-06-23', 'afrascari', '2015-06-30', 'afrascari', NULL, NULL, 0, 1),
(2, NULL, '2015-03-19', '2015-02-23', NULL, 1.1, NULL, NULL, '2015-06-30', 'afrascari', '2015-06-30', 'afrascari', NULL, NULL, 0, 1),
(3, NULL, NULL, '2015-03-20', NULL, 1.05, NULL, NULL, '2015-06-30', 'afrascari', '2015-06-30', 'afrascari', NULL, NULL, 0, 1);

INSERT INTO `CondizioniLibretto` ( `modalita_calcolo_interessi`, `vincolo`, `data_inizio_validita`, `codice_condizione`, `tipologia_deposito`, `data_fine_validita`, `note`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`, `ID_Cooperative_condizioni_libretti`, `owner_user`, `owner_group`) VALUES
( NULL, 1, NULL, 'RECESSO', 1, NULL, NULL, '2015-06-30', 'afrascari', '2015-06-30', 'afrascari', NULL, NULL, 0, 1, 1, NULL, NULL);

INSERT INTO  `iniziativesolidali`.`_system_decode` (
`sd_description` ,
`sd_value` ,
`sd_locale` ,
`sd_notes` ,
`ID__system_decode_sd_parent` ,
`sd_image` ,
`creation_date` ,
`creation_user` ,
`last_modification_date` ,
`last_modification_user` ,
`deletion_date` ,
`deletion_user` ,
`deletion_flag` ,
`activation_flag` ,
`sd_class` ,
`owner_user` ,
`owner_group`
)
VALUES (
  'Prelievo interessi',  '4',  'it', NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL ,  '0',  '1',  '217', NULL , NULL
);

INSERT INTO _system_module_parameter ( ID__system_module_sm_parameters, smp_name, smp_value, activation_flag, deletion_flag, creation_user, creation_date, last_modification_user, last_modification_date ) VALUES( "25", "email-libretti-from", "finanzasolidale@exaequo.bo.it", "1", "0", "afrascari", "2015-06-26", "afrascari", "2015-06-26" );
INSERT INTO _system_module_parameter ( ID__system_module_sm_parameters, smp_name, smp_value, activation_flag, deletion_flag, creation_user, creation_date, last_modification_user, last_modification_date ) VALUES( "25", "email-libretti-ccn", "finanzasolidale@exaequo.bo.it", "1", "0", "afrascari", "2015-06-26", "afrascari", "2015-06-26" );


/* **************  15/7  ****************/
update `Estrattoconto` set `interessi_lordi` = (`interessi_netti` * 1.26);
update `Estrattoconto` set   `interessi_indeducibili` = `interessi_lordi` where `interessi_netti` = `interessi_indeducibili`;

/************************* 23/10/15 *******************/

ALTER TABLE  `Estrattoconto` CHANGE  `importo_altre_quote`  `importo_altre_quote` DECIMAL( 8, 2 ) NOT NULL ,
CHANGE  `importo_capitale`  `importo_capitale` DECIMAL( 8, 2 ) NOT NULL ,
CHANGE  `importo_prestito`  `importo_prestito` DECIMAL( 8, 2 ) NOT NULL ,
CHANGE  `interessi_indeducibili`  `interessi_indeducibili` DECIMAL( 8, 2 ) NOT NULL ,
CHANGE  `interessi_lordi`  `interessi_lordi` DECIMAL( 8, 2 ) NOT NULL ,
CHANGE  `interessi_netti`  `interessi_netti` DECIMAL( 8, 2 ) NOT NULL ;

ALTER TABLE  `Estrattoconto` ADD UNIQUE (
`data` ,
`ID_Libretti_estratticonto`
);

update `Estrattoconto` set `interessi_lordi` = `interessi_netti` / 0.74;

ALTER TABLE  `SimulazioneEstrattoconto` CHANGE  `importo_altre_quote`  `importo_altre_quote` DECIMAL( 8, 2 ) NOT NULL ,
CHANGE  `importo_capitale`  `importo_capitale` DECIMAL( 8, 2 ) NOT NULL ,
CHANGE  `importo_prestito`  `importo_prestito` DECIMAL( 8, 2 ) NOT NULL ,
CHANGE  `interessi_indeducibili`  `interessi_indeducibili` DECIMAL( 8, 2 ) NOT NULL ,
CHANGE  `interessi_lordi`  `interessi_lordi` DECIMAL( 8, 2 ) NOT NULL ,
CHANGE  `interessi_netti`  `interessi_netti` DECIMAL( 8, 2 ) NOT NULL ;

ALTER TABLE  `iniziativesolidali`.`SimulazioneEstrattoconto` DROP INDEX  `codice_libretto` ,
ADD UNIQUE  `codice_libretto` (  `codice_libretto` ,  `data` ) COMMENT  '';



