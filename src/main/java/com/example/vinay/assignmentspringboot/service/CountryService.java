package com.example.vinay.assignmentspringboot.service;

import com.example.vinay.assignmentspringboot.entity.Country;
import com.example.vinay.assignmentspringboot.exception.ResourceNotFoundException;
import com.example.vinay.assignmentspringboot.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        try {
            return countryRepository.findAll();
        }
        catch (Exception e) {
            throw new ResourceNotFoundException("Error occurred while fetching all countries");
        }
    }
}