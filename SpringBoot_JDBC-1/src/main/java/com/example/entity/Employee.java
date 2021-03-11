package com.example.entity;

import java.sql.Date;

public class Employee {
	private int employeeId;
	private String employeeName;
	private double employeeSallary;
	private Date employeeDob;
	private String employeeAddress;

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSallary="
				+ employeeSallary + ", employeeDob=" + employeeDob + ", employeeAddress=" + employeeAddress + "]";
	}

	public Employee(int employeeId, String employeeName, double employeeSallary, Date employeeDob,
			String employeeAddress) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSallary = employeeSallary;
		this.employeeDob = employeeDob;
		this.employeeAddress = employeeAddress;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getEmployeeSallary() {
		return employeeSallary;
	}

	public void setEmployeeSallary(double employeeSallary) {
		this.employeeSallary = employeeSallary;
	}

	public Date getEmployeeDob() {
		return employeeDob;
	}

	public void setEmployeeDob(Date employeeDob) {
		this.employeeDob = employeeDob;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

}
