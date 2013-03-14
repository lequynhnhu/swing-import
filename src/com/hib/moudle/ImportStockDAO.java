package com.hib.moudle;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ImportStock entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hib.moudle.ImportStock
 * @author MyEclipse Persistence Tools
 */

public class ImportStockDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ImportStockDAO.class);
	// property constants
	public static final String _导入日期 = "导入日期";
	public static final String _代码 = "代码";
	public static final String _名称 = "名称";
	public static final String _涨幅率 = "涨幅率";
	public static final String _现价 = "现价";
	public static final String _涨跌 = "涨跌";
	public static final String _买入价 = "买入价";
	public static final String _卖出价 = "卖出价";
	public static final String _总量 = "总量";
	public static final String _现量 = "现量";
	public static final String _涨速率 = "涨速率";
	public static final String _换手率 = "换手率";
	public static final String _今开 = "今开";
	public static final String _昨收 = "昨收";
	public static final String _最高 = "最高";
	public static final String _最低 = "最低";
	public static final String 市盈DONG = "市盈dong";
	public static final String _总金额 = "总金额";
	public static final String _振幅率 = "振幅率";
	public static final String _流通股本 = "流通股本";
	public static final String _所属行业 = "所属行业";
	public static final String _量比 = "量比";
	public static final String _均价 = "均价";
	public static final String _委比率 = "委比率";
	public static final String _内盘 = "内盘";
	public static final String _外盘 = "外盘";
	public static final String _内外比 = "内外比";
	public static final String _委量差 = "委量差";
	public static final String _买量一 = "买量一";
	public static final String _卖量一 = "卖量一";
	public static final String _买价一 = "买价一";
	public static final String _卖价一 = "卖价一";
	public static final String _卖价二 = "卖价二";
	public static final String _卖量二 = "卖量二";
	public static final String _买价二 = "买价二";
	public static final String _买量二 = "买量二";
	public static final String _买价三 = "买价三";
	public static final String _买量三 = "买量三";
	public static final String _卖价三 = "卖价三";
	public static final String _卖量三 = "卖量三";
	public static final String _流通市值 = "流通市值";
	public static final String AB股总市值 = "ab股总市值";
	public static final String _多空平衡 = "多空平衡";
	public static final String _多头获利 = "多头获利";
	public static final String _多头止损 = "多头止损";
	public static final String _空头回补 = "空头回补";
	public static final String _空头止损 = "空头止损";
	public static final String _强弱度率 = "强弱度率";
	public static final String _活跃度 = "活跃度";
	public static final String _每笔均量 = "每笔均量";
	public static final String _每笔换手 = "每笔换手";
	public static final String _更新日期 = "更新日期";
	public static final String _上市日期 = "上市日期";
	public static final String 总股本WAN = "总股本wan";
	public static final String _国家股 = "国家股";
	public static final String _利润同比 = "利润同比";
	public static final String _收入同比 = "收入同比";
	public static final String B股或A = "b股或a";
	public static final String H股 = "h股";
	public static final String _职工股 = "职工股";
	public static final String 总资产WAN = "总资产wan";
	public static final String _流动资产 = "流动资产";
	public static final String _固定资产 = "固定资产";
	public static final String _无形资产 = "无形资产";
	public static final String _长期投资 = "长期投资";
	public static final String _流动负债 = "流动负债";
	public static final String _长期负债 = "长期负债";
	public static final String _公积金 = "公积金";
	public static final String _每股公积 = "每股公积";
	public static final String _净资产 = "净资产";
	public static final String _主营收入 = "主营收入";
	public static final String _主营利润 = "主营利润";
	public static final String _市净率 = "市净率";
	public static final String _营业利润 = "营业利润";
	public static final String _投资收益 = "投资收益";
	public static final String _经营现金流 = "经营现金流";
	public static final String _总现金流 = "总现金流";
	public static final String _存货 = "存货";
	public static final String _利润总额 = "利润总额";
	public static final String _税后利润 = "税后利润";
	public static final String _净利润 = "净利润";
	public static final String _未分利润 = "未分利润";
	public static final String _每股净资 = "每股净资";
	public static final String _调整后净资 = "调整后净资";
	public static final String _净益率 = "净益率";
	public static final String _每股未分配 = "每股未分配";
	public static final String _每股收益 = "每股收益";
	public static final String _权益比率 = "权益比率";

	public void save(ImportStock transientInstance) {
		log.debug("saving ImportStock instance");
		try {
			
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ImportStock persistentInstance) {
		log.debug("deleting ImportStock instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ImportStock findById(java.lang.String id) {
		log.debug("getting ImportStock instance with id: " + id);
		try {
			ImportStock instance = (ImportStock) getSession().get(
					"com.hib.moudle.ImportStock", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ImportStock> findByExample(ImportStock instance) {
		log.debug("finding ImportStock instance by example");
		try {
			List<ImportStock> results = (List<ImportStock>) getSession()
					.createCriteria("com.hib.moudle.ImportStock").add(
							create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ImportStock instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ImportStock as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ImportStock> findBy导入日期(Object 导入日期) {
		return findByProperty(_导入日期, 导入日期);
	}

	public List<ImportStock> findBy代码(Object 代码) {
		return findByProperty(_代码, 代码);
	}

	public List<ImportStock> findBy名称(Object 名称) {
		return findByProperty(_名称, 名称);
	}

	public List<ImportStock> findBy涨幅率(Object 涨幅率) {
		return findByProperty(_涨幅率, 涨幅率);
	}

	public List<ImportStock> findBy现价(Object 现价) {
		return findByProperty(_现价, 现价);
	}

	public List<ImportStock> findBy涨跌(Object 涨跌) {
		return findByProperty(_涨跌, 涨跌);
	}

	public List<ImportStock> findBy买入价(Object 买入价) {
		return findByProperty(_买入价, 买入价);
	}

	public List<ImportStock> findBy卖出价(Object 卖出价) {
		return findByProperty(_卖出价, 卖出价);
	}

	public List<ImportStock> findBy总量(Object 总量) {
		return findByProperty(_总量, 总量);
	}

	public List<ImportStock> findBy现量(Object 现量) {
		return findByProperty(_现量, 现量);
	}

	public List<ImportStock> findBy涨速率(Object 涨速率) {
		return findByProperty(_涨速率, 涨速率);
	}

	public List<ImportStock> findBy换手率(Object 换手率) {
		return findByProperty(_换手率, 换手率);
	}

	public List<ImportStock> findBy今开(Object 今开) {
		return findByProperty(_今开, 今开);
	}

	public List<ImportStock> findBy昨收(Object 昨收) {
		return findByProperty(_昨收, 昨收);
	}

	public List<ImportStock> findBy最高(Object 最高) {
		return findByProperty(_最高, 最高);
	}

	public List<ImportStock> findBy最低(Object 最低) {
		return findByProperty(_最低, 最低);
	}

	public List<ImportStock> findBy市盈dong(Object 市盈dong) {
		return findByProperty(市盈DONG, 市盈dong);
	}

	public List<ImportStock> findBy总金额(Object 总金额) {
		return findByProperty(_总金额, 总金额);
	}

	public List<ImportStock> findBy振幅率(Object 振幅率) {
		return findByProperty(_振幅率, 振幅率);
	}

	public List<ImportStock> findBy流通股本(Object 流通股本) {
		return findByProperty(_流通股本, 流通股本);
	}

	public List<ImportStock> findBy所属行业(Object 所属行业) {
		return findByProperty(_所属行业, 所属行业);
	}

	public List<ImportStock> findBy量比(Object 量比) {
		return findByProperty(_量比, 量比);
	}

	public List<ImportStock> findBy均价(Object 均价) {
		return findByProperty(_均价, 均价);
	}

	public List<ImportStock> findBy委比率(Object 委比率) {
		return findByProperty(_委比率, 委比率);
	}

	public List<ImportStock> findBy内盘(Object 内盘) {
		return findByProperty(_内盘, 内盘);
	}

	public List<ImportStock> findBy外盘(Object 外盘) {
		return findByProperty(_外盘, 外盘);
	}

	public List<ImportStock> findBy内外比(Object 内外比) {
		return findByProperty(_内外比, 内外比);
	}

	public List<ImportStock> findBy委量差(Object 委量差) {
		return findByProperty(_委量差, 委量差);
	}

	public List<ImportStock> findBy买量一(Object 买量一) {
		return findByProperty(_买量一, 买量一);
	}

	public List<ImportStock> findBy卖量一(Object 卖量一) {
		return findByProperty(_卖量一, 卖量一);
	}

	public List<ImportStock> findBy买价一(Object 买价一) {
		return findByProperty(_买价一, 买价一);
	}

	public List<ImportStock> findBy卖价一(Object 卖价一) {
		return findByProperty(_卖价一, 卖价一);
	}

	public List<ImportStock> findBy卖价二(Object 卖价二) {
		return findByProperty(_卖价二, 卖价二);
	}

	public List<ImportStock> findBy卖量二(Object 卖量二) {
		return findByProperty(_卖量二, 卖量二);
	}

	public List<ImportStock> findBy买价二(Object 买价二) {
		return findByProperty(_买价二, 买价二);
	}

	public List<ImportStock> findBy买量二(Object 买量二) {
		return findByProperty(_买量二, 买量二);
	}

	public List<ImportStock> findBy买价三(Object 买价三) {
		return findByProperty(_买价三, 买价三);
	}

	public List<ImportStock> findBy买量三(Object 买量三) {
		return findByProperty(_买量三, 买量三);
	}

	public List<ImportStock> findBy卖价三(Object 卖价三) {
		return findByProperty(_卖价三, 卖价三);
	}

	public List<ImportStock> findBy卖量三(Object 卖量三) {
		return findByProperty(_卖量三, 卖量三);
	}

	public List<ImportStock> findBy流通市值(Object 流通市值) {
		return findByProperty(_流通市值, 流通市值);
	}

	public List<ImportStock> findByAb股总市值(Object ab股总市值) {
		return findByProperty(AB股总市值, ab股总市值);
	}

	public List<ImportStock> findBy多空平衡(Object 多空平衡) {
		return findByProperty(_多空平衡, 多空平衡);
	}

	public List<ImportStock> findBy多头获利(Object 多头获利) {
		return findByProperty(_多头获利, 多头获利);
	}

	public List<ImportStock> findBy多头止损(Object 多头止损) {
		return findByProperty(_多头止损, 多头止损);
	}

	public List<ImportStock> findBy空头回补(Object 空头回补) {
		return findByProperty(_空头回补, 空头回补);
	}

	public List<ImportStock> findBy空头止损(Object 空头止损) {
		return findByProperty(_空头止损, 空头止损);
	}

	public List<ImportStock> findBy强弱度率(Object 强弱度率) {
		return findByProperty(_强弱度率, 强弱度率);
	}

	public List<ImportStock> findBy活跃度(Object 活跃度) {
		return findByProperty(_活跃度, 活跃度);
	}

	public List<ImportStock> findBy每笔均量(Object 每笔均量) {
		return findByProperty(_每笔均量, 每笔均量);
	}

	public List<ImportStock> findBy每笔换手(Object 每笔换手) {
		return findByProperty(_每笔换手, 每笔换手);
	}

	public List<ImportStock> findBy更新日期(Object 更新日期) {
		return findByProperty(_更新日期, 更新日期);
	}

	public List<ImportStock> findBy上市日期(Object 上市日期) {
		return findByProperty(_上市日期, 上市日期);
	}

	public List<ImportStock> findBy总股本wan(Object 总股本wan) {
		return findByProperty(总股本WAN, 总股本wan);
	}

	public List<ImportStock> findBy国家股(Object 国家股) {
		return findByProperty(_国家股, 国家股);
	}

	public List<ImportStock> findBy利润同比(Object 利润同比) {
		return findByProperty(_利润同比, 利润同比);
	}

	public List<ImportStock> findBy收入同比(Object 收入同比) {
		return findByProperty(_收入同比, 收入同比);
	}

	public List<ImportStock> findByB股或a(Object b股或a) {
		return findByProperty(B股或A, b股或a);
	}

	public List<ImportStock> findByH股(Object h股) {
		return findByProperty(H股, h股);
	}

	public List<ImportStock> findBy职工股(Object 职工股) {
		return findByProperty(_职工股, 职工股);
	}

	public List<ImportStock> findBy总资产wan(Object 总资产wan) {
		return findByProperty(总资产WAN, 总资产wan);
	}

	public List<ImportStock> findBy流动资产(Object 流动资产) {
		return findByProperty(_流动资产, 流动资产);
	}

	public List<ImportStock> findBy固定资产(Object 固定资产) {
		return findByProperty(_固定资产, 固定资产);
	}

	public List<ImportStock> findBy无形资产(Object 无形资产) {
		return findByProperty(_无形资产, 无形资产);
	}

	public List<ImportStock> findBy长期投资(Object 长期投资) {
		return findByProperty(_长期投资, 长期投资);
	}

	public List<ImportStock> findBy流动负债(Object 流动负债) {
		return findByProperty(_流动负债, 流动负债);
	}

	public List<ImportStock> findBy长期负债(Object 长期负债) {
		return findByProperty(_长期负债, 长期负债);
	}

	public List<ImportStock> findBy公积金(Object 公积金) {
		return findByProperty(_公积金, 公积金);
	}

	public List<ImportStock> findBy每股公积(Object 每股公积) {
		return findByProperty(_每股公积, 每股公积);
	}

	public List<ImportStock> findBy净资产(Object 净资产) {
		return findByProperty(_净资产, 净资产);
	}

	public List<ImportStock> findBy主营收入(Object 主营收入) {
		return findByProperty(_主营收入, 主营收入);
	}

	public List<ImportStock> findBy主营利润(Object 主营利润) {
		return findByProperty(_主营利润, 主营利润);
	}

	public List<ImportStock> findBy市净率(Object 市净率) {
		return findByProperty(_市净率, 市净率);
	}

	public List<ImportStock> findBy营业利润(Object 营业利润) {
		return findByProperty(_营业利润, 营业利润);
	}

	public List<ImportStock> findBy投资收益(Object 投资收益) {
		return findByProperty(_投资收益, 投资收益);
	}

	public List<ImportStock> findBy经营现金流(Object 经营现金流) {
		return findByProperty(_经营现金流, 经营现金流);
	}

	public List<ImportStock> findBy总现金流(Object 总现金流) {
		return findByProperty(_总现金流, 总现金流);
	}

	public List<ImportStock> findBy存货(Object 存货) {
		return findByProperty(_存货, 存货);
	}

	public List<ImportStock> findBy利润总额(Object 利润总额) {
		return findByProperty(_利润总额, 利润总额);
	}

	public List<ImportStock> findBy税后利润(Object 税后利润) {
		return findByProperty(_税后利润, 税后利润);
	}

	public List<ImportStock> findBy净利润(Object 净利润) {
		return findByProperty(_净利润, 净利润);
	}

	public List<ImportStock> findBy未分利润(Object 未分利润) {
		return findByProperty(_未分利润, 未分利润);
	}

	public List<ImportStock> findBy每股净资(Object 每股净资) {
		return findByProperty(_每股净资, 每股净资);
	}

	public List<ImportStock> findBy调整后净资(Object 调整后净资) {
		return findByProperty(_调整后净资, 调整后净资);
	}

	public List<ImportStock> findBy净益率(Object 净益率) {
		return findByProperty(_净益率, 净益率);
	}

	public List<ImportStock> findBy每股未分配(Object 每股未分配) {
		return findByProperty(_每股未分配, 每股未分配);
	}

	public List<ImportStock> findBy每股收益(Object 每股收益) {
		return findByProperty(_每股收益, 每股收益);
	}

	public List<ImportStock> findBy权益比率(Object 权益比率) {
		return findByProperty(_权益比率, 权益比率);
	}

	public List findAll() {
		log.debug("finding all ImportStock instances");
		try {
			String queryString = "from ImportStock";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ImportStock merge(ImportStock detachedInstance) {
		log.debug("merging ImportStock instance");
		try {
			ImportStock result = (ImportStock) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ImportStock instance) {
		log.debug("attaching dirty ImportStock instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ImportStock instance) {
		log.debug("attaching clean ImportStock instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}