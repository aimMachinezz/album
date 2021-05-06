/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50087
Source Host           : localhost:3306
Source Database       : ssmgrxcglxthsg7654x1b6

Target Server Type    : MYSQL
Target Server Version : 50087
File Encoding         : 65001

Date: 2020-03-30 11:41:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `allusers`
-- ----------------------------
DROP TABLE IF EXISTS `allusers`;
CREATE TABLE `allusers` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) default NULL,
  `pwd` varchar(50) default NULL,
  `cx` varchar(50) default '普通管理员',
  `addtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of allusers
-- ----------------------------
INSERT INTO `allusers` VALUES ('2', 'hsg', 'hsg', '超级管理员', '2020-03-29 16:26:50');

-- ----------------------------
-- Table structure for `dx`
-- ----------------------------
DROP TABLE IF EXISTS `dx`;
CREATE TABLE `dx` (
  `ID` int(11) NOT NULL auto_increment,
  `leibie` varchar(50) default NULL,
  `content` longtext,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dx
-- ----------------------------
INSERT INTO `dx` VALUES ('1', '系统公告', '<p>\r\n	欢迎大家登陆我站，我站主要是为广大朋友精心制作的一个系统，希望大家能够在我站获得一个好心情，谢谢！\r\n</p>\r\n<p>\r\n	自强不息，海纳百川，努力学习！fff\r\n</p>');
INSERT INTO `dx` VALUES ('2', '系统简介', '<p>\r\n	做一个开心的系统\r\n</p>');
INSERT INTO `dx` VALUES ('3', '关于我们', '&nbsp; &nbsp; 本公司坚持走:以质量求生存,以科技求发展,重合同守信用的道路,生产经营得到迅速发展。我们将以优质的产品和最完善的售后服务来真诚与各界朋友开展广泛的合作,共同创造一个美好的未来!<br />  <br />  公司行为准则:忠信仁义，以人为本。 <br />  忠：即忠诚，  包括三重含义：企业忠于国家、忠于民族；企业忠于客户；员工忠于企业。 <br />  信：即诚信，做企业要立足根本道德、信义，要诚实、讲信用。 <br />  仁：即仁爱，上司对下属要仁爱、体贴，同事之间要关怀、友爱。 <br />  义：即大义，公司在与合作伙伴、客户的交往过程中，不做损人利己的事，维护自己利益的前提是不损害他人利益；对民族、社会要共襄义举，要识大义，明是非。 <br />');
INSERT INTO `dx` VALUES ('4', '联系方式', '联系人：xxxxxxxx<br />  电话：0000-0000000<br />  手机：010000000000<br />  传真：0000-0000000<br />  邮件：xxxxxxxx@163.com<br />  地址：您公司的地址<br />  网址：http://www.xxxx.com<br />');

-- ----------------------------
-- Table structure for `liuyanban`
-- ----------------------------
DROP TABLE IF EXISTS `liuyanban`;
CREATE TABLE `liuyanban` (
  `id` int(11) NOT NULL auto_increment,
  `cheng` varchar(50) default NULL,
  `xingbie` varchar(50) default NULL,
  `QQ` varchar(50) default NULL,
  `youxiang` varchar(50) default NULL,
  `shouji` varchar(50) default NULL,
  `neirong` varchar(500) default NULL,
  `huifuneirong` varchar(500) default NULL,
  `addtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of liuyanban
-- ----------------------------
INSERT INTO `liuyanban` VALUES ('1', '888', '1', '', '', '', '122212', '12212', '2020-03-29 18:27:35');

