package com.example.backend.repository;

import com.example.backend.models.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VolunteerService {

    @Autowired
    private volunteerRepository volunteerRepository;

    public List<Volunteer> getVolunteersWithPhoneNumberStartingWith9595() {
        return volunteerRepository.findByPhoneStartingWith("9595");
    }
    public List<Volunteer> getVolunteersWithEmailEndingWithYahoo() {
        return volunteerRepository.findByEmailEndingWith("yahoo.com");
    }
}
