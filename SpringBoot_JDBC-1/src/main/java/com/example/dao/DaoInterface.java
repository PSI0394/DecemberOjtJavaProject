package com.example.dao;

import java.util.List;

import com.example.entity.Employee;

public interface DaoInterface {

	List<Employee> fetchAllRecord();

	String deleteRecord(int id);

	String updateRecord(int id,Employee employee);

	String insertRecord(Employee employee);

	List<Employee> andApi(String name);

	List<Employee> orApi(String name, String add);

	

	List<Employee> orderByApi();

	List<Employee> groupByApi();

	List<String> distinctApi();

	List<Employee> and_orApi(String name, String add);

}
