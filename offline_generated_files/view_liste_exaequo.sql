drop  VIEW if exists `View_Consumatori_ExAequo_Per_ML`;

CREATE VIEW `View_Consumatori_ExAequo_Per_ML` 
AS 
select c.ID, c.activation_flag, c.deletion_flag, c.creation_user, c.`nome` AS `nome`,c.`cognome` AS `cognome`,c.`email` AS `email` from `Consumatori` c
where ((c.`ID_Botteghe_consumatori` in (1,3,5)) and (c.`email` is not null) and (c.`email` <> '')) 
union 
select o.ID, o.activation_flag, o.deletion_flag, o.creation_user, o.`nome` AS `nome`,'' AS `cognome`,o.`email` AS `email` from `Organizzazioni` o
where ((o.`ID_Botteghe_organizzazioni` in (1,3,5)) and (o.`email` is not null) and (o.`email` <> ''))

order by email;



drop  VIEW if exists `View_Soci_ExAequo_Per_ML`;

CREATE VIEW `View_Soci_ExAequo_Per_ML` 
AS 
select c.ID, c.activation_flag, c.deletion_flag, c.creation_user, c.`nome` AS `nome`,c.`cognome` AS `cognome`,c.`email` AS `email` from `Consumatori` c
where c.`ID_Botteghe_consumatori` in (1,3,5) and c.`email` is not null and c.`email` <> ''
and exists (Select 1 from Soci s where s.ID = c.ID_Soci_dati_consumatore and s.deletion_flag=0 and s.data_delibera_recesso is null)
union 
select o.ID, o.activation_flag, o.deletion_flag,  o.creation_user, o.`nome` AS `nome`,'' AS `cognome`,o.`email` AS `email` from `Organizzazioni` o
where o.`ID_Botteghe_organizzazioni` in (1,3,5) and o.`email` is not null and o.`email` <> ''
and exists (Select 1 from Soci s where s.ID = o.ID_Soci_dati_organizzazione and s.deletion_flag=0 and s.data_delibera_recesso is null)
order by email;



update `Libretti` set data_chiusura = null WHERE data_chiusura = '0000-00-00';

drop  VIEW if exists `View_Prestatori_ExAequo_Per_ML`;

CREATE VIEW `View_Prestatori_ExAequo_Per_ML` 
AS 
select c.ID, c.activation_flag, c.deletion_flag, c.creation_user, c.`nome` AS `nome`,c.`cognome` AS `cognome`,c.`email` AS `email` from `Consumatori` c
where c.`ID_Botteghe_consumatori` in (1,3,5) and c.`email` is not null and c.`email` <> ''
and exists (Select 1 from Soci s where s.ID = c.ID_Soci_dati_consumatore and s.deletion_flag=0 and s.data_delibera_recesso is null
and exists (Select 1 from Libretti l where s.ID = l.ID_Soci_risparmio and l.deletion_flag=0 and l.data_chiusura is null)
)
union 
select o.ID, o.activation_flag,o.deletion_flag,  o.creation_user, o.`nome` AS `nome`,'' AS `cognome`,o.`email` AS `email` from `Organizzazioni` o
where o.`ID_Botteghe_organizzazioni` in (1,3,5) and o.`email` is not null and o.`email` <> ''
and exists (Select 1 from Soci s where s.ID = o.ID_Soci_dati_organizzazione and s.deletion_flag=0 and s.data_delibera_recesso is null
and exists (Select 1 from Libretti l where s.ID = l.ID_Soci_risparmio and l.deletion_flag=0 and l.data_chiusura is null))
order by email;



INSERT INTO `_system_module_parameter` (`ID`, `smp_name`, `smp_notes`, `smp_value`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`, `ID__system_module_sm_parameters`) VALUES
(1, 'SYMPA_SYNC', NULL, '/var/tomcat/critical_mid/iniziativesolidali/app/exec/sympa_synclist', '2013-01-02', 'afrascari', '2013-01-02', 'afrascari', NULL, NULL, 0, 1, 25),
(2, 'SYMPA_SYNC_INPUT', NULL, '/var/tomcat/critical_mid/iniziativesolidali/app/exec/list.xml', '2013-01-02', 'afrascari', '2013-01-02', 'afrascari', NULL, NULL, 0, 1, 25);
