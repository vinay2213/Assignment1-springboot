package com.example.vinay.assignmentspringboot.service;

import com.example.vinay.assignmentspringboot.entity.ProjectTable;
import com.example.vinay.assignmentspringboot.exception.ResourceNotFoundException;
import com.example.vinay.assignmentspringboot.repository.ProjectTableRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectTableService {

    @Autowired
    private ProjectTableRepository projectTableRepository;

    @Autowired
    private BrandService brandService;

    public List<ProjectTable> getProjectsByBrandName(@RequestParam("brand_name") String brandName) throws Exception {
        if (brandName.isEmpty()) {
            throw new ResourceNotFoundException("Brand Name is empty");
        }

        if (brandService.findByBrandName(brandName) == null) {
            throw new ResourceNotFoundException("This brand is not present in the database");
        }

        List<ProjectTable> projectDetails = null;

        try {
            projectDetails= projectTableRepository.findByBrand_BrandName(brandName);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        if(projectDetails.isEmpty()) {
            throw new ResourceNotFoundException("No project details are present for (Brand = " + brandName + ")");
        }

        return projectDetails;
    }

    private final EntityManager entityManager;

    public List<ProjectTable> getFilteredProjectDetails(String brandName, String countryName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProjectTable> criteriaQuery = criteriaBuilder.createQuery(ProjectTable.class);
        List<Predicate> predicates = new ArrayList<>();

        Root<ProjectTable> root = criteriaQuery.from(ProjectTable.class);

        Predicate brandNamePredicate = null;
        if (brandName != null) {
            brandNamePredicate = criteriaBuilder.equal(root.get("brand").get("brandName"), brandName);
            predicates.add(brandNamePredicate);
        }

        Predicate countryNamePredicate = null;
        if(countryName != null) {
            countryNamePredicate = criteriaBuilder.equal(root.get("country").get("countryName"), countryName);
            predicates.add(countryNamePredicate);
        }

        criteriaQuery.where(
        predicates.toArray(new Predicate[predicates.size()])
        );

        TypedQuery<ProjectTable> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
