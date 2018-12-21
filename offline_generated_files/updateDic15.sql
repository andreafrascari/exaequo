 UPDATE _system_menu_item SET smi_locale = "it" , ID__system_menu_item_smi_children = "50" , smi_alternative_text = "gestione finanza: accrediti, estratticonto...." , smi_title = "Finanza" , smi_href = "?q=object/detail&p=_system_cms_node/_a_ID/_v_6&t=HomeFinanza" , smi_association = NULL , smi_order = "99" , activation_flag = "1" , last_modification_user = "afrascari" , last_modification_date = "2015-12-30"  WHERE ID = 47;
 
 delete  FROM `Soci` WHERE `ID_Cooperative_i_soci` <> 1;
 
 delete FROM `Consumatori` WHERE `ID_Botteghe_consumatori` = 4;
 
 delete FROM `Movimenti_Quote` WHERE not exists (select 1 from Soci s where `ID_Soci_movimenti_quote` = s.ID);
 
 delete FROM `Libretti` WHERE not exists (select 1 from Soci s where `ID_Soci_risparmio` = s.ID);