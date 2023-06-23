-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto1prueba
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `catalogo`
--

DROP TABLE IF EXISTS `catalogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalogo` (
  `sala` int NOT NULL,
  `fotos` varchar(8) DEFAULT NULL,
  `PDF_areas` varchar(15) DEFAULT NULL,
  `Inf_eventos` int DEFAULT NULL,
  PRIMARY KEY (`sala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogo`
--

LOCK TABLES `catalogo` WRITE;
/*!40000 ALTER TABLE `catalogo` DISABLE KEYS */;
INSERT INTO `catalogo` VALUES (1,'S1.png','info.pdf',1);
/*!40000 ALTER TABLE `catalogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL,
  `nombre` varchar(8) DEFAULT NULL,
  `Cif` varchar(10) DEFAULT NULL,
  `Cif_Empresa` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `fk_cliente_empresa` (`Cif_Empresa`),
  CONSTRAINT `fk_cliente_empresa` FOREIGN KEY (`Cif_Empresa`) REFERENCES `empresa` (`Cif`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'sajid','A123456K','Y256783K');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenido`
--

DROP TABLE IF EXISTS `contenido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contenido` (
  `id_contenido` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `software` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_contenido`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenido`
--

LOCK TABLES `contenido` WRITE;
/*!40000 ALTER TABLE `contenido` DISABLE KEYS */;
INSERT INTO `contenido` VALUES (1,'Informativas',149.99,'I3 Television'),(2,'Series',99.99,'videomas'),(5,'VideoClips',99.99,'AdnStream');
/*!40000 ALTER TABLE `contenido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenido_empleado`
--

DROP TABLE IF EXISTS `contenido_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contenido_empleado` (
  `id_contenido` int NOT NULL,
  `id_empleado` int NOT NULL,
  PRIMARY KEY (`id_contenido`,`id_empleado`),
  KEY `FK_empleado3` (`id_empleado`),
  CONSTRAINT `FK_empleado3` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`),
  CONSTRAINT `FK_empleado4` FOREIGN KEY (`id_contenido`) REFERENCES `contenido` (`id_contenido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenido_empleado`
--

LOCK TABLES `contenido_empleado` WRITE;
/*!40000 ALTER TABLE `contenido_empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `contenido_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato` (
  `idcontrato` int NOT NULL AUTO_INCREMENT,
  `fecha_inicio` int DEFAULT NULL,
  `fecha_fin` int DEFAULT NULL,
  `idevento` int DEFAULT NULL,
  PRIMARY KEY (`idcontrato`),
  KEY `fk_evento_contrato` (`idevento`),
  CONSTRAINT `fk_evento_contrato` FOREIGN KEY (`idevento`) REFERENCES `evento` (`idevento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` VALUES (1,20230603,20230606,1),(2,20230610,20230613,2),(3,20030610,20030613,2),(4,20230613,20230621,3),(5,20230613,20230621,3);
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato_contenido`
--

DROP TABLE IF EXISTS `contrato_contenido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato_contenido` (
  `idcontenido` int NOT NULL,
  `idcontrato` int NOT NULL,
  PRIMARY KEY (`idcontenido`,`idcontrato`),
  KEY `idcontrato` (`idcontrato`),
  CONSTRAINT `contrato_contenido_ibfk_1` FOREIGN KEY (`idcontenido`) REFERENCES `contenido` (`id_contenido`),
  CONSTRAINT `contrato_contenido_ibfk_2` FOREIGN KEY (`idcontrato`) REFERENCES `contrato` (`idcontrato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato_contenido`
--

LOCK TABLES `contrato_contenido` WRITE;
/*!40000 ALTER TABLE `contrato_contenido` DISABLE KEYS */;
INSERT INTO `contrato_contenido` VALUES (5,1),(2,3),(5,3),(2,5),(5,5);
/*!40000 ALTER TABLE `contrato_contenido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato_equipamiento`
--

DROP TABLE IF EXISTS `contrato_equipamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato_equipamiento` (
  `idequipamiento` int DEFAULT NULL,
  `idcontrato` int DEFAULT NULL,
  `unidades` int DEFAULT NULL,
  KEY `idequipamiento` (`idequipamiento`),
  KEY `idcontrato` (`idcontrato`),
  CONSTRAINT `contrato_equipamiento_ibfk_1` FOREIGN KEY (`idequipamiento`) REFERENCES `equipamiento` (`id_equipamiento`),
  CONSTRAINT `contrato_equipamiento_ibfk_2` FOREIGN KEY (`idcontrato`) REFERENCES `contrato` (`idcontrato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato_equipamiento`
--

LOCK TABLES `contrato_equipamiento` WRITE;
/*!40000 ALTER TABLE `contrato_equipamiento` DISABLE KEYS */;
INSERT INTO `contrato_equipamiento` VALUES (2,1,2),(3,3,2),(7,5,3);
/*!40000 ALTER TABLE `contrato_equipamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato_factura`
--

DROP TABLE IF EXISTS `contrato_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato_factura` (
  `idFactura` int NOT NULL AUTO_INCREMENT,
  `fecha` int DEFAULT NULL,
  `iva` int DEFAULT NULL,
  `totalAPagar` double DEFAULT NULL,
  `nombreCliente` varchar(20) DEFAULT NULL,
  `cifCliente` varchar(20) DEFAULT NULL,
  `idcontrato` int NOT NULL,
  PRIMARY KEY (`idFactura`),
  UNIQUE KEY `idcontrato` (`idcontrato`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato_factura`
--

LOCK TABLES `contrato_factura` WRITE;
/*!40000 ALTER TABLE `contrato_factura` DISABLE KEYS */;
INSERT INTO `contrato_factura` VALUES (1,20230604,21,1088.89,'Eventus','Y256783K',1),(5,20230611,21,1451.85,'Eventus','Y256783K',3),(6,20230611,21,4839.52,'Eventus','Y256783K',5);
/*!40000 ALTER TABLE `contrato_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `id_dept` int NOT NULL,
  `nombreDepartamento` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_dept`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Contenido'),(2,'Equipamiento');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edificioprincipal`
--

DROP TABLE IF EXISTS `edificioprincipal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edificioprincipal` (
  `id_instalacion` int NOT NULL,
  `n1_aulas` int DEFAULT NULL,
  `n_ensayo` int DEFAULT NULL,
  `capa_restaurant` int DEFAULT NULL,
  PRIMARY KEY (`id_instalacion`),
  CONSTRAINT `edificioprincipal_ibfk_1` FOREIGN KEY (`id_instalacion`) REFERENCES `instalaciones` (`id_instalacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edificioprincipal`
--

LOCK TABLES `edificioprincipal` WRITE;
/*!40000 ALTER TABLE `edificioprincipal` DISABLE KEYS */;
/*!40000 ALTER TABLE `edificioprincipal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `id_empleado` int NOT NULL,
  `DNI` varchar(15) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellidos` varchar(20) DEFAULT NULL,
  `id_dept` int NOT NULL,
  `CifEmpresa` varchar(10) NOT NULL,
  `fechaAlta` int DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `id_Jefe` int NOT NULL,
  PRIMARY KEY (`id_empleado`),
  KEY `fk_CifEmpresa` (`CifEmpresa`),
  KEY `fk_empleado_departamento` (`id_dept`),
  KEY `fk_empleado_jefe` (`id_Jefe`),
  CONSTRAINT `fk_CifEmpresa` FOREIGN KEY (`CifEmpresa`) REFERENCES `empresa` (`Cif`),
  CONSTRAINT `fk_empleado_departamento` FOREIGN KEY (`id_dept`) REFERENCES `departamento` (`id_dept`),
  CONSTRAINT `fk_empleado_jefe` FOREIGN KEY (`id_Jefe`) REFERENCES `empleado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Y3470897Z','nom_empleado1','ape_empleado1',1,'Y256783K',20080412,632878799,1),(2,'Y3470867Z','nom_empleado2','ape_empleado2',1,'Y256783K',20080412,632878599,1),(3,'Y2345678K','German','Mendoza',2,'Y256783K',20120512,631987699,1),(4,'Y2345678K','David','Lopez',2,'Y256783K',20120512,631987699,1),(5,'Y5678908K','Sajid','Ahmad',1,'Y256783K',20080912,631987655,1);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `Cif` varchar(10) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `direccion` varchar(20) DEFAULT NULL,
  `municipio` varchar(20) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`Cif`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES ('Y256783K','Eventus','Calle maestro','Valencia','902839212');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipamiento`
--

DROP TABLE IF EXISTS `equipamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipamiento` (
  `id_equipamiento` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `ejemplares` int DEFAULT NULL,
  `precio` double(10,2) DEFAULT NULL,
  `imagen` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_equipamiento`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipamiento`
--

LOCK TABLES `equipamiento` WRITE;
/*!40000 ALTER TABLE `equipamiento` DISABLE KEYS */;
INSERT INTO `equipamiento` VALUES (1,'Digital Signage','Produccion de contenido',5,99.99,'Digital_Signage.png'),(2,'Camara canon','Video y Sonido',2,99.99,'Camara.png'),(3,'Microfono','Video y Sonido',8,99.99,'Microfono.png'),(5,'Elevacion de estructuras de iluminacion','Estructuras',10,149.99,'Estructura_Iluminacion.png'),(7,'Sony A7','Video y Sonido',7,99.99,'A7.png');
/*!40000 ALTER TABLE `equipamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipamiento_empleado`
--

DROP TABLE IF EXISTS `equipamiento_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipamiento_empleado` (
  `id_equipamiento` int NOT NULL,
  `id_empleado` int NOT NULL,
  PRIMARY KEY (`id_equipamiento`,`id_empleado`),
  KEY `FK_empleado1` (`id_empleado`),
  CONSTRAINT `FK_empleado1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`),
  CONSTRAINT `FK_empleado2` FOREIGN KEY (`id_equipamiento`) REFERENCES `equipamiento` (`id_equipamiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipamiento_empleado`
--

LOCK TABLES `equipamiento_empleado` WRITE;
/*!40000 ALTER TABLE `equipamiento_empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamiento_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento` (
  `idevento` int NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `fecha` int DEFAULT NULL,
  `id_cliente` int DEFAULT NULL,
  `precio` double(4,2) DEFAULT NULL,
  `id_recinto` int NOT NULL,
  `gestor` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idevento`),
  KEY `FK_recinto_evento` (`id_recinto`),
  KEY `FK_cliente_evento` (`id_cliente`),
  CONSTRAINT `FK_cliente_evento` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `FK_recinto_evento` FOREIGN KEY (`id_recinto`) REFERENCES `recinto` (`id_recinto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'Evento1','Concierto',20230319,1,99.99,1,'Gabriel'),(2,'Evento2','Espectaculo',20230620,1,99.99,1,'Sajid'),(3,'Evento3','Fiestas',20230612,1,99.99,1,'David');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento_empleado`
--

DROP TABLE IF EXISTS `evento_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento_empleado` (
  `id_evento` int NOT NULL,
  `id_empleado` int NOT NULL,
  PRIMARY KEY (`id_evento`,`id_empleado`),
  KEY `FK_empleado5` (`id_empleado`),
  CONSTRAINT `FK_empleado5` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`),
  CONSTRAINT `FK_empleado6` FOREIGN KEY (`id_evento`) REFERENCES `evento` (`idevento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento_empleado`
--

LOCK TABLES `evento_empleado` WRITE;
/*!40000 ALTER TABLE `evento_empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento_factura`
--

DROP TABLE IF EXISTS `evento_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento_factura` (
  `idFactura` int NOT NULL,
  `cifEmpresa` varchar(20) DEFAULT NULL,
  `fecha` int DEFAULT NULL,
  `idventa` int DEFAULT NULL,
  `iva` int DEFAULT NULL,
  `totalAPagar` double(4,2) DEFAULT NULL,
  `nombreCliente` varchar(20) DEFAULT NULL,
  `cifCliente` varchar(20) DEFAULT NULL,
  `idevento` int NOT NULL,
  PRIMARY KEY (`idFactura`),
  UNIQUE KEY `idevento` (`idevento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento_factura`
--

LOCK TABLES `evento_factura` WRITE;
/*!40000 ALTER TABLE `evento_factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instalaciones`
--

DROP TABLE IF EXISTS `instalaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instalaciones` (
  `id_instalacion` int NOT NULL,
  `z_oficinas` varchar(14) DEFAULT NULL,
  `m_carga` varchar(10) DEFAULT NULL,
  `a_solido` varchar(14) DEFAULT NULL,
  `a_iluminacion` int DEFAULT NULL,
  `p_aparca` varchar(10) DEFAULT NULL,
  `tamaño` int DEFAULT NULL,
  `almacen` int DEFAULT NULL,
  `id_recinto` int DEFAULT NULL,
  PRIMARY KEY (`id_instalacion`),
  KEY `FK_instalacion_recinto` (`id_recinto`),
  CONSTRAINT `FK_instalacion_recinto` FOREIGN KEY (`id_recinto`) REFERENCES `recinto` (`id_recinto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instalaciones`
--

LOCK TABLES `instalaciones` WRITE;
/*!40000 ALTER TABLE `instalaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `instalaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noticias`
--

DROP TABLE IF EXISTS `noticias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `noticias` (
  `id_noticia` int NOT NULL,
  `id_evento` int DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `noticia` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_noticia`),
  KEY `FK_id_noticia_evento` (`id_evento`),
  CONSTRAINT `FK_id_noticia_evento` FOREIGN KEY (`id_evento`) REFERENCES `evento` (`idevento`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticias`
--

LOCK TABLES `noticias` WRITE;
/*!40000 ALTER TABLE `noticias` DISABLE KEYS */;
/*!40000 ALTER TABLE `noticias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plato`
--

DROP TABLE IF EXISTS `plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plato` (
  `id_instalacion` int NOT NULL,
  `altura` int DEFAULT NULL,
  `n_salas` int DEFAULT NULL,
  `n_camareros` int DEFAULT NULL,
  `n_oficinas` int DEFAULT NULL,
  `n_peluqueria` int DEFAULT NULL,
  `s_maquillaje` int DEFAULT NULL,
  `z_descanso` int DEFAULT NULL,
  `imagene` varchar(10) DEFAULT NULL,
  `n_plato` int DEFAULT NULL,
  PRIMARY KEY (`id_instalacion`),
  CONSTRAINT `plato_ibfk_1` FOREIGN KEY (`id_instalacion`) REFERENCES `instalaciones` (`id_instalacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plato`
--

LOCK TABLES `plato` WRITE;
/*!40000 ALTER TABLE `plato` DISABLE KEYS */;
/*!40000 ALTER TABLE `plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyecto` (
  `id_proyecto` int NOT NULL,
  `fechaInicio` int DEFAULT NULL,
  `fechaFin` int DEFAULT NULL,
  `coste` float DEFAULT NULL,
  `localizacion` varchar(20) DEFAULT NULL,
  `Cif_Empresa` varchar(10) NOT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`id_proyecto`),
  KEY `fk_proyecto_Empresa` (`Cif_Empresa`),
  KEY `fk_cliente_proyecto` (`id_cliente`),
  CONSTRAINT `fk_cliente_proyecto` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `fk_proyecto_Empresa` FOREIGN KEY (`Cif_Empresa`) REFERENCES `empresa` (`Cif`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto_empleado`
--

DROP TABLE IF EXISTS `proyecto_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyecto_empleado` (
  `id_proyecto` int NOT NULL,
  `id_empleado` int NOT NULL,
  PRIMARY KEY (`id_proyecto`,`id_empleado`),
  KEY `fk_empleado` (`id_empleado`),
  CONSTRAINT `fk_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`),
  CONSTRAINT `fk_proyecto` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto_empleado`
--

LOCK TABLES `proyecto_empleado` WRITE;
/*!40000 ALTER TABLE `proyecto_empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyecto_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recinto`
--

DROP TABLE IF EXISTS `recinto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recinto` (
  `id_recinto` int NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `descripcion` varchar(14) DEFAULT NULL,
  `direccion` varchar(10) DEFAULT NULL,
  `municipio` varchar(14) DEFAULT NULL,
  `cod_postal` int DEFAULT NULL,
  `foto_recinto` varchar(10) DEFAULT NULL,
  `salas` int DEFAULT NULL,
  PRIMARY KEY (`id_recinto`),
  KEY `FK_sala_catalogo` (`salas`),
  CONSTRAINT `FK_sala_catalogo` FOREIGN KEY (`salas`) REFERENCES `catalogo` (`sala`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recinto`
--

LOCK TABLES `recinto` WRITE;
/*!40000 ALTER TABLE `recinto` DISABLE KEYS */;
INSERT INTO `recinto` VALUES (1,'recinto1','desp1','C/maestro','Valencia',48098,'R1.png',1);
/*!40000 ALTER TABLE `recinto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recinto_empleado`
--

DROP TABLE IF EXISTS `recinto_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recinto_empleado` (
  `id_recinto` int NOT NULL,
  `id_empleado` int NOT NULL,
  PRIMARY KEY (`id_recinto`,`id_empleado`),
  KEY `FK_empleado10` (`id_empleado`),
  CONSTRAINT `FK_empleado10` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`),
  CONSTRAINT `FK_recinto` FOREIGN KEY (`id_recinto`) REFERENCES `recinto` (`id_recinto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recinto_empleado`
--

LOCK TABLES `recinto_empleado` WRITE;
/*!40000 ALTER TABLE `recinto_empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `recinto_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tablon_anuncio`
--

DROP TABLE IF EXISTS `tablon_anuncio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tablon_anuncio` (
  `idanuncio` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `fabricante` varchar(20) DEFAULT NULL,
  `comentarioFabricante` varchar(20) DEFAULT NULL,
  `pdfcaracteristicas` varchar(50) DEFAULT NULL,
  `fechaAnuncio` int DEFAULT NULL,
  `fechalanzamiento` int DEFAULT NULL,
  `id_equipamiento` int DEFAULT NULL,
  PRIMARY KEY (`idanuncio`),
  KEY `id_equipamiento` (`id_equipamiento`),
  CONSTRAINT `tablon_anuncio_ibfk_1` FOREIGN KEY (`id_equipamiento`) REFERENCES `equipamiento` (`id_equipamiento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tablon_anuncio`
--

LOCK TABLES `tablon_anuncio` WRITE;
/*!40000 ALTER TABLE `tablon_anuncio` DISABLE KEYS */;
INSERT INTO `tablon_anuncio` VALUES (1,'Focos','Iluminacion','Sony','Comentario1','Caracteristicas.pdf',20230603,20230912,NULL),(2,'Sony A7','Video y Sonido','Sony','Comentario2','Caracteristicas.pdf',20230603,20230912,NULL),(4,'Karaoke','Video y Sonido','Sony','Comentario1','C.pdf',20230603,20210912,NULL),(5,'Camara','Video y Sonido','Sony','Comentario1 ','c.pdf',20230609,20220912,2);
/*!40000 ALTER TABLE `tablon_anuncio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-11 20:53:18
