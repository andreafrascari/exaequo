
--
-- Struttura per la vista `View_Consumatori_ExAequo_Per_ML`
--
DROP VIEW IF EXISTS `View_Consumatori_ExAequo_Per_ML`;

CREATE  VIEW `View_Consumatori_ExAequo_Per_ML` AS select `c`.`ID` AS `ID`,`c`.`activation_flag` AS `activation_flag`,`c`.`deletion_flag` AS `deletion_flag`,`c`.`creation_user` AS `creation_user`,`c`.`nome` AS `nome`,`c`.`cognome` AS `cognome`,`c`.`email` AS `email` from `Consumatori` `c` where ((`c`.`ID_Botteghe_consumatori` in (1,3,5)) and (`c`.`email` is not null) and (`c`.`email` <> '')) union select `o`.`ID` AS `ID`,`o`.`activation_flag` AS `activation_flag`,`o`.`deletion_flag` AS `deletion_flag`,`o`.`creation_user` AS `creation_user`,`o`.`nome` AS `nome`,'' AS `cognome`,`o`.`email` AS `email` from `Organizzazioni` `o` where ((`o`.`ID_Botteghe_organizzazioni` in (1,3,5)) and (`o`.`email` is not null) and (`o`.`email` <> '')) order by `email`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Consumatori_Non_Soci`
--
DROP VIEW IF EXISTS `View_Consumatori_Non_Soci`;

CREATE  VIEW `View_Consumatori_Non_Soci` AS select `Consumatori`.`ID` AS `ID`,`Consumatori`.`numero` AS `numero`,`Consumatori`.`nome` AS `nome`,`Consumatori`.`cognome` AS `cognome`,`Consumatori`.`tipo_via` AS `tipo_via`,`Consumatori`.`anno_rinnovo` AS `anno_rinnovo`,`Consumatori`.`anno_iscrizione` AS `anno_iscrizione`,`Consumatori`.`indirizzo` AS `indirizzo`,`Consumatori`.`presso` AS `presso`,`Consumatori`.`comune` AS `comune`,`Consumatori`.`cap` AS `cap`,`Consumatori`.`provincia` AS `provincia`,`Consumatori`.`email` AS `email`,`Consumatori`.`ID_Soci_dati_consumatore` AS `ID_Soci_dati_consumatore`,`Consumatori`.`note` AS `note`,`Consumatori`.`creation_date` AS `creation_date`,`Consumatori`.`creation_user` AS `creation_user`,`Consumatori`.`last_modification_date` AS `last_modification_date`,`Consumatori`.`last_modification_user` AS `last_modification_user`,`Consumatori`.`deletion_date` AS `deletion_date`,`Consumatori`.`deletion_user` AS `deletion_user`,`Consumatori`.`deletion_flag` AS `deletion_flag`,`Consumatori`.`activation_flag` AS `activation_flag`,`Consumatori`.`ID_Botteghe_consumatori` AS `ID_Botteghe_consumatori`,`Consumatori`.`regione` AS `regione` from `Consumatori` where (isnull(`Consumatori`.`ID_Soci_dati_consumatore`) and (`Consumatori`.`activation_flag` = 1) and (`Consumatori`.`deletion_flag` = 0));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Libretti_Anagrafica`
--
DROP VIEW IF EXISTS `View_Libretti_Anagrafica`;

CREATE  VIEW `View_Libretti_Anagrafica` AS select `s`.`nome` AS `nome`,`l`.`ID` AS `ID`,`l`.`codice_contratto` AS `codice_contratto`,`l`.`delega` AS `delega`,`l`.`data_apertura` AS `data_apertura`,`l`.`note_contratto` AS `note_contratto`,`l`.`data_scadenza` AS `data_scadenza`,`l`.`data_chiusura` AS `data_chiusura`,`l`.`motivazione_chiusura` AS `motivazione_chiusura`,`l`.`banca_di_riferimento` AS `banca_di_riferimento`,`l`.`conto_corrente` AS `conto_corrente`,`l`.`creation_date` AS `creation_date`,`l`.`creation_user` AS `creation_user`,`l`.`last_modification_date` AS `last_modification_date`,`l`.`last_modification_user` AS `last_modification_user`,`l`.`deletion_date` AS `deletion_date`,`l`.`deletion_user` AS `deletion_user`,`l`.`deletion_flag` AS `deletion_flag`,`l`.`activation_flag` AS `activation_flag`,`l`.`ID_Soci_risparmio` AS `ID_Soci_risparmio`,`l`.`stato_libretto` AS `stato_libretto`,`l`.`iban` AS `iban`,`l`.`data_rinnovo` AS `data_rinnovo`,`l`.`modalita_rinnovo` AS `modalita_rinnovo`,`l`.`ID_CondizioniLibretto_inverse_of_tipo_libretto` AS `ID_CondizioniLibretto_inverse_of_tipo_libretto` from (`Libretti` `l` join `View_Soci_Anagrafica` `s` on((`s`.`ID` = `l`.`ID_Soci_risparmio`))) where l.deletion_flag=0 order by `s`.`nome`;
-- --------------------------------------------------------

--
-- Struttura per la vista `View_Libretti_Attesa_Chiusura`
--
DROP VIEW IF EXISTS `View_Libretti_Attesa_Chiusura`;

CREATE  VIEW `View_Libretti_Attesa_Chiusura` AS select `View_Libretti_Anagrafica`.`nome` AS `nome`,`View_Libretti_Anagrafica`.`ID` AS `ID`,`View_Libretti_Anagrafica`.`codice_contratto` AS `codice_contratto`,`View_Libretti_Anagrafica`.`delega` AS `delega`,`View_Libretti_Anagrafica`.`data_apertura` AS `data_apertura`,`View_Libretti_Anagrafica`.`note_contratto` AS `note_contratto`,`View_Libretti_Anagrafica`.`data_scadenza` AS `data_scadenza`,`View_Libretti_Anagrafica`.`data_chiusura` AS `data_chiusura`,`View_Libretti_Anagrafica`.`motivazione_chiusura` AS `motivazione_chiusura`,`View_Libretti_Anagrafica`.`banca_di_riferimento` AS `banca_di_riferimento`,`View_Libretti_Anagrafica`.`conto_corrente` AS `conto_corrente`,`View_Libretti_Anagrafica`.`creation_date` AS `creation_date`,`View_Libretti_Anagrafica`.`creation_user` AS `creation_user`,`View_Libretti_Anagrafica`.`last_modification_date` AS `last_modification_date`,`View_Libretti_Anagrafica`.`last_modification_user` AS `last_modification_user`,`View_Libretti_Anagrafica`.`deletion_date` AS `deletion_date`,`View_Libretti_Anagrafica`.`deletion_user` AS `deletion_user`,`View_Libretti_Anagrafica`.`deletion_flag` AS `deletion_flag`,`View_Libretti_Anagrafica`.`activation_flag` AS `activation_flag`,`View_Libretti_Anagrafica`.`ID_Soci_risparmio` AS `ID_Soci_risparmio`,`View_Libretti_Anagrafica`.`stato_libretto` AS `stato_libretto`,`View_Libretti_Anagrafica`.`iban` AS `iban`,`View_Libretti_Anagrafica`.`data_rinnovo` AS `data_rinnovo`,`View_Libretti_Anagrafica`.`modalita_rinnovo` AS `modalita_rinnovo`,`View_Libretti_Anagrafica`.`ID_CondizioniLibretto_inverse_of_tipo_libretto` AS `ID_CondizioniLibretto_inverse_of_tipo_libretto` from `View_Libretti_Anagrafica` where ((`View_Libretti_Anagrafica`.`deletion_flag` = 0) and (`View_Libretti_Anagrafica`.`stato_libretto` = 4));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Libretti_Attesa_Rimborso`
--
DROP VIEW IF EXISTS `View_Libretti_Attesa_Rimborso`;

CREATE  VIEW `View_Libretti_Attesa_Rimborso` AS select `l`.`nome` AS `nome`,`l`.`ID` AS `ID`,`l`.`codice_contratto` AS `codice_contratto`,`l`.`delega` AS `delega`,`l`.`data_apertura` AS `data_apertura`,`l`.`note_contratto` AS `note_contratto`,`l`.`data_scadenza` AS `data_scadenza`,`l`.`data_chiusura` AS `data_chiusura`,`l`.`motivazione_chiusura` AS `motivazione_chiusura`,`l`.`banca_di_riferimento` AS `banca_di_riferimento`,`l`.`conto_corrente` AS `conto_corrente`,`l`.`creation_date` AS `creation_date`,`l`.`creation_user` AS `creation_user`,`l`.`last_modification_date` AS `last_modification_date`,`l`.`last_modification_user` AS `last_modification_user`,`l`.`deletion_date` AS `deletion_date`,`l`.`deletion_user` AS `deletion_user`,`l`.`deletion_flag` AS `deletion_flag`,`l`.`activation_flag` AS `activation_flag`,`l`.`ID_Soci_risparmio` AS `ID_Soci_risparmio`,`l`.`stato_libretto` AS `stato_libretto`,`l`.`iban` AS `iban`,`l`.`data_rinnovo` AS `data_rinnovo`,`l`.`modalita_rinnovo` AS `modalita_rinnovo`,`l`.`ID_CondizioniLibretto_inverse_of_tipo_libretto` AS `ID_CondizioniLibretto_inverse_of_tipo_libretto` from `View_Libretti_Anagrafica` `l` where ((`l`.`deletion_flag` = 0) and (`l`.`stato_libretto` = 2) and (not(exists(select 1 from `Movimenti_Quote` `m` where ((`m`.`deletion_flag` = 0) and (`m`.`ID_Soci_movimenti_quote` = `l`.`ID_Soci_risparmio`) and (`l`.`data_chiusura` = `m`.`data_movimento`) and (`m`.`causale_quota` = 3))))));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Libretti_Chiusi`
--
DROP VIEW IF EXISTS `View_Libretti_Chiusi`;

