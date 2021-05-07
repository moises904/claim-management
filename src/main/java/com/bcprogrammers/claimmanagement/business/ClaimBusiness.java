package com.bcprogrammers.claimmanagement.business;

import com.bcprogrammers.claimmanagement.model.expose.ClaimRs;
import com.bcprogrammers.claimmanagement.model.expose.ClaimSaveRq;
import com.bcprogrammers.claimmanagement.model.expose.ClaimSaveRs;
import io.reactivex.Maybe;
import io.reactivex.Observable;


public interface ClaimBusiness {

    Maybe<ClaimSaveRs> saveClaim(ClaimSaveRq request);

    Observable<ClaimRs> list(Integer documentType, String documentNumber);

}
