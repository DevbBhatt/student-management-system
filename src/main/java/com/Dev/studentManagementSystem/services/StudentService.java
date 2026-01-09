package com.Dev.studentManagementSystem.services;

import com.Dev.studentManagementSystem.modal.Student;
import com.Dev.studentManagementSystem.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;


    public void addStudent(Student student) {
        repo.save(student);
    }

    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    public Student getStudentById(int id) {
        return repo.findById(id).orElse(null);
    }

    public boolean updateStudent(Student student,int id) {

          Student old = repo.findById(id).orElse(null);

          if(old == null) return false;

        if (student.getName() != null) old.setName(student.getName());
        if (student.getEmail() != null) old.setEmail(student.getEmail());
        if (student.getCourse() != null) old.setCourse(student.getCourse());
        if (student.getPhoneNo() != 0) old.setPhoneNo(student.getPhoneNo());
        if (student.getAge() != 0) old.setAge(student.getAge());

        repo.save(old);
          return true;



    }


    public boolean deleteStudent(int id) {
        if (repo.findById(id).isEmpty()) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }



}
