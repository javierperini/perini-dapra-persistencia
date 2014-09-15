DROP SCHEMA IF EXISTS Epers_EjHibernate;
CREATE SCHEMA Epers_EjHibernate;

USE Epers_EjHibernate;

CREATE TABLE  `Epers_EjHibernate`.`Usuarios` (
  `J_ID` int(11) NOT NULL AUTO_INCREMENT,
  `J_NOMBRE` varchar(20) NOT NULL,
  PRIMARY KEY (`J_ID`)
) ENGINE = InnoDB AUTO_INCREMENT=1;

CREATE TABLE  `Epers_EjHibernate`.`Empresa` (
  `J_ID` int(11) NOT NULL AUTO_INCREMENT,
  `J_NOMBRE` varchar(20) NOT NULL,
  PRIMARY KEY (`J_ID`)
) ENGINE = InnoDB AUTO_INCREMENT=1;

