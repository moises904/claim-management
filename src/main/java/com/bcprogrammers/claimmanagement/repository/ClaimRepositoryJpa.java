package com.bcprogrammers.claimmanagement.repository;

import com.bcprogrammers.claimmanagement.model.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClaimRepositoryJpa extends JpaRepository<Claim, Integer> {

    @Query("select c from Claim c "
            + " join c.user u"
            + " where "
            + " u.documentType = :documentType and u.documentNumber = :documentNumber "
            + " order by c.createDate desc")
    List<Claim> findClaimsByUser(@Param("documentType") Integer documentType, @Param("documentNumber") String documentNumber);


}
