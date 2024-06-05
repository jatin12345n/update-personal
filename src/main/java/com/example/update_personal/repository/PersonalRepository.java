package com.example.update_personal.repository;

import com.example.update_personal.model.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface PersonalRepository extends JpaRepository<PersonalDetails, Long> {
 Optional<PersonalDetails>findById(Long id);

}
