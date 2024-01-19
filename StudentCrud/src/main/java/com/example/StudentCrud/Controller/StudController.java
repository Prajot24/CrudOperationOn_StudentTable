package com.example.StudentCrud.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentCrud.Entity.Student;
import com.example.StudentCrud.Service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudController {
	
	@Autowired
	private StudentService stdService;
	
	@PostMapping("create")
	public ResponseEntity<Student> create(@RequestBody Student std){
		Student student = this.stdService.createStd(std);
		return new ResponseEntity<>(student,HttpStatus.CREATED);	
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Student> update(@PathVariable int id, @RequestBody Student std){
		Student update = this.stdService.update(std, id);
		return  ResponseEntity.ok(update);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<Student> FindById(@PathVariable int id){
		Student student = this.stdService.SearchById(id);		
		return ResponseEntity.ok(student);
	}
	
	@DeleteMapping("del/{id}")
	public ResponseEntity<Map<String, String>> Delete(@PathVariable int id){
		this.stdService.delete(id);
		return new ResponseEntity(Map.of("Message","Student Deleted SccessFully"),HttpStatus.OK);
	}

}
