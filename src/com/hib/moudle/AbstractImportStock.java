package com.hib.moudle;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractImportStock entity provides the base persistence definition of the
 * ImportStock entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractImportStock implements java.io.Serializable {

	// Fields

	private String id;
	private String 导入日期;
	private String 代码;
	private String 名称;
	private String 涨幅率;
	private String 现价;
	private String 涨跌;
	private String 买入价;
	private String 卖出价;
	private String 总量;
	private String 现量;
	private String 涨速率;
	private String 换手率;
	private String 今开;
	private String 昨收;
	private String 最高;
	private String 最低;
	private String 市盈dong;
	private String 总金额;
	private String 振幅率;
	private String 流通股本;
	private String 所属行业;
	private String 量比;
	private String 均价;
	private String 委比率;
	private String 内盘;
	private String 外盘;
	private String 内外比;
	private String 委量差;
	private String 买量一;
	private String 卖量一;
	private String 买价一;
	private String 卖价一;
	private String 卖价二;
	private String 卖量二;
	private String 买价二;
	private String 买量二;
	private String 买价三;
	private String 买量三;
	private String 卖价三;
	private String 卖量三;
	private String 流通市值;
	private String ab股总市值;
	private String 多空平衡;
	private String 多头获利;
	private String 多头止损;
	private String 空头回补;
	private String 空头止损;
	private String 强弱度率;
	private String 活跃度;
	private String 每笔均量;
	private String 每笔换手;
	private String 更新日期;
	private String 上市日期;
	private String 总股本wan;
	private String 国家股;
	private String 利润同比;
	private String 收入同比;
	private String b股或a;
	private String h股;
	private String 职工股;
	private String 总资产wan;
	private String 流动资产;
	private String 固定资产;
	private String 无形资产;
	private String 长期投资;
	private String 流动负债;
	private String 长期负债;
	private String 公积金;
	private String 每股公积;
	private String 净资产;
	private String 主营收入;
	private String 主营利润;
	private String 市净率;
	private String 营业利润;
	private String 投资收益;
	private String 经营现金流;
	private String 总现金流;
	private String 存货;
	private String 利润总额;
	private String 税后利润;
	private String 净利润;
	private String 未分利润;
	private String 每股净资;
	private String 调整后净资;
	private String 净益率;
	private String 每股未分配;
	private String 每股收益;
	private String 权益比率;
	private String 开盘;
	private String 收盘;
	private String 成交额;
	private String 成交量;

	// Constructors

	/** default constructor */
	public AbstractImportStock() {
	}

	/** minimal constructor */
	public AbstractImportStock(String id, String 导入日期, String 代码, String 名称) {
		this.id = id;
		this.导入日期 = 导入日期;
		this.代码 = 代码;
		this.名称 = 名称;
	}

	/** full constructor */
	public AbstractImportStock(String id, String 导入日期, String 代码, String 名称,
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
		this.id = id;
		this.导入日期 = 导入日期;
		this.代码 = 代码;
		this.名称 = 名称;
		this.涨幅率 = 涨幅率;
		this.现价 = 现价;
		this.涨跌 = 涨跌;
		this.买入价 = 买入价;
		this.卖出价 = 卖出价;
		this.总量 = 总量;
		this.现量 = 现量;
		this.涨速率 = 涨速率;
		this.换手率 = 换手率;
		this.今开 = 今开;
		this.昨收 = 昨收;
		this.最高 = 最高;
		this.最低 = 最低;
		this.市盈dong = 市盈dong;
		this.总金额 = 总金额;
		this.振幅率 = 振幅率;
		this.流通股本 = 流通股本;
		this.所属行业 = 所属行业;
		this.量比 = 量比;
		this.均价 = 均价;
		this.委比率 = 委比率;
		this.内盘 = 内盘;
		this.外盘 = 外盘;
		this.内外比 = 内外比;
		this.委量差 = 委量差;
		this.买量一 = 买量一;
		this.卖量一 = 卖量一;
		this.买价一 = 买价一;
		this.卖价一 = 卖价一;
		this.卖价二 = 卖价二;
		this.卖量二 = 卖量二;
		this.买价二 = 买价二;
		this.买量二 = 买量二;
		this.买价三 = 买价三;
		this.买量三 = 买量三;
		this.卖价三 = 卖价三;
		this.卖量三 = 卖量三;
		this.流通市值 = 流通市值;
		this.ab股总市值 = ab股总市值;
		this.多空平衡 = 多空平衡;
		this.多头获利 = 多头获利;
		this.多头止损 = 多头止损;
		this.空头回补 = 空头回补;
		this.空头止损 = 空头止损;
		this.强弱度率 = 强弱度率;
		this.活跃度 = 活跃度;
		this.每笔均量 = 每笔均量;
		this.每笔换手 = 每笔换手;
		this.更新日期 = 更新日期;
		this.上市日期 = 上市日期;
		this.总股本wan = 总股本wan;
		this.国家股 = 国家股;
		this.利润同比 = 利润同比;
		this.收入同比 = 收入同比;
		this.b股或a = b股或a;
		this.h股 = h股;
		this.职工股 = 职工股;
		this.总资产wan = 总资产wan;
		this.流动资产 = 流动资产;
		this.固定资产 = 固定资产;
		this.无形资产 = 无形资产;
		this.长期投资 = 长期投资;
		this.流动负债 = 流动负债;
		this.长期负债 = 长期负债;
		this.公积金 = 公积金;
		this.每股公积 = 每股公积;
		this.净资产 = 净资产;
		this.主营收入 = 主营收入;
		this.主营利润 = 主营利润;
		this.市净率 = 市净率;
		this.营业利润 = 营业利润;
		this.投资收益 = 投资收益;
		this.经营现金流 = 经营现金流;
		this.总现金流 = 总现金流;
		this.存货 = 存货;
		this.利润总额 = 利润总额;
		this.税后利润 = 税后利润;
		this.净利润 = 净利润;
		this.未分利润 = 未分利润;
		this.每股净资 = 每股净资;
		this.调整后净资 = 调整后净资;
		this.净益率 = 净益率;
		this.每股未分配 = 每股未分配;
		this.每股收益 = 每股收益;
		this.权益比率 = 权益比率;
	}

	// Property accessors
	@Id
	@Column(name = "ID", nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "导入日期", nullable = false, length = 19)
	public String get导入日期() {
		return this.导入日期;
	}

	public void set导入日期(String 导入日期) {
		this.导入日期 = 导入日期;
	}

	@Column(name = "代码" , length = 10)
	public String get代码() {
		return this.代码;
	}

	public void set代码(String 代码) {
		this.代码 = 代码;
	}

	@Column(name = "名称", nullable = false, length = 30)
	public String get名称() {
		return this.名称;
	}

	public void set名称(String 名称) {
		this.名称 = 名称;
	}

	@Column(name = "涨幅率", length = 8)
	public String get涨幅率() {
		return this.涨幅率;
	}

	public void set涨幅率(String 涨幅率) {
		this.涨幅率 = 涨幅率;
	}

	@Column(name = "现价", length = 8)
	public String get现价() {
		return this.现价;
	}

	public void set现价(String 现价) {
		this.现价 = 现价;
	}

	@Column(name = "涨跌", length = 8)
	public String get涨跌() {
		return this.涨跌;
	}

	public void set涨跌(String 涨跌) {
		this.涨跌 = 涨跌;
	}

	@Column(name = "买入价", length = 8)
	public String get买入价() {
		return this.买入价;
	}

	public void set买入价(String 买入价) {
		this.买入价 = 买入价;
	}

	@Column(name = "卖出价", length = 8)
	public String get卖出价() {
		return this.卖出价;
	}

	public void set卖出价(String 卖出价) {
		this.卖出价 = 卖出价;
	}

	@Column(name = "总量", length = 15)
	public String get总量() {
		return this.总量;
	}

	public void set总量(String 总量) {
		this.总量 = 总量;
	}

	@Column(name = "现量", length = 15)
	public String get现量() {
		return this.现量;
	}

	public void set现量(String 现量) {
		this.现量 = 现量;
	}

	@Column(name = "涨速率", length = 8)
	public String get涨速率() {
		return this.涨速率;
	}

	public void set涨速率(String 涨速率) {
		this.涨速率 = 涨速率;
	}

	@Column(name = "换手率", length = 8)
	public String get换手率() {
		return this.换手率;
	}

	public void set换手率(String 换手率) {
		this.换手率 = 换手率;
	}

	@Column(name = "今开", length = 8)
	public String get今开() {
		return this.今开;
	}

	public void set今开(String 今开) {
		this.今开 = 今开;
	}

	@Column(name = "昨收", length = 8)
	public String get昨收() {
		return this.昨收;
	}

	public void set昨收(String 昨收) {
		this.昨收 = 昨收;
	}

	@Column(name = "最高", length = 8)
	public String get最高() {
		return this.最高;
	}

	public void set最高(String 最高) {
		this.最高 = 最高;
	}

	@Column(name = "最低", length = 8)
	public String get最低() {
		return this.最低;
	}

	public void set最低(String 最低) {
		this.最低 = 最低;
	}

	@Column(name = "市盈dong", length = 15)
	public String get市盈dong() {
		return this.市盈dong;
	}

	public void set市盈dong(String 市盈dong) {
		this.市盈dong = 市盈dong;
	}

	@Column(name = "总金额", length = 15)
	public String get总金额() {
		return this.总金额;
	}

	public void set总金额(String 总金额) {
		this.总金额 = 总金额;
	}

	@Column(name = "振幅率", length = 8)
	public String get振幅率() {
		return this.振幅率;
	}

	public void set振幅率(String 振幅率) {
		this.振幅率 = 振幅率;
	}

	@Column(name = "流通股本", length = 18)
	public String get流通股本() {
		return this.流通股本;
	}

	public void set流通股本(String 流通股本) {
		this.流通股本 = 流通股本;
	}

	@Column(name = "所属行业", length = 10)
	public String get所属行业() {
		return this.所属行业;
	}

	public void set所属行业(String 所属行业) {
		this.所属行业 = 所属行业;
	}

	@Column(name = "量比", length = 8)
	public String get量比() {
		return this.量比;
	}

	public void set量比(String 量比) {
		this.量比 = 量比;
	}

	@Column(name = "均价", length = 8)
	public String get均价() {
		return this.均价;
	}

	public void set均价(String 均价) {
		this.均价 = 均价;
	}

	@Column(name = "委比率", length = 8)
	public String get委比率() {
		return this.委比率;
	}

	public void set委比率(String 委比率) {
		this.委比率 = 委比率;
	}

	@Column(name = "内盘", length = 15)
	public String get内盘() {
		return this.内盘;
	}

	public void set内盘(String 内盘) {
		this.内盘 = 内盘;
	}

	@Column(name = "外盘", length = 15)
	public String get外盘() {
		return this.外盘;
	}

	public void set外盘(String 外盘) {
		this.外盘 = 外盘;
	}

	@Column(name = "内外比", length = 8)
	public String get内外比() {
		return this.内外比;
	}

	public void set内外比(String 内外比) {
		this.内外比 = 内外比;
	}

	@Column(name = "委量差", length = 10)
	public String get委量差() {
		return this.委量差;
	}

	public void set委量差(String 委量差) {
		this.委量差 = 委量差;
	}

	@Column(name = "买量一", length = 10)
	public String get买量一() {
		return this.买量一;
	}

	public void set买量一(String 买量一) {
		this.买量一 = 买量一;
	}

	@Column(name = "卖量一", length = 10)
	public String get卖量一() {
		return this.卖量一;
	}

	public void set卖量一(String 卖量一) {
		this.卖量一 = 卖量一;
	}

	@Column(name = "买价一", length = 8)
	public String get买价一() {
		return this.买价一;
	}

	public void set买价一(String 买价一) {
		this.买价一 = 买价一;
	}

	@Column(name = "卖价一", length = 8)
	public String get卖价一() {
		return this.卖价一;
	}

	public void set卖价一(String 卖价一) {
		this.卖价一 = 卖价一;
	}

	@Column(name = "卖价二", length = 8)
	public String get卖价二() {
		return this.卖价二;
	}

	public void set卖价二(String 卖价二) {
		this.卖价二 = 卖价二;
	}

	@Column(name = "卖量二", length = 10)
	public String get卖量二() {
		return this.卖量二;
	}

	public void set卖量二(String 卖量二) {
		this.卖量二 = 卖量二;
	}

	@Column(name = "买价二", length = 8)
	public String get买价二() {
		return this.买价二;
	}

	public void set买价二(String 买价二) {
		this.买价二 = 买价二;
	}

	@Column(name = "买量二", length = 10)
	public String get买量二() {
		return this.买量二;
	}

	public void set买量二(String 买量二) {
		this.买量二 = 买量二;
	}

	@Column(name = "买价三", length = 8)
	public String get买价三() {
		return this.买价三;
	}

	public void set买价三(String 买价三) {
		this.买价三 = 买价三;
	}

	@Column(name = "买量三", length = 10)
	public String get买量三() {
		return this.买量三;
	}

	public void set买量三(String 买量三) {
		this.买量三 = 买量三;
	}

	@Column(name = "卖价三", length = 8)
	public String get卖价三() {
		return this.卖价三;
	}

	public void set卖价三(String 卖价三) {
		this.卖价三 = 卖价三;
	}

	@Column(name = "卖量三", length = 10)
	public String get卖量三() {
		return this.卖量三;
	}

	public void set卖量三(String 卖量三) {
		this.卖量三 = 卖量三;
	}

	@Column(name = "流通市值", length = 15)
	public String get流通市值() {
		return this.流通市值;
	}

	public void set流通市值(String 流通市值) {
		this.流通市值 = 流通市值;
	}

	@Column(name = "AB股总市值", length = 15)
	public String getAb股总市值() {
		return this.ab股总市值;
	}

	public void setAb股总市值(String ab股总市值) {
		this.ab股总市值 = ab股总市值;
	}

	@Column(name = "多空平衡", length = 8)
	public String get多空平衡() {
		return this.多空平衡;
	}

	public void set多空平衡(String 多空平衡) {
		this.多空平衡 = 多空平衡;
	}

	@Column(name = "多头获利", length = 8)
	public String get多头获利() {
		return this.多头获利;
	}

	public void set多头获利(String 多头获利) {
		this.多头获利 = 多头获利;
	}

	@Column(name = "多头止损", length = 8)
	public String get多头止损() {
		return this.多头止损;
	}

	public void set多头止损(String 多头止损) {
		this.多头止损 = 多头止损;
	}

	@Column(name = "空头回补", length = 8)
	public String get空头回补() {
		return this.空头回补;
	}

	public void set空头回补(String 空头回补) {
		this.空头回补 = 空头回补;
	}

	@Column(name = "空头止损", length = 8)
	public String get空头止损() {
		return this.空头止损;
	}

	public void set空头止损(String 空头止损) {
		this.空头止损 = 空头止损;
	}

	@Column(name = "强弱度率", length = 8)
	public String get强弱度率() {
		return this.强弱度率;
	}

	public void set强弱度率(String 强弱度率) {
		this.强弱度率 = 强弱度率;
	}

	@Column(name = "活跃度", length = 8)
	public String get活跃度() {
		return this.活跃度;
	}

	public void set活跃度(String 活跃度) {
		this.活跃度 = 活跃度;
	}

	@Column(name = "每笔均量", length = 8)
	public String get每笔均量() {
		return this.每笔均量;
	}

	public void set每笔均量(String 每笔均量) {
		this.每笔均量 = 每笔均量;
	}

	@Column(name = "每笔换手", length = 8)
	public String get每笔换手() {
		return this.每笔换手;
	}

	public void set每笔换手(String 每笔换手) {
		this.每笔换手 = 每笔换手;
	}

	@Column(name = "更新日期", length = 10)
	public String get更新日期() {
		return this.更新日期;
	}

	public void set更新日期(String 更新日期) {
		this.更新日期 = 更新日期;
	}

	@Column(name = "上市日期", length = 10)
	public String get上市日期() {
		return this.上市日期;
	}

	public void set上市日期(String 上市日期) {
		this.上市日期 = 上市日期;
	}

	@Column(name = "总股本wan", length = 15)
	public String get总股本wan() {
		return this.总股本wan;
	}

	public void set总股本wan(String 总股本wan) {
		this.总股本wan = 总股本wan;
	}

	@Column(name = "国家股", length = 15)
	public String get国家股() {
		return this.国家股;
	}

	public void set国家股(String 国家股) {
		this.国家股 = 国家股;
	}

	@Column(name = "利润同比", length = 15)
	public String get利润同比() {
		return this.利润同比;
	}

	public void set利润同比(String 利润同比) {
		this.利润同比 = 利润同比;
	}

	@Column(name = "收入同比", length = 15)
	public String get收入同比() {
		return this.收入同比;
	}

	public void set收入同比(String 收入同比) {
		this.收入同比 = 收入同比;
	}

	@Column(name = "B股或A", length = 10)
	public String getB股或a() {
		return this.b股或a;
	}

	public void setB股或a(String b股或a) {
		this.b股或a = b股或a;
	}

	@Column(name = "H股", length = 15)
	public String getH股() {
		return this.h股;
	}

	public void setH股(String h股) {
		this.h股 = h股;
	}

	@Column(name = "职工股", length = 8)
	public String get职工股() {
		return this.职工股;
	}

	public void set职工股(String 职工股) {
		this.职工股 = 职工股;
	}

	@Column(name = "总资产wan", length = 15)
	public String get总资产wan() {
		return this.总资产wan;
	}

	public void set总资产wan(String 总资产wan) {
		this.总资产wan = 总资产wan;
	}

	@Column(name = "流动资产", length = 15)
	public String get流动资产() {
		return this.流动资产;
	}

	public void set流动资产(String 流动资产) {
		this.流动资产 = 流动资产;
	}

	@Column(name = "固定资产", length = 15)
	public String get固定资产() {
		return this.固定资产;
	}

	public void set固定资产(String 固定资产) {
		this.固定资产 = 固定资产;
	}

	@Column(name = "无形资产", length = 15)
	public String get无形资产() {
		return this.无形资产;
	}

	public void set无形资产(String 无形资产) {
		this.无形资产 = 无形资产;
	}

	@Column(name = "长期投资", length = 15)
	public String get长期投资() {
		return this.长期投资;
	}

	public void set长期投资(String 长期投资) {
		this.长期投资 = 长期投资;
	}

	@Column(name = "流动负债", length = 15)
	public String get流动负债() {
		return this.流动负债;
	}

	public void set流动负债(String 流动负债) {
		this.流动负债 = 流动负债;
	}

	@Column(name = "长期负债", length = 15)
	public String get长期负债() {
		return this.长期负债;
	}

	public void set长期负债(String 长期负债) {
		this.长期负债 = 长期负债;
	}

	@Column(name = "公积金", length = 15)
	public String get公积金() {
		return this.公积金;
	}

	public void set公积金(String 公积金) {
		this.公积金 = 公积金;
	}

	@Column(name = "每股公积", length = 8)
	public String get每股公积() {
		return this.每股公积;
	}

	public void set每股公积(String 每股公积) {
		this.每股公积 = 每股公积;
	}

	@Column(name = "净资产", length = 15)
	public String get净资产() {
		return this.净资产;
	}

	public void set净资产(String 净资产) {
		this.净资产 = 净资产;
	}

	@Column(name = "主营收入", length = 15)
	public String get主营收入() {
		return this.主营收入;
	}

	public void set主营收入(String 主营收入) {
		this.主营收入 = 主营收入;
	}

	@Column(name = "主营利润", length = 15)
	public String get主营利润() {
		return this.主营利润;
	}

	public void set主营利润(String 主营利润) {
		this.主营利润 = 主营利润;
	}

	@Column(name = "市净率", length = 8)
	public String get市净率() {
		return this.市净率;
	}

	public void set市净率(String 市净率) {
		this.市净率 = 市净率;
	}

	@Column(name = "营业利润", length = 15)
	public String get营业利润() {
		return this.营业利润;
	}

	public void set营业利润(String 营业利润) {
		this.营业利润 = 营业利润;
	}

	@Column(name = "投资收益", length = 15)
	public String get投资收益() {
		return this.投资收益;
	}

	public void set投资收益(String 投资收益) {
		this.投资收益 = 投资收益;
	}

	@Column(name = "经营现金流", length = 15)
	public String get经营现金流() {
		return this.经营现金流;
	}

	public void set经营现金流(String 经营现金流) {
		this.经营现金流 = 经营现金流;
	}

	@Column(name = "总现金流", length = 15)
	public String get总现金流() {
		return this.总现金流;
	}

	public void set总现金流(String 总现金流) {
		this.总现金流 = 总现金流;
	}

	@Column(name = "存货", length = 15)
	public String get存货() {
		return this.存货;
	}

	public void set存货(String 存货) {
		this.存货 = 存货;
	}

	@Column(name = "利润总额", length = 15)
	public String get利润总额() {
		return this.利润总额;
	}

	public void set利润总额(String 利润总额) {
		this.利润总额 = 利润总额;
	}

	@Column(name = "税后利润", length = 15)
	public String get税后利润() {
		return this.税后利润;
	}

	public void set税后利润(String 税后利润) {
		this.税后利润 = 税后利润;
	}

	@Column(name = "净利润", length = 15)
	public String get净利润() {
		return this.净利润;
	}

	public void set净利润(String 净利润) {
		this.净利润 = 净利润;
	}

	@Column(name = "未分利润", length = 15)
	public String get未分利润() {
		return this.未分利润;
	}

	public void set未分利润(String 未分利润) {
		this.未分利润 = 未分利润;
	}

	@Column(name = "每股净资", length = 8)
	public String get每股净资() {
		return this.每股净资;
	}

	public void set每股净资(String 每股净资) {
		this.每股净资 = 每股净资;
	}

	@Column(name = "调整后净资", length = 8)
	public String get调整后净资() {
		return this.调整后净资;
	}

	public void set调整后净资(String 调整后净资) {
		this.调整后净资 = 调整后净资;
	}

	@Column(name = "净益率", length = 10)
	public String get净益率() {
		return this.净益率;
	}

	public void set净益率(String 净益率) {
		this.净益率 = 净益率;
	}

	@Column(name = "每股未分配", length = 8)
	public String get每股未分配() {
		return this.每股未分配;
	}

	public void set每股未分配(String 每股未分配) {
		this.每股未分配 = 每股未分配;
	}

	@Column(name = "每股收益", length = 10)
	public String get每股收益() {
		return this.每股收益;
	}

	public void set每股收益(String 每股收益) {
		this.每股收益 = 每股收益;
	}

	@Column(name = "权益比率", length = 8)
	public String get权益比率() {
		return this.权益比率;
	}

	public void set权益比率(String 权益比率) {
		this.权益比率 = 权益比率;
	}

	@Column(name = "开盘", length = 15)
	public String get开盘() {
		return 开盘;
	}

	public void set开盘(String 开盘) {
		this.开盘 = 开盘;
	}

	@Column(name = "收盘", length = 15)
	public String get收盘() {
		return 收盘;
	}

	public void set收盘(String 收盘) {
		this.收盘 = 收盘;
	}

	@Column(name = "成交额", length = 15)
	public String get成交额() {
		return 成交额;
	}

	public void set成交额(String 成交额) {
		this.成交额 = 成交额;
	}

	@Column(name = "成交量", length = 15)
	public String get成交量() {
		return 成交量;
	}

	
	public void set成交量(String 成交量) {
		this.成交量 = 成交量;
	}
	
	
	

}