package com.dev.api_eventos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.api_eventos.domain.address.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID>{

}
