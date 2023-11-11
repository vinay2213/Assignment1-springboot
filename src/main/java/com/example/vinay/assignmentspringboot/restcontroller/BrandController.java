package com.example.vinay.assignmentspringboot.restcontroller;


import com.example.vinay.assignmentspringboot.entity.Brand;
import com.example.vinay.assignmentspringboot.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> getAllBrands() {
        List<Brand> brands = brandService.getAllBrands();
        return brands;
    }
}
