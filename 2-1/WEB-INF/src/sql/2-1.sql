create table IF NOT EXISTS catalog (id MEDIUMINT PRIMARY KEY AUTO_INCREMENT ,name varchar(128),price int,detail text,pictureurl varchar(255),index(id) ) type=INNODB;
