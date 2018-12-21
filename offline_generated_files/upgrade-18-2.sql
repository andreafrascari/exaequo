CREATE TABLE IF NOT EXISTS `rel__system_document_per_corso_to_CorsiFormazione_documenti_co` (
  `ID__system_document_per_corso` int(10) NOT NULL,
  `ID_CorsiFormazione_documenti_corso` int(10) NOT NULL,
PRIMARY KEY  (`ID__system_document_per_corso` ,`ID_CorsiFormazione_documenti_corso`)
) TYPE=InnoDB;



CREATE TABLE IF NOT EXISTS `rel__system_document_di_sessione_to_SessioniCorsi_documenti` (
  `ID__system_document_di_sessione` int(10) NOT NULL,
  `ID_SessioniCorsi_documenti` int(10) NOT NULL,
PRIMARY KEY  (`ID__system_document_di_sessione` ,`ID_SessioniCorsi_documenti`)
) TYPE=InnoDB;