ALTER TABLE `CondizioniLibretto` CHANGE `modalita_rinnovo` `modalita_rinnovo` INT( 10 ) NOT NULL ,
CHANGE `data_inizio_validita` `data_inizio_validita` DATETIME NOT NULL ,
CHANGE `tasso_interesse` `tasso_interesse` DOUBLE NOT NULL ,
CHANGE `codice_condizione` `codice_condizione` VARCHAR( 200 ) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
CHANGE `ID_Cooperative_condizioni_libretti` `ID_Cooperative_condizioni_libretti` INT( 10 ) NOT NULL ;

ALTER TABLE `CondizioniLibretto` ADD UNIQUE (
		`codice_condizione` ,
		`ID_Cooperative_condizioni_libretti`
		);


ALTER TABLE `CondizioniLibretto` ADD INDEX ( `codice_condizione` ) ;

ALTER TABLE `Cooperative` ADD INDEX ( `comune` ) ;

ALTER TABLE `Cooperative` ADD INDEX ( `provincia` ) ;

ALTER TABLE `Cooperative` ADD INDEX ( `regione` ) ;

ALTER TABLE `Cooperative` CHANGE `ragione_sociale` `ragione_sociale` VARCHAR( 200 ) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
CHANGE `indirizzo` `indirizzo` VARCHAR( 200 ) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
CHANGE `tipo_cooperativa` `tipo_cooperativa` INT( 10 ) NOT NULL ,
CHANGE `comune` `comune` INT( 10 ) NOT NULL ,
CHANGE `cap` `cap` VARCHAR( 200 ) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
CHANGE `provincia` `provincia` INT( 10 ) NOT NULL ,
CHANGE `regione` `regione` INT( 10 ) NOT NULL ,
CHANGE `creation_date` `creation_date` DATE NOT NULL ,
CHANGE `creation_user` `creation_user` VARCHAR( 100 ) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ;


ALTER TABLE `Libretti` CHANGE `data_apertura` `data_apertura` DATE NOT NULL ,
CHANGE `ID_CondizioniLibretto_inverse_of_tipo_libretto` `ID_CondizioniLibretto_inverse_of_tipo_libretto` INT( 10 ) NOT NULL;

ALTER TABLE `Libretti` ADD INDEX ( `ID_CondizioniLibretto_inverse_of_tipo_libretto` ) ;

ALTER TABLE `Libretti` ADD UNIQUE (
		`codice_contratto` ,
		`ID_Soci_risparmio`
		);

ALTER TABLE `Movimenti_Libretti` CHANGE `data_movimento` `data_movimento` DATE NOT NULL ,
CHANGE `causale_libretto` `causale_libretto` INT( 10 ) NOT NULL ,
CHANGE `importo` `importo` INT( 10 ) NOT NULL ,
CHANGE `creation_date` `creation_date` DATE NOT NULL ,
CHANGE `creation_user` `creation_user` VARCHAR( 100 ) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
CHANGE `deletion_flag` `deletion_flag` TINYINT( 1 ) NOT NULL ,
CHANGE `activation_flag` `activation_flag` TINYINT( 1 ) NOT NULL ,
CHANGE `ID_Libretti_movimenti` `ID_Libretti_movimenti` INT( 10 ) NOT NULL;

ALTER TABLE `Movimenti_Libretti` ADD INDEX ( `data_movimento` ) ;

ALTER TABLE `Movimenti_Libretti` ADD INDEX ( `data_movimento` ) ;

ALTER TABLE `Movimenti_Quote` CHANGE `data_movimento` `data_movimento` DATE NOT NULL ,
CHANGE `creation_date` `creation_date` DATE NOT NULL ,
CHANGE `creation_user` `creation_user` VARCHAR( 100 ) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
CHANGE `deletion_flag` `deletion_flag` TINYINT( 1 ) NOT NULL ,
CHANGE `activation_flag` `activation_flag` TINYINT( 1 ) NOT NULL ,
CHANGE `causale_quota` `causale_quota` INT( 10 ) NOT NULL ,
CHANGE `di_valore` `di_valore` DOUBLE NOT NULL ;

ALTER TABLE `Movimenti_Quote` ADD INDEX ( `ID_Soci_movimenti_quote` ) ;

ALTER TABLE `Movimenti_Quote` ADD INDEX ( `data_movimento` ) ;


DELETE FROM `_system_class_auth` WHERE `sca_class` = '_system_module' AND `ID__system_group_group_class_auth` =4;

ALTER TABLE `Movimenti_Quote` DROP INDEX `data_movimento` ;
ALTER TABLE `Movimenti_Quote` ADD INDEX ( `causale_quota` ) ;

ALTER TABLE `Movimenti_Libretti` CHANGE `importo` `importo` double NOT NULL; 

INSERT INTO `iniziative`.`_system_decode_class` (
		`ID` ,
		`sdc_description` ,
		`sdc_name` ,
		`creation_date` ,
		`creation_user` ,
		`last_modification_date` ,
		`last_modification_user` ,
		`deletion_date` ,
		`deletion_user` ,
		`deletion_flag` ,
		`activation_flag`
		)
		VALUES (
		'217', NULL , 'causale_prestito', NULL , NULL , NULL , NULL , NULL , NULL , '0', '1'
		);

UPDATE `iniziative`.`_system_decode` SET `sd_class` = '217' WHERE `_system_decode`.`ID` =26081 LIMIT 1;
INSERT INTO `iniziative`.`_system_decode` (
		`ID` ,
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
		`sd_class`
		)
		VALUES (
		NULL , 'Accredito saldo', '8', 'it', NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL , '0', '1', '217'
		);

ALTER TABLE `Libretti` CHANGE `codice_contratto` `codice_contratto` INT NOT NULL ;

drop view if exists View_Movimenti_Libretti_Senza_Quote;
create view View_Movimenti_Libretti_Senza_Quote as
select ML.* from Movimenti_Libretti ML inner join Libretti L on ML.ID_Libretti_movimenti = L.ID where not exists
(select 1 from Movimenti_Quote MQ where MQ.data_movimento = ML.data_movimento and L.ID_Soci_risparmio = MQ.ID_Soci_movimenti_quote and MQ.causale_quota=9 and MQ.activation_flag=1 and MQ.deletion_flag=0)
and ML.deletion_flag=0;


drop view if exists View_Movimenti_Libretti_Senza_Quote_o_Quote_Sbilanciate;
create view View_Movimenti_Libretti_Senza_Quote_o_Quote_Sbilanciate as
select ML.* from Movimenti_Libretti ML inner join Libretti L on ML.ID_Libretti_movimenti = L.ID where not exists
(select 1 from Movimenti_Quote MQ where MQ.data_movimento = ML.data_movimento and L.ID_Soci_risparmio = MQ.ID_Soci_movimenti_quote and MQ.causale_quota=9 and ((MQ.numero_quote * di_valore * 4) >= ML.importo) and MQ.activation_flag=1 and MQ.deletion_flag=0)
and ML.deletion_flag=0;



ALTER TABLE `CondizioniLibretto`
DROP `comuniqcazione_modifiche_giorni`,
DROP `modalita_rinnovo`;

ALTER TABLE `RegolamentoPrestito` ADD `comuniqcazione_modifiche_giorni` INT NULL AFTER `apertura_libretto_dopo_adesione_giorni` ;
ALTER TABLE `Libretti` ADD `modalita_rinnovo` INT NOT NULL AFTER `data_rinnovo` ;
ALTER TABLE `CondizioniLibretto` ADD `note` LONGTEXT NULL AFTER `data_fine_validita` ;








