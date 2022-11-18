package com.cruds.db;

import java.util.List;

import com.cruds.entity.Department;

public interface DepartmentDAO {
	
	public void create(Department d); 
	
	public List<Department> getAll();
	
	public void delete(int deptId);
	
	public Department edit(int deptId);
	
	public void update(Department d);

}
