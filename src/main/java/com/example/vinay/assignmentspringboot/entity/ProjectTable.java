package com.example.vinay.assignmentspringboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ProjectTable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int projectId;

    @Column(length = 50)
    private String projectName;

    @Column
    private LocalDateTime projectCreationTime;

    @Column
    private LocalDate projectCompletionDate;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDateTime getProjectCreationTime() {
        return projectCreationTime;
    }

    public void setProjectCreationTime(LocalDateTime projectCreationTime) {
        this.projectCreationTime = projectCreationTime;
    }

    public LocalDate getProjectCompletionDate() {
        return projectCompletionDate;
    }

    public void setProjectCompletionDate(LocalDate projectCompletionDate) {
        this.projectCompletionDate = projectCompletionDate;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
