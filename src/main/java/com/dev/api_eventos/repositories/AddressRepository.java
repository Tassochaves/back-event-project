package com.dev.api_eventos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.api_eventos.domain.address.Address;

public interface AddressRepository extends JpaRepository<Address, UUID>{

}
