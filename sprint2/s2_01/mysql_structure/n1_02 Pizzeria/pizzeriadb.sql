CREATE DATABASE  IF NOT EXISTS `pizzeriadb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pizzeriadb`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: pizzeriadb
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Beverages'),(2,'Categoria 5'),(3,'Categoria 6'),(4,'Categoria 7'),(5,'Categoria 8'),(6,'Categoria 9'),(7,'Categoria 10'),(8,'Categoria 11'),(9,'Categoria 12'),(10,'Categoria 13'),(11,'Categoria 14'),(12,'Categoria 15'),(13,'Categoria 16'),(14,'Categoria 17'),(15,'Categoria 18'),(16,'Categoria 19'),(17,'Categoria 20'),(18,'Categoria 21'),(19,'Categoria 22'),(20,'Categoria 23');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `postal_code` varchar(20) DEFAULT NULL,
  `locality_id` int DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `locality_id` (`locality_id`),
  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`locality_id`) REFERENCES `localities` (`locality_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (21,'Cliente 4','Sobrenome 4','Endereço Cliente 4','45678',4,'654321098'),(22,'Cliente 5','Sobrenome 5','Endereço Cliente 5','56789',5,'543210987'),(23,'Cliente 6','Sobrenome 6','Endereço Cliente 6','67890',6,'432109876'),(24,'Cliente 7','Sobrenome 7','Endereço Cliente 7','78901',7,'321098765'),(25,'Cliente 8','Sobrenome 8','Endereço Cliente 8','89012',8,'210987654'),(26,'Cliente 9','Sobrenome 9','Endereço Cliente 9','90123',9,'109876543'),(27,'Cliente 10','Sobrenome 10','Endereço Cliente 10','01234',10,'098765432'),(28,'Cliente 11','Sobrenome 11','Endereço Cliente 11','12345',11,'987654321'),(29,'Cliente 12','Sobrenome 12','Endereço Cliente 12','23456',12,'876543210'),(30,'Cliente 13','Sobrenome 13','Endereço Cliente 13','34567',13,'765432109'),(31,'Cliente 14','Sobrenome 14','Endereço Cliente 14','45678',14,'654321098'),(32,'Cliente 15','Sobrenome 15','Endereço Cliente 15','56789',15,'543210987'),(33,'Cliente 16','Sobrenome 16','Endereço Cliente 16','67890',16,'432109876'),(34,'Cliente 17','Sobrenome 17','Endereço Cliente 17','78901',17,'321098765'),(35,'Cliente 18','Sobrenome 18','Endereço Cliente 18','89012',18,'210987654'),(36,'Cliente 19','Sobrenome 19','Endereço Cliente 19','90123',19,'109876543'),(37,'Cliente 20','Sobrenome 20','Endereço Cliente 20','01234',20,'098765432'),(38,'Cliente 21','Sobrenome 21','Endereço Cliente 21','12345',1,'987654321'),(39,'Cliente 22','Sobrenome 22','Endereço Cliente 22','23456',2,'876543210'),(40,'Cliente 23','Sobrenome 23','Endereço Cliente 23','34567',3,'765432109');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliveries`
--

DROP TABLE IF EXISTS `deliveries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deliveries` (
  `delivery_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `delivery_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`delivery_id`),
  KEY `order_id` (`order_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `deliveries_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `deliveries_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliveries`
--

LOCK TABLES `deliveries` WRITE;
/*!40000 ALTER TABLE `deliveries` DISABLE KEYS */;
INSERT INTO `deliveries` VALUES (41,24,24,'2023-01-06 10:00:00'),(42,25,25,'2023-02-06 11:00:00'),(43,26,26,'2023-03-06 12:00:00'),(44,27,27,'2023-04-06 13:00:00'),(45,28,28,'2023-05-06 14:00:00'),(46,29,29,'2023-06-06 15:00:00'),(47,30,30,'2023-07-06 16:00:00'),(48,31,31,'2023-08-06 17:00:00'),(49,32,32,'2023-09-06 18:00:00'),(50,33,33,'2023-10-06 19:00:00'),(51,34,34,'2023-11-06 20:00:00'),(52,35,20,'2023-12-06 21:00:00'),(53,36,19,'2023-01-07 22:00:00'),(54,37,23,'2023-02-07 23:00:00'),(55,38,18,'2023-03-07 00:00:00'),(56,39,19,'2023-04-07 01:00:00'),(57,40,20,'2023-05-07 02:00:00'),(58,21,21,'2023-06-07 03:00:00'),(59,22,22,'2023-07-07 04:00:00'),(60,23,23,'2023-08-07 05:00:00');
/*!40000 ALTER TABLE `deliveries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `NIF` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `store_id` (`store_id`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `stores` (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (18,'Funcionário 4','Sobrenome 4','456789012','654321098','Cargo 4',45),(19,'Funcionário 5','Sobrenome 5','567890123','543210987','Cargo 5',46),(20,'Funcionário 6','Sobrenome 6','678901234','432109876','Cargo 6',47),(21,'Funcionário 7','Sobrenome 7','789012345','321098765','Cargo 7',48),(22,'Funcionário 8','Sobrenome 8','890123456','210987654','Cargo 8',49),(23,'Funcionário 9','Sobrenome 9','901234567','109876543','Cargo 9',50),(24,'Funcionário 10','Sobrenome 10','012345678','098765432','Cargo 10',51),(25,'Funcionário 11','Sobrenome 11','123456789','987654321','Cargo 11',52),(26,'Funcionário 12','Sobrenome 12','234567890','876543210','Cargo 12',53),(27,'Funcionário 13','Sobrenome 13','345678901','765432109','Cargo 13',54),(28,'Funcionário 14','Sobrenome 14','456789012','654321098','Cargo 14',55),(29,'Funcionário 15','Sobrenome 15','567890123','543210987','Cargo 15',56),(30,'Funcionário 16','Sobrenome 16','678901234','432109876','Cargo 16',57),(31,'Funcionário 17','Sobrenome 17','789012345','321098765','Cargo 17',58),(32,'Funcionário 18','Sobrenome 18','890123456','210987654','Cargo 18',59),(33,'Funcionário 19','Sobrenome 19','901234567','109876543','Cargo 19',60),(34,'Funcionário 20','Sobrenome 20','012345678','098765432','Cargo 20',61);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localities`
--

DROP TABLE IF EXISTS `localities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localities` (
  `locality_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `province_id` int DEFAULT NULL,
  PRIMARY KEY (`locality_id`),
  KEY `province_id` (`province_id`),
  CONSTRAINT `localities_ibfk_1` FOREIGN KEY (`province_id`) REFERENCES `provinces` (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localities`
--

LOCK TABLES `localities` WRITE;
/*!40000 ALTER TABLE `localities` DISABLE KEYS */;
INSERT INTO `localities` VALUES (1,'Localidade 6',3),(2,'Localidade 7',3),(3,'Localidade 8',4),(4,'Localidade 9',4),(5,'Localidade 10',5),(6,'Localidade 11',5),(7,'Localidade 12',6),(8,'Localidade 13',6),(9,'Localidade 14',7),(10,'Localidade 15',7),(11,'Localidade 16',8),(12,'Localidade 17',8),(13,'Localidade 18',9),(14,'Localidade 19',9),(15,'Localidade 20',10),(16,'Localidade 21',10),(17,'Localidade 22',11),(18,'Localidade 23',11),(19,'Localidade 24',12),(20,'Localidade 25',12);
/*!40000 ALTER TABLE `localities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetails` (
  `order_detail_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `orderdetails_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `orderdetails_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
INSERT INTO `orderdetails` VALUES (21,24,24,2),(22,25,25,3),(23,26,26,4),(24,27,27,5),(25,28,28,6),(26,29,29,7),(27,30,30,8),(28,31,31,9),(29,32,32,10),(30,33,33,11),(31,34,34,12),(32,35,35,13),(33,36,36,14),(34,37,37,15),(35,38,38,16),(36,39,39,17),(37,40,40,18),(38,21,21,19),(39,22,22,20),(40,23,23,21);
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `order_datetime` datetime DEFAULT NULL,
  `delivery_type` enum('home_delivery','store_pickup') DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `customer_id` (`customer_id`),
  KEY `employee_id` (`employee_id`),
  KEY `fk_store_id` (`store_id`),
  CONSTRAINT `fk_store_id` FOREIGN KEY (`store_id`) REFERENCES `stores` (`store_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (21,21,'2023-01-05 08:00:00','home_delivery',99.99,45,18),(22,22,'2023-02-05 09:00:00','store_pickup',89.99,46,19),(23,23,'2023-03-05 10:00:00','home_delivery',109.99,47,20),(24,24,'2023-04-05 11:00:00','store_pickup',79.99,48,21),(25,25,'2023-05-05 12:00:00','home_delivery',69.99,49,22),(26,26,'2023-06-05 13:00:00','store_pickup',59.99,50,23),(27,27,'2023-07-05 14:00:00','home_delivery',49.99,51,24),(28,28,'2023-08-05 15:00:00','store_pickup',39.99,52,25),(29,29,'2023-09-05 16:00:00','home_delivery',29.99,53,26),(30,30,'2023-10-05 17:00:00','store_pickup',19.99,54,27),(31,31,'2023-11-05 18:00:00','home_delivery',9.99,55,28),(32,32,'2023-12-05 19:00:00','store_pickup',109.99,56,29),(33,33,'2023-01-06 20:00:00','home_delivery',119.99,57,30),(34,34,'2023-02-06 21:00:00','store_pickup',129.99,58,31),(35,35,'2023-03-06 22:00:00','home_delivery',139.99,59,32),(36,36,'2023-04-06 23:00:00','store_pickup',149.99,60,33),(37,37,'2023-05-06 00:00:00','home_delivery',159.99,61,34),(38,38,'2023-06-06 01:00:00','store_pickup',169.99,62,34),(39,39,'2023-07-06 02:00:00','home_delivery',179.99,63,33),(40,40,'2023-08-06 03:00:00','store_pickup',189.99,64,32);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` text,
  `image` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (21,'Produto 4','Descrição do Produto 4','imagem_produto4.jpg',10.99,1),(22,'Produto 5','Descrição do Produto 5','imagem_produto5.jpg',15.99,2),(23,'Produto 6','Descrição do Produto 6','imagem_produto6.jpg',20.99,3),(24,'Produto 7','Descrição do Produto 7','imagem_produto7.jpg',25.99,4),(25,'Produto 8','Descrição do Produto 8','imagem_produto8.jpg',30.99,5),(26,'Produto 9','Descrição do Produto 9','imagem_produto9.jpg',35.99,6),(27,'Produto 10','Descrição do Produto 10','imagem_produto10.jpg',40.99,7),(28,'Produto 11','Descrição do Produto 11','imagem_produto11.jpg',45.99,8),(29,'Produto 12','Descrição do Produto 12','imagem_produto12.jpg',50.99,9),(30,'Produto 13','Descrição do Produto 13','imagem_produto13.jpg',55.99,10),(31,'Produto 14','Descrição do Produto 14','imagem_produto14.jpg',60.99,11),(32,'Produto 15','Descrição do Produto 15','imagem_produto15.jpg',65.99,12),(33,'Produto 16','Descrição do Produto 16','imagem_produto16.jpg',70.99,13),(34,'Produto 17','Descrição do Produto 17','imagem_produto17.jpg',75.99,14),(35,'Produto 18','Descrição do Produto 18','imagem_produto18.jpg',80.99,15),(36,'Produto 19','Descrição do Produto 19','imagem_produto19.jpg',85.99,16),(37,'Produto 20','Descrição do Produto 20','imagem_produto20.jpg',90.99,17),(38,'Produto 21','Descrição do Produto 21','imagem_produto21.jpg',95.99,18),(39,'Produto 22','Descrição do Produto 22','imagem_produto22.jpg',100.99,19),(40,'Produto 23','Descrição do Produto 23','imagem_produto23.jpg',105.99,20);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provinces`
--

DROP TABLE IF EXISTS `provinces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provinces` (
  `province_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`province_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provinces`
--

LOCK TABLES `provinces` WRITE;
/*!40000 ALTER TABLE `provinces` DISABLE KEYS */;
INSERT INTO `provinces` VALUES (1,'Província D'),(2,'Província E'),(3,'Província F'),(4,'Província G'),(5,'Província H'),(6,'Província I'),(7,'Província J'),(8,'Província K'),(9,'Província L'),(10,'Província M'),(11,'Província N'),(12,'Província O'),(13,'Província P'),(14,'Província Q'),(15,'Província R'),(16,'Província S'),(17,'Província T'),(18,'Província U'),(19,'Província V'),(20,'Província W');
/*!40000 ALTER TABLE `provinces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stores`
--

DROP TABLE IF EXISTS `stores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stores` (
  `store_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `postal_code` varchar(20) DEFAULT NULL,
  `locality_id` int DEFAULT NULL,
  PRIMARY KEY (`store_id`),
  KEY `locality_id` (`locality_id`),
  CONSTRAINT `stores_ibfk_1` FOREIGN KEY (`locality_id`) REFERENCES `localities` (`locality_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stores`
--

LOCK TABLES `stores` WRITE;
/*!40000 ALTER TABLE `stores` DISABLE KEYS */;
INSERT INTO `stores` VALUES (45,'Endereço 4','45678',1),(46,'Endereço 5','56789',2),(47,'Endereço 6','67890',3),(48,'Endereço 7','78901',4),(49,'Endereço 8','89012',5),(50,'Endereço 9','90123',6),(51,'Endereço 10','01234',7),(52,'Endereço 11','12345',8),(53,'Endereço 12','23456',9),(54,'Endereço 13','34567',10),(55,'Endereço 14','45678',11),(56,'Endereço 15','56789',12),(57,'Endereço 16','67890',13),(58,'Endereço 17','78901',14),(59,'Endereço 18','89012',15),(60,'Endereço 19','90123',16),(61,'Endereço 20','01234',17),(62,'Endereço 21','12345',18),(63,'Endereço 22','23456',19),(64,'Endereço 23','34567',20),(65,'Endereço 24','45678',1),(66,'Endereço 25','56789',2);
/*!40000 ALTER TABLE `stores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-08 14:49:22
