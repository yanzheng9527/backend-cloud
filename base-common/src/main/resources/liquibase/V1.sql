--liquibase formatted sql

--changeset randy:1
drop table if exists location;

/*==============================================================*/
/* Table: location                                              */
/*==============================================================*/
create table location
(
   id                   varchar(50) not null  comment '',
   name                 varchar(100)  comment '',
   description          varchar(1000)  comment '',
   picture              varchar(300)  comment '',
   longitude            varchar(50)  comment '',
   latitude             varchar(50)  comment '',
   status               varchar(50)  comment '',
   primary key (id)
);

INSERT INTO `location`(`id`, `name`, `description`, `picture`, `longitude`, `latitude`, `status`) VALUES ('152cb6b39d8a4b80b0938cc6107eb54b', '宝力西南门', NULL, NULL, '114.378637', '30.462851', NULL);
INSERT INTO `location`(`id`, `name`, `description`, `picture`, `longitude`, `latitude`, `status`) VALUES ('1570f09c9ad84302890bbf2a5be6c2fb', '宝力社区医院', NULL, NULL, '114.379748', '30.463577', NULL);
INSERT INTO `location`(`id`, `name`, `description`, `picture`, `longitude`, `latitude`, `status`) VALUES ('cb5e6bde89944b5bafb1fcd0c9268628', '宝力健身', NULL, NULL, '114.380291', '30.462795', NULL);
INSERT INTO `location`(`id`, `name`, `description`, `picture`, `longitude`, `latitude`, `status`) VALUES ('cefe06426a9f443d8a6567cdbcbc288b', '宝力西北门', NULL, NULL, '114.380209', '30.463489', NULL);
INSERT INTO `location`(`id`, `name`, `description`, `picture`, `longitude`, `latitude`, `status`) VALUES ('ebfd2612274c46a390642177733dfc1e', '宝力菜鸟驿站', NULL, NULL, '114.380815', '30.463406', NULL);



