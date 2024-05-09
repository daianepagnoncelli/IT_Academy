CREATE DATABASE  IF NOT EXISTS `youtubedb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `youtubedb`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: youtubedb
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
-- Table structure for table `channels`
--

DROP TABLE IF EXISTS `channels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `channels` (
  `channel_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `creation_date` date DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`channel_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `channels_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `channels`
--

LOCK TABLES `channels` WRITE;
/*!40000 ALTER TABLE `channels` DISABLE KEYS */;
INSERT INTO `channels` VALUES (1,'Channel 1','Description of Channel 1','2024-01-01',1),(2,'Channel 2','Description of Channel 2','2024-02-15',2),(3,'Channel 3','Description of Channel 3','2024-03-20',3),(4,'Channel 4','Description of Channel 4','2024-04-10',4),(5,'Channel 5','Description of Channel 5','2024-05-25',5);
/*!40000 ALTER TABLE `channels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commentreactions`
--

DROP TABLE IF EXISTS `commentreactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commentreactions` (
  `reaction_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `comment_id` int DEFAULT NULL,
  `reaction` enum('like','dislike') DEFAULT NULL,
  `reaction_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`reaction_id`),
  KEY `user_id` (`user_id`),
  KEY `comment_id` (`comment_id`),
  CONSTRAINT `commentreactions_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `commentreactions_ibfk_2` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentreactions`
--

LOCK TABLES `commentreactions` WRITE;
/*!40000 ALTER TABLE `commentreactions` DISABLE KEYS */;
INSERT INTO `commentreactions` VALUES (1,1,1,'like','2024-01-01 10:20:00'),(2,2,2,'dislike','2024-02-15 12:50:00'),(3,3,3,'like','2024-03-20 15:15:00'),(4,4,4,'dislike','2024-04-10 16:45:00'),(5,5,5,'like','2024-05-25 19:00:00');
/*!40000 ALTER TABLE `commentreactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `text` text,
  `comment_datetime` datetime DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `video_id` int DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `user_id` (`user_id`),
  KEY `video_id` (`video_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`video_id`) REFERENCES `videos` (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'Comment 1 for Video 1','2024-01-01 10:15:00',1,1),(2,'Comment 2 for Video 2','2024-02-15 12:45:00',2,2),(3,'Comment 3 for Video 3','2024-03-20 15:00:00',3,3),(4,'Comment 4 for Video 4','2024-04-10 16:30:00',4,4),(5,'Comment 5 for Video 5','2024-05-25 18:45:00',5,5);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
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
  `channel_id` int DEFAULT NULL,
  `subscribe_date` date DEFAULT NULL,
  PRIMARY KEY (`subscription_id`),
  KEY `user_id` (`user_id`),
  KEY `channel_id` (`channel_id`),
  CONSTRAINT `subscriptions_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `subscriptions_ibfk_2` FOREIGN KEY (`channel_id`) REFERENCES `channels` (`channel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptions`
--

LOCK TABLES `subscriptions` WRITE;
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` VALUES (1,1,2,'2024-01-01'),(2,2,3,'2024-02-15'),(3,3,4,'2024-03-20'),(4,4,5,'2024-04-10'),(5,5,1,'2024-05-25');
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tags` (
  `tag_id` int NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` VALUES (1,'Tag1'),(2,'Tag2'),(3,'Tag3'),(4,'Tag4'),(5,'Tag5');
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;
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
  `sex` enum('M','F') DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `postal_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'user1@example.com','password1','User1','1990-01-01','M','Country1','12345'),(2,'user2@example.com','password2','User2','1992-05-15','F','Country2','23456'),(3,'user3@example.com','password3','User3','1988-09-20','M','Country3','34567'),(4,'user4@example.com','password4','User4','1995-03-10','F','Country4','45678'),(5,'user5@example.com','password5','User5','1998-07-25','M','Country5','56789');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videos`
--

DROP TABLE IF EXISTS `videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videos` (
  `video_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` text,
  `size` varchar(20) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `length` time DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `views` int DEFAULT '0',
  `likes` int DEFAULT '0',
  `dislikes` int DEFAULT '0',
  `state` enum('public','hidden','private') DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `publish_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`video_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `videos_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videos`
--

LOCK TABLES `videos` WRITE;
/*!40000 ALTER TABLE `videos` DISABLE KEYS */;
INSERT INTO `videos` VALUES (1,'Video 1','Description of Video 1','100MB','video1.mp4','00:05:30','thumbnail1.jpg',1000,50,5,'public',1,'2024-01-01 10:00:00'),(2,'Video 2','Description of Video 2','150MB','video2.mp4','00:07:45','thumbnail2.jpg',800,40,8,'public',2,'2024-02-15 12:30:00'),(3,'Video 3','Description of Video 3','120MB','video3.mp4','00:06:20','thumbnail3.jpg',1200,60,6,'public',3,'2024-03-20 14:45:00'),(4,'Video 4','Description of Video 4','90MB','video4.mp4','00:04:15','thumbnail4.jpg',1500,70,7,'public',4,'2024-04-10 16:00:00'),(5,'Video 5','Description of Video 5','80MB','video5.mp4','00:03:50','thumbnail5.jpg',2000,80,4,'public',5,'2024-05-25 18:15:00');
/*!40000 ALTER TABLE `videos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videotags`
--

DROP TABLE IF EXISTS `videotags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videotags` (
  `video_id` int NOT NULL,
  `tag_id` int NOT NULL,
  PRIMARY KEY (`video_id`,`tag_id`),
  KEY `tag_id` (`tag_id`),
  CONSTRAINT `videotags_ibfk_1` FOREIGN KEY (`video_id`) REFERENCES `videos` (`video_id`),
  CONSTRAINT `videotags_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videotags`
--

LOCK TABLES `videotags` WRITE;
/*!40000 ALTER TABLE `videotags` DISABLE KEYS */;
INSERT INTO `videotags` VALUES (1,1),(2,2),(3,3),(4,4),(5,5);
/*!40000 ALTER TABLE `videotags` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-09  7:06:41
