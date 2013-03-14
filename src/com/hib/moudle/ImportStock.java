package com.hib.moudle;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ImportStock entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "import_stock", catalog = "gopiao")
public class ImportStock extends AbstractImportStock implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public ImportStock() {
	}

	/** minimal constructor */
	public ImportStock(String id, String 导入日期, String 代码, String 名称) {
		super(id, 导入日期, 代码, 名称);
	}

	/** full constructor */
	public ImportStock(String id, String 导入日期, String 代码, String 名称,
			String 涨幅率, String 现价, String 涨跌, String 买入价, String 卖出价,
			String 总量, String 现量, String 涨速率, String 换手率, String 今开, String 昨收,
			String 最高, String 最低, String 市盈dong, String 总金额, String 振幅率,
			String 流通股本, String 所属行业, String 量比, String 均价, String 委比率,
			String 内盘, String 外盘, String 内外比, String 委量差, String 买量一,
			String 卖量一, String 买价一, String 卖价一, String 卖价二, String 卖量二,
			String 买价二, String 买量二, String 买价三, String 买量三, String 卖价三,
			String 卖量三, String 流通市值, String ab股总市值, String 多空平衡, String 多头获利,
			String 多头止损, String 空头回补, String 空头止损, String 强弱度率, String 活跃度,
			String 每笔均量, String 每笔换手, String 更新日期, String 上市日期, String 总股本wan,
			String 国家股, String 利润同比, String 收入同比, String b股或a, String h股,
			String 职工股, String 总资产wan, String 流动资产, String 固定资产, String 无形资产,
			String 长期投资, String 流动负债, String 长期负债, String 公积金, String 每股公积,
			String 净资产, String 主营收入, String 主营利润, String 市净率, String 营业利润,
			String 投资收益, String 经营现金流, String 总现金流, String 存货, String 利润总额,
			String 税后利润, String 净利润, String 未分利润, String 每股净资, String 调整后净资,
			String 净益率, String 每股未分配, String 每股收益, String 权益比率) {
		super(id, 导入日期, 代码, 名称, 涨幅率, 现价, 涨跌, 买入价, 卖出价, 总量, 现量, 涨速率, 换手率, 今开,
				昨收, 最高, 最低, 市盈dong, 总金额, 振幅率, 流通股本, 所属行业, 量比, 均价, 委比率, 内盘, 外盘,
				内外比, 委量差, 买量一, 卖量一, 买价一, 卖价一, 卖价二, 卖量二, 买价二, 买量二, 买价三, 买量三,
				卖价三, 卖量三, 流通市值, ab股总市值, 多空平衡, 多头获利, 多头止损, 空头回补, 空头止损, 强弱度率,
				活跃度, 每笔均量, 每笔换手, 更新日期, 上市日期, 总股本wan, 国家股, 利润同比, 收入同比, b股或a, h股,
				职工股, 总资产wan, 流动资产, 固定资产, 无形资产, 长期投资, 流动负债, 长期负债, 公积金, 每股公积,
				净资产, 主营收入, 主营利润, 市净率, 营业利润, 投资收益, 经营现金流, 总现金流, 存货, 利润总额, 税后利润,
				净利润, 未分利润, 每股净资, 调整后净资, 净益率, 每股未分配, 每股收益, 权益比率);
	}

}
