DROP TABLE if EXISTS ota;

CREATE TABLE ota(
id  BIGINT SERIAL NOT NULL ,
`name` VARCHAR (255) not NULL ,
`desc` VARCHAR (255) not NULL ,
`code` INT(10)  not NULL
);

