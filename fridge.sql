/*
SQLyog Community v12.09 (64 bit)
MySQL - 5.6.21 : Database - fridge_nsa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fridge_nsa` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `fridge_nsa`;

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `description` text,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `item` */

insert  into `item`(`id`,`code`,`description`,`image_url`,`name`) values (1,'orange','Oranges are an excellent source of vitamin C. They are also a very good source of dietary fiber. In addition, oranges are a good source of B vitamins including vitamin B1, pantothenic acid, and folate as well as vitamin A, calcium, copper, and potassium.','http://preview.turbosquid.com/Preview/2014/05/26__12_06_50/Orange_fruit_1.jpg7d55a7de-0e63-47c9-9e4c-c61306a42257Original.jpg','Spanish Orange'),(2,'banana','Bananas are a very good source of vitamin B6 and a good source of manganese, vitamin C, potassium, dietary fiber, potassium, biotin, and copper.','http://www.bbcgoodfood.com/sites/default/files/glossary/banana-crop.jpg','Banana'),(3,'beer','Heineken Lager Beer (Dutch: Heineken Pilsener), or simply Heineken (Dutch pronunciation: [???in?k?n]), is a pale lager beer with 5% alcohol by volume produced by the Dutch brewing company Heineken International. Heineken is well known for its signature gr','https://uk.i-d-s.com/ImageHandler/2199w999h999/13155-jpg?Sequence=2199&Width=999&Height=999','Heineken');

/*Table structure for table `recipe` */

DROP TABLE IF EXISTS `recipe`;

CREATE TABLE `recipe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` text,
  `other_products` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `recipe` */

insert  into `recipe`(`id`,`image_url`,`name`,`content`,`other_products`) values (1,'http://images.edge-generalmills.com/3cf7cb34-8f77-4885-bfec-697f96dd5d61.jpg','Apple pie','Make the dough by hand. In a medium bowl, whisk together the flour, sugar, and salt. Using your fingers, work the butter into the dry ingredients until it resembles yellow corn meal mixed with bean sized bits of butter. (If the flour/butter mixture gets warm, refrigerate it for 10 minutes before proceeding.) Add the egg and stir the dough together with a fork or by hand in the bowl. If the dough is dry, sprinkle up to a tablespoon more of cold water over the mixture.','Flour, Sugar, Salt, Butter, Eggs'),(2,'http://chiefmarkets.com/blog/wp-content/uploads/2012/04/IMG_1609.jpg','Fruit salad','In a small bowl, combine orange juice, vinegar, and sugar. Stir until blended and set aside. Place cucumber, blueberries, strawberries, and apple in a large bowl. Top with the orange juice mixture and stir gently to coat. Cover and refrigerate for at least 1 hour (overnight is best). Stir gently just before serving. Garnish with mint, if using. Enjoy!!!','Brandy, Sugar, Strawberies, Cream');

/*Table structure for table `recipe_items` */

DROP TABLE IF EXISTS `recipe_items`;

CREATE TABLE `recipe_items` (
  `recipe_id` bigint(20) NOT NULL,
  `items_id` bigint(20) NOT NULL,
  KEY `FK_n952fyygyges4i20u7gv17pwf` (`items_id`),
  KEY `FK_qm7wbqmqev6t89na6krbqf6ob` (`recipe_id`),
  CONSTRAINT `FK_n952fyygyges4i20u7gv17pwf` FOREIGN KEY (`items_id`) REFERENCES `item` (`id`),
  CONSTRAINT `FK_qm7wbqmqev6t89na6krbqf6ob` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `recipe_items` */

insert  into `recipe_items`(`recipe_id`,`items_id`) values (1,1),(2,1),(2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
