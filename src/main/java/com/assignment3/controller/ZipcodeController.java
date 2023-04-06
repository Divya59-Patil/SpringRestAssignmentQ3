package com.assignment3.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment3.entities.Zipcode;
import com.assignment3.repo.ZipcodeRepository;

@RestController
@RequestMapping("/zipcode")
public class ZipcodeController {
    @Autowired
    private ZipcodeRepository zipcodeRepository;

    @GetMapping("/{zipcode}")
    public ResponseEntity<Map<String, String>> getByZipcode(@PathVariable String zipcode) {
        Optional<Zipcode> optionalZipcode = zipcodeRepository.findByZipcode(zipcode);
        if (optionalZipcode.isPresent()) {
            Zipcode result = optionalZipcode.get();
            Map<String, String> response = new HashMap<>();
            response.put("state", result.getState());
            response.put("city", result.getCity());
            response.put("country", result.getCountry());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
