/*
SQLyog Enterprise v12.08 (64 bit)
MySQL - 5.5.12-log : Database - db_jf
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_jf` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_jf`;

/*Table structure for table `c3p0testtable` */

DROP TABLE IF EXISTS `c3p0testtable`;

CREATE TABLE `c3p0testtable` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `c3p0testtable` */

/*Table structure for table `t_batch_serial` */

DROP TABLE IF EXISTS `t_batch_serial`;

CREATE TABLE `t_batch_serial` (
  `batchno` varchar(64) NOT NULL COMMENT '批次号',
  `serialno` varchar(64) NOT NULL COMMENT '流水号（作废）',
  `serialno_park` varchar(64) NOT NULL COMMENT '流水号（作废）',
  `flag` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_batch_serial` */

insert  into `t_batch_serial`(`batchno`,`serialno`,`serialno_park`,`flag`) values ('000108','000063','000718',0);

/*Table structure for table `t_billindex` */

DROP TABLE IF EXISTS `t_billindex`;

CREATE TABLE `t_billindex` (
  `id` varchar(64) NOT NULL,
  `bill_cardoff` int(11) NOT NULL COMMENT '卡折扣率',
  `bill_cashoff` int(11) NOT NULL COMMENT '现金折扣率',
  `bill_gracetime` int(11) NOT NULL COMMENT '宽限时长',
  `bill_memberoff` int(11) NOT NULL COMMENT '会员折扣率',
  `bill_name` varchar(255) DEFAULT NULL COMMENT '计费规则名称',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(255) DEFAULT NULL COMMENT '创建人',
  `dbStatus` int(11) NOT NULL COMMENT '数据状态',
  `fi_agentid` varchar(255) DEFAULT NULL COMMENT '归属运营商id',
  `updatedTime` datetime DEFAULT NULL COMMENT '最后更新时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '最后更新人',
  `cycle` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_billindex` */

insert  into `t_billindex`(`id`,`bill_cardoff`,`bill_cashoff`,`bill_gracetime`,`bill_memberoff`,`bill_name`,`createdTime`,`creater`,`dbStatus`,`fi_agentid`,`updatedTime`,`updater`,`cycle`) values ('7675fbf3-2973-4440-bfdc-de00bd602717',0,0,0,0,'H停车场计费','2017-03-28 17:45:39',NULL,0,'','2017-03-28 17:45:39',NULL,0),('d2ecf564-da79-4590-9263-fe13ed15d48c',0,0,0,0,'活动规则','2017-03-31 16:15:13',NULL,0,'','2017-03-31 16:15:13',NULL,0);

/*Table structure for table `t_billing` */

DROP TABLE IF EXISTS `t_billing`;

CREATE TABLE `t_billing` (
  `id` varchar(64) NOT NULL,
  `cartype` int(11) NOT NULL,
  `dayBegintime` varchar(255) DEFAULT NULL,
  `daycycletime1` int(11) NOT NULL,
  `daycycletime2` int(11) NOT NULL,
  `daycycletime3` int(11) NOT NULL,
  `daycycletime4` int(11) NOT NULL,
  `dayendtime` varchar(255) DEFAULT NULL,
  `daypaylimit` double NOT NULL,
  `daypayonce` double NOT NULL,
  `daypreamt` double NOT NULL,
  `dayprice1` double NOT NULL,
  `dayprice2` double NOT NULL,
  `dayprice3` double NOT NULL,
  `dayprice4` double NOT NULL,
  `daytype` int(11) NOT NULL,
  `dayunittime1` int(11) NOT NULL,
  `dayunittime2` int(11) NOT NULL,
  `dayunittime3` int(11) NOT NULL,
  `dayunittime4` int(11) NOT NULL,
  `dbStatus` int(11) NOT NULL,
  `freetime` int(11) NOT NULL,
  `nightbegintime` varchar(255) DEFAULT NULL,
  `nightcycletime1` int(11) NOT NULL,
  `nightcycletime2` int(11) NOT NULL,
  `nightcycletime3` int(11) NOT NULL,
  `nightcycletime4` int(11) NOT NULL,
  `nightendtime` varchar(255) DEFAULT NULL,
  `nightpaylimit` double NOT NULL,
  `nightpayonce` double NOT NULL,
  `nightpreamt` double NOT NULL,
  `nightprice1` double NOT NULL,
  `nightprice2` double NOT NULL,
  `nightprice3` double NOT NULL,
  `nightprice4` double NOT NULL,
  `nighttype` int(11) NOT NULL,
  `nightunittime1` int(11) NOT NULL,
  `nightunittime2` int(11) NOT NULL,
  `nightunittime3` int(11) NOT NULL,
  `nightunittime4` int(11) NOT NULL,
  `paylimit` double NOT NULL,
  `paymonth` double NOT NULL,
  `spefreetime` int(11) NOT NULL,
  `billingindex_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_j4amw26apkdiqlyuttw5e97bf` (`billingindex_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_billing` */

/*Table structure for table `t_billing_common` */

DROP TABLE IF EXISTS `t_billing_common`;

CREATE TABLE `t_billing_common` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `common_id` varchar(64) NOT NULL,
  `start_hour` int(11) DEFAULT NULL,
  `start_minute` int(11) DEFAULT NULL,
  `start_seconds` int(11) DEFAULT NULL,
  `end_hour` int(11) DEFAULT NULL,
  `end_minute` int(11) DEFAULT NULL,
  `end_seconds` int(11) DEFAULT NULL,
  `cost_limit` double DEFAULT NULL,
  `extra_billing_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`,`common_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_billing_common` */

insert  into `t_billing_common`(`id`,`common_id`,`start_hour`,`start_minute`,`start_seconds`,`end_hour`,`end_minute`,`end_seconds`,`cost_limit`,`extra_billing_id`) values (3,'f1abf964-5347-499f-819a-4bb116366e28',7,0,0,0,0,0,2000,'7699b260-5321-4b7a-aa44-6b8e2f27a269'),(6,'2265c09e-7223-4c66-a119-d86a25829b98',0,0,0,0,0,0,4000,'9cebc9a4-a1e4-4109-be80-d0268e3dde36'),(7,'e844f5d4-53f2-48f8-a57d-59ae4bd19b31',0,0,0,7,0,0,1000,'7699b260-5321-4b7a-aa44-6b8e2f27a269'),(8,'ee7c32a0-176a-44bc-8da0-f2623aec97de',18,0,0,0,0,0,0,'7699b260-5321-4b7a-aa44-6b8e2f27a268'),(9,'e7de2a31-1cd5-47a5-ad49-f9448037496a',0,0,0,6,0,0,0,'7699b260-5321-4b7a-aa44-6b8e2f27a268'),(11,'a051a897-9e0a-43be-9eb4-71163f1f1251',0,0,0,0,0,0,500,'25ae56b9-7139-4ed4-a460-00e593e6cbc1'),(12,'195b7fb4-98a9-4cff-9688-5678b691c198',0,0,0,0,0,0,400,'b3e5ceff-66da-46d8-86da-bed070200800');

/*Table structure for table `t_billing_detail` */

DROP TABLE IF EXISTS `t_billing_detail`;

CREATE TABLE `t_billing_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cycle` int(11) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `unit_cost` double DEFAULT NULL,
  `is_reuse` tinyint(1) DEFAULT NULL,
  `billing_common_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

/*Data for the table `t_billing_detail` */

insert  into `t_billing_detail`(`id`,`cycle`,`duration`,`unit_cost`,`is_reuse`,`billing_common_id`) values (6,60,1440,500,1,'2265c09e-7223-4c66-a119-d86a25829b98'),(20,420,420,1000,1,'e844f5d4-53f2-48f8-a57d-59ae4bd19b31'),(22,360,360,500,1,'ee7c32a0-176a-44bc-8da0-f2623aec97de'),(23,360,360,500,1,'e7de2a31-1cd5-47a5-ad49-f9448037496a'),(27,60,1020,200,1,'f1abf964-5347-499f-819a-4bb116366e28'),(29,60,60,500,1,'f1abf964-5347-499f-819a-4bb116366e29'),(30,660,660,500,1,'f1abf964-5347-499f-819a-4bb116366e29'),(31,60,60,500,1,'f1abf964-5347-499f-819a-4bb116366e29'),(34,660,660,500,1,'f1abf964-5347-499f-819a-4bb116366e29'),(39,120,120,100,1,'a051a897-9e0a-43be-9eb4-71163f1f1251'),(40,60,1320,200,1,'a051a897-9e0a-43be-9eb4-71163f1f1251'),(41,60,1440,100,1,'195b7fb4-98a9-4cff-9688-5678b691c198');

/*Table structure for table `t_carttype_forbidden` */

DROP TABLE IF EXISTS `t_carttype_forbidden`;

CREATE TABLE `t_carttype_forbidden` (
  `id` varchar(64) NOT NULL,
  `carnotype` int(11) DEFAULT NULL,
  `gate_id` varchar(64) DEFAULT NULL,
  `parkno` varchar(64) DEFAULT NULL,
  `startime` varchar(64) DEFAULT NULL,
  `endtime` varchar(64) DEFAULT NULL,
  `inaccepted` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_carttype_forbidden` */

insert  into `t_carttype_forbidden`(`id`,`carnotype`,`gate_id`,`parkno`,`startime`,`endtime`,`inaccepted`) values ('75e30f8e-a25a-4cb5-975c-502eb8c56198',0,'69b78cf3-e2b8-4b49-b6d8-1d9204461f7e','hzcl','0:0:0','0:0:0',0),('a7861512-f5f7-456a-96d0-33ea9fef1176',3,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f','hzcl','0:0:0','9:0:0',0),('ba5efd91-4660-4341-84dc-d731fced88a6',2,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f','hzcl','0:0:0','0:0:0',0),('c5d171d5-a57d-4b28-ae76-57c140c9d2b8',0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f','hzcl','0:0:0','0:0:0',0);

/*Table structure for table `t_datadict` */

DROP TABLE IF EXISTS `t_datadict`;

CREATE TABLE `t_datadict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(30) DEFAULT NULL,
  `key1` varchar(30) DEFAULT NULL,
  `value` varchar(30) DEFAULT '',
  `order_num` int(11) DEFAULT '0',
  `dbstatus` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

/*Data for the table `t_datadict` */

insert  into `t_datadict`(`id`,`category`,`key1`,`value`,`order_num`,`dbstatus`) values (1,'logon','1','上班',1,1),(2,'subtype','21','商圈',6,1),(3,'sex','0','男',1,1),(4,'cameraBrand','Signaltone','XLT',1,0),(5,'sex','1','女',2,1),(6,'role','11','分管理员',1,1),(7,'role','1','普通员工',2,1),(8,'cameraBrand','Uniview','YS',2,0),(9,'cameraBrand','YanTai','YT',3,0),(10,'cameraBrand','ZS','ZS',4,0),(11,'cameraBrand','ZXYD','ZXYD',5,0),(12,'cameraBrand','DH','DH',6,0),(13,'ledBrand','Socket','DSGD',0,0),(14,'ledBrand','AllInOne','FRTK',1,0),(15,'subtype','22','景区',7,1),(16,'violateUser','00','低保人员',1,0),(17,'violateUser','01','黑名单人员',2,0),(18,'violateUser','02','违章车辆',3,0),(19,'violateUser','03','法院控制人员',4,0),(20,'violateUser','04','老赖车人员',5,0),(21,'comparisonNum','1','1',1,1),(22,'comparisonNum','2','2',2,1),(23,'comparisonNum','3','3',3,1),(24,'comparisonNum','4','4',4,1),(25,'comparisonNum','5','5',5,1),(26,'comparisonNum','6','6',6,1),(27,'comparisonNum','7','7',7,1),(28,'subtype','23','宾馆',8,1),(29,'isused','0','启用',1,0),(30,'isused','1','未启用',2,0),(31,'subtype','24','酒店',9,1),(32,'induceled','EQ2013Led','EQ2013',1,0),(33,'subtype','25','政府',10,1),(34,'subtype','26','小区',11,1),(35,'subtype','27','园区',12,1),(36,'subtype','28','写字楼',13,1),(37,'dbstatus','-1','逻辑删除记录',1,1),(38,'dbstatus','0','正常记录',2,1),(39,'logon','2','下班',2,1),(40,'gatetype','0','入口',1,1),(41,'actiontype','1','立即显示',1,0),(42,'actiontype','3','连续左移',3,0),(43,'posttype','0','单通道',0,1),(44,'posttype','1','双通道',0,1),(45,'gatetype','1','出口',2,1),(46,'fontbold','0','细',1,0),(47,'fontbold','1','粗',2,0),(48,'inaccepted','0','自动确认',1,1),(49,'confirmed','0','未确认',1,1),(50,'confirmed','1','已确认',2,1),(51,'inaccepted','1','手动确认',2,1),(52,'outaccepted','0','自动确认',1,1),(53,'outaccepted','1','手动确认',2,1),(54,'paytype','000','现金',1,1),(55,'paytype','050','一卡通',2,1),(56,'paytype','300','自助缴费',3,1),(57,'paytype','600','预充值',4,1),(58,'type','1','路边',1,1),(59,'paytype','700','小时卡',5,1),(60,'zonelevel','00','Ⅰ级',1,0),(61,'zonelevel','01','Ⅱ级',2,0),(62,'cartypeno','3','会员卡',1,1),(63,'cartypeno','0','临时车',2,1),(64,'ischecked','0','未确认',1,1),(65,'ischecked','1','已确认',2,1),(66,'paytype','800','VIP卡',6,1),(67,'paytype','900','储值卡',6,1),(68,'cartypeno','2','储值卡',3,1),(69,'type','2','路外',2,1),(70,'exceptTraceDict','0004','储值卡余额不足',2,0),(71,'subtype','11','收费',1,1),(72,'daytype','0','按次数计费',1,1),(73,'daytype','1','按计时',2,1),(74,'daytype','2','按时阶梯计费',3,1),(75,'daytype','3','包月（自然月）',4,1),(76,'daytype','8','免费',5,1),(77,'enableVideoDiskRecorder','1','启用',1,1),(78,'enableVideoDiskRecorder','0','不启用',2,1),(79,'subtype','12','党政机关',2,1),(80,'nighttype','0','按次数计费',1,1),(81,'nighttype','1','按计时',2,1),(82,'nighttype','2','按时阶梯计费',3,1),(83,'nighttype','3','包月（自然月）',4,1),(84,'nighttype','8','免费',5,1),(85,'cartype','0','小型车',1,1),(86,'cartype','1','中型车',2,1),(87,'cartype','2','大型车',3,1),(88,'cartype','3','其它',4,1),(89,'subtype','13','单位个人',3,1),(90,'sendflag','0','未上传',1,1),(91,'sendflag','1','已上传',2,1),(92,'outaccepted','2','免费/异常放行',3,1),(93,'subtype','14','免费',4,1),(94,'subtype','15','分时免费',5,1),(95,'exceptTraceDict','0005','临时车实收应收不等',1,0),(96,'exceptTraceDict','0001','车牌自动识别失败',3,0),(97,'exceptTraceDict','0002','未找到入场记录',5,0),(98,'exceptTraceDict','0003','会员过期',4,0),(99,'supplementType','00','不补时',1,0),(100,'supplementType','01','向前补时',2,0),(101,'supplementType','02','向后补时',3,0),(102,'chargeType','01','分时段计费',1,0),(103,'chargeType','02','按时计费',2,0),(104,'chargeType','03','按次计费',3,0),(105,'reduceType','01','本次全免',1,0),(106,'reduceType','02','当天全免',2,0),(107,'reduceType','03','减免时长',3,0),(108,'reduceType','04','减免费用',4,0),(109,'reduceType','05','打折',5,0),(110,'reduceType','06','优惠计费规则',6,0);

/*Table structure for table `t_extra_billing` */

DROP TABLE IF EXISTS `t_extra_billing`;

CREATE TABLE `t_extra_billing` (
  `id` varchar(64) NOT NULL,
  `cartype` varchar(10) DEFAULT NULL,
  `rule` longtext,
  `remark` text,
  `free_time` int(11) DEFAULT NULL,
  `billingindex_id` varchar(64) DEFAULT NULL,
  `day_cost_limit` double DEFAULT NULL,
  `supplement_type` varchar(10) DEFAULT NULL,
  `charge_type` varchar(10) DEFAULT NULL,
  `cost_limit` double DEFAULT NULL,
  `is_naturalday` tinyint(1) DEFAULT NULL,
  `is_drools` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_extra_billing` */

insert  into `t_extra_billing`(`id`,`cartype`,`rule`,`remark`,`free_time`,`billingindex_id`,`day_cost_limit`,`supplement_type`,`charge_type`,`cost_limit`,`is_naturalday`,`is_drools`) values ('25ae56b9-7139-4ed4-a460-00e593e6cbc1','0','','',2,'d2ecf564-da79-4590-9263-fe13ed15d48c',0,NULL,'02',0,0,0),('7699b260-5321-4b7a-aa44-6b8e2f27a269','0','','每小时1元，每天10元封顶',30,'7675fbf3-2973-4440-bfdc-de00bd602717',0,NULL,'01',0,1,0),('9cebc9a4-a1e4-4109-be80-d0268e3dde36','2','1','',3,'7675fbf3-2973-4440-bfdc-de00bd602717',0,NULL,'02',0,0,0),('a8125d33-7f4e-4759-8fb7-82f1b0a6348e','1','',NULL,30,'7675fbf3-2973-4440-bfdc-de00bd602717',0,NULL,'01',0,0,1),('b3e5ceff-66da-46d8-86da-bed070200800','2','','',2,'d2ecf564-da79-4590-9263-fe13ed15d48c',0,NULL,'02',0,0,0);

/*Table structure for table `t_gateinfo` */

DROP TABLE IF EXISTS `t_gateinfo`;

CREATE TABLE `t_gateinfo` (
  `id` varchar(64) NOT NULL,
  `cameraIp` varchar(255) DEFAULT NULL COMMENT '摄相机IP地址',
  `camera_brand` varchar(100) DEFAULT NULL COMMENT '摄像机品牌',
  `dbStatus` int(11) NOT NULL COMMENT '摄像机状态',
  `gatename` varchar(255) DEFAULT NULL COMMENT '通道名称',
  `gateno` varchar(255) DEFAULT NULL COMMENT '通道编号',
  `gatetype` varchar(255) DEFAULT NULL COMMENT '通道类型（0入口、1出口）',
  `remark` varchar(255) DEFAULT NULL,
  `videoChannelNum` varchar(255) DEFAULT NULL,
  `parkno_id` varchar(64) DEFAULT NULL COMMENT '停车场编号',
  `ordernum` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `led_brand` varchar(100) DEFAULT NULL COMMENT 'led卡品牌',
  `ledip` varchar(100) DEFAULT NULL COMMENT 'led屏ip地址',
  `zone_id` varchar(64) DEFAULT NULL COMMENT '停车场区域编号id',
  `gategroup` varchar(64) DEFAULT NULL COMMENT '通道分组',
  `post_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_88au381hlkfx501i72rt0eylj` (`parkno_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_gateinfo` */

insert  into `t_gateinfo`(`id`,`cameraIp`,`camera_brand`,`dbStatus`,`gatename`,`gateno`,`gatetype`,`remark`,`videoChannelNum`,`parkno_id`,`ordernum`,`led_brand`,`ledip`,`zone_id`,`gategroup`,`post_id`) values ('00d063ca-41b8-11e7-bf98-ac853dae8834','',NULL,0,'bbbbbbbb','',NULL,NULL,NULL,'hzcl',5,NULL,'','5110dccc-41bb-11e7-bf98-ac853dae8834','','b8bbf294-41bb-11e7-bf98-ac853dae8834'),('69b78cf3-e2b8-4b49-b6d8-1d9204461f7e','192.168.100.40','ZXYD',0,'入口','','0',NULL,NULL,'hzcl',1,NULL,'','a174b6cd-3202-44e7-9a21-c62367796df7','','4753cf21-4db0-4c68-a370-fc0839da668f'),('824f8f39-48bb-4b9d-ba95-0d19b7e2f75c','192.168.100.40','ZXYD',0,'口口口口','2','0',NULL,NULL,'hzcl',2,'AllInOne','ledip','5110dccc-41bb-11e7-bf98-ac853dae8834','grop','4753cf21-4db0-4c68-a370-fc0839da668f'),('824f8f39-48bb-4b9d-ba95-0d19b7e2f75f','192.168.100.31','ZXYD',0,'出口','','1',NULL,NULL,'hzcl',3,NULL,'','a174b6cd-3202-44e7-9a21-c62367796df7','','4753cf21-4db0-4c68-a370-fc0839da668f'),('f9b067ba-7ba4-4c0f-ba86-47b7a5654df8','','Signaltone',0,'通道1','1','1',NULL,NULL,'hzcl',4,NULL,'','a174b6cd-3202-44e7-9a21-c62367796df7','','4753cf21-4db0-4c68-a370-fc0839da668f');

/*Table structure for table `t_inlog` */

DROP TABLE IF EXISTS `t_inlog`;

CREATE TABLE `t_inlog` (
  `id` varchar(64) NOT NULL,
  `carid` int(11) NOT NULL,
  `carno` varchar(255) DEFAULT NULL,
  `carnocolor` varchar(255) DEFAULT NULL,
  `confirmed` int(1) NOT NULL DEFAULT '0',
  `createdTime` datetime DEFAULT NULL,
  `creater` varchar(255) DEFAULT NULL,
  `inaccepted` int(11) DEFAULT NULL,
  `inopertiontime` datetime DEFAULT NULL,
  `inopertiontypename` varchar(255) DEFAULT NULL,
  `inphoto` varchar(255) DEFAULT NULL,
  `insmallphoto` varchar(255) DEFAULT NULL,
  `intime` datetime DEFAULT NULL,
  `sendflag` int(11) NOT NULL DEFAULT '0',
  `ingateno_id` varchar(64) DEFAULT NULL,
  `parkno_id` varchar(64) DEFAULT NULL,
  `batchno` varchar(64) DEFAULT NULL,
  `serialno` int(11) NOT NULL AUTO_INCREMENT,
  `confidence` double NOT NULL,
  `sendcount` int(11) DEFAULT NULL,
  `nocarno` int(11) DEFAULT NULL,
  `zone_id` varchar(64) DEFAULT NULL,
  `zk_sendflag` int(1) DEFAULT '0' COMMENT '中科进场图片上传标识',
  PRIMARY KEY (`id`),
  KEY `FK_qesnpkbuiq6eccrmrx8brkkbe` (`ingateno_id`) USING BTREE,
  KEY `FK_ppmjltw2jy5jf3dfsuecnuk0m` (`parkno_id`) USING BTREE,
  KEY `FK_serialno` (`serialno`) USING BTREE,
  KEY `idx_inlog1` (`createdTime`,`confirmed`,`zone_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_inlog` */

/*Table structure for table `t_inlog_history` */

DROP TABLE IF EXISTS `t_inlog_history`;

CREATE TABLE `t_inlog_history` (
  `id` varchar(64) NOT NULL,
  `carid` int(11) NOT NULL,
  `carno` varchar(255) DEFAULT NULL,
  `carnocolor` varchar(255) DEFAULT NULL,
  `confirmed` tinyint(1) NOT NULL DEFAULT '0',
  `createdTime` datetime DEFAULT NULL,
  `creater` varchar(255) DEFAULT NULL,
  `inaccepted` int(11) NOT NULL,
  `inopertiontime` datetime DEFAULT NULL,
  `inopertiontypename` varchar(255) DEFAULT NULL,
  `inphoto` varchar(255) DEFAULT NULL,
  `insmallphoto` varchar(255) DEFAULT NULL,
  `intime` datetime DEFAULT NULL,
  `sendflag` int(11) NOT NULL DEFAULT '0',
  `ingateno_id` varchar(64) DEFAULT NULL,
  `parkno_id` varchar(64) DEFAULT NULL,
  `batchno` varchar(64) DEFAULT NULL,
  `serialno` int(11) DEFAULT NULL,
  `confidence` double NOT NULL,
  `sendcount` int(11) DEFAULT NULL,
  `nocarno` int(11) DEFAULT NULL,
  `zone_id` varchar(64) DEFAULT NULL,
  `zk_sendflag` int(1) DEFAULT '0' COMMENT '中科进场图片上传标识',
  PRIMARY KEY (`id`),
  KEY `FK_qesnpkbuiq6eccrmrx8brkkbe` (`ingateno_id`) USING BTREE,
  KEY `FK_ppmjltw2jy5jf3dfsuecnuk0m` (`parkno_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_inlog_history` */

insert  into `t_inlog_history`(`id`,`carid`,`carno`,`carnocolor`,`confirmed`,`createdTime`,`creater`,`inaccepted`,`inopertiontime`,`inopertiontypename`,`inphoto`,`insmallphoto`,`intime`,`sendflag`,`ingateno_id`,`parkno_id`,`batchno`,`serialno`,`confidence`,`sendcount`,`nocarno`,`zone_id`,`zk_sendflag`) values ('62afea67-8b1d-488c-9f14-8289ac9fa9ff',0,'无车牌','蓝',0,'2017-05-11 10:27:50','hzcluser',0,'2017-05-11 10:26:44','01','D:\\flypark_image\\2017\\5\\11/鄂A065BT-2017-05-11-10-26-42-b.jpg',NULL,'2017-05-11 10:26:42',0,'69b78cf3-e2b8-4b49-b6d8-1d9204461f7e','hzcl','000070',2,0,NULL,NULL,'a174b6cd-3202-44e7-9a21-c62367796df7',0),('83d56bb8-bd8d-4088-a6e3-b23730008297',0,'无车牌','蓝',0,'2017-05-08 16:56:23','hzcluser',0,'2017-05-08 16:55:22','01','D:\\flypark_image\\2017\\5\\8/无车牌-2017-05-08-16-55-19-b.jpg',NULL,'2017-05-08 16:55:19',0,'69b78cf3-e2b8-4b49-b6d8-1d9204461f7e','hzcl','000069',1,0,NULL,NULL,'a174b6cd-3202-44e7-9a21-c62367796df7',0);

/*Table structure for table `t_manualopen` */

DROP TABLE IF EXISTS `t_manualopen`;

CREATE TABLE `t_manualopen` (
  `id` varchar(64) NOT NULL,
  `createdTime` datetime DEFAULT NULL,
  `creater` varchar(255) DEFAULT NULL,
  `opentype` int(11) NOT NULL,
  `photopath` varchar(255) DEFAULT NULL,
  `gateno_id` varchar(64) DEFAULT NULL,
  `parkno_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_p88xgn4fj5maiyn43lqvnltni` (`gateno_id`) USING BTREE,
  KEY `FK_iiy790ikljsftmjpuvtiqlcgh` (`parkno_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_manualopen` */

insert  into `t_manualopen`(`id`,`createdTime`,`creater`,`opentype`,`photopath`,`gateno_id`,`parkno_id`) values ('331a51be-c187-413f-a5c5-30fbaa7165a7','2017-05-08 16:56:20','hzcluser',1,'D:\\flypark_image\\2017\\5\\8/无车牌-2017-05-08-16-56-20-b.jpg','824f8f39-48bb-4b9d-ba95-0d19b7e2f75f','hzcl'),('c07c8ef2-4202-474a-8944-0483286da27d','2017-05-08 16:56:22','hzcluser',1,'D:\\flypark_image\\2017\\5\\8/无车牌-2017-05-08-16-56-22-b.jpg','824f8f39-48bb-4b9d-ba95-0d19b7e2f75f','hzcl'),('c477c06c-447f-4b6a-9e9d-c9d9699e2e60','2017-04-21 13:47:47','hzcluser',0,'D:\\flypark_image\\2017\\4\\21/无车牌-2017-04-21-13-47-47-b.jpg','69b78cf3-e2b8-4b49-b6d8-1d9204461f7e','hzcl'),('d00f00b9-2663-4a2a-bfe9-c1170ecd10bb','2017-05-11 10:26:53','hzcluser',1,'D:\\flypark_image\\2017\\5\\11/无车牌-2017-05-11-10-26-53-b.jpg','824f8f39-48bb-4b9d-ba95-0d19b7e2f75f','hzcl');

/*Table structure for table `t_member_car` */

DROP TABLE IF EXISTS `t_member_car`;

CREATE TABLE `t_member_car` (
  `id` varchar(64) NOT NULL,
  `balance` double DEFAULT NULL,
  `cargroupno` int(11) DEFAULT NULL,
  `carno` varchar(255) DEFAULT NULL,
  `province` varchar(2) DEFAULT NULL,
  `nopronum` varchar(32) DEFAULT NULL,
  `carnocolor` varchar(64) DEFAULT NULL,
  `carowner` varchar(255) DEFAULT NULL,
  `cartype` varchar(255) DEFAULT NULL,
  `cartypeno` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `creater` varchar(255) DEFAULT NULL,
  `dbStatus` int(11) NOT NULL,
  `drivelicenseno` varchar(255) DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `mem_origion_type` int(11) DEFAULT '3',
  `sendflag` int(11) DEFAULT '0',
  `starttime` datetime DEFAULT NULL,
  `telno` varchar(255) DEFAULT NULL,
  `updatedTime` datetime DEFAULT NULL,
  `updater` varchar(255) DEFAULT NULL,
  `parkno_id` varchar(64) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `verrecno` bigint(20) DEFAULT NULL,
  `alarm_type` varchar(64) DEFAULT NULL,
  `member_grade` varchar(64) DEFAULT NULL,
  `zone_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3iy5a4ow8igu6tiaxf08y2dkv` (`parkno_id`) USING BTREE,
  KEY `idx_membercar1` (`nopronum`,`zone_id`,`dbStatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_member_car` */

insert  into `t_member_car`(`id`,`balance`,`cargroupno`,`carno`,`province`,`nopronum`,`carnocolor`,`carowner`,`cartype`,`cartypeno`,`code`,`createdTime`,`creater`,`dbStatus`,`drivelicenseno`,`endtime`,`mem_origion_type`,`sendflag`,`starttime`,`telno`,`updatedTime`,`updater`,`parkno_id`,`remark`,`verrecno`,`alarm_type`,`member_grade`,`zone_id`) values ('092d768845ce11e7bf98ac853dae8834',0,0,'adasd',NULL,NULL,'蓝','lzc','0',0,NULL,NULL,NULL,0,NULL,'2017-05-31 14:55:04',3,0,'2017-05-31 14:55:04','13035143830',NULL,NULL,NULL,NULL,0,NULL,NULL,'qyid4e386f99-0967-4691-8c7e-d8fe93343012'),('4827674e-c576-48ec-bf77-4f116c1a3343',0,NULL,'鄂ACF015','鄂','ACF015','蓝','张三8','0',3,NULL,'2017-05-31 12:08:05','hzcluser',0,NULL,'2017-09-06 00:00:00',3,0,'2017-05-30 00:00:00','15000000007','2017-05-31 12:08:13','hzcluser','hzcl',NULL,NULL,NULL,NULL,'4303a5d8-68c1-45bf-a47e-5d6d994c513b'),('4c33ba8e-9d0e-44bd-9aff-f85606164718',0,NULL,'鄂ACF016','鄂','ACF016','黄','张三9','2',3,NULL,'2017-05-31 12:08:05','hzcluser',0,NULL,'2017-09-06 00:00:00',3,0,'2017-05-30 00:00:00','15000000008','2017-05-31 12:08:13','hzcluser','hzcl',NULL,NULL,NULL,NULL,'4303a5d8-68c1-45bf-a47e-5d6d994c513b'),('6625aca5-028d-4369-b101-e759d88a5dd0',0,NULL,'鄂ACF008','鄂','ACF008','蓝','张三1','0',3,NULL,'2017-05-31 12:08:05','hzcluser',0,NULL,'2017-09-06 00:00:00',3,0,'2017-05-30 00:00:00','15000000000','2017-05-31 12:08:12','hzcluser','hzcl',NULL,NULL,NULL,NULL,'4303a5d8-68c1-45bf-a47e-5d6d994c513b'),('75e5f247-3ef5-41ad-8bf3-a2dab9d1b111',0,NULL,'鄂ACF012','鄂','ACF012','黄','张三5','2',3,NULL,'2017-05-31 12:08:05','hzcluser',0,NULL,'2017-09-06 00:00:00',3,0,'2017-05-30 00:00:00','15000000004','2017-05-31 12:08:13','hzcluser','hzcl',NULL,NULL,NULL,NULL,'4303a5d8-68c1-45bf-a47e-5d6d994c513b'),('90ada7e1-44d1-4b9f-99b4-5e8fa0cdad14',0,NULL,'鄂ACF010','鄂','ACF010','蓝','张三3','0',3,NULL,'2017-05-31 12:08:05','hzcluser',0,NULL,'2017-09-06 00:00:00',3,0,'2017-05-30 00:00:00','15000000002','2017-05-31 12:08:12','hzcluser','hzcl',NULL,NULL,NULL,NULL,'4303a5d8-68c1-45bf-a47e-5d6d994c513b'),('9ba8ce49-3d0f-4f6d-8e30-ce027da59f3f',0,NULL,'鄂ACF011','鄂','ACF011','黄','张三4','2',3,NULL,'2017-05-31 12:08:05','hzcluser',0,NULL,'2017-09-06 00:00:00',3,0,'2017-05-30 00:00:00','15000000003','2017-05-31 12:08:13','hzcluser','hzcl',NULL,NULL,NULL,NULL,'4303a5d8-68c1-45bf-a47e-5d6d994c513b'),('a9ad16db-23f9-4e28-a358-1cafbbe31e01',0,NULL,'鄂ACF998','鄂','ACF998','蓝','张三','0',3,NULL,'2017-05-31 12:07:40','hzcluser',0,NULL,'2016-09-06 00:00:00',3,0,'2016-01-23 00:00:00','15000000000','2017-05-31 12:07:45','hzcluser','hzcl',NULL,NULL,NULL,NULL,'5110dccc-41bb-11e7-bf98-ac853dae8834'),('b2b6234a-2967-4682-9407-45cb51497112',0,NULL,'鄂ACF014','鄂','ACF014','蓝','张三7','0',3,NULL,'2017-05-31 12:08:05','hzcluser',0,NULL,'2017-09-06 00:00:00',3,0,'2017-05-30 00:00:00','15000000006','2017-05-31 12:08:13','hzcluser','hzcl',NULL,NULL,NULL,NULL,'4303a5d8-68c1-45bf-a47e-5d6d994c513b'),('c030616c-5478-4cfb-99a0-45203122a64b',0,NULL,'鄂ACF013','鄂','ACF013','蓝','张三6','0',3,NULL,'2017-05-31 12:08:05','hzcluser',0,NULL,'2017-09-06 00:00:00',3,0,'2017-05-30 00:00:00','15000000005','2017-05-31 12:08:13','hzcluser','hzcl',NULL,NULL,NULL,NULL,'4303a5d8-68c1-45bf-a47e-5d6d994c513b'),('c8282681-34bb-43c6-bdd6-a12b81d1bc11',100,0,'沪BED345','沪','BED345','蓝','储值卡','0',2,'','2017-04-01 10:04:50','hzcluser',0,'','2017-03-31 00:00:00',3,0,'2017-03-30 00:00:00','','2017-04-01 10:23:52','hzcluser','hzcl',NULL,NULL,NULL,NULL,'a174b6cd-3202-44e7-9a21-c62367796df7'),('f0b81aba45cb11e7bf98ac853dae8834',0,0,'鄂ACF017',NULL,NULL,'黄','张三10','2',0,NULL,NULL,NULL,0,NULL,'2017-11-06 00:00:00',3,0,'2017-05-30 00:00:00','15000000009',NULL,NULL,NULL,NULL,0,NULL,NULL,'4303a5d8-68c1-45bf-a47e-5d6d994c513b');

/*Table structure for table `t_member_charge` */

DROP TABLE IF EXISTS `t_member_charge`;

CREATE TABLE `t_member_charge` (
  `id` varchar(64) NOT NULL,
  `carno` varchar(255) DEFAULT NULL,
  `carowner` varchar(255) DEFAULT NULL,
  `cartypeno` int(11) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `chargemoney` double DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `chargesource` varchar(100) DEFAULT NULL,
  `operaterid` varbinary(64) DEFAULT NULL,
  `zone_id` varchar(64) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_member_charge` */

insert  into `t_member_charge`(`id`,`carno`,`carowner`,`cartypeno`,`balance`,`chargemoney`,`createTime`,`starttime`,`endtime`,`chargesource`,`operaterid`,`zone_id`,`remark`) values ('004a6d1b-1976-442e-89bb-6ccf25ef3c2e','鄂ACF016','张三9',3,0,0,'2017-05-31 12:08:09','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('0d221e96-4acf-451b-b929-88e454b9ddf3','鄂ACF013','张三6',3,0,0,'2017-05-31 12:08:17','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('2385e533-73a9-4815-af4f-035b4a391e11','鄂ACF014','张三7',3,0,0,'2017-05-31 12:08:17','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('24490712-7bf0-45d8-b12b-02a18cc84449','鄂ACF017','张三10',3,0,0,'2017-05-31 12:08:17','2017-05-30 00:00:00','2017-11-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('25069b1a-b3ad-487d-945a-1da937486ec8','鄂ACF016','张三9',3,0,0,'2017-05-31 12:08:17','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('2999d5fa-86f3-4d63-aa0e-6f8b1c008a41','鄂ACF012','张三5',3,0,0,'2017-05-31 12:08:17','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('2f64e419-b56c-4962-bf0f-c907c3a74297','鄂ACF011','张三4',3,0,0,'2017-05-31 12:08:09','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('38040ff6-46ce-4710-a97b-2f704f2d6dd4','鄂ACF010','张三3',3,0,0,'2017-05-31 12:08:17','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('3ba78a4c-7e62-45fd-b74d-11546dcb8dcb','鄂ACF009','张三2',3,0,0,'2017-05-31 12:08:09','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('48eb7303-a261-42ab-a981-7ad351f0a24a','鄂ACF010','张三3',3,0,0,'2017-05-31 12:08:09','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('5e29d9f4-1429-4d9c-bb50-a4af6b0c710c','鄂ACF012','张三5',3,0,0,'2017-05-31 12:08:09','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('71e89641-bb5a-4899-b242-8723d4bae10b','鄂ACF998','张三',3,0,0,'2017-05-31 12:07:50','2016-01-23 00:00:00','2016-09-06 00:00:00','批量导入','hzcluser','5110dccc-41bb-11e7-bf98-ac853dae8834',''),('792317f7-9fbe-4cce-8f38-4cae56c90f47','鄂ACF015','张三8',3,0,0,'2017-05-31 12:08:17','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('7ddaed32-902f-49ad-978f-98b9c740412c','沪BED345','储值卡',2,100,2,'2017-04-01 10:23:26','2017-03-30 00:00:00','2017-03-31 00:00:00','充值缴费','hzcluser','a174b6cd-3202-44e7-9a21-c62367796df7',''),('87b83bc6-ed3b-4346-9ba5-c6b5b6b42767','鄂A77HU3','会员卡',3,0,0,'2017-04-01 09:32:11','2017-04-01 00:00:00','2017-04-30 00:00:00','新增会员缴费','hzcluser','a174b6cd-3202-44e7-9a21-c62367796df7',''),('888595c5-5c39-4516-a167-36448f8da87f','鄂ACF008','张三1',3,0,0,'2017-05-31 12:08:09','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('95f9ddab-0b2d-4104-9983-9eb40fee1fc9','鄂ACF009','张三2',3,0,0,'2017-05-31 12:08:17','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('9ef93f9c-d3a4-4efe-9e15-b6893725af15','鄂BTS209','储值卡',2,0,3,'2017-04-01 10:06:20','2017-03-30 00:00:00','2017-03-31 00:00:00','充值缴费','hzcluser','a174b6cd-3202-44e7-9a21-c62367796df7',''),('b0f4e013-f28f-4a9c-b94a-82b6e9c9887b','鄂ACF017','张三10',3,0,0,'2017-05-31 12:08:09','2017-05-30 00:00:00','2017-11-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('b7719b1d-dee1-412a-8178-3e8b0061d175','鄂ACF998','张三',3,0,0,'2017-05-31 12:07:44','2016-01-23 00:00:00','2016-09-06 00:00:00','批量导入','hzcluser','5110dccc-41bb-11e7-bf98-ac853dae8834',''),('cd96d9af-818c-4a04-8ea9-b2864723dfce','鄂ACF013','张三6',3,0,0,'2017-05-31 12:08:09','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('d19a223d-19b2-48b6-be0d-742626635dc0','鄂ACF014','张三7',3,0,0,'2017-05-31 12:08:09','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('d7f8011d-b3cd-4dda-b5dc-4dfbdb0061a6','鄂BTS209','储值卡',2,0,0,'2017-04-01 10:04:50','2017-03-30 00:00:00','2017-03-31 00:00:00','新增会员缴费','hzcluser','a174b6cd-3202-44e7-9a21-c62367796df7',''),('e0314c26-556a-49df-9f54-11e429a1dc2a','鄂ACF011','张三4',3,0,0,'2017-05-31 12:08:17','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('e79eb1ce-bc7c-4e56-a3c2-f6d9dc5bebff','沪BED345','储值卡',2,300,2,'2017-04-01 10:23:53','2017-03-30 00:00:00','2017-03-31 00:00:00','充值缴费','hzcluser','a174b6cd-3202-44e7-9a21-c62367796df7',''),('ecfa293e-bad9-4736-a7c2-5d7cf24798bf','鄂ACF015','张三8',3,0,0,'2017-05-31 12:08:09','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('edd13f1c-93b6-40ca-bedc-dd1c347d7eca','鄂ACF008','张三1',3,0,0,'2017-05-31 12:08:17','2017-05-30 00:00:00','2017-09-06 00:00:00','批量导入','hzcluser','4303a5d8-68c1-45bf-a47e-5d6d994c513b',''),('f86af2af-8bef-4a60-afc3-0f5248e9d7cb','沪BNT563','会员卡',3,0,0,'2017-04-01 10:18:23','2017-03-01 00:00:00','2017-04-28 00:00:00','会员延期缴费','hzcluser','a174b6cd-3202-44e7-9a21-c62367796df7','');

/*Table structure for table `t_member_extension` */

DROP TABLE IF EXISTS `t_member_extension`;

CREATE TABLE `t_member_extension` (
  `id` varchar(64) NOT NULL,
  `memberId` varchar(64) DEFAULT NULL,
  `img` varchar(225) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `position` varchar(100) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `workNo` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  `address` varchar(225) DEFAULT NULL,
  `origin` varchar(100) DEFAULT NULL,
  `nation` varchar(100) DEFAULT NULL,
  `idCard` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_member_extension` */

insert  into `t_member_extension`(`id`,`memberId`,`img`,`sex`,`position`,`department`,`workNo`,`email`,`birthday`,`address`,`origin`,`nation`,`idCard`) values ('acc7cb9d-a23d-4fc9-a56f-9f84ef084434','a9ad16db-23f9-4e28-a358-1cafbbe31e01',NULL,0,'工程师','事业部','10001','sale@163.com','1989-02-11','武汉市江岸区','武汉','汉','420109198902112356'),('d8ad78c9-40c4-46e3-a8f7-f6e09978fbf3','6625aca5-028d-4369-b101-e759d88a5dd0',NULL,0,'工程师','事业部','10001','sale@163.com','1989-02-11','武汉市江岸区','武汉','汉','420109198902112356');

/*Table structure for table `t_outescapelog` */

DROP TABLE IF EXISTS `t_outescapelog`;

CREATE TABLE `t_outescapelog` (
  `id` varchar(64) NOT NULL,
  `carid` int(11) NOT NULL,
  `carno` varchar(255) DEFAULT NULL,
  `carnocolor` varchar(255) DEFAULT NULL,
  `chargemoney` double NOT NULL,
  `confirmed` tinyint(1) NOT NULL DEFAULT '0',
  `createdTime` datetime DEFAULT NULL,
  `inaccepted` int(11) NOT NULL,
  `increater` varchar(255) DEFAULT NULL,
  `inopertiontime` datetime DEFAULT NULL,
  `inopertiontypename` varchar(255) DEFAULT NULL,
  `inphoto` varchar(255) DEFAULT NULL,
  `insmallphoto` varchar(255) DEFAULT NULL,
  `intime` datetime DEFAULT NULL,
  `outaccepted` int(11) NOT NULL,
  `outcreater` varchar(255) DEFAULT NULL,
  `outopertiontime` datetime DEFAULT NULL,
  `outopertiontypename` varchar(255) DEFAULT NULL,
  `outphoto` varchar(255) DEFAULT NULL,
  `outsmallphoto` varchar(255) DEFAULT NULL,
  `outtime` datetime DEFAULT NULL,
  `paymoney` double NOT NULL,
  `paytype` varchar(10) DEFAULT NULL,
  `sendflag` int(11) NOT NULL DEFAULT '0',
  `ingateno_id` varchar(64) DEFAULT NULL,
  `outgateno_id` varchar(64) DEFAULT NULL,
  `parkno_id` varchar(64) DEFAULT NULL,
  `inlog_batchno` varchar(64) DEFAULT NULL,
  `inlog_serialno` varchar(64) DEFAULT NULL,
  `confidence` double NOT NULL,
  `inconfidence` double NOT NULL,
  `outlog_batchno` varchar(64) DEFAULT NULL,
  `zone_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gppn3pf8x9k5af7vpw4qdr938` (`ingateno_id`) USING BTREE,
  KEY `FK_9htyg20398j2cg4pbbm4rpbxb` (`outgateno_id`) USING BTREE,
  KEY `FK_2w95sj1sgffavhy82egav1b52` (`parkno_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_outescapelog` */

/*Table structure for table `t_outlog` */

DROP TABLE IF EXISTS `t_outlog`;

CREATE TABLE `t_outlog` (
  `id` varchar(64) NOT NULL,
  `carid` int(11) NOT NULL,
  `carno` varchar(255) DEFAULT NULL,
  `carnocolor` varchar(255) DEFAULT NULL,
  `chargemoney` double NOT NULL,
  `confirmed` tinyint(1) NOT NULL DEFAULT '0',
  `createdTime` datetime DEFAULT NULL,
  `inaccepted` int(11) DEFAULT NULL,
  `increater` varchar(255) DEFAULT NULL,
  `inopertiontime` datetime DEFAULT NULL,
  `inopertiontypename` varchar(255) DEFAULT NULL,
  `inphoto` varchar(255) DEFAULT NULL,
  `insmallphoto` varchar(255) DEFAULT NULL,
  `intime` datetime DEFAULT NULL,
  `outaccepted` int(11) NOT NULL,
  `outcreater` varchar(255) DEFAULT NULL,
  `outopertiontime` datetime DEFAULT NULL,
  `outopertiontypename` varchar(255) DEFAULT NULL,
  `outphoto` varchar(255) DEFAULT NULL,
  `outsmallphoto` varchar(255) DEFAULT NULL,
  `outtime` datetime DEFAULT NULL,
  `paymoney` double NOT NULL,
  `paytype` varchar(10) DEFAULT NULL,
  `sendflag` int(11) NOT NULL DEFAULT '0',
  `ingateno_id` varchar(64) DEFAULT NULL,
  `outgateno_id` varchar(64) DEFAULT NULL,
  `parkno_id` varchar(64) DEFAULT NULL,
  `inlog_batchno` varchar(64) DEFAULT NULL,
  `inlog_serialno` varchar(64) DEFAULT NULL,
  `confidence` double NOT NULL,
  `inconfidence` double NOT NULL,
  `outlog_batchno` varchar(64) DEFAULT NULL,
  `outtype` int(11) NOT NULL DEFAULT '0',
  `cartype` int(11) NOT NULL DEFAULT '0',
  `sendcount` int(11) DEFAULT NULL,
  `zone_id` varchar(64) DEFAULT NULL,
  `paymenttype` varchar(64) DEFAULT NULL,
  `reduce_id` varchar(64) DEFAULT NULL,
  `reduce_name` varchar(64) DEFAULT NULL,
  `privilegemoney` double DEFAULT NULL,
  `ismanual` int(11) NOT NULL DEFAULT '0',
  `zk_sendflag` int(1) DEFAULT '0' COMMENT '中科出场图片上传标识',
  PRIMARY KEY (`id`),
  KEY `FK_gppn3pf8x9k5af7vpw4qdr938` (`ingateno_id`) USING BTREE,
  KEY `FK_9htyg20398j2cg4pbbm4rpbxb` (`outgateno_id`) USING BTREE,
  KEY `FK_2w95sj1sgffavhy82egav1b52` (`parkno_id`) USING BTREE,
  KEY `idx_outlog1` (`createdTime`,`outtype`,`zone_id`),
  KEY `idx_outlog2` (`outlog_batchno`,`outgateno_id`,`ingateno_id`),
  KEY `idx_outlog3` (`outlog_batchno`,`outaccepted`,`paytype`,`chargemoney`,`privilegemoney`,`paymoney`),
  KEY `idx_outlog4` (`outtime`,`carno`,`outgateno_id`,`ingateno_id`,`outcreater`),
  KEY `idx_outlog5` (`outgateno_id`,`paytype`,`cartype`,`outopertiontypename`,`paymoney`,`chargemoney`,`privilegemoney`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_outlog` */

/*Table structure for table `t_outlog_central` */

DROP TABLE IF EXISTS `t_outlog_central`;

CREATE TABLE `t_outlog_central` (
  `id` varchar(64) NOT NULL,
  `carid` int(11) NOT NULL,
  `carno` varchar(255) DEFAULT NULL,
  `carnocolor` varchar(255) DEFAULT NULL,
  `chargemoney` double NOT NULL,
  `confirmed` tinyint(1) NOT NULL DEFAULT '0',
  `createdTime` datetime DEFAULT NULL,
  `inaccepted` int(11) DEFAULT NULL,
  `increater` varchar(255) DEFAULT NULL,
  `inopertiontime` datetime DEFAULT NULL,
  `inopertiontypename` varchar(255) DEFAULT NULL,
  `inphoto` varchar(255) DEFAULT NULL,
  `insmallphoto` varchar(255) DEFAULT NULL,
  `intime` datetime DEFAULT NULL,
  `outaccepted` int(11) NOT NULL,
  `outcreater` varchar(255) DEFAULT NULL,
  `outopertiontime` datetime DEFAULT NULL,
  `outopertiontypename` varchar(255) DEFAULT NULL,
  `outphoto` varchar(255) DEFAULT NULL,
  `outsmallphoto` varchar(255) DEFAULT NULL,
  `outtime` datetime DEFAULT NULL,
  `paymoney` double NOT NULL,
  `paytype` varchar(10) DEFAULT NULL,
  `sendflag` int(11) NOT NULL DEFAULT '0',
  `ingateno_id` varchar(64) DEFAULT NULL,
  `outgateno_id` varchar(64) DEFAULT NULL,
  `parkno_id` varchar(64) DEFAULT NULL,
  `inlog_batchno` varchar(64) DEFAULT NULL,
  `inlog_serialno` varchar(64) DEFAULT NULL,
  `confidence` double NOT NULL,
  `inconfidence` double NOT NULL,
  `outlog_batchno` varchar(64) DEFAULT NULL,
  `outtype` int(11) NOT NULL DEFAULT '0',
  `cartype` int(11) NOT NULL DEFAULT '0',
  `sendcount` int(11) DEFAULT NULL,
  `zone_id` varchar(64) DEFAULT NULL,
  `paymenttype` varchar(64) DEFAULT NULL,
  `reduce_id` varchar(64) DEFAULT NULL,
  `reduce_name` varchar(64) DEFAULT NULL,
  `privilegemoney` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gppn3pf8x9k5af7vpw4qdr938` (`ingateno_id`) USING BTREE,
  KEY `FK_9htyg20398j2cg4pbbm4rpbxb` (`outgateno_id`) USING BTREE,
  KEY `FK_2w95sj1sgffavhy82egav1b52` (`parkno_id`) USING BTREE,
  KEY `idx_outlogcentral` (`outlog_batchno`),
  KEY `idx_outlogcentral2` (`intime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_outlog_central` */

/*Table structure for table `t_outlog_history` */

DROP TABLE IF EXISTS `t_outlog_history`;

CREATE TABLE `t_outlog_history` (
  `id` varchar(64) NOT NULL,
  `carid` int(11) NOT NULL,
  `carno` varchar(255) DEFAULT NULL,
  `carnocolor` varchar(255) DEFAULT NULL,
  `chargemoney` double NOT NULL,
  `confirmed` tinyint(1) NOT NULL DEFAULT '0',
  `createdTime` datetime DEFAULT NULL,
  `inaccepted` int(11) NOT NULL,
  `increater` varchar(255) DEFAULT NULL,
  `inopertiontime` datetime DEFAULT NULL,
  `inopertiontypename` varchar(255) DEFAULT NULL,
  `inphoto` varchar(255) DEFAULT NULL,
  `insmallphoto` varchar(255) DEFAULT NULL,
  `intime` datetime DEFAULT NULL,
  `outaccepted` int(11) NOT NULL,
  `outcreater` varchar(255) DEFAULT NULL,
  `outopertiontime` datetime DEFAULT NULL,
  `outopertiontypename` varchar(255) DEFAULT NULL,
  `outphoto` varchar(255) DEFAULT NULL,
  `outsmallphoto` varchar(255) DEFAULT NULL,
  `outtime` datetime DEFAULT NULL,
  `paymoney` double NOT NULL,
  `paytype` varchar(10) DEFAULT NULL,
  `sendflag` int(11) NOT NULL DEFAULT '0',
  `ingateno_id` varchar(64) DEFAULT NULL,
  `outgateno_id` varchar(64) DEFAULT NULL,
  `parkno_id` varchar(64) DEFAULT NULL,
  `inlog_batchno` varchar(64) DEFAULT NULL,
  `inlog_serialno` varchar(64) DEFAULT NULL,
  `confidence` double NOT NULL,
  `inconfidence` double NOT NULL,
  `outlog_batchno` varchar(64) DEFAULT NULL,
  `outtype` int(11) NOT NULL DEFAULT '0',
  `cartype` int(11) NOT NULL DEFAULT '0',
  `sendcount` int(11) DEFAULT NULL,
  `zone_id` varchar(64) DEFAULT NULL,
  `paymenttype` varchar(64) DEFAULT NULL,
  `reduce_id` varchar(64) DEFAULT NULL,
  `reduce_name` varchar(64) DEFAULT NULL,
  `privilegemoney` double DEFAULT NULL,
  `ismanual` int(11) NOT NULL DEFAULT '0',
  `zk_sendflag` int(1) DEFAULT '0' COMMENT '中科出场图片上传标识',
  PRIMARY KEY (`id`),
  KEY `FK_gppn3pf8x9k5af7vpw4qdr938` (`ingateno_id`) USING BTREE,
  KEY `FK_9htyg20398j2cg4pbbm4rpbxb` (`outgateno_id`) USING BTREE,
  KEY `FK_2w95sj1sgffavhy82egav1b52` (`parkno_id`) USING BTREE,
  KEY `idx_outloghis1` (`outlog_batchno`,`outgateno_id`,`ingateno_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_outlog_history` */

/*Table structure for table `t_parkinfo` */

DROP TABLE IF EXISTS `t_parkinfo`;

CREATE TABLE `t_parkinfo` (
  `id` varchar(64) NOT NULL,
  `PARK_BAYNUM` int(11) NOT NULL COMMENT '停车场地磁数量',
  `PARK_FEEINDEX` varchar(255) DEFAULT NULL COMMENT '计费规则索引',
  `PARK_FEEDESC` varchar(255) DEFAULT NULL COMMENT '计费规则描述',
  `PARK_FEELEVEL` int(11) NOT NULL COMMENT '计费分类',
  `PARK_REGIONID` varchar(255) DEFAULT NULL COMMENT '停车场所属行政区域',
  `dbStatus` int(11) NOT NULL COMMENT '停车场状态',
  `enableVideoDiskRecorder` int(11) NOT NULL,
  `freecount` int(11) NOT NULL,
  `latitude` double NOT NULL COMMENT '维度',
  `longitude` double NOT NULL COMMENT '经度',
  `park_agentid` varchar(255) DEFAULT NULL COMMENT '运营商id',
  `park_freetime` int(11) NOT NULL COMMENT '免费时长',
  `park_logon` varchar(255) DEFAULT NULL COMMENT '停车场上班状态',
  `park_subtype` int(11) NOT NULL COMMENT '停车场子类型',
  `park_type` int(11) NOT NULL COMMENT '停车场类型',
  `parkaddress` varchar(255) DEFAULT NULL COMMENT '停车场地址',
  `parkname` varchar(255) DEFAULT NULL COMMENT '停车名称',
  `parkno` varchar(255) DEFAULT NULL COMMENT '停车场编号',
  `parkphoto` varchar(255) DEFAULT NULL COMMENT '停车场图片',
  `remark` varchar(255) DEFAULT NULL,
  `spacecount` int(11) NOT NULL COMMENT '停车场空闲车位数',
  `membercount` int(11) NOT NULL DEFAULT '0',
  `temporarycount` int(11) NOT NULL DEFAULT '0',
  `videoDiskRecorderIp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_parkinfo` */

insert  into `t_parkinfo`(`id`,`PARK_BAYNUM`,`PARK_FEEINDEX`,`PARK_FEEDESC`,`PARK_FEELEVEL`,`PARK_REGIONID`,`dbStatus`,`enableVideoDiskRecorder`,`freecount`,`latitude`,`longitude`,`park_agentid`,`park_freetime`,`park_logon`,`park_subtype`,`park_type`,`parkaddress`,`parkname`,`parkno`,`parkphoto`,`remark`,`spacecount`,`membercount`,`temporarycount`,`videoDiskRecorderIp`) values ('hzcl',0,'0','00',0,'aaaa',0,0,20,30457329,0,'00000000',2,'2',22,2,'武汉市','停车场','hzcl','0000000','我是停车场',100,0,0,'0');

/*Table structure for table `t_parkzoneinfo` */

DROP TABLE IF EXISTS `t_parkzoneinfo`;

CREATE TABLE `t_parkzoneinfo` (
  `id` varchar(64) NOT NULL,
  `dbStatus` int(11) NOT NULL,
  `updatetime` datetime DEFAULT NULL,
  `zonecount` int(11) NOT NULL,
  `zonefreecount` int(11) NOT NULL,
  `zonename` varchar(255) DEFAULT NULL,
  `parkno_id` varchar(64) DEFAULT NULL,
  `vipcarcount` int(11) DEFAULT NULL,
  `maxtempcar` int(11) DEFAULT '10000',
  `billingindex_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4ehrfa9nkywjgoef6qtq5k525` (`parkno_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_parkzoneinfo` */

insert  into `t_parkzoneinfo`(`id`,`dbStatus`,`updatetime`,`zonecount`,`zonefreecount`,`zonename`,`parkno_id`,`vipcarcount`,`maxtempcar`,`billingindex_id`) values ('5110dccc-41bb-11e7-bf98-ac853dae8834',0,'2017-05-26 10:30:56',100,100,'区域2','hzcl',0,0,NULL),('a174b6cd-3202-44e7-9a21-c62367796df7',0,'2017-05-26 09:54:31',100,0,'H停车场','hzcl',0,100,NULL);

/*Table structure for table `t_payinfo` */

DROP TABLE IF EXISTS `t_payinfo`;

CREATE TABLE `t_payinfo` (
  `id` varchar(64) NOT NULL,
  `carno` varchar(255) DEFAULT NULL,
  `chargevalue` double NOT NULL,
  `paytime` datetime DEFAULT NULL,
  `paytype` varchar(10) DEFAULT NULL,
  `payvalue` double NOT NULL,
  `parkoutlog_id` varchar(64) DEFAULT NULL,
  `inlog_batchno` varchar(64) DEFAULT NULL,
  `inlog_serialno` varchar(64) DEFAULT NULL,
  `batchno` varchar(64) DEFAULT NULL,
  `creater` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_payinfo` */

insert  into `t_payinfo`(`id`,`carno`,`chargevalue`,`paytime`,`paytype`,`payvalue`,`parkoutlog_id`,`inlog_batchno`,`inlog_serialno`,`batchno`,`creater`) values ('2d305eff-ec9b-498c-b81a-33f5b2a4b608','鄂A55G15',8500,'2017-03-31 14:30:22','000',8500,'0befbb37-b7a2-4750-9c61-2dc37e43cb00','000063','3','000063','hzcluser'),('3090373e-61a8-4134-bb25-4efd6ec214f1','鄂A55G15',0,'2017-03-31 17:26:05','000',20000,'3627f187-5b60-4534-aefc-b15d06927059','000063','7','000063','hzcluser'),('34c71422-c425-43ef-8449-46edbec42393','鄂A55G15',19700,'2017-03-31 17:28:44','000',20000,'d3e7b277-d699-4bde-af94-9ce6c3638ed9','000063','10','000063','hzcluser'),('3e779bdf-9a57-49df-ab6f-a88a6ad69318','沪BNT563',0,'2017-04-01 10:14:52','800',0,'32daafbe-e497-43e4-9845-411860587735','000063','16','000063','hzcluser'),('4598c91d-6bf0-4e53-9efc-0c2be9eee89f','鄂A77HU3',0,'2017-04-01 10:05:54','800',0,'e71b2ff1-a7d2-420f-ad79-d8851032cb5d','000063','17','000063','hzcluser'),('57eaf0c1-077e-49e3-b2e6-768edbc545ef','沪BNT563',0,'2017-04-01 10:20:32','000',0,'3cce4c5b-e389-4e49-93dc-d419f1e72a47','000063','22','000063','hzcluser'),('5bfd3a96-f254-4432-b829-587a457756db','鄂A78960',0,'2017-03-30 13:40:38','000',0,'827e7c55-1270-4591-b12d-b76804629fbc','000063','2','000063','hzcluser'),('6355f7ac-c9ef-4af5-be12-b17bf69fe39d','沪BNT563',1800,'2017-04-01 10:19:54','000',1800,'98f6d0d9-6793-48d7-b4ee-5f83e3815d0b','000063','20','000063','hzcluser'),('8b847239-78f9-48cc-865e-1ff1fec8ccca','沪BNT563',0,'2017-04-01 10:22:19','000',0,'f8ef4666-4ef6-4b9d-9e8e-335f11c317b6','000063','24','000063','hzcluser'),('92186e7e-a132-402d-b6bf-0aa9c1b77e1e','沪BED345',400,'2017-04-01 10:24:05','900',400,'a9c2af26-978c-4c67-a9ab-f254b02e94b4','000063','19','000063','hzcluser'),('94a352f6-e948-4ad8-af28-08003846f191','沪BNT563',0,'2017-04-01 10:15:24','800',0,'a912975f-bc25-485c-aed4-5cde1ba086c2',NULL,'0','000063','hzcluser'),('9baee27e-1f44-4c66-bae9-1e3d2e81c840','鄂A55G15',15800,'2017-03-31 17:24:48','000',20000,'bffe4b2f-43b8-41e3-8775-198dff14f5a0','000063','6','000063','hzcluser'),('a1c9d1e1-6cf9-41c5-b81e-9d966146d555','沪BNT563',0,'2017-04-01 10:21:07','000',0,'5097572d-4488-45fd-b5de-733aaff898f1','000063','23','000063','hzcluser'),('aaff2407-6fbd-464c-bd27-44fbcd9b3f62','鄂BTS209',200,'2017-04-01 10:06:57','900',200,'4cdd4379-cc9e-451f-b685-de6dc1b1d7e7','000063','15','000063','hzcluser'),('b2f97457-9588-4b7c-8c47-5be473b9e0bb','鄂A78900',900,'2017-03-30 13:26:49','000',900,'deedbcd2-891c-4cfc-89a9-be4160c632c3','000063','1','000063','hzcluser'),('b718de85-96b9-4d0c-be86-659dc0692d85','鄂A55G15',17000,'2017-03-31 17:29:05','000',20000,'4a7799d5-a15f-4417-bb29-1125e0d780ca','000063','11','000063','hzcluser'),('c095f1c5-901c-4b9d-8212-0ddc0d44b81e','黑A6R443',200,'2017-04-01 10:05:41','000',200,'cafd74b3-8ba4-4cc7-8c3b-689baee46e3d','000063','14','000063','hzcluser'),('c77cea1e-9cbd-419d-9dc4-5fc688603b83','鄂A77HU3',0,'2017-04-01 10:08:01','800',0,'c2b9e332-83b4-44e9-ba60-52509f2da296','000063','18','000063','hzcluser'),('d2e919d8-8036-42be-9517-b6b21f41c544','鄂A55G15',1100,'2017-03-31 17:27:12','000',20000,'06b38de7-3679-4ee5-8cf7-6d2f1b34ab35','000063','8','000063','hzcluser'),('eb246067-ac30-4c54-9e8a-7747fbb52b5b','沪BNT563',0,'2017-04-01 10:15:02','800',0,'dc3233a7-0808-4d3d-a06f-58458bbf5eea',NULL,'0','000063','hzcluser'),('fc62fbb2-47cd-49f4-9072-b1827b3b2278','鄂A55G15',19300,'2017-03-31 17:28:04','000',20000,'81b8b319-33a8-4723-9fad-fee5a44074be','000063','9','000063','hzcluser');

/*Table structure for table `t_payinfo_detail` */

DROP TABLE IF EXISTS `t_payinfo_detail`;

CREATE TABLE `t_payinfo_detail` (
  `id` varchar(64) NOT NULL,
  `carno` varchar(255) DEFAULT NULL,
  `chargevalue` double NOT NULL,
  `paytime` datetime DEFAULT NULL,
  `paytype` varchar(10) DEFAULT NULL,
  `payvalue` double NOT NULL,
  `parkoutlog_id` varchar(64) DEFAULT NULL,
  `inlog_batchno` varchar(64) DEFAULT NULL,
  `inlog_serialno` varchar(64) DEFAULT NULL,
  `batchno` varchar(64) DEFAULT NULL,
  `creater` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_payinfodetail` (`batchno`),
  KEY `idx_payinfodetail2` (`parkoutlog_id`,`chargevalue`,`payvalue`,`creater`,`paytime`),
  KEY `idx_payinfodetail3` (`paytime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_payinfo_detail` */

insert  into `t_payinfo_detail`(`id`,`carno`,`chargevalue`,`paytime`,`paytype`,`payvalue`,`parkoutlog_id`,`inlog_batchno`,`inlog_serialno`,`batchno`,`creater`) values ('0f54b4dd-e615-4c81-b01c-33c8f65d0abc','沪BNT563',1800,'2017-04-01 10:19:54','000',1800,'98f6d0d9-6793-48d7-b4ee-5f83e3815d0b','000063','20','000063','hzcluser'),('176e95df-9857-429b-9408-b967ee131d50','鄂A78900',900,'2017-03-30 13:26:49','000',900,'deedbcd2-891c-4cfc-89a9-be4160c632c3','000063','1','000063','hzcluser'),('2062e8cb-6421-423a-b320-f5e80606c534','沪BNT563',0,'2017-04-01 10:21:07','000',0,'5097572d-4488-45fd-b5de-733aaff898f1','000063','23','000063','hzcluser'),('31b36386-4471-4145-8657-ddc430bd2df2','沪BED345',400,'2017-04-01 10:24:05','900',400,'a9c2af26-978c-4c67-a9ab-f254b02e94b4','000063','19','000063','hzcluser'),('3ef3c74e-d7f7-4b73-8631-3ca56beae070','鄂BTS209',200,'2017-04-01 10:06:58','900',200,'4cdd4379-cc9e-451f-b685-de6dc1b1d7e7','000063','15','000063','hzcluser'),('4a19692d-1100-43e1-9024-1d1b3be6c439','沪BNT563',0,'2017-04-01 10:14:52','800',0,'32daafbe-e497-43e4-9845-411860587735','000063','16','000063','hzcluser'),('4a445b95-7596-4d02-944b-9756d2c4e0e4','沪BNT563',0,'2017-04-01 10:15:24','800',0,'a912975f-bc25-485c-aed4-5cde1ba086c2',NULL,'0','000063','hzcluser'),('6583e99b-ec9c-4aad-8960-103aca3f9a7a','鄂A55G15',8500,'2017-03-31 14:30:22','000',8500,'0befbb37-b7a2-4750-9c61-2dc37e43cb00','000063','3','000063','hzcluser'),('67372ace-b9cd-44b5-953e-afee7d758b94','鄂A78960',0,'2017-03-30 13:40:38','000',0,'827e7c55-1270-4591-b12d-b76804629fbc','000063','2','000063','hzcluser'),('6b452d67-424f-40ff-947e-1a6fb75f3dd2','沪BNT563',0,'2017-04-01 10:15:02','800',0,'dc3233a7-0808-4d3d-a06f-58458bbf5eea',NULL,'0','000063','hzcluser'),('72542de0-17ea-43f2-bf2e-d54a18bafa07','鄂A55G15',19700,'2017-03-31 17:28:44','000',20000,'d3e7b277-d699-4bde-af94-9ce6c3638ed9','000063','10','000063','hzcluser'),('7a01c093-73c1-4c73-8480-c3b7307b33a6','鄂A55G15',17000,'2017-03-31 17:29:05','000',20000,'4a7799d5-a15f-4417-bb29-1125e0d780ca','000063','11','000063','hzcluser'),('83090c97-8f1c-4a12-9e70-ed0b8aa728fc','鄂A55G15',0,'2017-03-31 17:26:05','000',20000,'3627f187-5b60-4534-aefc-b15d06927059','000063','7','000063','hzcluser'),('883f030e-557d-4f7f-a9e7-c90c5888ee05','沪BNT563',0,'2017-04-01 10:20:32','000',0,'3cce4c5b-e389-4e49-93dc-d419f1e72a47','000063','22','000063','hzcluser'),('9f0cd5ea-6bf8-4e8b-a9ff-e989bedd9c41','沪BNT563',0,'2017-04-01 10:22:19','000',0,'f8ef4666-4ef6-4b9d-9e8e-335f11c317b6','000063','24','000063','hzcluser'),('a54e4a05-0904-429a-954e-0c79f9bf24c9','鄂A55G15',15800,'2017-03-31 17:24:48','000',20000,'bffe4b2f-43b8-41e3-8775-198dff14f5a0','000063','6','000063','hzcluser'),('ba26ee95-7e4d-44c7-86a1-71f81d5ccd6c','鄂A77HU3',0,'2017-04-01 10:05:54','800',0,'e71b2ff1-a7d2-420f-ad79-d8851032cb5d','000063','17','000063','hzcluser'),('beafd914-2cbf-4035-936b-481e0435a225','鄂A77HU3',0,'2017-04-01 10:08:01','800',0,'c2b9e332-83b4-44e9-ba60-52509f2da296','000063','18','000063','hzcluser'),('d674113b-260b-4cea-be5c-7c0ddc59701c','鄂A55G15',19300,'2017-03-31 17:28:04','000',20000,'81b8b319-33a8-4723-9fad-fee5a44074be','000063','9','000063','hzcluser'),('dbe4945f-afd8-460e-b06a-a500daf81c1c','黑A6R443',200,'2017-04-01 10:05:41','000',200,'cafd74b3-8ba4-4cc7-8c3b-689baee46e3d','000063','14','000063','hzcluser'),('f01bc52e-e78f-499e-9012-54fce4cf4c4b','鄂A55G15',1100,'2017-03-31 17:27:12','000',20000,'06b38de7-3679-4ee5-8cf7-6d2f1b34ab35','000063','8','000063','hzcluser');

/*Table structure for table `t_pic_upload` */

DROP TABLE IF EXISTS `t_pic_upload`;

CREATE TABLE `t_pic_upload` (
  `id` varchar(64) NOT NULL,
  `carno` varchar(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `pic_id` varchar(64) DEFAULT NULL,
  `pic_type` varchar(1) DEFAULT NULL,
  `send_flag` smallint(1) DEFAULT '0',
  `pic_org_url` varchar(255) DEFAULT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  `upload_count` smallint(1) DEFAULT '0',
  `yun_r_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_pic_upload` */

/*Table structure for table `t_pos_info` */

DROP TABLE IF EXISTS `t_pos_info`;

CREATE TABLE `t_pos_info` (
  `id` varchar(64) NOT NULL,
  `device_code` varchar(64) NOT NULL,
  `pos_code` varchar(64) NOT NULL,
  `agent_code` varchar(64) NOT NULL,
  `program_ver` varchar(64) NOT NULL,
  `param_ver` varchar(64) NOT NULL,
  `feeman_code` varchar(64) NOT NULL,
  `feeman_name` varchar(64) NOT NULL,
  `park_code` varchar(64) NOT NULL,
  `park_name` varchar(64) NOT NULL,
  `tollgate_id` varchar(64) NOT NULL COMMENT '停车场卡口编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_pos_info` */

/*Table structure for table `t_postinfo` */

DROP TABLE IF EXISTS `t_postinfo`;

CREATE TABLE `t_postinfo` (
  `id` varchar(64) NOT NULL,
  `parkno_id` varchar(64) NOT NULL,
  `post_name` varchar(500) NOT NULL,
  `post_type` int(11) DEFAULT NULL,
  `remark` varchar(3000) DEFAULT NULL,
  `dbstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_postinfo` */

insert  into `t_postinfo`(`id`,`parkno_id`,`post_name`,`post_type`,`remark`,`dbstatus`) values ('4753cf21-4db0-4c68-a370-fc0839da668f','hzcl','岗亭',1,'重中之重重中之重',0),('b8bbf294-41bb-11e7-bf98-ac853dae8834','hzcl','岗亭2',0,'',0);

/*Table structure for table `t_publicledinfo` */

DROP TABLE IF EXISTS `t_publicledinfo`;

CREATE TABLE `t_publicledinfo` (
  `id` varchar(64) NOT NULL,
  `parkno_id` varchar(64) DEFAULT NULL,
  `ledname` varchar(100) DEFAULT NULL,
  `ledip` varchar(100) DEFAULT NULL,
  `port` varchar(50) DEFAULT NULL,
  `baudrate` varchar(50) DEFAULT NULL,
  `comname` varchar(50) DEFAULT NULL,
  `zone_id` varchar(64) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `dbStatus` int(11) NOT NULL,
  `fontbold` int(10) DEFAULT NULL,
  `holdtime` int(10) DEFAULT NULL,
  `actionspeed` int(10) DEFAULT NULL,
  `numcount` int(10) DEFAULT NULL,
  `actiontype` varchar(64) DEFAULT NULL,
  `texttmp` varchar(255) DEFAULT NULL,
  `ledbrand` varchar(64) NOT NULL,
  `cardaddress` int(10) DEFAULT NULL,
  `fontsize` int(10) DEFAULT NULL,
  `isused` int(2) DEFAULT NULL,
  `coordinateY` int(10) DEFAULT NULL,
  `coordinateX` int(10) DEFAULT NULL,
  `partHeight` int(10) DEFAULT NULL,
  `partWidth` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_publicledinfo` */

insert  into `t_publicledinfo`(`id`,`parkno_id`,`ledname`,`ledip`,`port`,`baudrate`,`comname`,`zone_id`,`remark`,`dbStatus`,`fontbold`,`holdtime`,`actionspeed`,`numcount`,`actiontype`,`texttmp`,`ledbrand`,`cardaddress`,`fontsize`,`isused`,`coordinateY`,`coordinateX`,`partHeight`,`partWidth`) values ('23579e64-41e9-11e7-bf98-ac853dae8834','hzcl','led2','11',NULL,NULL,NULL,'5110dccc-41bb-11e7-bf98-ac853dae8834',NULL,0,1,11111,11,11,'1','11111','Socket',111,1111,0,11111,11111,1111,1111),('5a73e274-41f1-11e7-bf98-ac853dae8834','hzcl','aaaa','',NULL,NULL,NULL,'5110dccc-41bb-11e7-bf98-ac853dae8834',NULL,0,0,5,0,0,'1','','Socket',0,0,0,0,0,0,0),('641ef686-fd37-433f-8296-f8a8ed7eae1a','hzcl','诱导屏','192.168.100.216',NULL,NULL,NULL,'a174b6cd-3202-44e7-9a21-c62367796df7',NULL,0,1,0,0,3,'1','','EQ2013Led',0,22,0,0,0,32,64),('949868dc-41ea-11e7-bf98-ac853dae8834','hzcl','bbbbb','',NULL,NULL,NULL,'5110dccc-41bb-11e7-bf98-ac853dae8834',NULL,0,0,0,0,0,'1','','Socket',0,0,0,15,0,0,0);

/*Table structure for table `t_reduce` */

DROP TABLE IF EXISTS `t_reduce`;

CREATE TABLE `t_reduce` (
  `id` varchar(64) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `remark` text,
  `rule` longtext,
  `is_drools` tinyint(1) DEFAULT NULL,
  `reduce_billingindex` varchar(64) DEFAULT NULL,
  `reduce_discount` int(11) DEFAULT '100',
  `reduce_fee` double DEFAULT NULL,
  `reduce_duration` int(11) DEFAULT NULL,
  `reduce_type` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_reduce` */

insert  into `t_reduce`(`id`,`name`,`remark`,`rule`,`is_drools`,`reduce_billingindex`,`reduce_discount`,`reduce_fee`,`reduce_duration`,`reduce_type`) values ('bda38f54-288e-4185-9273-77101cd54d74','减免一次停车','','',0,'',100,0,0,'01'),('0c00a69b-22eb-4890-b1b4-4f2b040dd5b1','活动优惠','','',0,'d2ecf564-da79-4590-9263-fe13ed15d48c',100,0,0,'06'),('4a64e3d7-d318-4ea1-8287-f0d6d33f8557','当天全免','','1',0,'',100,0,0,'01'),('659bb167-3b49-40c3-88ba-befe414f8d7f','减免脚本','','package reduces;\r\nimport com.freeparking.parking.fee.model.ReduceModel;\r\nimport com.freeparking.parking.fee.model.ReduceResult;\r\n\r\ndeclare Rule\r\n    reduceMoney:double\r\nend\r\n\r\nrule \"系统参数初始化\"\r\n   salience 20\r\n   no-loop true\r\n  when \r\n    eval(true)\r\n  then\r\n    Rule rle =new Rule();\r\n    //设置减免金额为5元,少补多不退\r\n    rle.setReduceMoney(600);\r\n    insert(rle);\r\n    System.out.println(\"初始化系统参数完成!\");\r\nend\r\n\r\n\r\n\r\nrule \"现金金额减免\"\r\n	salience 10\r\n        no-loop true\r\n    when \r\n        $reduceMode:ReduceModel();\r\n        $reduceResult:ReduceResult();\r\n        $rle:Rule();\r\n         eval($reduceMode.getOrginFee()>0)\r\n    then\r\n        System.out.println(\"现金减免规则\");\r\n        if($reduceMode.getOrginFee()>$rle.getReduceMoney())\r\n        {\r\n           System.out.println(\"现金减免\"+$rle.getReduceMoney()+\"元\");\r\n           $reduceResult.setFee($reduceMode.getOrginFee()-$rle.getReduceMoney());\r\n        }else\r\n        {\r\n           System.out.println(\"现金减免,无需缴费\");\r\n           $reduceResult.setFee(0);\r\n        }\r\nend',1,'',100,0,0,''),('be544345-c2dd-4798-bd56-dbcebeb41134','减免30分钟','2','1',0,'',100,0,30,'03'),('839f2b42-86fe-449b-9d47-9fada0cbf6ea','减免3元','','',0,'',100,300,2,'04'),('9c25b5af-7798-42eb-8e27-28d9789d67ae','打八折','','1',0,'',85,0,0,'05'),('a66f9be3-3c76-40c0-a522-a2e78b91ae2b','1','','1',0,'',100,100,1,''),('9dcd235d-bdf5-46be-9b85-fd269cd619e0','2','','2',0,'',100,200,2,''),('b6468e86-f59e-4573-b718-6ae44ed4e0f9','3','','3',0,'',100,300,3,''),('57f9d576-be65-4916-bc3a-6e1bc980517f','4','','',0,'',100,100,1,''),('d4604047-111d-4368-80ba-4ab88ccaa103','5','','5',0,'',100,500,5,''),('719783ab-fbab-4071-abbe-6b26427f769d','11','','',0,'',100,900,9,'01'),('201ca665-374f-4060-9362-c7c6525041df','2','','',0,'',100,0,0,'');

/*Table structure for table `t_syslog` */

DROP TABLE IF EXISTS `t_syslog`;

CREATE TABLE `t_syslog` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `operaterid` varchar(64) DEFAULT NULL COMMENT '用户id',
  `optModule` varchar(255) DEFAULT NULL COMMENT '操作模块',
  `optaction` varchar(255) DEFAULT NULL COMMENT '用户操作',
  `optcontent` varchar(255) DEFAULT NULL COMMENT '操作内容',
  `opttime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '操作时间',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `carno` varchar(255) DEFAULT NULL COMMENT '车牌号',
  `gateid` varchar(64) DEFAULT NULL COMMENT '通道id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_syslog` */

insert  into `t_syslog`(`id`,`operaterid`,`optModule`,`optaction`,`optcontent`,`opttime`,`createtime`,`carno`,`gateid`) values ('02dcfc23-9601-4f3d-a234-e3e74c8387d0','hzcluser','会员管理','导入会员','导入会员张三9,车牌为：鄂ACF016 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:17','2017-05-31 12:08:13','鄂ACF016',''),('10c6ce19-e903-46f8-8d75-4833b7efcc38','hzcluser','会员管理','导入会员','导入会员张三4,车牌为：鄂ACF011 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:09','2017-05-31 12:08:05','鄂ACF011',''),('14641ab9-df83-4ce3-a4fa-6518bfdd79a2','hzcluser','会员管理','导入会员','导入会员张三6,车牌为：鄂ACF013 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:09','2017-05-31 12:08:05','鄂ACF013',''),('1c7ae440-7158-466f-9e19-b087bed9c206','hzcluser','会员管理','导入会员','导入会员张三6,车牌为：鄂ACF013 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:17','2017-05-31 12:08:13','鄂ACF013',''),('1d09b749-cdc7-4c5d-ba6b-dfb58f4a7c03','hzcluser','会员管理','导入会员','导入会员张三9,车牌为：鄂ACF016 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:09','2017-05-31 12:08:05','鄂ACF016',''),('27d7ca0f-8cfa-4bf2-9d06-e319a824b2fa','hzcluser','会员管理','导入会员','导入会员张三2,车牌为：鄂ACF009 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:09','2017-05-31 12:08:05','鄂ACF009',''),('2b5f19fc-4cc9-4177-a752-52858b4ac85b','hzcluser','会员管理','余额充值','账户余额1.0元，充值金额2元','2017-04-01 10:23:25','2017-04-01 10:23:25','沪BED345',''),('3918e2bc-9867-47ad-862d-beb652f91643','hzcluser','会员管理','导入会员','导入会员张三7,车牌为：鄂ACF014 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:17','2017-05-31 12:08:13','鄂ACF014',''),('3f740272-54ce-43ec-8538-3ea6d543a81c','hzcluser','会员管理','导入会员','导入会员张三7,车牌为：鄂ACF014 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:09','2017-05-31 12:08:05','鄂ACF014',''),('4334593a-e8fd-4b5e-b9f6-ae232aa5705d','hzcluser','会员管理','导入会员','导入会员张三,车牌为：鄂ACF998 会员车,有效期为2016-01-23~2016-09-06','2017-05-31 12:07:50','2017-05-31 12:07:45','鄂ACF998',''),('538a8b24-6616-4296-b073-54f8c2537c85','hzcluser','会员管理','导入会员','导入会员张三8,车牌为：鄂ACF015 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:09','2017-05-31 12:08:05','鄂ACF015',''),('55342bf4-72cf-4161-a361-5f5b284060e4','hzcluser','会员管理','导入会员','导入会员张三1,车牌为：鄂ACF008 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:17','2017-05-31 12:08:12','鄂ACF008',''),('5a4b2f4e-6d69-4446-929d-6dfd34464966','hzcluser','会员管理','导入会员','导入会员张三8,车牌为：鄂ACF015 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:17','2017-05-31 12:08:13','鄂ACF015',''),('5e40d291-2e9e-46cc-8e85-9cbd9c63df9f','hzcluser','会员管理','导入会员','导入会员张三,车牌为：鄂ACF998 会员车,有效期为2016-01-23~2016-09-06','2017-05-31 12:07:44','2017-05-31 12:07:40','鄂ACF998',''),('6b99da3b-9b31-456f-a547-dacb6f99c7f7','hzcluser','会员管理','导入会员','导入会员张三5,车牌为：鄂ACF012 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:09','2017-05-31 12:08:05','鄂ACF012',''),('84326eda-d913-4edd-bc51-3fa87dad44c1','hzcluser','会员管理','会员延期','延期开始时间:2017-03-01,结束时间:2017-04-28','2017-04-01 10:18:22','2017-04-01 10:18:22','沪BNT563',''),('84bfee50-942b-49bf-994b-d93a6dc8dea4','hzcluser','会员管理','导入会员','导入会员张三4,车牌为：鄂ACF011 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:17','2017-05-31 12:08:13','鄂ACF011',''),('8ac8fddb-83e6-4eda-af94-0d0b5e315c75','hzcluser','会员管理','导入会员','导入会员张三3,车牌为：鄂ACF010 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:09','2017-05-31 12:08:05','鄂ACF010',''),('8b2f223e-727d-471d-a2f6-951e74c368b7','hzcluser','会员管理','导入会员','导入会员张三10,车牌为：鄂ACF017 会员车,有效期为2017-05-30~2017-11-06','2017-05-31 12:08:09','2017-05-31 12:08:05','鄂ACF017',''),('954cdbd1-0933-424e-8db1-8ddb0853cc00','hzcluser','会员管理','余额充值','账户余额3.0元，充值金额2元','2017-04-01 10:23:52','2017-04-01 10:23:52','沪BED345',''),('993f7324-341e-4b62-8ef8-947c90b44e56','hzcluser','会员管理','余额充值','账户余额0.0元，充值金额3元','2017-04-01 10:06:19','2017-04-01 10:06:19','鄂BTS209',''),('a4312306-f5e4-4cda-8bd7-56d389014279','hzcluser','会员管理','新增会员','新增会员会员卡,车牌为：鄂A77HU3 会员车,有效期为2017-04-01~2017-04-30','2017-04-01 09:32:11','2017-04-01 09:32:10','鄂A77HU3',''),('db721bc7-f273-4fff-9a4e-b48394bce269','hzcluser','会员管理','新增会员','新增会员储值卡,车牌为：鄂BTS209 储值车,余额为0.0元','2017-04-01 10:04:50','2017-04-01 10:04:50','鄂BTS209',''),('e62f22a5-bced-4ec4-be5a-6b4495c2f2a9','hzcluser','会员管理','导入会员','导入会员张三5,车牌为：鄂ACF012 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:17','2017-05-31 12:08:13','鄂ACF012',''),('ed55b260-810d-46bb-9ed8-103c14c81dd3','hzcluser','会员管理','导入会员','导入会员张三10,车牌为：鄂ACF017 会员车,有效期为2017-05-30~2017-11-06','2017-05-31 12:08:17','2017-05-31 12:08:13','鄂ACF017',''),('f2ecbb4b-3d7b-477b-93e6-0a1488368940','hzcluser','会员管理','导入会员','导入会员张三3,车牌为：鄂ACF010 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:17','2017-05-31 12:08:12','鄂ACF010',''),('f852a173-9757-450e-85fd-4964a02a681d','hzcluser','会员管理','导入会员','导入会员张三2,车牌为：鄂ACF009 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:17','2017-05-31 12:08:12','鄂ACF009',''),('ffdb11dc-f91e-4aac-aae3-92be855cf4b1','hzcluser','会员管理','导入会员','导入会员张三1,车牌为：鄂ACF008 会员车,有效期为2017-05-30~2017-09-06','2017-05-31 12:08:09','2017-05-31 12:08:05','鄂ACF008','');

/*Table structure for table `t_systeminfo` */

DROP TABLE IF EXISTS `t_systeminfo`;

CREATE TABLE `t_systeminfo` (
  `id` varchar(64) NOT NULL,
  `bigphotopath` varchar(255) DEFAULT NULL,
  `defaultcar` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `smallphotopath` varchar(255) DEFAULT NULL,
  `systemname` varchar(255) DEFAULT NULL,
  `comparisonNum` int(11) NOT NULL,
  `recoveryCycle` int(11) NOT NULL DEFAULT '0',
  `clear_inlogold` int(11) DEFAULT NULL,
  `clear_outlog` int(11) DEFAULT NULL,
  `chargeoutlog` int(11) DEFAULT NULL,
  `car_expiredalarms` int(11) DEFAULT NULL,
  `clear_syslog` int(11) DEFAULT NULL,
  `version` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_systeminfo` */

insert  into `t_systeminfo`(`id`,`bigphotopath`,`defaultcar`,`remark`,`smallphotopath`,`systemname`,`comparisonNum`,`recoveryCycle`,`clear_inlogold`,`clear_outlog`,`chargeoutlog`,`car_expiredalarms`,`clear_syslog`,`version`) values ('xtgl','D:\\flypark_image','鄂','','D:\\flypark_image','停车场管理系统',3,1,30,10,0,7,30,NULL);

/*Table structure for table `t_userinfo` */

DROP TABLE IF EXISTS `t_userinfo`;

CREATE TABLE `t_userinfo` (
  `id` varchar(64) NOT NULL,
  `age` datetime DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `creater` varchar(255) DEFAULT NULL,
  `dbStatus` int(11) NOT NULL,
  `loginname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `role` int(11) NOT NULL,
  `sex` int(11) NOT NULL,
  `telnum` varchar(255) DEFAULT NULL,
  `updatedTime` datetime DEFAULT NULL,
  `updater` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `workNo` varchar(255) DEFAULT NULL,
  `parkid_id` varchar(64) DEFAULT NULL,
  `batchno` varchar(64) DEFAULT NULL,
  `work_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_a8p8n8p90is2gi1ukjokgi8tw` (`parkid_id`) USING BTREE,
  KEY `idx_userinfo` (`workNo`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_userinfo` */

insert  into `t_userinfo`(`id`,`age`,`createdTime`,`creater`,`dbStatus`,`loginname`,`password`,`remark`,`role`,`sex`,`telnum`,`updatedTime`,`updater`,`username`,`workNo`,`parkid_id`,`batchno`,`work_status`) values ('6436d0e03e9111e7b7e5ac853dae8834','1995-06-13 00:00:00','2017-05-22 09:52:07',NULL,0,'lzc2','E10ADC3949BA59ABBE56E057F20F883E','aaaaa',11,1,'13035143830','2017-05-27 17:22:03',NULL,'lzc2','005','hzcl',NULL,0),('hzcluser','2013-11-25 00:00:00',NULL,'',0,'001','E10ADC3949BA59ABBE56E057F20F883E','',11,0,'15674563475','2017-05-24 12:13:44','hzcluser','初始管理员','007','hzcl','000108',0);

/*Table structure for table `t_violation_user` */

DROP TABLE IF EXISTS `t_violation_user`;

CREATE TABLE `t_violation_user` (
  `VIOLATION_ID` varchar(32) NOT NULL COMMENT 'UUID 违规ID',
  `VIOLATION_NAME` varchar(32) DEFAULT NULL COMMENT '人员名称',
  `VIOLATION_CARD` varchar(32) DEFAULT NULL COMMENT '身份证号码',
  `VIOLATION_PHONE` varchar(16) DEFAULT NULL COMMENT '人员电话',
  `VIOLATION_ADRESS` varchar(200) DEFAULT NULL COMMENT '地址',
  `VIOLATION_TYPE` varchar(2) DEFAULT NULL COMMENT '人员类型 00:低保人员 01 黑名单人员 02 违章车辆 03 法院控制人员 04 老赖车人员',
  `VIOLATION_CARNO` varchar(12) DEFAULT NULL COMMENT '车牌号',
  `VIOLATION_NUM` int(11) DEFAULT NULL COMMENT '违规次数',
  `VIOLATION_CONTENT` varchar(200) DEFAULT NULL COMMENT '违规描述',
  `REMARK` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`VIOLATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_violation_user` */

/*Table structure for table `t_worklog` */

DROP TABLE IF EXISTS `t_worklog`;

CREATE TABLE `t_worklog` (
  `id` varchar(64) NOT NULL,
  `parkno_id` varchar(64) DEFAULT NULL,
  `workno` varchar(64) DEFAULT NULL,
  `batchno` varchar(64) DEFAULT NULL,
  `onwork_time` datetime DEFAULT NULL,
  `offwork_time` datetime DEFAULT NULL,
  `dbstatus` int(11) DEFAULT NULL,
  `send_flag` int(11) NOT NULL DEFAULT '0',
  `gate_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_worklog` */

insert  into `t_worklog`(`id`,`parkno_id`,`workno`,`batchno`,`onwork_time`,`offwork_time`,`dbstatus`,`send_flag`,`gate_id`) values ('08b809a0-5dae-45c8-9683-728028a6ac34','hzcl','007','000097','2017-05-22 10:46:49','2017-05-22 18:23:37',0,0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f'),('09a91b41-9a7e-4e89-a694-c003a1d6b527','hzcl','007','000065','2017-04-20 11:08:04','2017-04-20 11:20:16',0,0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f'),('0f3ea629-de5e-40f1-9514-ce529bc00396','hzcl','007','000082','2017-05-15 12:12:05','2017-05-15 12:12:09',0,0,''),('1742e988-8765-4d9b-b52d-74633e1e219b','hzcl','007','000066','2017-04-20 11:20:21','2017-04-20 15:35:12',0,0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f'),('17c767e1-feed-41a9-ab56-dfc6e4657eba','hzcl','007','000072','2017-05-11 15:41:46','2017-05-11 16:39:00',0,0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f'),('1949cb04-a103-49e7-a1a3-3d2edf78c1c2','hzcl','007','000102','2017-05-24 09:41:23','2017-05-24 18:50:00',0,0,''),('2ea6fde7-bbd1-405e-abf5-b05f25828312','hzcl','007','000068','2017-05-02 10:10:53','2017-05-02 10:36:01',0,0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f'),('39eea4f3-1d80-413e-ac84-4460996b42c5','hzcl','007','000106','2017-05-27 09:08:23','2017-05-27 10:11:25',0,0,''),('4060df0a-09b9-47bc-b389-682f7929e6dc','hzcl','008','000096','2017-05-22 09:52:37','2017-05-22 10:47:50',0,0,''),('44fe8d86-fa24-43a8-af7a-241c262a460c','hzcl','007','000103','2017-05-25 10:52:18','2017-05-25 18:03:28',0,0,''),('48c2d930-3885-4008-a792-7327ec59903a','hzcl','007','000092','2017-05-18 09:24:50','2017-05-18 18:48:59',0,0,''),('4adc3a24-4ee3-4ee0-bcc8-bb6224556d90','hzcl','007','000108','2017-05-31 12:04:28','2017-05-31 15:44:49',0,0,''),('50dc24e5-73e7-447d-b608-14608abe1e1f','hzcl','007','000073','2017-05-12 11:28:54','2017-05-12 12:01:36',0,0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f'),('55f592e1-a501-469e-beec-39d338c59a5a','hzcl','007','000074','2017-05-12 16:37:04','2017-05-12 16:38:01',0,0,''),('57478717-7648-4f2d-bdd6-bb3de48d0139','hzcl','007','000071','2017-05-11 15:30:28','2017-05-11 15:30:50',0,0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f'),('5c18f772-651f-4dc9-8955-16d848c2def7','hzcl','007','000088','2017-05-17 14:46:50','2017-05-17 14:58:07',0,0,''),('5d22aa81-f73d-42f0-aa2f-300d7b1df734','hzcl','007','000107','2017-05-27 15:33:33','2017-05-27 15:54:51',0,0,''),('5fc17f65-2035-4858-8925-fa7472e199b6','hzcl','007','000067','2017-04-21 13:47:15','2017-04-21 15:42:56',0,0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f'),('67495818-f5ab-4771-8959-98255b5bd80e','hzcl','007','000064','2017-04-20 10:53:28','2017-04-20 11:07:59',0,0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f'),('738081f3-2e43-4e42-83d2-89e69561c7c4','hzcl','007','000083','2017-05-16 17:27:27','2017-05-16 18:25:18',0,0,''),('75db84c4-cbc2-4eb2-a421-14d0bd0d12a2','hzcl','007','000070','2017-05-11 10:26:35','2017-05-11 10:27:12',0,0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f'),('75de9ea2-7bcf-4b07-ba62-206f54f1efff','hzcl','008','000100','2017-05-22 12:40:16','2017-05-22 18:06:21',0,0,''),('78e20cac-b572-4238-b08f-6f200abf8113','hzcl','008','000099','2017-05-22 12:21:03','2017-05-22 12:21:33',0,0,''),('8031cd54-8aa4-4f26-93fc-034e53445dde','hzcl','007','000095','2017-05-22 09:45:32','2017-05-22 09:52:37',0,0,''),('80e77019-75a5-4dc9-ba95-3809636377a3','hzcl','007','000093','2017-05-19 10:30:59','2017-05-19 11:44:13',0,0,''),('82dbe128-7f24-4b4a-a3ab-8a42286674df','hzcl','007','000069','2017-05-08 16:50:24','2017-05-11 10:15:08',0,0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f'),('85f15079-5c02-482d-b646-9ed7547df7b2','hzcl','007','000105','2017-05-26 14:34:55','2017-05-26 17:13:42',0,0,''),('8b6b6145-9cfd-4c24-92fa-0182ed611182','hzcl','007','000075','2017-05-15 12:06:42','2017-05-15 12:06:49',0,0,''),('8ee61fe7-7bd6-4104-802e-58ce0fa4cf45','hzcl','003','000094','2017-05-22 09:43:54','2017-05-22 09:45:18',0,0,''),('a8d389a0-fb72-4a8d-92af-82e9bba906be','hzcl','007','000086','2017-05-17 14:32:28','2017-05-17 14:32:33',0,0,''),('ab05c882-34bc-40a0-84a0-2f8140110a51','hzcl','007','000104','2017-05-26 09:20:34','2017-05-26 14:34:33',0,0,''),('ae1655cf-561c-449c-9bba-5cc26c2e66c1','hzcl','007','000085','2017-05-17 11:36:06','2017-05-17 14:32:28',0,0,''),('afdb56c2-8a5e-4e68-959c-ca88243682b7','hzcl','007','000076','2017-05-15 12:07:18','2017-05-15 12:07:24',0,0,''),('bbccbe5b-062f-47b4-b569-ae9d57beeef6','hzcl','007','000063','2017-03-28 17:42:34','2017-04-20 10:53:22',0,0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f'),('c5244500-0c18-470d-83b8-57ed740dfc97','hzcl','007','000080','2017-05-15 12:10:50','2017-05-15 12:10:54',0,0,''),('c9aefc3f-f0ad-4fc5-97d0-5b89abf363c3','hzcl','007','000089','2017-05-17 14:58:16','2017-05-17 16:24:05',0,0,''),('cf1ea5c3-09de-46d1-8edf-13f1801daa29','hzcl','007','000079','2017-05-15 12:10:19','2017-05-15 12:10:24',0,0,''),('d669263e-1c0e-4387-8b6c-5465fdfd4766','hzcl','007','000091','2017-05-17 16:25:37','2017-05-17 18:34:04',0,0,''),('dd217ec9-f109-494c-9854-c94cc8640872','hzcl','008','000101','2017-05-23 09:24:39','2017-05-23 18:30:25',0,0,''),('ddfcf0a5-ff75-4e47-ae18-8236004e856d','hzcl','007','000078','2017-05-15 12:09:40','2017-05-15 12:09:44',0,0,''),('e18f0218-22a5-475c-8e09-d856d46f928e','hzcl','007','000077','2017-05-15 12:08:52','2017-05-15 12:08:56',0,0,''),('e6844c50-aff3-4632-8d5f-8a9ae553828d','hzcl','007','000087','2017-05-17 14:32:33','2017-05-17 14:45:25',0,0,''),('efa3e722-2e9e-49fa-bfb3-8cace830bb0a','hzcl','007','000081','2017-05-15 12:11:30','2017-05-15 12:11:34',0,0,''),('f014a8ca-a862-4a54-b5b5-c6cb8e9203b8','hzcl','007','000084','2017-05-16 18:41:16','2017-05-16 18:46:36',0,0,'824f8f39-48bb-4b9d-ba95-0d19b7e2f75f'),('f972e04d-3538-4093-a6f1-36b0a9049be6','hzcl','008','000098','2017-05-22 11:45:58','2017-05-22 11:47:02',0,0,'');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
