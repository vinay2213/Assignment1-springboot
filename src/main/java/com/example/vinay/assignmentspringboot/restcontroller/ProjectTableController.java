package com.example.vinay.assignmentspringboot.restcontroller;

import com.example.vinay.assignmentspringboot.entity.ProjectTable;
import com.example.vinay.assignmentspringboot.service.ProjectTableService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RolesAllowed("ADMIN")
public class ProjectTableController
{
    @Autowired
    private ProjectTableService projectTableService;

    @GetMapping("/projectdetails")
    @RolesAllowed("ADMIN")
    public ResponseEntity<List<ProjectTable>> getBrandDetails(@RequestParam ("brand_name") String brandName){
        List<ProjectTable> projectDetails = projectTableService.getProjectDetails(brandName);
        return ResponseEntity.ok(projectDetails);
    }
}
