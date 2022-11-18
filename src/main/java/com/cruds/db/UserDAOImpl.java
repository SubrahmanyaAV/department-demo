package com.cruds.db;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sf;
	
	public User authenticate(String userId, String pwd) {
		
		String hql = "from User u where u.userId = ? and u.password = ? ";
		
		Session session = sf.openSession();
		
		List<User> list = session.createQuery(hql).setString(0, userId).setString(1, pwd).list();
	//	Query q = (Query) session.createQuery(hql);
	//	List<User> results =  q.list();
	//	return(User) sf.getCurrentSession().get(User.class,userId);
		System.out.println(list);
		
		session.close();
		
		if(list.size() > 0)
		{
			return list.get(0);
		}
		else 
		{
			return null;
		}
	}

}
