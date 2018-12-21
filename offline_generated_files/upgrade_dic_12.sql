CREATE TABLE `TassoInteresseLibretto` (
		  `ID` int(10) unsigned NOT NULL auto_increment,
		  `data_fine_validita` DATE,
		  `data_inizio_validita` DATE,
		  `note` longtext,
		  `tasso_interesse` double NOT NULL,
		  `creation_date` date NOT NULL,
		  `creation_user` varchar(100) NOT NULL,
		  `last_modification_date` date,
		  `last_modification_user` varchar(100),
		  `deletion_date` date,
		  `deletion_user` varchar(100),
		  `deletion_flag` tinyint(1) NOT NULL,
		  `activation_flag` tinyint(1) NOT NULL,
		`ID_CondizioniLibretto_tassi_di_interesse` int(10) NOT NULL,
		INDEX(`ID_CondizioniLibretto_tassi_di_interesse`),
		PRIMARY KEY ( `ID` ),
		INDEX (`creation_user`),
		INDEX (`creation_date`),
		INDEX (`activation_flag`),
		INDEX (`deletion_flag`),
		UNIQUE KEY (`data_inizio_validita`, `ID_CondizioniLibretto_tassi_di_interesse`)
		) ENGINE=InnoDB;



drop view if exists View_Soci_Exaequo; 
create view View_Soci_Exaequo as
select `c`.`nome` AS `nome`,`c`.`cognome` AS `cognome`,`c`.`email` AS `email` from (`View_Soci_Attivi` `s` join `Consumatori` `c` on(((`c`.`ID_Soci_dati_consumatore` = `s`.`ID`) and (`s`.`ID_Cooperative_i_soci` = 1))))
union 
select `c`.`nome` AS `nome`,`c`.`legale_rappresentante` AS `cognome`,`c`.`email` AS `email` from (`View_Soci_Attivi` `s` join `Organizzazioni` `c` on(((`c`.`ID_Soci_dati_organizzazione` = `s`.`ID`) and (`s`.`ID_Cooperative_i_soci` = 1))));


drop view if exists View_Soci_Anagrafica; 
create view View_Soci_Anagrafica as
SELECT CONCAT(c.cognome,' ' ,c.nome) as nome, s.*  FROM  `Soci` s inner join Consumatori c  on s.ID = c.ID_Soci_dati_consumatore
union 
SELECT o.nome as nome, s.*  FROM `Soci` s  inner join Organizzazioni o on s.ID = o.ID_Soci_dati_organizzazione
order by nome;

drop view if exists View_Libretti_Anagrafica; 
create view View_Libretti_Anagrafica as
SELECT s.nome, l.* FROM   Libretti l inner join `View_Soci_Anagrafica` s  on s.ID = l.ID_Soci_risparmio
order by nome;


UPDATE _system_menu_item SET smi_href = "?q=object/filter&p=Soci_Anagrafica" , smi_association = NULL , smi_order = "3" , ID__system_menu_item_smi_children = "17" , smi_locale = "it" , smi_title = "Soci" , smi_alternative_text = "i soci attivi: per soci con operazioni in corso vedi cruscotto o strumenti" , activation_flag = "1" , last_modification_user = "afrascari" , last_modification_date = "2012-12-11"  WHERE ID = 21 ;
UPDATE _system_menu_item SET smi_href = "?q=object/filter&p=Libretti_Anagrafica" , smi_association = NULL , smi_order = "4" , ID__system_menu_item_smi_children = "17" , smi_locale = "it" , smi_title = "Prestito sociale" , smi_alternative_text = "prestito sociale: lista libretti" , activation_flag = "1" , last_modification_user = "afrascari" , last_modification_date = "2012-12-11"  WHERE ID = 43 ;

ALTER TABLE  `Libretti` DROP INDEX  `codice_contratto`;

ALTER TABLE  `Movimenti_Quote` CHANGE  `numero_quote_rimborsate`  `numero_quote_rimborsate` INT( 11 ) NOT NULL DEFAULT  '0';
ALTER TABLE  `Movimenti_Quote` CHANGE  `numero_quote`  `numero_quote` INT( 11 ) NOT NULL DEFAULT  '0';

INSERT INTO  `_system_decode` (
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
NULL ,  'Chiusura Anticipata',  '3',  'it', NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL ,  '0',  '1',  '228'
),
NULL ,  'In Attesa di Chiusura',  '4',  'it', NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL ,  '0',  '1',  '228'
);


ALTER TABLE `Movimenti_Quote`  
ADD `ID_Libretti_quote_relative` int(10);


