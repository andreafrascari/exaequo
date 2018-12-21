create VIEW `View_Consumatori_Non_Soci` AS select * from `Consumatori` where (isnull(`Consumatori`.`ID_Soci_dati_consumatore`) and (`Consumatori`.`activation_flag` = 1) and (`Consumatori`.`deletion_flag` = 0));

create VIEW `View_Organizzazioni_Non_Soci` AS select * from `Organizzazioni` where (isnull(`Organizzazioni`.`ID_Soci_dati_organizzazione`) and (`Organizzazioni`.`activation_flag` = 1) and (`Organizzazioni`.`deletion_flag` = 0));

--Attesa_Sottoscrizione
create view View_Soci_Attesa_Sottoscrizione as select * from Soci where not exists (select 1 from Movimenti_Quote q where q.activation_flag = 1 and q.deletion_flag=0 and q.ID_Soci_movimenti_quote = Soci.ID);

-- Attesa_Delibera_Ammissione
create view View_Soci_Attesa_Delibera_Ammissione as  select * from Soci where  exists (select 1 from Movimenti_Quote q where q.activation_flag = 1 and q.deletion_flag=0 and q.ID_Soci_movimenti_quote = Soci.ID) and data_ammissione is null;

-- attivi
create view View_Soci_Attivi as  select * from Soci  where  exists (select 1 from Movimenti_Quote q where q.activation_flag = 1 and q.deletion_flag=0 and q.ID_Soci_movimenti_quote = Soci.ID) and data_ammissione is not null and data_domanda_recesso is null;

-- Attesa_Delibera_Recesso
create view View_Soci_Attesa_Delibera_Recesso as  select * from Soci where  exists (select 1 from Movimenti_Quote q where q.activation_flag = 1 and q.deletion_flag=0 and q.ID_Soci_movimenti_quote = Soci.ID) and data_ammissione is not null and data_domanda_recesso is not null and data_delibera_recesso is  null 

-- Attesa_Rimborso_Quote
create view View_Soci_Attesa_Rimborso_Quote as  select * from Soci where not  exists (select 1 from Movimenti_Quote q where q.activation_flag = 1 and q.deletion_flag=0 and q.ID_Soci_movimenti_quote = Soci.ID and causale_quota=3) and data_ammissione is not null and data_domanda_recesso is not null and data_delibera_recesso is not null 

-- Receduti
create view View_Soci_Receduti as  select * from Soci where  exists (select 1 from Movimenti_Quote q where q.activation_flag = 1 and q.deletion_flag=0 and q.ID_Soci_movimenti_quote = Soci.ID and causale_quota=3) and data_ammissione is not null and data_domanda_recesso is not null and data_delibera_recesso is not null 
