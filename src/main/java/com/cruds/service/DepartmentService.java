package com.cruds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.db.DepartmentDAO;
import com.cruds.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	DepartmentDAO dao;
	
	public List<Department> getAll()
	{
		return dao.getAll();
	}
	
	public void create(Department d)
	{
		dao.create(d);
	}
	
	public void delete(int deptId)
	{
		dao.delete(deptId);
	}
	
	public Department edit(int deptId)
	{
		return dao.edit(deptId);
	}
	
	public void update(Department d)
	{
		dao.update(d);
	}

	
}
