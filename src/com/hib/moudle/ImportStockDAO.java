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
	public static final String _�������� = "��������";
	public static final String _���� = "����";
	public static final String _���� = "����";
	public static final String _�Ƿ��� = "�Ƿ���";
	public static final String _�ּ� = "�ּ�";
	public static final String _�ǵ� = "�ǵ�";
	public static final String _����� = "�����";
	public static final String _������ = "������";
	public static final String _���� = "����";
	public static final String _���� = "����";
	public static final String _������ = "������";
	public static final String _������ = "������";
	public static final String _�� = "��";
	public static final String _���� = "����";
	public static final String _��� = "���";
	public static final String _��� = "���";
	public static final String ��ӯDONG = "��ӯdong";
	public static final String _�ܽ�� = "�ܽ��";
	public static final String _����� = "�����";
	public static final String _��ͨ�ɱ� = "��ͨ�ɱ�";
	public static final String _������ҵ = "������ҵ";
	public static final String _���� = "����";
	public static final String _���� = "����";
	public static final String _ί���� = "ί����";
	public static final String _���� = "����";
	public static final String _���� = "����";
	public static final String _����� = "�����";
	public static final String _ί���� = "ί����";
	public static final String _����һ = "����һ";
	public static final String _����һ = "����һ";
	public static final String _���һ = "���һ";
	public static final String _����һ = "����һ";
	public static final String _���۶� = "���۶�";
	public static final String _������ = "������";
	public static final String _��۶� = "��۶�";
	public static final String _������ = "������";
	public static final String _����� = "�����";
	public static final String _������ = "������";
	public static final String _������ = "������";
	public static final String _������ = "������";
	public static final String _��ͨ��ֵ = "��ͨ��ֵ";
	public static final String AB������ֵ = "ab������ֵ";
	public static final String _���ƽ�� = "���ƽ��";
	public static final String _��ͷ���� = "��ͷ����";
	public static final String _��ͷֹ�� = "��ͷֹ��";
	public static final String _��ͷ�ز� = "��ͷ�ز�";
	public static final String _��ͷֹ�� = "��ͷֹ��";
	public static final String _ǿ������ = "ǿ������";
	public static final String _��Ծ�� = "��Ծ��";
	public static final String _ÿ�ʾ��� = "ÿ�ʾ���";
	public static final String _ÿ�ʻ��� = "ÿ�ʻ���";
	public static final String _�������� = "��������";
	public static final String _�������� = "��������";
	public static final String �ܹɱ�WAN = "�ܹɱ�wan";
	public static final String _���ҹ� = "���ҹ�";
	public static final String _����ͬ�� = "����ͬ��";
	public static final String _����ͬ�� = "����ͬ��";
	public static final String B�ɻ�A = "b�ɻ�a";
	public static final String H�� = "h��";
	public static final String _ְ���� = "ְ����";
	public static final String ���ʲ�WAN = "���ʲ�wan";
	public static final String _�����ʲ� = "�����ʲ�";
	public static final String _�̶��ʲ� = "�̶��ʲ�";
	public static final String _�����ʲ� = "�����ʲ�";
	public static final String _����Ͷ�� = "����Ͷ��";
	public static final String _������ծ = "������ծ";
	public static final String _���ڸ�ծ = "���ڸ�ծ";
	public static final String _������ = "������";
	public static final String _ÿ�ɹ��� = "ÿ�ɹ���";
	public static final String _���ʲ� = "���ʲ�";
	public static final String _��Ӫ���� = "��Ӫ����";
	public static final String _��Ӫ���� = "��Ӫ����";
	public static final String _�о��� = "�о���";
	public static final String _Ӫҵ���� = "Ӫҵ����";
	public static final String _Ͷ������ = "Ͷ������";
	public static final String _��Ӫ�ֽ��� = "��Ӫ�ֽ���";
	public static final String _���ֽ��� = "���ֽ���";
	public static final String _��� = "���";
	public static final String _�����ܶ� = "�����ܶ�";
	public static final String _˰������ = "˰������";
	public static final String _������ = "������";
	public static final String _δ������ = "δ������";
	public static final String _ÿ�ɾ��� = "ÿ�ɾ���";
	public static final String _�������� = "��������";
	public static final String _������ = "������";
	public static final String _ÿ��δ���� = "ÿ��δ����";
	public static final String _ÿ������ = "ÿ������";
	public static final String _Ȩ����� = "Ȩ�����";

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

	public List<ImportStock> findBy��������(Object ��������) {
		return findByProperty(_��������, ��������);
	}

	public List<ImportStock> findBy����(Object ����) {
		return findByProperty(_����, ����);
	}

	public List<ImportStock> findBy����(Object ����) {
		return findByProperty(_����, ����);
	}

	public List<ImportStock> findBy�Ƿ���(Object �Ƿ���) {
		return findByProperty(_�Ƿ���, �Ƿ���);
	}

	public List<ImportStock> findBy�ּ�(Object �ּ�) {
		return findByProperty(_�ּ�, �ּ�);
	}

	public List<ImportStock> findBy�ǵ�(Object �ǵ�) {
		return findByProperty(_�ǵ�, �ǵ�);
	}

	public List<ImportStock> findBy�����(Object �����) {
		return findByProperty(_�����, �����);
	}

	public List<ImportStock> findBy������(Object ������) {
		return findByProperty(_������, ������);
	}

	public List<ImportStock> findBy����(Object ����) {
		return findByProperty(_����, ����);
	}

	public List<ImportStock> findBy����(Object ����) {
		return findByProperty(_����, ����);
	}

	public List<ImportStock> findBy������(Object ������) {
		return findByProperty(_������, ������);
	}

	public List<ImportStock> findBy������(Object ������) {
		return findByProperty(_������, ������);
	}

	public List<ImportStock> findBy��(Object ��) {
		return findByProperty(_��, ��);
	}

	public List<ImportStock> findBy����(Object ����) {
		return findByProperty(_����, ����);
	}

	public List<ImportStock> findBy���(Object ���) {
		return findByProperty(_���, ���);
	}

	public List<ImportStock> findBy���(Object ���) {
		return findByProperty(_���, ���);
	}

	public List<ImportStock> findBy��ӯdong(Object ��ӯdong) {
		return findByProperty(��ӯDONG, ��ӯdong);
	}

	public List<ImportStock> findBy�ܽ��(Object �ܽ��) {
		return findByProperty(_�ܽ��, �ܽ��);
	}

	public List<ImportStock> findBy�����(Object �����) {
		return findByProperty(_�����, �����);
	}

	public List<ImportStock> findBy��ͨ�ɱ�(Object ��ͨ�ɱ�) {
		return findByProperty(_��ͨ�ɱ�, ��ͨ�ɱ�);
	}

	public List<ImportStock> findBy������ҵ(Object ������ҵ) {
		return findByProperty(_������ҵ, ������ҵ);
	}

	public List<ImportStock> findBy����(Object ����) {
		return findByProperty(_����, ����);
	}

	public List<ImportStock> findBy����(Object ����) {
		return findByProperty(_����, ����);
	}

	public List<ImportStock> findByί����(Object ί����) {
		return findByProperty(_ί����, ί����);
	}

	public List<ImportStock> findBy����(Object ����) {
		return findByProperty(_����, ����);
	}

	public List<ImportStock> findBy����(Object ����) {
		return findByProperty(_����, ����);
	}

	public List<ImportStock> findBy�����(Object �����) {
		return findByProperty(_�����, �����);
	}

	public List<ImportStock> findByί����(Object ί����) {
		return findByProperty(_ί����, ί����);
	}

	public List<ImportStock> findBy����һ(Object ����һ) {
		return findByProperty(_����һ, ����һ);
	}

	public List<ImportStock> findBy����һ(Object ����һ) {
		return findByProperty(_����һ, ����һ);
	}

	public List<ImportStock> findBy���һ(Object ���һ) {
		return findByProperty(_���һ, ���һ);
	}

	public List<ImportStock> findBy����һ(Object ����һ) {
		return findByProperty(_����һ, ����һ);
	}

	public List<ImportStock> findBy���۶�(Object ���۶�) {
		return findByProperty(_���۶�, ���۶�);
	}

	public List<ImportStock> findBy������(Object ������) {
		return findByProperty(_������, ������);
	}

	public List<ImportStock> findBy��۶�(Object ��۶�) {
		return findByProperty(_��۶�, ��۶�);
	}

	public List<ImportStock> findBy������(Object ������) {
		return findByProperty(_������, ������);
	}

	public List<ImportStock> findBy�����(Object �����) {
		return findByProperty(_�����, �����);
	}

	public List<ImportStock> findBy������(Object ������) {
		return findByProperty(_������, ������);
	}

	public List<ImportStock> findBy������(Object ������) {
		return findByProperty(_������, ������);
	}

	public List<ImportStock> findBy������(Object ������) {
		return findByProperty(_������, ������);
	}

	public List<ImportStock> findBy��ͨ��ֵ(Object ��ͨ��ֵ) {
		return findByProperty(_��ͨ��ֵ, ��ͨ��ֵ);
	}

	public List<ImportStock> findByAb������ֵ(Object ab������ֵ) {
		return findByProperty(AB������ֵ, ab������ֵ);
	}

	public List<ImportStock> findBy���ƽ��(Object ���ƽ��) {
		return findByProperty(_���ƽ��, ���ƽ��);
	}

	public List<ImportStock> findBy��ͷ����(Object ��ͷ����) {
		return findByProperty(_��ͷ����, ��ͷ����);
	}

	public List<ImportStock> findBy��ͷֹ��(Object ��ͷֹ��) {
		return findByProperty(_��ͷֹ��, ��ͷֹ��);
	}

	public List<ImportStock> findBy��ͷ�ز�(Object ��ͷ�ز�) {
		return findByProperty(_��ͷ�ز�, ��ͷ�ز�);
	}

	public List<ImportStock> findBy��ͷֹ��(Object ��ͷֹ��) {
		return findByProperty(_��ͷֹ��, ��ͷֹ��);
	}

	public List<ImportStock> findByǿ������(Object ǿ������) {
		return findByProperty(_ǿ������, ǿ������);
	}

	public List<ImportStock> findBy��Ծ��(Object ��Ծ��) {
		return findByProperty(_��Ծ��, ��Ծ��);
	}

	public List<ImportStock> findByÿ�ʾ���(Object ÿ�ʾ���) {
		return findByProperty(_ÿ�ʾ���, ÿ�ʾ���);
	}

	public List<ImportStock> findByÿ�ʻ���(Object ÿ�ʻ���) {
		return findByProperty(_ÿ�ʻ���, ÿ�ʻ���);
	}

	public List<ImportStock> findBy��������(Object ��������) {
		return findByProperty(_��������, ��������);
	}

	public List<ImportStock> findBy��������(Object ��������) {
		return findByProperty(_��������, ��������);
	}

	public List<ImportStock> findBy�ܹɱ�wan(Object �ܹɱ�wan) {
		return findByProperty(�ܹɱ�WAN, �ܹɱ�wan);
	}

	public List<ImportStock> findBy���ҹ�(Object ���ҹ�) {
		return findByProperty(_���ҹ�, ���ҹ�);
	}

	public List<ImportStock> findBy����ͬ��(Object ����ͬ��) {
		return findByProperty(_����ͬ��, ����ͬ��);
	}

	public List<ImportStock> findBy����ͬ��(Object ����ͬ��) {
		return findByProperty(_����ͬ��, ����ͬ��);
	}

	public List<ImportStock> findByB�ɻ�a(Object b�ɻ�a) {
		return findByProperty(B�ɻ�A, b�ɻ�a);
	}

	public List<ImportStock> findByH��(Object h��) {
		return findByProperty(H��, h��);
	}

	public List<ImportStock> findByְ����(Object ְ����) {
		return findByProperty(_ְ����, ְ����);
	}

	public List<ImportStock> findBy���ʲ�wan(Object ���ʲ�wan) {
		return findByProperty(���ʲ�WAN, ���ʲ�wan);
	}

	public List<ImportStock> findBy�����ʲ�(Object �����ʲ�) {
		return findByProperty(_�����ʲ�, �����ʲ�);
	}

	public List<ImportStock> findBy�̶��ʲ�(Object �̶��ʲ�) {
		return findByProperty(_�̶��ʲ�, �̶��ʲ�);
	}

	public List<ImportStock> findBy�����ʲ�(Object �����ʲ�) {
		return findByProperty(_�����ʲ�, �����ʲ�);
	}

	public List<ImportStock> findBy����Ͷ��(Object ����Ͷ��) {
		return findByProperty(_����Ͷ��, ����Ͷ��);
	}

	public List<ImportStock> findBy������ծ(Object ������ծ) {
		return findByProperty(_������ծ, ������ծ);
	}

	public List<ImportStock> findBy���ڸ�ծ(Object ���ڸ�ծ) {
		return findByProperty(_���ڸ�ծ, ���ڸ�ծ);
	}

	public List<ImportStock> findBy������(Object ������) {
		return findByProperty(_������, ������);
	}

	public List<ImportStock> findByÿ�ɹ���(Object ÿ�ɹ���) {
		return findByProperty(_ÿ�ɹ���, ÿ�ɹ���);
	}

	public List<ImportStock> findBy���ʲ�(Object ���ʲ�) {
		return findByProperty(_���ʲ�, ���ʲ�);
	}

	public List<ImportStock> findBy��Ӫ����(Object ��Ӫ����) {
		return findByProperty(_��Ӫ����, ��Ӫ����);
	}

	public List<ImportStock> findBy��Ӫ����(Object ��Ӫ����) {
		return findByProperty(_��Ӫ����, ��Ӫ����);
	}

	public List<ImportStock> findBy�о���(Object �о���) {
		return findByProperty(_�о���, �о���);
	}

	public List<ImportStock> findByӪҵ����(Object Ӫҵ����) {
		return findByProperty(_Ӫҵ����, Ӫҵ����);
	}

	public List<ImportStock> findByͶ������(Object Ͷ������) {
		return findByProperty(_Ͷ������, Ͷ������);
	}

	public List<ImportStock> findBy��Ӫ�ֽ���(Object ��Ӫ�ֽ���) {
		return findByProperty(_��Ӫ�ֽ���, ��Ӫ�ֽ���);
	}

	public List<ImportStock> findBy���ֽ���(Object ���ֽ���) {
		return findByProperty(_���ֽ���, ���ֽ���);
	}

	public List<ImportStock> findBy���(Object ���) {
		return findByProperty(_���, ���);
	}

	public List<ImportStock> findBy�����ܶ�(Object �����ܶ�) {
		return findByProperty(_�����ܶ�, �����ܶ�);
	}

	public List<ImportStock> findBy˰������(Object ˰������) {
		return findByProperty(_˰������, ˰������);
	}

	public List<ImportStock> findBy������(Object ������) {
		return findByProperty(_������, ������);
	}

	public List<ImportStock> findByδ������(Object δ������) {
		return findByProperty(_δ������, δ������);
	}

	public List<ImportStock> findByÿ�ɾ���(Object ÿ�ɾ���) {
		return findByProperty(_ÿ�ɾ���, ÿ�ɾ���);
	}

	public List<ImportStock> findBy��������(Object ��������) {
		return findByProperty(_��������, ��������);
	}

	public List<ImportStock> findBy������(Object ������) {
		return findByProperty(_������, ������);
	}

	public List<ImportStock> findByÿ��δ����(Object ÿ��δ����) {
		return findByProperty(_ÿ��δ����, ÿ��δ����);
	}

	public List<ImportStock> findByÿ������(Object ÿ������) {
		return findByProperty(_ÿ������, ÿ������);
	}

	public List<ImportStock> findByȨ�����(Object Ȩ�����) {
		return findByProperty(_Ȩ�����, Ȩ�����);
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