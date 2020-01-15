create database product_gallery;

use product_gallery;

create table category 
(
	id int primary key auto_increment,
    parent_id int, 
    name varchar(255),
    image LONGTEXT
);


create table product 
(
	id bigint(20) auto_increment,
    category_id int,
    name varchar(255),
    description LONGTEXT,
    price int,
    PRIMARY KEY (id)
);

create table product_photo
(
	id bigint primary key auto_increment,
    product_id bigint,
    image LONGTEXT
);

ALTER TABLE product
ADD FOREIGN KEY (category_id) REFERENCES category(id);

ALTER TABLE product_photo
ADD FOREIGN KEY (product_id) REFERENCES product(id);

CREATE TABLE `oauth_access_token` (
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(255) DEFAULT NULL
);

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
);


CREATE TABLE `oauth_client_token` (
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL
);

CREATE TABLE `oauth_code` (
  `code` varchar(255) DEFAULT NULL,
  `authentication` blob
);

CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication` blob
);

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_expired` tinyint(1) DEFAULT NULL,
  `account_locked` tinyint(1) DEFAULT NULL,
  `credentials_expired` tinyint(1) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `guid` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sure_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_user_name` (`user_name`)
);

CREATE TABLE `user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_expired` bit(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `credentials_expired` bit(1) DEFAULT NULL,
  `credentials_expired_date` datetime DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `locked` bit(1) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_info_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_user_info_id` (`user_info_id`),
  CONSTRAINT `fk_user_account_user` FOREIGN KEY (`user_info_id`) REFERENCES `sys_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
