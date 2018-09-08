CREATE DATABASE `dataBase` /*!40100 DEFAULT CHARACTER SET utf8 */;
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
    `role_id` INT(11) NOT NULL AUTO_INCREMENT,
    `role` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`role_id`)
)  ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
   
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `user_id` INT(11) NOT NULL AUTO_INCREMENT,
    `active` INT(11) DEFAULT NULL,
    `email` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`user_id`)
)  ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
    `user_id` INT(11) NOT NULL,
    `role_id` INT(11) NOT NULL,
    PRIMARY KEY (`user_id` , `role_id`),
    KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
    CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`user_id`),
    CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`)
        REFERENCES `role` (`role_id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;