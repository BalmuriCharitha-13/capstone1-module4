// package com.fdapp.analysisbackend.model;

// import com.fdapp.analysisbackend.enums.UserRole;
// import jakarta.persistence.*;
// import lombok.Data;
// import java.time.LocalDateTime;
// import java.util.UUID;

// @Data
// @Entity
// @Table(name = "users")
// public class User {

//     @Id
//     @GeneratedValue
//     private UUID id;

//     @Column(nullable = false)
//     private String name;

//     @Column(name = "email", unique = true, nullable = false)
//     private String email;

//     @Column(name = "passwordhash", nullable = false)   // 🔥 required mapping
//     private String passwordHash;

//     @Column(name = "phone")
//     private String phone;

//     @Enumerated(EnumType.STRING)
//     @Column(name = "role" , nullable = false)                              // 🔥 required mapping
//     private UserRole role;

//     @Column(name = "createdat" , nullable = false)                         // 🔥 required mapping
//     private LocalDateTime createdAt;
// }


package com.fdapp.analysisbackend.model;

import com.fdapp.analysisbackend.enums.UserRole;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "passwordhash", nullable = false)
    private String passwordHash;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @Column(name = "createdat", nullable = false)
    private LocalDateTime createdAt;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
