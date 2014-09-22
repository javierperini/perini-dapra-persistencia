-- MySQL dump 10.13  Distrib 5.5.38, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: Epers_EjHibernate
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Aerolinea`
--

DROP TABLE IF EXISTS `Aerolinea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Aerolinea` (
  `idAerolinea` int(11) NOT NULL AUTO_INCREMENT,
  `nombreAerolinea` varchar(40) NOT NULL,
  `idEmpresa` int(11) NOT NULL,
  PRIMARY KEY (`idAerolinea`),
  UNIQUE KEY `A_NOMBRE` (`nombreAerolinea`),
  KEY `A_IDE` (`idEmpresa`),
  CONSTRAINT `Aerolinea_ibfk_1` FOREIGN KEY (`idEmpresa`) REFERENCES `Empresa` (`E_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Aerolinea`
--

LOCK TABLES `Aerolinea` WRITE;
/*!40000 ALTER TABLE `Aerolinea` DISABLE KEYS */;
INSERT INTO `Aerolinea` VALUES (1,'lan',2),(2,'unNombreA',2);
/*!40000 ALTER TABLE `Aerolinea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Asiento`
--

DROP TABLE IF EXISTS `Asiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Asiento` (
  `idAsiento` int(11) NOT NULL AUTO_INCREMENT,
  `precioDeCategoria` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `reservado` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idAsiento`),
  UNIQUE KEY `S_CAT_PRECIO` (`precioDeCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Asiento`
--

LOCK TABLES `Asiento` WRITE;
/*!40000 ALTER TABLE `Asiento` DISABLE KEYS */;
INSERT INTO `Asiento` VALUES (2,0,2,0),(21,20,2,1);
/*!40000 ALTER TABLE `Asiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Empresa`
--

DROP TABLE IF EXISTS `Empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Empresa` (
  `E_ID` int(11) NOT NULL AUTO_INCREMENT,
  `E_NOMBRE` varchar(20) NOT NULL,
  PRIMARY KEY (`E_ID`),
  UNIQUE KEY `E_NOMBRE` (`E_NOMBRE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Empresa`
--

LOCK TABLES `Empresa` WRITE;
/*!40000 ALTER TABLE `Empresa` DISABLE KEYS */;
INSERT INTO `Empresa` VALUES (2,'unNombre');
/*!40000 ALTER TABLE `Empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tramo`
--

DROP TABLE IF EXISTS `Tramo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tramo` (
  `idTramo` int(11) NOT NULL AUTO_INCREMENT,
  `origen` varchar(20) NOT NULL,
  `destino` varchar(20) NOT NULL,
  `horaSalida` int(11) NOT NULL,
  `horaLlegada` int(11) NOT NULL,
  `precioBase` int(11) NOT NULL,
  `idVuelo` int(11) NOT NULL,
  PRIMARY KEY (`idTramo`),
  KEY `T_ID` (`idTramo`),
  KEY `fk_Tramo_1_idx` (`idVuelo`),
  CONSTRAINT `fk_Tramo_1` FOREIGN KEY (`idVuelo`) REFERENCES `Vuelo` (`idVuelo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tramo`
--

LOCK TABLES `Tramo` WRITE;
/*!40000 ALTER TABLE `Tramo` DISABLE KEYS */;
INSERT INTO `Tramo` VALUES (2,'unOrigenA','unDestinoA',22,22,12,2),(3,'China','Buenos Aires',1,2,30,2);
/*!40000 ALTER TABLE `Tramo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `U_NOMBRE` varchar(20) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (29,'usuario'),(44,'Juanca'),(45,'usuario'),(46,'JuanCito'),(47,'usuario');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vuelo`
--

DROP TABLE IF EXISTS `Vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Vuelo` (
  `idVuelo` int(11) NOT NULL AUTO_INCREMENT,
  `idAerolinea` int(11) NOT NULL,
  PRIMARY KEY (`idVuelo`),
  KEY `V_IDA` (`idAerolinea`),
  CONSTRAINT `Vuelo_ibfk_1` FOREIGN KEY (`idAerolinea`) REFERENCES `Aerolinea` (`idAerolinea`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vuelo`
--

LOCK TABLES `Vuelo` WRITE;
/*!40000 ALTER TABLE `Vuelo` DISABLE KEYS */;
INSERT INTO `Vuelo` VALUES (2,2);
/*!40000 ALTER TABLE `Vuelo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-22 19:57:16