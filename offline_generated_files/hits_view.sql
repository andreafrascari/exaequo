--
-- VIEW per ogni classe con titolo classe_hits: pregi: stampa il titolo della pagina
--

CREATE VIEW _system_cms_node_hits AS 
SELECT node.title, count( access.id ) AS hits ,1 AS `activation_flag`,0 AS `deletion_flag`
FROM `_system_access` access, _system_cms_node node
WHERE node.ID = access.sac_instance
AND access.sac_class = '_system_cms_node'
GROUP BY sac_instance
ORDER BY hits DESC

--
-- VIEW generica x tutte le classi: difetti: NON stampa il titolo della pagina
--

-- SELECT access.sac_instance, access.sac_class, count(access.sac_instance) as hits 
-- FROM `_system_access` access group by sac_class,sac_instance order by hits desc 


--
-- VIEW per mostrare i login effettuati

CREATE VIEW Login_hits AS 
SELECT user.user_user_id, user.user_name, count( access.id ) AS `hits`,
max( access.sac_time ) AS `last_login`,
1 AS `activation_flag`, 0 AS `deletion_flag`
FROM `_system_access` access, _system_user user
WHERE access.sac_action = "login" 
AND user.ID = access.sac_instance
AND access.sac_class = '_system_user'
GROUP BY sac_instance
ORDER BY hits DESC