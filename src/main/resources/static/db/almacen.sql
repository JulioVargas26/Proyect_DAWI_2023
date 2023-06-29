-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: almacen
-- ------------------------------------------------------
-- Server version	8.0.21

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

create database almacen;
use almacen;


--
-- Table structure for table `almacenero`
--

DROP TABLE IF EXISTS `almacenero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `almacenero` (
  `idalmacenero` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `clave` varchar(200) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `idrol` int DEFAULT NULL,
  PRIMARY KEY (`idalmacenero`),
  KEY `fk_almacenero_enlace1_idx` (`idrol`),
  CONSTRAINT `fk_almacenero_enlace1` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacenero`
--

LOCK TABLES `almacenero` WRITE;
/*!40000 ALTER TABLE `almacenero` DISABLE KEYS */;
INSERT INTO `almacenero` VALUES (1,'Lionel messi cuccitini','lmessi','$2a$10$my8vOqZlc8nXbya/6fWYXOxkJW0D715enZG0olPOqJmYbqjnjKj7y','907654354','lionel@gmail.com',1),(2,'Paolo guerrero gonzales','pguerrero','$2a$10$5l5CJsDgcvi8RfaFM5JJ4ufVkTzCXcFulOKt7Vo/xBH2Ba95/ZJCe','987654322','paolo@gmail.com',1),(4,'James nicho obregon','jnicho','$2a$10$3BTfsr5K/D/v/1Aq.2bi.eZsMrq./FEFWf009rY0LEwA4nG/c2Qn.','957353527','max@gmail.com',3),(5,'Claudia torres moreno','ctorres','$2a$10$3BTfsr5K/D/v/1Aq.2bi.eZsMrq./FEFWf009rY0LEwA4nG/c2Qn.','978353726','claudia@gmail.com',3),(6,'Cesar tito horna','ctito','$2a$10$3BTfsr5K/D/v/1Aq.2bi.eZsMrq./FEFWf009rY0LEwA4nG/c2Qn.','907241236','cesar@gmail.com',3),(7,'Pilar obregon ortiz','pobregon','$2a$10$3BTfsr5K/D/v/1Aq.2bi.eZsMrq./FEFWf009rY0LEwA4nG/c2Qn.','980704848','pilar@gmail.com',3),(8,'Hector martinez rubio','hmartinez','$2a$10$5l5CJsDgcvi8RfaFM5JJ4ufVkTzCXcFulOKt7Vo/xBH2Ba95/ZJCe','936272812','hector@gmail.com',2),(9,'Julio huacho castro','jhuacho','$2a$10$J3vwdM7jvDgv7UwgcncOL.OdL2EJ9DZHzB0RpFwbgQGUb0KZRBDmK','964732834','julio@gmail.com',2),(10,'jefferson farfan guadalupe','jfarfan','$2a$10$Uee/WvIhzGkgpe1/DvibGe6lbQZtRIg9P.cQm7K/lYeTjd9FcK28G','907654321','jefferson@gmail.com',2),(11,'Pierina gutierrez lengua','pgutierrez','$2a$10$bqliYGmhXXC7D96aLzEcfOH.1dSm.Pu1XlnC2k0HxaGvtdVSTwu6G','980652314','pierina@gmail.com',2),(12,'Milagros castillo tenorio','mcastillo','$2a$10$QUiTOorkYi/Z8Ml0lykGBeHQi4dXKpYLb/g8lEKIC7t/S.eHrlz3e','962734512','milagros@gmail.com',2),(13,'Jaime juan nicho ortiz','jnichoo','$2a$10$rqBTngoyiG./3ceDp6GYZOB3eWoYYtwVSU7XQtS6wNlkuRbeofXDS','980704848','jaime@gmail.com',2),(14,'Percy sotomarino ortiz','psotomarino','$2a$10$ZPQRvjm/l3ZBfmjUK37VeO8LgYMs7YP3oPa5zEzy4LQyHGqyF6gvW','976545310','percy@gmail.com',2),(15,'Fabian nicho obregon','fnicho','$2a$10$uKwHAU5GSRXJVageP8MvZ.7B3ik7BplwsGv.SXK70x1M4un90ckfO','909765643','fabian@gmail.com',2),(16,'Matias nicho obregon','mnicho','$2a$10$Db5s8qnpfbYcijCKWGCYAOSYHu969IMApQ5Pb9L9lD9VNqDXK1DiC','985023234','matias@gmail.com',2),(17,'Angelica ortiz montero','aortiz','$2a$10$4H0rVAbZtfrNZGC9KNGSAeSVznH5MksVduKC2MZcVZczxmTSDnW/W','967547602','angelica@gmail.com',2),(18,'Tayra zorrilla mendieta','tzorrilla','$2a$10$gztXUoDEFsewQGeXDhrtq.PqUYIdR1TwPCwgX1LzYwgIOBNM5y7zC','976879352','tayra@gmail.com',2);
/*!40000 ALTER TABLE `almacenero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `idcategoria` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Alimentos'),(2,'Autos'),(3,'Muebles'),(4,'Electrodomesticos'),(5,'Hogar'),(6,'Tecnologia'),(7,'Dormitorio'),(8,'Deportes'),(9,'Moda'),(10,'Calzado'),(11,'Accesorios'),(12,'Mascotas'),(13,'Juguetes'),(14,'Libreria oficina'),(15,'Bebidas');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enlace`
--

DROP TABLE IF EXISTS `enlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enlace` (
  `idenlace` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `ruta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idenlace`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enlace`
--

LOCK TABLES `enlace` WRITE;
/*!40000 ALTER TABLE `enlace` DISABLE KEYS */;
INSERT INTO `enlace` VALUES (1,'Producto','/producto/lista'),(2,'Proveedor','/proveedor/lista'),(3,'Entrada','/entrada/lista'),(4,'Almacenero','/almacenero/lista');
/*!40000 ALTER TABLE `enlace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entradas`
--

DROP TABLE IF EXISTS `entradas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entradas` (
  `identradas` int NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `precio_compra` double DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `idalmacenero` int NOT NULL,
  `idproveedor` int DEFAULT NULL,
  PRIMARY KEY (`identradas`),
  KEY `fk_entradas_almacenero1_idx` (`idalmacenero`),
  KEY `idproveedor` (`idproveedor`),
  CONSTRAINT `entradas_ibfk_1` FOREIGN KEY (`idproveedor`) REFERENCES `proveedor` (`idproveedor`),
  CONSTRAINT `fk_entradas_almacenero1` FOREIGN KEY (`idalmacenero`) REFERENCES `almacenero` (`idalmacenero`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entradas`
--

LOCK TABLES `entradas` WRITE;
/*!40000 ALTER TABLE `entradas` DISABLE KEYS */;
INSERT INTO `entradas` VALUES (1,0,0,'2023-06-18',1,1),(2,0,0,'2023-06-18',1,1),(3,1,1200,'2023-06-18',1,2),(4,5,12900,'2023-06-18',1,2),(5,5,1500,'2023-06-06',2,8);
/*!40000 ALTER TABLE `entradas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marca` (
  `idmarca` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `idproveedor` int DEFAULT NULL,
  PRIMARY KEY (`idmarca`),
  KEY `fk_marca_marca1_idx` (`idproveedor`),
  CONSTRAINT `fk_marca_marca1` FOREIGN KEY (`idproveedor`) REFERENCES `proveedor` (`idproveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'sol',1),(2,'constructor',1),(3,'laive',4),(4,'gloria',4),(5,'toyota',6),(6,'nissan',6),(7,'ford',6),(8,'bmw',7),(9,'oster',8),(10,'tomas',8),(11,'lenovo',11),(12,'asus',11),(13,'acer',11),(14,'micronics',12),(15,'imac',12),(16,'intel',12),(17,'amd',13),(18,'hp',13),(19,'windows',13),(20,'motorola',14),(21,'xiaomi',14),(22,'lg',14),(23,'iphone',14),(24,'samsung',14),(25,'walon',15),(26,'puma',15),(27,'adiddas',16),(28,'reebok',16),(29,'nike',17),(30,'cat',17),(31,'cristal',18),(32,'pilsen callao',18),(33,'corona',19),(34,'piscano',19),(35,'samsung',8),(36,'lg',8),(37,'aoc',9);
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idproducto` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `idcategoria` int NOT NULL,
  `idmarca` int NOT NULL,
  `stock_minimo` int DEFAULT NULL,
  `stock_actual` int DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`idproducto`),
  KEY `fk_producto_tipo_idx` (`idcategoria`),
  KEY `fk_producto_marca1_idx` (`idmarca`),
  CONSTRAINT `fk_producto_categoria` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`),
  CONSTRAINT `fk_producto_marca` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Vehiculo',2,5,20,25,'2023-06-06',3500),(2,'Computadora',6,11,20,25,'2023-06-18',1200),(3,'Televisor',6,35,10,15,'2023-06-18',1600),(4,'Laptop',6,13,50,90,'2023-05-12',2500),(5,'licuadora',4,9,50,100,'2023-04-13',500),(6,'olla arrocera',4,9,50,70,'2023-04-13',300),(7,'freidora de aire',4,10,20,40,'2023-04-13',200),(8,'pantalla',4,36,20,40,'2023-04-13',250),(9,'procesador',6,16,30,50,'2023-04-13',100),(10,'teclado',6,14,30,50,'2023-04-13',80),(11,'mouse',6,14,40,70,'2023-04-13',40),(12,'zapatilla',10,25,80,120,'2023-04-13',105),(13,'sneakers nike airmax',10,29,30,70,'2023-04-13',350),(14,'sneakers ',10,27,50,100,'2023-04-13',400),(15,'caja 1L',15,31,100,200,'2023-04-13',70),(16,'botella 1L',15,31,100,300,'2023-04-13',10);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_has_entrada`
--

DROP TABLE IF EXISTS `producto_has_entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_has_entrada` (
  `idproducto` int DEFAULT NULL,
  `identradas` int DEFAULT NULL,
  `precio` double DEFAULT NULL,
  KEY `idproducto` (`idproducto`),
  KEY `identradas` (`identradas`),
  CONSTRAINT `producto_has_entrada_ibfk_1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`),
  CONSTRAINT `producto_has_entrada_ibfk_2` FOREIGN KEY (`identradas`) REFERENCES `entradas` (`identradas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_has_entrada`
--

LOCK TABLES `producto_has_entrada` WRITE;
/*!40000 ALTER TABLE `producto_has_entrada` DISABLE KEYS */;
INSERT INTO `producto_has_entrada` VALUES (2,1,1200),(1,2,3500),(2,2,1200),(2,3,1200),(1,4,3500),(2,4,1200),(6,5,300);
/*!40000 ALTER TABLE `producto_has_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `idproveedor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `ruc` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idproveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Arenera San Martin','20428729201','Mz.E Lote 20 Santa Anita'),(2,'miperu','20428729202','Av. Izaguirre 223'),(3,'Nicolini','20129453627','av. girasol 323 callao'),(4,'lacteos peru','20343434356','Av.constructores 342 lima '),(5,'abarrotes sac','20103949495','Av. la cachina 120 la molina'),(6,'automundo','23239483939','Av. camino real 989 san isidro'),(7,'autos peru','23043439600','Av. javier prado 1098 la molina'),(8,'electroperu','20132424556','Av. tupac amaru 768 independencia'),(9,'peruhogar','20193923200','Av. Tomas valle 989 los olivos'),(10,'Dako','20191002930','Av. los libertadores 120 comas'),(11,'computodo','20190304900','Av. Arequipa 1029 lince'),(12,'compuplaza','20193030988','Av. arequipa 1121 lince'),(13,'telcel','20192374899','Av. cuba 139 lince'),(14,'fonotel','20193849006','Av. brasil 1176 jesus maria'),(15,'calzados maria','20192837466','Av. izaguirre 1234 los olivos'),(16,'starperu','20192746678','Av. monterrico 239 la molina'),(17,'todo tabas','20193466890','Av. la molina 2390 la molina'),(18,'Backus','20193764689','Av. alcazar 283 rimac'),(19,'extrabebida','20193879300','Av. mexico 129 la victoria');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idrol` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador'),(2,'Almacenero'),(3,'Jefe');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_enlace`
--

DROP TABLE IF EXISTS `rol_enlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_enlace` (
  `idrol` int NOT NULL,
  `idenlace` int NOT NULL,
  PRIMARY KEY (`idrol`,`idenlace`),
  KEY `fk_rol_has_enlace_enlace1_idx` (`idenlace`),
  KEY `fk_rol_has_enlace_rol1_idx` (`idrol`),
  CONSTRAINT `fk_rol_has_enlace_enlace1` FOREIGN KEY (`idenlace`) REFERENCES `enlace` (`idenlace`),
  CONSTRAINT `fk_rol_has_enlace_rol1` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_enlace`
--

LOCK TABLES `rol_enlace` WRITE;
/*!40000 ALTER TABLE `rol_enlace` DISABLE KEYS */;
INSERT INTO `rol_enlace` VALUES (1,1),(2,1),(3,1),(1,2),(3,2),(1,3),(2,3),(3,3),(1,4);
/*!40000 ALTER TABLE `rol_enlace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salidas`
--

DROP TABLE IF EXISTS `salidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salidas` (
  `idsalidas` int NOT NULL AUTO_INCREMENT,
  `fecha_registro` date DEFAULT NULL,
  `fecha_salida` date DEFAULT NULL,
  `idproducto` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  `responsable` varchar(45) DEFAULT NULL,
  `idalmacenero` int NOT NULL,
  PRIMARY KEY (`idsalidas`),
  KEY `fk_salidas_producto1_idx` (`idproducto`),
  KEY `fk_salidas_almacenero1_idx` (`idalmacenero`),
  CONSTRAINT `fk_salidas_almacenero1` FOREIGN KEY (`idalmacenero`) REFERENCES `almacenero` (`idalmacenero`),
  CONSTRAINT `fk_salidas_producto1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salidas`
--

LOCK TABLES `salidas` WRITE;
/*!40000 ALTER TABLE `salidas` DISABLE KEYS */;
/*!40000 ALTER TABLE `salidas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-26 17:24:09
