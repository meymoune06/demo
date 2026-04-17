package com.example.demo.controller;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // GET all
    @GetMapping
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    // POST
    @PostMapping
    public Student create(@RequestBody @Valid Student student) {
        return studentRepository.save(student);
    }

    // GET by ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    // PUT - تعديل طالب
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody @Valid Student updated) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(updated.getName());
        student.setEmail(updated.getEmail());
        return studentRepository.save(student);
    }

    // GET with pagination
    @GetMapping("/page")
    public Page<Student> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return studentRepository.findAll(PageRequest.of(page, size));
    }

    // GET search by name
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return studentRepository.findByName(name);
    }
}