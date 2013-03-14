CREATE DATABASE IF NOT EXISTS gopiao
/*
MySQL Data Transfer
Source Host: localhost
Source Database: gopiao
Target Host: localhost
Target Database: gopiao
Date: 2012-8-16 15:25:42
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for filemd5
-- ----------------------------
DROP TABLE IF EXISTS `filemd5`;
CREATE TABLE `filemd5` (
  `ID` varchar(36) NOT NULL,
  `filename` varchar(100) default NULL,
  `md5` varchar(100) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for import_stock
-- ----------------------------
DROP TABLE IF EXISTS `import_stock`;
CREATE TABLE `import_stock` (
  `ID` varchar(36) NOT NULL,
  `导入日期` varchar(19) NOT NULL,
  `名称` varchar(30) default NULL,
  `AB股总市值` varchar(15) default NULL,
  `B股或A` varchar(10) default NULL,
  `H股` varchar(15) default NULL,
  `上市日期` varchar(10) default NULL,
  `主营利润` varchar(15) default NULL,
  `主营收入` varchar(15) default NULL,
  `买价一` varchar(8) default NULL,
  `买价三` varchar(8) default NULL,
  `买价二` varchar(8) default NULL,
  `买入价` varchar(8) default NULL,
  `买量一` varchar(10) default NULL,
  `买量三` varchar(10) default NULL,
  `买量二` varchar(10) default NULL,
  `今开` varchar(8) default NULL,
  `代码` varchar(10) default NULL,
  `公积金` varchar(15) default NULL,
  `内外比` varchar(8) default NULL,
  `内盘` varchar(15) default NULL,
  `净利润` varchar(15) default NULL,
  `净益率` varchar(10) default NULL,
  `净资产` varchar(15) default NULL,
  `利润同比` varchar(15) default NULL,
  `利润总额` varchar(15) default NULL,
  `卖价一` varchar(8) default NULL,
  `卖价三` varchar(8) default NULL,
  `卖价二` varchar(8) default NULL,
  `卖出价` varchar(8) default NULL,
  `卖量一` varchar(10) default NULL,
  `卖量三` varchar(10) default NULL,
  `卖量二` varchar(10) default NULL,
  `固定资产` varchar(15) default NULL,
  `国家股` varchar(15) default NULL,
  `均价` varchar(8) default NULL,
  `外盘` varchar(15) default NULL,
  `多头止损` varchar(8) default NULL,
  `多头获利` varchar(8) default NULL,
  `多空平衡` varchar(8) default NULL,
  `委比率` varchar(8) default NULL,
  `委量差` varchar(10) default NULL,
  `存货` varchar(15) default NULL,
  `市净率` varchar(8) default NULL,
  `市盈dong` varchar(15) default NULL,
  `强弱度率` varchar(8) default NULL,
  `总现金流` varchar(15) default NULL,
  `总股本wan` varchar(15) default NULL,
  `总资产wan` varchar(15) default NULL,
  `总量` varchar(15) default NULL,
  `总金额` varchar(15) default NULL,
  `所属行业` varchar(10) default NULL,
  `投资收益` varchar(15) default NULL,
  `振幅率` varchar(8) default NULL,
  `换手率` varchar(8) default NULL,
  `收入同比` varchar(15) default NULL,
  `无形资产` varchar(15) default NULL,
  `昨收` varchar(8) default NULL,
  `更新日期` varchar(10) default NULL,
  `最低` varchar(8) default NULL,
  `最高` varchar(8) default NULL,
  `未分利润` varchar(15) default NULL,
  `权益比率` varchar(8) default NULL,
  `每笔均量` varchar(8) default NULL,
  `每笔换手` varchar(8) default NULL,
  `每股公积` varchar(8) default NULL,
  `每股净资` varchar(8) default NULL,
  `每股收益` varchar(10) default NULL,
  `每股未分配` varchar(8) default NULL,
  `活跃度` varchar(8) default NULL,
  `流动负债` varchar(15) default NULL,
  `流动资产` varchar(15) default NULL,
  `流通市值` varchar(15) default NULL,
  `流通股本` varchar(18) default NULL,
  `涨幅率` varchar(8) default NULL,
  `涨跌` varchar(8) default NULL,
  `涨速率` varchar(8) default NULL,
  `现价` varchar(8) default NULL,
  `现量` varchar(15) default NULL,
  `税后利润` varchar(15) default NULL,
  `空头回补` varchar(8) default NULL,
  `空头止损` varchar(8) default NULL,
  `经营现金流` varchar(15) default NULL,
  `职工股` varchar(8) default NULL,
  `营业利润` varchar(15) default NULL,
  `调整后净资` varchar(8) default NULL,
  `量比` varchar(8) default NULL,
  `长期投资` varchar(15) default NULL,
  `长期负债` varchar(15) default NULL,
  `开盘` varchar(15) default NULL,
  `收盘` varchar(15) default NULL,
  `成交额` varchar(15) default NULL,
  `成交量` varchar(15) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
