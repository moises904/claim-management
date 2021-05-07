package com.bcprogrammers.claimmanagement.controllers;


import com.bcprogrammers.claimmanagement.business.ClaimBusiness;
import com.bcprogrammers.claimmanagement.model.expose.ClaimRs;
import com.bcprogrammers.claimmanagement.model.expose.ClaimSaveRq;
import com.bcprogrammers.claimmanagement.model.expose.ClaimSaveRs;
import io.reactivex.Maybe;
import io.reactivex.Observable;
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

    @GetMapping
    public Observable<ClaimRs>
    get(@RequestParam("documentType") Integer documentType, @RequestParam("documentNumber") String documentNumber) {
        return claimBusiness.list(documentType, documentNumber);
    }


}
