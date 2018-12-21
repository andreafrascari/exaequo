DROP TABLE `RegolamentoPrestito`;

CREATE TABLE `RegolamentoPrestito` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `importo_massimo_prestito` double,
  `ritenuta_fiscale` double,
  `accredito_interessi` varchar(200),
  `liquidazione_interessi_chiusura` int(10),
  `apertura_libretto_dopo_adesione_giorni` int(10),
  `spese_tenuta_conto` double,
  `rapporto_prestito_capitale` int(10),
  `costo_singola_operazione` double,
  `spese_richiesta_documentazione` double,
  `giorni_valuta` int(10),
  `comuniqcazione_modifiche_giorni` int(10),
  `creation_date` date NOT NULL,
  `creation_user` varchar(100) NOT NULL,
  `last_modification_date` date,
  `last_modification_user` varchar(100),
  `deletion_date` date,
  `deletion_user` varchar(100),
  `deletion_flag` tinyint(1) NOT NULL,
  `activation_flag` tinyint(1) NOT NULL,
PRIMARY KEY ( `ID` ),
INDEX (`creation_user`),
INDEX (`creation_date`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

ALTER TABLE `CondizioniLibretto` CHANGE `modalita_calcolo_interessi` `modalita_calcolo_interessi` INT( 10 ) NOT NULL ,
CHANGE `vincolo` `vincolo` INT( 10 ) NOT NULL ,
CHANGE `tipologia_deposito` `tipologia_deposito` INT( 10 ) NOT NULL;

INSERT INTO `iniziative`.`_system_module` (
`ID` ,
`ID__system_menu_item_sm_menu` ,
`sm_name` ,
`sm_order` ,
`sm_java_class` ,
`sm_alternative_text` ,
`sm_description` ,
`sm_show` ,
`sm_position` ,
`sm_default_parameters` ,
`sm_default_call` ,
`sm_auto_load` ,
`ID__system_meta_environment_sme_modules` ,
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
NULL , NULL , 'iniziativesolidali', '10', 'eu.anastasis.serena.inziativesolidali.Iniziative_Module', 'iniziativesolidali', 'iniziativesolidali', 'iniziativesolidali', '5', NULL , NULL , NULL , '1', '2009-01-01', 'afrascari', '2009-01-01', 'afrascari', NULL , NULL , '0', '1'
);

INSERT INTO _system_instance_auth ( ID, ID__system_group_sia_group, sia_permissions, activation_flag, deletion_flag, creation_user, creation_date, last_modification_user, last_modification_date, sia_instance, sia_class ) VALUES( 51, "8", "111", "1", "0", "afrascari", "2012-09-05", "afrascari", "2012-09-05", "25", "_system_module" );
INSERT INTO _system_instance_auth ( ID, ID__system_group_sia_group, sia_permissions, activation_flag, deletion_flag, creation_user, creation_date, last_modification_user, last_modification_date, sia_instance, sia_class ) VALUES( 52, "1", "111", "1", "0", "afrascari", "2012-09-05", "afrascari", "2012-09-05", "25", "_system_module" );
INSERT INTO _system_instance_auth ( ID, ID__system_group_sia_group, sia_permissions, activation_flag, deletion_flag, creation_user, creation_date, last_modification_user, last_modification_date, sia_instance, sia_class ) VALUES( 53, "7", "111", "1", "0", "afrascari", "2012-09-05", "afrascari", "2012-09-05", "25", "_system_module" );
INSERT INTO _system_instance_auth ( ID, ID__system_group_sia_group, sia_permissions, activation_flag, deletion_flag, creation_user, creation_date, last_modification_user, last_modification_date, sia_instance, sia_class ) VALUES( 54, "2", "111", "1", "0", "afrascari", "2012-09-05", "afrascari", "2012-09-05", "25", "_system_module" );


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
		) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE `_system_module_parameter` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `smp_name` varchar(200),
  `smp_notes` longtext,
  `smp_value` varchar(200),
  `creation_date` date,
  `creation_user` varchar(100),
  `last_modification_date` date,
  `last_modification_user` varchar(100),
  `deletion_date` date,
  `deletion_user` varchar(100),
  `deletion_flag` tinyint(1),
  `activation_flag` tinyint(1),