CREATE  VIEW `View_Libretti_Chiusi` AS select `l`.`nome` AS `nome`,`l`.`ID` AS `ID`,`l`.`codice_contratto` AS `codice_contratto`,`l`.`delega` AS `delega`,`l`.`data_apertura` AS `data_apertura`,`l`.`note_contratto` AS `note_contratto`,`l`.`data_scadenza` AS `data_scadenza`,`l`.`data_chiusura` AS `data_chiusura`,`l`.`motivazione_chiusura` AS `motivazione_chiusura`,`l`.`banca_di_riferimento` AS `banca_di_riferimento`,`l`.`conto_corrente` AS `conto_corrente`,`l`.`creation_date` AS `creation_date`,`l`.`creation_user` AS `creation_user`,`l`.`last_modification_date` AS `last_modification_date`,`l`.`last_modification_user` AS `last_modification_user`,`l`.`deletion_date` AS `deletion_date`,`l`.`deletion_user` AS `deletion_user`,`l`.`deletion_flag` AS `deletion_flag`,`l`.`activation_flag` AS `activation_flag`,`l`.`ID_Soci_risparmio` AS `ID_Soci_risparmio`,`l`.`stato_libretto` AS `stato_libretto`,`l`.`iban` AS `iban`,`l`.`data_rinnovo` AS `data_rinnovo`,`l`.`modalita_rinnovo` AS `modalita_rinnovo`,`l`.`ID_CondizioniLibretto_inverse_of_tipo_libretto` AS `ID_CondizioniLibretto_inverse_of_tipo_libretto` from `View_Libretti_Anagrafica` `l` where ((`l`.`deletion_flag` = 0) and (`l`.`stato_libretto` = 2) and exists(select 1 from `Movimenti_Quote` `m` where ((`m`.`deletion_flag` = 0) and (`m`.`ID_Soci_movimenti_quote` = `l`.`ID_Soci_risparmio`) and (`l`.`data_chiusura` = `m`.`data_movimento`) and (`m`.`causale_quota` = 3))));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Movimenti_Libretti_Saldi`
--
DROP VIEW IF EXISTS `View_Movimenti_Libretti_Saldi`;

CREATE  VIEW `View_Movimenti_Libretti_Saldi` AS select `Movimenti_Libretti`.`ID` AS `ID`,`Movimenti_Libretti`.`data_movimento` AS `data_movimento`,`Movimenti_Libretti`.`causale_libretto` AS `causale_libretto`,sum(`Movimenti_Libretti`.`importo`) AS `importo`,`Movimenti_Libretti`.`note` AS `note`,`Movimenti_Libretti`.`numero_effetto` AS `numero_effetto`,`Movimenti_Libretti`.`allegato` AS `allegato`,`Movimenti_Libretti`.`mezzo` AS `mezzo`,`Movimenti_Libretti`.`data_valuta` AS `data_valuta`,`Movimenti_Libretti`.`banca_di_riferimento_movimento` AS `banca_di_riferimento_movimento`,`Movimenti_Libretti`.`creation_date` AS `creation_date`,`Movimenti_Libretti`.`creation_user` AS `creation_user`,`Movimenti_Libretti`.`last_modification_date` AS `last_modification_date`,`Movimenti_Libretti`.`last_modification_user` AS `last_modification_user`,`Movimenti_Libretti`.`deletion_date` AS `deletion_date`,`Movimenti_Libretti`.`deletion_user` AS `deletion_user`,`Movimenti_Libretti`.`deletion_flag` AS `deletion_flag`,`Movimenti_Libretti`.`activation_flag` AS `activation_flag`,`Movimenti_Libretti`.`ID_Libretti_movimenti` AS `ID_Libretti_movimenti` from `Movimenti_Libretti` where (`Movimenti_Libretti`.`deletion_flag` = 0) group by `Movimenti_Libretti`.`ID_Libretti_movimenti`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Movimenti_Libretti_Senza_Quote`
--
DROP VIEW IF EXISTS `View_Movimenti_Libretti_Senza_Quote`;

