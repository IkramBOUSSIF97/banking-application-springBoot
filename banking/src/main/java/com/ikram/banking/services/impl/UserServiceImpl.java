package com.ikram.banking.services.impl;

import com.ikram.banking.com.models.User;
import com.ikram.banking.dto.UserDto;
import com.ikram.banking.repositories.UserRepository;
import com.ikram.banking.services.UserService;
import com.ikram.banking.validators.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;  // used for communicate with database
    private final ObjectValidator<UserDto> validator;  // used for validate l'objet
    @Override
    public Integer save(UserDto dto) {
        validator.validate(dto);      // validate l object
        User user = UserDto.toEntity(dto); // tranfert l objet to an entity
        User savedUser = repository.save(user);
        return savedUser.getId();
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll()
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return repository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No user was found with the provided ID"));
    }

    @Override
    public void delete(Integer id) {
        // todo check before delete
         repository.deleteById(id);
    }
}
