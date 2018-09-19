# ssm
ssm学习,环境搭建，对数据表的增删查改。

具体说明可以参考下面的博客园连接地址


http://www.cnblogs.com/supertonny/p/6341521.html


http://www.cnblogs.com/supertonny/p/6418966.html



sql脚本以及测试数据
/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2017-04-21 15:35:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `userAge` int(11) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'tinny', '10');
INSERT INTO `t_user` VALUES ('2', 'tonny', '11');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `delflag` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('0', '1', 'Tonny Chien', '123', '25');
INSERT INTO `users` VALUES ('0', '2', 'Tinny Cheung', '123', '22');
INSERT INTO `users` VALUES (null, '3', 'Jerry Chien', null, '-1');
