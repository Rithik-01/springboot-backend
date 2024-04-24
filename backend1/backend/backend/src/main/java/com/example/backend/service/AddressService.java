package com.example.backend.service;

import com.example.backend.models.Address;

public interface AddressService {
    Address createAddress(Address address);
    Address updateAddress(Long id, Address addressDetails);
    void deleteAddress(Long id);
}


