package com.example.StudentCrud.StudRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentCrud.Entity.Student;

public interface Studrepo extends JpaRepository<Student, Integer> {

}
