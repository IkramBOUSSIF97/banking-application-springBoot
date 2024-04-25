package com.ikram.banking.services.impl;

import com.ikram.banking.dto.AddressDto;
import com.ikram.banking.repositories.AddressRepository;
import com.ikram.banking.services.AddressService;
import com.ikram.banking.validators.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final ObjectValidator validator;

    @Override
    public Integer save(AddressDto dto) {

        return null;
    }

    @Override
    public List<AddressDto> findAll() {
        return null;
    }

    @Override
    public AddressDto findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