CREATE  VIEW `View_Movimenti_Libretti_Senza_Quote` AS select `ML`.`ID` AS `ID`,`ML`.`data_movimento` AS `data_movimento`,`ML`.`causale_libretto` AS `causale_libretto`,`ML`.`importo` AS `importo`,`ML`.`note` AS `note`,`ML`.`numero_effetto` AS `numero_effetto`,`ML`.`allegato` AS `allegato`,`ML`.`mezzo` AS `mezzo`,`ML`.`data_valuta` AS `data_valuta`,`ML`.`banca_di_riferimento_movimento` AS `banca_di_riferimento_movimento`,`ML`.`creation_date` AS `creation_date`,`ML`.`creation_user` AS `creation_user`,`ML`.`last_modification_date` AS `last_modification_date`,`ML`.`last_modification_user` AS `last_modification_user`,`ML`.`deletion_date` AS `deletion_date`,`ML`.`deletion_user` AS `deletion_user`,`ML`.`deletion_flag` AS `deletion_flag`,`ML`.`activation_flag` AS `activation_flag`,`ML`.`ID_Libretti_movimenti` AS `ID_Libretti_movimenti` from (`Movimenti_Libretti` `ML` join `Libretti` `L` on((`ML`.`ID_Libretti_movimenti` = `L`.`ID`))) where ((not(exists(select 1 AS `1` from `Movimenti_Quote` `MQ` where ((`MQ`.`data_movimento` = `ML`.`data_movimento`) and (`L`.`ID_Soci_risparmio` = `MQ`.`ID_Soci_movimenti_quote`) and (`MQ`.`causale_quota` = 9) and (`MQ`.`activation_flag` = 1) and (`MQ`.`deletion_flag` = 0))))) and (`ML`.`deletion_flag` = 0));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Movimenti_Libretti_Senza_Quote_o_Quote_Sbilanciate`
--
DROP VIEW IF EXISTS `View_Movimenti_Libretti_Senza_Quote_o_Quote_Sbilanciate`;

CREATE  VIEW `View_Movimenti_Libretti_Senza_Quote_o_Quote_Sbilanciate` AS select `ML`.`ID` AS `ID`,`ML`.`data_movimento` AS `data_movimento`,`ML`.`causale_libretto` AS `causale_libretto`,`ML`.`importo` AS `importo`,`ML`.`note` AS `note`,`ML`.`numero_effetto` AS `numero_effetto`,`ML`.`allegato` AS `allegato`,`ML`.`mezzo` AS `mezzo`,`ML`.`data_valuta` AS `data_valuta`,`ML`.`banca_di_riferimento_movimento` AS `banca_di_riferimento_movimento`,`ML`.`creation_date` AS `creation_date`,`ML`.`creation_user` AS `creation_user`,`ML`.`last_modification_date` AS `last_modification_date`,`ML`.`last_modification_user` AS `last_modification_user`,`ML`.`deletion_date` AS `deletion_date`,`ML`.`deletion_user` AS `deletion_user`,`ML`.`deletion_flag` AS `deletion_flag`,`ML`.`activation_flag` AS `activation_flag`,`ML`.`ID_Libretti_movimenti` AS `ID_Libretti_movimenti` from (`Movimenti_Libretti` `ML` join `Libretti` `L` on((`ML`.`ID_Libretti_movimenti` = `L`.`ID`))) where ((not(exists(select 1 AS `1` from `Movimenti_Quote` `MQ` where ((`MQ`.`data_movimento` = `ML`.`data_movimento`) and (`L`.`ID_Soci_risparmio` = `MQ`.`ID_Soci_movimenti_quote`) and (`MQ`.`causale_quota` = 9) and (((`MQ`.`numero_quote` * `MQ`.`di_valore`) * 4) >= `ML`.`importo`) and (`MQ`.`activation_flag` = 1) and (`MQ`.`deletion_flag` = 0))))) and (`ML`.`deletion_flag` = 0));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Movimenti_Quote_Risparmio`
--
DROP VIEW IF EXISTS `View_Movimenti_Quote_Risparmio`;

CREATE  VIEW `View_Movimenti_Quote_Risparmio` AS select `Movimenti_Quote`.`ID` AS `ID`,`Movimenti_Quote`.`data_movimento` AS `data_movimento`,`Movimenti_Quote`.`creation_date` AS `creation_date`,`Movimenti_Quote`.`creation_user` AS `creation_user`,`Movimenti_Quote`.`last_modification_date` AS `last_modification_date`,`Movimenti_Quote`.`last_modification_user` AS `last_modification_user`,`Movimenti_Quote`.`deletion_date` AS `deletion_date`,`Movimenti_Quote`.`deletion_user` AS `deletion_user`,`Movimenti_Quote`.`deletion_flag` AS `deletion_flag`,`Movimenti_Quote`.`activation_flag` AS `activation_flag`,`Movimenti_Quote`.`ID_Soci_movimenti_quote` AS `ID_Soci_movimenti_quote`,`Movimenti_Quote`.`numero_quote` AS `numero_quote`,`Movimenti_Quote`.`numero_quote_rimborsate` AS `numero_quote_rimborsate`,`Movimenti_Quote`.`causale_quota` AS `causale_quota`,`Movimenti_Quote`.`di_valore` AS `di_valore`,`Movimenti_Quote`.`note` AS `note`,`Movimenti_Quote`.`ID_Libretti_quote_relative` AS `ID_Libretti_quote_relative` from `Movimenti_Quote` where ((`Movimenti_Quote`.`causale_quota` in (0,3,5,6,9)) and (`Movimenti_Quote`.`ID_Libretti_quote_relative` is not null) and (`Movimenti_Quote`.`deletion_flag` = 0));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Movimenti_Quote_Saldi`
--
DROP VIEW IF EXISTS `View_Movimenti_Quote_Saldi`;

CREATE  VIEW `View_Movimenti_Quote_Saldi` AS select `Movimenti_Quote`.`ID` AS `ID`,`Movimenti_Quote`.`data_movimento` AS `data_movimento`,`Movimenti_Quote`.`creation_date` AS `creation_date`,`Movimenti_Quote`.`creation_user` AS `creation_user`,`Movimenti_Quote`.`last_modification_date` AS `last_modification_date`,`Movimenti_Quote`.`last_modification_user` AS `last_modification_user`,`Movimenti_Quote`.`deletion_date` AS `deletion_date`,`Movimenti_Quote`.`deletion_user` AS `deletion_user`,`Movimenti_Quote`.`deletion_flag` AS `deletion_flag`,`Movimenti_Quote`.`activation_flag` AS `activation_flag`,`Movimenti_Quote`.`ID_Soci_movimenti_quote` AS `ID_Soci_movimenti_quote`,`Movimenti_Quote`.`numero_quote` AS `numero_quote`,`Movimenti_Quote`.`numero_quote_rimborsate` AS `numero_quote_rimborsate`,`Movimenti_Quote`.`causale_quota` AS `causale_quota`,(sum((`Movimenti_Quote`.`numero_quote` * `Movimenti_Quote`.`di_valore`)) - sum((`Movimenti_Quote`.`numero_quote_rimborsate` * `Movimenti_Quote`.`di_valore`))) AS `di_valore`,`Movimenti_Quote`.`note` AS `note` from `Movimenti_Quote` where (`Movimenti_Quote`.`deletion_flag` = 0) group by `Movimenti_Quote`.`ID_Soci_movimenti_quote`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Movimenti_Quote_Saldi_Adesione`
--
DROP VIEW IF EXISTS `View_Movimenti_Quote_Saldi_Adesione`;

