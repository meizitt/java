/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.62-log : Database - property_info
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`property_info` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `property_info`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `admin_account` varchar(50) NOT NULL,
  `admin_pwd` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`admin_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`admin_account`,`admin_pwd`) values ('admin','123');

/*Table structure for table `pinfo` */

DROP TABLE IF EXISTS `pinfo`;

CREATE TABLE `pinfo` (
  `p_id` varchar(50) NOT NULL,
  `p_name` varchar(10) DEFAULT NULL,
  `p_pwd` varchar(20) DEFAULT NULL,
  `p_sex` varchar(10) DEFAULT NULL,
  `p_addres` varchar(30) DEFAULT NULL,
  `p_phonenumber` varchar(15) DEFAULT NULL,
  `p_check_in_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pinfo` */

insert  into `pinfo`(`p_id`,`p_name`,`p_pwd`,`p_sex`,`p_addres`,`p_phonenumber`,`p_check_in_time`) values ('3307','虞姬','333333','女','4栋2单元楼1室','13990468765','2019-09-22'),('37ba','小乔','111111','男','1栋1单元楼1室','18779678330','2019-09-10'),('4dfb','都比','777777','男','1栋1单元楼1室','13567853423',''),('6766','王昭君','222222','女','1栋2单元楼1室','15788346689','2019-08-09'),('73cd','露娜','111111','男','1栋1单元楼1室','18779678330','2019-09-01'),('77a0','安琪拉','111111','女','3栋2单元楼1室','18779678330','2019-09-22'),('83c5','诸葛亮','444444','男','1栋1单元楼1室','13570836535',''),('ca1b','鲁班','111111','男','3栋1单元楼1室','18779678338','2019-09-22');

/*Table structure for table `record` */

DROP TABLE IF EXISTS `record`;

CREATE TABLE `record` (
  `r_id` varchar(50) NOT NULL,
  `p_id` varchar(50) NOT NULL,
  `r_time` date DEFAULT NULL,
  `r_money` double DEFAULT NULL,
  `r_remark` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`r_id`,`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `record` */

insert  into `record`(`r_id`,`p_id`,`r_time`,`r_money`,`r_remark`) values ('014192','73cd','2019-09-06',888,''),('0f1d32','ca1b','2019-09-15',347,'1'),('1672db','73cd','2019-09-15',53.5,''),('1bdd8c','ca1b','2019-09-15',50,'2'),('23a977','ca1b','2019-09-17',34,'3'),('2913b0','77a0','2019-09-15',100,''),('422b16','ca1b','2019-09-17',324,'4'),('8a0572','77a0','2019-09-15',45.6,'ok'),('8dfee1','37ba','2019-09-15',24.5,'ok'),('8fee71','77a0','2019-09-15',65,'ok'),('a48ce5','ca1b','2019-09-17',56,'5'),('bae4ac','37ba','2019-09-15',49,''),('c3a91e','ca1b','2019-09-17',56,'6'),('c68bd3','37ba','2019-09-15',58.8,''),('ec72e7','ca1b','2019-09-15',1,'7');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
