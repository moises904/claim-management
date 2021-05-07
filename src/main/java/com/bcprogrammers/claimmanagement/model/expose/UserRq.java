package com.bcprogrammers.claimmanagement.model.expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRq {
    private Integer documentType;
    private String documentNumber;
    private String phoneNumber;
    private String emailAddress;

}
