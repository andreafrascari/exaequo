update `_system_group` set `group_default_permissions` = '000' where `ID` = 4;

INSERT INTO `_system_class_auth` (`ID`, `sca_class`, `sca_permissions`, `ID__system_group_group_class_auth`, `creation_date`, `creation_user`, `last_modification_date`, `last_modification_user`, `deletion_date`, `deletion_user`, `deletion_flag`, `activation_flag`) VALUES
(1, '_system_attachment', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(2, '_system_cms_node', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(3, '_system_news', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(4, '_system_module', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(5, '_system_menu_item', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(6, '_system_meta_environment', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(7, '_system_user', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(8, '_system_group', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(9, '_system_decode', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(10, '_system_decode_class', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(11, '_system_class_auth', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(12, '_system_instance_auth', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(13, '_system_profile', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1),
(14, '_system_module_admin', '111', 4, '2008-06-06', 'afrascari', '2008-06-06', 'afrascari', NULL, NULL, 0, 1);
