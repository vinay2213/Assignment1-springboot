package com.example.vinay.assignmentspringboot.restcontroller;

import com.example.vinay.assignmentspringboot.entity.ProjectTable;
import com.example.vinay.assignmentspringboot.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectTableController
{
    @Autowired
    private BrandService brandService;

    @GetMapping("/projectdetails")
    public ResponseEntity<List<ProjectTable>> getBrandDetails(@RequestParam ("brand_name") String brandName){
        List<ProjectTable> projectDetails = brandService.getProjectDetails(brandName);
        return ResponseEntity.ok(projectDetails);
    }
}
