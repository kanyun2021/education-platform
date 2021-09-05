CREATE DATABASE IF NOT EXISTS `education-platform` CHARACTER SET UTF8;

USE `education-platform`;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `id` INT(20) UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID，主键',
  `username` VARCHAR(45) NOT NULL COMMENT '登录用户名',
  `password` VARCHAR(45) NOT NULL COMMENT '登录密码，md5小写字母加密',
  `creat_time` DATETIME NOT NULL ,
  `update_time` DATETIME NOT NULL ,
  `enable` int(11) NOT NULL DEFAULT '1' COMMENT '是否启用该用户，1表示启用，0表示禁用',
  `nickname` varchar(45) DEFAULT NULL COMMENT '用户显示名称，一般是用户的真实姓名',
  `mobile` char(11) DEFAULT NULL COMMENT '用户移动电话，手机号',
  `email` varchar(45) DEFAULT NULL COMMENT '用户邮箱',
  `type` int(11) DEFAULT NULL COMMENT '用户类型，0是普通用户(学生)，1是教师用户，2是校级管理员，3是省域管理员，4是超级管理员',
  `photo` varchar(255) DEFAULT NULL,
  `session_id` INT(20) UNSIGNED COMMENT '用户登陆会修改这个值，会对用户进行配置',
  UNIQUE KEY `username_UNIQUE` (`username`) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
