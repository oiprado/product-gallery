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
