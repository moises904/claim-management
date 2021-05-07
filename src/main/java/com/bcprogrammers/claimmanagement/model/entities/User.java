package com.bcprogrammers.claimmanagement.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "USERM")
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "DOCUMENT_TYPE")
    private Integer documentType;

    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
}
