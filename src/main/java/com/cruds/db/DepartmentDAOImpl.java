package com.cruds.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.entity.Department;

@Repository    // if annotation is not used here autowired(bean) will not be recognized
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired   //if not null pointer
	private SessionFactory sf;
	
	public void create(Department d) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		session.close();
		
	}

	public List<Department> getAll() {
		
		Session session = sf.openSession();
		List<Department> list = (List<Department>) session.createQuery("from Department").list();
		return list;
	}

	public void delete(int deptId) {

		Session session = sf.openSession();
		session.getTransaction().begin();
		Department d = (Department) session.load(Department.class, deptId);
		
		session.delete(d);
		session.getTransaction().commit();
		
		session.close();

		
	}

	public Department edit(int deptId) {
		
		String hql = "from Department u where u.deptId = ? ";
		
		Session session = sf.openSession();
		
		List<Department> list = session.createQuery(hql).setInteger(0, deptId).list();
		
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

	public void update(Department d) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(d);
		session.getTransaction().commit();
		session.close();
		
	}

		
}
	


