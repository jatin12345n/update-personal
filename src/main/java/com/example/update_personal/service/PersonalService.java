package com.example.update_personal.service;

import com.example.update_personal.model.PersonalDetails;
import com.example.update_personal.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonalService {


    @Autowired
    PersonalRepository repository;

    public String add(PersonalDetails personalDetails) {
        repository.save(personalDetails);
        return "Successfully added to database";
    }

    public Optional<PersonalDetails> getDetailsById(Long id) {
        return repository.findById(id);
    }


    public List<PersonalDetails> getAll() {
        return repository.findAll();
    }

    public PersonalDetails update(Long id, Map<String, Object> updates) {
        Optional<PersonalDetails> optional = repository.findById(id);
        if (optional.isPresent()) {
            PersonalDetails personalDetails = optional.get();
            updates.forEach((key, value) -> {
                switch (key) {
                    case "name":
                        personalDetails.setName((String) value);
                        break;
                    case "email":
                        personalDetails.setEmail((String) value);
                        break;
                    case "phone":
                        personalDetails.setPhone((String) value);
                        break;
                    case "panCard":
                        personalDetails.setPanCard((String) value);

                }
            });
           return repository.save(personalDetails);

        } else {
            return null;
        }
    }
}
