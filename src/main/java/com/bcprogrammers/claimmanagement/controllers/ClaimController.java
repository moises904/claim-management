package com.bcprogrammers.claimmanagement.controllers;


import com.bcprogrammers.claimmanagement.business.ClaimBusiness;
import com.bcprogrammers.claimmanagement.model.expose.ClaimSaveRq;
import com.bcprogrammers.claimmanagement.model.expose.ClaimSaveRs;
import io.reactivex.Maybe;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("claim")
public class ClaimController {

    private final ClaimBusiness claimBusiness;

    @PostMapping
    public Maybe<ClaimSaveRs> save(@RequestBody ClaimSaveRq save) {
        return claimBusiness.saveClaim(save);
    }


}
