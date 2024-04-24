package com.example.backend.controller;

import com.example.backend.models.Address;
import com.example.backend.models.Volunteer;
import com.example.backend.repository.AddressRepository;
import com.example.backend.repository.volunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class volunteerController {

    @Autowired
    private volunteerRepository volunteerRepository;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/get")
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    // @PostMapping("/post")
    // public Volunteer createVolunteer(@RequestBody Volunteer volunteer) {
    //     return volunteerRepository.save(volunteer);
    // }
    @PostMapping("/post")
public Volunteer createVolunteer(@RequestBody Volunteer volunteer) {
    // Save the address first
    Address savedAddress = addressRepository.save(volunteer.getAddress());
    volunteer.setAddress(savedAddress);
    return volunteerRepository.save(volunteer);
}


    @GetMapping("/{id}")
    public Volunteer getVolunteerById(@PathVariable Long id) {
        return volunteerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Volunteer not found with id: " + id));
    }

    @PutMapping("/update/{id}")
    public Volunteer updateVolunteer(@PathVariable Long id, @RequestBody Volunteer volunteerDetails) {
        Volunteer volunteer = volunteerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Volunteer not found with id: " + id));

        volunteer.setName(volunteerDetails.getName());
        volunteer.setEmail(volunteerDetails.getEmail());
        volunteer.setPhone(volunteerDetails.getPhone());
        volunteer.setAddress(volunteerDetails.getAddress());

        return volunteerRepository.save(volunteer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVolunteer(@PathVariable Long id) {
        volunteerRepository.deleteById(id);
    }

    @GetMapping("/phone/startingWith9595")
    public List<Volunteer> getVolunteersWithPhoneNumberStartingWith9595() {
        return volunteerRepository.findByPhoneStartingWith("9595");
    }
    @GetMapping("/email/endingWithYahoo.com")
    public List<Volunteer> getVolunteersWithEmailEndingWithYahoo() {
        return volunteerRepository.findByEmailEndingWith("yahoo.com");
    }
}
