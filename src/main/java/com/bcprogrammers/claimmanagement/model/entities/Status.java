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
    @Column(name = "STATUS_ID")
    private Long statusId;

    @Column(name = "CLAIM_ID")
    private Long documentType;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "STATUS")
    private String phoneNumber;

    @Column(name = "LAST_UPDATED_DATE")
    private LocalDateTime lastUpdatedDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;
}
