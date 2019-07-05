package com.haris.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.haris.demo.model.Employee;

public interface EmpDao extends JpaRepository<Employee, Integer>
{
	
//	List<Employee> findByDesignation(String designation);
//	
//	@Query("from Employee where name?=1 order by name")
//	List<Employee> findByNameSorted(String name);

}
