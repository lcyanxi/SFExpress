/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50171
Source Host           : localhost:3306
Source Database       : sfexpress

Target Server Type    : MYSQL
Target Server Version : 50171
File Encoding         : 65001

Date: 2017-05-27 08:20:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `AddId` char(10) NOT NULL,
  `UserId` char(10) NOT NULL,
  `AddName` varchar(20) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `DetailAddress` varchar(255) DEFAULT NULL,
  `AddPhone` varchar(11) DEFAULT NULL,
  `AddCreateTime` datetime DEFAULT NULL,
  `AddMark` int(11) DEFAULT NULL,
  PRIMARY KEY (`AddId`),
  KEY `UserId` (`UserId`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `CartId` char(10) NOT NULL,
  `UserId` char(10) NOT NULL,
  `ProId` char(10) NOT NULL,
  `Num` int(11) DEFAULT NULL,
  `Total` double DEFAULT NULL,
  `CartCreateTime` datetime DEFAULT NULL,
  `CartUpdateTime` datetime DEFAULT NULL,
  `CartMark` int(11) DEFAULT NULL,
  PRIMARY KEY (`CartId`),
  KEY `UserId` (`UserId`),
  KEY `ProId` (`ProId`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`ProId`) REFERENCES `prodution` (`ProId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `OrderId` char(10) NOT NULL,
  `UserId` char(10) NOT NULL,
  `OrderCreateTime` datetime DEFAULT NULL,
  `TotalPrice` double DEFAULT NULL,
  `PayMark` int(11) DEFAULT NULL,
  `OrderMark` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderId`),
  KEY `UserId` (`UserId`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for prodution
-- ----------------------------
DROP TABLE IF EXISTS `prodution`;
CREATE TABLE `prodution` (
  `ProId` char(10) NOT NULL,
  `ProName` varchar(30) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Img` varchar(255) DEFAULT NULL,
  `Detail` varchar(255) DEFAULT NULL,
  `ProMark` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for proinfo
-- ----------------------------
DROP TABLE IF EXISTS `proinfo`;
CREATE TABLE `proinfo` (
  `ProInfoId` char(10) NOT NULL,
  `OrderId` char(10) NOT NULL,
  `ProId` char(10) NOT NULL,
  `ProInfoCreateTime` datetime DEFAULT NULL,
  `ProInfoMark` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProInfoId`),
  KEY `OrderId` (`OrderId`),
  CONSTRAINT `proinfo_ibfk_1` FOREIGN KEY (`OrderId`) REFERENCES `order` (`OrderId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `UserId` char(10) NOT NULL,
  `UserName` varchar(16) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Phone` char(11) DEFAULT NULL,
  `Slead` int(11) DEFAULT NULL,
  `UserCreateTime` datetime DEFAULT NULL,
  `UserMark` int(11) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
