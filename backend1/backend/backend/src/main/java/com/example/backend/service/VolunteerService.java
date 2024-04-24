package com.example.backend.service;

import java.util.List;

import com.example.backend.models.Volunteer;

public interface VolunteerService {

    List<Volunteer> getAllVolunteers();
    
    Volunteer getVolunteerById(Long id);
    
    Volunteer createVolunteer(Volunteer volunteer);
    
    Volunteer updateVolunteer(Long id, Volunteer volunteerDetails);
    
    void deleteVolunteer(Long id);
    
} 

