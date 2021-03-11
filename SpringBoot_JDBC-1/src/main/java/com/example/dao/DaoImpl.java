package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.JDBC.SqlConnectionUtil;
import com.example.entity.Employee;

public class DaoImpl implements DaoInterface {
	String msg = "";

	Connection connection = SqlConnectionUtil.getConnection();
	Statement stmp;

	@Override
	public List<Employee> fetchAllRecord() {
		List<Employee> list = new ArrayList<>();
		try {
			stmp = connection.createStatement();

			ResultSet set = stmp.executeQuery("SELECT * FROM employee;");
			while (set.next()) {
				Employee employee = new Employee(set.getInt(1), set.getString(2), set.getDouble(3), set.getDate(4),
						set.getString(5));
				list.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public String deleteRecord(int id) {

		try {
			stmp = connection.createStatement();

			int i = stmp.executeUpdate("DELETE FROM employee WHERE employeeId = " + id + ";");

			if (i > 0)
				msg = "ID=" + id + " , This record deleted";
			else
				msg = "Record not fount";

		} catch (SQLException e) {
			
				e.printStackTrace();
			}

			

		return msg;
	}

	@Override
	public String updateRecord(int id,Employee e) {
		
		String sqlString="UPDATE `dec_ojt`.`employee` " + 
				"SET `employeeName` = '"+e.getEmployeeName()+"', "
				+ "`employeeSallary` = '"+e.getEmployeeSallary()+"',"
				+ " `employeeDob` = '"+e.getEmployeeDob()+"', "
				+ "`employeeAdd` = '"+e.getEmployeeAddress()+"' " + 
				"WHERE (`employeeId` = '"+id+"');" ;
		try {
			int i=stmp.executeUpdate(sqlString);
			if (i > 0)
				msg = "ID=" + id + " , This record updated";
			else
				msg = "Record not fount";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return msg;
	}

	@Override
	public String insertRecord(Employee employee) {
		try {
			stmp = connection.createStatement();
			int i=stmp.executeUpdate(
					"INSERT INTO `dec_ojt`.`employee` (`employeeName`, `employeeSallary`, `employeeDob`, `employeeAdd`) VALUES"
							+ " ('" + employee.getEmployeeName() + "', '" + employee.getEmployeeSallary() + "', '"
							+ employee.getEmployeeDob() + "', '" + employee.getEmployeeAddress() + "');");
			if(i>0)
				msg="one Record Insrted";
			else
				msg="error";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msg;
	}

		@Override
	public List<Employee> orderByApi() {
			List<Employee> list = new ArrayList<>();
			try {
				stmp = connection.createStatement();

				ResultSet set = stmp.executeQuery(" SELECT * FROM employee ORDER BY employeeDob;");
				while (set.next()) {
					Employee employee = new Employee(set.getInt(1), set.getString(2), set.getDouble(3), set.getDate(4),
							set.getString(5));
					list.add(employee);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return list;
	}

	@Override
	public List<Employee> groupByApi() {
		List<Employee> list = new ArrayList<>();
		try {
			stmp = connection.createStatement();

			ResultSet set = stmp.executeQuery(" SELECT *, COUNT(*) FROM employee GROUP BY employeeName, employeeAdd;");
			while (set.next()) {
				Employee employee = new Employee(set.getInt(1), set.getString(2), set.getDouble(3), set.getDate(4),
						set.getString(5));
				list.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<String> distinctApi() {
		List<String> list = new ArrayList<>();
		try {
			stmp = connection.createStatement();

			ResultSet set = stmp.executeQuery("  SELECT DISTINCT employeeAdd FROM employee;");
			while (set.next()) {
//				Employee employee = new Employee();
//						employee.setEmployeeAddress(set.getString(5));
				String addString=set.getString("employeeAdd");
				list.add(addString);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Employee> andApi(String name) {
		List<Employee> list = new ArrayList<>();
		try {
			stmp = connection.createStatement();

			ResultSet set = stmp.executeQuery(" SELECT * FROM employee WHERE employeeName ='"+name+"' AND employeeSallary >50000;" + 
					"");
			while (set.next()) {
				Employee employee = new Employee(set.getInt(1), set.getString(2), set.getDouble(3), set.getDate(4),
						set.getString(5));
				list.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Employee> orApi(String name, String add) {
		List<Employee> list = new ArrayList<>();
		try {
			stmp = connection.createStatement();

			String sqlString="SELECT * FROM employee WHERE employeeName = '"+name+"' OR employeeAdd = '"+add+"';" + 
					"";
			ResultSet set = stmp.executeQuery(sqlString);
					
			while (set.next()) {
				Employee employee = new Employee(set.getInt(1), set.getString(2), set.getDouble(3), set.getDate(4),
						set.getString(5));
				list.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	

	@Override
	public List<Employee> and_orApi(String name, String add) {
		List<Employee> list = new ArrayList<>();
		try {
			stmp = connection.createStatement();

			String sqlString="SELECT * FROM employee WHERE (employeeName = '"+name+"' AND employeeAdd = '"+add+"')\r\n" + 
					"       OR (employeeAdd = '"+add+"' AND employeeSallary>50000);";
			ResultSet set = stmp.executeQuery(sqlString);
					
			while (set.next()) {
				Employee employee = new Employee(set.getInt(1), set.getString(2), set.getDouble(3), set.getDate(4),
						set.getString(5));
				list.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

}
