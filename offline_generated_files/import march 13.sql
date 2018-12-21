ALTER TABLE `CondizioniLibretto` CHANGE `modalita_calcolo_interessi` `modalita_calcolo_interessi` INT( 10 ) NULL DEFAULT NULL ,
CHANGE `data_inizio_validita` `data_inizio_validita` DATE NULL DEFAULT NULL ;

DELETE FROM `iniziative`.`Libretti` WHERE `Libretti`.`ID` =1398 LIMIT 1 ;
DELETE FROM `iniziative`.`Libretti` WHERE `Libretti`.`ID` =1399 LIMIT 1 ;

update  `_import_movimenti_libretti` i set ID_SOCIO = (select ID from `View_Soci_Anagrafica` v where v.`nome` = i.`TITOLARE LIBRETTO`)

+ wyse = 346

SELECT * FROM `_import_movimenti_libretti` i where not exists (select 1 from `View_Soci_Anagrafica` v where v.`nome` = i.`TITOLARE LIBRETTO`)



insert into  `Libretti` (`codice_contratto`,`ID_Soci_risparmio`, `data_apertura`,  `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_flag`, `activation_flag`)
select `LIBRETTO`, `ID_SOCIO`, `DATA APERTURA`, curdate(), 'atrevisani',curdate(), 'atrevisani', 0,1  FROM `_import_movimenti_libretti`;

update `Libretti` set `stato_libretto` = 0;


update `Libretti` set `ID_CondizioniLibretto_inverse_of_tipo_libretto` = -1;

update `Libretti` set `ID_CondizioniLibretto_inverse_of_tipo_libretto` = 6 where exists
(select 1 from  `_import_movimenti_libretti` where LIBRETTO = codice_contratto and `TIPO CONTRATTO` = 'TRIENNALE / LUG04');


update `Libretti` set `ID_CondizioniLibretto_inverse_of_tipo_libretto` = 3 where exists
(select 1 from  `_import_movimenti_libretti` where LIBRETTO = codice_contratto and `TIPO CONTRATTO` = 'ORDINARIO');

update `Libretti` set `ID_CondizioniLibretto_inverse_of_tipo_libretto` = 4 where exists
(select 1 from  `_import_movimenti_libretti` where LIBRETTO = codice_contratto and `TIPO CONTRATTO` = 'ANNUALE');

update `Libretti` set `ID_CondizioniLibretto_inverse_of_tipo_libretto` = 2 where exists
(select 1 from  `_import_movimenti_libretti` where LIBRETTO = codice_contratto and `TIPO CONTRATTO` = 'ANNUALE / LUG04');

--ANNUALE / LUG04?

--ANTICIPATO?

update `_import_movimenti_libretti` set `ID_LIBRETTO` = (select ID from Libretti where LIBRETTO = codice_contratto)

UPDATE `iniziative`.`_system_decode` SET `sd_value` = '2' WHERE `_system_decode`.`ID` =26081 LIMIT 1 ;

UPDATE `iniziative`.`_system_decode` SET `sd_value` = '3' WHERE `_system_decode`.`ID` =26085 LIMIT 1 ;



update `_import_operazioni` set `ID_LIBRETTO` = (select ID from Libretti where `NUMERO LIBRETTO` = codice_contratto)

update  _import_operazioni i set i.ID_SOCIO = (select ID from `View_Soci_Anagrafica` v where v.`nome` = i.`NOMECOMPLE`)
 

update `_import_operazioni` set `CAUSALE` = 0 where TIPOOPERAZ = 'VERSAMENTO';
update `_import_operazioni` set `CAUSALE` = 1 where TIPOOPERAZ = 'PRELIEVO';
update `_import_operazioni` set `CAUSALE` = 1000 where TIPOOPERAZ = 'RIMBORSO CAPITALE';


update `_import_operazioni` set `CAUSALE_QUOTE` = 9 where TIPOOPERAZ = 'VERSAMENTO';
update `_import_operazioni` set `CAUSALE_QUOTE` = 6 where TIPOOPERAZ = 'PRELIEVO';
update `_import_operazioni` set `CAUSALE_QUOTE` = 3 where TIPOOPERAZ = 'RIMBORSO CAPITALE';


update `_import_operazioni` set `ID_MEZZO` = 2 where MEZZO = 'CONTANTI';
update `_import_operazioni` set `ID_MEZZO` = 0 where MEZZO = 'ASSEGNO BANCARIO';

// Operazioni 2009/10

// movimenti - prelievi

