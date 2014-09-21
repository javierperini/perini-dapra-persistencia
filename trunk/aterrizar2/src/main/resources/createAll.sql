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
  `A_ID` int(11) NOT NULL AUTO_INCREMENT,
  `A_NOMBRE` varchar(20) NOT NULL,
  `A_IDE` int(11) NOT NULL,
  PRIMARY KEY (`A_ID`),
  UNIQUE KEY `A_NOMBRE` (`A_NOMBRE`),
  KEY `A_IDE` (`A_IDE`),
  CONSTRAINT `Aerolinea_ibfk_1` FOREIGN KEY (`A_IDE`) REFERENCES `Empresa` (`E_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Aerolinea`
--

LOCK TABLES `Aerolinea` WRITE;
/*!40000 ALTER TABLE `Aerolinea` DISABLE KEYS */;
/*!40000 ALTER TABLE `Aerolinea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Asiento`
--

DROP TABLE IF EXISTS `Asiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Asiento` (
  `S_ID` int(11) NOT NULL AUTO_INCREMENT,
  `S_CAT_PRECIO` varchar(20) NOT NULL,
  `S_USUARIOID` int(11) DEFAULT NULL,
  PRIMARY KEY (`S_ID`),
  UNIQUE KEY `S_CAT_PRECIO` (`S_CAT_PRECIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Asiento`
--

LOCK TABLES `Asiento` WRITE;
/*!40000 ALTER TABLE `Asiento` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Empresa`
--

LOCK TABLES `Empresa` WRITE;
/*!40000 ALTER TABLE `Empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `Empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tramo`
--

DROP TABLE IF EXISTS `Tramo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tramo` (
  `T_ID` int(11) NOT NULL AUTO_INCREMENT,
  `T_ORIGEN` varchar(20) NOT NULL,
  `T_DESTINO` varchar(20) NOT NULL,
  `T_HORASALIDA` int(11) NOT NULL,
  `T_HORALLEGADA` int(11) NOT NULL,
  `T_PRECIO` int(11) NOT NULL,
  `T_IDV` int(11) NOT NULL,
  PRIMARY KEY (`T_IDV`),
  KEY `T_ID` (`T_ID`),
  CONSTRAINT `Tramo_ibfk_1` FOREIGN KEY (`T_ID`) REFERENCES `Vuelo` (`V_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tramo`
--

LOCK TABLES `Tramo` WRITE;
/*!40000 ALTER TABLE `Tramo` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tramo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `U_ID` int(11) NOT NULL AUTO_INCREMENT,
  `U_NOMBRE` varchar(20) NOT NULL,
  PRIMARY KEY (`U_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (12,'UnUsuario');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vuelo`
--

DROP TABLE IF EXISTS `Vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Vuelo` (
  `V_ID` int(11) NOT NULL AUTO_INCREMENT,
  `V_IDA` int(11) NOT NULL,
  PRIMARY KEY (`V_ID`),
  KEY `V_IDA` (`V_IDA`),
  CONSTRAINT `Vuelo_ibfk_1` FOREIGN KEY (`V_IDA`) REFERENCES `Aerolinea` (`A_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vuelo`
--

LOCK TABLES `Vuelo` WRITE;
/*!40000 ALTER TABLE `Vuelo` DISABLE KEYS */;
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

-- Dump completed on 2014-09-15 21:50:05








