package com.bt.sys.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bt.sys.dao.UserDao;
import com.bt.sys.entity.User;


@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	//获取和当前线程绑定的Seesion
    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
	
	@Override
	public List<User> selectUser() {
		String hql = "from User";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<User> selectUserByName(String name) {
		String hql = "from User where name=?";
		Query query = getSession().createQuery(hql).setParameter(0, name);
		return query.list();
	}

	@Override
	public void saveUser(User user) {
		getSession().save(user);
	}

	@Override
	public void deleteUser(User user) {
		getSession().delete(user);
	}

	@Override
	public void updateUser(User user) {
		
		getSession().update(user);
	}


	
}