drop view if exists View_Libretti_Attesa_Chiusura;
create view View_Libretti_Attesa_Chiusura as
select * from View_Libretti_Anagrafica where deletion_flag = 0 and  `stato_libretto` = 4;

drop view if exists View_Libretti_Attesa_Rimborso;
create view View_Libretti_Attesa_Rimborso as
select * from View_Libretti_Anagrafica l where l.deletion_flag = 0 and  `stato_libretto` = 2 and not exists
(select 1 from `Movimenti_Quote` m where m.deletion_flag=0 and m.`ID_Soci_movimenti_quote` = l.`ID_Soci_risparmio` and l.`data_chiusura` = m.`data_movimento` and `causale_quota` =3) ;


drop view if exists View_Libretti_Chiusi;
create view View_Libretti_Chiusi as
select * from View_Libretti_Anagrafica l where l.deletion_flag = 0 and  `stato_libretto` = 2 and exists
(select 1 from `Movimenti_Quote` m where m.deletion_flag=0 and m.`ID_Soci_movimenti_quote` = l.`ID_Soci_risparmio` and l.`data_chiusura` = m.`data_movimento` and `causale_quota` =3) ;



drop view if exists View_Movimenti_Quote_Saldi_Risparmio;
create view View_Movimenti_Quote_Saldi_Risparmio as
SELECT `ID`, `data_movimento`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`, `ID_Soci_movimenti_quote`, `numero_quote`, `numero_quote_rimborsate`, `causale_quota`, (sum(`numero_quote`* `di_valore`) -  sum(`numero_quote_rimborsate`* `di_valore`)) as `di_valore`, `note`,ID_Libretti_quote_relative FROM `Movimenti_Quote` where causale_quota in (3,6,9) and ID_Libretti_quote_relative is not null and deletion_flag = 0 group by `ID_Libretti_quote_relative`;

drop view if exists View_Movimenti_Quote_Saldi_Capitale;
create view View_Movimenti_Quote_Saldi_Capitale as
SELECT `ID`, `data_movimento`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`, `ID_Soci_movimenti_quote`, `numero_quote`, `numero_quote_rimborsate`, `causale_quota`, (sum(`numero_quote`* `di_valore`) -  sum(`numero_quote_rimborsate`* `di_valore`)) as `di_valore`, `note`,ID_Libretti_quote_relative FROM `Movimenti_Quote` where causale_quota not in (3,6,9) and ID_Libretti_quote_relative is null and deletion_flag = 0 group by `ID_Soci_movimenti_quote` ;

drop view if exists View_Movimenti_Quote_Saldi_Adesione;
create view View_Movimenti_Quote_Saldi_Adesione as
SELECT `ID`, `data_movimento`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`, `ID_Soci_movimenti_quote`, `numero_quote`, `numero_quote_rimborsate`, `causale_quota`, (sum(`numero_quote`* `di_valore`) -  sum(`numero_quote_rimborsate`* `di_valore`)) as `di_valore`, `note`,ID_Libretti_quote_relative FROM `Movimenti_Quote` where causale_quota = 2 and ID_Libretti_quote_relative is null and deletion_flag = 0 group by `ID_Soci_movimenti_quote` ;

drop view if exists View_Movimenti_Quote_Saldi_Capitale_No_Adesione;
create view View_Movimenti_Quote_Saldi_Capitale_No_Adesione as
SELECT `ID`, `data_movimento`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`, `ID_Soci_movimenti_quote`, `numero_quote`, `numero_quote_rimborsate`, `causale_quota`, (sum(`numero_quote`* `di_valore`) -  sum(`numero_quote_rimborsate`* `di_valore`)) as `di_valore`, `note`,ID_Libretti_quote_relative FROM `Movimenti_Quote` where causale_quota not in (3,9,2) and ID_Libretti_quote_relative is null and deletion_flag = 0 group by `ID_Soci_movimenti_quote` ;




drop view if exists View_Movimenti_Quote_Risparmio;
create view View_Movimenti_Quote_Risparmio as
SELECT * FROM `Movimenti_Quote` where causale_quota in (3,6,9) and ID_Libretti_quote_relative is not null and deletion_flag = 0 ;

drop view if exists View_Soci_Libretti;
CREATE VIEW `View_Soci_Libretti` AS select * from  `View_Soci_Anagrafica` `s` where deletion_flag=0 and exists  
 ( select 1 from `Libretti` `l`  where `s`.`ID` = `l`.`ID_Soci_risparmio`) order by `s`.`nome`;
 
 
 
 DROP view IF EXISTS `View_Consumatori_ExAequo_Per_ML`;

