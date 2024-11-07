package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class ControllerForStudent {

    private static final Logger logger = LoggerFactory.getLogger(ControllerForStudent.class);

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        try {
            // Save the student to the database
            Student savedStudent = studentRepository.save(student);
            logger.info("Student saved successfully: {}", savedStudent);
            return ResponseEntity.ok(savedStudent);
        } catch (Exception e) {
            logger.error("Error saving student: {}", e.getMessage(), e);
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to save student: " + e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }
}
