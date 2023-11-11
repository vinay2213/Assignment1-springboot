package com.example.vinay.assignmentspringboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Brand
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int brandId;

    @Column(length = 50)
    private String brandName;

    public Brand() {
    }

    @OneToMany(mappedBy = "brand")
    @JsonManagedReference
    @JsonIgnoreProperties("projects")
    private List<ProjectTable> project;

//

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<ProjectTable> getProject() {
        return project;
    }

    public void setProject(List<ProjectTable> project) {
        this.project = project;
    }

}