`ID__system_module_sm_parameters` int(10),
INDEX(`ID__system_module_sm_parameters`),
PRIMARY KEY ( `ID` ),
UNIQUE KEY (`smp_name`, `ID__system_module_sm_parameters`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


CREATE TABLE `_system_file_import` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `sfi_title` varchar(200),
  `sfi_import_class` int(10),
  `sfi_notes` longtext,
  `sfi_res` longtext,
  `sfi_file` int(10),
  `sfi_done` tinyint(1),
  `sfi_override` tinyint(1),
  `creation_date` date,
  `creation_user` varchar(100),
  `last_modification_date` date,
  `last_modification_user` varchar(100),
  `deletion_date` date,
  `deletion_user` varchar(100),
  `deletion_flag` tinyint(1),
  `activation_flag` tinyint(1),
PRIMARY KEY ( `ID` ),
UNIQUE KEY (`sfi_title`, `sfi_import_class`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;
--
-- Struttura della tabella `_system_error`
--

DROP TABLE IF EXISTS `_system_error`;
CREATE TABLE IF NOT EXISTS `_system_error` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `code` varchar(200) default NULL,
  `documentation` longtext NOT NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ;

--
-- Dump dei dati per la tabella `_system_error`
--

INSERT INTO `_system_error` (`ID`, `code`, `documentation`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`) VALUES
(1, 'generic_error', ' Errore generico, utilizzato nella gestione delle eccezioni non meglio specificate.<br /><br />Parametri:<br />Non ha parametri<br /> ', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(2, 'missing_required_field', 'Errore di validazione. E'' assente un campo obbligatorio.<br /><br />Parametri:<br />@PAR_0@ nome del campo che ha generato l''errore<br /> ', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(3, 'invalid_captcha', 'Errore generato se fallisce il riconoscimento della captcha<br /><br />Parametri:<br />Non ha parametri<br /> ', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(4, 'invalid_param_in_query_string', 'Errore generato se nella querystring vengono individuati parametri non validi<br /><br />Parametri:<br />Non ha parametri<br />', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(5, 'existing_user', ' Errore generato dalla form di registrazione quando tenta di registrarsi un utente gi&#224; presente nel database.<br /><br />Parametri:<br /> Non ha parametri', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(6, 'field_too_short', 'Errore di validazione. Campo troppo corto<br /><br />Parametri:<br />@PAR_0@ campo che ha generato l''errore<br />@PAR_1@ lunghezza minima<br /> ', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(7, 'field_too_long', 'Errore di validazione. Campo troppo lungo<br /><br />Parametri:<br />@PAR_0@ campo che ha generato l''errore<br />@PAR_1@ lunghezza massima ', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(8, 'data_is_not_a_number', 'Errore di validazione. Il campo, dichiarato come numero, non corrisponde ad un numero.<br /><br />Parametri:<br />@PAR_0@ nome del campo che ha generato l''errore ', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(9, 'data_is_not_a_valid_email', '   Errore di validazione. Il campo, dichiarato come email, non corrisponde ad un indirizzo valido<br /><br />Parametri:<br />@PAR_0@ nome del campo che ha generato l''errore  ', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(12, 'expiring_password_email_body', ' Corpo del messaggio per l''email di avviso di scadenza password<br /><br />Parametri<br />@PAR_0@=nome dell''applicazione<br />@PAR_1@=id utente<br />', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(13, 'expiring_password_email_obj', 'Oggetto dell''email mandata in caso di scadenza password<br /><br />Parametri:<br />Nessun parametro<br />', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(15, 'unrecognized_captcha', 'Errore di riconoscimento del captcha. Il dato immesso non corrisponde a quello richiesto<br /><br />Parametri:<br />Nessun parametro.<br /> ', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(16, 'no_permission', 'Messaggio di errore generato nel caso in cui l''utente tenti un''azione non permessa', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(17, 'generic_sql_error', 'Errore sql non ulteriormente specificato  ', '2009-09-01', 'admin', '2009-09-01', 'admin', NULL, NULL, 0, 1),
(18, 'missing_required_parameter', ' Errore nella chiamata del metodo. E'' assente un parametro obbigatorio<br /><br />Parametri:<br />@PAR_0@ nome del modulo chiamato<br />@PAR_1@ nome del metodo chiamato<br />@PAR_2@ nome del parametro mancante<br /><br /><br />', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(19, 'invalid_tax_code', 'Codice fiscale non valido.<br /><br />Non ha parametri<br /> ', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(20, 'invalid_city', ' Il comune selezionato non &egrave; valido ', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(21, 'tax_code_not_corresponding_to_others_data', 'Il codice fiscale non corrisponde agli altri dati anagrafici. Assicurarsi di non aver scritto il numero cinque al posto di una lettera esse (o viceversa) o il numero zero al posto di una lettera o (o viceversa).', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(22, 'no_permission_for_module_anonimous', ' Errore di permessi specifico per l''accesso ad un modulo per l''utente anonimo<br />', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(23, 'no_permission_for_module_general', ' Errore di permessi specifico per l''accesso ad un modulo generato per tutti gli utenti non anonimi', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(24, 'object_already_exists', 'Errore generato in caso di duplicate entry exception ', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(25, 'token_error', 'Il token manca o &#232; errato. ',NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(26, 'session_expired', 'Sessione scaduta', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(27, 'generic_template_error', 'Generato in caso di assenza o errori nel template', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(28, 'no_method', 'Errore di chiamata.<br />E'' stato richiesto un Serena Method che non esiste.<br /> ', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(29, 'no_user', 'Nome Utente o password non validi.', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(30, 'expired_password', 'La password fornita &#232; scaduta', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(31, 'invalid_url', 'Url non valido', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(32, 'confirm_password_error', 'il campo conferma password non corrisponde alla password', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(33, 'confirm_email_error', 'il campo conferma email non corrisponde alla email', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),	
(34, 'credit_not_enough', 'Non si hanno abbastanza crediti per l''operazione richiesta', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(35, 'recover_password_failed', 'L''invio della mail &egrave; fallito. Assicurarsi che nel proprio profilo sia specificato un indirizzo email corretto', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(36, 'user_already_exists', 'Nome utente gia'' esistente, si prega di sceglierne un altro.', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1),
(37, 'ip_no_permission', 'Messaggio di errore generato nel caso in cui l''utente chieda un''operazione all''Identity Provider senza essere loggato', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `_system_error_message`
--

DROP TABLE IF EXISTS `_system_error_message`;
CREATE TABLE IF NOT EXISTS `_system_error_message` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `language` varchar(200) default NULL,
  `message` varchar(800) default NULL,
  `creation_date` date default NULL,
  `creation_user` varchar(100) default NULL,
  `last_modification_date` date default NULL,
  `last_modification_user` varchar(100) default NULL,
  `deletion_date` date default NULL,
  `deletion_user` varchar(100) default NULL,
  `deletion_flag` tinyint(1) default NULL,
  `activation_flag` tinyint(1) default NULL,
  `ID__system_error_messages` int(10) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `real_key` (`language`,`ID__system_error_messages`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ;

--
-- Dump dei dati per la tabella `_system_error_message`
--

INSERT INTO `_system_error_message` (`ID`, `language`, `message`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`, `ID__system_error_messages`) VALUES
(1, 'IT', 'Si &egrave; verificato un errore non previsto', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 1),
(2, 'EN', 'An unknown error has occurred', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 1),
(3, 'IT', '@PAR_0@ &egrave; un campo obbligatorio', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 2),
(4, 'IT', 'Capcha non valido', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 3),
(5, 'EN', 'invalid captcha', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 3),
(6, 'EN', '@PAR_0@  is a required field', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 2),
(7, 'IT', 'Chiamata al modulo non valida', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 4),
(8, 'EN', 'The module received an invalid call', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 4),
(9, 'IT', 'Utente esistente. Inserisci un altro username', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 5),
(10, 'EN', 'Existing user. Try another username', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 5),
(11, 'IT', 'Il campo @PAR_0@ deve contenere almeno @PAR_1@ caratteri', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 6),
(12, 'EN', 'The field @PAR_0@ must contains at least @PAR_1@ characters', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 6),
(13, 'IT', 'Il campo @PAR_0@ puo'' contenere al massimo @PAR_1@ caratteri', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 7),
(14, 'EN', 'The field @PAR_0@ can contains at most @PAR_1@ characters', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 7),
(15, 'IT', 'Il valore di @PAR_0@ deve essere numerico', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 8),
(16, 'EN', '@PAR_0@ must have a numeric format', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 8),
(17, 'IT', 'Il valore di @PAR_0@ deve essere un indirizzo email valido', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 9),
(18, 'EN', '@PAR_0@ must contains a valid email address', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 9),
(19, 'IT', 'Attenzione: password in scadenza per il sito @PAR_0@', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 13),
(20, 'IT', 'La tua password per il sito @PAR_0@ scadra'' tra @PAR_2@ giorni. Sei pregato di aggiornarla. Grazie, lo staff del sito', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 12),(21, 'IT', 'Riconoscimento captcha fallito', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 15),
(22, 'IT', 'Permessi non sufficienti per compiere questa azione. E'' possibile che sia necessario effettuare il login.', '2009-03-23', 'afrascari', '2009-03-23', 'afrascari', NULL, NULL, 0, 1, 16),
(23, 'IT', 'L''applicazione ha generato un errore sql. Contattare l''amministratore di sistema', '2009-09-01', 'admin', '2009-09-01', 'admin', NULL, NULL, 0, 1, 17),
(24, 'IT', 'Il parametro @PAR_2@ &egrave; obbligatorio per il metodo richiesto (@PAR_0@/@PAR_1@)', '2009-09-11', 'admin', '2009-09-11', 'admin', NULL, NULL, 0, 1, 18),
(25, 'IT', 'codice fiscale non valido', NOW(), 'admin',NULL,NULL, NULL, NULL, 0, 1, 19),
(26, 'EN', 'invalid tax code', NOW(), 'admin',NULL, NULL, NULL, NULL, 0, 1, 19),
(27, 'IT', 'Il comune selezionato non &egrave; valido',NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 20),
(28, 'EN', 'The city selected is invalid', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 20),
(29, 'IT', 'Il codice fiscale non corrisponde agli altri dati anagrafici', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 21),
(30, 'EN', 'TO TRANSLATE Il codice fiscale non corrisponde agli altri dati anagrafici',NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 21),
(31, 'IT', 'Sessione scaduta oppure non si dispongono delle autorizzazioni per visualizzare questa pagina. Accedere al sistema con le proprie credenziali e riprovare',NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 22),
(32, 'IT', 'Il tuo profilo utente non ti consente di accedere a questa pagina. Contattare l''amministratore del sistema per maggiori informazioni',NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 23),
(33, 'IT', 'Attenzione l''oggetto inserito &egrave; gi&agrave; presente nella base dati', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 24),
(34, 'IT', 'Si &egrave; verificato un errore: non &egrave; stato possibile portare a termine con successo la richiesta.<br />Le possibili cause sono:<br /><ul><li>Il salvataggio &egrave; stato ripetuto in seguito alla pressione del tasto &quot;indietro&quot;</li></ul>', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 25),
(35, 'EN', 'Session expired after inactivity timeout: please go back to home page and re-login if necessary', '2010-01-21', 'admin', NULL, NULL, NULL, NULL, 0, 1, 26),
(36, 'IT', 'Sessione scaduta per inattivita'': si consiglia di tornare alla home e rieffettuare il logon se necessario', '2010-01-21', 'admin', NULL, NULL, NULL, NULL, 0, 1, 26),
(37, 'IT', 'Pagina inesistente o non disponibile',NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 27),
(38, 'EN', 'Page not found',NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 27),
(39, 'IT', 'Pagina inesistente o non disponibile', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 28),
(40, 'EN', 'Page not found. ', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 28),
(41, 'IT', 'ACCESSO NEGATO. Username e/o Password Errate', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 29),
(42, 'EN', 'ACCESS DENIED. Wrong username and/or password', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 29),
(43, 'IT', 'ACCESSO NEGATO. La password &egrave; scaduta', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 30),
(44, 'EN', 'ACCESS DENIED. Expired password', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 30),
(45, 'IT', 'Indirizzo non valido', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 31),
(46, 'EN', 'Invalid address', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 31),
(47, 'IT', 'Il campo conferma password non corrisponde alla password', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 32),
(48, 'EN', 'Confirm passord field doesn''t match witdh password', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 32),
(49, 'IT', 'Il campo conferma email non corrisponde alla email', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 33),
(50, 'EN', 'Confirm email field doesn''t match witdh email', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 33),
(51, 'IT', 'Non si hanno abbastanza crediti per l''operazione richiesta', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 34),
(52, 'EN', 'Not enough credits to complete the request', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 34),
(53, 'IT', 'L''invio della mail &egrave; fallito. Assicurarsi che nel proprio profilo sia specificato un indirizzo email corretto', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 35),
(54, 'EN', 'Failure sending e-mail. Please check the email address provided in your profile.', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 35),
(55, 'IT', 'Nome utente gia'' esistente, si prega di sceglierne un altro.', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 36),
(56, 'EN', 'Username already exists, please choose another.', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 36),
(57, 'IT', 'Non si hanno i permessi per eseguire questa operazione. Si prega di uscire dall''applicazione e rientrare', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 37),
(58, 'EN', 'No permission: you should log out and re-login.', NOW(), 'admin', NULL, NULL, NULL, NULL, 0, 1, 37);



-- --------------------------------------------------------

--
-- Struttura della tabella `_system_report`
--

CREATE TABLE `_system_report` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `body` longtext NOT NULL,
  `header` longtext,
  `footer` longtext,
  `header_first_page` longtext,
  `footer_last_page` longtext,
  `state` varchar(200),
  `attachment` int(10),
  `creation_date` date,
  `creation_user` varchar(100),
  `last_modification_date` date,
  `last_modification_user` varchar(100),
  `deletion_date` date,
  `deletion_user` varchar(100),
  `deletion_flag` tinyint(1),
  `activation_flag` tinyint(1),
PRIMARY KEY ( `ID` ),
INDEX (`creation_user`),
INDEX (`activation_flag`),
INDEX (`deletion_flag`)) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ;


UPDATE `iniziative`.`_system_decode` SET `sd_description` = 'Prelievo' WHERE `_system_decode`.`ID` =1139 LIMIT 1 ;
UPDATE `iniziative`.`_system_decode` SET `sd_description` = 'Versamento' WHERE `_system_decode`.`ID` =1138 LIMIT 1 ;


ALTER TABLE `CondizioniLibretto` CHANGE `data_inizio_validita` `data_inizio_validita` DATE NOT NULL ,
CHANGE `data_fine_validita` `data_fine_validita` DATE NULL DEFAULT NULL ;

ALTER TABLE `iniziative`.`CondizioniLibretto` DROP INDEX `codice_condizione` ,
ADD UNIQUE `codice_condizione` ( `codice_condizione` , `ID_Cooperative_condizioni_libretti` , `deletion_flag` );

drop view if exists View_Movimenti_Libretti_Saldi;
create view View_Movimenti_Libretti_Saldi as
SELECT `ID`, `data_movimento`, `causale_libretto`, sum(`importo`) as importo, `note`, `numero_effetto`, `allegato`, `mezzo`, `data_valuta`, `banca_di_riferimento_movimento`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`, `ID_Libretti_movimenti` FROM `Movimenti_Libretti`
WHERE deletion_flag=0
group by `ID_Libretti_movimenti`;


drop view if exists View_Movimenti_Quote_Saldi;
create view View_Movimenti_Quote_Saldi as
SELECT `ID`, `data_movimento`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`, `ID_Soci_movimenti_quote`, `numero_quote`, `numero_quote_rimborsate`, `causale_quota`, (sum(`numero_quote`* `di_valore`) -  sum(`numero_quote_rimborsate`* `di_valore`)) as `di_valore`, `note` FROM `Movimenti_Quote` WHERE deletion_flag=0 group by `ID_Soci_movimenti_quote` ;


