-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: product_gallery
-- ------------------------------------------------------
-- Server version	5.7.28-0ubuntu0.18.04.4

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` longtext,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,2,'Carcasa Silicona Huawei P30 Lite','<p>Garantía del proveedor 6 meses.</p>',34000),(2,2,'Audífonos Bluetooth Xiaomi ZBW4485GL','<p>Garantía del proveedor 3 meses. Información adicional\nEmparejamiento automático, asistente de Voz. Toque para pausar, reanudar o contestar/ colgar llamadas. </p>',99000),(3,5,'Celular Huawei Mate 20 Lite 64GB','<p>Huawei Mate 20 Lite: Pantalla FullView Full HD\nLas impresionantes imágenes de la pantalla FullView FHD+ de 6,3\" (2.340 x 1.080) lo sumergen en momentos de magia, mientras que la elegante y simétrica cubierta posterior descansa cómodamente en la palma de su mano.</p>',729900),(4,5,'iPhone XS Max 64GB','<p>Producto ambientado, sólo incluye productos especificados en la descripción.\nLa memoria interna y la RAM disponibles para el usuario dependen del sistema operativo y las aplicaciones precargadas.</p>',2999900),(5,5,'Celular Samsung Galaxy A30s 64GB','<h3>Tu contenido cobra vida con esta pantalla</h3><p>Tus videos, juegos y transmisiones lucen bien en la pantalla Infinity- V de 6.4 gracias a la tecnología Super AMOLED, que te permite disfrutar colores más brillantes y vívidos.</p>',749900),(6,9,'Smartwatch Galaxy Watch 42 mm R810','<h3>Con el Galaxy Watch podrás mantenerte conectado por más tiempo.</h3> <p>Mantente conectado por más tiempo. Las características de un reloj inteligente y la sensación natural de un reloj analógico en un solo paquete. Galaxy Watch te conecta con el mundo que te rodea.</p>',849900),(7,10,'Celular Samsung Galaxy Note 10+ 256GB','<p>Con Galaxy Note10 y Note10+, diseñamos una experiencia en el celular que equivale a tener una computadora, una consola de juegos, una cámara de filmación profesional y un lápiz inteligente, todo en un dispositivo</p>',3899900),(8,9,'Galaxy Fit e','<p>El Galaxy Fit e, cuenta con una pantalla compacta y sencilla, que muestra tu rutina de entrenamiento de forma fácil y rápida.</p>',149900),(9,8,'AirPods con estuche de carga inalámbrica','<p>Producto ambientado, sólo incluye productos especificados en la descripción.</p>',729900);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-16 14:47:45
