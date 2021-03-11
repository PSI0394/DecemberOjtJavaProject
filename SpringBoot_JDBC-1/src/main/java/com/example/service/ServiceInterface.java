package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface ServiceInterface {

	String insertRecord(Employee employee);

	String updateRecord(int id,Employee e);

	String deleteRecord(int id);

	List<Employee> fetchAllRecord();

	List<Employee> andApi(String name);

	List<Employee> orApi(String name, String add);

	List<Employee> and_orApi(String name, String add);

	List<Employee> groupByApi();

	List<Employee> orderByApi();

	List<String> distinctApi();

}
