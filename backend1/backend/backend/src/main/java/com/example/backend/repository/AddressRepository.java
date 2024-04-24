package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
