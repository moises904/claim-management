package com.bcprogrammers.claimmanagement.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "CLAIM")
@NoArgsConstructor
@AllArgsConstructor
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "CLAIM_ID")
    private Long claimId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @JoinColumn(name = "DESCRIPTION")
    private String description;

    @JoinColumn(name = "CLAIM_TYPE")
    private Integer claimType;

    @JoinColumn(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @JoinColumn(name = "LAST_UPDATED_DATE")
    private LocalDateTime lastUpdatedDate;

    @JoinColumn(name = "EXPECTED_DATE_ATTENTION")
    private LocalDateTime expectedDateAttention;

    @JoinColumn(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @OneToMany(mappedBy = "claim", cascade = CascadeType.MERGE)
    private List<Status> status = new ArrayList<Status>();
}
