package com.bcprogrammers.claimmanagement.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "CLAIM")
@NoArgsConstructor
@AllArgsConstructor
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLAIM_ID")
    private Long claimId;

    @ManyToOne
    @Column(name = "USER_ID")
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CLAIM_TYPE")
    private Integer claimType;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "LAST_UPDATED_DATE")
    private LocalDateTime lastUpdatedDate;

    @Column(name = "EXPECTED_DATE_ATTENTION")
    private LocalDateTime expectedDateAttention;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;
}