CREATE  VIEW `View_Movimenti_Quote_Saldi_Adesione` AS select `Movimenti_Quote`.`ID` AS `ID`,`Movimenti_Quote`.`data_movimento` AS `data_movimento`,`Movimenti_Quote`.`creation_date` AS `creation_date`,`Movimenti_Quote`.`creation_user` AS `creation_user`,`Movimenti_Quote`.`last_modification_date` AS `last_modification_date`,`Movimenti_Quote`.`last_modification_user` AS `last_modification_user`,`Movimenti_Quote`.`deletion_date` AS `deletion_date`,`Movimenti_Quote`.`deletion_user` AS `deletion_user`,`Movimenti_Quote`.`deletion_flag` AS `deletion_flag`,`Movimenti_Quote`.`activation_flag` AS `activation_flag`,`Movimenti_Quote`.`ID_Soci_movimenti_quote` AS `ID_Soci_movimenti_quote`,`Movimenti_Quote`.`numero_quote` AS `numero_quote`,`Movimenti_Quote`.`numero_quote_rimborsate` AS `numero_quote_rimborsate`,`Movimenti_Quote`.`causale_quota` AS `causale_quota`,(sum((`Movimenti_Quote`.`numero_quote` * `Movimenti_Quote`.`di_valore`)) - sum((`Movimenti_Quote`.`numero_quote_rimborsate` * `Movimenti_Quote`.`di_valore`))) AS `di_valore`,`Movimenti_Quote`.`note` AS `note`,`Movimenti_Quote`.`ID_Libretti_quote_relative` AS `ID_Libretti_quote_relative` from `Movimenti_Quote` where ((`Movimenti_Quote`.`causale_quota` = 2) and isnull(`Movimenti_Quote`.`ID_Libretti_quote_relative`) and (`Movimenti_Quote`.`deletion_flag` = 0)) group by `Movimenti_Quote`.`ID_Soci_movimenti_quote`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Movimenti_Quote_Saldi_Capitale`
--
DROP VIEW IF EXISTS `View_Movimenti_Quote_Saldi_Capitale`;

CREATE  VIEW `View_Movimenti_Quote_Saldi_Capitale` AS select `Movimenti_Quote`.`ID` AS `ID`,`Movimenti_Quote`.`data_movimento` AS `data_movimento`,`Movimenti_Quote`.`creation_date` AS `creation_date`,`Movimenti_Quote`.`creation_user` AS `creation_user`,`Movimenti_Quote`.`last_modification_date` AS `last_modification_date`,`Movimenti_Quote`.`last_modification_user` AS `last_modification_user`,`Movimenti_Quote`.`deletion_date` AS `deletion_date`,`Movimenti_Quote`.`deletion_user` AS `deletion_user`,`Movimenti_Quote`.`deletion_flag` AS `deletion_flag`,`Movimenti_Quote`.`activation_flag` AS `activation_flag`,`Movimenti_Quote`.`ID_Soci_movimenti_quote` AS `ID_Soci_movimenti_quote`,`Movimenti_Quote`.`numero_quote` AS `numero_quote`,`Movimenti_Quote`.`numero_quote_rimborsate` AS `numero_quote_rimborsate`,`Movimenti_Quote`.`causale_quota` AS `causale_quota`,(sum((`Movimenti_Quote`.`numero_quote` * `Movimenti_Quote`.`di_valore`)) - sum((`Movimenti_Quote`.`numero_quote_rimborsate` * `Movimenti_Quote`.`di_valore`))) AS `di_valore`,`Movimenti_Quote`.`note` AS `note`,`Movimenti_Quote`.`ID_Libretti_quote_relative` AS `ID_Libretti_quote_relative` from `Movimenti_Quote` where ((`Movimenti_Quote`.`causale_quota` not in (0,3,5,6,9)) and isnull(`Movimenti_Quote`.`ID_Libretti_quote_relative`) and (`Movimenti_Quote`.`deletion_flag` = 0)) group by `Movimenti_Quote`.`ID_Soci_movimenti_quote`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Movimenti_Quote_Saldi_Capitale_No_Adesione`
--
DROP VIEW IF EXISTS `View_Movimenti_Quote_Saldi_Capitale_No_Adesione`;

CREATE  VIEW `View_Movimenti_Quote_Saldi_Capitale_No_Adesione` AS select `Movimenti_Quote`.`ID` AS `ID`,`Movimenti_Quote`.`data_movimento` AS `data_movimento`,`Movimenti_Quote`.`creation_date` AS `creation_date`,`Movimenti_Quote`.`creation_user` AS `creation_user`,`Movimenti_Quote`.`last_modification_date` AS `last_modification_date`,`Movimenti_Quote`.`last_modification_user` AS `last_modification_user`,`Movimenti_Quote`.`deletion_date` AS `deletion_date`,`Movimenti_Quote`.`deletion_user` AS `deletion_user`,`Movimenti_Quote`.`deletion_flag` AS `deletion_flag`,`Movimenti_Quote`.`activation_flag` AS `activation_flag`,`Movimenti_Quote`.`ID_Soci_movimenti_quote` AS `ID_Soci_movimenti_quote`,`Movimenti_Quote`.`numero_quote` AS `numero_quote`,`Movimenti_Quote`.`numero_quote_rimborsate` AS `numero_quote_rimborsate`,`Movimenti_Quote`.`causale_quota` AS `causale_quota`,(sum((`Movimenti_Quote`.`numero_quote` * `Movimenti_Quote`.`di_valore`)) - sum((`Movimenti_Quote`.`numero_quote_rimborsate` * `Movimenti_Quote`.`di_valore`))) AS `di_valore`,`Movimenti_Quote`.`note` AS `note`,`Movimenti_Quote`.`ID_Libretti_quote_relative` AS `ID_Libretti_quote_relative` from `Movimenti_Quote` where ((`Movimenti_Quote`.`causale_quota` not in (3,9,2)) and isnull(`Movimenti_Quote`.`ID_Libretti_quote_relative`) and (`Movimenti_Quote`.`deletion_flag` = 0)) group by `Movimenti_Quote`.`ID_Soci_movimenti_quote`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Movimenti_Quote_Saldi_Quote`
--
DROP VIEW IF EXISTS `View_Movimenti_Quote_Saldi_Quote`;

CREATE  VIEW `View_Movimenti_Quote_Saldi_Quote` AS select `Movimenti_Quote`.`ID` AS `ID`,`Movimenti_Quote`.`data_movimento` AS `data_movimento`,`Movimenti_Quote`.`creation_date` AS `creation_date`,`Movimenti_Quote`.`creation_user` AS `creation_user`,`Movimenti_Quote`.`last_modification_date` AS `last_modification_date`,`Movimenti_Quote`.`last_modification_user` AS `last_modification_user`,`Movimenti_Quote`.`deletion_date` AS `deletion_date`,`Movimenti_Quote`.`deletion_user` AS `deletion_user`,`Movimenti_Quote`.`deletion_flag` AS `deletion_flag`,`Movimenti_Quote`.`activation_flag` AS `activation_flag`,`Movimenti_Quote`.`ID_Soci_movimenti_quote` AS `ID_Soci_movimenti_quote`,`Movimenti_Quote`.`numero_quote` AS `numero_quote`,`Movimenti_Quote`.`numero_quote_rimborsate` AS `numero_quote_rimborsate`,`Movimenti_Quote`.`causale_quota` AS `causale_quota`,(sum((`Movimenti_Quote`.`numero_quote` * `Movimenti_Quote`.`di_valore`)) - sum((`Movimenti_Quote`.`numero_quote_rimborsate` * `Movimenti_Quote`.`di_valore`))) AS `di_valore`,`Movimenti_Quote`.`note` AS `note`,`Movimenti_Quote`.`ID_Libretti_quote_relative` AS `ID_Libretti_quote_relative` from `Movimenti_Quote` where ((`Movimenti_Quote`.`causale_quota` not in (3,9)) and isnull(`Movimenti_Quote`.`ID_Libretti_quote_relative`)) and (`Movimenti_Quote`.`deletion_flag` = 0) group by `Movimenti_Quote`.`ID_Soci_movimenti_quote`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Movimenti_Quote_Saldi_Risparmio`
--
DROP VIEW IF EXISTS `View_Movimenti_Quote_Saldi_Risparmio`;

