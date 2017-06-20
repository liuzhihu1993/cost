/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : cost

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-04-18 22:04:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `audit_history`
-- ----------------------------
DROP TABLE IF EXISTS `audit_history`;
CREATE TABLE `audit_history` (
  `audit_id` int(11) NOT NULL AUTO_INCREMENT,
  `expense_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `audit_time` datetime DEFAULT NULL,
  `audit_state` varchar(5) DEFAULT NULL,
  `audit_desc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`audit_id`),
  KEY `FK_Reference_8` (`expense_id`),
  KEY `FK_Reference_9` (`user_id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`expense_id`) REFERENCES `expense_account` (`expense_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of audit_history
-- ----------------------------
INSERT INTO `audit_history` VALUES ('3', '1', '8', '2017-02-14 18:18:09', '2', '审核通过审核通过审核通过');
INSERT INTO `audit_history` VALUES ('4', '2', '8', '2017-02-14 18:18:29', '-1', '审核通过');
INSERT INTO `audit_history` VALUES ('5', '3', '8', '2017-02-14 18:18:59', 'del', '作废作废作废');
INSERT INTO `audit_history` VALUES ('6', '6', '1', '2017-02-14 23:02:02', '2', 'adsad');
INSERT INTO `audit_history` VALUES ('7', '1', '1', '2017-02-14 23:24:41', '3', '审核通过  审核通过  ');
INSERT INTO `audit_history` VALUES ('8', '6', '1', '2017-02-14 23:25:11', '3', 'asdsad');
INSERT INTO `audit_history` VALUES ('9', '7', '1', '2017-02-14 23:53:35', '2', '广州出差');
INSERT INTO `audit_history` VALUES ('10', '7', '1', '2017-02-14 23:54:01', '-2', '广州出差广州出差广州出差');
INSERT INTO `audit_history` VALUES ('11', '10', '1', '2017-02-14 01:36:56', '-1', 'sss');
INSERT INTO `audit_history` VALUES ('12', '11', '1', '2017-02-14 22:59:35', '2', '');
INSERT INTO `audit_history` VALUES ('13', '12', '1', '2017-02-14 16:44:17', '2', '斯蒂芬森');
INSERT INTO `audit_history` VALUES ('14', '12', '1', '2017-02-14 16:44:23', '3', '斯蒂芬森的');
INSERT INTO `audit_history` VALUES ('15', '9', '1', '2017-02-14 18:21:43', '2', '1231');
INSERT INTO `audit_history` VALUES ('16', '13', '8', '2017-04-13 23:43:37', '2', '审核通过');
INSERT INTO `audit_history` VALUES ('17', '13', '9', '2017-04-13 23:45:52', '3', '审核通过');
INSERT INTO `audit_history` VALUES ('18', '9', '9', '2017-04-13 23:46:04', '-2', '');
INSERT INTO `audit_history` VALUES ('19', '14', '8', '2017-04-13 23:54:22', '2', '审批通过。');
INSERT INTO `audit_history` VALUES ('20', '14', '9', '2017-04-13 23:56:06', '3', '审核通过。');
INSERT INTO `audit_history` VALUES ('21', '15', '8', '2017-04-14 00:48:53', '2', '通过');

-- ----------------------------
-- Table structure for `cost_info`
-- ----------------------------
DROP TABLE IF EXISTS `cost_info`;
CREATE TABLE `cost_info` (
  `cost_id` int(11) NOT NULL AUTO_INCREMENT,
  `cost_name` varchar(100) DEFAULT NULL,
  `cost_desc` varchar(1000) DEFAULT NULL,
  `cost_mark` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`cost_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cost_info
-- ----------------------------
INSERT INTO `cost_info` VALUES ('1', '住宿费', '住宿费每晚不能超过200元', '1');
INSERT INTO `cost_info` VALUES ('2', '火车费', '只能报销硬卧费用价格1', '1');
INSERT INTO `cost_info` VALUES ('3', '电话费', 'xxx', '1');

-- ----------------------------
-- Table structure for `expense_account`
-- ----------------------------
DROP TABLE IF EXISTS `expense_account`;
CREATE TABLE `expense_account` (
  `expense_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `expense_name` varchar(300) DEFAULT NULL,
  `expense_desc` varchar(1000) DEFAULT NULL,
  `expense_time` datetime DEFAULT NULL,
  `expense_state` varchar(5) DEFAULT NULL,
  `expense_total` double DEFAULT NULL,
  PRIMARY KEY (`expense_id`),
  KEY `FK_Reference_5` (`user_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expense_account
-- ----------------------------
INSERT INTO `expense_account` VALUES ('1', '1', '上海出差', '上海出差上海出差上海出差上海出差上海出差', '2017-01-13 00:00:00', '3', '7000');
INSERT INTO `expense_account` VALUES ('2', '1', '北京出差1', '北京出差北京出差北京出差北京出差', '2017-02-13 00:00:00', '1', '12222');
INSERT INTO `expense_account` VALUES ('3', '1', '重庆出差', '重庆出差重庆出差重庆出差', '2016-12-14 00:00:00', 'del', '10000');
INSERT INTO `expense_account` VALUES ('6', '8', '香港出差', '香港出差香港出差香港出差香港出差', '2016-10-14 00:00:00', '3', '6500');
INSERT INTO `expense_account` VALUES ('7', '1', '广州出差1', '广州出差广州出差广州出差广州出差', '2016-12-15 00:00:00', '1', '12332');
INSERT INTO `expense_account` VALUES ('8', '1', '大连出差', '大连出差大连出大连出差大连出差大连出差差', '2016-11-16 00:00:00', '3', '3333');
INSERT INTO `expense_account` VALUES ('9', '1', '广州出差2', '广州出差广州出差广州出差广州出差2', '2017-03-14 00:00:00', '0', '2221');
INSERT INTO `expense_account` VALUES ('10', '1', '广州出差1', '广州出差广州出差广州出差广州出差1', '2016-09-14 00:00:00', '0', '1221');
INSERT INTO `expense_account` VALUES ('11', '1', '8888', '', '2016-01-16 00:00:00', '3', '1899');
INSERT INTO `expense_account` VALUES ('12', '1', '重庆出差', '学校上课', '2015-12-28 00:00:00', '3', '1900');
INSERT INTO `expense_account` VALUES ('13', '2', '出差南京', '出差南京，住宾馆车费。', '2017-04-12 00:00:00', '3', '400');
INSERT INTO `expense_account` VALUES ('14', '2', '出差香港', '出差香港，住宿费。', '2017-04-13 00:00:00', '3', '800');
INSERT INTO `expense_account` VALUES ('15', '2', '111', '11111', '2017-04-14 00:00:00', '2', '200');

-- ----------------------------
-- Table structure for `expense_details`
-- ----------------------------
DROP TABLE IF EXISTS `expense_details`;
CREATE TABLE `expense_details` (
  `expense_details_id` int(11) NOT NULL AUTO_INCREMENT,
  `expense_id` int(11) DEFAULT NULL,
  `cost_id` int(11) DEFAULT NULL,
  `expense_details_amount` double DEFAULT NULL,
  PRIMARY KEY (`expense_details_id`),
  KEY `FK_Reference_6` (`expense_id`),
  KEY `FK_Reference_7` (`cost_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`expense_id`) REFERENCES `expense_account` (`expense_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`cost_id`) REFERENCES `cost_info` (`cost_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expense_details
-- ----------------------------
INSERT INTO `expense_details` VALUES ('1', '1', '2', '3000');
INSERT INTO `expense_details` VALUES ('2', '1', '1', '4000');
INSERT INTO `expense_details` VALUES ('5', '3', '1', '10000');
INSERT INTO `expense_details` VALUES ('6', '6', '2', '4000');
INSERT INTO `expense_details` VALUES ('7', '6', '1', '2500');
INSERT INTO `expense_details` VALUES ('10', '8', '2', '3333');
INSERT INTO `expense_details` VALUES ('11', '9', '1', '666');
INSERT INTO `expense_details` VALUES ('12', '9', '2', '555');
INSERT INTO `expense_details` VALUES ('13', '9', '3', '1000');
INSERT INTO `expense_details` VALUES ('14', '10', '1', '666');
INSERT INTO `expense_details` VALUES ('15', '10', '2', '555');
INSERT INTO `expense_details` VALUES ('16', '7', '1', '666');
INSERT INTO `expense_details` VALUES ('17', '7', '2', '555');
INSERT INTO `expense_details` VALUES ('18', '7', '3', '11111');
INSERT INTO `expense_details` VALUES ('19', '2', '1', '1111');
INSERT INTO `expense_details` VALUES ('20', '2', '2', '11111');
INSERT INTO `expense_details` VALUES ('21', '11', '2', '900');
INSERT INTO `expense_details` VALUES ('22', '11', '1', '999');
INSERT INTO `expense_details` VALUES ('23', '12', '3', '200');
INSERT INTO `expense_details` VALUES ('24', '12', '2', '500');
INSERT INTO `expense_details` VALUES ('25', '12', '1', '1200');
INSERT INTO `expense_details` VALUES ('26', '13', '2', '200');
INSERT INTO `expense_details` VALUES ('27', '13', '1', '200');
INSERT INTO `expense_details` VALUES ('28', '14', '1', '800');
INSERT INTO `expense_details` VALUES ('29', '15', '2', '200');

-- ----------------------------
-- Table structure for `menu_info`
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info` (
  `menu_id` int(11) NOT NULL,
  `prent_menu_id` int(11) DEFAULT NULL,
  `menu_name` varchar(100) DEFAULT NULL,
  `menu_url` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`menu_id`),
  KEY `FK_Reference_1` (`prent_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_info
-- ----------------------------
INSERT INTO `menu_info` VALUES ('0', '-1', '根节点', null);
INSERT INTO `menu_info` VALUES ('1', '0', '系统管理', null);
INSERT INTO `menu_info` VALUES ('3', '1', '用户管理', 'user/list.do');
INSERT INTO `menu_info` VALUES ('4', '1', '角色管理', 'role/list.do');
INSERT INTO `menu_info` VALUES ('7', '1', '菜单管理', 'menu/list.do');
INSERT INTO `menu_info` VALUES ('8', '0', '报销管理', '');
INSERT INTO `menu_info` VALUES ('9', '8', '报销单', 'expense/loadadd.do');
INSERT INTO `menu_info` VALUES ('10', '1', '权限管理', 'anthority/list.do');
INSERT INTO `menu_info` VALUES ('11', '1', '费用管理', 'cost/list.do');
INSERT INTO `menu_info` VALUES ('12', '8', '经理审核', 'expense/loadAuditManager.do');
INSERT INTO `menu_info` VALUES ('13', '8', '财务审核', 'expense/loadAuditFinance.do');
INSERT INTO `menu_info` VALUES ('14', '8', '我的报销', 'expense/mylist.do');
INSERT INTO `menu_info` VALUES ('15', '8', '我的审核', 'expense/myauditlist.do');
INSERT INTO `menu_info` VALUES ('16', '8', '报销查询', 'expense/list.do');
INSERT INTO `menu_info` VALUES ('17', '0', '薪资管理', '');
INSERT INTO `menu_info` VALUES ('18', '17', '薪资发放', 'salary/loadadd.do');
INSERT INTO `menu_info` VALUES ('19', '17', '薪资发放查询', 'salary/list.do');
INSERT INTO `menu_info` VALUES ('20', '0', '报表管理', '');
INSERT INTO `menu_info` VALUES ('21', '20', '薪资发放统计（table）', 'report/salaryMonth.do');
INSERT INTO `menu_info` VALUES ('22', '20', '薪资发放统计（柱状图）', 'report/salaryMonth.do?type=column');
INSERT INTO `menu_info` VALUES ('23', '20', '薪资发放统计（线形图）', 'report/salaryMonth.do?type=line');
INSERT INTO `menu_info` VALUES ('24', '20', '报销统计(table)', 'report/expenseMonth.do');
INSERT INTO `menu_info` VALUES ('25', '20', '报销统计(柱状图)', 'report/expenseMonth.do?type=column');
INSERT INTO `menu_info` VALUES ('26', '20', '报销统计(线形图)', 'report/expenseMonth.do?type=spline');
INSERT INTO `menu_info` VALUES ('27', '20', '费用统计(table)', 'report/expenseCost.do');
INSERT INTO `menu_info` VALUES ('28', '20', '费用统计(饼状图)', 'report/expenseCost.do?type=pie');
INSERT INTO `menu_info` VALUES ('29', '20', '费用统计(柱状图)', 'report/expenseCost.do?type=column');
INSERT INTO `menu_info` VALUES ('30', '20', '费用统计(线形图)', 'report/expenseCost.do?type=spline');

-- ----------------------------
-- Table structure for `role_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `role_desc` varchar(1000) DEFAULT NULL,
  `role_mark` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('1', '普通员工', '普通员工，可以天天打酱油', '1');
INSERT INTO `role_info` VALUES ('2', '超级管理员', '超级管理员', '1');
INSERT INTO `role_info` VALUES ('5', '财务经理', '天天数钱的', '1');
INSERT INTO `role_info` VALUES ('6', '部门经理', '部门经理', '1');

-- ----------------------------
-- Table structure for `role_menu_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_info`;
CREATE TABLE `role_menu_info` (
  `role_menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_menu_id`),
  KEY `FK_Reference_3` (`menu_id`),
  KEY `FK_Reference_4` (`role_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`menu_id`) REFERENCES `menu_info` (`menu_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=267 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu_info
-- ----------------------------
INSERT INTO `role_menu_info` VALUES ('191', '8', '1');
INSERT INTO `role_menu_info` VALUES ('192', '9', '1');
INSERT INTO `role_menu_info` VALUES ('193', '14', '1');
INSERT INTO `role_menu_info` VALUES ('194', '16', '1');
INSERT INTO `role_menu_info` VALUES ('195', '17', '1');
INSERT INTO `role_menu_info` VALUES ('212', '8', '5');
INSERT INTO `role_menu_info` VALUES ('213', '9', '5');
INSERT INTO `role_menu_info` VALUES ('214', '13', '5');
INSERT INTO `role_menu_info` VALUES ('215', '15', '5');
INSERT INTO `role_menu_info` VALUES ('216', '16', '5');
INSERT INTO `role_menu_info` VALUES ('217', '17', '5');
INSERT INTO `role_menu_info` VALUES ('218', '18', '5');
INSERT INTO `role_menu_info` VALUES ('219', '19', '5');
INSERT INTO `role_menu_info` VALUES ('220', '20', '5');
INSERT INTO `role_menu_info` VALUES ('221', '21', '5');
INSERT INTO `role_menu_info` VALUES ('222', '22', '5');
INSERT INTO `role_menu_info` VALUES ('223', '23', '5');
INSERT INTO `role_menu_info` VALUES ('224', '1', '2');
INSERT INTO `role_menu_info` VALUES ('225', '3', '2');
INSERT INTO `role_menu_info` VALUES ('226', '4', '2');
INSERT INTO `role_menu_info` VALUES ('227', '7', '2');
INSERT INTO `role_menu_info` VALUES ('228', '10', '2');
INSERT INTO `role_menu_info` VALUES ('229', '11', '2');
INSERT INTO `role_menu_info` VALUES ('230', '8', '2');
INSERT INTO `role_menu_info` VALUES ('231', '9', '2');
INSERT INTO `role_menu_info` VALUES ('232', '12', '2');
INSERT INTO `role_menu_info` VALUES ('233', '13', '2');
INSERT INTO `role_menu_info` VALUES ('234', '14', '2');
INSERT INTO `role_menu_info` VALUES ('235', '15', '2');
INSERT INTO `role_menu_info` VALUES ('236', '16', '2');
INSERT INTO `role_menu_info` VALUES ('237', '17', '2');
INSERT INTO `role_menu_info` VALUES ('238', '18', '2');
INSERT INTO `role_menu_info` VALUES ('239', '19', '2');
INSERT INTO `role_menu_info` VALUES ('240', '20', '2');
INSERT INTO `role_menu_info` VALUES ('241', '21', '2');
INSERT INTO `role_menu_info` VALUES ('242', '22', '2');
INSERT INTO `role_menu_info` VALUES ('243', '23', '2');
INSERT INTO `role_menu_info` VALUES ('244', '24', '2');
INSERT INTO `role_menu_info` VALUES ('245', '25', '2');
INSERT INTO `role_menu_info` VALUES ('246', '26', '2');
INSERT INTO `role_menu_info` VALUES ('247', '27', '2');
INSERT INTO `role_menu_info` VALUES ('248', '28', '2');
INSERT INTO `role_menu_info` VALUES ('249', '29', '2');
INSERT INTO `role_menu_info` VALUES ('250', '30', '2');
INSERT INTO `role_menu_info` VALUES ('251', '8', '6');
INSERT INTO `role_menu_info` VALUES ('252', '9', '6');
INSERT INTO `role_menu_info` VALUES ('253', '12', '6');
INSERT INTO `role_menu_info` VALUES ('254', '14', '6');
INSERT INTO `role_menu_info` VALUES ('255', '15', '6');
INSERT INTO `role_menu_info` VALUES ('256', '16', '6');
INSERT INTO `role_menu_info` VALUES ('257', '17', '6');
INSERT INTO `role_menu_info` VALUES ('258', '19', '6');
INSERT INTO `role_menu_info` VALUES ('259', '20', '6');
INSERT INTO `role_menu_info` VALUES ('260', '21', '6');
INSERT INTO `role_menu_info` VALUES ('261', '22', '6');
INSERT INTO `role_menu_info` VALUES ('262', '23', '6');
INSERT INTO `role_menu_info` VALUES ('263', '24', '6');
INSERT INTO `role_menu_info` VALUES ('264', '25', '6');
INSERT INTO `role_menu_info` VALUES ('265', '29', '6');
INSERT INTO `role_menu_info` VALUES ('266', '30', '6');

-- ----------------------------
-- Table structure for `salary_payment`
-- ----------------------------
DROP TABLE IF EXISTS `salary_payment`;
CREATE TABLE `salary_payment` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `payment_time` datetime DEFAULT NULL,
  `payment_money` double DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `FK_Reference_10` (`user_id`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salary_payment
-- ----------------------------
INSERT INTO `salary_payment` VALUES ('1', '1', '2016-12-17 00:00:00', '3000');
INSERT INTO `salary_payment` VALUES ('2', '1', '2016-12-17 00:00:00', '8000');
INSERT INTO `salary_payment` VALUES ('3', '1', '2016-12-17 00:00:00', '30000');
INSERT INTO `salary_payment` VALUES ('4', '1', '2016-12-18 00:00:00', '10000');
INSERT INTO `salary_payment` VALUES ('5', '10', '2016-12-15 00:00:00', '3000');
INSERT INTO `salary_payment` VALUES ('6', '1', '2016-12-30 00:00:00', '3000');
INSERT INTO `salary_payment` VALUES ('7', '2', '2016-12-30 00:00:00', '1500');
INSERT INTO `salary_payment` VALUES ('8', '8', '2016-12-30 00:00:00', '10000');
INSERT INTO `salary_payment` VALUES ('9', '10', '2016-12-30 00:00:00', '4000');
INSERT INTO `salary_payment` VALUES ('10', '1', '2017-01-30 00:00:00', '3000');
INSERT INTO `salary_payment` VALUES ('11', '2', '2017-01-30 00:00:00', '1500');
INSERT INTO `salary_payment` VALUES ('12', '8', '2017-01-30 00:00:00', '10000');
INSERT INTO `salary_payment` VALUES ('13', '10', '2017-01-30 00:00:00', '4000');
INSERT INTO `salary_payment` VALUES ('14', '10', '2016-09-28 00:00:00', '20000');
INSERT INTO `salary_payment` VALUES ('15', '9', '2016-11-15 00:00:00', '3000');
INSERT INTO `salary_payment` VALUES ('16', '10', '2016-10-30 00:00:00', '5555');
INSERT INTO `salary_payment` VALUES ('17', '10', '2017-04-13 00:00:00', '5000');
INSERT INTO `salary_payment` VALUES ('18', '2', '2017-04-15 00:00:00', '800');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_sex` varchar(10) DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_account` varchar(100) DEFAULT NULL,
  `user_password` varchar(100) DEFAULT NULL,
  `user_salary` double DEFAULT NULL,
  `user_mark` varchar(5) DEFAULT NULL COMMENT '1 ��Ч 0 ��Ч',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_account` (`user_account`),
  KEY `FK_Reference_2` (`role_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '2', '张小三', '男', '18', 'admin', '123', '500', '1');
INSERT INTO `user_info` VALUES ('2', '1', '张大三', '男', '25', 'user', '123', '111111', '1');
INSERT INTO `user_info` VALUES ('8', '6', '华安', '男', '11', 'manager', '123', '111', '1');
INSERT INTO `user_info` VALUES ('9', '5', '秋香', '女', '33', 'finance', '123', '3333', '1');
INSERT INTO `user_info` VALUES ('10', '2', '唐伯虎', '保密', '11', 'tangbohu', '123', '1111', '1');
