DROP SCHEMA IF EXISTS Epers_EjHibernate;
CREATE SCHEMA Epers_EjHibernate;

USE Epers_EjHibernate;

CREATE TABLE  `Epers_EjHibernate`.`Usuario` (
  `U_ID` int(11) NOT NULL AUTO_INCREMENT,
  `U_NOMBRE` varchar(20) NOT NULL unique,
  PRIMARY KEY (`U_ID`)
) ENGINE = InnoDB AUTO_INCREMENT=1;

CREATE TABLE  `Epers_EjHibernate`.`Empresa` (
  `E_ID` int(11) NOT NULL AUTO_INCREMENT,
  `E_NOMBRE` varchar(20) NOT NULL unique,
  PRIMARY KEY (`E_ID`)
) ENGINE = InnoDB AUTO_INCREMENT=1;

CREATE TABLE  `Epers_EjHibernate`.`Aerolinea` (
  `A_ID` int(11) NOT NULL AUTO_INCREMENT,
  `A_NOMBRE` varchar(20) NOT NULL unique,
  `A_IDE` int(11) NOT NULL ,
  PRIMARY KEY (`A_ID`),
  FOREIGN KEY (A_IDE) 
    REFERENCES Empresa(E_ID) 
    ON DELETE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT=1;

CREATE TABLE  `Epers_EjHibernate`.`Vuelo` (
  `V_ID` int(11) NOT NULL AUTO_INCREMENT,
  `V_IDA` int(11) NOT NULL ,
   PRIMARY KEY (`V_ID`),
  FOREIGN KEY (V_IDA) 
    REFERENCES Aerolinea(A_ID) 
    ON DELETE CASCADE  
) ENGINE = InnoDB AUTO_INCREMENT=1;

CREATE TABLE  `Epers_EjHibernate`.`Tramo` (
  `T_ID` int(11) NOT NULL AUTO_INCREMENT,
  `T_ORIGEN` varchar(20) NOT NULL,
  `T_DESTINO` varchar(20) NOT NULL,
  `T_HORASALIDA` int(11) NOT NULL,
  `T_HORALLEGADA` int(11) NOT NULL,
  `T_PRECIO`int(11) NOT NULL,
  `T_IDV` int(11) NOT NULL ,
    PRIMARY KEY (`T_IDV`),
  FOREIGN KEY (T_ID) 
    REFERENCES Vuelo(V_ID) 
    ON DELETE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT=1;

CREATE TABLE  `Epers_EjHibernate`.`Asiento` (
  `S_ID` int(11) NOT NULL AUTO_INCREMENT,
  `S_CAT_PRECIO` varchar(20) NOT NULL unique,
  `S_USUARIOID` int(11),
  PRIMARY KEY (`S_ID`)
) ENGINE = InnoDB AUTO_INCREMENT=1;