CREATE  VIEW `View_Movimenti_Quote_Saldi_Risparmio` AS select `Movimenti_Quote`.`ID` AS `ID`,`Movimenti_Quote`.`data_movimento` AS `data_movimento`,`Movimenti_Quote`.`creation_date` AS `creation_date`,`Movimenti_Quote`.`creation_user` AS `creation_user`,`Movimenti_Quote`.`last_modification_date` AS `last_modification_date`,`Movimenti_Quote`.`last_modification_user` AS `last_modification_user`,`Movimenti_Quote`.`deletion_date` AS `deletion_date`,`Movimenti_Quote`.`deletion_user` AS `deletion_user`,`Movimenti_Quote`.`deletion_flag` AS `deletion_flag`,`Movimenti_Quote`.`activation_flag` AS `activation_flag`,`Movimenti_Quote`.`ID_Soci_movimenti_quote` AS `ID_Soci_movimenti_quote`,`Movimenti_Quote`.`numero_quote` AS `numero_quote`,`Movimenti_Quote`.`numero_quote_rimborsate` AS `numero_quote_rimborsate`,`Movimenti_Quote`.`causale_quota` AS `causale_quota`,(sum((`Movimenti_Quote`.`numero_quote` * `Movimenti_Quote`.`di_valore`)) - sum((`Movimenti_Quote`.`numero_quote_rimborsate` * `Movimenti_Quote`.`di_valore`))) AS `di_valore`,`Movimenti_Quote`.`note` AS `note`,`Movimenti_Quote`.`ID_Libretti_quote_relative` AS `ID_Libretti_quote_relative` from `Movimenti_Quote` where ((`Movimenti_Quote`.`causale_quota` in (0,3,5,6,9)) and (`Movimenti_Quote`.`ID_Libretti_quote_relative` is not null) and (`Movimenti_Quote`.`deletion_flag` = 0)) group by `Movimenti_Quote`.`ID_Libretti_quote_relative`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Organizzazioni_Non_Soci`
--
DROP VIEW IF EXISTS `View_Organizzazioni_Non_Soci`;

CREATE  VIEW `View_Organizzazioni_Non_Soci` AS select `Organizzazioni`.`ID` AS `ID`,`Organizzazioni`.`nome` AS `nome`,`Organizzazioni`.`ID_Soci_dati_organizzazione` AS `ID_Soci_dati_organizzazione`,`Organizzazioni`.`email` AS `email`,`Organizzazioni`.`numero` AS `numero`,`Organizzazioni`.`tipo_via` AS `tipo_via`,`Organizzazioni`.`indirizzo` AS `indirizzo`,`Organizzazioni`.`comune` AS `comune`,`Organizzazioni`.`cap` AS `cap`,`Organizzazioni`.`provincia` AS `provincia`,`Organizzazioni`.`telefono` AS `telefono`,`Organizzazioni`.`fax` AS `fax`,`Organizzazioni`.`legale_rappresentante` AS `legale_rappresentante`,`Organizzazioni`.`settore_attivita` AS `settore_attivita`,`Organizzazioni`.`note` AS `note`,`Organizzazioni`.`creation_date` AS `creation_date`,`Organizzazioni`.`creation_user` AS `creation_user`,`Organizzazioni`.`last_modification_date` AS `last_modification_date`,`Organizzazioni`.`last_modification_user` AS `last_modification_user`,`Organizzazioni`.`deletion_date` AS `deletion_date`,`Organizzazioni`.`deletion_user` AS `deletion_user`,`Organizzazioni`.`deletion_flag` AS `deletion_flag`,`Organizzazioni`.`activation_flag` AS `activation_flag`,`Organizzazioni`.`ID_Botteghe_organizzazioni` AS `ID_Botteghe_organizzazioni`,`Organizzazioni`.`tipo_organizzazione` AS `tipo_organizzazione`,`Organizzazioni`.`anno_iscrizione` AS `anno_iscrizione`,`Organizzazioni`.`anno_rinnovo` AS `anno_rinnovo`,`Organizzazioni`.`regione` AS `regione`,`Organizzazioni`.`web` AS `web` from `Organizzazioni` where (isnull(`Organizzazioni`.`ID_Soci_dati_organizzazione`) and (`Organizzazioni`.`activation_flag` = 1) and (`Organizzazioni`.`deletion_flag` = 0));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Prestatori_ExAequo_Per_ML`
--
DROP VIEW IF EXISTS `View_Prestatori_ExAequo_Per_ML`;

CREATE  VIEW `View_Prestatori_ExAequo_Per_ML` AS select `c`.`ID` AS `ID`,`c`.`activation_flag` AS `activation_flag`,`c`.`deletion_flag` AS `deletion_flag`,`c`.`creation_user` AS `creation_user`,`c`.`nome` AS `nome`,`c`.`cognome` AS `cognome`,`c`.`email` AS `email` from `Consumatori` `c` where ((`c`.`ID_Botteghe_consumatori` in (1,3,5)) and (`c`.`email` is not null) and (`c`.`email` <> '') and exists(select 1 AS `1` from `Soci` `s` where ((`s`.`ID` = `c`.`ID_Soci_dati_consumatore`) and (`s`.`deletion_flag` = 0) and isnull(`s`.`data_delibera_recesso`) and exists(select 1 AS `1` from `Libretti` `l` where ((`s`.`ID` = `l`.`ID_Soci_risparmio`) and (`l`.`deletion_flag` = 0) and isnull(`l`.`data_chiusura`)))))) union select `o`.`ID` AS `ID`,`o`.`activation_flag` AS `activation_flag`,`o`.`deletion_flag` AS `deletion_flag`,`o`.`creation_user` AS `creation_user`,`o`.`nome` AS `nome`,'' AS `cognome`,`o`.`email` AS `email` from `Organizzazioni` `o` where ((`o`.`ID_Botteghe_organizzazioni` in (1,3,5)) and (`o`.`email` is not null) and (`o`.`email` <> '') and exists(select 1 AS `1` from `Soci` `s` where ((`s`.`ID` = `o`.`ID_Soci_dati_organizzazione`) and (`s`.`deletion_flag` = 0) and isnull(`s`.`data_delibera_recesso`) and exists(select 1 AS `1` from `Libretti` `l` where ((`s`.`ID` = `l`.`ID_Soci_risparmio`) and (`l`.`deletion_flag` = 0) and isnull(`l`.`data_chiusura`)))))) order by `email`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Anagrafica`
--
DROP VIEW IF EXISTS `View_Soci_Anagrafica`;

CREATE  VIEW `View_Soci_Anagrafica` AS select concat(`c`.`cognome`,' ',`c`.`nome`) AS `nome`,`s`.`ID` AS `ID`,`s`.`numero_socio` AS `numero_socio`,`s`.`telefono_casa` AS `telefono_casa`,`s`.`telefono_lavoro` AS `telefono_lavoro`,`s`.`telefono_cellulare` AS `telefono_cellulare`,`s`.`data_nascita` AS `data_nascita`,`s`.`comune_nascita` AS `comune_nascita`,`s`.`provincia_nascita` AS `provincia_nascita`,`s`.`professione` AS `professione`,`s`.`numero_domanda` AS `numero_domanda`,`s`.`data_domanda` AS `data_domanda`,`s`.`data_ammissione` AS `data_ammissione`,`s`.`codice_fiscale` AS `codice_fiscale`,`s`.`data_domanda_recesso` AS `data_domanda_recesso`,`s`.`data_delibera_recesso` AS `data_delibera_recesso`,`s`.`carica` AS `carica`,`s`.`creation_date` AS `creation_date`,`s`.`creation_user` AS `creation_user`,`s`.`last_modification_date` AS `last_modification_date`,`s`.`last_modification_user` AS `last_modification_user`,`s`.`deletion_date` AS `deletion_date`,`s`.`deletion_user` AS `deletion_user`,`s`.`deletion_flag` AS `deletion_flag`,`s`.`activation_flag` AS `activation_flag`,`s`.`stato_nascita` AS `stato_nascita`,`s`.`residenza_numero` AS `residenza_numero`,`s`.`residenza_tipo_via` AS `residenza_tipo_via`,`s`.`residenza_indirizzo` AS `residenza_indirizzo`,`s`.`residenza_comune` AS `residenza_comune`,`s`.`residenza_cap` AS `residenza_cap`,`s`.`residenza_provincia` AS `residenza_provincia`,`s`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`s`.`regione_nascita` AS `regione_nascita`,`s`.`residenza_regione` AS `residenza_regione`,`s`.`partita_iva` AS `partita_iva`,`s`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`s`.`genere` AS `genere` from (`Soci` `s` join `Consumatori` `c` on((`s`.`ID` = `c`.`ID_Soci_dati_consumatore`))) union select `o`.`nome` AS `nome`,`s`.`ID` AS `ID`,`s`.`numero_socio` AS `numero_socio`,`s`.`telefono_casa` AS `telefono_casa`,`s`.`telefono_lavoro` AS `telefono_lavoro`,`s`.`telefono_cellulare` AS `telefono_cellulare`,`s`.`data_nascita` AS `data_nascita`,`s`.`comune_nascita` AS `comune_nascita`,`s`.`provincia_nascita` AS `provincia_nascita`,`s`.`professione` AS `professione`,`s`.`numero_domanda` AS `numero_domanda`,`s`.`data_domanda` AS `data_domanda`,`s`.`data_ammissione` AS `data_ammissione`,`s`.`codice_fiscale` AS `codice_fiscale`,`s`.`data_domanda_recesso` AS `data_domanda_recesso`,`s`.`data_delibera_recesso` AS `data_delibera_recesso`,`s`.`carica` AS `carica`,`s`.`creation_date` AS `creation_date`,`s`.`creation_user` AS `creation_user`,`s`.`last_modification_date` AS `last_modification_date`,`s`.`last_modification_user` AS `last_modification_user`,`s`.`deletion_date` AS `deletion_date`,`s`.`deletion_user` AS `deletion_user`,`s`.`deletion_flag` AS `deletion_flag`,`s`.`activation_flag` AS `activation_flag`,`s`.`stato_nascita` AS `stato_nascita`,`s`.`residenza_numero` AS `residenza_numero`,`s`.`residenza_tipo_via` AS `residenza_tipo_via`,`s`.`residenza_indirizzo` AS `residenza_indirizzo`,`s`.`residenza_comune` AS `residenza_comune`,`s`.`residenza_cap` AS `residenza_cap`,`s`.`residenza_provincia` AS `residenza_provincia`,`s`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`s`.`regione_nascita` AS `regione_nascita`,`s`.`residenza_regione` AS `residenza_regione`,`s`.`partita_iva` AS `partita_iva`,`s`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`s`.`genere` AS `genere` from (`Soci` `s` join `Organizzazioni` `o` on((`s`.`ID` = `o`.`ID_Soci_dati_organizzazione`))) order by `nome`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Attesa_Delibera_Ammissione`
--
DROP VIEW IF EXISTS `View_Soci_Attesa_Delibera_Ammissione`;

