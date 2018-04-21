/*
Navicat MySQL Data Transfer

Source Server         : loc
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : h5_work_sys

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-21 11:20:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_answer`
-- ----------------------------
DROP TABLE IF EXISTS `t_answer`;
CREATE TABLE `t_answer` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_answer` varchar(255) DEFAULT NULL,
  `a_correct` int(1) NOT NULL,
  `q_id` int(11) NOT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_answer
-- ----------------------------
INSERT INTO `t_answer` VALUES ('9', '苹果', '0', '14');
INSERT INTO `t_answer` VALUES ('10', '橘子', '0', '14');
INSERT INTO `t_answer` VALUES ('11', '橙子', '1', '14');
INSERT INTO `t_answer` VALUES ('12', '是', '1', '15');
INSERT INTO `t_answer` VALUES ('13', '否', '0', '15');
INSERT INTO `t_answer` VALUES ('14', '1、继承，2、封装，3、抽象', '1', '16');

-- ----------------------------
-- Table structure for `t_clzss`
-- ----------------------------
DROP TABLE IF EXISTS `t_clzss`;
CREATE TABLE `t_clzss` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级主键id',
  `grade` varchar(255) DEFAULT NULL,
  `clzss` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_clzss
-- ----------------------------
INSERT INTO `t_clzss` VALUES ('37', '2018', '1');
INSERT INTO `t_clzss` VALUES ('38', '2018', '2');
INSERT INTO `t_clzss` VALUES ('39', '2018', '3');

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(32) DEFAULT NULL,
  `menu_pid` int(11) NOT NULL,
  `menu_name` varchar(32) DEFAULT NULL,
  `menu_link` varchar(50) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', 'system', '0', '系统管理', '', '5', '1');
INSERT INTO `t_menu` VALUES ('2', 'menu', '1', '菜单管理', 'menu', '1', '1');
INSERT INTO `t_menu` VALUES ('3', 'role', '1', '角色管理', 'role', '2', '1');
INSERT INTO `t_menu` VALUES ('4', 'user', '1', '用户管理', 'user', '3', '1');
INSERT INTO `t_menu` VALUES ('5', 'zidian', '0', '系统数据', '', '6', '1');
INSERT INTO `t_menu` VALUES ('8', 'info', '0', '信息管理', '', '1', '1');
INSERT INTO `t_menu` VALUES ('10', 'student', '8', '学生信息管理', 'student', '1', '1');
INSERT INTO `t_menu` VALUES ('23', 'gongneng', '0', '教师工具', '', '4', '1');
INSERT INTO `t_menu` VALUES ('31', '1429321176178', '0', '父', '', null, '1');
INSERT INTO `t_menu` VALUES ('34', 'classManagement', '5', '班级管理', 'clzss', '1', '1');
INSERT INTO `t_menu` VALUES ('35', 'workManagement', '23', '作业管理', 'work', '1', '1');
INSERT INTO `t_menu` VALUES ('36', 'questionAnswer', '23', '题库管理', 'questionAnswer', '1', '1');

-- ----------------------------
-- Table structure for `t_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `msg_id` int(11) NOT NULL AUTO_INCREMENT,
  `msg_pid` int(11) NOT NULL,
  `msg_type` int(1) NOT NULL COMMENT '消息类型。1：提问，2：讨论',
  `msg_content` varchar(500) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `w_id` int(11) NOT NULL COMMENT '作业ID',
  `oper_role` int(1) NOT NULL COMMENT '发送角色，1:老师，2:学生',
  `oper_id` int(11) NOT NULL COMMENT '发送者ID',
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES ('59', '0', '1', '老师你好，请问这个作业得什么时候完成？', '2018-04-21 10:31:45', '20', '1', '47');
INSERT INTO `t_message` VALUES ('60', '0', '1', '有不会做的怎么办？', '2018-04-21 10:32:13', '20', '1', '47');
INSERT INTO `t_message` VALUES ('61', '59', '1', '23号完成就好', '2018-04-21 10:45:26', '20', '2', '4');
INSERT INTO `t_message` VALUES ('62', '60', '1', '不会做的先随便答，后面会有答题', '2018-04-21 10:45:51', '20', '2', '4');
INSERT INTO `t_message` VALUES ('63', '0', '2', 'java的三大特性，有详细介绍吗？', '2018-04-21 10:49:32', '20', '1', '47');
INSERT INTO `t_message` VALUES ('64', '63', '2', '百度有噢。', '2018-04-21 10:54:55', '20', '1', '48');
INSERT INTO `t_message` VALUES ('65', '64', '2', '书本也有哦。在第一章。', '2018-04-21 10:59:21', '20', '2', '4');
INSERT INTO `t_message` VALUES ('66', '65', '2', '嗯。老师说的地方也是。', '2018-04-21 11:05:58', '20', '1', '48');
INSERT INTO `t_message` VALUES ('67', '66', '2', '。。。', '2018-04-21 11:06:13', '20', '2', '4');

-- ----------------------------
-- Table structure for `t_question`
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `q_id` int(11) NOT NULL AUTO_INCREMENT,
  `q_title` varchar(255) NOT NULL,
  `q_type` int(1) NOT NULL,
  PRIMARY KEY (`q_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_question
-- ----------------------------
INSERT INTO `t_question` VALUES ('14', '你喜欢吃的水果？', '1');
INSERT INTO `t_question` VALUES ('15', 'java是面向对象的吗？', '1');
INSERT INTO `t_question` VALUES ('16', 'java面向对象的三大特征是？', '2');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(32) DEFAULT NULL,
  `role_name` varchar(32) DEFAULT NULL,
  `sys` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `create_id` int(11) DEFAULT NULL,
  `update_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  KEY `FK_ROLE_USER` (`create_id`),
  CONSTRAINT `t_role_ibfk_1` FOREIGN KEY (`create_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin', '管理员', null, '拥有最高权限。', '1', '1', '1', '2015-03-05 09:47:47', '2018-04-20 21:27:03');
INSERT INTO `t_role` VALUES ('2', 'teacher', '教师', null, '拥有一些信息之类的管理。', '1', '1', '1', '2015-03-05 11:19:05', '2018-04-21 09:33:43');
INSERT INTO `t_role` VALUES ('3', 'student', '学生', null, '不允许进入后台。', '1', '1', null, '2015-03-05 11:23:56', null);

-- ----------------------------
-- Table structure for `t_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `role_id` int(11) DEFAULT NULL,
  `permission` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('1', 'ceshi:');
INSERT INTO `t_role_permission` VALUES ('1', 'system:');
INSERT INTO `t_role_permission` VALUES ('1', 'menu:');
INSERT INTO `t_role_permission` VALUES ('1', 'role:');
INSERT INTO `t_role_permission` VALUES ('1', 'user:');
INSERT INTO `t_role_permission` VALUES ('2', 'info:');
INSERT INTO `t_role_permission` VALUES ('2', 'student:');
INSERT INTO `t_role_permission` VALUES ('2', 'gongneng:');
INSERT INTO `t_role_permission` VALUES ('2', 'questionAnswer:');
INSERT INTO `t_role_permission` VALUES ('2', 'workManagement:');
INSERT INTO `t_role_permission` VALUES ('2', 'zidian:');
INSERT INTO `t_role_permission` VALUES ('2', 'classManagement:');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_no` varchar(50) NOT NULL,
  `s_name` varchar(50) NOT NULL,
  `s_password` varchar(50) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `user_role` int(11) DEFAULT NULL,
  `s_sex` tinyint(1) DEFAULT '0',
  `clzss_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('47', '2018001', '张三', '123456', null, '3', '0', '37');
INSERT INTO `t_student` VALUES ('48', '2018002', '李四', '123456', null, '3', '0', '37');
INSERT INTO `t_student` VALUES ('49', '2018003', '王五', '123456', null, '3', '1', '37');
INSERT INTO `t_student` VALUES ('50', '2018004', '赵六', '123456', null, '3', '0', '37');
INSERT INTO `t_student` VALUES ('51', '2018005', '马七', '123456', null, '3', '1', '37');

-- ----------------------------
-- Table structure for `t_stu_question`
-- ----------------------------
DROP TABLE IF EXISTS `t_stu_question`;
CREATE TABLE `t_stu_question` (
  `sq_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_id` int(11) DEFAULT NULL COMMENT 'student_id',
  `w_id` int(11) DEFAULT NULL COMMENT 'work_id',
  `q_id` int(11) DEFAULT NULL COMMENT '问题ID',
  `q_answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sq_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stu_question
-- ----------------------------
INSERT INTO `t_stu_question` VALUES ('43', '47', '20', '14', '苹果');
INSERT INTO `t_stu_question` VALUES ('44', '47', '20', '15', '是');
INSERT INTO `t_stu_question` VALUES ('45', '47', '20', '16', '封装，继承，抽象');
INSERT INTO `t_stu_question` VALUES ('46', '48', '20', '14', '橙子');
INSERT INTO `t_stu_question` VALUES ('47', '48', '20', '15', '是');
INSERT INTO `t_stu_question` VALUES ('48', '48', '20', '16', '不懂');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `user_role` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `create_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_USER_ROLE` (`user_role`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`user_role`) REFERENCES `t_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '系统管理员', '123456', '', '1', '1', '1', '2015-03-04 22:55:38');
INSERT INTO `t_user` VALUES ('2', 'jiaoshi', '教师', '123456', '', '2', '1', '1', '2015-03-05 11:21:11');
INSERT INTO `t_user` VALUES ('4', 'jiaoshi2', '教师2', '123456', null, '2', '1', '1', '2018-04-21 09:50:21');

-- ----------------------------
-- Table structure for `t_work`
-- ----------------------------
DROP TABLE IF EXISTS `t_work`;
CREATE TABLE `t_work` (
  `w_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_tch_id` int(11) DEFAULT NULL,
  `clzss_id` int(11) DEFAULT NULL,
  `w_work_name` varchar(50) DEFAULT NULL,
  `w_add_time` datetime DEFAULT NULL,
  `w_work_requirement` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`w_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_work
-- ----------------------------
INSERT INTO `t_work` VALUES ('20', '4', '37', 'java ee第一课课后习题。', '2018-04-21 09:53:24', '下一节课前完成答题。');
INSERT INTO `t_work` VALUES ('21', '4', '37', 'java ee第二课课后习题', '2018-04-21 10:04:16', 'java ee第二课课后习题');

-- ----------------------------
-- Table structure for `t_work_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_work_info`;
CREATE TABLE `t_work_info` (
  `wi_id` int(11) NOT NULL AUTO_INCREMENT,
  `w_id` int(11) DEFAULT NULL,
  `s_id` int(11) DEFAULT NULL,
  `wi_add_time` datetime DEFAULT NULL,
  `w_i_score` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`wi_id`),
  KEY `FK_WORKINFO_WORK` (`w_id`),
  KEY `FK_WORKINFO_STUDENT` (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_work_info
-- ----------------------------
INSERT INTO `t_work_info` VALUES ('9', '20', '47', '2018-04-21 10:48:21', '1');
INSERT INTO `t_work_info` VALUES ('10', '20', '48', '2018-04-21 10:50:14', '2');

-- ----------------------------
-- Table structure for `t_work_question`
-- ----------------------------
DROP TABLE IF EXISTS `t_work_question`;
CREATE TABLE `t_work_question` (
  `wq_id` int(11) NOT NULL AUTO_INCREMENT,
  `w_id` int(11) DEFAULT NULL COMMENT '作业ID',
  `q_id` int(11) DEFAULT NULL COMMENT '题目ID',
  PRIMARY KEY (`wq_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_work_question
-- ----------------------------
INSERT INTO `t_work_question` VALUES ('25', '20', '14');
INSERT INTO `t_work_question` VALUES ('26', '20', '15');
INSERT INTO `t_work_question` VALUES ('27', '20', '16');
INSERT INTO `t_work_question` VALUES ('28', '21', '14');
INSERT INTO `t_work_question` VALUES ('29', '21', '15');
INSERT INTO `t_work_question` VALUES ('30', '21', '16');

-- ----------------------------
-- View structure for `v_user`
-- ----------------------------
DROP VIEW IF EXISTS `v_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_user` AS select `t1`.`user_id` AS `user_id`,`t1`.`login_name` AS `login_name`,`t1`.`nick_name` AS `nick_name`,`t1`.`password` AS `password`,`t1`.`salt` AS `salt`,`t1`.`user_role` AS `user_role`,`t1`.`state` AS `state`,`t1`.`create_id` AS `create_id`,`t1`.`create_time` AS `create_time`,`t2`.`role_name` AS `role_name`,`t2`.`role_code` AS `role_code`,`t3`.`login_name` AS `create_name` from ((`t_user` `t1` left join `t_role` `t2` on((`t1`.`user_role` = `t2`.`role_id`))) left join `t_user` `t3` on((`t1`.`create_id` = `t3`.`user_id`))) ;
