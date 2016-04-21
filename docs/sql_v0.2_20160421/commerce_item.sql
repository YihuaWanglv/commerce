/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : commerce_item

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-04-21 18:21:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL,
  `item_desc` varchar(255) DEFAULT NULL,
  `price` decimal(13,2) DEFAULT NULL,
  `delivery_time_id` bigint(20) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `seller_cids` varchar(255) DEFAULT NULL COMMENT '商品所属的店铺内卖家自定义类目列表',
  `input_pids` varchar(512) DEFAULT NULL COMMENT '用户自行输入的类目属性ID串。结构："pid1,pid2,pid3"，如："20000"（表示品牌） 注：通常一个类目下用户可输入的关键属性不超过1个。',
  `input_str` varchar(4096) DEFAULT NULL COMMENT '用户自行输入的子属性名和属性值，结构:"父属性值;一级子属性名;一级子属性值;二级子属性名;自定义输入值,....",如：“耐克;耐克系列;科比系列;科比系列;2K5”，input_str需要与input_pids一一对应，注：通常一个类目下用户可输入的关键属性不超过1个。所有属性别名加起来不能超过 3999字节',
  `pic_url` varchar(255) DEFAULT NULL COMMENT '商品主图片地址',
  `num` int(11) DEFAULT NULL,
  `list_time` datetime DEFAULT NULL COMMENT '上架时间（格式：yyyy-MM-dd HH:mm:ss）',
  `delist_time` datetime DEFAULT NULL COMMENT '下架时间',
  `stuff_status` tinyint(4) DEFAULT NULL COMMENT '商品新旧程度(全新:new，闲置:unused，二手：second)',
  `location_id` bigint(20) DEFAULT NULL COMMENT '商品所在地',
  `increment` int(11) DEFAULT NULL COMMENT '加价幅度。如果为0，代表系统代理幅度。在竞拍中，为了超越上一个出价，会员需要在当前出价上增加金额，这个金额就是加价幅度。卖家在发布宝贝的时候可以自定义加价幅度，也可以让系统自动代理加价。系统自动代理加价的加价幅度随着当前出价金额的增加而增加，我们建议会员使用系统自动代理加价，并请买家在出价前看清楚加价幅度的具体金额。另外需要注意是，此功能只适用于拍卖的商品。以下是系统自动代理加价幅度表：当前价（加价幅度 ）1-40（ 1 ）、41-100（ 2 ）、101-200（5 ）、201-500 （10）、501-1001（15）、001-2000（25）、2001-5000（50）、5001-10000（100）10001以上 200',
  `approve_status` tinyint(4) DEFAULT NULL COMMENT '商品上传后的状态。onsale出售中，instock库中',
  `postage_id` int(11) DEFAULT NULL COMMENT '宝贝所属的运费模板ID，如果没有返回则说明没有使用运费模板',
  `product_id` bigint(20) DEFAULT NULL COMMENT '宝贝所属产品的id(可能为空)',
  `violation` tinyint(1) DEFAULT '0' COMMENT '商品是否违规，违规：true , 不违规：false',
  `title` varchar(128) DEFAULT NULL COMMENT '商品标题,不能超过60字节',
  `user_id` bigint(20) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL COMMENT '商品类型(fixed:一口价;auction:拍卖)',
  `property_alias` varchar(255) DEFAULT NULL COMMENT '属性值别名,比如颜色的自定义名称',
  `sell_point` varchar(255) DEFAULT NULL COMMENT '商品卖点信息，最长150个字符',
  `valid_thru` int(8) DEFAULT NULL COMMENT '有效期,7或者14（默认是7天）',
  `outer_id` varchar(128) DEFAULT NULL COMMENT '商家外部编码(可与商家外部系统对接)',
  `qualification` varchar(255) DEFAULT NULL COMMENT '商品资质的信息，用URLEncoder做过转换，使用时，需要URLDecoder转换回来，默认字符集为：UTF-8',
  `post_fee` decimal(9,2) DEFAULT NULL COMMENT '平邮费用,格式：5.00；单位：元；精确到：分',
  `express_fee` decimal(9,2) DEFAULT NULL COMMENT '快递费用,格式：5.00；单位：元；精确到：分',
  `ems_fee` decimal(9,2) DEFAULT NULL COMMENT 'ems费用,格式：5.00；单位：元；精确到：分',
  `stock_type` tinyint(4) DEFAULT NULL COMMENT '商品采购地信息（库存类型），有两种库存类型：现货和代购;参数值为1时代表现货，值为2时代表代购',
  `item_detail_id` bigint(20) DEFAULT NULL COMMENT 'item详情id',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------

