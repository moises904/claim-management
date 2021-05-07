package com.bcprogrammers.claimmanagement.business;

import com.bcprogrammers.claimmanagement.model.expose.ClaimSaveRq;
import com.bcprogrammers.claimmanagement.model.expose.ClaimSaveRs;
import io.reactivex.Maybe;


public interface ClaimBusiness {

    Maybe<ClaimSaveRs> saveClaim(ClaimSaveRq request);

}
