package com.hib.moudle;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.dataprovider.Txt;
import com.app.main.MainFrame;

public class Filemd5DAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(Filemd5DAO.class);
	// property constants
	public static final String FILENAME = "filename";
	public static final String MD5 = "md5";
	public void save(Filemd5 transientInstance) {
		log.debug("saving Filemd5 instance");
		try {
			getSession().beginTransaction();
			getSession().save(transientInstance);
			getSession().getTransaction().commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Filemd5 persistentInstance) {
		log.debug("deleting Filemd5 instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Filemd5 findById(java.lang.String id) {
		log.debug("getting Filemd5 instance with id: " + id);
		try {
			Filemd5 instance = (Filemd5) getSession().get(
					"com.hib.moudle.Filemd5", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public boolean ismd5exist(String md5){
		String hql = "from Filemd5 where md5='"+md5+"'";
		boolean isexist=false;
		try{
			getSession().beginTransaction();
			Query q = getSession().createQuery(hql);
			getSession().getTransaction().commit();
			List ls = q.list();
			if(ls.size()==0){
				isexist =  false;
			}
			else{
				isexist = true;
			}
		}
		catch(Exception e){
			isexist = false;
			MainFrame.getInstance().getTextPane().insert(e.getMessage(), MainFrame.getInstance().getTextPane().getRows());
			log.error("get failed", e);
			
		}
		return isexist;
	}
	
	

	public List<Filemd5> findByExample(Filemd5 instance) {
		log.debug("finding Filemd5 instance by example");
		try {
			List<Filemd5> results = (List<Filemd5>) getSession()
					.createCriteria("com.hib.moudle.Filemd5").add(
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
		log.debug("finding Filemd5 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Filemd5 as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Filemd5> findByFilename(Object filename) {
		return findByProperty(FILENAME, filename);
	}

	public List<Filemd5> findByMd5(Object md5) {
		return findByProperty(MD5, md5);
	}

	public List findAll() {
		log.debug("finding all Filemd5 instances");
		try {
			String queryString = "from Filemd5";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Filemd5 merge(Filemd5 detachedInstance) {
		log.debug("merging Filemd5 instance");
		try {
			Filemd5 result = (Filemd5) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Filemd5 instance) {
		log.debug("attaching dirty Filemd5 instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Filemd5 instance) {
		log.debug("attaching clean Filemd5 instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}