-- ----------------------------
-- Table structure for item_delivery_time
-- ----------------------------
DROP TABLE IF EXISTS `item_delivery_time`;
CREATE TABLE `item_delivery_time` (
  `delivery_time_id` bigint(20) NOT NULL,
  `need_delivery_time` tinyint(1) NOT NULL DEFAULT '0',
  `delivery_time_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '发货时间类型：绝对发货时间或者相对发货时间',
  `delivery_time` varchar(16) DEFAULT NULL COMMENT '商品级别设置的发货时间。设置了商品级别的发货时间，相对发货时间，则填写相对发货时间的天数（大于3）；绝对发货时间，则填写yyyy-mm-dd格式，如2013-11-11',
  PRIMARY KEY (`delivery_time_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_delivery_time
-- ----------------------------

-- ----------------------------
-- Table structure for item_detail
-- ----------------------------
DROP TABLE IF EXISTS `item_detail`;
CREATE TABLE `item_detail` (
  `item_detail_id` bigint(20) NOT NULL,
  `item_detail` longtext,
  PRIMARY KEY (`item_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品详情';

-- ----------------------------
-- Records of item_detail
-- ----------------------------

-- ----------------------------
-- Table structure for item_img
-- ----------------------------
DROP TABLE IF EXISTS `item_img`;
CREATE TABLE `item_img` (
  `item_img_id` bigint(20) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `position` tinyint(4) DEFAULT NULL,
  `created` varchar(255) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `item_inner_id` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`item_img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_img
-- ----------------------------

-- ----------------------------
-- Table structure for item_location
-- ----------------------------
DROP TABLE IF EXISTS `item_location`;
CREATE TABLE `item_location` (
  `location_id` bigint(20) NOT NULL,
  `zip` varchar(16) DEFAULT NULL COMMENT '邮政编码',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址，最大256个字节（128个中文）',
  `city_id` int(11) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_location
-- ----------------------------

-- ----------------------------
-- Table structure for item_prop_img
-- ----------------------------
DROP TABLE IF EXISTS `item_prop_img`;
CREATE TABLE `item_prop_img` (
  `item_prop_img_id` bigint(20) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `properties` varchar(255) DEFAULT NULL COMMENT '图片所对应的属性组合的字符串',
  `position` tinyint(4) DEFAULT NULL COMMENT '图片放在第几张（多图时可设置）',
  `item_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`item_prop_img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_prop_img
-- ----------------------------

-- ----------------------------
-- Table structure for item_sku
-- ----------------------------
DROP TABLE IF EXISTS `item_sku`;
CREATE TABLE `item_sku` (
  `sku_id` bigint(20) NOT NULL,
  `iid` bigint(20) NOT NULL,
  `properties` varchar(512) DEFAULT NULL COMMENT 'sku的销售属性组合字符串（颜色，大小，等等，可通过类目API获取某类目下的销售属性）,格式是p1:v1;p2:v2',
  `quantity` int(11) DEFAULT NULL,
  `price` varchar(12) DEFAULT NULL COMMENT '属于这个sku的商品的价格 取值范围:0-100000000;精确到2位小数;单位:元。如:200.07，表示:200元7分',
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT 'sku状态。 normal:正常 ；delete:删除',
  `extra_id` bigint(20) DEFAULT NULL COMMENT '扩展sku的id',
  `memo` varchar(255) DEFAULT NULL COMMENT '扩展sku的备注信息',
  `sku_spec_id` bigint(20) DEFAULT NULL COMMENT '表示SKu上的产品规格信息',
  `with_hold_quantity` int(11) DEFAULT NULL COMMENT '商品在付款减库存的状态下，该sku上未付款的订单数量',
  `sku_delivery_time` datetime DEFAULT NULL COMMENT 'sku级别发货时间',
  `change_prop` varchar(255) DEFAULT NULL COMMENT '基础色数据.pid:vid:vid1,vid2,vid3;pid:vid:vid1,vid2',
  `outer_id` varchar(128) DEFAULT NULL COMMENT '商家设置的外部id。卖家，需要登录才能获取到自己的商家编码，不能获取到他人的商家编码',
  PRIMARY KEY (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_sku
-- ----------------------------

-- ----------------------------
-- Table structure for seller_category
-- ----------------------------
DROP TABLE IF EXISTS `seller_category`;
CREATE TABLE `seller_category` (
  `seller_cid` bigint(20) NOT NULL,
  `cname` varchar(255) NOT NULL,
  PRIMARY KEY (`seller_cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller_category
-- ----------------------------

-- ----------------------------
-- Table structure for seller_shop
-- ----------------------------
DROP TABLE IF EXISTS `seller_shop`;
CREATE TABLE `seller_shop` (
  `shop_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `shop_name` varchar(512) NOT NULL,
  `type` tinyint(4) NOT NULL DEFAULT '0',
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `enable` tinyint(1) NOT NULL DEFAULT '0',
  `level` tinyint(4) NOT NULL DEFAULT '0',
  `domain` varchar(255) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller_shop
-- ----------------------------
