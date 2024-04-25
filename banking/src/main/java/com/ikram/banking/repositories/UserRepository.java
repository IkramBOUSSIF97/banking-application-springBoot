package com.ikram.banking.repositories;

import com.ikram.banking.com.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    // select * from _user where firstname= 'ikram'
    List<User> findAllByFirstname(String firstname);

    // select * from _user where firstname like '%Ikram%'
    List<User> findAllByFirstnameContaining(String firstname);

    // select * from _user where firstname ilike 'ikram'
    List<User> findAllByFirstnameContainingIgnoreCase(String firstname);

    // select * from _user u inner join account a on u.id = a.id_user and a.iban = 'DE1236985'
    List<User> findAllByAccountIban(String iban);

    // select * from _user where firstname = '%ikram%' and email = 'ikram.ben@gmail.com'
   User findByFirstnameContainingIgnoreCaseAndEmail(String firstname,String email);

   // @Query avec JPQL :
     /* @Query("from User where firstname = :firstname")
    List<User> searchByFirstname(String firstname); */
    /// ou bien
    @Query("from User where firstname = :fn")
    List<User> searchByFirstname(@Param("fn") String firstname);

    @Query("from User where firstname = '%:firstname%'")
    List<User> searchByFirstnameContaining(String firstname);

    @Query("from User u inner join Account a on u.id = a.users.id where a.iban = :iban")
    List<User> searchByIban(String iban);

    @Query(value = "select * from _user u inner join account a on u.id = a.id_user and a.iban = :iban", nativeQuery = true)
    List<User> searchByIbanNative(String iban);



}
