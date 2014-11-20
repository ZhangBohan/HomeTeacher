package com.jiajiaohello.support.core;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * User: bohan
 * Date: 11/13/14
 * Time: 5:58 PM
 */
@Repository
public class CommonDao<T> {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public T get(Integer id, Class<T> clazz) {
		return hibernateTemplate.get(clazz, id);
	}

	public T get(T entity) {
		List<T> list = getList(entity);
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	@Transactional
	public void saveOrUpdate(T entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

	public List<T> getList(T entity) {
		return hibernateTemplate.findByExample(entity);
	}

	public List<T> getList(T entity, int firstResult, int maxResult) {
		return hibernateTemplate.findByExample(entity, firstResult, maxResult);
	}

	@Transactional
	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	public void delete(Integer id, Class<T> clazz) {
		T t = get(id, clazz);
		if(t == null) {
			throw new EntityNotFoundException();
		}
		delete(t);
	}
	public int getCount( Class<T> clazz) {
		String hql = "select count(1) from "+clazz.getName();
		int count = Integer.parseInt(hibernateTemplate.find(hql).listIterator().next()+"");
		return count;
	}
}
