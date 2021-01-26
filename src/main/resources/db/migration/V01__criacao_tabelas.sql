CREATE TABLE `tbl_tool` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `link` varchar(250) NOT NULL,
  `description` varchar(400) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_tem_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `tbl_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_tem_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `tbl_tool_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tool_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_tem_UNIQUE` (`id`),
  KEY `fk_tool_idx` (`tool_id`),
  KEY `fk_tag_idx` (`tag_id`),
  CONSTRAINT `fk_tag` FOREIGN KEY (`tag_id`) REFERENCES `tbl_tag` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tool` FOREIGN KEY (`tool_id`) REFERENCES `tbl_tool` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

