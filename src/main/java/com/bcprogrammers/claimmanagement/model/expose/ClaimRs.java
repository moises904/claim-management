package com.bcprogrammers.claimmanagement.model.expose;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClaimRs {
    private Integer claimId;
    private LocalDate createDate;
    private LocalDate expectedDateAttention;
    private String status;
    private String comment;
}
