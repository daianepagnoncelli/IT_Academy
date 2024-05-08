-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: spotifydb
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
-- Table structure for table `albums`
--

DROP TABLE IF EXISTS `albums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `albums` (
  `album_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `year_of_publication` int DEFAULT NULL,
  `cover_image` varchar(255) DEFAULT NULL,
  `artist_id` int DEFAULT NULL,
  PRIMARY KEY (`album_id`),
  KEY `artist_id` (`artist_id`),
  CONSTRAINT `albums_ibfk_1` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`artist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albums`
--

LOCK TABLES `albums` WRITE;
/*!40000 ALTER TABLE `albums` DISABLE KEYS */;
INSERT INTO `albums` VALUES (11,'Album 1',2020,'album1_cover.jpg',1),(12,'Album 2',2018,'album2_cover.jpg',2),(13,'Album 3',2019,'album3_cover.jpg',3),(14,'Album 4',2021,'album4_cover.jpg',4),(15,'Album 5',2017,'album5_cover.jpg',5),(16,'Album 6',2022,'album6_cover.jpg',6),(17,'Album 7',2016,'album7_cover.jpg',7),(18,'Album 8',2023,'album8_cover.jpg',8),(19,'Album 9',2015,'album9_cover.jpg',9),(20,'Album 10',2024,'album10_cover.jpg',10);
/*!40000 ALTER TABLE `albums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artists`
--

DROP TABLE IF EXISTS `artists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artists` (
  `artist_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`artist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artists`
--

LOCK TABLES `artists` WRITE;
/*!40000 ALTER TABLE `artists` DISABLE KEYS */;
INSERT INTO `artists` VALUES (1,'Artist 1','artist1_image.jpg'),(2,'Artist 2','artist2_image.jpg'),(3,'Artist 3','artist3_image.jpg'),(4,'Artist 4','artist4_image.jpg'),(5,'Artist 5','artist5_image.jpg'),(6,'Artist 6','artist6_image.jpg'),(7,'Artist 7','artist7_image.jpg'),(8,'Artist 8','artist8_image.jpg'),(9,'Artist 9','artist9_image.jpg'),(10,'Artist 10','artist10_image.jpg');
/*!40000 ALTER TABLE `artists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentmethods`
--

DROP TABLE IF EXISTS `paymentmethods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paymentmethods` (
  `payment_method_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `method_type` enum('credit_card','PayPal') DEFAULT NULL,
  `card_number` varchar(20) DEFAULT NULL,
  `expiry_month` int DEFAULT NULL,
  `expiry_year` int DEFAULT NULL,
  `security_code` varchar(5) DEFAULT NULL,
  `PayPal_username` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`payment_method_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `paymentmethods_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentmethods`
--

LOCK TABLES `paymentmethods` WRITE;
/*!40000 ALTER TABLE `paymentmethods` DISABLE KEYS */;
INSERT INTO `paymentmethods` VALUES (1,1,'credit_card','1234567890123456',12,2025,'123',NULL),(2,2,'PayPal',NULL,NULL,NULL,NULL,'user2_paypal'),(3,3,'credit_card','9876543210987654',10,2024,'456',NULL),(4,4,'credit_card','4567890123456789',8,2023,'789',NULL),(5,5,'PayPal',NULL,NULL,NULL,NULL,'user5_paypal'),(6,6,'credit_card','9876543210123456',5,2024,'321',NULL),(7,7,'PayPal',NULL,NULL,NULL,NULL,'user7_paypal'),(8,8,'credit_card','1230987654321098',11,2025,'654',NULL),(9,9,'PayPal',NULL,NULL,NULL,NULL,'user9_paypal'),(10,10,'credit_card','8765432109876543',6,2023,'987',NULL);
/*!40000 ALTER TABLE `paymentmethods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `subscription_id` int DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `order_number` varchar(50) DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `subscription_id` (`subscription_id`),
  CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`subscription_id`) REFERENCES `subscriptions` (`subscription_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (1,1,'2023-01-01','ORD123456',99.99),(2,2,'2023-02-15','ORD987654',49.99),(3,3,'2023-03-20','ORD246810',79.99),(4,4,'2023-04-10','ORD135792',69.99),(5,5,'2023-05-25','ORD246813',129.99),(6,6,'2023-06-18','ORD579135',89.99),(7,7,'2023-07-05','ORD789456',39.99),(8,8,'2023-08-30','ORD357246',59.99),(9,9,'2023-09-15','ORD789123',109.99),(10,10,'2023-10-20','ORD987654',49.99);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlists`
--

DROP TABLE IF EXISTS `playlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlists` (
  `playlist_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `number_of_songs` int DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `deletion_date` date DEFAULT NULL,
  PRIMARY KEY (`playlist_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `playlists_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlists`
--

LOCK TABLES `playlists` WRITE;
/*!40000 ALTER TABLE `playlists` DISABLE KEYS */;
INSERT INTO `playlists` VALUES (1,1,'My Playlist',10,'2023-01-01',0,NULL),(2,2,'Workout Mix',15,'2023-02-15',0,NULL),(3,3,'Chill Vibes',20,'2023-03-20',0,NULL),(4,4,'Driving Tunes',12,'2023-04-10',0,NULL),(5,5,'Party Hits',18,'2023-05-25',0,NULL),(6,6,'Relaxation Sounds',10,'2023-06-18',0,NULL),(7,7,'Study Playlist',15,'2023-07-05',0,NULL),(8,8,'Road Trip Jams',20,'2023-08-30',0,NULL),(9,9,'Romantic Ballads',12,'2023-09-15',0,NULL),(10,10,'Throwback Classics',18,'2023-10-20',0,NULL);
/*!40000 ALTER TABLE `playlists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `songs`
--

DROP TABLE IF EXISTS `songs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `songs` (
  `song_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `duration` time DEFAULT NULL,
  `play_count` int DEFAULT '0',
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `songs`
--

LOCK TABLES `songs` WRITE;
/*!40000 ALTER TABLE `songs` DISABLE KEYS */;
INSERT INTO `songs` VALUES (1,'Song 1','03:45:00',100000),(2,'Song 2','04:20:00',95000),(3,'Song 3','03:30:00',90000),(4,'Song 4','04:00:00',85000),(5,'Song 5','03:15:00',80000),(6,'Song 6','04:10:00',75000),(7,'Song 7','03:50:00',70000),(8,'Song 8','04:30:00',65000),(9,'Song 9','03:40:00',60000),(10,'Song 10','04:15:00',55000);
/*!40000 ALTER TABLE `songs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscriptions` (
  `subscription_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `subscription_start_date` date DEFAULT NULL,
  `service_renewal_date` date DEFAULT NULL,
  `payment_method` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`subscription_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `subscriptions_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptions`
--

LOCK TABLES `subscriptions` WRITE;
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` VALUES (1,1,'2023-01-01','2024-01-01','credit_card'),(2,2,'2023-02-15','2023-08-15','PayPal'),(3,3,'2023-03-20','2023-09-20','credit_card'),(4,4,'2023-04-10','2024-04-10','credit_card'),(5,5,'2023-05-25','2024-05-25','PayPal'),(6,6,'2023-06-18','2023-12-18','credit_card'),(7,7,'2023-07-05','2023-12-05','PayPal'),(8,8,'2023-08-30','2024-02-29','credit_card'),(9,9,'2023-09-15','2024-03-15','PayPal'),(10,10,'2023-10-20','2024-04-20','credit_card');
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userartistrelationships`
--

DROP TABLE IF EXISTS `userartistrelationships`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userartistrelationships` (
  `relationship_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `artist_id` int DEFAULT NULL,
  PRIMARY KEY (`relationship_id`),
  KEY `user_id` (`user_id`),
  KEY `artist_id` (`artist_id`),
  CONSTRAINT `userartistrelationships_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `userartistrelationships_ibfk_2` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`artist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userartistrelationships`
--

LOCK TABLES `userartistrelationships` WRITE;
/*!40000 ALTER TABLE `userartistrelationships` DISABLE KEYS */;
INSERT INTO `userartistrelationships` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,7,7),(8,8,8),(9,9,9),(10,10,10);
/*!40000 ALTER TABLE `userartistrelationships` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userfavorites`
--

DROP TABLE IF EXISTS `userfavorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userfavorites` (
  `favorite_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `album_id` int DEFAULT NULL,
  `song_id` int DEFAULT NULL,
  PRIMARY KEY (`favorite_id`),
  KEY `user_id` (`user_id`),
  KEY `album_id` (`album_id`),
  KEY `song_id` (`song_id`),
  CONSTRAINT `userfavorites_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `userfavorites_ibfk_2` FOREIGN KEY (`album_id`) REFERENCES `albums` (`album_id`),
  CONSTRAINT `userfavorites_ibfk_3` FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userfavorites`
--

LOCK TABLES `userfavorites` WRITE;
/*!40000 ALTER TABLE `userfavorites` DISABLE KEYS */;
INSERT INTO `userfavorites` VALUES (11,1,11,1),(12,2,12,2),(13,3,13,3),(14,4,14,4),(15,5,15,5),(16,6,16,6),(17,7,17,7),(18,8,18,8),(19,9,19,9),(20,10,20,10);
/*!40000 ALTER TABLE `userfavorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `postal_code` varchar(20) DEFAULT NULL,
  `user_type` enum('free','premium') DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'user1@example.com','password1','user1','1990-01-01','M','USA','12345','premium'),(2,'user2@example.com','password2','user2','1995-05-15','F','UK','54321','free'),(3,'user3@example.com','password3','user3','1988-11-20','M','Canada','67890','free'),(4,'user4@example.com','password4','user4','1992-03-10','F','Germany','98765','free'),(5,'user5@example.com','password5','user5','1985-07-25','M','France','13579','premium'),(6,'user6@example.com','password6','user6','1987-09-18','F','Australia','24680','premium'),(7,'user7@example.com','password7','user7','1998-12-05','M','Japan','98741','free'),(8,'user8@example.com','password8','user8','1993-06-30','F','Brazil','75319','free'),(9,'user9@example.com','password9','user9','1980-04-15','M','Mexico','36985','premium'),(10,'user10@example.com','password10','user10','1977-08-20','F','Italy','15937','free');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-08 15:24:00
