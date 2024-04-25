package com.ikram.banking.dto;


import com.ikram.banking.com.models.Contact;
import com.ikram.banking.com.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ContactDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String iban;
    private Integer idUser;

    public static ContactDto fromEntity(Contact contact) {
        return ContactDto.builder()
                .firstname(contact.getFirstname())
                .id(contact.getId())
                .lastname(contact.getLastname())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .idUser(contact.getUsers().getId()).
                build();
    }

    public static Contact toEntity(ContactDto contactDto) {
        return Contact.builder()
                .firstname(contactDto.firstname)
                .lastname(contactDto.lastname)
                .email(contactDto.email)
                .iban(contactDto.iban)
                .users(User.builder()
                        .id(contactDto.getIdUser())
                        .build()
                )
                .build();
    }

}