insert into `Movimenti_Libretti` 
(`data_movimento`, `causale_libretto`, `importo`, `mezzo`, `data_valuta`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`,  `deletion_flag`, `activation_flag`, `ID_Libretti_movimenti`)
SELECT   `DATAOPERAZ`,`CAUSALE`, `PRELIEVO`,  `ID_MEZZO`, `DATAVALUTA`,  curdate(), 'atrevisani',curdate(), 'atrevisani', 0,1 ,  `ID_LIBRETTO` FROM `_import_operazioni` WHERE  
TIPOOPERAZ = 'PRELIEVO';

// movimenti - versamenti

insert into `Movimenti_Libretti` 
(`data_movimento`, `causale_libretto`, `importo`, `mezzo`, `data_valuta`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`,  `deletion_flag`, `activation_flag`, `ID_Libretti_movimenti`)
SELECT   `DATAOPERAZ`,`CAUSALE`, `VERSAMENTO`,  `ID_MEZZO`, `DATAVALUTA`,  curdate(), 'atrevisani',curdate(), 'atrevisani', 0,1 ,  `ID_LIBRETTO` FROM `_import_operazioni` WHERE  
TIPOOPERAZ = 'VERSAMENTO';

// quote prelievo

insert into  `Movimenti_Quote` (`data_movimento`, `numero_quote`, `numero_quote_rimborsate`, `causale_quota`, `di_valore`,`creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`,   `deletion_flag`, `activation_flag`, `ID_Soci_movimenti_quote`,  `ID_Libretti_quote_relative`)
SELECT   `DATAOPERAZ`,0, QUOTERIMBO,     `CAUSALE_QUOTE`, 25, curdate(), 'atrevisani',curdate(), 'atrevisani', 0,1 ,  `ID_SOCIO`,  `ID_LIBRETTO` FROM `_import_operazioni` WHERE  
TIPOOPERAZ = 'PRELIEVO';

// quote versamenti

insert into  `Movimenti_Quote` (`data_movimento`, `numero_quote`, `numero_quote_rimborsate`, `causale_quota`, `di_valore`,`creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`,   `deletion_flag`, `activation_flag`, `ID_Soci_movimenti_quote`,  `ID_Libretti_quote_relative`)
SELECT   `DATAOPERAZ`, QUOTEACQUI, 0,   `CAUSALE_QUOTE`, 25, curdate(), 'atrevisani',curdate(), 'atrevisani', 0,1 ,  `ID_SOCIO`,  `ID_LIBRETTO` FROM `_import_operazioni` WHERE  
TIPOOPERAZ = 'VERSAMENTO';


insert into  `Movimenti_Quote` (`data_movimento`, `numero_quote`, `numero_quote_rimborsate`, `causale_quota`, `di_valore`,`creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`,   `deletion_flag`, `activation_flag`, `ID_Soci_movimenti_quote`,  `ID_Libretti_quote_relative`)
SELECT   `DATAOPERAZ`, 0, QUOTERIMBO,    `CAUSALE_QUOTE`, 25, curdate(), 'atrevisani',curdate(), 'atrevisani', 0,1 ,  `ID_SOCIO`,  `ID_LIBRETTO` FROM `_import_operazioni` WHERE  
TIPOOPERAZ = 'RIMBORSO CAPITALE';



// Saldi 2009

// movimenti 

insert into `Movimenti_Libretti` 
(`data_movimento`, `causale_libretto`, `importo`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`,  `deletion_flag`, `activation_flag`, `ID_Libretti_movimenti`)
SELECT `DATAOPERAZ` ,3, `RISPARMIOI`, 
 curdate(), 'atrevisani',curdate(), 'atrevisani', 0,1 , `ID_LIBRETTO`
FROM `_import_movimenti_libretti` ;

// quote

insert into  `Movimenti_Quote` (`data_movimento`, `numero_quote`, `numero_quote_rimborsate`, `causale_quota`, `di_valore`,`creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`,   `deletion_flag`, `activation_flag`, `ID_Soci_movimenti_quote`,  `ID_Libretti_quote_relative`)
SELECT `DATAOPERAZ` ,`QUOTE CAPITALE`,0,9,25,
 curdate(), 'atrevisani',curdate(), 'atrevisani', 0,1 , `ID_SOCIO`, `ID_LIBRETTO`
FROM `_import_movimenti_libretti` ;


// interessi 2009 - NO!!!!!
/*
insert into `Movimenti_Libretti` 
(`data_movimento`, `causale_libretto`, `importo`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`,  `deletion_flag`, `activation_flag`, `ID_Libretti_movimenti`)
SELECT `DATAOPERAZ` ,2, `INTERESSI`, 
 curdate(), 'atrevisani',curdate(), 'atrevisani', 0,1 , `ID_LIBRETTO`
FROM `_import_movimenti_libretti` ;
*/




VERSAMENTO


causali movimenti 

Versamento 	0
Prelievo 	1
Accredito interessi 	2
Accredito saldo 	3


causali quote

Acquisto quote da soci 	0
Perdita per riduzione capitale 	1
Quota di adesione 	2
Rimborso quote per recesso 	3
Sottoscrizione nuove quote 	4
Vendita quote 	5
Rimborso parziale 	6
Accredito saldo 	8
Quota da risparmio 	9
