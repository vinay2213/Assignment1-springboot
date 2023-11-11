package com.example.vinay.assignmentspringboot.restcontroller;

import com.example.vinay.assignmentspringboot.entity.Brand;
import com.example.vinay.assignmentspringboot.entity.ProjectTable;
import com.example.vinay.assignmentspringboot.repository.BrandRepository;
import com.example.vinay.assignmentspringboot.repository.ProjectTableRepository;
import com.example.vinay.assignmentspringboot.service.ProjectTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectTableController
{
    @Autowired
    private ProjectTableService projectTableService;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProjectTableRepository projectTableRepository;

    @GetMapping("/details")
    public ProjectTable getBrandDetails(@RequestParam ("brandName") String brandName){
//        System.out.println("entered");
//        System.out.println(brandRepository.findByBrandName(brandName).getBrandId() + " done");

        int brandId = brandRepository.findByBrandName(brandName).getBrandId();
        System.out.println(projectTableRepository.findByBrand_BrandId(brandId).get(0));
        return projectTableRepository.findByBrand_BrandId(brandId).get(0);
//        return details;
    }

//    @GetMapping("/byBrand")
//    public List<ProjectTable> getProjectsByBrand(@RequestParam("brand_name") String brandName) {
//        Brand brand = brand.getBrandId();
//        List<ProjectTable> projects = projectTableService.getProjectsByBrandName(brandId);
//        return projects;
//    }
}
