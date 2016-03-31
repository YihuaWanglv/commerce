/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : commerce_user

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-03-31 12:12:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(4) NOT NULL,
  `role_name` varchar(64) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'user');
INSERT INTO `role` VALUES ('2', 'admin');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `type` tinyint(4) NOT NULL DEFAULT '0',
  `password` varchar(64) NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '0',
  `email` varchar(64) NOT NULL,
  `mobile` varchar(32) DEFAULT NULL,
  `salt` varchar(64) NOT NULL DEFAULT '0',
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `code` varchar(64) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'iyihua', '0', '457ebd4372bbb8f58881e3aabb254ade16296f0deba1853f', '1', '', null, '123456789', '0', null, '0000-00-00 00:00:00', null);
INSERT INTO `user` VALUES ('2', 'iyihua2', '1', 'CpievEp3tWpuK7exnZldGFzkQJDBPimEt+zG1EbUth6pmRt2pMLwSxtNJEhBRJRU', '1', '', null, '0', '0', null, '0000-00-00 00:00:00', null);
INSERT INTO `user` VALUES ('3', 'test', '0', '9d1f7fa9809595ef9ffa4ff1ec6405847081cda5ba7d171f', '1', '619361578@qq.com', '13560427788', '8552547760341714187', '0', null, '0000-00-00 00:00:00', null);
INSERT INTO `user` VALUES ('22', 'wanglvyihua', '0', 'e3fb1d24e7d9a6f118ca6c6b7ef12e2d80749ed7c7d45c45', '0', 'wanglvyh@cf-ec.com', null, '643103048256386404', '0', '2aec1eedcb16bc4635bd9768b347edb3837a57e0', '0000-00-00 00:00:00', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(4) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