CREATE  VIEW `View_Soci_Attesa_Delibera_Ammissione` AS select `Soci`.`ID` AS `ID`,`Soci`.`numero_socio` AS `numero_socio`,`Soci`.`telefono_casa` AS `telefono_casa`,`Soci`.`telefono_lavoro` AS `telefono_lavoro`,`Soci`.`telefono_cellulare` AS `telefono_cellulare`,`Soci`.`data_nascita` AS `data_nascita`,`Soci`.`comune_nascita` AS `comune_nascita`,`Soci`.`provincia_nascita` AS `provincia_nascita`,`Soci`.`professione` AS `professione`,`Soci`.`numero_domanda` AS `numero_domanda`,`Soci`.`data_domanda` AS `data_domanda`,`Soci`.`data_ammissione` AS `data_ammissione`,`Soci`.`codice_fiscale` AS `codice_fiscale`,`Soci`.`data_domanda_recesso` AS `data_domanda_recesso`,`Soci`.`data_delibera_recesso` AS `data_delibera_recesso`,`Soci`.`carica` AS `carica`,`Soci`.`creation_date` AS `creation_date`,`Soci`.`creation_user` AS `creation_user`,`Soci`.`last_modification_date` AS `last_modification_date`,`Soci`.`last_modification_user` AS `last_modification_user`,`Soci`.`deletion_date` AS `deletion_date`,`Soci`.`deletion_user` AS `deletion_user`,`Soci`.`deletion_flag` AS `deletion_flag`,`Soci`.`activation_flag` AS `activation_flag`,`Soci`.`residenza_numero` AS `residenza_numero`,`Soci`.`residenza_tipo_via` AS `residenza_tipo_via`,`Soci`.`residenza_indirizzo` AS `residenza_indirizzo`,`Soci`.`residenza_comune` AS `residenza_comune`,`Soci`.`residenza_cap` AS `residenza_cap`,`Soci`.`residenza_provincia` AS `residenza_provincia`,`Soci`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`Soci`.`regione_nascita` AS `regione_nascita`,`Soci`.`residenza_regione` AS `residenza_regione`,`Soci`.`partita_iva` AS `partita_iva`,`Soci`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`Soci`.`genere` AS `genere` from `Soci` where (exists(select 1 AS `1` from `Movimenti_Quote` `q` where ((`q`.`activation_flag` = 1) and (`q`.`deletion_flag` = 0) and (`q`.`ID_Soci_movimenti_quote` = `Soci`.`ID`))) and isnull(`Soci`.`data_ammissione`));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Attesa_Delibera_Recesso`
--
DROP VIEW IF EXISTS `View_Soci_Attesa_Delibera_Recesso`;

CREATE  VIEW `View_Soci_Attesa_Delibera_Recesso` AS select `Soci`.`ID` AS `ID`,`Soci`.`numero_socio` AS `numero_socio`,`Soci`.`telefono_casa` AS `telefono_casa`,`Soci`.`telefono_lavoro` AS `telefono_lavoro`,`Soci`.`telefono_cellulare` AS `telefono_cellulare`,`Soci`.`data_nascita` AS `data_nascita`,`Soci`.`comune_nascita` AS `comune_nascita`,`Soci`.`provincia_nascita` AS `provincia_nascita`,`Soci`.`professione` AS `professione`,`Soci`.`numero_domanda` AS `numero_domanda`,`Soci`.`data_domanda` AS `data_domanda`,`Soci`.`data_ammissione` AS `data_ammissione`,`Soci`.`codice_fiscale` AS `codice_fiscale`,`Soci`.`data_domanda_recesso` AS `data_domanda_recesso`,`Soci`.`data_delibera_recesso` AS `data_delibera_recesso`,`Soci`.`carica` AS `carica`,`Soci`.`creation_date` AS `creation_date`,`Soci`.`creation_user` AS `creation_user`,`Soci`.`last_modification_date` AS `last_modification_date`,`Soci`.`last_modification_user` AS `last_modification_user`,`Soci`.`deletion_date` AS `deletion_date`,`Soci`.`deletion_user` AS `deletion_user`,`Soci`.`deletion_flag` AS `deletion_flag`,`Soci`.`activation_flag` AS `activation_flag`,`Soci`.`residenza_numero` AS `residenza_numero`,`Soci`.`residenza_tipo_via` AS `residenza_tipo_via`,`Soci`.`residenza_indirizzo` AS `residenza_indirizzo`,`Soci`.`residenza_comune` AS `residenza_comune`,`Soci`.`residenza_cap` AS `residenza_cap`,`Soci`.`residenza_provincia` AS `residenza_provincia`,`Soci`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`Soci`.`regione_nascita` AS `regione_nascita`,`Soci`.`residenza_regione` AS `residenza_regione`,`Soci`.`partita_iva` AS `partita_iva`,`Soci`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`Soci`.`genere` AS `genere` from `Soci` where (exists(select 1 AS `1` from `Movimenti_Quote` `q` where ((`q`.`activation_flag` = 1) and (`q`.`deletion_flag` = 0) and (`q`.`ID_Soci_movimenti_quote` = `Soci`.`ID`))) and (`Soci`.`data_ammissione` is not null) and (`Soci`.`data_domanda_recesso` is not null) and isnull(`Soci`.`data_delibera_recesso`));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Attesa_Rimborso_Quote`
--
DROP VIEW IF EXISTS `View_Soci_Attesa_Rimborso_Quote`;

