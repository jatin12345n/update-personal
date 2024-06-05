package com.example.update_personal.controller;

import com.example.update_personal.model.PersonalDetails;
import com.example.update_personal.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
public class PersonalController {

    @Autowired
    PersonalService service;

    @PostMapping("/adding_personal_details")
    public String add(@RequestBody PersonalDetails personalDetails){
       return service.add(personalDetails);
    }
    @GetMapping("/getAllDetails")
    public List<PersonalDetails>getAll(){
        return service.getAll();
    }

    @PatchMapping("updating_personal_details/{id}")
    public ResponseEntity<PersonalDetails> update(@PathVariable Long id, @RequestBody Map<String, Object>updates){
        PersonalDetails personalDetails=service.update(id, updates);
        if (personalDetails!=null){
            return ResponseEntity.ok(personalDetails);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
