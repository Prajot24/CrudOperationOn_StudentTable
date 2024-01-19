package com.example.StudentCrud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentCrud.Entity.Student;
import com.example.StudentCrud.ExceptionHand.ResourceNotFound;
import com.example.StudentCrud.StudRepo.Studrepo;

@Service
public class StudentService {
	
	@Autowired
	private Studrepo stdrepo;
	
	public Student SearchById(int id) {
		Student std = this.stdrepo.findById(id).orElseThrow(() -> new ResourceNotFound("Student", "ID", id));
		return std;
	}
	
	public Student createStd(Student std) {
		Student stud=this.stdrepo.save(std);
		return stud;
	}
	
	public Student update(Student std,int id) {
		Student SaveSd = this.stdrepo.findById(id).orElseThrow(()-> new ResourceNotFound("Student", "ID", id));
		
		SaveSd.setAge(std.getAge());
		SaveSd.setEmail(std.getEmail());
		SaveSd.setName(std.getName());
		
		Student update = this.stdrepo.save(SaveSd);
		
		return update;
			
	}
	
	public void delete(int id) {
		Student std = this.stdrepo.findById(id).orElseThrow(() -> new ResourceNotFound("Student", "Id", id));
		
		this.stdrepo.delete(std);
	}

}
