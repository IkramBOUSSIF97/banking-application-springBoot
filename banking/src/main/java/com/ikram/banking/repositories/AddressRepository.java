package com.ikram.banking.repositories;

import com.ikram.banking.dto.AddressDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressDto,Integer> {
}
