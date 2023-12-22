-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: pokemon_place
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `categoria_id` bigint NOT NULL AUTO_INCREMENT,
  `nombre_categoria` varchar(45) NOT NULL,
  PRIMARY KEY (`categoria_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Producto Oficial'),(2,'Accesorios'),(3,'Juguetes'),(4,'Postres'),(5,'Juegos de Mesa'),(6,'Otros');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `compras_id` bigint NOT NULL AUTO_INCREMENT,
  `usuario_id` bigint NOT NULL,
  `fecha_compra` timestamp NULL DEFAULT NULL,
  `estado_id` bigint NOT NULL,
  PRIMARY KEY (`compras_id`),
  KEY `usuario_id_idx` (`usuario_id`),
  KEY `estado_id_idx` (`estado_id`),
  CONSTRAINT `estado_id` FOREIGN KEY (`estado_id`) REFERENCES `estado_compra` (`estado_id`),
  CONSTRAINT `usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (2,8,'2023-12-02 06:00:00',3),(9,9,'2023-12-03 06:00:00',2),(14,10,'2023-12-14 06:00:00',4),(16,7,'2023-12-21 06:00:00',6),(21,9,NULL,1);
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras_has_productos`
--

DROP TABLE IF EXISTS `compras_has_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras_has_productos` (
  `compras_id` bigint NOT NULL AUTO_INCREMENT,
  `productos_id` bigint NOT NULL,
  `cantidad_compra` int NOT NULL,
  PRIMARY KEY (`compras_id`,`productos_id`),
  KEY `producto_id_idx` (`productos_id`),
  CONSTRAINT `compras_id` FOREIGN KEY (`compras_id`) REFERENCES `compras` (`compras_id`),
  CONSTRAINT `producto_id` FOREIGN KEY (`productos_id`) REFERENCES `productos` (`producto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras_has_productos`
--

LOCK TABLES `compras_has_productos` WRITE;
/*!40000 ALTER TABLE `compras_has_productos` DISABLE KEYS */;
INSERT INTO `compras_has_productos` VALUES (2,4,3),(2,9,1),(9,5,1),(14,50,6),(16,55,4);
/*!40000 ALTER TABLE `compras_has_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_compra`
--

DROP TABLE IF EXISTS `estado_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado_compra` (
  `estado_id` bigint NOT NULL AUTO_INCREMENT,
  `estado_compra` varchar(60) NOT NULL,
  PRIMARY KEY (`estado_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_compra`
--

LOCK TABLES `estado_compra` WRITE;
/*!40000 ALTER TABLE `estado_compra` DISABLE KEYS */;
INSERT INTO `estado_compra` VALUES (1,'En carrito'),(2,'Pagado pero en proceso de envío'),(3,'Enviado'),(4,'Entregado'),(5,'Cancelado'),(6,'Con problema');
/*!40000 ALTER TABLE `estado_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagenes_productos`
--

DROP TABLE IF EXISTS `imagenes_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagenes_productos` (
  `imagen_id` bigint NOT NULL AUTO_INCREMENT,
  `nombre_imagen` varchar(120) NOT NULL,
  `producto_id` bigint NOT NULL,
  PRIMARY KEY (`imagen_id`),
  KEY `id_imagen_idx` (`producto_id`),
  CONSTRAINT `id_imagen` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`producto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagenes_productos`
--

LOCK TABLES `imagenes_productos` WRITE;
/*!40000 ALTER TABLE `imagenes_productos` DISABLE KEYS */;
INSERT INTO `imagenes_productos` VALUES (1,'20231204_173606.png',9),(2,'20231204_173614.png',9),(3,'20231204_173621.png',9),(4,'20231204_173628.png',9),(5,'20231204_173637.png',9),(6,'20231204_173647.png',9),(7,'20231204_173733.png',9),(8,'20231204_173950.png',10),(9,'20231204_173955.png',10),(10,'20231204_174000.png',10),(11,'20231204_174005.png',10),(12,'20231204_174012.png',10),(13,'20231204_174022.png',10),(14,'20231204_174107.png',10),(15,'20231205_094116.png',11),(16,'20231205_094117.png',12),(17,'20231205_094118.png',13),(18,'20231205_160259.png',14),(19,'20231205_160317.png',14),(20,'20231205_160326.png',14),(21,'20231205_160400.png',15),(22,'20231205_160408.png',15),(23,'20231205_160450.png',15),(24,'20231205_160548.png',1),(25,'20231205_160556.png',2),(26,'20231205_160604.png',3),(27,'20231205_160611.png',4),(28,'20231205_160619.png',16),(29,'20231205_160625.png',17),(30,'20231205_160714.png',18),(31,'20231205_160753.png',19),(32,'20231205_160822.png',20),(33,'20231205_160906.png',21),(34,'20231205_160932.png',5),(35,'20231205_160937.png',5),(36,'20231205_160944.png',6),(37,'20231205_160948.png',6),(38,'20231205_161003.png',22),(39,'20231205_161008.png',22),(40,'20231205_161023.png',7),(41,'20231205_161031.png',8),(42,'20231205_161054.png',23),(43,'20231205_161110.png',24),(44,'20231205_161119.png',25),(45,'20231205_161126.png',25),(46,'20231205_161132.png',26),(47,'20231205_161139.png',26),(48,'20231205_161148.png',27),(49,'20231205_161209.png',28),(50,'20231205_161217.png',29),(51,'20231205_161224.png',29),(52,'20231205_161229.png',30),(53,'20231205_161233.png',30),(54,'20231205_161250.png',31),(55,'20231205_161258.png',32),(56,'20231205_161304.png',33),(57,'20231205_161315.png',34),(58,'20231205_161319.png',34),(59,'20231205_161324.png',35),(60,'20231205_161332.png',36),(61,'20231205_161335.png',36),(62,'20231205_161354.png',37),(63,'20231205_161432.png',38),(64,'20231205_161449.png',39),(65,'20231205_161502.png',40),(66,'20231205_161512.png',41),(67,'20231205_161516.png',41),(68,'20231205_161523.png',42),(69,'20231205_161530.png',43),(70,'20231205_161535.png',43),(71,'20231205_161541.png',44),(72,'20231205_161546.png',44),(73,'20231205_161555.png',45),(74,'20231205_161607.png',46),(75,'20231205_161630.png',47),(76,'20231205_161645.png',48),(77,'20231205_161659.png',49),(78,'20231205_161708.png',50),(79,'20231205_161713.png',50),(80,'20231205_161733.png',51),(81,'20231205_161740.png',52),(82,'20231205_161744.png',52),(83,'20231205_161752.png',53),(84,'20231205_161758.png',54),(85,'20231205_161812.png',55),(86,'20231205_161917.png',55),(87,'20231205_161936.png',56),(88,'20231205_161942.png',57),(89,'20231205_161949.png',57),(90,'20231205_161955.png',58),(91,'20231205_161958.png',58),(92,'20231205_162005.png',59),(93,'20231205_162014.png',60),(94,'20231205_162020.png',61),(95,'20231205_162023.png',61),(96,'20231205_162044.png',62),(97,'20231205_162052.png',63),(98,'20231205_162058.png',64),(99,'20231205_162108.png',65),(100,'20231205_162115.png',66),(101,'20231205_162125.png',67),(102,'20231205_162131.png',68),(103,'20231205_162205.png',69),(104,'20231205_162213.png',70),(105,'20231205_162221.png',71),(106,'20231205_162226.png',72),(107,'20231205_162231.png',73),(108,'20231205_162236.png',74),(109,'20231205_162242.png',75),(110,'20231205_162245.png',75),(111,'20231205_162251.png',76),(112,'20231205_162335.png',77),(113,'20231205_162343.png',77),(114,'20231205_162352.png',78),(115,'20231205_162430.png',78),(116,'20231205_162627.png',79),(117,'20231205_162636.png',80),(118,'20231205_162702.png',79),(119,'20231205_162708.png',81),(120,'20231205_162727.png',82);
/*!40000 ALTER TABLE `imagenes_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `producto_id` bigint NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(200) NOT NULL,
  `precio` decimal(9,2) NOT NULL,
  `categoria_id` bigint NOT NULL,
  `cantidad_disponible` int NOT NULL,
  PRIMARY KEY (`producto_id`),
  KEY `categoria_id_idx` (`categoria_id`),
  CONSTRAINT `categoria_id` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`categoria_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Sticker de Vinil Transparente de Wooloo',15.00,6,2),(2,'Sticker de Vinil Transparente de Charizard',15.00,6,5),(3,'Sticker de Vinil Holográfico de Gardevoir',15.00,6,5),(4,'Sticker de Vinil Transparente de Chandelure',15.00,6,1),(5,'Squishy Chillón de Charmander',40.00,3,0),(6,'Squishy Chillón de Snorlax',40.00,3,1),(7,'Sticker de Vinil Transparente de Detective Pikachu',15.00,6,0),(8,'Sticker de Vinil Transparente de Gengar',15.00,6,4),(9,'Pokémon Fluxx',350.00,5,0),(10,'Pokémon Coup',250.00,5,0),(11,'Pokélate',100.00,4,0),(12,'Pokélate Master Ball',150.00,4,0),(13,'Pokélate Love Ball',150.00,4,0),(14,'Peluche de Kyogre',300.00,3,0),(15,'Peluche de Psyduck',300.00,3,0),(16,'Sticker de Vinil Transparente de Rowlet',15.00,6,6),(17,'Sticker de Vinil Transparente de 9° Aniversario',15.00,6,3),(18,'Sobre de 3 League Cards Series 3 - Starters de Hoenn',20.00,6,10),(19,'Sobre de 3 League Cards Series 2 - Pikachu Clones',20.00,6,7),(20,'Sobre de 3 League Cards Series 1 - Starters de Galar',20.00,6,2),(21,'Sobre de 3 League Cards Series 4 - Top 30 Pokémon de Kanto de 2020',20.00,6,16),(22,'Squishy Chillón de Bulbasaur',40.00,3,1),(23,'Llavero de Psyduck',30.00,2,1),(24,'Collar de Eevee Gigantamax',45.00,2,0),(25,'Figura de Resina de Eevee (Impresión 3D)',80.00,3,1),(26,'Figura de Resina de Pokébola de Pikachu (Impresión 3D)',80.00,3,2),(27,'Llavero de Squirtle',30.00,2,2),(28,'Collar de Pikachu',40.00,2,0),(29,'Figura de Resina de Pokébola de Charmander (Impresión 3D)',80.00,3,2),(30,'Figura de Resina de Pokébola de Squirtle (Impresión 3D)',80.00,3,3),(31,'Llavero de Ditto',30.00,2,0),(32,'Charm de Bulbasaur',10.00,3,2),(33,'Charm de Psyduck',10.00,3,3),(34,'Figura de Resina de Squirtle (Impresión 3D)',80.00,3,2),(35,'Charm de Pikachu',10.00,3,0),(36,'Llavero de Pokébola',30.00,2,5),(37,'Llavero de Ho-Oh',30.00,2,0),(38,'Llavero de Pikachu',30.00,2,1),(39,'Llavero de Snorlax',30.00,2,1),(40,'Collar de Ditto',40.00,2,0),(41,'Figura de Resina de Pokébola de Eevee (Impresión 3D)',80.00,3,2),(42,'Llavero de Pikachu',30.00,2,0),(43,'Figura de Resina de Pokébola de Bulbasaur (Impresión 3D)',80.00,3,3),(44,'Figura que abraza tu cable cargador de celular de Vulpix',45.00,2,0),(45,'Llavero de Raikou',30.00,2,0),(46,'Llavero de Togepi',30.00,2,1),(47,'Llavero de Jigglypuff',30.00,2,1),(48,'Llavero de Jigglypuff',30.00,2,1),(49,'Llavero de Squirtle',30.00,2,2),(50,'Figura de Resina de Bulbasaur (Impresión 3D)',80.00,3,3),(51,'Llavero de Pikachu',30.00,2,0),(52,'Llavero de Pokébola Tejida a Mano',50.00,2,0),(53,'Llavero de Bulbasaur',30.00,2,0),(54,'Pluma de Pikachu',35.00,6,0),(55,'Collar de Pikachu',80.00,2,0),(56,'Llavero Cascabel de Great Ball',30.00,2,0),(57,'Figura de Resina de Charmander (Impresión 3D)',80.00,3,2),(58,'Figura que abraza tu cable cargador de celular de Meowth',45.00,2,1),(59,'Llavero de Entei',30.00,2,0),(60,'Gancho de Leafeon (Pégalo en la pared y dobla su colita para colgar cosas en ella)',100.00,6,0),(61,'Figura que abraza tu cable cargador de celular de Torchic',45.00,2,0),(62,'Llavero de Lapras Gigantamax',45.00,2,1),(63,'Llavero de Squirtle',30.00,2,1),(64,'Llavero de Slowpoke',30.00,2,0),(65,'Llavero de Bulbasaur',30.00,2,1),(66,'Llavero de Bulbasaur',30.00,2,0),(67,'Llavero de Eevee',30.00,2,0),(68,'Llavero de Charmander',30.00,2,1),(69,'Llavero de Charmander',30.00,2,2),(70,'Llavero de Charmander',30.00,2,0),(71,'Llavero de Meowth',30.00,2,0),(72,'Llavero de Bulbasaur',30.00,2,1),(73,'Llavero de Psyduck',30.00,2,1),(74,'Llavero de Squirtle',30.00,2,1),(75,'Figura que abraza tu cable cargador de celular de Piplup',45.00,2,1),(76,'Llavero de Charmander',30.00,2,0),(77,'Bolsa Pequeña de Eevee',80.00,6,1),(78,'Pulsera de Charmander',80.00,2,1),(79,'Paquete de Energías de Pokémon TCG / JCC',50.00,1,2),(80,'Micas para cartas de TCG / JCC de la Expansión 151',200.00,1,1),(81,'Dados de TCG / JCC de la Expansión 151',100.00,1,1),(82,'Marcadores de TCG / JCC de Veneno y Quemadura',100.00,1,1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `rol_id` bigint NOT NULL AUTO_INCREMENT,
  `rol_nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Administrador'),(2,'Cliente');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `usuario_id` bigint NOT NULL AUTO_INCREMENT,
  `usuario_nombre` varchar(120) NOT NULL,
  `email` varchar(60) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `contrasena` varchar(20) NOT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `rol_id` bigint NOT NULL,
  PRIMARY KEY (`usuario_id`),
  KEY `fk_usuarios_roles_idx` (`rol_id`),
  CONSTRAINT `id_usuarios_roles` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`rol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Antonio González Navarrete','navarrete.antonio.2301@gmail.com','+52 3329467527','pikachu69',NULL,1),(2,'Mirta Adriana Tapia Don','mirta.atd@gmail.com','+52 1 33 1531 6295','charizard666',NULL,1),(3,'Misael Edgar Zepeda Díaz','misaeltup@gmail.com','+52 1 55 7209 7393','mewtwo123',NULL,1),(4,'Jocelyn Karina Peña Reyes','jocelyn.p.reyes332b@gmail.com','+52 5546935091','snorlax99',NULL,1),(5,'Yazmin Valeria Morales Martínez','myaz5848@gmail.com','5620893079','bulbasuar567',NULL,1),(6,'Jorge Alberto Ramirez Casillas','jorgermzc16@gmail.com','3311389817','ivysur987',NULL,1),(7,'Ana María Pérez','anamaria@gmail.com','+52 3334567890','clave123','Roles de Canela 24',2),(8,'Carlos González Rodriguez','carlos.gonzalez@gmail.com','+52 1 3356789012','password456','Hola Sol 2',2),(9,'Laura Martínez Silva','laura.martinez@outlook.com','3389012345','securepass789','Quiero unos chicles 989',2),(10,'Jose Avila Camacho','avila.jose@yahoo.com','+52 3389012345','securepass789','Avila Camacho 22',2);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-22 15:13:32
