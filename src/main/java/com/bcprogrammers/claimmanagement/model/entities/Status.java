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
@Table(name = "STATUS")
@NoArgsConstructor
@AllArgsConstructor

public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "STATUS_ID")
    private Long statusId;

    @JoinColumn(name = "COMMENT")
    private String comment;

    @JoinColumn(name = "STATUS")
    private String phoneNumber;

    @JoinColumn(name = "LAST_UPDATED_DATE")
    private LocalDateTime lastUpdatedDate;

    @JoinColumn(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @ManyToOne
    @JoinColumn(name = "CLAIM_ID")
    private Claim claim;
}
