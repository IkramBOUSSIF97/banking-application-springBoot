package com.ikram.banking.dto;

import com.ikram.banking.com.models.User;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.internal.CoreLogging;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id;

    @NotNull(message = "Le prenom ne doit pas etre null")
    @NotEmpty(message = "Le prenom ne doit pas etre null")
    @NotBlank(message = "Le prenom ne doit pas etre null")
    private String firstname;

    @NonNull
    @NotEmpty
    @NotBlank
    private String lastname;

    @NonNull
    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @NonNull
    @NotEmpty
    @NotBlank
    @Size(min=8, max=16)
    private String password;

    @Past
    private LocalDateTime birthdate;

    public static UserDto fromEntity(User user) {
        // null check
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static User toEntity(UserDto userDto) {
        // null check
        return User.builder()
                .firstname(userDto.getFirstname())
                .lastname((userDto.getLastname()))
                .email((userDto.getEmail()))
                .password(userDto.getPassword())
                .build();
    }
}