-- ----------------------------
-- Table structure for `pinglun`
-- ----------------------------
DROP TABLE IF EXISTS `pinglun`;
CREATE TABLE `pinglun` (
  `ID` int(11) NOT NULL auto_increment,
  `xinwenID` varchar(10) default NULL,
  `pinglunneirong` varchar(500) default NULL,
  `pinglunren` varchar(20) default NULL,
  `pingfen` varchar(4) default NULL,
  `biao` varchar(20) default NULL,
  `addtime` timestamp NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pinglun
-- ----------------------------
INSERT INTO `pinglun` VALUES ('1', '6', '好好看啊', '888', '5', 'xiangcexinxi', '2020-03-29 18:26:59');
INSERT INTO `pinglun` VALUES ('2', '6', 'nice', '888', '1', 'shipinxinxi', '2020-03-29 18:27:12');

-- ----------------------------
-- Table structure for `shipinxinxi`
-- ----------------------------
DROP TABLE IF EXISTS `shipinxinxi`;
CREATE TABLE `shipinxinxi` (
  `id` int(11) NOT NULL auto_increment,
  `bianhao` varchar(50) default NULL,
  `shipinbiaoti` varchar(50) default NULL,
  `shipinleixing` varchar(50) default NULL,
  `tupian` varchar(50) default NULL,
  `shipin` varchar(50) default NULL,
  `jianshu` varchar(500) default NULL,
  `gerenqianming` varchar(50) default NULL,
  `faburiqi` date default NULL,
  `faburen` varchar(50) default NULL,
  `issh` varchar(10) default '否',
  `dianzan_d` int(11) default '0',
  `dianzan_c` int(11) default '0',
  `addtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shipinxinxi
-- ----------------------------
INSERT INTO `shipinxinxi` VALUES ('2', '329187575', '情侣', '情侣', 'upload/1585476921501.jpg', 'upload/2.mp4', '测试', '12112', '2020-03-12', '020', '是', '0', '0', '2020-03-29 16:27:05');
INSERT INTO `shipinxinxi` VALUES ('3', '329187575', '亲子', '亲子', 'upload/1585476913500.jpg', 'upload/2.mp4', '测试', '121212', '2020-03-28', '017', '是', '0', '0', '2020-03-29 16:27:05');
INSERT INTO `shipinxinxi` VALUES ('4', '329177045', '情侣', '情侣', 'upload/1585476900740.jpg', 'upload/2.mp4', '测试', '111212', '2020-04-15', '003', '是', '0', '0', '2020-03-29 16:27:05');
INSERT INTO `shipinxinxi` VALUES ('5', '329177045', '旅游', '旅游', 'upload/1585476890963.jpg', 'upload/2.mp4', '测试', '212212', '2020-03-12', '014', '是', '0', '0', '2020-03-29 16:27:05');
INSERT INTO `shipinxinxi` VALUES ('6', '329183146', '情侣', '情侣', 'upload/1585476871740.jpg', 'upload/2.mp4', '测试', 'c121212', '2020-03-12', '001', '是', '0', '0', '2020-03-29 16:27:05');
INSERT INTO `shipinxinxi` VALUES ('7', '03291829081588', '旅游视频', '旅游', 'upload/1585477765253.jpg', 'upload/1585477775321.mp4', '测试', '我有我的样', '2020-03-29', '888', '是', '0', '0', '2020-03-29 18:29:43');

-- ----------------------------
-- Table structure for `shoucangjilu`
-- ----------------------------
DROP TABLE IF EXISTS `shoucangjilu`;
CREATE TABLE `shoucangjilu` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) default NULL,
  `xwid` varchar(50) default NULL,
  `ziduan` varchar(50) default NULL,
  `biao` varchar(50) default NULL,
  `addtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `biaoj` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shoucangjilu
-- ----------------------------
INSERT INTO `shoucangjilu` VALUES ('1', '888', '6', 'xiangcebiaoti', 'xiangcexinxi', '2020-03-29 18:26:52', 'xcxx');
INSERT INTO `shoucangjilu` VALUES ('2', '888', '6', 'shipinbiaoti', 'shipinxinxi', '2020-03-29 18:27:04', 'spxx');

-- ----------------------------
-- Table structure for `xiangcexinxi`
-- ----------------------------
DROP TABLE IF EXISTS `xiangcexinxi`;
CREATE TABLE `xiangcexinxi` (
  `id` int(11) NOT NULL auto_increment,
  `bianhao` varchar(50) default NULL,
  `xiangcebiaoti` varchar(50) default NULL,
  `xiangceleixing` varchar(50) default NULL,
  `xiangcefengmian` varchar(50) default NULL,
  `wenjian` varchar(50) default NULL,
  `tupianshuliang` varchar(50) default NULL,
  `jianshu` varchar(500) default NULL,
  `gexingqianming` varchar(50) default NULL,
  `faburiqi` date default NULL,
  `faburen` varchar(50) default NULL,
  `issh` varchar(10) default '否',
  `dianzan_d` int(11) default '0',
  `dianzan_c` int(11) default '0',
  `addtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of xiangcexinxi
-- ----------------------------
INSERT INTO `xiangcexinxi` VALUES ('2', '3295429442', '情侣相册', '情侣', 'upload/1585476828708.jpg', 'upload/1.zip', '53', '测是', '测试', '2020-03-18', '015', '是', '0', '0', '2020-03-29 16:27:24');
INSERT INTO `xiangcexinxi` VALUES ('3', '3295477799', '亲子相册', '亲子', 'upload/1585476818580.jpg', 'upload/1.zip', '10', '测', '测', '2020-04-14', '021', '是', '0', '0', '2020-03-29 16:27:24');
INSERT INTO `xiangcexinxi` VALUES ('4', '3295477799', '亲子相册', '亲子', 'upload/1585476804568.jpg', 'upload/1.zip', '10', '测试', '我有我的样', '2020-04-10', '009', '是', '0', '0', '2020-03-29 16:27:24');
INSERT INTO `xiangcexinxi` VALUES ('5', '3295401602', '亲子相册', '亲子', 'upload/1585476772763.jpg', 'upload/1.zip', '53', '测试', '12122', '2020-04-10', '029', '是', '0', '0', '2020-03-29 16:27:24');
INSERT INTO `xiangcexinxi` VALUES ('6', '3295417303', '旅游相册', '旅游', 'upload/1585476763177.jpg', 'upload/1.zip', '85', '121212', '12121212', '2020-04-10', '001', '是', '0', '0', '2020-03-29 16:27:24');
INSERT INTO `xiangcexinxi` VALUES ('7', '03291828181186', '亲子相册', '亲子', 'upload/1585477726006.jpg', 'upload/1585477732998.zip', '50张', '测试', '我有我的样', '2020-03-29', '888', '是', '0', '0', '2020-03-29 18:29:01');

-- ----------------------------
-- Table structure for `xinwentongzhi`
-- ----------------------------
DROP TABLE IF EXISTS `xinwentongzhi`;
CREATE TABLE `xinwentongzhi` (
  `id` int(11) NOT NULL auto_increment,
  `biaoti` varchar(50) default NULL,
  `leibie` varchar(50) default NULL,
  `neirong` text,
  `shouyetupian` varchar(50) default NULL,
  `dianjilv` varchar(50) default NULL,
  `tianjiaren` varchar(50) default NULL,
  `addtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `zhaiyao` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of xinwentongzhi
-- ----------------------------
INSERT INTO `xinwentongzhi` VALUES ('1', '变幻图1', '变幻图', '变幻图', 'upload/1585476706221.jpg', '3', 'hsg', '2020-03-29 16:26:50', null);
INSERT INTO `xinwentongzhi` VALUES ('2', '变幻图2', '变幻图', '变幻图', 'upload/1585476699573.jpg', '32', 'hsg', '2020-03-29 16:26:50', null);
INSERT INTO `xinwentongzhi` VALUES ('3', '变幻图3', '变幻图', '变幻图', 'upload/1585476690333.jpg', '33', 'hsg', '2020-03-29 16:26:50', null);
INSERT INTO `xinwentongzhi` VALUES ('4', '变幻图4', '变幻图', '变幻图', 'upload/1585476683773.jpg', '35', 'hsg', '2020-03-29 16:26:50', null);
INSERT INTO `xinwentongzhi` VALUES ('5', '变幻图5', '变幻图', '变幻图', 'upload/1585476676273.jpg', '13', 'hsg', '2020-03-29 16:26:50', null);
INSERT INTO `xinwentongzhi` VALUES ('6', '1212', '站内新闻', '12122', '', '', 'hsg', '2020-03-29 16:43:49', null);
INSERT INTO `xinwentongzhi` VALUES ('7', '关于XX公告', '公告通知', '<p>\r\n	公告\r\n</p>', '', '', 'hsg', '2020-03-29 18:21:00', null);
INSERT INTO `xinwentongzhi` VALUES ('8', '新闻信息', '站内新闻', '可以发布一些新闻公告', '', '1', 'hsg', '2020-03-29 18:23:28', null);
INSERT INTO `xinwentongzhi` VALUES ('9', '关于XX的公告', '公告通知', '<p>\r\n	可以发布一些公告信息\r\n</p>', '', '1', 'hsg', '2020-03-29 18:23:51', null);

-- ----------------------------
-- Table structure for `yonghuzhuce`
-- ----------------------------
DROP TABLE IF EXISTS `yonghuzhuce`;
CREATE TABLE `yonghuzhuce` (
  `id` int(11) NOT NULL auto_increment,
  `yonghuming` varchar(50) default NULL,
  `mima` varchar(50) default NULL,
  `xingming` varchar(50) default NULL,
  `xingbie` varchar(50) default NULL,
  `chushengnianyue` date default NULL,
  `QQ` varchar(50) default NULL,
  `youxiang` varchar(50) default NULL,
  `shouji` varchar(50) default NULL,
  `shenfenzheng` varchar(50) default NULL,
  `touxiang` varchar(50) default NULL,
  `dizhi` varchar(50) default NULL,
  `beizhu` varchar(500) default NULL,
  `issh` varchar(10) default '否',
  `addtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of yonghuzhuce
-- ----------------------------
INSERT INTO `yonghuzhuce` VALUES ('2', '006', '001', '陈燕琪', '男', '2019-02-10', '143244252', 'regrodd@qq.com', '13748589658', '33032718650304', 'upload/yhtx1.jpg', '泰兴路22号', '无', '是', '2019-01-25 12:19:45');
INSERT INTO `yonghuzhuce` VALUES ('3', '012', '001', '李鹏', '女', '2019-01-16', '2362624', '56547474@qq.com', '13186835580', '330327198615482633', 'upload/yhtx2.jpg', '龙翔路11号', 'ok', '是', '2019-01-25 12:19:45');
INSERT INTO `yonghuzhuce` VALUES ('4', '005', '001', '郑亚斌', '女', '2019-01-16', '2362743', '	fegge@163.com', '13587835380', '330327198805060222', 'upload/yhtx3.jpg', '开明路22号', 'ok', '是', '2019-01-25 12:19:45');
INSERT INTO `yonghuzhuce` VALUES ('5', '028', '001', '陈小巧', '男', '2019-01-31', '25454766', '43643933@qq.com', '18956482221', '33032718501209', 'upload/yhtx4.jpg', '复兴街27号', 'abc', '是', '2019-01-25 12:19:45');
INSERT INTO `yonghuzhuce` VALUES ('6', '001', '001', '赵小型', '男', '2019-01-16', '5437334', '2352352@qq.com', '17505772420', '33032719900723568X', 'upload/yhtx5.jpg', '方城丽圆11幢201室', '无', '是', '2019-01-25 12:19:45');

-- ----------------------------
-- Table structure for `youqinglianjie`
-- ----------------------------
DROP TABLE IF EXISTS `youqinglianjie`;
CREATE TABLE `youqinglianjie` (
  `ID` int(11) NOT NULL,
  `wangzhanmingcheng` varchar(50) default NULL,
  `wangzhi` varchar(50) default NULL,
  `addtime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `LOGO` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of youqinglianjie
-- ----------------------------
INSERT INTO `youqinglianjie` VALUES ('1', '百度', 'http://www.baidu.com', '2018-11-13 19:38:20', 'upload/baidu.jpg');
INSERT INTO `youqinglianjie` VALUES ('2', '谷歌', 'http://www.google.cn', '2018-11-13 19:38:20', 'upload/google.jpg');
INSERT INTO `youqinglianjie` VALUES ('3', '新浪', 'http://www.sina.com', '2018-11-13 19:38:20', 'upload/sina.jpg');
INSERT INTO `youqinglianjie` VALUES ('4', '雅虎', 'http://www.yahoo.cn', '2018-11-13 19:38:20', 'upload/yahoo.jpg');
INSERT INTO `youqinglianjie` VALUES ('5', '腾讯', 'http://www.qq.com', '2018-11-13 19:38:20', 'upload/qq.jpg');

-- ----------------------------
-- Table structure for `zhuceyonghu`
-- ----------------------------
DROP TABLE IF EXISTS `zhuceyonghu`;
CREATE TABLE `zhuceyonghu` (
  `id` int(11) NOT NULL auto_increment,
  `yonghuming` varchar(50) default NULL,
  `mima` varchar(50) default NULL,
  `cheng` varchar(50) default NULL,
  `xingming` varchar(50) default NULL,
  `xingbie` varchar(50) default NULL,
  `touxiang` varchar(50) default NULL,
  `shengri` date default NULL,
  `xingzuo` varchar(50) default NULL,
  `shenfenzheng` varchar(50) default NULL,
  `shouji` varchar(50) default NULL,
  `gexingqianming` varchar(50) default NULL,
  `aihao` varchar(50) default NULL,
  `issh` varchar(10) default '否',
  `addtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of zhuceyonghu
-- ----------------------------
INSERT INTO `zhuceyonghu` VALUES ('2', '026', '001', '', '李大汉', '男', 'upload/zhuceyonghu1.jpg', '2020-03-21', '处女座', '33032719900723568X', '6854778', '', '', '是', '2020-03-29 16:27:35');
INSERT INTO `zhuceyonghu` VALUES ('3', '032', '001', '', '余少庆', '男', 'upload/zhuceyonghu3.jpg', '2020-03-03', '双鱼座', '330327199504059511', '6497512', '', '', '是', '2020-03-29 16:27:35');
INSERT INTO `zhuceyonghu` VALUES ('4', '029', '001', '', '陈小巧', '女', 'upload/zhuceyonghu5.jpg', '2020-03-03', '天秤座', '330327185403060589', '8895632', '', '', '是', '2020-03-29 16:27:35');
INSERT INTO `zhuceyonghu` VALUES ('5', '005', '001', '', '刘建福', '男', 'upload/zhuceyonghu4.jpg', '2020-03-03', '狮子座', '330327198406150488', '8954878', '', '', '是', '2020-03-29 16:27:35');
INSERT INTO `zhuceyonghu` VALUES ('6', '001', '001', '剑神', '郑亚斌', '男', 'upload/zhuceyonghu2.jpg', '2020-03-21', '双子座', '330327199005060003', '4265325', '我有我的样', '', '是', '2020-03-29 16:27:35');
INSERT INTO `zhuceyonghu` VALUES ('7', '888', '001', '小叶子', '小叶', null, 'upload/1585477674860.png', '2020-03-29', '白羊座', '330327198811020456', '17505772420', '我有我的样', '打篮球，看电影', '是', '2020-03-29 18:22:58');
