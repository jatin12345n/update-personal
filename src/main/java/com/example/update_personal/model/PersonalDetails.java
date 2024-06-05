package com.example.update_personal.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PersonalDetails {

    @Id
    @GeneratedValue
    Long id;


    String name;


    String email;

    @Size(max = 10, message = "phone Number should be at least 10 characters")
    String phone;



    @Size(min = 10, max = 10, message = "pan card should have at least 10 characters")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "enter a valid pan no.")
    String panCard;
}