CREATE   VIEW `View_Consumatori_ExAequo_Per_ML` AS select `c`.`ID` AS `ID`,`c`.`activation_flag` AS `activation_flag`,`c`.`deletion_flag` AS `deletion_flag`,`c`.`creation_user` AS `creation_user`,`c`.`nome` AS `nome`,`c`.`cognome` AS `cognome`,`c`.`email` AS `email` from `Consumatori` `c` where ((`c`.`ID_Botteghe_consumatori` in (1,3,5)) and (`c`.`email` is not null) and (`c`.`email` <> '')) union select `o`.`ID` AS `ID`,`o`.`activation_flag` AS `activation_flag`,`o`.`deletion_flag` AS `deletion_flag`,`o`.`creation_user` AS `creation_user`,`o`.`nome` AS `nome`,'' AS `cognome`,`o`.`email` AS `email` from `Organizzazioni` `o` where ((`o`.`ID_Botteghe_organizzazioni` in (1,3,5)) and (`o`.`email` is not null) and (`o`.`email` <> '')) order by `email`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Prestatori_ExAequo_Per_ML`
--
DROP view IF EXISTS `View_Prestatori_ExAequo_Per_ML`;

CREATE   VIEW `View_Prestatori_ExAequo_Per_ML` AS select `c`.`ID` AS `ID`,`c`.`activation_flag` AS `activation_flag`,`c`.`deletion_flag` AS `deletion_flag`,`c`.`creation_user` AS `creation_user`,`c`.`nome` AS `nome`,`c`.`cognome` AS `cognome`,`c`.`email` AS `email` from `Consumatori` `c` where ((`c`.`ID_Botteghe_consumatori` in (1,3,5)) and (`c`.`email` is not null) and (`c`.`email` <> '') and exists(select 1 AS `1` from `Soci` `s` where ((`s`.`ID` = `c`.`ID_Soci_dati_consumatore`) and (`s`.`deletion_flag` = 0) and isnull(`s`.`data_delibera_recesso`) and exists(select 1 AS `1` from `Libretti` `l` where ((`s`.`ID` = `l`.`ID_Soci_risparmio`) and (`l`.`deletion_flag` = 0) and isnull(`l`.`data_chiusura`)))))) union select `o`.`ID` AS `ID`,`o`.`activation_flag` AS `activation_flag`,`o`.`deletion_flag` AS `deletion_flag`,`o`.`creation_user` AS `creation_user`,`o`.`nome` AS `nome`,'' AS `cognome`,`o`.`email` AS `email` from `Organizzazioni` `o` where ((`o`.`ID_Botteghe_organizzazioni` in (1,3,5)) and (`o`.`email` is not null) and (`o`.`email` <> '') and exists(select 1 AS `1` from `Soci` `s` where ((`s`.`ID` = `o`.`ID_Soci_dati_organizzazione`) and (`s`.`deletion_flag` = 0) and isnull(`s`.`data_delibera_recesso`) and exists(select 1 AS `1` from `Libretti` `l` where ((`s`.`ID` = `l`.`ID_Soci_risparmio`) and (`l`.`deletion_flag` = 0) and isnull(`l`.`data_chiusura`)))))) order by `email`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_ExAequo_Per_ML`
--
DROP view IF EXISTS `View_Soci_ExAequo_Per_ML`;

CREATE   VIEW `View_Soci_ExAequo_Per_ML` AS select `c`.`ID` AS `ID`,`c`.`activation_flag` AS `activation_flag`,`c`.`deletion_flag` AS `deletion_flag`,`c`.`creation_user` AS `creation_user`,`c`.`nome` AS `nome`,`c`.`cognome` AS `cognome`,`c`.`email` AS `email` from `Consumatori` `c` where ((`c`.`ID_Botteghe_consumatori` in (1,3,5)) and (`c`.`email` is not null) and (`c`.`email` <> '') and exists(select 1 AS `1` from `Soci` `s` where ((`s`.`ID` = `c`.`ID_Soci_dati_consumatore`) and (`s`.`deletion_flag` = 0) and isnull(`s`.`data_delibera_recesso`)))) union select `o`.`ID` AS `ID`,`o`.`activation_flag` AS `activation_flag`,`o`.`deletion_flag` AS `deletion_flag`,`o`.`creation_user` AS `creation_user`,`o`.`nome` AS `nome`,'' AS `cognome`,`o`.`email` AS `email` from `Organizzazioni` `o` where ((`o`.`ID_Botteghe_organizzazioni` in (1,3,5)) and (`o`.`email` is not null) and (`o`.`email` <> '') and exists(select 1 AS `1` from `Soci` `s` where ((`s`.`ID` = `o`.`ID_Soci_dati_organizzazione`) and (`s`.`deletion_flag` = 0) and isnull(`s`.`data_delibera_recesso`)))) order by `email`;