CREATE  VIEW `View_Soci_Attesa_Rimborso_Quote` AS select `Soci`.`ID` AS `ID`,`Soci`.`numero_socio` AS `numero_socio`,`Soci`.`telefono_casa` AS `telefono_casa`,`Soci`.`telefono_lavoro` AS `telefono_lavoro`,`Soci`.`telefono_cellulare` AS `telefono_cellulare`,`Soci`.`data_nascita` AS `data_nascita`,`Soci`.`comune_nascita` AS `comune_nascita`,`Soci`.`provincia_nascita` AS `provincia_nascita`,`Soci`.`professione` AS `professione`,`Soci`.`numero_domanda` AS `numero_domanda`,`Soci`.`data_domanda` AS `data_domanda`,`Soci`.`data_ammissione` AS `data_ammissione`,`Soci`.`codice_fiscale` AS `codice_fiscale`,`Soci`.`data_domanda_recesso` AS `data_domanda_recesso`,`Soci`.`data_delibera_recesso` AS `data_delibera_recesso`,`Soci`.`carica` AS `carica`,`Soci`.`creation_date` AS `creation_date`,`Soci`.`creation_user` AS `creation_user`,`Soci`.`last_modification_date` AS `last_modification_date`,`Soci`.`last_modification_user` AS `last_modification_user`,`Soci`.`deletion_date` AS `deletion_date`,`Soci`.`deletion_user` AS `deletion_user`,`Soci`.`deletion_flag` AS `deletion_flag`,`Soci`.`activation_flag` AS `activation_flag`,`Soci`.`residenza_numero` AS `residenza_numero`,`Soci`.`residenza_tipo_via` AS `residenza_tipo_via`,`Soci`.`residenza_indirizzo` AS `residenza_indirizzo`,`Soci`.`residenza_comune` AS `residenza_comune`,`Soci`.`residenza_cap` AS `residenza_cap`,`Soci`.`residenza_provincia` AS `residenza_provincia`,`Soci`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`Soci`.`regione_nascita` AS `regione_nascita`,`Soci`.`residenza_regione` AS `residenza_regione`,`Soci`.`partita_iva` AS `partita_iva`,`Soci`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`Soci`.`genere` AS `genere` from `Soci` where ((not(exists(select 1 AS `1` from `Movimenti_Quote` `q` where ((`q`.`activation_flag` = 1) and (`q`.`deletion_flag` = 0) and (`q`.`ID_Soci_movimenti_quote` = `Soci`.`ID`) and (`q`.`causale_quota` = 3))))) and (`Soci`.`data_ammissione` is not null) and (`Soci`.`data_domanda_recesso` is not null) and (`Soci`.`data_delibera_recesso` is not null));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Attesa_Sottoscrizione`
--
DROP VIEW IF EXISTS `View_Soci_Attesa_Sottoscrizione`;

CREATE  VIEW `View_Soci_Attesa_Sottoscrizione` AS select `Soci`.`ID` AS `ID`,`Soci`.`numero_socio` AS `numero_socio`,`Soci`.`telefono_casa` AS `telefono_casa`,`Soci`.`telefono_lavoro` AS `telefono_lavoro`,`Soci`.`telefono_cellulare` AS `telefono_cellulare`,`Soci`.`data_nascita` AS `data_nascita`,`Soci`.`comune_nascita` AS `comune_nascita`,`Soci`.`provincia_nascita` AS `provincia_nascita`,`Soci`.`professione` AS `professione`,`Soci`.`numero_domanda` AS `numero_domanda`,`Soci`.`data_domanda` AS `data_domanda`,`Soci`.`data_ammissione` AS `data_ammissione`,`Soci`.`codice_fiscale` AS `codice_fiscale`,`Soci`.`data_domanda_recesso` AS `data_domanda_recesso`,`Soci`.`data_delibera_recesso` AS `data_delibera_recesso`,`Soci`.`carica` AS `carica`,`Soci`.`creation_date` AS `creation_date`,`Soci`.`creation_user` AS `creation_user`,`Soci`.`last_modification_date` AS `last_modification_date`,`Soci`.`last_modification_user` AS `last_modification_user`,`Soci`.`deletion_date` AS `deletion_date`,`Soci`.`deletion_user` AS `deletion_user`,`Soci`.`deletion_flag` AS `deletion_flag`,`Soci`.`activation_flag` AS `activation_flag`,`Soci`.`residenza_numero` AS `residenza_numero`,`Soci`.`residenza_tipo_via` AS `residenza_tipo_via`,`Soci`.`residenza_indirizzo` AS `residenza_indirizzo`,`Soci`.`residenza_comune` AS `residenza_comune`,`Soci`.`residenza_cap` AS `residenza_cap`,`Soci`.`residenza_provincia` AS `residenza_provincia`,`Soci`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`Soci`.`regione_nascita` AS `regione_nascita`,`Soci`.`residenza_regione` AS `residenza_regione`,`Soci`.`partita_iva` AS `partita_iva`,`Soci`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`Soci`.`genere` AS `genere` from `Soci` where (not(exists(select 1 AS `1` from `Movimenti_Quote` `q` where ((`q`.`activation_flag` = 1) and (`q`.`deletion_flag` = 0) and (`q`.`ID_Soci_movimenti_quote` = `Soci`.`ID`)))));

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Attivi`
--
DROP VIEW IF EXISTS `View_Soci_Attivi`;

