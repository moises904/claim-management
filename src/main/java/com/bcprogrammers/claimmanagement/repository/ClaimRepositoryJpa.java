package com.bcprogrammers.claimmanagement.repository;

import com.bcprogrammers.claimmanagement.model.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepositoryJpa extends JpaRepository<Claim, Integer> {



}
