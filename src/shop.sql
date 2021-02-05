/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2021-02-05 14:22:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(32) NOT NULL,
  `adminPassword` varchar(32) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` varchar(32) NOT NULL,
  `cname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '手机数码');
INSERT INTO `category` VALUES ('172934bd636d485c98fd2d3d9cccd409', '运动户外');
INSERT INTO `category` VALUES ('2', '电脑办公');
INSERT INTO `category` VALUES ('3', '家具家居');
INSERT INTO `category` VALUES ('4', '鞋靴箱包');
INSERT INTO `category` VALUES ('5', '图书音像');
INSERT INTO `category` VALUES ('6', '母婴孕婴');
INSERT INTO `category` VALUES ('afdba41a139b4320a74904485bdb7719', '汽车用品');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `itemid` varchar(32) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `pid` varchar(32) DEFAULT NULL,
  `oid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `fk_0001` (`pid`),
  KEY `fk_0002` (`oid`),
  CONSTRAINT `fk_0001` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `fk_0002` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('02BBE48BD6AC41B58E8F2E2A0DC2B0D2', '1', '4288', '15', '3D3CE1E4FD0D430AA98D7D43363128A4');
INSERT INTO `orderitem` VALUES ('0A1D13AB6BB44AC6942E7EAC45A5EE17', '1', '4399', '36', '6BF519C7BC8F4465BF9636C70EB11296');
INSERT INTO `orderitem` VALUES ('10A9D67F5BFF4238B8564459AA440065', '1', '6688', '32', 'D9ACE25E2C6D425A87C480819DAF096B');
INSERT INTO `orderitem` VALUES ('17705E1E96A04F5E9975BC3D46F9737F', '1', '1299', '1', '13FF19BA86E8421FBEAAA3459FA006CE');
INSERT INTO `orderitem` VALUES ('1988E301178848F4B8D6DE41A388E848', '2', '2598', '1', 'D9ACE25E2C6D425A87C480819DAF096B');
INSERT INTO `orderitem` VALUES ('4171EA87688A47AF9C7B4D573E79A66F', '2', '5198', '10', '65528860295B482AB006656AA7ABE139');
INSERT INTO `orderitem` VALUES ('48A437D936A64D3AA4135769686345D1', '1', '3999', '17', '5DCADDC82C6A4609A4F0A10F86013D1A');
INSERT INTO `orderitem` VALUES ('49792EE2EE5E4BA7839A7137AF9BBC37', '2', '5198', '10', '3583C1CEFE714A1094751D15E414A6D6');
INSERT INTO `orderitem` VALUES ('4F6B45DF8FA44B27B8DE006334E1C643', '1', '2298', '11', '044DD2859A3C41218A61347D9829FC3D');
INSERT INTO `orderitem` VALUES ('68DA0475BF684A658FCDA65664F06121', '1', '2599', '10', 'A9249C5250AF4B0F81F060FBA8E6F453');
INSERT INTO `orderitem` VALUES ('81C565AF409D4BD4A1DBE20DF0598B5C', '1', '600', 'DBC501F2BABB45F58E070F67B76D9505', '33C1D784ADCA42D2B96E8988B28442B9');
INSERT INTO `orderitem` VALUES ('8BD4C9050CCC40A3B9E3B0D0359F373B', '1', '2500', '8A66AD2655804BD794BE45866693D07F', 'ED28B51D6D9D430F94FDEB7B476473F9');
INSERT INTO `orderitem` VALUES ('97A0595BDD82407698DD706E3A58F7D0', '1', '2300', 'BC365D81D27E4ACCABE31BC8784BDB48', '615EEA23BD85492EABCADC6303700CF2');
INSERT INTO `orderitem` VALUES ('98954244B2EE4A31BE847C1270C13DC0', '1', '4087', '16', 'ED28B51D6D9D430F94FDEB7B476473F9');
INSERT INTO `orderitem` VALUES ('AA4EC0E8BE804D7DBCD026F32921EE57', '3', '7797', '10', '8BD2B0D34293425ABAD2F0E992F6CB2F');
INSERT INTO `orderitem` VALUES ('C2C6C045ADFA4A50A6F62F5D39D9C701', '1', '2298', '11', '3D3CE1E4FD0D430AA98D7D43363128A4');
INSERT INTO `orderitem` VALUES ('C7E1422EB711477798A08488731C6849', '1', '2599', '10', 'CBDC95942B954184B05BC28ED9D2B7D2');
INSERT INTO `orderitem` VALUES ('CD8E9338A16C451C966B762EEB043821', '1', '4288', '15', 'A9249C5250AF4B0F81F060FBA8E6F453');
INSERT INTO `orderitem` VALUES ('E1CE82B61A914485895BA70E6CFCCA38', '1', '2599', '10', '2573C2E5AA9745C98E3D3E758A19DF5F');
INSERT INTO `orderitem` VALUES ('EA842AB812354C90830622F71279C186', '1', '4499', '34', '3D3CE1E4FD0D430AA98D7D43363128A4');
INSERT INTO `orderitem` VALUES ('FFFFACEDBEEB47D79622E64D5DB42CC7', '1', '2599', '10', '6BF519C7BC8F4465BF9636C70EB11296');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` varchar(32) NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `uid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('044DD2859A3C41218A61347D9829FC3D', '2020-08-10 09:04:19', '2298', '0', null, null, null, null);
INSERT INTO `orders` VALUES ('13FF19BA86E8421FBEAAA3459FA006CE', '2020-07-19 17:00:27', '1299', '1', null, null, null, '2D0ABBF114654BEDBA309DFD6F761F55');
INSERT INTO `orders` VALUES ('2573C2E5AA9745C98E3D3E758A19DF5F', '2020-07-19 21:12:17', '2599', '1', null, null, null, '2D0ABBF114654BEDBA309DFD6F761F55');
INSERT INTO `orders` VALUES ('33C1D784ADCA42D2B96E8988B28442B9', '2020-08-10 09:36:30', '600', '1', '河南', '小吴', '15670033519', '2D0ABBF114654BEDBA309DFD6F761F55');
INSERT INTO `orders` VALUES ('3583C1CEFE714A1094751D15E414A6D6', '2020-07-19 21:14:07', '5198', '1', '杭州', '吴文', '15670023519', '2D0ABBF114654BEDBA309DFD6F761F55');
INSERT INTO `orders` VALUES ('3D3CE1E4FD0D430AA98D7D43363128A4', '2020-07-20 22:27:00', '11085', '1', '驻马店', '吴文', '123456', '2D0ABBF114654BEDBA309DFD6F761F55');
INSERT INTO `orders` VALUES ('5DCADDC82C6A4609A4F0A10F86013D1A', '2020-08-10 09:08:20', '3999', '1', '杭州', '吴文', '15836629370', null);
INSERT INTO `orders` VALUES ('615EEA23BD85492EABCADC6303700CF2', '2020-10-08 10:17:38', '2300', '0', '武汉', '柳', null, '2D0ABBF114654BEDBA309DFD6F761F55');
INSERT INTO `orders` VALUES ('65528860295B482AB006656AA7ABE139', '2020-07-19 17:02:35', '5198', '1', '上海', '柳', '123123', '2D0ABBF114654BEDBA309DFD6F761F55');
INSERT INTO `orders` VALUES ('6BF519C7BC8F4465BF9636C70EB11296', '2020-08-10 09:01:34', '6998', '0', '', null, null, null);
INSERT INTO `orders` VALUES ('8BD2B0D34293425ABAD2F0E992F6CB2F', '2020-07-19 17:04:43', '7797', '1', '北京', 'wuwen', '123123', '2D0ABBF114654BEDBA309DFD6F761F55');
INSERT INTO `orders` VALUES ('A9249C5250AF4B0F81F060FBA8E6F453', '2020-08-10 08:30:51', '6887', '0', null, null, null, null);
INSERT INTO `orders` VALUES ('CBDC95942B954184B05BC28ED9D2B7D2', '2020-07-19 21:12:36', '2599', '1', '上海', 'wuwen', '123456', '2D0ABBF114654BEDBA309DFD6F761F55');
INSERT INTO `orders` VALUES ('D9ACE25E2C6D425A87C480819DAF096B', '2020-08-09 18:30:15', '9286', '0', null, null, null, null);
INSERT INTO `orders` VALUES ('ED28B51D6D9D430F94FDEB7B476473F9', '2020-11-26 17:30:29', '6587', '0', null, null, null, '2D0ABBF114654BEDBA309DFD6F761F55');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` varchar(32) NOT NULL,
  `pname` varchar(50) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `shop_price` double DEFAULT NULL,
  `pimage` varchar(200) DEFAULT NULL,
  `pdate` date DEFAULT NULL,
  `is_hot` int(11) DEFAULT NULL,
  `pdesc` varchar(255) DEFAULT NULL,
  `pflag` int(11) DEFAULT NULL,
  `cid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `sfk_0001` (`cid`),
  CONSTRAINT `product` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('10', '华为 Ascend Mate7', '2699', '2599', 'products/1/c_0010.jpg', '2015-11-02', '1', '华为 Ascend Mate7 月光银 移动4G手机 双卡双待双通6英寸高清大屏，纤薄机身，智能超八核，按压式指纹识别！!选择下方“移动老用户4G飞享合约”，无需换号，还有话费每月返还！', '0', '1');
INSERT INTO `product` VALUES ('11', 'vivo X5Pro', '2399', '2298', 'products/1/c_0014.jpg', '2015-11-02', '1', '移动联通双4G手机 3G运存版 极光白【购机送蓝牙耳机+蓝牙自拍杆】新升级3G运行内存·双2.5D弧面玻璃·眼球识别技术', '0', '1');
INSERT INTO `product` VALUES ('12', '努比亚（nubia）My 布拉格', '1899', '1799', 'products/1/c_0013.jpg', '2015-11-02', '0', '努比亚（nubia）My 布拉格 银白 移动联通4G手机 双卡双待【嗨11，下单立减100】金属机身，快速充电！布拉格相机全新体验！', '0', '1');
INSERT INTO `product` VALUES ('13', '华为 麦芒4', '2599', '2499', 'products/1/c_0012.jpg', '2015-11-02', '1', '华为 麦芒4 晨曦金 全网通版4G手机 双卡双待金属机身 2.5D弧面屏 指纹解锁 光学防抖', '0', '1');
INSERT INTO `product` VALUES ('14', 'vivo X5M', '1899', '1799', 'products/1/c_0011.jpg', '2015-11-02', '0', 'vivo X5M 移动4G手机 双卡双待 香槟金【购机送蓝牙耳机+蓝牙自拍杆】5.0英寸大屏显示·八核双卡双待·Hi-Fi移动KTV', '0', '1');
INSERT INTO `product` VALUES ('15', 'Apple iPhone 6 (A1586)', '4399', '4288', 'products/1/c_0015.jpg', '2015-11-02', '1', 'Apple iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机长期省才是真的省！点击购机送费版，月月送话费，月月享优惠，畅享4G网络，就在联通4G！', '0', '1');
INSERT INTO `product` VALUES ('16', '华为 HUAWEI Mate S 臻享版', '4200', '4087', 'products/1/c_0016.jpg', '2015-11-03', '0', '华为 HUAWEI Mate S 臻享版 手机 极昼金 移动联通双4G(高配)满星评价即返30元话费啦；买就送电源+清水套+创意手机支架；优雅弧屏，mate7升级版', '0', '1');
INSERT INTO `product` VALUES ('17', '索尼(SONY) E6533 Z3+', '4099', '3999', 'products/1/c_0017.jpg', '2015-11-02', '0', '索尼(SONY) E6533 Z3+ 双卡双4G手机 防水防尘 涧湖绿索尼z3专业防水 2070万像素 移动联通双4G', '0', '1');
INSERT INTO `product` VALUES ('18', 'HTC One M9+', '3599', '3499', 'products/1/c_0018.jpg', '2015-11-02', '0', 'HTC One M9+（M9pw） 金银汇 移动联通双4G手机5.2英寸，8核CPU，指纹识别，UltraPixel超像素前置相机+2000万/200万后置双镜头相机！降价特卖，惊喜不断！', '0', '1');
INSERT INTO `product` VALUES ('19', 'HTC Desire 826d 32G 臻珠白', '1599', '1469', 'products/1/c_0020.jpg', '2015-11-02', '1', '后置1300万+UltraPixel超像素前置摄像头+【双】前置扬声器+5.5英寸【1080p】大屏！', '0', '1');
INSERT INTO `product` VALUES ('1D42B41575DA40EF9DDC8BA6D327F827', '运动鞋', '450', '1200', 'upload/xie.jpg', '2020-07-23', '1', '穿上特别的舒服，不臭脚', '0', '172934bd636d485c98fd2d3d9cccd409');
INSERT INTO `product` VALUES ('20', '小米 红米2A 增强版 白色', '649', '549', 'products/1/c_0019.jpg', '2015-11-02', '0', '新增至2GB 内存+16GB容量！4G双卡双待，联芯 4 核 1.5GHz 处理器！', '0', '1');
INSERT INTO `product` VALUES ('21', '魅族 魅蓝note2 16GB 白色', '1099', '999', 'products/1/c_0021.jpg', '2015-11-02', '0', '现货速抢，抢完即止！5.5英寸1080P分辨率屏幕，64位八核1.3GHz处理器，1300万像素摄像头，双色温双闪光灯！', '0', '1');
INSERT INTO `product` VALUES ('22', '三星 Galaxy S5 (G9008W) 闪耀白', '2099', '1999', 'products/1/c_0022.jpg', '2015-11-02', '1', '5.1英寸全高清炫丽屏，2.5GHz四核处理器，1600万像素', '0', '1');
INSERT INTO `product` VALUES ('23', 'sonim XP7700 4G手机', '1799', '1699', 'products/1/c_0023.jpg', '2015-11-09', '1', '三防智能手机 移动/联通双4G 安全 黑黄色 双4G美国军工IP69 30天长待机 3米防水防摔 北斗', '0', '1');
INSERT INTO `product` VALUES ('24', '努比亚（nubia）Z9精英版 金色', '3988', '3888', 'products/1/c_0024.jpg', '2015-11-02', '1', '移动联通电信4G手机 双卡双待真正的无边框！金色尊贵版！4GB+64GB大内存！', '0', '1');
INSERT INTO `product` VALUES ('25', 'Apple iPhone 6 Plus (A1524) 16GB 金色', '5188', '4988', 'products/1/c_0025.jpg', '2015-11-02', '0', 'Apple iPhone 6 Plus (A1524) 16GB 金色 移动联通电信4G手机 硬货 硬实力', '0', '1');
INSERT INTO `product` VALUES ('26', 'Apple iPhone 6s (A1700) 64G 玫瑰金色', '6388', '6088', 'products/1/c_0026.jpg', '2015-11-02', '0', 'Apple iPhone 6 Plus (A1524) 16GB 金色 移动联通电信4G手机 硬货 硬实力', '0', '1');
INSERT INTO `product` VALUES ('27', '三星 Galaxy Note5（N9200）32G版', '5588', '5388', 'products/1/c_0027.jpg', '2015-11-02', '0', '旗舰机型！5.7英寸大屏，4+32G内存！不一样的SPen更优化的浮窗指令！赠无线充电板！', '0', '1');
INSERT INTO `product` VALUES ('28', '三星 Galaxy S6 Edge+（G9280）32G版 铂光金', '5999', '5888', 'products/1/c_0028.jpg', '2015-11-02', '0', '赠移动电源+自拍杆+三星OTG金属U盘+无线充电器+透明保护壳', '0', '1');
INSERT INTO `product` VALUES ('29', 'LG G4（H818）陶瓷白 国际版', '3018', '2978', 'products/1/c_0029.jpg', '2015-11-02', '0', '李敏镐代言，F1.8大光圈1600万后置摄像头，5.5英寸2K屏，3G+32G内存，LG年度旗舰机！', '0', '1');
INSERT INTO `product` VALUES ('30', '微软(Microsoft) Lumia 640 LTE DS (RM-1113)', '1099', '999', 'products/1/c_0030.jpg', '2015-11-02', '0', '微软首款双网双卡双4G手机，5.0英寸高清大屏，双网双卡双4G！', '0', '1');
INSERT INTO `product` VALUES ('31', '宏碁（acer）ATC705-N50 台式电脑', '2399', '2299', 'products/1/c_0031.jpg', '2015-11-02', '0', '爆款直降，满千减百，品质宏碁，特惠来袭，何必苦等11.11，早买早便宜！', '0', '1');
INSERT INTO `product` VALUES ('32', 'Apple MacBook Air MJVE2CH/A 13.3英寸', '6788', '6688', 'products/1/c_0032.jpg', '2015-11-02', '0', '宽屏笔记本电脑 128GB 闪存', '0', '2');
INSERT INTO `product` VALUES ('33', '联想（ThinkPad） 轻薄系列E450C(20EH0001CD)', '4399', '4199', 'products/1/c_0033.jpg', '2015-11-02', '0', '联想（ThinkPad） 轻薄系列E450C(20EH0001CD)14英寸笔记本电脑(i5-4210U 4G 500G 2G独显 Win8.1)', '0', '2');
INSERT INTO `product` VALUES ('34', '联想（Lenovo）小新V3000经典版', '4599', '4499', 'products/1/c_0034.jpg', '2015-11-02', '0', '14英寸超薄笔记本电脑（i7-5500U 4G 500G+8G SSHD 2G独显 全高清屏）黑色满1000減100，狂减！火力全开，横扫3天！', '0', '2');
INSERT INTO `product` VALUES ('35', '华硕（ASUS）经典系列R557LI', '3799', '3699', 'products/1/c_0035.jpg', '2015-11-02', '0', '15.6英寸笔记本电脑（i5-5200U 4G 7200转500G 2G独显 D刻 蓝牙 Win8.1 黑色）', '0', '2');
INSERT INTO `product` VALUES ('36', '华硕（ASUS）X450J', '4599', '4399', 'products/1/c_0036.jpg', '2015-11-02', '0', '14英寸笔记本电脑 （i5-4200H 4G 1TB GT940M 2G独显 蓝牙4.0 D刻 Win8.1 黑色）', '0', '2');
INSERT INTO `product` VALUES ('37', '戴尔（DELL）灵越 飞匣3000系列', '3399', '3299', 'products/1/c_0037.jpg', '2015-11-03', '0', ' Ins14C-4528B 14英寸笔记本（i5-5200U 4G 500G GT820M 2G独显 Win8）黑', '0', '2');
INSERT INTO `product` VALUES ('38', '惠普(HP)WASD 暗影精灵', '5699', '5499', 'products/1/c_0038.jpg', '2015-11-02', '0', '15.6英寸游戏笔记本电脑(i5-6300HQ 4G 1TB+128G SSD GTX950M 4G独显 Win10)', '0', '2');
INSERT INTO `product` VALUES ('39', 'Apple 配备 Retina 显示屏的 MacBook', '11299', '10288', 'products/1/c_0039.jpg', '2015-11-02', '0', 'Pro MF840CH/A 13.3英寸宽屏笔记本电脑 256GB 闪存', '0', '2');
INSERT INTO `product` VALUES ('40', '机械革命（MECHREVO）MR X6S-M', '6799', '6599', 'products/1/c_0040.jpg', '2015-11-02', '0', '15.6英寸游戏本(I7-4710MQ 8G 64GSSD+1T GTX960M 2G独显 IPS屏 WIN7)黑色', '0', '1');
INSERT INTO `product` VALUES ('41', '神舟（HASEE） 战神K660D-i7D2', '5699', '5499', 'products/1/c_0041.jpg', '2015-11-02', '0', '15.6英寸游戏本(i7-4710MQ 8G 1TB GTX960M 2G独显 1080P)黑色', '0', '2');
INSERT INTO `product` VALUES ('42', '微星（MSI）GE62 2QC-264XCN', '6199', '5999', 'products/1/c_0042.jpg', '2015-11-02', '0', '15.6英寸游戏笔记本电脑（i5-4210H 8G 1T GTX960MG DDR5 2G 背光键盘）黑色', '0', '2');
INSERT INTO `product` VALUES ('43', '雷神（ThundeRobot）G150S', '5699', '5499', 'products/1/c_0043.jpg', '2015-11-02', '0', '15.6英寸游戏本 ( i7-4710MQ 4G 500G GTX950M 2G独显 包无亮点全高清屏) 金', '0', '2');
INSERT INTO `product` VALUES ('44', '惠普（HP）轻薄系列 HP', '3199', '3099', 'products/1/c_0044.jpg', '2015-11-02', '0', '15-r239TX 15.6英寸笔记本电脑（i5-5200U 4G 500G GT820M 2G独显 win8.1）金属灰', '0', '2');
INSERT INTO `product` VALUES ('45', '未来人类（Terrans Force）T5', '10999', '9899', 'products/1/c_0045.jpg', '2015-11-02', '0', '15.6英寸游戏本（i7-5700HQ 16G 120G固态+1TB GTX970M 3G GDDR5独显）黑', '0', '2');
INSERT INTO `product` VALUES ('46', '戴尔（DELL）Vostro 3800-R6308 台式电脑', '3299', '3199', 'products/1/c_0046.jpg', '2015-11-02', '0', '（i3-4170 4G 500G DVD 三年上门服务 Win7）黑', '0', '2');
INSERT INTO `product` VALUES ('47', '联想（Lenovo）H3050 台式电脑', '5099', '4899', 'products/1/c_0047.jpg', '2015-11-11', '0', '（i5-4460 4G 500G GT720 1G独显 DVD 千兆网卡 Win10）23英寸', '0', '2');
INSERT INTO `product` VALUES ('48', 'Apple iPad mini 2 ME279CH/A', '2088', '1888', 'products/1/c_0048.jpg', '2015-11-02', '0', '（配备 Retina 显示屏 7.9英寸 16G WLAN 机型 银色）', '0', '1');
INSERT INTO `product` VALUES ('49', '小米（MI）7.9英寸平板', '1399', '1299', 'products/1/c_0049.jpg', '2015-11-02', '0', 'WIFI 64GB（NVIDIA Tegra K1 2.2GHz 2G 64G 2048*1536视网膜屏 800W）白色', '0', '1');
INSERT INTO `product` VALUES ('50', 'Apple iPad Air 2 MGLW2CH/A', '2399', '2299', 'products/1/c_0050.jpg', '2015-11-12', '0', '（9.7英寸 16G WLAN 机型 银色）', '0', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(32) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('09EA8845ACCD415787D83DB861E893D2', 'wwwww', '123456', 'wewwer', '231423@qq.com', '23423', '1999-03-03', '女', '1', null);
INSERT INTO `user` VALUES ('373eb242933b4f5ca3bd43503c34668b', 'wuwen', '123456', 'wuwen', '2223003379@qq.com', '15836693700', '1998-02-01', '男', '1', null);
INSERT INTO `user` VALUES ('3ca76a75e4f64db2bacd0974acc7c897', 'tom', '123456', 'tom', '5464565@qq.com', '15644648', '1999-03-03', '男', '1', null);
INSERT INTO `user` VALUES ('62145f6e66ea4f5cbe7b6f6b954917d3', 'xiaoqi', '123456', '小七', '4568456@qq.com', '23423', '1996-02-12', '女', '1', null);
INSERT INTO `user` VALUES ('B61DF11F066B40E8BD58A257FD1D6DFC', 'fahai', '123456', '法海', '666666@qq.com', '4654841365', '0001-01-01', '男', '0', 'FA45EE3872F042D4A7EA3F871EDD7AC0');
INSERT INTO `user` VALUES ('D77B837334194C71974448328B3A586C', 'admin', 'admin', 'admin', 'admin@qq.com', '123', '2011-05-09', '男', '1', null);
INSERT INTO `user` VALUES ('E9EA436F3F914A4399A2BF0775B42AB7', 'www', 'www', 'www', '2223003399@qq.com', null, '2021-02-01', 'man', '0', '6999F6914F1D43F68C9824150108A9A2');
INSERT INTO `user` VALUES ('F48CFDE163734C76892C382C0A950542', 'baise', '123456', '白蛇', '999999@qq.com', '45646', '0001-02-02', '女', '1', null);
