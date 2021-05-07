package com.bcprogrammers.claimmanagement.model.expose;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClaimSaveRs {
    private String description;
    private Long code;
}
