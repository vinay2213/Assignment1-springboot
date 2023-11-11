package com.example.vinay.assignmentspringboot.service;

import com.example.vinay.assignmentspringboot.repository.ProjectTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTableService {

    @Autowired
    private ProjectTableRepository projectTableRepository;

//    public List<ProjectTable> getProjectsByBrand(String brandName)
//    {
//        return projectTableRepository.findByBrand_BrandName(brandName);
//    }
}