CREATE VIEW `View_Soci_Attivi` AS select `aliasSoci`.`ID` AS `ID`,`aliasSoci`.`numero_socio` AS `numero_socio`,`aliasSoci`.`telefono_casa` AS `telefono_casa`,`aliasSoci`.`telefono_lavoro` AS `telefono_lavoro`,`aliasSoci`.`telefono_cellulare` AS `telefono_cellulare`,`aliasSoci`.`data_nascita` AS `data_nascita`,`aliasSoci`.`comune_nascita` AS `comune_nascita`,`aliasSoci`.`provincia_nascita` AS `provincia_nascita`,`aliasSoci`.`professione` AS `professione`,`aliasSoci`.`numero_domanda` AS `numero_domanda`,`aliasSoci`.`data_domanda` AS `data_domanda`,`aliasSoci`.`data_ammissione` AS `data_ammissione`,`aliasSoci`.`codice_fiscale` AS `codice_fiscale`,`aliasSoci`.`data_domanda_recesso` AS `data_domanda_recesso`,`aliasSoci`.`data_delibera_recesso` AS `data_delibera_recesso`,`aliasSoci`.`carica` AS `carica`,`aliasSoci`.`creation_date` AS `creation_date`,`aliasSoci`.`creation_user` AS `creation_user`,`aliasSoci`.`last_modification_date` AS `last_modification_date`,`aliasSoci`.`last_modification_user` AS `last_modification_user`,`aliasSoci`.`deletion_date` AS `deletion_date`,`aliasSoci`.`deletion_user` AS `deletion_user`,`aliasSoci`.`deletion_flag` AS `deletion_flag`,`aliasSoci`.`activation_flag` AS `activation_flag`,`aliasSoci`.`residenza_numero` AS `residenza_numero`,`aliasSoci`.`residenza_tipo_via` AS `residenza_tipo_via`,`aliasSoci`.`residenza_indirizzo` AS `residenza_indirizzo`,`aliasSoci`.`residenza_comune` AS `residenza_comune`,`aliasSoci`.`residenza_cap` AS `residenza_cap`,`aliasSoci`.`residenza_provincia` AS `residenza_provincia`,`aliasSoci`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`aliasSoci`.`regione_nascita` AS `regione_nascita`,`aliasSoci`.`residenza_regione` AS `residenza_regione`,`aliasSoci`.`partita_iva` AS `partita_iva`,`aliasSoci`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`aliasSoci`.`genere` AS `genere` from `Soci` `aliasSoci` 
where (exists(select 1 AS `1` from `Movimenti_Quote` `q` where ((`q`.`activation_flag` = 1) and (`q`.`deletion_flag` = 0) and (`q`.`ID_Soci_movimenti_quote` = `aliasSoci`.`ID`))) and (`aliasSoci`.`data_ammissione` is not null) and isnull(`aliasSoci`.`data_domanda_recesso`))
and  `aliasSoci`.deletion_flag=0;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_ExAequo_Per_ML`
--
DROP VIEW IF EXISTS `View_Soci_ExAequo_Per_ML`;

CREATE  VIEW `View_Soci_ExAequo_Per_ML` AS select `c`.`ID` AS `ID`,`c`.`activation_flag` AS `activation_flag`,`c`.`deletion_flag` AS `deletion_flag`,`c`.`creation_user` AS `creation_user`,`c`.`nome` AS `nome`,`c`.`cognome` AS `cognome`,`c`.`email` AS `email` from `Consumatori` `c` where ((`c`.`ID_Botteghe_consumatori` in (1,3,5)) and (`c`.`email` is not null) and (`c`.`email` <> '') and exists(select 1 AS `1` from `Soci` `s` where ((`s`.`ID` = `c`.`ID_Soci_dati_consumatore`) and (`s`.`deletion_flag` = 0) and isnull(`s`.`data_delibera_recesso`)))) union select `o`.`ID` AS `ID`,`o`.`activation_flag` AS `activation_flag`,`o`.`deletion_flag` AS `deletion_flag`,`o`.`creation_user` AS `creation_user`,`o`.`nome` AS `nome`,'' AS `cognome`,`o`.`email` AS `email` from `Organizzazioni` `o` where ((`o`.`ID_Botteghe_organizzazioni` in (1,3,5)) and (`o`.`email` is not null) and (`o`.`email` <> '') and exists(select 1 AS `1` from `Soci` `s` where ((`s`.`ID` = `o`.`ID_Soci_dati_organizzazione`) and (`s`.`deletion_flag` = 0) and isnull(`s`.`data_delibera_recesso`)))) order by `email`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Libretti`
--
DROP VIEW IF EXISTS `View_Soci_Libretti`;

CREATE  VIEW `View_Soci_Libretti` AS select `s`.`nome` AS `nome`,`s`.`ID` AS `ID`,`s`.`numero_socio` AS `numero_socio`,`s`.`telefono_casa` AS `telefono_casa`,`s`.`telefono_lavoro` AS `telefono_lavoro`,`s`.`telefono_cellulare` AS `telefono_cellulare`,`s`.`data_nascita` AS `data_nascita`,`s`.`comune_nascita` AS `comune_nascita`,`s`.`provincia_nascita` AS `provincia_nascita`,`s`.`professione` AS `professione`,`s`.`numero_domanda` AS `numero_domanda`,`s`.`data_domanda` AS `data_domanda`,`s`.`data_ammissione` AS `data_ammissione`,`s`.`codice_fiscale` AS `codice_fiscale`,`s`.`data_domanda_recesso` AS `data_domanda_recesso`,`s`.`data_delibera_recesso` AS `data_delibera_recesso`,`s`.`carica` AS `carica`,`s`.`creation_date` AS `creation_date`,`s`.`creation_user` AS `creation_user`,`s`.`last_modification_date` AS `last_modification_date`,`s`.`last_modification_user` AS `last_modification_user`,`s`.`deletion_date` AS `deletion_date`,`s`.`deletion_user` AS `deletion_user`,`s`.`deletion_flag` AS `deletion_flag`,`s`.`activation_flag` AS `activation_flag`,`s`.`stato_nascita` AS `stato_nascita`,`s`.`residenza_numero` AS `residenza_numero`,`s`.`residenza_tipo_via` AS `residenza_tipo_via`,`s`.`residenza_indirizzo` AS `residenza_indirizzo`,`s`.`residenza_comune` AS `residenza_comune`,`s`.`residenza_cap` AS `residenza_cap`,`s`.`residenza_provincia` AS `residenza_provincia`,`s`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`s`.`regione_nascita` AS `regione_nascita`,`s`.`residenza_regione` AS `residenza_regione`,`s`.`partita_iva` AS `partita_iva`,`s`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`s`.`genere` AS `genere` from `View_Soci_Anagrafica` `s` where ((`s`.`deletion_flag` = 0) and exists(select 1 AS `1` from `Libretti` `l` where (`s`.`ID` = `l`.`ID_Soci_risparmio`))) order by `s`.`nome`;

-- --------------------------------------------------------

--
-- Struttura per la vista `View_Soci_Receduti`
--
DROP VIEW IF EXISTS `View_Soci_Receduti`;

CREATE  VIEW `View_Soci_Receduti` AS select `Soci`.`ID` AS `ID`,`Soci`.`numero_socio` AS `numero_socio`,`Soci`.`telefono_casa` AS `telefono_casa`,`Soci`.`telefono_lavoro` AS `telefono_lavoro`,`Soci`.`telefono_cellulare` AS `telefono_cellulare`,`Soci`.`data_nascita` AS `data_nascita`,`Soci`.`comune_nascita` AS `comune_nascita`,`Soci`.`provincia_nascita` AS `provincia_nascita`,`Soci`.`professione` AS `professione`,`Soci`.`numero_domanda` AS `numero_domanda`,`Soci`.`data_domanda` AS `data_domanda`,`Soci`.`data_ammissione` AS `data_ammissione`,`Soci`.`codice_fiscale` AS `codice_fiscale`,`Soci`.`data_domanda_recesso` AS `data_domanda_recesso`,`Soci`.`data_delibera_recesso` AS `data_delibera_recesso`,`Soci`.`carica` AS `carica`,`Soci`.`creation_date` AS `creation_date`,`Soci`.`creation_user` AS `creation_user`,`Soci`.`last_modification_date` AS `last_modification_date`,`Soci`.`last_modification_user` AS `last_modification_user`,`Soci`.`deletion_date` AS `deletion_date`,`Soci`.`deletion_user` AS `deletion_user`,`Soci`.`deletion_flag` AS `deletion_flag`,`Soci`.`activation_flag` AS `activation_flag`,`Soci`.`residenza_numero` AS `residenza_numero`,`Soci`.`residenza_tipo_via` AS `residenza_tipo_via`,`Soci`.`residenza_indirizzo` AS `residenza_indirizzo`,`Soci`.`residenza_comune` AS `residenza_comune`,`Soci`.`residenza_cap` AS `residenza_cap`,`Soci`.`residenza_provincia` AS `residenza_provincia`,`Soci`.`ID_Cooperative_i_soci` AS `ID_Cooperative_i_soci`,`Soci`.`regione_nascita` AS `regione_nascita`,`Soci`.`residenza_regione` AS `residenza_regione`,`Soci`.`partita_iva` AS `partita_iva`,`Soci`.`data_delibera_domanda_organizzazione` AS `data_delibera_domanda_organizzazione`,`Soci`.`genere` AS `genere` from `Soci` where (exists(select 1 AS `1` from `Movimenti_Quote` `q` where ((`q`.`activation_flag` = 1) and (`q`.`deletion_flag` = 0) and (`q`.`ID_Soci_movimenti_quote` = `Soci`.`ID`) and (`q`.`causale_quota` = 3))) and (`Soci`.`data_ammissione` is not null) and (`Soci`.`data_domanda_recesso` is not null) and (`Soci`.`data_delibera_recesso` is not null));
