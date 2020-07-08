-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-07-2020 a las 20:33:00
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 5.6.39

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventario`
--
CREATE DATABASE IF NOT EXISTS `inventario` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `inventario`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bodega`
--

CREATE TABLE `bodega` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `descripcion` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caja`
--

CREATE TABLE `caja` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `descripcion` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `categoria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `codigo` varchar(30) NOT NULL,
  `categoria` int(3) NOT NULL,
  `subcategoria` int(3) NOT NULL,
  `marca` int(3) NOT NULL,
  `modelo` int(11) NOT NULL,
  `descripcion` longtext,
  `foto` blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lote`
--

CREATE TABLE `lote` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `descripcion` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `id` int(11) NOT NULL,
  `marca` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

CREATE TABLE `stock` (
  `id` int(11) NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  `item` int(11) NOT NULL,
  `unidad` int(1) NOT NULL,
  `cantidad` double(5,2) NOT NULL,
  `bodega` int(2) NOT NULL,
  `lote` int(4) NOT NULL,
  `caja` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subcategoria`
--

CREATE TABLE `subcategoria` (
  `id` int(11) NOT NULL,
  `subcategoria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad`
--

CREATE TABLE `unidad` (
  `id` int(11) NOT NULL,
  `unidad` varchar(30) NOT NULL,
  `factor_unitario` double(6,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bodega`
--
ALTER TABLE `bodega`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `caja`
--
ALTER TABLE `caja`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categoria` (`categoria`),
  ADD KEY `subcategoria` (`subcategoria`),
  ADD KEY `marca` (`marca`);

--
-- Indices de la tabla `lote`
--
ALTER TABLE `lote`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`id`),
  ADD KEY `item` (`item`),
  ADD KEY `unidad` (`unidad`),
  ADD KEY `bodega` (`bodega`),
  ADD KEY `lote` (`lote`),
  ADD KEY `caja` (`caja`);

--
-- Indices de la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `unidad`
--
ALTER TABLE `unidad`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bodega`
--
ALTER TABLE `bodega`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `caja`
--
ALTER TABLE `caja`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `item`
--
ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `lote`
--
ALTER TABLE `lote`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `stock`
--
ALTER TABLE `stock`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `unidad`
--
ALTER TABLE `unidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id`),
  ADD CONSTRAINT `item_ibfk_2` FOREIGN KEY (`subcategoria`) REFERENCES `subcategoria` (`id`),
  ADD CONSTRAINT `item_ibfk_3` FOREIGN KEY (`marca`) REFERENCES `marca` (`id`);

--
-- Filtros para la tabla `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`item`) REFERENCES `item` (`id`),
  ADD CONSTRAINT `stock_ibfk_2` FOREIGN KEY (`unidad`) REFERENCES `unidad` (`id`),
  ADD CONSTRAINT `stock_ibfk_3` FOREIGN KEY (`bodega`) REFERENCES `bodega` (`id`),
  ADD CONSTRAINT `stock_ibfk_4` FOREIGN KEY (`lote`) REFERENCES `lote` (`id`),
  ADD CONSTRAINT `stock_ibfk_5` FOREIGN KEY (`caja`) REFERENCES `caja` (`id`);
--
-- Base de datos: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(11) NOT NULL,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_length` text COLLATE utf8_bin,
  `col_collation` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) COLLATE utf8_bin DEFAULT '',
  `col_default` text COLLATE utf8_bin
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `settings_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `export_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `template_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `template_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sqlquery` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT '0',
  `x` float UNSIGNED NOT NULL DEFAULT '0',
  `y` float UNSIGNED NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin,
  `data_sql` longtext COLLATE utf8_bin,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `config_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Volcado de datos para la tabla `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2020-07-06 18:32:23', '{\"lang\":\"es\",\"Console\\/Mode\":\"collapse\"}');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL,
  `tab` varchar(64) COLLATE utf8_bin NOT NULL,
  `allowed` enum('Y','N') COLLATE utf8_bin NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Indices de la tabla `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Indices de la tabla `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Indices de la tabla `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Indices de la tabla `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Indices de la tabla `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Indices de la tabla `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Indices de la tabla `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Indices de la tabla `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Indices de la tabla `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Indices de la tabla `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Indices de la tabla `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Indices de la tabla `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Indices de la tabla `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Base de datos: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;
--
-- Base de datos: `trellis`
--
CREATE DATABASE IF NOT EXISTS `trellis` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `trellis`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_announcements`
--

CREATE TABLE `td_announcements` (
  `id` int(11) NOT NULL,
  `mid` int(11) NOT NULL DEFAULT '0',
  `mname` varchar(255) NOT NULL DEFAULT '',
  `title` varchar(255) NOT NULL DEFAULT '',
  `excerpt` text NOT NULL,
  `content` text NOT NULL,
  `email` int(1) NOT NULL DEFAULT '0',
  `dis_comments` tinyint(1) NOT NULL DEFAULT '0',
  `comments` int(11) NOT NULL DEFAULT '0',
  `start_date` int(10) NOT NULL DEFAULT '0',
  `end_date` int(10) NOT NULL DEFAULT '0',
  `date` int(10) NOT NULL DEFAULT '0',
  `ipadd` varchar(32) NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_announcements`
--

INSERT INTO `td_announcements` (`id`, `mid`, `mname`, `title`, `excerpt`, `content`, `email`, `dis_comments`, `comments`, `start_date`, `end_date`, `date`, `ipadd`) VALUES
(1, 1, 'admin', 'Welcome to Trellis Desk', 'This is a test announcement that can be deleted at any time.  To manage your announcements, login to the ACP, go to Management, and then click List Announcements.', 'The ACCORD5 Team would like to welcome you to Trellis Desk.&lt;br /&gt;&lt;br /&gt;We hope you find that Trellis Desk suits your needs.&amp;nbsp; If you ever need support, just &lt;a href=&quot;http://customer.accord5.com/trellis/&quot; target=&quot;_blank&quot;&gt;send us a ticket&lt;/a&gt;.&amp;nbsp; The &lt;a href=&quot;http://docs.accord5.com/&quot; target=&quot;_blank&quot;&gt;documentation&lt;/a&gt; is also a great resource.&lt;br /&gt;&lt;br /&gt;Enjoy Trellis Desk!', 0, 0, 0, 0, 0, 1547582806, '::1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_articles`
--

CREATE TABLE `td_articles` (
  `id` int(11) NOT NULL,
  `cat_id` int(11) NOT NULL DEFAULT '0',
  `cat_name` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL DEFAULT '',
  `description` text NOT NULL,
  `article` longtext NOT NULL,
  `votes` int(11) NOT NULL DEFAULT '0',
  `rating` float NOT NULL DEFAULT '0',
  `views` int(11) NOT NULL DEFAULT '0',
  `comments` int(11) NOT NULL DEFAULT '0',
  `date` int(10) NOT NULL DEFAULT '0',
  `updated` int(10) NOT NULL DEFAULT '0',
  `author_id` int(11) NOT NULL DEFAULT '0',
  `author_name` varchar(255) NOT NULL DEFAULT '',
  `keywords` text NOT NULL,
  `dis_comments` tinyint(1) NOT NULL DEFAULT '0',
  `dis_rating` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_articles`
--

INSERT INTO `td_articles` (`id`, `cat_id`, `cat_name`, `name`, `description`, `article`, `votes`, `rating`, `views`, `comments`, `date`, `updated`, `author_id`, `author_name`, `keywords`, `dis_comments`, `dis_rating`) VALUES
(1, 1, 'Test Category', 'Test Article', 'This is a test article that can be deleted at any time.', 'This is a test article that can be deleted at any time.\r\n\r\nTo manage your articles and knowledge base categories, login to the ACP, click Management, and then click the appropriate link under Knowledge Base Control.', 0, 0, 0, 0, 1547582806, 0, 1, 'admin', 'test|article', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_article_rate`
--

CREATE TABLE `td_article_rate` (
  `id` int(11) NOT NULL,
  `aid` int(11) NOT NULL DEFAULT '0',
  `mid` int(11) NOT NULL DEFAULT '0',
  `rating` int(11) NOT NULL DEFAULT '0',
  `date` int(10) NOT NULL DEFAULT '0',
  `ipadd` varchar(32) NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_asessions`
--

CREATE TABLE `td_asessions` (
  `s_id` varchar(33) NOT NULL DEFAULT '',
  `s_mid` int(11) NOT NULL DEFAULT '0',
  `s_mname` varchar(255) NOT NULL DEFAULT '',
  `s_ipadd` varchar(32) NOT NULL DEFAULT '',
  `s_location` varchar(255) NOT NULL DEFAULT '',
  `s_time` int(10) NOT NULL DEFAULT '0',
  `s_inticket` int(11) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_attachments`
--

CREATE TABLE `td_attachments` (
  `id` int(11) NOT NULL,
  `tid` int(11) NOT NULL DEFAULT '0',
  `real_name` varchar(255) NOT NULL DEFAULT '',
  `original_name` varchar(255) NOT NULL DEFAULT '',
  `mid` int(11) NOT NULL DEFAULT '0',
  `mname` varchar(255) NOT NULL DEFAULT '',
  `size` int(11) NOT NULL DEFAULT '0',
  `mime` varchar(255) NOT NULL DEFAULT '',
  `ipadd` varchar(32) NOT NULL DEFAULT '',
  `date` int(10) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_canned`
--

CREATE TABLE `td_canned` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `description` text NOT NULL,
  `content` longtext NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_canned`
--

INSERT INTO `td_canned` (`id`, `name`, `description`, `content`) VALUES
(1, 'Test Canned Reply', 'This is a test canned reply that can be deleted at any time.', 'This is a test canned reply that can be deleted at any time.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_categories`
--

CREATE TABLE `td_categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `sub_id` int(11) NOT NULL DEFAULT '0',
  `sub_name` varchar(255) NOT NULL DEFAULT '',
  `description` text NOT NULL,
  `articles` int(11) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_categories`
--

INSERT INTO `td_categories` (`id`, `name`, `sub_id`, `sub_name`, `description`, `articles`) VALUES
(1, 'Test Category', 0, '', 'This is a test category that can be deleted at any time.', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_comments`
--

CREATE TABLE `td_comments` (
  `id` int(11) NOT NULL,
  `aid` int(11) NOT NULL DEFAULT '0',
  `mid` int(11) NOT NULL DEFAULT '0',
  `mname` varchar(255) NOT NULL DEFAULT '',
  `comment` longtext NOT NULL,
  `date` int(10) NOT NULL DEFAULT '0',
  `ipadd` varchar(32) NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_departments`
--

CREATE TABLE `td_departments` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `sub_id` int(11) NOT NULL DEFAULT '0',
  `sub_name` varchar(255) NOT NULL DEFAULT '',
  `description` text NOT NULL,
  `tickets` int(11) NOT NULL DEFAULT '0',
  `placeholder` tinyint(1) NOT NULL DEFAULT '0',
  `ticket_own_close` tinyint(1) NOT NULL DEFAULT '0',
  `ticket_own_reopen` tinyint(1) NOT NULL DEFAULT '0',
  `can_escalate` tinyint(1) NOT NULL DEFAULT '0',
  `escalate_depart` int(11) NOT NULL DEFAULT '0',
  `escalate_wait` int(11) NOT NULL DEFAULT '0',
  `close_reason` tinyint(1) NOT NULL DEFAULT '0',
  `auto_close` int(11) NOT NULL DEFAULT '0',
  `can_attach` tinyint(1) NOT NULL DEFAULT '0',
  `email_pipe` tinyint(1) NOT NULL DEFAULT '0',
  `guest_pipe` tinyint(1) NOT NULL DEFAULT '0',
  `incoming_email` varchar(255) NOT NULL DEFAULT '',
  `email_pop3` tinyint(1) NOT NULL DEFAULT '0',
  `pop3_host` varchar(255) NOT NULL DEFAULT '',
  `pop3_user` varchar(255) NOT NULL DEFAULT '',
  `pop3_pass` varchar(255) NOT NULL DEFAULT '',
  `auto_assign` int(11) NOT NULL DEFAULT '0',
  `custom_fields` text NOT NULL,
  `position` int(11) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_departments`
--

INSERT INTO `td_departments` (`id`, `name`, `sub_id`, `sub_name`, `description`, `tickets`, `placeholder`, `ticket_own_close`, `ticket_own_reopen`, `can_escalate`, `escalate_depart`, `escalate_wait`, `close_reason`, `auto_close`, `can_attach`, `email_pipe`, `guest_pipe`, `incoming_email`, `email_pop3`, `pop3_host`, `pop3_user`, `pop3_pass`, `auto_assign`, `custom_fields`, `position`) VALUES
(1, 'Test Department', 0, '', 'This is a test department that can be deleted at any time.', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 0, '', '', '', 0, '', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_depart_fields`
--

CREATE TABLE `td_depart_fields` (
  `id` int(11) NOT NULL,
  `fkey` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL DEFAULT '',
  `type` varchar(25) NOT NULL DEFAULT '',
  `extra` text NOT NULL,
  `required` tinyint(1) NOT NULL DEFAULT '0',
  `departs` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_groups`
--

CREATE TABLE `td_groups` (
  `g_id` int(11) NOT NULL,
  `g_name` varchar(255) NOT NULL DEFAULT '',
  `g_members` int(11) NOT NULL DEFAULT '0',
  `g_ticket_access` tinyint(1) NOT NULL DEFAULT '0',
  `g_new_tickets` tinyint(1) NOT NULL DEFAULT '0',
  `g_kb_access` tinyint(1) NOT NULL DEFAULT '0',
  `g_kb_rate` tinyint(1) NOT NULL DEFAULT '0',
  `g_kb_comment` tinyint(1) NOT NULL DEFAULT '0',
  `g_news_comment` tinyint(1) NOT NULL DEFAULT '0',
  `g_ticket_edit` tinyint(1) NOT NULL DEFAULT '0',
  `g_reply_rate` tinyint(1) NOT NULL DEFAULT '0',
  `g_reply_edit` tinyint(1) NOT NULL DEFAULT '0',
  `g_reply_delete` tinyint(1) NOT NULL DEFAULT '0',
  `g_change_skin` tinyint(1) NOT NULL DEFAULT '0',
  `g_change_lang` tinyint(1) NOT NULL DEFAULT '0',
  `g_com_edit_all` tinyint(1) NOT NULL DEFAULT '0',
  `g_com_delete_all` tinyint(1) NOT NULL DEFAULT '0',
  `g_acp_access` tinyint(1) NOT NULL DEFAULT '0',
  `g_acp_perm` text NOT NULL,
  `g_depart_perm` text NOT NULL,
  `g_ticket_own_close` tinyint(1) NOT NULL DEFAULT '0',
  `g_m_depart_perm` text NOT NULL,
  `g_ticket_attach` tinyint(1) NOT NULL DEFAULT '0',
  `g_upload_size_max` int(11) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_groups`
--

INSERT INTO `td_groups` (`g_id`, `g_name`, `g_members`, `g_ticket_access`, `g_new_tickets`, `g_kb_access`, `g_kb_rate`, `g_kb_comment`, `g_news_comment`, `g_ticket_edit`, `g_reply_rate`, `g_reply_edit`, `g_reply_delete`, `g_change_skin`, `g_change_lang`, `g_com_edit_all`, `g_com_delete_all`, `g_acp_access`, `g_acp_perm`, `g_depart_perm`, `g_ticket_own_close`, `g_m_depart_perm`, `g_ticket_attach`, `g_upload_size_max`) VALUES
(1, 'Members', 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 'N;', 'N;', 1, 'a:1:{i:1;i:1;}', 1, 2048),
(2, 'Guests', 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'N;', 'N;', 0, 'N;', 0, 0),
(3, 'Validating', 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'N;', 'N;', 0, 'N;', 0, 0),
(4, 'Administrators', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'a:76:{s:5:\"admin\";i:1;s:10:\"admin_logs\";i:1;s:16:\"admin_logs_admin\";i:1;s:17:\"admin_logs_member\";i:1;s:16:\"admin_logs_email\";i:1;s:16:\"admin_logs_error\";i:1;s:19:\"admin_logs_security\";i:1;s:17:\"admin_logs_ticket\";i:1;s:16:\"admin_logs_prune\";i:1;s:6:\"manage\";i:1;s:13:\"manage_ticket\";i:1;s:19:\"manage_ticket_reply\";i:1;s:25:\"manage_ticket_assign_self\";i:1;s:24:\"manage_ticket_assign_any\";i:1;s:18:\"manage_ticket_hold\";i:1;s:22:\"manage_ticket_escalate\";i:1;s:18:\"manage_ticket_move\";i:1;s:19:\"manage_ticket_close\";i:1;s:20:\"manage_ticket_delete\";i:1;s:20:\"manage_ticket_reopen\";i:1;s:13:\"manage_canned\";i:1;s:17:\"manage_canned_add\";i:1;s:18:\"manage_canned_edit\";i:1;s:20:\"manage_canned_delete\";i:1;s:13:\"manage_depart\";i:1;s:17:\"manage_depart_add\";i:1;s:18:\"manage_depart_edit\";i:1;s:20:\"manage_depart_delete\";i:1;s:21:\"manage_depart_reorder\";i:1;s:21:\"manage_depart_cfields\";i:1;s:15:\"manage_announce\";i:1;s:19:\"manage_announce_add\";i:1;s:20:\"manage_announce_edit\";i:1;s:22:\"manage_announce_delete\";i:1;s:13:\"manage_member\";i:1;s:17:\"manage_member_add\";i:1;s:18:\"manage_member_edit\";i:1;s:20:\"manage_member_delete\";i:1;s:21:\"manage_member_approve\";i:1;s:21:\"manage_member_cfields\";i:1;s:12:\"manage_group\";i:1;s:16:\"manage_group_add\";i:1;s:17:\"manage_group_edit\";i:1;s:19:\"manage_group_delete\";i:1;s:14:\"manage_article\";i:1;s:18:\"manage_article_add\";i:1;s:19:\"manage_article_edit\";i:1;s:21:\"manage_article_delete\";i:1;s:10:\"manage_cat\";i:1;s:14:\"manage_cat_add\";i:1;s:15:\"manage_cat_edit\";i:1;s:17:\"manage_cat_delete\";i:1;s:12:\"manage_pages\";i:1;s:16:\"manage_pages_add\";i:1;s:17:\"manage_pages_edit\";i:1;s:19:\"manage_pages_delete\";i:1;s:15:\"manage_settings\";i:1;s:22:\"manage_settings_update\";i:1;s:4:\"look\";i:1;s:9:\"look_skin\";i:1;s:16:\"look_skin_manage\";i:1;s:15:\"look_skin_tools\";i:1;s:16:\"look_skin_import\";i:1;s:16:\"look_skin_export\";i:1;s:9:\"look_lang\";i:1;s:16:\"look_lang_manage\";i:1;s:15:\"look_lang_tools\";i:1;s:16:\"look_lang_import\";i:1;s:16:\"look_lang_export\";i:1;s:5:\"tools\";i:1;s:11:\"tools_maint\";i:1;s:19:\"tools_maint_recount\";i:1;s:17:\"tools_maint_clean\";i:1;s:16:\"tools_maint_optm\";i:1;s:20:\"tools_maint_syscheck\";i:1;s:12:\"tools_backup\";i:1;}', 'N;', 1, 'a:1:{i:1;i:1;}', 1, 0),
(5, 'Staff', 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'a:41:{s:5:\"admin\";i:1;s:10:\"admin_logs\";i:1;s:16:\"admin_logs_admin\";i:1;s:17:\"admin_logs_member\";i:1;s:16:\"admin_logs_email\";i:1;s:16:\"admin_logs_error\";i:1;s:19:\"admin_logs_security\";i:1;s:17:\"admin_logs_ticket\";i:1;s:6:\"manage\";i:1;s:13:\"manage_ticket\";i:1;s:19:\"manage_ticket_reply\";i:1;s:25:\"manage_ticket_assign_self\";i:1;s:18:\"manage_ticket_hold\";i:1;s:22:\"manage_ticket_escalate\";i:1;s:18:\"manage_ticket_move\";i:1;s:19:\"manage_ticket_close\";i:1;s:20:\"manage_ticket_delete\";i:1;s:20:\"manage_ticket_reopen\";i:1;s:13:\"manage_canned\";i:1;s:15:\"manage_announce\";i:1;s:19:\"manage_announce_add\";i:1;s:20:\"manage_announce_edit\";i:1;s:22:\"manage_announce_delete\";i:1;s:13:\"manage_member\";i:1;s:17:\"manage_member_add\";i:1;s:18:\"manage_member_edit\";i:1;s:20:\"manage_member_delete\";i:1;s:21:\"manage_member_approve\";i:1;s:14:\"manage_article\";i:1;s:18:\"manage_article_add\";i:1;s:19:\"manage_article_edit\";i:1;s:21:\"manage_article_delete\";i:1;s:10:\"manage_cat\";i:1;s:14:\"manage_cat_add\";i:1;s:15:\"manage_cat_edit\";i:1;s:17:\"manage_cat_delete\";i:1;s:5:\"tools\";i:1;s:11:\"tools_maint\";i:1;s:19:\"tools_maint_recount\";i:1;s:16:\"tools_maint_optm\";i:1;s:20:\"tools_maint_syscheck\";i:1;}', 'N;', 1, 'a:1:{i:1;i:1;}', 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_in_email_log`
--

CREATE TABLE `td_in_email_log` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `date` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_languages`
--

CREATE TABLE `td_languages` (
  `id` int(11) NOT NULL,
  `lkey` varchar(5) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL DEFAULT '',
  `users` int(11) NOT NULL DEFAULT '0',
  `default` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_languages`
--

INSERT INTO `td_languages` (`id`, `lkey`, `name`, `users`, `default`) VALUES
(1, 'en', 'English', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_logs`
--

CREATE TABLE `td_logs` (
  `id` int(11) NOT NULL,
  `mid` int(11) NOT NULL DEFAULT '0',
  `mname` varchar(255) NOT NULL DEFAULT '',
  `action` text NOT NULL,
  `extra` text NOT NULL,
  `type` tinyint(1) NOT NULL DEFAULT '0',
  `level` tinyint(1) NOT NULL DEFAULT '0',
  `date` int(10) NOT NULL DEFAULT '0',
  `ipadd` varchar(32) NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_members`
--

CREATE TABLE `td_members` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `email` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `pass_salt` varchar(255) NOT NULL DEFAULT '',
  `login_key` varchar(255) NOT NULL DEFAULT '',
  `mgroup` int(11) NOT NULL DEFAULT '0',
  `msub_group` varchar(255) NOT NULL DEFAULT '',
  `title` varchar(255) NOT NULL DEFAULT '',
  `joined` int(10) NOT NULL DEFAULT '0',
  `ipadd` varchar(32) NOT NULL DEFAULT '',
  `open_tickets` int(11) NOT NULL DEFAULT '0',
  `tickets` int(11) NOT NULL DEFAULT '0',
  `rating` float NOT NULL DEFAULT '0',
  `rating_total` int(11) NOT NULL DEFAULT '0',
  `votes` int(11) NOT NULL DEFAULT '0',
  `email_notify` tinyint(1) NOT NULL DEFAULT '0',
  `email_html` tinyint(1) NOT NULL DEFAULT '0',
  `email_new_ticket` tinyint(1) NOT NULL DEFAULT '0',
  `email_ticket_reply` tinyint(1) NOT NULL DEFAULT '0',
  `email_announce` tinyint(1) NOT NULL DEFAULT '0',
  `ban_ticket_center` tinyint(1) NOT NULL DEFAULT '0',
  `ban_ticket_open` tinyint(1) NOT NULL DEFAULT '0',
  `ban_ticket_escalate` tinyint(1) NOT NULL DEFAULT '0',
  `ban_ticket_rate` tinyint(1) NOT NULL DEFAULT '0',
  `ban_kb` tinyint(1) NOT NULL DEFAULT '0',
  `ban_kb_comment` tinyint(1) NOT NULL DEFAULT '0',
  `ban_kb_rate` tinyint(1) NOT NULL DEFAULT '0',
  `time_zone` varchar(3) NOT NULL DEFAULT '',
  `dst_active` tinyint(1) NOT NULL DEFAULT '0',
  `lang` varchar(3) NOT NULL DEFAULT '',
  `skin` int(11) NOT NULL DEFAULT '0',
  `email_val` tinyint(1) NOT NULL DEFAULT '0',
  `admin_val` tinyint(1) NOT NULL DEFAULT '0',
  `email_staff_new_ticket` tinyint(1) NOT NULL DEFAULT '0',
  `email_staff_ticket_reply` tinyint(1) NOT NULL DEFAULT '0',
  `use_rte` tinyint(1) NOT NULL DEFAULT '0',
  `cpfields` text NOT NULL,
  `rss_key` varchar(255) NOT NULL DEFAULT '',
  `assigned` int(11) NOT NULL DEFAULT '0',
  `signature` text NOT NULL,
  `auto_sig` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_members`
--

INSERT INTO `td_members` (`id`, `name`, `email`, `password`, `pass_salt`, `login_key`, `mgroup`, `msub_group`, `title`, `joined`, `ipadd`, `open_tickets`, `tickets`, `rating`, `rating_total`, `votes`, `email_notify`, `email_html`, `email_new_ticket`, `email_ticket_reply`, `email_announce`, `ban_ticket_center`, `ban_ticket_open`, `ban_ticket_escalate`, `ban_ticket_rate`, `ban_kb`, `ban_kb_comment`, `ban_kb_rate`, `time_zone`, `dst_active`, `lang`, `skin`, `email_val`, `admin_val`, `email_staff_new_ticket`, `email_staff_ticket_reply`, `use_rte`, `cpfields`, `rss_key`, `assigned`, `signature`, `auto_sig`) VALUES
(1, 'admin', 'sebastian.marquez@koinoschile.com', '512178205e5dfe9e4e4abedd3a4bf64e2caa2e52', '5777f0f9c', 'LnpGdVhYZHQzUjVWNXNoNkRVSkNUdSQuL013Li4uaiQxJA', 4, '', 'Administrator', 1547582806, '::1', 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, '-4', 0, 'en', 1, 1, 1, 1, 1, 1, '', '90019c6adb4637d2782914b7035f25ea', 0, '', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_news_comments`
--

CREATE TABLE `td_news_comments` (
  `id` int(11) NOT NULL,
  `nid` int(11) NOT NULL DEFAULT '0',
  `mid` int(11) NOT NULL DEFAULT '0',
  `mname` varchar(255) NOT NULL DEFAULT '',
  `comment` longtext NOT NULL,
  `date` int(10) NOT NULL DEFAULT '0',
  `ipadd` varchar(32) NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_pages`
--

CREATE TABLE `td_pages` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `description` text NOT NULL,
  `template` varchar(255) NOT NULL DEFAULT '',
  `content` longtext NOT NULL,
  `type` tinyint(1) NOT NULL DEFAULT '0',
  `date` int(10) NOT NULL DEFAULT '0',
  `ipadd` varchar(32) NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_pages`
--

INSERT INTO `td_pages` (`id`, `name`, `description`, `template`, `content`, `type`, `date`, `ipadd`) VALUES
(1, 'Test Page', 'This is a test page that can be deleted at any time.', 'custom_page', 'This is a test page that can be deleted at any time.', 0, 1547582806, '::1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_profile_fields`
--

CREATE TABLE `td_profile_fields` (
  `id` int(11) NOT NULL,
  `reg` tinyint(1) NOT NULL DEFAULT '0',
  `fkey` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL DEFAULT '',
  `type` varchar(25) NOT NULL DEFAULT '',
  `extra` text NOT NULL,
  `perms` text NOT NULL,
  `required` tinyint(1) NOT NULL DEFAULT '0',
  `ticket` tinyint(1) NOT NULL DEFAULT '0',
  `staff` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_replies`
--

CREATE TABLE `td_replies` (
  `id` int(11) NOT NULL,
  `tid` int(11) NOT NULL DEFAULT '0',
  `mid` int(11) NOT NULL DEFAULT '0',
  `mname` varchar(255) NOT NULL DEFAULT '',
  `message` longtext NOT NULL,
  `staff` tinyint(1) NOT NULL DEFAULT '0',
  `rte` tinyint(1) NOT NULL DEFAULT '0',
  `secret` tinyint(1) NOT NULL DEFAULT '0',
  `attach_id` int(11) NOT NULL DEFAULT '0',
  `date` int(10) NOT NULL DEFAULT '0',
  `ipadd` varchar(32) NOT NULL DEFAULT '',
  `guest` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_reply_rate`
--

CREATE TABLE `td_reply_rate` (
  `id` int(11) NOT NULL,
  `tid` int(11) NOT NULL DEFAULT '0',
  `rid` int(11) NOT NULL DEFAULT '0',
  `mid` int(11) NOT NULL DEFAULT '0',
  `rating` int(11) NOT NULL DEFAULT '0',
  `date` int(10) NOT NULL DEFAULT '0',
  `ipadd` varchar(32) NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_sessions`
--

CREATE TABLE `td_sessions` (
  `s_id` varchar(33) NOT NULL DEFAULT '',
  `s_mid` int(11) NOT NULL DEFAULT '0',
  `s_mname` varchar(255) NOT NULL DEFAULT '',
  `s_email` varchar(255) NOT NULL DEFAULT '',
  `s_ipadd` varchar(32) NOT NULL DEFAULT '',
  `s_location` varchar(255) NOT NULL DEFAULT '',
  `s_time` int(10) NOT NULL DEFAULT '0',
  `s_guest` tinyint(1) NOT NULL DEFAULT '0',
  `s_tkey` varchar(255) NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_sessions`
--

INSERT INTO `td_sessions` (`s_id`, `s_mid`, `s_mname`, `s_email`, `s_ipadd`, `s_location`, `s_time`, `s_guest`, `s_tkey`) VALUES
('24c64a92a2236b4e5267666c1f434a78', 1, 'admin', '', '::1', '', 1547582808, 0, ''),
('dfc4749a252553d06c37fa4c6266ae79', 1, 'admin', '', '::1', 'portal', 1547585475, 0, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_settings`
--

CREATE TABLE `td_settings` (
  `cf_id` int(11) NOT NULL,
  `cf_key` varchar(255) NOT NULL DEFAULT '',
  `cf_title` varchar(255) NOT NULL DEFAULT '',
  `cf_description` text NOT NULL,
  `cf_group` int(11) NOT NULL DEFAULT '0',
  `cf_type` varchar(255) NOT NULL DEFAULT '',
  `cf_default` text NOT NULL,
  `cf_extra` text NOT NULL,
  `cf_value` text NOT NULL,
  `cf_protected` tinyint(4) NOT NULL DEFAULT '0',
  `cf_position` int(11) NOT NULL DEFAULT '0',
  `cf_cache` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_settings`
--

INSERT INTO `td_settings` (`cf_id`, `cf_key`, `cf_title`, `cf_description`, `cf_group`, `cf_type`, `cf_default`, `cf_extra`, `cf_value`, `cf_protected`, `cf_position`, `cf_cache`) VALUES
(1, 'hd_name', 'Help Desk Name', 'This is the name of your help desk system.  It\'s used when relating to this system.', 1, 'input', 'Koinos help desk', '', 'Koinos help desk', 1, 1, 1),
(2, 'announce_amount', 'Announcements to Show on Portal', 'This is the number of announcements that will be shown on the portal page.', 7, 'input', '3', '', '3', 1, 3, 1),
(3, 'recent_articles', 'Recent Articles to Show', 'This is the number of recent articles that will be shown on the portal / main page.', 1, 'input', '5', '', '5', 1, 4, 1),
(4, 'popular_articles', 'Most Popular Articles to Show', 'This is the number of most popular articles that will be shown on the portal / main page.', 1, 'input', '5', '', '5', 1, 5, 1),
(5, 'enable_registration', 'Allow Registration', 'If yes, guests will be able to register on this system as a new member.', 2, 'yes_no', '1', '', '1', 1, 1, 1),
(6, 'email_validation', 'Require Email Validation', 'If yes, users will be required to verify their email before being placed in the members group.', 2, 'yes_no', '1', '', '1', 1, 2, 1),
(7, 'session_timeout', 'Session Timeout', 'The number of minutes a session lasts before it expires.', 2, 'input', '20', '', '20', 1, 6, 1),
(8, 'shutdown_queries', 'Enable Shutdown Queries', 'If yes, some non-important queries to the currently loading page will be saved and run after the output.', 1, 'yes_no', '1', '', '1', 1, 2, 1),
(9, 'enable_gzip', 'Enable GZIP Compression', 'If yes, the HTML output to the browser will be compressed to save loading time.  Some servers do not support this.', 1, 'yes_no', '1', '', '1', 1, 3, 1),
(10, 'allow_new_tickets', 'Allow New Tickets', 'If yes, members will be allowed to access the \'Open a Ticket\' page and submit a new ticket.', 3, 'yes_no', '1', '', '1', 1, 1, 1),
(29, 'enable_ticket_rte', 'Enable Rich Text Editor', 'If enabled, staff will be able to reply to tickets using TinyMCE Rich Text Editor.', 3, 'yes_no', '1', '', '1', 1, 5, 1),
(12, 'enable_kb', 'Enable Knowledge Base', 'If yes, the knowledge base section will be active.', 4, 'yes_no', '1', '', '1', 1, 1, 1),
(13, 'allow_kb_rating', 'Allow Rating', 'If yes, members will be able to rate KB articles.  (Per group permission).', 4, 'yes_no', '1', '', '1', 1, 2, 1),
(14, 'allow_kb_comment', 'Allow Commenting', 'If yes, members will be able to comment on KB articles.  (Per group permission).', 4, 'yes_no', '1', '', '1', 1, 3, 1),
(15, 'ban_names', 'Banned Usernames', 'List of banned usernames, seperated by a line break.', 5, 'textarea', '', '', '', 1, 1, 1),
(16, 'ban_emails', 'Banned Emails', 'List of banned emails, seperated by a line break.', 5, 'textarea', '', '', '', 1, 2, 1),
(17, 'ban_ips', 'Banned IPs', 'List of banned ip addresses, seperated by a line break.', 5, 'textarea', '', '', '', 1, 3, 1),
(18, 'allow_reply_rating', 'Allow Reply Rating', 'If yes, members will be able to rate staff replies to tickets with thumbs up or down.', 3, 'yes_no', '1', '', '1', 1, 3, 1),
(19, 'allow_change_skin', 'Allow Skin Changing', 'If yes users will be able to change their skin based on group permissions.', 6, 'yes_no', '1', '', '1', 1, 1, 1),
(20, 'allow_change_lang', 'Allow Language Changing', 'If yes, users will be able to change their language based on group permissions.', 6, 'yes_no', '1', '', '1', 1, 2, 1),
(21, 'admin_validation', 'Require Admin Validation', 'If yes, an administrator must approve all new accounts before they are moved into the members group.', 2, 'yes_no', '0', '', '0', 1, 3, 1),
(22, 'out_email', 'Outgoing Email', 'This email will be used when Trellis Desk sends emails to your users.', 8, 'input', 'sebastian.marquez@koinoschile.com', '', 'sebastian.marquez@koinoschile.com', 1, 1, 1),
(23, 'use_captcha', 'Enable Captcha', 'If enabled, users will be required to enter a code from a captcha image on some forms.', 2, 'yes_no', '1', '', '1', 1, 7, 1),
(24, 'enable_kb_rte', 'Enable Rich Text Editor', 'If enabled, users will be able to edit articles using TinyMCE Rich Text Editor.', 4, 'yes_no', '1', '', '1', 1, 4, 1),
(25, 'color_priorities', 'Color Priorities', 'If yes, ticket priorities will be color coded for better identification in ticket lists.', 3, 'yes_no', '1', '', '1', 1, 4, 1),
(26, 'session_ip_check', 'Check Session IP', 'If yes, the IP address of the user will be verified with the database on each load.', 2, 'yes_no', '0', '', '0', 1, 8, 1),
(27, 'use_form_tokens', 'Enable Form Tokens', 'If enabled, a random token hash will be verified with the database on each form to help prevent spam.', 2, 'yes_no', '0', '', '0', 1, 9, 1),
(28, 'token_ip_check', 'Check Token IP', 'If yes, the IP address of the user will be verified with each form token.', 2, 'yes_no', '1', '', '1', 1, 10, 1),
(30, 'ticket_attachments', 'Allow Attachments', 'If yes, users will be able to attach files to tickets, based on group and department permissions.', 3, 'yes_no', '1', '', '1', 1, 6, 1),
(31, 'upload_dir', 'Upload Directory', 'Full path to upload directory.', 1, 'input', 'C:/xampp/htdocs/helpdesk/uploads', '', 'C:/xampp/htdocs/helpdesk/uploads', 1, 7, 1),
(32, 'upload_url', 'Upload URL', 'URL to the upload directory.', 1, 'input', 'http://localhost/helpdesk/uploads', '', 'http://localhost/helpdesk/uploads', 1, 8, 1),
(33, 'upload_exts', 'Allowed Upload Extensions', 'A list of allowed upload extensions.  Seperate by a pipe (|).', 1, 'input', '.gif|.jpeg|.jpg|.png|.html|.doc|.docx|.xls|.xlsx|.txt|.pdf|.zip|.gz|.rar|.tar', '', '.gif|.jpeg|.jpg|.png|.html|.doc|.docx|.xls|.xlsx|.txt|.pdf|.zip|.gz|.rar|.tar', 1, 9, 1),
(34, 'enable_news', 'Enable Announcements', 'If yes, the announcement system will be active.', 7, 'yes_no', '1', '', '1', 1, 1, 1),
(35, 'display_qnews', 'Display Announcements on Portal', 'If yes, an announcements section will be added to the portal displaying the excerpts for each item.', 7, 'yes_no', '1', '', '1', 1, 2, 1),
(36, 'enable_news_page', 'Enable News Page', 'If yes, the news page will be active.  The news page displays the full details of recent news items.', 7, 'yes_no', '1', '', '1', 1, 5, 1),
(37, 'news_page_amount', 'Announcements to Show on News Page', 'The number of announcements that will be shown on the news page.  Leave blank to display all.', 7, 'input', '10', '', '10', 1, 6, 1),
(38, 'news_comments', 'Allow Commenting', 'If yes, members will be able to comment on announcements. (Per group permission).', 7, 'yes_no', '1', '', '1', 1, 7, 1),
(39, 'enable_news_rte', 'Enable Rich Text Editor', 'If enabled, users will be able to edit announcements using TinyMCE Rich Text Editor.', 7, 'yes_no', '1', '', '1', 1, 8, 1),
(41, 'guest_ticket_emails', 'Allow Guest Ticket Notification Emails', 'If yes, a guest will have the option of receiving email notifications when updates have been made to their ticket.', 3, 'yes_no', '1', '', '1', 1, 7, 1),
(42, 'guest_upgrade', 'Allow Guest Upgrading', 'If yes, guests will be able to upgrade their account to a registered member by simply providing additionally information, rather than having to manually register.  The guests tickets will also be saved and accessible in the registered account.', 3, 'yes_no', '1', '', '1', 1, 8, 1),
(43, 'cookie_domain', 'Cookie Domain', 'The domain of all cookies set by Trellis Desk.  Use .yourdomain.com for global cookies.', 1, 'input', '', '', '', 1, 9, 1),
(44, 'cookie_prefix', 'Cookie Prefix', 'Prefix used for all cookies names.  Allows multiple installations under the same path.', 1, 'input', '', '', '', 1, 10, 1),
(45, 'cookie_path', 'Cookie Path', 'Relative path to Trellis Desk installation.  Usually this can be left blank.', 1, 'input', '', '', '', 1, 11, 1),
(46, 'tickets_suggest', 'Enable KB Suggestions', 'If enabled, Trellis Desk will search the KB for articles that might answer the users\' inquiry before the ticket is sent.', 3, 'yes_no', '1', '', '1', 1, 2, 1),
(47, 'news_excerpt_trim', 'Excerpt Character Limit', 'Character count cut-off for excerpts (only applies to announcements that do not have a custom excerpt).  Leave blank to disable.', 7, 'input', '200', '', '200', 1, 4, 1),
(48, 'hour_offset', 'Hour Offset', 'Hour offset for Trellis Desk time.  Only adjust if your server\'s time is not correctly set to GMT.', 1, 'input', '', '', '', 1, 13, 1),
(49, 'minute_offset', 'Minute Offset', 'Minute offset for Trellis Desk time.  Only adjust if your server\'s time is not correctly set to GMT.', 1, 'input', '', '', '', 1, 14, 1),
(50, 'val_hours_p', 'Password Validation Expiration', 'The amount of hours in which a reset password validation code will expire.', 2, 'input', '1', '', '1', 1, 5, 1),
(51, 'val_hours_e', 'Email Validation Expiration', 'The amount of hours in which a email validation code will expire.', 2, 'input', '168', '', '168', 1, 4, 1),
(52, 'acp_help', 'Show ACP Inline Help', 'If set to yes, additional documentation will be available for several ACP settings.  To view this information, simply click the Toggle Information link.', 1, 'yes_no', '1', '', '1', 1, 15, 1),
(53, 'email_method', 'Email Method', 'Your outgoing emails will be sent using this method.', 8, 'dropdown', 'native', 'native=PHP mail()\r\nsmtp=SMTP', 'native', 1, 2, 1),
(54, 'smtp_host', 'SMTP Host', 'SMTP Host for outgoing emails (only applies if the Email Method is set to SMTP).', 8, 'input', 'localhost', '', 'localhost', 1, 3, 1),
(55, 'smtp_port', 'SMTP Port', 'The connection port for the above SMTP host (only applies if the Email Method is set to SMTP).  This is usually 25.', 8, 'input', '25', '', '25', 1, 4, 1),
(56, 'smtp_user', 'SMTP Username', 'SMTP username if authentication is required for SMTP (only applies if the Email Method is set to SMTP).', 8, 'input', '', '', '', 1, 5, 1),
(57, 'smtp_pass', 'SMTP Password', 'SMTP password if authentication is required for SMTP (only applies if the Email Method is set to SMTP).  This password will be stored in plaintext in your database.', 8, 'input', '', '', '', 1, 6, 1),
(58, 'smtp_encryption', 'SMTP Encryption', 'SMTP encryption method if your SMTP host requires it (only applies if the Email Method is set to SMTP).', 8, 'dropdown', '0', '0=None\r\nssl=SSL\r\ntls=TLS', '0', 1, 7, 1),
(59, 'email_flood', 'Incoming Flood Prevention', 'If enabled, Trellis Desk will attempt to prevent incoming email floods and infinite loops due to auto-responders on piping and POP3.', 8, 'enabled_disabled', '1', '', '1', 1, 7, 1),
(60, 'email_subject_regex', 'Subject Regular Expression', 'This is the regular expression used when detecting the ticket ID number for email ticket replies.', 8, 'input', '/Ticket ID #&#40;[0-9]+&#41;/i', '', '/Ticket ID #&#40;[0-9]+&#41;/i', 1, 8, 1),
(61, 'email_use_rline', 'Enable Reply Above Line', 'If enabled, Trellis Desk will search for the reply line and only include the content above in ticket replies.', 8, 'yes_no', '1', '', '1', 1, 9, 1),
(62, 'email_reply_line', 'Reply Above Line', 'This is line Trellis Desk searches for in email ticket replies as the marker for the end of the reply message.', 8, 'input', '==== REPLY ABOVE THIS LINE ====', '', '==== REPLY ABOVE THIS LINE ====', 1, 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_settings_groups`
--

CREATE TABLE `td_settings_groups` (
  `cg_id` int(11) NOT NULL,
  `cg_key` varchar(255) NOT NULL DEFAULT '',
  `cg_name` varchar(255) NOT NULL DEFAULT '',
  `cg_description` text NOT NULL,
  `cg_set_count` int(11) NOT NULL DEFAULT '0',
  `cg_hide` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_settings_groups`
--

INSERT INTO `td_settings_groups` (`cg_id`, `cg_key`, `cg_name`, `cg_description`, `cg_set_count`, `cg_hide`) VALUES
(1, 'general', 'General Configuration', 'Basic settings for Help Desk such as URLs, paths, and global features.', 14, 0),
(2, 'security', 'Security &amp; Privacy', 'Settings that control important security features such as session timeouts, IP matching, registration, etc.', 10, 0),
(3, 'ticket', 'Ticket Settings', 'General ticket settings such as escalation time.', 8, 0),
(4, 'kb', 'Knowledge Base Settings', 'General settings for the knowledge base such as allow the rating of articles, allow commenting, etc.', 4, 0),
(5, 'ban', 'Ban Filters', 'These settings control the ban filters for Trellis Desk.', 3, 0),
(6, 'skin_lang', 'Skins &amp; Languages', 'Settings such as allow members to change skin / language.', 2, 0),
(7, 'news', 'Announcement Settings', 'General settings for the announcement system such as RTE support, commenting, etc.', 8, 0),
(8, 'email', 'Email Configuration', 'Email settings and configuration such as mailing method, outgoing email, etc.', 11, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_skins`
--

CREATE TABLE `td_skins` (
  `id` tinyint(4) NOT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `img_dir` varchar(255) NOT NULL DEFAULT '',
  `users` int(11) NOT NULL DEFAULT '0',
  `default` tinyint(1) NOT NULL DEFAULT '0',
  `author` varchar(255) NOT NULL DEFAULT '',
  `author_email` varchar(255) NOT NULL DEFAULT '',
  `author_web` varchar(255) NOT NULL DEFAULT '',
  `notes` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_skins`
--

INSERT INTO `td_skins` (`id`, `name`, `img_dir`, `users`, `default`, `author`, `author_email`, `author_web`, `notes`) VALUES
(1, 'Trellis Desk Default', 'default', 1, 1, 'ACCORD5', 'sales@accord5.com', 'http://www.accord5.com/', '&copy; 2007 ACCORD5'),
(2, 'Trellis Desk Classic', 'classic', 0, 0, 'ACCORD5', 'sales@accord5.com', 'http://www.accord5.com/', '&copy; 2007 ACCORD5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_tickets`
--

CREATE TABLE `td_tickets` (
  `id` int(11) NOT NULL,
  `tkey` varchar(255) NOT NULL DEFAULT '',
  `did` int(11) NOT NULL DEFAULT '0',
  `dname` varchar(255) NOT NULL DEFAULT '',
  `mid` int(11) NOT NULL DEFAULT '0',
  `mname` varchar(255) NOT NULL DEFAULT '',
  `amid` int(11) NOT NULL DEFAULT '0',
  `amname` varchar(255) NOT NULL DEFAULT '',
  `email` varchar(255) NOT NULL DEFAULT '',
  `subject` varchar(255) NOT NULL DEFAULT '',
  `priority` tinyint(3) NOT NULL DEFAULT '0',
  `message` longtext NOT NULL,
  `date` int(10) NOT NULL DEFAULT '0',
  `last_reply` int(10) NOT NULL DEFAULT '0',
  `last_reply_staff` int(10) NOT NULL DEFAULT '0',
  `last_mid` int(11) NOT NULL DEFAULT '0',
  `last_mname` varchar(255) NOT NULL DEFAULT '',
  `ipadd` varchar(32) NOT NULL DEFAULT '',
  `replies` int(11) NOT NULL DEFAULT '0',
  `votes` int(11) NOT NULL DEFAULT '0',
  `rating` float NOT NULL DEFAULT '0',
  `rating_total` float NOT NULL DEFAULT '0',
  `notes` text NOT NULL,
  `status` tinyint(3) NOT NULL DEFAULT '0',
  `close_mid` int(11) NOT NULL DEFAULT '0',
  `close_mname` varchar(255) NOT NULL DEFAULT '',
  `close_reason` text NOT NULL,
  `auto_close` int(10) NOT NULL DEFAULT '0',
  `attach_id` int(11) NOT NULL DEFAULT '0',
  `cdfields` text NOT NULL,
  `guest` tinyint(1) NOT NULL DEFAULT '0',
  `guest_email` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_tokens`
--

CREATE TABLE `td_tokens` (
  `id` int(11) NOT NULL,
  `token` varchar(255) NOT NULL DEFAULT '',
  `type` varchar(32) NOT NULL DEFAULT '',
  `ipadd` varchar(32) NOT NULL DEFAULT '',
  `date` int(10) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_upg_history`
--

CREATE TABLE `td_upg_history` (
  `id` int(11) NOT NULL,
  `verid` int(11) NOT NULL DEFAULT '0',
  `verhuman` varchar(255) NOT NULL DEFAULT '',
  `date` int(10) NOT NULL DEFAULT '0',
  `username` varchar(255) NOT NULL DEFAULT '',
  `ukey` varchar(255) NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `td_upg_history`
--

INSERT INTO `td_upg_history` (`id`, `verid`, `verhuman`, `date`, `username`, `ukey`) VALUES
(1, 10440094, 'v1.0.4 Final', 1547582806, 'admin', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_validation`
--

CREATE TABLE `td_validation` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `mid` int(11) NOT NULL DEFAULT '0',
  `mname` varchar(255) NOT NULL DEFAULT '',
  `new_email` varchar(255) NOT NULL DEFAULT '',
  `date` int(10) NOT NULL DEFAULT '0',
  `type` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `td_announcements`
--
ALTER TABLE `td_announcements`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_articles`
--
ALTER TABLE `td_articles`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `td_articles` ADD FULLTEXT KEY `full_index` (`name`,`description`,`article`);

--
-- Indices de la tabla `td_article_rate`
--
ALTER TABLE `td_article_rate`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_asessions`
--
ALTER TABLE `td_asessions`
  ADD PRIMARY KEY (`s_id`);

--
-- Indices de la tabla `td_attachments`
--
ALTER TABLE `td_attachments`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_canned`
--
ALTER TABLE `td_canned`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_categories`
--
ALTER TABLE `td_categories`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_comments`
--
ALTER TABLE `td_comments`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_departments`
--
ALTER TABLE `td_departments`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_depart_fields`
--
ALTER TABLE `td_depart_fields`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_groups`
--
ALTER TABLE `td_groups`
  ADD PRIMARY KEY (`g_id`);

--
-- Indices de la tabla `td_in_email_log`
--
ALTER TABLE `td_in_email_log`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_languages`
--
ALTER TABLE `td_languages`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_logs`
--
ALTER TABLE `td_logs`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_members`
--
ALTER TABLE `td_members`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_news_comments`
--
ALTER TABLE `td_news_comments`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_pages`
--
ALTER TABLE `td_pages`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_profile_fields`
--
ALTER TABLE `td_profile_fields`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_replies`
--
ALTER TABLE `td_replies`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_reply_rate`
--
ALTER TABLE `td_reply_rate`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_sessions`
--
ALTER TABLE `td_sessions`
  ADD PRIMARY KEY (`s_id`);

--
-- Indices de la tabla `td_settings`
--
ALTER TABLE `td_settings`
  ADD PRIMARY KEY (`cf_id`);

--
-- Indices de la tabla `td_settings_groups`
--
ALTER TABLE `td_settings_groups`
  ADD PRIMARY KEY (`cg_id`);

--
-- Indices de la tabla `td_skins`
--
ALTER TABLE `td_skins`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_tickets`
--
ALTER TABLE `td_tickets`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_tokens`
--
ALTER TABLE `td_tokens`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_upg_history`
--
ALTER TABLE `td_upg_history`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `td_validation`
--
ALTER TABLE `td_validation`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `td_announcements`
--
ALTER TABLE `td_announcements`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `td_articles`
--
ALTER TABLE `td_articles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `td_article_rate`
--
ALTER TABLE `td_article_rate`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `td_attachments`
--
ALTER TABLE `td_attachments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `td_canned`
--
ALTER TABLE `td_canned`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `td_categories`
--
ALTER TABLE `td_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `td_comments`
--
ALTER TABLE `td_comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `td_departments`
--
ALTER TABLE `td_departments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `td_depart_fields`
--
ALTER TABLE `td_depart_fields`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `td_groups`
--
ALTER TABLE `td_groups`
  MODIFY `g_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `td_in_email_log`
--
ALTER TABLE `td_in_email_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `td_languages`
--
ALTER TABLE `td_languages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `td_logs`
--
ALTER TABLE `td_logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `td_members`
--
ALTER TABLE `td_members`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `td_news_comments`
--
ALTER TABLE `td_news_comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `td_pages`
--
ALTER TABLE `td_pages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `td_profile_fields`
--
ALTER TABLE `td_profile_fields`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `td_replies`
--
ALTER TABLE `td_replies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `td_reply_rate`
--
ALTER TABLE `td_reply_rate`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `td_settings`
--
ALTER TABLE `td_settings`
  MODIFY `cf_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT de la tabla `td_settings_groups`
--
ALTER TABLE `td_settings_groups`
  MODIFY `cg_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `td_skins`
--
ALTER TABLE `td_skins`
  MODIFY `id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `td_tickets`
--
ALTER TABLE `td_tickets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `td_tokens`
--
ALTER TABLE `td_tokens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `td_upg_history`
--
ALTER TABLE `td_upg_history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
