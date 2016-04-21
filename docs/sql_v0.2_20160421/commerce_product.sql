/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : commerce_product

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-04-21 18:22:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL,
  `cname` varchar(128) NOT NULL,
  `cname_cn` varchar(128) NOT NULL,
  `level` tinyint(4) NOT NULL DEFAULT '0',
  `category_path` varchar(512) DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL DEFAULT '0',
  `type` tinyint(4) NOT NULL DEFAULT '0',
  `is_bottom` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for category_prop_mapping
-- ----------------------------
DROP TABLE IF EXISTS `category_prop_mapping`;
CREATE TABLE `category_prop_mapping` (
  `category_prop_mapping_id` bigint(20) NOT NULL,
  `cid` int(11) NOT NULL,
  `pid` bigint(20) NOT NULL,
  PRIMARY KEY (`category_prop_mapping_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类目属性关联表';

-- ----------------------------
-- Records of category_prop_mapping
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL,
  `cid` int(11) NOT NULL,
  `outer_id` varchar(128) DEFAULT NULL COMMENT '外部产品ID',
  `props` varchar(512) DEFAULT NULL COMMENT '关键属性 结构:pid:vid;pid:vid.',
  `binds` varchar(512) DEFAULT NULL COMMENT '非关键属性结构:pid:vid;pid:vid',
  `sales_props` varchar(512) DEFAULT NULL COMMENT '销售属性结构:pid:vid;pid:vid',
  `customer_props` varchar(512) DEFAULT NULL COMMENT '用户自定义属性,结构：pid1:value1;pid2:value2，如果有型号，系列等子属性用: 隔开 例如：“20000:优衣库:型号:001;632501:1234”，表示“品牌:优衣库:型号:001;货号:1234”',
  `price` varchar(16) DEFAULT NULL COMMENT '产品市场价.精确到2位小数;单位为元.如：200.07',
  `image` varchar(512) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `desc` varchar(512) DEFAULT NULL,
  `market_time` datetime DEFAULT NULL COMMENT '上市时间',
  `property_alias` varchar(512) DEFAULT NULL COMMENT '销售属性值别名。格式为pid1:vid1:alias1;pid1:vid2:alia2。只有少数销售属性值支持传入别名，比如颜色和尺寸',
  `packing_list` varchar(512) DEFAULT NULL COMMENT '包装清单。注意，在管控类目下，包装清单不能为空，同时保证清单的格式为： 名称:数字;名称:数字; 其中，名称不能违禁、不能超过60字符，数字不能超过999',
  `extra_info` varchar(1024) DEFAULT NULL COMMENT '存放产品扩展信息，由List(ProductExtraInfo)转化成jsonArray存入',
  `market_id` varchar(128) DEFAULT NULL COMMENT '市场ID，1为新增C2C市场的产品信息， 2为新增B2C市场的产品信息。 不填写此值则C用户新增B2C市场的产品信息，B用户新增B2C市场的产品信息。',
  `sell_pt` varchar(64) DEFAULT NULL COMMENT '商品卖点描述',
  `template_id` bigint(20) DEFAULT NULL COMMENT '无关键属性发布产品，必须指定模板ID',
  `suite_items_str` varchar(512) DEFAULT NULL COMMENT '发布套装产品时，套装关联的产品规格+数量的字符串，格式：specsId:number',
  `is_pub_suite` tinyint(1) DEFAULT '0' COMMENT '是否发布套装产品，和suite_items_str配合使用',
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT '0',
  `level` tinyint(4) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  `prod_code` varchar(128) DEFAULT NULL COMMENT '产品内部code',
  `rate_num` int(11) DEFAULT NULL COMMENT '产品的评分次数',
  `sale_num` int(11) DEFAULT NULL COMMENT '产品的销售量',
  `vertical_market` tinyint(4) DEFAULT NULL COMMENT '垂直市场,如：3（3C），4（鞋城）',
  `shop_price` varchar(12) DEFAULT NULL COMMENT '产品的店内价格',
  `standard_price` varchar(12) DEFAULT NULL COMMENT '产品的标准价格',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for product_extra_info
-- ----------------------------
DROP TABLE IF EXISTS `product_extra_info`;
CREATE TABLE `product_extra_info` (
  `product_extra_info_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `field_key` varchar(128) DEFAULT NULL COMMENT '产品扩展信息键',
  `field_name` varchar(255) DEFAULT NULL COMMENT '产品扩展信息名称',
  `field_value` varchar(255) DEFAULT NULL COMMENT '产品扩展信息简介',
  PRIMARY KEY (`product_extra_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品扩展信息';

-- ----------------------------
-- Records of product_extra_info
-- ----------------------------

-- ----------------------------
-- Table structure for product_img
-- ----------------------------
DROP TABLE IF EXISTS `product_img`;
CREATE TABLE `product_img` (
  `product_img_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `position` tinyint(4) DEFAULT NULL COMMENT '图片序号。产品里的图片展示顺序，数据越小越靠前。要求是正整数。',
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`product_img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_img
-- ----------------------------

-- ----------------------------
-- Table structure for product_prop_imgs
-- ----------------------------
DROP TABLE IF EXISTS `product_prop_imgs`;
CREATE TABLE `product_prop_imgs` (
  `product_prop_imgs_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `props` varchar(512) DEFAULT NULL COMMENT '属性串(pid:vid),目前只有颜色属性.如:颜色:红色表示为　1627207:28326',
  `url` varchar(255) DEFAULT NULL COMMENT '图片地址.(绝对地址,格式:http://host/image_path)',
  `position` tinyint(4) DEFAULT NULL COMMENT '图片序号。产品里的图片展示顺序，数据越小越靠前。要求是正整数',
  PRIMARY KEY (`product_prop_imgs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_prop_imgs
-- ----------------------------

-- ----------------------------
-- Table structure for product_template
-- ----------------------------
DROP TABLE IF EXISTS `product_template`;
CREATE TABLE `product_template` (
  `product_templete_id` bigint(20) NOT NULL,
  `key_properties` varchar(512) DEFAULT NULL,
  `affect_properties` varchar(512) DEFAULT NULL COMMENT '产品绑定属性，内容为属性ID(PID)的列表,绑定属性肯定在类目上有，对应属性的类目特征，子属性请根据PID到类目上去取',
  `filter_properties` varchar(512) DEFAULT NULL COMMENT '过滤属性，内容有属性ID(PID)列表，很重要的属性，filter_properties包含的属性，必须填写',
  `cid` int(11) DEFAULT NULL,
  `prop_name_str` varchar(1024) DEFAULT NULL COMMENT '属性名称扁平化结构，只保证不在类目上的CP有值.100148233$剂型,100148233$剂型',
  `prop_features` varchar(255) DEFAULT NULL COMMENT '预留',
  PRIMARY KEY (`product_templete_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_template
-- ----------------------------

-- ----------------------------
-- Table structure for prop
-- ----------------------------
DROP TABLE IF EXISTS `prop`;
CREATE TABLE `prop` (
  `pid` bigint(20) NOT NULL,
  `cid` int(11) NOT NULL,
  `pname` varchar(255) NOT NULL,
  `pname_cn` varchar(255) DEFAULT NULL,
  `type` tinyint(4) NOT NULL DEFAULT '0',
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  `parent_pid` bigint(20) DEFAULT '0',
  `is_key_prop` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否关键属性',
  `is_sale_prop` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否销售属性',
  `is_color_prop` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否颜色属性',
  `is_enum_prop` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否枚举属性',
  `is_input_prop` tinyint(1) NOT NULL DEFAULT '0' COMMENT '在is_enum_prop是true的前提下，是否是卖家可以自行输入的属性',
  `is_item_prop` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否商品属性',
  `must` tinyint(1) NOT NULL DEFAULT '0' COMMENT '发布产品或商品时是否为必选属性',
  `multi` tinyint(1) NOT NULL DEFAULT '0' COMMENT '发布产品或商品时是否可以多选',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `sort_order` tinyint(4) NOT NULL DEFAULT '0',
  `is_allow_alias` tinyint(1) NOT NULL DEFAULT '0',
  `parent_vid` bigint(20) DEFAULT NULL COMMENT '上级属性值ID',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prop
-- ----------------------------

-- ----------------------------
-- Table structure for prop_value
-- ----------------------------
DROP TABLE IF EXISTS `prop_value`;
CREATE TABLE `prop_value` (
  `prop_value_id` bigint(20) NOT NULL,
  `cid` int(11) DEFAULT NULL,
  `vname` varchar(128) DEFAULT NULL,
  `name_alias` varchar(128) DEFAULT NULL,
  `is_parent` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为父类目属性',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态。可选值:normal(正常),deleted(删除)',
  `sort_order` tinyint(4) DEFAULT '0' COMMENT '排列序号。取值范围:大于零的整数',
  PRIMARY KEY (`prop_value_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prop_value
-- ----------------------------

-- ----------------------------
-- Table structure for prop_value_mapping
-- ----------------------------
DROP TABLE IF EXISTS `prop_value_mapping`;
CREATE TABLE `prop_value_mapping` (
  `prop_value_mapping_id` bigint(20) NOT NULL,
  `pid` bigint(20) NOT NULL,
  `vid` bigint(20) NOT NULL,
  PRIMARY KEY (`prop_value_mapping_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性和属性值关联表';

-- ----------------------------
-- Records of prop_value_mapping
-- ----------------------------
