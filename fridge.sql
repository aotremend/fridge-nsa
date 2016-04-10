/*
SQLyog Community v12.09 (64 bit)
MySQL - 5.6.21 : Database - fridge_nsa
*********************************************************************
*/
DROP DATABASE `fridge_nsa`;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `item` */

insert  into `item`(`id`,`code`,`description`,`image_url`,`name`) values (2,'banana','Bananas are a very good source of vitamin B6 and a good source of manganese, vitamin C, potassium, dietary fiber, potassium, biotin, and copper.','http://www.bbcgoodfood.com/sites/default/files/glossary/banana-crop.jpg','Banana'),(3,'beer','Heineken Lager Beer (Dutch: Heineken Pilsener), or simply Heineken, is a pale lager beer with 5% alcohol by volume produced by the Dutch brewing company Heineken International. Heineken is well known for its signature gr','https://uk.i-d-s.com/ImageHandler/2199w999h999/13155-jpg?Sequence=2199&Width=999&Height=999','Heineken'),(4,'kiwi','Kiwifruit is an excellent source of vitamin C and vitamin K as well as a very good source of copper and dietary fiber. It is also a good source of vitamin E, potassium, folate, and manganese.','https://upload.wikimedia.org/wikipedia/commons/5/59/Kiwi1.1.jpg','Kiwi'),(5,'milk','Milk and dairy foods are healthy foods and considered nutrient-rich because they serve as good sources of calcium and vitamin D as well as protein and other essential nutrients. They provide phosphorus, potassium, magnesium, and vitamins A, B12, and riboflavin.','http://www.livrari-online.ro/shop/image/cache/data/lapteladorna-500x500.jpg','La Dorna'),(6,'apple','These important nutritional elements include vitamin C, vitamin K, vitamin B6, and riboflavin, as well as minerals like potassium, copper, manganese, and magnesium. Apples are also very good sources of dietary fiber, and a single serving provides 12% of the daily fiber requirement.','http://weknowyourdreamz.com/images/apple/apple-01.jpg','Apple');

/*Table structure for table `recipe` */

DROP TABLE IF EXISTS `recipe`;

CREATE TABLE `recipe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` text,
  `other_products` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `recipe` */

insert  into `recipe`(`id`,`image_url`,`name`,`content`,`other_products`) values (2,'http://chiefmarkets.com/blog/wp-content/uploads/2012/04/IMG_1609.jpg','Fruit salad','In a small bowl, combine orange juice, vinegar, and sugar. Stir until blended and set aside. Place cucumber, blueberries, strawberries, and apple in a large bowl. Top with the orange juice mixture and stir gently to coat. Cover and refrigerate for at least 1 hour (overnight is best). Stir gently just before serving. Garnish with mint, if using. Enjoy!!!','Brandy, Sugar, Strawberies, Cream'),(4,'http://images.edge-generalmills.com/3cf7cb34-8f77-4885-bfec-697f96dd5d61.jpg','Apple pie','Make the dough by hand. In a medium bowl, whisk together the flour, sugar, and salt. Using your fingers, work the butter into the dry ingredients until it resembles yellow corn meal mixed with bean sized bits of butter. (If the flour/butter mixture gets warm, refrigerate it for 10 minutes before proceeding.) Add the egg and stir the dough together with a fork or by hand in the bowl. If the dough is dry, sprinkle up to a tablespoon more of cold water over the mixture.\',\'Flour, Sugar, Salt, Butter, Eggs\'),(2,\'http://chiefmarkets.com/blog/wp-content/uploads/2012/04/IMG_1609.jpg\',\'Fruit salad\',\'In a small bowl, combine orange juice, vinegar, and sugar. Stir until blended and set aside. Place cucumber, blueberries, strawberries, and apple in a large bowl. Top with the orange juice mixture and stir gently to coat. Cover and refrigerate for at least 1 hour (overnight is best). Stir gently just before serving. Garnish with mint, if using. Enjoy!!!','Brandy, Sugar, Strawberies, Cream'),(5,'http://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1081511_12.jpg?itok=PivRpcbD','Golden beer-battered fish with chips','Combine the flour, cornflour, baking powder and turmeric in a large bowl, season, then spoon 1 tbsp onto a plate and set aside. Gradually pour the beer and water into the bowl, stirring with a wooden spoon until you have a smooth, lump-free batter. Leave to rest for 30 mins while you prepare the chips.\r\nHeat oven to 200C/fan 180C/gas 6. Boil a large pan of water, then add the chipped potatoes and boil for 2-3 mins until the outsides are just tender but not soft. drain well, then tip onto a large baking tray with the flour, oil and some salt. Gently toss together until all the potatoes are evenly coated and the flour is no longer dusty. Roast for 30 mins, turning occasionally, until the chips are golden and crisp.','Fish, Oil, Potatoes, Sparkling water');

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

insert  into `recipe_items`(`recipe_id`,`items_id`) values (2,2),(4,5),(4,6),(2,6);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
