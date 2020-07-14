package com.xyz.student.records.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.student.records.model.Student;

@Repository
public interface StudentRecordRepository extends JpaRepository<Student, Integer>{

}
