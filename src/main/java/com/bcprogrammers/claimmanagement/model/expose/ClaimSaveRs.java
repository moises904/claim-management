package com.bcprogrammers.claimmanagement.model.expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClaimSaveRs {
    private String description;
    private Integer claimType;
}
