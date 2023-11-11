package com.example.vinay.assignmentspringboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Country
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int countryId;

    @Column(length = 100)
    private String countryName;

    @JsonBackReference
    @OneToMany(mappedBy = "country")
    private List<ProjectTable> project;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<ProjectTable> getProject() {
        return project;
    }

    public void setProject(List<ProjectTable> project) {
        this.project = project;
    }
}
