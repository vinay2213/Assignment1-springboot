package com.example.vinay.assignmentspringboot.service;

import com.example.vinay.assignmentspringboot.entity.ProjectTable;
import com.example.vinay.assignmentspringboot.exception.ResourceNotFoundException;
import com.example.vinay.assignmentspringboot.repository.ProjectTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTableService {

    @Autowired
    private ProjectTableRepository projectTableRepository;

    public List<ProjectTable> findByBrand_BrandId(int brandId)
    {
            if(projectTableRepository.findByBrand_BrandId(brandId).isEmpty())
            {
                throw new ResourceNotFoundException("No projects exist with brandId : " + brandId);
            }
            return projectTableRepository.findByBrand_BrandId(brandId);
    }
}
