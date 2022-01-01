/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2020-07-12 23:31:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ϵͳ���',
  `username` varchar(20) DEFAULT NULL COMMENT '�û���',
  `password` varchar(20) DEFAULT NULL COMMENT '��¼����',
  `type` int(11) DEFAULT NULL COMMENT '���ࣺ\r\n            ��ͨ����Ա :0\r\n            ϵͳ����Ա�� 1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='���ݿ����Ա��\r\n  ��Ϊ��ͨ����Ա ϵͳ����Ա';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'kappy', '1', '1');
INSERT INTO `admin` VALUES ('2', 'admin', '123456', '0');

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `author` varchar(25) DEFAULT NULL,
  `publish` varchar(25) DEFAULT NULL,
  `ISBN` varchar(25) DEFAULT NULL COMMENT '��׼���',
  `introduction` text COMMENT '��Ľ���',
  `language` varchar(20) DEFAULT NULL COMMENT '����',
  `price` double DEFAULT NULL COMMENT '�۸���Ϣ',
  `pub_date` date DEFAULT NULL COMMENT '����ʱ��',
  `type_id` int(10) DEFAULT NULL COMMENT '����ͼ�������е�id',
  `status` int(10) DEFAULT NULL COMMENT '0 未借出\r\n1 已经借出',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='ͼ�����Ϣ��';

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES ('1', '文化讲解', '张三', '新华出版社', '1001', '无', '中文', '15.6', '2020-06-07', '1', '0');
INSERT INTO `book_info` VALUES ('8', '文化讲解11111', '张三11', '新华出版社11', '100111', '1111111', '中文11', '15.611', '2020-06-01', '4', '1');
INSERT INTO `book_info` VALUES ('3', '文化讲解2', '张三', '新华出版社', '1001', '无', '中文', '15.6', '2020-06-07', '1', '0');
INSERT INTO `book_info` VALUES ('4', '历史', '张三', '新华出版社', '1002', '无', '中文', '15.6', '2020-06-07', '2', '0');

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='ͼ��ķ���� ';

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info` VALUES ('1', '文学类', '学文学');
INSERT INTO `class_info` VALUES ('2', '历史类', '历史类');
INSERT INTO `class_info` VALUES ('3', '医学类', '医学实测');
INSERT INTO `class_info` VALUES ('4', '化学类', '化学');
INSERT INTO `class_info` VALUES ('5', '文学类1', '   学文学1');

-- ----------------------------
-- Table structure for lend_list
-- ----------------------------
DROP TABLE IF EXISTS `lend_list`;
CREATE TABLE `lend_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ϵͳ���',
  `book_id` int(11) DEFAULT NULL COMMENT '��ı��',
  `reader_id` int(11) DEFAULT NULL COMMENT '����id',
  `lend_date` datetime DEFAULT NULL COMMENT '���ʱ��',
  `back_date` datetime DEFAULT NULL COMMENT '�黹ʱ��',
  `type` int(10) DEFAULT NULL COMMENT '�黹ͼ�����ͣ�\r\n              0�������黹\r\n              1�����ڹ黹\r\n              2������黹\r\n              3����ʧ����\r\n              4������',
  `remarks` varchar(255) DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='���黹����ؼ�¼��Ϣ';

-- ----------------------------
-- Records of lend_list
-- ----------------------------
INSERT INTO `lend_list` VALUES ('1', '1', '1', '2020-07-06 00:00:00', '2020-07-13 00:00:00', '0', '无');
INSERT INTO `lend_list` VALUES ('4', '1', '1', '2020-07-05 00:00:00', '2020-07-05 21:13:19', '0', null);
INSERT INTO `lend_list` VALUES ('12', '8', '2', '2020-07-05 22:41:48', null, null, null);
INSERT INTO `lend_list` VALUES ('10', '8', '1', '2020-07-05 22:32:15', '2020-07-05 22:33:13', '2', '图书破损不能外借啦');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text COMMENT '����',
  `create_date` date DEFAULT NULL COMMENT '����ʱ��',
  `author` int(11) DEFAULT NULL COMMENT '������',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='������Ϣ��';

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '公告内容', '2020-07-06', '1');

-- ----------------------------
-- Table structure for reader_card
-- ----------------------------
DROP TABLE IF EXISTS `reader_card`;
CREATE TABLE `reader_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL COMMENT '��¼����',
  `password` varchar(25) DEFAULT NULL COMMENT '����',
  `number` int(10) DEFAULT NULL COMMENT '借书数量',
  `name` varchar(25) DEFAULT NULL COMMENT '��������',
  `sex` varchar(5) DEFAULT NULL COMMENT '�Ա�',
  `birthday` date DEFAULT NULL COMMENT '��������',
  `address` varchar(150) DEFAULT NULL COMMENT '��ַ',
  `tel` varchar(20) DEFAULT NULL COMMENT '�绰',
  `email` varchar(50) DEFAULT NULL COMMENT '����',
  `creat_date` datetime DEFAULT NULL,
  `cjr` int(11) DEFAULT NULL,
  `cardnumber` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='���Ŀ���ͼ�鿨��';

-- ----------------------------
-- Records of reader_card
-- ----------------------------
INSERT INTO `reader_card` VALUES ('1', 'kappy1', '123456', '3', '张三', '女', '2020-06-03', null, '120', 'yishuihan@163.com', null, null, '10001');
INSERT INTO `reader_card` VALUES ('2', 'kappy', '123456', '2', 'kappy', '女', '2020-11-20', null, '112', 'yishuihan@163.com', '2020-06-26 17:30:32', null, '12222');
INSERT INTO `reader_card` VALUES ('5', 'kevin', '123456', '3', 'zhansgan', '男', '2020-06-01', null, '110', 'yishuihan@163.com', null, null, '1004');
