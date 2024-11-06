package com.example.crud;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="student")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_name", nullable = false)
    private String userName;
    
    @Column(name = "type", nullable = false)
    private String type;
    
    @Column(name = "displayname_en", nullable = false)
    private String engName;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "faculty", nullable = false)
    private String faculty;

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setEngName(String engName) {
        this.engName = engName;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}