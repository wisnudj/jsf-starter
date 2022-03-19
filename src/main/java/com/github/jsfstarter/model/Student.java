package com.github.jsfstarter.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

public class Student {
    @NotEmpty(message = "id tidak boleh kosong")
    private Long id;

    @NotEmpty(message = "first name tidak boleh kosong")
    private String firstName;

    @NotEmpty(message = "last name tidak boleh kosong")
    private String lastName;

    @NotEmpty(message = "email tidak boleh kosong")
    private String email;

    @NotEmpty(message = "created at tidak boleh kosong")
    private LocalDateTime createdAt;

    @NotEmpty(message = "updated at tidak boleh kosong")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
