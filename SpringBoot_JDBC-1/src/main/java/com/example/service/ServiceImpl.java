package com.example.service;



import java.util.List;

import com.example.dao.DaoImpl;
import com.example.dao.DaoInterface;
import com.example.entity.Employee;

public class ServiceImpl implements ServiceInterface {
	DaoInterface dao=new DaoImpl();
	String msg="";

	@Override
	public String insertRecord(Employee employee) {
		msg=dao.insertRecord(employee);
		
		return msg;
	}

	@Override
	public String updateRecord(int id,Employee e) {
		msg=dao.updateRecord(id, e);
	
		return msg;
	}

	@Override
	public String deleteRecord(int id) {
		msg=dao.deleteRecord(id);
		return msg;
	}

	@Override
	public List<Employee> fetchAllRecord() {
		List<Employee> list=dao.fetchAllRecord();
		
		return list;
	}

	@Override
	public List<Employee> andApi(String name) {
		List<Employee> list=dao.andApi(name);
		return list;
	}

	@Override
	public List<Employee> orApi(String name, String add) {
		List<Employee> list=dao.orApi(name,add);
		return list;
	}

	@Override
	public List<Employee> and_orApi(String name, String add) {
		List<Employee> list=dao.and_orApi(name,add);
		return list;
	}

	@Override
	public List<Employee> groupByApi() {
		List<Employee> list=dao.groupByApi();
		return list;
	}

	@Override
	public List<Employee> orderByApi() {
		List<Employee> list=dao.orderByApi();
		return list;
	}

	@Override
	public List<String> distinctApi() {
		List<String> list=dao.distinctApi();
		return list;
	}

}
