package com.app;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Employee;
import com.example.service.ServiceImpl;
import com.example.service.ServiceInterface;

@RestController
public class ControllerClass {
	String msg = "";
	ServiceInterface service = new ServiceImpl();

	@PostMapping("/insert")
	public ResponseEntity<String> insertRecord(@RequestBody Employee employee) {
		msg = service.insertRecord(employee);

		return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);

	}

	@PutMapping("/update/{eid}")
	public ResponseEntity<String> updateRecord(@PathVariable("eid") int id, @RequestBody Employee e) {

		msg = service.updateRecord(id, e);

		return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);

	}

	@DeleteMapping("/delete/{eid}")
	public ResponseEntity<String> deleteRecord(@PathVariable("eid") int id) {
		msg = service.deleteRecord(id);
		return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);

	}

	@GetMapping(value = "fetchAll")
	public ResponseEntity<List<Employee>> fetchAllRecord() {
		List<Employee> list = service.fetchAllRecord();
		return new ResponseEntity<>(list, HttpStatus.FORBIDDEN);

	}

	@GetMapping("and/{name}")
	public ResponseEntity<List<Employee>> andApi(@PathVariable String name) {

		List<Employee> list = service.andApi(name);
		return new ResponseEntity<>(list, HttpStatus.FORBIDDEN);

	}

	@GetMapping("or/{name}/{add}")
	public ResponseEntity<List<Employee>> orApi(@PathVariable("name") String name,@PathVariable("add") String add) {

		List<Employee> list = service.orApi(name, add);
		return new ResponseEntity<>(list, HttpStatus.FORBIDDEN);

	}

	@GetMapping("and_or/{name}/{add}")
	public ResponseEntity<List<Employee>> and_orApi(@PathVariable("name") String name,@PathVariable("add") String add) {

		List<Employee> list = service.and_orApi(name, add);
		return new ResponseEntity<>(list, HttpStatus.FORBIDDEN);

	}

	@GetMapping("distinct")
	public ResponseEntity<List<String>> distinctApi() {

		List<String> list = service.distinctApi();
		return new ResponseEntity<>(list, HttpStatus.FORBIDDEN);

	}

	@GetMapping("orderBy")
	public ResponseEntity<List<Employee>> orderByApi() {

		List<Employee> list = service.orderByApi();
		return new ResponseEntity<>(list, HttpStatus.FORBIDDEN);

	}

	@GetMapping("groupBy")
	public ResponseEntity<List<Employee>> groupByApi() {

		List<Employee> list = service.groupByApi();
		return new ResponseEntity<>(list, HttpStatus.FORBIDDEN);

	}

}
