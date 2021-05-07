package com.bcprogrammers.claimmanagement.repository;

import com.bcprogrammers.claimmanagement.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryJpa extends JpaRepository<User, Integer> {

    Optional<User> findByDocumentTypeAndDocumentNumber(Integer docType,
                                                       String docNumber);

}
