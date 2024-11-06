package com.example.crud;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class ControllerForStudent {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO, BindingResult result) {
        // Validation check
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        // Convert DTO to entity
        Student student = new Student();
        student.setUserName(studentDTO.getUserName());
        student.setType(studentDTO.getType());
        student.setEngName(studentDTO.getEngName());
        student.setEmail(studentDTO.getEmail());
        student.setFaculty(studentDTO.getFaculty());

        try {
            Student savedStudent = studentRepository.save(student);
            return ResponseEntity.ok(savedStudent);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to save student: " + e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }
}