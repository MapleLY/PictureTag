/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : picturetag

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-06-24 10:41:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `picinfo`
-- ----------------------------
DROP TABLE IF EXISTS `picinfo`;
CREATE TABLE `picinfo` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `picname` varchar(30) DEFAULT NULL,
  `picurl` varchar(500) DEFAULT NULL,
  `strlabel` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picinfo
-- ----------------------------
INSERT INTO `picinfo` VALUES ('1', 'taylorswift', 'aaaaa.jpg', 'd*霉霉+37,b*泰勒+5,a*美女+1,a*歌手+2,a*斯威夫特+1');
INSERT INTO `picinfo` VALUES ('2', 'cat', 'cat.jpg', 'b*猫咪+5');
INSERT INTO `picinfo` VALUES ('3', 'elf', 'elf.jpg', 'b*精灵王子+7');
INSERT INTO `picinfo` VALUES ('4', 'god', 'god.jpg', 'c*神奇女侠+12');
INSERT INTO `picinfo` VALUES ('5', 'woman', 'woman.jpg', 'a*加朵+4');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userid` int(100) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `labellog` varchar(500) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `usersex` varchar(5) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '1', '1', '1+5,6+0,3+0,5+0,1+3', '洛克', '男', '12345@163.com');
