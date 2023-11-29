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
@RolesAllowed({"ADMIN", "DEVELOPER"})
public class ProjectTableController
{
    @Autowired
    private ProjectTableService projectTableService;

    @GetMapping("/projectdetails")
    public ResponseEntity<List<ProjectTable>> getBrandDetails(@RequestParam ("brand_name") String brandName) throws Exception {
        List<ProjectTable> projectDetails = projectTableService.getProjectsByBrandName(brandName);
        return ResponseEntity.ok(projectDetails);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProjectTable>> getProjectDetailsByFiltering(
            @RequestParam(value="brand_name", required = false) String brandName,
            @RequestParam(value="country_name",required = false) String countryName
    ) {
        List<ProjectTable> filteredProjects = projectTableService.getFilteredProjectDetails(brandName, countryName);
        return ResponseEntity.ok(filteredProjects);
    }
}
