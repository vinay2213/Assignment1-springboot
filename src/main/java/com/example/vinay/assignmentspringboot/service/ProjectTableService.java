package com.example.vinay.assignmentspringboot.service;

import com.example.vinay.assignmentspringboot.entity.Brand;
import com.example.vinay.assignmentspringboot.entity.Country;
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
        Join<ProjectTable, Brand> brandJoin = root.join("brand", JoinType.INNER);
        Join<ProjectTable, Country> countryJoin = root.join("country", JoinType.INNER);

        Predicate brandNamePredicate = null;
        if (brandName != null) {
            brandNamePredicate = criteriaBuilder.like(brandJoin.get("brandName"), "%" + brandName + "%");
            predicates.add(brandNamePredicate);
        }

        Predicate countryNamePredicate = null;
        if(countryName != null) {
            countryNamePredicate = criteriaBuilder
                    .like(countryJoin.get("countryName"), "%" + countryName + "%");
            predicates.add(countryNamePredicate);
        }

        if(brandName != null && countryName != null){
            Predicate brandNameAndCountryNamePredicate = criteriaBuilder.and(
                    brandNamePredicate,
                    countryNamePredicate
            );
            predicates.add(brandNameAndCountryNamePredicate);
        }

        criteriaQuery.where(
                predicates.toArray(new Predicate[0])
        );

        TypedQuery<ProjectTable> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
