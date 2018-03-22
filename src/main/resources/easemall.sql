/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50625
Source Host           : 127.0.0.1:3306
Source Database       : easemall

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2018-03-22 15:25:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cartId` int(11) NOT NULL AUTO_INCREMENT,
  `prodId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  `isBuy` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`cartId`),
  KEY `cartProd` (`prodId`),
  KEY `cartUser` (`userId`),
  CONSTRAINT `cartProd` FOREIGN KEY (`prodId`) REFERENCES `product` (`prodId`),
  CONSTRAINT `cartUser` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('111', '13', '0', '1', '1');
INSERT INTO `cart` VALUES ('112', '10', '0', '1', '1');
INSERT INTO `cart` VALUES ('113', '12', '0', '1', '1');
INSERT INTO `cart` VALUES ('114', '18', '0', '1', '1');
INSERT INTO `cart` VALUES ('115', '22', '0', '1', '1');
INSERT INTO `cart` VALUES ('116', '19', '0', '1', '1');
INSERT INTO `cart` VALUES ('117', '2', '0', '4', '1');
INSERT INTO `cart` VALUES ('118', '21', '0', '1', '0');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `prodId` int(11) NOT NULL,
  `prodTitle` varchar(255) DEFAULT NULL,
  `prodImgUrl` varchar(255) DEFAULT NULL,
  `prodPrice` double DEFAULT NULL,
  `prodNum` int(11) DEFAULT NULL,
  `buyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `orderUser` (`userId`),
  KEY `orderProd` (`prodId`),
  CONSTRAINT `orderProd` FOREIGN KEY (`prodId`) REFERENCES `product` (`prodId`),
  CONSTRAINT `orderUser` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=384 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('377', '0', '13', '神经网络算法与实现 基于Java语言', 'http://img14.360buyimg.com/n7/jfs/t7360/123/1084613304/153775/65018bcd/599a668bN381d917e.jpg', '49', '1', '2018-03-04 19:26:50');
INSERT INTO `orders` VALUES ('378', '0', '10', '联想(Lenovo)小新潮7000 13.3英寸超轻薄窄边框笔记本电脑(i5-8250U 8G 256G PCIE MX150 2G)花火银', 'http://img14.360buyimg.com/n7/jfs/t10123/170/1203650051/249444/b4748f86/59ddb765N62523179.jpg', '5500', '1', '2018-03-04 19:34:07');
INSERT INTO `orders` VALUES ('379', '0', '12', 'Java编程思想（第4版）', 'http://img14.360buyimg.com/n7/jfs/t2191/111/699154754/198998/32d7bfe0/5624b582Nbc01af5b.jpg', '86', '1', '2018-03-04 19:57:50');
INSERT INTO `orders` VALUES ('380', '0', '18', 'Java并发编程的艺术', 'http://img14.360buyimg.com/n7/jfs/t1312/364/1104231705/156699/523dc84c/55b87a5eN09430825.jpg', '46', '1', '2018-03-04 20:03:04');
INSERT INTO `orders` VALUES ('381', '0', '22', 'fdafds', 'http://img14.360buyimg.com/n7/jfs/t2191/111/699154754/198998/32d7bfe0/5624b582Nbc01af5b.jpg', '22.3', '1', '2018-03-04 20:11:59');
INSERT INTO `orders` VALUES ('382', '0', '19', '疯狂Java讲义（第3版 附光盘）', 'http://img11.360buyimg.com/n7/jfs/t259/72/825065534/304211/8c4d7efa/53f1ccfeN9cf15811.jpg', '85.9', '1', '2018-03-04 20:16:12');
INSERT INTO `orders` VALUES ('383', '0', '2', '酷耶（Cooyes） i5四核/GTX1060独显/台式机电脑主机整机全套组装家用游戏 套餐一(GTX750独显电脑主机)', 'http://img14.360buyimg.com/n7/jfs/t6040/215/8121726492/353140/430b7c0a/59859394Nabbd69aa.jpg', '1670', '4', '2018-03-22 11:50:31');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `prodId` int(11) NOT NULL AUTO_INCREMENT,
  `prodTitle` varchar(255) DEFAULT NULL,
  `prodImgUrl` varchar(255) DEFAULT NULL,
  `prodSummary` varchar(255) DEFAULT NULL,
  `prodDetail` varchar(255) DEFAULT NULL,
  `prodPrice` double DEFAULT NULL,
  `isBuy` tinyint(1) DEFAULT '0',
  `isSell` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`prodId`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('2', '酷耶（Cooyes） i5四核/GTX1060独显/台式机电脑主机整机全套组装家用游戏 套餐一(GTX750独显电脑主机)', 'http://img14.360buyimg.com/n7/jfs/t6040/215/8121726492/353140/430b7c0a/59859394Nabbd69aa.jpg', '酷耶（Cooyes） i5四核/GTX1060独显/台式机电脑主机整机全套组装家用游戏 套餐一(GTX750独显电脑主机)', '酷耶（Cooyes） i5四核/GTX1060独显/台式机电脑主机整机全套组装家用游戏 套餐一(GTX750独显电脑主机)', '1670', '1', '1');
INSERT INTO `product` VALUES ('3', '联想(Lenovo)拯救者R720 15.6英寸大屏游戏笔记本电脑(i5-7300HQ 8G 1T+128G SSD GTX1050Ti 4G IPS 黑金)', 'http://img11.360buyimg.com/n7/jfs/t15049/87/1663809259/215478/4effd883/5a54725aNc2bfede3.jpg', '全新升级，吃鸡利器！拯救者“黑金”耀眼归来！“双硬盘”硬实力，玩儿视觉来“4G”！', '全新升级，吃鸡利器！拯救者“黑金”耀眼归来！“双硬盘”硬实力，玩儿视觉来“4G”！', '6399', '0', '0');
INSERT INTO `product` VALUES ('4', 'Apple MacBook Air 13.3英寸笔记本电脑 银色(2017新款Core i5 处理器/8GB内存/128GB闪存 MQD32CH/A)', 'http://img11.360buyimg.com/n7/jfs/t14848/365/2076510540/93902/e5883831/5a6947e5N39e16ed8.jpg', 'Apple产品年终盛典盛大开启！为您提供JD Care全方位一站式无忧服务，爆款惊喜，年货有新意！点击抢购》》', 'Apple产品年终盛典盛大开启！为您提供JD Care全方位一站式无忧服务，爆款惊喜，年货有新意！点击抢购》》', '5978', '0', '0');
INSERT INTO `product` VALUES ('5', 'Apple MacBook Air 13.3英寸笔记本电脑 银色(2017新款Core i5 处理器/8GB内存/256GB闪存 MQD42CH/A)', 'http://img14.360buyimg.com/n7/jfs/t17278/112/289194901/93902/e5883831/5a6947f0Nd79371e9.jpg', 'Apple产品年终盛典盛大开启！为您提供JD Care全方位一站式无忧服务，爆款惊喜，年货有新意！点击抢购》》', 'Apple产品年终盛典盛大开启！为您提供JD Care全方位一站式无忧服务，爆款惊喜，年货有新意！点击抢购》》', '7899', '0', '0');
INSERT INTO `product` VALUES ('6', '联想（ThinkPad） E470c（20H3A013CD）14英寸笔记本电脑（i5-6200U 8G 500G Win10）黑色', 'http://img13.360buyimg.com/n7/jfs/t15829/126/959661776/261455/2b01e587/5a434431Na02cd79b.jpg', '180度屏幕开合，轻至1.9KG！【ThinkPad年货节】爆品直降!白条3期免息', '180度屏幕开合，轻至1.9KG！【ThinkPad年货节】爆品直降!白条3期免息', '3999', '0', '0');
INSERT INTO `product` VALUES ('7', '小米(MI)Air 13.3英寸全金属轻薄笔记本(i5-7200U 8G 256G PCle SSD MX150 2G独显 FHD 指纹识别 Win10）银', 'http://img12.360buyimg.com/n7/jfs/t6700/155/2098998076/156185/6cf95035/595dd5a5Nc3a7dab5.jpg', '【春节也送货】【i5 MX150 2G显存】全贴合无边式玻璃覆盖 全高清窄边框 8G内存 256固态硬盘', '【春节也送货】【i5 MX150 2G显存】全贴合无边式玻璃覆盖 全高清窄边框 8G内存 256固态硬盘', '4999', '0', '0');
INSERT INTO `product` VALUES ('8', '联想(Lenovo)拯救者R720 GTX1060 MaxQ 15.6英寸游戏笔记本电脑(i7-7700HQ 8G 1T+128G SSD 6G IPS 黑)', 'http://img13.360buyimg.com/n7/jfs/t11926/217/1309283752/228477/f2ea2a50/59ffd522N9a0b3428.jpg', '【’吃鸡’利器GTX1060Max-Q 性能超越GTX980M！】流畅支持各种游戏大作 超强散热劲爆性能', '【’吃鸡’利器GTX1060Max-Q 性能超越GTX980M！】流畅支持各种游戏大作 超强散热劲爆性能', '8699', '0', '0');
INSERT INTO `product` VALUES ('9', '联想（ThinkPad） E470c（20H3A004CD）14英寸笔记本电脑（i5-6200U 8G 500G 2G独显 Win10）黑色', 'http://img14.360buyimg.com/n7/jfs/t16357/52/866540934/261455/2b01e587/5a434797N1299bda3.jpg', '8G大内存主推！ 23.7mm，高效5小时续航！【ThinkPad年货节】爆品直降!白条3期免息', '8G大内存主推！ 23.7mm，高效5小时续航！【ThinkPad年货节】爆品直降!白条3期免息', '4288', '0', '0');
INSERT INTO `product` VALUES ('10', '联想(Lenovo)小新潮7000 13.3英寸超轻薄窄边框笔记本电脑(i5-8250U 8G 256G PCIE MX150 2G)花火银', 'http://img14.360buyimg.com/n7/jfs/t10123/170/1203650051/249444/b4748f86/59ddb765N62523179.jpg', '【薄出位 潮生活】三面微边框全高清IPS屏，轻至1.2Kg，采用intel8代CPU+MX150 显卡，性能提升超30%', '【薄出位 潮生活】三面微边框全高清IPS屏，轻至1.2Kg，采用intel8代CPU+MX150 显卡，性能提升超30%', '5500', '1', '1');
INSERT INTO `product` VALUES ('11', '小米(MI)Pro 15.6英寸金属轻薄笔记本(i5-8250U 8G 256GSSD MX150 2G独显 FHD 指纹识别 预装office)深空灰', 'http://img12.360buyimg.com/n7/jfs/t8296/12/1239838463/285989/d34a93fa/59b62c9cN36ac48fa.jpg', '【春节也送货】【告别显示器轻装上阵】【15.6英寸MX150轻薄本】第八代酷睿I5处理器 256G SSD疾速启动', '【春节也送货】【告别显示器轻装上阵】【15.6英寸MX150轻薄本】第八代酷睿I5处理器 256G SSD疾速启动', '5599', '0', '0');
INSERT INTO `product` VALUES ('12', 'Java编程思想（第4版）', 'http://img14.360buyimg.com/n7/jfs/t2191/111/699154754/198998/32d7bfe0/5624b582Nbc01af5b.jpg', 'Java编程思想（第4版）', 'Java编程思想（第4版）', '86.4', '1', '1');
INSERT INTO `product` VALUES ('13', '神经网络算法与实现 基于Java语言', 'http://img14.360buyimg.com/n7/jfs/t7360/123/1084613304/153775/65018bcd/599a668bN381d917e.jpg', '用Java代码释放神经网络无穷力量', '用Java代码释放神经网络无穷力量', '48.7', '1', '1');
INSERT INTO `product` VALUES ('14', '深入分析Java Web技术内幕（修订版）', 'http://img10.360buyimg.com/n7/jfs/t226/69/852287594/266745/75deb0d4/53f1cd0fN3c47b9d0.jpg', '阿里巴巴集团技术丛书。技术大牛范禹、玉伯、毕玄联合力荐！大型互联网公司开发应用实践！', '阿里巴巴集团技术丛书。技术大牛范禹、玉伯、毕玄联合力荐！大型互联网公司开发应用实践！', '62.4', '0', '0');
INSERT INTO `product` VALUES ('15', 'Java核心技术 卷I：基础知识（原书第10版）', 'http://img13.360buyimg.com/n7/jfs/t3214/126/2309313357/292133/6c038027/57e09a03Nc57334e1.jpg', '全新第10版！Java领域极具影响力和价值的著作之一，与《Java编程思想》齐名，10余年全球畅销不衰，广受好评', '全新第10版！Java领域极具影响力和价值的著作之一，与《Java编程思想》齐名，10余年全球畅销不衰，广受好评', '93', '0', '0');
INSERT INTO `product` VALUES ('16', 'Java从入门到精通（第4版 附光盘）', 'http://img10.360buyimg.com/n7/jfs/t3775/118/1324998209/351033/2016778a/5823e5f9N2eee28eb.jpg', 'java入门经典书持续八年畅销累计63次重印 32小时视频 732个经典实例 369项面试真题 616项测试 30个模块及案例  PPT电子课件 入门 范例 项目实战全覆盖 随书附赠小白手册电子版', 'java入门经典书持续八年畅销累计63次重印 32小时视频 732个经典实例 369项面试真题 616项测试 30个模块及案例  PPT电子课件 入门 范例 项目实战全覆盖 随书附赠小白手册电子版', '49.8', '0', '0');
INSERT INTO `product` VALUES ('17', '全国计算机等级考试二级教程 Java语言程序设计（2018年版）', 'http://img11.360buyimg.com/n7/jfs/t13828/310/1016211549/234884/ab178b0b/5a17b5e0N2e0e8f6c.jpg', '大纲指定教材，重大修订；命题单位组织高校资深专家编写，内容精准，学完即考；', '大纲指定教材，重大修订；命题单位组织高校资深专家编写，内容精准，学完即考；', '34.9', '0', '0');
INSERT INTO `product` VALUES ('18', 'Java并发编程的艺术', 'http://img14.360buyimg.com/n7/jfs/t1312/364/1104231705/156699/523dc84c/55b87a5eN09430825.jpg', '阿里巴巴技术专家/Java并发编程领域领军人物撰写，从JDK源码、JVM、CPU多角度剖析并发编程原理和核心技术', '阿里巴巴技术专家/Java并发编程领域领军人物撰写，从JDK源码、JVM、CPU多角度剖析并发编程原理和核心技术', '46.4', '1', '1');
INSERT INTO `product` VALUES ('19', '疯狂Java讲义（第3版 附光盘）', 'http://img11.360buyimg.com/n7/jfs/t259/72/825065534/304211/8c4d7efa/53f1ccfeN9cf15811.jpg', 'Java经典全面升级，国内覆盖Java 8全特性的书籍，赠送880分钟视频讲解、550多个实例及详实课件', 'Java经典全面升级，国内覆盖Java 8全特性的书籍，赠送880分钟视频讲解、550多个实例及详实课件', '85.9', '1', '1');
INSERT INTO `product` VALUES ('20', '第一行代码 Java 视频讲解版', 'http://img13.360buyimg.com/n7/jfs/t4510/23/3208748180/99674/d679cf55/58f81c54N6cd71dde.jpg', 'Java从入门到精通书籍 国内原创经典Java入门书 Java教学名师视频教学 程序员笔试面试宝典 超过60小时教学视频 600多个实例 200余道常见面试题 400多个提示', 'Java从入门到精通书籍 国内原创经典Java入门书 Java教学名师视频教学 程序员笔试面试宝典 超过60小时教学视频 600多个实例 200余道常见面试题 400多个提示', '70.3', '0', '0');
INSERT INTO `product` VALUES ('21', 'Java微服务', 'http://img10.360buyimg.com/n7/jfs/t3739/14/2394977887/310369/675c16f7/58517428Ne3f9e2f9.jpg', 'Spring Boot|Spring Security|REST|Docker|DDD|OSS全线贯通', 'Spring Boot|Spring Security|REST|Docker|DDD|OSS全线贯通', '54.4', '0', '0');
INSERT INTO `product` VALUES ('22', 'fdafds', 'http://img14.360buyimg.com/n7/jfs/t2191/111/699154754/198998/32d7bfe0/5624b582Nbc01af5b.jpg', 'fdsa', 'fdafdsa', '22.3', '1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT '',
  `userPwd` varchar(255) DEFAULT NULL,
  `userType` int(11) DEFAULT NULL COMMENT '0为买家，1为卖家',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', 'buyer', '37254660e226ea65ce6f1efd54233424', '0');
INSERT INTO `user` VALUES ('1', 'seller', '981c57a5cfb0f868e064904b8745766f', '1');
