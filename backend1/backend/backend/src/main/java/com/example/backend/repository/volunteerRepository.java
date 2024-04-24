package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.models.Volunteer;
import java.util.List;

@Repository
public interface volunteerRepository extends JpaRepository<Volunteer, Long> {
    List<Volunteer> findByPhoneStartingWith(String prefix);
    List<Volunteer> findByEmailEndingWith(String suffix);
}
